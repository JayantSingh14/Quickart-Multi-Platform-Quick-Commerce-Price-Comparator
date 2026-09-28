package com.google.android.gms.internal.pal;

import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public final class zzqy {
    public static byte[] a(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i2 = 0; i2 < 16; i2++) {
            byte b2 = bArr[i2];
            byte b3 = (byte) ((b2 + b2) & 254);
            bArr2[i2] = b3;
            if (i2 < 15) {
                bArr2[i2] = (byte) (((bArr[i2 + 1] >> 7) & 1) | b3);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & WKSRecord.Service.LOC_SRV)) ^ bArr2[15]);
        return bArr2;
    }
}
