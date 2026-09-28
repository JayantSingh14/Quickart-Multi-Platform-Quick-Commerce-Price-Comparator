package com.google.android.gms.internal.ads;

import java.security.NoSuchAlgorithmException;
import java.security.spec.ECParameterSpec;

/* loaded from: classes4.dex */
public final class zzhvw {
    public static ECParameterSpec a(zzhvu zzhvuVar) throws NoSuchAlgorithmException {
        int iOrdinal = zzhvuVar.ordinal();
        if (iOrdinal == 0) {
            return zzhhq.f33824a;
        }
        if (iOrdinal == 1) {
            return zzhhq.f33825b;
        }
        if (iOrdinal == 2) {
            return zzhhq.f33826c;
        }
        throw new NoSuchAlgorithmException("curve not implemented:".concat(zzhvuVar.toString()));
    }

    public static byte[] b(byte[] bArr) {
        int length;
        int i2 = 0;
        while (true) {
            length = bArr.length;
            if (i2 >= length || bArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == length) {
            i2 = length - 1;
        }
        int i3 = (bArr[i2] & 128) == 128 ? 1 : 0;
        int i4 = length - i2;
        byte[] bArr2 = new byte[i4 + i3];
        System.arraycopy(bArr, i2, bArr2, i3, i4);
        return bArr2;
    }
}
