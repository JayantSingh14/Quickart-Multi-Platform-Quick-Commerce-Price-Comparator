package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

import in.juspay.widget.qrscanner.com.google.zxing.ChecksumException;
import in.juspay.widget.qrscanner.com.google.zxing.DecodeHintType;
import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;
import in.juspay.widget.qrscanner.com.google.zxing.common.DecoderResult;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.GenericGF;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.ReedSolomonDecoder;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.ReedSolomonException;
import java.util.Map;

/* loaded from: classes4.dex */
public final class Decoder {

    /* renamed from: a, reason: collision with root package name */
    private final ReedSolomonDecoder f48929a = new ReedSolomonDecoder(GenericGF.QR_CODE_FIELD_256);

    private DecoderResult a(BitMatrixParser bitMatrixParser, Map<DecodeHintType, ?> map) throws FormatException, ChecksumException {
        Version versionD = bitMatrixParser.d();
        ErrorCorrectionLevel errorCorrectionLevelB = bitMatrixParser.c().b();
        DataBlock[] dataBlockArrA = DataBlock.a(bitMatrixParser.b(), versionD, errorCorrectionLevelB);
        int iB = 0;
        for (DataBlock dataBlock : dataBlockArrA) {
            iB += dataBlock.b();
        }
        byte[] bArr = new byte[iB];
        int i2 = 0;
        for (DataBlock dataBlock2 : dataBlockArrA) {
            byte[] bArrA = dataBlock2.a();
            int iB2 = dataBlock2.b();
            a(bArrA, iB2);
            int i3 = 0;
            while (i3 < iB2) {
                bArr[i2] = bArrA[i3];
                i3++;
                i2++;
            }
        }
        return DecodedBitStreamParser.a(bArr, versionD, errorCorrectionLevelB, map);
    }

    public DecoderResult decode(BitMatrix bitMatrix) {
        return decode(bitMatrix, (Map<DecodeHintType, ?>) null);
    }

    private void a(byte[] bArr, int i2) throws ChecksumException {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        try {
            this.f48929a.decode(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (ReedSolomonException unused) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    public DecoderResult decode(BitMatrix bitMatrix, Map<DecodeHintType, ?> map) {
        ChecksumException e2;
        BitMatrixParser bitMatrixParser = new BitMatrixParser(bitMatrix);
        FormatException formatException = null;
        try {
            return a(bitMatrixParser, map);
        } catch (ChecksumException e3) {
            e2 = e3;
            try {
                bitMatrixParser.e();
                bitMatrixParser.a(true);
                bitMatrixParser.d();
                bitMatrixParser.c();
                bitMatrixParser.a();
                DecoderResult decoderResultA = a(bitMatrixParser, map);
                decoderResultA.setOther(new QRCodeDecoderMetaData(true));
                return decoderResultA;
            } catch (ChecksumException | FormatException e4) {
                if (formatException != null) {
                    throw formatException;
                }
                if (e2 != null) {
                    throw e2;
                }
                throw e4;
            }
        } catch (FormatException e5) {
            e2 = null;
            formatException = e5;
            bitMatrixParser.e();
            bitMatrixParser.a(true);
            bitMatrixParser.d();
            bitMatrixParser.c();
            bitMatrixParser.a();
            DecoderResult decoderResultA2 = a(bitMatrixParser, map);
            decoderResultA2.setOther(new QRCodeDecoderMetaData(true));
            return decoderResultA2;
        }
    }

    public DecoderResult decode(boolean[][] zArr) {
        return decode(zArr, (Map<DecodeHintType, ?>) null);
    }

    public DecoderResult decode(boolean[][] zArr, Map<DecodeHintType, ?> map) {
        return decode(BitMatrix.parse(zArr), map);
    }
}
