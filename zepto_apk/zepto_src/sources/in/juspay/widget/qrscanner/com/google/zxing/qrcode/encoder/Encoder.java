package in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import in.juspay.widget.qrscanner.com.google.zxing.WriterException;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitArray;
import in.juspay.widget.qrscanner.com.google.zxing.common.CharacterSetECI;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.GenericGF;
import in.juspay.widget.qrscanner.com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class Encoder {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f48978a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f48979a;

        static {
            int[] iArr = new int[Mode.values().length];
            f48979a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f48979a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f48979a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f48979a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    public static int a(int i2) {
        int[] iArr = f48978a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public static void b(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iCharAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                bitArray.appendBits(((charSequence.charAt(i2 + 1) - '0') * 10) + (iCharAt * 100) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    bitArray.appendBits((iCharAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    bitArray.appendBits(iCharAt, 4);
                }
            }
        }
    }

    public static Mode chooseMode(String str) {
        return a(str, (String) null);
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) {
        return encode(str, errorCorrectionLevel, null);
    }

    private static int a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i2 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            MatrixUtil.a(bitArray, errorCorrectionLevel, version, i4, byteMatrix);
            int iA = a(byteMatrix);
            if (iA < i2) {
                i3 = i4;
                i2 = iA;
            }
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String r6, in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r7, java.util.Map<in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType, ?> r8) throws in.juspay.widget.qrscanner.com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        /*
            if (r8 == 0) goto Lc
            in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType r0 = in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            java.lang.String r1 = "ISO-8859-1"
            if (r0 == 0) goto L1c
            in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType r2 = in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r2 = r8.get(r2)
            java.lang.String r2 = r2.toString()
            goto L1d
        L1c:
            r2 = r1
        L1d:
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode r3 = a(r6, r2)
            in.juspay.widget.qrscanner.com.google.zxing.common.BitArray r4 = new in.juspay.widget.qrscanner.com.google.zxing.common.BitArray
            r4.<init>()
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode r5 = in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r3 != r5) goto L3b
            if (r0 != 0) goto L32
            boolean r0 = r1.equals(r2)
            if (r0 != 0) goto L3b
        L32:
            in.juspay.widget.qrscanner.com.google.zxing.common.CharacterSetECI r0 = in.juspay.widget.qrscanner.com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r2)
            if (r0 == 0) goto L3b
            a(r0, r4)
        L3b:
            if (r8 == 0) goto L5c
            in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType r0 = in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r1 = r8.containsKey(r0)
            if (r1 == 0) goto L5c
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5c
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode r0 = in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            a(r0, r4)
        L5c:
            a(r3, r4)
            in.juspay.widget.qrscanner.com.google.zxing.common.BitArray r0 = new in.juspay.widget.qrscanner.com.google.zxing.common.BitArray
            r0.<init>()
            a(r6, r3, r0, r2)
            if (r8 == 0) goto L94
            in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType r1 = in.juspay.widget.qrscanner.com.google.zxing.EncodeHintType.QR_VERSION
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L94
            java.lang.Object r8 = r8.get(r1)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version r8 = in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r8)
            int r1 = a(r3, r4, r0, r8)
            boolean r1 = a(r1, r8, r7)
            if (r1 == 0) goto L8c
            goto L98
        L8c:
            in.juspay.widget.qrscanner.com.google.zxing.WriterException r6 = new in.juspay.widget.qrscanner.com.google.zxing.WriterException
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L94:
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version r8 = a(r7, r3, r4, r0)
        L98:
            in.juspay.widget.qrscanner.com.google.zxing.common.BitArray r1 = new in.juspay.widget.qrscanner.com.google.zxing.common.BitArray
            r1.<init>()
            r1.appendBitArray(r4)
            if (r3 != r5) goto La7
            int r6 = r0.getSizeInBytes()
            goto Lab
        La7:
            int r6 = r6.length()
        Lab:
            a(r6, r8, r3, r1)
            r1.appendBitArray(r0)
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version$ECBlocks r6 = r8.getECBlocksForLevel(r7)
            int r0 = r8.getTotalCodewords()
            int r2 = r6.getTotalECCodewords()
            int r0 = r0 - r2
            a(r0, r1)
            int r2 = r8.getTotalCodewords()
            int r6 = r6.getNumBlocks()
            in.juspay.widget.qrscanner.com.google.zxing.common.BitArray r6 = a(r1, r2, r0, r6)
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.QRCode r0 = new in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.QRCode
            r0.<init>()
            r0.setECLevel(r7)
            r0.setMode(r3)
            r0.setVersion(r8)
            int r1 = r8.getDimensionForVersion()
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.ByteMatrix r2 = new in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.ByteMatrix
            r2.<init>(r1, r1)
            int r1 = a(r6, r7, r8, r2)
            r0.setMaskPattern(r1)
            in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.MatrixUtil.a(r6, r7, r8, r1, r2)
            r0.setMatrix(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.Encoder.encode(java.lang.String, in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder.QRCode");
    }

    private static int a(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray2.getSize() + mode.getCharacterCountBits(version) + bitArray.getSize();
    }

    private static int a(ByteMatrix byteMatrix) {
        return MaskUtil.a(byteMatrix) + MaskUtil.b(byteMatrix) + MaskUtil.c(byteMatrix) + MaskUtil.d(byteMatrix);
    }

    public static BitArray a(BitArray bitArray, int i2, int i3, int i4) throws WriterException {
        if (bitArray.getSizeInBytes() != i3) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i4);
        int i5 = 0;
        int i6 = 0;
        int iMax = 0;
        int iMax2 = 0;
        while (i5 < i4) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            int i7 = i2;
            int i8 = i3;
            int i9 = i4;
            a(i7, i8, i9, i5, iArr, iArr2);
            int i10 = iArr[0];
            byte[] bArr = new byte[i10];
            bitArray.toBytes(i6 * 8, bArr, 0, i10);
            byte[] bArrA = a(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, bArrA));
            iMax2 = Math.max(iMax2, i10);
            iMax = Math.max(iMax, bArrA.length);
            i6 += iArr[0];
            i5++;
            i2 = i7;
            i3 = i8;
            i4 = i9;
        }
        int i11 = i2;
        if (i3 != i6) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i12 = 0; i12 < iMax2; i12++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((BlockPair) it.next()).getDataBytes();
                if (i12 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i12], 8);
                }
            }
        }
        for (int i13 = 0; i13 < iMax; i13++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i13 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i13], 8);
                }
            }
        }
        if (i11 == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        StringBuilder sbU = b.u(i11, "Interleaving error: ", " and ");
        sbU.append(bitArray2.getSizeInBytes());
        sbU.append(" differ.");
        throw new WriterException(sbU.toString());
    }

    private static Mode a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (a(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        return z ? Mode.ALPHANUMERIC : z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    private static Version a(int i2, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            Version versionForNumber = Version.getVersionForNumber(i3);
            if (a(i2, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    private static Version a(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) {
        return a(a(mode, bitArray, bitArray2, a(a(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void a(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 >= i4) {
            throw new WriterException("Block ID too large");
        }
        int i6 = i2 % i4;
        int i7 = i4 - i6;
        int i8 = i2 / i4;
        int i9 = i8 + 1;
        int i10 = i3 / i4;
        int i11 = i10 + 1;
        int i12 = i8 - i10;
        int i13 = i9 - i11;
        if (i12 != i13) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i4 != i7 + i6) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i2 != ((i11 + i13) * i6) + ((i10 + i12) * i7)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i5 < i7) {
            iArr[0] = i10;
            iArr2[0] = i12;
        } else {
            iArr[0] = i11;
            iArr2[0] = i13;
        }
    }

    public static void a(int i2, BitArray bitArray) throws WriterException {
        int i3 = i2 * 8;
        if (bitArray.getSize() > i3) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i3);
        }
        for (int i4 = 0; i4 < 4 && bitArray.getSize() < i3; i4++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i2 - bitArray.getSizeInBytes();
        for (int i5 = 0; i5 < sizeInBytes; i5++) {
            bitArray.appendBits((i5 & 1) == 0 ? 236 : 17, 8);
        }
        if (bitArray.getSize() != i3) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    public static void a(int i2, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i3 = 1 << characterCountBits;
        if (i2 < i3) {
            bitArray.appendBits(i2, characterCountBits);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    private static void a(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    public static void a(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void a(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int iA = a(charSequence.charAt(i2));
            if (iA == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int iA2 = a(charSequence.charAt(i3));
                if (iA2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((iA * 45) + iA2, 11);
                i2 += 2;
            } else {
                bitArray.appendBits(iA, 6);
                i2 = i3;
            }
        }
    }

    public static void a(String str, BitArray bitArray) throws WriterException, UnsupportedEncodingException {
        int i2;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i3 = 0; i3 < length; i3 += 2) {
                int i4 = ((bytes[i3] & 255) << 8) | (bytes[i3 + 1] & 255);
                int i5 = 33088;
                if (i4 >= 33088 && i4 <= 40956) {
                    i2 = i4 - i5;
                } else if (i4 < 57408 || i4 > 60351) {
                    i2 = -1;
                } else {
                    i5 = 49472;
                    i2 = i4 - i5;
                }
                if (i2 == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.appendBits(((i2 >> 8) * 192) + (i2 & 255), 13);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    public static void a(String str, BitArray bitArray, String str2) throws WriterException, UnsupportedEncodingException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                bitArray.appendBits(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    public static void a(String str, Mode mode, BitArray bitArray, String str2) throws WriterException, UnsupportedEncodingException {
        int i2 = AnonymousClass1.f48979a[mode.ordinal()];
        if (i2 == 1) {
            b(str, bitArray);
            return;
        }
        if (i2 == 2) {
            a((CharSequence) str, bitArray);
            return;
        }
        if (i2 == 3) {
            a(str, bitArray, str2);
        } else if (i2 == 4) {
            a(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static boolean a(int i2, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i2 + 7) / 8;
    }

    private static boolean a(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }
}
