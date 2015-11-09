package com.quantimodo.tools.activities;

import android.accounts.AccountManager;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.AccountPicker;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.Scopes;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;
import com.quantimodo.tools.QTools;
import com.quantimodo.tools.R;
import com.quantimodo.tools.ToolsPrefs;
import com.quantimodo.tools.sdk.AuthHelper;
import com.quantimodo.tools.utils.GetUsernameTask;

import java.util.Arrays;

import javax.inject.Inject;

/**
 * Activity used to log in the user using either the google account or facebook account
 */
public class QuantimodoLoginActivity extends Activity {
    private static final String TAG = QuantimodoLoginActivity.class.getSimpleName();
    public static final java.lang.String KEY_SHOW_LOGIN_AGAIN = "show_login_again";
//    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.profile";
//    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/plus.me " +
//        "https://www.googleapis.com/auth/plus.login " +
//        "https://www.googleapis.com/auth/plus.profile.emails.read";
    private static final String SCOPE = "oauth2:https://www.googleapis.com/auth/userinfo.email " +
        "https://www.googleapis.com/auth/userinfo.profile";
    private static final int REQUEST_CODE_PICK_ACCOUNT = 1000;
    private static final int REQUEST_CODE_RECOVER_FROM_AUTH_ERROR = 1;
    static final int REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR = 1001;

    @Inject
    ToolsPrefs mPrefs;

    @Inject
    AuthHelper authHelper;

    private CallbackManager callbackManager;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        QTools.getInstance().inject(this);
        setContentView(R.layout.qmt_login);
        View buttonGoogle = findViewById(R.id.qmt_signin_google);
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickUserAccount();
            }
        });
        View buttonMoodi = findViewById(R.id.qmt_signin_moodimodo);
        buttonMoodi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QuantimodoLoginActivity.this, QuantimodoWebAuthenticatorActivity.class);
                startActivity(intent);
            }
        });
        callbackManager = CallbackManager.Factory.create();
        Button loginButton = (Button) findViewById(R.id.qmt_signin_facebook);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginManager.getInstance().logInWithReadPermissions(QuantimodoLoginActivity.this, Arrays.asList("public_profile"));
            }
        });
        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                final String token = loginResult.getAccessToken().getToken();
                Log.d("QUantimodoLoginActivity", "Token: " + token);
                sendFbToken(token);
            }

            @Override
            public void onCancel() {
                Log.d("QUantimodoLoginActivity", "login fb cancel");
            }

            @Override
            public void onError(FacebookException error) {
                Log.d("QUantimodoLoginActivity", "login fb error");
                error.printStackTrace();
            }
        });
        if(AccessToken.getCurrentAccessToken() != null && !AccessToken.getCurrentAccessToken().isExpired()){
            Log.d("QuantimodoLoginActivity", "fb accesstoken: " + AccessToken.getCurrentAccessToken().getToken());
//            sendFbToken(AccessToken.getCurrentAccessToken().getToken());
        }

        if (getIntent().hasExtra(KEY_SHOW_LOGIN_AGAIN) && getIntent().getExtras().getBoolean(KEY_SHOW_LOGIN_AGAIN,false)) {
            Toast.makeText(this, R.string.oauth_refresh_failed, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_PICK_ACCOUNT) {
            if (resultCode == RESULT_OK) {
                mEmail = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                getAuthToken();
            } else if (resultCode == RESULT_CANCELED) {
                //Do nothing
            }
        } else if ((requestCode == REQUEST_CODE_RECOVER_FROM_AUTH_ERROR ||
                requestCode == REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR)
                && resultCode == RESULT_OK) {
            getAuthToken();
        }
    }

    private void pickUserAccount() {
        String[] accountTypes = new String[]{"com.google"};
        Intent intent = AccountPicker.newChooseAccountIntent(null, null,
                accountTypes, false, null, null, null, null);
        startActivityForResult(intent, REQUEST_CODE_PICK_ACCOUNT);
    }

    /**
     * Attempts to retrieve the username.
     * If the account is not yet known, invoke the picker. Once the account is known,
     * start an instance of the AsyncTask to get the auth token and do work with it.
     */
    private void getAuthToken() {
        if (mEmail == null) {
            pickUserAccount();
        } else {
            if (isDeviceOnline()) {
                new GetUsernameTask(QuantimodoLoginActivity.this, mEmail, SCOPE, mPrefs).execute();
            } else {
                Toast.makeText(this, "You must have internet connection to proceed", Toast.LENGTH_LONG).show();
            }
        }
    }

    private boolean isDeviceOnline(){
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    /**
     * This method is a hook for background threads and async tasks that need to
     * provide the user a response UI when an exception occurs.
     */
    public void handleException(final Exception e) {
        // Because this call comes from the AsyncTask, we must ensure that the following
        // code instead executes on the UI thread.
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (e instanceof GooglePlayServicesAvailabilityException) {
                    // The Google Play services APK is old, disabled, or not present.
                    // Show a dialog created by Google Play services that allows
                    // the user to update the APK
                    int statusCode = ((GooglePlayServicesAvailabilityException)e)
                            .getConnectionStatusCode();
                    Dialog dialog = GooglePlayServicesUtil.getErrorDialog(statusCode,
                            QuantimodoLoginActivity.this,
                            REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
                    dialog.show();
                } else if (e instanceof UserRecoverableAuthException) {
                    // Unable to authenticate, such as when the user has not yet granted
                    // the app access to the account, but the user can fix this.
                    // Forward the user to an activity in Google Play services.
                    Intent intent = ((UserRecoverableAuthException)e).getIntent();
                    startActivityForResult(intent,
                            REQUEST_CODE_RECOVER_FROM_PLAY_SERVICES_ERROR);
                }
            }
        });
    }

    private void sendFbToken(final String token){
        Log.d("QuantimodoLoginActivity", "Sending Fb token to QM server...");
        String url = mPrefs.getApiSocialAuth() + "?provider=facebook&accessToken=" + token;
        Ion.with(QuantimodoLoginActivity.this)
                .load(url)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject response) {
                        JsonObject result = response;
                        if (result != null)
                            setAuthTokenFromJson(result);
                        else {
                            Log.d("QuantimodoLoginActivity", "result is null!");
                        }
                    }
                });
    }
    public void setAuthTokenFromJson(final JsonObject result){
        if(result == null){
            Log.d(TAG, "Error when requesting token from QM Server: result json null!");
            return;
        }
        else if(!result.get("success").getAsBoolean()){
            Log.d(TAG, "Error when requesting token from QM Server: " + result.get("error").getAsString());
            return;
        }
        Log.d(TAG, "Result from QM Server as string: " + result.toString());
        try {
            String accessToken = result.get("access_token").getAsString();
            String refreshToken = result.get("refresh_token").getAsString();
            int expiresIn = result.get("expires_in").getAsInt();
            Log.d(TAG, "data from json, accessToken: " + accessToken + ", refreshToken: " + refreshToken + ", expiration: " + expiresIn);
            authHelper.setAuthToken(new AuthHelper.AuthToken(accessToken, refreshToken, System.currentTimeMillis() / 1000 + expiresIn));
        } catch(NullPointerException e){
            e.printStackTrace();
        }
    }
}
