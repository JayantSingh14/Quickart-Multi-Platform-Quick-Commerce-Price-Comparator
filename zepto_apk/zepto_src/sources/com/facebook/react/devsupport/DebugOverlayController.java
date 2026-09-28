package com.facebook.react.devsupport;

import android.provider.Settings;
import android.view.WindowManager;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.ReactApplicationContext;

/* loaded from: classes3.dex */
class DebugOverlayController {

    /* renamed from: a, reason: collision with root package name */
    public final WindowManager f18786a;

    /* renamed from: b, reason: collision with root package name */
    public final ReactApplicationContext f18787b;

    /* renamed from: c, reason: collision with root package name */
    public FpsView f18788c;

    /* renamed from: com.facebook.react.devsupport.DebugOverlayController$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f18789a;

        public AnonymousClass1(boolean z) {
            this.f18789a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FpsView fpsView;
            DebugOverlayController debugOverlayController = DebugOverlayController.this;
            boolean z = this.f18789a;
            if (!z || debugOverlayController.f18788c != null) {
                if (z || (fpsView = debugOverlayController.f18788c) == null) {
                    return;
                }
                fpsView.removeAllViews();
                debugOverlayController.f18786a.removeView(debugOverlayController.f18788c);
                debugOverlayController.f18788c = null;
                return;
            }
            ReactApplicationContext reactApplicationContext = debugOverlayController.f18787b;
            if (!Settings.canDrawOverlays(reactApplicationContext)) {
                FLog.a("ReactNative", "Wait for overlay permission to be set");
                return;
            }
            debugOverlayController.f18788c = new FpsView(reactApplicationContext);
            debugOverlayController.f18786a.addView(debugOverlayController.f18788c, new WindowManager.LayoutParams(-1, -1, WindowOverlayCompat.f18918a, 24, -3));
        }
    }

    public DebugOverlayController(ReactApplicationContext reactApplicationContext) {
        this.f18787b = reactApplicationContext;
        this.f18786a = (WindowManager) reactApplicationContext.getSystemService("window");
    }
}
