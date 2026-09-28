package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.value.ScaleXY;

/* loaded from: classes3.dex */
public class ScaleXYParser implements ValueParser<ScaleXY> {

    /* renamed from: a, reason: collision with root package name */
    public static final ScaleXYParser f14737a = new ScaleXYParser();

    @Override // com.airbnb.lottie.parser.ValueParser
    public final Object a(JsonReader jsonReader, float f2) {
        boolean z = jsonReader.r() == JsonReader.Token.f14753a;
        if (z) {
            jsonReader.a();
        }
        float fNextDouble = (float) jsonReader.nextDouble();
        float fNextDouble2 = (float) jsonReader.nextDouble();
        while (jsonReader.c()) {
            jsonReader.E();
        }
        if (z) {
            jsonReader.b();
        }
        return new ScaleXY((fNextDouble / 100.0f) * f2, (fNextDouble2 / 100.0f) * f2);
    }
}
