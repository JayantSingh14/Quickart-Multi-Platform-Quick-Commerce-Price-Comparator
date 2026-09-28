package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.GradientStrokeContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableGradientColorValue;
import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatablePointValue;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class GradientStroke implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14517a;

    /* renamed from: b, reason: collision with root package name */
    public final GradientType f14518b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableGradientColorValue f14519c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableIntegerValue f14520d;

    /* renamed from: e, reason: collision with root package name */
    public final AnimatablePointValue f14521e;

    /* renamed from: f, reason: collision with root package name */
    public final AnimatablePointValue f14522f;

    /* renamed from: g, reason: collision with root package name */
    public final AnimatableFloatValue f14523g;

    /* renamed from: h, reason: collision with root package name */
    public final ShapeStroke.LineCapType f14524h;

    /* renamed from: i, reason: collision with root package name */
    public final ShapeStroke.LineJoinType f14525i;

    /* renamed from: j, reason: collision with root package name */
    public final float f14526j;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f14527k;

    /* renamed from: l, reason: collision with root package name */
    public final AnimatableFloatValue f14528l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f14529m;

    public GradientStroke(String str, GradientType gradientType, AnimatableGradientColorValue animatableGradientColorValue, AnimatableIntegerValue animatableIntegerValue, AnimatablePointValue animatablePointValue, AnimatablePointValue animatablePointValue2, AnimatableFloatValue animatableFloatValue, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f2, ArrayList arrayList, AnimatableFloatValue animatableFloatValue2, boolean z) {
        this.f14517a = str;
        this.f14518b = gradientType;
        this.f14519c = animatableGradientColorValue;
        this.f14520d = animatableIntegerValue;
        this.f14521e = animatablePointValue;
        this.f14522f = animatablePointValue2;
        this.f14523g = animatableFloatValue;
        this.f14524h = lineCapType;
        this.f14525i = lineJoinType;
        this.f14526j = f2;
        this.f14527k = arrayList;
        this.f14528l = animatableFloatValue2;
        this.f14529m = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new GradientStrokeContent(lottieDrawable, baseLayer, this);
    }
}
