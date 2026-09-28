package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Grouping {
    public static WidgetGroup a(ConstraintWidget constraintWidget, int i2, ArrayList arrayList, WidgetGroup widgetGroup) {
        int i3;
        int i4 = i2 == 0 ? constraintWidget.s0 : constraintWidget.t0;
        if (i4 != -1 && (widgetGroup == null || i4 != widgetGroup.f2039b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                WidgetGroup widgetGroup2 = (WidgetGroup) arrayList.get(i5);
                if (widgetGroup2.f2039b == i4) {
                    if (widgetGroup != null) {
                        widgetGroup.c(i2, widgetGroup2);
                        arrayList.remove(widgetGroup);
                    }
                    widgetGroup = widgetGroup2;
                } else {
                    i5++;
                }
            }
        } else if (i4 != -1) {
            return widgetGroup;
        }
        if (widgetGroup == null) {
            if (constraintWidget instanceof HelperWidget) {
                HelperWidget helperWidget = (HelperWidget) constraintWidget;
                int i6 = 0;
                while (true) {
                    if (i6 >= helperWidget.v0) {
                        i3 = -1;
                        break;
                    }
                    ConstraintWidget constraintWidget2 = helperWidget.u0[i6];
                    if ((i2 == 0 && (i3 = constraintWidget2.s0) != -1) || (i2 == 1 && (i3 = constraintWidget2.t0) != -1)) {
                        break;
                    }
                    i6++;
                }
                if (i3 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        WidgetGroup widgetGroup3 = (WidgetGroup) arrayList.get(i7);
                        if (widgetGroup3.f2039b == i3) {
                            widgetGroup = widgetGroup3;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (widgetGroup == null) {
                widgetGroup = new WidgetGroup();
                widgetGroup.f2038a = new ArrayList();
                widgetGroup.f2041d = null;
                widgetGroup.f2042e = -1;
                int i8 = WidgetGroup.f2037f;
                WidgetGroup.f2037f = i8 + 1;
                widgetGroup.f2039b = i8;
                widgetGroup.f2040c = i2;
            }
            arrayList.add(widgetGroup);
        }
        ArrayList arrayList2 = widgetGroup.f2038a;
        if (arrayList2.contains(constraintWidget)) {
            return widgetGroup;
        }
        arrayList2.add(constraintWidget);
        if (constraintWidget instanceof Guideline) {
            Guideline guideline = (Guideline) constraintWidget;
            guideline.x0.c(guideline.y0 == 0 ? 1 : 0, widgetGroup, arrayList);
        }
        int i9 = widgetGroup.f2039b;
        if (i2 == 0) {
            constraintWidget.s0 = i9;
            constraintWidget.J.c(i2, widgetGroup, arrayList);
            constraintWidget.L.c(i2, widgetGroup, arrayList);
        } else {
            constraintWidget.t0 = i9;
            constraintWidget.K.c(i2, widgetGroup, arrayList);
            constraintWidget.N.c(i2, widgetGroup, arrayList);
            constraintWidget.M.c(i2, widgetGroup, arrayList);
        }
        constraintWidget.Q.c(i2, widgetGroup, arrayList);
        return widgetGroup;
    }

    public static boolean b(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour5 = ConstraintWidget.DimensionBehaviour.f1964a;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour6 = ConstraintWidget.DimensionBehaviour.f1967d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour7 = ConstraintWidget.DimensionBehaviour.f1965b;
        return (dimensionBehaviour3 == dimensionBehaviour5 || dimensionBehaviour3 == dimensionBehaviour7 || (dimensionBehaviour3 == dimensionBehaviour6 && dimensionBehaviour != dimensionBehaviour7)) || (dimensionBehaviour4 == dimensionBehaviour5 || dimensionBehaviour4 == dimensionBehaviour7 || (dimensionBehaviour4 == dimensionBehaviour6 && dimensionBehaviour2 != dimensionBehaviour7));
    }
}
