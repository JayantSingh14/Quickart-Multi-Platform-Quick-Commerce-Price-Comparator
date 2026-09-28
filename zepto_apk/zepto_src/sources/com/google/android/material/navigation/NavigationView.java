package com.google.android.material.navigation;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.activity.BackEventCompat;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.motion.b;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes4.dex */
public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    public static final int[] x = {R.attr.state_checked};
    public static final int[] y = {-16842910};
    public static final int z = com.google.android.material.R.style.Widget_Design_NavigationView;

    /* renamed from: h, reason: collision with root package name */
    public final NavigationMenu f40745h;

    /* renamed from: i, reason: collision with root package name */
    public final NavigationMenuPresenter f40746i;

    /* renamed from: j, reason: collision with root package name */
    public OnNavigationItemSelectedListener f40747j;

    /* renamed from: k, reason: collision with root package name */
    public final int f40748k;

    /* renamed from: l, reason: collision with root package name */
    public final int[] f40749l;

    /* renamed from: m, reason: collision with root package name */
    public SupportMenuInflater f40750m;
    public final ViewTreeObserver.OnGlobalLayoutListener n;
    public boolean o;
    public boolean p;
    public int q;
    public final boolean r;
    public final int s;
    public final ShapeableDelegate t;
    public final MaterialSideContainerBackHelper u;
    public final MaterialBackOrchestrator v;
    public final DrawerLayout.DrawerListener w;

    public interface OnNavigationItemSelectedListener {
        boolean a();
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public Bundle f40754c;

        /* renamed from: com.google.android.material.navigation.NavigationView$SavedState$1, reason: invalid class name */
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
            this.f40754c = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f40754c);
        }
    }

    public NavigationView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.navigationViewStyle);
    }

    private MenuInflater getMenuInflater() {
        if (this.f40750m == null) {
            this.f40750m = new SupportMenuInflater(getContext());
        }
        return this.f40750m;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void b() {
        k();
        this.u.b();
        if (!this.r || this.q == 0) {
            return;
        }
        this.q = 0;
        j(getWidth(), getHeight());
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void c(BackEventCompat backEventCompat) {
        k();
        this.u.f40671f = backEventCompat;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void d(BackEventCompat backEventCompat) {
        int i2 = ((DrawerLayout.LayoutParams) k().second).f4238a;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.u;
        if (materialSideContainerBackHelper.f40671f == null) {
            Log.w("MaterialBackHelper", "Must call startBackProgress() before updateBackProgress()");
        }
        BackEventCompat backEventCompat2 = materialSideContainerBackHelper.f40671f;
        materialSideContainerBackHelper.f40671f = backEventCompat;
        float f2 = backEventCompat.f120c;
        if (backEventCompat2 != null) {
            materialSideContainerBackHelper.d(f2, i2, backEventCompat.f121d == 0);
        }
        if (this.r) {
            this.q = AnimationUtils.c(materialSideContainerBackHelper.f40666a.getInterpolation(f2), 0, this.s);
            j(getWidth(), getHeight());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        ShapeableDelegate shapeableDelegate = this.t;
        if (shapeableDelegate.c()) {
            Path path = shapeableDelegate.f41083e;
            if (!path.isEmpty()) {
                canvas.save();
                canvas.clipPath(path);
                super.dispatchDraw(canvas);
                canvas.restore();
                return;
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public final void e() {
        int i2 = 1;
        Pair pairK = k();
        final DrawerLayout drawerLayout = (DrawerLayout) pairK.first;
        MaterialSideContainerBackHelper materialSideContainerBackHelper = this.u;
        BackEventCompat backEventCompat = materialSideContainerBackHelper.f40671f;
        materialSideContainerBackHelper.f40671f = null;
        if (backEventCompat == null || Build.VERSION.SDK_INT < 34) {
            drawerLayout.c(this, true);
            return;
        }
        int i3 = ((DrawerLayout.LayoutParams) pairK.second).f4238a;
        int i4 = DrawerLayoutUtils.f40697a;
        materialSideContainerBackHelper.c(backEventCompat, i3, new AnimatorListenerAdapter() { // from class: com.google.android.material.navigation.DrawerLayoutUtils.1

            /* renamed from: b */
            public final /* synthetic */ NavigationView f40699b;

            public AnonymousClass1(final NavigationView this) {
                navigationView = this;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public final void onAnimationEnd(Animator animator) {
                NavigationView navigationView = navigationView;
                DrawerLayout drawerLayout2 = drawerLayout;
                drawerLayout2.c(navigationView, false);
                drawerLayout2.setScrimColor(-1728053248);
            }
        }, new b(drawerLayout, i2));
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void g(WindowInsetsCompat windowInsetsCompat) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.getClass();
        int iJ = windowInsetsCompat.j();
        if (navigationMenuPresenter.z != iJ) {
            navigationMenuPresenter.z = iJ;
            int i2 = (navigationMenuPresenter.f40585b.getChildCount() <= 0 && navigationMenuPresenter.x) ? navigationMenuPresenter.z : 0;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.f40584a;
            navigationMenuView.setPadding(0, i2, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = navigationMenuPresenter.f40584a;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, windowInsetsCompat.g());
        ViewCompat.c(navigationMenuPresenter.f40585b, windowInsetsCompat);
    }

    @VisibleForTesting
    public MaterialSideContainerBackHelper getBackHelper() {
        return this.u;
    }

    @Nullable
    public MenuItem getCheckedItem() {
        return this.f40746i.a();
    }

    @Px
    public int getDividerInsetEnd() {
        return this.f40746i.t;
    }

    @Px
    public int getDividerInsetStart() {
        return this.f40746i.s;
    }

    public int getHeaderCount() {
        return this.f40746i.f40585b.getChildCount();
    }

    @Nullable
    public Drawable getItemBackground() {
        return this.f40746i.f40596m;
    }

    @Dimension
    public int getItemHorizontalPadding() {
        return this.f40746i.o;
    }

    @Dimension
    public int getItemIconPadding() {
        return this.f40746i.q;
    }

    @Nullable
    public ColorStateList getItemIconTintList() {
        return this.f40746i.f40595l;
    }

    public int getItemMaxLines() {
        return this.f40746i.y;
    }

    @Nullable
    public ColorStateList getItemTextColor() {
        return this.f40746i.f40594k;
    }

    @Px
    public int getItemVerticalPadding() {
        return this.f40746i.p;
    }

    @NonNull
    public Menu getMenu() {
        return this.f40745h;
    }

    @Px
    public int getSubheaderInsetEnd() {
        return this.f40746i.v;
    }

    @Px
    public int getSubheaderInsetStart() {
        return this.f40746i.u;
    }

    public final ColorStateList h(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListB = ContextCompat.b(typedValue.resourceId, getContext());
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = colorStateListB.getDefaultColor();
        int[] iArr = y;
        return new ColorStateList(new int[][]{iArr, x, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListB.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    public final InsetDrawable i(TintTypedArray tintTypedArray, ColorStateList colorStateList) {
        int i2 = com.google.android.material.R.styleable.NavigationView_itemShapeAppearance;
        TypedArray typedArray = tintTypedArray.f1185b;
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.a(getContext(), typedArray.getResourceId(i2, 0), typedArray.getResourceId(com.google.android.material.R.styleable.NavigationView_itemShapeAppearanceOverlay, 0)).a());
        materialShapeDrawable.m(colorStateList);
        return new InsetDrawable((Drawable) materialShapeDrawable, typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetStart, 0), typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetTop, 0), typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetEnd, 0), typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    public final void j(int i2, int i3) {
        if ((getParent() instanceof DrawerLayout) && (getLayoutParams() instanceof DrawerLayout.LayoutParams)) {
            if ((this.q > 0 || this.r) && (getBackground() instanceof MaterialShapeDrawable)) {
                int i4 = ((DrawerLayout.LayoutParams) getLayoutParams()).f4238a;
                WeakHashMap weakHashMap = ViewCompat.f3080a;
                boolean z2 = Gravity.getAbsoluteGravity(i4, getLayoutDirection()) == 3;
                MaterialShapeDrawable materialShapeDrawable = (MaterialShapeDrawable) getBackground();
                ShapeAppearanceModel.Builder builderG = materialShapeDrawable.f40974a.f40989a.g();
                builderG.c(this.q);
                if (z2) {
                    builderG.h(0.0f);
                    builderG.d(0.0f);
                } else {
                    builderG.k(0.0f);
                    builderG.e(0.0f);
                }
                ShapeAppearanceModel shapeAppearanceModelA = builderG.a();
                materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModelA);
                ShapeableDelegate shapeableDelegate = this.t;
                shapeableDelegate.f41081c = shapeAppearanceModelA;
                shapeableDelegate.d();
                shapeableDelegate.b(this);
                shapeableDelegate.f41082d = new RectF(0.0f, 0.0f, i2, i3);
                shapeableDelegate.d();
                shapeableDelegate.b(this);
                shapeableDelegate.f41080b = true;
                shapeableDelegate.b(this);
            }
        }
    }

    public final Pair k() {
        ViewParent parent = getParent();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if ((parent instanceof DrawerLayout) && (layoutParams instanceof DrawerLayout.LayoutParams)) {
            return new Pair((DrawerLayout) parent, (DrawerLayout.LayoutParams) layoutParams);
        }
        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.d(this);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            MaterialBackOrchestrator materialBackOrchestrator = this.v;
            if (materialBackOrchestrator.f40672a != null) {
                DrawerLayout drawerLayout = (DrawerLayout) parent;
                DrawerLayout.DrawerListener drawerListener = this.w;
                if (drawerListener == null) {
                    drawerLayout.getClass();
                } else {
                    ArrayList arrayList = drawerLayout.t;
                    if (arrayList != null) {
                        arrayList.remove(drawerListener);
                    }
                }
                drawerLayout.a(drawerListener);
                if (DrawerLayout.m(this)) {
                    materialBackOrchestrator.a(true);
                }
            }
        }
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.n);
        ViewParent parent = getParent();
        if (parent instanceof DrawerLayout) {
            DrawerLayout drawerLayout = (DrawerLayout) parent;
            DrawerLayout.DrawerListener drawerListener = this.w;
            if (drawerListener == null) {
                drawerLayout.getClass();
                return;
            }
            ArrayList arrayList = drawerLayout.t;
            if (arrayList == null) {
                return;
            }
            arrayList.remove(drawerListener);
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int i4 = this.f40748k;
        if (mode == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), i4), 1073741824);
        } else if (mode == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        super.onMeasure(i2, i3);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        this.f40745h.u(savedState.f40754c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f40754c = bundle;
        this.f40745h.w(bundle);
        return savedState;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        j(i2, i3);
    }

    public void setBottomInsetScrimEnabled(boolean z2) {
        this.p = z2;
    }

    public void setCheckedItem(@IdRes int i2) {
        MenuItem menuItemFindItem = this.f40745h.findItem(i2);
        if (menuItemFindItem != null) {
            this.f40746i.m((MenuItemImpl) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(@Px int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.t = i2;
        navigationMenuPresenter.j(false);
    }

    public void setDividerInsetStart(@Px int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.s = i2;
        navigationMenuPresenter.j(false);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        MaterialShapeUtils.b(this, f2);
    }

    @RestrictTo
    @VisibleForTesting
    public void setForceCompatClippingEnabled(boolean z2) {
        ShapeableDelegate shapeableDelegate = this.t;
        if (z2 != shapeableDelegate.f41079a) {
            shapeableDelegate.f41079a = z2;
            shapeableDelegate.b(this);
        }
    }

    public void setItemBackground(@Nullable Drawable drawable) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.f40596m = drawable;
        navigationMenuPresenter.j(false);
    }

    public void setItemBackgroundResource(@DrawableRes int i2) {
        setItemBackground(getContext().getDrawable(i2));
    }

    public void setItemHorizontalPadding(@Dimension int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.o = i2;
        navigationMenuPresenter.j(false);
    }

    public void setItemHorizontalPaddingResource(@DimenRes int i2) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.o = dimensionPixelSize;
        navigationMenuPresenter.j(false);
    }

    public void setItemIconPadding(@Dimension int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.q = i2;
        navigationMenuPresenter.j(false);
    }

    public void setItemIconPaddingResource(int i2) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.q = dimensionPixelSize;
        navigationMenuPresenter.j(false);
    }

    public void setItemIconSize(@Dimension int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        if (navigationMenuPresenter.r != i2) {
            navigationMenuPresenter.r = i2;
            navigationMenuPresenter.w = true;
            navigationMenuPresenter.j(false);
        }
    }

    public void setItemIconTintList(@Nullable ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.f40595l = colorStateList;
        navigationMenuPresenter.j(false);
    }

    public void setItemMaxLines(int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.y = i2;
        navigationMenuPresenter.j(false);
    }

    public void setItemTextAppearance(@StyleRes int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.f40592i = i2;
        navigationMenuPresenter.j(false);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.f40593j = z2;
        navigationMenuPresenter.j(false);
    }

    public void setItemTextColor(@Nullable ColorStateList colorStateList) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.f40594k = colorStateList;
        navigationMenuPresenter.j(false);
    }

    public void setItemVerticalPadding(@Px int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.p = i2;
        navigationMenuPresenter.j(false);
    }

    public void setItemVerticalPaddingResource(@DimenRes int i2) throws Resources.NotFoundException {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i2);
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.p = dimensionPixelSize;
        navigationMenuPresenter.j(false);
    }

    public void setNavigationItemSelectedListener(@Nullable OnNavigationItemSelectedListener onNavigationItemSelectedListener) {
        this.f40747j = onNavigationItemSelectedListener;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i2) {
        super.setOverScrollMode(i2);
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        if (navigationMenuPresenter != null) {
            navigationMenuPresenter.B = i2;
            NavigationMenuView navigationMenuView = navigationMenuPresenter.f40584a;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i2);
            }
        }
    }

    public void setSubheaderInsetEnd(@Px int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.v = i2;
        navigationMenuPresenter.j(false);
    }

    public void setSubheaderInsetStart(@Px int i2) {
        NavigationMenuPresenter navigationMenuPresenter = this.f40746i;
        navigationMenuPresenter.u = i2;
        navigationMenuPresenter.j(false);
    }

    public void setTopInsetScrimEnabled(boolean z2) {
        this.o = z2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0191 A[PHI: r15
      0x0191: PHI (r15v2 android.graphics.drawable.Drawable) = 
      (r15v1 android.graphics.drawable.Drawable)
      (r15v5 android.graphics.drawable.Drawable)
      (r15v1 android.graphics.drawable.Drawable)
     binds: [B:50:0x0153, B:56:0x0179, B:54:0x0163] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(@androidx.annotation.NonNull android.content.Context r18, @androidx.annotation.Nullable android.util.AttributeSet r19, int r20) {
        /*
            Method dump skipped, instructions count: 693
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(@NonNull MenuItem menuItem) {
        MenuItem menuItemFindItem = this.f40745h.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.f40746i.m((MenuItemImpl) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
