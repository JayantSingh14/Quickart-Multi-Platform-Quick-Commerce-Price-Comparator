package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes3.dex */
public class HorizontalWidgetRun extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public static final int[] f2030k = new int[2];

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2031a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f2031a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2031a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2031a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.f2050h.f2011e = DependencyNode.Type.f2022d;
        this.f2051i.f2011e = DependencyNode.Type.f2023e;
        this.f2048f = 0;
    }

    public static void m(int[] iArr, int i2, int i3, int i4, int i5, float f2, int i6) {
        int i7 = i3 - i2;
        int i8 = i5 - i4;
        if (i6 != -1) {
            if (i6 == 0) {
                iArr[0] = (int) ((i8 * f2) + 0.5f);
                iArr[1] = i8;
                return;
            } else {
                if (i6 != 1) {
                    return;
                }
                iArr[0] = i7;
                iArr[1] = (int) ((i7 * f2) + 0.5f);
                return;
            }
        }
        int i9 = (int) ((i8 * f2) + 0.5f);
        int i10 = (int) ((i7 / f2) + 0.5f);
        if (i9 <= i7) {
            iArr[0] = i9;
            iArr[1] = i8;
        } else if (i10 <= i8) {
            iArr[0] = i7;
            iArr[1] = i10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r24) {
        /*
            Method dump skipped, instructions count: 915
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        ConstraintWidget constraintWidget5 = this.f2044b;
        boolean z = constraintWidget5.f1950a;
        DimensionDependency dimensionDependency = this.f2047e;
        if (z) {
            dimensionDependency.d(constraintWidget5.u());
        }
        boolean z2 = dimensionDependency.f2016j;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1967d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1966c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1964a;
        DependencyNode dependencyNode = this.f2051i;
        DependencyNode dependencyNode2 = this.f2050h;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.f2044b;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = constraintWidget6.U[0];
            this.f2046d = dimensionBehaviour6;
            if (dimensionBehaviour6 != dimensionBehaviour4) {
                if (dimensionBehaviour6 == dimensionBehaviour3 && (constraintWidget4 = constraintWidget6.V) != null && ((dimensionBehaviour2 = constraintWidget4.U[0]) == dimensionBehaviour5 || dimensionBehaviour2 == dimensionBehaviour3)) {
                    int iU = (constraintWidget4.u() - this.f2044b.J.e()) - this.f2044b.L.e();
                    WidgetRun.b(dependencyNode2, constraintWidget4.f1953d.f2050h, this.f2044b.J.e());
                    WidgetRun.b(dependencyNode, constraintWidget4.f1953d.f2051i, -this.f2044b.L.e());
                    dimensionDependency.d(iU);
                    return;
                }
                if (dimensionBehaviour6 == dimensionBehaviour5) {
                    dimensionDependency.d(constraintWidget6.u());
                }
            }
        } else if (this.f2046d == dimensionBehaviour3 && (constraintWidget2 = (constraintWidget = this.f2044b).V) != null && ((dimensionBehaviour = constraintWidget2.U[0]) == dimensionBehaviour5 || dimensionBehaviour == dimensionBehaviour3)) {
            WidgetRun.b(dependencyNode2, constraintWidget2.f1953d.f2050h, constraintWidget.J.e());
            WidgetRun.b(dependencyNode, constraintWidget2.f1953d.f2051i, -this.f2044b.L.e());
            return;
        }
        if (dimensionDependency.f2016j) {
            ConstraintWidget constraintWidget7 = this.f2044b;
            if (constraintWidget7.f1950a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.R;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[0];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f1937f;
                if (constraintAnchor2 != null && constraintAnchorArr[1].f1937f != null) {
                    if (constraintWidget7.B()) {
                        dependencyNode2.f2012f = this.f2044b.R[0].e();
                        dependencyNode.f2012f = -this.f2044b.R[1].e();
                        return;
                    }
                    DependencyNode dependencyNodeH = WidgetRun.h(this.f2044b.R[0]);
                    if (dependencyNodeH != null) {
                        WidgetRun.b(dependencyNode2, dependencyNodeH, this.f2044b.R[0].e());
                    }
                    DependencyNode dependencyNodeH2 = WidgetRun.h(this.f2044b.R[1]);
                    if (dependencyNodeH2 != null) {
                        WidgetRun.b(dependencyNode, dependencyNodeH2, -this.f2044b.R[1].e());
                    }
                    dependencyNode2.f2008b = true;
                    dependencyNode.f2008b = true;
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = WidgetRun.h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        WidgetRun.b(dependencyNode2, dependencyNodeH3, this.f2044b.R[0].e());
                        WidgetRun.b(dependencyNode, dependencyNode2, dimensionDependency.f2013g);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[1];
                if (constraintAnchor3.f1937f != null) {
                    DependencyNode dependencyNodeH4 = WidgetRun.h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        WidgetRun.b(dependencyNode, dependencyNodeH4, -this.f2044b.R[1].e());
                        WidgetRun.b(dependencyNode2, dependencyNode, -dimensionDependency.f2013g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget7 instanceof Helper) || constraintWidget7.V == null || constraintWidget7.m(ConstraintAnchor.Type.f1946f).f1937f != null) {
                    return;
                }
                ConstraintWidget constraintWidget8 = this.f2044b;
                WidgetRun.b(dependencyNode2, constraintWidget8.V.f1953d.f2050h, constraintWidget8.v());
                WidgetRun.b(dependencyNode, dependencyNode2, dimensionDependency.f2013g);
                return;
            }
        }
        if (this.f2046d == dimensionBehaviour4) {
            ConstraintWidget constraintWidget9 = this.f2044b;
            int i2 = constraintWidget9.r;
            if (i2 == 2) {
                ConstraintWidget constraintWidget10 = constraintWidget9.V;
                if (constraintWidget10 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget10.f1954e.f2047e;
                    dimensionDependency.f2018l.add(dimensionDependency2);
                    dimensionDependency2.f2017k.add(dimensionDependency);
                    dimensionDependency.f2008b = true;
                    dimensionDependency.f2017k.add(dependencyNode2);
                    dimensionDependency.f2017k.add(dependencyNode);
                }
            } else if (i2 == 3) {
                if (constraintWidget9.s == 3) {
                    dependencyNode2.f2007a = this;
                    dependencyNode.f2007a = this;
                    VerticalWidgetRun verticalWidgetRun = constraintWidget9.f1954e;
                    verticalWidgetRun.f2050h.f2007a = this;
                    verticalWidgetRun.f2051i.f2007a = this;
                    dimensionDependency.f2007a = this;
                    if (constraintWidget9.C()) {
                        dimensionDependency.f2018l.add(this.f2044b.f1954e.f2047e);
                        this.f2044b.f1954e.f2047e.f2017k.add(dimensionDependency);
                        VerticalWidgetRun verticalWidgetRun2 = this.f2044b.f1954e;
                        verticalWidgetRun2.f2047e.f2007a = this;
                        dimensionDependency.f2018l.add(verticalWidgetRun2.f2050h);
                        dimensionDependency.f2018l.add(this.f2044b.f1954e.f2051i);
                        this.f2044b.f1954e.f2050h.f2017k.add(dimensionDependency);
                        this.f2044b.f1954e.f2051i.f2017k.add(dimensionDependency);
                    } else if (this.f2044b.B()) {
                        this.f2044b.f1954e.f2047e.f2018l.add(dimensionDependency);
                        dimensionDependency.f2017k.add(this.f2044b.f1954e.f2047e);
                    } else {
                        this.f2044b.f1954e.f2047e.f2018l.add(dimensionDependency);
                    }
                } else {
                    DimensionDependency dimensionDependency3 = constraintWidget9.f1954e.f2047e;
                    dimensionDependency.f2018l.add(dimensionDependency3);
                    dimensionDependency3.f2017k.add(dimensionDependency);
                    this.f2044b.f1954e.f2050h.f2017k.add(dimensionDependency);
                    this.f2044b.f1954e.f2051i.f2017k.add(dimensionDependency);
                    dimensionDependency.f2008b = true;
                    dimensionDependency.f2017k.add(dependencyNode2);
                    dimensionDependency.f2017k.add(dependencyNode);
                    dependencyNode2.f2018l.add(dimensionDependency);
                    dependencyNode.f2018l.add(dimensionDependency);
                }
            }
        }
        ConstraintWidget constraintWidget11 = this.f2044b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget11.R;
        ConstraintAnchor constraintAnchor4 = constraintAnchorArr2[0];
        ConstraintAnchor constraintAnchor5 = constraintAnchor4.f1937f;
        if (constraintAnchor5 != null && constraintAnchorArr2[1].f1937f != null) {
            if (constraintWidget11.B()) {
                dependencyNode2.f2012f = this.f2044b.R[0].e();
                dependencyNode.f2012f = -this.f2044b.R[1].e();
                return;
            }
            DependencyNode dependencyNodeH5 = WidgetRun.h(this.f2044b.R[0]);
            DependencyNode dependencyNodeH6 = WidgetRun.h(this.f2044b.R[1]);
            if (dependencyNodeH5 != null) {
                dependencyNodeH5.b(this);
            }
            if (dependencyNodeH6 != null) {
                dependencyNodeH6.b(this);
            }
            this.f2052j = WidgetRun.RunType.f2055b;
            return;
        }
        if (constraintAnchor5 != null) {
            DependencyNode dependencyNodeH7 = WidgetRun.h(constraintAnchor4);
            if (dependencyNodeH7 != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeH7, this.f2044b.R[0].e());
                c(dependencyNode, dependencyNode2, 1, dimensionDependency);
                return;
            }
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr2[1];
        if (constraintAnchor6.f1937f != null) {
            DependencyNode dependencyNodeH8 = WidgetRun.h(constraintAnchor6);
            if (dependencyNodeH8 != null) {
                WidgetRun.b(dependencyNode, dependencyNodeH8, -this.f2044b.R[1].e());
                c(dependencyNode2, dependencyNode, -1, dimensionDependency);
                return;
            }
            return;
        }
        if ((constraintWidget11 instanceof Helper) || (constraintWidget3 = constraintWidget11.V) == null) {
            return;
        }
        WidgetRun.b(dependencyNode2, constraintWidget3.f1953d.f2050h, constraintWidget11.v());
        c(dependencyNode, dependencyNode2, 1, dimensionDependency);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        DependencyNode dependencyNode = this.f2050h;
        if (dependencyNode.f2016j) {
            this.f2044b.a0 = dependencyNode.f2013g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f2045c = null;
        this.f2050h.c();
        this.f2051i.c();
        this.f2047e.c();
        this.f2049g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        return this.f2046d != ConstraintWidget.DimensionBehaviour.f1966c || this.f2044b.r == 0;
    }

    public final void n() {
        this.f2049g = false;
        DependencyNode dependencyNode = this.f2050h;
        dependencyNode.c();
        dependencyNode.f2016j = false;
        DependencyNode dependencyNode2 = this.f2051i;
        dependencyNode2.c();
        dependencyNode2.f2016j = false;
        this.f2047e.f2016j = false;
    }

    public final String toString() {
        return "HorizontalRun " + this.f2044b.k0;
    }
}
