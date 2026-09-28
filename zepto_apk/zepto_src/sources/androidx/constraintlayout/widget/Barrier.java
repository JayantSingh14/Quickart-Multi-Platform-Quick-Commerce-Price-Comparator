package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class Barrier extends ConstraintHelper {

    /* renamed from: j, reason: collision with root package name */
    public int f2368j;

    /* renamed from: k, reason: collision with root package name */
    public int f2369k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.Barrier f2370l;

    public Barrier(Context context) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context);
        this.f2388a = new int[32];
        this.f2392e = false;
        this.f2395h = null;
        this.f2396i = new HashMap();
        this.f2390c = context;
        k(null);
        super.setVisibility(8);
    }

    public boolean getAllowsGoneWidget() {
        return this.f2370l.x0;
    }

    public int getMargin() {
        return this.f2370l.y0;
    }

    public int getType() {
        return this.f2368j;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.k(attributeSet);
        this.f2370l = new androidx.constraintlayout.core.widgets.Barrier();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_barrierDirection) {
                    setType(typedArrayObtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.f2370l.x0 = typedArrayObtainStyledAttributes.getBoolean(index, true);
                } else if (index == R.styleable.ConstraintLayout_Layout_barrierMargin) {
                    this.f2370l.y0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2391d = this.f2370l;
        q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void l(ConstraintSet.Constraint constraint, HelperWidget helperWidget, Constraints.LayoutParams layoutParams, SparseArray sparseArray) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.l(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            androidx.constraintlayout.core.widgets.Barrier barrier = (androidx.constraintlayout.core.widgets.Barrier) helperWidget;
            boolean z = ((ConstraintWidgetContainer) helperWidget.V).z0;
            ConstraintSet.Layout layout = constraint.f2463e;
            r(barrier, layout.g0, z);
            barrier.x0 = layout.o0;
            barrier.y0 = layout.h0;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void m(ConstraintWidget constraintWidget, boolean z) {
        r(constraintWidget, this.f2368j, z);
    }

    public final void r(ConstraintWidget constraintWidget, int i2, boolean z) {
        this.f2369k = i2;
        if (z) {
            int i3 = this.f2368j;
            if (i3 == 5) {
                this.f2369k = 1;
            } else if (i3 == 6) {
                this.f2369k = 0;
            }
        } else {
            int i4 = this.f2368j;
            if (i4 == 5) {
                this.f2369k = 0;
            } else if (i4 == 6) {
                this.f2369k = 1;
            }
        }
        if (constraintWidget instanceof androidx.constraintlayout.core.widgets.Barrier) {
            ((androidx.constraintlayout.core.widgets.Barrier) constraintWidget).w0 = this.f2369k;
        }
    }

    public void setAllowsGoneWidget(boolean z) {
        this.f2370l.x0 = z;
    }

    public void setDpMargin(int i2) {
        this.f2370l.y0 = (int) ((i2 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i2) {
        this.f2370l.y0 = i2;
    }

    public void setType(int i2) {
        this.f2368j = i2;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }

    public Barrier(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        super.setVisibility(8);
    }
}
