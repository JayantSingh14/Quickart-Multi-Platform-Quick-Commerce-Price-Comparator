package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzmr extends zzms {
    @Override // com.google.android.gms.internal.pal.zzms
    public final int a() {
        return 12;
    }

    @Override // com.google.android.gms.internal.pal.zzms
    public final int[] b(int i2, int[] iArr) {
        int length = iArr.length;
        if (length != 3) {
            throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", Integer.valueOf(length * 32)));
        }
        int[] iArr2 = new int[16];
        int[] iArr3 = this.f37932a;
        int[] iArr4 = zzmo.f37928a;
        System.arraycopy(iArr4, 0, iArr2, 0, iArr4.length);
        System.arraycopy(iArr3, 0, iArr2, iArr4.length, 8);
        iArr2[12] = i2;
        System.arraycopy(iArr, 0, iArr2, 13, 3);
        return iArr2;
    }
}
