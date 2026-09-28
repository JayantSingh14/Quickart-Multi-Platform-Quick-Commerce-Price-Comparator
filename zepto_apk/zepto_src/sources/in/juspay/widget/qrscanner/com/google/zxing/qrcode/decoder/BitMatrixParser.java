package in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder;

import in.juspay.widget.qrscanner.com.google.zxing.FormatException;
import in.juspay.widget.qrscanner.com.google.zxing.common.BitMatrix;

/* loaded from: classes4.dex */
final class BitMatrixParser {

    /* renamed from: a, reason: collision with root package name */
    private final BitMatrix f48920a;

    /* renamed from: b, reason: collision with root package name */
    private Version f48921b;

    /* renamed from: c, reason: collision with root package name */
    private FormatInformation f48922c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f48923d;

    public BitMatrixParser(BitMatrix bitMatrix) throws FormatException {
        int height = bitMatrix.getHeight();
        if (height < 21 || (height & 3) != 1) {
            throw FormatException.getFormatInstance();
        }
        this.f48920a = bitMatrix;
    }

    private int a(int i2, int i3, int i4) {
        return this.f48923d ? this.f48920a.get(i3, i2) : this.f48920a.get(i2, i3) ? (i4 << 1) | 1 : i4 << 1;
    }

    public byte[] b() throws FormatException {
        FormatInformation formatInformationC = c();
        Version versionD = d();
        DataMask dataMask = DataMask.values()[formatInformationC.a()];
        int height = this.f48920a.getHeight();
        dataMask.a(this.f48920a, height);
        BitMatrix bitMatrixA = versionD.a();
        byte[] bArr = new byte[versionD.getTotalCodewords()];
        int i2 = height - 1;
        boolean z = true;
        int i3 = i2;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 > 0) {
            if (i3 == 6) {
                i3--;
            }
            for (int i7 = 0; i7 < height; i7++) {
                int i8 = z ? i2 - i7 : i7;
                for (int i9 = 0; i9 < 2; i9++) {
                    int i10 = i3 - i9;
                    if (!bitMatrixA.get(i10, i8)) {
                        i6++;
                        i5 <<= 1;
                        if (this.f48920a.get(i10, i8)) {
                            i5 |= 1;
                        }
                        if (i6 == 8) {
                            bArr[i4] = (byte) i5;
                            i4++;
                            i5 = 0;
                            i6 = 0;
                        }
                    }
                }
            }
            z = !z;
            i3 -= 2;
        }
        if (i4 == versionD.getTotalCodewords()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public FormatInformation c() throws FormatException {
        FormatInformation formatInformation = this.f48922c;
        if (formatInformation != null) {
            return formatInformation;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            iA2 = a(i2, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i3 = 5; i3 >= 0; i3--) {
            iA3 = a(8, i3, iA3);
        }
        int height = this.f48920a.getHeight();
        int i4 = height - 7;
        for (int i5 = height - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = height - 8; i6 < height; i6++) {
            iA = a(i6, 8, iA);
        }
        FormatInformation formatInformationA = FormatInformation.a(iA3, iA);
        this.f48922c = formatInformationA;
        if (formatInformationA != null) {
            return formatInformationA;
        }
        throw FormatException.getFormatInstance();
    }

    public Version d() throws FormatException {
        Version version = this.f48921b;
        if (version != null) {
            return version;
        }
        int height = this.f48920a.getHeight();
        int i2 = (height - 17) / 4;
        if (i2 <= 6) {
            return Version.getVersionForNumber(i2);
        }
        int i3 = height - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = height - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        Version versionA = Version.a(iA2);
        if (versionA != null && versionA.getDimensionForVersion() == height) {
            this.f48921b = versionA;
            return versionA;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = height - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        Version versionA2 = Version.a(iA);
        if (versionA2 == null || versionA2.getDimensionForVersion() != height) {
            throw FormatException.getFormatInstance();
        }
        this.f48921b = versionA2;
        return versionA2;
    }

    public void e() {
        if (this.f48922c == null) {
            return;
        }
        DataMask.values()[this.f48922c.a()].a(this.f48920a, this.f48920a.getHeight());
    }

    public void a() {
        int i2 = 0;
        while (i2 < this.f48920a.getWidth()) {
            int i3 = i2 + 1;
            for (int i4 = i3; i4 < this.f48920a.getHeight(); i4++) {
                if (this.f48920a.get(i2, i4) != this.f48920a.get(i4, i2)) {
                    this.f48920a.flip(i4, i2);
                    this.f48920a.flip(i2, i4);
                }
            }
            i2 = i3;
        }
    }

    public void a(boolean z) {
        this.f48921b = null;
        this.f48922c = null;
        this.f48923d = z;
    }
}
