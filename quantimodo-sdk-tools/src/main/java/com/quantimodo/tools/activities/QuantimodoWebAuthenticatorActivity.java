package com.quantimodo.tools.activities;

import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.*;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.facebook.appevents.AppEventsLogger;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.R;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.sdk.AuthHelper;

import javax.inject.Inject;
import java.util.Random;

/**
 * Activity for auth, used in pair with {@link AuthHelper AuthHelper},
 * which should be injected by {@link com.quantimodo.tools.QApplication QApplication}
 */
public class QuantimodoWebAuthenticatorActivity extends Activity
{
    public static final String KEY_AUTH_TOKEN = "key_auth_token";

    @Inject
    AuthHelper authHelper;

    @Inject
    ToolsPrefs mPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        QTools.getInstance().inject(this);

        setContentView(R.layout.qmt_authenticator_quantimodoweb);
        String QMToken = null;
        if(getIntent().hasExtra(KEY_AUTH_TOKEN)){
            QMToken = getIntent().getExtras().getString(KEY_AUTH_TOKEN);
        }

        initOAuthWebView(QMToken);
    }

    private void initOAuthWebView(final String QMToken) {
        WebView webView = (WebView) findViewById(R.id.web);
        webView.setWebViewClient(new OAuthClient(new OAuthClient.OnReceivedAuthorizeResponse() {
            @Override
            public void onSuccess(String authorizationCode, String state) {
                getAccessToken(authorizationCode, QMToken);
            }

            @Override
            public void onError(String error, String errorDescription) {

            }
        }, mPrefs));

        webView.loadUrl(mPrefs.getApiUrl() + "api/v2/oauth/authorize?token=" + QMToken
                + "&response_type=code&scope=" + mPrefs.getApiScopes() + "&client_id=" + authHelper.getClientId() +
        "&client_secret=" + authHelper.getClientSecret());
    }

    private void getAccessToken(String authorizationCode, final String QMToken) {
        Ion.with(this, mPrefs.getApiUrl() + "api/v2/oauth/access_token?token=" + QMToken)
                .setBodyParameter("client_id", authHelper.getClientId())
                .setBodyParameter("client_secret", authHelper.getClientSecret())
                .setBodyParameter("grant_type", "authorization_code")
                .setBodyParameter("code", authorizationCode)
                .asJsonObject()
                .withResponse().setCallback(new FutureCallback<Response<JsonObject>>() {
            @Override
            public void onCompleted(Exception e, Response<JsonObject> response) {
                JsonObject result = response.getResult();
                if (result != null) {
                    try {
                        String accessToken = result.get("access_token").getAsString();
                        String refreshToken = result.get("refresh_token").getAsString();
                        int expiresIn = result.get("expires_in").getAsInt();

                        authHelper.setAuthToken(new AuthHelper.AuthToken(accessToken,refreshToken, System.currentTimeMillis()/1000 + expiresIn));

                        //TODO: remove/update the tests related with this Activity
                        //TODO: also finish QuantimodoLoginActivity when login was succeed
                        finish();
                    } catch (NullPointerException ignored) {
                        Log.i(ToolsPrefs.DEBUG_TAG,"Error getting access token: " + result.get("error").getAsString()
                                + ", " + result.get("error_description").getAsString());
                    }
                }
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        CookieManager.getInstance().removeAllCookie();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    private static class OAuthClient extends WebViewClient {
        private final OnReceivedAuthorizeResponse listener;
        private final ToolsPrefs mPrefs;

        protected interface OnReceivedAuthorizeResponse {
            void onSuccess(String authorizationCode, String state);
            void onError(String error, String errorDescription);
        }

        public OAuthClient(OnReceivedAuthorizeResponse listener, ToolsPrefs mPrefs) {
            this.listener = listener;
            this.mPrefs = mPrefs;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (!url.startsWith(mPrefs.getApiUrl())) {
                int startCode = url.indexOf("code=") + 5;
                int endCode = url.indexOf("&state=");

                if (startCode == 4)  // -1 + 5
                {
                    // Code and state not found, so we got an error
                    int startError = url.indexOf("error=") + 6;
                    int endError = url.indexOf("error_description=");

                    String error = url.substring(startError, endError);
                    String errorDescription = url.substring(endError + 6, url.length());
                    listener.onError(error, errorDescription);
                } else {
                    String code = url.substring(startCode, endCode);
                    String state = url.substring(endCode + 7, url.length());
                    listener.onSuccess(code, state);
                }

                return true;
            } else {
                view.loadUrl(url);
            }

            return true;
        }
    }
}
