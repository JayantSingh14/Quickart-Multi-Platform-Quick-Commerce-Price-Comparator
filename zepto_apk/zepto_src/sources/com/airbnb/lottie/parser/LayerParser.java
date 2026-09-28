package com.airbnb.lottie.parser;

import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes3.dex */
public class LayerParser {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.Options f14722a = JsonReader.Options.a("nm", "ind", CLConstants.LABEL_REF_ID, "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd", "ao", "bm");

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.Options f14723b = JsonReader.Options.a("d", "a");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.Options f14724c = JsonReader.Options.a("ty", "nm");

    /* renamed from: com.airbnb.lottie.parser.LayerParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14725a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f14725a = iArr;
            try {
                iArr[3] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14725a[4] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:192:0x038b A[PHI: r46
      0x038b: PHI (r46v18 com.airbnb.lottie.model.content.LBlendMode) = (r46v16 com.airbnb.lottie.model.content.LBlendMode), (r46v19 com.airbnb.lottie.model.content.LBlendMode) binds: [B:196:0x0395, B:191:0x0378] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0475  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.airbnb.lottie.model.layer.Layer a(com.airbnb.lottie.parser.moshi.JsonReader r53, com.airbnb.lottie.LottieComposition r54) {
        /*
            Method dump skipped, instructions count: 1940
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.LayerParser.a(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition):com.airbnb.lottie.model.layer.Layer");
    }
}
