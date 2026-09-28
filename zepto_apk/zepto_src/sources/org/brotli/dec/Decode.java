package org.brotli.dec;

import org.xbill.DNS.Message;

/* loaded from: classes5.dex */
final class Decode {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f57410a = {1, 2, 3, 4, 0, 5, 17, 6, 16, 7, 8, 9, 10, 11, 12, 13, 14, 15};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f57411b = {3, 2, 1, 0, 3, 3, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f57412c = {0, 0, 0, 0, -1, 1, -2, 2, -3, 3, -1, 1, -2, 2, -3, 3};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f57413d = {131072, 131076, 131075, 196610, 131072, 131076, 131075, 262145, 131072, 131076, 131075, 196610, 131072, 131076, 131075, 262149};

    public static void a(State state, int i2) {
        BitReader bitReader = state.f57432c;
        int i3 = i2 * 2;
        BitReader.b(bitReader);
        int i4 = i2 * 1080;
        int iF = f(state.f57434e, i4, bitReader);
        BitReader.b(bitReader);
        int iF2 = f(state.f57435f, i4, bitReader);
        state.n[i2] = Prefix.f57422a[iF2] + BitReader.d(bitReader, Prefix.f57423b[iF2]);
        int[] iArr = state.p;
        int i5 = iF == 1 ? iArr[i3 + 1] + 1 : iF == 0 ? iArr[i3] : iF - 2;
        int i6 = state.o[i2];
        if (i5 >= i6) {
            i5 -= i6;
        }
        int i7 = i3 + 1;
        iArr[i3] = iArr[i7];
        iArr[i7] = i5;
    }

    public static int b(int i2, byte[] bArr, BitReader bitReader) {
        int iD;
        BitReader.e(bitReader);
        if (BitReader.d(bitReader, 1) != 0) {
            int iD2 = BitReader.d(bitReader, 3);
            iD = iD2 == 0 ? 1 : BitReader.d(bitReader, iD2) + (1 << iD2);
        } else {
            iD = 0;
        }
        int i3 = iD + 1;
        if (i3 == 1) {
            int i4 = 0;
            while (i4 < i2) {
                int iMin = Math.min(i4 + 1024, i2) - i4;
                System.arraycopy(Utils.f57447a, 0, bArr, i4, iMin);
                i4 += iMin;
            }
        } else {
            int iD3 = BitReader.d(bitReader, 1) == 1 ? BitReader.d(bitReader, 4) + 1 : 0;
            int[] iArr = new int[1080];
            e(i3 + iD3, iArr, 0, bitReader);
            int i5 = 0;
            while (i5 < i2) {
                BitReader.e(bitReader);
                BitReader.b(bitReader);
                int iF = f(iArr, 0, bitReader);
                if (iF == 0) {
                    bArr[i5] = 0;
                } else if (iF <= iD3) {
                    for (int iD4 = (1 << iF) + BitReader.d(bitReader, iF); iD4 != 0; iD4--) {
                        if (i5 >= i2) {
                            throw new BrotliRuntimeException("Corrupted context map");
                        }
                        bArr[i5] = 0;
                        i5++;
                    }
                } else {
                    bArr[i5] = (byte) (iF - iD3);
                }
                i5++;
            }
            if (BitReader.d(bitReader, 1) == 1) {
                int[] iArr2 = new int[256];
                for (int i6 = 0; i6 < 256; i6++) {
                    iArr2[i6] = i6;
                }
                for (int i7 = 0; i7 < i2; i7++) {
                    int i8 = bArr[i7] & 255;
                    int i9 = iArr2[i8];
                    bArr[i7] = (byte) i9;
                    if (i8 != 0) {
                        while (i8 > 0) {
                            iArr2[i8] = iArr2[i8 - 1];
                            i8--;
                        }
                        iArr2[0] = i9;
                    }
                }
            }
        }
        return i3;
    }

    public static void c(State state) {
        a(state, 0);
        int i2 = state.p[1];
        int i3 = i2 << 6;
        state.A = i3;
        state.v = state.f57440k.f57419c[state.z[i3] & 255];
        byte b2 = state.y[i2];
        int[] iArr = Context.f57409b;
        state.C = iArr[b2];
        state.D = iArr[b2 + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0140, code lost:
    
        throw new org.brotli.dec.BrotliRuntimeException("Invalid backward reference");
     */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0437 A[LOOP:7: B:164:0x0437->B:173:0x047e, LOOP_START, PHI: r5
      0x0437: PHI (r5v83 char) = (r5v63 char), (r5v86 char) binds: [B:163:0x0435, B:173:0x047e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0605  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0716  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x071c  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0746  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x0748  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0751  */
    /* JADX WARN: Removed duplicated region for block: B:410:0x07b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:413:0x07b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:428:0x05fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:430:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(org.brotli.dec.State r29) {
        /*
            Method dump skipped, instructions count: 2140
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.brotli.dec.Decode.d(org.brotli.dec.State):void");
    }

    public static void e(int i2, int[] iArr, int i3, BitReader bitReader) {
        int i4;
        int i5;
        int i6;
        BitReader.e(bitReader);
        int[] iArr2 = new int[i2];
        int iD = BitReader.d(bitReader, 2);
        char c2 = 3;
        boolean z = true;
        if (iD == 1) {
            int i7 = i2 - 1;
            int[] iArr3 = new int[4];
            int iD2 = BitReader.d(bitReader, 2) + 1;
            int i8 = 0;
            while (i7 != 0) {
                i7 >>= 1;
                i8++;
            }
            for (int i9 = 0; i9 < iD2; i9++) {
                int iD3 = BitReader.d(bitReader, i8) % i2;
                iArr3[i9] = iD3;
                iArr2[iD3] = 2;
            }
            iArr2[iArr3[0]] = 1;
            if (iD2 != 1) {
                if (iD2 == 2) {
                    int i10 = iArr3[0];
                    int i11 = iArr3[1];
                    z = i10 != i11;
                    iArr2[i11] = 1;
                } else if (iD2 != 3) {
                    int i12 = iArr3[0];
                    int i13 = iArr3[1];
                    boolean z2 = (i12 == i13 || i12 == (i5 = iArr3[2]) || i12 == (i6 = iArr3[3]) || i13 == i5 || i13 == i6 || i5 == i6) ? false : true;
                    if (BitReader.d(bitReader, 1) == 1) {
                        iArr2[iArr3[2]] = 3;
                        iArr2[iArr3[3]] = 3;
                    } else {
                        iArr2[iArr3[0]] = 2;
                    }
                    z = z2;
                } else {
                    int i14 = iArr3[0];
                    int i15 = iArr3[1];
                    if (i14 != i15 && i14 != (i4 = iArr3[2]) && i15 != i4) {
                        z = true;
                    }
                }
                z = z;
            }
        } else {
            int[] iArr4 = new int[18];
            int i16 = 0;
            int i17 = 32;
            while (iD < 18 && i17 > 0) {
                int i18 = f57410a[iD];
                BitReader.b(bitReader);
                long j2 = bitReader.f57400f;
                char c3 = c2;
                int i19 = bitReader.f57401g;
                int i20 = f57413d[((int) (j2 >>> i19)) & 15];
                bitReader.f57401g = i19 + (i20 >> 16);
                int i21 = i20 & Message.MAXLENGTH;
                iArr4[i18] = i21;
                if (i21 != 0) {
                    i17 -= 32 >> i21;
                    i16++;
                }
                iD++;
                c2 = c3;
            }
            if (i16 != 1 && i17 != 0) {
                z = false;
            }
            int[] iArr5 = new int[32];
            Huffman.a(0, 5, 18, iArr5, iArr4);
            int i22 = 8;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 32768;
            while (i23 < i2 && i26 > 0) {
                BitReader.e(bitReader);
                BitReader.b(bitReader);
                long j3 = bitReader.f57400f;
                int i27 = bitReader.f57401g;
                int i28 = iArr5[((int) (j3 >>> i27)) & 31];
                bitReader.f57401g = i27 + (i28 >> 16);
                int i29 = i28 & Message.MAXLENGTH;
                if (i29 < 16) {
                    int i30 = i23 + 1;
                    iArr2[i23] = i29;
                    if (i29 != 0) {
                        i26 -= 32768 >> i29;
                        i22 = i29;
                    }
                    i23 = i30;
                    i25 = 0;
                } else {
                    int i31 = i29 - 14;
                    int i32 = i29 == 16 ? i22 : 0;
                    if (i24 != i32) {
                        i24 = i32;
                        i25 = 0;
                    }
                    int iD4 = BitReader.d(bitReader, i31) + 3 + (i25 > 0 ? (i25 - 2) << i31 : i25);
                    int i33 = iD4 - i25;
                    if (i23 + i33 > i2) {
                        throw new BrotliRuntimeException("symbol + repeatDelta > numSymbols");
                    }
                    int i34 = 0;
                    while (i34 < i33) {
                        iArr2[i23] = i24;
                        i34++;
                        i23++;
                    }
                    if (i24 != 0) {
                        i26 -= i33 << (15 - i24);
                    }
                    i25 = iD4;
                }
            }
            if (i26 != 0) {
                throw new BrotliRuntimeException("Unused space");
            }
            int i35 = i2 - i23;
            int i36 = 0;
            while (i36 < i35) {
                int iMin = Math.min(i36 + 1024, i35) - i36;
                System.arraycopy(Utils.f57448b, 0, iArr2, i23 + i36, iMin);
                i36 += iMin;
            }
        }
        if (!z) {
            throw new BrotliRuntimeException("Can't readHuffmanCode");
        }
        Huffman.a(i3, 8, i2, iArr, iArr2);
    }

    public static int f(int[] iArr, int i2, BitReader bitReader) {
        long j2 = bitReader.f57400f;
        int i3 = bitReader.f57401g;
        int i4 = (int) (j2 >>> i3);
        int i5 = i2 + (i4 & 255);
        int i6 = iArr[i5];
        int i7 = i6 >> 16;
        int i8 = i6 & Message.MAXLENGTH;
        if (i7 <= 8) {
            bitReader.f57401g = i3 + i7;
            return i8;
        }
        int i9 = iArr[i5 + i8 + ((i4 & ((1 << i7) - 1)) >>> 8)];
        bitReader.f57401g = (i9 >> 16) + 8 + i3;
        return i9 & Message.MAXLENGTH;
    }
}
