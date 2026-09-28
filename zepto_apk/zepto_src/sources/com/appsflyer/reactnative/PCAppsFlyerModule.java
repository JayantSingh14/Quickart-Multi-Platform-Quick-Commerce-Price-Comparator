package com.appsflyer.reactnative;

import android.util.Log;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes.dex */
public class PCAppsFlyerModule extends ReactContextBaseJavaModule {
    public PCAppsFlyerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Log.d("AppsFlyer", "PurchaseConnector inclusion status: false");
    }

    @ReactMethod
    public void addListener(String str) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "PCAppsFlyer";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }
}
