package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.FillContent;
import com.airbnb.lottie.model.animatable.AnimatableColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class ShapeFill implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f14582a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f14583b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14584c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableColorValue f14585d;

    /* renamed from: e, reason: collision with root package name */
    public final AnimatableIntegerValue f14586e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14587f;

    public ShapeFill(String str, boolean z, Path.FillType fillType, AnimatableColorValue animatableColorValue, AnimatableIntegerValue animatableIntegerValue, boolean z2) {
        this.f14584c = str;
        this.f14582a = z;
        this.f14583b = fillType;
        this.f14585d = animatableColorValue;
        this.f14586e = animatableIntegerValue;
        this.f14587f = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new FillContent(lottieDrawable, baseLayer, this);
    }

    public final String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f14582a + '}';
    }
}
