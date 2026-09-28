package com.reactnativecommunity.netinfo;

/* loaded from: classes.dex */
public class NetInfoUtils {
    public static void a(byte[] bArr) {
        for (int i2 = 0; i2 < bArr.length / 2; i2++) {
            byte b2 = bArr[i2];
            bArr[i2] = bArr[(bArr.length - i2) - 1];
            bArr[(bArr.length - i2) - 1] = b2;
        }
    }
}
