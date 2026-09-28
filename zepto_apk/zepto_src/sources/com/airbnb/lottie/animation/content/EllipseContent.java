package com.airbnb.lottie.animation.content;

import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.PointKeyframeAnimation;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.content.CircleShape;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class EllipseContent implements PathContent, BaseKeyframeAnimation.AnimationListener, KeyPathElementContent {

    /* renamed from: b, reason: collision with root package name */
    public final String f14239b;

    /* renamed from: c, reason: collision with root package name */
    public final LottieDrawable f14240c;

    /* renamed from: d, reason: collision with root package name */
    public final PointKeyframeAnimation f14241d;

    /* renamed from: e, reason: collision with root package name */
    public final BaseKeyframeAnimation f14242e;

    /* renamed from: f, reason: collision with root package name */
    public final CircleShape f14243f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14245h;

    /* renamed from: a, reason: collision with root package name */
    public final Path f14238a = new Path();

    /* renamed from: g, reason: collision with root package name */
    public final CompoundTrimPathContent f14244g = new CompoundTrimPathContent();

    public EllipseContent(LottieDrawable lottieDrawable, BaseLayer baseLayer, CircleShape circleShape) {
        this.f14239b = circleShape.f14502a;
        this.f14240c = lottieDrawable;
        BaseKeyframeAnimation baseKeyframeAnimationA = circleShape.f14504c.a();
        this.f14241d = (PointKeyframeAnimation) baseKeyframeAnimationA;
        BaseKeyframeAnimation baseKeyframeAnimationA2 = circleShape.f14503b.a();
        this.f14242e = baseKeyframeAnimationA2;
        this.f14243f = circleShape;
        baseLayer.g(baseKeyframeAnimationA);
        baseLayer.g(baseKeyframeAnimationA2);
        baseKeyframeAnimationA.a(this);
        baseKeyframeAnimationA2.a(this);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener
    public final void a() {
        this.f14245h = false;
        this.f14240c.invalidateSelf();
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final void b(List list, List list2) {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = (ArrayList) list;
            if (i2 >= arrayList.size()) {
                return;
            }
            Content content = (Content) arrayList.get(i2);
            if (content instanceof TrimPathContent) {
                TrimPathContent trimPathContent = (TrimPathContent) content;
                if (trimPathContent.f14325c == ShapeTrimPath.Type.f14616a) {
                    this.f14244g.f14226a.add(trimPathContent);
                    trimPathContent.d(this);
                }
            }
            i2++;
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void d(ColorFilter colorFilter, LottieValueCallback lottieValueCallback) {
        if (colorFilter == LottieProperty.f14183f) {
            this.f14241d.k(lottieValueCallback);
        } else if (colorFilter == LottieProperty.f14186i) {
            this.f14242e.k(lottieValueCallback);
        }
    }

    @Override // com.airbnb.lottie.model.KeyPathElement
    public final void e(KeyPath keyPath, int i2, ArrayList arrayList, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i2, arrayList, keyPath2, this);
    }

    @Override // com.airbnb.lottie.animation.content.Content
    public final String getName() {
        return this.f14239b;
    }

    @Override // com.airbnb.lottie.animation.content.PathContent
    public final Path j() {
        boolean z = this.f14245h;
        Path path = this.f14238a;
        if (z) {
            return path;
        }
        path.reset();
        CircleShape circleShape = this.f14243f;
        if (circleShape.f14506e) {
            this.f14245h = true;
            return path;
        }
        PointF pointF = (PointF) this.f14241d.f();
        float f2 = pointF.x / 2.0f;
        float f3 = pointF.y / 2.0f;
        float f4 = f2 * 0.55228f;
        float f5 = f3 * 0.55228f;
        path.reset();
        if (circleShape.f14505d) {
            float f6 = -f3;
            path.moveTo(0.0f, f6);
            float f7 = 0.0f - f4;
            float f8 = -f2;
            float f9 = 0.0f - f5;
            path.cubicTo(f7, f6, f8, f9, f8, 0.0f);
            float f10 = f5 + 0.0f;
            path.cubicTo(f8, f10, f7, f3, 0.0f, f3);
            float f11 = f4 + 0.0f;
            path.cubicTo(f11, f3, f2, f10, f2, 0.0f);
            path.cubicTo(f2, f9, f11, f6, 0.0f, f6);
        } else {
            float f12 = -f3;
            path.moveTo(0.0f, f12);
            float f13 = f4 + 0.0f;
            float f14 = 0.0f - f5;
            path.cubicTo(f13, f12, f2, f14, f2, 0.0f);
            float f15 = f5 + 0.0f;
            path.cubicTo(f2, f15, f13, f3, 0.0f, f3);
            float f16 = 0.0f - f4;
            float f17 = -f2;
            path.cubicTo(f16, f3, f17, f15, f17, 0.0f);
            path.cubicTo(f17, f14, f16, f12, 0.0f, f12);
        }
        PointF pointF2 = (PointF) this.f14242e.f();
        path.offset(pointF2.x, pointF2.y);
        path.close();
        this.f14244g.a(path);
        this.f14245h = true;
        return path;
    }
}
