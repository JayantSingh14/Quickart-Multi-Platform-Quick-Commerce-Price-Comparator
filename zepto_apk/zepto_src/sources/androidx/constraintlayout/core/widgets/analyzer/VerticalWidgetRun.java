package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.WidgetRun;

/* loaded from: classes3.dex */
public class VerticalWidgetRun extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public final DependencyNode f2034k;

    /* renamed from: l, reason: collision with root package name */
    public BaselineDimensionDependency f2035l;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2036a;

        static {
            int[] iArr = new int[WidgetRun.RunType.values().length];
            f2036a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2036a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2036a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        DependencyNode dependencyNode = new DependencyNode(this);
        this.f2034k = dependencyNode;
        this.f2035l = null;
        this.f2050h.f2011e = DependencyNode.Type.f2024f;
        this.f2051i.f2011e = DependencyNode.Type.f2025g;
        dependencyNode.f2011e = DependencyNode.Type.f2026h;
        this.f2048f = 1;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void a(Dependency dependency) {
        float f2;
        float f3;
        float f4;
        int i2;
        if (this.f2052j.ordinal() == 3) {
            ConstraintWidget constraintWidget = this.f2044b;
            l(constraintWidget.K, constraintWidget.M, 1);
            return;
        }
        DimensionDependency dimensionDependency = this.f2047e;
        boolean z = dimensionDependency.f2009c;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1966c;
        if (z && !dimensionDependency.f2016j && this.f2046d == dimensionBehaviour) {
            ConstraintWidget constraintWidget2 = this.f2044b;
            int i3 = constraintWidget2.s;
            if (i3 == 2) {
                ConstraintWidget constraintWidget3 = constraintWidget2.V;
                if (constraintWidget3 != null) {
                    if (constraintWidget3.f1954e.f2047e.f2016j) {
                        dimensionDependency.d((int) ((r1.f2013g * constraintWidget2.z) + 0.5f));
                    }
                }
            } else if (i3 == 3) {
                DimensionDependency dimensionDependency2 = constraintWidget2.f1953d.f2047e;
                if (dimensionDependency2.f2016j) {
                    int i4 = constraintWidget2.Z;
                    if (i4 == -1) {
                        f2 = dimensionDependency2.f2013g;
                        f3 = constraintWidget2.Y;
                    } else if (i4 == 0) {
                        f4 = dimensionDependency2.f2013g * constraintWidget2.Y;
                        i2 = (int) (f4 + 0.5f);
                        dimensionDependency.d(i2);
                    } else if (i4 != 1) {
                        i2 = 0;
                        dimensionDependency.d(i2);
                    } else {
                        f2 = dimensionDependency2.f2013g;
                        f3 = constraintWidget2.Y;
                    }
                    f4 = f2 / f3;
                    i2 = (int) (f4 + 0.5f);
                    dimensionDependency.d(i2);
                }
            }
        }
        DependencyNode dependencyNode = this.f2050h;
        if (dependencyNode.f2009c) {
            DependencyNode dependencyNode2 = this.f2051i;
            if (dependencyNode2.f2009c) {
                if (dependencyNode.f2016j && dependencyNode2.f2016j && dimensionDependency.f2016j) {
                    return;
                }
                if (!dimensionDependency.f2016j && this.f2046d == dimensionBehaviour) {
                    ConstraintWidget constraintWidget4 = this.f2044b;
                    if (constraintWidget4.r == 0 && !constraintWidget4.C()) {
                        DependencyNode dependencyNode3 = (DependencyNode) dependencyNode.f2018l.get(0);
                        DependencyNode dependencyNode4 = (DependencyNode) dependencyNode2.f2018l.get(0);
                        int i5 = dependencyNode3.f2013g + dependencyNode.f2012f;
                        int i6 = dependencyNode4.f2013g + dependencyNode2.f2012f;
                        dependencyNode.d(i5);
                        dependencyNode2.d(i6);
                        dimensionDependency.d(i6 - i5);
                        return;
                    }
                }
                if (!dimensionDependency.f2016j && this.f2046d == dimensionBehaviour && this.f2043a == 1 && dependencyNode.f2018l.size() > 0 && dependencyNode2.f2018l.size() > 0) {
                    DependencyNode dependencyNode5 = (DependencyNode) dependencyNode.f2018l.get(0);
                    int i7 = (((DependencyNode) dependencyNode2.f2018l.get(0)).f2013g + dependencyNode2.f2012f) - (dependencyNode5.f2013g + dependencyNode.f2012f);
                    int i8 = dimensionDependency.f2028m;
                    if (i7 < i8) {
                        dimensionDependency.d(i7);
                    } else {
                        dimensionDependency.d(i8);
                    }
                }
                if (dimensionDependency.f2016j && dependencyNode.f2018l.size() > 0 && dependencyNode2.f2018l.size() > 0) {
                    DependencyNode dependencyNode6 = (DependencyNode) dependencyNode.f2018l.get(0);
                    DependencyNode dependencyNode7 = (DependencyNode) dependencyNode2.f2018l.get(0);
                    int i9 = dependencyNode6.f2013g;
                    int i10 = dependencyNode.f2012f + i9;
                    int i11 = dependencyNode7.f2013g;
                    int i12 = dependencyNode2.f2012f + i11;
                    float f5 = this.f2044b.g0;
                    if (dependencyNode6 == dependencyNode7) {
                        f5 = 0.5f;
                    } else {
                        i9 = i10;
                        i11 = i12;
                    }
                    dependencyNode.d((int) ((((i11 - i9) - dimensionDependency.f2013g) * f5) + i9 + 0.5f));
                    dependencyNode2.d(dependencyNode.f2013g + dimensionDependency.f2013g);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5 = this.f2044b;
        boolean z = constraintWidget5.f1950a;
        DimensionDependency dimensionDependency = this.f2047e;
        if (z) {
            dimensionDependency.d(constraintWidget5.o());
        }
        boolean z2 = dimensionDependency.f2016j;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1967d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1964a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1966c;
        DependencyNode dependencyNode = this.f2051i;
        DependencyNode dependencyNode2 = this.f2050h;
        if (!z2) {
            ConstraintWidget constraintWidget6 = this.f2044b;
            this.f2046d = constraintWidget6.U[1];
            if (constraintWidget6.E) {
                this.f2035l = new BaselineDimensionDependency(this);
            }
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = this.f2046d;
            if (dimensionBehaviour4 != dimensionBehaviour3) {
                if (dimensionBehaviour4 == dimensionBehaviour && (constraintWidget4 = this.f2044b.V) != null && constraintWidget4.U[1] == dimensionBehaviour2) {
                    int iO = (constraintWidget4.o() - this.f2044b.K.e()) - this.f2044b.M.e();
                    WidgetRun.b(dependencyNode2, constraintWidget4.f1954e.f2050h, this.f2044b.K.e());
                    WidgetRun.b(dependencyNode, constraintWidget4.f1954e.f2051i, -this.f2044b.M.e());
                    dimensionDependency.d(iO);
                    return;
                }
                if (dimensionBehaviour4 == dimensionBehaviour2) {
                    dimensionDependency.d(this.f2044b.o());
                }
            }
        } else if (this.f2046d == dimensionBehaviour && (constraintWidget2 = (constraintWidget = this.f2044b).V) != null && constraintWidget2.U[1] == dimensionBehaviour2) {
            WidgetRun.b(dependencyNode2, constraintWidget2.f1954e.f2050h, constraintWidget.K.e());
            WidgetRun.b(dependencyNode, constraintWidget2.f1954e.f2051i, -this.f2044b.M.e());
            return;
        }
        boolean z3 = dimensionDependency.f2016j;
        DependencyNode dependencyNode3 = this.f2034k;
        if (z3) {
            ConstraintWidget constraintWidget7 = this.f2044b;
            if (constraintWidget7.f1950a) {
                ConstraintAnchor[] constraintAnchorArr = constraintWidget7.R;
                ConstraintAnchor constraintAnchor = constraintAnchorArr[2];
                ConstraintAnchor constraintAnchor2 = constraintAnchor.f1937f;
                if (constraintAnchor2 != null && constraintAnchorArr[3].f1937f != null) {
                    if (constraintWidget7.C()) {
                        dependencyNode2.f2012f = this.f2044b.R[2].e();
                        dependencyNode.f2012f = -this.f2044b.R[3].e();
                    } else {
                        DependencyNode dependencyNodeH = WidgetRun.h(this.f2044b.R[2]);
                        if (dependencyNodeH != null) {
                            WidgetRun.b(dependencyNode2, dependencyNodeH, this.f2044b.R[2].e());
                        }
                        DependencyNode dependencyNodeH2 = WidgetRun.h(this.f2044b.R[3]);
                        if (dependencyNodeH2 != null) {
                            WidgetRun.b(dependencyNode, dependencyNodeH2, -this.f2044b.R[3].e());
                        }
                        dependencyNode2.f2008b = true;
                        dependencyNode.f2008b = true;
                    }
                    ConstraintWidget constraintWidget8 = this.f2044b;
                    if (constraintWidget8.E) {
                        WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget8.c0);
                        return;
                    }
                    return;
                }
                if (constraintAnchor2 != null) {
                    DependencyNode dependencyNodeH3 = WidgetRun.h(constraintAnchor);
                    if (dependencyNodeH3 != null) {
                        WidgetRun.b(dependencyNode2, dependencyNodeH3, this.f2044b.R[2].e());
                        WidgetRun.b(dependencyNode, dependencyNode2, dimensionDependency.f2013g);
                        ConstraintWidget constraintWidget9 = this.f2044b;
                        if (constraintWidget9.E) {
                            WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget9.c0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr[3];
                if (constraintAnchor3.f1937f != null) {
                    DependencyNode dependencyNodeH4 = WidgetRun.h(constraintAnchor3);
                    if (dependencyNodeH4 != null) {
                        WidgetRun.b(dependencyNode, dependencyNodeH4, -this.f2044b.R[3].e());
                        WidgetRun.b(dependencyNode2, dependencyNode, -dimensionDependency.f2013g);
                    }
                    ConstraintWidget constraintWidget10 = this.f2044b;
                    if (constraintWidget10.E) {
                        WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget10.c0);
                        return;
                    }
                    return;
                }
                ConstraintAnchor constraintAnchor4 = constraintAnchorArr[4];
                if (constraintAnchor4.f1937f != null) {
                    DependencyNode dependencyNodeH5 = WidgetRun.h(constraintAnchor4);
                    if (dependencyNodeH5 != null) {
                        WidgetRun.b(dependencyNode3, dependencyNodeH5, 0);
                        WidgetRun.b(dependencyNode2, dependencyNode3, -this.f2044b.c0);
                        WidgetRun.b(dependencyNode, dependencyNode2, dimensionDependency.f2013g);
                        return;
                    }
                    return;
                }
                if ((constraintWidget7 instanceof Helper) || constraintWidget7.V == null || constraintWidget7.m(ConstraintAnchor.Type.f1946f).f1937f != null) {
                    return;
                }
                ConstraintWidget constraintWidget11 = this.f2044b;
                WidgetRun.b(dependencyNode2, constraintWidget11.V.f1954e.f2050h, constraintWidget11.w());
                WidgetRun.b(dependencyNode, dependencyNode2, dimensionDependency.f2013g);
                ConstraintWidget constraintWidget12 = this.f2044b;
                if (constraintWidget12.E) {
                    WidgetRun.b(dependencyNode3, dependencyNode2, constraintWidget12.c0);
                    return;
                }
                return;
            }
        }
        if (z3 || this.f2046d != dimensionBehaviour3) {
            dimensionDependency.b(this);
        } else {
            ConstraintWidget constraintWidget13 = this.f2044b;
            int i2 = constraintWidget13.s;
            if (i2 == 2) {
                ConstraintWidget constraintWidget14 = constraintWidget13.V;
                if (constraintWidget14 != null) {
                    DimensionDependency dimensionDependency2 = constraintWidget14.f1954e.f2047e;
                    dimensionDependency.f2018l.add(dimensionDependency2);
                    dimensionDependency2.f2017k.add(dimensionDependency);
                    dimensionDependency.f2008b = true;
                    dimensionDependency.f2017k.add(dependencyNode2);
                    dimensionDependency.f2017k.add(dependencyNode);
                }
            } else if (i2 == 3 && !constraintWidget13.C()) {
                ConstraintWidget constraintWidget15 = this.f2044b;
                if (constraintWidget15.r != 3) {
                    DimensionDependency dimensionDependency3 = constraintWidget15.f1953d.f2047e;
                    dimensionDependency.f2018l.add(dimensionDependency3);
                    dimensionDependency3.f2017k.add(dimensionDependency);
                    dimensionDependency.f2008b = true;
                    dimensionDependency.f2017k.add(dependencyNode2);
                    dimensionDependency.f2017k.add(dependencyNode);
                }
            }
        }
        ConstraintWidget constraintWidget16 = this.f2044b;
        ConstraintAnchor[] constraintAnchorArr2 = constraintWidget16.R;
        ConstraintAnchor constraintAnchor5 = constraintAnchorArr2[2];
        ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1937f;
        if (constraintAnchor6 != null && constraintAnchorArr2[3].f1937f != null) {
            if (constraintWidget16.C()) {
                dependencyNode2.f2012f = this.f2044b.R[2].e();
                dependencyNode.f2012f = -this.f2044b.R[3].e();
            } else {
                DependencyNode dependencyNodeH6 = WidgetRun.h(this.f2044b.R[2]);
                DependencyNode dependencyNodeH7 = WidgetRun.h(this.f2044b.R[3]);
                if (dependencyNodeH6 != null) {
                    dependencyNodeH6.b(this);
                }
                if (dependencyNodeH7 != null) {
                    dependencyNodeH7.b(this);
                }
                this.f2052j = WidgetRun.RunType.f2055b;
            }
            if (this.f2044b.E) {
                c(dependencyNode3, dependencyNode2, 1, this.f2035l);
            }
        } else if (constraintAnchor6 != null) {
            DependencyNode dependencyNodeH8 = WidgetRun.h(constraintAnchor5);
            if (dependencyNodeH8 != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeH8, this.f2044b.R[2].e());
                c(dependencyNode, dependencyNode2, 1, dimensionDependency);
                if (this.f2044b.E) {
                    c(dependencyNode3, dependencyNode2, 1, this.f2035l);
                }
                if (this.f2046d == dimensionBehaviour3) {
                    ConstraintWidget constraintWidget17 = this.f2044b;
                    if (constraintWidget17.Y > 0.0f) {
                        HorizontalWidgetRun horizontalWidgetRun = constraintWidget17.f1953d;
                        if (horizontalWidgetRun.f2046d == dimensionBehaviour3) {
                            horizontalWidgetRun.f2047e.f2017k.add(dimensionDependency);
                            dimensionDependency.f2018l.add(this.f2044b.f1953d.f2047e);
                            dimensionDependency.f2007a = this;
                        }
                    }
                }
            }
        } else {
            ConstraintAnchor constraintAnchor7 = constraintAnchorArr2[3];
            if (constraintAnchor7.f1937f != null) {
                DependencyNode dependencyNodeH9 = WidgetRun.h(constraintAnchor7);
                if (dependencyNodeH9 != null) {
                    WidgetRun.b(dependencyNode, dependencyNodeH9, -this.f2044b.R[3].e());
                    c(dependencyNode2, dependencyNode, -1, dimensionDependency);
                    if (this.f2044b.E) {
                        c(dependencyNode3, dependencyNode2, 1, this.f2035l);
                    }
                }
            } else {
                ConstraintAnchor constraintAnchor8 = constraintAnchorArr2[4];
                if (constraintAnchor8.f1937f != null) {
                    DependencyNode dependencyNodeH10 = WidgetRun.h(constraintAnchor8);
                    if (dependencyNodeH10 != null) {
                        WidgetRun.b(dependencyNode3, dependencyNodeH10, 0);
                        c(dependencyNode2, dependencyNode3, -1, this.f2035l);
                        c(dependencyNode, dependencyNode2, 1, dimensionDependency);
                    }
                } else if (!(constraintWidget16 instanceof Helper) && (constraintWidget3 = constraintWidget16.V) != null) {
                    WidgetRun.b(dependencyNode2, constraintWidget3.f1954e.f2050h, constraintWidget16.w());
                    c(dependencyNode, dependencyNode2, 1, dimensionDependency);
                    if (this.f2044b.E) {
                        c(dependencyNode3, dependencyNode2, 1, this.f2035l);
                    }
                    if (this.f2046d == dimensionBehaviour3) {
                        ConstraintWidget constraintWidget18 = this.f2044b;
                        if (constraintWidget18.Y > 0.0f) {
                            HorizontalWidgetRun horizontalWidgetRun2 = constraintWidget18.f1953d;
                            if (horizontalWidgetRun2.f2046d == dimensionBehaviour3) {
                                horizontalWidgetRun2.f2047e.f2017k.add(dimensionDependency);
                                dimensionDependency.f2018l.add(this.f2044b.f1953d.f2047e);
                                dimensionDependency.f2007a = this;
                            }
                        }
                    }
                }
            }
        }
        if (dimensionDependency.f2018l.size() == 0) {
            dimensionDependency.f2009c = true;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        DependencyNode dependencyNode = this.f2050h;
        if (dependencyNode.f2016j) {
            this.f2044b.b0 = dependencyNode.f2013g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f2045c = null;
        this.f2050h.c();
        this.f2051i.c();
        this.f2034k.c();
        this.f2047e.c();
        this.f2049g = false;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        return this.f2046d != ConstraintWidget.DimensionBehaviour.f1966c || this.f2044b.s == 0;
    }

    public final void m() {
        this.f2049g = false;
        DependencyNode dependencyNode = this.f2050h;
        dependencyNode.c();
        dependencyNode.f2016j = false;
        DependencyNode dependencyNode2 = this.f2051i;
        dependencyNode2.c();
        dependencyNode2.f2016j = false;
        DependencyNode dependencyNode3 = this.f2034k;
        dependencyNode3.c();
        dependencyNode3.f2016j = false;
        this.f2047e.f2016j = false;
    }

    public final String toString() {
        return "VerticalRun " + this.f2044b.k0;
    }
}
