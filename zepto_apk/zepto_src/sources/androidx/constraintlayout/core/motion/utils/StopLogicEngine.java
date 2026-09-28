package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class StopLogicEngine implements StopEngine {

    /* renamed from: a, reason: collision with root package name */
    public float f1869a;

    /* renamed from: b, reason: collision with root package name */
    public float f1870b;

    /* renamed from: c, reason: collision with root package name */
    public float f1871c;

    /* renamed from: d, reason: collision with root package name */
    public float f1872d;

    /* renamed from: e, reason: collision with root package name */
    public float f1873e;

    /* renamed from: f, reason: collision with root package name */
    public float f1874f;

    /* renamed from: g, reason: collision with root package name */
    public float f1875g;

    /* renamed from: h, reason: collision with root package name */
    public float f1876h;

    /* renamed from: i, reason: collision with root package name */
    public float f1877i;

    /* renamed from: j, reason: collision with root package name */
    public int f1878j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1879k = false;

    /* renamed from: l, reason: collision with root package name */
    public float f1880l;

    /* renamed from: m, reason: collision with root package name */
    public float f1881m;
    public float n;

    public static class Decelerate implements StopEngine {

        /* renamed from: a, reason: collision with root package name */
        public float f1882a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1883b = false;

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public final float a() {
            return this.f1882a;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public final boolean b() {
            return this.f1883b;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public final float getInterpolation(float f2) {
            if (f2 > 0.0f) {
                this.f1883b = true;
                return 0.0f;
            }
            if (f2 <= 0.0f) {
                this.f1882a = (0.0f * f2) + 0.0f;
            }
            return ((((0.0f * f2) / 2.0f) + 0.0f) * f2) + 0.0f;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float a() {
        return this.f1879k ? -c(this.n) : c(this.n);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final boolean b() {
        return a() < 1.0E-5f && Math.abs(this.f1877i - this.f1881m) < 1.0E-5f;
    }

    public final float c(float f2) {
        float f3;
        float f4;
        float f5 = this.f1872d;
        if (f2 <= f5) {
            f3 = this.f1869a;
            f4 = this.f1870b;
        } else {
            int i2 = this.f1878j;
            if (i2 == 1) {
                return 0.0f;
            }
            f2 -= f5;
            f5 = this.f1873e;
            if (f2 >= f5) {
                if (i2 == 2) {
                    return 0.0f;
                }
                float f6 = f2 - f5;
                float f7 = this.f1874f;
                if (f6 >= f7) {
                    return 0.0f;
                }
                float f8 = this.f1871c;
                return f8 - ((f6 * f8) / f7);
            }
            f3 = this.f1870b;
            f4 = this.f1871c;
        }
        return (((f4 - f3) * f2) / f5) + f3;
    }

    public final void d(float f2, float f3, float f4, float f5, float f6) {
        this.f1877i = f3;
        if (f2 == 0.0f) {
            f2 = 1.0E-4f;
        }
        float f7 = f2 / f4;
        float f8 = (f7 * f2) / 2.0f;
        if (f2 < 0.0f) {
            float fSqrt = (float) Math.sqrt((f3 - ((((-f2) / f4) * f2) / 2.0f)) * f4);
            if (fSqrt < f5) {
                this.f1878j = 2;
                this.f1869a = f2;
                this.f1870b = fSqrt;
                this.f1871c = 0.0f;
                float f9 = (fSqrt - f2) / f4;
                this.f1872d = f9;
                this.f1873e = fSqrt / f4;
                this.f1875g = ((f2 + fSqrt) * f9) / 2.0f;
                this.f1876h = f3;
                this.f1877i = f3;
                return;
            }
            this.f1878j = 3;
            this.f1869a = f2;
            this.f1870b = f5;
            this.f1871c = f5;
            float f10 = (f5 - f2) / f4;
            this.f1872d = f10;
            float f11 = f5 / f4;
            this.f1874f = f11;
            float f12 = ((f2 + f5) * f10) / 2.0f;
            float f13 = (f11 * f5) / 2.0f;
            this.f1873e = ((f3 - f12) - f13) / f5;
            this.f1875g = f12;
            this.f1876h = f3 - f13;
            this.f1877i = f3;
            return;
        }
        if (f8 >= f3) {
            this.f1878j = 1;
            this.f1869a = f2;
            this.f1870b = 0.0f;
            this.f1875g = f3;
            this.f1872d = (2.0f * f3) / f2;
            return;
        }
        float f14 = f3 - f8;
        float f15 = f14 / f2;
        if (f15 + f7 < f6) {
            this.f1878j = 2;
            this.f1869a = f2;
            this.f1870b = f2;
            this.f1871c = 0.0f;
            this.f1875g = f14;
            this.f1876h = f3;
            this.f1872d = f15;
            this.f1873e = f7;
            return;
        }
        float fSqrt2 = (float) Math.sqrt(((f2 * f2) / 2.0f) + (f4 * f3));
        float f16 = (fSqrt2 - f2) / f4;
        this.f1872d = f16;
        float f17 = fSqrt2 / f4;
        this.f1873e = f17;
        if (fSqrt2 < f5) {
            this.f1878j = 2;
            this.f1869a = f2;
            this.f1870b = fSqrt2;
            this.f1871c = 0.0f;
            this.f1872d = f16;
            this.f1873e = f17;
            this.f1875g = ((f2 + fSqrt2) * f16) / 2.0f;
            this.f1876h = f3;
            return;
        }
        this.f1878j = 3;
        this.f1869a = f2;
        this.f1870b = f5;
        this.f1871c = f5;
        float f18 = (f5 - f2) / f4;
        this.f1872d = f18;
        float f19 = f5 / f4;
        this.f1874f = f19;
        float f20 = ((f2 + f5) * f18) / 2.0f;
        float f21 = (f19 * f5) / 2.0f;
        this.f1873e = ((f3 - f20) - f21) / f5;
        this.f1875g = f20;
        this.f1876h = f3 - f21;
        this.f1877i = f3;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public final float getInterpolation(float f2) {
        float f3;
        float f4 = this.f1872d;
        if (f2 <= f4) {
            float f5 = this.f1869a;
            f3 = ((((this.f1870b - f5) * f2) * f2) / (f4 * 2.0f)) + (f5 * f2);
        } else {
            int i2 = this.f1878j;
            if (i2 == 1) {
                f3 = this.f1875g;
            } else {
                float f6 = f2 - f4;
                float f7 = this.f1873e;
                if (f6 < f7) {
                    float f8 = this.f1875g;
                    float f9 = this.f1870b;
                    f3 = ((((this.f1871c - f9) * f6) * f6) / (f7 * 2.0f)) + (f9 * f6) + f8;
                } else if (i2 == 2) {
                    f3 = this.f1876h;
                } else {
                    float f10 = f6 - f7;
                    float f11 = this.f1874f;
                    if (f10 <= f11) {
                        float f12 = this.f1876h;
                        float f13 = this.f1871c * f10;
                        f3 = (f12 + f13) - ((f13 * f10) / (f11 * 2.0f));
                    } else {
                        f3 = this.f1877i;
                    }
                }
            }
        }
        this.f1881m = f3;
        this.n = f2;
        return this.f1879k ? this.f1880l - f3 : this.f1880l + f3;
    }
}
