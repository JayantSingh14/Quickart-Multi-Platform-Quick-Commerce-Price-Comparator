package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes3.dex */
public abstract class WidgetRun implements Dependency {

    /* renamed from: a, reason: collision with root package name */
    public int f2043a;

    /* renamed from: b, reason: collision with root package name */
    public ConstraintWidget f2044b;

    /* renamed from: c, reason: collision with root package name */
    public RunGroup f2045c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget.DimensionBehaviour f2046d;

    /* renamed from: e, reason: collision with root package name */
    public final DimensionDependency f2047e = new DimensionDependency(this);

    /* renamed from: f, reason: collision with root package name */
    public int f2048f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2049g = false;

    /* renamed from: h, reason: collision with root package name */
    public final DependencyNode f2050h = new DependencyNode(this);

    /* renamed from: i, reason: collision with root package name */
    public final DependencyNode f2051i = new DependencyNode(this);

    /* renamed from: j, reason: collision with root package name */
    public RunType f2052j = RunType.f2054a;

    /* renamed from: androidx.constraintlayout.core.widgets.analyzer.WidgetRun$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2053a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f2053a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2053a[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2053a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2053a[5] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2053a[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class RunType {

        /* renamed from: a, reason: collision with root package name */
        public static final RunType f2054a;

        /* renamed from: b, reason: collision with root package name */
        public static final RunType f2055b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ RunType[] f2056c;

        static {
            RunType runType = new RunType("NONE", 0);
            f2054a = runType;
            RunType runType2 = new RunType("START", 1);
            RunType runType3 = new RunType("END", 2);
            RunType runType4 = new RunType("CENTER", 3);
            f2055b = runType4;
            f2056c = new RunType[]{runType, runType2, runType3, runType4};
        }

        public static RunType valueOf(String str) {
            return (RunType) Enum.valueOf(RunType.class, str);
        }

        public static RunType[] values() {
            return (RunType[]) f2056c.clone();
        }
    }

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.f2044b = constraintWidget;
    }

    public static void b(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2) {
        dependencyNode.f2018l.add(dependencyNode2);
        dependencyNode.f2012f = i2;
        dependencyNode2.f2017k.add(dependencyNode);
    }

    public static DependencyNode h(ConstraintAnchor constraintAnchor) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1937f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1935d;
        int iOrdinal = constraintAnchor2.f1936e.ordinal();
        if (iOrdinal == 1) {
            return constraintWidget.f1953d.f2050h;
        }
        if (iOrdinal == 2) {
            return constraintWidget.f1954e.f2050h;
        }
        if (iOrdinal == 3) {
            return constraintWidget.f1953d.f2051i;
        }
        if (iOrdinal == 4) {
            return constraintWidget.f1954e.f2051i;
        }
        if (iOrdinal != 5) {
            return null;
        }
        return constraintWidget.f1954e.f2034k;
    }

    public static DependencyNode i(ConstraintAnchor constraintAnchor, int i2) {
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1937f;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor2.f1935d;
        WidgetRun widgetRun = i2 == 0 ? constraintWidget.f1953d : constraintWidget.f1954e;
        int iOrdinal = constraintAnchor2.f1936e.ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            return widgetRun.f2050h;
        }
        if (iOrdinal == 3 || iOrdinal == 4) {
            return widgetRun.f2051i;
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.Dependency
    public void a(Dependency dependency) {
    }

    public final void c(DependencyNode dependencyNode, DependencyNode dependencyNode2, int i2, DimensionDependency dimensionDependency) {
        dependencyNode.f2018l.add(dependencyNode2);
        dependencyNode.f2018l.add(this.f2047e);
        dependencyNode.f2014h = i2;
        dependencyNode.f2015i = dimensionDependency;
        dependencyNode2.f2017k.add(dependencyNode);
        dimensionDependency.f2017k.add(dependencyNode);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i2, int i3) {
        if (i3 == 0) {
            ConstraintWidget constraintWidget = this.f2044b;
            int i4 = constraintWidget.v;
            int iMax = Math.max(constraintWidget.u, i2);
            if (i4 > 0) {
                iMax = Math.min(i4, i2);
            }
            if (iMax != i2) {
                return iMax;
            }
        } else {
            ConstraintWidget constraintWidget2 = this.f2044b;
            int i5 = constraintWidget2.y;
            int iMax2 = Math.max(constraintWidget2.x, i2);
            if (i5 > 0) {
                iMax2 = Math.min(i5, i2);
            }
            if (iMax2 != i2) {
                return iMax2;
            }
        }
        return i2;
    }

    public long j() {
        if (this.f2047e.f2016j) {
            return r0.f2013g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(androidx.constraintlayout.core.widgets.ConstraintAnchor r13, androidx.constraintlayout.core.widgets.ConstraintAnchor r14, int r15) {
        /*
            Method dump skipped, instructions count: 236
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.WidgetRun.l(androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int):void");
    }
}
