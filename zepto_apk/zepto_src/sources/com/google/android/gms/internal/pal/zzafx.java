package com.google.android.gms.internal.pal;

/* loaded from: classes4.dex */
final class zzafx {

    /* renamed from: a, reason: collision with root package name */
    public static final zzafv f37505a;

    static {
        if (zzafs.f37502e && zzafs.f37501d) {
            int i2 = zzabk.f37351a;
        }
        f37505a = new zzafv();
    }

    public static /* bridge */ /* synthetic */ int a(int i2, byte[] bArr, int i3) {
        byte b2 = bArr[i2 - 1];
        int i4 = i3 - i2;
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

    public static int b(String str, byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        char cCharAt;
        int length = str.length();
        int i6 = i3 + i2;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i2) < i6 && (cCharAt = str.charAt(i7)) < 128) {
            bArr[i5] = (byte) cCharAt;
            i7++;
        }
        if (i7 == length) {
            return i2 + length;
        }
        int i8 = i2 + i7;
        while (i7 < length) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 < 128 && i8 < i6) {
                bArr[i8] = (byte) cCharAt2;
                i8++;
            } else if (cCharAt2 < 2048 && i8 <= i6 - 2) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((cCharAt2 >>> 6) | 960);
                i8 += 2;
                bArr[i9] = (byte) ((cCharAt2 & '?') | 128);
            } else {
                if ((cCharAt2 >= 55296 && cCharAt2 <= 57343) || i8 > i6 - 3) {
                    if (i8 > i6 - 4) {
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i4 = i7 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i4)))) {
                            throw new zzafw(i7, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
                    }
                    int i10 = i7 + 1;
                    if (i10 != str.length()) {
                        char cCharAt3 = str.charAt(i10);
                        if (Character.isSurrogatePair(cCharAt2, cCharAt3)) {
                            int codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                            bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                            bArr[i8 + 1] = (byte) (((codePoint >>> 12) & 63) | 128);
                            int i11 = i8 + 3;
                            bArr[i8 + 2] = (byte) (((codePoint >>> 6) & 63) | 128);
                            i8 += 4;
                            bArr[i11] = (byte) ((codePoint & 63) | 128);
                            i7 = i10;
                        } else {
                            i7 = i10;
                        }
                    }
                    throw new zzafw(i7 - 1, length);
                }
                bArr[i8] = (byte) ((cCharAt2 >>> '\f') | 480);
                int i12 = i8 + 2;
                bArr[i8 + 1] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                i8 += 3;
                bArr[i12] = (byte) ((cCharAt2 & '?') | 128);
            }
            i7++;
        }
        return i8;
    }

    public static int c(String str) {
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
                                throw new zzafw(i3, length2);
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
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i4 + 4294967296L));
    }

    public static String d(int i2, byte[] bArr, int i3) throws zzadi {
        int length = bArr.length;
        if ((i2 | i3 | ((length - i2) - i3)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i4 = i2 + i3;
        char[] cArr = new char[i3];
        int i5 = 0;
        while (i2 < i4) {
            byte b2 = bArr[i2];
            if (b2 < 0) {
                break;
            }
            i2++;
            cArr[i5] = (char) b2;
            i5++;
        }
        while (i2 < i4) {
            int i6 = i2 + 1;
            byte b3 = bArr[i2];
            if (b3 >= 0) {
                cArr[i5] = (char) b3;
                i5++;
                i2 = i6;
                while (i2 < i4) {
                    byte b4 = bArr[i2];
                    if (b4 >= 0) {
                        i2++;
                        cArr[i5] = (char) b4;
                        i5++;
                    }
                }
            } else {
                if (b3 >= -32) {
                    if (b3 < -16) {
                        if (i6 >= i4 - 1) {
                            throw zzadi.b();
                        }
                        int i7 = i2 + 2;
                        i2 += 3;
                        int i8 = i5 + 1;
                        byte b5 = bArr[i6];
                        byte b6 = bArr[i7];
                        if (!zzaft.a(b5)) {
                            if (b3 == -32) {
                                if (b5 >= -96) {
                                    b3 = -32;
                                }
                            }
                            if (b3 == -19) {
                                if (b5 < -96) {
                                    b3 = -19;
                                }
                            }
                            if (!zzaft.a(b6)) {
                                cArr[i5] = (char) (((b5 & 63) << 6) | ((b3 & 15) << 12) | (b6 & 63));
                                i5 = i8;
                            }
                        }
                        throw zzadi.b();
                    }
                    if (i6 >= i4 - 2) {
                        throw zzadi.b();
                    }
                    int i9 = i2 + 2;
                    int i10 = i2 + 3;
                    i2 += 4;
                    byte b7 = bArr[i6];
                    byte b8 = bArr[i9];
                    byte b9 = bArr[i10];
                    if (!zzaft.a(b7)) {
                        if ((((b7 + 112) + (b3 << 28)) >> 30) == 0 && !zzaft.a(b8) && !zzaft.a(b9)) {
                            int i11 = ((b7 & 63) << 12) | ((b3 & 7) << 18) | ((b8 & 63) << 6) | (b9 & 63);
                            cArr[i5] = (char) ((i11 >>> 10) + 55232);
                            cArr[i5 + 1] = (char) ((i11 & 1023) + 56320);
                            i5 += 2;
                        }
                    }
                    throw zzadi.b();
                }
                if (i6 >= i4) {
                    throw zzadi.b();
                }
                i2 += 2;
                int i12 = i5 + 1;
                byte b10 = bArr[i6];
                if (b3 < -62 || zzaft.a(b10)) {
                    throw zzadi.b();
                }
                cArr[i5] = (char) ((b10 & 63) | ((b3 & 31) << 6));
                i5 = i12;
            }
        }
        return new String(cArr, 0, i5);
    }
}
