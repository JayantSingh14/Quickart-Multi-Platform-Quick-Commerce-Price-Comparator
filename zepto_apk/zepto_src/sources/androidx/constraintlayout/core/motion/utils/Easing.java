package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class Easing {

    /* renamed from: b, reason: collision with root package name */
    public static final Easing f1810b = new Easing();

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f1811c = {"standard", "accelerate", "decelerate", "linear"};

    /* renamed from: a, reason: collision with root package name */
    public String f1812a = "identity";

    public static class CubicEasing extends Easing {

        /* renamed from: d, reason: collision with root package name */
        public final double f1813d;

        /* renamed from: e, reason: collision with root package name */
        public final double f1814e;

        /* renamed from: f, reason: collision with root package name */
        public final double f1815f;

        /* renamed from: g, reason: collision with root package name */
        public final double f1816g;

        public CubicEasing(String str) {
            this.f1812a = str;
            int iIndexOf = str.indexOf(40);
            int iIndexOf2 = str.indexOf(44, iIndexOf);
            this.f1813d = Double.parseDouble(str.substring(iIndexOf + 1, iIndexOf2).trim());
            int i2 = iIndexOf2 + 1;
            int iIndexOf3 = str.indexOf(44, i2);
            this.f1814e = Double.parseDouble(str.substring(i2, iIndexOf3).trim());
            int i3 = iIndexOf3 + 1;
            int iIndexOf4 = str.indexOf(44, i3);
            this.f1815f = Double.parseDouble(str.substring(i3, iIndexOf4).trim());
            int i4 = iIndexOf4 + 1;
            this.f1816g = Double.parseDouble(str.substring(i4, str.indexOf(41, i4)).trim());
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public final double a(double d2) {
            if (d2 <= 0.0d) {
                return 0.0d;
            }
            if (d2 >= 1.0d) {
                return 1.0d;
            }
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 0.01d) {
                d3 *= 0.5d;
                d4 = d(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d(d5);
            double d7 = d4 + d3;
            double d8 = d(d7);
            double dE = e(d5);
            return (((d2 - d6) * (e(d7) - dE)) / (d8 - d6)) + dE;
        }

        @Override // androidx.constraintlayout.core.motion.utils.Easing
        public final double b(double d2) {
            double d3 = 0.5d;
            double d4 = 0.5d;
            while (d3 > 1.0E-4d) {
                d3 *= 0.5d;
                d4 = d(d4) < d2 ? d4 + d3 : d4 - d3;
            }
            double d5 = d4 - d3;
            double d6 = d4 + d3;
            return (e(d6) - e(d5)) / (d(d6) - d(d5));
        }

        public final double d(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.f1815f * d6) + (this.f1813d * d5) + (d2 * d2 * d2);
        }

        public final double e(double d2) {
            double d3 = 1.0d - d2;
            double d4 = 3.0d * d3;
            double d5 = d3 * d4 * d2;
            double d6 = d4 * d2 * d2;
            return (this.f1816g * d6) + (this.f1814e * d5) + (d2 * d2 * d2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:30:0x013f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.constraintlayout.core.motion.utils.Easing c(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.Easing.c(java.lang.String):androidx.constraintlayout.core.motion.utils.Easing");
    }

    public double a(double d2) {
        return d2;
    }

    public double b(double d2) {
        return 1.0d;
    }

    public final String toString() {
        return this.f1812a;
    }
}
