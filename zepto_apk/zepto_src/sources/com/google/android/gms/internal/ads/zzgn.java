package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzgn {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f32957a;

    /* renamed from: b, reason: collision with root package name */
    public final int f32958b;

    /* renamed from: c, reason: collision with root package name */
    public int f32959c;

    /* renamed from: d, reason: collision with root package name */
    public int f32960d = 0;

    public zzgn(byte[] bArr, int i2, int i3) {
        this.f32957a = bArr;
        this.f32959c = i2;
        this.f32958b = i3;
        i();
    }

    public final void a() {
        int i2 = this.f32960d + 1;
        this.f32960d = i2;
        if (i2 == 8) {
            this.f32960d = 0;
            int i3 = this.f32959c;
            this.f32959c = i3 + (true == h(i3 + 1) ? 2 : 1);
        }
        i();
    }

    public final void b(int i2) {
        int i3 = this.f32959c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f32959c = i5;
        int i6 = (i2 - (i4 * 8)) + this.f32960d;
        this.f32960d = i6;
        if (i6 > 7) {
            this.f32959c = i5 + 1;
            this.f32960d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f32959c) {
                i();
                return;
            } else if (h(i3)) {
                this.f32959c++;
                i3 += 2;
            }
        }
    }

    public final boolean c(int i2) {
        int i3;
        int i4 = this.f32959c;
        int i5 = i2 / 8;
        int i6 = i4 + i5;
        int i7 = (this.f32960d + i2) - (i5 * 8);
        if (i7 > 7) {
            i6++;
            i7 -= 8;
        }
        while (true) {
            i4++;
            i3 = this.f32958b;
            if (i4 > i6 || i6 >= i3) {
                break;
            }
            if (h(i4)) {
                i6++;
                i4 += 2;
            }
        }
        if (i6 >= i3) {
            return i6 == i3 && i7 == 0;
        }
        return true;
    }

    public final boolean d() {
        int i2 = this.f32957a[this.f32959c] & (128 >> this.f32960d);
        a();
        return i2 != 0;
    }

    public final int e(int i2) {
        int i3;
        byte[] bArr;
        this.f32960d += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f32960d;
            bArr = this.f32957a;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f32960d = i5;
            int i6 = this.f32959c;
            i4 |= (bArr[i6] & 255) << i5;
            if (true != h(i6 + 1)) {
                i = 1;
            }
            this.f32959c = i6 + i;
        }
        int i7 = this.f32959c;
        int i8 = i4 | ((bArr[i7] & 255) >> (8 - i3));
        int i9 = 32 - i2;
        if (i3 == 8) {
            this.f32960d = 0;
            this.f32959c = i7 + (true != h(i7 + 1) ? 1 : 2);
        }
        int i10 = ((-1) >>> i9) & i8;
        i();
        return i10;
    }

    public final int f() {
        int iG = g();
        int i2 = iG % 2;
        return ((iG + 1) / 2) * (i2 == 0 ? -1 : 1);
    }

    public final int g() {
        int i2 = 0;
        while (!d()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? e(i2) : 0);
    }

    public final boolean h(int i2) {
        if (i2 < 2 || i2 >= this.f32958b) {
            return false;
        }
        byte[] bArr = this.f32957a;
        return bArr[i2] == 3 && bArr[i2 + (-2)] == 0 && bArr[i2 + (-1)] == 0;
    }

    public final void i() {
        int i2;
        int i3 = this.f32959c;
        boolean z = false;
        if (i3 >= 0 && (i3 < (i2 = this.f32958b) || (i3 == i2 && this.f32960d == 0))) {
            z = true;
        }
        zzgqa.f(z);
    }
}
