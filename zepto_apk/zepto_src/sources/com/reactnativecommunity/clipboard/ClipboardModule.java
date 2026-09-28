package com.reactnativecommunity.clipboard;

import android.content.ClipData;
import android.content.ClipboardManager;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule;

@ReactModule(name = ClipboardModule.NAME)
/* loaded from: classes.dex */
public class ClipboardModule extends ReactContextBaseJavaModule {
    public static final String CLIPBOARD_TEXT_CHANGED = "RNCClipboard_TEXT_CHANGED";
    public static final String MIMETYPE_HEIC = "image/heic";
    public static final String MIMETYPE_HEIF = "image/heif";
    public static final String MIMETYPE_JPEG = "image/jpeg";
    public static final String MIMETYPE_JPG = "image/jpg";
    public static final String MIMETYPE_PNG = "image/png";
    public static final String MIMETYPE_WEBP = "image/webp";
    public static final String NAME = "RNCClipboard";
    private ClipboardManager.OnPrimaryClipChangedListener listener;
    private ReactApplicationContext reactContext;

    public ClipboardModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.listener = null;
        this.reactContext = reactApplicationContext;
    }

    private ClipboardManager getClipboardService() {
        return (ClipboardManager) this.reactContext.getSystemService("clipboard");
    }

    @ReactMethod
    public void addListener(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0094  */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void getImage(com.facebook.react.bridge.Promise r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.clipboard.ClipboardModule.getImage(com.facebook.react.bridge.Promise):void");
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getString(Promise promise) {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipData primaryClip = clipboardService.getPrimaryClip();
            if (primaryClip == null || primaryClip.getItemCount() < 1) {
                promise.resolve("");
                return;
            }
            promise.resolve("" + ((Object) clipboardService.getPrimaryClip().getItemAt(0).getText()));
        } catch (Exception e2) {
            promise.reject(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    @com.facebook.react.bridge.ReactMethod
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void hasString(com.facebook.react.bridge.Promise r3) {
        /*
            r2 = this;
            android.content.ClipboardManager r0 = r2.getClipboardService()     // Catch: java.lang.Exception -> L12
            android.content.ClipData r0 = r0.getPrimaryClip()     // Catch: java.lang.Exception -> L12
            if (r0 == 0) goto L14
            int r0 = r0.getItemCount()     // Catch: java.lang.Exception -> L12
            r1 = 1
            if (r0 < r1) goto L14
            goto L15
        L12:
            r0 = move-exception
            goto L1d
        L14:
            r1 = 0
        L15:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Exception -> L12
            r3.resolve(r0)     // Catch: java.lang.Exception -> L12
            return
        L1d:
            r3.reject(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.clipboard.ClipboardModule.hasString(com.facebook.react.bridge.Promise):void");
    }

    @ReactMethod
    public void removeListener() {
        if (this.listener != null) {
            try {
                getClipboardService().removePrimaryClipChangedListener(this.listener);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    @ReactMethod
    public void setListener() {
        try {
            ClipboardManager clipboardService = getClipboardService();
            ClipboardManager.OnPrimaryClipChangedListener onPrimaryClipChangedListener = new ClipboardManager.OnPrimaryClipChangedListener() { // from class: com.reactnativecommunity.clipboard.ClipboardModule.1
                @Override // android.content.ClipboardManager.OnPrimaryClipChangedListener
                public final void onPrimaryClipChanged() {
                    ((DeviceEventManagerModule.RCTDeviceEventEmitter) ClipboardModule.this.reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ClipboardModule.CLIPBOARD_TEXT_CHANGED, null);
                }
            };
            this.listener = onPrimaryClipChangedListener;
            clipboardService.addPrimaryClipChangedListener(onPrimaryClipChangedListener);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @ReactMethod
    public void setString(String str) {
        try {
            getClipboardService().setPrimaryClip(ClipData.newPlainText(null, str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
