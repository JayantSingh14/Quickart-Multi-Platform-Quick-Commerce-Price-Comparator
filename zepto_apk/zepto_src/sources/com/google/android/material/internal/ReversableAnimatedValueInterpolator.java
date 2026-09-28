package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.RestrictTo;

@RestrictTo
/* loaded from: classes4.dex */
public class ReversableAnimatedValueInterpolator implements TimeInterpolator {

    /* renamed from: a, reason: collision with root package name */
    public final Interpolator f40611a;

    public ReversableAnimatedValueInterpolator(Interpolator interpolator) {
        this.f40611a = interpolator;
    }

    public static TimeInterpolator a(boolean z, Interpolator interpolator) {
        return z ? interpolator : new ReversableAnimatedValueInterpolator(interpolator);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        return 1.0f - this.f40611a.getInterpolation(f2);
    }
}
