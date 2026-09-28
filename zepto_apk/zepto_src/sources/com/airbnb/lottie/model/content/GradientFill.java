package com.airbnb.lottie.model.content;

import android.graphics.Path;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientFillContent;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class GradientFill implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final GradientType f14509a;

    /* renamed from: b, reason: collision with root package name */
    public final Path.FillType f14510b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableGradientColorValue f14511c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableIntegerValue f14512d;

    /* renamed from: e, reason: collision with root package name */
    public final AnimatablePointValue f14513e;

    /* renamed from: f, reason: collision with root package name */
    public final AnimatablePointValue f14514f;

    /* renamed from: g, reason: collision with root package name */
    public final String f14515g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f14516h;

    public GradientFill(String str, GradientType gradientType, Path.FillType fillType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, boolean z) {
        this.f14509a = gradientType;
        this.f14510b = fillType;
        this.f14511c = animatableGradientColorValue;
        this.f14512d = animatableIntegerValue;
        this.f14513e = animatablePointValue;
        this.f14514f = animatablePointValue2;
        this.f14515g = str;
        this.f14516h = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new GradientFillContent(lottieDrawable, lottieComposition, baseLayer, this);
    }
}
