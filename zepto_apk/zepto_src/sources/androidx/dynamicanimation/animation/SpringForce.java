package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes3.dex */
public final class SpringForce implements Force {

    /* renamed from: a, reason: collision with root package name */
    public double f4280a;

    /* renamed from: b, reason: collision with root package name */
    public double f4281b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4282c;

    /* renamed from: d, reason: collision with root package name */
    public double f4283d;

    /* renamed from: e, reason: collision with root package name */
    public double f4284e;

    /* renamed from: f, reason: collision with root package name */
    public double f4285f;

    /* renamed from: g, reason: collision with root package name */
    public double f4286g;

    /* renamed from: h, reason: collision with root package name */
    public double f4287h;

    /* renamed from: i, reason: collision with root package name */
    public double f4288i;

    /* renamed from: j, reason: collision with root package name */
    public final DynamicAnimation.MassState f4289j;

    public SpringForce() {
        this.f4280a = Math.sqrt(1500.0d);
        this.f4281b = 0.5d;
        this.f4282c = false;
        this.f4288i = Double.MAX_VALUE;
        this.f4289j = new DynamicAnimation.MassState();
    }

    public final void a(float f2) {
        if (f2 <= 0.0f) {
            throw new IllegalArgumentException("Spring stiffness constant must be positive.");
        }
        this.f4280a = Math.sqrt(f2);
        this.f4282c = false;
    }

    public final DynamicAnimation.MassState b(double d2, double d3, long j2) {
        double dSin;
        double dCos;
        if (!this.f4282c) {
            if (this.f4288i == Double.MAX_VALUE) {
                throw new IllegalStateException("Error: Final position of the spring must be set before the animation starts");
            }
            double d4 = this.f4281b;
            if (d4 > 1.0d) {
                double d5 = this.f4280a;
                this.f4285f = (Math.sqrt((d4 * d4) - 1.0d) * d5) + ((-d4) * d5);
                double d6 = this.f4281b;
                double d7 = this.f4280a;
                this.f4286g = ((-d6) * d7) - (Math.sqrt((d6 * d6) - 1.0d) * d7);
            } else if (d4 >= 0.0d && d4 < 1.0d) {
                this.f4287h = Math.sqrt(1.0d - (d4 * d4)) * this.f4280a;
            }
            this.f4282c = true;
        }
        double d8 = j2 / 1000.0d;
        double d9 = d2 - this.f4288i;
        double d10 = this.f4281b;
        if (d10 > 1.0d) {
            double d11 = this.f4286g;
            double d12 = ((d11 * d9) - d3) / (d11 - this.f4285f);
            double d13 = d9 - d12;
            dSin = (Math.pow(2.718281828459045d, this.f4285f * d8) * d12) + (Math.pow(2.718281828459045d, d11 * d8) * d13);
            double d14 = this.f4286g;
            double dPow = Math.pow(2.718281828459045d, d14 * d8) * d13 * d14;
            double d15 = this.f4285f;
            dCos = (Math.pow(2.718281828459045d, d15 * d8) * d12 * d15) + dPow;
        } else if (d10 == 1.0d) {
            double d16 = this.f4280a;
            double d17 = (d16 * d9) + d3;
            double d18 = (d17 * d8) + d9;
            double dPow2 = Math.pow(2.718281828459045d, (-d16) * d8) * d18;
            double dPow3 = Math.pow(2.718281828459045d, (-this.f4280a) * d8) * d18;
            double d19 = -this.f4280a;
            dCos = (Math.pow(2.718281828459045d, d19 * d8) * d17) + (dPow3 * d19);
            dSin = dPow2;
        } else {
            double d20 = 1.0d / this.f4287h;
            double d21 = this.f4280a;
            double d22 = ((d10 * d21 * d9) + d3) * d20;
            dSin = ((Math.sin(this.f4287h * d8) * d22) + (Math.cos(this.f4287h * d8) * d9)) * Math.pow(2.718281828459045d, (-d10) * d21 * d8);
            double d23 = this.f4280a;
            double d24 = this.f4281b;
            double d25 = (-d23) * dSin * d24;
            double dPow4 = Math.pow(2.718281828459045d, (-d24) * d23 * d8);
            double d26 = this.f4287h;
            double dSin2 = Math.sin(d26 * d8) * (-d26) * d9;
            double d27 = this.f4287h;
            dCos = (((Math.cos(d27 * d8) * d22 * d27) + dSin2) * dPow4) + d25;
        }
        float f2 = (float) (dSin + this.f4288i);
        DynamicAnimation.MassState massState = this.f4289j;
        massState.f4277a = f2;
        massState.f4278b = (float) dCos;
        return massState;
    }

    public SpringForce(float f2) {
        this.f4280a = Math.sqrt(1500.0d);
        this.f4281b = 0.5d;
        this.f4282c = false;
        this.f4289j = new DynamicAnimation.MassState();
        this.f4288i = f2;
    }
}
