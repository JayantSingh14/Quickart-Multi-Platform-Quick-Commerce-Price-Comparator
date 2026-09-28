package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes3.dex */
public class Grid extends VirtualLayout {
    public final HashSet A;
    public int[] B;

    /* renamed from: l, reason: collision with root package name */
    public View[] f2063l;

    /* renamed from: m, reason: collision with root package name */
    public ConstraintLayout f2064m;
    public int n;
    public int o;
    public int p;
    public int q;
    public String r;
    public String s;
    public String t;
    public String u;
    public float v;
    public float w;
    public int x;
    public int y;
    public boolean[][] z;

    public Grid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 0;
        this.A = new HashSet();
    }

    public static int[][] B(String str) {
        String[] strArrSplit = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArrSplit.length, 3);
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String[] strArrSplit2 = strArrSplit[i2].trim().split(":");
            String[] strArrSplit3 = strArrSplit2[1].split("x");
            iArr[i2][0] = Integer.parseInt(strArrSplit2[0]);
            iArr[i2][1] = Integer.parseInt(strArrSplit3[0]);
            iArr[i2][2] = Integer.parseInt(strArrSplit3[1]);
        }
        return iArr;
    }

    public static float[] C(int i2, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] strArrSplit = str.split(",");
        if (strArrSplit.length != i2) {
            return null;
        }
        float[] fArr = new float[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            fArr[i3] = Float.parseFloat(strArrSplit[i3].trim());
        }
        return fArr;
    }

    private int getNextPosition() {
        boolean z = false;
        int i2 = 0;
        while (!z) {
            i2 = this.y;
            if (i2 >= this.n * this.p) {
                return -1;
            }
            int iX = x(i2);
            int iW = w(this.y);
            boolean[] zArr = this.z[iX];
            if (zArr[iW]) {
                zArr[iW] = false;
                z = true;
            }
            this.y++;
        }
        return i2;
    }

    public static void s(View view) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.H = -1.0f;
        layoutParams.f2416f = -1;
        layoutParams.f2415e = -1;
        layoutParams.f2417g = -1;
        layoutParams.f2418h = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
        view.setLayoutParams(layoutParams);
    }

    public static void t(View view) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        layoutParams.I = -1.0f;
        layoutParams.f2420j = -1;
        layoutParams.f2419i = -1;
        layoutParams.f2421k = -1;
        layoutParams.f2422l = -1;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = -1;
        view.setLayoutParams(layoutParams);
    }

    public final View A() {
        View view = new View(getContext());
        view.setId(View.generateViewId());
        view.setVisibility(4);
        this.f2064m.addView(view, new ConstraintLayout.LayoutParams(0, 0));
        return view;
    }

    public final void D() {
        int i2;
        int i3 = this.o;
        if (i3 != 0 && (i2 = this.q) != 0) {
            this.n = i3;
            this.p = i2;
            return;
        }
        int i4 = this.q;
        if (i4 > 0) {
            this.p = i4;
            this.n = ((this.f2389b + i4) - 1) / i4;
        } else if (i3 > 0) {
            this.n = i3;
            this.p = ((this.f2389b + i3) - 1) / i3;
        } else {
            int iSqrt = (int) (Math.sqrt(this.f2389b) + 1.5d);
            this.n = iSqrt;
            this.p = ((this.f2389b + iSqrt) - 1) / iSqrt;
        }
    }

    public String getColumnWeights() {
        return this.u;
    }

    public int getColumns() {
        return this.q;
    }

    public float getHorizontalGaps() {
        return this.v;
    }

    public int getOrientation() {
        return this.x;
    }

    public String getRowWeights() {
        return this.t;
    }

    public int getRows() {
        return this.o;
    }

    public String getSkips() {
        return this.s;
    }

    public String getSpans() {
        return this.r;
    }

    public float getVerticalGaps() {
        return this.w;
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.k(attributeSet);
        this.f2392e = true;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Grid);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.Grid_grid_rows) {
                    this.o = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_columns) {
                    this.q = typedArrayObtainStyledAttributes.getInteger(index, 0);
                } else if (index == R.styleable.Grid_grid_spans) {
                    this.r = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_skips) {
                    this.s = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_rowWeights) {
                    this.t = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_columnWeights) {
                    this.u = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.Grid_grid_orientation) {
                    this.x = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == R.styleable.Grid_grid_horizontalGaps) {
                    this.v = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_verticalGaps) {
                    this.w = typedArrayObtainStyledAttributes.getDimension(index, 0.0f);
                } else if (index == R.styleable.Grid_grid_validateInputs) {
                    typedArrayObtainStyledAttributes.getBoolean(index, false);
                } else if (index == R.styleable.Grid_grid_useRtl) {
                    typedArrayObtainStyledAttributes.getBoolean(index, false);
                }
            }
            D();
            y();
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        this.f2064m = (ConstraintLayout) getParent();
        v(false);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            Paint paint = new Paint();
            paint.setColor(-65536);
            paint.setStyle(Paint.Style.STROKE);
            int top = getTop();
            int left = getLeft();
            int bottom = getBottom();
            int right = getRight();
            for (View view : this.f2063l) {
                int left2 = view.getLeft() - left;
                int top2 = view.getTop() - top;
                int right2 = view.getRight() - left;
                int bottom2 = view.getBottom() - top;
                canvas.drawRect(left2, 0.0f, right2, bottom - top, paint);
                canvas.drawRect(0.0f, top2, right - left, bottom2, paint);
            }
        }
    }

    public void setColumnWeights(String str) {
        String str2 = this.u;
        if (str2 == null || !str2.equals(str)) {
            this.u = str;
            v(true);
            invalidate();
        }
    }

    public void setColumns(int i2) {
        if (i2 <= 50 && this.q != i2) {
            this.q = i2;
            D();
            y();
            v(false);
            invalidate();
        }
    }

    public void setHorizontalGaps(float f2) {
        if (f2 >= 0.0f && this.v != f2) {
            this.v = f2;
            v(true);
            invalidate();
        }
    }

    public void setOrientation(int i2) {
        if ((i2 == 0 || i2 == 1) && this.x != i2) {
            this.x = i2;
            v(true);
            invalidate();
        }
    }

    public void setRowWeights(String str) {
        String str2 = this.t;
        if (str2 == null || !str2.equals(str)) {
            this.t = str;
            v(true);
            invalidate();
        }
    }

    public void setRows(int i2) {
        if (i2 <= 50 && this.o != i2) {
            this.o = i2;
            D();
            y();
            v(false);
            invalidate();
        }
    }

    public void setSkips(String str) {
        String str2 = this.s;
        if (str2 == null || !str2.equals(str)) {
            this.s = str;
            v(true);
            invalidate();
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.r;
        if (str == null || !str.contentEquals(charSequence)) {
            this.r = charSequence.toString();
            v(true);
            invalidate();
        }
    }

    public void setVerticalGaps(float f2) {
        if (f2 >= 0.0f && this.w != f2) {
            this.w = f2;
            v(true);
            invalidate();
        }
    }

    public final void u(View view, int i2, int i3, int i4, int i5) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) view.getLayoutParams();
        int[] iArr = this.B;
        layoutParams.f2415e = iArr[i3];
        layoutParams.f2419i = iArr[i2];
        layoutParams.f2418h = iArr[(i3 + i5) - 1];
        layoutParams.f2422l = iArr[(i2 + i4) - 1];
        view.setLayoutParams(layoutParams);
    }

    public final void v(boolean z) {
        int i2;
        int i3;
        int[][] iArrB;
        int[][] iArrB2;
        if (this.f2064m == null || this.n < 1 || this.p < 1) {
            return;
        }
        HashSet hashSet = this.A;
        if (z) {
            for (int i4 = 0; i4 < this.z.length; i4++) {
                int i5 = 0;
                while (true) {
                    boolean[][] zArr = this.z;
                    if (i5 < zArr[0].length) {
                        zArr[i4][i5] = true;
                        i5++;
                    }
                }
            }
            hashSet.clear();
        }
        this.y = 0;
        int iMax = Math.max(this.n, this.p);
        View[] viewArr = this.f2063l;
        if (viewArr == null) {
            this.f2063l = new View[iMax];
            int i6 = 0;
            while (true) {
                View[] viewArr2 = this.f2063l;
                if (i6 >= viewArr2.length) {
                    break;
                }
                viewArr2[i6] = A();
                i6++;
            }
        } else if (iMax != viewArr.length) {
            View[] viewArr3 = new View[iMax];
            for (int i7 = 0; i7 < iMax; i7++) {
                View[] viewArr4 = this.f2063l;
                if (i7 < viewArr4.length) {
                    viewArr3[i7] = viewArr4[i7];
                } else {
                    viewArr3[i7] = A();
                }
            }
            int i8 = iMax;
            while (true) {
                View[] viewArr5 = this.f2063l;
                if (i8 >= viewArr5.length) {
                    break;
                }
                this.f2064m.removeView(viewArr5[i8]);
                i8++;
            }
            this.f2063l = viewArr3;
        }
        this.B = new int[iMax];
        int i9 = 0;
        while (true) {
            View[] viewArr6 = this.f2063l;
            if (i9 >= viewArr6.length) {
                break;
            }
            this.B[i9] = viewArr6[i9].getId();
            i9++;
        }
        int id = getId();
        int iMax2 = Math.max(this.n, this.p);
        float[] fArrC = C(this.n, this.t);
        if (this.n == 1) {
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) this.f2063l[0].getLayoutParams();
            t(this.f2063l[0]);
            layoutParams.f2419i = id;
            layoutParams.f2422l = id;
            this.f2063l[0].setLayoutParams(layoutParams);
        } else {
            int i10 = 0;
            while (true) {
                i2 = this.n;
                if (i10 >= i2) {
                    break;
                }
                ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f2063l[i10].getLayoutParams();
                t(this.f2063l[i10]);
                if (fArrC != null) {
                    layoutParams2.I = fArrC[i10];
                }
                if (i10 > 0) {
                    layoutParams2.f2420j = this.B[i10 - 1];
                } else {
                    layoutParams2.f2419i = id;
                }
                if (i10 < this.n - 1) {
                    layoutParams2.f2421k = this.B[i10 + 1];
                } else {
                    layoutParams2.f2422l = id;
                }
                if (i10 > 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = (int) this.v;
                }
                this.f2063l[i10].setLayoutParams(layoutParams2);
                i10++;
            }
            while (i2 < iMax2) {
                ConstraintLayout.LayoutParams layoutParams3 = (ConstraintLayout.LayoutParams) this.f2063l[i2].getLayoutParams();
                t(this.f2063l[i2]);
                layoutParams3.f2419i = id;
                layoutParams3.f2422l = id;
                this.f2063l[i2].setLayoutParams(layoutParams3);
                i2++;
            }
        }
        int id2 = getId();
        int iMax3 = Math.max(this.n, this.p);
        float[] fArrC2 = C(this.p, this.u);
        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) this.f2063l[0].getLayoutParams();
        if (this.p == 1) {
            s(this.f2063l[0]);
            layoutParams4.f2415e = id2;
            layoutParams4.f2418h = id2;
            this.f2063l[0].setLayoutParams(layoutParams4);
        } else {
            int i11 = 0;
            while (true) {
                i3 = this.p;
                if (i11 >= i3) {
                    break;
                }
                ConstraintLayout.LayoutParams layoutParams5 = (ConstraintLayout.LayoutParams) this.f2063l[i11].getLayoutParams();
                s(this.f2063l[i11]);
                if (fArrC2 != null) {
                    layoutParams5.H = fArrC2[i11];
                }
                if (i11 > 0) {
                    layoutParams5.f2416f = this.B[i11 - 1];
                } else {
                    layoutParams5.f2415e = id2;
                }
                if (i11 < this.p - 1) {
                    layoutParams5.f2417g = this.B[i11 + 1];
                } else {
                    layoutParams5.f2418h = id2;
                }
                if (i11 > 0) {
                    ((ViewGroup.MarginLayoutParams) layoutParams5).leftMargin = (int) this.v;
                }
                this.f2063l[i11].setLayoutParams(layoutParams5);
                i11++;
            }
            while (i3 < iMax3) {
                ConstraintLayout.LayoutParams layoutParams6 = (ConstraintLayout.LayoutParams) this.f2063l[i3].getLayoutParams();
                s(this.f2063l[i3]);
                layoutParams6.f2415e = id2;
                layoutParams6.f2418h = id2;
                this.f2063l[i3].setLayoutParams(layoutParams6);
                i3++;
            }
        }
        String str = this.s;
        if (str != null && !str.trim().isEmpty() && (iArrB2 = B(this.s)) != null) {
            for (int i12 = 0; i12 < iArrB2.length; i12++) {
                int iX = x(iArrB2[i12][0]);
                int iW = w(iArrB2[i12][0]);
                int[] iArr = iArrB2[i12];
                if (!z(iX, iW, iArr[1], iArr[2])) {
                    break;
                }
            }
        }
        String str2 = this.r;
        if (str2 != null && !str2.trim().isEmpty() && (iArrB = B(this.r)) != null) {
            int[] iArr2 = this.f2388a;
            View[] viewArrJ = j(this.f2064m);
            for (int i13 = 0; i13 < iArrB.length; i13++) {
                int iX2 = x(iArrB[i13][0]);
                int iW2 = w(iArrB[i13][0]);
                int[] iArr3 = iArrB[i13];
                if (!z(iX2, iW2, iArr3[1], iArr3[2])) {
                    break;
                }
                View view = viewArrJ[i13];
                int[] iArr4 = iArrB[i13];
                u(view, iX2, iW2, iArr4[1], iArr4[2]);
                hashSet.add(Integer.valueOf(iArr2[i13]));
            }
        }
        View[] viewArrJ2 = j(this.f2064m);
        for (int i14 = 0; i14 < this.f2389b; i14++) {
            if (!hashSet.contains(Integer.valueOf(this.f2388a[i14]))) {
                int nextPosition = getNextPosition();
                int iX3 = x(nextPosition);
                int iW3 = w(nextPosition);
                if (nextPosition == -1) {
                    return;
                } else {
                    u(viewArrJ2[i14], iX3, iW3, 1, 1);
                }
            }
        }
    }

    public final int w(int i2) {
        return this.x == 1 ? i2 / this.n : i2 % this.p;
    }

    public final int x(int i2) {
        return this.x == 1 ? i2 % this.n : i2 / this.p;
    }

    public final void y() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.n, this.p);
        this.z = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
    }

    public final boolean z(int i2, int i3, int i4, int i5) {
        for (int i6 = i2; i6 < i2 + i4; i6++) {
            for (int i7 = i3; i7 < i3 + i5; i7++) {
                boolean[][] zArr = this.z;
                if (i6 < zArr.length && i7 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i6];
                    if (zArr2[i7]) {
                        zArr2[i7] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    public Grid(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.y = 0;
        this.A = new HashSet();
    }
}
