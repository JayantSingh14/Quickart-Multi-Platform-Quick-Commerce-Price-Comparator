package com.zeptoconsumerapp.screenShotDetector;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresApi;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zeptoconsumerapp.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class ScreenshotDetectionModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    @NotNull
    private final ReactApplicationContext reactContext;

    @Nullable
    private Activity.ScreenCaptureCallback screenCaptureCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScreenshotDetectionModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.reactContext = reactContext;
        reactContext.addLifecycleEventListener(this);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [android.app.Activity$ScreenCaptureCallback, com.zeptoconsumerapp.screenShotDetector.a] */
    @RequiresApi
    private final void registerScreenshotDetection() {
        try {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            if (currentActivity != null) {
                ?? r1 = new Activity.ScreenCaptureCallback() { // from class: com.zeptoconsumerapp.screenShotDetector.a
                    @Override // android.app.Activity.ScreenCaptureCallback
                    public final void onScreenCaptured() {
                        this.f47806a.sendScreenshotEvent();
                    }
                };
                this.screenCaptureCallback = r1;
                currentActivity.registerScreenCaptureCallback(new com.google.firebase.messaging.a(1), r1);
            }
        } catch (Exception e2) {
            Utils.i(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerScreenshotDetection$lambda$3$lambda$2$lambda$1(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendScreenshotEvent() {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("SCREEN_SHOT_DETECTED", null);
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "ScreenshotDetectionModule";
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.screenCaptureCallback = null;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
    }

    @ReactMethod
    public final void registerScreenCaptureCallback() {
        if (Build.VERSION.SDK_INT >= 34) {
            registerScreenshotDetection();
        }
    }

    @ReactMethod
    @RequiresApi
    public final void unregisterScreenCaptureCallback() {
        Activity.ScreenCaptureCallback screenCaptureCallback;
        try {
            Activity currentActivity = this.reactContext.getCurrentActivity();
            if (currentActivity != null && (screenCaptureCallback = this.screenCaptureCallback) != null) {
                currentActivity.unregisterScreenCaptureCallback(screenCaptureCallback);
            }
        } catch (Exception e2) {
            Utils.i(e2);
        } finally {
            this.screenCaptureCallback = null;
        }
    }
}
