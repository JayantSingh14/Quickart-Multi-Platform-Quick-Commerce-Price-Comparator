package in.juspay.widget.qrscanner.com.journeyapps.barcodescanner;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import in.juspay.widget.qrscanner.com.google.zxing.PlanarYUVLuminanceSource;
import java.io.ByteArrayOutputStream;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private byte[] f49080a;

    /* renamed from: b, reason: collision with root package name */
    private int f49081b;

    /* renamed from: c, reason: collision with root package name */
    private int f49082c;

    /* renamed from: d, reason: collision with root package name */
    private int f49083d;

    /* renamed from: e, reason: collision with root package name */
    private int f49084e;

    /* renamed from: f, reason: collision with root package name */
    private Rect f49085f;

    public j(byte[] bArr, int i2, int i3, int i4, int i5) {
        this.f49080a = bArr;
        this.f49081b = i2;
        this.f49082c = i3;
        this.f49084e = i5;
        this.f49083d = i4;
        if (i2 * i3 <= bArr.length) {
            return;
        }
        StringBuilder sbT = android.support.v4.media.b.t(i2, i3, "Image data does not match the resolution. ", "x", " > ");
        sbT.append(bArr.length);
        throw new IllegalArgumentException(sbT.toString());
    }

    public static byte[] c(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i2 * i3];
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = i3 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i2) + i5];
                i4++;
            }
        }
        return bArr2;
    }

    public Bitmap a(int i2) {
        return a(this.f49085f, i2);
    }

    public boolean b() {
        return this.f49084e % 180 != 0;
    }

    private Bitmap a(Rect rect, int i2) {
        if (b()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f49080a, this.f49083d, this.f49081b, this.f49082c, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i2;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f49084e == 0) {
            return bitmapDecodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f49084e);
        return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
    }

    public static byte[] b(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[i4];
        int i5 = i4 - 1;
        for (int i6 = 0; i6 < i2; i6++) {
            for (int i7 = i3 - 1; i7 >= 0; i7--) {
                bArr2[i5] = bArr[(i7 * i2) + i6];
                i5--;
            }
        }
        return bArr2;
    }

    public PlanarYUVLuminanceSource a() {
        byte[] bArrA = a(this.f49084e, this.f49080a, this.f49081b, this.f49082c);
        if (b()) {
            int i2 = this.f49082c;
            int i3 = this.f49081b;
            Rect rect = this.f49085f;
            return new PlanarYUVLuminanceSource(bArrA, i2, i3, rect.left, rect.top, rect.width(), this.f49085f.height(), false);
        }
        int i4 = this.f49081b;
        int i5 = this.f49082c;
        Rect rect2 = this.f49085f;
        return new PlanarYUVLuminanceSource(bArrA, i4, i5, rect2.left, rect2.top, rect2.width(), this.f49085f.height(), false);
    }

    public void a(Rect rect) {
        this.f49085f = rect;
    }

    public static byte[] a(int i2, byte[] bArr, int i3, int i4) {
        return i2 != 90 ? i2 != 180 ? i2 != 270 ? bArr : b(bArr, i3, i4) : a(bArr, i3, i4) : c(bArr, i3, i4);
    }

    public static byte[] a(byte[] bArr, int i2, int i3) {
        int i4 = i2 * i3;
        byte[] bArr2 = new byte[i4];
        int i5 = i4 - 1;
        for (int i6 = 0; i6 < i4; i6++) {
            bArr2[i5] = bArr[i6];
            i5--;
        }
        return bArr2;
    }
}
