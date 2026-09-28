package in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder;

import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Mode;
import in.juspay.widget.qrscanner.com.google.zxing.qrcode.decoder.Version;

/* loaded from: classes4.dex */
public final class QRCode {
    public static final int NUM_MASK_PATTERNS = 8;

    /* renamed from: a, reason: collision with root package name */
    private Mode f48984a;

    /* renamed from: b, reason: collision with root package name */
    private ErrorCorrectionLevel f48985b;

    /* renamed from: c, reason: collision with root package name */
    private Version f48986c;

    /* renamed from: d, reason: collision with root package name */
    private int f48987d = -1;

    /* renamed from: e, reason: collision with root package name */
    private ByteMatrix f48988e;

    public static boolean isValidMaskPattern(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public ErrorCorrectionLevel getECLevel() {
        return this.f48985b;
    }

    public int getMaskPattern() {
        return this.f48987d;
    }

    public ByteMatrix getMatrix() {
        return this.f48988e;
    }

    public Mode getMode() {
        return this.f48984a;
    }

    public Version getVersion() {
        return this.f48986c;
    }

    public void setECLevel(ErrorCorrectionLevel errorCorrectionLevel) {
        this.f48985b = errorCorrectionLevel;
    }

    public void setMaskPattern(int i2) {
        this.f48987d = i2;
    }

    public void setMatrix(ByteMatrix byteMatrix) {
        this.f48988e = byteMatrix;
    }

    public void setMode(Mode mode) {
        this.f48984a = mode;
    }

    public void setVersion(Version version) {
        this.f48986c = version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n mode: ");
        sb.append(this.f48984a);
        sb.append("\n ecLevel: ");
        sb.append(this.f48985b);
        sb.append("\n version: ");
        sb.append(this.f48986c);
        sb.append("\n maskPattern: ");
        sb.append(this.f48987d);
        if (this.f48988e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f48988e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
