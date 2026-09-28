package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* loaded from: classes3.dex */
public class PagerSnapHelper extends SnapHelper {

    /* renamed from: d, reason: collision with root package name */
    public OrientationHelper f11542d;

    /* renamed from: e, reason: collision with root package name */
    public OrientationHelper f11543e;

    public static int h(View view, OrientationHelper orientationHelper) {
        return ((orientationHelper.c(view) / 2) + orientationHelper.e(view)) - ((orientationHelper.l() / 2) + orientationHelper.k());
    }

    public static View i(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper) {
        int iV = layoutManager.v();
        View view = null;
        if (iV == 0) {
            return null;
        }
        int iL = (orientationHelper.l() / 2) + orientationHelper.k();
        int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i3 = 0; i3 < iV; i3++) {
            View viewU = layoutManager.u(i3);
            int iAbs = Math.abs(((orientationHelper.c(viewU) / 2) + orientationHelper.e(viewU)) - iL);
            if (iAbs < i2) {
                view = viewU;
                i2 = iAbs;
            }
        }
        return view;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] c(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.d()) {
            iArr[0] = h(view, j(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.e()) {
            iArr[1] = h(view, k(layoutManager));
            return iArr;
        }
        iArr[1] = 0;
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final RecyclerView.SmoothScroller d(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f11671a.getContext()) { // from class: androidx.recyclerview.widget.PagerSnapHelper.1
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                public final void e(View view, RecyclerView.SmoothScroller.Action action) {
                    PagerSnapHelper pagerSnapHelper = PagerSnapHelper.this;
                    int[] iArrC = pagerSnapHelper.c(pagerSnapHelper.f11671a.getLayoutManager(), view);
                    int i2 = iArrC[0];
                    int i3 = iArrC[1];
                    int iCeil = (int) Math.ceil(k(Math.max(Math.abs(i2), Math.abs(i3))) / 0.3356d);
                    if (iCeil > 0) {
                        DecelerateInterpolator decelerateInterpolator = this.f11528j;
                        action.f11626a = i2;
                        action.f11627b = i3;
                        action.f11628c = iCeil;
                        action.f11630e = decelerateInterpolator;
                        action.f11631f = true;
                    }
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public final float j(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }

                @Override // androidx.recyclerview.widget.LinearSmoothScroller
                public final int k(int i2) {
                    return Math.min(100, super.k(i2));
                }
            };
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public View e(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.e()) {
            return i(layoutManager, k(layoutManager));
        }
        if (layoutManager.d()) {
            return i(layoutManager, j(layoutManager));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public final int f(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        PointF pointFA;
        int iF = layoutManager.F();
        if (iF != 0) {
            View view = null;
            OrientationHelper orientationHelperK = layoutManager.e() ? k(layoutManager) : layoutManager.d() ? j(layoutManager) : null;
            if (orientationHelperK != null) {
                int iV = layoutManager.v();
                boolean z = false;
                int i4 = Integer.MAX_VALUE;
                int i5 = Integer.MIN_VALUE;
                View view2 = null;
                for (int i6 = 0; i6 < iV; i6++) {
                    View viewU = layoutManager.u(i6);
                    if (viewU != null) {
                        int iH = h(viewU, orientationHelperK);
                        if (iH <= 0 && iH > i5) {
                            view2 = viewU;
                            i5 = iH;
                        }
                        if (iH >= 0 && iH < i4) {
                            view = viewU;
                            i4 = iH;
                        }
                    }
                }
                boolean z2 = !layoutManager.d() ? i3 <= 0 : i2 <= 0;
                if (z2 && view != null) {
                    return RecyclerView.LayoutManager.L(view);
                }
                if (!z2 && view2 != null) {
                    return RecyclerView.LayoutManager.L(view2);
                }
                if (z2) {
                    view = view2;
                }
                if (view != null) {
                    int iL = RecyclerView.LayoutManager.L(view);
                    int iF2 = layoutManager.F();
                    if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (pointFA = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).a(iF2 - 1)) != null && (pointFA.x < 0.0f || pointFA.y < 0.0f)) {
                        z = true;
                    }
                    int i7 = iL + (z == z2 ? -1 : 1);
                    if (i7 >= 0 && i7 < iF) {
                        return i7;
                    }
                }
            }
        }
        return -1;
    }

    public final OrientationHelper j(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f11543e;
        if (orientationHelper == null || orientationHelper.f11539a != layoutManager) {
            this.f11543e = new OrientationHelper.AnonymousClass1(layoutManager);
        }
        return this.f11543e;
    }

    public final OrientationHelper k(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f11542d;
        if (orientationHelper == null || orientationHelper.f11539a != layoutManager) {
            this.f11542d = new OrientationHelper.AnonymousClass2(layoutManager);
        }
        return this.f11542d;
    }
}
