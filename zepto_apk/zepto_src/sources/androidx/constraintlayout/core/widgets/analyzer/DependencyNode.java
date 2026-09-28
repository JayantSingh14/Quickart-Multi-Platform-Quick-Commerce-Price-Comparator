package androidx.constraintlayout.core.widgets.analyzer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DependencyNode implements Dependency {

    /* renamed from: d, reason: collision with root package name */
    public final WidgetRun f2010d;

    /* renamed from: f, reason: collision with root package name */
    public int f2012f;

    /* renamed from: g, reason: collision with root package name */
    public int f2013g;

    /* renamed from: a, reason: collision with root package name */
    public WidgetRun f2007a = null;

    /* renamed from: b, reason: collision with root package name */
    public boolean f2008b = false;

    /* renamed from: c, reason: collision with root package name */
    public boolean f2009c = false;

    /* renamed from: e, reason: collision with root package name */
    public Type f2011e = Type.f2019a;

    /* renamed from: h, reason: collision with root package name */
    public int f2014h = 1;

    /* renamed from: i, reason: collision with root package name */
    public DimensionDependency f2015i = null;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2016j = false;

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f2017k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public final ArrayList f2018l = new ArrayList();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f2019a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f2020b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f2021c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f2022d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f2023e;

        /* renamed from: f, reason: collision with root package name */
        public static final Type f2024f;

        /* renamed from: g, reason: collision with root package name */
        public static final Type f2025g;

        /* renamed from: h, reason: collision with root package name */
        public static final Type f2026h;

        /* renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ Type[] f2027i;

        static {
            Type type = new Type("UNKNOWN", 0);
            f2019a = type;
            Type type2 = new Type("HORIZONTAL_DIMENSION", 1);
            f2020b = type2;
            Type type3 = new Type("VERTICAL_DIMENSION", 2);
            f2021c = type3;
            Type type4 = new Type("LEFT", 3);
            f2022d = type4;
            Type type5 = new Type("RIGHT", 4);
            f2023e = type5;
            Type type6 = new Type("TOP", 5);
            f2024f = type6;
            Type type7 = new Type("BOTTOM", 6);
            f2025g = type7;
            Type type8 = new Type("BASELINE", 7);
            f2026h = type8;
            f2027i = new Type[]{type, type2, type3, type4, type5, type6, type7, type8};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f2027i.clone();
        }
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.f2010d = widgetRun;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public final void a(Dependency dependency) {
        ArrayList arrayList = this.f2018l;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).f2016j) {
                return;
            }
        }
        this.f2009c = true;
        WidgetRun widgetRun = this.f2007a;
        if (widgetRun != null) {
            widgetRun.a(this);
        }
        if (this.f2008b) {
            this.f2010d.a(this);
            return;
        }
        Iterator it2 = arrayList.iterator();
        DependencyNode dependencyNode = null;
        int i2 = 0;
        while (it2.hasNext()) {
            DependencyNode dependencyNode2 = (DependencyNode) it2.next();
            if (!(dependencyNode2 instanceof DimensionDependency)) {
                i2++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i2 == 1 && dependencyNode.f2016j) {
            DimensionDependency dimensionDependency = this.f2015i;
            if (dimensionDependency != null) {
                if (!dimensionDependency.f2016j) {
                    return;
                } else {
                    this.f2012f = this.f2014h * dimensionDependency.f2013g;
                }
            }
            d(dependencyNode.f2013g + this.f2012f);
        }
        WidgetRun widgetRun2 = this.f2007a;
        if (widgetRun2 != null) {
            widgetRun2.a(this);
        }
    }

    public final void b(WidgetRun widgetRun) {
        this.f2017k.add(widgetRun);
        if (this.f2016j) {
            widgetRun.a(widgetRun);
        }
    }

    public final void c() {
        this.f2018l.clear();
        this.f2017k.clear();
        this.f2016j = false;
        this.f2013g = 0;
        this.f2009c = false;
        this.f2008b = false;
    }

    public void d(int i2) {
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

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2010d.f2044b.k0);
        sb.append(":");
        sb.append(this.f2011e);
        sb.append("(");
        sb.append(this.f2016j ? Integer.valueOf(this.f2013g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.f2018l.size());
        sb.append(":d=");
        sb.append(this.f2017k.size());
        sb.append(">");
        return sb.toString();
    }
}
