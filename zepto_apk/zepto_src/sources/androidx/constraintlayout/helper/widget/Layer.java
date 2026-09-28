package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

/* loaded from: classes3.dex */
public class Layer extends ConstraintHelper {
    public boolean A;

    /* renamed from: j, reason: collision with root package name */
    public float f2065j;

    /* renamed from: k, reason: collision with root package name */
    public float f2066k;

    /* renamed from: l, reason: collision with root package name */
    public float f2067l;

    /* renamed from: m, reason: collision with root package name */
    public ConstraintLayout f2068m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public final boolean v;
    public View[] w;
    public float x;
    public float y;
    public boolean z;

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2065j = Float.NaN;
        this.f2066k = Float.NaN;
        this.f2067l = Float.NaN;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = true;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(ConstraintLayout constraintLayout) {
        f(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.k(attributeSet);
        this.f2392e = false;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_android_visibility) {
                    this.z = true;
                } else if (index == R.styleable.ConstraintLayout_Layout_android_elevation) {
                    this.A = true;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void n() {
        s();
        this.p = Float.NaN;
        this.q = Float.NaN;
        ConstraintWidget constraintWidget = ((ConstraintLayout.LayoutParams) getLayoutParams()).q0;
        constraintWidget.S(0);
        constraintWidget.P(0);
        r();
        layout(((int) this.t) - getPaddingLeft(), ((int) this.u) - getPaddingTop(), getPaddingRight() + ((int) this.r), getPaddingBottom() + ((int) this.s));
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void o(ConstraintLayout constraintLayout) {
        this.f2068m = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f2067l = rotation;
        } else {
            if (Float.isNaN(this.f2067l)) {
                return;
            }
            this.f2067l = rotation;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        this.f2068m = (ConstraintLayout) getParent();
        if (this.z || this.A) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i2 = 0; i2 < this.f2389b; i2++) {
                View viewC = this.f2068m.c(this.f2388a[i2]);
                if (viewC != null) {
                    if (this.z) {
                        viewC.setVisibility(visibility);
                    }
                    if (this.A && elevation > 0.0f) {
                        viewC.setTranslationZ(viewC.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void r() {
        if (this.f2068m == null) {
            return;
        }
        if (this.v || Float.isNaN(this.p) || Float.isNaN(this.q)) {
            if (!Float.isNaN(this.f2065j) && !Float.isNaN(this.f2066k)) {
                this.q = this.f2066k;
                this.p = this.f2065j;
                return;
            }
            View[] viewArrJ = j(this.f2068m);
            int left = viewArrJ[0].getLeft();
            int top = viewArrJ[0].getTop();
            int right = viewArrJ[0].getRight();
            int bottom = viewArrJ[0].getBottom();
            for (int i2 = 0; i2 < this.f2389b; i2++) {
                View view = viewArrJ[i2];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.r = right;
            this.s = bottom;
            this.t = left;
            this.u = top;
            if (Float.isNaN(this.f2065j)) {
                this.p = (left + right) / 2;
            } else {
                this.p = this.f2065j;
            }
            if (Float.isNaN(this.f2066k)) {
                this.q = (top + bottom) / 2;
            } else {
                this.q = this.f2066k;
            }
        }
    }

    public final void s() {
        int i2;
        if (this.f2068m == null || (i2 = this.f2389b) == 0) {
            return;
        }
        View[] viewArr = this.w;
        if (viewArr == null || viewArr.length != i2) {
            this.w = new View[i2];
        }
        for (int i3 = 0; i3 < this.f2389b; i3++) {
            this.w[i3] = this.f2068m.c(this.f2388a[i3]);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        e();
    }

    @Override // android.view.View
    public void setPivotX(float f2) {
        this.f2065j = f2;
        t();
    }

    @Override // android.view.View
    public void setPivotY(float f2) {
        this.f2066k = f2;
        t();
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.f2067l = f2;
        t();
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        this.n = f2;
        t();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        this.o = f2;
        t();
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        this.x = f2;
        t();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        this.y = f2;
        t();
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        e();
    }

    public final void t() {
        if (this.f2068m == null) {
            return;
        }
        if (this.w == null) {
            s();
        }
        r();
        double radians = Float.isNaN(this.f2067l) ? 0.0d : Math.toRadians(this.f2067l);
        float fSin = (float) Math.sin(radians);
        float fCos = (float) Math.cos(radians);
        float f2 = this.n;
        float f3 = f2 * fCos;
        float f4 = this.o;
        float f5 = (-f4) * fSin;
        float f6 = f2 * fSin;
        float f7 = f4 * fCos;
        for (int i2 = 0; i2 < this.f2389b; i2++) {
            View view = this.w[i2];
            int right = (view.getRight() + view.getLeft()) / 2;
            int bottom = (view.getBottom() + view.getTop()) / 2;
            float f8 = right - this.p;
            float f9 = bottom - this.q;
            float f10 = (((f5 * f9) + (f3 * f8)) - f8) + this.x;
            float f11 = (((f7 * f9) + (f8 * f6)) - f9) + this.y;
            view.setTranslationX(f10);
            view.setTranslationY(f11);
            view.setScaleY(this.o);
            view.setScaleX(this.n);
            if (!Float.isNaN(this.f2067l)) {
                view.setRotation(this.f2067l);
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2065j = Float.NaN;
        this.f2066k = Float.NaN;
        this.f2067l = Float.NaN;
        this.n = 1.0f;
        this.o = 1.0f;
        this.p = Float.NaN;
        this.q = Float.NaN;
        this.r = Float.NaN;
        this.s = Float.NaN;
        this.t = Float.NaN;
        this.u = Float.NaN;
        this.v = true;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
    }
}
