package com.google.gson.stream;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public final class JsonToken {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonToken f45475a;

    /* renamed from: b, reason: collision with root package name */
    public static final JsonToken f45476b;

    /* renamed from: c, reason: collision with root package name */
    public static final JsonToken f45477c;

    /* renamed from: d, reason: collision with root package name */
    public static final JsonToken f45478d;

    /* renamed from: e, reason: collision with root package name */
    public static final JsonToken f45479e;

    /* renamed from: f, reason: collision with root package name */
    public static final JsonToken f45480f;

    /* renamed from: g, reason: collision with root package name */
    public static final JsonToken f45481g;

    /* renamed from: h, reason: collision with root package name */
    public static final JsonToken f45482h;

    /* renamed from: i, reason: collision with root package name */
    public static final JsonToken f45483i;

    /* renamed from: j, reason: collision with root package name */
    public static final JsonToken f45484j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ JsonToken[] f45485k;

    static {
        JsonToken jsonToken = new JsonToken("BEGIN_ARRAY", 0);
        f45475a = jsonToken;
        JsonToken jsonToken2 = new JsonToken("END_ARRAY", 1);
        f45476b = jsonToken2;
        JsonToken jsonToken3 = new JsonToken("BEGIN_OBJECT", 2);
        f45477c = jsonToken3;
        JsonToken jsonToken4 = new JsonToken("END_OBJECT", 3);
        f45478d = jsonToken4;
        JsonToken jsonToken5 = new JsonToken("NAME", 4);
        f45479e = jsonToken5;
        JsonToken jsonToken6 = new JsonToken("STRING", 5);
        f45480f = jsonToken6;
        JsonToken jsonToken7 = new JsonToken("NUMBER", 6);
        f45481g = jsonToken7;
        JsonToken jsonToken8 = new JsonToken("BOOLEAN", 7);
        f45482h = jsonToken8;
        JsonToken jsonToken9 = new JsonToken("NULL", 8);
        f45483i = jsonToken9;
        JsonToken jsonToken10 = new JsonToken("END_DOCUMENT", 9);
        f45484j = jsonToken10;
        f45485k = new JsonToken[]{jsonToken, jsonToken2, jsonToken3, jsonToken4, jsonToken5, jsonToken6, jsonToken7, jsonToken8, jsonToken9, jsonToken10};
    }

    public static JsonToken valueOf(String str) {
        return (JsonToken) Enum.valueOf(JsonToken.class, str);
    }

    public static JsonToken[] values() {
        return (JsonToken[]) f45485k.clone();
    }
}
