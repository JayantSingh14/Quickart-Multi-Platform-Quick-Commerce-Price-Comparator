package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* loaded from: classes3.dex */
public class Placeholder extends VirtualLayout {
    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public final void W(int i2, int i3, int i4, int i5) {
        int iU = this.A0 + this.B0;
        int iO = this.w0 + this.x0;
        if (this.v0 > 0) {
            iU += this.u0[0].u();
            iO += this.u0[0].o();
        }
        int iMax = Math.max(this.d0, iU);
        int iMax2 = Math.max(this.e0, iO);
        if (i2 != 1073741824) {
            i3 = i2 == Integer.MIN_VALUE ? Math.min(iMax, i3) : i2 == 0 ? iMax : 0;
        }
        if (i4 != 1073741824) {
            i5 = i4 == Integer.MIN_VALUE ? Math.min(iMax2, i5) : i4 == 0 ? iMax2 : 0;
        }
        this.D0 = i3;
        this.E0 = i5;
        S(i3);
        P(i5);
        this.C0 = this.v0 > 0;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void e(LinearSystem linearSystem, boolean z) {
        super.e(linearSystem, z);
        if (this.v0 > 0) {
            ConstraintWidget constraintWidget = this.u0[0];
            constraintWidget.H();
            constraintWidget.g0 = 0.5f;
            constraintWidget.f0 = 0.5f;
            ConstraintAnchor.Type type = ConstraintAnchor.Type.f1941a;
            constraintWidget.h(type, this, type, 0);
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.f1943c;
            constraintWidget.h(type2, this, type2, 0);
            ConstraintAnchor.Type type3 = ConstraintAnchor.Type.f1942b;
            constraintWidget.h(type3, this, type3, 0);
            ConstraintAnchor.Type type4 = ConstraintAnchor.Type.f1944d;
            constraintWidget.h(type4, this, type4, 0);
        }
    }
}
