package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ConstraintAnchor {

    /* renamed from: b, reason: collision with root package name */
    public int f1933b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1934c;

    /* renamed from: d, reason: collision with root package name */
    public final ConstraintWidget f1935d;

    /* renamed from: e, reason: collision with root package name */
    public final Type f1936e;

    /* renamed from: f, reason: collision with root package name */
    public ConstraintAnchor f1937f;

    /* renamed from: i, reason: collision with root package name */
    public SolverVariable f1940i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f1932a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f1938g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f1939h = Integer.MIN_VALUE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class Type {

        /* renamed from: a, reason: collision with root package name */
        public static final Type f1941a;

        /* renamed from: b, reason: collision with root package name */
        public static final Type f1942b;

        /* renamed from: c, reason: collision with root package name */
        public static final Type f1943c;

        /* renamed from: d, reason: collision with root package name */
        public static final Type f1944d;

        /* renamed from: e, reason: collision with root package name */
        public static final Type f1945e;

        /* renamed from: f, reason: collision with root package name */
        public static final Type f1946f;

        /* renamed from: g, reason: collision with root package name */
        public static final Type f1947g;

        /* renamed from: h, reason: collision with root package name */
        public static final Type f1948h;

        /* renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ Type[] f1949i;

        /* JADX INFO: Fake field, exist only in values array */
        Type EF0;

        static {
            Type type = new Type("NONE", 0);
            Type type2 = new Type("LEFT", 1);
            f1941a = type2;
            Type type3 = new Type("TOP", 2);
            f1942b = type3;
            Type type4 = new Type("RIGHT", 3);
            f1943c = type4;
            Type type5 = new Type("BOTTOM", 4);
            f1944d = type5;
            Type type6 = new Type("BASELINE", 5);
            f1945e = type6;
            Type type7 = new Type("CENTER", 6);
            f1946f = type7;
            Type type8 = new Type("CENTER_X", 7);
            f1947g = type8;
            Type type9 = new Type("CENTER_Y", 8);
            f1948h = type9;
            f1949i = new Type[]{type, type2, type3, type4, type5, type6, type7, type8, type9};
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) f1949i.clone();
        }
    }

    public ConstraintAnchor(ConstraintWidget constraintWidget, Type type) {
        this.f1935d = constraintWidget;
        this.f1936e = type;
    }

    public final void a(ConstraintAnchor constraintAnchor, int i2) {
        b(constraintAnchor, i2, Integer.MIN_VALUE, false);
    }

    public final boolean b(ConstraintAnchor constraintAnchor, int i2, int i3, boolean z) {
        if (constraintAnchor == null) {
            j();
            return true;
        }
        if (!z && !i(constraintAnchor)) {
            return false;
        }
        this.f1937f = constraintAnchor;
        if (constraintAnchor.f1932a == null) {
            constraintAnchor.f1932a = new HashSet();
        }
        HashSet hashSet = this.f1937f.f1932a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f1938g = i2;
        this.f1939h = i3;
        return true;
    }

    public final void c(int i2, WidgetGroup widgetGroup, ArrayList arrayList) {
        HashSet hashSet = this.f1932a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                Grouping.a(((ConstraintAnchor) it.next()).f1935d, i2, arrayList, widgetGroup);
            }
        }
    }

    public final int d() {
        if (this.f1934c) {
            return this.f1933b;
        }
        return 0;
    }

    public final int e() {
        ConstraintAnchor constraintAnchor;
        if (this.f1935d.i0 == 8) {
            return 0;
        }
        int i2 = this.f1939h;
        return (i2 == Integer.MIN_VALUE || (constraintAnchor = this.f1937f) == null || constraintAnchor.f1935d.i0 != 8) ? this.f1938g : i2;
    }

    public final ConstraintAnchor f() {
        Type type = this.f1936e;
        int iOrdinal = type.ordinal();
        ConstraintWidget constraintWidget = this.f1935d;
        switch (iOrdinal) {
            case 0:
            case 5:
            case 6:
            case 7:
            case 8:
                return null;
            case 1:
                return constraintWidget.L;
            case 2:
                return constraintWidget.M;
            case 3:
                return constraintWidget.J;
            case 4:
                return constraintWidget.K;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f1932a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((ConstraintAnchor) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f1937f != null;
    }

    public final boolean i(ConstraintAnchor constraintAnchor) {
        if (constraintAnchor == null) {
            return false;
        }
        Type type = Type.f1945e;
        Type type2 = this.f1936e;
        ConstraintWidget constraintWidget = constraintAnchor.f1935d;
        Type type3 = constraintAnchor.f1936e;
        if (type3 == type2) {
            return type2 != type || (constraintWidget.E && this.f1935d.E);
        }
        int iOrdinal = type2.ordinal();
        Type type4 = Type.f1943c;
        Type type5 = Type.f1941a;
        Type type6 = Type.f1948h;
        Type type7 = Type.f1947g;
        switch (iOrdinal) {
            case 0:
            case 7:
            case 8:
                return false;
            case 1:
            case 3:
                boolean z = type3 == type5 || type3 == type4;
                return constraintWidget instanceof Guideline ? z || type3 == type7 : z;
            case 2:
            case 4:
                boolean z2 = type3 == Type.f1942b || type3 == Type.f1944d;
                return constraintWidget instanceof Guideline ? z2 || type3 == type6 : z2;
            case 5:
                return (type3 == type5 || type3 == type4) ? false : true;
            case 6:
                return (type3 == type || type3 == type7 || type3 == type6) ? false : true;
            default:
                throw new AssertionError(type2.name());
        }
    }

    public final void j() {
        HashSet hashSet;
        ConstraintAnchor constraintAnchor = this.f1937f;
        if (constraintAnchor != null && (hashSet = constraintAnchor.f1932a) != null) {
            hashSet.remove(this);
            if (this.f1937f.f1932a.size() == 0) {
                this.f1937f.f1932a = null;
            }
        }
        this.f1932a = null;
        this.f1937f = null;
        this.f1938g = 0;
        this.f1939h = Integer.MIN_VALUE;
        this.f1934c = false;
        this.f1933b = 0;
    }

    public final void k() {
        SolverVariable solverVariable = this.f1940i;
        if (solverVariable == null) {
            this.f1940i = new SolverVariable(SolverVariable.Type.f1704a);
        } else {
            solverVariable.c();
        }
    }

    public final void l(int i2) {
        this.f1933b = i2;
        this.f1934c = true;
    }

    public final String toString() {
        return this.f1935d.k0 + ":" + this.f1936e.toString();
    }
}
