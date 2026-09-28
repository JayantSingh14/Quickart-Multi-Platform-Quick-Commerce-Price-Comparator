package in.juspay.widget.qrscanner.com.google.zxing.qrcode;

import in.juspay.widget.qrscanner.com.google.zxing.BarcodeFormat;
import in.juspay.widget.qrscanner.com.google.zxing.BinaryBitmap;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.NotFoundException;
import in.juspay.widget.qrscanner.com.google.zxing.Reader;
import in.juspay.widget.qrscanner.com.google.zxing.Result;
import in.juspay.widget.qrscanner.com.google.zxing.ResultMetadataType;
import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.common.DecoderResult;
import in.juspay.widget.qrscanner.com.google.zxing.common.DetectorResult;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Decoder;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.QRCodeDecoderMetaData;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector.Detector;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class QRCodeReader implements Reader {

    /* renamed from: b, reason: collision with root package name */
    private static final ResultPoint[] f48918b = new ResultPoint[0];

    /* renamed from: a, reason: collision with root package name */
    private final Decoder f48919a = new Decoder();

    private static float a(int[] iArr, BitMatrix bitMatrix) throws NotFoundException {
        int height = bitMatrix.getHeight();
        int width = bitMatrix.getWidth();
        int i2 = iArr[0];
        boolean z = true;
        int i3 = iArr[1];
        int i4 = 0;
        while (i2 < width && i3 < height) {
            if (z != bitMatrix.get(i2, i3)) {
                i4++;
                if (i4 == 5) {
                    break;
                }
                z = !z;
            }
            i2++;
            i3++;
        }
        if (i2 == width || i3 == height) {
            throw NotFoundException.getNotFoundInstance();
        }
        return (i2 - iArr[0]) / 7.0f;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Reader
    public Result decode(BinaryBitmap binaryBitmap) {
        return decode(binaryBitmap, null);
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Reader
    public void reset() {
    }

    private static BitMatrix a(BitMatrix bitMatrix) throws NotFoundException {
        int[] topLeftOnBit = bitMatrix.getTopLeftOnBit();
        int[] bottomRightOnBit = bitMatrix.getBottomRightOnBit();
        if (topLeftOnBit == null || bottomRightOnBit == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        float fA = a(topLeftOnBit, bitMatrix);
        int i2 = topLeftOnBit[1];
        int i3 = bottomRightOnBit[1];
        int i4 = topLeftOnBit[0];
        int i5 = bottomRightOnBit[0];
        if (i4 >= i5 || i2 >= i3) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i6 = i3 - i2;
        if (i6 != i5 - i4 && (i5 = i4 + i6) >= bitMatrix.getWidth()) {
            throw NotFoundException.getNotFoundInstance();
        }
        int iRound = Math.round(((i5 - i4) + 1) / fA);
        int iRound2 = Math.round((i6 + 1) / fA);
        if (iRound <= 0 || iRound2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (iRound2 != iRound) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i7 = (int) (fA / 2.0f);
        int i8 = i2 + i7;
        int i9 = i4 + i7;
        int i10 = (((int) ((iRound - 1) * fA)) + i9) - i5;
        if (i10 > 0) {
            if (i10 > i7) {
                throw NotFoundException.getNotFoundInstance();
            }
            i9 -= i10;
        }
        int i11 = (((int) ((iRound2 - 1) * fA)) + i8) - i3;
        if (i11 > 0) {
            if (i11 > i7) {
                throw NotFoundException.getNotFoundInstance();
            }
            i8 -= i11;
        }
        BitMatrix bitMatrix2 = new BitMatrix(iRound, iRound2);
        for (int i12 = 0; i12 < iRound2; i12++) {
            int i13 = ((int) (i12 * fA)) + i8;
            for (int i14 = 0; i14 < iRound; i14++) {
                if (bitMatrix.get(((int) (i14 * fA)) + i9, i13)) {
                    bitMatrix2.set(i14, i12);
                }
            }
        }
        return bitMatrix2;
    }

    @Override // in.juspay.widget.qrscanner.com.google.zxing.Reader
    public final Result decode(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ResultPoint[] points;
        DecoderResult decoderResultDecode;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            DetectorResult detectorResultDetect = new Detector(binaryBitmap.getBlackMatrix()).detect(map);
            DecoderResult decoderResultDecode2 = this.f48919a.decode(detectorResultDetect.getBits(), map);
            points = detectorResultDetect.getPoints();
            decoderResultDecode = decoderResultDecode2;
        } else {
            decoderResultDecode = this.f48919a.decode(a(binaryBitmap.getBlackMatrix()), map);
            points = f48918b;
        }
        if (decoderResultDecode.getOther() instanceof QRCodeDecoderMetaData) {
            ((QRCodeDecoderMetaData) decoderResultDecode.getOther()).applyMirroredCorrection(points);
        }
        Result result = new Result(decoderResultDecode.getText(), decoderResultDecode.getRawBytes(), points, BarcodeFormat.QR_CODE);
        List<byte[]> byteSegments = decoderResultDecode.getByteSegments();
        if (byteSegments != null) {
            result.putMetadata(ResultMetadataType.BYTE_SEGMENTS, byteSegments);
        }
        String eCLevel = decoderResultDecode.getECLevel();
        if (eCLevel != null) {
            result.putMetadata(ResultMetadataType.ERROR_CORRECTION_LEVEL, eCLevel);
        }
        if (decoderResultDecode.hasStructuredAppend()) {
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(decoderResultDecode.getStructuredAppendSequenceNumber()));
            result.putMetadata(ResultMetadataType.STRUCTURED_APPEND_PARITY, Integer.valueOf(decoderResultDecode.getStructuredAppendParity()));
        }
        result.putMetadata(ResultMetadataType.SYMBOLOGY_IDENTIFIER, "]Q" + decoderResultDecode.getSymbologyModifier());
        return result;
    }
}
