package com.appsflyer.internal;

/* loaded from: classes.dex */
public class AFk1qSDK {
    public static void getCurrencyIso4217Code(byte[] bArr, byte b2, long j2) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (((1 << i2) & j2) != 0) {
                bArr[i2] = (byte) (bArr[i2] ^ b2);
            }
        }
    }
}
