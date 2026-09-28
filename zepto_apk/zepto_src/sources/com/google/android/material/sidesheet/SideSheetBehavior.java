package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.sidesheet.SideSheetDialog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    public static final int x = R.string.side_sheet_accessibility_pane_title;
    public static final int y = R.style.Widget_Material3_SideSheet;

    /* renamed from: a, reason: collision with root package name */
    public SheetDelegate f41099a;

    /* renamed from: b, reason: collision with root package name */
    public final MaterialShapeDrawable f41100b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorStateList f41101c;

    /* renamed from: d, reason: collision with root package name */
    public final ShapeAppearanceModel f41102d;

    /* renamed from: e, reason: collision with root package name */
    public final StateSettlingTracker f41103e;

    /* renamed from: f, reason: collision with root package name */
    public final float f41104f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f41105g;

    /* renamed from: h, reason: collision with root package name */
    public int f41106h;

    /* renamed from: i, reason: collision with root package name */
    public ViewDragHelper f41107i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f41108j;

    /* renamed from: k, reason: collision with root package name */
    public final float f41109k;

    /* renamed from: l, reason: collision with root package name */
    public int f41110l;

    /* renamed from: m, reason: collision with root package name */
    public int f41111m;
    public int n;
    public int o;
    public WeakReference p;
    public WeakReference q;
    public final int r;
    public VelocityTracker s;
    public MaterialSideContainerBackHelper t;
    public int u;
    public final LinkedHashSet v;
    public final ViewDragHelper.Callback w;

    public class StateSettlingTracker {

        /* renamed from: a, reason: collision with root package name */
        public int f41115a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f41116b;

        /* renamed from: c, reason: collision with root package name */
        public final c f41117c = new Runnable() { // from class: com.google.android.material.sidesheet.c
            @Override // java.lang.Runnable
            public final void run() {
                SideSheetBehavior.StateSettlingTracker stateSettlingTracker = this.f41125a;
                stateSettlingTracker.f41116b = false;
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                ViewDragHelper viewDragHelper = sideSheetBehavior.f41107i;
                if (viewDragHelper != null && viewDragHelper.h()) {
                    stateSettlingTracker.a(stateSettlingTracker.f41115a);
                } else if (sideSheetBehavior.f41106h == 2) {
                    sideSheetBehavior.y(stateSettlingTracker.f41115a);
                }
            }
        };

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.android.material.sidesheet.c] */
        public StateSettlingTracker() {
        }

        public final void a(int i2) {
            SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
            WeakReference weakReference = sideSheetBehavior.p;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.f41115a = i2;
            if (this.f41116b) {
                return;
            }
            View view = (View) sideSheetBehavior.p.get();
            c cVar = this.f41117c;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            view.postOnAnimation(cVar);
            this.f41116b = true;
        }
    }

    public SideSheetBehavior() {
        this.f41103e = new StateSettlingTracker();
        this.f41105g = true;
        this.f41106h = 5;
        this.f41109k = 0.1f;
        this.r = -1;
        this.v = new LinkedHashSet();
        this.w = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int a(int i2, View view) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                return MathUtils.b(i2, sideSheetBehavior.f41099a.g(), sideSheetBehavior.f41099a.f());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int b(int i2, View view) {
                return view.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int c(View view) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                return sideSheetBehavior.f41110l + sideSheetBehavior.o;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void h(int i2) {
                if (i2 == 1) {
                    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                    if (sideSheetBehavior.f41105g) {
                        sideSheetBehavior.y(1);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void i(View view, int i2, int i3) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                WeakReference weakReference = sideSheetBehavior.q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f41099a.p(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.v;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f41099a.b(i2);
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((SheetCallback) it.next()).getClass();
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void j(android.view.View r3, float r4, float r5) {
                /*
                    r2 = this;
                    com.google.android.material.sidesheet.SideSheetBehavior r0 = com.google.android.material.sidesheet.SideSheetBehavior.this
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    boolean r1 = r1.k(r4)
                    if (r1 == 0) goto Lb
                    goto L53
                Lb:
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    boolean r1 = r1.n(r3, r4)
                    if (r1 == 0) goto L24
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    boolean r4 = r1.m(r4, r5)
                    if (r4 != 0) goto L55
                    com.google.android.material.sidesheet.SheetDelegate r4 = r0.f41099a
                    boolean r4 = r4.l(r3)
                    if (r4 == 0) goto L53
                    goto L55
                L24:
                    r1 = 0
                    int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                    if (r1 == 0) goto L36
                    float r4 = java.lang.Math.abs(r4)
                    float r5 = java.lang.Math.abs(r5)
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 <= 0) goto L36
                    goto L55
                L36:
                    int r4 = r3.getLeft()
                    com.google.android.material.sidesheet.SheetDelegate r5 = r0.f41099a
                    int r5 = r5.d()
                    int r5 = r4 - r5
                    int r5 = java.lang.Math.abs(r5)
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    int r1 = r1.e()
                    int r4 = r4 - r1
                    int r4 = java.lang.Math.abs(r4)
                    if (r5 >= r4) goto L55
                L53:
                    r4 = 3
                    goto L56
                L55:
                    r4 = 5
                L56:
                    r5 = 1
                    r0.A(r4, r3, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.AnonymousClass1.j(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final boolean k(int i2, View view) {
                WeakReference weakReference;
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                return (sideSheetBehavior.f41106h == 1 || (weakReference = sideSheetBehavior.p) == null || weakReference.get() != view) ? false : true;
            }
        };
    }

    public final void A(int i2, View view, boolean z) {
        int iD;
        if (i2 == 3) {
            iD = this.f41099a.d();
        } else {
            if (i2 != 5) {
                throw new IllegalArgumentException(android.support.v4.media.b.f(i2, "Invalid state to get outer edge offset: "));
            }
            iD = this.f41099a.e();
        }
        ViewDragHelper viewDragHelper = this.f41107i;
        if (viewDragHelper == null || (!z ? viewDragHelper.A(view, iD, view.getTop()) : viewDragHelper.y(iD, view.getTop()))) {
            y(i2);
        } else {
            y(2);
            this.f41103e.a(i2);
        }
    }

    public final void B() {
        View view;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        ViewCompat.v(262144, view);
        ViewCompat.s(0, view);
        ViewCompat.v(1048576, view);
        ViewCompat.s(0, view);
        int i2 = 5;
        if (this.f41106h != 5) {
            ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3195m, null, new androidx.media3.exoplayer.analytics.b(i2, 7, this));
        }
        int i3 = 3;
        if (this.f41106h != 3) {
            ViewCompat.w(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3193k, null, new androidx.media3.exoplayer.analytics.b(i3, 7, this));
        }
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final void a(SideSheetDialog.AnonymousClass1 anonymousClass1) {
        this.v.add(anonymousClass1);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void b() {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.t;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.b();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void c(BackEventCompat backEventCompat) {
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.t;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        materialSideContainerBackHelper.f40671f = backEventCompat;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void d(BackEventCompat backEventCompat) {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.t;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        SheetDelegate sheetDelegate = this.f41099a;
        int i2 = (sheetDelegate == null || sheetDelegate.j() == 0) ? 5 : 3;
        if (materialSideContainerBackHelper.f40671f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = materialSideContainerBackHelper.f40671f;
        materialSideContainerBackHelper.f40671f = backEventCompat;
        if (backEventCompat2 != null) {
            materialSideContainerBackHelper.d(backEventCompat.f120c, i2, backEventCompat.f121d == 0);
        }
        WeakReference weakReference = this.p;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        View view = (View) this.p.get();
        WeakReference weakReference2 = this.q;
        View view2 = weakReference2 != null ? (View) weakReference2.get() : null;
        if (view2 == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) == null) {
            return;
        }
        this.f41099a.o(marginLayoutParams, (int) ((view.getScaleX() * this.f41110l) + this.o));
        view2.requestLayout();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void e() {
        final ViewGroup.MarginLayoutParams marginLayoutParams;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.t;
        if (materialSideContainerBackHelper == null) {
            return;
        }
        BackEventCompat backEventCompat = materialSideContainerBackHelper.f40671f;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = null;
        materialSideContainerBackHelper.f40671f = null;
        int i2 = 5;
        if (backEventCompat == null || Build.VERSION.SDK_INT < 34) {
            f(5);
            return;
        }
        SheetDelegate sheetDelegate = this.f41099a;
        if (sheetDelegate != null && sheetDelegate.j() != 0) {
            i2 = 3;
        }
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                sideSheetBehavior.y(5);
                WeakReference weakReference = sideSheetBehavior.p;
                if (weakReference == null || weakReference.get() == null) {
                    return;
                }
                ((View) sideSheetBehavior.p.get()).requestLayout();
            }
        };
        WeakReference weakReference = this.q;
        final View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams()) != null) {
            final int iC = this.f41099a.c(marginLayoutParams);
            animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.sidesheet.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.f41121a.f41099a.o(marginLayoutParams, AnimationUtils.c(valueAnimator.getAnimatedFraction(), iC, 0));
                    view.requestLayout();
                }
            };
        }
        materialSideContainerBackHelper.c(backEventCompat, i2, animatorListenerAdapter, animatorUpdateListener);
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final void f(int i2) {
        int i3 = 2;
        if (i2 == 1 || i2 == 2) {
            throw new IllegalArgumentException(android.support.v4.media.b.r(new StringBuilder("STATE_"), i2 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        WeakReference weakReference = this.p;
        if (weakReference == null || weakReference.get() == null) {
            y(i2);
            return;
        }
        View view = (View) this.p.get();
        com.facebook.react.uimanager.b bVar = new com.facebook.react.uimanager.b(i2, i3, this);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (view.isAttachedToWindow()) {
                view.post(bVar);
                return;
            }
        }
        bVar.run();
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public final int getState() {
        return this.f41106h;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void i(CoordinatorLayout.LayoutParams layoutParams) {
        this.p = null;
        this.f41107i = null;
        this.t = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void l() {
        this.p = null;
        this.f41107i = null;
        this.t = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean m(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && ViewCompat.f(view) == null) || !this.f41105g) {
            this.f41108j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.s) != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.u = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.f41108j) {
            this.f41108j = false;
            return false;
        }
        return (this.f41108j || (viewDragHelper = this.f41107i) == null || !viewDragHelper.z(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean n(CoordinatorLayout coordinatorLayout, View view, int i2) {
        View view2;
        View view3;
        int i3;
        View viewFindViewById;
        MaterialShapeDrawable materialShapeDrawable = this.f41100b;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        int iH = 0;
        if (this.p == null) {
            this.p = new WeakReference(view);
            this.t = new MaterialSideContainerBackHelper(view);
            if (materialShapeDrawable != null) {
                view.setBackground(materialShapeDrawable);
                float fJ = this.f41104f;
                if (fJ == -1.0f) {
                    fJ = ViewCompat.j(view);
                }
                materialShapeDrawable.l(fJ);
            } else {
                ColorStateList colorStateList = this.f41101c;
                if (colorStateList != null) {
                    ViewCompat.C(view, colorStateList);
                }
            }
            int i4 = this.f41106h == 5 ? 4 : 0;
            if (view.getVisibility() != i4) {
                view.setVisibility(i4);
            }
            B();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (ViewCompat.f(view) == null) {
                ViewCompat.B(view, view.getResources().getString(x));
            }
        }
        int i5 = Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) view.getLayoutParams()).f2562c, i2) == 3 ? 1 : 0;
        SheetDelegate sheetDelegate = this.f41099a;
        if (sheetDelegate == null || sheetDelegate.j() != i5) {
            ShapeAppearanceModel shapeAppearanceModel = this.f41102d;
            CoordinatorLayout.LayoutParams layoutParams = null;
            if (i5 == 0) {
                this.f41099a = new RightSheetDelegate(this);
                if (shapeAppearanceModel != null) {
                    WeakReference weakReference = this.p;
                    if (weakReference != null && (view3 = (View) weakReference.get()) != null && (view3.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view3.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin <= 0) {
                        ShapeAppearanceModel.Builder builderG = shapeAppearanceModel.g();
                        builderG.k(0.0f);
                        builderG.e(0.0f);
                        ShapeAppearanceModel shapeAppearanceModelA = builderG.a();
                        if (materialShapeDrawable != null) {
                            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelA);
                        }
                    }
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalArgumentException(android.support.v4.media.b.g(i5, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.f41099a = new LeftSheetDelegate(this);
                if (shapeAppearanceModel != null) {
                    WeakReference weakReference2 = this.p;
                    if (weakReference2 != null && (view2 = (View) weakReference2.get()) != null && (view2.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
                        layoutParams = (CoordinatorLayout.LayoutParams) view2.getLayoutParams();
                    }
                    if (layoutParams == null || ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin <= 0) {
                        ShapeAppearanceModel.Builder builderG2 = shapeAppearanceModel.g();
                        builderG2.h(0.0f);
                        builderG2.d(0.0f);
                        ShapeAppearanceModel shapeAppearanceModelA2 = builderG2.a();
                        if (materialShapeDrawable != null) {
                            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelA2);
                        }
                    }
                }
            }
        }
        if (this.f41107i == null) {
            this.f41107i = new ViewDragHelper(coordinatorLayout.getContext(), coordinatorLayout, this.w);
        }
        int iH2 = this.f41099a.h(view);
        coordinatorLayout.v(i2, view);
        this.f41111m = coordinatorLayout.getWidth();
        this.n = this.f41099a.i(coordinatorLayout);
        this.f41110l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.o = marginLayoutParams != null ? this.f41099a.a(marginLayoutParams) : 0;
        int i6 = this.f41106h;
        if (i6 == 1 || i6 == 2) {
            iH = iH2 - this.f41099a.h(view);
        } else if (i6 != 3) {
            if (i6 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.f41106h);
            }
            iH = this.f41099a.e();
        }
        view.offsetLeftAndRight(iH);
        if (this.q == null && (i3 = this.r) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i3)) != null) {
            this.q = new WeakReference(viewFindViewById);
        }
        for (SheetCallback sheetCallback : this.v) {
            if (sheetCallback instanceof SideSheetCallback) {
                ((SideSheetCallback) sheetCallback).getClass();
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean o(CoordinatorLayout coordinatorLayout, View view, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i2, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final void t(View view, Parcelable parcelable) {
        int i2 = ((SavedState) parcelable).f41114c;
        if (i2 == 1 || i2 == 2) {
            i2 = 5;
        }
        this.f41106h = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final Parcelable u(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new SavedState(this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public final boolean x(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f41106h == 1 && actionMasked == 0) {
            return true;
        }
        if (z()) {
            this.f41107i.p(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.s) != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        if (z() && actionMasked == 2 && !this.f41108j && z()) {
            float fAbs = Math.abs(this.u - motionEvent.getX());
            ViewDragHelper viewDragHelper = this.f41107i;
            if (fAbs > viewDragHelper.f3341b) {
                viewDragHelper.b(motionEvent.getPointerId(motionEvent.getActionIndex()), view);
            }
        }
        return !this.f41108j;
    }

    public final void y(int i2) {
        View view;
        if (this.f41106h == i2) {
            return;
        }
        this.f41106h = i2;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i3 = this.f41106h == 5 ? 4 : 0;
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            ((SheetCallback) it.next()).a(i2);
        }
        B();
    }

    public final boolean z() {
        if (this.f41107i != null) {
            return this.f41105g || this.f41106h == 1;
        }
        return false;
    }

    public static class SavedState extends androidx.customview.view.AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public final int f41114c;

        /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$SavedState$1, reason: invalid class name */
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
            this.f41114c = parcel.readInt();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f41114c);
        }

        public SavedState(SideSheetBehavior sideSheetBehavior) {
            super(AbsSavedState.EMPTY_STATE);
            this.f41114c = sideSheetBehavior.f41106h;
        }
    }

    public SideSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41103e = new StateSettlingTracker();
        this.f41105g = true;
        this.f41106h = 5;
        this.f41109k = 0.1f;
        this.r = -1;
        this.v = new LinkedHashSet();
        this.w = new ViewDragHelper.Callback() { // from class: com.google.android.material.sidesheet.SideSheetBehavior.1
            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int a(int i2, View view) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                return MathUtils.b(i2, sideSheetBehavior.f41099a.g(), sideSheetBehavior.f41099a.f());
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int b(int i2, View view) {
                return view.getTop();
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final int c(View view) {
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                return sideSheetBehavior.f41110l + sideSheetBehavior.o;
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void h(int i2) {
                if (i2 == 1) {
                    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                    if (sideSheetBehavior.f41105g) {
                        sideSheetBehavior.y(1);
                    }
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void i(View view, int i2, int i3) {
                ViewGroup.MarginLayoutParams marginLayoutParams;
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                WeakReference weakReference = sideSheetBehavior.q;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) view2.getLayoutParams()) != null) {
                    sideSheetBehavior.f41099a.p(marginLayoutParams, view.getLeft(), view.getRight());
                    view2.setLayoutParams(marginLayoutParams);
                }
                LinkedHashSet linkedHashSet = sideSheetBehavior.v;
                if (linkedHashSet.isEmpty()) {
                    return;
                }
                sideSheetBehavior.f41099a.b(i2);
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    ((SheetCallback) it.next()).getClass();
                }
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final void j(View v, float v2, float v3) {
                /*
                    this = this;
                    com.google.android.material.sidesheet.SideSheetBehavior r0 = com.google.android.material.sidesheet.SideSheetBehavior.this
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    boolean r1 = r1.k(r4)
                    if (r1 == 0) goto Lb
                    goto L53
                Lb:
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    boolean r1 = r1.n(r3, r4)
                    if (r1 == 0) goto L24
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    boolean r4 = r1.m(r4, r5)
                    if (r4 != 0) goto L55
                    com.google.android.material.sidesheet.SheetDelegate r4 = r0.f41099a
                    boolean r4 = r4.l(r3)
                    if (r4 == 0) goto L53
                    goto L55
                L24:
                    r1 = 0
                    int r1 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
                    if (r1 == 0) goto L36
                    float r4 = java.lang.Math.abs(r4)
                    float r5 = java.lang.Math.abs(r5)
                    int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
                    if (r4 <= 0) goto L36
                    goto L55
                L36:
                    int r4 = r3.getLeft()
                    com.google.android.material.sidesheet.SheetDelegate r5 = r0.f41099a
                    int r5 = r5.d()
                    int r5 = r4 - r5
                    int r5 = java.lang.Math.abs(r5)
                    com.google.android.material.sidesheet.SheetDelegate r1 = r0.f41099a
                    int r1 = r1.e()
                    int r4 = r4 - r1
                    int r4 = java.lang.Math.abs(r4)
                    if (r5 >= r4) goto L55
                L53:
                    r4 = 3
                    goto L56
                L55:
                    r4 = 5
                L56:
                    r5 = 1
                    r0.A(r4, r3, r5)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.AnonymousClass1.j(android.view.View, float, float):void");
            }

            @Override // androidx.customview.widget.ViewDragHelper.Callback
            public final boolean k(int i2, View view) {
                WeakReference weakReference;
                SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                return (sideSheetBehavior.f41106h == 1 || (weakReference = sideSheetBehavior.p) == null || weakReference.get() != view) ? false : true;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SideSheetBehavior_Layout);
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_backgroundTint)) {
            this.f41101c = MaterialResources.a(context, typedArrayObtainStyledAttributes, R.styleable.SideSheetBehavior_Layout_backgroundTint);
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.f41102d = ShapeAppearanceModel.c(context, attributeSet, 0, y).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, -1);
            this.r = resourceId;
            WeakReference weakReference = this.q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.q = null;
            WeakReference weakReference2 = this.p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    if (view.isLaidOut()) {
                        view.requestLayout();
                    }
                }
            }
        }
        ShapeAppearanceModel shapeAppearanceModel = this.f41102d;
        if (shapeAppearanceModel != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
            this.f41100b = materialShapeDrawable;
            materialShapeDrawable.k(context);
            ColorStateList colorStateList = this.f41101c;
            if (colorStateList != null) {
                this.f41100b.m(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.f41100b.setTint(typedValue.data);
            }
        }
        this.f41104f = typedArrayObtainStyledAttributes.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        this.f41105g = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
