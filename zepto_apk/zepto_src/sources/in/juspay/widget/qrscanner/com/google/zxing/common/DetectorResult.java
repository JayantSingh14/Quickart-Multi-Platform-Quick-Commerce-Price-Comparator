package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;

/* loaded from: classes4.dex */
public class DetectorResult {

    /* renamed from: a, reason: collision with root package name */
    private final BitMatrix f48888a;

    /* renamed from: b, reason: collision with root package name */
    private final ResultPoint[] f48889b;

    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr) {
        this.f48888a = bitMatrix;
        this.f48889b = resultPointArr;
    }

    public final BitMatrix getBits() {
        return this.f48888a;
    }

    public final ResultPoint[] getPoints() {
        return this.f48889b;
    }
}
