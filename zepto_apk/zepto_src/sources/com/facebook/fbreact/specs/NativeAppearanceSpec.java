package com.facebook.fbreact.specs;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.zeptoconsumerapp.BuildConfig;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class NativeAppearanceSpec extends ReactContextBaseJavaModule implements TurboModule {
    public static final String NAME = "Appearance";

    public NativeAppearanceSpec(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @DoNotStrip
    @ReactMethod
    public abstract void addListener(String str);

    @DoNotStrip
    @ReactMethod(isBlockingSynchronousMethod = BuildConfig.IS_HERMES_ENABLED)
    @Nullable
    public abstract String getColorScheme();

    @Override // com.facebook.react.bridge.NativeModule
    @Nonnull
    public String getName() {
        return "Appearance";
    }

    @DoNotStrip
    @ReactMethod
    public abstract void removeListeners(double d2);

    @DoNotStrip
    @ReactMethod
    public abstract void setColorScheme(String str);
}
