package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.EllipseContent;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class CircleShape implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14502a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableValue f14503b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatablePointValue f14504c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14505d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14506e;

    public CircleShape(String str, AnimatableValue animatableValue, AnimatablePointValue animatablePointValue, boolean z, boolean z2) {
        this.f14502a = str;
        this.f14503b = animatableValue;
        this.f14504c = animatablePointValue;
        this.f14505d = z;
        this.f14506e = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new EllipseContent(lottieDrawable, baseLayer, this);
    }
}
