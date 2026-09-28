package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class CircularFlow extends VirtualLayout {
    public static int v;
    public static float w;

    /* renamed from: l, reason: collision with root package name */
    public ConstraintLayout f2060l;

    /* renamed from: m, reason: collision with root package name */
    public int f2061m;
    public float[] n;
    public int[] o;
    public int p;
    public int q;
    public String r;
    public String s;
    public Float t;
    public Integer u;

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.q = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                s(str.substring(i2).trim());
                return;
            } else {
                s(str.substring(i2, iIndexOf).trim());
                i2 = iIndexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.p = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                t(str.substring(i2).trim());
                return;
            } else {
                t(str.substring(i2, iIndexOf).trim());
                i2 = iIndexOf + 1;
            }
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.n, this.q);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.o, this.p);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f2061m = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.r = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.s = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float fValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, w));
                    this.t = fValueOf;
                    setDefaultAngle(fValueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer numValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getDimensionPixelSize(index, v));
                    this.u = numValueOf;
                    setDefaultRadius(numValueOf.intValue());
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.r;
        if (str != null) {
            this.n = new float[1];
            setAngles(str);
        }
        String str2 = this.s;
        if (str2 != null) {
            this.o = new int[1];
            setRadius(str2);
        }
        Float f2 = this.t;
        if (f2 != null) {
            setDefaultAngle(f2.floatValue());
        }
        Integer num = this.u;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        this.f2060l = (ConstraintLayout) getParent();
        for (int i2 = 0; i2 < this.f2389b; i2++) {
            View viewC = this.f2060l.c(this.f2388a[i2]);
            if (viewC != null) {
                int i3 = v;
                float f3 = w;
                int[] iArr = this.o;
                HashMap map = this.f2396i;
                if (iArr == null || i2 >= iArr.length) {
                    Integer num2 = this.u;
                    if (num2 == null || num2.intValue() == -1) {
                        Log.e("CircularFlow", "Added radius to view with id: " + ((String) map.get(Integer.valueOf(viewC.getId()))));
                    } else {
                        this.p++;
                        if (this.o == null) {
                            this.o = new int[1];
                        }
                        int[] radius = getRadius();
                        this.o = radius;
                        radius[this.p - 1] = i3;
                    }
                } else {
                    i3 = iArr[i2];
                }
                float[] fArr = this.n;
                if (fArr == null || i2 >= fArr.length) {
                    Float f4 = this.t;
                    if (f4 == null || f4.floatValue() == -1.0f) {
                        Log.e("CircularFlow", "Added angle to view with id: " + ((String) map.get(Integer.valueOf(viewC.getId()))));
                    } else {
                        this.q++;
                        if (this.n == null) {
                            this.n = new float[1];
                        }
                        float[] angles = getAngles();
                        this.n = angles;
                        angles[this.q - 1] = f3;
                    }
                } else {
                    f3 = fArr[i2];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewC.getLayoutParams();
                layoutParams.r = f3;
                layoutParams.p = this.f2061m;
                layoutParams.q = i3;
                viewC.setLayoutParams(layoutParams);
            }
        }
        e();
    }

    public final void s(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f2390c == null || (fArr = this.n) == null) {
            return;
        }
        if (this.q + 1 > fArr.length) {
            this.n = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.n[this.q] = Integer.parseInt(str);
        this.q++;
    }

    public void setDefaultAngle(float f2) {
        w = f2;
    }

    public void setDefaultRadius(int i2) {
        v = i2;
    }

    public final void t(String str) {
        Context context;
        int[] iArr;
        if (str == null || str.length() == 0 || (context = this.f2390c) == null || (iArr = this.o) == null) {
            return;
        }
        if (this.p + 1 > iArr.length) {
            this.o = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.o[this.p] = (int) (Integer.parseInt(str) * context.getResources().getDisplayMetrics().density);
        this.p++;
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }
}
