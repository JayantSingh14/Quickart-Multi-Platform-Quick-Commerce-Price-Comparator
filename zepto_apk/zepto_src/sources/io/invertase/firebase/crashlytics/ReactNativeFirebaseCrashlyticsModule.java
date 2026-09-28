package io.invertase.firebase.crashlytics;

import android.os.Handler;
import android.util.Log;
import coil3.util.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.sudoplz.rninappupdates.b;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReactNativeFirebaseCrashlyticsModule extends ReactNativeFirebaseModule {
    private static final String TAG = "Crashlytics";

    public ReactNativeFirebaseCrashlyticsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$checkForUnsentReports$0(Promise promise, Task task) {
        if (!task.p()) {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, zzck.UNKNOWN_CONTENT_TYPE, task.k() != null ? task.k().getMessage() : "checkForUnsentReports() request error");
        } else if (task.l() != null) {
            promise.resolve(task.l());
        } else {
            ReactNativeFirebaseModule.rejectPromiseWithCodeAndMessage(promise, zzck.UNKNOWN_CONTENT_TYPE, "Unknown result of check for unsent reports");
        }
    }

    private Exception recordJavaScriptError(ReadableMap readableMap) {
        String string = readableMap.getString(APayConstants.Error.MESSAGE);
        ReadableArray array = readableMap.getArray("frames");
        Objects.requireNonNull(array);
        Exception unhandledPromiseRejection = readableMap.getBoolean("isUnhandledRejection") ? new UnhandledPromiseRejection(string) : new JavaScriptError(string);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[array.size()];
        for (int i2 = 0; i2 < array.size(); i2++) {
            ReadableMap map = array.getMap(i2);
            Objects.requireNonNull(map);
            stackTraceElementArr[i2] = new StackTraceElement("", map.getString("fn"), map.getString(UtilsKt.SCHEME_FILE), -1);
        }
        unhandledPromiseRejection.setStackTrace(stackTraceElementArr);
        FirebaseCrashlytics.getInstance().recordException(unhandledPromiseRejection);
        return unhandledPromiseRejection;
    }

    @ReactMethod
    public void checkForUnsentReports(Promise promise) {
        FirebaseCrashlytics.getInstance().checkForUnsentReports().addOnCompleteListener(new b(11, promise));
    }

    @ReactMethod
    public void crash() {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            new Handler().postDelayed(new Runnable() { // from class: io.invertase.firebase.crashlytics.ReactNativeFirebaseCrashlyticsModule.1
                @Override // java.lang.Runnable
                public final void run() {
                    throw new RuntimeException("Crash Test");
                }
            }, 50L);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
    }

    @ReactMethod
    public void crashWithStackPromise(ReadableMap readableMap, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            recordJavaScriptError(readableMap).printStackTrace(System.err);
            Log.e(TAG, "Crash logged. Terminating app.");
            System.exit(0);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void deleteUnsentReports() {
        FirebaseCrashlytics.getInstance().deleteUnsentReports();
    }

    @ReactMethod
    public void didCrashOnPreviousExecution(Promise promise) {
        promise.resolve(Boolean.valueOf(FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()));
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        boolean zA;
        boolean zA2;
        HashMap map = new HashMap();
        map.put("isCrashlyticsCollectionEnabled", Boolean.valueOf(ReactNativeFirebaseCrashlyticsInitProvider.a()));
        ReactNativeFirebaseJSON reactNativeFirebaseJSON = ReactNativeFirebaseJSON.f49237b;
        ReactNativeFirebaseMeta reactNativeFirebaseMeta = ReactNativeFirebaseMeta.f49239a;
        ReactNativeFirebasePreferences reactNativeFirebasePreferences = ReactNativeFirebasePreferences.f49240b;
        if (reactNativeFirebasePreferences.a().contains("crashlytics_is_error_generation_on_js_crash_enabled")) {
            zA = reactNativeFirebasePreferences.a().getBoolean("crashlytics_is_error_generation_on_js_crash_enabled", true);
            Log.d("RNFBCrashlyticsInit", "isErrorGenerationOnJSCrashEnabled via RNFBPreferences: " + zA);
        } else {
            JSONObject jSONObject = reactNativeFirebaseJSON.f49238a;
            if (jSONObject == null ? false : jSONObject.has("crashlytics_is_error_generation_on_js_crash_enabled")) {
                JSONObject jSONObject2 = reactNativeFirebaseJSON.f49238a;
                zA = jSONObject2 == null ? true : jSONObject2.optBoolean("crashlytics_is_error_generation_on_js_crash_enabled", true);
                Log.d("RNFBCrashlyticsInit", "isErrorGenerationOnJSCrashEnabled via RNFBJSON: " + zA);
            } else {
                reactNativeFirebaseMeta.getClass();
                zA = ReactNativeFirebaseMeta.a("crashlytics_is_error_generation_on_js_crash_enabled");
                Log.d("RNFBCrashlyticsInit", "isErrorGenerationOnJSCrashEnabled via RNFBMeta: " + zA);
            }
        }
        Log.d("RNFBCrashlyticsInit", "isErrorGenerationOnJSCrashEnabled final value: " + zA);
        map.put("isErrorGenerationOnJSCrashEnabled", Boolean.valueOf(zA));
        if (reactNativeFirebasePreferences.a().contains("crashlytics_javascript_exception_handler_chaining_enabled")) {
            zA2 = reactNativeFirebasePreferences.a().getBoolean("crashlytics_javascript_exception_handler_chaining_enabled", true);
            Log.d("RNFBCrashlyticsInit", "isCrashlyticsJavascriptExceptionHandlerChainingEnabled via RNFBPreferences: " + zA2);
        } else {
            JSONObject jSONObject3 = reactNativeFirebaseJSON.f49238a;
            if (jSONObject3 != null ? jSONObject3.has("crashlytics_javascript_exception_handler_chaining_enabled") : false) {
                JSONObject jSONObject4 = reactNativeFirebaseJSON.f49238a;
                boolean zOptBoolean = jSONObject4 != null ? jSONObject4.optBoolean("crashlytics_javascript_exception_handler_chaining_enabled", true) : true;
                Log.d("RNFBCrashlyticsInit", "isCrashlyticsJavascriptExceptionHandlerChainingEnabled via RNFBJSON: " + zOptBoolean);
                zA2 = zOptBoolean;
            } else {
                reactNativeFirebaseMeta.getClass();
                zA2 = ReactNativeFirebaseMeta.a("crashlytics_javascript_exception_handler_chaining_enabled");
                Log.d("RNFBCrashlyticsInit", "isCrashlyticsJavascriptExceptionHandlerChainingEnabled via RNFBMeta: " + zA2);
            }
        }
        Log.d("RNFBCrashlyticsInit", "isCrashlyticsJavascriptExceptionHandlerChainingEnabled final value: " + zA2);
        map.put("isCrashlyticsJavascriptExceptionHandlerChainingEnabled", Boolean.valueOf(zA2));
        return map;
    }

    @ReactMethod
    public void log(String str) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            FirebaseCrashlytics.getInstance().log(str);
        }
    }

    @ReactMethod
    public void logPromise(String str, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            FirebaseCrashlytics.getInstance().log(str);
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void recordError(ReadableMap readableMap) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            recordJavaScriptError(readableMap);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
    }

    @ReactMethod
    public void recordErrorPromise(ReadableMap readableMap, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            recordJavaScriptError(readableMap);
        } else {
            Log.i(TAG, "crashlytics collection is not enabled, not crashing.");
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void sendUnsentReports() {
        FirebaseCrashlytics.getInstance().sendUnsentReports();
    }

    @ReactMethod
    public void setAttribute(String str, String str2, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void setAttributes(ReadableMap readableMap, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = readableMap.keySetIterator();
            FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                firebaseCrashlytics.setCustomKey(strNextKey, readableMap.getString(strNextKey));
            }
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void setCrashlyticsCollectionEnabled(Boolean bool, Promise promise) {
        ReactNativeFirebasePreferences reactNativeFirebasePreferences = ReactNativeFirebasePreferences.f49240b;
        reactNativeFirebasePreferences.a().edit().putBoolean("crashlytics_auto_collection_enabled", bool.booleanValue()).apply();
        promise.resolve(null);
    }

    @ReactMethod
    public void setUserId(String str, Promise promise) {
        if (ReactNativeFirebaseCrashlyticsInitProvider.a()) {
            FirebaseCrashlytics.getInstance().setUserId(str);
        }
        promise.resolve(null);
    }
}
