package in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
public final class GenericGF {
    public static final GenericGF AZTEC_DATA_6;
    public static final GenericGF AZTEC_DATA_8;
    public static final GenericGF AZTEC_PARAM;
    public static final GenericGF DATA_MATRIX_FIELD_256;
    public static final GenericGF MAXICODE_FIELD_64;
    public static final GenericGF QR_CODE_FIELD_256;

    /* renamed from: a, reason: collision with root package name */
    private final int[] f48906a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f48907b;

    /* renamed from: c, reason: collision with root package name */
    private final GenericGFPoly f48908c;

    /* renamed from: d, reason: collision with root package name */
    private final GenericGFPoly f48909d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48910e;

    /* renamed from: f, reason: collision with root package name */
    private final int f48911f;

    /* renamed from: g, reason: collision with root package name */
    private final int f48912g;
    public static final GenericGF AZTEC_DATA_12 = new GenericGF(4201, 4096, 1);
    public static final GenericGF AZTEC_DATA_10 = new GenericGF(1033, 1024, 1);

    static {
        GenericGF genericGF = new GenericGF(67, 64, 1);
        AZTEC_DATA_6 = genericGF;
        AZTEC_PARAM = new GenericGF(19, 16, 1);
        QR_CODE_FIELD_256 = new GenericGF(285, 256, 0);
        GenericGF genericGF2 = new GenericGF(301, 256, 1);
        DATA_MATRIX_FIELD_256 = genericGF2;
        AZTEC_DATA_8 = genericGF2;
        MAXICODE_FIELD_64 = genericGF;
    }

    public GenericGF(int i2, int i3, int i4) {
        this.f48911f = i2;
        this.f48910e = i3;
        this.f48912g = i4;
        this.f48906a = new int[i3];
        this.f48907b = new int[i3];
        int i5 = 1;
        for (int i6 = 0; i6 < i3; i6++) {
            this.f48906a[i6] = i5;
            i5 *= 2;
            if (i5 >= i3) {
                i5 = (i5 ^ i2) & (i3 - 1);
            }
        }
        for (int i7 = 0; i7 < i3 - 1; i7++) {
            this.f48907b[this.f48906a[i7]] = i7;
        }
        this.f48908c = new GenericGFPoly(this, new int[]{0});
        this.f48909d = new GenericGFPoly(this, new int[]{1});
    }

    public int a(int i2) {
        return this.f48906a[i2];
    }

    public int b(int i2) {
        if (i2 != 0) {
            return this.f48906a[(this.f48910e - this.f48907b[i2]) - 1];
        }
        throw new ArithmeticException();
    }

    public int c(int i2) {
        if (i2 != 0) {
            return this.f48907b[i2];
        }
        throw new IllegalArgumentException();
    }

    public int getGeneratorBase() {
        return this.f48912g;
    }

    public int getSize() {
        return this.f48910e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GF(0x");
        sb.append(Integer.toHexString(this.f48911f));
        sb.append(',');
        return b.n(sb, this.f48910e, ')');
    }

    public static int a(int i2, int i3) {
        return i2 ^ i3;
    }

    public GenericGFPoly b() {
        return this.f48908c;
    }

    public int c(int i2, int i3) {
        if (i2 == 0 || i3 == 0) {
            return 0;
        }
        int[] iArr = this.f48906a;
        int[] iArr2 = this.f48907b;
        return iArr[(iArr2[i2] + iArr2[i3]) % (this.f48910e - 1)];
    }

    public GenericGFPoly a() {
        return this.f48909d;
    }

    public GenericGFPoly b(int i2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
        if (i3 == 0) {
            return this.f48908c;
        }
        int[] iArr = new int[i2 + 1];
        iArr[0] = i3;
        return new GenericGFPoly(this, iArr);
    }
}
