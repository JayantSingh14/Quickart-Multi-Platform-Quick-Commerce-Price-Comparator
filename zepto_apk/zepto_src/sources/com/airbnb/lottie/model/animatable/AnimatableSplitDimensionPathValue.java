package com.airbnb.lottie.model.animatable;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.animation.keyframe.SplitDimensionPathKeyframeAnimation;
import java.util.List;

/* loaded from: classes3.dex */
public class AnimatableSplitDimensionPathValue implements AnimatableValue<PointF, PointF> {

    /* renamed from: a, reason: collision with root package name */
    public final AnimatableFloatValue f14477a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableFloatValue f14478b;

    public AnimatableSplitDimensionPathValue(AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2) {
        this.f14477a = animatableFloatValue;
        this.f14478b = animatableFloatValue2;
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final BaseKeyframeAnimation a() {
        return new SplitDimensionPathKeyframeAnimation(this.f14477a.a(), this.f14478b.a());
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final List b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // com.airbnb.lottie.model.animatable.AnimatableValue
    public final boolean c() {
        return this.f14477a.c() && this.f14478b.c();
    }
}
