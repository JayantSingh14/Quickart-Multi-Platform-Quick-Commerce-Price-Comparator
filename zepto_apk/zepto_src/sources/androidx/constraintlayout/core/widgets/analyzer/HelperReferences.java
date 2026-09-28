package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.Barrier;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* loaded from: classes3.dex */
class HelperReferences extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void a(Dependency dependency) {
        Barrier barrier = (Barrier) this.f2044b;
        int i2 = barrier.w0;
        DependencyNode dependencyNode = this.f2050h;
        Iterator it = dependencyNode.f2018l.iterator();
        int i3 = 0;
        int i4 = -1;
        while (it.hasNext()) {
            int i5 = ((DependencyNode) it.next()).f2013g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i3 < i5) {
                i3 = i5;
            }
        }
        if (i2 == 0 || i2 == 2) {
            dependencyNode.d(i4 + barrier.y0);
        } else {
            dependencyNode.d(i3 + barrier.y0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget = this.f2044b;
        if (constraintWidget instanceof Barrier) {
            DependencyNode dependencyNode = this.f2050h;
            dependencyNode.f2008b = true;
            Barrier barrier = (Barrier) constraintWidget;
            int i2 = barrier.w0;
            boolean z = barrier.x0;
            int i3 = 0;
            if (i2 == 0) {
                dependencyNode.f2011e = DependencyNode.Type.f2022d;
                while (i3 < barrier.v0) {
                    ConstraintWidget constraintWidget2 = barrier.u0[i3];
                    if (z || constraintWidget2.i0 != 8) {
                        DependencyNode dependencyNode2 = constraintWidget2.f1953d.f2050h;
                        dependencyNode2.f2017k.add(dependencyNode);
                        dependencyNode.f2018l.add(dependencyNode2);
                    }
                    i3++;
                }
                m(this.f2044b.f1953d.f2050h);
                m(this.f2044b.f1953d.f2051i);
                return;
            }
            if (i2 == 1) {
                dependencyNode.f2011e = DependencyNode.Type.f2023e;
                while (i3 < barrier.v0) {
                    ConstraintWidget constraintWidget3 = barrier.u0[i3];
                    if (z || constraintWidget3.i0 != 8) {
                        DependencyNode dependencyNode3 = constraintWidget3.f1953d.f2051i;
                        dependencyNode3.f2017k.add(dependencyNode);
                        dependencyNode.f2018l.add(dependencyNode3);
                    }
                    i3++;
                }
                m(this.f2044b.f1953d.f2050h);
                m(this.f2044b.f1953d.f2051i);
                return;
            }
            if (i2 == 2) {
                dependencyNode.f2011e = DependencyNode.Type.f2024f;
                while (i3 < barrier.v0) {
                    ConstraintWidget constraintWidget4 = barrier.u0[i3];
                    if (z || constraintWidget4.i0 != 8) {
                        DependencyNode dependencyNode4 = constraintWidget4.f1954e.f2050h;
                        dependencyNode4.f2017k.add(dependencyNode);
                        dependencyNode.f2018l.add(dependencyNode4);
                    }
                    i3++;
                }
                m(this.f2044b.f1954e.f2050h);
                m(this.f2044b.f1954e.f2051i);
                return;
            }
            if (i2 != 3) {
                return;
            }
            dependencyNode.f2011e = DependencyNode.Type.f2025g;
            while (i3 < barrier.v0) {
                ConstraintWidget constraintWidget5 = barrier.u0[i3];
                if (z || constraintWidget5.i0 != 8) {
                    DependencyNode dependencyNode5 = constraintWidget5.f1954e.f2051i;
                    dependencyNode5.f2017k.add(dependencyNode);
                    dependencyNode.f2018l.add(dependencyNode5);
                }
                i3++;
            }
            m(this.f2044b.f1954e.f2050h);
            m(this.f2044b.f1954e.f2051i);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        ConstraintWidget constraintWidget = this.f2044b;
        if (constraintWidget instanceof Barrier) {
            int i2 = ((Barrier) constraintWidget).w0;
            DependencyNode dependencyNode = this.f2050h;
            if (i2 == 0 || i2 == 1) {
                constraintWidget.a0 = dependencyNode.f2013g;
            } else {
                constraintWidget.b0 = dependencyNode.f2013g;
            }
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f2045c = null;
        this.f2050h.c();
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        return false;
    }

    public final void m(DependencyNode dependencyNode) {
        DependencyNode dependencyNode2 = this.f2050h;
        dependencyNode2.f2017k.add(dependencyNode);
        dependencyNode.f2018l.add(dependencyNode2);
    }
}
