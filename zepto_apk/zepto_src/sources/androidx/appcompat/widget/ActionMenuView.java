package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.gms.common.api.Api;

/* loaded from: classes3.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.ItemInvoker, MenuView {
    public OnMenuItemClickListener A;
    public MenuBuilder p;
    public Context q;
    public int r;
    public boolean s;
    public ActionMenuPresenter t;
    public MenuPresenter.Callback u;
    public MenuBuilder.Callback v;
    public boolean w;
    public int x;
    public final int y;
    public final int z;

    @RestrictTo
    public interface ActionMenuChildView {
        boolean a();

        boolean b();
    }

    public static class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void c(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean d(MenuBuilder menuBuilder) {
            return false;
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* renamed from: a, reason: collision with root package name */
        public boolean f729a;

        /* renamed from: b, reason: collision with root package name */
        public int f730b;

        /* renamed from: c, reason: collision with root package name */
        public int f731c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f732d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f733e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f734f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            OnMenuItemClickListener onMenuItemClickListener = ActionMenuView.this.A;
            return onMenuItemClickListener != null && onMenuItemClickListener.onMenuItemClick(menuItem);
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void b(MenuBuilder menuBuilder) {
            MenuBuilder.Callback callback = ActionMenuView.this.v;
            if (callback != null) {
                callback.b(menuBuilder);
            }
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public ActionMenuView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.y = (int) (56.0f * f2);
        this.z = (int) (f2 * 4.0f);
        this.q = context;
        this.r = 0;
    }

    public static LayoutParams l() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f729a = false;
        ((LinearLayout.LayoutParams) layoutParams).gravity = 16;
        return layoutParams;
    }

    public static LayoutParams m(ViewGroup.LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (layoutParams == null) {
            return l();
        }
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams3 = (LayoutParams) layoutParams;
            layoutParams2 = new LayoutParams(layoutParams3);
            layoutParams2.f729a = layoutParams3.f729a;
        } else {
            layoutParams2 = new LayoutParams(layoutParams);
        }
        if (((LinearLayout.LayoutParams) layoutParams2).gravity <= 0) {
            ((LinearLayout.LayoutParams) layoutParams2).gravity = 16;
        }
        return layoutParams2;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public final void a(MenuBuilder menuBuilder) {
        this.p = menuBuilder;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.ItemInvoker
    public final boolean d(MenuItemImpl menuItemImpl) {
        return this.p.r(menuItemImpl, null, 0);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public Menu getMenu() {
        if (this.p == null) {
            Context context = getContext();
            MenuBuilder menuBuilder = new MenuBuilder(context);
            this.p = menuBuilder;
            menuBuilder.f607e = new MenuBuilderCallback();
            ActionMenuPresenter actionMenuPresenter = new ActionMenuPresenter(context);
            this.t = actionMenuPresenter;
            actionMenuPresenter.f719m = true;
            actionMenuPresenter.n = true;
            MenuPresenter.Callback actionMenuPresenterCallback = this.u;
            if (actionMenuPresenterCallback == null) {
                actionMenuPresenterCallback = new ActionMenuPresenterCallback();
            }
            actionMenuPresenter.f543e = actionMenuPresenterCallback;
            this.p.c(actionMenuPresenter, this.q);
            ActionMenuPresenter actionMenuPresenter2 = this.t;
            actionMenuPresenter2.f546h = this;
            this.p = actionMenuPresenter2.f541c;
        }
        return this.p;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.t;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.f716j;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (actionMenuPresenter.f718l) {
            return actionMenuPresenter.f717k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.r;
    }

    @RestrictTo
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: h */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateDefaultLayoutParams() {
        return l();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: i */
    public final LinearLayoutCompat.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat
    /* renamed from: j */
    public final /* bridge */ /* synthetic */ LinearLayoutCompat.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return m(layoutParams);
    }

    public final boolean n(int i2) {
        boolean zA = false;
        if (i2 == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i2 - 1);
        KeyEvent.Callback childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof ActionMenuChildView)) {
            zA = ((ActionMenuChildView) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof ActionMenuChildView)) ? zA : ((ActionMenuChildView) childAt2).b() | zA;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ActionMenuPresenter actionMenuPresenter = this.t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.j(false);
            if (this.t.p()) {
                this.t.o();
                this.t.r();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.t;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.o();
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = actionMenuPresenter.u;
            if (actionButtonSubmenu == null || !actionButtonSubmenu.b()) {
                return;
            }
            actionButtonSubmenu.f652i.dismiss();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int width;
        int paddingLeft;
        if (!this.w) {
            super.onLayout(z, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i6 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i7 = i4 - i2;
        int paddingRight = (i7 - getPaddingRight()) - getPaddingLeft();
        boolean z2 = ViewUtils.f1266a;
        boolean z3 = getLayoutDirection() == 1;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f729a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (n(i10)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (z3) {
                        paddingLeft = getPaddingLeft() + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                        width = paddingLeft + measuredWidth;
                    } else {
                        width = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                        paddingLeft = width - measuredWidth;
                    }
                    int i11 = i6 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i11, width, measuredHeight + i11);
                    paddingRight -= measuredWidth;
                    i8 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams).leftMargin) + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    n(i10);
                    i9++;
                }
            }
        }
        if (childCount == 1 && i8 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i12 = (i7 / 2) - (measuredWidth2 / 2);
            int i13 = i6 - (measuredHeight2 / 2);
            childAt2.layout(i12, i13, measuredWidth2 + i12, measuredHeight2 + i13);
            return;
        }
        int i14 = i9 - (i8 ^ 1);
        int iMax = Math.max(0, i14 > 0 ? paddingRight / i14 : 0);
        if (z3) {
            int width2 = getWidth() - getPaddingRight();
            for (int i15 = 0; i15 < childCount; i15++) {
                View childAt3 = getChildAt(i15);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f729a) {
                    int i16 = width2 - ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i6 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth3, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth3 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin) + iMax);
                }
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        for (int i18 = 0; i18 < childCount; i18++) {
            View childAt4 = getChildAt(i18);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f729a) {
                int i19 = paddingLeft2 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i20 = i6 - (measuredHeight4 / 2);
                childAt4.layout(i19, i20, i19 + measuredWidth4, measuredHeight4 + i20);
                paddingLeft2 = android.support.v4.media.b.b(measuredWidth4, ((LinearLayout.LayoutParams) layoutParams3).rightMargin, iMax, i19);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r11v14 */
    /* JADX WARN: Type inference failed for: r11v15, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v40 */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        ?? r11;
        int i6;
        int i7;
        MenuBuilder menuBuilder;
        boolean z = this.w;
        boolean z2 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.w = z2;
        if (z != z2) {
            this.x = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (this.w && (menuBuilder = this.p) != null && size != this.x) {
            this.x = size;
            menuBuilder.q(true);
        }
        int childCount = getChildCount();
        if (!this.w || childCount <= 0) {
            for (int i8 = 0; i8 < childCount; i8++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i8).getLayoutParams();
                ((LinearLayout.LayoutParams) layoutParams).rightMargin = 0;
                ((LinearLayout.LayoutParams) layoutParams).leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
        int i9 = size2 - paddingRight;
        int i10 = this.y;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = (i12 / i11) + i10;
        int childCount2 = getChildCount();
        int iMax = 0;
        int i14 = 0;
        int iMax2 = 0;
        int i15 = 0;
        boolean z3 = false;
        int i16 = 0;
        long j2 = 0;
        while (true) {
            i4 = this.z;
            if (i15 >= childCount2) {
                break;
            }
            View childAt = getChildAt(i15);
            int i17 = size3;
            int i18 = paddingBottom;
            if (childAt.getVisibility() == 8) {
                i6 = i13;
            } else {
                boolean z4 = childAt instanceof ActionMenuItemView;
                i14++;
                if (z4) {
                    childAt.setPadding(i4, 0, i4, 0);
                }
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                layoutParams2.f734f = false;
                layoutParams2.f731c = 0;
                layoutParams2.f730b = 0;
                layoutParams2.f732d = false;
                ((LinearLayout.LayoutParams) layoutParams2).leftMargin = 0;
                ((LinearLayout.LayoutParams) layoutParams2).rightMargin = 0;
                layoutParams2.f733e = z4 && !TextUtils.isEmpty(((ActionMenuItemView) childAt).getText());
                int i19 = layoutParams2.f729a ? 1 : i11;
                LayoutParams layoutParams3 = (LayoutParams) childAt.getLayoutParams();
                int i20 = i11;
                i6 = i13;
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(childMeasureSpec) - i18, View.MeasureSpec.getMode(childMeasureSpec));
                ActionMenuItemView actionMenuItemView = z4 ? (ActionMenuItemView) childAt : null;
                boolean z5 = (actionMenuItemView == null || TextUtils.isEmpty(actionMenuItemView.getText())) ? false : true;
                boolean z6 = z5;
                if (i19 <= 0 || (z5 && i19 < 2)) {
                    i7 = 0;
                } else {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i6 * i19, Integer.MIN_VALUE), iMakeMeasureSpec);
                    int measuredWidth = childAt.getMeasuredWidth();
                    i7 = measuredWidth / i6;
                    if (measuredWidth % i6 != 0) {
                        i7++;
                    }
                    if (z6 && i7 < 2) {
                        i7 = 2;
                    }
                }
                layoutParams3.f732d = !layoutParams3.f729a && z6;
                layoutParams3.f730b = i7;
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i7 * i6, 1073741824), iMakeMeasureSpec);
                iMax2 = Math.max(iMax2, i7);
                if (layoutParams2.f732d) {
                    i16++;
                }
                if (layoutParams2.f729a) {
                    z3 = true;
                }
                i11 = i20 - i7;
                iMax = Math.max(iMax, childAt.getMeasuredHeight());
                if (i7 == 1) {
                    j2 |= 1 << i15;
                }
            }
            i15++;
            size3 = i17;
            paddingBottom = i18;
            i13 = i6;
        }
        int i21 = size3;
        int i22 = i11;
        int i23 = i13;
        boolean z7 = z3 && i14 == 2;
        int i24 = i22;
        boolean z8 = false;
        while (i16 > 0 && i24 > 0) {
            int i25 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            long j3 = 0;
            int i26 = 0;
            int i27 = 0;
            while (i27 < childCount2) {
                boolean z9 = z7;
                LayoutParams layoutParams4 = (LayoutParams) getChildAt(i27).getLayoutParams();
                int i28 = iMax;
                if (layoutParams4.f732d) {
                    int i29 = layoutParams4.f730b;
                    if (i29 < i25) {
                        j3 = 1 << i27;
                        i25 = i29;
                        i26 = 1;
                    } else if (i29 == i25) {
                        j3 |= 1 << i27;
                        i26++;
                    }
                }
                i27++;
                iMax = i28;
                z7 = z9;
            }
            boolean z10 = z7;
            i5 = iMax;
            j2 |= j3;
            if (i26 > i24) {
                break;
            }
            int i30 = i25 + 1;
            int i31 = 0;
            while (i31 < childCount2) {
                View childAt2 = getChildAt(i31);
                LayoutParams layoutParams5 = (LayoutParams) childAt2.getLayoutParams();
                boolean z11 = z3;
                long j4 = 1 << i31;
                if ((j3 & j4) != 0) {
                    if (z10 && layoutParams5.f733e) {
                        r11 = 1;
                        r11 = 1;
                        if (i24 == 1) {
                            childAt2.setPadding(i4 + i23, 0, i4, 0);
                        }
                    } else {
                        r11 = 1;
                    }
                    layoutParams5.f730b += r11;
                    layoutParams5.f734f = r11;
                    i24--;
                } else if (layoutParams5.f730b == i30) {
                    j2 |= j4;
                }
                i31++;
                z3 = z11;
            }
            iMax = i5;
            z7 = z10;
            z8 = true;
        }
        i5 = iMax;
        boolean z12 = !z3 && i14 == 1;
        if (i24 > 0 && j2 != 0 && (i24 < i14 - 1 || z12 || iMax2 > 1)) {
            float fBitCount = Long.bitCount(j2);
            if (!z12) {
                if ((j2 & 1) != 0 && !((LayoutParams) getChildAt(0).getLayoutParams()).f733e) {
                    fBitCount -= 0.5f;
                }
                int i32 = childCount2 - 1;
                if ((j2 & (1 << i32)) != 0 && !((LayoutParams) getChildAt(i32).getLayoutParams()).f733e) {
                    fBitCount -= 0.5f;
                }
            }
            int i33 = fBitCount > 0.0f ? (int) ((i24 * i23) / fBitCount) : 0;
            boolean z13 = z8;
            for (int i34 = 0; i34 < childCount2; i34++) {
                if ((j2 & (1 << i34)) != 0) {
                    View childAt3 = getChildAt(i34);
                    LayoutParams layoutParams6 = (LayoutParams) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        layoutParams6.f731c = i33;
                        layoutParams6.f734f = true;
                        if (i34 == 0 && !layoutParams6.f733e) {
                            ((LinearLayout.LayoutParams) layoutParams6).leftMargin = (-i33) / 2;
                        }
                        z13 = true;
                    } else if (layoutParams6.f729a) {
                        layoutParams6.f731c = i33;
                        layoutParams6.f734f = true;
                        ((LinearLayout.LayoutParams) layoutParams6).rightMargin = (-i33) / 2;
                        z13 = true;
                    } else {
                        if (i34 != 0) {
                            ((LinearLayout.LayoutParams) layoutParams6).leftMargin = i33 / 2;
                        }
                        if (i34 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) layoutParams6).rightMargin = i33 / 2;
                        }
                    }
                }
            }
            z8 = z13;
        }
        if (z8) {
            for (int i35 = 0; i35 < childCount2; i35++) {
                View childAt4 = getChildAt(i35);
                LayoutParams layoutParams7 = (LayoutParams) childAt4.getLayoutParams();
                if (layoutParams7.f734f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((layoutParams7.f730b * i23) + layoutParams7.f731c, 1073741824), childMeasureSpec);
                }
            }
        }
        setMeasuredDimension(i9, mode != 1073741824 ? i5 : i21);
    }

    @RestrictTo
    public void setExpandedActionViewsExclusive(boolean z) {
        this.t.r = z;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.A = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        getMenu();
        ActionMenuPresenter actionMenuPresenter = this.t;
        ActionMenuPresenter.OverflowMenuButton overflowMenuButton = actionMenuPresenter.f716j;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            actionMenuPresenter.f718l = true;
            actionMenuPresenter.f717k = drawable;
        }
    }

    @RestrictTo
    public void setOverflowReserved(boolean z) {
        this.s = z;
    }

    public void setPopupTheme(@StyleRes int i2) {
        if (this.r != i2) {
            this.r = i2;
            if (i2 == 0) {
                this.q = getContext();
            } else {
                this.q = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    @RestrictTo
    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.t = actionMenuPresenter;
        actionMenuPresenter.f546h = this;
        this.p = actionMenuPresenter.f541c;
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }
}
