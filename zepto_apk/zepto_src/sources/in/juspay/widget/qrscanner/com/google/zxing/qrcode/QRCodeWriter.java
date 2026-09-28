package in.juspay.widget.qrscanner.com.google.zxing.qrcode;

import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.Writer;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.ByteMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.Encoder;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

/* loaded from: classes4.dex */
public final class QRCodeWriter implements Writer {
    private static BitMatrix a(QRCode qRCode, int i2, int i3, int i4) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix == null) {
            throw new IllegalStateException();
        }
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int i5 = i4 * 2;
        int i6 = width + i5;
        int i7 = i5 + height;
        int iMax = Math.max(i2, i6);
        int iMax2 = Math.max(i3, i7);
        int iMin = Math.min(iMax / i6, iMax2 / i7);
        int i8 = (iMax - (width * iMin)) / 2;
        int i9 = (iMax2 - (height * iMin)) / 2;
        BitMatrix bitMatrix = new BitMatrix(iMax, iMax2);
        int i10 = 0;
        while (i10 < height) {
            int i11 = 0;
            int i12 = i8;
            while (i11 < width) {
                if (matrix.get(i11, i10) == 1) {
                    bitMatrix.setRegion(i12, i9, iMin, iMin);
                }
                i11++;
                i12 += iMin;
            }
            i10++;
            i9 += iMin;
        }
        return bitMatrix;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3) {
        return encode(str, barcodeFormat, i2, i3, null);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Writer
    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got " + barcodeFormat);
        }
        if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i2 + 'x' + i3);
        }
        ErrorCorrectionLevel errorCorrectionLevelValueOf = ErrorCorrectionLevel.L;
        int i4 = 4;
        if (map != null) {
            EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
            if (map.containsKey(encodeHintType)) {
                errorCorrectionLevelValueOf = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
            }
            EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
            if (map.containsKey(encodeHintType2)) {
                i4 = Integer.parseInt(map.get(encodeHintType2).toString());
            }
        }
        return a(Encoder.encode(str, errorCorrectionLevelValueOf, map), i2, i3, i4);
    }
}
