package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.GradientColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.GradientColor;
import com.airbnb.lottie.model.content.GradientStroke;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    public final PointKeyframeAnimation A;
    public ValueCallbackKeyframeAnimation B;
    public final String r;
    public final boolean s;
    public final LongSparseArray t;
    public final LongSparseArray u;
    public final RectF v;
    public final GradientType w;
    public final int x;
    public final GradientColorKeyframeAnimation y;
    public final PointKeyframeAnimation z;

    /* JADX WARN: Illegal instructions before constructor call */
    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, GradientStroke gradientStroke) {
        int iOrdinal = gradientStroke.f14524h.ordinal();
        Paint.Cap cap = iOrdinal != 0 ? iOrdinal != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iOrdinal2 = gradientStroke.f14525i.ordinal();
        super(lottieDrawable, baseLayer, cap, iOrdinal2 != 0 ? iOrdinal2 != 1 ? iOrdinal2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, gradientStroke.f14526j, gradientStroke.f14520d, gradientStroke.f14523g, gradientStroke.f14527k, gradientStroke.f14528l);
        this.t = new LongSparseArray();
        this.u = new LongSparseArray();
        this.v = new RectF();
        this.r = gradientStroke.f14517a;
        this.w = gradientStroke.f14518b;
        this.s = gradientStroke.f14529m;
        this.x = (int) (lottieDrawable.f14152a.b() / 32.0f);
        BaseKeyframeAnimation baseKeyframeAnimationA = gradientStroke.f14519c.a();
        this.y = (GradientColorKeyframeAnimation) baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.g(baseKeyframeAnimationA);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = gradientStroke.f14521e.a();
        this.z = (PointKeyframeAnimation) baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.g(baseKeyframeAnimationA2);
        BaseKeyframeAnimation baseKeyframeAnimationA3 = gradientStroke.f14522f.a();
        this.A = (PointKeyframeAnimation) baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a(this);
        baseLayer.g(baseKeyframeAnimationA3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        super.d(colorFilter, lottieValueCallback);
        if (colorFilter == LottieProperty.G) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.B;
            BaseLayer baseLayer = this.f14216f;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.q(valueCallbackKeyframeAnimation);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.B = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            baseLayer.g(this.B);
        }
    }

    public final int[] g(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.B;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.f();
            int i2 = 0;
            if (iArr.length == numArr.length) {
                while (i2 < iArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i2 < numArr.length) {
                    iArr[i2] = numArr[i2].intValue();
                    i2++;
                }
            }
        }
        return iArr;
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.r;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public final void h(Canvas canvas, Matrix matrix, int i2) {
        Shader shader;
        Shader radialGradient;
        if (this.s) {
            return;
        }
        f(this.v, matrix, false);
        GradientType gradientType = GradientType.f14530a;
        GradientColorKeyframeAnimation gradientColorKeyframeAnimation = this.y;
        PointKeyframeAnimation pointKeyframeAnimation = this.A;
        PointKeyframeAnimation pointKeyframeAnimation2 = this.z;
        if (this.w == gradientType) {
            long jI = i();
            LongSparseArray longSparseArray = this.t;
            shader = (LinearGradient) longSparseArray.c(jI);
            if (shader == null) {
                PointF pointF = (PointF) pointKeyframeAnimation2.f();
                PointF pointF2 = (PointF) pointKeyframeAnimation.f();
                GradientColor gradientColor = (GradientColor) gradientColorKeyframeAnimation.f();
                radialGradient = new LinearGradient(pointF.x, pointF.y, pointF2.x, pointF2.y, g(gradientColor.f14508b), gradientColor.f14507a, Shader.TileMode.CLAMP);
                longSparseArray.g(jI, radialGradient);
                shader = radialGradient;
            }
        } else {
            long jI2 = i();
            LongSparseArray longSparseArray2 = this.u;
            shader = (RadialGradient) longSparseArray2.c(jI2);
            if (shader == null) {
                PointF pointF3 = (PointF) pointKeyframeAnimation2.f();
                PointF pointF4 = (PointF) pointKeyframeAnimation.f();
                GradientColor gradientColor2 = (GradientColor) gradientColorKeyframeAnimation.f();
                int[] iArrG = g(gradientColor2.f14508b);
                radialGradient = new RadialGradient(pointF3.x, pointF3.y, (float) Math.hypot(pointF4.x - r10, pointF4.y - r11), iArrG, gradientColor2.f14507a, Shader.TileMode.CLAMP);
                longSparseArray2.g(jI2, radialGradient);
                shader = radialGradient;
            }
        }
        this.f14219i.setShader(shader);
        super.h(canvas, matrix, i2);
    }

    public final int i() {
        float f2 = this.z.f14332d;
        float f3 = this.x;
        int iRound = Math.round(f2 * f3);
        int iRound2 = Math.round(this.A.f14332d * f3);
        int iRound3 = Math.round(this.y.f14332d * f3);
        int i2 = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i2 = i2 * 31 * iRound2;
        }
        return iRound3 != 0 ? i2 * 31 * iRound3 : i2;
    }
}
