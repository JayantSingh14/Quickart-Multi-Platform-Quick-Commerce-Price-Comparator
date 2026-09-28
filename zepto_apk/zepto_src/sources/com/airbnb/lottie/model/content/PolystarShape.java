package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.PolystarContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class PolystarShape implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final String f14554a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f14555b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableFloatValue f14556c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableValue f14557d;

    /* renamed from: e, reason: collision with root package name */
    public final AnimatableFloatValue f14558e;

    /* renamed from: f, reason: collision with root package name */
    public final AnimatableFloatValue f14559f;

    /* renamed from: g, reason: collision with root package name */
    public final AnimatableFloatValue f14560g;

    /* renamed from: h, reason: collision with root package name */
    public final AnimatableFloatValue f14561h;

    /* renamed from: i, reason: collision with root package name */
    public final AnimatableFloatValue f14562i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f14563j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f14564k;

    public enum Type {
        STAR(1),
        /* JADX INFO: Fake field, exist only in values array */
        POLYGON(2);


        /* renamed from: a, reason: collision with root package name */
        public final int f14567a;

        Type(int i2) {
            this.f14567a = i2;
        }
    }

    public PolystarShape(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableValue animatableValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, AnimatableFloatValue animatableFloatValue4, AnimatableFloatValue animatableFloatValue5, AnimatableFloatValue animatableFloatValue6, boolean z, boolean z2) {
        this.f14554a = str;
        this.f14555b = type;
        this.f14556c = animatableFloatValue;
        this.f14557d = animatableValue;
        this.f14558e = animatableFloatValue2;
        this.f14559f = animatableFloatValue3;
        this.f14560g = animatableFloatValue4;
        this.f14561h = animatableFloatValue5;
        this.f14562i = animatableFloatValue6;
        this.f14563j = z;
        this.f14564k = z2;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new PolystarContent(lottieDrawable, baseLayer, this);
    }
}
