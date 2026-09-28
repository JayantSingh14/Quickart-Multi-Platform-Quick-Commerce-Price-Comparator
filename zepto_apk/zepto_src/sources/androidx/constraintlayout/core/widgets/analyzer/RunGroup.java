package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;

/* loaded from: classes3.dex */
class RunGroup {

    /* renamed from: a, reason: collision with root package name */
    public WidgetRun f2032a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2033b;

    public static long a(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.f2010d;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        ArrayList arrayList = dependencyNode.f2017k;
        int size = arrayList.size();
        long jMin = j2;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = (Dependency) arrayList.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f2010d != widgetRun) {
                    jMin = Math.min(jMin, a(dependencyNode2, dependencyNode2.f2012f + j2));
                }
            }
        }
        if (dependencyNode != widgetRun.f2051i) {
            return jMin;
        }
        long j3 = widgetRun.j();
        long j4 = j2 - j3;
        return Math.min(Math.min(jMin, a(widgetRun.f2050h, j4)), j4 - r9.f2012f);
    }

    public static long b(DependencyNode dependencyNode, long j2) {
        WidgetRun widgetRun = dependencyNode.f2010d;
        if (widgetRun instanceof HelperReferences) {
            return j2;
        }
        ArrayList arrayList = dependencyNode.f2017k;
        int size = arrayList.size();
        long jMax = j2;
        for (int i2 = 0; i2 < size; i2++) {
            Dependency dependency = (Dependency) arrayList.get(i2);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.f2010d != widgetRun) {
                    jMax = Math.max(jMax, b(dependencyNode2, dependencyNode2.f2012f + j2));
                }
            }
        }
        if (dependencyNode != widgetRun.f2050h) {
            return jMax;
        }
        long j3 = widgetRun.j();
        long j4 = j2 + j3;
        return Math.max(Math.max(jMax, b(widgetRun.f2051i, j4)), j4 - r9.f2012f);
    }
}
