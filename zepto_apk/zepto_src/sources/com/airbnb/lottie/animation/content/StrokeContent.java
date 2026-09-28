package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class StrokeContent extends BaseStrokeContent {
    public final BaseLayer r;
    public final String s;
    public final boolean t;
    public final ColorKeyframeAnimation u;
    public ValueCallbackKeyframeAnimation v;

    /* JADX WARN: Illegal instructions before constructor call */
    public StrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeStroke shapeStroke) {
        int iOrdinal = shapeStroke.f14601g.ordinal();
        Paint.Cap cap = iOrdinal != 0 ? iOrdinal != 1 ? Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        int iOrdinal2 = shapeStroke.f14602h.ordinal();
        super(lottieDrawable, baseLayer, cap, iOrdinal2 != 0 ? iOrdinal2 != 1 ? iOrdinal2 != 2 ? null : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER, shapeStroke.f14603i, shapeStroke.f14599e, shapeStroke.f14600f, shapeStroke.f14597c, shapeStroke.f14596b);
        this.r = baseLayer;
        this.s = shapeStroke.f14595a;
        this.t = shapeStroke.f14604j;
        BaseKeyframeAnimation baseKeyframeAnimationA = shapeStroke.f14598d.a();
        this.u = (ColorKeyframeAnimation) baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.g(baseKeyframeAnimationA);
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        super.d(colorFilter, lottieValueCallback);
        PointF pointF = LottieProperty.f14178a;
        ColorKeyframeAnimation colorKeyframeAnimation = this.u;
        if (colorFilter == 2) {
            colorKeyframeAnimation.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.F) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.v;
            BaseLayer baseLayer = this.r;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.q(valueCallbackKeyframeAnimation);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.v = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            baseLayer.g(colorKeyframeAnimation);
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.s;
    }

    @Override // com.airbnb.lottie.animation.content.BaseStrokeContent, com.airbnb.lottie.animation.content.DrawingContent
    public final void h(Canvas canvas, Matrix matrix, int i2) {
        if (this.t) {
            return;
        }
        LPaint lPaint = this.f14219i;
        ColorKeyframeAnimation colorKeyframeAnimation = this.u;
        lPaint.setColor(colorKeyframeAnimation.l(colorKeyframeAnimation.b(), colorKeyframeAnimation.d()));
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.v;
        if (valueCallbackKeyframeAnimation != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation.f());
        }
        super.h(canvas, matrix, i2);
    }
}
