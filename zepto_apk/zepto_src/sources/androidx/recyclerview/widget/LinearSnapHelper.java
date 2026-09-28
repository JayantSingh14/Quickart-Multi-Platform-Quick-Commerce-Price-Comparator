package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;

/* loaded from: classes3.dex */
public class LinearSnapHelper extends SnapHelper {

    /* renamed from: d, reason: collision with root package name */
    public OrientationHelper f11532d;

    /* renamed from: e, reason: collision with root package name */
    public OrientationHelper f11533e;

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
            OrientationHelper orientationHelperJ = j(layoutManager);
            iArr[0] = ((orientationHelperJ.c(view) / 2) + orientationHelperJ.e(view)) - ((orientationHelperJ.l() / 2) + orientationHelperJ.k());
        } else {
            iArr[0] = 0;
        }
        if (!layoutManager.e()) {
            iArr[1] = 0;
            return iArr;
        }
        OrientationHelper orientationHelperK = k(layoutManager);
        iArr[1] = ((orientationHelperK.c(view) / 2) + orientationHelperK.e(view)) - ((orientationHelperK.l() / 2) + orientationHelperK.k());
        return iArr;
    }

    @Override // androidx.recyclerview.widget.SnapHelper
    public final View e(RecyclerView.LayoutManager layoutManager) {
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
        int iF;
        View viewE;
        int iL;
        int i4;
        PointF pointFA;
        int iH;
        int iH2;
        if ((layoutManager instanceof RecyclerView.SmoothScroller.ScrollVectorProvider) && (iF = layoutManager.F()) != 0 && (viewE = e(layoutManager)) != null && (iL = RecyclerView.LayoutManager.L(viewE)) != -1 && (pointFA = ((RecyclerView.SmoothScroller.ScrollVectorProvider) layoutManager).a(iF - 1)) != null) {
            if (layoutManager.d()) {
                iH = h(layoutManager, j(layoutManager), i2, 0);
                if (pointFA.x < 0.0f) {
                    iH = -iH;
                }
            } else {
                iH = 0;
            }
            if (layoutManager.e()) {
                iH2 = h(layoutManager, k(layoutManager), 0, i3);
                if (pointFA.y < 0.0f) {
                    iH2 = -iH2;
                }
            } else {
                iH2 = 0;
            }
            if (layoutManager.e()) {
                iH = iH2;
            }
            if (iH != 0) {
                int i5 = iL + iH;
                int i6 = i5 >= 0 ? i5 : 0;
                return i6 >= iF ? i4 : i6;
            }
        }
        return -1;
    }

    public final int h(RecyclerView.LayoutManager layoutManager, OrientationHelper orientationHelper, int i2, int i3) {
        this.f11672b.fling(0, 0, i2, i3, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        int[] iArr = {this.f11672b.getFinalX(), this.f11672b.getFinalY()};
        int iV = layoutManager.v();
        float f2 = 1.0f;
        if (iV != 0) {
            View view = null;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MAX_VALUE;
            View view2 = null;
            for (int i6 = 0; i6 < iV; i6++) {
                View viewU = layoutManager.u(i6);
                int iL = RecyclerView.LayoutManager.L(viewU);
                if (iL != -1) {
                    if (iL < i5) {
                        view = viewU;
                        i5 = iL;
                    }
                    if (iL > i4) {
                        view2 = viewU;
                        i4 = iL;
                    }
                }
            }
            if (view != null && view2 != null) {
                int iMax = Math.max(orientationHelper.b(view), orientationHelper.b(view2)) - Math.min(orientationHelper.e(view), orientationHelper.e(view2));
                if (iMax != 0) {
                    f2 = (iMax * 1.0f) / ((i4 - i5) + 1);
                }
            }
        }
        if (f2 <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(iArr[0]) > Math.abs(iArr[1]) ? iArr[0] : iArr[1]) / f2);
    }

    public final OrientationHelper j(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f11533e;
        if (orientationHelper == null || orientationHelper.f11539a != layoutManager) {
            this.f11533e = new OrientationHelper.AnonymousClass1(layoutManager);
        }
        return this.f11533e;
    }

    public final OrientationHelper k(RecyclerView.LayoutManager layoutManager) {
        OrientationHelper orientationHelper = this.f11532d;
        if (orientationHelper == null || orientationHelper.f11539a != layoutManager) {
            this.f11532d = new OrientationHelper.AnonymousClass2(layoutManager);
        }
        return this.f11532d;
    }
}
