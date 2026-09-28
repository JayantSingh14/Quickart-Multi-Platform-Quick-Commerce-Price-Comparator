package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;

/* loaded from: classes3.dex */
public class DocumentDataParser implements ValueParser<DocumentData> {

    /* renamed from: a, reason: collision with root package name */
    public static final DocumentDataParser f14691a = new DocumentDataParser();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.Options f14692b = JsonReader.Options.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of", "ps", "sz");

    @Override // com.airbnb.lottie.parser.ValueParser
    public final Object a(JsonReader jsonReader, float f2) {
        boolean z;
        int i2;
        DocumentData.Justification justification = DocumentData.Justification.f14455a;
        jsonReader.k();
        String strK0 = null;
        DocumentData.Justification justification2 = justification;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fNextDouble4 = 0.0f;
        int iNextInt = 0;
        int iA = 0;
        int iA2 = 0;
        boolean zE = true;
        String strK02 = null;
        PointF pointF = null;
        PointF pointF2 = null;
        while (jsonReader.c()) {
            switch (jsonReader.x(f14692b)) {
                case 0:
                    z = zE;
                    strK0 = jsonReader.K0();
                    zE = z;
                    break;
                case 1:
                    z = zE;
                    strK02 = jsonReader.K0();
                    zE = z;
                    break;
                case 2:
                    z = zE;
                    fNextDouble = (float) jsonReader.nextDouble();
                    zE = z;
                    break;
                case 3:
                    z = zE;
                    i2 = iA2;
                    int iNextInt2 = jsonReader.nextInt();
                    justification2 = (iNextInt2 > 2 || iNextInt2 < 0) ? justification : DocumentData.Justification.values()[iNextInt2];
                    iA2 = i2;
                    zE = z;
                    break;
                case 4:
                    z = zE;
                    iNextInt = jsonReader.nextInt();
                    zE = z;
                    break;
                case 5:
                    z = zE;
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    zE = z;
                    break;
                case 6:
                    z = zE;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    zE = z;
                    break;
                case 7:
                    z = zE;
                    iA = JsonUtils.a(jsonReader);
                    zE = z;
                    break;
                case 8:
                    iA2 = JsonUtils.a(jsonReader);
                    break;
                case 9:
                    z = zE;
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    zE = z;
                    break;
                case 10:
                    zE = jsonReader.e();
                    iA2 = iA2;
                    break;
                case 11:
                    z = zE;
                    jsonReader.a();
                    i2 = iA2;
                    pointF = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
                    jsonReader.b();
                    iA2 = i2;
                    zE = z;
                    break;
                case 12:
                    jsonReader.a();
                    z = zE;
                    pointF2 = new PointF(((float) jsonReader.nextDouble()) * f2, ((float) jsonReader.nextDouble()) * f2);
                    jsonReader.b();
                    iA2 = iA2;
                    zE = z;
                    break;
                default:
                    jsonReader.A();
                    jsonReader.E();
                    break;
            }
        }
        jsonReader.t();
        DocumentData documentData = new DocumentData();
        documentData.f14442a = strK0;
        documentData.f14443b = strK02;
        documentData.f14444c = fNextDouble;
        documentData.f14445d = justification2;
        documentData.f14446e = iNextInt;
        documentData.f14447f = fNextDouble2;
        documentData.f14448g = fNextDouble3;
        documentData.f14449h = iA;
        documentData.f14450i = iA2;
        documentData.f14451j = fNextDouble4;
        documentData.f14452k = zE;
        documentData.f14453l = pointF;
        documentData.f14454m = pointF2;
        return documentData;
    }
}
