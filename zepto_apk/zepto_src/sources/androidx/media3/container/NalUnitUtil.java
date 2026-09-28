package androidx.media3.container;

import android.support.v4.media.a;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.util.Arrays;

@UnstableApi
/* loaded from: classes3.dex */
public final class NalUnitUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f5779a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    public static final float[] f5780b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5781c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static int[] f5782d = new int[10];

    public static final class H265SpsData {

        /* renamed from: a, reason: collision with root package name */
        public final int f5783a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5784b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5785c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5786d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5787e;

        /* renamed from: f, reason: collision with root package name */
        public final int f5788f;

        /* renamed from: g, reason: collision with root package name */
        public final int[] f5789g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5790h;

        /* renamed from: i, reason: collision with root package name */
        public final int f5791i;

        /* renamed from: j, reason: collision with root package name */
        public final int f5792j;

        /* renamed from: k, reason: collision with root package name */
        public final float f5793k;

        /* renamed from: l, reason: collision with root package name */
        public final int f5794l;

        /* renamed from: m, reason: collision with root package name */
        public final int f5795m;
        public final int n;
        public final int o;

        public H265SpsData(int i2, boolean z, int i3, int i4, int i5, int i6, int[] iArr, int i7, int i8, int i9, float f2, int i10, int i11, int i12, int i13) {
            this.f5783a = i2;
            this.f5784b = z;
            this.f5785c = i3;
            this.f5786d = i4;
            this.f5787e = i5;
            this.f5788f = i6;
            this.f5789g = iArr;
            this.f5790h = i7;
            this.f5791i = i8;
            this.f5792j = i9;
            this.f5793k = f2;
            this.f5794l = i10;
            this.f5795m = i11;
            this.n = i12;
            this.o = i13;
        }
    }

    public static final class PpsData {

        /* renamed from: a, reason: collision with root package name */
        public final int f5796a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f5797b;

        public PpsData(int i2, int i3, boolean z) {
            this.f5796a = i3;
            this.f5797b = z;
        }
    }

    public static final class SpsData {

        /* renamed from: a, reason: collision with root package name */
        public final int f5798a;

        /* renamed from: b, reason: collision with root package name */
        public final int f5799b;

        /* renamed from: c, reason: collision with root package name */
        public final int f5800c;

        /* renamed from: d, reason: collision with root package name */
        public final int f5801d;

        /* renamed from: e, reason: collision with root package name */
        public final int f5802e;

        /* renamed from: f, reason: collision with root package name */
        public final int f5803f;

        /* renamed from: g, reason: collision with root package name */
        public final float f5804g;

        /* renamed from: h, reason: collision with root package name */
        public final int f5805h;

        /* renamed from: i, reason: collision with root package name */
        public final int f5806i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f5807j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f5808k;

        /* renamed from: l, reason: collision with root package name */
        public final int f5809l;

        /* renamed from: m, reason: collision with root package name */
        public final int f5810m;
        public final int n;
        public final boolean o;
        public final int p;
        public final int q;
        public final int r;
        public final int s;

        public SpsData(int i2, int i3, int i4, int i5, int i6, int i7, float f2, int i8, int i9, boolean z, boolean z2, int i10, int i11, int i12, boolean z3, int i13, int i14, int i15, int i16) {
            this.f5798a = i2;
            this.f5799b = i3;
            this.f5800c = i4;
            this.f5801d = i5;
            this.f5802e = i6;
            this.f5803f = i7;
            this.f5804g = f2;
            this.f5805h = i8;
            this.f5806i = i9;
            this.f5807j = z;
            this.f5808k = z2;
            this.f5809l = i10;
            this.f5810m = i11;
            this.n = i12;
            this.o = z3;
            this.p = i13;
            this.q = i14;
            this.r = i15;
            this.s = i16;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static int b(byte[] bArr, int i2, int i3, boolean[] zArr) {
        int i4 = i3 - i2;
        Assertions.g(i4 >= 0);
        if (i4 == 0) {
            return i3;
        }
        if (zArr[0]) {
            a(zArr);
            return i2 - 3;
        }
        if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
            a(zArr);
            return i2 - 2;
        }
        if (i4 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
            a(zArr);
            return i2 - 1;
        }
        int i5 = i3 - 1;
        int i6 = i2 + 2;
        while (i6 < i5) {
            byte b2 = bArr[i6];
            if ((b2 & 254) == 0) {
                int i7 = i6 - 2;
                if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i7;
                }
                i6 -= 2;
            }
            i6 += 3;
        }
        zArr[0] = i4 <= 2 ? !(i4 != 2 ? !(zArr[1] && bArr[i5] == 1) : !(zArr[2] && bArr[i3 + (-2)] == 0 && bArr[i5] == 1)) : bArr[i3 + (-3)] == 0 && bArr[i3 + (-2)] == 0 && bArr[i5] == 1;
        zArr[1] = i4 <= 1 ? zArr[2] && bArr[i5] == 0 : bArr[i3 + (-2)] == 0 && bArr[i5] == 0;
        zArr[2] = bArr[i5] == 0;
        return i3;
    }

    public static H265SpsData c(int i2, byte[] bArr, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int iG;
        int i8;
        int i9;
        int i10;
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i2 + 2, i3);
        int i11 = 4;
        parsableNalUnitBitArray.j(4);
        int iE = parsableNalUnitBitArray.e(3);
        parsableNalUnitBitArray.i();
        int iE2 = parsableNalUnitBitArray.e(2);
        boolean zD = parsableNalUnitBitArray.d();
        int iE3 = parsableNalUnitBitArray.e(5);
        int i12 = 0;
        for (int i13 = 0; i13 < 32; i13++) {
            if (parsableNalUnitBitArray.d()) {
                i12 |= 1 << i13;
            }
        }
        int[] iArr = new int[6];
        for (int i14 = 0; i14 < 6; i14++) {
            iArr[i14] = parsableNalUnitBitArray.e(8);
        }
        int iE4 = parsableNalUnitBitArray.e(8);
        int i15 = 0;
        for (int i16 = 0; i16 < iE; i16++) {
            if (parsableNalUnitBitArray.d()) {
                i15 += 89;
            }
            if (parsableNalUnitBitArray.d()) {
                i15 += 8;
            }
        }
        parsableNalUnitBitArray.j(i15);
        if (iE > 0) {
            parsableNalUnitBitArray.j((8 - iE) * 2);
        }
        parsableNalUnitBitArray.f();
        int iF = parsableNalUnitBitArray.f();
        if (iF == 3) {
            parsableNalUnitBitArray.i();
        }
        int iF2 = parsableNalUnitBitArray.f();
        int iF3 = parsableNalUnitBitArray.f();
        if (parsableNalUnitBitArray.d()) {
            int iF4 = parsableNalUnitBitArray.f();
            int iF5 = parsableNalUnitBitArray.f();
            int iF6 = parsableNalUnitBitArray.f();
            int iF7 = parsableNalUnitBitArray.f();
            iF2 -= (iF4 + iF5) * ((iF == 1 || iF == 2) ? 2 : 1);
            iF3 -= (iF6 + iF7) * (iF == 1 ? 2 : 1);
        }
        int iF8 = parsableNalUnitBitArray.f();
        int i17 = iF2;
        int i18 = i12;
        int iF9 = parsableNalUnitBitArray.f();
        int iF10 = parsableNalUnitBitArray.f();
        int iF11 = -1;
        int iMax = -1;
        for (int i19 = parsableNalUnitBitArray.d() ? 0 : iE; i19 <= iE; i19++) {
            parsableNalUnitBitArray.f();
            iMax = Math.max(parsableNalUnitBitArray.f(), iMax);
            parsableNalUnitBitArray.f();
        }
        parsableNalUnitBitArray.f();
        parsableNalUnitBitArray.f();
        parsableNalUnitBitArray.f();
        parsableNalUnitBitArray.f();
        parsableNalUnitBitArray.f();
        parsableNalUnitBitArray.f();
        if (parsableNalUnitBitArray.d() && parsableNalUnitBitArray.d()) {
            int i20 = 0;
            while (i20 < i11) {
                int i21 = 0;
                while (i21 < 6) {
                    if (parsableNalUnitBitArray.d()) {
                        int iMin = Math.min(64, 1 << ((i20 << 1) + i11));
                        if (i20 > 1) {
                            parsableNalUnitBitArray.g();
                        }
                        for (int i22 = 0; i22 < iMin; i22++) {
                            parsableNalUnitBitArray.g();
                        }
                    } else {
                        parsableNalUnitBitArray.f();
                    }
                    i21 += i20 == 3 ? 3 : 1;
                    i11 = 4;
                }
                i20++;
                i11 = 4;
            }
        }
        parsableNalUnitBitArray.j(2);
        if (parsableNalUnitBitArray.d()) {
            parsableNalUnitBitArray.j(8);
            parsableNalUnitBitArray.f();
            parsableNalUnitBitArray.f();
            parsableNalUnitBitArray.i();
        }
        int iF12 = parsableNalUnitBitArray.f();
        int[] iArrCopyOf = new int[0];
        int[] iArrCopyOf2 = new int[0];
        int i23 = 0;
        int i24 = -1;
        int i25 = -1;
        while (i23 < iF12) {
            if (i23 == 0 || !parsableNalUnitBitArray.d()) {
                i8 = iMax;
                i9 = iF12;
                i10 = iF8;
                int iF13 = parsableNalUnitBitArray.f();
                int iF14 = parsableNalUnitBitArray.f();
                int[] iArr2 = new int[iF13];
                int i26 = 0;
                while (i26 < iF13) {
                    iArr2[i26] = (i26 > 0 ? iArr2[i26 - 1] : 0) - (parsableNalUnitBitArray.f() + 1);
                    parsableNalUnitBitArray.i();
                    i26++;
                }
                int[] iArr3 = new int[iF14];
                int i27 = 0;
                while (i27 < iF14) {
                    iArr3[i27] = parsableNalUnitBitArray.f() + 1 + (i27 > 0 ? iArr3[i27 - 1] : 0);
                    parsableNalUnitBitArray.i();
                    i27++;
                }
                i25 = iF14;
                iArrCopyOf2 = iArr3;
                iArrCopyOf = iArr2;
                i24 = iF13;
            } else {
                i8 = iMax;
                int i28 = i24 + i25;
                int iF15 = (1 - ((parsableNalUnitBitArray.d() ? 1 : 0) * 2)) * (parsableNalUnitBitArray.f() + 1);
                i9 = iF12;
                int i29 = i28 + 1;
                int[] iArr4 = iArrCopyOf;
                boolean[] zArr = new boolean[i29];
                for (int i30 = 0; i30 <= i28; i30++) {
                    if (parsableNalUnitBitArray.d()) {
                        zArr[i30] = true;
                    } else {
                        zArr[i30] = parsableNalUnitBitArray.d();
                    }
                }
                int[] iArr5 = new int[i29];
                int[] iArr6 = new int[i29];
                int i31 = 0;
                for (int i32 = i25 - 1; i32 >= 0; i32--) {
                    int i33 = iArrCopyOf2[i32] + iF15;
                    if (i33 < 0 && zArr[i24 + i32]) {
                        iArr5[i31] = i33;
                        i31++;
                    }
                }
                if (iF15 < 0 && zArr[i28]) {
                    iArr5[i31] = iF15;
                    i31++;
                }
                int i34 = i31;
                i10 = iF8;
                for (int i35 = 0; i35 < i24; i35++) {
                    int i36 = iArr4[i35] + iF15;
                    if (i36 < 0 && zArr[i35]) {
                        iArr5[i34] = i36;
                        i34++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr5, i34);
                int i37 = 0;
                for (int i38 = i24 - 1; i38 >= 0; i38--) {
                    int i39 = iArr4[i38] + iF15;
                    if (i39 > 0 && zArr[i38]) {
                        iArr6[i37] = i39;
                        i37++;
                    }
                }
                if (iF15 > 0 && zArr[i28]) {
                    iArr6[i37] = iF15;
                    i37++;
                }
                int i40 = i34;
                int i41 = i37;
                for (int i42 = 0; i42 < i25; i42++) {
                    int i43 = iArrCopyOf2[i42] + iF15;
                    if (i43 > 0 && zArr[i24 + i42]) {
                        iArr6[i41] = i43;
                        i41++;
                    }
                }
                iArrCopyOf2 = Arrays.copyOf(iArr6, i41);
                i25 = i41;
                i24 = i40;
            }
            i23++;
            iMax = i8;
            iF12 = i9;
            iF8 = i10;
        }
        int i44 = iMax;
        int i45 = iF8;
        if (parsableNalUnitBitArray.d()) {
            int iF16 = parsableNalUnitBitArray.f();
            for (int i46 = 0; i46 < iF16; i46++) {
                parsableNalUnitBitArray.j(iF10 + 5);
            }
        }
        parsableNalUnitBitArray.j(2);
        float f2 = 1.0f;
        if (parsableNalUnitBitArray.d()) {
            if (parsableNalUnitBitArray.d()) {
                int iE5 = parsableNalUnitBitArray.e(8);
                if (iE5 == 255) {
                    int iE6 = parsableNalUnitBitArray.e(16);
                    int iE7 = parsableNalUnitBitArray.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f2 = iE6 / iE7;
                    }
                } else if (iE5 < 17) {
                    f2 = f5780b[iE5];
                } else {
                    a.r(iE5, "Unexpected aspect_ratio_idc value: ", "NalUnitUtil");
                }
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.i();
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.j(3);
                i7 = parsableNalUnitBitArray.d() ? 1 : 2;
                if (parsableNalUnitBitArray.d()) {
                    int iE8 = parsableNalUnitBitArray.e(8);
                    int iE9 = parsableNalUnitBitArray.e(8);
                    parsableNalUnitBitArray.j(8);
                    iF11 = ColorInfo.f(iE8);
                    iG = ColorInfo.g(iE9);
                } else {
                    iG = -1;
                }
            } else {
                i7 = -1;
                iG = -1;
            }
            if (parsableNalUnitBitArray.d()) {
                parsableNalUnitBitArray.f();
                parsableNalUnitBitArray.f();
            }
            parsableNalUnitBitArray.i();
            if (parsableNalUnitBitArray.d()) {
                iF3 *= 2;
            }
            i6 = i7;
            i4 = iF3;
            i5 = iF11;
            iF11 = iG;
        } else {
            i4 = iF3;
            i5 = -1;
            i6 = -1;
        }
        return new H265SpsData(iE2, zD, iE3, i18, i45, iF9, iArr, iE4, i17, i4, f2, i44, i5, i6, iF11);
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x018e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.media3.container.NalUnitUtil.SpsData d(int r30, byte[] r31, int r32) {
        /*
            Method dump skipped, instructions count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.container.NalUnitUtil.d(int, byte[], int):androidx.media3.container.NalUnitUtil$SpsData");
    }

    public static void e(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int iF = parsableNalUnitBitArray.f() + 1;
        parsableNalUnitBitArray.j(8);
        for (int i2 = 0; i2 < iF; i2++) {
            parsableNalUnitBitArray.f();
            parsableNalUnitBitArray.f();
            parsableNalUnitBitArray.i();
        }
        parsableNalUnitBitArray.j(20);
    }

    public static int f(int i2, byte[] bArr) {
        int i3;
        synchronized (f5781c) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                while (true) {
                    if (i4 >= i2 - 2) {
                        i4 = i2;
                        break;
                    }
                    try {
                        if (bArr[i4] == 0 && bArr[i4 + 1] == 0 && bArr[i4 + 2] == 3) {
                            break;
                        }
                        i4++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i4 < i2) {
                    int[] iArr = f5782d;
                    if (iArr.length <= i5) {
                        f5782d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    f5782d[i5] = i4;
                    i4 += 3;
                    i5++;
                }
            }
            i3 = i2 - i5;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i5; i8++) {
                int i9 = f5782d[i8] - i7;
                System.arraycopy(bArr, i7, bArr, i6, i9);
                int i10 = i6 + i9;
                int i11 = i10 + 1;
                bArr[i10] = 0;
                i6 = i10 + 2;
                bArr[i11] = 0;
                i7 += i9 + 3;
            }
            System.arraycopy(bArr, i7, bArr, i6, i3 - i6);
        }
        return i3;
    }
}
