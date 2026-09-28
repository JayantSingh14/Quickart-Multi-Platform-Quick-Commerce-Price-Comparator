package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class zzbdr extends zzbdm {

    /* renamed from: c, reason: collision with root package name */
    public MessageDigest f24808c;

    public final byte[] b(String str) throws UnsupportedEncodingException {
        byte[] bArr;
        byte[] bArrArray;
        String[] strArrSplit = str.split(StringUtils.SPACE);
        int length = strArrSplit.length;
        int i2 = 4;
        if (length == 1) {
            int iA = zzbdq.a(strArrSplit[0]);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
            byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocate.putInt(iA);
            bArrArray = byteBufferAllocate.array();
        } else {
            if (length < 5) {
                bArr = new byte[length + length];
                for (int i3 = 0; i3 < strArrSplit.length; i3++) {
                    int iA2 = zzbdq.a(strArrSplit[i3]);
                    int i4 = (iA2 >> 16) ^ ((char) iA2);
                    byte b2 = (byte) i4;
                    byte b3 = (byte) (i4 >> 8);
                    int i5 = i3 + i3;
                    bArr[i5] = new byte[]{b2, b3}[0];
                    bArr[i5 + 1] = b3;
                }
            } else {
                bArr = new byte[length];
                for (int i6 = 0; i6 < strArrSplit.length; i6++) {
                    int iA3 = zzbdq.a(strArrSplit[i6]);
                    bArr[i6] = (byte) ((iA3 >> 24) ^ (((iA3 & 255) ^ ((iA3 >> 8) & 255)) ^ ((iA3 >> 16) & 255)));
                }
            }
            bArrArray = bArr;
        }
        this.f24808c = a();
        synchronized (this.f24803a) {
            try {
                MessageDigest messageDigest = this.f24808c;
                if (messageDigest == null) {
                    return new byte[0];
                }
                messageDigest.reset();
                this.f24808c.update(bArrArray);
                byte[] bArrDigest = this.f24808c.digest();
                int length2 = bArrDigest.length;
                if (length2 <= 4) {
                    i2 = length2;
                }
                byte[] bArr2 = new byte[i2];
                System.arraycopy(bArrDigest, 0, bArr2, 0, i2);
                return bArr2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
