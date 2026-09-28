package androidx.media3.common.util;

import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
@UnstableApi
/* loaded from: classes3.dex */
public final class ParsableBitArray {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f5716a;

    /* renamed from: b, reason: collision with root package name */
    public int f5717b;

    /* renamed from: c, reason: collision with root package name */
    public int f5718c;

    /* renamed from: d, reason: collision with root package name */
    public int f5719d;

    public ParsableBitArray() {
        this.f5716a = Util.f5749f;
    }

    public final void a() {
        int i2;
        int i3 = this.f5717b;
        Assertions.g(i3 >= 0 && (i3 < (i2 = this.f5719d) || (i3 == i2 && this.f5718c == 0)));
    }

    public final int b() {
        return ((this.f5719d - this.f5717b) * 8) - this.f5718c;
    }

    public final void c() {
        if (this.f5718c == 0) {
            return;
        }
        this.f5718c = 0;
        this.f5717b++;
        a();
    }

    public final int d() {
        Assertions.g(this.f5718c == 0);
        return this.f5717b;
    }

    public final int e() {
        return (this.f5717b * 8) + this.f5718c;
    }

    public final boolean f() {
        boolean z = (this.f5716a[this.f5717b] & (128 >> this.f5718c)) != 0;
        n();
        return z;
    }

    public final int g(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f5718c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f5718c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f5718c = i5;
            byte[] bArr = this.f5716a;
            int i6 = this.f5717b;
            this.f5717b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f5716a;
        int i7 = this.f5717b;
        int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f5718c = 0;
            this.f5717b = i7 + 1;
        }
        a();
        return i8;
    }

    public final void h(int i2, byte[] bArr) {
        int i3 = i2 >> 3;
        for (int i4 = 0; i4 < i3; i4++) {
            byte[] bArr2 = this.f5716a;
            int i5 = this.f5717b;
            int i6 = i5 + 1;
            this.f5717b = i6;
            byte b2 = bArr2[i5];
            int i7 = this.f5718c;
            byte b3 = (byte) (b2 << i7);
            bArr[i4] = b3;
            bArr[i4] = (byte) (((255 & bArr2[i6]) >> (8 - i7)) | b3);
        }
        int i8 = i2 & 7;
        if (i8 == 0) {
            return;
        }
        byte b4 = (byte) (bArr[i3] & (255 >> i8));
        bArr[i3] = b4;
        int i9 = this.f5718c;
        if (i9 + i8 > 8) {
            byte[] bArr3 = this.f5716a;
            int i10 = this.f5717b;
            this.f5717b = i10 + 1;
            bArr[i3] = (byte) (b4 | ((bArr3[i10] & 255) << i9));
            this.f5718c = i9 - 8;
        }
        int i11 = this.f5718c + i8;
        this.f5718c = i11;
        byte[] bArr4 = this.f5716a;
        int i12 = this.f5717b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | bArr[i3]);
        if (i11 == 8) {
            this.f5718c = 0;
            this.f5717b = i12 + 1;
        }
        a();
    }

    public final long i(int i2) {
        if (i2 <= 32) {
            int iG = g(i2);
            int i3 = Util.f5744a;
            return 4294967295L & iG;
        }
        int iG2 = g(i2 - 32);
        int iG3 = g(32);
        int i4 = Util.f5744a;
        return (4294967295L & iG3) | ((iG2 & 4294967295L) << 32);
    }

    public final void j(int i2, byte[] bArr) {
        Assertions.g(this.f5718c == 0);
        System.arraycopy(this.f5716a, this.f5717b, bArr, 0, i2);
        this.f5717b += i2;
        a();
    }

    public final void k(int i2, byte[] bArr) {
        this.f5716a = bArr;
        this.f5717b = 0;
        this.f5718c = 0;
        this.f5719d = i2;
    }

    public final void l(ParsableByteArray parsableByteArray) {
        k(parsableByteArray.f5725c, parsableByteArray.f5723a);
        m(parsableByteArray.f5724b * 8);
    }

    public final void m(int i2) {
        int i3 = i2 / 8;
        this.f5717b = i3;
        this.f5718c = i2 - (i3 * 8);
        a();
    }

    public final void n() {
        int i2 = this.f5718c + 1;
        this.f5718c = i2;
        if (i2 == 8) {
            this.f5718c = 0;
            this.f5717b++;
        }
        a();
    }

    public final void o(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f5717b + i3;
        this.f5717b = i4;
        int i5 = (i2 - (i3 * 8)) + this.f5718c;
        this.f5718c = i5;
        if (i5 > 7) {
            this.f5717b = i4 + 1;
            this.f5718c = i5 - 8;
        }
        a();
    }

    public final void p(int i2) {
        Assertions.g(this.f5718c == 0);
        this.f5717b += i2;
        a();
    }

    public ParsableBitArray(byte[] bArr, int i2) {
        this.f5716a = bArr;
        this.f5719d = i2;
    }
}
