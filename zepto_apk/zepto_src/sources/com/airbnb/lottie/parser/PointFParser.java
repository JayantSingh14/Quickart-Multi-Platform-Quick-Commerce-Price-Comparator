package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes3.dex */
public class PointFParser implements ValueParser<PointF> {

    /* renamed from: a, reason: collision with root package name */
    public static final PointFParser f14732a = new PointFParser();

    @Override // com.airbnb.lottie.parser.ValueParser
    public final Object a(JsonReader jsonReader, float f2) {
        JsonReader.Token tokenR = jsonReader.r();
        if (tokenR == JsonReader.Token.f14753a) {
            return JsonUtils.b(jsonReader, f2);
        }
        if (tokenR == JsonReader.Token.f14755c) {
            return JsonUtils.b(jsonReader, f2);
        }
        if (tokenR != JsonReader.Token.f14759g) {
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + tokenR);
        }
        PointF pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
        while (jsonReader.c()) {
            jsonReader.E();
        }
        return pointF;
    }
}
