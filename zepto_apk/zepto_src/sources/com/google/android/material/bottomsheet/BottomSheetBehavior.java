package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.b;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {
    public static final int P0 = R.style.Widget_Design_BottomSheet_Modal;
    public final StateSettlingTracker A;
    public int A0;
    public final ValueAnimator B;
    public int B0;
    public int C;
    public int C0;
    public int D;
    public WeakReference D0;
    public int E;
    public WeakReference E0;
    public float F;
    public WeakReference F0;
    public int G;
    public final ArrayList G0;
    public final float H;
    public VelocityTracker H0;
    public boolean I;
    public MaterialBottomContainerBackHelper I0;
    public boolean J;
    public int J0;
    public boolean K;
    public int K0;
    public int L;
    public boolean L0;
    public ViewDragHelper M;
    public HashMap M0;
    public final SparseIntArray N0;
    public final ViewDragHelper.Callback O0;
    public boolean Q;
    public int X;
    public boolean Y;
    public final float Z;

    /* renamed from: a, reason: collision with root package name */
    public final int f40007a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f40008b;

    /* renamed from: c, reason: collision with root package name */
    public final float f40009c;

    /* renamed from: d, reason: collision with root package name */
    public final int f40010d;

    /* renamed from: e, reason: collision with root package name */
    public int f40011e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40012f;

    /* renamed from: g, reason: collision with root package name */
    public int f40013g;

    /* renamed from: h, reason: collision with root package name */
    public final int f40014h;

    /* renamed from: i, reason: collision with root package name */
    public final MaterialShapeDrawable f40015i;

    /* renamed from: j, reason: collision with root package name */
    public final ColorStateList f40016j;

    /* renamed from: k, reason: collision with root package name */
    public final int f40017k;

    /* renamed from: l, reason: collision with root package name */
    public int f40018l;

    /* renamed from: m, reason: collision with root package name */
    public int f40019m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public int v;
    public int w;
    public final boolean x;
    public final ShapeAppearanceModel y;
    public boolean z;

    public static abstract class BottomSheetCallback {
        public void onLayout(@NonNull View view) {
        }

        public abstract void onSlide(View view, float f2);

        public abstract void onStateChanged(View view, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface SaveFlags {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface State {
    }

    public class StateSettlingTracker {

        /* renamed from: a, reason: collision with root package name */
        public int f40035a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f40036b;

        /* renamed from: c, reason: collision with root package name */
        public final Runnable f40037c = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.StateSettlingTracker.1
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                StateSettlingTracker stateSettlingTracker = StateSettlingTracker.this;
                stateSettlingTracker.f40036b = false;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                ViewDragHelper viewDragHelper = bottomSheetBehavior.M;
                if (viewDragHelper != null && viewDragHelper.h()) {
                    stateSettlingTracker.a(stateSettlingTracker.f40035a);
                } else if (bottomSheetBehavior.L == 2) {
                    bottomSheetBehavior.T(stateSettlingTracker.f40035a);
                }
            }
        };

        public StateSettlingTracker() {
        }

        public final void a(int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            WeakReference weakReference = bottomSheetBehavior.D0;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f40035a = i2;
            if (this.f40036b) {
                return;
            }
            View view = (View) bottomSheetBehavior.D0.get();
            Runnable runnable = this.f40037c;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view.postOnAnimation(runnable);
            this.f40036b = true;
        }
    }

    public BottomSheetBehavior() {
        this.f40007a = 0;
        this.f40008b = true;
        this.f40017k = -1;
        this.f40018l = -1;
        this.A = new StateSettlingTracker();
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Z = 0.1f;
        this.G0 = new ArrayList();
        this.K0 = -1;
        this.N0 = new SparseIntArray();
        this.O0 = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int a(int i2, View view) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int b(int i2, View view) {
                return MathUtils.b(i2, BottomSheetBehavior.this.H(), d());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int d() {
                int i2 = BottomSheetBehavior.P0;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return bottomSheetBehavior.I ? bottomSheetBehavior.C0 : bottomSheetBehavior.G;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void h(int i2) throws Resources.NotFoundException {
                if (i2 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.T(1);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void i(View view, int i2, int i3) {
                BottomSheetBehavior.this.D(i3);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x004c  */
            /* JADX WARN: Removed duplicated region for block: B:34:0x0085  */
            /* JADX WARN: Removed duplicated region for block: B:6:0x000d  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void j(android.view.View r6, float r7, float r8) throws android.content.res.Resources.NotFoundException {
                /*
                    Method dump skipped, instructions count: 233
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.j(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final boolean k(int i2, View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i3 = bottomSheetBehavior.L;
                if (i3 == 1 || bottomSheetBehavior.L0) {
                    return false;
                }
                if (i3 == 3 && bottomSheetBehavior.J0 == i2) {
                    WeakReference weakReference = bottomSheetBehavior.F0;
                    View view2 = weakReference != null ? (View) weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                System.currentTimeMillis();
                WeakReference weakReference2 = bottomSheetBehavior.D0;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
    }

    public static View E(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (ViewCompat.r(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View viewE = E(viewGroup.getChildAt(i2));
            if (viewE != null) {
                return viewE;
            }
        }
        return null;
    }

    public static BottomSheetBehavior F(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).f2560a;
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    public static int G(int i2, int i3, int i4, int i5) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, i3, i5);
        if (i4 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i4), 1073741824);
        }
        if (size != 0) {
            i4 = Math.min(size, i4);
        }
        return View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float A() {
        /*
            r5 = this;
            com.google.android.material.shape.MaterialShapeDrawable r0 = r5.f40015i
            r1 = 0
            if (r0 == 0) goto L6f
            java.lang.ref.WeakReference r0 = r5.D0
            if (r0 == 0) goto L6f
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L6f
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r0 < r2) goto L6f
            java.lang.ref.WeakReference r0 = r5.D0
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            boolean r2 = r5.L()
            if (r2 == 0) goto L6f
            android.view.WindowInsets r0 = r0.getRootWindowInsets()
            if (r0 == 0) goto L6f
            com.google.android.material.shape.MaterialShapeDrawable r2 = r5.f40015i
            float r2 = r2.i()
            android.view.RoundedCorner r3 = com.facebook.hermes.intl.a.p(r0)
            if (r3 == 0) goto L44
            int r3 = com.google.android.gms.internal.ads.c.a(r3)
            float r3 = (float) r3
            int r4 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L44
            float r3 = r3 / r2
            goto L45
        L44:
            r3 = r1
        L45:
            com.google.android.material.shape.MaterialShapeDrawable r2 = r5.f40015i
            com.google.android.material.shape.MaterialShapeDrawable$MaterialShapeDrawableState r4 = r2.f40974a
            com.google.android.material.shape.ShapeAppearanceModel r4 = r4.f40989a
            com.google.android.material.shape.CornerSize r4 = r4.f41012f
            android.graphics.RectF r2 = r2.g()
            float r2 = r4.a(r2)
            android.view.RoundedCorner r0 = com.facebook.hermes.intl.a.y(r0)
            if (r0 == 0) goto L6a
            int r0 = com.google.android.gms.internal.ads.c.a(r0)
            float r0 = (float) r0
            int r4 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            int r4 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            if (r4 <= 0) goto L6a
            float r1 = r0 / r2
        L6a:
            float r0 = java.lang.Math.max(r3, r1)
            return r0
        L6f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.A():float");
    }

    public final int B() {
        int i2;
        return this.f40012f ? Math.min(Math.max(this.f40013g, this.C0 - ((this.B0 * 9) / 16)), this.A0) + this.v : (this.n || this.o || (i2 = this.f40019m) <= 0) ? this.f40011e + this.v : Math.max(this.f40011e, i2 + this.f40014h);
    }

    public final void C(int i2, View view) {
        if (view == null) {
            return;
        }
        ViewCompat.v(524288, view);
        ViewCompat.s(0, view);
        ViewCompat.v(262144, view);
        ViewCompat.s(0, view);
        ViewCompat.v(1048576, view);
        ViewCompat.s(0, view);
        SparseIntArray sparseIntArray = this.N0;
        int i3 = sparseIntArray.get(i2, -1);
        if (i3 != -1) {
            ViewCompat.v(i3, view);
            ViewCompat.s(0, view);
            sparseIntArray.delete(i2);
        }
    }

    public final void D(int i2) {
        float f2;
        float fH;
        View view = (View) this.D0.get();
        if (view != null) {
            ArrayList arrayList = this.G0;
            if (arrayList.isEmpty()) {
                return;
            }
            int i3 = this.G;
            if (i2 > i3 || i3 == H()) {
                int i4 = this.G;
                f2 = i4 - i2;
                fH = this.C0 - i4;
            } else {
                int i5 = this.G;
                f2 = i5 - i2;
                fH = i5 - H();
            }
            float f3 = f2 / fH;
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                ((BottomSheetCallback) arrayList.get(i6)).onSlide(view, f3);
            }
        }
    }

    public final int H() {
        if (this.f40008b) {
            return this.D;
        }
        return Math.max(this.C, this.r ? 0 : this.w);
    }

    public final float I() {
        return this.F;
    }

    public final int J() {
        if (this.f40012f) {
            return -1;
        }
        return this.f40011e;
    }

    public final int K(int i2) {
        if (i2 == 3) {
            return H();
        }
        if (i2 == 4) {
            return this.G;
        }
        if (i2 == 5) {
            return this.C0;
        }
        if (i2 == 6) {
            return this.E;
        }
        throw new IllegalArgumentException(b.f(i2, "Invalid state to get top offset: "));
    }

    public final boolean L() {
        WeakReference weakReference = this.D0;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.D0.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    public final void M(BottomSheetCallback bottomSheetCallback) {
        this.G0.remove(bottomSheetCallback);
    }

    public final void N(BottomSheetDragHandleView bottomSheetDragHandleView) throws Resources.NotFoundException {
        WeakReference weakReference;
        if (bottomSheetDragHandleView != null || (weakReference = this.E0) == null) {
            this.E0 = new WeakReference(bottomSheetDragHandleView);
            X(1, bottomSheetDragHandleView);
        } else {
            C(1, (View) weakReference.get());
            this.E0 = null;
        }
    }

    public final void O(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.C = i2;
        Y(this.L, true);
    }

    public final void P(boolean z) throws Resources.NotFoundException {
        if (this.f40008b == z) {
            return;
        }
        this.f40008b = z;
        if (this.D0 != null) {
            z();
        }
        T((this.f40008b && this.L == 6) ? 3 : this.L);
        Y(this.L, true);
        W();
    }

    public final void Q(float f2) {
        if (f2 <= 0.0f || f2 >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.F = f2;
        if (this.D0 != null) {
            this.E = (int) ((1.0f - f2) * this.C0);
        }
    }

    public final void R(boolean z) throws Resources.NotFoundException {
        if (this.I != z) {
            this.I = z;
            if (!z && this.L == 5) {
                f(4);
            }
            W();
        }
    }

    public final void S(int i2) {
        if (i2 == -1) {
            if (this.f40012f) {
                return;
            } else {
                this.f40012f = true;
            }
        } else {
            if (!this.f40012f && this.f40011e == i2) {
                return;
            }
            this.f40012f = false;
            this.f40011e = Math.max(0, i2);
        }
        a0();
    }

    public final void T(int i2) throws Resources.NotFoundException {
        View view;
        if (this.L == i2) {
            return;
        }
        this.L = i2;
        if (i2 != 4 && i2 != 3 && i2 != 6) {
            boolean z = this.I;
        }
        WeakReference weakReference = this.D0;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i3 = 0;
        if (i2 == 3) {
            Z(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            Z(false);
        }
        Y(i2, true);
        while (true) {
            ArrayList arrayList = this.G0;
            if (i3 >= arrayList.size()) {
                W();
                return;
            } else {
                ((BottomSheetCallback) arrayList.get(i3)).onStateChanged(view, i2);
                i3++;
            }
        }
    }

    public final boolean U(View view, float f2) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f2 * this.Z) + ((float) view.getTop())) - ((float) this.G)) / ((float) B()) > 0.5f;
    }

    public final void V(int i2, View view, boolean z) throws Resources.NotFoundException {
        int iK = K(i2);
        ViewDragHelper viewDragHelper = this.M;
        if (viewDragHelper == null || (!z ? viewDragHelper.A(view, view.getLeft(), iK) : viewDragHelper.y(view.getLeft(), iK))) {
            T(i2);
            return;
        }
        T(2);
        Y(i2, true);
        this.A.a(i2);
    }

    public final void W() throws Resources.NotFoundException {
        WeakReference weakReference = this.D0;
        if (weakReference != null) {
            X(0, (View) weakReference.get());
        }
        WeakReference weakReference2 = this.E0;
        if (weakReference2 != null) {
            X(1, (View) weakReference2.get());
        }
    }

    public final void X(int i2, View view) throws Resources.NotFoundException {
        int iA;
        int i3;
        if (view == null) {
            return;
        }
        C(i2, view);
        if (!this.f40008b && this.L != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            AccessibilityViewCommand accessibilityViewCommand = new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean c(View view2) throws Resources.NotFoundException {
                    BottomSheetBehavior.this.f(i);
                    return true;
                }
            };
            ArrayList arrayListG = ViewCompat.g(view);
            int i4 = 0;
            while (true) {
                if (i4 >= arrayListG.size()) {
                    int i5 = -1;
                    for (int i6 = 0; i6 < 32 && i5 == -1; i6++) {
                        int i7 = ViewCompat.f3083d[i6];
                        boolean z = true;
                        for (int i8 = 0; i8 < arrayListG.size(); i8++) {
                            z &= ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) arrayListG.get(i8)).a() != i7;
                        }
                        if (z) {
                            i5 = i7;
                        }
                    }
                    iA = i5;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) arrayListG.get(i4)).f3196a).getLabel())) {
                        iA = ((AccessibilityNodeInfoCompat.AccessibilityActionCompat) arrayListG.get(i4)).a();
                        break;
                    }
                    i4++;
                }
            }
            if (iA != -1) {
                i3 = iA;
                AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat = new AccessibilityNodeInfoCompat.AccessibilityActionCompat(null, i3, string, accessibilityViewCommand, null);
                AccessibilityDelegateCompat accessibilityDelegateCompatD = ViewCompat.d(view);
                if (accessibilityDelegateCompatD == null) {
                    accessibilityDelegateCompatD = new AccessibilityDelegateCompat();
                }
                ViewCompat.z(view, accessibilityDelegateCompatD);
                ViewCompat.v(accessibilityActionCompat.a(), view);
                ViewCompat.g(view).add(accessibilityActionCompat);
                ViewCompat.s(0, view);
            } else {
                i3 = iA;
            }
            this.N0.put(i2, i3);
        }
        if (this.I) {
            final int i9 = 5;
            if (this.L != 5) {
                ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3195m, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
                    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                    public final boolean c(View view2) throws Resources.NotFoundException {
                        BottomSheetBehavior.this.f(i9);
                        return true;
                    }
                });
            }
        }
        int i10 = this.L;
        final int i11 = 4;
        final int i12 = 3;
        if (i10 == 3) {
            i = this.f40008b ? 4 : 6;
            ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3194l, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean c(View view2) throws Resources.NotFoundException {
                    BottomSheetBehavior.this.f(i);
                    return true;
                }
            });
        } else if (i10 == 4) {
            i = this.f40008b ? 3 : 6;
            ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3193k, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean c(View view2) throws Resources.NotFoundException {
                    BottomSheetBehavior.this.f(i);
                    return true;
                }
            });
        } else {
            if (i10 != 6) {
                return;
            }
            ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3194l, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean c(View view2) throws Resources.NotFoundException {
                    BottomSheetBehavior.this.f(i11);
                    return true;
                }
            });
            ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3193k, null, new AccessibilityViewCommand() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.6
                @Override // androidx.core.view.accessibility.AccessibilityViewCommand
                public final boolean c(View view2) throws Resources.NotFoundException {
                    BottomSheetBehavior.this.f(i12);
                    return true;
                }
            });
        }
    }

    public final void Y(int i2, boolean z) {
        MaterialShapeDrawable materialShapeDrawable = this.f40015i;
        ValueAnimator valueAnimator = this.B;
        if (i2 == 2) {
            return;
        }
        boolean z2 = this.L == 3 && (this.x || L());
        if (this.z == z2 || materialShapeDrawable == null) {
            return;
        }
        this.z = z2;
        if (!z || valueAnimator == null) {
            if (valueAnimator != null && valueAnimator.isRunning()) {
                valueAnimator.cancel();
            }
            materialShapeDrawable.n(this.z ? A() : 1.0f);
            return;
        }
        if (valueAnimator.isRunning()) {
            valueAnimator.reverse();
        } else {
            valueAnimator.setFloatValues(materialShapeDrawable.f40974a.f40997i, z2 ? A() : 1.0f);
            valueAnimator.start();
        }
    }

    public final void Z(boolean z) {
        WeakReference weakReference = this.D0;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.M0 != null) {
                    return;
                } else {
                    this.M0 = new HashMap(childCount);
                }
            }
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = coordinatorLayout.getChildAt(i2);
                if (childAt != this.D0.get() && z) {
                    this.M0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.M0 = null;
        }
    }

    public final void a0() {
        View view;
        if (this.D0 != null) {
            z();
            if (this.L != 4 || (view = (View) this.D0.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void b() {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.I0;
        if (materialBottomContainerBackHelper == null || materialBottomContainerBackHelper.a() == null) {
            return;
        }
        AnimatorSet animatorSetB = materialBottomContainerBackHelper.b();
        animatorSetB.setDuration(materialBottomContainerBackHelper.f40670e);
        animatorSetB.start();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void c(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.I0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        materialBottomContainerBackHelper.f40671f = backEventCompat;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void d(BackEventCompat backEventCompat) {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.I0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        if (materialBottomContainerBackHelper.f40671f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = materialBottomContainerBackHelper.f40671f;
        materialBottomContainerBackHelper.f40671f = backEventCompat;
        if (backEventCompat2 == null) {
            return;
        }
        materialBottomContainerBackHelper.d(backEventCompat.f120c);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void e() throws Resources.NotFoundException {
        MaterialBottomContainerBackHelper materialBottomContainerBackHelper = this.I0;
        if (materialBottomContainerBackHelper == null) {
            return;
        }
        BackEventCompat backEventCompat = materialBottomContainerBackHelper.f40671f;
        materialBottomContainerBackHelper.f40671f = null;
        if (backEventCompat == null || Build.VERSION.SDK_INT < 34) {
            f(this.I ? 5 : 4);
            return;
        }
        if (this.I) {
            materialBottomContainerBackHelper.c(backEventCompat, new AnimatorListenerAdapter() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator) throws Resources.NotFoundException {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    bottomSheetBehavior.T(5);
                    WeakReference weakReference = bottomSheetBehavior.D0;
                    if (weakReference == null || weakReference.get() == null) {
                        return;
                    }
                    ((View) bottomSheetBehavior.D0.get()).requestLayout();
                }
            });
            return;
        }
        AnimatorSet animatorSetB = materialBottomContainerBackHelper.b();
        animatorSetB.setDuration(AnimationUtils.c(backEventCompat.f120c, materialBottomContainerBackHelper.f40668c, materialBottomContainerBackHelper.f40669d));
        animatorSetB.start();
        f(4);
    }

    public final void f(int i2) throws Resources.NotFoundException {
        if (i2 == 1 || i2 == 2) {
            throw new IllegalArgumentException(b.r(new StringBuilder("STATE_"), i2 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i2 == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i2);
            return;
        }
        final int i3 = (i2 == 6 && this.f40008b && K(i2) <= this.D) ? 3 : i2;
        WeakReference weakReference = this.D0;
        if (weakReference == null || weakReference.get() == null) {
            T(i2);
            return;
        }
        final View view = (View) this.D0.get();
        Runnable runnable = new Runnable() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.1
            @Override // java.lang.Runnable
            public final void run() throws Resources.NotFoundException {
                int i4 = BottomSheetBehavior.P0;
                BottomSheetBehavior.this.V(i3, view, false);
            }
        };
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (view.isAttachedToWindow()) {
                view.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    public final int getState() {
        return this.L;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void i(CoordinatorLayout.LayoutParams layoutParams) {
        this.D0 = null;
        this.M = null;
        this.I0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void l() {
        this.D0 = null;
        this.M = null;
        this.I0 = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i2;
        ViewDragHelper viewDragHelper;
        if (!view.isShown() || !this.K) {
            this.Q = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.J0 = -1;
            this.K0 = -1;
            VelocityTracker velocityTracker = this.H0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.H0 = null;
            }
        }
        if (this.H0 == null) {
            this.H0 = VelocityTracker.obtain();
        }
        this.H0.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.K0 = (int) motionEvent.getY();
            if (this.L != 2) {
                WeakReference weakReference = this.F0;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.t(view2, x, this.K0)) {
                    this.J0 = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.L0 = true;
                }
            }
            this.Q = this.J0 == -1 && !coordinatorLayout.t(view, x, this.K0);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.L0 = false;
            this.J0 = -1;
            if (this.Q) {
                this.Q = false;
                return false;
            }
        }
        if (this.Q || (viewDragHelper = this.M) == null || !viewDragHelper.z(motionEvent)) {
            WeakReference weakReference2 = this.F0;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.Q || this.L == 1 || coordinatorLayout.t(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || (i2 = this.K0) == -1 || Math.abs(i2 - motionEvent.getY()) <= this.M.f3341b) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) throws Resources.NotFoundException {
        MaterialShapeDrawable materialShapeDrawable = this.f40015i;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int i3 = 0;
        if (this.D0 == null) {
            this.f40013g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            final boolean z = (Build.VERSION.SDK_INT < 29 || this.n || this.f40012f) ? false : true;
            if (this.o || this.p || this.q || this.s || this.t || this.u || z) {
                ViewUtils.b(view, new ViewUtils.OnApplyWindowInsetsListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.4
                    /* JADX WARN: Removed duplicated region for block: B:33:0x0078  */
                    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final androidx.core.view.WindowInsetsCompat a(android.view.View r11, androidx.core.view.WindowInsetsCompat r12, com.google.android.material.internal.ViewUtils.RelativePadding r13) {
                        /*
                            r10 = this;
                            r0 = 519(0x207, float:7.27E-43)
                            androidx.core.graphics.Insets r0 = r12.d(r0)
                            r1 = 32
                            androidx.core.graphics.Insets r1 = r12.d(r1)
                            int r2 = r0.f2809b
                            com.google.android.material.bottomsheet.BottomSheetBehavior r3 = com.google.android.material.bottomsheet.BottomSheetBehavior.this
                            r3.w = r2
                            boolean r2 = com.google.android.material.internal.ViewUtils.h(r11)
                            int r4 = r11.getPaddingBottom()
                            int r5 = r11.getPaddingLeft()
                            int r6 = r11.getPaddingRight()
                            boolean r7 = r3.o
                            if (r7 == 0) goto L2f
                            int r4 = r12.g()
                            r3.v = r4
                            int r7 = r13.f40663d
                            int r4 = r4 + r7
                        L2f:
                            boolean r7 = r3.p
                            int r8 = r0.f2808a
                            if (r7 == 0) goto L3d
                            if (r2 == 0) goto L3a
                            int r5 = r13.f40662c
                            goto L3c
                        L3a:
                            int r5 = r13.f40660a
                        L3c:
                            int r5 = r5 + r8
                        L3d:
                            boolean r7 = r3.q
                            int r9 = r0.f2810c
                            if (r7 == 0) goto L4c
                            if (r2 == 0) goto L48
                            int r13 = r13.f40660a
                            goto L4a
                        L48:
                            int r13 = r13.f40662c
                        L4a:
                            int r6 = r13 + r9
                        L4c:
                            android.view.ViewGroup$LayoutParams r13 = r11.getLayoutParams()
                            android.view.ViewGroup$MarginLayoutParams r13 = (android.view.ViewGroup.MarginLayoutParams) r13
                            boolean r2 = r3.s
                            r7 = 1
                            if (r2 == 0) goto L5f
                            int r2 = r13.leftMargin
                            if (r2 == r8) goto L5f
                            r13.leftMargin = r8
                            r2 = r7
                            goto L60
                        L5f:
                            r2 = 0
                        L60:
                            boolean r8 = r3.t
                            if (r8 == 0) goto L6b
                            int r8 = r13.rightMargin
                            if (r8 == r9) goto L6b
                            r13.rightMargin = r9
                            r2 = r7
                        L6b:
                            boolean r8 = r3.u
                            if (r8 == 0) goto L78
                            int r8 = r13.topMargin
                            int r0 = r0.f2809b
                            if (r8 == r0) goto L78
                            r13.topMargin = r0
                            goto L79
                        L78:
                            r7 = r2
                        L79:
                            if (r7 == 0) goto L7e
                            r11.setLayoutParams(r13)
                        L7e:
                            int r13 = r11.getPaddingTop()
                            r11.setPadding(r5, r13, r6, r4)
                            boolean r11 = r2
                            if (r11 == 0) goto L8d
                            int r13 = r1.f2811d
                            r3.f40019m = r13
                        L8d:
                            boolean r13 = r3.o
                            if (r13 != 0) goto L95
                            if (r11 == 0) goto L94
                            goto L95
                        L94:
                            return r12
                        L95:
                            r3.a0()
                            return r12
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass4.a(android.view.View, androidx.core.view.WindowInsetsCompat, com.google.android.material.internal.ViewUtils$RelativePadding):androidx.core.view.WindowInsetsCompat");
                    }
                });
            }
            ViewCompat.O(view, new InsetsAnimationCallback(view));
            this.D0 = new WeakReference(view);
            this.I0 = new MaterialBottomContainerBackHelper(view);
            if (materialShapeDrawable != null) {
                view.setBackground(materialShapeDrawable);
                float fJ = this.H;
                if (fJ == -1.0f) {
                    fJ = ViewCompat.j(view);
                }
                materialShapeDrawable.l(fJ);
            } else {
                ColorStateList colorStateList = this.f40016j;
                if (colorStateList != null) {
                    ViewCompat.C(view, colorStateList);
                }
            }
            W();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.M == null) {
            this.M = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.O0);
        }
        int top = view.getTop();
        coordinatorLayout.v(i2, view);
        this.B0 = coordinatorLayout.getWidth();
        this.C0 = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.A0 = height;
        int iMin = this.C0;
        int i4 = iMin - height;
        int i5 = this.w;
        if (i4 < i5) {
            if (this.r) {
                int i6 = this.f40018l;
                if (i6 != -1) {
                    iMin = Math.min(iMin, i6);
                }
                this.A0 = iMin;
            } else {
                int iMin2 = iMin - i5;
                int i7 = this.f40018l;
                if (i7 != -1) {
                    iMin2 = Math.min(iMin2, i7);
                }
                this.A0 = iMin2;
            }
        }
        this.D = Math.max(0, this.C0 - this.A0);
        this.E = (int) ((1.0f - this.F) * this.C0);
        z();
        int i8 = this.L;
        if (i8 == 3) {
            view.offsetTopAndBottom(H());
        } else if (i8 == 6) {
            view.offsetTopAndBottom(this.E);
        } else if (this.I && i8 == 5) {
            view.offsetTopAndBottom(this.C0);
        } else if (i8 == 4) {
            view.offsetTopAndBottom(this.G);
        } else if (i8 == 1 || i8 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        Y(this.L, false);
        this.F0 = new WeakReference(E(view));
        while (true) {
            ArrayList arrayList = this.G0;
            if (i3 >= arrayList.size()) {
                return true;
            }
            ((BottomSheetCallback) arrayList.get(i3)).onLayout(view);
            i3++;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean o(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(G(i2, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, this.f40017k, marginLayoutParams.width), G(i4, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.f40018l, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean p(View view) {
        WeakReference weakReference = this.F0;
        return (weakReference == null || view != weakReference.get() || this.L == 3) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i2, int i3, int[] iArr, int i4) throws Resources.NotFoundException {
        if (i4 == 1) {
            return;
        }
        WeakReference weakReference = this.F0;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < H()) {
                int iH = top - H();
                iArr[1] = iH;
                int i6 = -iH;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                view.offsetTopAndBottom(i6);
                T(3);
            } else {
                if (!this.K) {
                    return;
                }
                iArr[1] = i3;
                WeakHashMap weakHashMap2 = ViewCompat.f3080a;
                view.offsetTopAndBottom(-i3);
                T(1);
            }
        } else if (i3 < 0 && !view2.canScrollVertically(-1)) {
            int i7 = this.G;
            if (i5 > i7 && !this.I) {
                int i8 = top - i7;
                iArr[1] = i8;
                int i9 = -i8;
                WeakHashMap weakHashMap3 = ViewCompat.f3080a;
                view.offsetTopAndBottom(i9);
                T(4);
            } else {
                if (!this.K) {
                    return;
                }
                iArr[1] = i3;
                WeakHashMap weakHashMap4 = ViewCompat.f3080a;
                view.offsetTopAndBottom(-i3);
                T(1);
            }
        }
        D(view.getTop());
        this.X = i3;
        this.Y = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void t(View view, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        int i2 = this.f40007a;
        if (i2 != 0) {
            if (i2 == -1 || (i2 & 1) == 1) {
                this.f40011e = savedState.f40031d;
            }
            if (i2 == -1 || (i2 & 2) == 2) {
                this.f40008b = savedState.f40032e;
            }
            if (i2 == -1 || (i2 & 4) == 4) {
                this.I = savedState.f40033f;
            }
            if (i2 == -1 || (i2 & 8) == 8) {
                this.J = savedState.f40034g;
            }
        }
        int i3 = savedState.f40030c;
        if (i3 == 1 || i3 == 2) {
            this.L = 4;
        } else {
            this.L = i3;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable u(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new SavedState(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean v(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i2, int i3) {
        this.X = 0;
        this.Y = false;
        return (i2 & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(androidx.coordinatorlayout.widget.CoordinatorLayout r3, android.view.View r4, android.view.View r5, int r6) throws android.content.res.Resources.NotFoundException {
        /*
            r2 = this;
            int r3 = r4.getTop()
            int r6 = r2.H()
            r0 = 3
            if (r3 != r6) goto Lf
            r2.T(r0)
            return
        Lf:
            java.lang.ref.WeakReference r3 = r2.F0
            if (r3 == 0) goto Lb5
            java.lang.Object r3 = r3.get()
            if (r5 != r3) goto Lb5
            boolean r3 = r2.Y
            if (r3 != 0) goto L1f
            goto Lb5
        L1f:
            int r3 = r2.X
            r5 = 6
            if (r3 <= 0) goto L34
            boolean r3 = r2.f40008b
            if (r3 == 0) goto L2a
            goto Laf
        L2a:
            int r3 = r4.getTop()
            int r6 = r2.E
            if (r3 <= r6) goto Laf
            goto Lae
        L34:
            boolean r3 = r2.I
            if (r3 == 0) goto L55
            android.view.VelocityTracker r3 = r2.H0
            if (r3 != 0) goto L3e
            r3 = 0
            goto L4d
        L3e:
            r6 = 1000(0x3e8, float:1.401E-42)
            float r1 = r2.f40009c
            r3.computeCurrentVelocity(r6, r1)
            android.view.VelocityTracker r3 = r2.H0
            int r6 = r2.J0
            float r3 = r3.getYVelocity(r6)
        L4d:
            boolean r3 = r2.U(r4, r3)
            if (r3 == 0) goto L55
            r0 = 5
            goto Laf
        L55:
            int r3 = r2.X
            r6 = 4
            if (r3 != 0) goto L93
            int r3 = r4.getTop()
            boolean r1 = r2.f40008b
            if (r1 == 0) goto L74
            int r5 = r2.D
            int r5 = r3 - r5
            int r5 = java.lang.Math.abs(r5)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r5 >= r3) goto L97
            goto Laf
        L74:
            int r1 = r2.E
            if (r3 >= r1) goto L83
            int r6 = r2.G
            int r6 = r3 - r6
            int r6 = java.lang.Math.abs(r6)
            if (r3 >= r6) goto Lae
            goto Laf
        L83:
            int r0 = r3 - r1
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
            goto Lae
        L93:
            boolean r3 = r2.f40008b
            if (r3 == 0) goto L99
        L97:
            r0 = r6
            goto Laf
        L99:
            int r3 = r4.getTop()
            int r0 = r2.E
            int r0 = r3 - r0
            int r0 = java.lang.Math.abs(r0)
            int r1 = r2.G
            int r3 = r3 - r1
            int r3 = java.lang.Math.abs(r3)
            if (r0 >= r3) goto L97
        Lae:
            r0 = r5
        Laf:
            r3 = 0
            r2.V(r0, r4, r3)
            r2.Y = r3
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.w(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.View, int):void");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean x(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i2 = this.L;
        if (i2 == 1 && actionMasked == 0) {
            return true;
        }
        ViewDragHelper viewDragHelper = this.M;
        if (viewDragHelper != null && (this.K || i2 == 1)) {
            viewDragHelper.p(motionEvent);
        }
        if (actionMasked == 0) {
            this.J0 = -1;
            this.K0 = -1;
            VelocityTracker velocityTracker = this.H0;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.H0 = null;
            }
        }
        if (this.H0 == null) {
            this.H0 = VelocityTracker.obtain();
        }
        this.H0.addMovement(motionEvent);
        if (this.M != null && ((this.K || this.L == 1) && actionMasked == 2 && !this.Q)) {
            float fAbs = Math.abs(this.K0 - motionEvent.getY());
            ViewDragHelper viewDragHelper2 = this.M;
            if (fAbs > viewDragHelper2.f3341b) {
                viewDragHelper2.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.Q;
    }

    public final void y(BottomSheetCallback bottomSheetCallback) {
        ArrayList arrayList = this.G0;
        if (arrayList.contains(bottomSheetCallback)) {
            return;
        }
        arrayList.add(bottomSheetCallback);
    }

    public final void z() {
        int iB = B();
        if (this.f40008b) {
            this.G = Math.max(this.C0 - iB, this.D);
        } else {
            this.G = this.C0 - iB;
        }
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public final int f40030c;

        /* renamed from: d, reason: collision with root package name */
        public final int f40031d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f40032e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f40033f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f40034g;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f40030c = parcel.readInt();
            this.f40031d = parcel.readInt();
            this.f40032e = parcel.readInt() == 1;
            this.f40033f = parcel.readInt() == 1;
            this.f40034g = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f40030c);
            parcel.writeInt(this.f40031d);
            parcel.writeInt(this.f40032e ? 1 : 0);
            parcel.writeInt(this.f40033f ? 1 : 0);
            parcel.writeInt(this.f40034g ? 1 : 0);
        }

        public SavedState(BottomSheetBehavior bottomSheetBehavior) {
            super(AbsSavedState.EMPTY_STATE);
            this.f40030c = bottomSheetBehavior.L;
            this.f40031d = bottomSheetBehavior.f40011e;
            this.f40032e = bottomSheetBehavior.f40008b;
            this.f40033f = bottomSheetBehavior.I;
            this.f40034g = bottomSheetBehavior.J;
        }
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) throws Resources.NotFoundException {
        int i2;
        super(context, attributeSet);
        this.f40007a = 0;
        this.f40008b = true;
        this.f40017k = -1;
        this.f40018l = -1;
        this.A = new StateSettlingTracker();
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Z = 0.1f;
        this.G0 = new ArrayList();
        this.K0 = -1;
        this.N0 = new SparseIntArray();
        this.O0 = new ViewDragHelper.Callback() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.5
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int a(int i22, View view) {
                return view.getLeft();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int b(int i22, View view) {
                return MathUtils.b(i22, BottomSheetBehavior.this.H(), d());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int d() {
                int i22 = BottomSheetBehavior.P0;
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                return bottomSheetBehavior.I ? bottomSheetBehavior.C0 : bottomSheetBehavior.G;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void h(int i22) throws Resources.NotFoundException {
                if (i22 == 1) {
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    if (bottomSheetBehavior.K) {
                        bottomSheetBehavior.T(1);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void i(View view, int i22, int i3) {
                BottomSheetBehavior.this.D(i3);
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void j(View v, float v2, float v3) throws Resources.NotFoundException {
                /*
                    Method dump skipped, instructions count: 233
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.AnonymousClass5.j(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final boolean k(int i22, View view) {
                BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                int i3 = bottomSheetBehavior.L;
                if (i3 == 1 || bottomSheetBehavior.L0) {
                    return false;
                }
                if (i3 == 3 && bottomSheetBehavior.J0 == i22) {
                    WeakReference weakReference = bottomSheetBehavior.F0;
                    View view2 = weakReference != null ? (View) weakReference.get() : null;
                    if (view2 != null && view2.canScrollVertically(-1)) {
                        return false;
                    }
                }
                System.currentTimeMillis();
                WeakReference weakReference2 = bottomSheetBehavior.D0;
                return weakReference2 != null && weakReference2.get() == view;
            }
        };
        this.f40014h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.f40016j = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.y = ShapeAppearanceModel.c(context, attributeSet, R.attr.bottomSheetStyle, P0).a();
        }
        ShapeAppearanceModel shapeAppearanceModel = this.y;
        if (shapeAppearanceModel != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
            this.f40015i = materialShapeDrawable;
            materialShapeDrawable.k(context);
            ColorStateList colorStateList = this.f40016j;
            if (colorStateList != null) {
                this.f40015i.m(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f40015i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(A(), 1.0f);
        this.B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.B.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.bottomsheet.BottomSheetBehavior.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                MaterialShapeDrawable materialShapeDrawable2 = BottomSheetBehavior.this.f40015i;
                if (materialShapeDrawable2 != null) {
                    materialShapeDrawable2.n(fFloatValue);
                }
            }
        });
        this.H = typedArrayObtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            this.f40017k = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            this.f40018l = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && (i2 = typedValuePeekValue.data) == -1) {
            S(i2);
        } else {
            S(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        R(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        this.n = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false);
        P(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        this.J = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true);
        this.f40007a = typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0);
        Q(typedArrayObtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (typedValuePeekValue2 != null && typedValuePeekValue2.type == 16) {
            O(typedValuePeekValue2.data);
        } else {
            O(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        }
        this.f40010d = typedArrayObtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500);
        this.o = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.p = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.q = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.r = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.s = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.t = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.u = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.x = typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        typedArrayObtainStyledAttributes.recycle();
        this.f40009c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void r(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4, int[] iArr) {
    }
}
