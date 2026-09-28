package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class AFk1tSDK {
    public static void AFAdRevenueData(int i2, int i3, boolean z, int i4, int[] iArr, int[][] iArr2, int[] iArr3) {
        if (!z) {
            getCurrencyIso4217Code(iArr);
        }
        int i5 = 0;
        while (i5 < i4) {
            int i6 = i2 ^ iArr[i5];
            int mediationNetwork = i3 ^ getMediationNetwork(i6, iArr2);
            i5++;
            i3 = i6;
            i2 = mediationNetwork;
        }
        int i7 = i2 ^ iArr[iArr.length - 2];
        int i8 = i3 ^ iArr[iArr.length - 1];
        if (!z) {
            getCurrencyIso4217Code(iArr);
        }
        iArr3[0] = i8;
        iArr3[1] = i7;
    }

    private static void getCurrencyIso4217Code(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i3 = iArr[i2];
            iArr[i2] = iArr[(iArr.length - i2) - 1];
            iArr[(iArr.length - i2) - 1] = i3;
        }
    }

    private static int getMediationNetwork(int i2, int[][] iArr) {
        return ((iArr[0][i2 >>> 24] + iArr[1][(i2 >>> 16) & 255]) ^ iArr[2][(i2 >>> 8) & 255]) + iArr[3][i2 & 255];
    }
}
