package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class BasicMeasure {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1984a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public final Measure f1985b = new Measure();

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintWidgetContainer f1986c;

    public static class Measure {

        /* renamed from: a, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f1987a;

        /* renamed from: b, reason: collision with root package name */
        public ConstraintWidget.DimensionBehaviour f1988b;

        /* renamed from: c, reason: collision with root package name */
        public int f1989c;

        /* renamed from: d, reason: collision with root package name */
        public int f1990d;

        /* renamed from: e, reason: collision with root package name */
        public int f1991e;

        /* renamed from: f, reason: collision with root package name */
        public int f1992f;

        /* renamed from: g, reason: collision with root package name */
        public int f1993g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f1994h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f1995i;

        /* renamed from: j, reason: collision with root package name */
        public int f1996j;
    }

    public interface Measurer {
        void a();

        void b(ConstraintWidget constraintWidget, Measure measure);
    }

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.f1986c = constraintWidgetContainer;
    }

    public final boolean a(int i2, ConstraintWidget constraintWidget, Measurer measurer) {
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
        Measure measure = this.f1985b;
        measure.f1987a = dimensionBehaviour;
        measure.f1988b = dimensionBehaviourArr[1];
        measure.f1989c = constraintWidget.u();
        measure.f1990d = constraintWidget.o();
        measure.f1995i = false;
        measure.f1996j = i2;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure.f1987a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.f1966c;
        boolean z = dimensionBehaviour2 == dimensionBehaviour3;
        boolean z2 = measure.f1988b == dimensionBehaviour3;
        boolean z3 = z && constraintWidget.Y > 0.0f;
        boolean z4 = z2 && constraintWidget.Y > 0.0f;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.f1964a;
        int[] iArr = constraintWidget.t;
        if (z3 && iArr[0] == 4) {
            measure.f1987a = dimensionBehaviour4;
        }
        if (z4 && iArr[1] == 4) {
            measure.f1988b = dimensionBehaviour4;
        }
        measurer.b(constraintWidget, measure);
        constraintWidget.S(measure.f1991e);
        constraintWidget.P(measure.f1992f);
        constraintWidget.E = measure.f1994h;
        constraintWidget.M(measure.f1993g);
        measure.f1996j = 0;
        return measure.f1995i;
    }

    public final void b(ConstraintWidgetContainer constraintWidgetContainer, int i2, int i3, int i4) {
        constraintWidgetContainer.getClass();
        int i5 = constraintWidgetContainer.d0;
        int i6 = constraintWidgetContainer.e0;
        constraintWidgetContainer.d0 = 0;
        constraintWidgetContainer.e0 = 0;
        constraintWidgetContainer.S(i3);
        constraintWidgetContainer.P(i4);
        if (i5 < 0) {
            constraintWidgetContainer.d0 = 0;
        } else {
            constraintWidgetContainer.d0 = i5;
        }
        if (i6 < 0) {
            constraintWidgetContainer.e0 = 0;
        } else {
            constraintWidgetContainer.e0 = i6;
        }
        ConstraintWidgetContainer constraintWidgetContainer2 = this.f1986c;
        constraintWidgetContainer2.x0 = i2;
        constraintWidgetContainer2.V();
    }

    public final void c(ConstraintWidgetContainer constraintWidgetContainer) {
        ArrayList arrayList = this.f1984a;
        arrayList.clear();
        int size = constraintWidgetContainer.u0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) constraintWidgetContainer.u0.get(i2);
            ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.U;
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = dimensionBehaviourArr[0];
            ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1966c;
            if (dimensionBehaviour == dimensionBehaviour2 || dimensionBehaviourArr[1] == dimensionBehaviour2) {
                arrayList.add(constraintWidget);
            }
        }
        constraintWidgetContainer.w0.f2000b = true;
    }
}
