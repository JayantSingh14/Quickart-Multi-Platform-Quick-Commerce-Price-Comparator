package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes3.dex */
public class IntegerParser implements ValueParser<Integer> {

    /* renamed from: a, reason: collision with root package name */
    public static final IntegerParser f14715a = new IntegerParser();

    @Override // com.airbnb.lottie.parser.ValueParser
    public final Object a(JsonReader jsonReader, float f2) {
        return Integer.valueOf(Math.round(JsonUtils.d(jsonReader) * f2));
    }
}
