package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;

/* loaded from: classes4.dex */
public final class QRCodeDecoderMetaData {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f48939a;

    public QRCodeDecoderMetaData(boolean z) {
        this.f48939a = z;
    }

    public void applyMirroredCorrection(ResultPoint[] resultPointArr) {
        if (!this.f48939a || resultPointArr == null || resultPointArr.length < 3) {
            return;
        }
        ResultPoint resultPoint = resultPointArr[0];
        resultPointArr[0] = resultPointArr[2];
        resultPointArr[2] = resultPoint;
    }

    public boolean isMirrored() {
        return this.f48939a;
    }
}
