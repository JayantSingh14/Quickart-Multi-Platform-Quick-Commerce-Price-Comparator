package org.xbill.DNS.utils;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public class base32 {
    private final String alphabet;
    private final boolean lowercase;
    private final boolean padding;

    public static class Alphabet {
        public static final String BASE32 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567=";
        public static final String BASE32HEX = "0123456789ABCDEFGHIJKLMNOPQRSTUV=";

        private Alphabet() {
        }
    }

    public base32(String str, boolean z, boolean z2) {
        this.alphabet = str;
        this.padding = z;
        this.lowercase = z2;
    }

    private static int blockLenToPadding(int i2) {
        if (i2 == 1) {
            return 6;
        }
        if (i2 == 2) {
            return 4;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 != 4) {
            return i2 != 5 ? -1 : 0;
        }
        return 1;
    }

    private static int paddingToBlockLen(int i2) {
        if (i2 == 0) {
            return 5;
        }
        if (i2 == 1) {
            return 4;
        }
        if (i2 == 3) {
            return 3;
        }
        if (i2 != 4) {
            return i2 != 6 ? -1 : 1;
        }
        return 2;
    }

    public byte[] fromString(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (byte b2 : str.getBytes()) {
            char c2 = (char) b2;
            if (!Character.isWhitespace(c2)) {
                byteArrayOutputStream.write((byte) Character.toUpperCase(c2));
            }
        }
        if (!this.padding) {
            while (byteArrayOutputStream.size() % 8 != 0) {
                byteArrayOutputStream.write(61);
            }
        } else if (byteArrayOutputStream.size() % 8 != 0) {
            return null;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.reset();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        for (int i2 = 0; i2 < byteArray.length / 8; i2++) {
            short[] sArr = new short[8];
            int i3 = 8;
            for (int i4 = 0; i4 < 8; i4++) {
                byte b3 = byteArray[(i2 * 8) + i4];
                if (((char) b3) == '=') {
                    break;
                }
                short sIndexOf = (short) this.alphabet.indexOf(b3);
                sArr[i4] = sIndexOf;
                if (sIndexOf < 0) {
                    return null;
                }
                i3--;
            }
            int iPaddingToBlockLen = paddingToBlockLen(i3);
            if (iPaddingToBlockLen < 0) {
                return null;
            }
            int i5 = sArr[0] << 3;
            short s = sArr[1];
            int i6 = i5 | (s >> 2);
            int i7 = sArr[2] << 1;
            short s2 = sArr[3];
            int i8 = i7 | ((s & 3) << 6) | (s2 >> 4);
            short s3 = sArr[4];
            int i9 = ((s2 & 15) << 4) | ((s3 >> 1) & 15);
            int i10 = (s3 << 7) | (sArr[5] << 2);
            short s4 = sArr[6];
            int[] iArr = {i6, i8, i9, i10 | (s4 >> 3), sArr[7] | ((s4 & 7) << 5)};
            for (int i11 = 0; i11 < iPaddingToBlockLen; i11++) {
                try {
                    dataOutputStream.writeByte((byte) (iArr[i11] & 255));
                } catch (IOException unused) {
                }
            }
        }
        return byteArrayOutputStream.toByteArray();
    }

    public String toString(byte[] bArr) {
        int i2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; i3 < (bArr.length + 4) / 5; i3++) {
            short[] sArr = new short[5];
            int i4 = 5;
            for (int i5 = 0; i5 < 5; i5++) {
                int i6 = (i3 * 5) + i5;
                if (i6 < bArr.length) {
                    sArr[i5] = (short) (bArr[i6] & 255);
                } else {
                    sArr[i5] = 0;
                    i4--;
                }
            }
            int iBlockLenToPadding = blockLenToPadding(i4);
            short s = sArr[0];
            short s2 = sArr[1];
            short s3 = sArr[2];
            short s4 = sArr[3];
            short s5 = sArr[4];
            int[] iArr = {(byte) ((s >> 3) & 31), (byte) (((s & 7) << 2) | ((s2 >> 6) & 3)), (byte) ((s2 >> 1) & 31), (byte) (((s2 & 1) << 4) | ((s3 >> 4) & 15)), (byte) (((s3 & 15) << 1) | ((s4 >> 7) & 1)), (byte) ((s4 >> 2) & 31), (byte) (((s5 >> 5) & 7) | ((s4 & 3) << 3)), (byte) (s5 & 31)};
            int i7 = 0;
            while (true) {
                i2 = 8 - iBlockLenToPadding;
                if (i7 >= i2) {
                    break;
                }
                char cCharAt = this.alphabet.charAt(iArr[i7]);
                if (this.lowercase) {
                    cCharAt = Character.toLowerCase(cCharAt);
                }
                byteArrayOutputStream.write(cCharAt);
                i7++;
            }
            if (this.padding) {
                while (i2 < 8) {
                    byteArrayOutputStream.write(61);
                    i2++;
                }
            }
        }
        return byteArrayOutputStream.toString();
    }
}
