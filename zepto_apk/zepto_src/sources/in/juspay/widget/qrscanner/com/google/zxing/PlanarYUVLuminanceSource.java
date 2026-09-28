package in.juspay.widget.qrscanner.com.google.zxing;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
public final class PlanarYUVLuminanceSource extends LuminanceSource {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f48812c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48813d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48814e;

    /* renamed from: f, reason: collision with root package name */
    private final int f48815f;

    /* renamed from: g, reason: collision with root package name */
    private final int f48816g;

    public PlanarYUVLuminanceSource(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        super(i6, i7);
        if (i4 + i6 > i2 || i5 + i7 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f48812c = bArr;
        this.f48813d = i2;
        this.f48814e = i3;
        this.f48815f = i4;
        this.f48816g = i5;
        if (z) {
            a(i6, i7);
        }
    }

    private void a(int i2, int i3) {
        byte[] bArr = this.f48812c;
        int i4 = (this.f48816g * this.f48813d) + this.f48815f;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = (i2 / 2) + i4;
            int i7 = (i4 + i2) - 1;
            int i8 = i4;
            while (i8 < i6) {
                byte b2 = bArr[i8];
                bArr[i8] = bArr[i7];
                bArr[i7] = b2;
                i8++;
                i7--;
            }
            i5++;
            i4 += this.f48813d;
        }
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        return new PlanarYUVLuminanceSource(this.f48812c, this.f48813d, this.f48814e, this.f48815f + i2, this.f48816g + i3, i4, i5, false);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i2 = this.f48813d;
        if (width == i2 && height == this.f48814e) {
            return this.f48812c;
        }
        int i3 = width * height;
        byte[] bArr = new byte[i3];
        int i4 = (this.f48816g * i2) + this.f48815f;
        if (width == i2) {
            System.arraycopy(this.f48812c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(this.f48812c, i4, bArr, i5 * width, width);
            i4 += this.f48813d;
        }
        return bArr;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public byte[] getRow(int i2, byte[] bArr) {
        if (i2 < 0 || i2 >= getHeight()) {
            throw new IllegalArgumentException(b.f(i2, "Requested row is outside the image: "));
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.f48812c, ((i2 + this.f48816g) * this.f48813d) + this.f48815f, bArr, 0, width);
        return bArr;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[width * height];
        byte[] bArr = this.f48812c;
        int i2 = (this.f48816g * this.f48813d) + this.f48815f;
        for (int i3 = 0; i3 < height; i3++) {
            int i4 = i3 * width;
            for (int i5 = 0; i5 < width; i5++) {
                iArr[i4 + i5] = ((bArr[(i5 * 2) + i2] & 255) * 65793) | (-16777216);
            }
            i2 += this.f48813d * 2;
        }
        return iArr;
    }
}
