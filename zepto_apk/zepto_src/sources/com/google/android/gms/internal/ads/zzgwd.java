package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import org.xbill.DNS.KEYRecord;

/* loaded from: classes4.dex */
public final class zzgwd {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f33286a = 0;

    static {
        new zzgwb();
    }

    public static byte[] a(InputStream inputStream) throws IOException {
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iHighestOneBit = Integer.highestOneBit(0);
        int iMin = Math.min(KEYRecord.Flags.FLAG2, Math.max(128, iHighestOneBit + iHighestOneBit));
        int i2 = 0;
        while (i2 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i2);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i3 = 0;
            while (i3 < iMin2) {
                int i4 = inputStream.read(bArr, i3, iMin2 - i3);
                if (i4 == -1) {
                    return b(arrayDeque, i2);
                }
                i3 += i4;
                i2 += i4;
            }
            iMin = zzgwx.b(iMin * (iMin < 4096 ? 4 : 2));
        }
        if (inputStream.read() == -1) {
            return b(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static byte[] b(ArrayDeque arrayDeque, int i2) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        int length = bArr.length;
        if (length == i2) {
            return bArr;
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i2);
        int i3 = i2 - length;
        while (i3 > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(i3, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i2 - i3, iMin);
            i3 -= iMin;
        }
        return bArrCopyOf;
    }
}
