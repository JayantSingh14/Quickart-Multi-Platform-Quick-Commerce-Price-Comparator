package org.apache.commons.lang3;

import android.support.v4.media.a;
import android.support.v4.media.b;
import java.util.UUID;
import org.xbill.DNS.Message;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes5.dex */
public class Conversion {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean[] TTTT = {true, true, true, true};
    private static final boolean[] FTTT = {false, true, true, true};
    private static final boolean[] TFTT = {true, false, true, true};
    private static final boolean[] FFTT = {false, false, true, true};
    private static final boolean[] TTFT = {true, true, false, true};
    private static final boolean[] FTFT = {false, true, false, true};
    private static final boolean[] TFFT = {true, false, false, true};
    private static final boolean[] FFFT = {false, false, false, true};
    private static final boolean[] TTTF = {true, true, true, false};
    private static final boolean[] FTTF = {false, true, true, false};
    private static final boolean[] TFTF = {true, false, true, false};
    private static final boolean[] FFTF = {false, false, true, false};
    private static final boolean[] TTFF = {true, true, false, false};
    private static final boolean[] FTFF = {false, true, false, false};
    private static final boolean[] TFFF = {true, false, false, false};
    private static final boolean[] FFFF = {false, false, false, false};

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr) {
        return binaryBeMsb0ToHexDigit(zArr, 0);
    }

    public static byte binaryToByte(boolean[] zArr, int i2, byte b2, int i3, int i4) {
        if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
            return b2;
        }
        if ((i4 - 1) + i3 >= 8) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 8");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i3;
            b2 = (byte) ((b2 & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6));
        }
        return b2;
    }

    public static char binaryToHexDigit(boolean[] zArr) {
        return binaryToHexDigit(zArr, 0);
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr) {
        return binaryToHexDigitMsb0_4bits(zArr, 0);
    }

    public static int binaryToInt(boolean[] zArr, int i2, int i3, int i4, int i5) {
        if ((zArr.length == 0 && i2 == 0) || i5 == 0) {
            return i3;
        }
        if ((i5 - 1) + i4 >= 32) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = i6 + i4;
            i3 = (i3 & (~(1 << i7))) | ((zArr[i6 + i2] ? 1 : 0) << i7);
        }
        return i3;
    }

    public static long binaryToLong(boolean[] zArr, int i2, long j2, int i3, int i4) {
        if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if ((i4 - 1) + i3 >= 64) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i3;
            j2 = (j2 & (~(1 << i6))) | ((zArr[i5 + i2] ? 1L : 0L) << i6);
        }
        return j2;
    }

    public static short binaryToShort(boolean[] zArr, int i2, short s, int i3, int i4) {
        if ((zArr.length == 0 && i2 == 0) || i4 == 0) {
            return s;
        }
        if ((i4 - 1) + i3 >= 16) {
            throw new IllegalArgumentException("nBools-1+dstPos is greater or equal to than 16");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i5 + i3;
            s = (short) ((s & (~(1 << i6))) | ((zArr[i5 + i2] ? 1 : 0) << i6));
        }
        return s;
    }

    public static int byteArrayToInt(byte[] bArr, int i2, int i3, int i4, int i5) {
        if ((bArr.length == 0 && i2 == 0) || i5 == 0) {
            return i3;
        }
        if (a.c(i5, 1, 8, i4) >= 32) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 * 8) + i4;
            i3 = (i3 & (~(255 << i7))) | ((bArr[i6 + i2] & 255) << i7);
        }
        return i3;
    }

    public static long byteArrayToLong(byte[] bArr, int i2, long j2, int i3, int i4) {
        if ((bArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if (a.c(i4, 1, 8, i3) >= 64) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 8) + i3;
            j2 = (j2 & (~(255 << i6))) | ((bArr[i5 + i2] & 255) << i6);
        }
        return j2;
    }

    public static short byteArrayToShort(byte[] bArr, int i2, short s, int i3, int i4) {
        if ((bArr.length == 0 && i2 == 0) || i4 == 0) {
            return s;
        }
        if (a.c(i4, 1, 8, i3) >= 16) {
            throw new IllegalArgumentException("(nBytes-1)*8+dstPos is greater or equal to than 16");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 8) + i3;
            s = (short) ((s & (~(255 << i6))) | ((bArr[i5 + i2] & 255) << i6));
        }
        return s;
    }

    public static UUID byteArrayToUuid(byte[] bArr, int i2) {
        if (bArr.length - i2 >= 16) {
            return new UUID(byteArrayToLong(bArr, i2, 0L, 0, 8), byteArrayToLong(bArr, i2 + 8, 0L, 0, 8));
        }
        throw new IllegalArgumentException("Need at least 16 bytes for UUID");
    }

    public static boolean[] byteToBinary(byte b2, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 != 0) {
            if ((i4 - 1) + i2 >= 8) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 8");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i3 + i5;
                boolean z = true;
                if (((b2 >> (i5 + i2)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
        }
        return zArr;
    }

    public static String byteToHex(byte b2, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (a.c(i4, 1, 4, i2) >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 8");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (b2 >> ((i5 * 4) + i2)) & 15;
            int i7 = i3 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean[] hexDigitMsb0ToBinary(char r3) {
        /*
            switch(r3) {
                case 48: goto La9;
                case 49: goto La0;
                case 50: goto L97;
                case 51: goto L8e;
                case 52: goto L85;
                case 53: goto L7c;
                case 54: goto L73;
                case 55: goto L6a;
                case 56: goto L61;
                case 57: goto L58;
                default: goto L3;
            }
        L3:
            switch(r3) {
                case 65: goto L4f;
                case 66: goto L46;
                case 67: goto L3d;
                case 68: goto L34;
                case 69: goto L2b;
                case 70: goto L22;
                default: goto L6;
            }
        L6:
            switch(r3) {
                case 97: goto L4f;
                case 98: goto L46;
                case 99: goto L3d;
                case 100: goto L34;
                case 101: goto L2b;
                case 102: goto L22;
                default: goto L9;
            }
        L9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Cannot interpret '"
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L22:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L2b:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L34:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L3d:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L46:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L4f:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L58:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L61:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L6a:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L73:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L7c:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L85:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L8e:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L97:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La0:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La9:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitMsb0ToBinary(char):boolean[]");
    }

    public static int hexDigitMsb0ToInt(char c2) {
        switch (c2) {
            case Type.DNSKEY /* 48 */:
                return 0;
            case '1':
                return 8;
            case '2':
                return 4;
            case '3':
                return 12;
            case Type.TLSA /* 52 */:
                return 2;
            case '5':
                return 10;
            case '6':
                return 6;
            case '7':
                return 14;
            case Type.NINFO /* 56 */:
                return 1;
            case Type.RKEY /* 57 */:
                return 9;
            default:
                switch (c2) {
                    case 'A':
                        return 5;
                    case WKSRecord.Protocol.RVD /* 66 */:
                        return 13;
                    case 'C':
                        return 3;
                    case WKSRecord.Service.BOOTPC /* 68 */:
                        return 11;
                    case 'E':
                        return 7;
                    case 'F':
                        return 15;
                    default:
                        switch (c2) {
                            case WKSRecord.Service.SWIFT_RVF /* 97 */:
                                return 5;
                            case WKSRecord.Service.TACNEWS /* 98 */:
                                return 13;
                            case 'c':
                                return 3;
                            case 'd':
                                return 11;
                            case 'e':
                                return 7;
                            case 'f':
                                return 15;
                            default:
                                throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
                        }
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean[] hexDigitToBinary(char r3) {
        /*
            switch(r3) {
                case 48: goto La9;
                case 49: goto La0;
                case 50: goto L97;
                case 51: goto L8e;
                case 52: goto L85;
                case 53: goto L7c;
                case 54: goto L73;
                case 55: goto L6a;
                case 56: goto L61;
                case 57: goto L58;
                default: goto L3;
            }
        L3:
            switch(r3) {
                case 65: goto L4f;
                case 66: goto L46;
                case 67: goto L3d;
                case 68: goto L34;
                case 69: goto L2b;
                case 70: goto L22;
                default: goto L6;
            }
        L6:
            switch(r3) {
                case 97: goto L4f;
                case 98: goto L46;
                case 99: goto L3d;
                case 100: goto L34;
                case 101: goto L2b;
                case 102: goto L22;
                default: goto L9;
            }
        L9:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Cannot interpret '"
            r1.<init>(r2)
            r1.append(r3)
            java.lang.String r3 = "' as a hexadecimal digit"
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L22:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L2b:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L34:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L3d:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L46:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L4f:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L58:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L61:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFT
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L6a:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L73:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L7c:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L85:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFTF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L8e:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        L97:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FTFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La0:
            boolean[] r3 = org.apache.commons.lang3.Conversion.TFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        La9:
            boolean[] r3 = org.apache.commons.lang3.Conversion.FFFF
            java.lang.Object r3 = r3.clone()
            boolean[] r3 = (boolean[]) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.lang3.Conversion.hexDigitToBinary(char):boolean[]");
    }

    public static int hexDigitToInt(char c2) {
        int iDigit = Character.digit(c2, 16);
        if (iDigit >= 0) {
            return iDigit;
        }
        throw new IllegalArgumentException("Cannot interpret '" + c2 + "' as a hexadecimal digit");
    }

    public static byte hexToByte(String str, int i2, byte b2, int i3, int i4) {
        if (i4 == 0) {
            return b2;
        }
        if (a.c(i4, 1, 4, i3) >= 8) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 8");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i3;
            b2 = (byte) ((b2 & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6));
        }
        return b2;
    }

    public static int hexToInt(String str, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return i3;
        }
        if (a.c(i5, 1, 4, i4) >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 * 4) + i4;
            i3 = (i3 & (~(15 << i7))) | ((hexDigitToInt(str.charAt(i6 + i2)) & 15) << i7);
        }
        return i3;
    }

    public static long hexToLong(String str, int i2, long j2, int i3, int i4) {
        if (i4 == 0) {
            return j2;
        }
        if (a.c(i4, 1, 4, i3) >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i3;
            j2 = (j2 & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6);
        }
        return j2;
    }

    public static short hexToShort(String str, int i2, short s, int i3, int i4) {
        if (i4 == 0) {
            return s;
        }
        if (a.c(i4, 1, 4, i3) >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+dstPos is greater or equal to than 16");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 4) + i3;
            s = (short) ((s & (~(15 << i6))) | ((hexDigitToInt(str.charAt(i5 + i2)) & 15) << i6));
        }
        return s;
    }

    public static long intArrayToLong(int[] iArr, int i2, long j2, int i3, int i4) {
        if ((iArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if (a.c(i4, 1, 32, i3) >= 64) {
            throw new IllegalArgumentException("(nInts-1)*32+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 32) + i3;
            j2 = (j2 & (~(4294967295 << i6))) | ((iArr[i5 + i2] & 4294967295L) << i6);
        }
        return j2;
    }

    public static boolean[] intToBinary(int i2, int i3, boolean[] zArr, int i4, int i5) {
        if (i5 != 0) {
            if ((i5 - 1) + i3 >= 32) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 32");
            }
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = i4 + i6;
                boolean z = true;
                if (((i2 >> (i6 + i3)) & 1) == 0) {
                    z = false;
                }
                zArr[i7] = z;
            }
        }
        return zArr;
    }

    public static byte[] intToByteArray(int i2, int i3, byte[] bArr, int i4, int i5) {
        if (i5 != 0) {
            if (a.c(i5, 1, 8, i3) >= 32) {
                throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 32");
            }
            for (int i6 = 0; i6 < i5; i6++) {
                bArr[i4 + i6] = (byte) ((i2 >> ((i6 * 8) + i3)) & 255);
            }
        }
        return bArr;
    }

    public static String intToHex(int i2, int i3, String str, int i4, int i5) {
        if (i5 == 0) {
            return str;
        }
        if (a.c(i5, 1, 4, i3) >= 32) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 32");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i2 >> ((i6 * 4) + i3)) & 15;
            int i8 = i4 + i6;
            if (i8 == length) {
                length++;
                sb.append(intToHexDigit(i7));
            } else {
                sb.setCharAt(i8, intToHexDigit(i7));
            }
        }
        return sb.toString();
    }

    public static char intToHexDigit(int i2) {
        char cForDigit = Character.forDigit(i2, 16);
        if (cForDigit != 0) {
            return cForDigit;
        }
        throw new IllegalArgumentException(b.f(i2, "nibble value not between 0 and 15: "));
    }

    public static char intToHexDigitMsb0(int i2) {
        switch (i2) {
            case 0:
                return '0';
            case 1:
                return '8';
            case 2:
                return '4';
            case 3:
                return 'c';
            case 4:
                return '2';
            case 5:
                return 'a';
            case 6:
                return '6';
            case 7:
                return 'e';
            case 8:
                return '1';
            case 9:
                return '9';
            case 10:
                return '5';
            case 11:
                return 'd';
            case 12:
                return '3';
            case 13:
                return 'b';
            case 14:
                return '7';
            case 15:
                return 'f';
            default:
                throw new IllegalArgumentException(b.f(i2, "nibble value not between 0 and 15: "));
        }
    }

    public static short[] intToShortArray(int i2, int i3, short[] sArr, int i4, int i5) {
        if (i5 != 0) {
            if (a.c(i5, 1, 16, i3) >= 32) {
                throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 32");
            }
            for (int i6 = 0; i6 < i5; i6++) {
                sArr[i4 + i6] = (short) ((i2 >> ((i6 * 16) + i3)) & Message.MAXLENGTH);
            }
        }
        return sArr;
    }

    public static boolean[] longToBinary(long j2, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 != 0) {
            if ((i4 - 1) + i2 >= 64) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                zArr[i3 + i5] = (1 & (j2 >> (i5 + i2))) != 0;
            }
        }
        return zArr;
    }

    public static byte[] longToByteArray(long j2, int i2, byte[] bArr, int i3, int i4) {
        if (i4 != 0) {
            if (a.c(i4, 1, 8, i2) >= 64) {
                throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) (255 & (j2 >> ((i5 * 8) + i2)));
            }
        }
        return bArr;
    }

    public static String longToHex(long j2, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (a.c(i4, 1, 4, i2) >= 64) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 64");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (int) ((j2 >> ((i5 * 4) + i2)) & 15);
            int i7 = i3 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    public static int[] longToIntArray(long j2, int i2, int[] iArr, int i3, int i4) {
        if (i4 != 0) {
            if (a.c(i4, 1, 32, i2) >= 64) {
                throw new IllegalArgumentException("(nInts-1)*32+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                iArr[i3 + i5] = (int) (j2 >> ((i5 * 32) + i2));
            }
        }
        return iArr;
    }

    public static short[] longToShortArray(long j2, int i2, short[] sArr, int i3, int i4) {
        if (i4 != 0) {
            if (a.c(i4, 1, 16, i2) >= 64) {
                throw new IllegalArgumentException("(nShorts-1)*16+srcPos is greater or equal to than 64");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                sArr[i3 + i5] = (short) (65535 & (j2 >> ((i5 * 16) + i2)));
            }
        }
        return sArr;
    }

    public static int shortArrayToInt(short[] sArr, int i2, int i3, int i4, int i5) {
        if ((sArr.length == 0 && i2 == 0) || i5 == 0) {
            return i3;
        }
        if (a.c(i5, 1, 16, i4) >= 32) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 32");
        }
        for (int i6 = 0; i6 < i5; i6++) {
            int i7 = (i6 * 16) + i4;
            i3 = (i3 & (~(Message.MAXLENGTH << i7))) | ((sArr[i6 + i2] & 65535) << i7);
        }
        return i3;
    }

    public static long shortArrayToLong(short[] sArr, int i2, long j2, int i3, int i4) {
        if ((sArr.length == 0 && i2 == 0) || i4 == 0) {
            return j2;
        }
        if (a.c(i4, 1, 16, i3) >= 64) {
            throw new IllegalArgumentException("(nShorts-1)*16+dstPos is greater or equal to than 64");
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 16) + i3;
            j2 = (j2 & (~(65535 << i6))) | ((sArr[i5 + i2] & 65535) << i6);
        }
        return j2;
    }

    public static boolean[] shortToBinary(short s, int i2, boolean[] zArr, int i3, int i4) {
        if (i4 != 0) {
            if ((i4 - 1) + i2 >= 16) {
                throw new IllegalArgumentException("nBools-1+srcPos is greater or equal to than 16");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                int i6 = i3 + i5;
                boolean z = true;
                if (((s >> (i5 + i2)) & 1) == 0) {
                    z = false;
                }
                zArr[i6] = z;
            }
        }
        return zArr;
    }

    public static byte[] shortToByteArray(short s, int i2, byte[] bArr, int i3, int i4) {
        if (i4 != 0) {
            if (a.c(i4, 1, 8, i2) >= 16) {
                throw new IllegalArgumentException("(nBytes-1)*8+srcPos is greater or equal to than 16");
            }
            for (int i5 = 0; i5 < i4; i5++) {
                bArr[i3 + i5] = (byte) ((s >> ((i5 * 8) + i2)) & 255);
            }
        }
        return bArr;
    }

    public static String shortToHex(short s, int i2, String str, int i3, int i4) {
        if (i4 == 0) {
            return str;
        }
        if (a.c(i4, 1, 4, i2) >= 16) {
            throw new IllegalArgumentException("(nHexs-1)*4+srcPos is greater or equal to than 16");
        }
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length();
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (s >> ((i5 * 4) + i2)) & 15;
            int i7 = i3 + i5;
            if (i7 == length) {
                length++;
                sb.append(intToHexDigit(i6));
            } else {
                sb.setCharAt(i7, intToHexDigit(i6));
            }
        }
        return sb.toString();
    }

    public static byte[] uuidToByteArray(UUID uuid, byte[] bArr, int i2, int i3) {
        if (i3 != 0) {
            if (i3 > 16) {
                throw new IllegalArgumentException("nBytes is greater than 16");
            }
            longToByteArray(uuid.getMostSignificantBits(), 0, bArr, i2, i3 > 8 ? 8 : i3);
            if (i3 >= 8) {
                longToByteArray(uuid.getLeastSignificantBits(), 0, bArr, i2 + 8, i3 - 8);
            }
        }
        return bArr;
    }

    public static char binaryBeMsb0ToHexDigit(boolean[] zArr, int i2) {
        if (zArr.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int length = ((zArr.length - 1) - i2) + 1;
        int iMin = Math.min(4, length);
        boolean[] zArr2 = new boolean[4];
        System.arraycopy(zArr, length - iMin, zArr2, 4 - iMin, iMin);
        return zArr2[0] ? zArr2[1] ? zArr2[2] ? zArr2[3] ? 'f' : 'e' : zArr2[3] ? 'd' : 'c' : zArr2[2] ? zArr2[3] ? 'b' : 'a' : zArr2[3] ? '9' : '8' : zArr2[1] ? zArr2[2] ? zArr2[3] ? '7' : '6' : zArr2[3] ? '5' : '4' : zArr2[2] ? zArr2[3] ? '3' : '2' : zArr2[3] ? '1' : '0';
    }

    public static char binaryToHexDigit(boolean[] zArr, int i2) {
        if (zArr.length == 0) {
            throw new IllegalArgumentException("Cannot convert an empty array.");
        }
        int i3 = i2 + 3;
        if (zArr.length <= i3 || !zArr[i3]) {
            int i4 = i2 + 2;
            if (zArr.length <= i4 || !zArr[i4]) {
                int i5 = i2 + 1;
                return (zArr.length <= i5 || !zArr[i5]) ? zArr[i2] ? '1' : '0' : zArr[i2] ? '3' : '2';
            }
            int i6 = i2 + 1;
            return (zArr.length <= i6 || !zArr[i6]) ? zArr[i2] ? '5' : '4' : zArr[i2] ? '7' : '6';
        }
        int i7 = i2 + 2;
        if (zArr.length <= i7 || !zArr[i7]) {
            int i8 = i2 + 1;
            return (zArr.length <= i8 || !zArr[i8]) ? zArr[i2] ? '9' : '8' : zArr[i2] ? 'b' : 'a';
        }
        int i9 = i2 + 1;
        return (zArr.length <= i9 || !zArr[i9]) ? zArr[i2] ? 'd' : 'c' : zArr[i2] ? 'f' : 'e';
    }

    public static char binaryToHexDigitMsb0_4bits(boolean[] zArr, int i2) {
        if (zArr.length > 8) {
            throw new IllegalArgumentException("src.length>8: src.length=" + zArr.length);
        }
        if (zArr.length - i2 >= 4) {
            return zArr[i2 + 3] ? zArr[i2 + 2] ? zArr[i2 + 1] ? zArr[i2] ? 'f' : '7' : zArr[i2] ? 'b' : '3' : zArr[i2 + 1] ? zArr[i2] ? 'd' : '5' : zArr[i2] ? '9' : '1' : zArr[i2 + 2] ? zArr[i2 + 1] ? zArr[i2] ? 'e' : '6' : zArr[i2] ? 'a' : '2' : zArr[i2 + 1] ? zArr[i2] ? 'c' : '4' : zArr[i2] ? '8' : '0';
        }
        throw new IllegalArgumentException("src.length-srcPos<4: src.length=" + zArr.length + ", srcPos=" + i2);
    }
}
