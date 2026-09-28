package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: a, reason: collision with root package name */
    public ViewDragHelper f39963a;

    /* renamed from: b, reason: collision with root package name */
    public OnDismissListener f39964b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f39965c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f39966d;

    /* renamed from: e, reason: collision with root package name */
    public int f39967e = 2;

    /* renamed from: f, reason: collision with root package name */
    public final float f39968f = 0.5f;

    /* renamed from: g, reason: collision with root package name */
    public float f39969g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f39970h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    public final ViewDragHelper.Callback f39971i = new ViewDragHelper.Callback() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.1

        /* renamed from: a, reason: collision with root package name */
        public int f39972a;

        /* renamed from: b, reason: collision with root package name */
        public int f39973b = -1;

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int a(int i2, View view) {
            int width;
            int width2;
            int width3;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            boolean z = view.getLayoutDirection() == 1;
            int i3 = SwipeDismissBehavior.this.f39967e;
            if (i3 == 0) {
                if (z) {
                    width = this.f39972a - view.getWidth();
                    width2 = this.f39972a;
                } else {
                    width = this.f39972a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 != 1) {
                width = this.f39972a - view.getWidth();
                width2 = view.getWidth() + this.f39972a;
            } else if (z) {
                width = this.f39972a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.f39972a - view.getWidth();
                width2 = this.f39972a;
            }
            return Math.min(Math.max(width, i2), width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int b(int i2, View view) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final int c(View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void g(int i2, View view) {
            this.f39973b = i2;
            this.f39972a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                swipeDismissBehavior.f39966d = true;
                parent.requestDisallowInterceptTouchEvent(true);
                swipeDismissBehavior.f39966d = false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void h(int i2) {
            OnDismissListener onDismissListener = SwipeDismissBehavior.this.f39964b;
            if (onDismissListener != null) {
                onDismissListener.b(i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final void i(View view, int i2, int i3) {
            float width = view.getWidth();
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            float f2 = width * swipeDismissBehavior.f39969g;
            float width2 = view.getWidth() * swipeDismissBehavior.f39970h;
            float fAbs = Math.abs(i2 - this.f39972a);
            if (fAbs <= f2) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(Math.min(Math.max(0.0f, 1.0f - ((fAbs - f2) / (width2 - f2))), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0066  */
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void j(android.view.View r9, float r10, float r11) {
            /*
                r8 = this;
                r11 = -1
                r8.f39973b = r11
                int r11 = r9.getWidth()
                r0 = 0
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L39
                java.util.WeakHashMap r5 = androidx.core.view.ViewCompat.f3080a
                int r5 = r9.getLayoutDirection()
                if (r5 != r3) goto L1a
                r5 = r3
                goto L1b
            L1a:
                r5 = r4
            L1b:
                int r6 = r2.f39967e
                r7 = 2
                if (r6 != r7) goto L21
                goto L52
            L21:
                if (r6 != 0) goto L2d
                if (r5 == 0) goto L2a
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r1 >= 0) goto L66
                goto L52
            L2a:
                if (r1 <= 0) goto L66
                goto L52
            L2d:
                if (r6 != r3) goto L66
                if (r5 == 0) goto L34
                if (r1 <= 0) goto L66
                goto L52
            L34:
                int r1 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r1 >= 0) goto L66
                goto L52
            L39:
                int r1 = r9.getLeft()
                int r5 = r8.f39972a
                int r1 = r1 - r5
                int r5 = r9.getWidth()
                float r5 = (float) r5
                float r6 = r2.f39968f
                float r5 = r5 * r6
                int r5 = java.lang.Math.round(r5)
                int r1 = java.lang.Math.abs(r1)
                if (r1 < r5) goto L66
            L52:
                int r10 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r10 < 0) goto L61
                int r10 = r9.getLeft()
                int r0 = r8.f39972a
                if (r10 >= r0) goto L5f
                goto L61
            L5f:
                int r0 = r0 + r11
                goto L69
            L61:
                int r10 = r8.f39972a
                int r0 = r10 - r11
                goto L69
            L66:
                int r0 = r8.f39972a
                r3 = r4
            L69:
                androidx.customview.widget.ViewDragHelper r10 = r2.f39963a
                int r11 = r9.getTop()
                boolean r10 = r10.y(r0, r11)
                if (r10 == 0) goto L80
                com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable r10 = new com.google.android.material.behavior.SwipeDismissBehavior$SettleRunnable
                r10.<init>(r9, r3)
                java.util.WeakHashMap r11 = androidx.core.view.ViewCompat.f3080a
                r9.postOnAnimation(r10)
                return
            L80:
                if (r3 == 0) goto L89
                com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener r10 = r2.f39964b
                if (r10 == 0) goto L89
                r10.a(r9)
            L89:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.AnonymousClass1.j(android.view.View, float, float):void");
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public final boolean k(int i2, View view) {
            int i3 = this.f39973b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.y(view);
        }
    };

    public interface OnDismissListener {
        void a(View view);

        void b(int i2);
    }

    public class SettleRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final View f39976a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f39977b;

        public SettleRunnable(View view, boolean z) {
            this.f39976a = view;
            this.f39977b = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OnDismissListener onDismissListener;
            SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
            ViewDragHelper viewDragHelper = swipeDismissBehavior.f39963a;
            View view = this.f39976a;
            if (viewDragHelper != null && viewDragHelper.h()) {
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view.postOnAnimation(this);
            } else {
                if (!this.f39977b || (onDismissListener = swipeDismissBehavior.f39964b) == null) {
                    return;
                }
                onDismissListener.a(view);
            }
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean m(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zT = this.f39965c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zT = coordinatorLayout.t(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f39965c = zT;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f39965c = false;
        }
        if (zT) {
            if (this.f39963a == null) {
                this.f39963a = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.f39971i);
            }
            if (!this.f39966d && this.f39963a.z(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            ViewCompat.v(1048576, view);
            ViewCompat.s(0, view);
            if (y(view)) {
                ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3195m, null, new AccessibilityViewCommand() { // from class: com.google.android.material.behavior.SwipeDismissBehavior.2
                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean c(View view2) {
                        SwipeDismissBehavior swipeDismissBehavior = SwipeDismissBehavior.this;
                        if (!swipeDismissBehavior.y(view2)) {
                            return false;
                        }
                        WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                        boolean z = view2.getLayoutDirection() == 1;
                        int i3 = swipeDismissBehavior.f39967e;
                        view2.offsetLeftAndRight((!(i3 == 0 && z) && (i3 != 1 || z)) ? view2.getWidth() : -view2.getWidth());
                        view2.setAlpha(0.0f);
                        OnDismissListener onDismissListener = swipeDismissBehavior.f39964b;
                        if (onDismissListener != null) {
                            onDismissListener.a(view2);
                        }
                        return true;
                    }
                });
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean x(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f39963a == null) {
            return false;
        }
        if (this.f39966d && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f39963a.p(motionEvent);
        return true;
    }

    public boolean y(View view) {
        return true;
    }
}
