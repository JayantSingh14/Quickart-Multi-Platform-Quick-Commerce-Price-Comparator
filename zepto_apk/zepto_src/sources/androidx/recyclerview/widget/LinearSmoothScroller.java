package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class LinearSmoothScroller extends RecyclerView.SmoothScroller {

    /* renamed from: k, reason: collision with root package name */
    public PointF f11529k;

    /* renamed from: l, reason: collision with root package name */
    public final DisplayMetrics f11530l;
    public float n;

    /* renamed from: i, reason: collision with root package name */
    public final LinearInterpolator f11527i = new LinearInterpolator();

    /* renamed from: j, reason: collision with root package name */
    public final DecelerateInterpolator f11528j = new DecelerateInterpolator();

    /* renamed from: m, reason: collision with root package name */
    public boolean f11531m = false;
    public int o = 0;
    public int p = 0;

    public LinearSmoothScroller(Context context) {
        this.f11530l = context.getResources().getDisplayMetrics();
    }

    public static int g(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == -1) {
            return i4 - i2;
        }
        if (i6 != 0) {
            if (i6 == 1) {
                return i5 - i3;
            }
            throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
        int i7 = i4 - i2;
        if (i7 > 0) {
            return i7;
        }
        int i8 = i5 - i3;
        if (i8 < 0) {
            return i8;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void c(int i2, int i3, RecyclerView.SmoothScroller.Action action) {
        if (this.f11619b.n.v() == 0) {
            f();
            return;
        }
        int i4 = this.o;
        int i5 = i4 - i2;
        if (i4 * i5 <= 0) {
            i5 = 0;
        }
        this.o = i5;
        int i6 = this.p;
        int i7 = i6 - i3;
        int i8 = i6 * i7 > 0 ? i7 : 0;
        this.p = i8;
        if (i5 == 0 && i8 == 0) {
            PointF pointFA = a(this.f11618a);
            if (pointFA != null) {
                if (pointFA.x != 0.0f || pointFA.y != 0.0f) {
                    float f2 = pointFA.y;
                    float fSqrt = (float) Math.sqrt((f2 * f2) + (r4 * r4));
                    float f3 = pointFA.x / fSqrt;
                    pointFA.x = f3;
                    float f4 = pointFA.y / fSqrt;
                    pointFA.y = f4;
                    this.f11529k = pointFA;
                    this.o = (int) (f3 * 10000.0f);
                    this.p = (int) (f4 * 10000.0f);
                    int iK = k(10000);
                    LinearInterpolator linearInterpolator = this.f11527i;
                    action.f11626a = (int) (this.o * 1.2f);
                    action.f11627b = (int) (this.p * 1.2f);
                    action.f11628c = (int) (iK * 1.2f);
                    action.f11630e = linearInterpolator;
                    action.f11631f = true;
                    return;
                }
            }
            action.f11629d = this.f11618a;
            f();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    public final void d() {
        this.p = 0;
        this.o = 0;
        this.f11529k = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0015  */
    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(android.view.View r7, androidx.recyclerview.widget.RecyclerView.SmoothScroller.Action r8) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r6.f11529k
            r1 = 1
            r2 = 0
            r3 = -1
            r4 = 0
            if (r0 == 0) goto L15
            float r0 = r0.x
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 != 0) goto Lf
            goto L15
        Lf:
            if (r0 <= 0) goto L13
            r0 = r1
            goto L16
        L13:
            r0 = r3
            goto L16
        L15:
            r0 = r2
        L16:
            int r0 = r6.h(r0, r7)
            android.graphics.PointF r5 = r6.f11529k
            if (r5 == 0) goto L2a
            float r5 = r5.y
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 != 0) goto L25
            goto L2a
        L25:
            if (r4 <= 0) goto L29
            r2 = r1
            goto L2a
        L29:
            r2 = r3
        L2a:
            int r7 = r6.i(r2, r7)
            int r2 = r0 * r0
            int r3 = r7 * r7
            int r3 = r3 + r2
            double r2 = (double) r3
            double r2 = java.lang.Math.sqrt(r2)
            int r2 = (int) r2
            int r2 = r6.k(r2)
            double r2 = (double) r2
            r4 = 4599717252057688074(0x3fd57a786c22680a, double:0.3356)
            double r2 = r2 / r4
            double r2 = java.lang.Math.ceil(r2)
            int r2 = (int) r2
            if (r2 <= 0) goto L59
            int r0 = -r0
            int r7 = -r7
            android.view.animation.DecelerateInterpolator r3 = r6.f11528j
            r8.f11626a = r0
            r8.f11627b = r7
            r8.f11628c = r2
            r8.f11630e = r3
            r8.f11631f = r1
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearSmoothScroller.e(android.view.View, androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action):void");
    }

    public int h(int i2, View view) {
        RecyclerView.LayoutManager layoutManager = this.f11620c;
        if (layoutManager == null || !layoutManager.d()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return g(RecyclerView.LayoutManager.A(view) - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin, RecyclerView.LayoutManager.D(view) + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin, layoutManager.I(), layoutManager.n - layoutManager.J(), i2);
    }

    public int i(int i2, View view) {
        RecyclerView.LayoutManager layoutManager = this.f11620c;
        if (layoutManager == null || !layoutManager.e()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return g(RecyclerView.LayoutManager.E(view) - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, RecyclerView.LayoutManager.y(view) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin, layoutManager.K(), layoutManager.o - layoutManager.H(), i2);
    }

    public float j(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int k(int i2) {
        float fAbs = Math.abs(i2);
        if (!this.f11531m) {
            this.n = j(this.f11530l);
            this.f11531m = true;
        }
        return (int) Math.ceil(fAbs * this.n);
    }
}
