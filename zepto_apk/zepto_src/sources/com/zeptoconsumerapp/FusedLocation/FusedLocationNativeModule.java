package com.zeptoconsumerapp.FusedLocation;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;

/* loaded from: classes.dex */
public class FusedLocationNativeModule extends ReactContextBaseJavaModule {
    public static final String TAG = "LocationNativeModule";
    public static WritableMap cachedLocationInfo;

    public FusedLocationNativeModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public static void setCachedLocation(WritableMap writableMap) {
        cachedLocationInfo = writableMap.copy();
    }

    @ReactMethod
    public void getCachedLocation(Promise promise) {
        try {
            promise.resolve(cachedLocationInfo);
            cachedLocationInfo = null;
        } catch (Exception unused) {
            promise.resolve(null);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return TAG;
    }
}
