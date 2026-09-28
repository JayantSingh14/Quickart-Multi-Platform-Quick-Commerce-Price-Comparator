package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.Cache;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class WidgetContainer extends ConstraintWidget {
    public ArrayList u0 = new ArrayList();

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void G() {
        this.u0.clear();
        super.G();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public final void J(Cache cache) {
        super.J(cache);
        int size = this.u0.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ConstraintWidget) this.u0.get(i2)).J(cache);
        }
    }

    public void V() {
        ArrayList arrayList = this.u0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) this.u0.get(i2);
            if (constraintWidget instanceof WidgetContainer) {
                ((WidgetContainer) constraintWidget).V();
            }
        }
    }

    public final void a(ConstraintWidget constraintWidget) {
        this.u0.add(constraintWidget);
        ConstraintWidget constraintWidget2 = constraintWidget.V;
        if (constraintWidget2 != null) {
            ((WidgetContainer) constraintWidget2).u0.remove(constraintWidget);
            constraintWidget.G();
        }
        constraintWidget.V = this;
    }
}
