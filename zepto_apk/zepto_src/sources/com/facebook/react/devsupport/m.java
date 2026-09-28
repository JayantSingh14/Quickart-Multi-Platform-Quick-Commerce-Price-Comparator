package com.facebook.react.devsupport;

import android.app.Dialog;
import android.widget.PopupWindow;

/* loaded from: classes3.dex */
public final /* synthetic */ class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18950a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f18951b;

    public /* synthetic */ m(Object obj, int i2) {
        this.f18950a = i2;
        this.f18951b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18950a) {
            case 0:
                PausedInDebuggerOverlayDialogManager pausedInDebuggerOverlayDialogManager = (PausedInDebuggerOverlayDialogManager) this.f18951b;
                Dialog dialog = pausedInDebuggerOverlayDialogManager.f18865b;
                if (dialog != null) {
                    dialog.dismiss();
                    pausedInDebuggerOverlayDialogManager.f18865b = null;
                    break;
                }
                break;
            case 1:
                ((RedBoxDialogSurfaceDelegate) this.f18951b).a();
                break;
            case 2:
                ((BridgeDevSupportManager) this.f18951b).f18823f.getClass();
                break;
            case 3:
                DefaultDevLoadingViewImplementation defaultDevLoadingViewImplementation = (DefaultDevLoadingViewImplementation) this.f18951b;
                PopupWindow popupWindow = defaultDevLoadingViewImplementation.f18793c;
                if (popupWindow != null && popupWindow.isShowing()) {
                    popupWindow.dismiss();
                    defaultDevLoadingViewImplementation.f18793c = null;
                    defaultDevLoadingViewImplementation.f18792b = null;
                    break;
                }
                break;
            default:
                ((DoubleTapReloadRecognizer) this.f18951b).f18842a = false;
                break;
        }
    }
}
