package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzhkl {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f33932a = 0;

    static {
        Charset.forName("UTF-8");
    }

    public static final zzhxc a(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '!' || cCharAt > '~') {
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 33);
                sb.append("Not a printable ASCII character: ");
                sb.append(cCharAt);
                throw new zzhkk(sb.toString());
            }
            bArr[i2] = (byte) cCharAt;
        }
        return zzhxc.a(bArr);
    }

    public static final zzhxc b(String str) throws GeneralSecurityException {
        byte[] bArr = new byte[str.length()];
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < '!' || cCharAt > '~') {
                StringBuilder sb = new StringBuilder(String.valueOf(cCharAt).length() + 33);
                sb.append("Not a printable ASCII character: ");
                sb.append(cCharAt);
                throw new GeneralSecurityException(sb.toString());
            }
            bArr[i2] = (byte) cCharAt;
        }
        return zzhxc.a(bArr);
    }

    public static boolean c(byte[] bArr, byte[] bArr2) {
        if (bArr2.length < bArr.length) {
            return false;
        }
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (bArr2[i2] != bArr[i2]) {
                return false;
            }
        }
        return true;
    }
}
