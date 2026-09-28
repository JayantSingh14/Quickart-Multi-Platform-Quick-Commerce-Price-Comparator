package in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder;

import in.juspay.widget.qrscanner.com.google.zxing.WriterException;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitArray;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes4.dex */
final class MatrixUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final int[][] f48980a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    /* renamed from: b, reason: collision with root package name */
    private static final int[][] f48981b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    /* renamed from: c, reason: collision with root package name */
    private static final int[][] f48982c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, Type.L64, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, WKSRecord.Service.CISCO_FNA, -1}, new int[]{6, 30, 56, 82, Type.EUI48, WKSRecord.Service.INGRES_NET, -1}, new int[]{6, 34, 60, 86, 112, WKSRecord.Service.NETBIOS_DGM, -1}, new int[]{6, 30, 58, 86, 114, WKSRecord.Service.BL_IDM, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, Type.L64, WKSRecord.Service.CISCO_SYS, 158}, new int[]{6, 32, 58, 84, 110, WKSRecord.Service.PROFILE, 162}, new int[]{6, 26, 54, 82, 110, WKSRecord.Service.NETBIOS_DGM, 166}, new int[]{6, 30, 58, 86, 114, WKSRecord.Service.BL_IDM, 170}};

    /* renamed from: d, reason: collision with root package name */
    private static final int[][] f48983d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private MatrixUtil() {
    }

    public static int a(int i2) {
        return 32 - Integer.numberOfLeadingZeros(i2);
    }

    private static void b(int i2, int i3, ByteMatrix byteMatrix) {
        for (int i4 = 0; i4 < 5; i4++) {
            int[] iArr = f48981b[i4];
            for (int i5 = 0; i5 < 5; i5++) {
                byteMatrix.set(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void c(int i2, int i3, ByteMatrix byteMatrix) {
        for (int i4 = 0; i4 < 7; i4++) {
            int[] iArr = f48980a[i4];
            for (int i5 = 0; i5 < 7; i5++) {
                byteMatrix.set(i2 + i5, i3 + i4, iArr[i5]);
            }
        }
    }

    private static void d(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        for (int i4 = 0; i4 < 7; i4++) {
            int i5 = i3 + i4;
            if (!b(byteMatrix.get(i2, i5))) {
                throw new WriterException();
            }
            byteMatrix.set(i2, i5, 0);
        }
    }

    public static int a(int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iA = a(i3);
        int iA2 = i2 << (iA - 1);
        while (a(iA2) >= iA) {
            iA2 ^= i3 << (a(iA2) - iA);
        }
        return iA2;
    }

    private static void b(Version version, ByteMatrix byteMatrix) {
        if (version.getVersionNumber() < 2) {
            return;
        }
        int[] iArr = f48982c[version.getVersionNumber() - 1];
        for (int i2 : iArr) {
            if (i2 >= 0) {
                for (int i3 : iArr) {
                    if (i3 >= 0 && b(byteMatrix.get(i3, i2))) {
                        b(i3 - 2, i2 - 2, byteMatrix);
                    }
                }
            }
        }
    }

    public static void c(Version version, ByteMatrix byteMatrix) throws WriterException {
        if (version.getVersionNumber() < 7) {
            return;
        }
        BitArray bitArray = new BitArray();
        a(version, bitArray);
        int i2 = 17;
        for (int i3 = 0; i3 < 6; i3++) {
            for (int i4 = 0; i4 < 3; i4++) {
                boolean z = bitArray.get(i2);
                i2--;
                byteMatrix.set(i3, (byteMatrix.getHeight() - 11) + i4, z);
                byteMatrix.set((byteMatrix.getHeight() - 11) + i4, i3, z);
            }
        }
    }

    /* JADX WARN: Failed to analyze thrown exceptions
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:131)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.checkInsn(MethodThrowsVisitor.java:179)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.processInstructions(MethodThrowsVisitor.java:132)
    	at jadx.core.dex.visitors.MethodThrowsVisitor.visit(MethodThrowsVisitor.java:69)
     */
    private static void d(ByteMatrix byteMatrix) {
        int i2 = 8;
        while (i2 < byteMatrix.getWidth() - 8) {
            int i3 = i2 + 1;
            int i4 = i3 % 2;
            if (b(byteMatrix.get(i2, 6))) {
                byteMatrix.set(i2, 6, i4);
            }
            if (b(byteMatrix.get(6, i2))) {
                byteMatrix.set(6, i2, i4);
            }
            i2 = i3;
        }
    }

    private static void a(int i2, int i3, ByteMatrix byteMatrix) throws WriterException {
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = i2 + i4;
            if (!b(byteMatrix.get(i5, i3))) {
                throw new WriterException();
            }
            byteMatrix.set(i5, i3, 0);
        }
    }

    private static void b(ByteMatrix byteMatrix) throws WriterException {
        if (byteMatrix.get(8, byteMatrix.getHeight() - 8) == 0) {
            throw new WriterException();
        }
        byteMatrix.set(8, byteMatrix.getHeight() - 8, 1);
    }

    private static void c(ByteMatrix byteMatrix) throws WriterException {
        int length = f48980a[0].length;
        c(0, 0, byteMatrix);
        c(byteMatrix.getWidth() - length, 0, byteMatrix);
        c(0, byteMatrix.getWidth() - length, byteMatrix);
        a(0, 7, byteMatrix);
        a(byteMatrix.getWidth() - 8, 7, byteMatrix);
        a(0, byteMatrix.getWidth() - 8, byteMatrix);
        d(7, 0, byteMatrix);
        d(byteMatrix.getHeight() - 8, 0, byteMatrix);
        d(7, byteMatrix.getHeight() - 7, byteMatrix);
    }

    public static void a(BitArray bitArray, int i2, ByteMatrix byteMatrix) throws WriterException {
        boolean z;
        int width = byteMatrix.getWidth() - 1;
        int height = byteMatrix.getHeight() - 1;
        int i3 = 0;
        int i4 = -1;
        while (width > 0) {
            if (width == 6) {
                width--;
            }
            while (height >= 0 && height < byteMatrix.getHeight()) {
                for (int i5 = 0; i5 < 2; i5++) {
                    int i6 = width - i5;
                    if (b(byteMatrix.get(i6, height))) {
                        if (i3 < bitArray.getSize()) {
                            z = bitArray.get(i3);
                            i3++;
                        } else {
                            z = false;
                        }
                        if (i2 != -1 && MaskUtil.a(i2, i6, height)) {
                            z = !z;
                        }
                        byteMatrix.set(i6, height, z);
                    }
                }
                height += i4;
            }
            i4 = -i4;
            height += i4;
            width -= 2;
        }
        if (i3 == bitArray.getSize()) {
            return;
        }
        throw new WriterException("Not all bits consumed: " + i3 + '/' + bitArray.getSize());
    }

    private static boolean b(int i2) {
        return i2 == -1;
    }

    public static void a(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, int i2, ByteMatrix byteMatrix) throws WriterException {
        a(byteMatrix);
        a(version, byteMatrix);
        a(errorCorrectionLevel, i2, byteMatrix);
        c(version, byteMatrix);
        a(bitArray, i2, byteMatrix);
    }

    public static void a(ErrorCorrectionLevel errorCorrectionLevel, int i2, BitArray bitArray) throws WriterException {
        if (!QRCode.isValidMaskPattern(i2)) {
            throw new WriterException("Invalid mask pattern");
        }
        int bits = (errorCorrectionLevel.getBits() << 3) | i2;
        bitArray.appendBits(bits, 5);
        bitArray.appendBits(a(bits, 1335), 10);
        BitArray bitArray2 = new BitArray();
        bitArray2.appendBits(21522, 15);
        bitArray.xor(bitArray2);
        if (bitArray.getSize() == 15) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void a(ErrorCorrectionLevel errorCorrectionLevel, int i2, ByteMatrix byteMatrix) throws WriterException {
        BitArray bitArray = new BitArray();
        a(errorCorrectionLevel, i2, bitArray);
        for (int i3 = 0; i3 < bitArray.getSize(); i3++) {
            boolean z = bitArray.get((bitArray.getSize() - 1) - i3);
            int[] iArr = f48983d[i3];
            byteMatrix.set(iArr[0], iArr[1], z);
            if (i3 < 8) {
                byteMatrix.set((byteMatrix.getWidth() - i3) - 1, 8, z);
            } else {
                byteMatrix.set(8, (i3 - 8) + (byteMatrix.getHeight() - 7), z);
            }
        }
    }

    public static void a(Version version, BitArray bitArray) throws WriterException {
        bitArray.appendBits(version.getVersionNumber(), 6);
        bitArray.appendBits(a(version.getVersionNumber(), 7973), 12);
        if (bitArray.getSize() == 18) {
            return;
        }
        throw new WriterException("should not happen but we got: " + bitArray.getSize());
    }

    public static void a(Version version, ByteMatrix byteMatrix) throws WriterException {
        c(byteMatrix);
        b(byteMatrix);
        b(version, byteMatrix);
        d(byteMatrix);
    }

    public static void a(ByteMatrix byteMatrix) {
        byteMatrix.clear((byte) -1);
    }
}
