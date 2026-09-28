package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class SpringStopEngine implements StopEngine {

    /* renamed from: b, reason: collision with root package name */
    public double f1860b;

    /* renamed from: c, reason: collision with root package name */
    public double f1861c;

    /* renamed from: d, reason: collision with root package name */
    public float f1862d;

    /* renamed from: e, reason: collision with root package name */
    public float f1863e;

    /* renamed from: f, reason: collision with root package name */
    public float f1864f;

    /* renamed from: g, reason: collision with root package name */
    public float f1865g;

    /* renamed from: h, reason: collision with root package name */
    public float f1866h;

    /* renamed from: a, reason: collision with root package name */
    public double f1859a = 0.5d;

    /* renamed from: i, reason: collision with root package name */
    public int f1867i = 0;

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float a() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final boolean b() {
        double d2 = this.f1863e - this.f1861c;
        double d3 = this.f1860b;
        double d4 = this.f1864f;
        return Math.sqrt((((d3 * d2) * d2) + ((d4 * d4) * ((double) this.f1865g))) / d3) <= ((double) this.f1866h);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float getInterpolation(float f2) {
        double d2 = f2 - this.f1862d;
        if (d2 > 0.0d) {
            double d3 = this.f1860b;
            double d4 = this.f1859a;
            int iSqrt = (int) ((9.0d / ((Math.sqrt(d3 / this.f1865g) * d2) * 4.0d)) + 1.0d);
            double d5 = d2 / iSqrt;
            int i2 = 0;
            while (i2 < iSqrt) {
                float f3 = this.f1863e;
                double d6 = f3;
                double d7 = this.f1861c;
                double d8 = d5;
                float f4 = this.f1864f;
                double d9 = f4;
                double d10 = ((-d3) * (d6 - d7)) - (d4 * d9);
                double d11 = this.f1865g;
                double d12 = (((d10 / d11) * d8) / 2.0d) + d9;
                double d13 = ((((-((((d8 * d12) / 2.0d) + d6) - d7)) * d3) - (d12 * d4)) / d11) * d8;
                float f5 = f4 + ((float) d13);
                this.f1864f = f5;
                float f6 = f3 + ((float) (((d13 / 2.0d) + d9) * d8));
                this.f1863e = f6;
                int i3 = this.f1867i;
                if (i3 > 0) {
                    if (f6 < 0.0f && (i3 & 1) == 1) {
                        this.f1863e = -f6;
                        this.f1864f = -f5;
                    }
                    float f7 = this.f1863e;
                    if (f7 > 1.0f && (i3 & 2) == 2) {
                        this.f1863e = 2.0f - f7;
                        this.f1864f = -this.f1864f;
                    }
                }
                i2++;
                d5 = d8;
            }
        }
        this.f1862d = f2;
        if (b()) {
            this.f1863e = (float) this.f1861c;
        }
        return this.f1863e;
    }
}
