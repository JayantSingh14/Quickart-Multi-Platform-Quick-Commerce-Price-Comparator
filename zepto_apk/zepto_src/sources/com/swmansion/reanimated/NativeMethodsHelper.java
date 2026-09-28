package com.swmansion.reanimated;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.facebook.react.views.swiperefresh.ReactSwipeRefreshLayout;

/* loaded from: classes4.dex */
public class NativeMethodsHelper {
    private static void computeBoundingBox(View view, int[] iArr) {
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        mapRectFromViewToWindowCoords(view, rectF);
        iArr[0] = Math.round(rectF.left);
        iArr[1] = Math.round(rectF.top);
        iArr[2] = Math.round(rectF.right - rectF.left);
        iArr[3] = Math.round(rectF.bottom - rectF.top);
    }

    private static ReactScrollView findScrollView(ReactSwipeRefreshLayout reactSwipeRefreshLayout) {
        for (int i2 = 0; i2 < reactSwipeRefreshLayout.getChildCount(); i2++) {
            if (reactSwipeRefreshLayout.getChildAt(i2) instanceof ReactScrollView) {
                return (ReactScrollView) reactSwipeRefreshLayout.getChildAt(i2);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$scrollTo$0(View view, int i2, int i3) {
        ((ReactHorizontalScrollView) view).smoothScrollTo(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$scrollTo$1(View view, int i2, int i3) {
        ((ReactScrollView) view).smoothScrollTo(i2, i3);
    }

    private static void mapRectFromViewToWindowCoords(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset(view.getLeft(), view.getTop());
        Object parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset(-view2.getScrollX(), -view2.getScrollY());
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset(view2.getLeft(), view2.getTop());
            parent = view2.getParent();
        }
    }

    public static float[] measure(View view) {
        View view2 = (View) RootViewUtil.a(view);
        if (view2 == null) {
            float[] fArr = new float[6];
            fArr[0] = -1234567.0f;
            return fArr;
        }
        int[] iArr = new int[4];
        computeBoundingBox(view2, iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        computeBoundingBox(view, iArr);
        iArr[0] = iArr[0] - i2;
        iArr[1] = iArr[1] - i3;
        float[] fArr2 = new float[6];
        fArr2[0] = PixelUtil.a(view.getLeft());
        fArr2[1] = PixelUtil.a(view.getTop());
        for (int i4 = 2; i4 < 6; i4++) {
            fArr2[i4] = PixelUtil.a(iArr[i4 - 2]);
        }
        return fArr2;
    }

    public static void scrollTo(View view, double d2, double d3, boolean z) {
        int iRound = Math.round(PixelUtil.b((float) d2));
        int iRound2 = Math.round(PixelUtil.b((float) d3));
        boolean z2 = view instanceof ReactHorizontalScrollView;
        if (!z2) {
            if (view instanceof ReactSwipeRefreshLayout) {
                view = findScrollView((ReactSwipeRefreshLayout) view);
            }
            if (!(view instanceof ReactScrollView)) {
                Log.w("REANIMATED", "NativeMethodsHelper: Unhandled scroll view type - allowed only {ReactScrollView, ReactHorizontalScrollView}");
                return;
            }
        }
        if (!z) {
            view.scrollTo(iRound, iRound2);
        } else if (z2) {
            view.post(new a(view, iRound, iRound2, 0));
        } else {
            view.post(new a(view, iRound, iRound2, 1));
        }
    }
}
