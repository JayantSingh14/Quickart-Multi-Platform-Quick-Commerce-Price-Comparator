package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class ChipGroup extends FlowLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final int f40221k = R.style.Widget_MaterialComponents_ChipGroup;

    /* renamed from: e, reason: collision with root package name */
    public int f40222e;

    /* renamed from: f, reason: collision with root package name */
    public int f40223f;

    /* renamed from: g, reason: collision with root package name */
    public OnCheckedStateChangeListener f40224g;

    /* renamed from: h, reason: collision with root package name */
    public final CheckableGroup f40225h;

    /* renamed from: i, reason: collision with root package name */
    public final int f40226i;

    /* renamed from: j, reason: collision with root package name */
    public final PassThroughHierarchyChangeListener f40227j;

    /* renamed from: com.google.android.material.chip.ChipGroup$1, reason: invalid class name */
    public class AnonymousClass1 implements CheckableGroup.OnCheckedStateChangeListener {
        public AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.CheckableGroup.OnCheckedStateChangeListener
        public final void a() {
            ChipGroup chipGroup = ChipGroup.this;
            OnCheckedStateChangeListener onCheckedStateChangeListener = chipGroup.f40224g;
            if (onCheckedStateChangeListener != null) {
                chipGroup.f40225h.c(chipGroup);
                onCheckedStateChangeListener.a(chipGroup);
            }
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    @Deprecated
    public interface OnCheckedChangeListener {
        void a();
    }

    public interface OnCheckedStateChangeListener {
        void a(ChipGroup chipGroup);
    }

    public class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {

        /* renamed from: a, reason: collision with root package name */
        public ViewGroup.OnHierarchyChangeListener f40231a;

        public PassThroughHierarchyChangeListener() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewAdded(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    view2.setId(View.generateViewId());
                }
                chipGroup.f40225h.a((Chip) view2);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f40231a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public final void onChildViewRemoved(View view, View view2) {
            ChipGroup chipGroup = ChipGroup.this;
            if (view == chipGroup && (view2 instanceof Chip)) {
                Chip chip = (Chip) view2;
                CheckableGroup checkableGroup = chipGroup.f40225h;
                checkableGroup.getClass();
                chip.setInternalOnCheckedChangeListener(null);
                checkableGroup.f40539a.remove(Integer.valueOf(chip.getId()));
                checkableGroup.f40540b.remove(Integer.valueOf(chip.getId()));
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.f40231a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    private int getVisibleChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof Chip) && getChildAt(i3).getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public final boolean a() {
        return this.f40579c;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        return this.f40225h.d();
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        return this.f40225h.c(this);
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.f40222e;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.f40223f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        CheckableGroup.OnCheckedStateChangeListener onCheckedStateChangeListener;
        super.onFinishInflate();
        int i2 = this.f40226i;
        if (i2 != -1) {
            CheckableGroup checkableGroup = this.f40225h;
            MaterialCheckable materialCheckable = (MaterialCheckable) checkableGroup.f40539a.get(Integer.valueOf(i2));
            if (materialCheckable == null || !checkableGroup.b(materialCheckable) || (onCheckedStateChangeListener = checkableGroup.f40541c) == null) {
                return;
            }
            new HashSet(checkableGroup.f40540b);
            ((AnonymousClass1) onCheckedStateChangeListener).a();
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        new AccessibilityNodeInfoCompat(accessibilityNodeInfo).o(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(getRowCount(), this.f40579c ? getVisibleChipCount() : -1, this.f40225h.f40542d ? 1 : 2));
    }

    public void setChipSpacing(@Dimension int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(@Dimension int i2) {
        if (this.f40222e != i2) {
            this.f40222e = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(@DimenRes int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(@Dimension int i2) {
        if (this.f40223f != i2) {
            this.f40223f = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated
    public void setOnCheckedChangeListener(@Nullable final OnCheckedChangeListener onCheckedChangeListener) {
        if (onCheckedChangeListener == null) {
            setOnCheckedStateChangeListener(null);
        } else {
            setOnCheckedStateChangeListener(new OnCheckedStateChangeListener() { // from class: com.google.android.material.chip.ChipGroup.2
                @Override // com.google.android.material.chip.ChipGroup.OnCheckedStateChangeListener
                public final void a(ChipGroup chipGroup) {
                    ChipGroup chipGroup2 = ChipGroup.this;
                    if (chipGroup2.f40225h.f40542d) {
                        OnCheckedChangeListener onCheckedChangeListener2 = onCheckedChangeListener;
                        chipGroup2.getCheckedChipId();
                        onCheckedChangeListener2.a();
                    }
                }
            });
        }
    }

    public void setOnCheckedStateChangeListener(@Nullable OnCheckedStateChangeListener onCheckedStateChangeListener) {
        this.f40224g = onCheckedStateChangeListener;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f40227j.f40231a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.f40225h.f40543e = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        CheckableGroup.OnCheckedStateChangeListener onCheckedStateChangeListener;
        CheckableGroup checkableGroup = this.f40225h;
        if (checkableGroup.f40542d != z) {
            checkableGroup.f40542d = z;
            HashSet hashSet = checkableGroup.f40540b;
            boolean zIsEmpty = hashSet.isEmpty();
            Iterator it = checkableGroup.f40539a.values().iterator();
            while (it.hasNext()) {
                checkableGroup.e((MaterialCheckable) it.next(), false);
            }
            if (zIsEmpty || (onCheckedStateChangeListener = checkableGroup.f40541c) == null) {
                return;
            }
            new HashSet(hashSet);
            ((AnonymousClass1) onCheckedStateChangeListener).a();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ChipGroup(Context context, AttributeSet attributeSet, int i2) {
        int i3 = f40221k;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        CheckableGroup checkableGroup = new CheckableGroup();
        this.f40225h = checkableGroup;
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.f40227j = passThroughHierarchyChangeListener;
        TypedArray typedArrayD = ThemeEnforcement.d(getContext(), attributeSet, R.styleable.ChipGroup, i2, i3, new int[0]);
        int dimensionPixelOffset = typedArrayD.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacing, 0);
        setChipSpacingHorizontal(typedArrayD.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingHorizontal, dimensionPixelOffset));
        setChipSpacingVertical(typedArrayD.getDimensionPixelOffset(R.styleable.ChipGroup_chipSpacingVertical, dimensionPixelOffset));
        setSingleLine(typedArrayD.getBoolean(R.styleable.ChipGroup_singleLine, false));
        setSingleSelection(typedArrayD.getBoolean(R.styleable.ChipGroup_singleSelection, false));
        setSelectionRequired(typedArrayD.getBoolean(R.styleable.ChipGroup_selectionRequired, false));
        this.f40226i = typedArrayD.getResourceId(R.styleable.ChipGroup_checkedChip, -1);
        typedArrayD.recycle();
        checkableGroup.f40541c = new AnonymousClass1();
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@BoolRes int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
