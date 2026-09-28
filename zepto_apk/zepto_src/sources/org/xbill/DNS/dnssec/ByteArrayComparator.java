package org.xbill.DNS.dnssec;

import lombok.Generated;

/* loaded from: classes5.dex */
final class ByteArrayComparator {
    private static final int MAX_BYTE = 255;

    @Generated
    private ByteArrayComparator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int compare(byte[] bArr, byte[] bArr2) {
        int length;
        int length2;
        if (bArr.length == bArr2.length) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b2 = bArr[i2];
                byte b3 = bArr2[i2];
                if (b2 != b3) {
                    length = b2 & 255;
                    length2 = b3 & 255;
                }
            }
            return 0;
        }
        length = bArr.length;
        length2 = bArr2.length;
        return length - length2;
    }
}
