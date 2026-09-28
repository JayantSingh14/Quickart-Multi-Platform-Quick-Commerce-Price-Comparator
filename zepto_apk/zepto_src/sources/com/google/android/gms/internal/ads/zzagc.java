package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzagc {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f22988a;

    /* renamed from: b, reason: collision with root package name */
    public final int f22989b;

    /* renamed from: c, reason: collision with root package name */
    public int f22990c;

    /* renamed from: d, reason: collision with root package name */
    public int f22991d;

    public zzagc(byte[] bArr) {
        this.f22988a = bArr;
        this.f22989b = bArr.length;
    }

    public final boolean a() {
        int i2 = (this.f22988a[this.f22990c] & 255) >> this.f22991d;
        c(1);
        return 1 == (i2 & 1);
    }

    public final int b(int i2) {
        int i3 = this.f22990c;
        int i4 = i3 + 1;
        int iMin = Math.min(i2, 8 - this.f22991d);
        byte[] bArr = this.f22988a;
        int i5 = ((bArr[i3] & 255) >> this.f22991d) & (255 >> (8 - iMin));
        while (iMin < i2) {
            i5 |= (bArr[i4] & 255) << iMin;
            iMin += 8;
            i4++;
        }
        int i6 = i5 & ((-1) >>> (32 - i2));
        c(i2);
        return i6;
    }

    public final void c(int i2) {
        int i3;
        int i4 = i2 / 8;
        int i5 = this.f22990c + i4;
        this.f22990c = i5;
        int i6 = (i2 - (i4 * 8)) + this.f22991d;
        this.f22991d = i6;
        if (i6 > 7) {
            i5++;
            this.f22990c = i5;
            i6 -= 8;
            this.f22991d = i6;
        }
        boolean z = false;
        if (i5 >= 0 && (i5 < (i3 = this.f22989b) || (i5 == i3 && i6 == 0))) {
            z = true;
        }
        zzgqa.f(z);
    }
}
