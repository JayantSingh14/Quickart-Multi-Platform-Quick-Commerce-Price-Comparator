package com.reactnativemmkv;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = MmkvModule.NAME)
/* loaded from: classes.dex */
public class MmkvModule extends ReactContextBaseJavaModule {
    public static final String NAME = "MMKV";

    public MmkvModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private static native void nativeInstall(long j2, String str);

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public boolean install(@Nullable String str) {
        try {
            Log.i(NAME, "Loading C++ library...");
            System.loadLibrary("reactnativemmkv");
            JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
            if (str == null) {
                str = getReactApplicationContext().getFilesDir().getAbsolutePath() + "/mmkv";
            }
            Log.i(NAME, "Installing MMKV JSI Bindings for MMKV root directory: " + str);
            nativeInstall(javaScriptContextHolder.get(), str);
            Log.i(NAME, "Successfully installed MMKV JSI Bindings!");
            return true;
        } catch (Exception e2) {
            Log.e(NAME, "Failed to install MMKV JSI Bindings!", e2);
            return false;
        }
    }
}
