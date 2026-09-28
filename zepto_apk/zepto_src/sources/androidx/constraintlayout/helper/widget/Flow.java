package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

/* loaded from: classes3.dex */
public class Flow extends VirtualLayout {

    /* renamed from: l, reason: collision with root package name */
    public androidx.constraintlayout.core.widgets.Flow f2062l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.k(attributeSet);
        this.f2062l = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f2062l.Z0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    androidx.constraintlayout.core.widgets.Flow flow = this.f2062l;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    flow.w0 = dimensionPixelSize;
                    flow.x0 = dimensionPixelSize;
                    flow.y0 = dimensionPixelSize;
                    flow.z0 = dimensionPixelSize;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    androidx.constraintlayout.core.widgets.Flow flow2 = this.f2062l;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    flow2.y0 = dimensionPixelSize2;
                    flow2.A0 = dimensionPixelSize2;
                    flow2.B0 = dimensionPixelSize2;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f2062l.z0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f2062l.A0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f2062l.w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f2062l.B0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f2062l.x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f2062l.X0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f2062l.H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f2062l.I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f2062l.J0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f2062l.L0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f2062l.K0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f2062l.M0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f2062l.N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f2062l.P0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f2062l.R0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f2062l.Q0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f2062l.S0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f2062l.O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f2062l.V0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f2062l.W0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f2062l.T0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f2062l.U0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f2062l.Y0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f2391d = this.f2062l;
        q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void l(ConstraintSet.Constraint constraint, HelperWidget helperWidget, Constraints.LayoutParams layoutParams, SparseArray sparseArray) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.l(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i2 = layoutParams.V;
            if (i2 != -1) {
                flow.Z0 = i2;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void m(ConstraintWidget constraintWidget, boolean z) {
        androidx.constraintlayout.core.widgets.Flow flow = this.f2062l;
        int i2 = flow.y0;
        if (i2 > 0 || flow.z0 > 0) {
            if (z) {
                flow.A0 = flow.z0;
                flow.B0 = i2;
            } else {
                flow.A0 = i2;
                flow.B0 = flow.z0;
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onMeasure(int i2, int i3) {
        r(this.f2062l, i2, i3);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public final void r(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (virtualLayout == null) {
            setMeasuredDimension(0, 0);
        } else {
            virtualLayout.W(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.D0, virtualLayout.E0);
        }
    }

    public void setFirstHorizontalBias(float f2) {
        this.f2062l.P0 = f2;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i2) {
        this.f2062l.J0 = i2;
        requestLayout();
    }

    public void setFirstVerticalBias(float f2) {
        this.f2062l.Q0 = f2;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i2) {
        this.f2062l.K0 = i2;
        requestLayout();
    }

    public void setHorizontalAlign(int i2) {
        this.f2062l.V0 = i2;
        requestLayout();
    }

    public void setHorizontalBias(float f2) {
        this.f2062l.N0 = f2;
        requestLayout();
    }

    public void setHorizontalGap(int i2) {
        this.f2062l.T0 = i2;
        requestLayout();
    }

    public void setHorizontalStyle(int i2) {
        this.f2062l.H0 = i2;
        requestLayout();
    }

    public void setLastHorizontalBias(float f2) {
        this.f2062l.R0 = f2;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i2) {
        this.f2062l.L0 = i2;
        requestLayout();
    }

    public void setLastVerticalBias(float f2) {
        this.f2062l.S0 = f2;
        requestLayout();
    }

    public void setLastVerticalStyle(int i2) {
        this.f2062l.M0 = i2;
        requestLayout();
    }

    public void setMaxElementsWrap(int i2) {
        this.f2062l.Y0 = i2;
        requestLayout();
    }

    public void setOrientation(int i2) {
        this.f2062l.Z0 = i2;
        requestLayout();
    }

    public void setPadding(int i2) {
        androidx.constraintlayout.core.widgets.Flow flow = this.f2062l;
        flow.w0 = i2;
        flow.x0 = i2;
        flow.y0 = i2;
        flow.z0 = i2;
        requestLayout();
    }

    public void setPaddingBottom(int i2) {
        this.f2062l.x0 = i2;
        requestLayout();
    }

    public void setPaddingLeft(int i2) {
        this.f2062l.A0 = i2;
        requestLayout();
    }

    public void setPaddingRight(int i2) {
        this.f2062l.B0 = i2;
        requestLayout();
    }

    public void setPaddingTop(int i2) {
        this.f2062l.w0 = i2;
        requestLayout();
    }

    public void setVerticalAlign(int i2) {
        this.f2062l.W0 = i2;
        requestLayout();
    }

    public void setVerticalBias(float f2) {
        this.f2062l.O0 = f2;
        requestLayout();
    }

    public void setVerticalGap(int i2) {
        this.f2062l.U0 = i2;
        requestLayout();
    }

    public void setVerticalStyle(int i2) {
        this.f2062l.I0 = i2;
        requestLayout();
    }

    public void setWrapMode(int i2) {
        this.f2062l.X0 = i2;
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
