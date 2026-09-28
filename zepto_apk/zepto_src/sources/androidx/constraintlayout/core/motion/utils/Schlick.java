package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class Schlick extends Easing {

    /* renamed from: d, reason: collision with root package name */
    public double f1852d;

    /* renamed from: e, reason: collision with root package name */
    public double f1853e;

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double a(double d2) {
        double d3 = this.f1853e;
        double d4 = this.f1852d;
        if (d2 < d3) {
            return (d3 * d2) / (((d3 - d2) * d4) + d2);
        }
        return ((d2 - 1.0d) * (1.0d - d3)) / ((1.0d - d2) - ((d3 - d2) * d4));
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double b(double d2) {
        double d3 = this.f1853e;
        double d4 = this.f1852d;
        if (d2 < d3) {
            double d5 = d4 * d3 * d3;
            double d6 = ((d3 - d2) * d4) + d2;
            return d5 / (d6 * d6);
        }
        double d7 = d3 - 1.0d;
        double d8 = (((d3 - d2) * (-d4)) - d2) + 1.0d;
        return ((d7 * d4) * d7) / (d8 * d8);
    }
}
