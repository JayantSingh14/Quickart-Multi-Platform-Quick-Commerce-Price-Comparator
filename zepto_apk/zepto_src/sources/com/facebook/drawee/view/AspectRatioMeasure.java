package com.facebook.drawee.view;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.infer.annotation.Nullsafe;

@Nullsafe
/* loaded from: classes3.dex */
public class AspectRatioMeasure {

    public static class Spec {

        /* renamed from: a, reason: collision with root package name */
        public int f17445a;

        /* renamed from: b, reason: collision with root package name */
        public int f17446b;
    }

    public static void a(Spec spec, float f2, ViewGroup.LayoutParams layoutParams, int i2, int i3) {
        if (f2 <= 0.0f || layoutParams == null) {
            return;
        }
        int i4 = layoutParams.height;
        if (i4 == 0 || i4 == -2) {
            spec.f17446b = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(spec.f17445a) - i2) / f2) + i3), spec.f17446b), 1073741824);
            return;
        }
        int i5 = layoutParams.width;
        if (i5 == 0 || i5 == -2) {
            spec.f17445a = View.MeasureSpec.makeMeasureSpec(View.resolveSize((int) (((View.MeasureSpec.getSize(spec.f17446b) - i3) * f2) + i2), spec.f17445a), 1073741824);
        }
    }
}
