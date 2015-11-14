QuantiModo-SDK-Android
======================

This is the software development kit for implementing enabling Android Applications to store or access user Quantified Self data in the QuantiModo database.

## Modules
The QuantiModo SDK for Android consists of two modules.  
### 1. SDK Module
The sdk module contains the model classes and API client for QuantiModo API web-service.
### 2. QuantiModo Tools
The qtools module is a set of components that make it easy to create application that will take full advantage of the QuantiModo platform. qtools handles:
- Auth and token management
- Data synchonization with the QuantiModo we service
- Network interaction using [RoboSpice](https://github.com/stephanenicolas/robospice) 

## Install
Library can be obtained from OSS Sonatype repository.

### SDK

Maven:
```
<dependency>
  <groupId>com.quantimodo.android</groupId>
  <artifactId>sdk</artifactId>
  <version>2.2.4</version>
  <type>aar</type>
</dependency>
```

Gradle:
```
compile 'com.quantimodo.android:sdk:2.2.4'
```

### Quantimodo-Tools

Maven:
```
<dependency>
  <groupId>com.quantimodo.android</groupId>
  <artifactId>sdk-tools</artifactId>
  <version>1.0</version>
  <type>aar</type>
</dependency>
```

Gradle:
```
compile 'com.quantimodo.android:sdk-tools:1.0'
```

### How to create a new Android project and build it using the QuantiModo SDK

Create regular Android project, and add SDK as [dependency](#sdk).

#### Configure

To use SDK you need to obtain [OAuth2 token](https://app.quantimo.do/api/docs/#oauth2-authentication).
After that you can get instance of QuantimodoApiV2

```
String token = "oauth_token";
QuantimodoApiV2 api = QuantimodoApiV2.getInstance(null);
SdkResponse<User> response = api.getUser(ctx,token);
```

#### Use

After configuration you can start using SDK.
All requests return [SdkResponse<T>](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/sdk/index.html?com/quantimodo/android/sdk/SdkResponse.html) , which contain all info about response. 
For example to submit measurement to QuantiModo service for variable "Overall Mood"

```
//Variable Category : Mood
//Variable : Overall Mood
//Unit : /5 ( from 1 to 5 )
//Source name : Sample application
MeasurementSet sets = new MeasurementSet("Overall Mood", null, "Mood", "/5", MeasurementSet.COMBINE_MEAN, "Sample application");

//Measurement with Overall Mood, with 5 out of 5 rating, that submitted right now
Measurement measurement = new Measurement(System.currentTimeMillis() / 1000, 5.0d);

//Adding measurement into set
sets.getMeasurements().add(measurement);

String token = "oauth_token";
QuantimodoApiV2 api = QuantimodoApiV2.getInstance(null);

SdkResponse<Integer> result = api.putMeasurements(ctx,token,sets);
if (result.isSuccessful() && ((Integer) 1).equals(result.getData())){
  Log.i("sample","sent");
}
```

For more info, please check [JavaDocs](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/sdk/).
Or you can find examples in [tests](https://github.com/QuantiModo/QuantiModo-SDK-Android/tree/develop/sdk/src/androidTest/).

## About Quantimodo-Tools



### How to create a new Android project and build it using the Quantimodo-Tools

Create regular Android project, and add QuantiModo tools as [dependency](#quantimodo-tools).

#### Configure

App uses DI to initialize components, there are several components that should be initialized in order to use tools:

- [Module](http://square.github.io/dagger/#using) that would provide dependencies
- ToolsPrefs , that contain info about endpoint ( base URL, application source, permissions )
- SpiceService, in order to configure caching
- SyncService , if data should be synced
- [QApplication](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/QApplication.html) interface, which would provide dependencies to other components

First you need to implement [QApplication](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/QApplication.html) interface,
or you can extend [QBaseApplication](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/QApplication.html).

To do that you need to create a Module, that would provide dependency injection, example can be found in [tests sources](https://github.com/QuantiModo/QuantiModo-SDK-Android/blob/master/quantimodo-sdk-tools/src/androidTest/java/com/quantimodo/tools/testhelpers/TestModule.java)

Configuration stored in ToolsPrefs class instance, which should be created
```
ToolsPrefs prefs = new ToolsPrefs("https://app.quantimo.do/","readmeasurements writemeasurements","QuantimodoTest");
```
Then you need to create AuthHelper component
```
mAuthHelper = new AuthHelper(applicationContext,prefs);
```

Please refer to [test sources](https://github.com/QuantiModo/QuantiModo-SDK-Android/blob/master/quantimodo-sdk-tools/src/androidTest/java/com/quantimodo/tools/testhelpers/), to see how configure application.

#### Use

Most useful components could be :

- [AuthHelper](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/sdk/AuthHelper.html), can provide and refresh access token
- [TrackingFragment](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/fragments/TrackingFragment.html), would help you to submit tokens, could be configurated to show/submit to one category or to any
- [FactorsFragment](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/fragments/FactorsFragment.html), shows positive or negative correlations for effect
- [ImportWebFragment](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/fragments/ImportWebFragment.html), helps create connections with 3rd-party services
- [SyncHelper](http://quantimodo.github.io/QuantiModo-SDK-Android/javadoc/qm-tools/index.html?com/quantimodo/tools/sync/SyncHelper.html), would help configure sync

**Using the SDK Authenticator:**
To use the authenticator you just to start `QuantimodoLoginActivity`, which provides signing in with Facebook, Google, and Quantimodo directly.
 
The Activity can take two optional parameters:

- `KEY_SHOW_LOGIN_AGAIN` (boolean): if true a toast will pop up right after the Activity starts saying: "You need to log in again"
- `KEY_APP_NAME` (string): is used to customize the Quantimodo log in button. 
If you provide it, the button text will be "Sign in with KEY_APP_NAME", if not, the text will just be: "Sign in".

Example:

```
Intent auth = new Intent(context, QuantimodoLoginActivity.class);
auth.putExtra(QuantimodoLoginActivity.KEY_APP_NAME, getString(R.string.app_name));
auth.putExtra(QuantimodoLoginActivity.KEY_SHOW_LOGIN_AGAIN, true);
startActivity(auth)
```

Of course authentication uses internet connection, so make sure to include `android.permission.INTERNET` on your AndroidManifest.xml file:

```
<!-- Add it as a child of <manifest> tag -->
<uses-permission android:name="android.permission.INTERNET" />
```

## Running tests

Connect device and run in project root

```
./gradlew cAT
```

## Gradle SDK Distribution
The SDK can be found in the [Sonatype Central Repository](https://oss.sonatype.org/#nexus-search;quick~quantimodo) for open-source software. 

[Guide To Publish An Aar To Maven Using Gradle](http://www.survivingwithandroid.com/2014/05/android-guide-to-publish-aar-to-maven-gradle.html)

## Instructions to Deploy and Release Updates to the QM-Android SDK
See http://central.sonatype.org/pages/ossrh-guide.html

## Working with the SDK itself
To work with the SDK you can add it manually as a folder inside your project. You have to do the following:

- Create libs/qm-sdk folder
- Create a file called .gitmodules on the root of your project and write the following code:

```
[submodule "libs/qm-sdk"]
	path = libs/qm-sdk
	url = git@github.com:QuantiModo/QuantiModo-SDK-Android.git
```

- Then execute the following commands on the terminal (at the root of the project):

```
git submodule init
git submodule sync
git submodule update
```
