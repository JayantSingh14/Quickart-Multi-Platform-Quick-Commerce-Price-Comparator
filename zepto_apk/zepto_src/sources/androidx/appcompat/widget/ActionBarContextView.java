package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.AbsActionBarView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

@RestrictTo
/* loaded from: classes3.dex */
public class ActionBarContextView extends AbsActionBarView {

    /* renamed from: i, reason: collision with root package name */
    public CharSequence f694i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f695j;

    /* renamed from: k, reason: collision with root package name */
    public View f696k;

    /* renamed from: l, reason: collision with root package name */
    public View f697l;

    /* renamed from: m, reason: collision with root package name */
    public View f698m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public final int q;
    public final int r;
    public boolean s;
    public final int t;

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public final void e(final ActionMode actionMode) {
        View view = this.f696k;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.t, (ViewGroup) this, false);
            this.f696k = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.f696k);
        }
        View viewFindViewById = this.f696k.findViewById(R.id.action_mode_close_button);
        this.f697l = viewFindViewById;
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ActionBarContextView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                actionMode.c();
            }
        });
        MenuBuilder menuBuilderE = actionMode.e();
        ActionMenuPresenter actionMenuPresenter = this.f675d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.o();
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = actionMenuPresenter.u;
            if (actionButtonSubmenu != null && actionButtonSubmenu.b()) {
                actionButtonSubmenu.f652i.dismiss();
            }
        }
        ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(getContext());
        this.f675d = actionMenuPresenter2;
        actionMenuPresenter2.f719m = true;
        actionMenuPresenter2.n = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        menuBuilderE.c(this.f675d, this.f673b);
        ActionMenuPresenter actionMenuPresenter3 = this.f675d;
        MenuView menuView = actionMenuPresenter3.f546h;
        if (menuView == null) {
            MenuView menuView2 = (MenuView) actionMenuPresenter3.f542d.inflate(actionMenuPresenter3.f544f, (ViewGroup) this, false);
            actionMenuPresenter3.f546h = menuView2;
            menuView2.a(actionMenuPresenter3.f541c);
            actionMenuPresenter3.j(true);
        }
        MenuView menuView3 = actionMenuPresenter3.f546h;
        if (menuView != menuView3) {
            ((ActionMenuView) menuView3).setPresenter(actionMenuPresenter3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) menuView3;
        this.f674c = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f674c, layoutParams);
    }

    public final void f() {
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.n = linearLayout;
            this.o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.p = (TextView) this.n.findViewById(R.id.action_bar_subtitle);
            int i2 = this.q;
            if (i2 != 0) {
                this.o.setTextAppearance(getContext(), i2);
            }
            int i3 = this.r;
            if (i3 != 0) {
                this.p.setTextAppearance(getContext(), i3);
            }
        }
        this.o.setText(this.f694i);
        this.p.setText(this.f695j);
        boolean zIsEmpty = TextUtils.isEmpty(this.f694i);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.f695j);
        this.p.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.n.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    public final void g() {
        removeAllViews();
        this.f698m = null;
        this.f674c = null;
        this.f675d = null;
        View view = this.f697l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.f677f != null ? this.f672a.f681b : getVisibility();
    }

    public int getContentHeight() {
        return this.f676e;
    }

    public CharSequence getSubtitle() {
        return this.f695j;
    }

    public CharSequence getTitle() {
        return this.f694i;
    }

    public final ViewPropertyAnimatorCompat h(int i2, long j2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = this.f677f;
        if (viewPropertyAnimatorCompat != null) {
            viewPropertyAnimatorCompat.b();
        }
        AbsActionBarView.VisibilityAnimListener visibilityAnimListener = this.f672a;
        if (i2 != 0) {
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA = ViewCompat.a(this);
            viewPropertyAnimatorCompatA.a(0.0f);
            viewPropertyAnimatorCompatA.c(j2);
            AbsActionBarView.this.f677f = viewPropertyAnimatorCompatA;
            visibilityAnimListener.f681b = i2;
            viewPropertyAnimatorCompatA.d(visibilityAnimListener);
            return viewPropertyAnimatorCompatA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA2 = ViewCompat.a(this);
        viewPropertyAnimatorCompatA2.a(1.0f);
        viewPropertyAnimatorCompatA2.c(j2);
        AbsActionBarView.this.f677f = viewPropertyAnimatorCompatA2;
        visibilityAnimListener.f681b = i2;
        viewPropertyAnimatorCompatA2.d(visibilityAnimListener);
        return viewPropertyAnimatorCompatA2;
    }

    public final boolean i() {
        ActionMenuPresenter actionMenuPresenter = this.f675d;
        if (actionMenuPresenter != null) {
            return actionMenuPresenter.r();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ActionMenuPresenter actionMenuPresenter = this.f675d;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.o();
            ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = this.f675d.u;
            if (actionButtonSubmenu == null || !actionButtonSubmenu.b()) {
                return;
            }
            actionButtonSubmenu.f652i.dismiss();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2 = ViewUtils.f1266a;
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i4 - i2) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i5 - i3) - getPaddingTop()) - getPaddingBottom();
        View view = this.f696k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f696k.getLayoutParams();
            int i6 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i7 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i8 = z3 ? paddingRight - i6 : paddingRight + i6;
            int iD = i8 + AbsActionBarView.d(i8, paddingTop, paddingTop2, this.f696k, z3);
            paddingRight = z3 ? iD - i7 : iD + i7;
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.f698m == null && linearLayout.getVisibility() != 8) {
            paddingRight += AbsActionBarView.d(paddingRight, paddingTop, paddingTop2, this.n, z3);
        }
        View view2 = this.f698m;
        if (view2 != null) {
            AbsActionBarView.d(paddingRight, paddingTop, paddingTop2, view2, z3);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i4 - i2) - getPaddingRight();
        ActionMenuView actionMenuView = this.f674c;
        if (actionMenuView != null) {
            AbsActionBarView.d(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z3);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i2, int i3) {
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i3) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.f676e;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i3);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.f696k;
        if (view != null) {
            int iC = AbsActionBarView.c(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f696k.getLayoutParams();
            paddingLeft = iC - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f674c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = AbsActionBarView.c(this.f674c, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.f698m == null) {
            if (this.s) {
                this.n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.n.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.n.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = AbsActionBarView.c(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.f698m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i4 = layoutParams.width;
            int i5 = i4 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i4 >= 0) {
                paddingLeft = Math.min(i4, paddingLeft);
            }
            int i6 = layoutParams.height;
            int i7 = i6 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i6 >= 0) {
                iMin = Math.min(i6, iMin);
            }
            this.f698m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i5), View.MeasureSpec.makeMeasureSpec(iMin, i7));
        }
        if (this.f676e > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i8) {
                i8 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i8);
    }

    @Override // androidx.appcompat.widget.AbsActionBarView
    public void setContentHeight(int i2) {
        this.f676e = i2;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.f698m;
        if (view2 != null) {
            removeView(view2);
        }
        this.f698m = view;
        if (view != null && (linearLayout = this.n) != null) {
            removeView(linearLayout);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f695j = charSequence;
        f();
    }

    public void setTitle(CharSequence charSequence) {
        this.f694i = charSequence;
        f();
        ViewCompat.B(this, charSequence);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.s) {
            requestLayout();
        }
        this.s = z;
    }

    @Override // androidx.appcompat.widget.AbsActionBarView, android.view.View
    public /* bridge */ /* synthetic */ void setVisibility(int i2) {
        super.setVisibility(i2);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.actionModeStyle);
    }

    public ActionBarContextView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMode, i2, 0);
        TintTypedArray tintTypedArray = new TintTypedArray(context, typedArrayObtainStyledAttributes);
        setBackground(tintTypedArray.b(R.styleable.ActionMode_background));
        this.q = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionMode_titleTextStyle, 0);
        this.r = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionMode_subtitleTextStyle, 0);
        this.f676e = typedArrayObtainStyledAttributes.getLayoutDimension(R.styleable.ActionMode_height, 0);
        this.t = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ActionMode_closeItemLayout, R.layout.abc_action_mode_close_item_material);
        tintTypedArray.g();
    }
}
