package com.google.android.material.search;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class SearchBar extends Toolbar {
    public static final int V0 = R.style.Widget_Material3_SearchBar;
    public final TextView G0;
    public final boolean H0;
    public final boolean I0;
    public final SearchBarAnimationHelper J0;
    public final Drawable K0;
    public final boolean L0;
    public final boolean M0;
    public View N0;
    public final Integer O0;
    public Drawable P0;
    public int Q0;
    public boolean R0;
    public final MaterialShapeDrawable S0;
    public final AccessibilityManager T0;
    public final a U0;

    public static abstract class OnLoadAnimationCallback {
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public String f40896c;

        /* renamed from: com.google.android.material.search.SearchBar$SavedState$1, reason: invalid class name */
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
            this.f40896c = parcel.readString();
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f40896c);
        }
    }

    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchBarStyle);
    }

    private void setNavigationIconDecorative(boolean z) {
        ImageButton imageButtonB = ToolbarUtils.b(this);
        if (imageButtonB == null) {
            return;
        }
        imageButtonB.setClickable(!z);
        imageButtonB.setFocusable(!z);
        Drawable background = imageButtonB.getBackground();
        if (background != null) {
            this.P0 = background;
        }
        imageButtonB.setBackgroundDrawable(z ? null : this.P0);
        z();
    }

    public final void A() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.R0) {
                if (layoutParams.f39866a == 0) {
                    layoutParams.f39866a = 53;
                }
            } else if (layoutParams.f39866a == 53) {
                layoutParams.f39866a = 0;
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.H0 && this.N0 == null && !(view instanceof ActionMenuView)) {
            this.N0 = view;
            view.setAlpha(0.0f);
        }
        super.addView(view, i2, layoutParams);
    }

    @Nullable
    public View getCenterView() {
        return this.N0;
    }

    public float getCompatElevation() {
        MaterialShapeDrawable materialShapeDrawable = this.S0;
        return materialShapeDrawable != null ? materialShapeDrawable.f40974a.f41001m : ViewCompat.j(this);
    }

    public float getCornerSize() {
        return this.S0.i();
    }

    @DimenRes
    @RestrictTo
    public int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    @DrawableRes
    @RestrictTo
    public int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    @Nullable
    public CharSequence getHint() {
        return this.G0.getHint();
    }

    public int getMenuResId() {
        return this.Q0;
    }

    @ColorInt
    public int getStrokeColor() {
        return this.S0.f40974a.f40992d.getDefaultColor();
    }

    @Dimension
    public float getStrokeWidth() {
        return this.S0.f40974a.f40998j;
    }

    @NonNull
    public CharSequence getText() {
        return this.G0.getText();
    }

    @NonNull
    public TextView getTextView() {
        return this.G0;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public final void n(int i2) {
        Menu menu = getMenu();
        boolean z = menu instanceof MenuBuilder;
        if (z) {
            ((MenuBuilder) menu).B();
        }
        super.n(i2);
        this.Q0 = i2;
        if (z) {
            ((MenuBuilder) menu).A();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() throws Resources.NotFoundException {
        super.onAttachedToWindow();
        MaterialShapeUtils.c(this, this.S0);
        if (this.I0 && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            int i2 = marginLayoutParams.leftMargin;
            if (i2 == 0) {
                i2 = dimensionPixelSize;
            }
            marginLayoutParams.leftMargin = i2;
            int i3 = marginLayoutParams.topMargin;
            if (i3 == 0) {
                i3 = dimensionPixelSize2;
            }
            marginLayoutParams.topMargin = i3;
            int i4 = marginLayoutParams.rightMargin;
            if (i4 != 0) {
                dimensionPixelSize = i4;
            }
            marginLayoutParams.rightMargin = dimensionPixelSize;
            int i5 = marginLayoutParams.bottomMargin;
            if (i5 != 0) {
                dimensionPixelSize2 = i5;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize2;
        }
        A();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        int i2 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean zIsEmpty = TextUtils.isEmpty(text);
        if (i2 >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(zIsEmpty);
        }
        if (zIsEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.N0;
        if (view != null) {
            int measuredWidth = view.getMeasuredWidth();
            int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
            int i6 = measuredWidth + measuredWidth2;
            int measuredHeight = this.N0.getMeasuredHeight();
            int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
            int i7 = measuredHeight + measuredHeight2;
            View view2 = this.N0;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            if (getLayoutDirection() == 1) {
                view2.layout(getMeasuredWidth() - i6, measuredHeight2, getMeasuredWidth() - measuredWidth2, i7);
            } else {
                view2.layout(measuredWidth2, measuredHeight2, i6, i7);
            }
        }
        z();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        View view = this.N0;
        if (view != null) {
            view.measure(i2, i3);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        setText(savedState.f40896c);
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.f40896c = text == null ? null : text.toString();
        return savedState;
    }

    public void setCenterView(@Nullable View view) {
        View view2 = this.N0;
        if (view2 != null) {
            removeView(view2);
            this.N0 = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z) {
        this.R0 = z;
        A();
    }

    @Override // android.view.View
    @RequiresApi
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeDrawable materialShapeDrawable = this.S0;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.l(f2);
        }
    }

    public void setHint(@Nullable CharSequence charSequence) {
        this.G0.setHint(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(@Nullable Drawable drawable) {
        int iB;
        if (this.L0 && drawable != null) {
            Integer num = this.O0;
            if (num != null) {
                iB = num.intValue();
            } else {
                iB = MaterialColors.b(drawable == this.K0 ? R.attr.colorOnSurfaceVariant : R.attr.colorOnSurface, this);
            }
            drawable = drawable.mutate();
            drawable.setTint(iB);
        }
        super.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.M0) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.J0.getClass();
    }

    public void setStrokeColor(@ColorInt int i2) {
        if (getStrokeColor() != i2) {
            this.S0.t(ColorStateList.valueOf(i2));
        }
    }

    public void setStrokeWidth(@Dimension float f2) {
        if (getStrokeWidth() != f2) {
            this.S0.u(f2);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(@Nullable CharSequence charSequence) {
        this.G0.setText(charSequence);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public final void z() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z = getLayoutDirection() == 1;
        ImageButton imageButtonB = ToolbarUtils.b(this);
        int width = (imageButtonB == null || !imageButtonB.isClickable()) ? 0 : z ? getWidth() - imageButtonB.getLeft() : imageButtonB.getRight();
        ActionMenuView actionMenuViewA = ToolbarUtils.a(this);
        int right = actionMenuViewA != null ? z ? actionMenuViewA.getRight() : getWidth() - actionMenuViewA.getLeft() : 0;
        float f2 = -(z ? right : width);
        if (!z) {
            width = right;
        }
        setHandwritingBoundsOffsets(f2, 0.0f, -width, 0.0f);
    }

    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

        /* renamed from: g, reason: collision with root package name */
        public boolean f40897g;

        public ScrollingViewBehavior() {
            this.f40897g = false;
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public final boolean j(CoordinatorLayout coordinatorLayout, View view, View view2) {
            super.j(coordinatorLayout, view, view2);
            if (!this.f40897g && (view2 instanceof AppBarLayout)) {
                this.f40897g = true;
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                appBarLayout.setBackgroundColor(0);
                appBarLayout.setTargetElevation(0.0f);
            }
            return false;
        }

        public ScrollingViewBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f40897g = false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SearchBar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        int i3 = V0;
        super(MaterialThemeOverlay.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.Q0 = -1;
        this.U0 = new a(this);
        Context context2 = getContext();
        if (attributeSet != null) {
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "title") != null) {
                throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "subtitle") != null) {
                throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
            }
        }
        Drawable drawableB = AppCompatResources.b(getDefaultNavigationIconResource(), context2);
        this.K0 = drawableB;
        SearchBarAnimationHelper searchBarAnimationHelper = new SearchBarAnimationHelper();
        new LinkedHashSet();
        new LinkedHashSet();
        new LinkedHashSet();
        this.J0 = searchBarAnimationHelper;
        TypedArray typedArrayD = ThemeEnforcement.d(context2, attributeSet, R.styleable.SearchBar, i2, i3, new int[0]);
        ShapeAppearanceModel shapeAppearanceModelA = ShapeAppearanceModel.c(context2, attributeSet, i2, i3).a();
        int color = typedArrayD.getColor(R.styleable.SearchBar_backgroundTint, 0);
        float dimension = typedArrayD.getDimension(R.styleable.SearchBar_elevation, 0.0f);
        this.I0 = typedArrayD.getBoolean(R.styleable.SearchBar_defaultMarginsEnabled, true);
        this.R0 = typedArrayD.getBoolean(R.styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean z = typedArrayD.getBoolean(R.styleable.SearchBar_hideNavigationIcon, false);
        this.M0 = typedArrayD.getBoolean(R.styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.L0 = typedArrayD.getBoolean(R.styleable.SearchBar_tintNavigationIcon, true);
        if (typedArrayD.hasValue(R.styleable.SearchBar_navigationIconTint)) {
            this.O0 = Integer.valueOf(typedArrayD.getColor(R.styleable.SearchBar_navigationIconTint, -1));
        }
        int resourceId = typedArrayD.getResourceId(R.styleable.SearchBar_android_textAppearance, -1);
        String string = typedArrayD.getString(R.styleable.SearchBar_android_text);
        String string2 = typedArrayD.getString(R.styleable.SearchBar_android_hint);
        float dimension2 = typedArrayD.getDimension(R.styleable.SearchBar_strokeWidth, -1.0f);
        int color2 = typedArrayD.getColor(R.styleable.SearchBar_strokeColor, 0);
        typedArrayD.recycle();
        if (!z) {
            setNavigationIcon(getNavigationIcon() != null ? getNavigationIcon() : drawableB);
            setNavigationIconDecorative(true);
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_bar, this);
        this.H0 = true;
        TextView textView = (TextView) findViewById(R.id.open_search_bar_text_view);
        this.G0 = textView;
        ViewCompat.E(this, dimension);
        if (resourceId != -1) {
            textView.setTextAppearance(resourceId);
        }
        setText(string);
        setHint(string2);
        if (getNavigationIcon() == null) {
            ((ViewGroup.MarginLayoutParams) textView.getLayoutParams()).setMarginStart(getResources().getDimensionPixelSize(R.dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModelA);
        this.S0 = materialShapeDrawable;
        materialShapeDrawable.k(getContext());
        this.S0.l(dimension);
        if (dimension2 >= 0.0f) {
            MaterialShapeDrawable materialShapeDrawable2 = this.S0;
            materialShapeDrawable2.u(dimension2);
            materialShapeDrawable2.t(ColorStateList.valueOf(color2));
        }
        int iB = MaterialColors.b(R.attr.colorControlHighlight, this);
        this.S0.m(ColorStateList.valueOf(color));
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iB);
        MaterialShapeDrawable materialShapeDrawable3 = this.S0;
        setBackground(new RippleDrawable(colorStateListValueOf, materialShapeDrawable3, materialShapeDrawable3));
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.T0 = accessibilityManager;
        if (accessibilityManager != null) {
            if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
                setFocusableInTouchMode(true);
            }
            addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.search.SearchBar.1
                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewAttachedToWindow(View view) {
                    SearchBar searchBar = SearchBar.this;
                    AccessibilityManagerCompat.a(searchBar.T0, searchBar.U0);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public final void onViewDetachedFromWindow(View view) {
                    SearchBar searchBar = SearchBar.this;
                    AccessibilityManagerCompat.b(searchBar.T0, searchBar.U0);
                }
            });
        }
    }

    public void setHint(@StringRes int i2) {
        this.G0.setHint(i2);
    }

    public void setText(@StringRes int i2) {
        this.G0.setText(i2);
    }
}
