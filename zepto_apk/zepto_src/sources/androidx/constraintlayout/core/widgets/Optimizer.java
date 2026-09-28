package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;

/* loaded from: classes3.dex */
public class Optimizer {

    /* renamed from: a, reason: collision with root package name */
    public static final boolean[] f1983a = new boolean[3];

    public static void a(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ConstraintWidget constraintWidget) {
        constraintWidget.o = -1;
        constraintWidget.p = -1;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.U[0];
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1965b;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1967d;
        if (dimensionBehaviour != dimensionBehaviour2 && constraintWidget.U[0] == dimensionBehaviour3) {
            ConstraintAnchor constraintAnchor = constraintWidget.J;
            int i2 = constraintAnchor.f1938g;
            int iU = constraintWidgetContainer.u();
            ConstraintAnchor constraintAnchor2 = constraintWidget.L;
            int i3 = iU - constraintAnchor2.f1938g;
            constraintAnchor.f1940i = linearSystem.k(constraintAnchor);
            constraintAnchor2.f1940i = linearSystem.k(constraintAnchor2);
            linearSystem.d(constraintAnchor.f1940i, i2);
            linearSystem.d(constraintAnchor2.f1940i, i3);
            constraintWidget.o = 2;
            constraintWidget.a0 = i2;
            int i4 = i3 - i2;
            constraintWidget.W = i4;
            int i5 = constraintWidget.d0;
            if (i4 < i5) {
                constraintWidget.W = i5;
            }
        }
        if (constraintWidgetContainer.U[1] == dimensionBehaviour2 || constraintWidget.U[1] != dimensionBehaviour3) {
            return;
        }
        ConstraintAnchor constraintAnchor3 = constraintWidget.K;
        int i6 = constraintAnchor3.f1938g;
        int iO = constraintWidgetContainer.o();
        ConstraintAnchor constraintAnchor4 = constraintWidget.M;
        int i7 = iO - constraintAnchor4.f1938g;
        constraintAnchor3.f1940i = linearSystem.k(constraintAnchor3);
        constraintAnchor4.f1940i = linearSystem.k(constraintAnchor4);
        linearSystem.d(constraintAnchor3.f1940i, i6);
        linearSystem.d(constraintAnchor4.f1940i, i7);
        if (constraintWidget.c0 > 0 || constraintWidget.i0 == 8) {
            ConstraintAnchor constraintAnchor5 = constraintWidget.N;
            constraintAnchor5.f1940i = linearSystem.k(constraintAnchor5);
            linearSystem.d(constraintAnchor5.f1940i, constraintWidget.c0 + i6);
        }
        constraintWidget.p = 2;
        constraintWidget.b0 = i6;
        int i8 = i7 - i6;
        constraintWidget.X = i8;
        int i9 = constraintWidget.e0;
        if (i8 < i9) {
            constraintWidget.X = i9;
        }
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
