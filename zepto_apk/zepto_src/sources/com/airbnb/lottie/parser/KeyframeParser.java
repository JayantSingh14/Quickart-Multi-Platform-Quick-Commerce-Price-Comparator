package com.airbnb.lottie.parser;

import android.graphics.PointF;
import android.view.animation.BaseInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import com.airbnb.lottie.L;
import com.airbnb.lottie.network.NetworkFetcher;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.utils.Utils;

/* loaded from: classes3.dex */
class KeyframeParser {

    /* renamed from: a, reason: collision with root package name */
    public static final LinearInterpolator f14718a = new LinearInterpolator();

    /* renamed from: b, reason: collision with root package name */
    public static final JsonReader.Options f14719b = JsonReader.Options.a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* renamed from: c, reason: collision with root package name */
    public static final JsonReader.Options f14720c = JsonReader.Options.a("x", "y");

    public static BaseInterpolator a(PointF pointF, PointF pointF2) {
        BaseInterpolator pathInterpolator;
        pointF.x = MiscUtils.b(pointF.x, -1.0f, 1.0f);
        pointF.y = MiscUtils.b(pointF.y, -100.0f, 100.0f);
        pointF2.x = MiscUtils.b(pointF2.x, -1.0f, 1.0f);
        float fB = MiscUtils.b(pointF2.y, -100.0f, 100.0f);
        pointF2.y = fB;
        ThreadLocal threadLocal = Utils.f14810a;
        NetworkFetcher networkFetcher = L.f14106a;
        try {
            pathInterpolator = new PathInterpolator(pointF.x, pointF.y, pointF2.x, fB);
        } catch (IllegalArgumentException e2) {
            pathInterpolator = "The Path cannot loop back on itself.".equals(e2.getMessage()) ? new PathInterpolator(Math.min(pointF.x, 1.0f), pointF.y, Math.max(pointF2.x, 0.0f), pointF2.y) : new LinearInterpolator();
        }
        NetworkFetcher networkFetcher2 = L.f14106a;
        return pathInterpolator;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0033. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01fb A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r3v3, types: [android.view.animation.BaseInterpolator] */
    /* JADX WARN: Type inference failed for: r3v8, types: [android.view.animation.BaseInterpolator] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.airbnb.lottie.value.Keyframe b(com.airbnb.lottie.parser.moshi.JsonReader r24, com.airbnb.lottie.LottieComposition r25, float r26, com.airbnb.lottie.parser.ValueParser r27, boolean r28, boolean r29) {
        /*
            Method dump skipped, instructions count: 730
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.KeyframeParser.b(com.airbnb.lottie.parser.moshi.JsonReader, com.airbnb.lottie.LottieComposition, float, com.airbnb.lottie.parser.ValueParser, boolean, boolean):com.airbnb.lottie.value.Keyframe");
    }
}
