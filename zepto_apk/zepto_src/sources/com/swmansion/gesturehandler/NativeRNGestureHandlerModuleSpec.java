package com.swmansion.gesturehandler;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReactModuleWithSpec;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes.dex */
public abstract class NativeRNGestureHandlerModuleSpec extends ReactContextBaseJavaModule implements ReactModuleWithSpec, TurboModule {
    public static final String NAME = "RNGestureHandlerModule";

    public NativeRNGestureHandlerModuleSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void attachGestureHandler(double d2, double d3, double d4);

    @DoNotStrip
    @ReactMethod
    public abstract void createGestureHandler(String str, double d2, ReadableMap readableMap);

    @DoNotStrip
    @ReactMethod
    public abstract void dropGestureHandler(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void flushOperations();

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "RNGestureHandlerModule";
    }

    @DoNotStrip
    @ReactMethod
    public abstract void handleClearJSResponder();

    @DoNotStrip
    @ReactMethod
    public abstract void handleSetJSResponder(double d2, boolean z);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public abstract boolean install();

    @DoNotStrip
    @ReactMethod
    public abstract void updateGestureHandler(double d2, ReadableMap readableMap);
}
