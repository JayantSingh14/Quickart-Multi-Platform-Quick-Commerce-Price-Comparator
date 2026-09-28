package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Guideline extends ConstraintWidget {
    public float u0 = -1.0f;
    public int v0 = -1;
    public int w0 = -1;
    public ConstraintAnchor x0 = this.K;
    public int y0 = 0;
    public boolean z0;

    /* renamed from: androidx.constraintlayout.core.widgets.Guideline$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1982a;

        static {
            int[] iArr = new int[ConstraintAnchor.Type.values().length];
            f1982a = iArr;
            try {
                iArr[1] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1982a[3] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1982a[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1982a[4] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1982a[5] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1982a[6] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1982a[7] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1982a[8] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1982a[0] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public Guideline() {
        this.S.clear();
        this.S.add(this.x0);
        int length = this.R.length;
        for (int i2 = 0; i2 < length; i2++) {
            this.R[i2] = this.x0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean E() {
        return this.z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean F() {
        return this.z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void U(LinearSystem linearSystem, boolean z) {
        if (this.V == null) {
            return;
        }
        ConstraintAnchor constraintAnchor = this.x0;
        linearSystem.getClass();
        int iN = LinearSystem.n(constraintAnchor);
        if (this.y0 == 1) {
            this.a0 = iN;
            this.b0 = 0;
            P(this.V.o());
            S(0);
            return;
        }
        this.a0 = 0;
        this.b0 = iN;
        S(this.V.u());
        P(0);
    }

    public final void V(int i2) {
        this.x0.l(i2);
        this.z0 = true;
    }

    public final void W(int i2) {
        if (this.y0 == i2) {
            return;
        }
        this.y0 = i2;
        ArrayList arrayList = this.S;
        arrayList.clear();
        if (this.y0 == 1) {
            this.x0 = this.J;
        } else {
            this.x0 = this.K;
        }
        arrayList.add(this.x0);
        ConstraintAnchor[] constraintAnchorArr = this.R;
        int length = constraintAnchorArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            constraintAnchorArr[i3] = this.x0;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void e(LinearSystem linearSystem, boolean z) {
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) this.V;
        if (constraintWidgetContainer == null) {
            return;
        }
        Object objM = constraintWidgetContainer.m(ConstraintAnchor.Type.f1941a);
        Object objM2 = constraintWidgetContainer.m(ConstraintAnchor.Type.f1943c);
        ConstraintWidget constraintWidget = this.V;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1965b;
        boolean z2 = constraintWidget != null && constraintWidget.U[0] == dimensionBehaviour;
        if (this.y0 == 0) {
            objM = constraintWidgetContainer.m(ConstraintAnchor.Type.f1942b);
            objM2 = constraintWidgetContainer.m(ConstraintAnchor.Type.f1944d);
            ConstraintWidget constraintWidget2 = this.V;
            z2 = constraintWidget2 != null && constraintWidget2.U[1] == dimensionBehaviour;
        }
        if (this.z0) {
            ConstraintAnchor constraintAnchor = this.x0;
            if (constraintAnchor.f1934c) {
                SolverVariable solverVariableK = linearSystem.k(constraintAnchor);
                linearSystem.d(solverVariableK, this.x0.d());
                if (this.v0 != -1) {
                    if (z2) {
                        linearSystem.f(linearSystem.k(objM2), solverVariableK, 0, 5);
                    }
                } else if (this.w0 != -1 && z2) {
                    SolverVariable solverVariableK2 = linearSystem.k(objM2);
                    linearSystem.f(solverVariableK, linearSystem.k(objM), 0, 5);
                    linearSystem.f(solverVariableK2, solverVariableK, 0, 5);
                }
                this.z0 = false;
                return;
            }
        }
        if (this.v0 != -1) {
            SolverVariable solverVariableK3 = linearSystem.k(this.x0);
            linearSystem.e(solverVariableK3, linearSystem.k(objM), this.v0, 8);
            if (z2) {
                linearSystem.f(linearSystem.k(objM2), solverVariableK3, 0, 5);
                return;
            }
            return;
        }
        if (this.w0 != -1) {
            SolverVariable solverVariableK4 = linearSystem.k(this.x0);
            SolverVariable solverVariableK5 = linearSystem.k(objM2);
            linearSystem.e(solverVariableK4, solverVariableK5, -this.w0, 8);
            if (z2) {
                linearSystem.f(solverVariableK4, linearSystem.k(objM), 0, 5);
                linearSystem.f(solverVariableK5, solverVariableK4, 0, 5);
                return;
            }
            return;
        }
        if (this.u0 != -1.0f) {
            SolverVariable solverVariableK6 = linearSystem.k(this.x0);
            SolverVariable solverVariableK7 = linearSystem.k(objM2);
            float f2 = this.u0;
            ArrayRow arrayRowL = linearSystem.l();
            arrayRowL.f1659d.h(solverVariableK6, -1.0f);
            arrayRowL.f1659d.h(solverVariableK7, f2);
            linearSystem.c(arrayRowL);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean f() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void j(ConstraintWidget constraintWidget, HashMap map) {
        super.j(constraintWidget, map);
        Guideline guideline = (Guideline) constraintWidget;
        this.u0 = guideline.u0;
        this.v0 = guideline.v0;
        this.w0 = guideline.w0;
        W(guideline.y0);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final ConstraintAnchor m(ConstraintAnchor.Type type) {
        int iOrdinal = type.ordinal();
        if (iOrdinal != 1) {
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return null;
                    }
                }
            }
            if (this.y0 == 0) {
                return this.x0;
            }
            return null;
        }
        if (this.y0 == 1) {
            return this.x0;
        }
        return null;
    }
}
