package in.juspay.widget.qrscanner.com.google.zxing.qrcode.detector;

import in.juspay.widget.qrscanner.com.google.zxing.ResultPoint;

/* loaded from: classes4.dex */
public final class FinderPattern extends ResultPoint {

    /* renamed from: c, reason: collision with root package name */
    private final float f48962c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48963d;

    public FinderPattern(float f2, float f3, float f4) {
        this(f2, f3, f4, 1);
    }

    public boolean a(float f2, float f3, float f4) {
        if (Math.abs(f3 - getY()) > f2 || Math.abs(f4 - getX()) > f2) {
            return false;
        }
        float fAbs = Math.abs(f2 - this.f48962c);
        return fAbs <= 1.0f || fAbs <= this.f48962c;
    }

    public FinderPattern b(float f2, float f3, float f4) {
        int i2 = this.f48963d;
        int i3 = i2 + 1;
        float x = (getX() * i2) + f3;
        float f5 = i3;
        return new FinderPattern(x / f5, ((getY() * this.f48963d) + f2) / f5, ((this.f48963d * this.f48962c) + f4) / f5, i3);
    }

    public int getCount() {
        return this.f48963d;
    }

    public float getEstimatedModuleSize() {
        return this.f48962c;
    }

    private FinderPattern(float f2, float f3, float f4, int i2) {
        super(f2, f3);
        this.f48962c = f4;
        this.f48963d = i2;
    }
}
