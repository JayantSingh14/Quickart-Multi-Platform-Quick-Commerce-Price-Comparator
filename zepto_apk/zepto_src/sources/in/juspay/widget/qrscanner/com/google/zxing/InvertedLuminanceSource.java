package in.juspay.widget.qrscanner.com.google.zxing;

/* loaded from: classes4.dex */
public final class InvertedLuminanceSource extends LuminanceSource {

    /* renamed from: c, reason: collision with root package name */
    private final LuminanceSource f48806c;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.f48806c = luminanceSource;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        return new InvertedLuminanceSource(this.f48806c.crop(i2, i3, i4, i5));
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        byte[] matrix = this.f48806c.getMatrix();
        int height = getHeight() * getWidth();
        byte[] bArr = new byte[height];
        for (int i2 = 0; i2 < height; i2++) {
            bArr[i2] = (byte) (255 - (matrix[i2] & 255));
        }
        return bArr;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public byte[] getRow(int i2, byte[] bArr) {
        byte[] row = this.f48806c.getRow(i2, bArr);
        int width = getWidth();
        for (int i3 = 0; i3 < width; i3++) {
            row[i3] = (byte) (255 - (row[i3] & 255));
        }
        return row;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public LuminanceSource invert() {
        return this.f48806c;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return this.f48806c.isCropSupported();
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public boolean isRotateSupported() {
        return this.f48806c.isRotateSupported();
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.f48806c.rotateCounterClockwise());
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.f48806c.rotateCounterClockwise45());
    }
}
