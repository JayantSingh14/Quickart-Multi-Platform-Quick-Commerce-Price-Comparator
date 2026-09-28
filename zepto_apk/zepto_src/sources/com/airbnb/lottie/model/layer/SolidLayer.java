package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class SolidLayer extends BaseLayer {
    public final RectF D;
    public final LPaint E;
    public final float[] F;
    public final Path G;
    public final Layer H;
    public ValueCallbackKeyframeAnimation I;
    public ValueCallbackKeyframeAnimation J;

    public SolidLayer(LottieDrawable lottieDrawable, Layer layer) {
        super(lottieDrawable, layer);
        this.D = new RectF();
        LPaint lPaint = new LPaint();
        this.E = lPaint;
        this.F = new float[8];
        this.G = new Path();
        this.H = layer;
        lPaint.setAlpha(0);
        lPaint.setStyle(Paint.Style.FILL);
        lPaint.setColor(layer.f14649l);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        super.d(colorFilter, lottieValueCallback);
        if (colorFilter == LottieProperty.F) {
            this.I = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        } else if (colorFilter == 1) {
            this.J = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        super.f(rectF, matrix, z);
        RectF rectF2 = this.D;
        Layer layer = this.H;
        rectF2.set(0.0f, 0.0f, layer.f14647j, layer.f14648k);
        this.n.mapRect(rectF2);
        rectF.set(rectF2);
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer
    public final void l(Canvas canvas, Matrix matrix, int i2) {
        Layer layer = this.H;
        int iAlpha = Color.alpha(layer.f14649l);
        if (iAlpha == 0) {
            return;
        }
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.J;
        Integer num = valueCallbackKeyframeAnimation == null ? null : (Integer) valueCallbackKeyframeAnimation.f();
        LPaint lPaint = this.E;
        if (num != null) {
            lPaint.setColor(num.intValue());
        } else {
            lPaint.setColor(layer.f14649l);
        }
        int iIntValue = (int) ((((iAlpha / 255.0f) * (this.w.f14389j == null ? 100 : ((Integer) r2.f()).intValue())) / 100.0f) * (i2 / 255.0f) * 255.0f);
        lPaint.setAlpha(iIntValue);
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.I;
        if (valueCallbackKeyframeAnimation2 != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation2.f());
        }
        if (iIntValue > 0) {
            float[] fArr = this.F;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            float f2 = layer.f14647j;
            fArr[2] = f2;
            fArr[3] = 0.0f;
            fArr[4] = f2;
            float f3 = layer.f14648k;
            fArr[5] = f3;
            fArr[6] = 0.0f;
            fArr[7] = f3;
            matrix.mapPoints(fArr);
            Path path = this.G;
            path.reset();
            path.moveTo(fArr[0], fArr[1]);
            path.lineTo(fArr[2], fArr[3]);
            path.lineTo(fArr[4], fArr[5]);
            path.lineTo(fArr[6], fArr[7]);
            path.lineTo(fArr[0], fArr[1]);
            path.close();
            canvas.drawPath(path, lPaint);
        }
    }
}
