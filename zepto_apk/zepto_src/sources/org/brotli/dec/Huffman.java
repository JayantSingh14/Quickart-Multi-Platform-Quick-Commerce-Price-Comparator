package org.brotli.dec;

/* loaded from: classes5.dex */
final class Huffman {
    public static void a(int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        int i5;
        int i6;
        int i7;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        int i8 = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            int i10 = iArr2[i9];
            iArr4[i10] = iArr4[i10] + 1;
        }
        iArr5[1] = 0;
        int i11 = 1;
        while (i11 < 15) {
            int i12 = i11 + 1;
            iArr5[i12] = iArr5[i11] + iArr4[i11];
            i11 = i12;
        }
        for (int i13 = 0; i13 < i4; i13++) {
            int i14 = iArr2[i13];
            if (i14 != 0) {
                int i15 = iArr5[i14];
                iArr5[i14] = i15 + 1;
                iArr3[i15] = i13;
            }
        }
        int i16 = 1 << i3;
        if (iArr5[15] == 1) {
            for (int i17 = 0; i17 < i16; i17++) {
                iArr[i2 + i17] = iArr3[0];
            }
            return;
        }
        int i18 = 2;
        int i19 = 2;
        int i20 = 0;
        int i21 = 1;
        while (i21 <= i3) {
            while (iArr4[i21] > 0) {
                int i22 = i2 + i8;
                int i23 = i20 + 1;
                int i24 = (i21 << 16) | iArr3[i20];
                int i25 = i16;
                do {
                    i25 -= i19;
                    iArr[i22 + i25] = i24;
                } while (i25 > 0);
                int i26 = 1 << (i21 - 1);
                while ((i8 & i26) != 0) {
                    i26 >>= 1;
                }
                i8 = (i8 & (i26 - 1)) + i26;
                iArr4[i21] = iArr4[i21] - 1;
                i20 = i23;
            }
            i21++;
            i19 <<= 1;
        }
        int i27 = i16 - 1;
        int i28 = i3 + 1;
        int i29 = -1;
        int i30 = i2;
        while (i28 <= 15) {
            while (iArr4[i28] > 0) {
                int i31 = i8 & i27;
                if (i31 != i29) {
                    int i32 = i30 + i16;
                    int i33 = 1 << (i28 - i3);
                    int i34 = i28;
                    while (i34 < 15) {
                        int i35 = i33 - iArr4[i34];
                        if (i35 <= 0) {
                            break;
                        }
                        i34++;
                        i33 = i35 << 1;
                    }
                    int i36 = i34 - i3;
                    iArr[i2 + i31] = ((i36 + i3) << 16) | ((i32 - i2) - i31);
                    i5 = i31;
                    i7 = i32;
                    i6 = 1 << i36;
                } else {
                    i5 = i29;
                    i6 = i16;
                    i7 = i30;
                }
                int i37 = i7 + (i8 >> i3);
                int i38 = i20 + 1;
                int i39 = ((i28 - i3) << 16) | iArr3[i20];
                int i40 = i6;
                do {
                    i40 -= i18;
                    iArr[i37 + i40] = i39;
                } while (i40 > 0);
                int i41 = 1 << (i28 - 1);
                while ((i8 & i41) != 0) {
                    i41 >>= 1;
                }
                i8 = (i8 & (i41 - 1)) + i41;
                iArr4[i28] = iArr4[i28] - 1;
                i16 = i6;
                i30 = i7;
                i29 = i5;
                i20 = i38;
            }
            i28++;
            i18 <<= 1;
        }
    }
}
