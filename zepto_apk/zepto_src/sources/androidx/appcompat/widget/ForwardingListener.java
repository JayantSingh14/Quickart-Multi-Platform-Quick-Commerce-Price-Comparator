package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ShowableListMenu;

@RestrictTo
/* loaded from: classes3.dex */
public abstract class ForwardingListener implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final float f1038a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1039b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1040c;

    /* renamed from: d, reason: collision with root package name */
    public final View f1041d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f1042e;

    /* renamed from: f, reason: collision with root package name */
    public Runnable f1043f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1044g;

    /* renamed from: h, reason: collision with root package name */
    public int f1045h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f1046i = new int[2];

    public class DisallowIntercept implements Runnable {
        public DisallowIntercept() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ViewParent parent = ForwardingListener.this.f1041d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public class TriggerLongPress implements Runnable {
        public TriggerLongPress() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ForwardingListener forwardingListener = ForwardingListener.this;
            forwardingListener.a();
            View view = forwardingListener.f1041d;
            if (view.isEnabled() && !view.isLongClickable() && forwardingListener.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                forwardingListener.f1044g = true;
            }
        }
    }

    public ForwardingListener(View view) {
        this.f1041d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1038a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1039b = tapTimeout;
        this.f1040c = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        Runnable runnable = this.f1043f;
        View view = this.f1041d;
        if (runnable != null) {
            view.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1042e;
        if (runnable2 != null) {
            view.removeCallbacks(runnable2);
        }
    }

    public abstract ShowableListMenu b();

    public boolean c() {
        ShowableListMenu showableListMenuB = b();
        if (showableListMenuB == null || showableListMenuB.b()) {
            return true;
        }
        showableListMenuB.a();
        return true;
    }

    public boolean d() {
        ShowableListMenu showableListMenuB = b();
        if (showableListMenuB == null || !showableListMenuB.b()) {
            return true;
        }
        showableListMenuB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ForwardingListener.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f1044g = false;
        this.f1045h = -1;
        Runnable runnable = this.f1042e;
        if (runnable != null) {
            this.f1041d.removeCallbacks(runnable);
        }
    }
}
