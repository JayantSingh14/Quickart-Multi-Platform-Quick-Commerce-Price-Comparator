package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.Binarizer;
import in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource;

/* loaded from: classes4.dex */
public final class HybridBinarizer extends GlobalHistogramBinarizer {

    /* renamed from: e, reason: collision with root package name */
    private BitMatrix f48894e;

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    private static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.common.GlobalHistogramBinarizer, in.juspay.widget.qrscanner.com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.common.GlobalHistogramBinarizer, in.juspay.widget.qrscanner.com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() {
        BitMatrix bitMatrix = this.f48894e;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.f48894e = super.getBlackMatrix();
        } else {
            byte[] matrix = luminanceSource.getMatrix();
            int i2 = width >> 3;
            if ((width & 7) != 0) {
                i2++;
            }
            int i3 = i2;
            int i4 = height >> 3;
            if ((height & 7) != 0) {
                i4++;
            }
            int i5 = i4;
            int[][] iArrA = a(matrix, i3, i5, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            a(matrix, i3, i5, width, height, iArrA, bitMatrix2);
            this.f48894e = bitMatrix2;
        }
        return this.f48894e;
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, int i5, BitMatrix bitMatrix) {
        int i6 = (i3 * i5) + i2;
        int i7 = 0;
        while (i7 < 8) {
            for (int i8 = 0; i8 < 8; i8++) {
                if ((bArr[i6 + i8] & 255) <= i4) {
                    bitMatrix.set(i2 + i8, i3 + i7);
                }
            }
            i7++;
            i6 += i5;
        }
    }

    private static void a(byte[] bArr, int i2, int i3, int i4, int i5, int[][] iArr, BitMatrix bitMatrix) {
        int i6 = i5 - 8;
        int i7 = i4 - 8;
        for (int i8 = 0; i8 < i3; i8++) {
            int i9 = i8 << 3;
            int i10 = i9 > i6 ? i6 : i9;
            int iA = a(i8, 2, i3 - 3);
            for (int i11 = 0; i11 < i2; i11++) {
                int i12 = i11 << 3;
                int i13 = i12 > i7 ? i7 : i12;
                int iA2 = a(i11, 2, i2 - 3);
                int i14 = 0;
                for (int i15 = -2; i15 <= 2; i15++) {
                    int[] iArr2 = iArr[iA + i15];
                    i14 += iArr2[iA2 - 2] + iArr2[iA2 - 1] + iArr2[iA2] + iArr2[iA2 + 1] + iArr2[iA2 + 2];
                }
                a(bArr, i13, i10, i14 / 25, i4, bitMatrix);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0099 A[PHI: r8
      0x0099: PHI (r8v6 int) = (r8v5 int), (r8v8 int), (r8v8 int), (r8v8 int) binds: [B:33:0x007a, B:35:0x007e, B:36:0x0080, B:38:0x0096] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static int[][] a(byte[] r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.widget.qrscanner.com.google.zxing.common.HybridBinarizer.a(byte[], int, int, int, int):int[][]");
    }
}
