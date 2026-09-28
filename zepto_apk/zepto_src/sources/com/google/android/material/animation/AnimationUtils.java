package com.google.android.material.animation;

import android.support.v4.media.a;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo
/* loaded from: classes4.dex */
public class AnimationUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f39816a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final FastOutSlowInInterpolator f39817b = new FastOutSlowInInterpolator();

    /* renamed from: c, reason: collision with root package name */
    public static final FastOutLinearInInterpolator f39818c = new FastOutLinearInInterpolator();

    /* renamed from: d, reason: collision with root package name */
    public static final LinearOutSlowInInterpolator f39819d = new LinearOutSlowInInterpolator();

    /* renamed from: e, reason: collision with root package name */
    public static final DecelerateInterpolator f39820e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return a.a(f3, f2, f4, f2);
    }

    public static float b(float f2, float f3, float f4, float f5, float f6) {
        return f6 <= f4 ? f2 : f6 >= f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }

    public static int c(float f2, int i2, int i3) {
        return Math.round(f2 * (i3 - i2)) + i2;
    }
}
