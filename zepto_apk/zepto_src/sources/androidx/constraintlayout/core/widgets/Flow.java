package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Flow extends VirtualLayout {
    public ConstraintWidget[] e1;
    public int H0 = -1;
    public int I0 = -1;
    public int J0 = -1;
    public int K0 = -1;
    public int L0 = -1;
    public int M0 = -1;
    public float N0 = 0.5f;
    public float O0 = 0.5f;
    public float P0 = 0.5f;
    public float Q0 = 0.5f;
    public float R0 = 0.5f;
    public float S0 = 0.5f;
    public int T0 = 0;
    public int U0 = 0;
    public int V0 = 2;
    public int W0 = 2;
    public int X0 = 0;
    public int Y0 = -1;
    public int Z0 = 0;
    public final ArrayList a1 = new ArrayList();
    public ConstraintWidget[] b1 = null;
    public ConstraintWidget[] c1 = null;
    public int[] d1 = null;
    public int f1 = 0;

    public class WidgetsList {

        /* renamed from: a, reason: collision with root package name */
        public int f1969a;

        /* renamed from: d, reason: collision with root package name */
        public ConstraintAnchor f1972d;

        /* renamed from: e, reason: collision with root package name */
        public ConstraintAnchor f1973e;

        /* renamed from: f, reason: collision with root package name */
        public ConstraintAnchor f1974f;

        /* renamed from: g, reason: collision with root package name */
        public ConstraintAnchor f1975g;

        /* renamed from: h, reason: collision with root package name */
        public int f1976h;

        /* renamed from: i, reason: collision with root package name */
        public int f1977i;

        /* renamed from: j, reason: collision with root package name */
        public int f1978j;

        /* renamed from: k, reason: collision with root package name */
        public int f1979k;
        public int q;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget f1970b = null;

        /* renamed from: c, reason: collision with root package name */
        public int f1971c = 0;

        /* renamed from: l, reason: collision with root package name */
        public int f1980l = 0;

        /* renamed from: m, reason: collision with root package name */
        public int f1981m = 0;
        public int n = 0;
        public int o = 0;
        public int p = 0;

        public WidgetsList(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3) {
            this.f1976h = 0;
            this.f1977i = 0;
            this.f1978j = 0;
            this.f1979k = 0;
            this.q = 0;
            this.f1969a = i2;
            this.f1972d = constraintAnchor;
            this.f1973e = constraintAnchor2;
            this.f1974f = constraintAnchor3;
            this.f1975g = constraintAnchor4;
            this.f1976h = Flow.this.A0;
            this.f1977i = Flow.this.w0;
            this.f1978j = Flow.this.B0;
            this.f1979k = Flow.this.x0;
            this.q = i3;
        }

        public final void a(ConstraintWidget constraintWidget) {
            int i2 = this.f1969a;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1966c;
            Flow flow = Flow.this;
            if (i2 == 0) {
                int iZ = flow.Z(constraintWidget, this.q);
                if (constraintWidget.U[0] == dimensionBehaviour) {
                    this.p++;
                    iZ = 0;
                }
                this.f1980l = iZ + (constraintWidget.i0 != 8 ? flow.T0 : 0) + this.f1980l;
                int iY = flow.Y(constraintWidget, this.q);
                if (this.f1970b == null || this.f1971c < iY) {
                    this.f1970b = constraintWidget;
                    this.f1971c = iY;
                    this.f1981m = iY;
                }
            } else {
                int iZ2 = flow.Z(constraintWidget, this.q);
                int iY2 = flow.Y(constraintWidget, this.q);
                if (constraintWidget.U[1] == dimensionBehaviour) {
                    this.p++;
                    iY2 = 0;
                }
                this.f1981m = iY2 + (constraintWidget.i0 != 8 ? flow.U0 : 0) + this.f1981m;
                if (this.f1970b == null || this.f1971c < iZ2) {
                    this.f1970b = constraintWidget;
                    this.f1971c = iZ2;
                    this.f1980l = iZ2;
                }
            }
            this.o++;
        }

        public final void b(int i2, boolean z, boolean z2) {
            Flow flow;
            int i3;
            ConstraintWidget constraintWidget;
            boolean z3;
            char c2;
            float f2;
            float f3;
            int i4;
            float f4;
            float f5;
            int i5;
            int i6 = this.o;
            int i7 = 0;
            while (true) {
                flow = Flow.this;
                if (i7 >= i6 || (i5 = this.n + i7) >= flow.f1) {
                    break;
                }
                ConstraintWidget constraintWidget2 = flow.e1[i5];
                if (constraintWidget2 != null) {
                    constraintWidget2.H();
                }
                i7++;
            }
            if (i6 == 0 || this.f1970b == null) {
                return;
            }
            boolean z4 = z2 && i2 == 0;
            int i8 = -1;
            int i9 = -1;
            for (int i10 = 0; i10 < i6; i10++) {
                int i11 = this.n + (z ? (i6 - 1) - i10 : i10);
                if (i11 >= flow.f1) {
                    break;
                }
                ConstraintWidget constraintWidget3 = flow.e1[i11];
                if (constraintWidget3 != null && constraintWidget3.i0 == 0) {
                    if (i8 == -1) {
                        i8 = i10;
                    }
                    i9 = i10;
                }
            }
            if (this.f1969a != 0) {
                boolean z5 = z4;
                ConstraintWidget constraintWidget4 = this.f1970b;
                constraintWidget4.l0 = flow.H0;
                int i12 = this.f1976h;
                if (i2 > 0) {
                    i12 += flow.T0;
                }
                ConstraintAnchor constraintAnchor = constraintWidget4.J;
                ConstraintAnchor constraintAnchor2 = constraintWidget4.L;
                if (z) {
                    constraintAnchor2.a(this.f1974f, i12);
                    if (z2) {
                        constraintAnchor.a(this.f1972d, this.f1978j);
                    }
                    if (i2 > 0) {
                        this.f1974f.f1935d.J.a(constraintAnchor2, 0);
                    }
                } else {
                    constraintAnchor.a(this.f1972d, i12);
                    if (z2) {
                        constraintAnchor2.a(this.f1974f, this.f1978j);
                    }
                    if (i2 > 0) {
                        this.f1972d.f1935d.L.a(constraintAnchor, 0);
                    }
                }
                ConstraintWidget constraintWidget5 = null;
                for (int i13 = 0; i13 < i6; i13++) {
                    int i14 = this.n + i13;
                    if (i14 >= flow.f1) {
                        return;
                    }
                    ConstraintWidget constraintWidget6 = flow.e1[i14];
                    if (constraintWidget6 != null) {
                        ConstraintAnchor constraintAnchor3 = constraintWidget6.K;
                        if (i13 == 0) {
                            constraintWidget6.i(constraintAnchor3, this.f1973e, this.f1977i);
                            int i15 = flow.I0;
                            float f6 = flow.O0;
                            if (this.n == 0) {
                                int i16 = flow.K0;
                                i3 = -1;
                                if (i16 != -1) {
                                    f6 = flow.Q0;
                                }
                                i15 = i16;
                                constraintWidget6.m0 = i15;
                                constraintWidget6.g0 = f6;
                            } else {
                                i3 = -1;
                            }
                            if (z2 && (i16 = flow.M0) != i3) {
                                f6 = flow.S0;
                                i15 = i16;
                            }
                            constraintWidget6.m0 = i15;
                            constraintWidget6.g0 = f6;
                        }
                        if (i13 == i6 - 1) {
                            constraintWidget6.i(constraintWidget6.M, this.f1975g, this.f1979k);
                        }
                        if (constraintWidget5 != null) {
                            int i17 = flow.U0;
                            ConstraintAnchor constraintAnchor4 = constraintWidget5.M;
                            constraintAnchor3.a(constraintAnchor4, i17);
                            if (i13 == i8) {
                                int i18 = this.f1977i;
                                if (constraintAnchor3.h()) {
                                    constraintAnchor3.f1939h = i18;
                                }
                            }
                            constraintAnchor4.a(constraintAnchor3, 0);
                            if (i13 == i9 + 1) {
                                int i19 = this.f1979k;
                                if (constraintAnchor4.h()) {
                                    constraintAnchor4.f1939h = i19;
                                }
                            }
                        }
                        if (constraintWidget6 != constraintWidget4) {
                            ConstraintAnchor constraintAnchor5 = constraintWidget6.L;
                            ConstraintAnchor constraintAnchor6 = constraintWidget6.J;
                            if (z) {
                                int i20 = flow.V0;
                                if (i20 == 0) {
                                    constraintAnchor5.a(constraintAnchor2, 0);
                                } else if (i20 == 1) {
                                    constraintAnchor6.a(constraintAnchor, 0);
                                } else if (i20 == 2) {
                                    constraintAnchor6.a(constraintAnchor, 0);
                                    constraintAnchor5.a(constraintAnchor2, 0);
                                }
                                constraintWidget5 = constraintWidget6;
                            } else {
                                int i21 = flow.V0;
                                if (i21 == 0) {
                                    constraintAnchor6.a(constraintAnchor, 0);
                                } else if (i21 == 1) {
                                    constraintAnchor5.a(constraintAnchor2, 0);
                                } else if (i21 == 2) {
                                    if (z5) {
                                        constraintAnchor6.a(this.f1972d, this.f1976h);
                                        constraintAnchor5.a(this.f1974f, this.f1978j);
                                    } else {
                                        constraintAnchor6.a(constraintAnchor, 0);
                                        constraintAnchor5.a(constraintAnchor2, 0);
                                    }
                                }
                                constraintWidget5 = constraintWidget6;
                            }
                        } else {
                            constraintWidget5 = constraintWidget6;
                        }
                    }
                }
                return;
            }
            ConstraintWidget constraintWidget7 = this.f1970b;
            constraintWidget7.m0 = flow.I0;
            int i22 = this.f1977i;
            if (i2 > 0) {
                i22 += flow.U0;
            }
            ConstraintAnchor constraintAnchor7 = this.f1973e;
            ConstraintAnchor constraintAnchor8 = constraintWidget7.K;
            constraintAnchor8.a(constraintAnchor7, i22);
            ConstraintAnchor constraintAnchor9 = constraintWidget7.M;
            if (z2) {
                constraintAnchor9.a(this.f1975g, this.f1979k);
            }
            if (i2 > 0) {
                this.f1973e.f1935d.M.a(constraintAnchor8, 0);
            }
            if (flow.W0 != 3 || constraintWidget7.E) {
                constraintWidget = constraintWidget7;
            } else {
                for (int i23 = 0; i23 < i6; i23++) {
                    int i24 = this.n + (z ? (i6 - 1) - i23 : i23);
                    if (i24 >= flow.f1) {
                        break;
                    }
                    constraintWidget = flow.e1[i24];
                    if (constraintWidget.E) {
                        break;
                    }
                }
                constraintWidget = constraintWidget7;
            }
            int i25 = 0;
            ConstraintWidget constraintWidget8 = null;
            while (i25 < i6) {
                int i26 = z ? (i6 - 1) - i25 : i25;
                int i27 = this.n + i26;
                if (i27 >= flow.f1) {
                    return;
                }
                ConstraintWidget constraintWidget9 = flow.e1[i27];
                if (constraintWidget9 == null) {
                    z3 = z4;
                    c2 = 3;
                } else {
                    ConstraintAnchor constraintAnchor10 = constraintWidget9.J;
                    if (i25 == 0) {
                        constraintWidget9.i(constraintAnchor10, this.f1972d, this.f1976h);
                    }
                    if (i26 == 0) {
                        int i28 = flow.H0;
                        if (z) {
                            f2 = 1.0f;
                            f3 = 1.0f - flow.N0;
                        } else {
                            f2 = 1.0f;
                            f3 = flow.N0;
                        }
                        if (this.n == 0) {
                            i4 = flow.J0;
                            z3 = z4;
                            if (i4 != -1) {
                                if (z) {
                                    f5 = flow.P0;
                                    f3 = f2 - f5;
                                } else {
                                    f4 = flow.P0;
                                    f3 = f4;
                                }
                            }
                            constraintWidget9.l0 = i4;
                            constraintWidget9.f0 = f3;
                        } else {
                            z3 = z4;
                        }
                        if (!z2 || (i4 = flow.L0) == -1) {
                            i4 = i28;
                            constraintWidget9.l0 = i4;
                            constraintWidget9.f0 = f3;
                        } else if (z) {
                            f5 = flow.R0;
                            f3 = f2 - f5;
                            constraintWidget9.l0 = i4;
                            constraintWidget9.f0 = f3;
                        } else {
                            f4 = flow.R0;
                            f3 = f4;
                            constraintWidget9.l0 = i4;
                            constraintWidget9.f0 = f3;
                        }
                    } else {
                        z3 = z4;
                    }
                    if (i25 == i6 - 1) {
                        constraintWidget9.i(constraintWidget9.L, this.f1974f, this.f1978j);
                    }
                    if (constraintWidget8 != null) {
                        int i29 = flow.T0;
                        ConstraintAnchor constraintAnchor11 = constraintWidget8.L;
                        constraintAnchor10.a(constraintAnchor11, i29);
                        if (i25 == i8) {
                            int i30 = this.f1976h;
                            if (constraintAnchor10.h()) {
                                constraintAnchor10.f1939h = i30;
                            }
                        }
                        constraintAnchor11.a(constraintAnchor10, 0);
                        if (i25 == i9 + 1) {
                            int i31 = this.f1978j;
                            if (constraintAnchor11.h()) {
                                constraintAnchor11.f1939h = i31;
                            }
                        }
                    }
                    if (constraintWidget9 != constraintWidget7) {
                        int i32 = flow.W0;
                        c2 = 3;
                        if (i32 == 3 && constraintWidget.E && constraintWidget9 != constraintWidget && constraintWidget9.E) {
                            constraintWidget9.N.a(constraintWidget.N, 0);
                        } else {
                            ConstraintAnchor constraintAnchor12 = constraintWidget9.K;
                            if (i32 != 0) {
                                ConstraintAnchor constraintAnchor13 = constraintWidget9.M;
                                if (i32 == 1) {
                                    constraintAnchor13.a(constraintAnchor9, 0);
                                } else if (z3) {
                                    constraintAnchor12.a(this.f1973e, this.f1977i);
                                    constraintAnchor13.a(this.f1975g, this.f1979k);
                                } else {
                                    constraintAnchor12.a(constraintAnchor8, 0);
                                    constraintAnchor13.a(constraintAnchor9, 0);
                                }
                            } else {
                                constraintAnchor12.a(constraintAnchor8, 0);
                            }
                        }
                    } else {
                        c2 = 3;
                    }
                    constraintWidget8 = constraintWidget9;
                }
                i25++;
                z4 = z3;
            }
        }

        public final int c() {
            return this.f1969a == 1 ? this.f1981m - Flow.this.U0 : this.f1981m;
        }

        public final int d() {
            return this.f1969a == 0 ? this.f1980l - Flow.this.T0 : this.f1980l;
        }

        public final void e(int i2) {
            int i3 = this.p;
            if (i3 == 0) {
                return;
            }
            int i4 = this.o;
            int i5 = i2 / i3;
            for (int i6 = 0; i6 < i4; i6++) {
                int i7 = this.n;
                int i8 = i7 + i6;
                Flow flow = Flow.this;
                if (i8 >= flow.f1) {
                    break;
                }
                ConstraintWidget constraintWidget = flow.e1[i7 + i6];
                int i9 = this.f1969a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1964a;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1966c;
                if (i9 == 0) {
                    if (constraintWidget != null) {
                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
                        if (dimensionBehaviourArr[0] == dimensionBehaviour2 && constraintWidget.r == 0) {
                            flow.X(constraintWidget, dimensionBehaviour, i5, dimensionBehaviourArr[1], constraintWidget.o());
                        }
                    }
                } else if (constraintWidget != null) {
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget.U;
                    if (dimensionBehaviourArr2[1] == dimensionBehaviour2 && constraintWidget.s == 0) {
                        int i10 = i5;
                        flow.X(constraintWidget, dimensionBehaviourArr2[0], constraintWidget.u(), dimensionBehaviour, i10);
                        i5 = i10;
                    }
                }
            }
            this.f1980l = 0;
            this.f1981m = 0;
            this.f1970b = null;
            this.f1971c = 0;
            int i11 = this.o;
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = this.n + i12;
                Flow flow2 = Flow.this;
                if (i13 >= flow2.f1) {
                    return;
                }
                ConstraintWidget constraintWidget2 = flow2.e1[i13];
                if (this.f1969a == 0) {
                    int iU = constraintWidget2.u();
                    int i14 = flow2.T0;
                    if (constraintWidget2.i0 == 8) {
                        i14 = 0;
                    }
                    this.f1980l = iU + i14 + this.f1980l;
                    int iY = flow2.Y(constraintWidget2, this.q);
                    if (this.f1970b == null || this.f1971c < iY) {
                        this.f1970b = constraintWidget2;
                        this.f1971c = iY;
                        this.f1981m = iY;
                    }
                } else {
                    int iZ = flow2.Z(constraintWidget2, this.q);
                    int iY2 = flow2.Y(constraintWidget2, this.q);
                    int i15 = flow2.U0;
                    if (constraintWidget2.i0 == 8) {
                        i15 = 0;
                    }
                    this.f1981m = iY2 + i15 + this.f1981m;
                    if (this.f1970b == null || this.f1971c < iZ) {
                        this.f1970b = constraintWidget2;
                        this.f1971c = iZ;
                        this.f1980l = iZ;
                    }
                }
            }
        }

        public final void f(int i2, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i3, int i4, int i5, int i6, int i7) {
            this.f1969a = i2;
            this.f1972d = constraintAnchor;
            this.f1973e = constraintAnchor2;
            this.f1974f = constraintAnchor3;
            this.f1975g = constraintAnchor4;
            this.f1976h = i3;
            this.f1977i = i4;
            this.f1978j = i5;
            this.f1979k = i6;
            this.q = i7;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:395:0x06be  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x06c3  */
    /* JADX WARN: Removed duplicated region for block: B:404:0x06d5  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x06d8  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x06f4  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0116  */
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W(int r39, int r40, int r41, int r42) {
        /*
            Method dump skipped, instructions count: 1788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.W(int, int, int, int):void");
    }

    public final int Y(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.U[1] == ConstraintWidget.DimensionBehaviour.f1966c) {
            int i3 = constraintWidget.s;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.z * i2);
                if (i4 != constraintWidget.o()) {
                    constraintWidget.f1956g = true;
                    X(constraintWidget, constraintWidget.U[0], constraintWidget.u(), ConstraintWidget.DimensionBehaviour.f1964a, i4);
                }
                return i4;
            }
            constraintWidget2 = constraintWidget;
            if (i3 == 1) {
                return constraintWidget2.o();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget2.u() * constraintWidget2.Y) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.o();
    }

    public final int Z(ConstraintWidget constraintWidget, int i2) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.U[0] == ConstraintWidget.DimensionBehaviour.f1966c) {
            int i3 = constraintWidget.r;
            if (i3 == 0) {
                return 0;
            }
            if (i3 == 2) {
                int i4 = (int) (constraintWidget.w * i2);
                if (i4 != constraintWidget.u()) {
                    constraintWidget.f1956g = true;
                    X(constraintWidget, ConstraintWidget.DimensionBehaviour.f1964a, i4, constraintWidget.U[1], constraintWidget.o());
                }
                return i4;
            }
            constraintWidget2 = constraintWidget;
            if (i3 == 1) {
                return constraintWidget2.u();
            }
            if (i3 == 3) {
                return (int) ((constraintWidget2.o() * constraintWidget2.Y) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.u();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void e(LinearSystem linearSystem, boolean z) {
        ConstraintWidget constraintWidget;
        float f2;
        int i2;
        super.e(linearSystem, z);
        ConstraintWidget constraintWidget2 = this.V;
        boolean z2 = constraintWidget2 != null && ((ConstraintWidgetContainer) constraintWidget2).z0;
        int i3 = this.X0;
        ArrayList arrayList = this.a1;
        if (i3 != 0) {
            if (i3 == 1) {
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    ((WidgetsList) arrayList.get(i4)).b(i4, z2, i4 == size + (-1));
                    i4++;
                }
            } else if (i3 != 2) {
                if (i3 == 3) {
                    int size2 = arrayList.size();
                    int i5 = 0;
                    while (i5 < size2) {
                        ((WidgetsList) arrayList.get(i5)).b(i5, z2, i5 == size2 + (-1));
                        i5++;
                    }
                }
            } else if (this.d1 != null && this.c1 != null && this.b1 != null) {
                for (int i6 = 0; i6 < this.f1; i6++) {
                    this.e1[i6].H();
                }
                int[] iArr = this.d1;
                int i7 = iArr[0];
                int i8 = iArr[1];
                float f3 = this.N0;
                ConstraintWidget constraintWidget3 = null;
                int i9 = 0;
                while (i9 < i7) {
                    if (z2) {
                        i2 = (i7 - i9) - 1;
                        f2 = 1.0f - this.N0;
                    } else {
                        f2 = f3;
                        i2 = i9;
                    }
                    ConstraintWidget constraintWidget4 = this.c1[i2];
                    if (constraintWidget4 != null && constraintWidget4.i0 != 8) {
                        ConstraintAnchor constraintAnchor = constraintWidget4.J;
                        if (i9 == 0) {
                            constraintWidget4.i(constraintAnchor, this.J, this.A0);
                            constraintWidget4.l0 = this.H0;
                            constraintWidget4.f0 = f2;
                        }
                        if (i9 == i7 - 1) {
                            constraintWidget4.i(constraintWidget4.L, this.L, this.B0);
                        }
                        if (i9 > 0 && constraintWidget3 != null) {
                            int i10 = this.T0;
                            ConstraintAnchor constraintAnchor2 = constraintWidget3.L;
                            constraintWidget4.i(constraintAnchor, constraintAnchor2, i10);
                            constraintWidget3.i(constraintAnchor2, constraintAnchor, 0);
                        }
                        constraintWidget3 = constraintWidget4;
                    }
                    i9++;
                    f3 = f2;
                }
                for (int i11 = 0; i11 < i8; i11++) {
                    ConstraintWidget constraintWidget5 = this.b1[i11];
                    if (constraintWidget5 != null && constraintWidget5.i0 != 8) {
                        ConstraintAnchor constraintAnchor3 = constraintWidget5.K;
                        if (i11 == 0) {
                            constraintWidget5.i(constraintAnchor3, this.K, this.w0);
                            constraintWidget5.m0 = this.I0;
                            constraintWidget5.g0 = this.O0;
                        }
                        if (i11 == i8 - 1) {
                            constraintWidget5.i(constraintWidget5.M, this.M, this.x0);
                        }
                        if (i11 > 0 && constraintWidget3 != null) {
                            int i12 = this.U0;
                            ConstraintAnchor constraintAnchor4 = constraintWidget3.M;
                            constraintWidget5.i(constraintAnchor3, constraintAnchor4, i12);
                            constraintWidget3.i(constraintAnchor4, constraintAnchor3, 0);
                        }
                        constraintWidget3 = constraintWidget5;
                    }
                }
                for (int i13 = 0; i13 < i7; i13++) {
                    for (int i14 = 0; i14 < i8; i14++) {
                        int i15 = (i14 * i7) + i13;
                        if (this.Z0 == 1) {
                            i15 = (i13 * i8) + i14;
                        }
                        ConstraintWidget[] constraintWidgetArr = this.e1;
                        if (i15 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i15]) != null && constraintWidget.i0 != 8) {
                            ConstraintWidget constraintWidget6 = this.c1[i13];
                            ConstraintWidget constraintWidget7 = this.b1[i14];
                            if (constraintWidget != constraintWidget6) {
                                constraintWidget.i(constraintWidget.J, constraintWidget6.J, 0);
                                constraintWidget.i(constraintWidget.L, constraintWidget6.L, 0);
                            }
                            if (constraintWidget != constraintWidget7) {
                                constraintWidget.i(constraintWidget.K, constraintWidget7.K, 0);
                                constraintWidget.i(constraintWidget.M, constraintWidget7.M, 0);
                            }
                        }
                    }
                }
            }
        } else if (arrayList.size() > 0) {
            ((WidgetsList) arrayList.get(0)).b(0, z2, true);
        }
        this.C0 = false;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void j(ConstraintWidget constraintWidget, HashMap map) {
        super.j(constraintWidget, map);
        Flow flow = (Flow) constraintWidget;
        this.H0 = flow.H0;
        this.I0 = flow.I0;
        this.J0 = flow.J0;
        this.K0 = flow.K0;
        this.L0 = flow.L0;
        this.M0 = flow.M0;
        this.N0 = flow.N0;
        this.O0 = flow.O0;
        this.P0 = flow.P0;
        this.Q0 = flow.Q0;
        this.R0 = flow.R0;
        this.S0 = flow.S0;
        this.T0 = flow.T0;
        this.U0 = flow.U0;
        this.V0 = flow.V0;
        this.W0 = flow.W0;
        this.X0 = flow.X0;
        this.Y0 = flow.Y0;
        this.Z0 = flow.Z0;
    }
}
