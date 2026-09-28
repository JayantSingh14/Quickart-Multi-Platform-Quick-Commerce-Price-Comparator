package org.xbill.DNS;

import lombok.Generated;

/* loaded from: classes5.dex */
final class IPAddressUtils {
    static final int IPv4 = 1;
    static final int IPv6 = 2;

    @Generated
    private IPAddressUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static byte[] parseV4(String str) {
        byte[] bArr = new byte[4];
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (cCharAt < '0' || cCharAt > '9') {
                if (cCharAt != '.' || i2 == 3 || i3 == 0) {
                    return null;
                }
                bArr[i2] = (byte) i4;
                i4 = 0;
                i2++;
                i3 = 0;
            } else {
                if (i3 == 3) {
                    return null;
                }
                if (i3 > 0 && i4 == 0) {
                    return null;
                }
                i3++;
                int i6 = (cCharAt - '0') + (i4 * 10);
                if (i6 > 255) {
                    return null;
                }
                i4 = i6;
            }
        }
        if (i2 != 3 || i3 == 0) {
            return null;
        }
        bArr[i2] = (byte) i4;
        return bArr;
    }

    public static byte[] parseV6(String str) throws NumberFormatException {
        int i2;
        byte[] byteArray;
        byte[] bArr = new byte[16];
        int i3 = -1;
        String[] strArrSplit = str.split(":", -1);
        int length = strArrSplit.length;
        int i4 = length - 1;
        if (!strArrSplit[0].isEmpty()) {
            i2 = 0;
        } else {
            if (i4 <= 0 || !strArrSplit[1].isEmpty()) {
                return null;
            }
            i2 = 1;
        }
        if (strArrSplit[i4].isEmpty()) {
            if (i4 - i2 <= 0 || !strArrSplit[length - 2].isEmpty()) {
                return null;
            }
            i4 = length - 2;
        }
        if ((i4 - i2) + 1 > 8) {
            return null;
        }
        int i5 = 0;
        while (true) {
            if (i2 > i4) {
                break;
            }
            if (strArrSplit[i2].isEmpty()) {
                if (i3 >= 0) {
                    return null;
                }
                i3 = i5;
            } else if (strArrSplit[i2].indexOf(46) < 0) {
                for (int i6 = 0; i6 < strArrSplit[i2].length(); i6++) {
                    try {
                        if (Character.digit(strArrSplit[i2].charAt(i6), 16) < 0) {
                            return null;
                        }
                    } catch (NumberFormatException unused) {
                        return null;
                    }
                }
                int i7 = Integer.parseInt(strArrSplit[i2], 16);
                if (!Utils.isUInt16(i7)) {
                    return null;
                }
                int i8 = i5 + 1;
                bArr[i5] = (byte) (i7 >>> 8);
                i5 += 2;
                bArr[i8] = (byte) (i7 & 255);
            } else {
                if (i2 < i4 || i2 > 6 || (byteArray = Address.toByteArray(strArrSplit[i2], 1)) == null) {
                    return null;
                }
                int i9 = 0;
                while (i9 < 4) {
                    bArr[i5] = byteArray[i9];
                    i9++;
                    i5++;
                }
            }
            i2++;
        }
        if (i5 < 16 && i3 < 0) {
            return null;
        }
        if (i3 >= 0) {
            int i10 = (16 - i5) + i3;
            System.arraycopy(bArr, i3, bArr, i10, i5 - i3);
            while (i3 < i10) {
                bArr[i3] = 0;
                i3++;
            }
        }
        return bArr;
    }
}
