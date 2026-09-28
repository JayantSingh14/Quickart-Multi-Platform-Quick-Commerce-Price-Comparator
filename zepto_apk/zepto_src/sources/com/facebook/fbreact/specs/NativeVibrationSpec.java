package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import javax.annotation.Nonnull;

/* loaded from: classes.dex */
public abstract class NativeVibrationSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Vibration";

    public NativeVibrationSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void cancel();

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "Vibration";
    }

    @DoNotStrip
    @ReactMethod
    public abstract void vibrate(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void vibrateByPattern(ReadableArray readableArray, double d2);
}
