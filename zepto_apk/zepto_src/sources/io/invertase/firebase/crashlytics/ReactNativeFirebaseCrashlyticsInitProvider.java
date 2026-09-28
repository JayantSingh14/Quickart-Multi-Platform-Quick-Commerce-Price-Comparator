package io.invertase.firebase.crashlytics;

import android.util.Log;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import io.invertase.firebase.common.ReactNativeFirebaseInitProvider;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ReactNativeFirebaseCrashlyticsInitProvider extends ReactNativeFirebaseInitProvider {
    public static boolean a() {
        boolean zA;
        ReactNativeFirebaseJSON reactNativeFirebaseJSON = ReactNativeFirebaseJSON.f49237b;
        ReactNativeFirebaseMeta reactNativeFirebaseMeta = ReactNativeFirebaseMeta.f49239a;
        ReactNativeFirebasePreferences reactNativeFirebasePreferences = ReactNativeFirebasePreferences.f49240b;
        if (reactNativeFirebasePreferences.a().contains("crashlytics_auto_collection_enabled")) {
            zA = reactNativeFirebasePreferences.a().getBoolean("crashlytics_auto_collection_enabled", true);
            Log.d("RNFBCrashlyticsInit", "isCrashlyticsCollectionEnabled via RNFBPreferences: " + zA);
        } else {
            JSONObject jSONObject = reactNativeFirebaseJSON.f49238a;
            if (jSONObject == null ? false : jSONObject.has("crashlytics_auto_collection_enabled")) {
                JSONObject jSONObject2 = reactNativeFirebaseJSON.f49238a;
                boolean zOptBoolean = jSONObject2 != null ? jSONObject2.optBoolean("crashlytics_auto_collection_enabled", true) : true;
                Log.d("RNFBCrashlyticsInit", "isCrashlyticsCollectionEnabled via RNFBJSON: " + zOptBoolean);
                zA = zOptBoolean;
            } else {
                reactNativeFirebaseMeta.getClass();
                zA = ReactNativeFirebaseMeta.a("crashlytics_auto_collection_enabled");
                Log.d("RNFBCrashlyticsInit", "isCrashlyticsCollectionEnabled via RNFBMeta: " + zA);
            }
        }
        Log.d("RNFBCrashlyticsInit", "isCrashlyticsCollectionEnabled final value: " + zA);
        return zA;
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseInitProvider, android.content.ContentProvider
    public final boolean onCreate() {
        super.onCreate();
        try {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(a());
            Log.i("RNFBCrashlyticsInit", "initialization successful");
            return true;
        } catch (Exception e2) {
            Log.e("RNFBCrashlyticsInit", "initialization failed", e2);
            return false;
        }
    }
}
