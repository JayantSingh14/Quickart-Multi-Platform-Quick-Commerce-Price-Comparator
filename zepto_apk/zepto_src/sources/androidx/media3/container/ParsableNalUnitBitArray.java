package androidx.media3.container;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class ParsableNalUnitBitArray {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f5811a;

    /* renamed from: b, reason: collision with root package name */
    public int f5812b;

    /* renamed from: c, reason: collision with root package name */
    public int f5813c;

    /* renamed from: d, reason: collision with root package name */
    public int f5814d = 0;

    public ParsableNalUnitBitArray(byte[] bArr, int i2, int i3) {
        this.f5811a = bArr;
        this.f5813c = i2;
        this.f5812b = i3;
        a();
    }

    public final void a() {
        int i2;
        int i3 = this.f5813c;
        Assertions.g(i3 >= 0 && (i3 < (i2 = this.f5812b) || (i3 == i2 && this.f5814d == 0)));
    }

    public final boolean b(int i2) {
        int i3 = this.f5813c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        int i6 = (this.f5814d + i2) - (i4 * 8);
        if (i6 > 7) {
            i5++;
            i6 -= 8;
        }
        while (true) {
            i3++;
            if (i3 > i5 || i5 >= this.f5812b) {
                break;
            }
            if (h(i3)) {
                i5++;
                i3 += 2;
            }
        }
        int i7 = this.f5812b;
        if (i5 >= i7) {
            return i5 == i7 && i6 == 0;
        }
        return true;
    }

    public final boolean c() {
        int i2 = this.f5813c;
        int i3 = this.f5814d;
        int i4 = 0;
        while (this.f5813c < this.f5812b && !d()) {
            i4++;
        }
        boolean z = this.f5813c == this.f5812b;
        this.f5813c = i2;
        this.f5814d = i3;
        return !z && b((i4 * 2) + 1);
    }

    public final boolean d() {
        boolean z = (this.f5811a[this.f5813c] & (128 >> this.f5814d)) != 0;
        i();
        return z;
    }

    public final int e(int i2) {
        int i3;
        this.f5814d += i2;
        int i4 = 0;
        while (true) {
            i3 = this.f5814d;
            if (i3 <= 8) {
                break;
            }
            int i5 = i3 - 8;
            this.f5814d = i5;
            byte[] bArr = this.f5811a;
            int i6 = this.f5813c;
            i4 |= (bArr[i6] & 255) << i5;
            if (!h(i6 + 1)) {
                i = 1;
            }
            this.f5813c = i6 + i;
        }
        byte[] bArr2 = this.f5811a;
        int i7 = this.f5813c;
        int i8 = ((-1) >>> (32 - i2)) & (i4 | ((bArr2[i7] & 255) >> (8 - i3)));
        if (i3 == 8) {
            this.f5814d = 0;
            this.f5813c = i7 + (h(i7 + 1) ? 2 : 1);
        }
        a();
        return i8;
    }

    public final int f() {
        int i2 = 0;
        while (!d()) {
            i2++;
        }
        return ((1 << i2) - 1) + (i2 > 0 ? e(i2) : 0);
    }

    public final int g() {
        int iF = f();
        return ((iF + 1) / 2) * (iF % 2 == 0 ? -1 : 1);
    }

    public final boolean h(int i2) {
        if (2 > i2 || i2 >= this.f5812b) {
            return false;
        }
        byte[] bArr = this.f5811a;
        return bArr[i2] == 3 && bArr[i2 + (-2)] == 0 && bArr[i2 - 1] == 0;
    }

    public final void i() {
        int i2 = this.f5814d + 1;
        this.f5814d = i2;
        if (i2 == 8) {
            this.f5814d = 0;
            int i3 = this.f5813c;
            this.f5813c = i3 + (h(i3 + 1) ? 2 : 1);
        }
        a();
    }

    public final void j(int i2) {
        int i3 = this.f5813c;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        this.f5813c = i5;
        int i6 = (i2 - (i4 * 8)) + this.f5814d;
        this.f5814d = i6;
        if (i6 > 7) {
            this.f5813c = i5 + 1;
            this.f5814d = i6 - 8;
        }
        while (true) {
            i3++;
            if (i3 > this.f5813c) {
                a();
                return;
            } else if (h(i3)) {
                this.f5813c++;
                i3 += 2;
            }
        }
    }
}
