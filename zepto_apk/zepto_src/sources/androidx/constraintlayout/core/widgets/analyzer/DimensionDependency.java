package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DimensionDependency extends DependencyNode {

    /* renamed from: m, reason: collision with root package name */
    public int f2028m;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof HorizontalWidgetRun) {
            this.f2011e = DependencyNode.Type.f2020b;
        } else {
            this.f2011e = DependencyNode.Type.f2021c;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
    public final void d(int i2) {
        if (this.f2016j) {
            return;
        }
        this.f2016j = true;
        this.f2013g = i2;
        Iterator it = this.f2017k.iterator();
        while (it.hasNext()) {
            Dependency dependency = (Dependency) it.next();
            dependency.a(dependency);
        }
    }
}
