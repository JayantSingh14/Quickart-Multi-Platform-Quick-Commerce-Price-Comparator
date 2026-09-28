package in.juspay.hypersdk.security;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
public class Base64Codec {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public static int computeEncodedLength(int i2, boolean z) {
        if (i2 == 0) {
            return 0;
        }
        if (!z) {
            return (((i2 - 1) / 3) + 1) << 2;
        }
        int i3 = (i2 / 3) << 2;
        int i4 = i2 % 3;
        return i4 == 0 ? i3 : i3 + i4 + 1;
    }

    public static byte[] decode(String str) throws UnsupportedEncodingException {
        if (str == null || str.isEmpty()) {
            return new byte[0];
        }
        byte[] bytes = str.getBytes("UTF-8");
        int length = bytes.length;
        byte[] bArr = new byte[(length * 6) >> 3];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bytes.length) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < 4 && i2 < length) {
                int i6 = i2 + 1;
                int iDecodeDigit = decodeDigit(bytes[i2]);
                if (iDecodeDigit >= 0) {
                    i5 |= iDecodeDigit << (18 - (i4 * 6));
                    i4++;
                }
                i2 = i6;
            }
            if (i4 >= 2) {
                int i7 = i3 + 1;
                bArr[i3] = (byte) (i5 >> 16);
                if (i4 >= 3) {
                    int i8 = i3 + 2;
                    bArr[i7] = (byte) (i5 >> 8);
                    if (i4 >= 4) {
                        i3 += 3;
                        bArr[i8] = (byte) i5;
                    } else {
                        i3 = i8;
                    }
                } else {
                    i3 = i7;
                }
            }
        }
        return Arrays.copyOf(bArr, i3);
    }

    public static int decodeDigit(byte b2) {
        int iTpGT = tpGT(b2, 64) & tpLT(b2, 91);
        int iTpGT2 = tpGT(b2, 96) & tpLT(b2, WKSRecord.Service.NTP);
        int iTpGT3 = tpGT(b2, 47) & tpLT(b2, 58);
        int iTpEq = tpEq(b2, 45) | tpEq(b2, 43);
        int iTpEq2 = tpEq(b2, 47) | tpEq(b2, 95);
        return tpSelect(iTpGT3, b2 + 4, 0) | tpSelect(iTpGT, b2 - 65, 0) | tpSelect(iTpGT2, b2 - 71, 0) | tpSelect(iTpEq, 62, 0) | tpSelect(iTpEq2, 63, 0) | tpSelect(iTpGT | iTpGT2 | iTpGT3 | iTpEq | iTpEq2, 0, -1);
    }

    public static byte encodeDigitBase64(int i2) {
        int iTpLT = tpLT(i2, 26);
        int iTpGT = tpGT(i2, 25) & tpLT(i2, 52);
        return (byte) (tpSelect(tpGT(i2, 51) & tpLT(i2, 62), i2 - 4, 0) | tpSelect(iTpLT, i2 + 65, 0) | tpSelect(iTpGT, i2 + 71, 0) | tpSelect(tpEq(i2, 62), 43, 0) | tpSelect(tpEq(i2, 63), 47, 0));
    }

    public static byte encodeDigitBase64URL(int i2) {
        int iTpLT = tpLT(i2, 26);
        int iTpGT = tpGT(i2, 25) & tpLT(i2, 52);
        return (byte) (tpSelect(tpGT(i2, 51) & tpLT(i2, 62), i2 - 4, 0) | tpSelect(iTpLT, i2 + 65, 0) | tpSelect(iTpGT, i2 + 71, 0) | tpSelect(tpEq(i2, 62), 45, 0) | tpSelect(tpEq(i2, 63), 95, 0));
    }

    public static String encodeToString(byte[] bArr, boolean z) {
        int length = bArr != null ? bArr.length : 0;
        if (length == 0) {
            return "";
        }
        int i2 = (length / 3) * 3;
        int iComputeEncodedLength = computeEncodedLength(length, z);
        byte[] bArr2 = new byte[iComputeEncodedLength];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            int i5 = i3 + 2;
            int i6 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            i3 += 3;
            int i7 = i6 | (bArr[i5] & 255);
            if (z) {
                bArr2[i4] = encodeDigitBase64URL((i7 >>> 18) & 63);
                bArr2[i4 + 1] = encodeDigitBase64URL((i7 >>> 12) & 63);
                int i8 = i4 + 3;
                bArr2[i4 + 2] = encodeDigitBase64URL((i7 >>> 6) & 63);
                i4 += 4;
                bArr2[i8] = encodeDigitBase64URL(i7 & 63);
            } else {
                bArr2[i4] = encodeDigitBase64((i7 >>> 18) & 63);
                bArr2[i4 + 1] = encodeDigitBase64((i7 >>> 12) & 63);
                int i9 = i4 + 3;
                bArr2[i4 + 2] = encodeDigitBase64((i7 >>> 6) & 63);
                i4 += 4;
                bArr2[i9] = encodeDigitBase64(i7 & 63);
            }
        }
        int i10 = length - i2;
        if (i10 > 0) {
            int i11 = ((bArr[i2] & 255) << 10) | (i10 == 2 ? (bArr[length - 1] & 255) << 2 : 0);
            if (!z) {
                bArr2[iComputeEncodedLength - 4] = encodeDigitBase64(i11 >> 12);
                bArr2[iComputeEncodedLength - 3] = encodeDigitBase64((i11 >>> 6) & 63);
                bArr2[iComputeEncodedLength - 2] = i10 == 2 ? encodeDigitBase64(i11 & 63) : (byte) 61;
                bArr2[iComputeEncodedLength - 1] = 61;
            } else if (i10 == 2) {
                bArr2[iComputeEncodedLength - 3] = encodeDigitBase64URL(i11 >> 12);
                bArr2[iComputeEncodedLength - 2] = encodeDigitBase64URL((i11 >>> 6) & 63);
                bArr2[iComputeEncodedLength - 1] = encodeDigitBase64URL(i11 & 63);
            } else {
                bArr2[iComputeEncodedLength - 2] = encodeDigitBase64URL(i11 >> 12);
                bArr2[iComputeEncodedLength - 1] = encodeDigitBase64URL((i11 >>> 6) & 63);
            }
        }
        return new String(bArr2, "UTF-8");
    }

    public static int tpEq(int i2, int i3) {
        int i4 = i2 ^ i3;
        return ((~i4) & (i4 - 1)) >>> 63;
    }

    public static int tpGT(int i2, int i3) {
        return (int) ((i3 - i2) >>> 63);
    }

    public static int tpLT(int i2, int i3) {
        return (int) ((i2 - i3) >>> 63);
    }

    public static int tpSelect(int i2, int i3, int i4) {
        return ((i2 - 1) & (i4 ^ i3)) ^ i3;
    }
}
