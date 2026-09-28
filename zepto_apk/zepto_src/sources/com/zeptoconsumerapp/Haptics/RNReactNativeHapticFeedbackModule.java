package com.zeptoconsumerapp.Haptics;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;

/* loaded from: classes.dex */
public class RNReactNativeHapticFeedbackModule extends ReactContextBaseJavaModule {
    ReactApplicationContext reactContext;

    public RNReactNativeHapticFeedbackModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNHapticFeedback";
    }

    @ReactMethod
    public void trigger(String str, ReadableMap readableMap) {
        RNReactNativeHapticFeedbackModuleImpl.a(this.reactContext, readableMap, str);
    }
}
