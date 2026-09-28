package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;

/* loaded from: classes3.dex */
class GuidelineReference extends WidgetRun {
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void a(Dependency dependency) {
        DependencyNode dependencyNode = this.f2050h;
        if (dependencyNode.f2009c && !dependencyNode.f2016j) {
            dependencyNode.d((int) ((((DependencyNode) dependencyNode.f2018l.get(0)).f2013g * ((Guideline) this.f2044b).u0) + 0.5f));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ConstraintWidget constraintWidget = this.f2044b;
        Guideline guideline = (Guideline) constraintWidget;
        int i2 = guideline.v0;
        int i3 = guideline.w0;
        int i4 = guideline.y0;
        DependencyNode dependencyNode = this.f2050h;
        if (i4 == 1) {
            if (i2 != -1) {
                dependencyNode.f2018l.add(constraintWidget.V.f1953d.f2050h);
                this.f2044b.V.f1953d.f2050h.f2017k.add(dependencyNode);
                dependencyNode.f2012f = i2;
            } else if (i3 != -1) {
                dependencyNode.f2018l.add(constraintWidget.V.f1953d.f2051i);
                this.f2044b.V.f1953d.f2051i.f2017k.add(dependencyNode);
                dependencyNode.f2012f = -i3;
            } else {
                dependencyNode.f2008b = true;
                dependencyNode.f2018l.add(constraintWidget.V.f1953d.f2051i);
                this.f2044b.V.f1953d.f2051i.f2017k.add(dependencyNode);
            }
            m(this.f2044b.f1953d.f2050h);
            m(this.f2044b.f1953d.f2051i);
            return;
        }
        if (i2 != -1) {
            dependencyNode.f2018l.add(constraintWidget.V.f1954e.f2050h);
            this.f2044b.V.f1954e.f2050h.f2017k.add(dependencyNode);
            dependencyNode.f2012f = i2;
        } else if (i3 != -1) {
            dependencyNode.f2018l.add(constraintWidget.V.f1954e.f2051i);
            this.f2044b.V.f1954e.f2051i.f2017k.add(dependencyNode);
            dependencyNode.f2012f = -i3;
        } else {
            dependencyNode.f2008b = true;
            dependencyNode.f2018l.add(constraintWidget.V.f1954e.f2051i);
            this.f2044b.V.f1954e.f2051i.f2017k.add(dependencyNode);
        }
        m(this.f2044b.f1954e.f2050h);
        m(this.f2044b.f1954e.f2051i);
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        ConstraintWidget constraintWidget = this.f2044b;
        int i2 = ((Guideline) constraintWidget).y0;
        DependencyNode dependencyNode = this.f2050h;
        if (i2 == 1) {
            constraintWidget.a0 = dependencyNode.f2013g;
        } else {
            constraintWidget.b0 = dependencyNode.f2013g;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
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
