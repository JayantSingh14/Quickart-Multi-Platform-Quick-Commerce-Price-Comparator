package in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class ByteMatrix {

    /* renamed from: a, reason: collision with root package name */
    private final byte[][] f48975a;

    /* renamed from: b, reason: collision with root package name */
    private final int f48976b;

    /* renamed from: c, reason: collision with root package name */
    private final int f48977c;

    public ByteMatrix(int i2, int i3) {
        this.f48975a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i3, i2);
        this.f48976b = i2;
        this.f48977c = i3;
    }

    public void clear(byte b2) {
        for (byte[] bArr : this.f48975a) {
            Arrays.fill(bArr, b2);
        }
    }

    public byte get(int i2, int i3) {
        return this.f48975a[i3][i2];
    }

    public byte[][] getArray() {
        return this.f48975a;
    }

    public int getHeight() {
        return this.f48977c;
    }

    public int getWidth() {
        return this.f48976b;
    }

    public void set(int i2, int i3, byte b2) {
        this.f48975a[i3][i2] = b2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f48976b * 2 * this.f48977c) + 2);
        for (int i2 = 0; i2 < this.f48977c; i2++) {
            byte[] bArr = this.f48975a[i2];
            for (int i3 = 0; i3 < this.f48976b; i3++) {
                byte b2 = bArr[i3];
                sb.append(b2 != 0 ? b2 != 1 ? "  " : " 1" : " 0");
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public void set(int i2, int i3, int i4) {
        this.f48975a[i3][i2] = (byte) i4;
    }

    public void set(int i2, int i3, boolean z) {
        this.f48975a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }
}
