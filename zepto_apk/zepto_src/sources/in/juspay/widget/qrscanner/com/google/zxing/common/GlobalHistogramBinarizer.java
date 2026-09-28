package in.juspay.widget.qrscanner.com.google.zxing.common;

import in.juspay.widget.qrscanner.com.google.zxing.Binarizer;
import in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;

/* loaded from: classes4.dex */
public class GlobalHistogramBinarizer extends Binarizer {

    /* renamed from: d, reason: collision with root package name */
    private static final byte[] f48890d = new byte[0];

    /* renamed from: b, reason: collision with root package name */
    private byte[] f48891b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f48892c;

    public GlobalHistogramBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
        this.f48891b = f48890d;
        this.f48892c = new int[32];
    }

    private static int a(int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            if (i6 > i2) {
                i4 = i5;
                i2 = i6;
            }
            if (i6 > i3) {
                i3 = i6;
            }
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            int i10 = i9 - i4;
            int i11 = iArr[i9] * i10 * i10;
            if (i11 > i8) {
                i7 = i9;
                i8 = i11;
            }
        }
        if (i4 <= i7) {
            int i12 = i4;
            i4 = i7;
            i7 = i12;
        }
        if (i4 - i7 <= length / 16) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i13 = i4 - 1;
        int i14 = -1;
        int i15 = i13;
        while (i13 > i7) {
            int i16 = i13 - i7;
            int i17 = (i3 - iArr[i13]) * (i4 - i13) * i16 * i16;
            if (i17 > i14) {
                i15 = i13;
                i14 = i17;
            }
            i13--;
        }
        return i15 << 3;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Binarizer
    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new GlobalHistogramBinarizer(luminanceSource);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Binarizer
    public BitMatrix getBlackMatrix() throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        BitMatrix bitMatrix = new BitMatrix(width, height);
        a(width);
        int[] iArr = this.f48892c;
        for (int i2 = 1; i2 < 5; i2++) {
            byte[] row = luminanceSource.getRow((height * i2) / 5, this.f48891b);
            int i3 = (width * 4) / 5;
            for (int i4 = width / 5; i4 < i3; i4++) {
                int i5 = (row[i4] & 255) >> 3;
                iArr[i5] = iArr[i5] + 1;
            }
        }
        int iA = a(iArr);
        byte[] matrix = luminanceSource.getMatrix();
        for (int i6 = 0; i6 < height; i6++) {
            int i7 = i6 * width;
            for (int i8 = 0; i8 < width; i8++) {
                if ((matrix[i7 + i8] & 255) < iA) {
                    bitMatrix.set(i8, i6);
                }
            }
        }
        return bitMatrix;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Binarizer
    public BitArray getBlackRow(int i2, BitArray bitArray) throws NotFoundException {
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        if (bitArray == null || bitArray.getSize() < width) {
            bitArray = new BitArray(width);
        } else {
            bitArray.clear();
        }
        a(width);
        byte[] row = luminanceSource.getRow(i2, this.f48891b);
        int[] iArr = this.f48892c;
        for (int i3 = 0; i3 < width; i3++) {
            int i4 = (row[i3] & 255) >> 3;
            iArr[i4] = iArr[i4] + 1;
        }
        int iA = a(iArr);
        if (width < 3) {
            for (int i5 = 0; i5 < width; i5++) {
                if ((row[i5] & 255) < iA) {
                    bitArray.set(i5);
                }
            }
        } else {
            int i6 = row[0] & 255;
            int i7 = row[1] & 255;
            int i8 = 1;
            while (i8 < width - 1) {
                int i9 = i8 + 1;
                int i10 = row[i9] & 255;
                if ((((i7 * 4) - i6) - i10) / 2 < iA) {
                    bitArray.set(i8);
                }
                i6 = i7;
                i8 = i9;
                i7 = i10;
            }
        }
        return bitArray;
    }

    private void a(int i2) {
        if (this.f48891b.length < i2) {
            this.f48891b = new byte[i2];
        }
        for (int i3 = 0; i3 < 32; i3++) {
            this.f48892c[i3] = 0;
        }
    }
}
