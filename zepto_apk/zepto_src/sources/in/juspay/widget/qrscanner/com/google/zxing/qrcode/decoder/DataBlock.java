package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes4.dex */
final class DataBlock {

    /* renamed from: a, reason: collision with root package name */
    private final int f48924a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f48925b;

    private DataBlock(int i2, byte[] bArr) {
        this.f48924a = i2;
        this.f48925b = bArr;
    }

    public byte[] a() {
        return this.f48925b;
    }

    public int b() {
        return this.f48924a;
    }

    public static DataBlock[] a(byte[] bArr, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        if (bArr.length != version.getTotalCodewords()) {
            throw new IllegalArgumentException();
        }
        Version.ECBlocks eCBlocksForLevel = version.getECBlocksForLevel(errorCorrectionLevel);
        Version.ECB[] eCBlocks = eCBlocksForLevel.getECBlocks();
        int count = 0;
        for (Version.ECB ecb : eCBlocks) {
            count += ecb.getCount();
        }
        DataBlock[] dataBlockArr = new DataBlock[count];
        int i2 = 0;
        for (Version.ECB ecb2 : eCBlocks) {
            int i3 = 0;
            while (i3 < ecb2.getCount()) {
                int dataCodewords = ecb2.getDataCodewords();
                dataBlockArr[i2] = new DataBlock(dataCodewords, new byte[eCBlocksForLevel.getECCodewordsPerBlock() + dataCodewords]);
                i3++;
                i2++;
            }
        }
        int length = dataBlockArr[0].f48925b.length;
        int i4 = count - 1;
        while (i4 >= 0 && dataBlockArr[i4].f48925b.length != length) {
            i4--;
        }
        int i5 = i4 + 1;
        int eCCodewordsPerBlock = length - eCBlocksForLevel.getECCodewordsPerBlock();
        int i6 = 0;
        for (int i7 = 0; i7 < eCCodewordsPerBlock; i7++) {
            int i8 = 0;
            while (i8 < i2) {
                dataBlockArr[i8].f48925b[i7] = bArr[i6];
                i8++;
                i6++;
            }
        }
        int i9 = i5;
        while (i9 < i2) {
            dataBlockArr[i9].f48925b[eCCodewordsPerBlock] = bArr[i6];
            i9++;
            i6++;
        }
        int length2 = dataBlockArr[0].f48925b.length;
        while (eCCodewordsPerBlock < length2) {
            int i10 = 0;
            while (i10 < i2) {
                dataBlockArr[i10].f48925b[i10 < i5 ? eCCodewordsPerBlock : eCCodewordsPerBlock + 1] = bArr[i6];
                i10++;
                i6++;
            }
            eCCodewordsPerBlock++;
        }
        return dataBlockArr;
    }
}
