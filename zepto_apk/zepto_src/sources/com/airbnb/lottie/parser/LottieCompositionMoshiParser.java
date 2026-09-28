package com.airbnb.lottie.parser;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.content.ShapeGroup;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class LottieCompositionMoshiParser {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.Options f14726a = JsonReader.Options.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.Options f14727b = JsonReader.Options.a(CLConstants.SHARED_PREFERENCE_ITEM_ID, "layers", "w", "h", "p", "u");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.Options f14728c = JsonReader.Options.a("list");

    /* renamed from: d, reason: collision with root package name */
    public static final JsonReader.Options f14729d = JsonReader.Options.a("cm", "tm", "dr");

    public static LottieComposition a(JsonReader jsonReader) throws NumberFormatException {
        float f2;
        ArrayList arrayList;
        float f3;
        float fC = Utils.c();
        LongSparseArray longSparseArray = new LongSparseArray();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
        LottieComposition lottieComposition = new LottieComposition();
        jsonReader.k();
        float fNextDouble = 0.0f;
        int iNextInt = 0;
        int iNextInt2 = 0;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        while (jsonReader.c()) {
            switch (jsonReader.x(f14726a)) {
                case 0:
                    iNextInt = jsonReader.nextInt();
                    break;
                case 1:
                    iNextInt2 = jsonReader.nextInt();
                    break;
                case 2:
                    f2 = fC;
                    fNextDouble2 = (float) jsonReader.nextDouble();
                    fC = f2;
                    break;
                case 3:
                    f2 = fC;
                    fNextDouble = ((float) jsonReader.nextDouble()) - 0.01f;
                    fC = f2;
                    break;
                case 4:
                    f2 = fC;
                    fNextDouble3 = (float) jsonReader.nextDouble();
                    fC = f2;
                    break;
                case 5:
                    f2 = fC;
                    arrayList = arrayList3;
                    f3 = fNextDouble;
                    String[] strArrSplit = jsonReader.K0().split("\\.");
                    int i2 = Integer.parseInt(strArrSplit[0]);
                    int i3 = Integer.parseInt(strArrSplit[1]);
                    int i4 = Integer.parseInt(strArrSplit[2]);
                    if (i2 < 4 || (i2 <= 4 && (i3 < 4 || (i3 <= 4 && i4 < 0)))) {
                        lottieComposition.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
                case 6:
                    f2 = fC;
                    arrayList = arrayList3;
                    f3 = fNextDouble;
                    jsonReader.a();
                    int i5 = 0;
                    while (jsonReader.c()) {
                        Layer layerA = LayerParser.a(jsonReader, lottieComposition);
                        if (layerA.f14642e == Layer.LayerType.f14652b) {
                            i5++;
                        }
                        arrayList2.add(layerA);
                        longSparseArray.g(layerA.f14641d, layerA);
                        if (i5 > 4) {
                            Logger.b("You have " + i5 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
                        }
                    }
                    jsonReader.b();
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
                case 7:
                    f2 = fC;
                    arrayList = arrayList3;
                    f3 = fNextDouble;
                    jsonReader.a();
                    while (jsonReader.c()) {
                        ArrayList arrayList4 = new ArrayList();
                        LongSparseArray longSparseArray2 = new LongSparseArray();
                        jsonReader.k();
                        String strK0 = null;
                        String strK02 = null;
                        String strK03 = null;
                        int iNextInt3 = 0;
                        int iNextInt4 = 0;
                        while (jsonReader.c()) {
                            int iX = jsonReader.x(f14727b);
                            if (iX == 0) {
                                strK0 = jsonReader.K0();
                            } else if (iX == 1) {
                                jsonReader.a();
                                while (jsonReader.c()) {
                                    Layer layerA2 = LayerParser.a(jsonReader, lottieComposition);
                                    longSparseArray2.g(layerA2.f14641d, layerA2);
                                    arrayList4.add(layerA2);
                                }
                                jsonReader.b();
                            } else if (iX == 2) {
                                iNextInt3 = jsonReader.nextInt();
                            } else if (iX == 3) {
                                iNextInt4 = jsonReader.nextInt();
                            } else if (iX == 4) {
                                strK02 = jsonReader.K0();
                            } else if (iX != 5) {
                                jsonReader.A();
                                jsonReader.E();
                            } else {
                                strK03 = jsonReader.K0();
                            }
                        }
                        jsonReader.t();
                        if (strK02 != null) {
                            map2.put(strK0, new LottieImageAsset(iNextInt3, iNextInt4, strK0, strK02, strK03));
                        } else {
                            map.put(strK0, arrayList4);
                        }
                    }
                    jsonReader.b();
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
                case 8:
                    f2 = fC;
                    f3 = fNextDouble;
                    jsonReader.k();
                    while (jsonReader.c()) {
                        if (jsonReader.x(f14728c) != 0) {
                            jsonReader.A();
                            jsonReader.E();
                        } else {
                            jsonReader.a();
                            while (jsonReader.c()) {
                                JsonReader.Options options = FontParser.f14708a;
                                jsonReader.k();
                                String strK04 = null;
                                String strK05 = null;
                                String strK06 = null;
                                while (jsonReader.c()) {
                                    int iX2 = jsonReader.x(FontParser.f14708a);
                                    if (iX2 != 0) {
                                        ArrayList arrayList5 = arrayList3;
                                        if (iX2 == 1) {
                                            strK05 = jsonReader.K0();
                                        } else if (iX2 == 2) {
                                            strK06 = jsonReader.K0();
                                        } else if (iX2 != 3) {
                                            jsonReader.A();
                                            jsonReader.E();
                                        } else {
                                            jsonReader.nextDouble();
                                        }
                                        arrayList3 = arrayList5;
                                    } else {
                                        strK04 = jsonReader.K0();
                                    }
                                }
                                jsonReader.t();
                                map3.put(strK05, new Font(strK04, strK05, strK06));
                                arrayList3 = arrayList3;
                            }
                            jsonReader.b();
                        }
                    }
                    arrayList = arrayList3;
                    jsonReader.t();
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
                case 9:
                    f2 = fC;
                    f3 = fNextDouble;
                    jsonReader.a();
                    while (jsonReader.c()) {
                        JsonReader.Options options2 = FontCharacterParser.f14706a;
                        ArrayList arrayList6 = new ArrayList();
                        jsonReader.k();
                        double dNextDouble = 0.0d;
                        String strK07 = null;
                        String strK08 = null;
                        char cCharAt = 0;
                        while (jsonReader.c()) {
                            int iX3 = jsonReader.x(FontCharacterParser.f14706a);
                            if (iX3 == 0) {
                                cCharAt = jsonReader.K0().charAt(0);
                            } else if (iX3 == 1) {
                                jsonReader.nextDouble();
                            } else if (iX3 == 2) {
                                dNextDouble = jsonReader.nextDouble();
                            } else if (iX3 == 3) {
                                strK07 = jsonReader.K0();
                            } else if (iX3 == 4) {
                                strK08 = jsonReader.K0();
                            } else if (iX3 != 5) {
                                jsonReader.A();
                                jsonReader.E();
                            } else {
                                jsonReader.k();
                                while (jsonReader.c()) {
                                    if (jsonReader.x(FontCharacterParser.f14707b) != 0) {
                                        jsonReader.A();
                                        jsonReader.E();
                                    } else {
                                        jsonReader.a();
                                        while (jsonReader.c()) {
                                            arrayList6.add((ShapeGroup) ContentModelParser.a(jsonReader, lottieComposition));
                                        }
                                        jsonReader.b();
                                    }
                                }
                                jsonReader.t();
                            }
                        }
                        jsonReader.t();
                        FontCharacter fontCharacter = new FontCharacter(arrayList6, cCharAt, dNextDouble, strK07, strK08);
                        sparseArrayCompat.c(fontCharacter.hashCode(), fontCharacter);
                    }
                    jsonReader.b();
                    arrayList = arrayList3;
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
                case 10:
                    jsonReader.a();
                    while (jsonReader.c()) {
                        jsonReader.k();
                        String strK09 = null;
                        float fNextDouble4 = 0.0f;
                        float fNextDouble5 = 0.0f;
                        while (jsonReader.c()) {
                            int iX4 = jsonReader.x(f14729d);
                            if (iX4 != 0) {
                                float f4 = fC;
                                if (iX4 == 1) {
                                    fNextDouble4 = (float) jsonReader.nextDouble();
                                } else if (iX4 != 2) {
                                    jsonReader.A();
                                    jsonReader.E();
                                } else {
                                    fNextDouble5 = (float) jsonReader.nextDouble();
                                }
                                fC = f4;
                            } else {
                                strK09 = jsonReader.K0();
                            }
                        }
                        float f5 = fC;
                        jsonReader.t();
                        arrayList3.add(new Marker(strK09, fNextDouble4, fNextDouble5));
                        fNextDouble = fNextDouble;
                        fC = f5;
                    }
                    f2 = fC;
                    f3 = fNextDouble;
                    jsonReader.b();
                    arrayList = arrayList3;
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
                default:
                    jsonReader.A();
                    jsonReader.E();
                    f2 = fC;
                    arrayList = arrayList3;
                    f3 = fNextDouble;
                    fNextDouble = f3;
                    arrayList3 = arrayList;
                    fC = f2;
                    break;
            }
        }
        float f6 = fC;
        Rect rect = new Rect(0, 0, (int) (iNextInt * f6), (int) (iNextInt2 * f6));
        float fC2 = Utils.c();
        lottieComposition.f14145k = rect;
        lottieComposition.f14146l = fNextDouble2;
        lottieComposition.f14147m = fNextDouble;
        lottieComposition.n = fNextDouble3;
        lottieComposition.f14144j = arrayList2;
        lottieComposition.f14143i = longSparseArray;
        lottieComposition.f14137c = map;
        lottieComposition.f14138d = map2;
        lottieComposition.f14139e = fC2;
        lottieComposition.f14142h = sparseArrayCompat;
        lottieComposition.f14140f = map3;
        lottieComposition.f14141g = arrayList3;
        return lottieComposition;
    }
}
