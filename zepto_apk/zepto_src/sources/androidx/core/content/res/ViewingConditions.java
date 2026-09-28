package androidx.core.content.res;

/* loaded from: classes3.dex */
final class ViewingConditions {

    /* renamed from: k, reason: collision with root package name */
    public static final ViewingConditions f2776k;

    /* renamed from: a, reason: collision with root package name */
    public final float f2777a;

    /* renamed from: b, reason: collision with root package name */
    public final float f2778b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2779c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2780d;

    /* renamed from: e, reason: collision with root package name */
    public final float f2781e;

    /* renamed from: f, reason: collision with root package name */
    public final float f2782f;

    /* renamed from: g, reason: collision with root package name */
    public final float[] f2783g;

    /* renamed from: h, reason: collision with root package name */
    public final float f2784h;

    /* renamed from: i, reason: collision with root package name */
    public final float f2785i;

    /* renamed from: j, reason: collision with root package name */
    public final float f2786j;

    static {
        float[] fArr = CamUtils.f2744c;
        float fC = (float) ((CamUtils.c() * 63.66197723675813d) / 100.0d);
        float[][] fArr2 = CamUtils.f2742a;
        float f2 = fArr[0];
        float[] fArr3 = fArr2[0];
        float f3 = fArr3[0] * f2;
        float f4 = fArr[1];
        float f5 = (fArr3[1] * f4) + f3;
        float f6 = fArr[2];
        float f7 = (fArr3[2] * f6) + f5;
        float[] fArr4 = fArr2[1];
        float f8 = (fArr4[2] * f6) + (fArr4[1] * f4) + (fArr4[0] * f2);
        float[] fArr5 = fArr2[2];
        float f9 = (f6 * fArr5[2]) + (f4 * fArr5[1]) + (f2 * fArr5[0]);
        float f10 = ((double) 1.0f) >= 0.9d ? 0.69f : 0.655f;
        float fExp = (1.0f - (((float) Math.exp(((-fC) - 42.0f) / 92.0f)) * 0.2777778f)) * 1.0f;
        double d2 = fExp;
        if (d2 > 1.0d) {
            fExp = 1.0f;
        } else if (d2 < 0.0d) {
            fExp = 0.0f;
        }
        float f11 = 1.0f / ((5.0f * fC) + 1.0f);
        float f12 = f11 * f11 * f11 * f11;
        float f13 = 1.0f - f12;
        float fCbrt = (0.1f * f13 * f13 * ((float) Math.cbrt(fC * 5.0d))) + (f12 * fC);
        float fC2 = CamUtils.c() / fArr[1];
        double d3 = fC2;
        float fSqrt = ((float) Math.sqrt(d3)) + 1.48f;
        float fPow = 0.725f / ((float) Math.pow(d3, 0.2d));
        float[] fArr6 = {(float) Math.pow(((r9[0] * fCbrt) * f7) / 100.0d, 0.42d), (float) Math.pow(((r9[1] * fCbrt) * f8) / 100.0d, 0.42d), (float) Math.pow(((r9[2] * fCbrt) * f9) / 100.0d, 0.42d)};
        float f14 = fArr6[0];
        float f15 = (f14 * 400.0f) / (f14 + 27.13f);
        float f16 = fArr6[1];
        float f17 = (f16 * 400.0f) / (f16 + 27.13f);
        float f18 = fArr6[2];
        float[] fArr7 = {f15, f17, (400.0f * f18) / (f18 + 27.13f)};
        f2776k = new ViewingConditions(fC2, ((fArr7[2] * 0.05f) + (fArr7[0] * 2.0f) + fArr7[1]) * fPow, fPow, fPow, f10, 1.0f, new float[]{(((100.0f / f7) * fExp) + 1.0f) - fExp, (((100.0f / f8) * fExp) + 1.0f) - fExp, (((100.0f / f9) * fExp) + 1.0f) - fExp}, fCbrt, (float) Math.pow(fCbrt, 0.25d), fSqrt);
    }

    public ViewingConditions(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr, float f8, float f9, float f10) {
        this.f2782f = f2;
        this.f2777a = f3;
        this.f2778b = f4;
        this.f2779c = f5;
        this.f2780d = f6;
        this.f2781e = f7;
        this.f2783g = fArr;
        this.f2784h = f8;
        this.f2785i = f9;
        this.f2786j = f10;
    }
}
