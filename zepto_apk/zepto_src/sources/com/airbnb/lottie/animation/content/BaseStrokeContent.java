package com.airbnb.lottie.animation.content;

import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.RectF;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.LPaint;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.DropShadowKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.IntegerKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.ValueCallbackKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public abstract class BaseStrokeContent implements BaseKeyframeAnimation.AnimationListener, KeyPathElementContent, DrawingContent {

    /* renamed from: e, reason: collision with root package name */
    public final LottieDrawable f14215e;

    /* renamed from: f, reason: collision with root package name */
    public final BaseLayer f14216f;

    /* renamed from: h, reason: collision with root package name */
    public final float[] f14218h;

    /* renamed from: i, reason: collision with root package name */
    public final LPaint f14219i;

    /* renamed from: j, reason: collision with root package name */
    public final FloatKeyframeAnimation f14220j;

    /* renamed from: k, reason: collision with root package name */
    public final IntegerKeyframeAnimation f14221k;

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f14222l;

    /* renamed from: m, reason: collision with root package name */
    public final FloatKeyframeAnimation f14223m;
    public ValueCallbackKeyframeAnimation n;
    public BaseKeyframeAnimation o;
    public float p;
    public final DropShadowKeyframeAnimation q;

    /* renamed from: a, reason: collision with root package name */
    public final PathMeasure f14211a = new PathMeasure();

    /* renamed from: b, reason: collision with root package name */
    public final Path f14212b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final Path f14213c = new Path();

    /* renamed from: d, reason: collision with root package name */
    public final RectF f14214d = new RectF();

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f14217g = new ArrayList();

    public static final class PathGroup {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f14224a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final TrimPathContent f14225b;

        public PathGroup(TrimPathContent trimPathContent) {
            this.f14225b = trimPathContent;
        }
    }

    public BaseStrokeContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Paint.Cap cap, Paint.Join join, float f2, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue, ArrayList arrayList, AnimatableFloatValue animatableFloatValue2) {
        LPaint lPaint = new LPaint(1);
        this.f14219i = lPaint;
        this.p = 0.0f;
        this.f14215e = lottieDrawable;
        this.f14216f = baseLayer;
        lPaint.setStyle(Paint.Style.STROKE);
        lPaint.setStrokeCap(cap);
        lPaint.setStrokeJoin(join);
        lPaint.setStrokeMiter(f2);
        this.f14221k = (IntegerKeyframeAnimation) animatableIntegerValue.a();
        this.f14220j = animatableFloatValue.a();
        if (animatableFloatValue2 == null) {
            this.f14223m = null;
        } else {
            this.f14223m = animatableFloatValue2.a();
        }
        this.f14222l = new ArrayList(arrayList.size());
        this.f14218h = new float[arrayList.size()];
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.f14222l.add(((AnimatableFloatValue) arrayList.get(i2)).a());
        }
        baseLayer.g(this.f14221k);
        baseLayer.g(this.f14220j);
        for (int i3 = 0; i3 < this.f14222l.size(); i3++) {
            baseLayer.g((BaseKeyframeAnimation) this.f14222l.get(i3));
        }
        FloatKeyframeAnimation floatKeyframeAnimation = this.f14223m;
        if (floatKeyframeAnimation != null) {
            baseLayer.g(floatKeyframeAnimation);
        }
        this.f14221k.a(this);
        this.f14220j.a(this);
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ((BaseKeyframeAnimation) this.f14222l.get(i4)).a(this);
        }
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f14223m;
        if (floatKeyframeAnimation2 != null) {
            floatKeyframeAnimation2.a(this);
        }
        if (baseLayer.m() != null) {
            FloatKeyframeAnimation floatKeyframeAnimationA = baseLayer.m().f14501a.a();
            this.o = floatKeyframeAnimationA;
            floatKeyframeAnimationA.a(this);
            baseLayer.g(this.o);
        }
        if (baseLayer.n() != null) {
            this.q = new DropShadowKeyframeAnimation(this, baseLayer, baseLayer.n());
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14215e.invalidateSelf();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    @Override // com.airbnb.lottie.animation.content.Content
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.util.List r8, java.util.List r9) {
        /*
            r7 = this;
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            int r0 = r8.size()
            int r0 = r0 + (-1)
            r1 = 0
            r2 = r1
        La:
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r3 = com.airbnb.lottie.model.content.ShapeTrimPath.Type.f14617b
            if (r0 < 0) goto L22
            java.lang.Object r4 = r8.get(r0)
            com.airbnb.lottie.animation.content.Content r4 = (com.airbnb.lottie.animation.content.Content) r4
            boolean r5 = r4 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r5 == 0) goto L1f
            com.airbnb.lottie.animation.content.TrimPathContent r4 = (com.airbnb.lottie.animation.content.TrimPathContent) r4
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r5 = r4.f14325c
            if (r5 != r3) goto L1f
            r2 = r4
        L1f:
            int r0 = r0 + (-1)
            goto La
        L22:
            if (r2 == 0) goto L27
            r2.d(r7)
        L27:
            int r8 = r9.size()
            int r8 = r8 + (-1)
        L2d:
            java.util.ArrayList r0 = r7.f14217g
            if (r8 < 0) goto L66
            java.lang.Object r4 = r9.get(r8)
            com.airbnb.lottie.animation.content.Content r4 = (com.airbnb.lottie.animation.content.Content) r4
            boolean r5 = r4 instanceof com.airbnb.lottie.animation.content.TrimPathContent
            if (r5 == 0) goto L51
            r5 = r4
            com.airbnb.lottie.animation.content.TrimPathContent r5 = (com.airbnb.lottie.animation.content.TrimPathContent) r5
            com.airbnb.lottie.model.content.ShapeTrimPath$Type r6 = r5.f14325c
            if (r6 != r3) goto L51
            if (r1 == 0) goto L47
            r0.add(r1)
        L47:
            com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup r0 = new com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup
            r0.<init>(r5)
            r5.d(r7)
            r1 = r0
            goto L63
        L51:
            boolean r0 = r4 instanceof com.airbnb.lottie.animation.content.PathContent
            if (r0 == 0) goto L63
            if (r1 != 0) goto L5c
            com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup r1 = new com.airbnb.lottie.animation.content.BaseStrokeContent$PathGroup
            r1.<init>(r2)
        L5c:
            java.util.ArrayList r0 = r1.f14224a
            com.airbnb.lottie.animation.content.PathContent r4 = (com.airbnb.lottie.animation.content.PathContent) r4
            r0.add(r4)
        L63:
            int r8 = r8 + (-1)
            goto L2d
        L66:
            if (r1 == 0) goto L6b
            r0.add(r1)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.BaseStrokeContent.b(java.util.List, java.util.List):void");
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        PointF pointF = LottieProperty.f14178a;
        if (colorFilter == 4) {
            this.f14221k.k(lottieValueCallback);
            return;
        }
        if (colorFilter == LottieProperty.n) {
            this.f14220j.k(lottieValueCallback);
            return;
        }
        ColorFilter colorFilter2 = LottieProperty.F;
        BaseLayer baseLayer = this.f14216f;
        if (colorFilter == colorFilter2) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.n;
            if (valueCallbackKeyframeAnimation != null) {
                baseLayer.q(valueCallbackKeyframeAnimation);
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.n = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a(this);
            baseLayer.g(this.n);
            return;
        }
        if (colorFilter == LottieProperty.f14182e) {
            BaseKeyframeAnimation baseKeyframeAnimation = this.o;
            if (baseKeyframeAnimation != null) {
                baseKeyframeAnimation.k(lottieValueCallback);
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.o = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a(this);
            baseLayer.g(this.o);
            return;
        }
        DropShadowKeyframeAnimation dropShadowKeyframeAnimation = this.q;
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
        NetworkFetcher networkFetcher = L.f14106a;
        Path path = this.f14212b;
        path.reset();
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14217g;
            if (i2 >= arrayList.size()) {
                RectF rectF2 = this.f14214d;
                path.computeBounds(rectF2, false);
                float fL = this.f14220j.l() / 2.0f;
                rectF2.set(rectF2.left - fL, rectF2.top - fL, rectF2.right + fL, rectF2.bottom + fL);
                rectF.set(rectF2);
                rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
                NetworkFetcher networkFetcher2 = L.f14106a;
                return;
            }
            PathGroup pathGroup = (PathGroup) arrayList.get(i2);
            for (int i3 = 0; i3 < pathGroup.f14224a.size(); i3++) {
                path.addPath(((PathContent) pathGroup.f14224a.get(i3)).j(), matrix);
            }
            i2++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0213  */
    @Override // com.airbnb.lottie.animation.content.DrawingContent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(android.graphics.Canvas r20, android.graphics.Matrix r21, int r22) {
        /*
            Method dump skipped, instructions count: 639
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.animation.content.BaseStrokeContent.h(android.graphics.Canvas, android.graphics.Matrix, int):void");
    }
}
