package androidx.constraintlayout.core.widgets.analyzer;

import android.support.v4.media.b;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes3.dex */
public class WidgetGroup {

    /* renamed from: f, reason: collision with root package name */
    public static int f2037f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f2038a;

    /* renamed from: b, reason: collision with root package name */
    public int f2039b;

    /* renamed from: c, reason: collision with root package name */
    public int f2040c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2041d;

    /* renamed from: e, reason: collision with root package name */
    public int f2042e;

    public static class MeasureResult {
    }

    public final void a(ArrayList arrayList) {
        int size = this.f2038a.size();
        if (this.f2042e != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                WidgetGroup widgetGroup = (WidgetGroup) arrayList.get(i2);
                if (this.f2042e == widgetGroup.f2039b) {
                    c(this.f2040c, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(LinearSystem linearSystem, int i2) {
        int iN;
        int iN2;
        ArrayList arrayList = this.f2038a;
        if (arrayList.size() == 0) {
            return 0;
        }
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) ((ConstraintWidget) arrayList.get(0)).V;
        linearSystem.t();
        constraintWidgetContainer.e(linearSystem, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            ((ConstraintWidget) arrayList.get(i3)).e(linearSystem, false);
        }
        if (i2 == 0 && constraintWidgetContainer.D0 > 0) {
            Chain.a(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i2 == 1 && constraintWidgetContainer.E0 > 0) {
            Chain.a(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.p();
        } catch (Exception e2) {
            System.err.println(e2.toString() + StringUtils.LF + Arrays.toString(e2.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.f2041d = new ArrayList();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            ConstraintWidget constraintWidget = (ConstraintWidget) arrayList.get(i4);
            MeasureResult measureResult = new MeasureResult();
            new WeakReference(constraintWidget);
            LinearSystem.n(constraintWidget.J);
            LinearSystem.n(constraintWidget.K);
            LinearSystem.n(constraintWidget.L);
            LinearSystem.n(constraintWidget.M);
            LinearSystem.n(constraintWidget.N);
            this.f2041d.add(measureResult);
        }
        if (i2 == 0) {
            iN = LinearSystem.n(constraintWidgetContainer.J);
            iN2 = LinearSystem.n(constraintWidgetContainer.L);
            linearSystem.t();
        } else {
            iN = LinearSystem.n(constraintWidgetContainer.K);
            iN2 = LinearSystem.n(constraintWidgetContainer.M);
            linearSystem.t();
        }
        return iN2 - iN;
    }

    public final void c(int i2, WidgetGroup widgetGroup) {
        Iterator it = this.f2038a.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            ArrayList arrayList = widgetGroup.f2038a;
            if (!arrayList.contains(constraintWidget)) {
                arrayList.add(constraintWidget);
            }
            int i3 = widgetGroup.f2039b;
            if (i2 == 0) {
                constraintWidget.s0 = i3;
            } else {
                constraintWidget.t0 = i3;
            }
        }
        this.f2042e = widgetGroup.f2039b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        int i2 = this.f2040c;
        sb.append(i2 == 0 ? "Horizontal" : i2 == 1 ? "Vertical" : i2 == 2 ? "Both" : "Unknown");
        sb.append(" [");
        String strO = b.o(sb, this.f2039b, "] <");
        Iterator it = this.f2038a.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            StringBuilder sbX = b.x(strO, StringUtils.SPACE);
            sbX.append(constraintWidget.k0);
            strO = sbX.toString();
        }
        return b.k(strO, " >");
    }
}
