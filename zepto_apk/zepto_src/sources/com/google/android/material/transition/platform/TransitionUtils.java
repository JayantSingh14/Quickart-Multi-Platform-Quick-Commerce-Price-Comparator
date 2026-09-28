package com.google.android.material.transition.platform;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.media.b;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.google.android.material.canvas.CanvasCompat;

@RequiresApi
/* loaded from: classes4.dex */
class TransitionUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final RectF f41653a = new RectF();

    public interface CornerSizeBinaryOperator {
    }

    public static View a(int i2, View view) throws Resources.NotFoundException {
        String resourceName = view.getResources().getResourceName(i2);
        while (view != null) {
            if (view.getId() != i2) {
                Object parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(b.k(resourceName, " is not a valid ancestor"));
    }

    public static RectF b(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new RectF(iArr[0], iArr[1], view.getWidth() + r1, view.getHeight() + r0);
    }

    public static float c(float f2, float f3, float f4) {
        return android.support.v4.media.a.a(f3, f2, f4, f2);
    }

    public static float d(float f2, float f3, float f4, float f5, float f6, boolean z) {
        return (!z || (f6 >= 0.0f && f6 <= 1.0f)) ? f6 < f4 ? f2 : f6 > f5 ? f3 : c(f2, f3, (f6 - f4) / (f5 - f4)) : c(f2, f3, f6);
    }

    public static int e(float f2, float f3, float f4, int i2, int i3) {
        return f4 < f2 ? i2 : f4 > f3 ? i3 : (int) c(i2, i3, (f4 - f2) / (f3 - f2));
    }

    public static void f(Canvas canvas, Rect rect, float f2, float f3, float f4, int i2, CanvasCompat.CanvasOperation canvasOperation) {
        if (i2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(f2, f3);
        canvas.scale(f4, f4);
        if (i2 < 255) {
            RectF rectF = f41653a;
            rectF.set(rect);
            canvas.saveLayerAlpha(rectF, i2);
        }
        canvasOperation.a(canvas);
        canvas.restoreToCount(iSave);
    }
}
