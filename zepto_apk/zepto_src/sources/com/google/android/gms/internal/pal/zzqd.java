package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
public final class zzqd {
    public static final zzyv a(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '!' || cCharAt > '~') {
                throw new zzqc("Not a printable ASCII character: " + cCharAt);
            }
            bArr[i2] = (byte) cCharAt;
        }
        return zzyv.a(bArr);
    }
}
