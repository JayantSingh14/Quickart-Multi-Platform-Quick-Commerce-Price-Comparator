package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final int f40099k = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f40100a;

    /* renamed from: b, reason: collision with root package name */
    public final PressedStateTracker f40101b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashSet f40102c;

    /* renamed from: d, reason: collision with root package name */
    public final Comparator f40103d;

    /* renamed from: e, reason: collision with root package name */
    public Integer[] f40104e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f40105f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f40106g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f40107h;

    /* renamed from: i, reason: collision with root package name */
    public final int f40108i;

    /* renamed from: j, reason: collision with root package name */
    public HashSet f40109j;

    public static class CornerData {

        /* renamed from: e, reason: collision with root package name */
        public static final AbsoluteCornerSize f40112e = new AbsoluteCornerSize(0.0f);

        /* renamed from: a, reason: collision with root package name */
        public final CornerSize f40113a;

        /* renamed from: b, reason: collision with root package name */
        public final CornerSize f40114b;

        /* renamed from: c, reason: collision with root package name */
        public final CornerSize f40115c;

        /* renamed from: d, reason: collision with root package name */
        public final CornerSize f40116d;

        public CornerData(CornerSize cornerSize, CornerSize cornerSize2, CornerSize cornerSize3, CornerSize cornerSize4) {
            this.f40113a = cornerSize;
            this.f40114b = cornerSize3;
            this.f40115c = cornerSize4;
            this.f40116d = cornerSize2;
        }
    }

    public interface OnButtonCheckedListener {
        void a(int i2, boolean z);
    }

    public class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        public PressedStateTracker() {
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public final void a() {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (c(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && c(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            materialButton.setId(View.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.setOnPressedChangeListenerInternal(this.f40101b);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            int iMin = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i2 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                layoutParams2.setMarginEnd(0);
                layoutParams2.setMarginStart(-iMin);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -iMin;
                layoutParams2.setMarginStart(0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            layoutParams3.setMarginEnd(0);
            layoutParams3.setMarginStart(0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        b(materialButton.getId(), materialButton.o);
        ShapeAppearanceModel shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f40100a.add(new CornerData(shapeAppearanceModel.f41011e, shapeAppearanceModel.f41014h, shapeAppearanceModel.f41012f, shapeAppearanceModel.f41013g));
        materialButton.setEnabled(isEnabled());
        ViewCompat.z(materialButton, new AccessibilityDelegateCompat() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.2
            @Override // androidx.core.view.AccessibilityDelegateCompat
            public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                int i3;
                super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                int i4 = MaterialButtonToggleGroup.f40099k;
                MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                if (view2 instanceof MaterialButton) {
                    i3 = 0;
                    for (int i5 = 0; i5 < materialButtonToggleGroup.getChildCount(); i5++) {
                        if (materialButtonToggleGroup.getChildAt(i5) == view2) {
                            break;
                        }
                        if ((materialButtonToggleGroup.getChildAt(i5) instanceof MaterialButton) && materialButtonToggleGroup.c(i5)) {
                            i3++;
                        }
                    }
                    i3 = -1;
                } else {
                    i3 = -1;
                }
                accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, i3, 1, false, ((MaterialButton) view2).o));
            }
        });
    }

    public final void b(int i2, boolean z) {
        if (i2 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + i2);
            return;
        }
        HashSet hashSet = new HashSet(this.f40109j);
        if (z && !hashSet.contains(Integer.valueOf(i2))) {
            if (this.f40106g && !hashSet.isEmpty()) {
                hashSet.clear();
            }
            hashSet.add(Integer.valueOf(i2));
        } else {
            if (z || !hashSet.contains(Integer.valueOf(i2))) {
                return;
            }
            if (!this.f40107h || hashSet.size() > 1) {
                hashSet.remove(Integer.valueOf(i2));
            }
        }
        d(hashSet);
    }

    public final boolean c(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    public final void d(Set set) {
        HashSet hashSet = this.f40109j;
        this.f40109j = new HashSet(set);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            int id = ((MaterialButton) getChildAt(i2)).getId();
            boolean zContains = set.contains(Integer.valueOf(id));
            View viewFindViewById = findViewById(id);
            if (viewFindViewById instanceof MaterialButton) {
                this.f40105f = true;
                ((MaterialButton) viewFindViewById).setChecked(zContains);
                this.f40105f = false;
            }
            if (hashSet.contains(Integer.valueOf(id)) != set.contains(Integer.valueOf(id))) {
                boolean zContains2 = set.contains(Integer.valueOf(id));
                Iterator it = this.f40102c.iterator();
                while (it.hasNext()) {
                    ((OnButtonCheckedListener) it.next()).a(id, zContains2);
                }
            }
        }
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.f40103d);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put((MaterialButton) getChildAt(i2), Integer.valueOf(i2));
        }
        this.f40104e = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        CornerData cornerData;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i2);
            if (materialButton.getVisibility() != 8) {
                ShapeAppearanceModel.Builder builderG = materialButton.getShapeAppearanceModel().g();
                CornerData cornerData2 = (CornerData) this.f40100a.get(i2);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z = getOrientation() == 0;
                    AbsoluteCornerSize absoluteCornerSize = CornerData.f40112e;
                    if (i2 == firstVisibleChildIndex) {
                        cornerData = z ? ViewUtils.h(this) ? new CornerData(absoluteCornerSize, absoluteCornerSize, cornerData2.f40114b, cornerData2.f40115c) : new CornerData(cornerData2.f40113a, cornerData2.f40116d, absoluteCornerSize, absoluteCornerSize) : new CornerData(cornerData2.f40113a, absoluteCornerSize, cornerData2.f40114b, absoluteCornerSize);
                    } else if (i2 == lastVisibleChildIndex) {
                        cornerData = z ? ViewUtils.h(this) ? new CornerData(cornerData2.f40113a, cornerData2.f40116d, absoluteCornerSize, absoluteCornerSize) : new CornerData(absoluteCornerSize, absoluteCornerSize, cornerData2.f40114b, cornerData2.f40115c) : new CornerData(absoluteCornerSize, cornerData2.f40116d, absoluteCornerSize, cornerData2.f40115c);
                    } else {
                        cornerData2 = null;
                    }
                    cornerData2 = cornerData;
                }
                if (cornerData2 == null) {
                    builderG.c(0.0f);
                } else {
                    builderG.f41023e = cornerData2.f40113a;
                    builderG.f41026h = cornerData2.f40116d;
                    builderG.f41024f = cornerData2.f40114b;
                    builderG.f41025g = cornerData2.f40115c;
                }
                materialButton.setShapeAppearanceModel(builderG.a());
            }
        }
    }

    @IdRes
    public int getCheckedButtonId() {
        if (!this.f40106g || this.f40109j.isEmpty()) {
            return -1;
        }
        return ((Integer) this.f40109j.iterator().next()).intValue();
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            int id = ((MaterialButton) getChildAt(i2)).getId();
            if (this.f40109j.contains(Integer.valueOf(id))) {
                arrayList.add(Integer.valueOf(id));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f40104e;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w("MButtonToggleGroup", "Child order wasn't updated");
        return i3;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f40108i;
        if (i2 != -1) {
            d(Collections.singleton(Integer.valueOf(i2)));
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        new AccessibilityNodeInfoCompat(accessibilityNodeInfo).o(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, getVisibleButtonCount(), this.f40106g ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        e();
        a();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild >= 0) {
            this.f40100a.remove(iIndexOfChild);
        }
        e();
        a();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((MaterialButton) getChildAt(i2)).setEnabled(z);
        }
    }

    public void setSelectionRequired(boolean z) {
        this.f40107h = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f40106g != z) {
            this.f40106g = z;
            d(new HashSet());
        }
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            ((MaterialButton) getChildAt(i2)).setA11yClassName((this.f40106g ? RadioButton.class : ToggleButton.class).getName());
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = f40099k;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.f40100a = new ArrayList();
        this.f40101b = new PressedStateTracker();
        this.f40102c = new LinkedHashSet();
        this.f40103d = new Comparator<MaterialButton>() { // from class: com.google.android.material.button.MaterialButtonToggleGroup.1
            @Override // java.util.Comparator
            public final int compare(MaterialButton materialButton, MaterialButton materialButton2) {
                MaterialButton materialButton3 = materialButton;
                MaterialButton materialButton4 = materialButton2;
                int iCompareTo = Boolean.valueOf(materialButton3.o).compareTo(Boolean.valueOf(materialButton4.o));
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                int iCompareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
                if (iCompareTo2 != 0) {
                    return iCompareTo2;
                }
                MaterialButtonToggleGroup materialButtonToggleGroup = MaterialButtonToggleGroup.this;
                return Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton3)).compareTo(Integer.valueOf(materialButtonToggleGroup.indexOfChild(materialButton4)));
            }
        };
        this.f40105f = false;
        this.f40109j = new HashSet();
        TypedArray typedArrayD = ThemeEnforcement.d(getContext(), attributeSet, R.styleable.MaterialButtonToggleGroup, i2, i3, new int[0]);
        setSingleSelection(typedArrayD.getBoolean(R.styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.f40108i = typedArrayD.getResourceId(R.styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.f40107h = typedArrayD.getBoolean(R.styleable.MaterialButtonToggleGroup_selectionRequired, false);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(typedArrayD.getBoolean(R.styleable.MaterialButtonToggleGroup_android_enabled, true));
        typedArrayD.recycle();
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(1);
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
