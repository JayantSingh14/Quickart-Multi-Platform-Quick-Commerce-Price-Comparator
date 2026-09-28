package com.zeptoconsumerapp.DynamicSplashScreen;

import android.app.Activity;
import android.app.Dialog;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class DynamicSplashScreenModule extends ReactContextBaseJavaModule {
    public DynamicSplashScreenModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void getActiveCampaignName(Promise promise) {
        try {
            promise.resolve(DynamicSplashScreen.f47419f);
        } catch (Exception unused) {
            promise.resolve("");
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "DynamicSplashScreen";
    }

    @ReactMethod
    public void hide() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            WeakReference weakReference = DynamicSplashScreen.f47415b;
            if (weakReference == null) {
                return;
            } else {
                currentActivity = (Activity) weakReference.get();
            }
        }
        if (DynamicSplashScreen.b(currentActivity)) {
            DynamicSplashScreen.f47417d = true;
            currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.DynamicSplashScreen.DynamicSplashScreen.6
                @Override // java.lang.Runnable
                public final void run() {
                    Dialog dialog = DynamicSplashScreen.f47414a;
                    if (dialog == null || !dialog.isShowing()) {
                        return;
                    }
                    Activity activity = currentActivity;
                    boolean zIsDestroyed = activity.isDestroyed();
                    if (DynamicSplashScreen.b(activity) && !zIsDestroyed && DynamicSplashScreen.f47416c) {
                        DynamicSplashScreen.a();
                    }
                }
            });
        }
    }
}
