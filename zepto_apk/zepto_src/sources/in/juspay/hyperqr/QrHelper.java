package in.juspay.hyperqr;

import android.graphics.Bitmap;
import androidx.annotation.Keep;
import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.QRCodeWriter;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class QrHelper {
    @Keep
    public static Bitmap getBitMapFromBitMatrix(int i2, int i3, int i4, BitMatrix bitMatrix) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.RGB_565);
        for (int i5 = 0; i5 < i2; i5++) {
            for (int i6 = 0; i6 < i3; i6++) {
                bitmapCreateBitmap.setPixel(i5, i6, bitMatrix.get(i5, i6) ? i4 : -1);
            }
        }
        return bitmapCreateBitmap;
    }

    @Keep
    public static Bitmap getQrBitMap(String str, int i2, int i3) {
        HashMap map = new HashMap();
        map.put(EncodeHintType.MARGIN, Integer.valueOf(i3));
        BitMatrix bitMatrixEncode = new QRCodeWriter().encode(str, BarcodeFormat.QR_CODE, i2, i2, map);
        return getBitMapFromBitMatrix(bitMatrixEncode.getWidth(), bitMatrixEncode.getHeight(), -16777216, bitMatrixEncode);
    }
}
