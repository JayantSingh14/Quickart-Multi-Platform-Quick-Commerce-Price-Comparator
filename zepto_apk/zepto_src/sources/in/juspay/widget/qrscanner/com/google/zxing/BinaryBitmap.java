package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.common.BitArray;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;

/* loaded from: classes4.dex */
public final class BinaryBitmap {

    /* renamed from: a, reason: collision with root package name */
    private final Binarizer f48799a;

    /* renamed from: b, reason: collision with root package name */
    private BitMatrix f48800b;

    public BinaryBitmap(Binarizer binarizer) {
        if (binarizer == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.f48799a = binarizer;
    }

    public BinaryBitmap crop(int i2, int i3, int i4, int i5) {
        return new BinaryBitmap(this.f48799a.createBinarizer(this.f48799a.getLuminanceSource().crop(i2, i3, i4, i5)));
    }

    public BitMatrix getBlackMatrix() {
        if (this.f48800b == null) {
            this.f48800b = this.f48799a.getBlackMatrix();
        }
        return this.f48800b;
    }

    public BitArray getBlackRow(int i2, BitArray bitArray) {
        return this.f48799a.getBlackRow(i2, bitArray);
    }

    public int getHeight() {
        return this.f48799a.getHeight();
    }

    public int getWidth() {
        return this.f48799a.getWidth();
    }

    public boolean isCropSupported() {
        return this.f48799a.getLuminanceSource().isCropSupported();
    }

    public boolean isRotateSupported() {
        return this.f48799a.getLuminanceSource().isRotateSupported();
    }

    public BinaryBitmap rotateCounterClockwise() {
        return new BinaryBitmap(this.f48799a.createBinarizer(this.f48799a.getLuminanceSource().rotateCounterClockwise()));
    }

    public BinaryBitmap rotateCounterClockwise45() {
        return new BinaryBitmap(this.f48799a.createBinarizer(this.f48799a.getLuminanceSource().rotateCounterClockwise45()));
    }

    public String toString() {
        try {
            return getBlackMatrix().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
