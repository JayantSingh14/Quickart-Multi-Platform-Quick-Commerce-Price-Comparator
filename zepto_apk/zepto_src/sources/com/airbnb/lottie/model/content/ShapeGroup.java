package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.ContentGroup;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class ShapeGroup implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14588a;

    /* renamed from: b, reason: collision with root package name */
    public final List f14589b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14590c;

    public ShapeGroup(String str, List list, boolean z) {
        this.f14588a = str;
        this.f14589b = list;
        this.f14590c = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new ContentGroup(lottieDrawable, baseLayer, this, lottieComposition);
    }

    public final String toString() {
        return "ShapeGroup{name='" + this.f14588a + "' Shapes: " + Arrays.toString(this.f14589b.toArray()) + '}';
    }
}
