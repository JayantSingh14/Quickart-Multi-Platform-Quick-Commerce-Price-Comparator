package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes3.dex */
public abstract class ConstraintHelper extends View {

    /* renamed from: a, reason: collision with root package name */
    public int[] f2388a;

    /* renamed from: b, reason: collision with root package name */
    public int f2389b;

    /* renamed from: c, reason: collision with root package name */
    public Context f2390c;

    /* renamed from: d, reason: collision with root package name */
    public HelperWidget f2391d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f2392e;

    /* renamed from: f, reason: collision with root package name */
    public String f2393f;

    /* renamed from: g, reason: collision with root package name */
    public String f2394g;

    /* renamed from: h, reason: collision with root package name */
    public View[] f2395h;

    /* renamed from: i, reason: collision with root package name */
    public HashMap f2396i;

    public ConstraintHelper(Context context, AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet);
        this.f2388a = new int[32];
        this.f2392e = false;
        this.f2395h = null;
        this.f2396i = new HashMap();
        this.f2390c = context;
        k(attributeSet);
    }

    public final void b(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (str == null || str.length() == 0 || this.f2390c == null) {
            return;
        }
        String strTrim = str.trim();
        int i2 = i(strTrim);
        if (i2 != 0) {
            this.f2396i.put(Integer.valueOf(i2), strTrim);
            c(i2);
        } else {
            Log.w("ConstraintHelper", "Could not find id of \"" + strTrim + "\"");
        }
    }

    public final void c(int i2) {
        if (i2 == getId()) {
            return;
        }
        int i3 = this.f2389b + 1;
        int[] iArr = this.f2388a;
        if (i3 > iArr.length) {
            this.f2388a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f2388a;
        int i4 = this.f2389b;
        iArr2[i4] = i2;
        this.f2389b = i4 + 1;
    }

    public final void d(String str) {
        if (str == null || str.length() == 0 || this.f2390c == null) {
            return;
        }
        String strTrim = str.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.LayoutParams) && strTrim.equals(((ConstraintLayout.LayoutParams) layoutParams).Y)) {
                if (childAt.getId() == -1) {
                    Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                } else {
                    c(childAt.getId());
                }
            }
        }
    }

    public final void e() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        f((ConstraintLayout) parent);
    }

    public final void f(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.f2389b; i2++) {
            View viewC = constraintLayout.c(this.f2388a[i2]);
            if (viewC != null) {
                viewC.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewC.setTranslationZ(viewC.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void g(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f2388a, this.f2389b);
    }

    public final int h(ConstraintLayout constraintLayout, String str) throws Resources.NotFoundException {
        Resources resources;
        String resourceEntryName;
        if (str != null && (resources = this.f2390c.getResources()) != null) {
            int childCount = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = constraintLayout.getChildAt(i2);
                if (childAt.getId() != -1) {
                    try {
                        resourceEntryName = resources.getResourceEntryName(childAt.getId());
                    } catch (Resources.NotFoundException unused) {
                        resourceEntryName = null;
                    }
                    if (str.equals(resourceEntryName)) {
                        return childAt.getId();
                    }
                }
            }
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(java.lang.String r5) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.constraintlayout.widget.ConstraintLayout
            r1 = 0
            if (r0 == 0) goto L10
            android.view.ViewParent r0 = r4.getParent()
            androidx.constraintlayout.widget.ConstraintLayout r0 = (androidx.constraintlayout.widget.ConstraintLayout) r0
            goto L11
        L10:
            r0 = r1
        L11:
            boolean r2 = r4.isInEditMode()
            if (r2 == 0) goto L38
            if (r0 == 0) goto L38
            if (r5 == 0) goto L2c
            java.util.HashMap r2 = r0.f2409m
            if (r2 == 0) goto L2c
            boolean r2 = r2.containsKey(r5)
            if (r2 == 0) goto L2c
            java.util.HashMap r2 = r0.f2409m
            java.lang.Object r2 = r2.get(r5)
            goto L2d
        L2c:
            r2 = r1
        L2d:
            boolean r3 = r2 instanceof java.lang.Integer
            if (r3 == 0) goto L38
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            goto L39
        L38:
            r2 = 0
        L39:
            if (r2 != 0) goto L41
            if (r0 == 0) goto L41
            int r2 = r4.h(r0, r5)
        L41:
            if (r2 != 0) goto L4d
            java.lang.Class<androidx.constraintlayout.widget.R$id> r0 = androidx.constraintlayout.widget.R.id.class
            java.lang.reflect.Field r0 = r0.getField(r5)     // Catch: java.lang.Exception -> L4d
            int r2 = r0.getInt(r1)     // Catch: java.lang.Exception -> L4d
        L4d:
            if (r2 != 0) goto L5f
            android.content.Context r0 = r4.f2390c
            android.content.res.Resources r1 = r0.getResources()
            java.lang.String r2 = "id"
            java.lang.String r0 = r0.getPackageName()
            int r2 = r1.getIdentifier(r5, r2, r0)
        L5f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.i(java.lang.String):int");
    }

    public final View[] j(ConstraintLayout constraintLayout) {
        View[] viewArr = this.f2395h;
        if (viewArr == null || viewArr.length != this.f2389b) {
            this.f2395h = new View[this.f2389b];
        }
        for (int i2 = 0; i2 < this.f2389b; i2++) {
            this.f2395h[i2] = constraintLayout.c(this.f2388a[i2]);
        }
        return this.f2395h;
    }

    public void k(AttributeSet attributeSet) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = typedArrayObtainStyledAttributes.getString(index);
                    this.f2393f = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = typedArrayObtainStyledAttributes.getString(index);
                    this.f2394g = string2;
                    setReferenceTags(string2);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void l(ConstraintSet.Constraint constraint, HelperWidget helperWidget, Constraints.LayoutParams layoutParams, SparseArray sparseArray) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        ConstraintSet.Layout layout = constraint.f2463e;
        int[] iArr = layout.j0;
        int i2 = 0;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.k0;
            if (str != null) {
                if (str.length() > 0) {
                    String[] strArrSplit = layout.k0.split(",");
                    int[] iArrCopyOf = new int[strArrSplit.length];
                    int i3 = 0;
                    for (String str2 : strArrSplit) {
                        int i4 = i(str2.trim());
                        if (i4 != 0) {
                            iArrCopyOf[i3] = i4;
                            i3++;
                        }
                    }
                    if (i3 != strArrSplit.length) {
                        iArrCopyOf = Arrays.copyOf(iArrCopyOf, i3);
                    }
                    layout.j0 = iArrCopyOf;
                } else {
                    layout.j0 = null;
                }
            }
        }
        helperWidget.b();
        if (layout.j0 == null) {
            return;
        }
        while (true) {
            int[] iArr2 = layout.j0;
            if (i2 >= iArr2.length) {
                return;
            }
            ConstraintWidget constraintWidget = (ConstraintWidget) sparseArray.get(iArr2[i2]);
            if (constraintWidget != null) {
                helperWidget.a(constraintWidget);
            }
            i2++;
        }
    }

    public void m(ConstraintWidget constraintWidget, boolean z) {
    }

    public void o(ConstraintLayout constraintLayout) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super.onAttachedToWindow();
        String str = this.f2393f;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f2394g;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.f2392e) {
            super.onMeasure(i2, i3);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void p(Helper helper, SparseArray sparseArray) {
        helper.b();
        for (int i2 = 0; i2 < this.f2389b; i2++) {
            helper.a((ConstraintWidget) sparseArray.get(this.f2388a[i2]));
        }
    }

    public final void q() {
        if (this.f2391d == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).q0 = this.f2391d;
        }
    }

    public void setIds(String str) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        this.f2393f = str;
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.f2389b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                b(str.substring(i2));
                return;
            } else {
                b(str.substring(i2, iIndexOf));
                i2 = iIndexOf + 1;
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f2394g = str;
        if (str == null) {
            return;
        }
        int i2 = 0;
        this.f2389b = 0;
        while (true) {
            int iIndexOf = str.indexOf(44, i2);
            if (iIndexOf == -1) {
                d(str.substring(i2));
                return;
            } else {
                d(str.substring(i2, iIndexOf));
                i2 = iIndexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f2393f = null;
        this.f2389b = 0;
        for (int i2 : iArr) {
            c(i2);
        }
    }

    @Override // android.view.View
    public final void setTag(int i2, Object obj) {
        super.setTag(i2, obj);
        if (obj == null && this.f2393f == null) {
            c(i2);
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i2) throws IllegalAccessException, Resources.NotFoundException, IllegalArgumentException {
        super(context, attributeSet, i2);
        this.f2388a = new int[32];
        this.f2392e = false;
        this.f2395h = null;
        this.f2396i = new HashMap();
        this.f2390c = context;
        k(attributeSet);
    }

    public void n() {
    }
}
