package com.airbnb.lottie.model.animatable;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ModifierContent;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class AnimatableTransform implements ModifierContent, ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final AnimatablePathValue f14490a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableValue f14491b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableScaleValue f14492c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableFloatValue f14493d;

    /* renamed from: e, reason: collision with root package name */
    public final AnimatableIntegerValue f14494e;

    /* renamed from: f, reason: collision with root package name */
    public final AnimatableFloatValue f14495f;

    /* renamed from: g, reason: collision with root package name */
    public final AnimatableFloatValue f14496g;

    /* renamed from: h, reason: collision with root package name */
    public final AnimatableFloatValue f14497h;

    /* renamed from: i, reason: collision with root package name */
    public final AnimatableFloatValue f14498i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f14499j;

    public AnimatableTransform() {
        this(null, null, null, null, null, null, null, null, null);
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return null;
    }

    public AnimatableTransform(AnimatablePathValue animatablePathValue, AnimatableValue animatableValue, AnimatableScaleValue animatableScaleValue, AnimatableFloatValue animatableFloatValue, AnimatableIntegerValue animatableIntegerValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5) {
        this.f14499j = false;
        this.f14490a = animatablePathValue;
        this.f14491b = animatableValue;
        this.f14492c = animatableScaleValue;
        this.f14493d = animatableFloatValue;
        this.f14494e = animatableIntegerValue;
        this.f14497h = animatableFloatValue2;
        this.f14498i = animatableFloatValue3;
        this.f14495f = animatableFloatValue4;
        this.f14496g = animatableFloatValue5;
    }
}
