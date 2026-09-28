package androidx.browser.browseractions;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;

@Deprecated
/* loaded from: classes3.dex */
class BrowserActionsFallbackMenuDialog extends Dialog {

    /* renamed from: androidx.browser.browseractions.BrowserActionsFallbackMenuDialog$1, reason: invalid class name */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator animator) {
            throw null;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        throw null;
    }

    @Override // android.app.Dialog
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        throw null;
    }

    @Override // android.app.Dialog
    public final void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        throw null;
    }
}
