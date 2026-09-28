package in.juspay.widget.qrscanner.com.google.zxing;

import in.juspay.widget.qrscanner.com.google.zxing.common.BitArray;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;

/* loaded from: classes4.dex */
public abstract class Binarizer {

    /* renamed from: a, reason: collision with root package name */
    private final LuminanceSource f48798a;

    public Binarizer(LuminanceSource luminanceSource) {
        this.f48798a = luminanceSource;
    }

    public abstract Binarizer createBinarizer(LuminanceSource luminanceSource);

    public abstract BitMatrix getBlackMatrix();

    public abstract BitArray getBlackRow(int i2, BitArray bitArray);

    public final int getHeight() {
        return this.f48798a.getHeight();
    }

    public final LuminanceSource getLuminanceSource() {
        return this.f48798a;
    }

    public final int getWidth() {
        return this.f48798a.getWidth();
    }
}
