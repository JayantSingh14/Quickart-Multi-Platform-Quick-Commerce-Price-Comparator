package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RectangleContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class RectangleShape implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14568a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableValue f14569b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatablePointValue f14570c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableFloatValue f14571d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14572e;

    public RectangleShape(String str, AnimatableValue animatableValue, AnimatablePointValue animatablePointValue, AnimatableFloatValue animatableFloatValue, boolean z) {
        this.f14568a = str;
        this.f14569b = animatableValue;
        this.f14570c = animatablePointValue;
        this.f14571d = animatableFloatValue;
        this.f14572e = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new RectangleContent(lottieDrawable, baseLayer, this);
    }

    public final String toString() {
        return "RectangleShape{position=" + this.f14569b + ", size=" + this.f14570c + '}';
    }
}
