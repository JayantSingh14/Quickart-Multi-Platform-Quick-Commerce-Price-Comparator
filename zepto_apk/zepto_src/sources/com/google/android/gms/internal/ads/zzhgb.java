package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzhgb extends zzhgc {
    @Override // com.google.android.gms.internal.ads.zzhgc
    public final int[] a(int i2, int[] iArr) {
        int length = iArr.length;
        if (length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = this.f33750a;
        int[] iArr4 = zzhga.f33749a;
        int length2 = iArr4.length;
        System.arraycopy(iArr4, 0, iArr2, 0, length2);
        System.arraycopy(iArr3, 0, iArr2, length2, 8);
        iArr2[12] = i2;
        System.arraycopy(iArr, 0, iArr2, 13, 3);
        return iArr2;
    }

    @Override // com.google.android.gms.internal.ads.zzhgc
    public final int b() {
        return 12;
    }
}
