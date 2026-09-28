package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.media.b;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.graphics.ColorUtils;
import androidx.core.math.MathUtils;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.carousel.KeylineState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class CarouselLayoutManager extends RecyclerView.LayoutManager implements Carousel, RecyclerView.SmoothScroller.ScrollVectorProvider {
    public int A;
    public int B;
    public final int C;
    public int p;
    public int q;
    public int r;
    public final DebugItemDecoration s;
    public final MultiBrowseCarouselStrategy t;
    public KeylineStateList u;
    public KeylineState v;
    public int w;
    public HashMap x;
    public CarouselOrientationHelper y;
    public final View.OnLayoutChangeListener z;

    public static final class ChildCalculations {

        /* renamed from: a, reason: collision with root package name */
        public final View f40146a;

        /* renamed from: b, reason: collision with root package name */
        public final float f40147b;

        /* renamed from: c, reason: collision with root package name */
        public final float f40148c;

        /* renamed from: d, reason: collision with root package name */
        public final KeylineRange f40149d;

        public ChildCalculations(View view, float f2, float f3, KeylineRange keylineRange) {
            this.f40146a = view;
            this.f40147b = f2;
            this.f40148c = f3;
            this.f40149d = keylineRange;
        }
    }

    public static class DebugItemDecoration extends RecyclerView.ItemDecoration {

        /* renamed from: a, reason: collision with root package name */
        public final Paint f40150a;

        /* renamed from: b, reason: collision with root package name */
        public List f40151b;

        public DebugItemDecoration() {
            Paint paint = new Paint();
            this.f40150a = paint;
            this.f40151b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public final void h(Canvas canvas, RecyclerView recyclerView) {
            Canvas canvas2;
            Paint paint = this.f40150a;
            paint.setStrokeWidth(recyclerView.getResources().getDimension(R.dimen.m3_carousel_debug_keyline_width));
            for (KeylineState.Keyline keyline : this.f40151b) {
                paint.setColor(ColorUtils.d(keyline.f40175c, -65281, -16776961));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).V0()) {
                    float fI = ((CarouselLayoutManager) recyclerView.getLayoutManager()).y.i();
                    float fD = ((CarouselLayoutManager) recyclerView.getLayoutManager()).y.d();
                    float f2 = keyline.f40174b;
                    canvas2 = canvas;
                    canvas2.drawLine(f2, fI, f2, fD, paint);
                } else {
                    float f3 = ((CarouselLayoutManager) recyclerView.getLayoutManager()).y.f();
                    float fG = ((CarouselLayoutManager) recyclerView.getLayoutManager()).y.g();
                    float f4 = keyline.f40174b;
                    canvas2 = canvas;
                    canvas2.drawLine(f3, f4, fG, f4, paint);
                }
                canvas = canvas2;
            }
        }
    }

    public static class KeylineRange {

        /* renamed from: a, reason: collision with root package name */
        public final KeylineState.Keyline f40152a;

        /* renamed from: b, reason: collision with root package name */
        public final KeylineState.Keyline f40153b;

        public KeylineRange(KeylineState.Keyline keyline, KeylineState.Keyline keyline2) {
            if (keyline.f40173a > keyline2.f40173a) {
                throw new IllegalArgumentException();
            }
            this.f40152a = keyline;
            this.f40153b = keyline2;
        }
    }

    public static class LayoutDirection {
    }

    public CarouselLayoutManager() {
        MultiBrowseCarouselStrategy multiBrowseCarouselStrategy = new MultiBrowseCarouselStrategy();
        this.s = new DebugItemDecoration();
        this.w = 0;
        this.z = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                CarouselLayoutManager carouselLayoutManager = this.f40198a;
                if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
                    return;
                }
                view.post(new androidx.constraintlayout.helper.widget.a(carouselLayoutManager, 20));
            }
        };
        this.B = -1;
        this.C = 0;
        this.t = multiBrowseCarouselStrategy;
        c1();
        e1(0);
    }

    public static KeylineRange U0(List list, float f2, boolean z) {
        float f3 = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        int i5 = -1;
        float f4 = -3.4028235E38f;
        float f5 = Float.MAX_VALUE;
        float f6 = Float.MAX_VALUE;
        for (int i6 = 0; i6 < list.size(); i6++) {
            KeylineState.Keyline keyline = (KeylineState.Keyline) list.get(i6);
            float f7 = z ? keyline.f40174b : keyline.f40173a;
            float fAbs = Math.abs(f7 - f2);
            if (f7 <= f2 && fAbs <= f3) {
                i2 = i6;
                f3 = fAbs;
            }
            if (f7 > f2 && fAbs <= f5) {
                i4 = i6;
                f5 = fAbs;
            }
            if (f7 <= f6) {
                i3 = i6;
                f6 = f7;
            }
            if (f7 > f4) {
                i5 = i6;
                f4 = f7;
            }
        }
        if (i2 == -1) {
            i2 = i3;
        }
        if (i4 == -1) {
            i4 = i5;
        }
        return new KeylineRange((KeylineState.Keyline) list.get(i2), (KeylineState.Keyline) list.get(i4));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void E0(int i2, RecyclerView recyclerView) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext()) { // from class: com.google.android.material.carousel.CarouselLayoutManager.1
            @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
            public final PointF a(int i3) {
                return CarouselLayoutManager.this.a(i3);
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int h(int i3, View view) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                if (carouselLayoutManager.u == null || !carouselLayoutManager.V0()) {
                    return 0;
                }
                int iL = RecyclerView.LayoutManager.L(view);
                return (int) (carouselLayoutManager.p - carouselLayoutManager.S0(iL, carouselLayoutManager.Q0(iL)));
            }

            @Override // androidx.recyclerview.widget.LinearSmoothScroller
            public final int i(int i3, View view) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                if (carouselLayoutManager.u == null || carouselLayoutManager.V0()) {
                    return 0;
                }
                int iL = RecyclerView.LayoutManager.L(view);
                return (int) (carouselLayoutManager.p - carouselLayoutManager.S0(iL, carouselLayoutManager.Q0(iL)));
            }
        };
        linearSmoothScroller.f11618a = i2;
        F0(linearSmoothScroller);
    }

    public final void H0(View view, int i2, ChildCalculations childCalculations) {
        float f2 = this.v.f40160a / 2.0f;
        b(i2, view, false);
        float f3 = childCalculations.f40148c;
        this.y.j(view, (int) (f3 - f2), (int) (f3 + f2));
        f1(view, childCalculations.f40147b, childCalculations.f40149d);
    }

    public final float I0(float f2, float f3) {
        return W0() ? f2 - f3 : f2 + f3;
    }

    public final void J0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        float fM0 = M0(i2);
        while (i2 < state.b()) {
            ChildCalculations childCalculationsZ0 = Z0(recycler, fM0, i2);
            float f2 = childCalculationsZ0.f40148c;
            KeylineRange keylineRange = childCalculationsZ0.f40149d;
            if (X0(f2, keylineRange)) {
                return;
            }
            fM0 = I0(fM0, this.v.f40160a);
            if (!Y0(f2, keylineRange)) {
                H0(childCalculationsZ0.f40146a, -1, childCalculationsZ0);
            }
            i2++;
        }
    }

    public final void K0(RecyclerView.Recycler recycler, int i2) {
        float fM0 = M0(i2);
        while (i2 >= 0) {
            ChildCalculations childCalculationsZ0 = Z0(recycler, fM0, i2);
            KeylineRange keylineRange = childCalculationsZ0.f40149d;
            float f2 = childCalculationsZ0.f40148c;
            if (Y0(f2, keylineRange)) {
                return;
            }
            float f3 = this.v.f40160a;
            fM0 = W0() ? fM0 + f3 : fM0 - f3;
            if (!X0(f2, keylineRange)) {
                H0(childCalculationsZ0.f40146a, 0, childCalculationsZ0);
            }
            i2--;
        }
    }

    public final float L0(View view, float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f40152a;
        float f3 = keyline.f40174b;
        KeylineState.Keyline keyline2 = keylineRange.f40153b;
        float f4 = keyline2.f40174b;
        float f5 = keyline.f40173a;
        float f6 = keyline2.f40173a;
        float fB = AnimationUtils.b(f3, f4, f5, f6, f2);
        if (keyline2 != this.v.b() && keyline != this.v.d()) {
            return fB;
        }
        return (((1.0f - keyline2.f40175c) + (this.y.b((RecyclerView.LayoutParams) view.getLayoutParams()) / this.v.f40160a)) * (f2 - f6)) + fB;
    }

    public final float M0(int i2) {
        return I0(this.y.h() - this.p, this.v.f40160a * i2);
    }

    public final void N0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        while (v() > 0) {
            View viewU = u(0);
            float fP0 = P0(viewU);
            if (!Y0(fP0, U0(this.v.f40161b, fP0, true))) {
                break;
            } else {
                p0(viewU, recycler);
            }
        }
        while (v() - 1 >= 0) {
            View viewU2 = u(v() - 1);
            float fP02 = P0(viewU2);
            if (!X0(fP02, U0(this.v.f40161b, fP02, true))) {
                break;
            } else {
                p0(viewU2, recycler);
            }
        }
        if (v() == 0) {
            K0(recycler, this.w - 1);
            J0(this.w, recycler, state);
        } else {
            int iL = RecyclerView.LayoutManager.L(u(0));
            int iL2 = RecyclerView.LayoutManager.L(u(v() - 1));
            K0(recycler, iL - 1);
            J0(iL2 + 1, recycler, state);
        }
    }

    public final int O0() {
        return V0() ? this.n : this.o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean P() {
        return true;
    }

    public final float P0(View view) {
        RecyclerView.O(new Rect(), view);
        return V0() ? r0.centerX() : r0.centerY();
    }

    public final KeylineState Q0(int i2) {
        KeylineState keylineState;
        HashMap map = this.x;
        return (map == null || (keylineState = (KeylineState) map.get(Integer.valueOf(MathUtils.b(i2, 0, Math.max(0, F() + (-1)))))) == null) ? this.u.f40181a : keylineState;
    }

    public final int R0(int i2) {
        int iS0 = S0(i2, this.u.b(this.p, this.q, this.r, true)) - this.p;
        if (this.x != null) {
            S0(i2, Q0(i2));
        }
        return iS0;
    }

    public final int S0(int i2, KeylineState keylineState) {
        if (!W0()) {
            return (int) ((keylineState.f40160a / 2.0f) + ((i2 * keylineState.f40160a) - keylineState.a().f40173a));
        }
        float fO0 = O0() - keylineState.c().f40173a;
        float f2 = keylineState.f40160a;
        return (int) ((fO0 - (i2 * f2)) - (f2 / 2.0f));
    }

    public final int T0(int i2, KeylineState keylineState) {
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (KeylineState.Keyline keyline : keylineState.f40161b.subList(keylineState.f40162c, keylineState.f40163d + 1)) {
            float f2 = keylineState.f40160a;
            float f3 = (f2 / 2.0f) + (i2 * f2);
            int iO0 = (W0() ? (int) ((O0() - keyline.f40173a) - f3) : (int) (f3 - keyline.f40173a)) - this.p;
            if (Math.abs(i3) > Math.abs(iO0)) {
                i3 = iO0;
            }
        }
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void V(RecyclerView recyclerView) throws Resources.NotFoundException {
        MultiBrowseCarouselStrategy multiBrowseCarouselStrategy = this.t;
        Context context = recyclerView.getContext();
        float dimension = multiBrowseCarouselStrategy.f40158a;
        if (dimension <= 0.0f) {
            dimension = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        multiBrowseCarouselStrategy.f40158a = dimension;
        float dimension2 = multiBrowseCarouselStrategy.f40159b;
        if (dimension2 <= 0.0f) {
            dimension2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        multiBrowseCarouselStrategy.f40159b = dimension2;
        c1();
        recyclerView.addOnLayoutChangeListener(this.z);
    }

    public final boolean V0() {
        return this.y.f40154a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void W(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.z);
    }

    public final boolean W0() {
        return V0() && G() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View X(android.view.View r5, int r6, androidx.recyclerview.widget.RecyclerView.Recycler r7, androidx.recyclerview.widget.RecyclerView.State r8) {
        /*
            r4 = this;
            int r8 = r4.v()
            if (r8 != 0) goto L8
            goto L9c
        L8:
            com.google.android.material.carousel.CarouselOrientationHelper r8 = r4.y
            int r8 = r8.f40154a
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = -1
            r2 = 1
            if (r6 == r2) goto L46
            r3 = 2
            if (r6 == r3) goto L3c
            r3 = 17
            if (r6 == r3) goto L4b
            r3 = 33
            if (r6 == r3) goto L48
            r3 = 66
            if (r6 == r3) goto L3e
            r3 = 130(0x82, float:1.82E-43)
            if (r6 == r3) goto L3a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r3 = "Unknown focus request:"
            r8.<init>(r3)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            java.lang.String r8 = "CarouselLayoutManager"
            android.util.Log.d(r8, r6)
        L38:
            r6 = r0
            goto L54
        L3a:
            if (r8 != r2) goto L38
        L3c:
            r6 = r2
            goto L54
        L3e:
            if (r8 != 0) goto L38
            boolean r6 = r4.W0()
            if (r6 == 0) goto L3c
        L46:
            r6 = r1
            goto L54
        L48:
            if (r8 != r2) goto L38
            goto L46
        L4b:
            if (r8 != 0) goto L38
            boolean r6 = r4.W0()
            if (r6 == 0) goto L46
            goto L3c
        L54:
            if (r6 != r0) goto L57
            goto L9c
        L57:
            r8 = 0
            if (r6 != r1) goto L91
            int r5 = androidx.recyclerview.widget.RecyclerView.LayoutManager.L(r5)
            if (r5 != 0) goto L61
            goto L9c
        L61:
            android.view.View r5 = r4.u(r8)
            int r5 = androidx.recyclerview.widget.RecyclerView.LayoutManager.L(r5)
            int r5 = r5 - r2
            if (r5 < 0) goto L80
            int r6 = r4.F()
            if (r5 < r6) goto L73
            goto L80
        L73:
            float r6 = r4.M0(r5)
            com.google.android.material.carousel.CarouselLayoutManager$ChildCalculations r5 = r4.Z0(r7, r6, r5)
            android.view.View r6 = r5.f40146a
            r4.H0(r6, r8, r5)
        L80:
            boolean r5 = r4.W0()
            if (r5 == 0) goto L8c
            int r5 = r4.v()
            int r8 = r5 + (-1)
        L8c:
            android.view.View r5 = r4.u(r8)
            return r5
        L91:
            int r5 = androidx.recyclerview.widget.RecyclerView.LayoutManager.L(r5)
            int r6 = r4.F()
            int r6 = r6 - r2
            if (r5 != r6) goto L9e
        L9c:
            r5 = 0
            return r5
        L9e:
            int r5 = r4.v()
            int r5 = r5 - r2
            android.view.View r5 = r4.u(r5)
            int r5 = androidx.recyclerview.widget.RecyclerView.LayoutManager.L(r5)
            int r5 = r5 + r2
            if (r5 < 0) goto Lc2
            int r6 = r4.F()
            if (r5 < r6) goto Lb5
            goto Lc2
        Lb5:
            float r6 = r4.M0(r5)
            com.google.android.material.carousel.CarouselLayoutManager$ChildCalculations r5 = r4.Z0(r7, r6, r5)
            android.view.View r6 = r5.f40146a
            r4.H0(r6, r1, r5)
        Lc2:
            boolean r5 = r4.W0()
            if (r5 == 0) goto Lc9
            goto Lcf
        Lc9:
            int r5 = r4.v()
            int r8 = r5 + (-1)
        Lcf:
            android.view.View r5 = r4.u(r8)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.X(android.view.View, int, androidx.recyclerview.widget.RecyclerView$Recycler, androidx.recyclerview.widget.RecyclerView$State):android.view.View");
    }

    public final boolean X0(float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f40152a;
        float f3 = keyline.f40176d;
        KeylineState.Keyline keyline2 = keylineRange.f40153b;
        float fB = AnimationUtils.b(f3, keyline2.f40176d, keyline.f40174b, keyline2.f40174b, f2) / 2.0f;
        float f4 = W0() ? f2 + fB : f2 - fB;
        return W0() ? f4 < 0.0f : f4 > ((float) O0());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void Y(AccessibilityEvent accessibilityEvent) {
        super.Y(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(RecyclerView.LayoutManager.L(u(0)));
            accessibilityEvent.setToIndex(RecyclerView.LayoutManager.L(u(v() - 1)));
        }
    }

    public final boolean Y0(float f2, KeylineRange keylineRange) {
        KeylineState.Keyline keyline = keylineRange.f40152a;
        float f3 = keyline.f40176d;
        KeylineState.Keyline keyline2 = keylineRange.f40153b;
        float fI0 = I0(f2, AnimationUtils.b(f3, keyline2.f40176d, keyline.f40174b, keyline2.f40174b, f2) / 2.0f);
        return W0() ? fI0 > ((float) O0()) : fI0 < 0.0f;
    }

    public final ChildCalculations Z0(RecyclerView.Recycler recycler, float f2, int i2) {
        View view = recycler.k(i2, Long.MAX_VALUE).f11653a;
        a1(view);
        float fI0 = I0(f2, this.v.f40160a / 2.0f);
        KeylineRange keylineRangeU0 = U0(this.v.f40161b, fI0, false);
        return new ChildCalculations(view, fI0, L0(view, fI0, keylineRangeU0), keylineRangeU0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public final PointF a(int i2) {
        if (this.u == null) {
            return null;
        }
        int iS0 = S0(i2, Q0(i2)) - this.p;
        return V0() ? new PointF(iS0, 0.0f) : new PointF(0.0f, iS0);
    }

    public final void a1(View view) {
        if (!(view instanceof Maskable)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        Rect rect = new Rect();
        RecyclerView recyclerView = this.f11578b;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.P(view));
        }
        int i2 = rect.left + rect.right;
        int i3 = rect.top + rect.bottom;
        KeylineStateList keylineStateList = this.u;
        view.measure(RecyclerView.LayoutManager.w(V0(), this.n, this.f11588l, J() + I() + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + i2, (int) ((keylineStateList == null || this.y.f40154a != 0) ? ((ViewGroup.MarginLayoutParams) layoutParams).width : keylineStateList.f40181a.f40160a)), RecyclerView.LayoutManager.w(e(), this.o, this.f11589m, H() + K() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + i3, (int) ((keylineStateList == null || this.y.f40154a != 1) ? ((ViewGroup.MarginLayoutParams) layoutParams).height : keylineStateList.f40181a.f40160a)));
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x0452 A[PHI: r24
      0x0452: PHI (r24v1 float) = (r24v3 float), (r24v4 float) binds: [B:120:0x0450, B:116:0x0448] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x055b  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0560  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0581  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x05a2  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x05a5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0554 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b1(androidx.recyclerview.widget.RecyclerView.Recycler r30) {
        /*
            Method dump skipped, instructions count: 1659
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.carousel.CarouselLayoutManager.b1(androidx.recyclerview.widget.RecyclerView$Recycler):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void c0(int i2, int i3) {
        int iF = F();
        int i4 = this.A;
        if (iF == i4 || this.u == null) {
            return;
        }
        MultiBrowseCarouselStrategy multiBrowseCarouselStrategy = this.t;
        if ((i4 < multiBrowseCarouselStrategy.f40197c && F() >= multiBrowseCarouselStrategy.f40197c) || (i4 >= multiBrowseCarouselStrategy.f40197c && F() < multiBrowseCarouselStrategy.f40197c)) {
            c1();
        }
        this.A = iF;
    }

    public final void c1() {
        this.u = null;
        s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean d() {
        return V0();
    }

    public final int d1(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (v() == 0 || i2 == 0) {
            return 0;
        }
        if (this.u == null) {
            b1(recycler);
        }
        int i3 = this.p;
        int i4 = this.q;
        int i5 = this.r;
        int i6 = i3 + i2;
        if (i6 < i4) {
            i2 = i4 - i3;
        } else if (i6 > i5) {
            i2 = i5 - i3;
        }
        this.p = i3 + i2;
        g1(this.u);
        float f2 = this.v.f40160a / 2.0f;
        float fM0 = M0(RecyclerView.LayoutManager.L(u(0)));
        Rect rect = new Rect();
        float f3 = W0() ? this.v.c().f40174b : this.v.a().f40174b;
        float f4 = Float.MAX_VALUE;
        for (int i7 = 0; i7 < v(); i7++) {
            View viewU = u(i7);
            float fI0 = I0(fM0, f2);
            KeylineRange keylineRangeU0 = U0(this.v.f40161b, fI0, false);
            float fL0 = L0(viewU, fI0, keylineRangeU0);
            RecyclerView.O(rect, viewU);
            f1(viewU, fI0, keylineRangeU0);
            this.y.l(viewU, rect, f2, fL0);
            float fAbs = Math.abs(f3 - fL0);
            if (fAbs < f4) {
                this.B = RecyclerView.LayoutManager.L(viewU);
                f4 = fAbs;
            }
            fM0 = I0(fM0, this.v.f40160a);
        }
        N0(recycler, state);
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean e() {
        return !V0();
    }

    public final void e1(int i2) {
        CarouselOrientationHelper carouselOrientationHelper;
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException(b.f(i2, "invalid orientation:"));
        }
        c(null);
        CarouselOrientationHelper carouselOrientationHelper2 = this.y;
        if (carouselOrientationHelper2 == null || i2 != carouselOrientationHelper2.f40154a) {
            if (i2 == 0) {
                carouselOrientationHelper = new CarouselOrientationHelper() { // from class: com.google.android.material.carousel.CarouselOrientationHelper.2
                    {
                        super(0);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
                        float f2 = rectF2.left;
                        float f3 = rectF3.left;
                        if (f2 < f3 && rectF2.right > f3) {
                            float f4 = f3 - f2;
                            rectF.left += f4;
                            rectF2.left += f4;
                        }
                        float f5 = rectF2.right;
                        float f6 = rectF3.right;
                        if (f5 <= f6 || rectF2.left >= f6) {
                            return;
                        }
                        float f7 = f5 - f6;
                        rectF.right = Math.max(rectF.right - f7, rectF.left);
                        rectF2.right = Math.max(rectF2.right - f7, rectF2.left);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final float b(RecyclerView.LayoutParams layoutParams) {
                        return ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final RectF c(float f2, float f3, float f4, float f5) {
                        return new RectF(f5, 0.0f, f3 - f5, f2);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int d() {
                        CarouselLayoutManager carouselLayoutManager = this.f40156b;
                        return carouselLayoutManager.o - carouselLayoutManager.H();
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int e() {
                        CarouselLayoutManager carouselLayoutManager = this.f40156b;
                        if (carouselLayoutManager.W0()) {
                            return 0;
                        }
                        return carouselLayoutManager.n;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int f() {
                        return 0;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int g() {
                        return this.f40156b.n;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int h() {
                        CarouselLayoutManager carouselLayoutManager = this.f40156b;
                        if (carouselLayoutManager.W0()) {
                            return carouselLayoutManager.n;
                        }
                        return 0;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int i() {
                        return this.f40156b.K();
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void j(View view, int i3, int i4) {
                        CarouselLayoutManager carouselLayoutManager = this.f40156b;
                        int iK = carouselLayoutManager.K();
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                        int iB = RecyclerView.LayoutManager.B(view) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + iK;
                        carouselLayoutManager.getClass();
                        RecyclerView.LayoutManager.R(view, i3, iK, i4, iB);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void k(RectF rectF, RectF rectF2, RectF rectF3) {
                        if (rectF2.right <= rectF3.left) {
                            float fFloor = ((float) Math.floor(rectF.right)) - 1.0f;
                            rectF.right = fFloor;
                            rectF.left = Math.min(rectF.left, fFloor);
                        }
                        if (rectF2.left >= rectF3.right) {
                            float fCeil = ((float) Math.ceil(rectF.left)) + 1.0f;
                            rectF.left = fCeil;
                            rectF.right = Math.max(fCeil, rectF.right);
                        }
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void l(View view, Rect rect, float f2, float f3) {
                        view.offsetLeftAndRight((int) (f3 - (rect.left + f2)));
                    }
                };
            } else {
                if (i2 != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                carouselOrientationHelper = new CarouselOrientationHelper() { // from class: com.google.android.material.carousel.CarouselOrientationHelper.1
                    {
                        super(1);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void a(RectF rectF, RectF rectF2, RectF rectF3) {
                        float f2 = rectF2.top;
                        float f3 = rectF3.top;
                        if (f2 < f3 && rectF2.bottom > f3) {
                            float f4 = f3 - f2;
                            rectF.top += f4;
                            rectF3.top += f4;
                        }
                        float f5 = rectF2.bottom;
                        float f6 = rectF3.bottom;
                        if (f5 <= f6 || rectF2.top >= f6) {
                            return;
                        }
                        float f7 = f5 - f6;
                        rectF.bottom = Math.max(rectF.bottom - f7, rectF.top);
                        rectF2.bottom = Math.max(rectF2.bottom - f7, rectF2.top);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final float b(RecyclerView.LayoutParams layoutParams) {
                        return ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final RectF c(float f2, float f3, float f4, float f5) {
                        return new RectF(0.0f, f4, f3, f2 - f4);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int d() {
                        return this.f40155b.o;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int e() {
                        return this.f40155b.o;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int f() {
                        return this.f40155b.I();
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int g() {
                        CarouselLayoutManager carouselLayoutManager = this.f40155b;
                        return carouselLayoutManager.n - carouselLayoutManager.J();
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int h() {
                        return 0;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final int i() {
                        return 0;
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void j(View view, int i3, int i4) {
                        CarouselLayoutManager carouselLayoutManager = this.f40155b;
                        int I = carouselLayoutManager.I();
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                        int iC = RecyclerView.LayoutManager.C(view) + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + I;
                        carouselLayoutManager.getClass();
                        RecyclerView.LayoutManager.R(view, I, i3, iC, i4);
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void k(RectF rectF, RectF rectF2, RectF rectF3) {
                        if (rectF2.bottom <= rectF3.top) {
                            float fFloor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                            rectF.bottom = fFloor;
                            rectF.top = Math.min(rectF.top, fFloor);
                        }
                        if (rectF2.top >= rectF3.bottom) {
                            float fCeil = ((float) Math.ceil(rectF.top)) + 1.0f;
                            rectF.top = fCeil;
                            rectF.bottom = Math.max(fCeil, rectF.bottom);
                        }
                    }

                    @Override // com.google.android.material.carousel.CarouselOrientationHelper
                    public final void l(View view, Rect rect, float f2, float f3) {
                        view.offsetTopAndBottom((int) (f3 - (rect.top + f2)));
                    }
                };
            }
            this.y = carouselOrientationHelper;
            c1();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void f0(int i2, int i3) {
        int iF = F();
        int i4 = this.A;
        if (iF == i4 || this.u == null) {
            return;
        }
        MultiBrowseCarouselStrategy multiBrowseCarouselStrategy = this.t;
        if ((i4 < multiBrowseCarouselStrategy.f40197c && F() >= multiBrowseCarouselStrategy.f40197c) || (i4 >= multiBrowseCarouselStrategy.f40197c && F() < multiBrowseCarouselStrategy.f40197c)) {
            c1();
        }
        this.A = iF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f1(View view, float f2, KeylineRange keylineRange) {
        if (view instanceof Maskable) {
            KeylineState.Keyline keyline = keylineRange.f40152a;
            float f3 = keyline.f40175c;
            KeylineState.Keyline keyline2 = keylineRange.f40153b;
            float fB = AnimationUtils.b(f3, keyline2.f40175c, keyline.f40173a, keyline2.f40173a, f2);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF rectFC = this.y.c(height, width, AnimationUtils.b(0.0f, height / 2.0f, 0.0f, 1.0f, fB), AnimationUtils.b(0.0f, width / 2.0f, 0.0f, 1.0f, fB));
            float fL0 = L0(view, f2, keylineRange);
            RectF rectF = new RectF(fL0 - (rectFC.width() / 2.0f), fL0 - (rectFC.height() / 2.0f), (rectFC.width() / 2.0f) + fL0, (rectFC.height() / 2.0f) + fL0);
            RectF rectF2 = new RectF(this.y.f(), this.y.i(), this.y.g(), this.y.d());
            this.t.getClass();
            this.y.a(rectFC, rectF, rectF2);
            this.y.k(rectFC, rectF, rectF2);
            ((Maskable) view).setMaskRectF(rectFC);
        }
    }

    public final void g1(KeylineStateList keylineStateList) {
        int i2 = this.r;
        int i3 = this.q;
        if (i2 <= i3) {
            this.v = W0() ? keylineStateList.a() : keylineStateList.c();
        } else {
            this.v = keylineStateList.b(this.p, i3, i2, false);
        }
        List list = this.v.f40161b;
        DebugItemDecoration debugItemDecoration = this.s;
        debugItemDecoration.getClass();
        debugItemDecoration.f40151b = Collections.unmodifiableList(list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void h0(RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f2;
        if (state.b() <= 0 || O0() <= 0.0f) {
            n0(recycler);
            this.w = 0;
            return;
        }
        boolean zW0 = W0();
        boolean z = this.u == null;
        if (z) {
            b1(recycler);
        }
        KeylineStateList keylineStateList = this.u;
        boolean zW02 = W0();
        KeylineState keylineStateA = zW02 ? keylineStateList.a() : keylineStateList.c();
        float f3 = (zW02 ? keylineStateA.c() : keylineStateA.a()).f40173a;
        float f4 = keylineStateA.f40160a / 2.0f;
        int iH = (int) (this.y.h() - (W0() ? f3 + f4 : f3 - f4));
        KeylineStateList keylineStateList2 = this.u;
        boolean zW03 = W0();
        KeylineState keylineStateC = zW03 ? keylineStateList2.c() : keylineStateList2.a();
        KeylineState.Keyline keylineA = zW03 ? keylineStateC.a() : keylineStateC.c();
        int iB = (int) (((((state.b() - 1) * keylineStateC.f40160a) * (zW03 ? -1.0f : 1.0f)) - (keylineA.f40173a - this.y.h())) + (this.y.e() - keylineA.f40173a) + (zW03 ? -keylineA.f40179g : keylineA.f40180h));
        int iMin = zW03 ? Math.min(0, iB) : Math.max(0, iB);
        this.q = zW0 ? iMin : iH;
        if (zW0) {
            iMin = iH;
        }
        this.r = iMin;
        if (z) {
            this.p = iH;
            KeylineStateList keylineStateList3 = this.u;
            int iF = F();
            int i2 = this.q;
            int i3 = this.r;
            boolean zW04 = W0();
            KeylineState keylineState = keylineStateList3.f40181a;
            HashMap map = new HashMap();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                f2 = keylineState.f40160a;
                if (i4 >= iF) {
                    break;
                }
                int i6 = zW04 ? (iF - i4) - 1 : i4;
                float f5 = i6 * f2 * (zW04 ? -1 : 1);
                float f6 = i3 - keylineStateList3.f40187g;
                List list = keylineStateList3.f40183c;
                if (f5 > f6 || i4 >= iF - list.size()) {
                    map.put(Integer.valueOf(i6), (KeylineState) list.get(MathUtils.b(i5, 0, list.size() - 1)));
                    i5++;
                }
                i4++;
            }
            int i7 = 0;
            for (int i8 = iF - 1; i8 >= 0; i8--) {
                int i9 = zW04 ? (iF - i8) - 1 : i8;
                float f7 = i9 * f2 * (zW04 ? -1 : 1);
                float f8 = i2 + keylineStateList3.f40186f;
                List list2 = keylineStateList3.f40182b;
                if (f7 < f8 || i8 < list2.size()) {
                    map.put(Integer.valueOf(i9), (KeylineState) list2.get(MathUtils.b(i7, 0, list2.size() - 1)));
                    i7++;
                }
            }
            this.x = map;
            int i10 = this.B;
            if (i10 != -1) {
                this.p = S0(i10, Q0(i10));
            }
        }
        int i11 = this.p;
        int i12 = this.q;
        int i13 = this.r;
        this.p = (i11 < i12 ? i12 - i11 : i11 > i13 ? i13 - i11 : 0) + i11;
        this.w = MathUtils.b(this.w, 0, state.b());
        g1(this.u);
        p(recycler);
        N0(recycler, state);
        this.A = F();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void i0(RecyclerView.State state) {
        if (v() == 0) {
            this.w = 0;
        } else {
            this.w = RecyclerView.LayoutManager.L(u(0));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int j(RecyclerView.State state) {
        if (v() == 0 || this.u == null || F() <= 1) {
            return 0;
        }
        return (int) (this.n * (this.u.f40181a.f40160a / l(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int k(RecyclerView.State state) {
        return this.p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int l(RecyclerView.State state) {
        return this.r - this.q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int m(RecyclerView.State state) {
        if (v() == 0 || this.u == null || F() <= 1) {
            return 0;
        }
        return (int) (this.o * (this.u.f40181a.f40160a / o(state)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int n(RecyclerView.State state) {
        return this.p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int o(RecyclerView.State state) {
        return this.r - this.q;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams r() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final boolean r0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        int iT0;
        if (this.u == null || (iT0 = T0(RecyclerView.LayoutManager.L(view), Q0(RecyclerView.LayoutManager.L(view)))) == 0) {
            return false;
        }
        int i2 = this.p;
        int i3 = this.q;
        int i4 = this.r;
        int i5 = i2 + iT0;
        if (i5 < i3) {
            iT0 = i3 - i2;
        } else if (i5 > i4) {
            iT0 = i4 - i2;
        }
        int iT02 = T0(RecyclerView.LayoutManager.L(view), this.u.b(i2 + iT0, i3, i4, false));
        if (V0()) {
            recyclerView.scrollBy(iT02, 0);
            return true;
        }
        recyclerView.scrollBy(0, iT02);
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int t0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (V0()) {
            return d1(i2, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void u0(int i2) {
        this.B = i2;
        if (this.u == null) {
            return;
        }
        this.p = S0(i2, Q0(i2));
        this.w = MathUtils.b(i2, 0, Math.max(0, F() - 1));
        g1(this.u);
        s0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final int v0(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (e()) {
            return d1(i2, recycler, state);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public final void z(Rect rect, View view) {
        RecyclerView.O(rect, view);
        float fCenterY = rect.centerY();
        if (V0()) {
            fCenterY = rect.centerX();
        }
        KeylineRange keylineRangeU0 = U0(this.v.f40161b, fCenterY, true);
        KeylineState.Keyline keyline = keylineRangeU0.f40152a;
        float f2 = keyline.f40176d;
        KeylineState.Keyline keyline2 = keylineRangeU0.f40153b;
        float fB = AnimationUtils.b(f2, keyline2.f40176d, keyline.f40174b, keyline2.f40174b, fCenterY);
        float fWidth = V0() ? (rect.width() - fB) / 2.0f : 0.0f;
        float fHeight = V0() ? 0.0f : (rect.height() - fB) / 2.0f;
        rect.set((int) (rect.left + fWidth), (int) (rect.top + fHeight), (int) (rect.right - fWidth), (int) (rect.bottom - fHeight));
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.s = new DebugItemDecoration();
        this.w = 0;
        this.z = new View.OnLayoutChangeListener() { // from class: com.google.android.material.carousel.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i22, int i32, int i4, int i5, int i6, int i7, int i8, int i9) {
                CarouselLayoutManager carouselLayoutManager = this.f40198a;
                if (i22 == i6 && i32 == i7 && i4 == i8 && i5 == i9) {
                    return;
                }
                view.post(new androidx.constraintlayout.helper.widget.a(carouselLayoutManager, 20));
            }
        };
        this.B = -1;
        this.C = 0;
        this.t = new MultiBrowseCarouselStrategy();
        c1();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            this.C = typedArrayObtainStyledAttributes.getInt(R.styleable.Carousel_carousel_alignment, 0);
            c1();
            e1(typedArrayObtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
