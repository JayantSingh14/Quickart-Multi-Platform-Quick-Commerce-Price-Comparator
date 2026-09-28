package in.juspay.widget.qrscanner.com.google.zxing.common;

/* loaded from: classes4.dex */
public final class BitSource {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f48869a;

    /* renamed from: b, reason: collision with root package name */
    private int f48870b;

    /* renamed from: c, reason: collision with root package name */
    private int f48871c;

    public BitSource(byte[] bArr) {
        this.f48869a = bArr;
    }

    public int available() {
        return ((this.f48869a.length - this.f48870b) * 8) - this.f48871c;
    }

    public int getBitOffset() {
        return this.f48871c;
    }

    public int getByteOffset() {
        return this.f48870b;
    }

    public int readBits(int i2) {
        if (i2 < 1 || i2 > 32 || i2 > available()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i3 = this.f48871c;
        int i4 = 0;
        if (i3 > 0) {
            int i5 = 8 - i3;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.f48869a;
            int i8 = this.f48870b;
            int i9 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
            i2 -= i6;
            int i10 = i3 + i6;
            this.f48871c = i10;
            if (i10 == 8) {
                this.f48871c = 0;
                this.f48870b = i8 + 1;
            }
            i4 = i9;
        }
        if (i2 > 0) {
            while (i2 >= 8) {
                int i11 = i4 << 8;
                byte[] bArr2 = this.f48869a;
                int i12 = this.f48870b;
                i4 = (bArr2[i12] & 255) | i11;
                this.f48870b = i12 + 1;
                i2 -= 8;
            }
            if (i2 > 0) {
                int i13 = 8 - i2;
                int i14 = ((((255 >> i13) << i13) & this.f48869a[this.f48870b]) >> i13) | (i4 << i2);
                this.f48871c += i2;
                return i14;
            }
        }
        return i4;
    }
}
