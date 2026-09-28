package com.google.android.material.carousel;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
public class CarouselSnapHelper extends SnapHelper {

    /* renamed from: d, reason: collision with root package name */
    public final boolean f40157d = true;

    /* renamed from: com.google.android.material.carousel.CarouselSnapHelper$1, reason: invalid class name */
    class AnonymousClass1 extends LinearSmoothScroller {
        @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
        public final void e(View view, RecyclerView.SmoothScroller.Action action) {
            throw null;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public final float j(DisplayMetrics displayMetrics) {
            throw null;
        }
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final int[] c(RecyclerView.LayoutManager layoutManager, View view) {
        if (!(layoutManager instanceof CarouselLayoutManager)) {
            return new int[]{0, 0};
        }
        CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) layoutManager;
        carouselLayoutManager.getClass();
        int iR0 = carouselLayoutManager.R0(RecyclerView.LayoutManager.L(view));
        return ((CarouselLayoutManager) layoutManager).V0() ? new int[]{iR0, 0} : layoutManager.e() ? new int[]{0, iR0} : new int[]{0, 0};
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final RecyclerView.SmoothScroller d(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            throw null;
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final View e(RecyclerView.LayoutManager layoutManager) {
        int iV = layoutManager.v();
        View view = null;
        if (iV != 0 && (layoutManager instanceof CarouselLayoutManager)) {
            CarouselLayoutManager carouselLayoutManager = (CarouselLayoutManager) layoutManager;
            int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            for (int i3 = 0; i3 < iV; i3++) {
                View viewU = layoutManager.u(i3);
                int iAbs = Math.abs(carouselLayoutManager.R0(RecyclerView.LayoutManager.L(viewU)));
                if (iAbs < i2) {
                    view = viewU;
                    i2 = iAbs;
                }
            }
        }
        return view;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.SnapHelper
    public final int f(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int iF;
        PointF pointFA;
        if (this.f40157d && (iF = layoutManager.F()) != 0) {
            int iV = layoutManager.v();
            View view = null;
            boolean z = false;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            View view2 = null;
            for (int i6 = 0; i6 < iV; i6++) {
                View viewU = layoutManager.u(i6);
                if (viewU != null) {
                    int iR0 = ((CarouselLayoutManager) layoutManager).R0(RecyclerView.LayoutManager.L(viewU));
                    if (iR0 <= 0 && iR0 > i5) {
                        view2 = viewU;
                        i5 = iR0;
                    }
                    if (iR0 >= 0 && iR0 < i4) {
                        view = viewU;
                        i4 = iR0;
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
        return -1;
    }
}
