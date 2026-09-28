package androidx.constraintlayout.core.widgets;

import android.support.v4.media.a;
import android.support.v4.media.b;
import android.view.View;
import androidx.constraintlayout.core.Cache;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.state.WidgetFrame;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.analyzer.ChainRun;
import androidx.constraintlayout.core.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.core.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.core.widgets.analyzer.VerticalWidgetRun;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class ConstraintWidget {
    public int A;
    public float B;
    public int[] C;
    public float D;
    public boolean E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public final ConstraintAnchor J;
    public final ConstraintAnchor K;
    public final ConstraintAnchor L;
    public final ConstraintAnchor M;
    public final ConstraintAnchor N;
    public final ConstraintAnchor O;
    public final ConstraintAnchor P;
    public final ConstraintAnchor Q;
    public final ConstraintAnchor[] R;
    public final ArrayList S;
    public final boolean[] T;
    public DimensionBehaviour[] U;
    public ConstraintWidget V;
    public int W;
    public int X;
    public float Y;
    public int Z;
    public int a0;

    /* renamed from: b, reason: collision with root package name */
    public ChainRun f1951b;
    public int b0;

    /* renamed from: c, reason: collision with root package name */
    public ChainRun f1952c;
    public int c0;
    public int d0;
    public int e0;
    public float f0;
    public float g0;
    public View h0;
    public int i0;

    /* renamed from: j, reason: collision with root package name */
    public String f1959j;
    public boolean j0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f1960k;
    public String k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1961l;
    public int l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1962m;
    public int m0;
    public boolean n;
    public final float[] n0;
    public int o;
    public final ConstraintWidget[] o0;
    public int p;
    public final ConstraintWidget[] p0;
    public int q;
    public ConstraintWidget q0;
    public int r;
    public ConstraintWidget r0;
    public int s;
    public int s0;
    public final int[] t;
    public int t0;
    public int u;
    public int v;
    public float w;
    public int x;
    public int y;
    public float z;

    /* renamed from: a, reason: collision with root package name */
    public boolean f1950a = false;

    /* renamed from: d, reason: collision with root package name */
    public HorizontalWidgetRun f1953d = null;

    /* renamed from: e, reason: collision with root package name */
    public VerticalWidgetRun f1954e = null;

    /* renamed from: f, reason: collision with root package name */
    public final boolean[] f1955f = {true, true};

    /* renamed from: g, reason: collision with root package name */
    public boolean f1956g = true;

    /* renamed from: h, reason: collision with root package name */
    public int f1957h = -1;

    /* renamed from: i, reason: collision with root package name */
    public int f1958i = -1;

    /* renamed from: androidx.constraintlayout.core.widgets.ConstraintWidget$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1963a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f1963a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1963a[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1963a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1963a[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1963a[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1963a[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1963a[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1963a[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1963a[0] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class DimensionBehaviour {

        /* renamed from: a, reason: collision with root package name */
        public static final DimensionBehaviour f1964a;

        /* renamed from: b, reason: collision with root package name */
        public static final DimensionBehaviour f1965b;

        /* renamed from: c, reason: collision with root package name */
        public static final DimensionBehaviour f1966c;

        /* renamed from: d, reason: collision with root package name */
        public static final DimensionBehaviour f1967d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ DimensionBehaviour[] f1968e;

        static {
            DimensionBehaviour dimensionBehaviour = new DimensionBehaviour("FIXED", 0);
            f1964a = dimensionBehaviour;
            DimensionBehaviour dimensionBehaviour2 = new DimensionBehaviour("WRAP_CONTENT", 1);
            f1965b = dimensionBehaviour2;
            DimensionBehaviour dimensionBehaviour3 = new DimensionBehaviour("MATCH_CONSTRAINT", 2);
            f1966c = dimensionBehaviour3;
            DimensionBehaviour dimensionBehaviour4 = new DimensionBehaviour("MATCH_PARENT", 3);
            f1967d = dimensionBehaviour4;
            f1968e = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour2, dimensionBehaviour3, dimensionBehaviour4};
        }

        public static DimensionBehaviour valueOf(String str) {
            return (DimensionBehaviour) Enum.valueOf(DimensionBehaviour.class, str);
        }

        public static DimensionBehaviour[] values() {
            return (DimensionBehaviour[]) f1968e.clone();
        }
    }

    public ConstraintWidget() {
        new WidgetFrame(this);
        this.f1960k = false;
        this.f1961l = false;
        this.f1962m = false;
        this.n = false;
        this.o = -1;
        this.p = -1;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = new int[2];
        this.u = 0;
        this.v = 0;
        this.w = 1.0f;
        this.x = 0;
        this.y = 0;
        this.z = 1.0f;
        this.A = -1;
        this.B = 1.0f;
        this.C = new int[]{Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER};
        this.D = Float.NaN;
        this.E = false;
        this.G = false;
        this.H = 0;
        this.I = 0;
        ConstraintAnchor constraintAnchor = new ConstraintAnchor(this, ConstraintAnchor.Type.f1941a);
        this.J = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1942b);
        this.K = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1943c);
        this.L = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1944d);
        this.M = constraintAnchor4;
        ConstraintAnchor constraintAnchor5 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1945e);
        this.N = constraintAnchor5;
        ConstraintAnchor constraintAnchor6 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1947g);
        this.O = constraintAnchor6;
        ConstraintAnchor constraintAnchor7 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1948h);
        this.P = constraintAnchor7;
        ConstraintAnchor constraintAnchor8 = new ConstraintAnchor(this, ConstraintAnchor.Type.f1946f);
        this.Q = constraintAnchor8;
        this.R = new ConstraintAnchor[]{constraintAnchor, constraintAnchor3, constraintAnchor2, constraintAnchor4, constraintAnchor5, constraintAnchor8};
        ArrayList arrayList = new ArrayList();
        this.S = arrayList;
        this.T = new boolean[2];
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.f1964a;
        this.U = new DimensionBehaviour[]{dimensionBehaviour, dimensionBehaviour};
        this.V = null;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.f0 = 0.5f;
        this.g0 = 0.5f;
        this.i0 = 0;
        this.j0 = false;
        this.k0 = null;
        this.l0 = 0;
        this.m0 = 0;
        this.n0 = new float[]{-1.0f, -1.0f};
        this.o0 = new ConstraintWidget[]{null, null};
        this.p0 = new ConstraintWidget[]{null, null};
        this.q0 = null;
        this.r0 = null;
        this.s0 = -1;
        this.t0 = -1;
        arrayList.add(constraintAnchor);
        arrayList.add(constraintAnchor2);
        arrayList.add(constraintAnchor3);
        arrayList.add(constraintAnchor4);
        arrayList.add(constraintAnchor6);
        arrayList.add(constraintAnchor7);
        arrayList.add(constraintAnchor8);
        arrayList.add(constraintAnchor5);
    }

    public static void K(int i2, int i3, String str, StringBuilder sb) {
        if (i2 == i3) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(i2);
        sb.append(",\n");
    }

    public static void L(StringBuilder sb, String str, float f2, float f3) {
        if (f2 == f3) {
            return;
        }
        sb.append(str);
        sb.append(" :   ");
        sb.append(f2);
        sb.append(",\n");
    }

    public static void s(StringBuilder sb, String str, int i2, int i3, int i4, int i5, int i6, float f2, DimensionBehaviour dimensionBehaviour) {
        sb.append(str);
        sb.append(" :  {\n");
        String string = dimensionBehaviour.toString();
        if (!"FIXED".equals(string)) {
            b.B(sb, "      behavior", " :   ", string, ",\n");
        }
        K(i2, 0, "      size", sb);
        K(i3, 0, "      min", sb);
        K(i4, Api.BaseClientBuilder.API_PRIORITY_OTHER, "      max", sb);
        K(i5, 0, "      matchMin", sb);
        K(i6, 0, "      matchDef", sb);
        L(sb, "      matchPercent", f2, 1.0f);
        sb.append("    },\n");
    }

    public static void t(StringBuilder sb, String str, ConstraintAnchor constraintAnchor) {
        if (constraintAnchor.f1937f == null) {
            return;
        }
        a.u(sb, "    ", str, " : [ '");
        sb.append(constraintAnchor.f1937f);
        sb.append("'");
        if (constraintAnchor.f1939h != Integer.MIN_VALUE || constraintAnchor.f1938g != 0) {
            sb.append(",");
            sb.append(constraintAnchor.f1938g);
            if (constraintAnchor.f1939h != Integer.MIN_VALUE) {
                sb.append(",");
                sb.append(constraintAnchor.f1939h);
                sb.append(",");
            }
        }
        sb.append(" ] ,\n");
    }

    public final boolean A(int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        int i3 = i2 * 2;
        ConstraintAnchor[] constraintAnchorArr = this.R;
        ConstraintAnchor constraintAnchor3 = constraintAnchorArr[i3];
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1937f;
        return (constraintAnchor4 == null || constraintAnchor4.f1937f == constraintAnchor3 || (constraintAnchor2 = (constraintAnchor = constraintAnchorArr[i3 + 1]).f1937f) == null || constraintAnchor2.f1937f != constraintAnchor) ? false : true;
    }

    public final boolean B() {
        ConstraintAnchor constraintAnchor = this.J;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1937f;
        if (constraintAnchor2 != null && constraintAnchor2.f1937f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.L;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1937f;
        return constraintAnchor4 != null && constraintAnchor4.f1937f == constraintAnchor3;
    }

    public final boolean C() {
        ConstraintAnchor constraintAnchor = this.K;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.f1937f;
        if (constraintAnchor2 != null && constraintAnchor2.f1937f == constraintAnchor) {
            return true;
        }
        ConstraintAnchor constraintAnchor3 = this.M;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1937f;
        return constraintAnchor4 != null && constraintAnchor4.f1937f == constraintAnchor3;
    }

    public final boolean D() {
        return this.f1956g && this.i0 != 8;
    }

    public boolean E() {
        if (this.f1960k) {
            return true;
        }
        return this.J.f1934c && this.L.f1934c;
    }

    public boolean F() {
        if (this.f1961l) {
            return true;
        }
        return this.K.f1934c && this.M.f1934c;
    }

    public void G() {
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.V = null;
        this.D = Float.NaN;
        this.W = 0;
        this.X = 0;
        this.Y = 0.0f;
        this.Z = -1;
        this.a0 = 0;
        this.b0 = 0;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = 0;
        this.f0 = 0.5f;
        this.g0 = 0.5f;
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.f1964a;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        this.h0 = null;
        this.i0 = 0;
        this.l0 = 0;
        this.m0 = 0;
        float[] fArr = this.n0;
        fArr[0] = -1.0f;
        fArr[1] = -1.0f;
        this.o = -1;
        this.p = -1;
        int[] iArr = this.C;
        iArr[0] = Integer.MAX_VALUE;
        iArr[1] = Integer.MAX_VALUE;
        this.r = 0;
        this.s = 0;
        this.w = 1.0f;
        this.z = 1.0f;
        this.v = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.y = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.u = 0;
        this.x = 0;
        this.A = -1;
        this.B = 1.0f;
        boolean[] zArr = this.f1955f;
        zArr[0] = true;
        zArr[1] = true;
        this.G = false;
        boolean[] zArr2 = this.T;
        zArr2[0] = false;
        zArr2[1] = false;
        this.f1956g = true;
        int[] iArr2 = this.t;
        iArr2[0] = 0;
        iArr2[1] = 0;
        this.f1957h = -1;
        this.f1958i = -1;
    }

    public final void H() {
        ConstraintWidget constraintWidget = this.V;
        if (constraintWidget != null && (constraintWidget instanceof ConstraintWidgetContainer)) {
            ((ConstraintWidgetContainer) constraintWidget).getClass();
        }
        ArrayList arrayList = this.S;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintAnchor) arrayList.get(i2)).j();
        }
    }

    public final void I() {
        this.f1960k = false;
        this.f1961l = false;
        this.f1962m = false;
        this.n = false;
        ArrayList arrayList = this.S;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) arrayList.get(i2);
            constraintAnchor.f1934c = false;
            constraintAnchor.f1933b = 0;
        }
    }

    public void J(Cache cache) {
        this.J.k();
        this.K.k();
        this.L.k();
        this.M.k();
        this.N.k();
        this.Q.k();
        this.O.k();
        this.P.k();
    }

    public final void M(int i2) {
        this.c0 = i2;
        this.E = i2 > 0;
    }

    public final void N(int i2, int i3) {
        if (this.f1960k) {
            return;
        }
        this.J.l(i2);
        this.L.l(i3);
        this.a0 = i2;
        this.W = i3 - i2;
        this.f1960k = true;
    }

    public final void O(int i2, int i3) {
        if (this.f1961l) {
            return;
        }
        this.K.l(i2);
        this.M.l(i3);
        this.b0 = i2;
        this.X = i3 - i2;
        if (this.E) {
            this.N.l(i2 + this.c0);
        }
        this.f1961l = true;
    }

    public final void P(int i2) {
        this.X = i2;
        int i3 = this.e0;
        if (i2 < i3) {
            this.X = i3;
        }
    }

    public final void Q(DimensionBehaviour dimensionBehaviour) {
        this.U[0] = dimensionBehaviour;
    }

    public final void R(DimensionBehaviour dimensionBehaviour) {
        this.U[1] = dimensionBehaviour;
    }

    public final void S(int i2) {
        this.W = i2;
        int i3 = this.d0;
        if (i2 < i3) {
            this.W = i3;
        }
    }

    public void T(boolean z, boolean z2) {
        int i2;
        int i3;
        HorizontalWidgetRun horizontalWidgetRun = this.f1953d;
        boolean z3 = z & horizontalWidgetRun.f2049g;
        VerticalWidgetRun verticalWidgetRun = this.f1954e;
        boolean z4 = z2 & verticalWidgetRun.f2049g;
        int i4 = horizontalWidgetRun.f2050h.f2013g;
        int i5 = verticalWidgetRun.f2050h.f2013g;
        int i6 = horizontalWidgetRun.f2051i.f2013g;
        int i7 = verticalWidgetRun.f2051i.f2013g;
        int i8 = i7 - i5;
        if (i6 - i4 < 0 || i8 < 0 || i4 == Integer.MIN_VALUE || i4 == Integer.MAX_VALUE || i5 == Integer.MIN_VALUE || i5 == Integer.MAX_VALUE || i6 == Integer.MIN_VALUE || i6 == Integer.MAX_VALUE || i7 == Integer.MIN_VALUE || i7 == Integer.MAX_VALUE) {
            i6 = 0;
            i7 = 0;
            i4 = 0;
            i5 = 0;
        }
        int i9 = i6 - i4;
        int i10 = i7 - i5;
        if (z3) {
            this.a0 = i4;
        }
        if (z4) {
            this.b0 = i5;
        }
        if (this.i0 == 8) {
            this.W = 0;
            this.X = 0;
            return;
        }
        DimensionBehaviour dimensionBehaviour = DimensionBehaviour.f1964a;
        if (z3) {
            if (this.U[0] == dimensionBehaviour && i9 < (i3 = this.W)) {
                i9 = i3;
            }
            this.W = i9;
            int i11 = this.d0;
            if (i9 < i11) {
                this.W = i11;
            }
        }
        if (z4) {
            if (this.U[1] == dimensionBehaviour && i10 < (i2 = this.X)) {
                i10 = i2;
            }
            this.X = i10;
            int i12 = this.e0;
            if (i10 < i12) {
                this.X = i12;
            }
        }
    }

    public void U(LinearSystem linearSystem, boolean z) {
        int i2;
        int i3;
        VerticalWidgetRun verticalWidgetRun;
        HorizontalWidgetRun horizontalWidgetRun;
        ConstraintAnchor constraintAnchor = this.J;
        linearSystem.getClass();
        int iN = LinearSystem.n(constraintAnchor);
        int iN2 = LinearSystem.n(this.K);
        int iN3 = LinearSystem.n(this.L);
        int iN4 = LinearSystem.n(this.M);
        if (z && (horizontalWidgetRun = this.f1953d) != null) {
            DependencyNode dependencyNode = horizontalWidgetRun.f2050h;
            if (dependencyNode.f2016j) {
                DependencyNode dependencyNode2 = horizontalWidgetRun.f2051i;
                if (dependencyNode2.f2016j) {
                    iN = dependencyNode.f2013g;
                    iN3 = dependencyNode2.f2013g;
                }
            }
        }
        if (z && (verticalWidgetRun = this.f1954e) != null) {
            DependencyNode dependencyNode3 = verticalWidgetRun.f2050h;
            if (dependencyNode3.f2016j) {
                DependencyNode dependencyNode4 = verticalWidgetRun.f2051i;
                if (dependencyNode4.f2016j) {
                    iN2 = dependencyNode3.f2013g;
                    iN4 = dependencyNode4.f2013g;
                }
            }
        }
        int i4 = iN4 - iN2;
        if (iN3 - iN < 0 || i4 < 0 || iN == Integer.MIN_VALUE || iN == Integer.MAX_VALUE || iN2 == Integer.MIN_VALUE || iN2 == Integer.MAX_VALUE || iN3 == Integer.MIN_VALUE || iN3 == Integer.MAX_VALUE || iN4 == Integer.MIN_VALUE || iN4 == Integer.MAX_VALUE) {
            iN = 0;
            iN2 = 0;
            iN3 = 0;
            iN4 = 0;
        }
        int i5 = iN3 - iN;
        int i6 = iN4 - iN2;
        this.a0 = iN;
        this.b0 = iN2;
        if (this.i0 == 8) {
            this.W = 0;
            this.X = 0;
            return;
        }
        DimensionBehaviour[] dimensionBehaviourArr = this.U;
        DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        DimensionBehaviour dimensionBehaviour2 = DimensionBehaviour.f1964a;
        if (dimensionBehaviour == dimensionBehaviour2 && i5 < (i3 = this.W)) {
            i5 = i3;
        }
        if (dimensionBehaviourArr[1] == dimensionBehaviour2 && i6 < (i2 = this.X)) {
            i6 = i2;
        }
        this.W = i5;
        this.X = i6;
        int i7 = this.e0;
        if (i6 < i7) {
            this.X = i7;
        }
        int i8 = this.d0;
        if (i5 < i8) {
            this.W = i8;
        }
        int i9 = this.v;
        DimensionBehaviour dimensionBehaviour3 = DimensionBehaviour.f1966c;
        if (i9 > 0 && dimensionBehaviour == dimensionBehaviour3) {
            this.W = Math.min(this.W, i9);
        }
        int i10 = this.y;
        if (i10 > 0 && this.U[1] == dimensionBehaviour3) {
            this.X = Math.min(this.X, i10);
        }
        int i11 = this.W;
        if (i5 != i11) {
            this.f1957h = i11;
        }
        int i12 = this.X;
        if (i6 != i12) {
            this.f1958i = i12;
        }
    }

    public final void d(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, HashSet hashSet, int i2, boolean z) {
        if (z) {
            if (!hashSet.contains(this)) {
                return;
            }
            Optimizer.a(constraintWidgetContainer, linearSystem, this);
            hashSet.remove(this);
            e(linearSystem, constraintWidgetContainer.Z(64));
        }
        if (i2 == 0) {
            HashSet hashSet2 = this.J.f1932a;
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    ((ConstraintAnchor) it.next()).f1935d.d(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
            }
            HashSet hashSet3 = this.L.f1932a;
            if (hashSet3 != null) {
                Iterator it2 = hashSet3.iterator();
                while (it2.hasNext()) {
                    ((ConstraintAnchor) it2.next()).f1935d.d(constraintWidgetContainer, linearSystem, hashSet, i2, true);
                }
                return;
            }
            return;
        }
        HashSet hashSet4 = this.K.f1932a;
        if (hashSet4 != null) {
            Iterator it3 = hashSet4.iterator();
            while (it3.hasNext()) {
                ((ConstraintAnchor) it3.next()).f1935d.d(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet hashSet5 = this.M.f1932a;
        if (hashSet5 != null) {
            Iterator it4 = hashSet5.iterator();
            while (it4.hasNext()) {
                ((ConstraintAnchor) it4.next()).f1935d.d(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
        HashSet hashSet6 = this.N.f1932a;
        if (hashSet6 != null) {
            Iterator it5 = hashSet6.iterator();
            while (it5.hasNext()) {
                ((ConstraintAnchor) it5.next()).f1935d.d(constraintWidgetContainer, linearSystem, hashSet, i2, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0452  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x0547  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x05aa  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x05ad  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x066d  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x06d1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0109  */
    /* JADX WARN: Type inference failed for: r12v35 */
    /* JADX WARN: Type inference failed for: r12v36, types: [int] */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r14v46, types: [androidx.constraintlayout.core.widgets.ConstraintWidgetContainer] */
    /* JADX WARN: Type inference failed for: r18v14 */
    /* JADX WARN: Type inference failed for: r18v15 */
    /* JADX WARN: Type inference failed for: r18v18 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v9, types: [boolean] */
    /* JADX WARN: Type inference failed for: r20v11 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v14 */
    /* JADX WARN: Type inference failed for: r20v2 */
    /* JADX WARN: Type inference failed for: r27v3 */
    /* JADX WARN: Type inference failed for: r27v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r27v7 */
    /* JADX WARN: Type inference failed for: r27v8 */
    /* JADX WARN: Type inference failed for: r27v9 */
    /* JADX WARN: Type inference failed for: r59v0, types: [androidx.constraintlayout.core.widgets.ConstraintWidget] */
    /* JADX WARN: Type inference failed for: r9v14, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(androidx.constraintlayout.core.LinearSystem r60, boolean r61) {
        /*
            Method dump skipped, instructions count: 1928
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.e(androidx.constraintlayout.core.LinearSystem, boolean):void");
    }

    public boolean f() {
        return this.i0 != 8;
    }

    /* JADX WARN: Removed duplicated region for block: B:218:0x03be A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x049b A[PHI: r3
      0x049b: PHI (r3v17 int) = (r3v16 int), (r3v21 int), (r3v21 int), (r3v21 int) binds: [B:282:0x048b, B:284:0x0491, B:285:0x0493, B:287:0x0497] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04ad  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04ce  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:347:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(androidx.constraintlayout.core.LinearSystem r29, boolean r30, boolean r31, boolean r32, boolean r33, androidx.constraintlayout.core.SolverVariable r34, androidx.constraintlayout.core.SolverVariable r35, androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour r36, boolean r37, androidx.constraintlayout.core.widgets.ConstraintAnchor r38, androidx.constraintlayout.core.widgets.ConstraintAnchor r39, int r40, int r41, int r42, int r43, float r44, boolean r45, boolean r46, boolean r47, boolean r48, boolean r49, int r50, int r51, int r52, int r53, float r54, boolean r55) {
        /*
            Method dump skipped, instructions count: 1330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.g(androidx.constraintlayout.core.LinearSystem, boolean, boolean, boolean, boolean, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.SolverVariable, androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour, boolean, androidx.constraintlayout.core.widgets.ConstraintAnchor, androidx.constraintlayout.core.widgets.ConstraintAnchor, int, int, int, int, float, boolean, boolean, boolean, boolean, boolean, int, int, int, int, float, boolean):void");
    }

    public final void h(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2) {
        boolean z;
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.f1946f;
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.f1948h;
        ConstraintAnchor.Type type5 = ConstraintAnchor.Type.f1947g;
        ConstraintAnchor.Type type6 = ConstraintAnchor.Type.f1941a;
        ConstraintAnchor.Type type7 = ConstraintAnchor.Type.f1942b;
        ConstraintAnchor.Type type8 = ConstraintAnchor.Type.f1943c;
        ConstraintAnchor.Type type9 = ConstraintAnchor.Type.f1944d;
        if (type == type3) {
            if (type2 != type3) {
                if (type2 == type6 || type2 == type8) {
                    h(type6, constraintWidget, type2, 0);
                    h(type8, constraintWidget, type2, 0);
                    m(type3).a(constraintWidget.m(type2), 0);
                    return;
                } else {
                    if (type2 == type7 || type2 == type9) {
                        h(type7, constraintWidget, type2, 0);
                        h(type9, constraintWidget, type2, 0);
                        m(type3).a(constraintWidget.m(type2), 0);
                        return;
                    }
                    return;
                }
            }
            ConstraintAnchor constraintAnchorM = m(type6);
            ConstraintAnchor constraintAnchorM2 = m(type8);
            ConstraintAnchor constraintAnchorM3 = m(type7);
            ConstraintAnchor constraintAnchorM4 = m(type9);
            boolean z2 = true;
            if ((constraintAnchorM == null || !constraintAnchorM.h()) && (constraintAnchorM2 == null || !constraintAnchorM2.h())) {
                h(type6, constraintWidget, type6, 0);
                h(type8, constraintWidget, type8, 0);
                z = true;
            } else {
                z = false;
            }
            if ((constraintAnchorM3 == null || !constraintAnchorM3.h()) && (constraintAnchorM4 == null || !constraintAnchorM4.h())) {
                h(type7, constraintWidget, type7, 0);
                h(type9, constraintWidget, type9, 0);
            } else {
                z2 = false;
            }
            if (z && z2) {
                m(type3).a(constraintWidget.m(type3), 0);
                return;
            } else if (z) {
                m(type5).a(constraintWidget.m(type5), 0);
                return;
            } else {
                if (z2) {
                    m(type4).a(constraintWidget.m(type4), 0);
                    return;
                }
                return;
            }
        }
        if (type == type5 && (type2 == type6 || type2 == type8)) {
            ConstraintAnchor constraintAnchorM5 = m(type6);
            ConstraintAnchor constraintAnchorM6 = constraintWidget.m(type2);
            ConstraintAnchor constraintAnchorM7 = m(type8);
            constraintAnchorM5.a(constraintAnchorM6, 0);
            constraintAnchorM7.a(constraintAnchorM6, 0);
            m(type5).a(constraintAnchorM6, 0);
            return;
        }
        if (type == type4 && (type2 == type7 || type2 == type9)) {
            ConstraintAnchor constraintAnchorM8 = constraintWidget.m(type2);
            m(type7).a(constraintAnchorM8, 0);
            m(type9).a(constraintAnchorM8, 0);
            m(type4).a(constraintAnchorM8, 0);
            return;
        }
        if (type == type5 && type2 == type5) {
            m(type6).a(constraintWidget.m(type6), 0);
            m(type8).a(constraintWidget.m(type8), 0);
            m(type5).a(constraintWidget.m(type2), 0);
            return;
        }
        if (type == type4 && type2 == type4) {
            m(type7).a(constraintWidget.m(type7), 0);
            m(type9).a(constraintWidget.m(type9), 0);
            m(type4).a(constraintWidget.m(type2), 0);
            return;
        }
        ConstraintAnchor constraintAnchorM9 = m(type);
        ConstraintAnchor constraintAnchorM10 = constraintWidget.m(type2);
        if (constraintAnchorM9.i(constraintAnchorM10)) {
            ConstraintAnchor.Type type10 = ConstraintAnchor.Type.f1945e;
            if (type == type10) {
                ConstraintAnchor constraintAnchorM11 = m(type7);
                ConstraintAnchor constraintAnchorM12 = m(type9);
                if (constraintAnchorM11 != null) {
                    constraintAnchorM11.j();
                }
                if (constraintAnchorM12 != null) {
                    constraintAnchorM12.j();
                }
            } else if (type == type7 || type == type9) {
                ConstraintAnchor constraintAnchorM13 = m(type10);
                if (constraintAnchorM13 != null) {
                    constraintAnchorM13.j();
                }
                ConstraintAnchor constraintAnchorM14 = m(type3);
                if (constraintAnchorM14.f1937f != constraintAnchorM10) {
                    constraintAnchorM14.j();
                }
                ConstraintAnchor constraintAnchorF = m(type).f();
                ConstraintAnchor constraintAnchorM15 = m(type4);
                if (constraintAnchorM15.h()) {
                    constraintAnchorF.j();
                    constraintAnchorM15.j();
                }
            } else if (type == type6 || type == type8) {
                ConstraintAnchor constraintAnchorM16 = m(type3);
                if (constraintAnchorM16.f1937f != constraintAnchorM10) {
                    constraintAnchorM16.j();
                }
                ConstraintAnchor constraintAnchorF2 = m(type).f();
                ConstraintAnchor constraintAnchorM17 = m(type5);
                if (constraintAnchorM17.h()) {
                    constraintAnchorF2.j();
                    constraintAnchorM17.j();
                }
            }
            constraintAnchorM9.a(constraintAnchorM10, i2);
        }
    }

    public final void i(ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int i2) {
        if (constraintAnchor.f1935d == this) {
            h(constraintAnchor.f1936e, constraintAnchor2.f1935d, constraintAnchor2.f1936e, i2);
        }
    }

    public void j(ConstraintWidget constraintWidget, HashMap map) {
        this.o = constraintWidget.o;
        this.p = constraintWidget.p;
        this.r = constraintWidget.r;
        this.s = constraintWidget.s;
        int[] iArr = constraintWidget.t;
        int i2 = iArr[0];
        int[] iArr2 = this.t;
        iArr2[0] = i2;
        iArr2[1] = iArr[1];
        this.u = constraintWidget.u;
        this.v = constraintWidget.v;
        this.x = constraintWidget.x;
        this.y = constraintWidget.y;
        this.z = constraintWidget.z;
        this.A = constraintWidget.A;
        this.B = constraintWidget.B;
        int[] iArr3 = constraintWidget.C;
        this.C = Arrays.copyOf(iArr3, iArr3.length);
        this.D = constraintWidget.D;
        this.E = constraintWidget.E;
        this.F = constraintWidget.F;
        this.J.j();
        this.K.j();
        this.L.j();
        this.M.j();
        this.N.j();
        this.O.j();
        this.P.j();
        this.Q.j();
        this.U = (DimensionBehaviour[]) Arrays.copyOf(this.U, 2);
        this.V = this.V == null ? null : (ConstraintWidget) map.get(constraintWidget.V);
        this.W = constraintWidget.W;
        this.X = constraintWidget.X;
        this.Y = constraintWidget.Y;
        this.Z = constraintWidget.Z;
        this.a0 = constraintWidget.a0;
        this.b0 = constraintWidget.b0;
        this.c0 = constraintWidget.c0;
        this.d0 = constraintWidget.d0;
        this.e0 = constraintWidget.e0;
        this.f0 = constraintWidget.f0;
        this.g0 = constraintWidget.g0;
        this.h0 = constraintWidget.h0;
        this.i0 = constraintWidget.i0;
        this.j0 = constraintWidget.j0;
        this.k0 = constraintWidget.k0;
        this.l0 = constraintWidget.l0;
        this.m0 = constraintWidget.m0;
        float[] fArr = constraintWidget.n0;
        float f2 = fArr[0];
        float[] fArr2 = this.n0;
        fArr2[0] = f2;
        fArr2[1] = fArr[1];
        ConstraintWidget[] constraintWidgetArr = constraintWidget.o0;
        ConstraintWidget constraintWidget2 = constraintWidgetArr[0];
        ConstraintWidget[] constraintWidgetArr2 = this.o0;
        constraintWidgetArr2[0] = constraintWidget2;
        constraintWidgetArr2[1] = constraintWidgetArr[1];
        ConstraintWidget[] constraintWidgetArr3 = constraintWidget.p0;
        ConstraintWidget constraintWidget3 = constraintWidgetArr3[0];
        ConstraintWidget[] constraintWidgetArr4 = this.p0;
        constraintWidgetArr4[0] = constraintWidget3;
        constraintWidgetArr4[1] = constraintWidgetArr3[1];
        ConstraintWidget constraintWidget4 = constraintWidget.q0;
        this.q0 = constraintWidget4 == null ? null : (ConstraintWidget) map.get(constraintWidget4);
        ConstraintWidget constraintWidget5 = constraintWidget.r0;
        this.r0 = constraintWidget5 != null ? (ConstraintWidget) map.get(constraintWidget5) : null;
    }

    public final void k(LinearSystem linearSystem) {
        linearSystem.k(this.J);
        linearSystem.k(this.K);
        linearSystem.k(this.L);
        linearSystem.k(this.M);
        if (this.c0 > 0) {
            linearSystem.k(this.N);
        }
    }

    public final void l() {
        if (this.f1953d == null) {
            this.f1953d = new HorizontalWidgetRun(this);
        }
        if (this.f1954e == null) {
            this.f1954e = new VerticalWidgetRun(this);
        }
    }

    public ConstraintAnchor m(ConstraintAnchor.Type type) {
        switch (type.ordinal()) {
            case 0:
                return null;
            case 1:
                return this.J;
            case 2:
                return this.K;
            case 3:
                return this.L;
            case 4:
                return this.M;
            case 5:
                return this.N;
            case 6:
                return this.Q;
            case 7:
                return this.O;
            case 8:
                return this.P;
            default:
                throw new AssertionError(type.name());
        }
    }

    public final DimensionBehaviour n(int i2) {
        if (i2 == 0) {
            return this.U[0];
        }
        if (i2 == 1) {
            return this.U[1];
        }
        return null;
    }

    public final int o() {
        if (this.i0 == 8) {
            return 0;
        }
        return this.X;
    }

    public final ConstraintWidget p(int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i2 != 0) {
            if (i2 == 1 && (constraintAnchor2 = (constraintAnchor = this.M).f1937f) != null && constraintAnchor2.f1937f == constraintAnchor) {
                return constraintAnchor2.f1935d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.L;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1937f;
        if (constraintAnchor4 == null || constraintAnchor4.f1937f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f1935d;
    }

    public final ConstraintWidget q(int i2) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        if (i2 != 0) {
            if (i2 == 1 && (constraintAnchor2 = (constraintAnchor = this.K).f1937f) != null && constraintAnchor2.f1937f == constraintAnchor) {
                return constraintAnchor2.f1935d;
            }
            return null;
        }
        ConstraintAnchor constraintAnchor3 = this.J;
        ConstraintAnchor constraintAnchor4 = constraintAnchor3.f1937f;
        if (constraintAnchor4 == null || constraintAnchor4.f1937f != constraintAnchor3) {
            return null;
        }
        return constraintAnchor4.f1935d;
    }

    public void r(StringBuilder sb) {
        sb.append("  " + this.f1959j + ":{\n");
        StringBuilder sb2 = new StringBuilder("    actualWidth:");
        sb2.append(this.W);
        sb.append(sb2.toString());
        sb.append(StringUtils.LF);
        sb.append("    actualHeight:" + this.X);
        sb.append(StringUtils.LF);
        sb.append("    actualLeft:" + this.a0);
        sb.append(StringUtils.LF);
        sb.append("    actualTop:" + this.b0);
        sb.append(StringUtils.LF);
        t(sb, "left", this.J);
        t(sb, "top", this.K);
        t(sb, "right", this.L);
        t(sb, "bottom", this.M);
        t(sb, "baseline", this.N);
        t(sb, "centerX", this.O);
        t(sb, "centerY", this.P);
        int i2 = this.W;
        int i3 = this.d0;
        int i4 = this.C[0];
        int i5 = this.u;
        int i6 = this.r;
        float f2 = this.w;
        DimensionBehaviour dimensionBehaviour = this.U[0];
        float[] fArr = this.n0;
        float f3 = fArr[0];
        s(sb, "    width", i2, i3, i4, i5, i6, f2, dimensionBehaviour);
        int i7 = this.X;
        int i8 = this.e0;
        int i9 = this.C[1];
        int i10 = this.x;
        int i11 = this.s;
        float f4 = this.z;
        DimensionBehaviour dimensionBehaviour2 = this.U[1];
        float f5 = fArr[1];
        s(sb, "    height", i7, i8, i9, i10, i11, f4, dimensionBehaviour2);
        float f6 = this.Y;
        int i12 = this.Z;
        if (f6 != 0.0f) {
            sb.append("    dimensionRatio");
            sb.append(" :  [");
            sb.append(f6);
            sb.append(",");
            sb.append(i12);
            sb.append("");
            sb.append("],\n");
        }
        L(sb, "    horizontalBias", this.f0, 0.5f);
        L(sb, "    verticalBias", this.g0, 0.5f);
        K(this.l0, 0, "    horizontalChainStyle", sb);
        K(this.m0, 0, "    verticalChainStyle", sb);
        sb.append("  }");
    }

    public String toString() {
        StringBuilder sbW = b.w("");
        sbW.append(this.k0 != null ? b.r(new StringBuilder("id: "), this.k0, StringUtils.SPACE) : "");
        sbW.append("(");
        sbW.append(this.a0);
        sbW.append(", ");
        sbW.append(this.b0);
        sbW.append(") - (");
        sbW.append(this.W);
        sbW.append(" x ");
        return b.o(sbW, this.X, ")");
    }

    public final int u() {
        if (this.i0 == 8) {
            return 0;
        }
        return this.W;
    }

    public final int v() {
        ConstraintWidget constraintWidget = this.V;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.a0 : ((ConstraintWidgetContainer) constraintWidget).B0 + this.a0;
    }

    public final int w() {
        ConstraintWidget constraintWidget = this.V;
        return (constraintWidget == null || !(constraintWidget instanceof ConstraintWidgetContainer)) ? this.b0 : ((ConstraintWidgetContainer) constraintWidget).C0 + this.b0;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean x(int r5) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            r2 = 1
            if (r5 != 0) goto L1b
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.J
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1937f
            if (r5 == 0) goto Ld
            r5 = r2
            goto Le
        Ld:
            r5 = r1
        Le:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r4.L
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1937f
            if (r3 == 0) goto L16
            r3 = r2
            goto L17
        L16:
            r3 = r1
        L17:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
            goto L3a
        L1b:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r4.K
            androidx.constraintlayout.core.widgets.ConstraintAnchor r5 = r5.f1937f
            if (r5 == 0) goto L23
            r5 = r2
            goto L24
        L23:
            r5 = r1
        L24:
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r4.M
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1937f
            if (r3 == 0) goto L2c
            r3 = r2
            goto L2d
        L2c:
            r3 = r1
        L2d:
            int r5 = r5 + r3
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r4.N
            androidx.constraintlayout.core.widgets.ConstraintAnchor r3 = r3.f1937f
            if (r3 == 0) goto L36
            r3 = r2
            goto L37
        L36:
            r3 = r1
        L37:
            int r5 = r5 + r3
            if (r5 >= r0) goto L3b
        L3a:
            return r2
        L3b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.ConstraintWidget.x(int):boolean");
    }

    public final boolean y(int i2, int i3) {
        ConstraintAnchor constraintAnchor;
        ConstraintAnchor constraintAnchor2;
        ConstraintAnchor constraintAnchor3;
        ConstraintAnchor constraintAnchor4;
        if (i2 == 0) {
            ConstraintAnchor constraintAnchor5 = this.J;
            ConstraintAnchor constraintAnchor6 = constraintAnchor5.f1937f;
            if (constraintAnchor6 == null || !constraintAnchor6.f1934c || (constraintAnchor4 = (constraintAnchor3 = this.L).f1937f) == null || !constraintAnchor4.f1934c) {
                return false;
            }
            return (constraintAnchor4.d() - constraintAnchor3.e()) - (constraintAnchor5.e() + constraintAnchor5.f1937f.d()) >= i3;
        }
        ConstraintAnchor constraintAnchor7 = this.K;
        ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1937f;
        if (constraintAnchor8 == null || !constraintAnchor8.f1934c || (constraintAnchor2 = (constraintAnchor = this.M).f1937f) == null || !constraintAnchor2.f1934c) {
            return false;
        }
        return (constraintAnchor2.d() - constraintAnchor.e()) - (constraintAnchor7.e() + constraintAnchor7.f1937f.d()) >= i3;
    }

    public final void z(ConstraintAnchor.Type type, ConstraintWidget constraintWidget, ConstraintAnchor.Type type2, int i2, int i3) {
        m(type).b(constraintWidget.m(type2), i2, i3, true);
    }
}
