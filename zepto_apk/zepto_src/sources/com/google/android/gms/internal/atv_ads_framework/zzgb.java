package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzgb extends zzga {
    public final int a(int i2, byte[] bArr) {
        int i3 = 0;
        while (i3 < i2 && bArr[i3] >= 0) {
            i3++;
        }
        if (i3 < i2) {
            while (i3 < i2) {
                int i4 = i3 + 1;
                byte b2 = bArr[i3];
                if (b2 >= 0) {
                    i3 = i4;
                } else if (b2 < -32) {
                    if (i4 >= i2) {
                        return b2;
                    }
                    if (b2 < -62) {
                        return -1;
                    }
                    i3 += 2;
                    if (bArr[i4] > -65) {
                        return -1;
                    }
                } else if (b2 < -16) {
                    if (i4 >= i2 - 1) {
                        return zzgd.a(i4, bArr, i2);
                    }
                    int i5 = i3 + 2;
                    byte b3 = bArr[i4];
                    if (b3 > -65) {
                        return -1;
                    }
                    if (b2 == -32 && b3 < -96) {
                        return -1;
                    }
                    if (b2 == -19 && b3 >= -96) {
                        return -1;
                    }
                    i3 += 3;
                    if (bArr[i5] > -65) {
                        return -1;
                    }
                } else {
                    if (i4 >= i2 - 2) {
                        return zzgd.a(i4, bArr, i2);
                    }
                    int i6 = i3 + 2;
                    byte b4 = bArr[i4];
                    if (b4 > -65) {
                        return -1;
                    }
                    if ((((b4 + 112) + (b2 << 28)) >> 30) != 0) {
                        return -1;
                    }
                    int i7 = i3 + 3;
                    if (bArr[i6] > -65) {
                        return -1;
                    }
                    i3 += 4;
                    if (bArr[i7] > -65) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
}
