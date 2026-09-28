package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] u0 = new ConstraintWidget[4];
    public int v0 = 0;

    public final void V(int i2, WidgetGroup widgetGroup, ArrayList arrayList) {
        for (int i3 = 0; i3 < this.v0; i3++) {
            ConstraintWidget constraintWidget = this.u0[i3];
            ArrayList arrayList2 = widgetGroup.f2038a;
            if (!arrayList2.contains(constraintWidget)) {
                arrayList2.add(constraintWidget);
            }
        }
        for (int i4 = 0; i4 < this.v0; i4++) {
            Grouping.a(this.u0[i4], i2, arrayList, widgetGroup);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public final void a(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i2 = this.v0 + 1;
        ConstraintWidget[] constraintWidgetArr = this.u0;
        if (i2 > constraintWidgetArr.length) {
            this.u0 = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.u0;
        int i3 = this.v0;
        constraintWidgetArr2[i3] = constraintWidget;
        this.v0 = i3 + 1;
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public final void b() {
        this.v0 = 0;
        Arrays.fill(this.u0, (Object) null);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void j(ConstraintWidget constraintWidget, HashMap map) {
        super.j(constraintWidget, map);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.v0 = 0;
        int i2 = helperWidget.v0;
        for (int i3 = 0; i3 < i2; i3++) {
            a((ConstraintWidget) map.get(helperWidget.u0[i3]));
        }
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void c() {
    }
}
