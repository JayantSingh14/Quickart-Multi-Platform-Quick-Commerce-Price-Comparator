package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public abstract class CurveFit {

    public static class Constant extends CurveFit {

        /* renamed from: a, reason: collision with root package name */
        public double f1808a;

        /* renamed from: b, reason: collision with root package name */
        public double[] f1809b;

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final double b(double d2) {
            return this.f1809b[0];
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final void c(double d2, float[] fArr) {
            int i2 = 0;
            while (true) {
                double[] dArr = this.f1809b;
                if (i2 >= dArr.length) {
                    return;
                }
                fArr[i2] = (float) dArr[i2];
                i2++;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final void d(double[] dArr, double d2) {
            double[] dArr2 = this.f1809b;
            System.arraycopy(dArr2, 0, dArr, 0, dArr2.length);
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final double e(double d2) {
            return 0.0d;
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final void f(double[] dArr, double d2) {
            for (int i2 = 0; i2 < this.f1809b.length; i2++) {
                dArr[i2] = 0.0d;
            }
        }

        @Override // androidx.constraintlayout.core.motion.utils.CurveFit
        public final double[] g() {
            return new double[]{this.f1808a};
        }
    }

    public static CurveFit a(int i2, double[] dArr, double[][] dArr2) {
        if (dArr.length == 1) {
            i2 = 2;
        }
        if (i2 == 0) {
            return new MonotonicCurveFit(dArr, dArr2);
        }
        if (i2 == 2) {
            double d2 = dArr[0];
            double[] dArr3 = dArr2[0];
            Constant constant = new Constant();
            constant.f1808a = d2;
            constant.f1809b = dArr3;
            return constant;
        }
        LinearCurveFit linearCurveFit = new LinearCurveFit();
        linearCurveFit.f1840c = true;
        int length = dArr2[0].length;
        linearCurveFit.f1841d = new double[length];
        linearCurveFit.f1838a = dArr;
        linearCurveFit.f1839b = dArr2;
        if (length > 2) {
            double d3 = 0.0d;
            int i3 = 0;
            while (true) {
                double d4 = d3;
                if (i3 >= dArr.length) {
                    break;
                }
                double d5 = dArr2[i3][0];
                if (i3 > 0) {
                    Math.hypot(d5 - d3, d5 - d4);
                }
                i3++;
                d3 = d5;
            }
        }
        return linearCurveFit;
    }

    public abstract double b(double d2);

    public abstract void c(double d2, float[] fArr);

    public abstract void d(double[] dArr, double d2);

    public abstract double e(double d2);

    public abstract void f(double[] dArr, double d2);

    public abstract double[] g();
}
