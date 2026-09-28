package com.airbnb.lottie.model.content;

import android.support.v4.media.b;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ShapeContent;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class ShapePath implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14591a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14592b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableShapeValue f14593c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f14594d;

    public ShapePath(String str, int i2, AnimatableShapeValue animatableShapeValue, boolean z) {
        this.f14591a = str;
        this.f14592b = i2;
        this.f14593c = animatableShapeValue;
        this.f14594d = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new ShapeContent(lottieDrawable, baseLayer, this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ShapePath{name=");
        sb.append(this.f14591a);
        sb.append(", index=");
        return b.n(sb, this.f14592b, '}');
    }
}
