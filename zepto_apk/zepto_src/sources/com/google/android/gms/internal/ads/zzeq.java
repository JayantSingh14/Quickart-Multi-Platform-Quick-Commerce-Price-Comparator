package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzeq {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f30084a;

    /* renamed from: b, reason: collision with root package name */
    public int f30085b;

    /* renamed from: c, reason: collision with root package name */
    public int f30086c;

    /* renamed from: d, reason: collision with root package name */
    public int f30087d;

    public zzeq(byte[] bArr, int i2) {
        this.f30084a = bArr;
        this.f30087d = i2;
    }

    public final void a(zzer zzerVar) {
        byte[] bArr = zzerVar.f30144a;
        int i2 = zzerVar.f30146c;
        this.f30084a = bArr;
        this.f30085b = 0;
        this.f30086c = 0;
        this.f30087d = i2;
        d(zzerVar.f30145b * 8);
    }

    public final int b() {
        return ((this.f30087d - this.f30085b) * 8) - this.f30086c;
    }

    public final int c() {
        zzgqa.f(this.f30086c == 0);
        return this.f30085b;
    }

    public final void d(int i2) {
        int i3 = i2 / 8;
        this.f30085b = i3;
        this.f30086c = i2 - (i3 * 8);
        m();
    }

    public final void e() {
        int i2 = this.f30086c + 1;
        this.f30086c = i2;
        if (i2 == 8) {
            this.f30086c = 0;
            this.f30085b++;
        }
        m();
    }

    public final void f(int i2) {
        int i3 = i2 / 8;
        int i4 = this.f30085b + i3;
        this.f30085b = i4;
        int i5 = (i2 - (i3 * 8)) + this.f30086c;
        this.f30086c = i5;
        if (i5 > 7) {
            this.f30085b = i4 + 1;
            this.f30086c = i5 - 8;
        }
        m();
    }

    public final boolean g() {
        int i2 = this.f30084a[this.f30085b] & (128 >> this.f30086c);
        e();
        return i2 != 0;
    }

    public final int h(int i2) {
        int i3;
        if (i2 == 0) {
            return 0;
        }
        this.f30086c += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f30086c;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f30086c = i5;
            byte[] bArr = this.f30084a;
            int i6 = this.f30085b;
            this.f30085b = i6 + 1;
            i4 |= (bArr[i6] & 255) << i5;
        }
        byte[] bArr2 = this.f30084a;
        int i7 = this.f30085b;
        int i8 = i4 | ((bArr2[i7] & 255) >> (8 - i3));
        int i9 = 32 - i2;
        if (i3 == 8) {
            this.f30086c = 0;
            this.f30085b = i7 + 1;
        }
        int i10 = ((-1) >>> i9) & i8;
        m();
        return i10;
    }

    public final long i(int i2) {
        if (i2 <= 32) {
            int iH = h(i2);
            String str = zzfj.f31254a;
            return 4294967295L & iH;
        }
        int iH2 = h(i2 - 32);
        int iH3 = h(32);
        String str2 = zzfj.f31254a;
        return (4294967295L & iH3) | ((iH2 & 4294967295L) << 32);
    }

    public final void j(int i2, byte[] bArr) {
        int i3;
        int i4 = 0;
        while (true) {
            i3 = i2 >> 3;
            if (i4 >= i3) {
                break;
            }
            byte[] bArr2 = this.f30084a;
            int i5 = this.f30085b;
            int i6 = i5 + 1;
            this.f30085b = i6;
            byte b2 = bArr2[i5];
            int i7 = this.f30086c;
            byte b3 = (byte) (b2 << i7);
            bArr[i4] = b3;
            bArr[i4] = (byte) (((bArr2[i6] & 255) >> (8 - i7)) | b3);
            i4++;
        }
        int i8 = i2 & 7;
        if (i8 == 0) {
            return;
        }
        byte b4 = (byte) (bArr[i3] & (255 >> i8));
        bArr[i3] = b4;
        int i9 = this.f30086c;
        if (i9 + i8 > 8) {
            byte[] bArr3 = this.f30084a;
            int i10 = this.f30085b;
            this.f30085b = i10 + 1;
            b4 = (byte) (b4 | ((bArr3[i10] & 255) << i9));
            bArr[i3] = b4;
            i9 -= 8;
        }
        int i11 = i9 + i8;
        this.f30086c = i11;
        byte[] bArr4 = this.f30084a;
        int i12 = this.f30085b;
        bArr[i3] = (byte) (((byte) (((255 & bArr4[i12]) >> (8 - i11)) << (8 - i8))) | b4);
        if (i11 == 8) {
            this.f30086c = 0;
            this.f30085b = i12 + 1;
        }
        m();
    }

    public final void k() {
        if (this.f30086c == 0) {
            return;
        }
        this.f30086c = 0;
        this.f30085b++;
        m();
    }

    public final void l(int i2) {
        zzgqa.f(this.f30086c == 0);
        this.f30085b += i2;
        m();
    }

    public final void m() {
        int i2;
        int i3 = this.f30085b;
        boolean z = false;
        if (i3 >= 0 && (i3 < (i2 = this.f30087d) || (i3 == i2 && this.f30086c == 0))) {
            z = true;
        }
        zzgqa.f(z);
    }

    public zzeq() {
        this.f30084a = zzfj.f31255b;
    }
}
