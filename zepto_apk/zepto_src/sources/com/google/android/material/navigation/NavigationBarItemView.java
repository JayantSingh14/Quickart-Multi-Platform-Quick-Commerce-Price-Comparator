package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.view.PointerIconCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.ripple.RippleUtils;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public abstract class NavigationBarItemView extends FrameLayout implements MenuView.ItemView {
    public static final int[] G = {R.attr.state_checked};
    public static final ActiveIndicatorTransform H = new ActiveIndicatorTransform();
    public static final ActiveIndicatorUnlabeledTransform I = new ActiveIndicatorUnlabeledTransform();
    public boolean A;
    public int B;
    public int C;
    public boolean D;
    public int E;
    public BadgeDrawable F;

    /* renamed from: a, reason: collision with root package name */
    public boolean f40700a;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f40701b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f40702c;

    /* renamed from: d, reason: collision with root package name */
    public int f40703d;

    /* renamed from: e, reason: collision with root package name */
    public int f40704e;

    /* renamed from: f, reason: collision with root package name */
    public int f40705f;

    /* renamed from: g, reason: collision with root package name */
    public float f40706g;

    /* renamed from: h, reason: collision with root package name */
    public float f40707h;

    /* renamed from: i, reason: collision with root package name */
    public float f40708i;

    /* renamed from: j, reason: collision with root package name */
    public int f40709j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f40710k;

    /* renamed from: l, reason: collision with root package name */
    public final FrameLayout f40711l;

    /* renamed from: m, reason: collision with root package name */
    public final View f40712m;
    public final ImageView n;
    public final ViewGroup o;
    public final TextView p;
    public final TextView q;
    public int r;
    public int s;
    public MenuItemImpl t;
    public ColorStateList u;
    public Drawable v;
    public Drawable w;
    public ValueAnimator x;
    public ActiveIndicatorTransform y;
    public float z;

    public static class ActiveIndicatorTransform {
        public float a(float f2, float f3) {
            return 1.0f;
        }
    }

    public static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        public final float a(float f2, float f3) {
            return AnimationUtils.a(0.4f, 1.0f, f2);
        }
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.f40700a = false;
        this.r = -1;
        this.s = 0;
        this.y = H;
        this.z = 0.0f;
        this.A = false;
        this.B = 0;
        this.C = 0;
        this.D = false;
        this.E = 0;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.f40711l = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.f40712m = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        ImageView imageView = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        this.n = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.o = viewGroup;
        TextView textView = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.p = textView;
        TextView textView2 = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        this.q = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f40703d = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.f40704e = viewGroup.getPaddingBottom();
        this.f40705f = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_item_active_indicator_label_padding);
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        textView.setImportantForAccessibility(2);
        textView2.setImportantForAccessibility(2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.google.android.material.navigation.NavigationBarItemView.1
                @Override // android.view.View.OnLayoutChangeListener
                public final void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                    BadgeDrawable badgeDrawable;
                    NavigationBarItemView navigationBarItemView = NavigationBarItemView.this;
                    ImageView imageView2 = navigationBarItemView.n;
                    if (imageView2.getVisibility() != 0 || (badgeDrawable = navigationBarItemView.F) == null) {
                        return;
                    }
                    Rect rect = new Rect();
                    imageView2.getDrawingRect(rect);
                    badgeDrawable.setBounds(rect);
                    badgeDrawable.i(imageView2, null);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(android.widget.TextView r4, int r5) throws android.content.res.Resources.NotFoundException {
        /*
            r4.setTextAppearance(r5)
            android.content.Context r0 = r4.getContext()
            r1 = 0
            if (r5 != 0) goto Lb
            goto L21
        Lb:
            int[] r2 = com.google.android.material.R.styleable.TextAppearance
            android.content.res.TypedArray r5 = r0.obtainStyledAttributes(r5, r2)
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            int r3 = com.google.android.material.R.styleable.TextAppearance_android_textSize
            boolean r3 = r5.getValue(r3, r2)
            r5.recycle()
            if (r3 != 0) goto L23
        L21:
            r5 = r1
            goto L4e
        L23:
            int r5 = r2.getComplexUnit()
            r3 = 2
            if (r5 != r3) goto L40
            int r5 = r2.data
            float r5 = android.util.TypedValue.complexToFloat(r5)
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            float r0 = r0.density
            float r5 = r5 * r0
            int r5 = java.lang.Math.round(r5)
            goto L4e
        L40:
            int r5 = r2.data
            android.content.res.Resources r0 = r0.getResources()
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()
            int r5 = android.util.TypedValue.complexToDimensionPixelSize(r5, r0)
        L4e:
            if (r5 == 0) goto L54
            float r5 = (float) r5
            r4.setTextSize(r1, r5)
        L54:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarItemView.f(android.widget.TextView, int):void");
    }

    public static void g(float f2, float f3, int i2, View view) {
        view.setScaleX(f2);
        view.setScaleY(f3);
        view.setVisibility(i2);
    }

    private View getIconOrContainer() {
        FrameLayout frameLayout = this.f40711l;
        return frameLayout != null ? frameLayout : this.n;
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int iIndexOfChild = viewGroup.indexOfChild(this);
        int i2 = 0;
        for (int i3 = 0; i3 < iIndexOfChild; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i2++;
            }
        }
        return i2;
    }

    private int getSuggestedIconHeight() {
        return getIconOrContainer().getMeasuredHeight() + ((FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams()).topMargin;
    }

    private int getSuggestedIconWidth() {
        BadgeDrawable badgeDrawable = this.F;
        int minimumWidth = badgeDrawable == null ? 0 : badgeDrawable.getMinimumWidth() - this.F.f39917e.f39927b.w.intValue();
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getIconOrContainer().getLayoutParams();
        return Math.max(minimumWidth, layoutParams.rightMargin) + this.n.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.leftMargin);
    }

    public static void h(View view, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i2;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    public static void j(int i2, View view) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i2);
    }

    public final void a(float f2, float f3) {
        this.f40706g = f2 - f3;
        this.f40707h = (f3 * 1.0f) / f2;
        this.f40708i = (f2 * 1.0f) / f3;
    }

    public final void b() {
        MenuItemImpl menuItemImpl = this.t;
        if (menuItemImpl != null) {
            setChecked(menuItemImpl.isChecked());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public final void c(MenuItemImpl menuItemImpl) {
        this.t = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.f623e);
        setId(menuItemImpl.f619a);
        if (!TextUtils.isEmpty(menuItemImpl.q)) {
            setContentDescription(menuItemImpl.q);
        }
        TooltipCompat.a(this, !TextUtils.isEmpty(menuItemImpl.r) ? menuItemImpl.r : menuItemImpl.f623e);
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        this.f40700a = true;
    }

    public final void d() {
        Drawable rippleDrawable = this.f40702c;
        ColorStateList colorStateList = this.f40701b;
        FrameLayout frameLayout = this.f40711l;
        RippleDrawable rippleDrawable2 = null;
        boolean z = true;
        if (colorStateList != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.A && getActiveIndicatorDrawable() != null && frameLayout != null && activeIndicatorDrawable != null) {
                rippleDrawable2 = new RippleDrawable(RippleUtils.c(this.f40701b), null, activeIndicatorDrawable);
                z = false;
            } else if (rippleDrawable == null) {
                rippleDrawable = new RippleDrawable(RippleUtils.a(this.f40701b), null, null);
            }
        }
        if (frameLayout != null) {
            frameLayout.setPadding(0, 0, 0, 0);
            frameLayout.setForeground(rippleDrawable2);
        }
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        setBackground(rippleDrawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        FrameLayout frameLayout = this.f40711l;
        if (frameLayout != null && this.A) {
            frameLayout.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void e(float f2, float f3) {
        View view = this.f40712m;
        if (view != null) {
            ActiveIndicatorTransform activeIndicatorTransform = this.y;
            activeIndicatorTransform.getClass();
            view.setScaleX(AnimationUtils.a(0.4f, 1.0f, f2));
            view.setScaleY(activeIndicatorTransform.a(f2, f3));
            view.setAlpha(AnimationUtils.b(0.0f, 1.0f, f3 == 0.0f ? 0.8f : 0.0f, f3 == 0.0f ? 1.0f : 0.2f, f2));
        }
        this.z = f2;
    }

    @Nullable
    public Drawable getActiveIndicatorDrawable() {
        View view = this.f40712m;
        if (view == null) {
            return null;
        }
        return view.getBackground();
    }

    @Nullable
    public BadgeDrawable getBadge() {
        return this.F;
    }

    @DrawableRes
    public int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    @Nullable
    public MenuItemImpl getItemData() {
        return this.t;
    }

    @DimenRes
    public int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    @LayoutRes
    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.r;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.o;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + (viewGroup.getVisibility() == 0 ? this.f40705f : 0) + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.o;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    public final void i(int i2) {
        View view = this.f40712m;
        if (view == null || i2 <= 0) {
            return;
        }
        int iMin = Math.min(this.B, i2 - (this.E * 2));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.height = (this.D && this.f40709j == 2) ? iMin : this.C;
        layoutParams.width = iMin;
        view.setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i2) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        MenuItemImpl menuItemImpl = this.t;
        if (menuItemImpl != null && menuItemImpl.isCheckable() && this.t.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, G);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        BadgeDrawable badgeDrawable = this.F;
        if (badgeDrawable != null && badgeDrawable.isVisible()) {
            MenuItemImpl menuItemImpl = this.t;
            CharSequence charSequence = menuItemImpl.f623e;
            if (!TextUtils.isEmpty(menuItemImpl.q)) {
                charSequence = this.t.q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.F.c()));
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
        accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            accessibilityNodeInfoCompat.n(false);
            accessibilityNodeInfoCompat.j(AccessibilityNodeInfoCompat.AccessibilityActionCompat.f3189g);
        }
        accessibilityNodeInfoCompat.t(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // android.view.View
    public final void onSizeChanged(final int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new Runnable() { // from class: com.google.android.material.navigation.NavigationBarItemView.2
            @Override // java.lang.Runnable
            public final void run() {
                int[] iArr = NavigationBarItemView.G;
                NavigationBarItemView.this.i(i2);
            }
        });
    }

    public void setActiveIndicatorDrawable(@Nullable Drawable drawable) {
        View view = this.f40712m;
        if (view == null) {
            return;
        }
        view.setBackgroundDrawable(drawable);
        d();
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.A = z;
        d();
        View view = this.f40712m;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
            requestLayout();
        }
    }

    public void setActiveIndicatorHeight(int i2) {
        this.C = i2;
        i(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i2) {
        if (this.f40705f != i2) {
            this.f40705f = i2;
            b();
        }
    }

    public void setActiveIndicatorMarginHorizontal(@Px int i2) {
        this.E = i2;
        i(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.D = z;
    }

    public void setActiveIndicatorWidth(int i2) {
        this.B = i2;
        i(getWidth());
    }

    public void setBadge(@NonNull BadgeDrawable badgeDrawable) {
        BadgeDrawable badgeDrawable2 = this.F;
        if (badgeDrawable2 == badgeDrawable) {
            return;
        }
        boolean z = badgeDrawable2 != null;
        ImageView imageView = this.n;
        if (z && imageView != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            if (this.F != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeDrawable badgeDrawable3 = this.F;
                if (badgeDrawable3 != null) {
                    if (badgeDrawable3.d() != null) {
                        badgeDrawable3.d().setForeground(null);
                    } else {
                        imageView.getOverlay().remove(badgeDrawable3);
                    }
                }
                this.F = null;
            }
        }
        this.F = badgeDrawable;
        if (imageView == null || badgeDrawable == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        BadgeDrawable badgeDrawable4 = this.F;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        badgeDrawable4.setBounds(rect);
        badgeDrawable4.i(imageView, null);
        if (badgeDrawable4.d() != null) {
            badgeDrawable4.d().setForeground(badgeDrawable4);
        } else {
            imageView.getOverlay().add(badgeDrawable4);
        }
    }

    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setChecked(boolean r13) {
        /*
            Method dump skipped, instructions count: 374
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarItemView.setChecked(boolean):void");
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.p.setEnabled(z);
        this.q.setEnabled(z);
        this.n.setEnabled(z);
        if (z) {
            ViewCompat.I(this, new PointerIconCompat(PointerIcon.getSystemIcon(getContext(), 1002)));
        } else {
            ViewCompat.I(this, null);
        }
    }

    public void setIcon(@Nullable Drawable drawable) {
        if (drawable == this.v) {
            return;
        }
        this.v = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.w = drawable;
            ColorStateList colorStateList = this.u;
            if (colorStateList != null) {
                drawable.setTintList(colorStateList);
            }
        }
        this.n.setImageDrawable(drawable);
    }

    public void setIconSize(int i2) {
        ImageView imageView = this.n;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i2;
        layoutParams.height = i2;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(@Nullable ColorStateList colorStateList) {
        Drawable drawable;
        this.u = colorStateList;
        if (this.t == null || (drawable = this.w) == null) {
            return;
        }
        drawable.setTintList(colorStateList);
        this.w.invalidateSelf();
    }

    public void setItemBackground(int i2) {
        setItemBackground(i2 == 0 ? null : getContext().getDrawable(i2));
    }

    public void setItemPaddingBottom(int i2) {
        if (this.f40704e != i2) {
            this.f40704e = i2;
            b();
        }
    }

    public void setItemPaddingTop(int i2) {
        if (this.f40703d != i2) {
            this.f40703d = i2;
            b();
        }
    }

    public void setItemPosition(int i2) {
        this.r = i2;
    }

    public void setItemRippleColor(@Nullable ColorStateList colorStateList) {
        this.f40701b = colorStateList;
        d();
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f40709j != i2) {
            this.f40709j = i2;
            if (this.D && i2 == 2) {
                this.y = I;
            } else {
                this.y = H;
            }
            i(getWidth());
            b();
        }
    }

    public void setShifting(boolean z) {
        if (this.f40710k != z) {
            this.f40710k = z;
            b();
        }
    }

    public void setTextAppearanceActive(@StyleRes int i2) throws Resources.NotFoundException {
        this.s = i2;
        TextView textView = this.q;
        f(textView, i2);
        a(this.p.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) throws Resources.NotFoundException {
        setTextAppearanceActive(this.s);
        TextView textView = this.q;
        textView.setTypeface(textView.getTypeface(), z ? 1 : 0);
    }

    public void setTextAppearanceInactive(@StyleRes int i2) throws Resources.NotFoundException {
        TextView textView = this.p;
        f(textView, i2);
        a(textView.getTextSize(), this.q.getTextSize());
    }

    public void setTextColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.p.setTextColor(colorStateList);
            this.q.setTextColor(colorStateList);
        }
    }

    public void setTitle(@Nullable CharSequence charSequence) {
        this.p.setText(charSequence);
        this.q.setText(charSequence);
        MenuItemImpl menuItemImpl = this.t;
        if (menuItemImpl == null || TextUtils.isEmpty(menuItemImpl.q)) {
            setContentDescription(charSequence);
        }
        MenuItemImpl menuItemImpl2 = this.t;
        if (menuItemImpl2 != null && !TextUtils.isEmpty(menuItemImpl2.r)) {
            charSequence = this.t.r;
        }
        TooltipCompat.a(this, charSequence);
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.f40702c = drawable;
        d();
    }
}
