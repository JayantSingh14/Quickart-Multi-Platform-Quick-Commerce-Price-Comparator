package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class ShapeDataParser implements ValueParser<ShapeData> {

    /* renamed from: a, reason: collision with root package name */
    public static final ShapeDataParser f14738a = new ShapeDataParser();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.Options f14739b = JsonReader.Options.a("c", "v", "i", "o");

    @Override // com.airbnb.lottie.parser.ValueParser
    public final Object a(JsonReader jsonReader, float f2) {
        if (jsonReader.r() == JsonReader.Token.f14753a) {
            jsonReader.a();
        }
        jsonReader.k();
        ArrayList arrayListC = null;
        ArrayList arrayListC2 = null;
        ArrayList arrayListC3 = null;
        boolean zE = false;
        while (jsonReader.c()) {
            int iX = jsonReader.x(f14739b);
            if (iX == 0) {
                zE = jsonReader.e();
            } else if (iX == 1) {
                arrayListC = JsonUtils.c(jsonReader, f2);
            } else if (iX == 2) {
                arrayListC2 = JsonUtils.c(jsonReader, f2);
            } else if (iX != 3) {
                jsonReader.A();
                jsonReader.E();
            } else {
                arrayListC3 = JsonUtils.c(jsonReader, f2);
            }
        }
        jsonReader.t();
        if (jsonReader.r() == JsonReader.Token.f14754b) {
            jsonReader.b();
        }
        if (arrayListC == null || arrayListC2 == null || arrayListC3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (arrayListC.isEmpty()) {
            return new ShapeData(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = arrayListC.size();
        PointF pointF = (PointF) arrayListC.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 1; i2 < size; i2++) {
            PointF pointF2 = (PointF) arrayListC.get(i2);
            int i3 = i2 - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a((PointF) arrayListC.get(i3), (PointF) arrayListC3.get(i3)), MiscUtils.a(pointF2, (PointF) arrayListC2.get(i2)), pointF2));
        }
        if (zE) {
            PointF pointF3 = (PointF) arrayListC.get(0);
            int i4 = size - 1;
            arrayList.add(new CubicCurveData(MiscUtils.a((PointF) arrayListC.get(i4), (PointF) arrayListC3.get(i4)), MiscUtils.a(pointF3, (PointF) arrayListC2.get(0)), pointF3));
        }
        return new ShapeData(pointF, zE, arrayList);
    }
}
