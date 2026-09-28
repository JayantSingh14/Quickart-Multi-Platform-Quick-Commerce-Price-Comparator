package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
class ScrollbarHelper {
    public static int a(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.v() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(RecyclerView.LayoutManager.L(view) - RecyclerView.LayoutManager.L(view2)) + 1;
        }
        return Math.min(orientationHelper.l(), orientationHelper.b(view2) - orientationHelper.e(view));
    }

    public static int b(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z, boolean z2) {
        if (layoutManager.v() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z2 ? Math.max(0, (state.b() - Math.max(RecyclerView.LayoutManager.L(view), RecyclerView.LayoutManager.L(view2))) - 1) : Math.max(0, Math.min(RecyclerView.LayoutManager.L(view), RecyclerView.LayoutManager.L(view2)));
        if (z) {
            return Math.round((iMax * (Math.abs(orientationHelper.b(view2) - orientationHelper.e(view)) / (Math.abs(RecyclerView.LayoutManager.L(view) - RecyclerView.LayoutManager.L(view2)) + 1))) + (orientationHelper.k() - orientationHelper.e(view)));
        }
        return iMax;
    }

    public static int c(RecyclerView.State state, OrientationHelper orientationHelper, View view, View view2, RecyclerView.LayoutManager layoutManager, boolean z) {
        if (layoutManager.v() == 0 || state.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return state.b();
        }
        return (int) (((orientationHelper.b(view2) - orientationHelper.e(view)) / (Math.abs(RecyclerView.LayoutManager.L(view) - RecyclerView.LayoutManager.L(view2)) + 1)) * state.b());
    }
}
