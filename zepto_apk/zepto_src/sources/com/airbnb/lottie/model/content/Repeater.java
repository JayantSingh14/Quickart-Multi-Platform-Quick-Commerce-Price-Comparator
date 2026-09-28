package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.RepeaterContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableTransform;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class Repeater implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14573a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableFloatValue f14574b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableFloatValue f14575c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableTransform f14576d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14577e;

    public Repeater(String str, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableTransform animatableTransform, boolean z) {
        this.f14573a = str;
        this.f14574b = animatableFloatValue;
        this.f14575c = animatableFloatValue2;
        this.f14576d = animatableTransform;
        this.f14577e = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new RepeaterContent(lottieDrawable, baseLayer, this);
    }
}
