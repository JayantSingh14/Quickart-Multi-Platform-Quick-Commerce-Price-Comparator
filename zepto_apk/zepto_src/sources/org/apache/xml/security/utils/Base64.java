package org.apache.xml.security.utils;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.xml.security.exceptions.Base64DecodingException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/* loaded from: classes5.dex */
public class Base64 {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f57311a = new byte[255];

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f57312b = new char[64];

    static {
        int i2 = 0;
        for (int i3 = 0; i3 < 255; i3++) {
            f57311a[i3] = -1;
        }
        for (int i4 = 90; i4 >= 65; i4--) {
            f57311a[i4] = (byte) (i4 - 65);
        }
        for (int i5 = 122; i5 >= 97; i5--) {
            f57311a[i5] = (byte) (i5 - 71);
        }
        for (int i6 = 57; i6 >= 48; i6--) {
            f57311a[i6] = (byte) (i6 + 4);
        }
        byte[] bArr = f57311a;
        bArr[43] = 62;
        bArr[47] = 63;
        for (int i7 = 0; i7 <= 25; i7++) {
            f57312b[i7] = (char) (i7 + 65);
        }
        int i8 = 26;
        int i9 = 0;
        while (i8 <= 51) {
            f57312b[i8] = (char) (i9 + 97);
            i8++;
            i9++;
        }
        int i10 = 52;
        while (i10 <= 61) {
            f57312b[i10] = (char) (i2 + 48);
            i10++;
            i2++;
        }
        char[] cArr = f57312b;
        cArr[62] = '+';
        cArr[63] = '/';
    }

    private Base64() {
    }

    public static final int a(String str, byte[] bArr) {
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            byte bCharAt = (byte) str.charAt(i3);
            if (!a(bCharAt)) {
                bArr[i2] = bCharAt;
                i2++;
            }
        }
        return i2;
    }

    public static final String b(byte[] bArr) {
        return a(bArr, XMLUtils.a() ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 76);
    }

    public static final int c(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int i2 = 0;
        for (byte b2 : bArr) {
            if (!a(b2)) {
                bArr[i2] = b2;
                i2++;
            }
        }
        return i2;
    }

    public static final String a(byte[] bArr, int i2) {
        char c2 = 4;
        int i3 = i2;
        if (i3 < 4) {
            i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        if (bArr == null) {
            return null;
        }
        int length = bArr.length * 8;
        if (length == 0) {
            return "";
        }
        int i4 = length % 24;
        int i5 = length / 24;
        int i6 = i4 != 0 ? i5 + 1 : i5;
        int i7 = (i6 - 1) / (i3 / 4);
        char[] cArr = new char[(i6 * 4) + i7];
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i8 < i7) {
            int i12 = 0;
            while (i12 < 19) {
                byte b2 = bArr[i11];
                int i13 = i11 + 2;
                byte b3 = bArr[i11 + 1];
                i11 += 3;
                byte b4 = bArr[i13];
                char c3 = c2;
                byte b5 = (byte) (b3 & 15);
                byte b6 = (byte) (b2 & 3);
                int i14 = b2 & (-128);
                int i15 = b2 >> 2;
                if (i14 != 0) {
                    i15 ^= 192;
                }
                byte b7 = (byte) i15;
                int i16 = b3 & (-128);
                int i17 = b3 >> 4;
                if (i16 != 0) {
                    i17 ^= 240;
                }
                byte b8 = (byte) i17;
                int i18 = b4 >> 6;
                if ((b4 & (-128)) != 0) {
                    i18 ^= 252;
                }
                byte b9 = (byte) i18;
                char[] cArr2 = f57312b;
                cArr[i10] = cArr2[b7];
                cArr[i10 + 1] = cArr2[(b6 << 4) | b8];
                int i19 = i10 + 3;
                cArr[i10 + 2] = cArr2[(b5 << 2) | b9];
                i10 += 4;
                cArr[i19] = cArr2[b4 & 63];
                i9++;
                i12++;
                c2 = c3;
            }
            cArr[i10] = '\n';
            i8++;
            i10++;
            c2 = c2;
        }
        while (i9 < i5) {
            byte b10 = bArr[i11];
            int i20 = i11 + 2;
            byte b11 = bArr[i11 + 1];
            i11 += 3;
            byte b12 = bArr[i20];
            byte b13 = (byte) (b11 & 15);
            byte b14 = (byte) (b10 & 3);
            int i21 = b10 & (-128);
            int i22 = b10 >> 2;
            if (i21 != 0) {
                i22 ^= 192;
            }
            byte b15 = (byte) i22;
            int i23 = b11 & (-128);
            int i24 = b11 >> 4;
            if (i23 != 0) {
                i24 ^= 240;
            }
            byte b16 = (byte) i24;
            byte b17 = (byte) ((b12 & (-128)) == 0 ? b12 >> 6 : (b12 >> 6) ^ 252);
            char[] cArr3 = f57312b;
            cArr[i10] = cArr3[b15];
            cArr[i10 + 1] = cArr3[b16 | (b14 << 4)];
            int i25 = i10 + 3;
            cArr[i10 + 2] = cArr3[(b13 << 2) | b17];
            i10 += 4;
            cArr[i25] = cArr3[b12 & 63];
            i9++;
        }
        if (i4 == 8) {
            byte b18 = bArr[i11];
            byte b19 = (byte) (b18 & 3);
            int i26 = b18 & (-128);
            int i27 = b18 >> 2;
            if (i26 != 0) {
                i27 ^= 192;
            }
            byte b20 = (byte) i27;
            char[] cArr4 = f57312b;
            cArr[i10] = cArr4[b20];
            cArr[i10 + 1] = cArr4[b19 << 4];
            cArr[i10 + 2] = '=';
            cArr[i10 + 3] = '=';
        } else if (i4 == 16) {
            byte b21 = bArr[i11];
            byte b22 = bArr[i11 + 1];
            byte b23 = (byte) (b22 & 15);
            byte b24 = (byte) (b21 & 3);
            int i28 = b21 & (-128);
            int i29 = b21 >> 2;
            if (i28 != 0) {
                i29 ^= 192;
            }
            byte b25 = (byte) i29;
            int i30 = b22 & (-128);
            int i31 = b22 >> 4;
            if (i30 != 0) {
                i31 ^= 240;
            }
            byte b26 = (byte) i31;
            char[] cArr5 = f57312b;
            cArr[i10] = cArr5[b25];
            cArr[i10 + 1] = cArr5[b26 | (b24 << 4)];
            cArr[i10 + 2] = cArr5[b23 << 2];
            cArr[i10 + 3] = '=';
        }
        return new String(cArr);
    }

    public static final boolean b(byte b2) {
        return b2 == 61;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        r11 = r1[0];
        r2 = r1[1];
        r3 = r1[2];
        r1 = r1[3];
        r4 = org.apache.xml.security.utils.Base64.f57311a;
        r11 = r4[r11];
        r2 = r4[r2];
        r7 = r4[r3];
        r8 = r4[r1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007d, code lost:
    
        if (r7 == (-1)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        if (r8 != (-1)) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0082, code lost:
    
        r12.write((byte) ((r11 << 2) | (r2 >> 4)));
        r12.write((byte) (((r2 & 15) << 4) | ((r7 >> 2) & 15)));
        r11 = (r7 << 6) | r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0099, code lost:
    
        r12.write((byte) r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a2, code lost:
    
        if (b(r3) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a8, code lost:
    
        if (b(r1) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
    
        if ((r2 & 15) != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ae, code lost:
    
        r11 = r11 << 2;
        r0 = r2 >> 4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b1, code lost:
    
        r11 = r11 | r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b8, code lost:
    
        throw new org.apache.xml.security.exceptions.Base64DecodingException("decoding.general");
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bd, code lost:
    
        if (b(r3) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c3, code lost:
    
        if (b(r1) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c5, code lost:
    
        r1 = r4[r3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c9, code lost:
    
        if ((r1 & 3) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00cb, code lost:
    
        r12.write((byte) ((r11 << 2) | (r2 >> 4)));
        r11 = (r2 & 15) << 4;
        r0 = (r1 >> 2) & 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e0, code lost:
    
        throw new org.apache.xml.security.exceptions.Base64DecodingException("decoding.general");
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e6, code lost:
    
        throw new org.apache.xml.security.exceptions.Base64DecodingException("decoding.general");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(java.io.InputStream r11, java.io.OutputStream r12) throws org.apache.xml.security.exceptions.Base64DecodingException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.xml.security.utils.Base64.a(java.io.InputStream, java.io.OutputStream):void");
    }

    public static final byte[] b(byte[] bArr, int i2) throws Base64DecodingException {
        byte[] bArr2;
        if (i2 == -1) {
            i2 = c(bArr);
        }
        if (i2 % 4 != 0) {
            throw new Base64DecodingException("decoding.divisible.four");
        }
        int i3 = i2 / 4;
        int i4 = 0;
        if (i3 == 0) {
            return new byte[0];
        }
        int i5 = i3 - 1;
        int i6 = i5 * 4;
        int i7 = i5 * 3;
        byte[] bArr3 = f57311a;
        byte b2 = bArr3[bArr[i6]];
        int i8 = i6 + 2;
        byte b3 = bArr3[bArr[i6 + 1]];
        if (b2 == -1 || b3 == -1) {
            throw new Base64DecodingException("decoding.general");
        }
        byte b4 = bArr[i8];
        byte b5 = bArr3[b4];
        byte b6 = bArr[i6 + 3];
        byte b7 = bArr3[b6];
        if (b5 != -1 && b7 != -1) {
            bArr2 = new byte[i7 + 3];
            bArr2[i7] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr2[i7 + 1] = (byte) (((b3 & 15) << 4) | ((b5 >> 2) & 15));
            bArr2[i7 + 2] = (byte) (b7 | (b5 << 6));
        } else if (b(b4) && b(b6)) {
            if ((b3 & 15) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            bArr2 = new byte[i7 + 1];
            bArr2[i7] = (byte) ((b2 << 2) | (b3 >> 4));
        } else {
            if (b(b4) || !b(b6)) {
                throw new Base64DecodingException("decoding.general");
            }
            if ((b5 & 3) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            bArr2 = new byte[i7 + 2];
            bArr2[i7] = (byte) ((b2 << 2) | (b3 >> 4));
            bArr2[i7 + 1] = (byte) (((b3 & 15) << 4) | ((b5 >> 2) & 15));
        }
        int i9 = 0;
        while (i5 > 0) {
            byte[] bArr4 = f57311a;
            byte b8 = bArr4[bArr[i4]];
            byte b9 = bArr4[bArr[i4 + 1]];
            int i10 = i4 + 3;
            byte b10 = bArr4[bArr[i4 + 2]];
            i4 += 4;
            byte b11 = bArr4[bArr[i10]];
            if (b8 == -1 || b9 == -1 || b10 == -1 || b11 == -1) {
                throw new Base64DecodingException("decoding.general");
            }
            bArr2[i9] = (byte) ((b8 << 2) | (b9 >> 4));
            int i11 = i9 + 2;
            bArr2[i9 + 1] = (byte) (((b9 & 15) << 4) | ((b10 >> 2) & 15));
            i9 += 3;
            bArr2[i11] = (byte) (b11 | (b10 << 6));
            i5--;
        }
        return bArr2;
    }

    public static final void a(String str, OutputStream outputStream) throws Base64DecodingException, IOException {
        byte[] bArr = new byte[str.length()];
        a(bArr, outputStream, a(str, bArr));
    }

    public static final void a(byte[] bArr, OutputStream outputStream) throws Base64DecodingException, IOException {
        a(bArr, outputStream, -1);
    }

    public static final void a(byte[] bArr, OutputStream outputStream, int i2) throws Base64DecodingException, IOException {
        int i3;
        if (i2 == -1) {
            i2 = c(bArr);
        }
        if (i2 % 4 != 0) {
            throw new Base64DecodingException("decoding.divisible.four");
        }
        int i4 = i2 / 4;
        if (i4 == 0) {
            return;
        }
        int i5 = 0;
        for (int i6 = i4 - 1; i6 > 0; i6--) {
            byte[] bArr2 = f57311a;
            byte b2 = bArr2[bArr[i5]];
            byte b3 = bArr2[bArr[i5 + 1]];
            int i7 = i5 + 3;
            byte b4 = bArr2[bArr[i5 + 2]];
            i5 += 4;
            byte b5 = bArr2[bArr[i7]];
            if (b2 == -1 || b3 == -1 || b4 == -1 || b5 == -1) {
                throw new Base64DecodingException("decoding.general");
            }
            outputStream.write((byte) ((b2 << 2) | (b3 >> 4)));
            outputStream.write((byte) (((b3 & 15) << 4) | ((b4 >> 2) & 15)));
            outputStream.write((byte) ((b4 << 6) | b5));
        }
        byte[] bArr3 = f57311a;
        int i8 = bArr3[bArr[i5]];
        int i9 = i5 + 2;
        int i10 = bArr3[bArr[i5 + 1]];
        if (i8 == -1 || i10 == -1) {
            throw new Base64DecodingException("decoding.general");
        }
        byte b6 = bArr[i9];
        int i11 = bArr3[b6];
        byte b7 = bArr[i5 + 3];
        int i12 = bArr3[b7];
        if (i11 != -1 && i12 != -1) {
            outputStream.write((byte) ((i8 << 2) | (i10 >> 4)));
            outputStream.write((byte) (((i10 & 15) << 4) | ((i11 >> 2) & 15)));
            i3 = i11 << 6;
        } else if (b(b6) && b(b7)) {
            if ((i10 & 15) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            i3 = i8 << 2;
            i12 = i10 >> 4;
        } else {
            if (b(b6) || !b(b7)) {
                throw new Base64DecodingException("decoding.general");
            }
            if ((i11 & 3) != 0) {
                throw new Base64DecodingException("decoding.general");
            }
            outputStream.write((byte) ((i8 << 2) | (i10 >> 4)));
            i3 = (i10 & 15) << 4;
            i12 = (i11 >> 2) & 15;
        }
        outputStream.write((byte) (i3 | i12));
    }

    public static final boolean a(byte b2) {
        return b2 == 32 || b2 == 13 || b2 == 10 || b2 == 9;
    }

    public static final byte[] a(String str) {
        if (str == null) {
            return null;
        }
        byte[] bArr = new byte[str.length()];
        return b(bArr, a(str, bArr));
    }

    public static final byte[] a(Element element) {
        StringBuffer stringBuffer = new StringBuffer();
        for (Node firstChild = element.getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            if (firstChild.getNodeType() == 3) {
                stringBuffer.append(((Text) firstChild).getData());
            }
        }
        return a(stringBuffer.toString());
    }

    public static final byte[] a(byte[] bArr) {
        return b(bArr, -1);
    }
}
