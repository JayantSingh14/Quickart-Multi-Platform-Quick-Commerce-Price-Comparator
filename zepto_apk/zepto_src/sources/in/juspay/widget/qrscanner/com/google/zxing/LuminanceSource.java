package in.juspay.widget.qrscanner.com.google.zxing;

import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes4.dex */
public abstract class LuminanceSource {

    /* renamed from: a, reason: collision with root package name */
    private final int f48807a;

    /* renamed from: b, reason: collision with root package name */
    private final int f48808b;

    public LuminanceSource(int i2, int i3) {
        this.f48807a = i2;
        this.f48808b = i3;
    }

    public LuminanceSource crop(int i2, int i3, int i4, int i5) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.f48808b;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i2, byte[] bArr);

    public final int getWidth() {
        return this.f48807a;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i2 = this.f48807a;
        byte[] row = new byte[i2];
        StringBuilder sb = new StringBuilder((i2 + 1) * this.f48808b);
        for (int i3 = 0; i3 < this.f48808b; i3++) {
            row = getRow(i3, row);
            for (int i4 = 0; i4 < this.f48807a; i4++) {
                int i5 = row[i4] & 255;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? ClassUtils.PACKAGE_SEPARATOR_CHAR : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
