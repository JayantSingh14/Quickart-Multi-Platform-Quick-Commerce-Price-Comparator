package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.model.animatable.AnimatableFloatValue;
import com.airbnb.lottie.model.animatable.AnimatablePathValue;
import com.airbnb.lottie.model.animatable.AnimatableSplitDimensionPathValue;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class AnimatablePathValueParser {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.Options f14680a = JsonReader.Options.a("k", "x", "y");

    public static AnimatablePathValue a(JsonReader jsonReader, LottieComposition lottieComposition) {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.r() == JsonReader.Token.f14753a) {
            jsonReader.a();
            while (jsonReader.c()) {
                JsonReader jsonReader2 = jsonReader;
                LottieComposition lottieComposition2 = lottieComposition;
                arrayList.add(new PathKeyframe(lottieComposition2, KeyframeParser.b(jsonReader2, lottieComposition2, Utils.c(), PathParser.f14731a, jsonReader.r() == JsonReader.Token.f14755c, false)));
                jsonReader = jsonReader2;
                lottieComposition = lottieComposition2;
            }
            jsonReader.b();
            KeyframesParser.b(arrayList);
        } else {
            arrayList.add(new Keyframe(JsonUtils.b(jsonReader, Utils.c())));
        }
        return new AnimatablePathValue(arrayList);
    }

    public static AnimatableValue b(JsonReader jsonReader, LottieComposition lottieComposition) {
        jsonReader.k();
        AnimatablePathValue animatablePathValueA = null;
        AnimatableFloatValue animatableFloatValueB = null;
        boolean z = false;
        AnimatableFloatValue animatableFloatValueB2 = null;
        while (jsonReader.r() != JsonReader.Token.f14756d) {
            int iX = jsonReader.x(f14680a);
            if (iX != 0) {
                JsonReader.Token token = JsonReader.Token.f14758f;
                if (iX != 1) {
                    if (iX != 2) {
                        jsonReader.A();
                        jsonReader.E();
                    } else if (jsonReader.r() == token) {
                        jsonReader.E();
                        z = true;
                    } else {
                        animatableFloatValueB = AnimatableValueParser.b(jsonReader, lottieComposition, true);
                    }
                } else if (jsonReader.r() == token) {
                    jsonReader.E();
                    z = true;
                } else {
                    animatableFloatValueB2 = AnimatableValueParser.b(jsonReader, lottieComposition, true);
                }
            } else {
                animatablePathValueA = a(jsonReader, lottieComposition);
            }
        }
        jsonReader.t();
        if (z) {
            lottieComposition.a("Lottie doesn't support expressions.");
        }
        return animatablePathValueA != null ? animatablePathValueA : new AnimatableSplitDimensionPathValue(animatableFloatValueB2, animatableFloatValueB);
    }
}
