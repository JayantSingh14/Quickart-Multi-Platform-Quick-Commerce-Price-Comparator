package in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector;

import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;

/* loaded from: classes4.dex */
public final class AlignmentPattern extends ResultPoint {

    /* renamed from: c, reason: collision with root package name */
    private final float f48950c;

    public AlignmentPattern(float f2, float f3, float f4) {
        super(f2, f3);
        this.f48950c = f4;
    }

    public boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - getY()) > f2 || Math.abs(f4 - getX()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f48950c);
        return fAbs <= 1.0f || fAbs <= this.f48950c;
    }

    public AlignmentPattern b(float f2, float f3, float f4) {
        return new AlignmentPattern((getX() + f3) / 2.0f, (getY() + f2) / 2.0f, (this.f48950c + f4) / 2.0f);
    }
}
