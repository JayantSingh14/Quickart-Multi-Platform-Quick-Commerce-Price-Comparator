package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;

/* loaded from: classes3.dex */
public class VirtualLayout extends HelperWidget {
    public int w0 = 0;
    public int x0 = 0;
    public int y0 = 0;
    public int z0 = 0;
    public int A0 = 0;
    public int B0 = 0;
    public boolean C0 = false;
    public int D0 = 0;
    public int E0 = 0;
    public final BasicMeasure.Measure F0 = new BasicMeasure.Measure();
    public BasicMeasure.Measurer G0 = null;

    public void W(int i2, int i3, int i4, int i5) {
    }

    public final void X(ConstraintWidget constraintWidget, ConstraintWidget.DimensionBehaviour dimensionBehaviour, int i2, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, int i3) {
        BasicMeasure.Measurer measurer;
        ConstraintWidget constraintWidget2;
        while (true) {
            measurer = this.G0;
            if (measurer != null || (constraintWidget2 = this.V) == null) {
                break;
            } else {
                this.G0 = ((ConstraintWidgetContainer) constraintWidget2).y0;
            }
        }
        BasicMeasure.Measure measure = this.F0;
        measure.f1987a = dimensionBehaviour;
        measure.f1988b = dimensionBehaviour2;
        measure.f1989c = i2;
        measure.f1990d = i3;
        measurer.b(constraintWidget, measure);
        constraintWidget.S(measure.f1991e);
        constraintWidget.P(measure.f1992f);
        constraintWidget.E = measure.f1994h;
        constraintWidget.M(measure.f1993g);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.Helper
    public final void c() {
        for (int i2 = 0; i2 < this.v0; i2++) {
            ConstraintWidget constraintWidget = this.u0[i2];
            if (constraintWidget != null) {
                constraintWidget.G = true;
            }
        }
    }
}
