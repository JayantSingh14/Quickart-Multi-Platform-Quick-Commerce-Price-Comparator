package com.airbnb.lottie.model.layer;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.parser.DropShadowEffect;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class ImageLayer extends BaseLayer {
    public final LPaint D;
    public final Rect E;
    public final Rect F;
    public final LottieImageAsset G;
    public ValueCallbackKeyframeAnimation H;
    public ValueCallbackKeyframeAnimation I;
    public final DropShadowKeyframeAnimation J;

    public ImageLayer(LottieDrawable lottieDrawable, Layer layer) {
        LottieImageAsset lottieImageAsset;
        super(lottieDrawable, layer);
        this.D = new LPaint(3);
        this.E = new Rect();
        this.F = new Rect();
        LottieComposition lottieComposition = lottieDrawable.f14152a;
        if (lottieComposition == null) {
            lottieImageAsset = null;
        } else {
            lottieImageAsset = (LottieImageAsset) ((HashMap) lottieComposition.c()).get(layer.f14644g);
        }
        this.G = lottieImageAsset;
        DropShadowEffect dropShadowEffect = this.p.x;
        if (dropShadowEffect != null) {
            this.J = new DropShadowKeyframeAnimation(this, this, dropShadowEffect);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        super.d(colorFilter, lottieValueCallback);
        if (colorFilter == LottieProperty.F) {
            this.H = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        } else if (colorFilter == LottieProperty.I) {
            this.I = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
        }
    }

    @Override // com.airbnb.lottie.model.layer.BaseLayer, com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        super.f(rectF, matrix, z);
        if (this.G != null) {
            float fC = Utils.c();
            rectF.set(0.0f, 0.0f, r3.f14172a * fC, r3.f14173b * fC);
            this.n.mapRect(rectF);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0134  */
    @Override // com.airbnb.lottie.model.layer.BaseLayer
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(android.graphics.Canvas r17, android.graphics.Matrix r18, int r19) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.model.layer.ImageLayer.l(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }
}
