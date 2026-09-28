package androidx.media3.extractor;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
/* loaded from: classes3.dex */
public final class VorbisBitArray {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f8625a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8626b;

    /* renamed from: c, reason: collision with root package name */
    public int f8627c;

    /* renamed from: d, reason: collision with root package name */
    public int f8628d;

    public VorbisBitArray(byte[] bArr) {
        this.f8625a = bArr;
        this.f8626b = bArr.length;
    }

    public final boolean a() {
        boolean z = (((this.f8625a[this.f8627c] & 255) >> this.f8628d) & 1) == 1;
        c(1);
        return z;
    }

    public final int b(int i2) {
        int i3 = this.f8627c;
        int iMin = Math.min(i2, 8 - this.f8628d);
        int i4 = i3 + 1;
        byte[] bArr = this.f8625a;
        int i5 = ((bArr[i3] & 255) >> this.f8628d) & (255 >> (8 - iMin));
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
        int i5 = this.f8627c + i4;
        this.f8627c = i5;
        int i6 = (i2 - (i4 * 8)) + this.f8628d;
        this.f8628d = i6;
        boolean z = true;
        if (i6 > 7) {
            this.f8627c = i5 + 1;
            this.f8628d = i6 - 8;
        }
        int i7 = this.f8627c;
        if (i7 < 0 || (i7 >= (i3 = this.f8626b) && (i7 != i3 || this.f8628d != 0))) {
            z = false;
        }
        Assertions.g(z);
    }
}
