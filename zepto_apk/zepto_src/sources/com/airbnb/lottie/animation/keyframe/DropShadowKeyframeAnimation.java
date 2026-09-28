package com.airbnb.lottie.animation.keyframe;

import android.graphics.Color;
import android.graphics.Matrix;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class DropShadowKeyframeAnimation implements BaseKeyframeAnimation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final BaseLayer f14343a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f14344b;

    /* renamed from: c, reason: collision with root package name */
    public final ColorKeyframeAnimation f14345c;

    /* renamed from: d, reason: collision with root package name */
    public final FloatKeyframeAnimation f14346d;

    /* renamed from: e, reason: collision with root package name */
    public final FloatKeyframeAnimation f14347e;

    /* renamed from: f, reason: collision with root package name */
    public final FloatKeyframeAnimation f14348f;

    /* renamed from: g, reason: collision with root package name */
    public final FloatKeyframeAnimation f14349g;

    /* renamed from: h, reason: collision with root package name */
    public float f14350h = Float.NaN;

    /* renamed from: i, reason: collision with root package name */
    public float f14351i = Float.NaN;

    /* renamed from: j, reason: collision with root package name */
    public float f14352j = Float.NaN;

    /* renamed from: k, reason: collision with root package name */
    public int f14353k = 0;

    /* renamed from: l, reason: collision with root package name */
    public final float[] f14354l = new float[9];

    public DropShadowKeyframeAnimation(BaseKeyframeAnimation.AnimationListener animationListener, BaseLayer baseLayer, DropShadowEffect dropShadowEffect) {
        this.f14344b = animationListener;
        this.f14343a = baseLayer;
        BaseKeyframeAnimation baseKeyframeAnimationA = dropShadowEffect.f14693a.a();
        this.f14345c = (ColorKeyframeAnimation) baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.g(baseKeyframeAnimationA);
        FloatKeyframeAnimation floatKeyframeAnimationA = dropShadowEffect.f14694b.a();
        this.f14346d = floatKeyframeAnimationA;
        floatKeyframeAnimationA.a(this);
        baseLayer.g(floatKeyframeAnimationA);
        FloatKeyframeAnimation floatKeyframeAnimationA2 = dropShadowEffect.f14695c.a();
        this.f14347e = floatKeyframeAnimationA2;
        floatKeyframeAnimationA2.a(this);
        baseLayer.g(floatKeyframeAnimationA2);
        FloatKeyframeAnimation floatKeyframeAnimationA3 = dropShadowEffect.f14696d.a();
        this.f14348f = floatKeyframeAnimationA3;
        floatKeyframeAnimationA3.a(this);
        baseLayer.g(floatKeyframeAnimationA3);
        FloatKeyframeAnimation floatKeyframeAnimationA4 = dropShadowEffect.f14697e.a();
        this.f14349g = floatKeyframeAnimationA4;
        floatKeyframeAnimationA4.a(this);
        baseLayer.g(floatKeyframeAnimationA4);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener, java.lang.Object] */
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14344b.a();
    }

    public final void b(LPaint lPaint, Matrix matrix, int i2) {
        float fL = this.f14347e.l() * 0.017453292f;
        float fFloatValue = ((Float) this.f14348f.f()).floatValue();
        double d2 = fL;
        float fSin = ((float) Math.sin(d2)) * fFloatValue;
        float fCos = ((float) Math.cos(d2 + 3.141592653589793d)) * fFloatValue;
        Matrix matrixE = this.f14343a.w.e();
        float[] fArr = this.f14354l;
        matrixE.getValues(fArr);
        float f2 = fArr[0];
        float f3 = fArr[4];
        matrix.getValues(fArr);
        float f4 = fArr[0] / f2;
        float f5 = fSin * f4;
        float f6 = fCos * (fArr[4] / f3);
        int iIntValue = ((Integer) this.f14345c.f()).intValue();
        int iArgb = Color.argb(Math.round((((Float) this.f14346d.f()).floatValue() * i2) / 255.0f), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue));
        float fMax = Math.max(((Float) this.f14349g.f()).floatValue() * f4 * 0.33f, Float.MIN_VALUE);
        if (this.f14350h == fMax && this.f14351i == f5 && this.f14352j == f6 && this.f14353k == iArgb) {
            return;
        }
        this.f14350h = fMax;
        this.f14351i = f5;
        this.f14352j = f6;
        this.f14353k = iArgb;
        lPaint.setShadowLayer(fMax, f5, f6, iArgb);
    }

    public final void c(final LottieValueCallback lottieValueCallback) {
        this.f14346d.k(new LottieValueCallback<Float>() { // from class: com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation.1
            @Override // com.airbnb.lottie.value.LottieValueCallback
            public final Object a(LottieFrameInfo lottieFrameInfo) {
                Float f2 = (Float) lottieValueCallback.f14837b;
                if (f2 == null) {
                    return null;
                }
                return Float.valueOf(f2.floatValue() * 2.55f);
            }
        });
    }
}
