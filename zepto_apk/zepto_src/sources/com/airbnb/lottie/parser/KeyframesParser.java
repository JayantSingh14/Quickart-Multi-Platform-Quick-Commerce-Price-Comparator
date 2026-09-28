package com.airbnb.lottie.parser;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.animation.keyframe.PathKeyframe;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.Keyframe;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class KeyframesParser {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.Options f14721a = JsonReader.Options.a("k");

    public static ArrayList a(JsonReader jsonReader, LottieComposition lottieComposition, float f2, ValueParser valueParser, boolean z) {
        JsonReader jsonReader2;
        LottieComposition lottieComposition2;
        float f3;
        ValueParser valueParser2;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        if (jsonReader.r() == JsonReader.Token.f14758f) {
            lottieComposition.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.k();
        while (jsonReader.c()) {
            if (jsonReader.x(f14721a) != 0) {
                jsonReader.E();
            } else if (jsonReader.r() == JsonReader.Token.f14753a) {
                jsonReader.a();
                if (jsonReader.r() == JsonReader.Token.f14759g) {
                    JsonReader jsonReader3 = jsonReader;
                    LottieComposition lottieComposition3 = lottieComposition;
                    float f4 = f2;
                    ValueParser valueParser3 = valueParser;
                    boolean z3 = z;
                    Keyframe keyframeB = KeyframeParser.b(jsonReader3, lottieComposition3, f4, valueParser3, false, z3);
                    jsonReader2 = jsonReader3;
                    lottieComposition2 = lottieComposition3;
                    f3 = f4;
                    valueParser2 = valueParser3;
                    z2 = z3;
                    arrayList.add(keyframeB);
                } else {
                    jsonReader2 = jsonReader;
                    lottieComposition2 = lottieComposition;
                    f3 = f2;
                    valueParser2 = valueParser;
                    z2 = z;
                    while (jsonReader2.c()) {
                        arrayList.add(KeyframeParser.b(jsonReader2, lottieComposition2, f3, valueParser2, true, z2));
                    }
                }
                jsonReader2.b();
                jsonReader = jsonReader2;
                lottieComposition = lottieComposition2;
                f2 = f3;
                valueParser = valueParser2;
                z = z2;
            } else {
                JsonReader jsonReader4 = jsonReader;
                arrayList.add(KeyframeParser.b(jsonReader4, lottieComposition, f2, valueParser, false, z));
                jsonReader = jsonReader4;
            }
        }
        jsonReader.t();
        b(arrayList);
        return arrayList;
    }

    public static void b(ArrayList arrayList) {
        int i2;
        Object obj;
        int size = arrayList.size();
        int i3 = 0;
        while (true) {
            i2 = size - 1;
            if (i3 >= i2) {
                break;
            }
            Keyframe keyframe = (Keyframe) arrayList.get(i3);
            i3++;
            Keyframe keyframe2 = (Keyframe) arrayList.get(i3);
            keyframe.f14822h = Float.valueOf(keyframe2.f14821g);
            if (keyframe.f14817c == null && (obj = keyframe2.f14816b) != null) {
                keyframe.f14817c = obj;
                if (keyframe instanceof PathKeyframe) {
                    ((PathKeyframe) keyframe).d();
                }
            }
        }
        Keyframe keyframe3 = (Keyframe) arrayList.get(i2);
        if ((keyframe3.f14816b == null || keyframe3.f14817c == null) && arrayList.size() > 1) {
            arrayList.remove(keyframe3);
        }
    }
}
