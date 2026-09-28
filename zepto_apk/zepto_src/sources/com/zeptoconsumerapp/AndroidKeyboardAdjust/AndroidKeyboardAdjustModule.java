package com.zeptoconsumerapp.AndroidKeyboardAdjust;

import android.app.Activity;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/* loaded from: classes.dex */
public class AndroidKeyboardAdjustModule extends ReactContextBaseJavaModule {
    public AndroidKeyboardAdjustModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AndroidKeyboardAdjust";
    }

    @ReactMethod
    public void setAdjustNothing() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.2
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(48);
            }
        });
    }

    @ReactMethod
    public void setAdjustPan() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.3
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(32);
            }
        });
    }

    @ReactMethod
    public void setAdjustResize() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.4
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(16);
            }
        });
    }

    @ReactMethod
    public void setAdjustUnspecified() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.5
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(0);
            }
        });
    }

    @ReactMethod
    public void setAlwaysHidden() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.6
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(3);
            }
        });
    }

    @ReactMethod
    public void setAlwaysVisible() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.7
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(5);
            }
        });
    }

    @ReactMethod
    public void setHidden() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.9
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(2);
            }
        });
    }

    @ReactMethod
    public void setStateUnspecified() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.1
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(0);
            }
        });
    }

    @ReactMethod
    public void setUnchanged() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.10
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(1);
            }
        });
    }

    @ReactMethod
    public void setVisible() {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        currentActivity.runOnUiThread(new Runnable() { // from class: com.zeptoconsumerapp.AndroidKeyboardAdjust.AndroidKeyboardAdjustModule.8
            @Override // java.lang.Runnable
            public final void run() {
                currentActivity.getWindow().setSoftInputMode(4);
            }
        });
    }
}
