package in.juspay.widget.qrscanner.com.google.zxing.qrcode.encoder;

/* loaded from: classes4.dex */
final class BlockPair {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f48973a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f48974b;

    public BlockPair(byte[] bArr, byte[] bArr2) {
        this.f48973a = bArr;
        this.f48974b = bArr2;
    }

    public byte[] getDataBytes() {
        return this.f48973a;
    }

    public byte[] getErrorCorrectionBytes() {
        return this.f48974b;
    }
}
