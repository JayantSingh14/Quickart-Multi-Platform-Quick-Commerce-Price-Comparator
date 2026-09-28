package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes3.dex */
public class FloatParser implements ValueParser<Float> {

    /* renamed from: a, reason: collision with root package name */
    public static final FloatParser f14705a = new FloatParser();

    @Override // com.airbnb.lottie.parser.ValueParser
    public final Object a(JsonReader jsonReader, float f2) {
        return Float.valueOf(JsonUtils.d(jsonReader) * f2);
    }
}
