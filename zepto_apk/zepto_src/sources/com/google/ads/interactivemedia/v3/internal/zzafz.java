package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzafz {
    private static final zzafw zza;

    static {
        if (zzafu.zzx() && zzafu.zzy()) {
            int i2 = zzaay.zza;
        }
        zza = new zzafx();
    }

    public static /* bridge */ /* synthetic */ int zzc(byte[] bArr, int i2, int i3) {
        int i4 = i3 - i2;
        byte b2 = bArr[i2 - 1];
        if (i4 == 0) {
            if (b2 > -12) {
                return -1;
            }
            return b2;
        }
        if (i4 == 1) {
            return zzj(b2, bArr[i2]);
        }
        if (i4 == 2) {
            return zzk(b2, bArr[i2], bArr[i2 + 1]);
        }
        throw new AssertionError();
    }

    public static int zzd(String str, byte[] bArr, int i2, int i3) {
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
                        if (cCharAt2 >= 55296 && cCharAt2 <= 57343 && ((i5 = i7 + 1) == str.length() || !Character.isSurrogatePair(cCharAt2, str.charAt(i5)))) {
                            throw new zzafy(i7, length);
                        }
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + cCharAt2 + " at index " + i8);
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
                    throw new zzafy(i7 - 1, length);
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

    public static int zze(String str) {
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
                                throw new zzafy(i3, length2);
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

    public static int zzf(int i2, byte[] bArr, int i3, int i4) {
        return zza.zza(i2, bArr, i3, i4);
    }

    public static String zzg(byte[] bArr, int i2, int i3) throws zzacz {
        int i4;
        int length = bArr.length;
        if ((((length - i2) - i3) | i2 | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(i2), Integer.valueOf(i3)));
        }
        int i5 = i2 + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (i2 < i5) {
            byte b2 = bArr[i2];
            if (!zzafv.zzd(b2)) {
                break;
            }
            i2++;
            cArr[i6] = (char) b2;
            i6++;
        }
        int i7 = i6;
        while (i2 < i5) {
            int i8 = i2 + 1;
            byte b3 = bArr[i2];
            if (zzafv.zzd(b3)) {
                cArr[i7] = (char) b3;
                i7++;
                i2 = i8;
                while (i2 < i5) {
                    byte b4 = bArr[i2];
                    if (zzafv.zzd(b4)) {
                        i2++;
                        cArr[i7] = (char) b4;
                        i7++;
                    }
                }
            } else {
                if (b3 < -32) {
                    if (i8 >= i5) {
                        throw zzacz.zzd();
                    }
                    i4 = i7 + 1;
                    i2 += 2;
                    zzafv.zzc(b3, bArr[i8], cArr, i7);
                } else if (b3 < -16) {
                    if (i8 >= i5 - 1) {
                        throw zzacz.zzd();
                    }
                    i4 = i7 + 1;
                    int i9 = i2 + 2;
                    i2 += 3;
                    zzafv.zzb(b3, bArr[i8], bArr[i9], cArr, i7);
                } else {
                    if (i8 >= i5 - 2) {
                        throw zzacz.zzd();
                    }
                    byte b5 = bArr[i8];
                    int i10 = i2 + 3;
                    byte b6 = bArr[i2 + 2];
                    i2 += 4;
                    zzafv.zza(b3, b5, b6, bArr[i10], cArr, i7);
                    i7 += 2;
                }
                i7 = i4;
            }
        }
        return new String(cArr, 0, i7);
    }

    public static boolean zzh(byte[] bArr) {
        return zza.zzb(bArr, 0, bArr.length);
    }

    public static boolean zzi(byte[] bArr, int i2, int i3) {
        return zza.zzb(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzj(int i2, int i3) {
        if (i2 > -12 || i3 > -65) {
            return -1;
        }
        return i2 ^ (i3 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzk(int i2, int i3, int i4) {
        if (i2 > -12 || i3 > -65 || i4 > -65) {
            return -1;
        }
        return (i2 ^ (i3 << 8)) ^ (i4 << 16);
    }
}
