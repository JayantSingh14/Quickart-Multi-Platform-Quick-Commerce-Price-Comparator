package androidx.constraintlayout.core.widgets.analyzer;

import android.support.v4.media.b;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ChainRun extends WidgetRun {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f1997k;

    /* renamed from: l, reason: collision with root package name */
    public int f1998l;

    public ChainRun(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        super(constraintWidget);
        this.f1997k = new ArrayList();
        this.f2048f = i2;
        ConstraintWidget constraintWidget3 = this.f2044b;
        ConstraintWidget constraintWidgetQ = constraintWidget3.q(i2);
        while (true) {
            ConstraintWidget constraintWidget4 = constraintWidgetQ;
            constraintWidget2 = constraintWidget3;
            constraintWidget3 = constraintWidget4;
            if (constraintWidget3 == null) {
                break;
            } else {
                constraintWidgetQ = constraintWidget3.q(this.f2048f);
            }
        }
        this.f2044b = constraintWidget2;
        int i3 = this.f2048f;
        WidgetRun widgetRun = i3 == 0 ? constraintWidget2.f1953d : i3 == 1 ? constraintWidget2.f1954e : null;
        ArrayList arrayList = this.f1997k;
        arrayList.add(widgetRun);
        ConstraintWidget constraintWidgetP = constraintWidget2.p(this.f2048f);
        while (constraintWidgetP != null) {
            int i4 = this.f2048f;
            arrayList.add(i4 == 0 ? constraintWidgetP.f1953d : i4 == 1 ? constraintWidgetP.f1954e : null);
            constraintWidgetP = constraintWidgetP.p(this.f2048f);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WidgetRun widgetRun2 = (WidgetRun) it.next();
            int i5 = this.f2048f;
            if (i5 == 0) {
                widgetRun2.f2044b.f1951b = this;
            } else if (i5 == 1) {
                widgetRun2.f2044b.f1952c = this;
            }
        }
        if (this.f2048f == 0 && ((ConstraintWidgetContainer) this.f2044b.V).z0 && arrayList.size() > 1) {
            this.f2044b = ((WidgetRun) b.c(1, arrayList)).f2044b;
        }
        this.f1998l = this.f2048f == 0 ? this.f2044b.l0 : this.f2044b.m0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015b  */
    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun, androidx.constraintlayout.core.widgets.analyzer.Dependency
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(androidx.constraintlayout.core.widgets.analyzer.Dependency r30) {
        /*
            Method dump skipped, instructions count: 961
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.ChainRun.a(androidx.constraintlayout.core.widgets.analyzer.Dependency):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void d() {
        ArrayList arrayList = this.f1997k;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).d();
        }
        int size = arrayList.size();
        if (size < 1) {
            return;
        }
        ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(0)).f2044b;
        ConstraintWidget constraintWidget2 = ((WidgetRun) arrayList.get(size - 1)).f2044b;
        int i2 = this.f2048f;
        DependencyNode dependencyNode = this.f2051i;
        DependencyNode dependencyNode2 = this.f2050h;
        if (i2 == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget.J;
            ConstraintAnchor constraintAnchor2 = constraintWidget2.L;
            DependencyNode dependencyNodeI = WidgetRun.i(constraintAnchor, 0);
            int iE = constraintAnchor.e();
            ConstraintWidget constraintWidgetM = m();
            if (constraintWidgetM != null) {
                iE = constraintWidgetM.J.e();
            }
            if (dependencyNodeI != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeI, iE);
            }
            DependencyNode dependencyNodeI2 = WidgetRun.i(constraintAnchor2, 0);
            int iE2 = constraintAnchor2.e();
            ConstraintWidget constraintWidgetN = n();
            if (constraintWidgetN != null) {
                iE2 = constraintWidgetN.L.e();
            }
            if (dependencyNodeI2 != null) {
                WidgetRun.b(dependencyNode, dependencyNodeI2, -iE2);
            }
        } else {
            ConstraintAnchor constraintAnchor3 = constraintWidget.K;
            ConstraintAnchor constraintAnchor4 = constraintWidget2.M;
            DependencyNode dependencyNodeI3 = WidgetRun.i(constraintAnchor3, 1);
            int iE3 = constraintAnchor3.e();
            ConstraintWidget constraintWidgetM2 = m();
            if (constraintWidgetM2 != null) {
                iE3 = constraintWidgetM2.K.e();
            }
            if (dependencyNodeI3 != null) {
                WidgetRun.b(dependencyNode2, dependencyNodeI3, iE3);
            }
            DependencyNode dependencyNodeI4 = WidgetRun.i(constraintAnchor4, 1);
            int iE4 = constraintAnchor4.e();
            ConstraintWidget constraintWidgetN2 = n();
            if (constraintWidgetN2 != null) {
                iE4 = constraintWidgetN2.M.e();
            }
            if (dependencyNodeI4 != null) {
                WidgetRun.b(dependencyNode, dependencyNodeI4, -iE4);
            }
        }
        dependencyNode2.f2007a = this;
        dependencyNode.f2007a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void e() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f1997k;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((WidgetRun) arrayList.get(i2)).e();
            i2++;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final void f() {
        this.f2045c = null;
        Iterator it = this.f1997k.iterator();
        while (it.hasNext()) {
            ((WidgetRun) it.next()).f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final long j() {
        ArrayList arrayList = this.f1997k;
        int size = arrayList.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = r5.f2051i.f2012f + ((WidgetRun) arrayList.get(i2)).j() + j2 + r5.f2050h.f2012f;
        }
        return j2;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.WidgetRun
    public final boolean k() {
        ArrayList arrayList = this.f1997k;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!((WidgetRun) arrayList.get(i2)).k()) {
                return false;
            }
        }
        return true;
    }

    public final ConstraintWidget m() {
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f1997k;
            if (i2 >= arrayList.size()) {
                return null;
            }
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(i2)).f2044b;
            if (constraintWidget.i0 != 8) {
                return constraintWidget;
            }
            i2++;
        }
    }

    public final ConstraintWidget n() {
        ArrayList arrayList = this.f1997k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ConstraintWidget constraintWidget = ((WidgetRun) arrayList.get(size)).f2044b;
            if (constraintWidget.i0 != 8) {
                return constraintWidget;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f2048f == 0 ? "horizontal : " : "vertical : ");
        Iterator it = this.f1997k.iterator();
        while (it.hasNext()) {
            WidgetRun widgetRun = (WidgetRun) it.next();
            sb.append("<");
            sb.append(widgetRun);
            sb.append("> ");
        }
        return sb.toString();
    }
}
