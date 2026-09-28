package com.airbnb.lottie.animation.content;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.FloatKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.TransformKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.content.Repeater;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f14303a = new Matrix();

    /* renamed from: b, reason: collision with root package name */
    public final Path f14304b = new Path();

    /* renamed from: c, reason: collision with root package name */
    public final LottieDrawable f14305c;

    /* renamed from: d, reason: collision with root package name */
    public final BaseLayer f14306d;

    /* renamed from: e, reason: collision with root package name */
    public final String f14307e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14308f;

    /* renamed from: g, reason: collision with root package name */
    public final FloatKeyframeAnimation f14309g;

    /* renamed from: h, reason: collision with root package name */
    public final FloatKeyframeAnimation f14310h;

    /* renamed from: i, reason: collision with root package name */
    public final TransformKeyframeAnimation f14311i;

    /* renamed from: j, reason: collision with root package name */
    public ContentGroup f14312j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, Repeater repeater) {
        this.f14305c = lottieDrawable;
        this.f14306d = baseLayer;
        this.f14307e = repeater.f14573a;
        this.f14308f = repeater.f14577e;
        FloatKeyframeAnimation floatKeyframeAnimationA = repeater.f14574b.a();
        this.f14309g = floatKeyframeAnimationA;
        baseLayer.g(floatKeyframeAnimationA);
        floatKeyframeAnimationA.a(this);
        FloatKeyframeAnimation floatKeyframeAnimationA2 = repeater.f14575c.a();
        this.f14310h = floatKeyframeAnimationA2;
        baseLayer.g(floatKeyframeAnimationA2);
        floatKeyframeAnimationA2.a(this);
        AnimatableTransform animatableTransform = repeater.f14576d;
        animatableTransform.getClass();
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.f14311i = transformKeyframeAnimation;
        transformKeyframeAnimation.a(baseLayer);
        transformKeyframeAnimation.b(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14305c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        this.f14312j.b(list, list2);
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        if (this.f14311i.c(colorFilter, lottieValueCallback)) {
            return;
        }
        if (colorFilter == LottieProperty.p) {
            this.f14309g.k(lottieValueCallback);
        } else if (colorFilter == LottieProperty.q) {
            this.f14310h.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
        for (int i3 = 0; i3 < this.f14312j.f14234h.size(); i3++) {
            Content content = (Content) this.f14312j.f14234h.get(i3);
            if (content instanceof KeyPathElementContent) {
                MiscUtils.f(keyPath, i2, arrayList, keyPath2, (KeyPathElementContent) content);
            }
        }
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void f(RectF rectF, Matrix matrix, boolean z) {
        this.f14312j.f(rectF, matrix, z);
    }

    @Override // com.airbnb.lottie.animation.content.GreedyContent
    public final void g(ListIterator listIterator) {
        if (this.f14312j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add((Content) listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f14312j = new ContentGroup(this.f14305c, this.f14306d, "Repeater", this.f14308f, arrayList, null);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14307e;
    }

    @Override // com.airbnb.lottie.animation.content.DrawingContent
    public final void h(Canvas canvas, Matrix matrix, int i2) {
        float fFloatValue = ((Float) this.f14309g.f()).floatValue();
        float fFloatValue2 = ((Float) this.f14310h.f()).floatValue();
        TransformKeyframeAnimation transformKeyframeAnimation = this.f14311i;
        float fFloatValue3 = ((Float) transformKeyframeAnimation.f14392m.f()).floatValue() / 100.0f;
        float fFloatValue4 = ((Float) transformKeyframeAnimation.n.f()).floatValue() / 100.0f;
        for (int i3 = ((int) fFloatValue) - 1; i3 >= 0; i3--) {
            Matrix matrix2 = this.f14303a;
            matrix2.set(matrix);
            float f2 = i3;
            matrix2.preConcat(transformKeyframeAnimation.f(f2 + fFloatValue2));
            this.f14312j.h(canvas, matrix2, (int) (MiscUtils.e(fFloatValue3, fFloatValue4, f2 / fFloatValue) * i2));
        }
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        Path pathJ = this.f14312j.j();
        Path path = this.f14304b;
        path.reset();
        float fFloatValue = ((Float) this.f14309g.f()).floatValue();
        float fFloatValue2 = ((Float) this.f14310h.f()).floatValue();
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            Matrix matrix = this.f14303a;
            matrix.set(this.f14311i.f(i2 + fFloatValue2));
            path.addPath(pathJ, matrix);
        }
        return path;
    }
}
