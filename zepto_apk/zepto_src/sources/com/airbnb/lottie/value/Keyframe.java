package com.airbnb.lottie.value;

import android.graphics.PointF;
import android.view.animation.BaseInterpolator;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.content.GradientColor;

/* loaded from: classes3.dex */
public class Keyframe<T> {

    /* renamed from: a, reason: collision with root package name */
    public final LottieComposition f14815a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14816b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14817c;

    /* renamed from: d, reason: collision with root package name */
    public final BaseInterpolator f14818d;

    /* renamed from: e, reason: collision with root package name */
    public final BaseInterpolator f14819e;

    /* renamed from: f, reason: collision with root package name */
    public final BaseInterpolator f14820f;

    /* renamed from: g, reason: collision with root package name */
    public final float f14821g;

    /* renamed from: h, reason: collision with root package name */
    public Float f14822h;

    /* renamed from: i, reason: collision with root package name */
    public float f14823i;

    /* renamed from: j, reason: collision with root package name */
    public float f14824j;

    /* renamed from: k, reason: collision with root package name */
    public int f14825k;

    /* renamed from: l, reason: collision with root package name */
    public int f14826l;

    /* renamed from: m, reason: collision with root package name */
    public float f14827m;
    public float n;
    public PointF o;
    public PointF p;

    public Keyframe(LottieComposition lottieComposition, Object obj, Object obj2, BaseInterpolator baseInterpolator, float f2, Float f3) {
        this.f14823i = -3987645.8f;
        this.f14824j = -3987645.8f;
        this.f14825k = 784923401;
        this.f14826l = 784923401;
        this.f14827m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f14815a = lottieComposition;
        this.f14816b = obj;
        this.f14817c = obj2;
        this.f14818d = baseInterpolator;
        this.f14819e = null;
        this.f14820f = null;
        this.f14821g = f2;
        this.f14822h = f3;
    }

    public final float a() {
        LottieComposition lottieComposition = this.f14815a;
        if (lottieComposition == null) {
            return 1.0f;
        }
        if (this.n == Float.MIN_VALUE) {
            if (this.f14822h == null) {
                this.n = 1.0f;
            } else {
                this.n = ((this.f14822h.floatValue() - this.f14821g) / (lottieComposition.f14147m - lottieComposition.f14146l)) + b();
            }
        }
        return this.n;
    }

    public final float b() {
        LottieComposition lottieComposition = this.f14815a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.f14827m == Float.MIN_VALUE) {
            float f2 = lottieComposition.f14146l;
            this.f14827m = (this.f14821g - f2) / (lottieComposition.f14147m - f2);
        }
        return this.f14827m;
    }

    public final boolean c() {
        return this.f14818d == null && this.f14819e == null && this.f14820f == null;
    }

    public final String toString() {
        return "Keyframe{startValue=" + this.f14816b + ", endValue=" + this.f14817c + ", startFrame=" + this.f14821g + ", endFrame=" + this.f14822h + ", interpolator=" + this.f14818d + '}';
    }

    public Keyframe(LottieComposition lottieComposition, Object obj, Object obj2, BaseInterpolator baseInterpolator, BaseInterpolator baseInterpolator2, float f2) {
        this.f14823i = -3987645.8f;
        this.f14824j = -3987645.8f;
        this.f14825k = 784923401;
        this.f14826l = 784923401;
        this.f14827m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f14815a = lottieComposition;
        this.f14816b = obj;
        this.f14817c = obj2;
        this.f14818d = null;
        this.f14819e = baseInterpolator;
        this.f14820f = baseInterpolator2;
        this.f14821g = f2;
        this.f14822h = null;
    }

    public Keyframe(LottieComposition lottieComposition, Object obj, Object obj2, BaseInterpolator baseInterpolator, BaseInterpolator baseInterpolator2, BaseInterpolator baseInterpolator3, float f2, Float f3) {
        this.f14823i = -3987645.8f;
        this.f14824j = -3987645.8f;
        this.f14825k = 784923401;
        this.f14826l = 784923401;
        this.f14827m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f14815a = lottieComposition;
        this.f14816b = obj;
        this.f14817c = obj2;
        this.f14818d = baseInterpolator;
        this.f14819e = baseInterpolator2;
        this.f14820f = baseInterpolator3;
        this.f14821g = f2;
        this.f14822h = f3;
    }

    public Keyframe(Object obj) {
        this.f14823i = -3987645.8f;
        this.f14824j = -3987645.8f;
        this.f14825k = 784923401;
        this.f14826l = 784923401;
        this.f14827m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f14815a = null;
        this.f14816b = obj;
        this.f14817c = obj;
        this.f14818d = null;
        this.f14819e = null;
        this.f14820f = null;
        this.f14821g = Float.MIN_VALUE;
        this.f14822h = Float.valueOf(Float.MAX_VALUE);
    }

    public Keyframe(GradientColor gradientColor, GradientColor gradientColor2) {
        this.f14823i = -3987645.8f;
        this.f14824j = -3987645.8f;
        this.f14825k = 784923401;
        this.f14826l = 784923401;
        this.f14827m = Float.MIN_VALUE;
        this.n = Float.MIN_VALUE;
        this.o = null;
        this.p = null;
        this.f14815a = null;
        this.f14816b = gradientColor;
        this.f14817c = gradientColor2;
        this.f14818d = null;
        this.f14819e = null;
        this.f14820f = null;
        this.f14821g = Float.MIN_VALUE;
        this.f14822h = Float.valueOf(Float.MAX_VALUE);
    }
}
