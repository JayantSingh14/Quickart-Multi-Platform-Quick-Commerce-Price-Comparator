package androidx.constraintlayout.core.utils;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class GridCore extends VirtualLayout {
    public ConstraintWidgetContainer H0;
    public ConstraintWidget[] I0;
    public final int J0;
    public final int K0;
    public int L0;
    public final boolean[][] M0;
    public final HashSet N0 = new HashSet();
    public final int[][] O0;

    public GridCore() {
        boolean[][] zArr;
        this.L0 = 0;
        int iSqrt = (int) (Math.sqrt(this.v0) + 1.5d);
        this.J0 = iSqrt;
        int i2 = this.v0;
        int i3 = ((i2 + iSqrt) - 1) / iSqrt;
        this.K0 = i3;
        int[][] iArr = this.O0;
        boolean z = iArr != null && iArr.length == i2 && (zArr = this.M0) != null && zArr.length == iSqrt && zArr[0].length == i3;
        if (!z) {
            boolean[][] zArr2 = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, iSqrt, i3);
            this.M0 = zArr2;
            for (boolean[] zArr3 : zArr2) {
                Arrays.fill(zArr3, true);
            }
            int i4 = this.v0;
            if (i4 > 0) {
                int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i4, 4);
                this.O0 = iArr2;
                for (int[] iArr3 : iArr2) {
                    Arrays.fill(iArr3, -1);
                }
            }
        }
        if (z) {
            for (int i5 = 0; i5 < this.M0.length; i5++) {
                int i6 = 0;
                while (true) {
                    boolean[][] zArr4 = this.M0;
                    if (i6 < zArr4[0].length) {
                        zArr4[i5][i6] = true;
                        i6++;
                    }
                }
            }
            for (int i7 = 0; i7 < this.O0.length; i7++) {
                int i8 = 0;
                while (true) {
                    int[][] iArr4 = this.O0;
                    if (i8 < iArr4[0].length) {
                        iArr4[i7][i8] = -1;
                        i8++;
                    }
                }
            }
        }
        this.L0 = 0;
    }

    public static void Y(ConstraintWidget constraintWidget) {
        constraintWidget.n0[1] = -1.0f;
        constraintWidget.K.j();
        constraintWidget.M.j();
        constraintWidget.N.j();
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public final void W(int i2, int i3, int i4, int i5) {
        int i6;
        this.H0 = (ConstraintWidgetContainer) this.V;
        int i7 = this.J0;
        if (i7 >= 1 && (i6 = this.K0) >= 1) {
            this.L0 = 0;
            int iMax = Math.max(i7, i6);
            ConstraintWidget[] constraintWidgetArr = this.I0;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.f1966c;
            if (constraintWidgetArr == null) {
                this.I0 = new ConstraintWidget[iMax];
                int i8 = 0;
                while (true) {
                    ConstraintWidget[] constraintWidgetArr2 = this.I0;
                    if (i8 >= constraintWidgetArr2.length) {
                        break;
                    }
                    ConstraintWidget constraintWidget = new ConstraintWidget();
                    ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
                    dimensionBehaviourArr[0] = dimensionBehaviour;
                    dimensionBehaviourArr[1] = dimensionBehaviour;
                    constraintWidget.f1959j = String.valueOf(constraintWidget.hashCode());
                    constraintWidgetArr2[i8] = constraintWidget;
                    i8++;
                }
            } else if (iMax != constraintWidgetArr.length) {
                ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[iMax];
                for (int i9 = 0; i9 < iMax; i9++) {
                    ConstraintWidget[] constraintWidgetArr4 = this.I0;
                    if (i9 < constraintWidgetArr4.length) {
                        constraintWidgetArr3[i9] = constraintWidgetArr4[i9];
                    } else {
                        ConstraintWidget constraintWidget2 = new ConstraintWidget();
                        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr2 = constraintWidget2.U;
                        dimensionBehaviourArr2[0] = dimensionBehaviour;
                        dimensionBehaviourArr2[1] = dimensionBehaviour;
                        constraintWidget2.f1959j = String.valueOf(constraintWidget2.hashCode());
                        constraintWidgetArr3[i9] = constraintWidget2;
                    }
                }
                while (true) {
                    ConstraintWidget[] constraintWidgetArr5 = this.I0;
                    if (iMax >= constraintWidgetArr5.length) {
                        break;
                    }
                    ConstraintWidget constraintWidget3 = constraintWidgetArr5[iMax];
                    this.H0.u0.remove(constraintWidget3);
                    constraintWidget3.G();
                    iMax++;
                }
                this.I0 = constraintWidgetArr3;
            }
        }
        ConstraintWidgetContainer constraintWidgetContainer = this.H0;
        ConstraintWidget[] constraintWidgetArr6 = this.I0;
        constraintWidgetContainer.getClass();
        for (ConstraintWidget constraintWidget4 : constraintWidgetArr6) {
            constraintWidgetContainer.a(constraintWidget4);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void e(LinearSystem linearSystem, boolean z) {
        int i2;
        int i3;
        super.e(linearSystem, z);
        int iMax = Math.max(this.J0, this.K0);
        ConstraintWidget constraintWidget = this.I0[0];
        int i4 = this.J0;
        ConstraintAnchor constraintAnchor = this.M;
        ConstraintAnchor constraintAnchor2 = this.K;
        if (i4 == 1) {
            Y(constraintWidget);
            constraintWidget.K.a(constraintAnchor2, 0);
            constraintWidget.M.a(constraintAnchor, 0);
        } else {
            int i5 = 0;
            while (true) {
                i2 = this.J0;
                if (i5 >= i2) {
                    break;
                }
                ConstraintWidget constraintWidget2 = this.I0[i5];
                Y(constraintWidget2);
                ConstraintAnchor constraintAnchor3 = constraintWidget2.K;
                if (i5 > 0) {
                    constraintAnchor3.a(this.I0[i5 - 1].M, 0);
                } else {
                    constraintAnchor3.a(constraintAnchor2, 0);
                }
                int i6 = this.J0 - 1;
                ConstraintAnchor constraintAnchor4 = constraintWidget2.M;
                if (i5 < i6) {
                    constraintAnchor4.a(this.I0[i5 + 1].K, 0);
                } else {
                    constraintAnchor4.a(constraintAnchor, 0);
                }
                if (i5 > 0) {
                    constraintAnchor3.f1938g = (int) 0.0f;
                }
                i5++;
            }
            while (i2 < iMax) {
                ConstraintWidget constraintWidget3 = this.I0[i2];
                Y(constraintWidget3);
                constraintWidget3.K.a(constraintAnchor2, 0);
                constraintWidget3.M.a(constraintAnchor, 0);
                i2++;
            }
        }
        int iMax2 = Math.max(this.J0, this.K0);
        ConstraintWidget constraintWidget4 = this.I0[0];
        int i7 = this.K0;
        ConstraintAnchor constraintAnchor5 = this.L;
        ConstraintAnchor constraintAnchor6 = this.J;
        if (i7 == 1) {
            constraintWidget4.n0[0] = -1.0f;
            constraintWidget4.J.j();
            constraintWidget4.L.j();
            constraintWidget4.J.a(constraintAnchor6, 0);
            constraintWidget4.L.a(constraintAnchor5, 0);
        } else {
            int i8 = 0;
            while (true) {
                i3 = this.K0;
                if (i8 >= i3) {
                    break;
                }
                ConstraintWidget constraintWidget5 = this.I0[i8];
                constraintWidget5.n0[0] = -1.0f;
                constraintWidget5.J.j();
                constraintWidget5.L.j();
                ConstraintAnchor constraintAnchor7 = constraintWidget5.J;
                if (i8 > 0) {
                    constraintAnchor7.a(this.I0[i8 - 1].L, 0);
                } else {
                    constraintAnchor7.a(constraintAnchor6, 0);
                }
                int i9 = this.K0 - 1;
                ConstraintAnchor constraintAnchor8 = constraintWidget5.L;
                if (i8 < i9) {
                    constraintAnchor8.a(this.I0[i8 + 1].J, 0);
                } else {
                    constraintAnchor8.a(constraintAnchor5, 0);
                }
                if (i8 > 0) {
                    constraintAnchor7.f1938g = (int) 0.0f;
                }
                i8++;
            }
            while (i3 < iMax2) {
                ConstraintWidget constraintWidget6 = this.I0[i3];
                constraintWidget6.n0[0] = -1.0f;
                constraintWidget6.J.j();
                constraintWidget6.L.j();
                constraintWidget6.J.a(constraintAnchor6, 0);
                constraintWidget6.L.a(constraintAnchor5, 0);
                i3++;
            }
        }
        for (int i10 = 0; i10 < this.v0; i10++) {
            if (!this.N0.contains(this.u0[i10].f1959j)) {
                boolean z2 = false;
                int i11 = 0;
                while (true) {
                    if (z2) {
                        break;
                    }
                    i11 = this.L0;
                    int i12 = this.J0;
                    int i13 = this.K0;
                    if (i11 >= i12 * i13) {
                        i11 = -1;
                        break;
                    }
                    int i14 = i11 % i13;
                    boolean[] zArr = this.M0[i11 / i13];
                    if (zArr[i14]) {
                        zArr[i14] = false;
                        z2 = true;
                    }
                    this.L0 = i11 + 1;
                }
                int i15 = this.K0;
                int i16 = i11 / i15;
                int i17 = i11 % i15;
                if (i11 == -1) {
                    return;
                }
                ConstraintWidget constraintWidget7 = this.u0[i10];
                constraintWidget7.J.a(this.I0[i17].J, 0);
                constraintWidget7.K.a(this.I0[i16].K, 0);
                constraintWidget7.L.a(this.I0[i17].L, 0);
                constraintWidget7.M.a(this.I0[i16].M, 0);
            }
        }
    }
}
