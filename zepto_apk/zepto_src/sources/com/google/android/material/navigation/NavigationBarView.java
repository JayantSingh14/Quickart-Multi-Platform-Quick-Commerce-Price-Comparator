package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public final NavigationBarMenu f40737a;

    /* renamed from: b, reason: collision with root package name */
    public final NavigationBarMenuView f40738b;

    /* renamed from: c, reason: collision with root package name */
    public final NavigationBarPresenter f40739c;

    /* renamed from: d, reason: collision with root package name */
    public SupportMenuInflater f40740d;

    /* renamed from: e, reason: collision with root package name */
    public OnItemSelectedListener f40741e;

    /* renamed from: f, reason: collision with root package name */
    public OnItemReselectedListener f40742f;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo
    public @interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void a();
    }

    public interface OnItemSelectedListener {
        boolean a();
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public Bundle f40744c;

        /* renamed from: com.google.android.material.navigation.NavigationBarView$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f40744c = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f40744c);
        }
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i2, int i3) throws Resources.NotFoundException {
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        NavigationBarPresenter navigationBarPresenter = new NavigationBarPresenter();
        this.f40739c = navigationBarPresenter;
        Context context2 = getContext();
        TintTypedArray tintTypedArrayE = ThemeEnforcement.e(context2, attributeSet, R.styleable.NavigationBarView, i2, i3, R.styleable.NavigationBarView_itemTextAppearanceInactive, R.styleable.NavigationBarView_itemTextAppearanceActive);
        NavigationBarMenu navigationBarMenu = new NavigationBarMenu(context2, getClass(), getMaxItemCount());
        this.f40737a = navigationBarMenu;
        NavigationBarMenuView navigationBarMenuViewA = a(context2);
        this.f40738b = navigationBarMenuViewA;
        navigationBarPresenter.f40732a = navigationBarMenuViewA;
        navigationBarPresenter.f40734c = 1;
        navigationBarMenuViewA.setPresenter(navigationBarPresenter);
        navigationBarMenu.b(navigationBarPresenter);
        getContext();
        navigationBarPresenter.f40732a.E = navigationBarMenu;
        int i4 = R.styleable.NavigationBarView_itemIconTint;
        TypedArray typedArray = tintTypedArrayE.f1185b;
        if (typedArray.hasValue(i4)) {
            navigationBarMenuViewA.setIconTintList(tintTypedArrayE.a(R.styleable.NavigationBarView_itemIconTint));
        } else {
            navigationBarMenuViewA.setIconTintList(navigationBarMenuViewA.c());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(R.styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(R.styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(R.styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (typedArray.hasValue(R.styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(typedArray.getResourceId(R.styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        setItemTextAppearanceActiveBoldEnabled(typedArray.getBoolean(R.styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        if (typedArray.hasValue(R.styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(tintTypedArrayE.a(R.styleable.NavigationBarView_itemTextColor));
        }
        Drawable background = getBackground();
        ColorStateList colorStateListD = DrawableUtils.d(background);
        if (background == null || colorStateListD != null) {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.c(context2, attributeSet, i2, i3).a());
            if (colorStateListD != null) {
                materialShapeDrawable.m(colorStateListD);
            }
            materialShapeDrawable.k(context2);
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            setBackground(materialShapeDrawable);
        }
        if (typedArray.hasValue(R.styleable.NavigationBarView_itemPaddingTop)) {
            setItemPaddingTop(typedArray.getDimensionPixelSize(R.styleable.NavigationBarView_itemPaddingTop, 0));
        }
        if (typedArray.hasValue(R.styleable.NavigationBarView_itemPaddingBottom)) {
            setItemPaddingBottom(typedArray.getDimensionPixelSize(R.styleable.NavigationBarView_itemPaddingBottom, 0));
        }
        if (typedArray.hasValue(R.styleable.NavigationBarView_activeIndicatorLabelPadding)) {
            setActiveIndicatorLabelPadding(typedArray.getDimensionPixelSize(R.styleable.NavigationBarView_activeIndicatorLabelPadding, 0));
        }
        if (typedArray.hasValue(R.styleable.NavigationBarView_elevation)) {
            setElevation(typedArray.getDimensionPixelSize(R.styleable.NavigationBarView_elevation, 0));
        }
        getBackground().mutate().setTintList(MaterialResources.b(context2, tintTypedArrayE, R.styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(typedArray.getInteger(R.styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = typedArray.getResourceId(R.styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            navigationBarMenuViewA.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(MaterialResources.b(context2, tintTypedArrayE, R.styleable.NavigationBarView_itemRippleColor));
        }
        int resourceId2 = typedArray.getResourceId(R.styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if (resourceId2 != 0) {
            setItemActiveIndicatorEnabled(true);
            TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(resourceId2, R.styleable.NavigationBarActiveIndicator);
            setItemActiveIndicatorWidth(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_width, 0));
            setItemActiveIndicatorHeight(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.NavigationBarActiveIndicator_android_height, 0));
            setItemActiveIndicatorMarginHorizontal(typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            setItemActiveIndicatorColor(MaterialResources.a(context2, typedArrayObtainStyledAttributes, R.styleable.NavigationBarActiveIndicator_android_color));
            setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.a(context2, typedArrayObtainStyledAttributes.getResourceId(R.styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).a());
            typedArrayObtainStyledAttributes.recycle();
        }
        if (typedArray.hasValue(R.styleable.NavigationBarView_menu)) {
            int resourceId3 = typedArray.getResourceId(R.styleable.NavigationBarView_menu, 0);
            navigationBarPresenter.f40733b = true;
            getMenuInflater().inflate(resourceId3, navigationBarMenu);
            navigationBarPresenter.f40733b = false;
            navigationBarPresenter.j(true);
        }
        tintTypedArrayE.g();
        addView(navigationBarMenuViewA);
        navigationBarMenu.f607e = new MenuBuilder.Callback() { // from class: com.google.android.material.navigation.NavigationBarView.1
            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
                NavigationBarView navigationBarView = NavigationBarView.this;
                if (navigationBarView.f40742f == null || menuItem.getItemId() != navigationBarView.getSelectedItemId()) {
                    OnItemSelectedListener onItemSelectedListener = navigationBarView.f40741e;
                    return (onItemSelectedListener == null || onItemSelectedListener.a()) ? false : true;
                }
                navigationBarView.f40742f.a();
                return true;
            }

            @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
            public final void b(MenuBuilder menuBuilder) {
            }
        };
    }

    private MenuInflater getMenuInflater() {
        if (this.f40740d == null) {
            this.f40740d = new SupportMenuInflater(getContext());
        }
        return this.f40740d;
    }

    public abstract NavigationBarMenuView a(Context context);

    @Px
    public int getActiveIndicatorLabelPadding() {
        return this.f40738b.getActiveIndicatorLabelPadding();
    }

    @Nullable
    public ColorStateList getItemActiveIndicatorColor() {
        return this.f40738b.getItemActiveIndicatorColor();
    }

    @Px
    public int getItemActiveIndicatorHeight() {
        return this.f40738b.getItemActiveIndicatorHeight();
    }

    @Px
    public int getItemActiveIndicatorMarginHorizontal() {
        return this.f40738b.getItemActiveIndicatorMarginHorizontal();
    }

    @Nullable
    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.f40738b.getItemActiveIndicatorShapeAppearance();
    }

    @Px
    public int getItemActiveIndicatorWidth() {
        return this.f40738b.getItemActiveIndicatorWidth();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f40738b.getItemBackground();
    }

    @DrawableRes
    @Deprecated
    public int getItemBackgroundResource() {
        return this.f40738b.getItemBackgroundRes();
    }

    @Dimension
    public int getItemIconSize() {
        return this.f40738b.getItemIconSize();
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f40738b.getIconTintList();
    }

    @Px
    public int getItemPaddingBottom() {
        return this.f40738b.getItemPaddingBottom();
    }

    @Px
    public int getItemPaddingTop() {
        return this.f40738b.getItemPaddingTop();
    }

    @Nullable
    public ColorStateList getItemRippleColor() {
        return this.f40738b.getItemRippleColor();
    }

    @StyleRes
    public int getItemTextAppearanceActive() {
        return this.f40738b.getItemTextAppearanceActive();
    }

    @StyleRes
    public int getItemTextAppearanceInactive() {
        return this.f40738b.getItemTextAppearanceInactive();
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f40738b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f40738b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    @NonNull
    public Menu getMenu() {
        return this.f40737a;
    }

    @NonNull
    @RestrictTo
    public MenuView getMenuView() {
        return this.f40738b;
    }

    @NonNull
    @RestrictTo
    public NavigationBarPresenter getPresenter() {
        return this.f40739c;
    }

    @IdRes
    public int getSelectedItemId() {
        return this.f40738b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.d(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        this.f40737a.u(savedState.f40744c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f40744c = bundle;
        this.f40737a.w(bundle);
        return savedState;
    }

    public void setActiveIndicatorLabelPadding(@Px int i2) {
        this.f40738b.setActiveIndicatorLabelPadding(i2);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.b(this, f2);
    }

    public void setItemActiveIndicatorColor(@Nullable ColorStateList colorStateList) {
        this.f40738b.setItemActiveIndicatorColor(colorStateList);
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.f40738b.setItemActiveIndicatorEnabled(z);
    }

    public void setItemActiveIndicatorHeight(@Px int i2) {
        this.f40738b.setItemActiveIndicatorHeight(i2);
    }

    public void setItemActiveIndicatorMarginHorizontal(@Px int i2) {
        this.f40738b.setItemActiveIndicatorMarginHorizontal(i2);
    }

    public void setItemActiveIndicatorShapeAppearance(@Nullable ShapeAppearanceModel shapeAppearanceModel) {
        this.f40738b.setItemActiveIndicatorShapeAppearance(shapeAppearanceModel);
    }

    public void setItemActiveIndicatorWidth(@Px int i2) {
        this.f40738b.setItemActiveIndicatorWidth(i2);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        this.f40738b.setItemBackground(drawable);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        this.f40738b.setItemBackgroundRes(i2);
    }

    public void setItemIconSize(@Dimension int i2) {
        this.f40738b.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(@DimenRes int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        this.f40738b.setIconTintList(colorStateList);
    }

    public void setItemPaddingBottom(@Px int i2) {
        this.f40738b.setItemPaddingBottom(i2);
    }

    public void setItemPaddingTop(@Px int i2) {
        this.f40738b.setItemPaddingTop(i2);
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f40738b.setItemRippleColor(colorStateList);
    }

    public void setItemTextAppearanceActive(@StyleRes int i2) throws Resources.NotFoundException {
        this.f40738b.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) throws Resources.NotFoundException {
        this.f40738b.setItemTextAppearanceActiveBoldEnabled(z);
    }

    public void setItemTextAppearanceInactive(@StyleRes int i2) throws Resources.NotFoundException {
        this.f40738b.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        this.f40738b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        NavigationBarMenuView navigationBarMenuView = this.f40738b;
        if (navigationBarMenuView.getLabelVisibilityMode() != i2) {
            navigationBarMenuView.setLabelVisibilityMode(i2);
            this.f40739c.j(false);
        }
    }

    public void setOnItemReselectedListener(@Nullable OnItemReselectedListener onItemReselectedListener) {
        this.f40742f = onItemReselectedListener;
    }

    public void setOnItemSelectedListener(@Nullable OnItemSelectedListener onItemSelectedListener) {
        this.f40741e = onItemSelectedListener;
    }

    public void setSelectedItemId(@IdRes int i2) {
        NavigationBarMenu navigationBarMenu = this.f40737a;
        MenuItem menuItemFindItem = navigationBarMenu.findItem(i2);
        if (menuItemFindItem == null || navigationBarMenu.r(menuItemFindItem, this.f40739c, 0)) {
            return;
        }
        menuItemFindItem.setChecked(true);
    }
}
