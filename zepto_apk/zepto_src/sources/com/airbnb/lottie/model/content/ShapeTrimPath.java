package com.airbnb.lottie.model.content;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.TrimPathContent;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.layer.BaseLayer;

/* loaded from: classes3.dex */
public class ShapeTrimPath implements ContentModel {

    /* renamed from: a, reason: collision with root package name */
    public final Type f14611a;

    /* renamed from: b, reason: collision with root package name */
    public final AnimatableFloatValue f14612b;

    /* renamed from: c, reason: collision with root package name */
    public final AnimatableFloatValue f14613c;

    /* renamed from: d, reason: collision with root package name */
    public final AnimatableFloatValue f14614d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f14615e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f14616a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f14617b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ Type[] f14618c;

        static {
            Type type = new Type("SIMULTANEOUSLY", 0);
            f14616a = type;
            Type type2 = new Type("INDIVIDUALLY", 1);
            f14617b = type2;
            f14618c = new Type[]{type, type2};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f14618c.clone();
        }
    }

    public ShapeTrimPath(String str, Type type, AnimatableFloatValue animatableFloatValue, AnimatableFloatValue animatableFloatValue2, AnimatableFloatValue animatableFloatValue3, boolean z) {
        this.f14611a = type;
        this.f14612b = animatableFloatValue;
        this.f14613c = animatableFloatValue2;
        this.f14614d = animatableFloatValue3;
        this.f14615e = z;
    }

    @Override // com.airbnb.lottie.model.content.ContentModel
    public final Content a(LottieDrawable lottieDrawable, LottieComposition lottieComposition, BaseLayer baseLayer) {
        return new TrimPathContent(baseLayer, this);
    }

    public final String toString() {
        return "Trim Path: {start: " + this.f14612b + ", end: " + this.f14613c + ", offset: " + this.f14614d + "}";
    }
}
