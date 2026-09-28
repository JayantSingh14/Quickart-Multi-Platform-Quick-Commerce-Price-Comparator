package in.juspay.widget.qrscanner.com.google.zxing.common;

/* loaded from: classes4.dex */
public final class PerspectiveTransform {

    /* renamed from: a, reason: collision with root package name */
    private final float f48895a;

    /* renamed from: b, reason: collision with root package name */
    private final float f48896b;

    /* renamed from: c, reason: collision with root package name */
    private final float f48897c;

    /* renamed from: d, reason: collision with root package name */
    private final float f48898d;

    /* renamed from: e, reason: collision with root package name */
    private final float f48899e;

    /* renamed from: f, reason: collision with root package name */
    private final float f48900f;

    /* renamed from: g, reason: collision with root package name */
    private final float f48901g;

    /* renamed from: h, reason: collision with root package name */
    private final float f48902h;

    /* renamed from: i, reason: collision with root package name */
    private final float f48903i;

    private PerspectiveTransform(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        this.f48895a = f2;
        this.f48896b = f5;
        this.f48897c = f8;
        this.f48898d = f3;
        this.f48899e = f6;
        this.f48900f = f9;
        this.f48901g = f4;
        this.f48902h = f7;
        this.f48903i = f10;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16, float f17) {
        return squareToQuadrilateral(f10, f11, f12, f13, f14, f15, f16, f17).a(quadrilateralToSquare(f2, f3, f4, f5, f6, f7, f8, f9));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return squareToQuadrilateral(f2, f3, f4, f5, f6, f7, f8, f9).a();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        float f10 = ((f2 - f4) + f6) - f8;
        float f11 = ((f3 - f5) + f7) - f9;
        if (f10 == 0.0f && f11 == 0.0f) {
            return new PerspectiveTransform(f4 - f2, f6 - f4, f2, f5 - f3, f7 - f5, f3, 0.0f, 0.0f, 1.0f);
        }
        float f12 = f4 - f6;
        float f13 = f8 - f6;
        float f14 = f5 - f7;
        float f15 = f9 - f7;
        float f16 = (f12 * f15) - (f13 * f14);
        float f17 = ((f15 * f10) - (f13 * f11)) / f16;
        float f18 = ((f12 * f11) - (f10 * f14)) / f16;
        return new PerspectiveTransform((f17 * f4) + (f4 - f2), (f18 * f8) + (f8 - f2), f2, (f17 * f5) + (f5 - f3), (f18 * f9) + (f9 - f3), f3, f17, f18, 1.0f);
    }

    public PerspectiveTransform a() {
        float f2 = this.f48899e;
        float f3 = this.f48903i;
        float f4 = this.f48900f;
        float f5 = this.f48902h;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = this.f48901g;
        float f8 = this.f48898d;
        float f9 = (f4 * f7) - (f8 * f3);
        float f10 = (f8 * f5) - (f2 * f7);
        float f11 = this.f48897c;
        float f12 = this.f48896b;
        float f13 = (f11 * f5) - (f12 * f3);
        float f14 = this.f48895a;
        return new PerspectiveTransform(f6, f9, f10, f13, (f3 * f14) - (f11 * f7), (f7 * f12) - (f5 * f14), (f12 * f4) - (f11 * f2), (f11 * f8) - (f4 * f14), (f14 * f2) - (f12 * f8));
    }

    public void transformPoints(float[] fArr) {
        int length = fArr.length;
        float f2 = this.f48895a;
        float f3 = this.f48896b;
        float f4 = this.f48897c;
        float f5 = this.f48898d;
        float f6 = this.f48899e;
        float f7 = this.f48900f;
        float f8 = this.f48901g;
        float f9 = this.f48902h;
        float f10 = this.f48903i;
        for (int i2 = 0; i2 < length; i2 += 2) {
            float f11 = fArr[i2];
            int i3 = i2 + 1;
            float f12 = fArr[i3];
            float f13 = (f7 * f12) + (f4 * f11) + f10;
            fArr[i2] = (((f5 * f12) + (f2 * f11)) + f8) / f13;
            fArr[i3] = (((f12 * f6) + (f11 * f3)) + f9) / f13;
        }
    }

    public PerspectiveTransform a(PerspectiveTransform perspectiveTransform) {
        float f2 = this.f48895a;
        float f3 = perspectiveTransform.f48895a;
        float f4 = this.f48898d;
        float f5 = perspectiveTransform.f48896b;
        float f6 = this.f48901g;
        float f7 = perspectiveTransform.f48897c;
        float f8 = (f6 * f7) + (f4 * f5) + (f2 * f3);
        float f9 = perspectiveTransform.f48898d;
        float f10 = perspectiveTransform.f48899e;
        float f11 = perspectiveTransform.f48900f;
        float f12 = (f6 * f11) + (f4 * f10) + (f2 * f9);
        float f13 = perspectiveTransform.f48901g;
        float f14 = perspectiveTransform.f48902h;
        float f15 = perspectiveTransform.f48903i;
        float f16 = f6 * f15;
        float f17 = f16 + (f4 * f14) + (f2 * f13);
        float f18 = this.f48896b;
        float f19 = this.f48899e;
        float f20 = this.f48902h;
        float f21 = (f20 * f7) + (f19 * f5) + (f18 * f3);
        float f22 = (f20 * f11) + (f19 * f10) + (f18 * f9);
        float f23 = f20 * f15;
        float f24 = f23 + (f19 * f14) + (f18 * f13);
        float f25 = this.f48897c;
        float f26 = this.f48900f;
        float f27 = (f5 * f26) + (f3 * f25);
        float f28 = this.f48903i;
        return new PerspectiveTransform(f8, f12, f17, f21, f22, f24, (f7 * f28) + f27, (f11 * f28) + (f10 * f26) + (f9 * f25), (f28 * f15) + (f26 * f14) + (f25 * f13));
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr[i2];
            float f3 = fArr2[i2];
            float f4 = (this.f48900f * f3) + (this.f48897c * f2) + this.f48903i;
            fArr[i2] = (((this.f48898d * f3) + (this.f48895a * f2)) + this.f48901g) / f4;
            fArr2[i2] = (((this.f48899e * f3) + (this.f48896b * f2)) + this.f48902h) / f4;
        }
    }
}
