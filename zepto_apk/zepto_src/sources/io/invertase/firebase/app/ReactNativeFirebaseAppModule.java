package io.invertase.firebase.app;

import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.a;
import androidx.media3.common.util.c;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseAppLifecycleListener;
import com.google.firebase.FirebaseOptions;
import io.invertase.firebase.common.RCTConvertFirebase;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseJSON;
import io.invertase.firebase.common.ReactNativeFirebaseMeta;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import io.invertase.firebase.common.ReactNativeFirebasePreferences;
import io.invertase.firebase.common.SharedUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes.dex */
public class ReactNativeFirebaseAppModule extends ReactNativeFirebaseModule {
    private static final String TAG = "App";
    public static Map<String, String> authDomains = new HashMap();

    public ReactNativeFirebaseAppModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
    }

    public static void configureAuthDomain(String str, String str2) {
        if (str2 == null) {
            authDomains.remove(str);
            return;
        }
        Log.d(TAG, str + " custom authDomain " + str2);
        authDomains.put(str, str2);
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @ReactMethod
    public void deleteApp(String str, Promise promise) {
        FirebaseApp firebaseAppE = FirebaseApp.e(str);
        if (firebaseAppE.f43494f.compareAndSet(false, true)) {
            synchronized (FirebaseApp.f43487k) {
                FirebaseApp.f43488l.remove(firebaseAppE.f43490b);
            }
            Iterator it = firebaseAppE.f43498j.iterator();
            while (it.hasNext()) {
                ((FirebaseAppLifecycleListener) it.next()).a();
            }
        }
        promise.resolve(null);
    }

    @ReactMethod
    public void eventsAddListener(String str) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        synchronized (reactNativeFirebaseEventEmitter.f49233c) {
            try {
                reactNativeFirebaseEventEmitter.f49236f++;
                if (reactNativeFirebaseEventEmitter.f49233c.containsKey(str)) {
                    reactNativeFirebaseEventEmitter.f49233c.put(str, Integer.valueOf(((Integer) reactNativeFirebaseEventEmitter.f49233c.get(str)).intValue() + 1));
                } else {
                    reactNativeFirebaseEventEmitter.f49233c.put(str, 1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        reactNativeFirebaseEventEmitter.f49232b.post(new a(reactNativeFirebaseEventEmitter, 10));
    }

    @ReactMethod
    public void eventsGetListeners(Promise promise) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        reactNativeFirebaseEventEmitter.getClass();
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap.putInt("listeners", reactNativeFirebaseEventEmitter.f49236f);
        writableMapCreateMap.putInt("queued", reactNativeFirebaseEventEmitter.f49231a.size());
        synchronized (reactNativeFirebaseEventEmitter.f49233c) {
            try {
                for (Map.Entry entry : reactNativeFirebaseEventEmitter.f49233c.entrySet()) {
                    writableMapCreateMap2.putInt((String) entry.getKey(), ((Integer) entry.getValue()).intValue());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        writableMapCreateMap.putMap("events", writableMapCreateMap2);
        promise.resolve(writableMapCreateMap);
    }

    @ReactMethod
    public void eventsNotifyReady(Boolean bool) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        reactNativeFirebaseEventEmitter.f49232b.post(new c(3, reactNativeFirebaseEventEmitter, bool));
    }

    @ReactMethod
    public void eventsPing(String str, ReadableMap readableMap, Promise promise) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.merge(readableMap);
        reactNativeFirebaseEventEmitter.b(new ReactNativeFirebaseEvent(str, writableMapCreateMap));
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        writableMapCreateMap2.merge(readableMap);
        promise.resolve(writableMapCreateMap2);
    }

    @ReactMethod
    public void eventsRemoveListener(String str, Boolean bool) {
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        synchronized (reactNativeFirebaseEventEmitter.f49233c) {
            try {
                if (reactNativeFirebaseEventEmitter.f49233c.containsKey(str)) {
                    int iIntValue = ((Integer) reactNativeFirebaseEventEmitter.f49233c.get(str)).intValue();
                    if (iIntValue <= 1 || bool.booleanValue()) {
                        reactNativeFirebaseEventEmitter.f49233c.remove(str);
                    } else {
                        reactNativeFirebaseEventEmitter.f49233c.put(str, Integer.valueOf(iIntValue - 1));
                    }
                    int i2 = reactNativeFirebaseEventEmitter.f49236f;
                    if (!bool.booleanValue()) {
                        iIntValue = 1;
                    }
                    reactNativeFirebaseEventEmitter.f49236f = i2 - iIntValue;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        ArrayList arrayList;
        HashMap map = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        getReactApplicationContext();
        synchronized (FirebaseApp.f43487k) {
            arrayList = new ArrayList(FirebaseApp.f43488l.values());
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(RCTConvertFirebase.a((FirebaseApp) it.next()));
        }
        map.put("NATIVE_FIREBASE_APPS", arrayList2);
        ReactNativeFirebaseJSON.f49237b.getClass();
        map.put("FIREBASE_RAW_JSON", "{\"crashlytics_debug_enabled\":true,\"crashlytics_disable_auto_disabler\":true,\"crashlytics_auto_collection_enabled\":true,\"crashlytics_is_error_generation_on_js_crash_enabled\":true,\"crashlytics_javascript_exception_handler_chaining_enabled\":true,\"perf_auto_collection_enabled\":true}");
        return map;
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        super.initialize();
        ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter = ReactNativeFirebaseEventEmitter.f49230g;
        reactNativeFirebaseEventEmitter.f49232b.post(new c(4, reactNativeFirebaseEventEmitter, getContext()));
    }

    @ReactMethod
    public void initializeApp(ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        ReactContext context = getContext();
        FirebaseOptions.Builder builder = new FirebaseOptions.Builder();
        String string = readableMap2.getString(CLConstants.FIELD_PAY_INFO_NAME);
        builder.b(readableMap.getString("apiKey"));
        builder.c(readableMap.getString(CLConstants.SALT_FIELD_APP_ID));
        builder.g(readableMap.getString("projectId"));
        builder.d(readableMap.getString("databaseURL"));
        if (readableMap.hasKey("gaTrackingId")) {
            builder.e(readableMap.getString("gaTrackingId"));
        }
        builder.h(readableMap.getString("storageBucket"));
        builder.f(readableMap.getString("messagingSenderId"));
        FirebaseApp firebaseAppI = string.equals("[DEFAULT]") ? FirebaseApp.i(context, builder.a(), "[DEFAULT]") : FirebaseApp.i(context, builder.a(), string);
        if (readableMap2.hasKey("automaticDataCollectionEnabled")) {
            firebaseAppI.l(Boolean.valueOf(readableMap2.getBoolean("automaticDataCollectionEnabled")));
        }
        if (readableMap2.hasKey("automaticResourceManagement")) {
            boolean z = readableMap2.getBoolean("automaticResourceManagement");
            firebaseAppI.a();
            if (firebaseAppI.f43493e.compareAndSet(!z, z)) {
                boolean zIsInBackground = BackgroundDetector.getInstance().isInBackground();
                if (z && zIsInBackground) {
                    firebaseAppI.k(true);
                } else if (!z && zIsInBackground) {
                    firebaseAppI.k(false);
                }
            }
        }
        configureAuthDomain(readableMap2.getString(CLConstants.FIELD_PAY_INFO_NAME), readableMap.getString("authDomain"));
        promise.resolve(Arguments.makeNativeMap(RCTConvertFirebase.a(firebaseAppI)));
    }

    @ReactMethod
    public void jsonGetAll(Promise promise) throws JSONException {
        ReactNativeFirebaseJSON reactNativeFirebaseJSON = ReactNativeFirebaseJSON.f49237b;
        reactNativeFirebaseJSON.getClass();
        WritableMap writableMapCreateMap = Arguments.createMap();
        JSONObject jSONObject = reactNativeFirebaseJSON.f49238a;
        JSONArray jSONArrayNames = jSONObject.names();
        for (int i2 = 0; i2 < jSONArrayNames.length(); i2++) {
            try {
                String string = jSONArrayNames.getString(i2);
                SharedUtils.e(writableMapCreateMap, string, jSONObject.get(string));
            } catch (JSONException unused) {
            }
        }
        promise.resolve(writableMapCreateMap);
    }

    @ReactMethod
    public void metaGetAll(Promise promise) {
        ReactNativeFirebaseMeta.f49239a.getClass();
        Bundle bundleB = ReactNativeFirebaseMeta.b();
        WritableMap writableMapCreateMap = Arguments.createMap();
        if (bundleB != null) {
            for (String str : bundleB.keySet()) {
                if (str.startsWith("rnfirebase_")) {
                    Object obj = bundleB.get(str);
                    if (obj == null) {
                        writableMapCreateMap.putNull(str);
                    } else if (obj instanceof String) {
                        writableMapCreateMap.putString(str, (String) obj);
                    } else if (obj instanceof Boolean) {
                        writableMapCreateMap.putBoolean(str, ((Boolean) obj).booleanValue());
                    }
                }
            }
        }
        promise.resolve(writableMapCreateMap);
    }

    @ReactMethod
    public void preferencesClearAll(Promise promise) {
        ReactNativeFirebasePreferences.f49240b.a().edit().clear().apply();
        promise.resolve(null);
    }

    @ReactMethod
    public void preferencesGetAll(Promise promise) {
        ReactNativeFirebasePreferences reactNativeFirebasePreferences = ReactNativeFirebasePreferences.f49240b;
        reactNativeFirebasePreferences.getClass();
        WritableMap writableMapCreateMap = Arguments.createMap();
        for (Map.Entry<String, ?> entry : reactNativeFirebasePreferences.a().getAll().entrySet()) {
            SharedUtils.e(writableMapCreateMap, entry.getKey(), entry.getValue());
        }
        promise.resolve(writableMapCreateMap);
    }

    @ReactMethod
    public void preferencesSetBool(String str, boolean z, Promise promise) {
        ReactNativeFirebasePreferences.f49240b.a().edit().putBoolean(str, z).apply();
        promise.resolve(null);
    }

    @ReactMethod
    public void preferencesSetString(String str, String str2, Promise promise) {
        ReactNativeFirebasePreferences.f49240b.a().edit().putString(str, str2).apply();
        promise.resolve(null);
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void setAutomaticDataCollectionEnabled(String str, Boolean bool) {
        FirebaseApp.e(str).l(bool);
    }
}
