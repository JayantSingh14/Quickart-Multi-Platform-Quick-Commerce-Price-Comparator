package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ListView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChild2;
import androidx.core.view.NestedScrollingChild3;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ListViewCompat;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements NestedScrollingParent3, NestedScrollingParent2, NestedScrollingChild3, NestedScrollingChild2, NestedScrollingParent, NestedScrollingChild {
    public static final int[] M = {R.attr.enabled};
    public Animation A;
    public Animation B;
    public Animation C;
    public Animation D;
    public boolean E;
    public int F;
    public boolean G;
    public OnChildScrollUpCallback H;
    public boolean I;
    public final Animation.AnimationListener J;
    public final Animation K;
    public final Animation L;

    /* renamed from: a, reason: collision with root package name */
    public View f11978a;

    /* renamed from: b, reason: collision with root package name */
    public OnRefreshListener f11979b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11980c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11981d;

    /* renamed from: e, reason: collision with root package name */
    public float f11982e;

    /* renamed from: f, reason: collision with root package name */
    public float f11983f;

    /* renamed from: g, reason: collision with root package name */
    public final NestedScrollingParentHelper f11984g;

    /* renamed from: h, reason: collision with root package name */
    public final NestedScrollingChildHelper f11985h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f11986i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f11987j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f11988k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11989l;

    /* renamed from: m, reason: collision with root package name */
    public final int f11990m;
    public int n;
    public float o;
    public float p;
    public boolean q;
    public int r;
    public final DecelerateInterpolator s;
    public final CircleImageView t;
    public int u;
    public int v;
    public int w;
    public int x;
    public int y;
    public final CircularProgressDrawable z;

    /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$8, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass8 extends Animation {
        @Override // android.view.animation.Animation
        public final void applyTransformation(float f2, Transformation transformation) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public interface OnChildScrollUpCallback {
        boolean a();
    }

    /* loaded from: classes3.dex */
    public interface OnRefreshListener {
        void b();
    }

    public SwipeRefreshLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11980c = false;
        this.f11982e = -1.0f;
        this.f11986i = new int[2];
        this.f11987j = new int[2];
        this.f11988k = new int[2];
        this.r = -1;
        this.u = -1;
        this.J = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                OnRefreshListener onRefreshListener;
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                if (!swipeRefreshLayout.f11980c) {
                    swipeRefreshLayout.f();
                    return;
                }
                swipeRefreshLayout.z.setAlpha(255);
                swipeRefreshLayout.z.start();
                if (swipeRefreshLayout.E && (onRefreshListener = swipeRefreshLayout.f11979b) != null) {
                    onRefreshListener.b();
                }
                swipeRefreshLayout.n = swipeRefreshLayout.t.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }
        };
        this.K = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                int iAbs = !swipeRefreshLayout.G ? swipeRefreshLayout.x - Math.abs(swipeRefreshLayout.w) : swipeRefreshLayout.x;
                swipeRefreshLayout.setTargetOffsetTopAndBottom((swipeRefreshLayout.v + ((int) ((iAbs - r1) * f2))) - swipeRefreshLayout.t.getTop());
                swipeRefreshLayout.z.c(1.0f - f2);
            }
        };
        this.L = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.7
            @Override // android.view.animation.Animation
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.e(f2);
            }
        };
        this.f11981d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f11990m = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.s = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.F = (int) (displayMetrics.density * 40.0f);
        this.t = new CircleImageView(getContext());
        CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(getContext());
        this.z = circularProgressDrawable;
        circularProgressDrawable.h(1);
        this.t.setImageDrawable(this.z);
        this.t.setVisibility(8);
        addView(this.t);
        setChildrenDrawingOrderEnabled(true);
        int i2 = (int) (displayMetrics.density * 64.0f);
        this.x = i2;
        this.f11982e = i2;
        this.f11984g = new NestedScrollingParentHelper();
        this.f11985h = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i3 = -this.F;
        this.n = i3;
        this.w = i3;
        e(1.0f);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, M);
        setEnabled(typedArrayObtainStyledAttributes.getBoolean(0, true));
        typedArrayObtainStyledAttributes.recycle();
    }

    private void setColorViewAlpha(int i2) {
        this.t.getBackground().setAlpha(i2);
        this.z.setAlpha(i2);
    }

    public boolean a() {
        OnChildScrollUpCallback onChildScrollUpCallback = this.H;
        if (onChildScrollUpCallback != null) {
            return onChildScrollUpCallback.a();
        }
        View view = this.f11978a;
        return view instanceof ListView ? ListViewCompat.a((ListView) view) : view.canScrollVertically(-1);
    }

    public final void b() {
        if (this.f11978a == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (!childAt.equals(this.t)) {
                    this.f11978a = childAt;
                    return;
                }
            }
        }
    }

    public final void c(float f2) {
        if (f2 > this.f11982e) {
            g(true, true);
            return;
        }
        this.f11980c = false;
        this.z.g(0.0f);
        Animation.AnimationListener animationListener = new Animation.AnimationListener() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.5
            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationEnd(Animation animation) {
                SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
                swipeRefreshLayout.getClass();
                swipeRefreshLayout.l(null);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public final void onAnimationStart(Animation animation) {
            }
        };
        this.v = this.n;
        Animation animation = this.L;
        animation.reset();
        animation.setDuration(200L);
        animation.setInterpolator(this.s);
        this.t.a(animationListener);
        this.t.clearAnimation();
        this.t.startAnimation(animation);
        this.z.b(false);
    }

    public final void d(float f2) {
        Animation animation;
        Animation animation2;
        this.z.b(true);
        float fMin = Math.min(1.0f, Math.abs(f2 / this.f11982e));
        float fMax = (((float) Math.max(fMin - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f2) - this.f11982e;
        int i2 = this.y;
        if (i2 <= 0) {
            i2 = this.G ? this.x - this.w : this.x;
        }
        float f3 = i2;
        double dMax = Math.max(0.0f, Math.min(fAbs, f3 * 2.0f) / f3) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i3 = this.w + ((int) ((f3 * fMin) + (f3 * fPow * 2.0f)));
        if (this.t.getVisibility() != 0) {
            this.t.setVisibility(0);
        }
        this.t.setScaleX(1.0f);
        this.t.setScaleY(1.0f);
        if (f2 < this.f11982e) {
            final int i4 = 76;
            if (this.z.getAlpha() > 76 && ((animation2 = this.C) == null || !animation2.hasStarted() || animation2.hasEnded())) {
                final int alpha = this.z.getAlpha();
                Animation animation3 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
                    @Override // android.view.animation.Animation
                    public final void applyTransformation(float f4, Transformation transformation) {
                        SwipeRefreshLayout.this.z.setAlpha((int) (((i4 - r0) * f4) + alpha));
                    }
                };
                animation3.setDuration(300L);
                this.t.a(null);
                this.t.clearAnimation();
                this.t.startAnimation(animation3);
                this.C = animation3;
            }
        } else {
            final int i5 = 255;
            if (this.z.getAlpha() < 255 && ((animation = this.D) == null || !animation.hasStarted() || animation.hasEnded())) {
                final int alpha2 = this.z.getAlpha();
                Animation animation4 = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.4
                    @Override // android.view.animation.Animation
                    public final void applyTransformation(float f4, Transformation transformation) {
                        SwipeRefreshLayout.this.z.setAlpha((int) (((i5 - r0) * f4) + alpha2));
                    }
                };
                animation4.setDuration(300L);
                this.t.a(null);
                this.t.clearAnimation();
                this.t.startAnimation(animation4);
                this.D = animation4;
            }
        }
        this.z.g(Math.min(0.8f, fMax * 0.8f));
        this.z.c(Math.min(1.0f, fMax));
        this.z.e(((fPow * 2.0f) + ((fMax * 0.4f) - 0.25f)) * 0.5f);
        setTargetOffsetTopAndBottom(i3 - this.n);
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.f11985h.a(f2, f3, z);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f2, float f3) {
        return this.f11985h.b(f2, f3);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return this.f11985h.d(i2, i3, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return this.f11985h.f(i2, i3, i4, i5, iArr);
    }

    public final void e(float f2) {
        setTargetOffsetTopAndBottom((this.v + ((int) ((this.w - r0) * f2))) - this.t.getTop());
    }

    public final void f() {
        this.t.clearAnimation();
        this.z.stop();
        this.t.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.w - this.n);
        this.n = this.t.getTop();
    }

    public final void g(boolean z, boolean z2) {
        if (this.f11980c != z) {
            this.E = z2;
            b();
            this.f11980c = z;
            Animation.AnimationListener animationListener = this.J;
            if (!z) {
                l(animationListener);
                return;
            }
            this.v = this.n;
            Animation animation = this.K;
            animation.reset();
            animation.setDuration(200L);
            animation.setInterpolator(this.s);
            if (animationListener != null) {
                this.t.a(animationListener);
            }
            this.t.clearAnimation();
            this.t.startAnimation(animation);
        }
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        int i4 = this.u;
        return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.f11984g.a();
    }

    public int getProgressCircleDiameter() {
        return this.F;
    }

    public int getProgressViewEndOffset() {
        return this.x;
    }

    public int getProgressViewStartOffset() {
        return this.w;
    }

    public final void h(float f2) {
        float f3 = this.p;
        float f4 = f2 - f3;
        float f5 = this.f11981d;
        if (f4 <= f5 || this.q) {
            return;
        }
        this.o = f3 + f5;
        this.q = true;
        this.z.setAlpha(76);
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.f11985h.i();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void i(int i2, View view) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.f11985h.k();
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void j(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void k(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    public final void l(Animation.AnimationListener animationListener) {
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.3
            @Override // android.view.animation.Animation
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(1.0f - f2);
            }
        };
        this.B = animation;
        animation.setDuration(150L);
        this.t.a(animationListener);
        this.t.clearAnimation();
        this.t.startAnimation(this.B);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public final void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 != 0) {
            return;
        }
        int i7 = iArr[1];
        if (i6 == 0) {
            this.f11985h.e(i2, i3, i4, i5, this.f11987j, i6, iArr);
        }
        int i8 = i5 - (iArr[1] - i7);
        if ((i8 == 0 ? i5 + this.f11987j[1] : i8) >= 0 || a()) {
            return;
        }
        float fAbs = this.f11983f + Math.abs(r14);
        this.f11983f = fAbs;
        d(fAbs);
        iArr[1] = iArr[1] + i8;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final void n(View view, int i2, int i3, int i4, int i5, int i6) {
        m(view, i2, i3, i4, i5, i6, this.f11988k);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public final boolean o(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            return onStartNestedScroll(view, view2, i2);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r5.b()
            int r0 = r6.getActionMasked()
            boolean r1 = r5.isEnabled()
            r2 = 0
            if (r1 == 0) goto L88
            boolean r1 = r5.a()
            if (r1 != 0) goto L88
            boolean r1 = r5.f11980c
            if (r1 != 0) goto L88
            boolean r1 = r5.f11989l
            if (r1 == 0) goto L1e
            goto L88
        L1e:
            if (r0 == 0) goto L64
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L5f
            r4 = 2
            if (r0 == r4) goto L44
            r4 = 3
            if (r0 == r4) goto L5f
            r3 = 6
            if (r0 == r3) goto L2e
            goto L85
        L2e:
            int r0 = r6.getActionIndex()
            int r3 = r6.getPointerId(r0)
            int r4 = r5.r
            if (r3 != r4) goto L85
            if (r0 != 0) goto L3d
            r2 = r1
        L3d:
            int r6 = r6.getPointerId(r2)
            r5.r = r6
            goto L85
        L44:
            int r0 = r5.r
            if (r0 != r3) goto L50
            java.lang.String r6 = "SwipeRefreshLayout"
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r6, r0)
            return r2
        L50:
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L57
            goto L88
        L57:
            float r6 = r6.getY(r0)
            r5.h(r6)
            goto L85
        L5f:
            r5.q = r2
            r5.r = r3
            goto L85
        L64:
            int r0 = r5.w
            androidx.swiperefreshlayout.widget.CircleImageView r1 = r5.t
            int r1 = r1.getTop()
            int r0 = r0 - r1
            r5.setTargetOffsetTopAndBottom(r0)
            int r0 = r6.getPointerId(r2)
            r5.r = r0
            r5.q = r2
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L7f
            goto L88
        L7f:
            float r6 = r6.getY(r0)
            r5.p = r6
        L85:
            boolean r6 = r5.q
            return r6
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f11978a == null) {
            b();
        }
        View view = this.f11978a;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.t.getMeasuredWidth();
        int measuredHeight2 = this.t.getMeasuredHeight();
        int i6 = measuredWidth / 2;
        int i7 = measuredWidth2 / 2;
        int i8 = this.n;
        this.t.layout(i6 - i7, i8, i6 + i7, measuredHeight2 + i8);
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.f11978a == null) {
            b();
        }
        View view = this.f11978a;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.t.measure(View.MeasureSpec.makeMeasureSpec(this.F, 1073741824), View.MeasureSpec.makeMeasureSpec(this.F, 1073741824));
        this.u = -1;
        for (int i4 = 0; i4 < getChildCount(); i4++) {
            if (getChildAt(i4) == this.t) {
                this.u = i4;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f2, float f3, boolean z) {
        return this.f11985h.a(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f2, float f3) {
        return this.f11985h.b(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
        if (i3 > 0) {
            float f2 = this.f11983f;
            if (f2 > 0.0f) {
                float f3 = i3;
                if (f3 > f2) {
                    iArr[1] = (int) f2;
                    this.f11983f = 0.0f;
                } else {
                    this.f11983f = f2 - f3;
                    iArr[1] = i3;
                }
                d(this.f11983f);
            }
        }
        if (this.G && i3 > 0 && this.f11983f == 0.0f && Math.abs(i3 - iArr[1]) > 0) {
            this.t.setVisibility(8);
        }
        int i4 = i2 - iArr[0];
        int i5 = i3 - iArr[1];
        NestedScrollingChildHelper nestedScrollingChildHelper = this.f11985h;
        int[] iArr2 = this.f11986i;
        if (nestedScrollingChildHelper.d(i4, i5, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        m(view, i2, i3, i4, i5, 0, this.f11988k);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i2) {
        this.f11984g.b(i2);
        startNestedScroll(i2 & 2);
        this.f11983f = 0.0f;
        this.f11989l = true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setRefreshing(savedState.f12000a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), this.f11980c);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i2) {
        return (!isEnabled() || this.f11980c || (i2 & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.f11984g.c();
        this.f11989l = false;
        float f2 = this.f11983f;
        if (f2 > 0.0f) {
            c(f2);
            this.f11983f = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !a() && !this.f11980c && !this.f11989l) {
            if (actionMasked == 0) {
                this.r = motionEvent.getPointerId(0);
                this.q = false;
                return true;
            }
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.r);
                if (iFindPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.q) {
                    float y = (motionEvent.getY(iFindPointerIndex) - this.o) * 0.5f;
                    this.q = false;
                    c(y);
                }
                this.r = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.r);
                if (iFindPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y2 = motionEvent.getY(iFindPointerIndex2);
                h(y2);
                if (this.q) {
                    float f2 = (y2 - this.o) * 0.5f;
                    if (f2 > 0.0f) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        d(f2);
                    }
                }
                return true;
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.r) {
                            this.r = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                            return true;
                        }
                    }
                    return true;
                }
                int actionIndex2 = motionEvent.getActionIndex();
                if (actionIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.r = motionEvent.getPointerId(actionIndex2);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        ViewParent parent;
        View view = this.f11978a;
        if (view == null || ViewCompat.r(view)) {
            super.requestDisallowInterceptTouchEvent(z);
        } else {
            if (this.I || (parent = getParent()) == null) {
                return;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    public void setAnimationProgress(float f2) {
        this.t.setScaleX(f2);
        this.t.setScaleY(f2);
    }

    @Deprecated
    public void setColorScheme(@ColorRes int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(@ColorInt int... iArr) {
        b();
        this.z.d(iArr);
    }

    public void setColorSchemeResources(@ColorRes int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = context.getColor(iArr[i2]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i2) {
        this.f11982e = i2;
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (z) {
            return;
        }
        f();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z) {
        this.I = z;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.f11985h.l(z);
    }

    public void setOnChildScrollUpCallback(@Nullable OnChildScrollUpCallback onChildScrollUpCallback) {
        this.H = onChildScrollUpCallback;
    }

    public void setOnRefreshListener(@Nullable OnRefreshListener onRefreshListener) {
        this.f11979b = onRefreshListener;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i2) {
        setProgressBackgroundColorSchemeResource(i2);
    }

    public void setProgressBackgroundColorSchemeColor(@ColorInt int i2) {
        this.t.setBackgroundColor(i2);
    }

    public void setProgressBackgroundColorSchemeResource(@ColorRes int i2) {
        setProgressBackgroundColorSchemeColor(getContext().getColor(i2));
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f11980c == z) {
            g(z, false);
            return;
        }
        this.f11980c = z;
        setTargetOffsetTopAndBottom((!this.G ? this.x + this.w : this.x) - this.n);
        this.E = false;
        Animation.AnimationListener animationListener = this.J;
        this.t.setVisibility(0);
        this.z.setAlpha(255);
        Animation animation = new Animation() { // from class: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public final void applyTransformation(float f2, Transformation transformation) {
                SwipeRefreshLayout.this.setAnimationProgress(f2);
            }
        };
        this.A = animation;
        animation.setDuration(this.f11990m);
        if (animationListener != null) {
            this.t.a(animationListener);
        }
        this.t.clearAnimation();
        this.t.startAnimation(this.A);
    }

    public void setSize(int i2) {
        if (i2 == 0 || i2 == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i2 == 0) {
                this.F = (int) (displayMetrics.density * 56.0f);
            } else {
                this.F = (int) (displayMetrics.density * 40.0f);
            }
            this.t.setImageDrawable(null);
            this.z.h(i2);
            this.t.setImageDrawable(this.z);
        }
    }

    public void setSlingshotDistance(@Px int i2) {
        this.y = i2;
    }

    public void setTargetOffsetTopAndBottom(int i2) {
        CircleImageView circleImageView = this.t;
        circleImageView.bringToFront();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        circleImageView.offsetTopAndBottom(i2);
        this.n = circleImageView.getTop();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i2) {
        return this.f11985h.m(i2);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.f11985h.o();
    }

    /* loaded from: classes3.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public final boolean f12000a;

        /* renamed from: androidx.swiperefreshlayout.widget.SwipeRefreshLayout$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable, boolean z) {
            super(parcelable);
            this.f12000a = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeByte(this.f12000a ? (byte) 1 : (byte) 0);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f12000a = parcel.readByte() != 0;
        }
    }
}
