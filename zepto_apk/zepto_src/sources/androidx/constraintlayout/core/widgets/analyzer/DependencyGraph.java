package androidx.constraintlayout.core.widgets.analyzer;

import android.support.v4.media.a;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DependencyGraph {

    /* renamed from: a, reason: collision with root package name */
    public ConstraintWidgetContainer f1999a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2000b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2001c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidgetContainer f2002d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f2003e;

    /* renamed from: f, reason: collision with root package name */
    public BasicMeasure.Measurer f2004f;

    /* renamed from: g, reason: collision with root package name */
    public BasicMeasure.Measure f2005g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f2006h;

    public final void a(DependencyNode dependencyNode, int i2, ArrayList arrayList, RunGroup runGroup) {
        WidgetRun widgetRun = dependencyNode.f2010d;
        if (widgetRun.f2045c == null) {
            ConstraintWidgetContainer constraintWidgetContainer = this.f1999a;
            if (widgetRun == constraintWidgetContainer.f1953d || widgetRun == constraintWidgetContainer.f1954e) {
                return;
            }
            if (runGroup == null) {
                runGroup = new RunGroup();
                runGroup.f2032a = null;
                runGroup.f2033b = new ArrayList();
                runGroup.f2032a = widgetRun;
                arrayList.add(runGroup);
            }
            widgetRun.f2045c = runGroup;
            runGroup.f2033b.add(widgetRun);
            DependencyNode dependencyNode2 = widgetRun.f2050h;
            Iterator it = dependencyNode2.f2017k.iterator();
            while (it.hasNext()) {
                Dependency dependency = (Dependency) it.next();
                if (dependency instanceof DependencyNode) {
                    a((DependencyNode) dependency, i2, arrayList, runGroup);
                }
            }
            DependencyNode dependencyNode3 = widgetRun.f2051i;
            Iterator it2 = dependencyNode3.f2017k.iterator();
            while (it2.hasNext()) {
                Dependency dependency2 = (Dependency) it2.next();
                if (dependency2 instanceof DependencyNode) {
                    a((DependencyNode) dependency2, i2, arrayList, runGroup);
                }
            }
            if (i2 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                Iterator it3 = ((VerticalWidgetRun) widgetRun).f2034k.f2017k.iterator();
                while (it3.hasNext()) {
                    Dependency dependency3 = (Dependency) it3.next();
                    if (dependency3 instanceof DependencyNode) {
                        a((DependencyNode) dependency3, i2, arrayList, runGroup);
                    }
                }
            }
            Iterator it4 = dependencyNode2.f2018l.iterator();
            while (it4.hasNext()) {
                a((DependencyNode) it4.next(), i2, arrayList, runGroup);
            }
            Iterator it5 = dependencyNode3.f2018l.iterator();
            while (it5.hasNext()) {
                a((DependencyNode) it5.next(), i2, arrayList, runGroup);
            }
            if (i2 == 1 && (widgetRun instanceof VerticalWidgetRun)) {
                Iterator it6 = ((VerticalWidgetRun) widgetRun).f2034k.f2018l.iterator();
                while (it6.hasNext()) {
                    a((DependencyNode) it6.next(), i2, arrayList, runGroup);
                }
            }
        }
    }

    public final void b(ConstraintWidgetContainer constraintWidgetContainer) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        float f2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6;
        Iterator it = constraintWidgetContainer.u0.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour8 = dimensionBehaviourArr[1];
            if (constraintWidget.i0 == 8) {
                constraintWidget.f1950a = true;
            } else {
                float f3 = constraintWidget.w;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour9 = ConstraintWidget.DimensionBehaviour.f1966c;
                if (f3 < 1.0f && dimensionBehaviour7 == dimensionBehaviour9) {
                    constraintWidget.r = 2;
                }
                float f4 = constraintWidget.z;
                if (f4 < 1.0f && dimensionBehaviour8 == dimensionBehaviour9) {
                    constraintWidget.s = 2;
                }
                float f5 = constraintWidget.Y;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour10 = ConstraintWidget.DimensionBehaviour.f1965b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour11 = ConstraintWidget.DimensionBehaviour.f1964a;
                if (f5 > 0.0f) {
                    if (dimensionBehaviour7 == dimensionBehaviour9 && (dimensionBehaviour8 == dimensionBehaviour10 || dimensionBehaviour8 == dimensionBehaviour11)) {
                        constraintWidget.r = 3;
                    } else if (dimensionBehaviour8 == dimensionBehaviour9 && (dimensionBehaviour7 == dimensionBehaviour10 || dimensionBehaviour7 == dimensionBehaviour11)) {
                        constraintWidget.s = 3;
                    } else if (dimensionBehaviour7 == dimensionBehaviour9 && dimensionBehaviour8 == dimensionBehaviour9) {
                        if (constraintWidget.r == 0) {
                            constraintWidget.r = 3;
                        }
                        if (constraintWidget.s == 0) {
                            constraintWidget.s = 3;
                        }
                    }
                }
                ConstraintAnchor constraintAnchor = constraintWidget.L;
                ConstraintAnchor constraintAnchor2 = constraintWidget.J;
                if (dimensionBehaviour7 == dimensionBehaviour9 && constraintWidget.r == 1 && (constraintAnchor2.f1937f == null || constraintAnchor.f1937f == null)) {
                    dimensionBehaviour7 = dimensionBehaviour10;
                }
                ConstraintAnchor constraintAnchor3 = constraintWidget.M;
                ConstraintAnchor constraintAnchor4 = constraintWidget.K;
                if (dimensionBehaviour8 == dimensionBehaviour9 && constraintWidget.s == 1 && (constraintAnchor4.f1937f == null || constraintAnchor3.f1937f == null)) {
                    dimensionBehaviour8 = dimensionBehaviour10;
                }
                HorizontalWidgetRun horizontalWidgetRun = constraintWidget.f1953d;
                horizontalWidgetRun.f2046d = dimensionBehaviour7;
                int i2 = constraintWidget.r;
                horizontalWidgetRun.f2043a = i2;
                VerticalWidgetRun verticalWidgetRun = constraintWidget.f1954e;
                verticalWidgetRun.f2046d = dimensionBehaviour8;
                Iterator it2 = it;
                int i3 = constraintWidget.s;
                verticalWidgetRun.f2043a = i3;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour12 = ConstraintWidget.DimensionBehaviour.f1967d;
                if ((dimensionBehaviour7 == dimensionBehaviour12 || dimensionBehaviour7 == dimensionBehaviour11 || dimensionBehaviour7 == dimensionBehaviour10) && (dimensionBehaviour8 == dimensionBehaviour12 || dimensionBehaviour8 == dimensionBehaviour11 || dimensionBehaviour8 == dimensionBehaviour10)) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour13 = dimensionBehaviour8;
                    int iU = constraintWidget.u();
                    if (dimensionBehaviour7 == dimensionBehaviour12) {
                        iU = (constraintWidgetContainer.u() - constraintAnchor2.f1938g) - constraintAnchor.f1938g;
                        dimensionBehaviour7 = dimensionBehaviour11;
                    }
                    int i4 = iU;
                    int iO = constraintWidget.o();
                    if (dimensionBehaviour13 == dimensionBehaviour12) {
                        iO = (constraintWidgetContainer.o() - constraintAnchor4.f1938g) - constraintAnchor3.f1938g;
                        dimensionBehaviour13 = dimensionBehaviour11;
                    }
                    h(constraintWidget, dimensionBehaviour7, i4, dimensionBehaviour13, iO);
                    constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                    constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                    constraintWidget.f1950a = true;
                } else {
                    ConstraintAnchor[] constraintAnchorArr = constraintWidget.R;
                    if (dimensionBehaviour7 != dimensionBehaviour9 || (dimensionBehaviour8 != dimensionBehaviour10 && dimensionBehaviour8 != dimensionBehaviour11)) {
                        dimensionBehaviour = dimensionBehaviour7;
                        dimensionBehaviour2 = dimensionBehaviour10;
                        f2 = f4;
                        dimensionBehaviour3 = dimensionBehaviour11;
                        dimensionBehaviour4 = dimensionBehaviour8;
                    } else if (i2 == 3) {
                        if (dimensionBehaviour8 == dimensionBehaviour10) {
                            h(constraintWidget, dimensionBehaviour10, 0, dimensionBehaviour10, 0);
                        }
                        int iO2 = constraintWidget.o();
                        h(constraintWidget, dimensionBehaviour11, (int) ((iO2 * constraintWidget.Y) + 0.5f), dimensionBehaviour11, iO2);
                        constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                        constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                        constraintWidget.f1950a = true;
                    } else {
                        dimensionBehaviour = dimensionBehaviour7;
                        dimensionBehaviour2 = dimensionBehaviour10;
                        dimensionBehaviour3 = dimensionBehaviour11;
                        if (i2 == 1) {
                            h(constraintWidget, dimensionBehaviour2, 0, dimensionBehaviour8, 0);
                            constraintWidget.f1953d.f2047e.f2028m = constraintWidget.u();
                        } else {
                            f2 = f4;
                            dimensionBehaviour4 = dimensionBehaviour8;
                            if (i2 == 2) {
                                ConstraintWidget.DimensionBehaviour dimensionBehaviour14 = constraintWidgetContainer.U[0];
                                if (dimensionBehaviour14 == dimensionBehaviour3 || dimensionBehaviour14 == dimensionBehaviour12) {
                                    h(constraintWidget, dimensionBehaviour3, (int) ((f3 * constraintWidgetContainer.u()) + 0.5f), dimensionBehaviour4, constraintWidget.o());
                                    constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                                    constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                                    constraintWidget.f1950a = true;
                                }
                            } else if (constraintAnchorArr[0].f1937f == null || constraintAnchorArr[1].f1937f == null) {
                                h(constraintWidget, dimensionBehaviour2, 0, dimensionBehaviour4, 0);
                                constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                                constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                                constraintWidget.f1950a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour4 != dimensionBehaviour9 || (dimensionBehaviour != dimensionBehaviour2 && dimensionBehaviour != dimensionBehaviour3)) {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour15 = dimensionBehaviour;
                        dimensionBehaviour5 = dimensionBehaviour2;
                        dimensionBehaviour6 = dimensionBehaviour15;
                    } else if (i3 == 3) {
                        if (dimensionBehaviour == dimensionBehaviour2) {
                            h(constraintWidget, dimensionBehaviour2, 0, dimensionBehaviour2, 0);
                        }
                        int iU2 = constraintWidget.u();
                        float f6 = constraintWidget.Y;
                        if (constraintWidget.Z == -1) {
                            f6 = 1.0f / f6;
                        }
                        h(constraintWidget, dimensionBehaviour3, iU2, dimensionBehaviour3, (int) ((iU2 * f6) + 0.5f));
                        constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                        constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                        constraintWidget.f1950a = true;
                    } else if (i3 == 1) {
                        h(constraintWidget, dimensionBehaviour, 0, dimensionBehaviour2, 0);
                        constraintWidget.f1954e.f2047e.f2028m = constraintWidget.o();
                    } else {
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour16 = dimensionBehaviour;
                        dimensionBehaviour5 = dimensionBehaviour2;
                        if (i3 == 2) {
                            ConstraintWidget.DimensionBehaviour dimensionBehaviour17 = constraintWidgetContainer.U[1];
                            if (dimensionBehaviour17 == dimensionBehaviour3 || dimensionBehaviour17 == dimensionBehaviour12) {
                                h(constraintWidget, dimensionBehaviour16, constraintWidget.u(), dimensionBehaviour3, (int) ((f2 * constraintWidgetContainer.o()) + 0.5f));
                                constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                                constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                                constraintWidget.f1950a = true;
                            } else {
                                dimensionBehaviour6 = dimensionBehaviour16;
                            }
                        } else {
                            dimensionBehaviour6 = dimensionBehaviour16;
                            if (constraintAnchorArr[2].f1937f == null || constraintAnchorArr[3].f1937f == null) {
                                h(constraintWidget, dimensionBehaviour5, 0, dimensionBehaviour4, 0);
                                constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                                constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                                constraintWidget.f1950a = true;
                            }
                        }
                    }
                    if (dimensionBehaviour6 == dimensionBehaviour9 && dimensionBehaviour4 == dimensionBehaviour9) {
                        if (i2 == 1 || i3 == 1) {
                            h(constraintWidget, dimensionBehaviour5, 0, dimensionBehaviour5, 0);
                            constraintWidget.f1953d.f2047e.f2028m = constraintWidget.u();
                            constraintWidget.f1954e.f2047e.f2028m = constraintWidget.o();
                        } else if (i3 == 2 && i2 == 2) {
                            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidgetContainer.U;
                            if (dimensionBehaviourArr2[0] == dimensionBehaviour3 && dimensionBehaviourArr2[1] == dimensionBehaviour3) {
                                h(constraintWidget, dimensionBehaviour3, (int) ((f3 * constraintWidgetContainer.u()) + 0.5f), dimensionBehaviour3, (int) ((f2 * constraintWidgetContainer.o()) + 0.5f));
                                constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                                constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                                constraintWidget.f1950a = true;
                            }
                        }
                    }
                }
                it = it2;
            }
        }
    }

    public final void c() {
        ArrayList arrayList = this.f2003e;
        arrayList.clear();
        ConstraintWidgetContainer constraintWidgetContainer = this.f2002d;
        constraintWidgetContainer.f1953d.f();
        constraintWidgetContainer.f1954e.f();
        arrayList.add(constraintWidgetContainer.f1953d);
        arrayList.add(constraintWidgetContainer.f1954e);
        Iterator it = constraintWidgetContainer.u0.iterator();
        HashSet hashSet = null;
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (constraintWidget instanceof Guideline) {
                GuidelineReference guidelineReference = new GuidelineReference(constraintWidget);
                constraintWidget.f1953d.f();
                constraintWidget.f1954e.f();
                guidelineReference.f2048f = ((Guideline) constraintWidget).y0;
                arrayList.add(guidelineReference);
            } else {
                if (constraintWidget.B()) {
                    if (constraintWidget.f1951b == null) {
                        constraintWidget.f1951b = new ChainRun(constraintWidget, 0);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f1951b);
                } else {
                    arrayList.add(constraintWidget.f1953d);
                }
                if (constraintWidget.C()) {
                    if (constraintWidget.f1952c == null) {
                        constraintWidget.f1952c = new ChainRun(constraintWidget, 1);
                    }
                    if (hashSet == null) {
                        hashSet = new HashSet();
                    }
                    hashSet.add(constraintWidget.f1952c);
                } else {
                    arrayList.add(constraintWidget.f1954e);
                }
                if (constraintWidget instanceof HelperWidget) {
                    arrayList.add(new HelperReferences(constraintWidget));
                }
            }
        }
        if (hashSet != null) {
            arrayList.addAll(hashSet);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((WidgetRun) it2.next()).f();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.f2044b != constraintWidgetContainer) {
                widgetRun.d();
            }
        }
        ArrayList arrayList2 = this.f2006h;
        arrayList2.clear();
        ConstraintWidgetContainer constraintWidgetContainer2 = this.f1999a;
        g(constraintWidgetContainer2.f1953d, 0, arrayList2);
        g(constraintWidgetContainer2.f1954e, 1, arrayList2);
        this.f2000b = false;
    }

    public final int d(ConstraintWidgetContainer constraintWidgetContainer, int i2) {
        ArrayList arrayList;
        int i3;
        int i4;
        long jMax;
        float f2;
        ConstraintWidgetContainer constraintWidgetContainer2 = constraintWidgetContainer;
        ArrayList arrayList2 = this.f2006h;
        int size = arrayList2.size();
        int i5 = 0;
        long jMax2 = 0;
        while (i5 < size) {
            WidgetRun widgetRun = ((RunGroup) arrayList2.get(i5)).f2032a;
            if (!(widgetRun instanceof ChainRun) ? !(i2 != 0 ? (widgetRun instanceof VerticalWidgetRun) : (widgetRun instanceof HorizontalWidgetRun)) : ((ChainRun) widgetRun).f2048f != i2) {
                DependencyNode dependencyNode = (i2 == 0 ? constraintWidgetContainer2.f1953d : constraintWidgetContainer2.f1954e).f2050h;
                DependencyNode dependencyNode2 = (i2 == 0 ? constraintWidgetContainer2.f1953d : constraintWidgetContainer2.f1954e).f2051i;
                boolean zContains = widgetRun.f2050h.f2018l.contains(dependencyNode);
                DependencyNode dependencyNode3 = widgetRun.f2051i;
                boolean zContains2 = dependencyNode3.f2018l.contains(dependencyNode2);
                long j2 = widgetRun.j();
                DependencyNode dependencyNode4 = widgetRun.f2050h;
                if (zContains && zContains2) {
                    long jB = RunGroup.b(dependencyNode4, 0L);
                    ArrayList arrayList3 = arrayList2;
                    i3 = size;
                    long jA = RunGroup.a(dependencyNode3, 0L);
                    long j3 = jB - j2;
                    int i6 = dependencyNode3.f2012f;
                    arrayList = arrayList3;
                    i4 = i5;
                    if (j3 >= (-i6)) {
                        j3 += i6;
                    }
                    long j4 = (-jA) - j2;
                    long j5 = dependencyNode4.f2012f;
                    long j6 = j4 - j5;
                    if (j6 >= j5) {
                        j6 -= j5;
                    }
                    ConstraintWidget constraintWidget = widgetRun.f2044b;
                    if (i2 == 0) {
                        f2 = constraintWidget.f0;
                    } else if (i2 == 1) {
                        f2 = constraintWidget.g0;
                    } else {
                        constraintWidget.getClass();
                        f2 = -1.0f;
                    }
                    float f3 = f2 > 0.0f ? (long) ((j3 / (1.0f - f2)) + (j6 / f2)) : 0L;
                    jMax = (dependencyNode4.f2012f + ((((long) ((f3 * f2) + 0.5f)) + j2) + ((long) a.a(1.0f, f2, f3, 0.5f)))) - dependencyNode3.f2012f;
                } else {
                    arrayList = arrayList2;
                    i3 = size;
                    i4 = i5;
                    jMax = zContains ? Math.max(RunGroup.b(dependencyNode4, dependencyNode4.f2012f), dependencyNode4.f2012f + j2) : zContains2 ? Math.max(-RunGroup.a(dependencyNode3, dependencyNode3.f2012f), (-dependencyNode3.f2012f) + j2) : (widgetRun.j() + dependencyNode4.f2012f) - dependencyNode3.f2012f;
                }
            } else {
                arrayList = arrayList2;
                i3 = size;
                i4 = i5;
                jMax = 0;
            }
            jMax2 = Math.max(jMax2, jMax);
            i5 = i4 + 1;
            constraintWidgetContainer2 = constraintWidgetContainer;
            size = i3;
            arrayList2 = arrayList;
        }
        return (int) jMax2;
    }

    public final boolean e(boolean z) {
        boolean z2;
        boolean z3 = this.f2000b;
        ConstraintWidgetContainer constraintWidgetContainer = this.f1999a;
        boolean z4 = false;
        if (z3 || this.f2001c) {
            Iterator it = constraintWidgetContainer.u0.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.l();
                constraintWidget.f1950a = false;
                constraintWidget.f1953d.n();
                constraintWidget.f1954e.m();
            }
            constraintWidgetContainer.l();
            constraintWidgetContainer.f1950a = false;
            constraintWidgetContainer.f1953d.n();
            constraintWidgetContainer.f1954e.m();
            this.f2001c = false;
        }
        b(this.f2002d);
        constraintWidgetContainer.a0 = 0;
        constraintWidgetContainer.b0 = 0;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourN = constraintWidgetContainer.n(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourN2 = constraintWidgetContainer.n(1);
        if (this.f2000b) {
            c();
        }
        int iV = constraintWidgetContainer.v();
        int iW = constraintWidgetContainer.w();
        constraintWidgetContainer.f1953d.f2050h.d(iV);
        constraintWidgetContainer.f1954e.f2050h.d(iW);
        i();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1965b;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1964a;
        ArrayList arrayList = this.f2003e;
        if (dimensionBehaviourN == dimensionBehaviour || dimensionBehaviourN2 == dimensionBehaviour) {
            if (z) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    if (!((WidgetRun) it2.next()).k()) {
                        z = false;
                        break;
                    }
                }
            }
            if (z && dimensionBehaviourN == dimensionBehaviour) {
                constraintWidgetContainer.Q(dimensionBehaviour2);
                constraintWidgetContainer.S(d(constraintWidgetContainer, 0));
                constraintWidgetContainer.f1953d.f2047e.d(constraintWidgetContainer.u());
            }
            if (z && dimensionBehaviourN2 == dimensionBehaviour) {
                constraintWidgetContainer.R(dimensionBehaviour2);
                constraintWidgetContainer.P(d(constraintWidgetContainer, 1));
                constraintWidgetContainer.f1954e.f2047e.d(constraintWidgetContainer.o());
            }
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = constraintWidgetContainer.U[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1967d;
        if (dimensionBehaviour3 == dimensionBehaviour2 || dimensionBehaviour3 == dimensionBehaviour4) {
            int iU = constraintWidgetContainer.u() + iV;
            constraintWidgetContainer.f1953d.f2051i.d(iU);
            constraintWidgetContainer.f1953d.f2047e.d(iU - iV);
            i();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer.U[1];
            if (dimensionBehaviour5 == dimensionBehaviour2 || dimensionBehaviour5 == dimensionBehaviour4) {
                int iO = constraintWidgetContainer.o() + iW;
                constraintWidgetContainer.f1954e.f2051i.d(iO);
                constraintWidgetContainer.f1954e.f2047e.d(iO - iW);
            }
            i();
            z2 = true;
        } else {
            z2 = false;
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it3.next();
            if (widgetRun.f2044b != constraintWidgetContainer || widgetRun.f2049g) {
                widgetRun.e();
            }
        }
        Iterator it4 = arrayList.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z4 = true;
                break;
            }
            WidgetRun widgetRun2 = (WidgetRun) it4.next();
            if (z2 || widgetRun2.f2044b != constraintWidgetContainer) {
                if (!widgetRun2.f2050h.f2016j || ((!widgetRun2.f2051i.f2016j && !(widgetRun2 instanceof GuidelineReference)) || (!widgetRun2.f2047e.f2016j && !(widgetRun2 instanceof ChainRun) && !(widgetRun2 instanceof GuidelineReference)))) {
                    break;
                }
            }
        }
        constraintWidgetContainer.Q(dimensionBehaviourN);
        constraintWidgetContainer.R(dimensionBehaviourN2);
        return z4;
    }

    public final boolean f(int i2, boolean z) {
        boolean z2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidgetContainer constraintWidgetContainer = this.f1999a;
        boolean z3 = false;
        ConstraintWidget.DimensionBehaviour dimensionBehaviourN = constraintWidgetContainer.n(0);
        ConstraintWidget.DimensionBehaviour dimensionBehaviourN2 = constraintWidgetContainer.n(1);
        int iV = constraintWidgetContainer.v();
        int iW = constraintWidgetContainer.w();
        ArrayList arrayList = this.f2003e;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1964a;
        if (z && (dimensionBehaviourN == (dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1965b) || dimensionBehaviourN2 == dimensionBehaviour)) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WidgetRun widgetRun = (WidgetRun) it.next();
                if (widgetRun.f2048f == i2 && !widgetRun.k()) {
                    z = false;
                    break;
                }
            }
            if (i2 == 0) {
                if (z && dimensionBehaviourN == dimensionBehaviour) {
                    constraintWidgetContainer.Q(dimensionBehaviour2);
                    constraintWidgetContainer.S(d(constraintWidgetContainer, 0));
                    constraintWidgetContainer.f1953d.f2047e.d(constraintWidgetContainer.u());
                }
            } else if (z && dimensionBehaviourN2 == dimensionBehaviour) {
                constraintWidgetContainer.R(dimensionBehaviour2);
                constraintWidgetContainer.P(d(constraintWidgetContainer, 1));
                constraintWidgetContainer.f1954e.f2047e.d(constraintWidgetContainer.o());
            }
        }
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1967d;
        if (i2 == 0) {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = constraintWidgetContainer.U[0];
            if (dimensionBehaviour4 == dimensionBehaviour2 || dimensionBehaviour4 == dimensionBehaviour3) {
                int iU = constraintWidgetContainer.u() + iV;
                constraintWidgetContainer.f1953d.f2051i.d(iU);
                constraintWidgetContainer.f1953d.f2047e.d(iU - iV);
                z2 = true;
            }
            z2 = false;
        } else {
            ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = constraintWidgetContainer.U[1];
            if (dimensionBehaviour5 == dimensionBehaviour2 || dimensionBehaviour5 == dimensionBehaviour3) {
                int iO = constraintWidgetContainer.o() + iW;
                constraintWidgetContainer.f1954e.f2051i.d(iO);
                constraintWidgetContainer.f1954e.f2047e.d(iO - iW);
                z2 = true;
            }
            z2 = false;
        }
        i();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            WidgetRun widgetRun2 = (WidgetRun) it2.next();
            if (widgetRun2.f2048f == i2 && (widgetRun2.f2044b != constraintWidgetContainer || widgetRun2.f2049g)) {
                widgetRun2.e();
            }
        }
        Iterator it3 = arrayList.iterator();
        while (true) {
            if (!it3.hasNext()) {
                z3 = true;
                break;
            }
            WidgetRun widgetRun3 = (WidgetRun) it3.next();
            if (widgetRun3.f2048f == i2 && (z2 || widgetRun3.f2044b != constraintWidgetContainer)) {
                if (!widgetRun3.f2050h.f2016j || !widgetRun3.f2051i.f2016j || (!(widgetRun3 instanceof ChainRun) && !widgetRun3.f2047e.f2016j)) {
                    break;
                }
            }
        }
        constraintWidgetContainer.Q(dimensionBehaviourN);
        constraintWidgetContainer.R(dimensionBehaviourN2);
        return z3;
    }

    public final void g(WidgetRun widgetRun, int i2, ArrayList arrayList) {
        DependencyNode dependencyNode;
        Iterator it = widgetRun.f2050h.f2017k.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            dependencyNode = widgetRun.f2051i;
            if (!zHasNext) {
                break;
            }
            Dependency dependency = (Dependency) it.next();
            if (dependency instanceof DependencyNode) {
                a((DependencyNode) dependency, i2, arrayList, null);
            } else if (dependency instanceof WidgetRun) {
                a(((WidgetRun) dependency).f2050h, i2, arrayList, null);
            }
        }
        Iterator it2 = dependencyNode.f2017k.iterator();
        while (it2.hasNext()) {
            Dependency dependency2 = (Dependency) it2.next();
            if (dependency2 instanceof DependencyNode) {
                a((DependencyNode) dependency2, i2, arrayList, null);
            } else if (dependency2 instanceof WidgetRun) {
                a(((WidgetRun) dependency2).f2051i, i2, arrayList, null);
            }
        }
        if (i2 == 1) {
            Iterator it3 = ((VerticalWidgetRun) widgetRun).f2034k.f2017k.iterator();
            while (it3.hasNext()) {
                Dependency dependency3 = (Dependency) it3.next();
                if (dependency3 instanceof DependencyNode) {
                    a((DependencyNode) dependency3, i2, arrayList, null);
                }
            }
        }
    }

    public final void h(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        BasicMeasure.Measure measure = this.f2005g;
        measure.f1987a = dimensionBehaviour;
        measure.f1988b = dimensionBehaviour2;
        measure.f1989c = i2;
        measure.f1990d = i3;
        this.f2004f.b(constraintWidget, measure);
        constraintWidget.S(measure.f1991e);
        constraintWidget.P(measure.f1992f);
        constraintWidget.E = measure.f1994h;
        constraintWidget.M(measure.f1993g);
    }

    public final void i() {
        BaselineDimensionDependency baselineDimensionDependency;
        Iterator it = this.f1999a.u0.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            if (!constraintWidget.f1950a) {
                ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
                boolean z = false;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = dimensionBehaviourArr[1];
                int i2 = constraintWidget.r;
                int i3 = constraintWidget.s;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1965b;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1966c;
                boolean z2 = dimensionBehaviour == dimensionBehaviour3 || (dimensionBehaviour == dimensionBehaviour4 && i2 == 1);
                if (dimensionBehaviour2 == dimensionBehaviour3 || (dimensionBehaviour2 == dimensionBehaviour4 && i3 == 1)) {
                    z = true;
                }
                DimensionDependency dimensionDependency = constraintWidget.f1953d.f2047e;
                boolean z3 = dimensionDependency.f2016j;
                DimensionDependency dimensionDependency2 = constraintWidget.f1954e.f2047e;
                boolean z4 = dimensionDependency2.f2016j;
                boolean z5 = z2;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1964a;
                if (z3 && z4) {
                    h(constraintWidget, dimensionBehaviour5, dimensionDependency.f2013g, dimensionBehaviour5, dimensionDependency2.f2013g);
                    constraintWidget.f1950a = true;
                } else if (z3 && z) {
                    h(constraintWidget, dimensionBehaviour5, dimensionDependency.f2013g, dimensionBehaviour3, dimensionDependency2.f2013g);
                    if (dimensionBehaviour2 == dimensionBehaviour4) {
                        constraintWidget.f1954e.f2047e.f2028m = constraintWidget.o();
                    } else {
                        constraintWidget.f1954e.f2047e.d(constraintWidget.o());
                        constraintWidget.f1950a = true;
                    }
                } else if (z4 && z5) {
                    h(constraintWidget, dimensionBehaviour3, dimensionDependency.f2013g, dimensionBehaviour5, dimensionDependency2.f2013g);
                    if (dimensionBehaviour == dimensionBehaviour4) {
                        constraintWidget.f1953d.f2047e.f2028m = constraintWidget.u();
                    } else {
                        constraintWidget.f1953d.f2047e.d(constraintWidget.u());
                        constraintWidget.f1950a = true;
                    }
                }
                if (constraintWidget.f1950a && (baselineDimensionDependency = constraintWidget.f1954e.f2035l) != null) {
                    baselineDimensionDependency.d(constraintWidget.c0);
                }
            }
        }
    }
}
