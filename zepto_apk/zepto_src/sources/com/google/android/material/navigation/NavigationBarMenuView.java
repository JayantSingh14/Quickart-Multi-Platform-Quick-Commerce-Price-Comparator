package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pools;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    public static final int[] F = {R.attr.state_checked};
    public static final int[] G = {-16842910};
    public ShapeAppearanceModel A;
    public boolean B;
    public ColorStateList C;
    public NavigationBarPresenter D;
    public MenuBuilder E;

    /* renamed from: a, reason: collision with root package name */
    public final AutoTransition f40718a;

    /* renamed from: b, reason: collision with root package name */
    public final View.OnClickListener f40719b;

    /* renamed from: c, reason: collision with root package name */
    public final Pools.SynchronizedPool f40720c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseArray f40721d;

    /* renamed from: e, reason: collision with root package name */
    public int f40722e;

    /* renamed from: f, reason: collision with root package name */
    public NavigationBarItemView[] f40723f;

    /* renamed from: g, reason: collision with root package name */
    public int f40724g;

    /* renamed from: h, reason: collision with root package name */
    public int f40725h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f40726i;

    /* renamed from: j, reason: collision with root package name */
    public int f40727j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f40728k;

    /* renamed from: l, reason: collision with root package name */
    public final ColorStateList f40729l;

    /* renamed from: m, reason: collision with root package name */
    public int f40730m;
    public int n;
    public boolean o;
    public Drawable p;
    public ColorStateList q;
    public int r;
    public final SparseArray s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public int x;
    public int y;
    public int z;

    public NavigationBarMenuView(Context context) {
        super(context);
        this.f40720c = new Pools.SynchronizedPool(5);
        this.f40721d = new SparseArray(5);
        this.f40724g = 0;
        this.f40725h = 0;
        this.s = new SparseArray(5);
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.B = false;
        this.f40729l = c();
        if (isInEditMode()) {
            this.f40718a = null;
        } else {
            AutoTransition autoTransition = new AutoTransition();
            this.f40718a = autoTransition;
            autoTransition.T(0);
            autoTransition.G(MotionUtils.c(getContext(), com.google.android.material.R.attr.motionDurationMedium4, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
            autoTransition.I(MotionUtils.d(getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.f39817b));
            autoTransition.P(new TextScale());
        }
        this.f40719b = new View.OnClickListener() { // from class: com.google.android.material.navigation.NavigationBarMenuView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
                NavigationBarMenuView navigationBarMenuView = NavigationBarMenuView.this;
                if (navigationBarMenuView.E.r(itemData, navigationBarMenuView.D, 0)) {
                    return;
                }
                itemData.setChecked(true);
            }
        };
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setImportantForAccessibility(1);
    }

    public static boolean f(int i2, int i3) {
        return i2 == -1 ? i3 > 3 : i2 == 0;
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.f40720c.b();
        return navigationBarItemView == null ? e(getContext()) : navigationBarItemView;
    }

    private void setBadgeIfNeeded(@NonNull NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (id == -1 || (badgeDrawable = (BadgeDrawable) this.s.get(id)) == null) {
            return;
        }
        navigationBarItemView.setBadge(badgeDrawable);
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void a(MenuBuilder menuBuilder) {
        this.E = menuBuilder;
    }

    public final void b() {
        removeAllViews();
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                if (navigationBarItemView != null) {
                    this.f40720c.a(navigationBarItemView);
                    if (navigationBarItemView.F != null) {
                        ImageView imageView = navigationBarItemView.n;
                        if (imageView != null) {
                            navigationBarItemView.setClipChildren(true);
                            navigationBarItemView.setClipToPadding(true);
                            BadgeDrawable badgeDrawable = navigationBarItemView.F;
                            if (badgeDrawable != null) {
                                if (badgeDrawable.d() != null) {
                                    badgeDrawable.d().setForeground(null);
                                } else {
                                    imageView.getOverlay().remove(badgeDrawable);
                                }
                            }
                        }
                        navigationBarItemView.F = null;
                    }
                    navigationBarItemView.t = null;
                    navigationBarItemView.z = 0.0f;
                    navigationBarItemView.f40700a = false;
                }
            }
        }
        if (this.E.f608f.size() == 0) {
            this.f40724g = 0;
            this.f40725h = 0;
            this.f40723f = null;
            return;
        }
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.E.f608f.size(); i2++) {
            hashSet.add(Integer.valueOf(this.E.getItem(i2).getItemId()));
        }
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.s;
            if (i3 >= sparseArray.size()) {
                break;
            }
            int iKeyAt = sparseArray.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(iKeyAt))) {
                sparseArray.delete(iKeyAt);
            }
            i3++;
        }
        this.f40723f = new NavigationBarItemView[this.E.f608f.size()];
        boolean zF = f(this.f40722e, this.E.m().size());
        for (int i4 = 0; i4 < this.E.f608f.size(); i4++) {
            this.D.f40733b = true;
            this.E.getItem(i4).setCheckable(true);
            this.D.f40733b = false;
            NavigationBarItemView newItem = getNewItem();
            this.f40723f[i4] = newItem;
            newItem.setIconTintList(this.f40726i);
            newItem.setIconSize(this.f40727j);
            newItem.setTextColor(this.f40729l);
            newItem.setTextAppearanceInactive(this.f40730m);
            newItem.setTextAppearanceActive(this.n);
            newItem.setTextAppearanceActiveBoldEnabled(this.o);
            newItem.setTextColor(this.f40728k);
            int i5 = this.t;
            if (i5 != -1) {
                newItem.setItemPaddingTop(i5);
            }
            int i6 = this.u;
            if (i6 != -1) {
                newItem.setItemPaddingBottom(i6);
            }
            int i7 = this.v;
            if (i7 != -1) {
                newItem.setActiveIndicatorLabelPadding(i7);
            }
            newItem.setActiveIndicatorWidth(this.x);
            newItem.setActiveIndicatorHeight(this.y);
            newItem.setActiveIndicatorMarginHorizontal(this.z);
            newItem.setActiveIndicatorDrawable(d());
            newItem.setActiveIndicatorResizeable(this.B);
            newItem.setActiveIndicatorEnabled(this.w);
            Drawable drawable = this.p;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.r);
            }
            newItem.setItemRippleColor(this.q);
            newItem.setShifting(zF);
            newItem.setLabelVisibilityMode(this.f40722e);
            MenuItemImpl menuItemImpl = (MenuItemImpl) this.E.getItem(i4);
            newItem.c(menuItemImpl);
            newItem.setItemPosition(i4);
            SparseArray sparseArray2 = this.f40721d;
            int i8 = menuItemImpl.f619a;
            newItem.setOnTouchListener((View.OnTouchListener) sparseArray2.get(i8));
            newItem.setOnClickListener(this.f40719b);
            int i9 = this.f40724g;
            if (i9 != 0 && i8 == i9) {
                this.f40725h = i4;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int iMin = Math.min(this.E.f608f.size() - 1, this.f40725h);
        this.f40725h = iMin;
        this.E.getItem(iMin).setChecked(true);
    }

    public final ColorStateList c() {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(R.attr.textColorSecondary, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListB = ContextCompat.b(typedValue.resourceId, getContext());
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListB.getDefaultColor();
        int[] iArr = G;
        return new ColorStateList(new int[][]{iArr, F, ViewGroup.EMPTY_STATE_SET}, new int[]{colorStateListB.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    public final MaterialShapeDrawable d() {
        if (this.A == null || this.C == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.A);
        materialShapeDrawable.m(this.C);
        return materialShapeDrawable;
    }

    public abstract NavigationBarItemView e(Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.v;
    }

    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.s;
    }

    @Nullable
    public ColorStateList getIconTintList() {
        return this.f40726i;
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.C;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.w;
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.y;
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.z;
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.A;
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.x;
    }

    @Nullable
    public Drawable getItemBackground() {
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        return (navigationBarItemViewArr == null || navigationBarItemViewArr.length <= 0) ? this.p : navigationBarItemViewArr[0].getBackground();
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.r;
    }

    @Dimension
    public int getItemIconSize() {
        return this.f40727j;
    }

    @Px
    public int getItemPaddingBottom() {
        return this.u;
    }

    @Px
    public int getItemPaddingTop() {
        return this.t;
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.q;
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.n;
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f40730m;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f40728k;
    }

    public int getLabelVisibilityMode() {
        return this.f40722e;
    }

    @Nullable
    public MenuBuilder getMenu() {
        return this.E;
    }

    public int getSelectedItemId() {
        return this.f40724g;
    }

    public int getSelectedItemPosition() {
        return this.f40725h;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        new AccessibilityNodeInfoCompat(accessibilityNodeInfo).o(AccessibilityNodeInfoCompat.CollectionInfoCompat.a(1, this.E.m().size(), 1));
    }

    public void setActiveIndicatorLabelPadding(@Px int i2) {
        this.v = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorLabelPadding(i2);
            }
        }
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        this.f40726i = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.C = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.w = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorEnabled(z);
            }
        }
    }

    public void setItemActiveIndicatorHeight(@Px int i2) {
        this.y = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorHeight(i2);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i2) {
        this.z = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorMarginHorizontal(i2);
            }
        }
    }

    public void setItemActiveIndicatorResizeable(boolean z) {
        this.B = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorResizeable(z);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.A = shapeAppearanceModel;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorDrawable(d());
            }
        }
    }

    public void setItemActiveIndicatorWidth(@Px int i2) {
        this.x = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setActiveIndicatorWidth(i2);
            }
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.p = drawable;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.r = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemBackground(i2);
            }
        }
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f40727j = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setIconSize(i2);
            }
        }
    }

    public void setItemPaddingBottom(@Px int i2) {
        this.u = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingBottom(i2);
            }
        }
    }

    public void setItemPaddingTop(@Px int i2) {
        this.t = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemPaddingTop(i2);
            }
        }
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.q = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setItemRippleColor(colorStateList);
            }
        }
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) throws Resources.NotFoundException {
        this.n = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.f40728k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) throws Resources.NotFoundException {
        this.o = z;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceActiveBoldEnabled(z);
            }
        }
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) throws Resources.NotFoundException {
        this.f40730m = i2;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.f40728k;
                if (colorStateList != null) {
                    navigationBarItemView.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f40728k = colorStateList;
        NavigationBarItemView[] navigationBarItemViewArr = this.f40723f;
        if (navigationBarItemViewArr != null) {
            for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                navigationBarItemView.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.f40722e = i2;
    }

    public void setPresenter(@NonNull NavigationBarPresenter navigationBarPresenter) {
        this.D = navigationBarPresenter;
    }
}
