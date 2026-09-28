package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class ArcCurveFit extends CurveFit {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f1792a;

    /* renamed from: b, reason: collision with root package name */
    public final Arc[] f1793b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1794c;

    public static class Arc {
        public static final double[] s = new double[91];

        /* renamed from: a, reason: collision with root package name */
        public double[] f1795a;

        /* renamed from: b, reason: collision with root package name */
        public double f1796b;

        /* renamed from: c, reason: collision with root package name */
        public double f1797c;

        /* renamed from: d, reason: collision with root package name */
        public double f1798d;

        /* renamed from: e, reason: collision with root package name */
        public double f1799e;

        /* renamed from: f, reason: collision with root package name */
        public double f1800f;

        /* renamed from: g, reason: collision with root package name */
        public double f1801g;

        /* renamed from: h, reason: collision with root package name */
        public double f1802h;

        /* renamed from: i, reason: collision with root package name */
        public double f1803i;

        /* renamed from: j, reason: collision with root package name */
        public double f1804j;

        /* renamed from: k, reason: collision with root package name */
        public double f1805k;

        /* renamed from: l, reason: collision with root package name */
        public double f1806l;

        /* renamed from: m, reason: collision with root package name */
        public double f1807m;
        public double n;
        public double o;
        public double p;
        public boolean q;
        public boolean r;

        public final double a() {
            double d2 = this.f1804j * this.p;
            double dHypot = this.n / Math.hypot(d2, (-this.f1805k) * this.o);
            return this.q ? (-d2) * dHypot : d2 * dHypot;
        }

        public final double b() {
            double d2 = this.f1804j * this.p;
            double d3 = (-this.f1805k) * this.o;
            double dHypot = this.n / Math.hypot(d2, d3);
            return this.q ? (-d3) * dHypot : d3 * dHypot;
        }

        public final double c(double d2) {
            double d3 = (d2 - this.f1797c) * this.f1803i;
            double d4 = this.f1800f;
            double d5 = this.f1799e;
            return ((d4 - d5) * d3) + d5;
        }

        public final double d(double d2) {
            double d3 = (d2 - this.f1797c) * this.f1803i;
            double d4 = this.f1802h;
            double d5 = this.f1801g;
            return ((d4 - d5) * d3) + d5;
        }

        public final double e() {
            return (this.f1804j * this.o) + this.f1806l;
        }

        public final double f() {
            return (this.f1805k * this.p) + this.f1807m;
        }

        public final void g(double d2) {
            double d3 = (this.q ? this.f1798d - d2 : d2 - this.f1797c) * this.f1803i;
            double d4 = 0.0d;
            if (d3 > 0.0d) {
                d4 = 1.0d;
                if (d3 < 1.0d) {
                    double[] dArr = this.f1795a;
                    double length = d3 * (dArr.length - 1);
                    int i2 = (int) length;
                    double d5 = dArr[i2];
                    d4 = ((dArr[i2 + 1] - d5) * (length - i2)) + d5;
                }
            }
            double d6 = d4 * 1.5707963267948966d;
            this.o = Math.sin(d6);
            this.p = Math.cos(d6);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0039  */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.constraintlayout.core.motion.utils.ArcCurveFit, androidx.constraintlayout.core.motion.utils.CurveFit] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ArcCurveFit(int[] r33, double[] r34, double[][] r35) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.utils.ArcCurveFit.<init>(int[], double[], double[][]):void");
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double b(double d2) {
        boolean z = this.f1794c;
        Arc[] arcArr = this.f1793b;
        if (z) {
            Arc arc = arcArr[0];
            double d3 = arc.f1797c;
            if (d2 < d3) {
                double d4 = d2 - d3;
                if (arc.r) {
                    return (d4 * arcArr[0].f1806l) + arc.c(d3);
                }
                arc.g(d3);
                return (d4 * arcArr[0].a()) + arcArr[0].e();
            }
            if (d2 > arcArr[arcArr.length - 1].f1798d) {
                double d5 = arcArr[arcArr.length - 1].f1798d;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                return (d6 * arcArr[length].f1806l) + arcArr[length].c(d5);
            }
        } else {
            double d7 = arcArr[0].f1797c;
            if (d2 < d7) {
                d2 = d7;
            } else if (d2 > arcArr[arcArr.length - 1].f1798d) {
                d2 = arcArr[arcArr.length - 1].f1798d;
            }
        }
        for (int i2 = 0; i2 < arcArr.length; i2++) {
            Arc arc2 = arcArr[i2];
            if (d2 <= arc2.f1798d) {
                if (arc2.r) {
                    return arc2.c(d2);
                }
                arc2.g(d2);
                return arcArr[i2].e();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void c(double d2, float[] fArr) {
        boolean z = this.f1794c;
        Arc[] arcArr = this.f1793b;
        if (z) {
            Arc arc = arcArr[0];
            double d3 = arc.f1797c;
            if (d2 < d3) {
                double d4 = d2 - d3;
                if (arc.r) {
                    double dC = arc.c(d3);
                    Arc arc2 = arcArr[0];
                    fArr[0] = (float) ((arc2.f1806l * d4) + dC);
                    fArr[1] = (float) ((d4 * arcArr[0].f1807m) + arc2.d(d3));
                    return;
                }
                arc.g(d3);
                fArr[0] = (float) ((arcArr[0].a() * d4) + arcArr[0].e());
                fArr[1] = (float) ((d4 * arcArr[0].b()) + arcArr[0].f());
                return;
            }
            if (d2 > arcArr[arcArr.length - 1].f1798d) {
                double d5 = arcArr[arcArr.length - 1].f1798d;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                Arc arc3 = arcArr[length];
                if (!arc3.r) {
                    arc3.g(d2);
                    fArr[0] = (float) arcArr[length].e();
                    fArr[1] = (float) arcArr[length].f();
                    return;
                } else {
                    double dC2 = arc3.c(d5);
                    Arc arc4 = arcArr[length];
                    fArr[0] = (float) ((arc4.f1806l * d6) + dC2);
                    fArr[1] = (float) ((d6 * arcArr[length].f1807m) + arc4.d(d5));
                    return;
                }
            }
        } else {
            double d7 = arcArr[0].f1797c;
            if (d2 < d7) {
                d2 = d7;
            } else if (d2 > arcArr[arcArr.length - 1].f1798d) {
                d2 = arcArr[arcArr.length - 1].f1798d;
            }
        }
        for (int i2 = 0; i2 < arcArr.length; i2++) {
            Arc arc5 = arcArr[i2];
            if (d2 <= arc5.f1798d) {
                if (arc5.r) {
                    fArr[0] = (float) arc5.c(d2);
                    fArr[1] = (float) arcArr[i2].d(d2);
                    return;
                } else {
                    arc5.g(d2);
                    fArr[0] = (float) arcArr[i2].e();
                    fArr[1] = (float) arcArr[i2].f();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void d(double[] dArr, double d2) {
        boolean z = this.f1794c;
        Arc[] arcArr = this.f1793b;
        if (z) {
            Arc arc = arcArr[0];
            double d3 = arc.f1797c;
            if (d2 < d3) {
                double d4 = d2 - d3;
                if (arc.r) {
                    double dC = arc.c(d3);
                    Arc arc2 = arcArr[0];
                    dArr[0] = (arc2.f1806l * d4) + dC;
                    dArr[1] = (d4 * arcArr[0].f1807m) + arc2.d(d3);
                    return;
                }
                arc.g(d3);
                dArr[0] = (arcArr[0].a() * d4) + arcArr[0].e();
                dArr[1] = (d4 * arcArr[0].b()) + arcArr[0].f();
                return;
            }
            if (d2 > arcArr[arcArr.length - 1].f1798d) {
                double d5 = arcArr[arcArr.length - 1].f1798d;
                double d6 = d2 - d5;
                int length = arcArr.length - 1;
                Arc arc3 = arcArr[length];
                if (arc3.r) {
                    double dC2 = arc3.c(d5);
                    Arc arc4 = arcArr[length];
                    dArr[0] = (arc4.f1806l * d6) + dC2;
                    dArr[1] = (d6 * arcArr[length].f1807m) + arc4.d(d5);
                    return;
                }
                arc3.g(d2);
                dArr[0] = (arcArr[length].a() * d6) + arcArr[length].e();
                dArr[1] = (d6 * arcArr[length].b()) + arcArr[length].f();
                return;
            }
        } else {
            double d7 = arcArr[0].f1797c;
            if (d2 < d7) {
                d2 = d7;
            }
            if (d2 > arcArr[arcArr.length - 1].f1798d) {
                d2 = arcArr[arcArr.length - 1].f1798d;
            }
        }
        for (int i2 = 0; i2 < arcArr.length; i2++) {
            Arc arc5 = arcArr[i2];
            if (d2 <= arc5.f1798d) {
                if (arc5.r) {
                    dArr[0] = arc5.c(d2);
                    dArr[1] = arcArr[i2].d(d2);
                    return;
                } else {
                    arc5.g(d2);
                    dArr[0] = arcArr[i2].e();
                    dArr[1] = arcArr[i2].f();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double e(double d2) {
        Arc[] arcArr = this.f1793b;
        double d3 = arcArr[0].f1797c;
        if (d2 < d3) {
            d2 = d3;
        }
        if (d2 > arcArr[arcArr.length - 1].f1798d) {
            d2 = arcArr[arcArr.length - 1].f1798d;
        }
        for (int i2 = 0; i2 < arcArr.length; i2++) {
            Arc arc = arcArr[i2];
            if (d2 <= arc.f1798d) {
                if (arc.r) {
                    return arc.f1806l;
                }
                arc.g(d2);
                return arcArr[i2].a();
            }
        }
        return Double.NaN;
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final void f(double[] dArr, double d2) {
        Arc[] arcArr = this.f1793b;
        double d3 = arcArr[0].f1797c;
        if (d2 < d3) {
            d2 = d3;
        } else if (d2 > arcArr[arcArr.length - 1].f1798d) {
            d2 = arcArr[arcArr.length - 1].f1798d;
        }
        for (int i2 = 0; i2 < arcArr.length; i2++) {
            Arc arc = arcArr[i2];
            if (d2 <= arc.f1798d) {
                if (arc.r) {
                    dArr[0] = arc.f1806l;
                    dArr[1] = arc.f1807m;
                    return;
                } else {
                    arc.g(d2);
                    dArr[0] = arcArr[i2].a();
                    dArr[1] = arcArr[i2].b();
                    return;
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.CurveFit
    public final double[] g() {
        return this.f1792a;
    }
}
