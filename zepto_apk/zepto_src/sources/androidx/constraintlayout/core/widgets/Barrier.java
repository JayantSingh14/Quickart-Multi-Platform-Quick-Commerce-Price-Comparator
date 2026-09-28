package androidx.constraintlayout.core.widgets;

import android.support.v4.media.b;
import androidx.constraintlayout.core.ArrayRow;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Barrier extends HelperWidget {
    public int w0 = 0;
    public boolean x0 = true;
    public int y0 = 0;
    public boolean z0 = false;

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean E() {
        return this.z0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean F() {
        return this.z0;
    }

    public final boolean W() {
        int i2;
        int i3;
        int i4;
        boolean z = true;
        int i5 = 0;
        while (true) {
            i2 = this.v0;
            if (i5 >= i2) {
                break;
            }
            ConstraintWidget constraintWidget = this.u0[i5];
            if ((this.x0 || constraintWidget.f()) && ((((i3 = this.w0) == 0 || i3 == 1) && !constraintWidget.E()) || (((i4 = this.w0) == 2 || i4 == 3) && !constraintWidget.F()))) {
                z = false;
            }
            i5++;
        }
        if (!z || i2 <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i6 = 0; i6 < this.v0; i6++) {
            ConstraintWidget constraintWidget2 = this.u0[i6];
            if (this.x0 || constraintWidget2.f()) {
                ConstraintAnchor.Type type = ConstraintAnchor.Type.f1944d;
                ConstraintAnchor.Type type2 = ConstraintAnchor.Type.f1942b;
                ConstraintAnchor.Type type3 = ConstraintAnchor.Type.f1943c;
                ConstraintAnchor.Type type4 = ConstraintAnchor.Type.f1941a;
                if (!z2) {
                    int i7 = this.w0;
                    if (i7 == 0) {
                        iMax = constraintWidget2.m(type4).d();
                    } else if (i7 == 1) {
                        iMax = constraintWidget2.m(type3).d();
                    } else if (i7 == 2) {
                        iMax = constraintWidget2.m(type2).d();
                    } else if (i7 == 3) {
                        iMax = constraintWidget2.m(type).d();
                    }
                    z2 = true;
                }
                int i8 = this.w0;
                if (i8 == 0) {
                    iMax = Math.min(iMax, constraintWidget2.m(type4).d());
                } else if (i8 == 1) {
                    iMax = Math.max(iMax, constraintWidget2.m(type3).d());
                } else if (i8 == 2) {
                    iMax = Math.min(iMax, constraintWidget2.m(type2).d());
                } else if (i8 == 3) {
                    iMax = Math.max(iMax, constraintWidget2.m(type).d());
                }
            }
        }
        int i9 = iMax + this.y0;
        int i10 = this.w0;
        if (i10 == 0 || i10 == 1) {
            N(i9, i9);
        } else {
            O(i9, i9);
        }
        this.z0 = true;
        return true;
    }

    public final int X() {
        int i2 = this.w0;
        if (i2 == 0 || i2 == 1) {
            return 0;
        }
        return (i2 == 2 || i2 == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void e(LinearSystem linearSystem, boolean z) {
        boolean z2;
        int i2;
        ConstraintAnchor[] constraintAnchorArr = this.R;
        ConstraintAnchor constraintAnchor = this.J;
        constraintAnchorArr[0] = constraintAnchor;
        ConstraintAnchor constraintAnchor2 = this.K;
        int i3 = 2;
        constraintAnchorArr[2] = constraintAnchor2;
        ConstraintAnchor constraintAnchor3 = this.L;
        constraintAnchorArr[1] = constraintAnchor3;
        ConstraintAnchor constraintAnchor4 = this.M;
        constraintAnchorArr[3] = constraintAnchor4;
        for (ConstraintAnchor constraintAnchor5 : constraintAnchorArr) {
            constraintAnchor5.f1940i = linearSystem.k(constraintAnchor5);
        }
        int i4 = this.w0;
        if (i4 < 0 || i4 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchorArr[i4];
        if (!this.z0) {
            W();
        }
        if (this.z0) {
            this.z0 = false;
            int i5 = this.w0;
            if (i5 == 0 || i5 == 1) {
                linearSystem.d(constraintAnchor.f1940i, this.a0);
                linearSystem.d(constraintAnchor3.f1940i, this.a0);
                return;
            } else {
                if (i5 == 2 || i5 == 3) {
                    linearSystem.d(constraintAnchor2.f1940i, this.b0);
                    linearSystem.d(constraintAnchor4.f1940i, this.b0);
                    return;
                }
                return;
            }
        }
        for (int i6 = 0; i6 < this.v0; i6++) {
            ConstraintWidget constraintWidget = this.u0[i6];
            if (this.x0 || constraintWidget.f()) {
                int i7 = this.w0;
                ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1966c;
                if (((i7 == 0 || i7 == 1) && constraintWidget.U[0] == dimensionBehaviour && constraintWidget.J.f1937f != null && constraintWidget.L.f1937f != null) || ((i7 == 2 || i7 == 3) && constraintWidget.U[1] == dimensionBehaviour && constraintWidget.K.f1937f != null && constraintWidget.M.f1937f != null)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        boolean z3 = constraintAnchor.g() || constraintAnchor3.g();
        boolean z4 = constraintAnchor2.g() || constraintAnchor4.g();
        int i8 = (z2 || !(((i2 = this.w0) == 0 && z3) || ((i2 == 2 && z4) || ((i2 == 1 && z3) || (i2 == 3 && z4))))) ? 4 : 5;
        int i9 = 0;
        while (i9 < this.v0) {
            ConstraintWidget constraintWidget2 = this.u0[i9];
            if (this.x0 || constraintWidget2.f()) {
                SolverVariable solverVariableK = linearSystem.k(constraintWidget2.R[this.w0]);
                int i10 = this.w0;
                ConstraintAnchor constraintAnchor7 = constraintWidget2.R[i10];
                constraintAnchor7.f1940i = solverVariableK;
                ConstraintAnchor constraintAnchor8 = constraintAnchor7.f1937f;
                int i11 = (constraintAnchor8 == null || constraintAnchor8.f1935d != this) ? 0 : constraintAnchor7.f1938g;
                if (i10 == 0 || i10 == i3) {
                    SolverVariable solverVariable = constraintAnchor6.f1940i;
                    int i12 = this.y0 - i11;
                    ArrayRow arrayRowL = linearSystem.l();
                    SolverVariable solverVariableM = linearSystem.m();
                    solverVariableM.f1695d = 0;
                    arrayRowL.d(solverVariable, solverVariableK, solverVariableM, i12);
                    linearSystem.c(arrayRowL);
                } else {
                    SolverVariable solverVariable2 = constraintAnchor6.f1940i;
                    int i13 = this.y0 + i11;
                    ArrayRow arrayRowL2 = linearSystem.l();
                    SolverVariable solverVariableM2 = linearSystem.m();
                    solverVariableM2.f1695d = 0;
                    arrayRowL2.c(solverVariable2, solverVariableK, solverVariableM2, i13);
                    linearSystem.c(arrayRowL2);
                }
                linearSystem.e(constraintAnchor6.f1940i, solverVariableK, this.y0 + i11, i8);
            }
            i9++;
            i3 = 2;
        }
        int i14 = this.w0;
        if (i14 == 0) {
            linearSystem.e(constraintAnchor3.f1940i, constraintAnchor.f1940i, 0, 8);
            linearSystem.e(constraintAnchor.f1940i, this.V.L.f1940i, 0, 4);
            linearSystem.e(constraintAnchor.f1940i, this.V.J.f1940i, 0, 0);
            return;
        }
        if (i14 == 1) {
            linearSystem.e(constraintAnchor.f1940i, constraintAnchor3.f1940i, 0, 8);
            linearSystem.e(constraintAnchor.f1940i, this.V.J.f1940i, 0, 4);
            linearSystem.e(constraintAnchor.f1940i, this.V.L.f1940i, 0, 0);
        } else if (i14 == 2) {
            linearSystem.e(constraintAnchor4.f1940i, constraintAnchor2.f1940i, 0, 8);
            linearSystem.e(constraintAnchor2.f1940i, this.V.M.f1940i, 0, 4);
            linearSystem.e(constraintAnchor2.f1940i, this.V.K.f1940i, 0, 0);
        } else if (i14 == 3) {
            linearSystem.e(constraintAnchor2.f1940i, constraintAnchor4.f1940i, 0, 8);
            linearSystem.e(constraintAnchor2.f1940i, this.V.K.f1940i, 0, 4);
            linearSystem.e(constraintAnchor2.f1940i, this.V.M.f1940i, 0, 0);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final boolean f() {
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void j(ConstraintWidget constraintWidget, HashMap map) {
        super.j(constraintWidget, map);
        Barrier barrier = (Barrier) constraintWidget;
        this.w0 = barrier.w0;
        this.x0 = barrier.x0;
        this.y0 = barrier.y0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final String toString() {
        String strR = b.r(new StringBuilder("[Barrier] "), this.k0, " {");
        for (int i2 = 0; i2 < this.v0; i2++) {
            ConstraintWidget constraintWidget = this.u0[i2];
            if (i2 > 0) {
                strR = b.k(strR, ", ");
            }
            StringBuilder sbW = b.w(strR);
            sbW.append(constraintWidget.k0);
            strR = sbW.toString();
        }
        return b.k(strR, "}");
    }
}
