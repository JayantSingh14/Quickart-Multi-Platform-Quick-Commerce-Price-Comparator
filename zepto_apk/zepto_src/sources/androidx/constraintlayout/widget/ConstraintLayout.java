package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xbill.DNS.Type;
import org.xbill.DNS.WKSRecord;

/* loaded from: classes3.dex */
public class ConstraintLayout extends ViewGroup {
    public static SharedValues p;

    /* renamed from: a, reason: collision with root package name */
    public final SparseArray f2397a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2398b;

    /* renamed from: c, reason: collision with root package name */
    public final ConstraintWidgetContainer f2399c;

    /* renamed from: d, reason: collision with root package name */
    public int f2400d;

    /* renamed from: e, reason: collision with root package name */
    public int f2401e;

    /* renamed from: f, reason: collision with root package name */
    public int f2402f;

    /* renamed from: g, reason: collision with root package name */
    public int f2403g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2404h;

    /* renamed from: i, reason: collision with root package name */
    public int f2405i;

    /* renamed from: j, reason: collision with root package name */
    public ConstraintSet f2406j;

    /* renamed from: k, reason: collision with root package name */
    public ConstraintLayoutStates f2407k;

    /* renamed from: l, reason: collision with root package name */
    public int f2408l;

    /* renamed from: m, reason: collision with root package name */
    public HashMap f2409m;
    public final SparseArray n;
    public final Measurer o;

    /* renamed from: androidx.constraintlayout.widget.ConstraintLayout$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2410a;

        static {
            int[] iArr = new int[ConstraintWidget.DimensionBehaviour.values().length];
            f2410a = iArr;
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2410a[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2410a[3] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2410a[2] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public class Measurer implements BasicMeasure.Measurer {

        /* renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f2425a;

        /* renamed from: b, reason: collision with root package name */
        public int f2426b;

        /* renamed from: c, reason: collision with root package name */
        public int f2427c;

        /* renamed from: d, reason: collision with root package name */
        public int f2428d;

        /* renamed from: e, reason: collision with root package name */
        public int f2429e;

        /* renamed from: f, reason: collision with root package name */
        public int f2430f;

        /* renamed from: g, reason: collision with root package name */
        public int f2431g;

        public Measurer(ConstraintLayout constraintLayout) {
            this.f2425a = constraintLayout;
        }

        public static boolean c(int i2, int i3, int i4) {
            if (i2 == i3) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i4 == size;
            }
            return false;
        }

        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        public final void a() {
            ConstraintLayout constraintLayout = this.f2425a;
            int childCount = constraintLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = constraintLayout.getChildAt(i2);
                if (childAt instanceof Placeholder) {
                    Placeholder placeholder = (Placeholder) childAt;
                    if (placeholder.f2526b != null) {
                        LayoutParams layoutParams = (LayoutParams) placeholder.getLayoutParams();
                        LayoutParams layoutParams2 = (LayoutParams) placeholder.f2526b.getLayoutParams();
                        ConstraintWidget constraintWidget = layoutParams2.q0;
                        constraintWidget.i0 = 0;
                        ConstraintWidget constraintWidget2 = layoutParams.q0;
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget2.U[0];
                        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.f1964a;
                        if (dimensionBehaviour != dimensionBehaviour2) {
                            constraintWidget2.S(constraintWidget.u());
                        }
                        ConstraintWidget constraintWidget3 = layoutParams.q0;
                        if (constraintWidget3.U[1] != dimensionBehaviour2) {
                            constraintWidget3.P(layoutParams2.q0.o());
                        }
                        layoutParams2.q0.i0 = 8;
                    }
                }
            }
            int size = constraintLayout.f2398b.size();
            if (size > 0) {
                for (int i3 = 0; i3 < size; i3++) {
                    ((ConstraintHelper) constraintLayout.f2398b.get(i3)).getClass();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:116:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x01a7  */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01aa  */
        /* JADX WARN: Removed duplicated region for block: B:120:0x01ac  */
        /* JADX WARN: Removed duplicated region for block: B:126:0x01b8  */
        /* JADX WARN: Removed duplicated region for block: B:131:0x01c0  */
        /* JADX WARN: Removed duplicated region for block: B:137:0x01cc  */
        /* JADX WARN: Removed duplicated region for block: B:142:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:144:0x01da A[ORIG_RETURN, RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:145:0x01db  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:91:0x012c  */
        @Override // androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measurer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void b(androidx.constraintlayout.core.widgets.ConstraintWidget r18, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure.Measure r19) {
            /*
                Method dump skipped, instructions count: 714
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.Measurer.b(androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.core.widgets.analyzer.BasicMeasure$Measure):void");
        }
    }

    public interface ValueModifier {
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2397a = new SparseArray();
        this.f2398b = new ArrayList(4);
        this.f2399c = new ConstraintWidgetContainer();
        this.f2400d = 0;
        this.f2401e = 0;
        this.f2402f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2403g = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2404h = true;
        this.f2405i = Type.CAA;
        this.f2406j = null;
        this.f2407k = null;
        this.f2408l = -1;
        this.f2409m = new HashMap();
        this.n = new SparseArray();
        this.o = new Measurer(this);
        e(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static SharedValues getSharedValues() {
        if (p == null) {
            p = new SharedValues();
        }
        return p;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01c5  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:164:0x02de -> B:165:0x02df). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(boolean r22, android.view.View r23, androidx.constraintlayout.core.widgets.ConstraintWidget r24, androidx.constraintlayout.widget.ConstraintLayout.LayoutParams r25, android.util.SparseArray r26) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 845
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a(boolean, android.view.View, androidx.constraintlayout.core.widgets.ConstraintWidget, androidx.constraintlayout.widget.ConstraintLayout$LayoutParams, android.util.SparseArray):void");
    }

    public final View c(int i2) {
        return (View) this.f2397a.get(i2);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public final ConstraintWidget d(View view) {
        if (view == this) {
            return this.f2399c;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).q0;
        }
        view.setLayoutParams(new LayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).q0;
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f2398b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i2 = 0; i2 < size; i2++) {
                ((ConstraintHelper) arrayList.get(i2)).o(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i4 = Integer.parseInt(strArrSplit[0]);
                        int i5 = Integer.parseInt(strArrSplit[1]);
                        int i6 = Integer.parseInt(strArrSplit[2]);
                        int i7 = (int) ((i4 / 1080.0f) * width);
                        int i8 = (int) ((i5 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f2 = i7;
                        float f3 = i8;
                        float f4 = i7 + ((int) ((i6 / 1080.0f) * width));
                        canvas.drawLine(f2, f3, f4, f3, paint);
                        float f5 = i8 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f4, f3, f4, f5, paint);
                        canvas.drawLine(f4, f5, f2, f5, paint);
                        canvas.drawLine(f2, f5, f2, f3, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f2, f3, f4, f5, paint);
                        canvas.drawLine(f2, f5, f4, f3, paint);
                    }
                }
            }
        }
    }

    public final void e(AttributeSet attributeSet, int i2) {
        ConstraintWidgetContainer constraintWidgetContainer = this.f2399c;
        constraintWidgetContainer.h0 = this;
        Measurer measurer = this.o;
        constraintWidgetContainer.y0 = measurer;
        constraintWidgetContainer.w0.f2004f = measurer;
        this.f2397a.put(getId(), this);
        this.f2406j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout, i2, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i3);
                if (index == R.styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.f2400d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2400d);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.f2401e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2401e);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.f2402f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2402f);
                } else if (index == R.styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.f2403g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2403g);
                } else if (index == R.styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.f2405i = typedArrayObtainStyledAttributes.getInt(index, this.f2405i);
                } else if (index == R.styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            g(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f2407k = null;
                        }
                    }
                } else if (index == R.styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f2406j = constraintSet;
                        constraintSet.k(resourceId2, getContext());
                    } catch (Resources.NotFoundException unused2) {
                        this.f2406j = null;
                    }
                    this.f2408l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        constraintWidgetContainer.H0 = this.f2405i;
        LinearSystem.q = constraintWidgetContainer.Z(512);
    }

    public final boolean f() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f2404h = true;
        super.forceLayout();
    }

    public void g(int i2) {
        this.f2407k = new ConstraintLayoutStates(getContext(), this, i2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f2403g;
    }

    public int getMaxWidth() {
        return this.f2402f;
    }

    public int getMinHeight() {
        return this.f2401e;
    }

    public int getMinWidth() {
        return this.f2400d;
    }

    public int getOptimizationLevel() {
        return this.f2399c.H0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        ConstraintWidgetContainer constraintWidgetContainer = this.f2399c;
        if (constraintWidgetContainer.f1959j == null) {
            int id2 = getId();
            if (id2 != -1) {
                constraintWidgetContainer.f1959j = getContext().getResources().getResourceEntryName(id2);
            } else {
                constraintWidgetContainer.f1959j = "parent";
            }
        }
        if (constraintWidgetContainer.k0 == null) {
            constraintWidgetContainer.k0 = constraintWidgetContainer.f1959j;
            Log.v("ConstraintLayout", " setDebugName " + constraintWidgetContainer.k0);
        }
        Iterator it = constraintWidgetContainer.u0.iterator();
        while (it.hasNext()) {
            ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
            View view = constraintWidget.h0;
            if (view != null) {
                if (constraintWidget.f1959j == null && (id = view.getId()) != -1) {
                    constraintWidget.f1959j = getContext().getResources().getResourceEntryName(id);
                }
                if (constraintWidget.k0 == null) {
                    constraintWidget.k0 = constraintWidget.f1959j;
                    Log.v("ConstraintLayout", " setDebugName " + constraintWidget.k0);
                }
            }
        }
        constraintWidgetContainer.r(sb);
        return sb.toString();
    }

    public final void h(int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Measurer measurer = this.o;
        int i6 = measurer.f2429e;
        int iResolveSizeAndState = View.resolveSizeAndState(i4 + measurer.f2428d, i2, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i5 + i6, i3, 0) & 16777215;
        int iMin = Math.min(this.f2402f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f2403g, iResolveSizeAndState2);
        if (z) {
            iMin |= 16777216;
        }
        if (z2) {
            iMin2 |= 16777216;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01ca A[PHI: r2
      0x01ca: PHI (r2v3 boolean) = (r2v2 boolean), (r2v50 boolean) binds: [B:62:0x0168, B:297:0x01ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d1 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r25, int r26, int r27, int r28) {
        /*
            Method dump skipped, instructions count: 1341
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.l(androidx.constraintlayout.core.widgets.ConstraintWidgetContainer, int, int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.q0;
            if ((childAt.getVisibility() != 8 || layoutParams.d0 || layoutParams.e0 || zIsInEditMode) && !layoutParams.f0) {
                int iV = constraintWidget.v();
                int iW = constraintWidget.w();
                int iU = constraintWidget.u() + iV;
                int iO = constraintWidget.o() + iW;
                childAt.layout(iV, iW, iU, iO);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iV, iW, iU, iO);
                }
            }
        }
        ArrayList arrayList = this.f2398b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i7 = 0; i7 < size; i7++) {
                ((ConstraintHelper) arrayList.get(i7)).n();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01bc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r17, int r18) throws java.lang.IllegalAccessException, android.content.res.Resources.NotFoundException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget constraintWidgetD = d(view);
        if ((view instanceof Guideline) && !(constraintWidgetD instanceof androidx.constraintlayout.core.widgets.Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            androidx.constraintlayout.core.widgets.Guideline guideline = new androidx.constraintlayout.core.widgets.Guideline();
            layoutParams.q0 = guideline;
            layoutParams.d0 = true;
            guideline.W(layoutParams.V);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.q();
            ((LayoutParams) view.getLayoutParams()).e0 = true;
            ArrayList arrayList = this.f2398b;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.f2397a.put(view.getId(), view);
        this.f2404h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f2397a.remove(view.getId());
        ConstraintWidget constraintWidgetD = d(view);
        this.f2399c.u0.remove(constraintWidgetD);
        constraintWidgetD.G();
        this.f2398b.remove(view);
        this.f2404h = true;
    }

    public final void p(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray sparseArray, int i2, ConstraintAnchor.Type type) {
        View view = (View) this.f2397a.get(i2);
        ConstraintWidget constraintWidget2 = (ConstraintWidget) sparseArray.get(i2);
        if (constraintWidget2 == null || view == null || !(view.getLayoutParams() instanceof LayoutParams)) {
            return;
        }
        layoutParams.c0 = true;
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.f1945e;
        if (type == type2) {
            LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
            layoutParams2.c0 = true;
            layoutParams2.q0.E = true;
        }
        constraintWidget.m(type2).b(constraintWidget2.m(type), layoutParams.D, layoutParams.C, true);
        constraintWidget.E = true;
        constraintWidget.m(ConstraintAnchor.Type.f1942b).j();
        constraintWidget.m(ConstraintAnchor.Type.f1944d).j();
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f2404h = true;
        super.requestLayout();
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.f2406j = constraintSet;
    }

    @Override // android.view.View
    public void setId(int i2) {
        int id = getId();
        SparseArray sparseArray = this.f2397a;
        sparseArray.remove(id);
        super.setId(i2);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i2) {
        if (i2 == this.f2403g) {
            return;
        }
        this.f2403g = i2;
        requestLayout();
    }

    public void setMaxWidth(int i2) {
        if (i2 == this.f2402f) {
            return;
        }
        this.f2402f = i2;
        requestLayout();
    }

    public void setMinHeight(int i2) {
        if (i2 == this.f2401e) {
            return;
        }
        this.f2401e = i2;
        requestLayout();
    }

    public void setMinWidth(int i2) {
        if (i2 == this.f2400d) {
            return;
        }
        this.f2400d = i2;
        requestLayout();
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
    }

    public void setOptimizationLevel(int i2) {
        this.f2405i = i2;
        ConstraintWidgetContainer constraintWidgetContainer = this.f2399c;
        constraintWidgetContainer.H0 = i2;
        LinearSystem.q = constraintWidgetContainer.Z(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2397a = new SparseArray();
        this.f2398b = new ArrayList(4);
        this.f2399c = new ConstraintWidgetContainer();
        this.f2400d = 0;
        this.f2401e = 0;
        this.f2402f = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2403g = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        this.f2404h = true;
        this.f2405i = Type.CAA;
        this.f2406j = null;
        this.f2407k = null;
        this.f2408l = -1;
        this.f2409m = new HashMap();
        this.n = new SparseArray();
        this.o = new Measurer(this);
        e(attributeSet, i2);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A;
        public int B;
        public final int C;
        public final int D;
        public float E;
        public float F;
        public String G;
        public float H;
        public float I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public float R;
        public float S;
        public int T;
        public int U;
        public int V;
        public boolean W;
        public boolean X;
        public String Y;
        public int Z;

        /* renamed from: a, reason: collision with root package name */
        public int f2411a;
        public boolean a0;

        /* renamed from: b, reason: collision with root package name */
        public int f2412b;
        public boolean b0;

        /* renamed from: c, reason: collision with root package name */
        public float f2413c;
        public boolean c0;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f2414d;
        public boolean d0;

        /* renamed from: e, reason: collision with root package name */
        public int f2415e;
        public boolean e0;

        /* renamed from: f, reason: collision with root package name */
        public int f2416f;
        public boolean f0;

        /* renamed from: g, reason: collision with root package name */
        public int f2417g;
        public int g0;

        /* renamed from: h, reason: collision with root package name */
        public int f2418h;
        public int h0;

        /* renamed from: i, reason: collision with root package name */
        public int f2419i;
        public int i0;

        /* renamed from: j, reason: collision with root package name */
        public int f2420j;
        public int j0;

        /* renamed from: k, reason: collision with root package name */
        public int f2421k;
        public int k0;

        /* renamed from: l, reason: collision with root package name */
        public int f2422l;
        public int l0;

        /* renamed from: m, reason: collision with root package name */
        public int f2423m;
        public float m0;
        public int n;
        public int n0;
        public int o;
        public int o0;
        public int p;
        public float p0;
        public int q;
        public ConstraintWidget q0;
        public float r;
        public int s;
        public int t;
        public int u;
        public int v;
        public final int w;
        public int x;
        public final int y;
        public int z;

        public static class Table {

            /* renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f2424a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f2424a = sparseIntArray;
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_guidelineUseRtl, 67);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R.styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2411a = -1;
            this.f2412b = -1;
            this.f2413c = -1.0f;
            this.f2414d = true;
            this.f2415e = -1;
            this.f2416f = -1;
            this.f2417g = -1;
            this.f2418h = -1;
            this.f2419i = -1;
            this.f2420j = -1;
            this.f2421k = -1;
            this.f2422l = -1;
            this.f2423m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.m0 = 0.5f;
            this.q0 = new ConstraintWidget();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
                ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
                ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
                ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
                setMarginStart(marginLayoutParams.getMarginStart());
                setMarginEnd(marginLayoutParams.getMarginEnd());
            }
            if (layoutParams instanceof LayoutParams) {
                LayoutParams layoutParams2 = (LayoutParams) layoutParams;
                this.f2411a = layoutParams2.f2411a;
                this.f2412b = layoutParams2.f2412b;
                this.f2413c = layoutParams2.f2413c;
                this.f2414d = layoutParams2.f2414d;
                this.f2415e = layoutParams2.f2415e;
                this.f2416f = layoutParams2.f2416f;
                this.f2417g = layoutParams2.f2417g;
                this.f2418h = layoutParams2.f2418h;
                this.f2419i = layoutParams2.f2419i;
                this.f2420j = layoutParams2.f2420j;
                this.f2421k = layoutParams2.f2421k;
                this.f2422l = layoutParams2.f2422l;
                this.f2423m = layoutParams2.f2423m;
                this.n = layoutParams2.n;
                this.o = layoutParams2.o;
                this.p = layoutParams2.p;
                this.q = layoutParams2.q;
                this.r = layoutParams2.r;
                this.s = layoutParams2.s;
                this.t = layoutParams2.t;
                this.u = layoutParams2.u;
                this.v = layoutParams2.v;
                this.w = layoutParams2.w;
                this.x = layoutParams2.x;
                this.y = layoutParams2.y;
                this.z = layoutParams2.z;
                this.A = layoutParams2.A;
                this.B = layoutParams2.B;
                this.C = layoutParams2.C;
                this.D = layoutParams2.D;
                this.E = layoutParams2.E;
                this.F = layoutParams2.F;
                this.G = layoutParams2.G;
                this.H = layoutParams2.H;
                this.I = layoutParams2.I;
                this.J = layoutParams2.J;
                this.K = layoutParams2.K;
                this.W = layoutParams2.W;
                this.X = layoutParams2.X;
                this.L = layoutParams2.L;
                this.M = layoutParams2.M;
                this.N = layoutParams2.N;
                this.P = layoutParams2.P;
                this.O = layoutParams2.O;
                this.Q = layoutParams2.Q;
                this.R = layoutParams2.R;
                this.S = layoutParams2.S;
                this.T = layoutParams2.T;
                this.U = layoutParams2.U;
                this.V = layoutParams2.V;
                this.a0 = layoutParams2.a0;
                this.b0 = layoutParams2.b0;
                this.c0 = layoutParams2.c0;
                this.d0 = layoutParams2.d0;
                this.g0 = layoutParams2.g0;
                this.h0 = layoutParams2.h0;
                this.i0 = layoutParams2.i0;
                this.j0 = layoutParams2.j0;
                this.k0 = layoutParams2.k0;
                this.l0 = layoutParams2.l0;
                this.m0 = layoutParams2.m0;
                this.Y = layoutParams2.Y;
                this.Z = layoutParams2.Z;
                this.q0 = layoutParams2.q0;
            }
        }

        public final void a() {
            this.d0 = false;
            this.a0 = true;
            this.b0 = true;
            int i2 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i2 == -2 && this.W) {
                this.a0 = false;
                if (this.L == 0) {
                    this.L = 1;
                }
            }
            int i3 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i3 == -2 && this.X) {
                this.b0 = false;
                if (this.M == 0) {
                    this.M = 1;
                }
            }
            if (i2 == 0 || i2 == -1) {
                this.a0 = false;
                if (i2 == 0 && this.L == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.W = true;
                }
            }
            if (i3 == 0 || i3 == -1) {
                this.b0 = false;
                if (i3 == 0 && this.M == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.X = true;
                }
            }
            if (this.f2413c == -1.0f && this.f2411a == -1 && this.f2412b == -1) {
                return;
            }
            this.d0 = true;
            this.a0 = true;
            this.b0 = true;
            if (!(this.q0 instanceof androidx.constraintlayout.core.widgets.Guideline)) {
                this.q0 = new androidx.constraintlayout.core.widgets.Guideline();
            }
            ((androidx.constraintlayout.core.widgets.Guideline) this.q0).W(this.V);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0051  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x005e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0082  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void resolveLayoutDirection(int r11) {
            /*
                Method dump skipped, instructions count: 259
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2411a = -1;
            this.f2412b = -1;
            this.f2413c = -1.0f;
            this.f2414d = true;
            this.f2415e = -1;
            this.f2416f = -1;
            this.f2417g = -1;
            this.f2418h = -1;
            this.f2419i = -1;
            this.f2420j = -1;
            this.f2421k = -1;
            this.f2422l = -1;
            this.f2423m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.m0 = 0.5f;
            this.q0 = new ConstraintWidget();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i2);
                int i3 = Table.f2424a.get(index);
                switch (i3) {
                    case 1:
                        this.V = typedArrayObtainStyledAttributes.getInt(index, this.V);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.p);
                        this.p = resourceId;
                        if (resourceId == -1) {
                            this.p = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 3:
                        this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.q);
                        break;
                    case 4:
                        float f2 = typedArrayObtainStyledAttributes.getFloat(index, this.r) % 360.0f;
                        this.r = f2;
                        if (f2 < 0.0f) {
                            this.r = (360.0f - f2) % 360.0f;
                            break;
                        } else {
                            break;
                        }
                    case 5:
                        this.f2411a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2411a);
                        break;
                    case 6:
                        this.f2412b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f2412b);
                        break;
                    case 7:
                        this.f2413c = typedArrayObtainStyledAttributes.getFloat(index, this.f2413c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2415e);
                        this.f2415e = resourceId2;
                        if (resourceId2 == -1) {
                            this.f2415e = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2416f);
                        this.f2416f = resourceId3;
                        if (resourceId3 == -1) {
                            this.f2416f = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2417g);
                        this.f2417g = resourceId4;
                        if (resourceId4 == -1) {
                            this.f2417g = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2418h);
                        this.f2418h = resourceId5;
                        if (resourceId5 == -1) {
                            this.f2418h = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2419i);
                        this.f2419i = resourceId6;
                        if (resourceId6 == -1) {
                            this.f2419i = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2420j);
                        this.f2420j = resourceId7;
                        if (resourceId7 == -1) {
                            this.f2420j = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2421k);
                        this.f2421k = resourceId8;
                        if (resourceId8 == -1) {
                            this.f2421k = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2422l);
                        this.f2422l = resourceId9;
                        if (resourceId9 == -1) {
                            this.f2422l = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f2423m);
                        this.f2423m = resourceId10;
                        if (resourceId10 == -1) {
                            this.f2423m = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.s);
                        this.s = resourceId11;
                        if (resourceId11 == -1) {
                            this.s = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.t);
                        this.t = resourceId12;
                        if (resourceId12 == -1) {
                            this.t = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.u);
                        this.u = resourceId13;
                        if (resourceId13 == -1) {
                            this.u = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.v);
                        this.v = resourceId14;
                        if (resourceId14 == -1) {
                            this.v = typedArrayObtainStyledAttributes.getInt(index, -1);
                            break;
                        } else {
                            break;
                        }
                    case 21:
                        this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.w);
                        break;
                    case 22:
                        this.x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.x);
                        break;
                    case 23:
                        this.y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.y);
                        break;
                    case 24:
                        this.z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.z);
                        break;
                    case 25:
                        this.A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 26:
                        this.B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.B);
                        break;
                    case 27:
                        this.W = typedArrayObtainStyledAttributes.getBoolean(index, this.W);
                        break;
                    case 28:
                        this.X = typedArrayObtainStyledAttributes.getBoolean(index, this.X);
                        break;
                    case 29:
                        this.E = typedArrayObtainStyledAttributes.getFloat(index, this.E);
                        break;
                    case 30:
                        this.F = typedArrayObtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 31:
                        int i4 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.L = i4;
                        if (i4 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 32:
                        int i5 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.M = i5;
                        if (i5 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        } else {
                            break;
                        }
                    case 33:
                        try {
                            this.N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            break;
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.N) == -2) {
                                this.N = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            break;
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.P) == -2) {
                                this.P = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 35:
                        this.R = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.R));
                        this.L = 2;
                        break;
                    case 36:
                        try {
                            this.O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            break;
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.O) == -2) {
                                this.O = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.Q) == -2) {
                                this.Q = -2;
                                break;
                            } else {
                                break;
                            }
                        }
                    case Type.A6 /* 38 */:
                        this.S = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.S));
                        this.M = 2;
                        break;
                    default:
                        switch (i3) {
                            case 44:
                                ConstraintSet.o(this, typedArrayObtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.H = typedArrayObtainStyledAttributes.getFloat(index, this.H);
                                break;
                            case 46:
                                this.I = typedArrayObtainStyledAttributes.getFloat(index, this.I);
                                break;
                            case 47:
                                this.J = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case Type.DNSKEY /* 48 */:
                                this.K = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.T);
                                break;
                            case 50:
                                this.U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.U);
                                break;
                            case 51:
                                this.Y = typedArrayObtainStyledAttributes.getString(index);
                                break;
                            case Type.TLSA /* 52 */:
                                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, this.n);
                                this.n = resourceId15;
                                if (resourceId15 == -1) {
                                    this.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 53:
                                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, this.o);
                                this.o = resourceId16;
                                if (resourceId16 == -1) {
                                    this.o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                    break;
                                } else {
                                    break;
                                }
                            case 54:
                                this.D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.D);
                                break;
                            case 55:
                                this.C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            default:
                                switch (i3) {
                                    case 64:
                                        ConstraintSet.n(this, typedArrayObtainStyledAttributes, index, 0);
                                        break;
                                    case 65:
                                        ConstraintSet.n(this, typedArrayObtainStyledAttributes, index, 1);
                                        break;
                                    case WKSRecord.Protocol.RVD /* 66 */:
                                        this.Z = typedArrayObtainStyledAttributes.getInt(index, this.Z);
                                        break;
                                    case 67:
                                        this.f2414d = typedArrayObtainStyledAttributes.getBoolean(index, this.f2414d);
                                        break;
                                }
                        }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2411a = -1;
            this.f2412b = -1;
            this.f2413c = -1.0f;
            this.f2414d = true;
            this.f2415e = -1;
            this.f2416f = -1;
            this.f2417g = -1;
            this.f2418h = -1;
            this.f2419i = -1;
            this.f2420j = -1;
            this.f2421k = -1;
            this.f2422l = -1;
            this.f2423m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = 0;
            this.r = 0.0f;
            this.s = -1;
            this.t = -1;
            this.u = -1;
            this.v = -1;
            this.w = Integer.MIN_VALUE;
            this.x = Integer.MIN_VALUE;
            this.y = Integer.MIN_VALUE;
            this.z = Integer.MIN_VALUE;
            this.A = Integer.MIN_VALUE;
            this.B = Integer.MIN_VALUE;
            this.C = Integer.MIN_VALUE;
            this.D = 0;
            this.E = 0.5f;
            this.F = 0.5f;
            this.G = null;
            this.H = -1.0f;
            this.I = -1.0f;
            this.J = 0;
            this.K = 0;
            this.L = 0;
            this.M = 0;
            this.N = 0;
            this.O = 0;
            this.P = 0;
            this.Q = 0;
            this.R = 1.0f;
            this.S = 1.0f;
            this.T = -1;
            this.U = -1;
            this.V = -1;
            this.W = false;
            this.X = false;
            this.Y = null;
            this.Z = 0;
            this.a0 = true;
            this.b0 = true;
            this.c0 = false;
            this.d0 = false;
            this.e0 = false;
            this.f0 = false;
            this.g0 = -1;
            this.h0 = -1;
            this.i0 = -1;
            this.j0 = -1;
            this.k0 = Integer.MIN_VALUE;
            this.l0 = Integer.MIN_VALUE;
            this.m0 = 0.5f;
            this.q0 = new ConstraintWidget();
        }
    }
}
