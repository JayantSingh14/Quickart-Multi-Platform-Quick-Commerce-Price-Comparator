package com.airbnb.lottie.parser;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class JsonUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.Options f14716a = JsonReader.Options.a("x", "y");

    /* renamed from: com.airbnb.lottie.parser.JsonUtils$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14717a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f14717a = iArr;
            try {
                iArr[6] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14717a[0] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14717a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static int a(JsonReader jsonReader) {
        jsonReader.a();
        int iNextDouble = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble2 = (int) (jsonReader.nextDouble() * 255.0d);
        int iNextDouble3 = (int) (jsonReader.nextDouble() * 255.0d);
        while (jsonReader.c()) {
            jsonReader.E();
        }
        jsonReader.b();
        return Color.argb(255, iNextDouble, iNextDouble2, iNextDouble3);
    }

    public static PointF b(JsonReader jsonReader, float f2) {
        int iOrdinal = jsonReader.r().ordinal();
        if (iOrdinal == 0) {
            jsonReader.a();
            float fNextDouble = (float) jsonReader.nextDouble();
            float fNextDouble2 = (float) jsonReader.nextDouble();
            while (jsonReader.r() != JsonReader.Token.f14754b) {
                jsonReader.E();
            }
            jsonReader.b();
            return new PointF(fNextDouble * f2, fNextDouble2 * f2);
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 6) {
                throw new IllegalArgumentException("Unknown point starts with " + jsonReader.r());
            }
            float fNextDouble3 = (float) jsonReader.nextDouble();
            float fNextDouble4 = (float) jsonReader.nextDouble();
            while (jsonReader.c()) {
                jsonReader.E();
            }
            return new PointF(fNextDouble3 * f2, fNextDouble4 * f2);
        }
        jsonReader.k();
        float fD = 0.0f;
        float fD2 = 0.0f;
        while (jsonReader.c()) {
            int iX = jsonReader.x(f14716a);
            if (iX == 0) {
                fD = d(jsonReader);
            } else if (iX != 1) {
                jsonReader.A();
                jsonReader.E();
            } else {
                fD2 = d(jsonReader);
            }
        }
        jsonReader.t();
        return new PointF(fD * f2, fD2 * f2);
    }

    public static ArrayList c(JsonReader jsonReader, float f2) {
        ArrayList arrayList = new ArrayList();
        jsonReader.a();
        while (jsonReader.r() == JsonReader.Token.f14753a) {
            jsonReader.a();
            arrayList.add(b(jsonReader, f2));
            jsonReader.b();
        }
        jsonReader.b();
        return arrayList;
    }

    public static float d(JsonReader jsonReader) {
        JsonReader.Token tokenR = jsonReader.r();
        int iOrdinal = tokenR.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 6) {
                return (float) jsonReader.nextDouble();
            }
            throw new IllegalArgumentException("Unknown value for token of type " + tokenR);
        }
        jsonReader.a();
        float fNextDouble = (float) jsonReader.nextDouble();
        while (jsonReader.c()) {
            jsonReader.E();
        }
        jsonReader.b();
        return fNextDouble;
    }
}
