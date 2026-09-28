package in.juspay.widget.qrscanner.com.google.zxing;

import android.support.v4.media.b;

/* loaded from: classes4.dex */
public final class RGBLuminanceSource extends LuminanceSource {

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f48817c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48818d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48819e;

    /* renamed from: f, reason: collision with root package name */
    private final int f48820f;

    /* renamed from: g, reason: collision with root package name */
    private final int f48821g;

    public RGBLuminanceSource(int i2, int i3, int[] iArr) {
        super(i2, i3);
        this.f48818d = i2;
        this.f48819e = i3;
        this.f48820f = 0;
        this.f48821g = 0;
        int i4 = i2 * i3;
        this.f48817c = new byte[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = iArr[i5];
            this.f48817c[i5] = (byte) (((((i6 >> 16) & 255) + ((i6 >> 7) & 510)) + (i6 & 255)) / 4);
        }
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        return new RGBLuminanceSource(this.f48817c, this.f48818d, this.f48819e, this.f48820f + i2, this.f48821g + i3, i4, i5);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i2 = this.f48818d;
        if (width == i2 && height == this.f48819e) {
            return this.f48817c;
        }
        int i3 = width * height;
        byte[] bArr = new byte[i3];
        int i4 = (this.f48821g * i2) + this.f48820f;
        if (width == i2) {
            System.arraycopy(this.f48817c, i4, bArr, 0, i3);
            return bArr;
        }
        for (int i5 = 0; i5 < height; i5++) {
            System.arraycopy(this.f48817c, i4, bArr, i5 * width, width);
            i4 += this.f48818d;
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
        System.arraycopy(this.f48817c, ((i2 + this.f48821g) * this.f48818d) + this.f48820f, bArr, 0, width);
        return bArr;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.LuminanceSource
    public boolean isCropSupported() {
        return true;
    }

    private RGBLuminanceSource(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7) {
        super(i6, i7);
        if (i6 + i4 > i2 || i7 + i5 > i3) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f48817c = bArr;
        this.f48818d = i2;
        this.f48819e = i3;
        this.f48820f = i4;
        this.f48821g = i5;
    }
}
