package com.google.android.gms.internal.pal;

import com.google.android.gms.common.api.Api;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* loaded from: classes4.dex */
public final class zzxo {
    public static final void a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2) {
        if (i2 < 0 || byteBuffer2.remaining() < i2 || byteBuffer3.remaining() < i2 || byteBuffer.remaining() < i2) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
        }
    }

    public static final boolean b(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length == bArr2.length) {
            int i2 = 0;
            for (int i3 = 0; i3 < bArr.length; i3++) {
                i2 |= bArr[i3] ^ bArr2[i3];
            }
            if (i2 == 0) {
                return true;
            }
        }
        return false;
    }

    public static byte[] c(byte[]... bArr) throws GeneralSecurityException {
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            int length = bArr2.length;
            if (i2 > Api.BaseClientBuilder.API_PRIORITY_OTHER - length) {
                throw new GeneralSecurityException("exceeded size limit");
            }
            i2 += length;
        }
        byte[] bArr3 = new byte[i2];
        int i3 = 0;
        for (byte[] bArr4 : bArr) {
            int length2 = bArr4.length;
            System.arraycopy(bArr4, 0, bArr3, i3, length2);
            i3 += length2;
        }
        return bArr3;
    }

    public static final byte[] d(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length == bArr2.length) {
            return e(bArr, 0, 0, bArr2, length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] e(byte[] bArr, int i2, int i3, byte[] bArr2, int i4) {
        if (bArr.length - i4 < i2 || bArr2.length - i4 < i3) {
            throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
        }
        byte[] bArr3 = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            bArr3[i5] = (byte) (bArr[i5 + i2] ^ bArr2[i5 + i3]);
        }
        return bArr3;
    }
}
