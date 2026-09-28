package com.airbnb.lottie.animation.content;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ColorKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.content.ShapeFill;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FillContent implements DrawingContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a, reason: collision with root package name */
    public final Path f14246a;

    /* renamed from: b, reason: collision with root package name */
    public final LPaint f14247b;

    /* renamed from: c, reason: collision with root package name */
    public final BaseLayer f14248c;

    /* renamed from: d, reason: collision with root package name */
    public final String f14249d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14250e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f14251f;

    /* renamed from: g, reason: collision with root package name */
    public final ColorKeyframeAnimation f14252g;

    /* renamed from: h, reason: collision with root package name */
    public final IntegerKeyframeAnimation f14253h;

    /* renamed from: i, reason: collision with root package name */
    public ValueCallbackKeyframeAnimation f14254i;

    /* renamed from: j, reason: collision with root package name */
    public final LottieDrawable f14255j;

    /* renamed from: k, reason: collision with root package name */
    public BaseKeyframeAnimation f14256k;

    /* renamed from: l, reason: collision with root package name */
    public float f14257l;

    /* renamed from: m, reason: collision with root package name */
    public final DropShadowKeyframeAnimation f14258m;

    public FillContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, ShapeFill shapeFill) {
        Path path = new Path();
        this.f14246a = path;
        this.f14247b = new LPaint(1);
        this.f14251f = new ArrayList();
        this.f14248c = baseLayer;
        this.f14249d = shapeFill.f14584c;
        this.f14250e = shapeFill.f14587f;
        this.f14255j = lottieDrawable;
        if (baseLayer.m() != null) {
            FloatKeyframeAnimation floatKeyframeAnimationA = baseLayer.m().f14501a.a();
            this.f14256k = floatKeyframeAnimationA;
            floatKeyframeAnimationA.a(this);
            baseLayer.g(this.f14256k);
        }
        if (baseLayer.n() != null) {
            this.f14258m = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.n());
        }
        AnimatableColorValue animatableColorValue = shapeFill.f14585d;
        if (animatableColorValue == null) {
            this.f14252g = null;
            this.f14253h = null;
            return;
        }
        AnimatableIntegerValue animatableIntegerValue = shapeFill.f14586e;
        path.setFillType(shapeFill.f14583b);
        BaseKeyframeAnimation baseKeyframeAnimationA = animatableColorValue.a();
        this.f14252g = (ColorKeyframeAnimation) baseKeyframeAnimationA;
        baseKeyframeAnimationA.a(this);
        baseLayer.g(baseKeyframeAnimationA);
        BaseKeyframeAnimation baseKeyframeAnimationA2 = animatableIntegerValue.a();
        this.f14253h = (IntegerKeyframeAnimation) baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a(this);
        baseLayer.g(baseKeyframeAnimationA2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14255j.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        for (int i2 = 0; i2 < list2.size(); i2++) {
            Content content = (Content) list2.get(i2);
            if (content instanceof PathContent) {
                this.f14251f.add((PathContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        PointF pointF = LottieProperty.f14178a;
        if (colorFilter == 1) {
            this.f14252g.k(lottieValueCallback);
            return;
        }
        if (colorFilter == 4) {
            this.f14253h.k(lottieValueCallback);
            return;
        }
        ColorFilter colorFilter2 = LottieProperty.F;
        BaseLayer baseLayer = this.f14248c;
        if (colorFilter == colorFilter2) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f14254i;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.q(valueCallbackKeyframeAnimation);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f14254i = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            baseLayer.g(this.f14254i);
            return;
        }
        if (colorFilter == LottieProperty.f14182e) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.f14256k;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.k(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f14256k = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            baseLayer.g(this.f14256k);
            return;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f14258m;
        if (colorFilter == 5 && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.f14345c.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.B && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.c(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.C && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.f14347e.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.D && dropShadowKeyframeAnimation != null) {
            dropShadowKeyframeAnimation.f14348f.k(lottieValueCallback);
        } else {
            if (colorFilter != LottieProperty.E || dropShadowKeyframeAnimation == null) {
                return;
            }
            dropShadowKeyframeAnimation.f14349g.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        Path path = this.f14246a;
        path.reset();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14251f;
            if (i2 >= arrayList.size()) {
                path.computeBounds(rectF, false);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                return;
            } else {
                path.addPath(((PathContent) arrayList.get(i2)).j(), matrix);
                i2++;
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14249d;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void h(Canvas canvas, Matrix matrix, int i2) {
        BlurMaskFilter blurMaskFilter;
        if (this.f14250e) {
            return;
        }
        NetworkFetcher networkFetcher = L.f14106a;
        ColorKeyframeAnimation colorKeyframeAnimation = this.f14252g;
        int iL = colorKeyframeAnimation.l(colorKeyframeAnimation.b(), colorKeyframeAnimation.d());
        float f2 = i2 / 255.0f;
        int iIntValue = (int) (((((Integer) this.f14253h.f()).intValue() * f2) / 100.0f) * 255.0f);
        LPaint lPaint = this.f14247b;
        PointF pointF = MiscUtils.f14809a;
        int i3 = 0;
        lPaint.setColor((iL & 16777215) | (Math.max(0, Math.min(255, iIntValue)) << 24));
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f14254i;
        if (valueCallbackKeyframeAnimation != null) {
            lPaint.setColorFilter((ColorFilter) valueCallbackKeyframeAnimation.f());
        }
        BaseKeyframeAnimation baseKeyframeAnimation = this.f14256k;
        if (baseKeyframeAnimation != null) {
            float fFloatValue = ((Float) baseKeyframeAnimation.f()).floatValue();
            if (fFloatValue == 0.0f) {
                lPaint.setMaskFilter(null);
            } else if (fFloatValue != this.f14257l) {
                BaseLayer baseLayer = this.f14248c;
                if (baseLayer.A == fFloatValue) {
                    blurMaskFilter = baseLayer.B;
                } else {
                    BlurMaskFilter blurMaskFilter2 = new BlurMaskFilter(fFloatValue / 2.0f, BlurMaskFilter.Blur.NORMAL);
                    baseLayer.B = blurMaskFilter2;
                    baseLayer.A = fFloatValue;
                    blurMaskFilter = blurMaskFilter2;
                }
                lPaint.setMaskFilter(blurMaskFilter);
            }
            this.f14257l = fFloatValue;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.f14258m;
        if (dropShadowKeyframeAnimation != null) {
            ThreadLocal threadLocal = Utils.f14810a;
            dropShadowKeyframeAnimation.b(lPaint, matrix, (int) (((f2 * iIntValue) / 255.0f) * 255.0f));
        }
        Path path = this.f14246a;
        path.reset();
        while (true) {
            ArrayList arrayList = this.f14251f;
            if (i3 >= arrayList.size()) {
                canvas.drawPath(path, lPaint);
                NetworkFetcher networkFetcher2 = L.f14106a;
                return;
            } else {
                path.addPath(((PathContent) arrayList.get(i3)).j(), matrix);
                i3++;
            }
        }
    }
}
