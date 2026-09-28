package androidx.recyclerview.widget;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class SnapHelper extends RecyclerView.OnFlingListener {

    /* renamed from: a, reason: collision with root package name */
    public RecyclerView f11671a;

    /* renamed from: b, reason: collision with root package name */
    public Scroller f11672b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView.OnScrollListener f11673c = new RecyclerView.OnScrollListener() { // from class: androidx.recyclerview.widget.SnapHelper.1

        /* renamed from: a, reason: collision with root package name */
        public boolean f11674a = false;

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void a(int i2, RecyclerView recyclerView) {
            if (i2 == 0 && this.f11674a) {
                this.f11674a = false;
                SnapHelper.this.g();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void b(RecyclerView recyclerView, int i2, int i3) {
            if (i2 == 0 && i3 == 0) {
                return;
            }
            this.f11674a = true;
        }
    };

    @Override // androidx.recyclerview.widget.RecyclerView.OnFlingListener
    public final boolean a(int i2, int i3) {
        RecyclerView.SmoothScroller smoothScrollerD;
        int iF;
        RecyclerView.LayoutManager layoutManager = this.f11671a.getLayoutManager();
        if (layoutManager == null || this.f11671a.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.f11671a.getMinFlingVelocity();
        if ((Math.abs(i3) <= minFlingVelocity && Math.abs(i2) <= minFlingVelocity) || !(layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) || (smoothScrollerD = d(layoutManager)) == null || (iF = f(layoutManager, i2, i3)) == -1) {
            return false;
        }
        smoothScrollerD.f11618a = iF;
        layoutManager.F0(smoothScrollerD);
        return true;
    }

    public final void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f11671a;
        if (recyclerView2 == recyclerView) {
            return;
        }
        RecyclerView.OnScrollListener onScrollListener = this.f11673c;
        if (recyclerView2 != null) {
            ArrayList arrayList = recyclerView2.T0;
            if (arrayList != null) {
                arrayList.remove(onScrollListener);
            }
            this.f11671a.setOnFlingListener(null);
        }
        this.f11671a = recyclerView;
        if (recyclerView != null) {
            if (recyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.f11671a.k(onScrollListener);
            this.f11671a.setOnFlingListener(this);
            this.f11672b = new Scroller(this.f11671a.getContext(), new DecelerateInterpolator());
            g();
        }
    }

    public abstract int[] c(RecyclerView.LayoutManager layoutManager, View view);

    public RecyclerView.SmoothScroller d(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) {
            return new LinearSmoothScroller(this.f11671a.getContext()) { // from class: androidx.recyclerview.widget.SnapHelper.2
                @Override // androidx.recyclerview.widget.LinearSmoothScroller, androidx.recyclerview.widget.RecyclerView.SmoothScroller
                public final void e(View view, RecyclerView.SmoothScroller.Action action) {
                    SnapHelper snapHelper = SnapHelper.this;
                    RecyclerView recyclerView = snapHelper.f11671a;
                    if (recyclerView == null) {
                        return;
                    }
                    int[] iArrC = snapHelper.c(recyclerView.getLayoutManager(), view);
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
            };
        }
        return null;
    }

    public abstract View e(RecyclerView.LayoutManager layoutManager);

    public abstract int f(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    public final void g() {
        RecyclerView.LayoutManager layoutManager;
        View viewE;
        RecyclerView recyclerView = this.f11671a;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewE = e(layoutManager)) == null) {
            return;
        }
        int[] iArrC = c(layoutManager, viewE);
        int i2 = iArrC[0];
        if (i2 == 0 && iArrC[1] == 0) {
            return;
        }
        this.f11671a.l0(i2, iArrC[1], false);
    }
}
