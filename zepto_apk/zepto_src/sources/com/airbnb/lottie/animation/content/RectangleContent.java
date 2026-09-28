package com.airbnb.lottie.animation.content;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.RectangleShape;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class RectangleContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, PathContent {

    /* renamed from: c, reason: collision with root package name */
    public final String f14294c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14295d;

    /* renamed from: e, reason: collision with root package name */
    public final LottieDrawable f14296e;

    /* renamed from: f, reason: collision with root package name */
    public final BaseKeyframeAnimation f14297f;

    /* renamed from: g, reason: collision with root package name */
    public final BaseKeyframeAnimation f14298g;

    /* renamed from: h, reason: collision with root package name */
    public final FloatKeyframeAnimation f14299h;

    /* renamed from: k, reason: collision with root package name */
    public boolean f14302k;

    /* renamed from: a, reason: collision with root package name */
    public final Path f14292a = new Path();

    /* renamed from: b, reason: collision with root package name */
    public final RectF f14293b = new RectF();

    /* renamed from: i, reason: collision with root package name */
    public final CompoundTrimPathContent f14300i = new CompoundTrimPathContent();

    /* renamed from: j, reason: collision with root package name */
    public BaseKeyframeAnimation f14301j = null;

    public RectangleContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, RectangleShape rectangleShape) {
        this.f14294c = rectangleShape.f14568a;
        this.f14295d = rectangleShape.f14572e;
        this.f14296e = lottieDrawable;
        BaseKeyframeAnimation baseKeyframeAnimationA = rectangleShape.f14569b.a();
        this.f14297f = baseKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA2 = rectangleShape.f14570c.a();
        this.f14298g = baseKeyframeAnimationA2;
        FloatKeyframeAnimation floatKeyframeAnimationA = rectangleShape.f14571d.a();
        this.f14299h = floatKeyframeAnimationA;
        baseLayer.g(baseKeyframeAnimationA);
        baseLayer.g(baseKeyframeAnimationA2);
        baseLayer.g(floatKeyframeAnimationA);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
        floatKeyframeAnimationA.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14302k = false;
        this.f14296e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.List r5, java.util.List r6) {
        /*
            r4 = this;
            r6 = 0
        L1:
            r0 = r5
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r1 = r0.size()
            if (r6 >= r1) goto L35
            java.lang.Object r0 = r0.get(r6)
            com.airbnb.lottie.animation.content.Content r0 = (com.airbnb.lottie.animation.content.Content) r0
            boolean r1 = r0 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r1 == 0) goto L28
            r1 = r0
            com.airbnb.lottie.animation.content.TrimPathContent r1 = (com.airbnb.lottie.animation.content.TrimPathContent) r1
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r2 = r1.f14325c
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r3 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.f14616a
            if (r2 != r3) goto L28
            com.airbnb.lottie.animation.content.CompoundTrimPathContent r0 = r4.f14300i
            java.util.ArrayList r0 = r0.f14226a
            r0.add(r1)
            r1.d(r4)
            goto L32
        L28:
            boolean r1 = r0 instanceof com.airbnb.lottie.animation.content.RoundedCornersContent
            if (r1 == 0) goto L32
            com.airbnb.lottie.animation.content.RoundedCornersContent r0 = (com.airbnb.lottie.animation.content.RoundedCornersContent) r0
            com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation r0 = r0.f14314b
            r4.f14301j = r0
        L32:
            int r6 = r6 + 1
            goto L1
        L35:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.RectangleContent.b(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        if (colorFilter == LottieProperty.f14184g) {
            this.f14298g.k(lottieValueCallback);
        } else if (colorFilter == LottieProperty.f14186i) {
            this.f14297f.k(lottieValueCallback);
        } else if (colorFilter == LottieProperty.f14185h) {
            this.f14299h.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14294c;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        float f2;
        BaseKeyframeAnimation baseKeyframeAnimation;
        boolean z = this.f14302k;
        Path path = this.f14292a;
        if (z) {
            return path;
        }
        path.reset();
        if (this.f14295d) {
            this.f14302k = true;
            return path;
        }
        PointF pointF = (PointF) this.f14298g.f();
        float f3 = pointF.x / 2.0f;
        float f4 = pointF.y / 2.0f;
        FloatKeyframeAnimation floatKeyframeAnimation = this.f14299h;
        float fL = floatKeyframeAnimation == null ? 0.0f : floatKeyframeAnimation.l();
        if (fL == 0.0f && (baseKeyframeAnimation = this.f14301j) != null) {
            fL = Math.min(((Float) baseKeyframeAnimation.f()).floatValue(), Math.min(f3, f4));
        }
        float fMin = Math.min(f3, f4);
        if (fL > fMin) {
            fL = fMin;
        }
        PointF pointF2 = (PointF) this.f14297f.f();
        path.moveTo(pointF2.x + f3, (pointF2.y - f4) + fL);
        path.lineTo(pointF2.x + f3, (pointF2.y + f4) - fL);
        RectF rectF = this.f14293b;
        if (fL > 0.0f) {
            float f5 = pointF2.x + f3;
            float f6 = fL * 2.0f;
            f2 = 2.0f;
            float f7 = pointF2.y + f4;
            rectF.set(f5 - f6, f7 - f6, f5, f7);
            path.arcTo(rectF, 0.0f, 90.0f, false);
        } else {
            f2 = 2.0f;
        }
        path.lineTo((pointF2.x - f3) + fL, pointF2.y + f4);
        if (fL > 0.0f) {
            float f8 = pointF2.x - f3;
            float f9 = pointF2.y + f4;
            float f10 = fL * f2;
            rectF.set(f8, f9 - f10, f10 + f8, f9);
            path.arcTo(rectF, 90.0f, 90.0f, false);
        }
        path.lineTo(pointF2.x - f3, (pointF2.y - f4) + fL);
        if (fL > 0.0f) {
            float f11 = pointF2.x - f3;
            float f12 = pointF2.y - f4;
            float f13 = fL * f2;
            rectF.set(f11, f12, f11 + f13, f13 + f12);
            path.arcTo(rectF, 180.0f, 90.0f, false);
        }
        path.lineTo((pointF2.x + f3) - fL, pointF2.y - f4);
        if (fL > 0.0f) {
            float f14 = pointF2.x + f3;
            float f15 = fL * f2;
            float f16 = pointF2.y - f4;
            rectF.set(f14 - f15, f16, f14, f15 + f16);
            path.arcTo(rectF, 270.0f, 90.0f, false);
        }
        path.close();
        this.f14300i.a(path);
        this.f14302k = true;
        return path;
    }
}
