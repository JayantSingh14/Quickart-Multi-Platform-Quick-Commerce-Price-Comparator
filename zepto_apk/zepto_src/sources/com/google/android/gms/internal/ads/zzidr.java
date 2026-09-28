package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* loaded from: classes4.dex */
final class zzidr {

    /* renamed from: a, reason: collision with root package name */
    public static final zzidp f34775a;

    static {
        if (zzidm.f34771e && zzidm.f34770d) {
            int i2 = zzhyy.f34536a;
        }
        f34775a = new zzidp();
    }

    public static boolean a(int i2, byte[] bArr, int i3) {
        int iE;
        f34775a.getClass();
        while (i2 < i3 && bArr[i2] >= 0) {
            i2++;
        }
        if (i2 >= i3) {
            iE = 0;
        } else {
            while (i2 < i3) {
                int i4 = i2 + 1;
                iE = bArr[i2];
                if (iE < 0) {
                    if (iE >= -32) {
                        if (iE >= -16) {
                            if (i4 < i3 - 2) {
                                int i5 = i2 + 2;
                                int i6 = bArr[i4];
                                if (i6 <= -65) {
                                    if ((((i6 + 112) + (iE << 28)) >> 30) == 0) {
                                        int i7 = i2 + 3;
                                        if (bArr[i5] <= 65471) {
                                            i2 += 4;
                                            if (bArr[i7] > 65471) {
                                            }
                                        }
                                    }
                                }
                                iE = -1;
                                break;
                            }
                            iE = e(i4, bArr, i3);
                            break;
                        }
                        if (i4 < i3 - 1) {
                            int i8 = i2 + 2;
                            char c2 = bArr[i4];
                            if (c2 <= 65471 && ((iE != -32 || c2 >= 65440) && (iE != -19 || c2 < 65440))) {
                                i2 += 3;
                                if (bArr[i8] > 65471) {
                                }
                            }
                            iE = -1;
                            break;
                        }
                        iE = e(i4, bArr, i3);
                        break;
                    }
                    if (i4 >= i3) {
                        break;
                    }
                    if (iE >= -62) {
                        i2 += 2;
                        if (bArr[i4] > 65471) {
                        }
                    }
                    iE = -1;
                    break;
                }
                i2 = i4;
            }
            iE = 0;
        }
        return iE == 0;
    }

    public static int b(String str) {
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        while (i3 < length && str.charAt(i3) < 128) {
            i3++;
        }
        int i4 = length;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = str.charAt(i3);
            if (cCharAt < 2048) {
                i4 += (127 - cCharAt) >>> 31;
                i3++;
            } else {
                int length2 = str.length();
                while (i3 < length2) {
                    char cCharAt2 = str.charAt(i3);
                    if (cCharAt2 < 2048) {
                        i2 += (127 - cCharAt2) >>> 31;
                    } else {
                        i2 += 2;
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                            if (Character.codePointAt(str, i3) < 65536) {
                                throw new zzidq(i3, length2);
                            }
                            i3++;
                        }
                    }
                    i3++;
                }
                i4 += i2;
            }
        }
        if (i4 >= length) {
            return i4;
        }
        long j2 = i4 + 4294967296L;
        StringBuilder sb = new StringBuilder(String.valueOf(j2).length() + 34);
        sb.append("UTF-8 length does not fit in int: ");
        sb.append(j2);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int c(String str, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        char cCharAt;
        int length = str.length();
        int i7 = 0;
        while (true) {
            i4 = i2 + i3;
            if (i7 >= length || (i6 = i7 + i2) >= i4 || (cCharAt = str.charAt(i7)) >= 128) {
                break;
            }
            bArr[i6] = (byte) cCharAt;
            i7++;
        }
        if (i7 == length) {
            return i2 + length;
        }
        int i8 = i2 + i7;
        while (i7 < length) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 < 128 && i8 < i4) {
                bArr[i8] = (byte) cCharAt2;
                i8++;
            } else if (cCharAt2 < 2048 && i8 <= i4 - 2) {
                bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                bArr[i8 + 1] = (byte) ((cCharAt2 & '?') | 128);
                i8 += 2;
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i8 > i4 - 3) {
                    if (i8 > i4 - 4) {
                        if (cCharAt2 < 55296 || cCharAt2 > 57343 || ((i5 = i7 + 1) != str.length() && Character.isSurrogatePair(cCharAt2, str.charAt(i5)))) {
                            throw new ArrayIndexOutOfBoundsException("Not enough space in output buffer to encode UTF-8 string");
                        }
                        throw new zzidq(i7, length);
                    }
                    int i9 = i7 + 1;
                    if (i9 != str.length()) {
                        char cCharAt3 = str.charAt(i9);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int i10 = i8 + 3;
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 += 4;
                            bArr[i10] = (byte) ((codePoint & 63) | 128);
                            i7 = i9;
                        } else {
                            i7 = i9;
                        }
                    }
                    throw new zzidq(i7 - 1, length);
                }
                bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                bArr[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                i8 += 3;
            }
            i7++;
        }
        return i8;
    }

    public static String d(ByteBuffer byteBuffer, int i2, int i3) {
        if (!byteBuffer.hasArray()) {
            return byteBuffer.isDirect() ? zzido.a(byteBuffer, i2, i3) : zzido.a(byteBuffer, i2, i3);
        }
        return f34775a.b(byteBuffer.arrayOffset() + i2, byteBuffer.array(), i3);
    }

    public static int e(int i2, byte[] bArr, int i3) {
        int i4 = i3 - i2;
        byte b2 = bArr[i2 - 1];
        if (i4 == 0) {
            if (b2 > -12) {
                return -1;
            }
            return b2;
        }
        if (i4 == 1) {
            byte b3 = bArr[i2];
            if (b2 > -12 || b3 > -65) {
                return -1;
            }
            return (b3 << 8) ^ b2;
        }
        if (i4 != 2) {
            throw new AssertionError();
        }
        byte b4 = bArr[i2];
        byte b5 = bArr[i2 + 1];
        if (b2 > -12 || b4 > -65 || b5 > -65) {
            return -1;
        }
        return (b5 << 16) ^ ((b4 << 8) ^ b2);
    }
}
