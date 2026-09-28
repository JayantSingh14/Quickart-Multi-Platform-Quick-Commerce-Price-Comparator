package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

/* loaded from: classes4.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: b, reason: collision with root package name */
    private static final ErrorCorrectionLevel[] f48930b;

    /* renamed from: a, reason: collision with root package name */
    private final int f48932a;

    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        f48930b = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    ErrorCorrectionLevel(int i2) {
        this.f48932a = i2;
    }

    public static ErrorCorrectionLevel forBits(int i2) {
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = f48930b;
            if (i2 < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i2];
            }
        }
        throw new IllegalArgumentException();
    }

    public int getBits() {
        return this.f48932a;
    }
}
