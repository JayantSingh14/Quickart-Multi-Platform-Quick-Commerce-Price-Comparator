package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Direct {

    /* renamed from: a, reason: collision with root package name */
    public static final BasicMeasure.Measure f2029a = new BasicMeasure.Measure();

    public static boolean a(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
        ConstraintWidget constraintWidget2 = constraintWidget.V;
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget2 != null ? (ConstraintWidgetContainer) constraintWidget2 : null;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1964a;
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer.U[0];
        }
        if (constraintWidgetContainer != null) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer.U[1];
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.f1966c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.f1965b;
        boolean z = dimensionBehaviour == dimensionBehaviour3 || constraintWidget.E() || dimensionBehaviour == dimensionBehaviour7 || (dimensionBehaviour == dimensionBehaviour6 && constraintWidget.r == 0 && constraintWidget.Y == 0.0f && constraintWidget.x(0)) || (dimensionBehaviour == dimensionBehaviour6 && constraintWidget.r == 1 && constraintWidget.y(0, constraintWidget.u()));
        boolean z2 = dimensionBehaviour2 == dimensionBehaviour3 || constraintWidget.F() || dimensionBehaviour2 == dimensionBehaviour7 || (dimensionBehaviour2 == dimensionBehaviour6 && constraintWidget.s == 0 && constraintWidget.Y == 0.0f && constraintWidget.x(1)) || (dimensionBehaviour2 == dimensionBehaviour6 && constraintWidget.s == 1 && constraintWidget.y(1, constraintWidget.o()));
        return (constraintWidget.Y > 0.0f && (z || z2)) || (z && z2);
    }

    public static void b(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        char c2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.f1962m) {
            return;
        }
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.D() && a(constraintWidget)) {
            ConstraintWidgetContainer.Y(constraintWidget, measurer, new BasicMeasure.Measure());
        }
        ConstraintAnchor constraintAnchorM = constraintWidget.m(ConstraintAnchor.Type.f1941a);
        ConstraintAnchor constraintAnchorM2 = constraintWidget.m(ConstraintAnchor.Type.f1943c);
        int iD = constraintAnchorM.d();
        int iD2 = constraintAnchorM2.d();
        HashSet hashSet = constraintAnchorM.f1932a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1966c;
        if (hashSet != null && constraintAnchorM.f1934c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ConstraintAnchor constraintAnchor5 = (ConstraintAnchor) it.next();
                ConstraintWidget constraintWidget2 = constraintAnchor5.f1935d;
                int i3 = i2 + 1;
                boolean zA = a(constraintWidget2);
                if (constraintWidget2.D() && zA) {
                    c2 = 0;
                    ConstraintWidgetContainer.Y(constraintWidget2, measurer, new BasicMeasure.Measure());
                } else {
                    c2 = 0;
                }
                ConstraintAnchor constraintAnchor6 = constraintWidget2.J;
                ConstraintAnchor constraintAnchor7 = constraintWidget2.L;
                char c3 = ((constraintAnchor5 == constraintAnchor6 && (constraintAnchor4 = constraintAnchor7.f1937f) != null && constraintAnchor4.f1934c) || (constraintAnchor5 == constraintAnchor7 && (constraintAnchor3 = constraintAnchor6.f1937f) != null && constraintAnchor3.f1934c)) ? (char) 1 : c2;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.U[c2];
                if (dimensionBehaviour2 != dimensionBehaviour || zA) {
                    if (!constraintWidget2.D()) {
                        if (constraintAnchor5 == constraintAnchor6 && constraintAnchor7.f1937f == null) {
                            int iE = constraintAnchor6.e() + iD;
                            constraintWidget2.N(iE, constraintWidget2.u() + iE);
                            b(i3, constraintWidget2, measurer, z);
                        } else if (constraintAnchor5 == constraintAnchor7 && constraintAnchor6.f1937f == null) {
                            int iE2 = iD - constraintAnchor7.e();
                            constraintWidget2.N(iE2 - constraintWidget2.u(), iE2);
                            b(i3, constraintWidget2, measurer, z);
                        } else if (c3 != 0 && !constraintWidget2.B()) {
                            c(i3, constraintWidget2, measurer, z);
                        }
                    }
                } else if (dimensionBehaviour2 == dimensionBehaviour && constraintWidget2.v >= 0 && constraintWidget2.u >= 0 && (constraintWidget2.i0 == 8 || (constraintWidget2.r == 0 && constraintWidget2.Y == 0.0f))) {
                    if (!constraintWidget2.B() && !constraintWidget2.G && c3 != 0 && !constraintWidget2.B()) {
                        d(i3, constraintWidget, measurer, constraintWidget2, z);
                    }
                }
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        HashSet hashSet2 = constraintAnchorM2.f1932a;
        if (hashSet2 != null && constraintAnchorM2.f1934c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                ConstraintAnchor constraintAnchor8 = (ConstraintAnchor) it2.next();
                ConstraintWidget constraintWidget3 = constraintAnchor8.f1935d;
                int i4 = i2 + 1;
                boolean zA2 = a(constraintWidget3);
                if (constraintWidget3.D() && zA2) {
                    ConstraintWidgetContainer.Y(constraintWidget3, measurer, new BasicMeasure.Measure());
                }
                ConstraintAnchor constraintAnchor9 = constraintWidget3.J;
                ConstraintAnchor constraintAnchor10 = constraintWidget3.L;
                boolean z2 = (constraintAnchor8 == constraintAnchor9 && (constraintAnchor2 = constraintAnchor10.f1937f) != null && constraintAnchor2.f1934c) || (constraintAnchor8 == constraintAnchor10 && (constraintAnchor = constraintAnchor9.f1937f) != null && constraintAnchor.f1934c);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidget3.U[0];
                if (dimensionBehaviour3 != dimensionBehaviour || zA2) {
                    if (!constraintWidget3.D()) {
                        if (constraintAnchor8 == constraintAnchor9 && constraintAnchor10.f1937f == null) {
                            int iE3 = constraintAnchor9.e() + iD2;
                            constraintWidget3.N(iE3, constraintWidget3.u() + iE3);
                            b(i4, constraintWidget3, measurer, z);
                        } else if (constraintAnchor8 == constraintAnchor10 && constraintAnchor9.f1937f == null) {
                            int iE4 = iD2 - constraintAnchor10.e();
                            constraintWidget3.N(iE4 - constraintWidget3.u(), iE4);
                            b(i4, constraintWidget3, measurer, z);
                        } else if (z2 && !constraintWidget3.B()) {
                            c(i4, constraintWidget3, measurer, z);
                        }
                    }
                } else if (dimensionBehaviour3 == dimensionBehaviour && constraintWidget3.v >= 0 && constraintWidget3.u >= 0) {
                    if (constraintWidget3.i0 == 8 || (constraintWidget3.r == 0 && constraintWidget3.Y == 0.0f)) {
                        if (!constraintWidget3.B() && !constraintWidget3.G && z2 && !constraintWidget3.B()) {
                            d(i4, constraintWidget, measurer, constraintWidget3, z);
                        }
                    }
                }
            }
        }
        constraintWidget.f1962m = true;
    }

    public static void c(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, boolean z) {
        float f2 = constraintWidget.f0;
        ConstraintAnchor constraintAnchor = constraintWidget.J;
        int iD = constraintAnchor.f1937f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget.L;
        int iD2 = constraintAnchor2.f1937f.d();
        int iE = constraintAnchor.e() + iD;
        int iE2 = iD2 - constraintAnchor2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iU = constraintWidget.u();
        int i3 = (iD2 - iD) - iU;
        if (iD > iD2) {
            i3 = (iD - iD2) - iU;
        }
        int i4 = ((int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3)) + iD;
        int i5 = i4 + iU;
        if (iD > iD2) {
            i5 = i4 - iU;
        }
        constraintWidget.N(i4, i5);
        b(i2 + 1, constraintWidget, measurer, z);
    }

    public static void d(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2, boolean z) {
        float f2 = constraintWidget2.f0;
        ConstraintAnchor constraintAnchor = constraintWidget2.J;
        int iE = constraintAnchor.e() + constraintAnchor.f1937f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.L;
        int iD = constraintAnchor2.f1937f.d() - constraintAnchor2.e();
        if (iD >= iE) {
            int iU = constraintWidget2.u();
            if (constraintWidget2.i0 != 8) {
                int i3 = constraintWidget2.r;
                if (i3 == 2) {
                    iU = (int) (constraintWidget2.f0 * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.u() : constraintWidget.V.u()));
                } else if (i3 == 0) {
                    iU = iD - iE;
                }
                iU = Math.max(constraintWidget2.u, iU);
                int i4 = constraintWidget2.v;
                if (i4 > 0) {
                    iU = Math.min(i4, iU);
                }
            }
            int i5 = iE + ((int) ((f2 * ((iD - iE) - iU)) + 0.5f));
            constraintWidget2.N(i5, iU + i5);
            b(i2 + 1, constraintWidget2, measurer, z);
        }
    }

    public static void e(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        float f2 = constraintWidget.g0;
        ConstraintAnchor constraintAnchor = constraintWidget.K;
        int iD = constraintAnchor.f1937f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget.M;
        int iD2 = constraintAnchor2.f1937f.d();
        int iE = constraintAnchor.e() + iD;
        int iE2 = iD2 - constraintAnchor2.e();
        if (iD == iD2) {
            f2 = 0.5f;
        } else {
            iD = iE;
            iD2 = iE2;
        }
        int iO = constraintWidget.o();
        int i3 = (iD2 - iD) - iO;
        if (iD > iD2) {
            i3 = (iD - iD2) - iO;
        }
        int i4 = (int) (i3 > 0 ? (f2 * i3) + 0.5f : f2 * i3);
        int i5 = iD + i4;
        int i6 = i5 + iO;
        if (iD > iD2) {
            i5 = iD - i4;
            i6 = i5 - iO;
        }
        constraintWidget.O(i5, i6);
        g(i2 + 1, constraintWidget, measurer);
    }

    public static void f(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        float f2 = constraintWidget2.g0;
        ConstraintAnchor constraintAnchor = constraintWidget2.K;
        int iE = constraintAnchor.e() + constraintAnchor.f1937f.d();
        ConstraintAnchor constraintAnchor2 = constraintWidget2.M;
        int iD = constraintAnchor2.f1937f.d() - constraintAnchor2.e();
        if (iD >= iE) {
            int iO = constraintWidget2.o();
            if (constraintWidget2.i0 != 8) {
                int i3 = constraintWidget2.s;
                if (i3 == 2) {
                    iO = (int) (f2 * 0.5f * (constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.o() : constraintWidget.V.o()));
                } else if (i3 == 0) {
                    iO = iD - iE;
                }
                iO = Math.max(constraintWidget2.x, iO);
                int i4 = constraintWidget2.y;
                if (i4 > 0) {
                    iO = Math.min(i4, iO);
                }
            }
            int i5 = iE + ((int) ((f2 * ((iD - iE) - iO)) + 0.5f));
            constraintWidget2.O(i5, iO + i5);
            g(i2 + 1, constraintWidget2, measurer);
        }
    }

    public static void g(int i2, ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        boolean z;
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (constraintWidget.n) {
            return;
        }
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.D() && a(constraintWidget)) {
            ConstraintWidgetContainer.Y(constraintWidget, measurer, new BasicMeasure.Measure());
        }
        ConstraintAnchor constraintAnchorM = constraintWidget.m(ConstraintAnchor.Type.f1942b);
        ConstraintAnchor constraintAnchorM2 = constraintWidget.m(ConstraintAnchor.Type.f1944d);
        int iD = constraintAnchorM.d();
        int iD2 = constraintAnchorM2.d();
        HashSet hashSet = constraintAnchorM.f1932a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1966c;
        if (hashSet != null && constraintAnchorM.f1934c) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ConstraintAnchor constraintAnchor5 = (ConstraintAnchor) it.next();
                ConstraintWidget constraintWidget2 = constraintAnchor5.f1935d;
                int i3 = i2 + 1;
                boolean zA = a(constraintWidget2);
                if (constraintWidget2.D() && zA) {
                    ConstraintWidgetContainer.Y(constraintWidget2, measurer, new BasicMeasure.Measure());
                }
                ConstraintAnchor constraintAnchor6 = constraintWidget2.K;
                ConstraintAnchor constraintAnchor7 = constraintWidget2.M;
                boolean z2 = (constraintAnchor5 == constraintAnchor6 && (constraintAnchor4 = constraintAnchor7.f1937f) != null && constraintAnchor4.f1934c) || (constraintAnchor5 == constraintAnchor7 && (constraintAnchor3 = constraintAnchor6.f1937f) != null && constraintAnchor3.f1934c);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget2.U[1];
                if (dimensionBehaviour2 != dimensionBehaviour || zA) {
                    if (!constraintWidget2.D()) {
                        if (constraintAnchor5 == constraintAnchor6 && constraintAnchor7.f1937f == null) {
                            int iE = constraintAnchor6.e() + iD;
                            constraintWidget2.O(iE, constraintWidget2.o() + iE);
                            g(i3, constraintWidget2, measurer);
                        } else if (constraintAnchor5 == constraintAnchor7 && constraintAnchor6.f1937f == null) {
                            int iE2 = iD - constraintAnchor7.e();
                            constraintWidget2.O(iE2 - constraintWidget2.o(), iE2);
                            g(i3, constraintWidget2, measurer);
                        } else if (z2 && !constraintWidget2.C()) {
                            e(i3, constraintWidget2, measurer);
                        }
                    }
                } else if (dimensionBehaviour2 == dimensionBehaviour && constraintWidget2.y >= 0 && constraintWidget2.x >= 0 && (constraintWidget2.i0 == 8 || (constraintWidget2.s == 0 && constraintWidget2.Y == 0.0f))) {
                    if (!constraintWidget2.C() && !constraintWidget2.G && z2 && !constraintWidget2.C()) {
                        f(i3, constraintWidget, measurer, constraintWidget2);
                    }
                }
            }
        }
        boolean z3 = true;
        z3 = true;
        z3 = true;
        if (constraintWidget instanceof Guideline) {
            return;
        }
        HashSet hashSet2 = constraintAnchorM2.f1932a;
        if (hashSet2 != null && constraintAnchorM2.f1934c) {
            Iterator it2 = hashSet2.iterator();
            while (it2.hasNext()) {
                ConstraintAnchor constraintAnchor8 = (ConstraintAnchor) it2.next();
                ConstraintWidget constraintWidget3 = constraintAnchor8.f1935d;
                int i4 = i2 + 1;
                boolean zA2 = a(constraintWidget3);
                if (constraintWidget3.D() && zA2) {
                    ConstraintWidgetContainer.Y(constraintWidget3, measurer, new BasicMeasure.Measure());
                }
                ConstraintAnchor constraintAnchor9 = constraintWidget3.K;
                ConstraintAnchor constraintAnchor10 = constraintWidget3.M;
                boolean z4 = (constraintAnchor8 == constraintAnchor9 && (constraintAnchor2 = constraintAnchor10.f1937f) != null && constraintAnchor2.f1934c) || (constraintAnchor8 == constraintAnchor10 && (constraintAnchor = constraintAnchor9.f1937f) != null && constraintAnchor.f1934c);
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidget3.U[1];
                if (dimensionBehaviour3 != dimensionBehaviour || zA2) {
                    if (!constraintWidget3.D()) {
                        if (constraintAnchor8 == constraintAnchor9 && constraintAnchor10.f1937f == null) {
                            int iE3 = constraintAnchor9.e() + iD2;
                            constraintWidget3.O(iE3, constraintWidget3.o() + iE3);
                            g(i4, constraintWidget3, measurer);
                        } else if (constraintAnchor8 == constraintAnchor10 && constraintAnchor9.f1937f == null) {
                            int iE4 = iD2 - constraintAnchor10.e();
                            constraintWidget3.O(iE4 - constraintWidget3.o(), iE4);
                            g(i4, constraintWidget3, measurer);
                        } else if (z4 && !constraintWidget3.C()) {
                            e(i4, constraintWidget3, measurer);
                        }
                    }
                } else if (dimensionBehaviour3 == dimensionBehaviour && constraintWidget3.y >= 0 && constraintWidget3.x >= 0 && (constraintWidget3.i0 == 8 || (constraintWidget3.s == 0 && constraintWidget3.Y == 0.0f))) {
                    if (!constraintWidget3.C() && !constraintWidget3.G && z4 && !constraintWidget3.C()) {
                        f(i4, constraintWidget, measurer, constraintWidget3);
                    }
                }
            }
        }
        ConstraintAnchor constraintAnchorM3 = constraintWidget.m(ConstraintAnchor.Type.f1945e);
        if (constraintAnchorM3.f1932a != null && constraintAnchorM3.f1934c) {
            int iD3 = constraintAnchorM3.d();
            Iterator it3 = constraintAnchorM3.f1932a.iterator();
            while (it3.hasNext()) {
                ConstraintAnchor constraintAnchor11 = (ConstraintAnchor) it3.next();
                ConstraintWidget constraintWidget4 = constraintAnchor11.f1935d;
                int i5 = i2 + 1;
                boolean zA3 = a(constraintWidget4);
                if (constraintWidget4.D() && zA3) {
                    ConstraintWidgetContainer.Y(constraintWidget4, measurer, new BasicMeasure.Measure());
                }
                if (constraintWidget4.U[z3 ? 1 : 0] != dimensionBehaviour || zA3) {
                    if (!constraintWidget4.D()) {
                        ConstraintAnchor constraintAnchor12 = constraintWidget4.N;
                        if (constraintAnchor11 == constraintAnchor12) {
                            int iE5 = constraintAnchor11.e() + iD3;
                            if (constraintWidget4.E) {
                                int i6 = iE5 - constraintWidget4.c0;
                                int i7 = constraintWidget4.X + i6;
                                constraintWidget4.b0 = i6;
                                constraintWidget4.K.l(i6);
                                constraintWidget4.M.l(i7);
                                constraintAnchor12.l(iE5);
                                z = z3 ? 1 : 0;
                                constraintWidget4.f1961l = z;
                            } else {
                                z = z3 ? 1 : 0;
                            }
                            g(i5, constraintWidget4, measurer);
                        }
                        z3 = z;
                    }
                }
                z = z3 ? 1 : 0;
                z3 = z;
            }
        }
        constraintWidget.n = z3;
    }
}
