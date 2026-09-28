package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.ExpandedActionViewMenuPresenter;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

@RestrictTo
/* loaded from: classes3.dex */
public class ToolbarWidgetWrapper implements DecorToolbar {

    /* renamed from: a, reason: collision with root package name */
    public final Toolbar f1223a;

    /* renamed from: b, reason: collision with root package name */
    public int f1224b;

    /* renamed from: c, reason: collision with root package name */
    public final View f1225c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f1226d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f1227e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f1228f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1229g;

    /* renamed from: h, reason: collision with root package name */
    public CharSequence f1230h;

    /* renamed from: i, reason: collision with root package name */
    public final CharSequence f1231i;

    /* renamed from: j, reason: collision with root package name */
    public final CharSequence f1232j;

    /* renamed from: k, reason: collision with root package name */
    public Window.Callback f1233k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f1234l;

    /* renamed from: m, reason: collision with root package name */
    public ActionMenuPresenter f1235m;
    public final int n;
    public final Drawable o;

    public ToolbarWidgetWrapper(Toolbar toolbar, boolean z) {
        int i2;
        Drawable drawable;
        int i3 = R.string.abc_action_bar_up_description;
        this.n = 0;
        this.f1223a = toolbar;
        this.f1230h = toolbar.getTitle();
        this.f1231i = toolbar.getSubtitle();
        this.f1229g = this.f1230h != null;
        this.f1228f = toolbar.getNavigationIcon();
        TintTypedArray tintTypedArrayF = TintTypedArray.f(toolbar.getContext(), null, R.styleable.ActionBar, R.attr.actionBarStyle);
        this.o = tintTypedArrayF.b(R.styleable.ActionBar_homeAsUpIndicator);
        if (z) {
            int i4 = R.styleable.ActionBar_title;
            TypedArray typedArray = tintTypedArrayF.f1185b;
            CharSequence text = typedArray.getText(i4);
            if (!TextUtils.isEmpty(text)) {
                setTitle(text);
            }
            CharSequence text2 = typedArray.getText(R.styleable.ActionBar_subtitle);
            if (!TextUtils.isEmpty(text2)) {
                this.f1231i = text2;
                if ((this.f1224b & 8) != 0) {
                    toolbar.setSubtitle(text2);
                }
            }
            Drawable drawableB = tintTypedArrayF.b(R.styleable.ActionBar_logo);
            if (drawableB != null) {
                this.f1227e = drawableB;
                u();
            }
            Drawable drawableB2 = tintTypedArrayF.b(R.styleable.ActionBar_icon);
            if (drawableB2 != null) {
                setIcon(drawableB2);
            }
            if (this.f1228f == null && (drawable = this.o) != null) {
                s(drawable);
            }
            i(typedArray.getInt(R.styleable.ActionBar_displayOptions, 0));
            int resourceId = typedArray.getResourceId(R.styleable.ActionBar_customNavigationLayout, 0);
            if (resourceId != 0) {
                View viewInflate = LayoutInflater.from(toolbar.getContext()).inflate(resourceId, (ViewGroup) toolbar, false);
                View view = this.f1225c;
                if (view != null && (this.f1224b & 16) != 0) {
                    toolbar.removeView(view);
                }
                this.f1225c = viewInflate;
                if (viewInflate != null && (this.f1224b & 16) != 0) {
                    toolbar.addView(viewInflate);
                }
                i(this.f1224b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(R.styleable.ActionBar_height, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = toolbar.getLayoutParams();
                layoutParams.height = layoutDimension;
                toolbar.setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetStart, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(R.styleable.ActionBar_contentInsetEnd, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                toolbar.v(Math.max(dimensionPixelOffset, 0), Math.max(dimensionPixelOffset2, 0));
            }
            int resourceId2 = typedArray.getResourceId(R.styleable.ActionBar_titleTextStyle, 0);
            if (resourceId2 != 0) {
                Context context = toolbar.getContext();
                toolbar.f1198l = resourceId2;
                AppCompatTextView appCompatTextView = toolbar.f1188b;
                if (appCompatTextView != null) {
                    appCompatTextView.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(R.styleable.ActionBar_subtitleTextStyle, 0);
            if (resourceId3 != 0) {
                Context context2 = toolbar.getContext();
                toolbar.f1199m = resourceId3;
                AppCompatTextView appCompatTextView2 = toolbar.f1189c;
                if (appCompatTextView2 != null) {
                    appCompatTextView2.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(R.styleable.ActionBar_popupTheme, 0);
            if (resourceId4 != 0) {
                toolbar.setPopupTheme(resourceId4);
            }
        } else {
            if (toolbar.getNavigationIcon() != null) {
                this.o = toolbar.getNavigationIcon();
                i2 = 15;
            } else {
                i2 = 11;
            }
            this.f1224b = i2;
        }
        tintTypedArrayF.g();
        if (i3 != this.n) {
            this.n = i3;
            if (TextUtils.isEmpty(toolbar.getNavigationContentDescription())) {
                int i5 = this.n;
                this.f1232j = i5 != 0 ? this.f1223a.getContext().getString(i5) : null;
                t();
            }
        }
        this.f1232j = toolbar.getNavigationContentDescription();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.1

            /* renamed from: a, reason: collision with root package name */
            public final ActionMenuItem f1236a;

            {
                Context context3 = ToolbarWidgetWrapper.this.f1223a.getContext();
                CharSequence charSequence = ToolbarWidgetWrapper.this.f1230h;
                ActionMenuItem actionMenuItem = new ActionMenuItem();
                actionMenuItem.f523e = 4096;
                actionMenuItem.f525g = 4096;
                actionMenuItem.f530l = null;
                actionMenuItem.f531m = null;
                actionMenuItem.n = false;
                actionMenuItem.o = false;
                actionMenuItem.p = 16;
                actionMenuItem.f527i = context3;
                actionMenuItem.f519a = charSequence;
                this.f1236a = actionMenuItem;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ToolbarWidgetWrapper toolbarWidgetWrapper = ToolbarWidgetWrapper.this;
                Window.Callback callback = toolbarWidgetWrapper.f1233k;
                if (callback == null || !toolbarWidgetWrapper.f1234l) {
                    return;
                }
                callback.onMenuItemSelected(0, this.f1236a);
            }
        });
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean a() {
        ActionMenuView actionMenuView;
        Toolbar toolbar = this.f1223a;
        return toolbar.getVisibility() == 0 && (actionMenuView = toolbar.f1187a) != null && actionMenuView.s;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void b(MenuBuilder menuBuilder, MenuPresenter.Callback callback) {
        ActionMenuPresenter actionMenuPresenter = this.f1235m;
        Toolbar toolbar = this.f1223a;
        if (actionMenuPresenter == null) {
            ActionMenuPresenter actionMenuPresenter2 = new ActionMenuPresenter(toolbar.getContext());
            this.f1235m = actionMenuPresenter2;
            actionMenuPresenter2.f547i = R.id.action_menu_presenter;
        }
        ActionMenuPresenter actionMenuPresenter3 = this.f1235m;
        actionMenuPresenter3.f543e = callback;
        if (menuBuilder == null && toolbar.f1187a == null) {
            return;
        }
        toolbar.f();
        MenuBuilder menuBuilder2 = toolbar.f1187a.p;
        if (menuBuilder2 == menuBuilder) {
            return;
        }
        if (menuBuilder2 != null) {
            menuBuilder2.s(toolbar.L);
            menuBuilder2.s(toolbar.M);
        }
        if (toolbar.M == null) {
            toolbar.M = toolbar.new ExpandedActionViewMenuPresenter();
        }
        actionMenuPresenter3.r = true;
        if (menuBuilder != null) {
            menuBuilder.c(actionMenuPresenter3, toolbar.f1196j);
            menuBuilder.c(toolbar.M, toolbar.f1196j);
        } else {
            actionMenuPresenter3.l(toolbar.f1196j, null);
            toolbar.M.l(toolbar.f1196j, null);
            actionMenuPresenter3.j(true);
            toolbar.M.j(true);
        }
        toolbar.f1187a.setPopupTheme(toolbar.f1197k);
        toolbar.f1187a.setPresenter(actionMenuPresenter3);
        toolbar.L = actionMenuPresenter3;
        toolbar.y();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean c() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f1223a.f1187a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null || !actionMenuPresenter.o()) ? false : true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void collapseActionView() {
        Toolbar.ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.f1223a.M;
        MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.f1205b;
        if (menuItemImpl != null) {
            menuItemImpl.collapseActionView();
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean d() {
        return this.f1223a.x();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean e() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f1223a.f1187a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null || !actionMenuPresenter.p()) ? false : true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void f() {
        this.f1234l = true;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean g() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f1223a.f1187a;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null) {
            return false;
        }
        return actionMenuPresenter.v != null || actionMenuPresenter.p();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final Context getContext() {
        return this.f1223a.getContext();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final CharSequence getTitle() {
        return this.f1223a.getTitle();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final boolean h() {
        return this.f1223a.m();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void i(int i2) {
        View view;
        int i3 = this.f1224b ^ i2;
        this.f1224b = i2;
        if (i3 != 0) {
            if ((i3 & 4) != 0) {
                if ((i2 & 4) != 0) {
                    t();
                }
                int i4 = this.f1224b & 4;
                Toolbar toolbar = this.f1223a;
                if (i4 != 0) {
                    Drawable drawable = this.f1228f;
                    if (drawable == null) {
                        drawable = this.o;
                    }
                    toolbar.setNavigationIcon(drawable);
                } else {
                    toolbar.setNavigationIcon((Drawable) null);
                }
            }
            if ((i3 & 3) != 0) {
                u();
            }
            int i5 = i3 & 8;
            Toolbar toolbar2 = this.f1223a;
            if (i5 != 0) {
                if ((i2 & 8) != 0) {
                    toolbar2.setTitle(this.f1230h);
                    toolbar2.setSubtitle(this.f1231i);
                } else {
                    toolbar2.setTitle((CharSequence) null);
                    toolbar2.setSubtitle((CharSequence) null);
                }
            }
            if ((i3 & 16) == 0 || (view = this.f1225c) == null) {
                return;
            }
            if ((i2 & 16) != 0) {
                toolbar2.addView(view);
            } else {
                toolbar2.removeView(view);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final int j() {
        return 0;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final ViewPropertyAnimatorCompat k(final int i2, long j2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA = ViewCompat.a(this.f1223a);
        viewPropertyAnimatorCompatA.a(i2 == 0 ? 1.0f : 0.0f);
        viewPropertyAnimatorCompatA.c(j2);
        viewPropertyAnimatorCompatA.d(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.widget.ToolbarWidgetWrapper.2

            /* renamed from: c, reason: collision with root package name */
            public boolean f1238c = false;

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationCancel(View view) {
                this.f1238c = true;
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationEnd(View view) {
                if (this.f1238c) {
                    return;
                }
                ToolbarWidgetWrapper.this.f1223a.setVisibility(i2);
            }

            @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
            public final void onAnimationStart(View view) {
                ToolbarWidgetWrapper.this.f1223a.setVisibility(0);
            }
        });
        return viewPropertyAnimatorCompatA;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void l() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void m(boolean z) {
        this.f1223a.setCollapsible(z);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void n() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f1223a.f1187a;
        if (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null) {
            return;
        }
        actionMenuPresenter.o();
        ActionMenuPresenter.ActionButtonSubmenu actionButtonSubmenu = actionMenuPresenter.u;
        if (actionButtonSubmenu == null || !actionButtonSubmenu.b()) {
            return;
        }
        actionButtonSubmenu.f652i.dismiss();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void p(int i2) {
        this.f1227e = i2 != 0 ? AppCompatResources.b(i2, this.f1223a.getContext()) : null;
        u();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final int q() {
        return this.f1224b;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void r() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void s(Drawable drawable) {
        this.f1228f = drawable;
        int i2 = this.f1224b & 4;
        Toolbar toolbar = this.f1223a;
        if (i2 == 0) {
            toolbar.setNavigationIcon((Drawable) null);
            return;
        }
        if (drawable == null) {
            drawable = this.o;
        }
        toolbar.setNavigationIcon(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setIcon(int i2) {
        setIcon(i2 != 0 ? AppCompatResources.b(i2, this.f1223a.getContext()) : null);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setTitle(CharSequence charSequence) {
        this.f1229g = true;
        this.f1230h = charSequence;
        if ((this.f1224b & 8) != 0) {
            Toolbar toolbar = this.f1223a;
            toolbar.setTitle(charSequence);
            if (this.f1229g) {
                ViewCompat.B(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setVisibility(int i2) {
        this.f1223a.setVisibility(i2);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setWindowCallback(Window.Callback callback) {
        this.f1233k = callback;
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setWindowTitle(CharSequence charSequence) {
        if (this.f1229g) {
            return;
        }
        this.f1230h = charSequence;
        if ((this.f1224b & 8) != 0) {
            Toolbar toolbar = this.f1223a;
            toolbar.setTitle(charSequence);
            if (this.f1229g) {
                ViewCompat.B(toolbar.getRootView(), charSequence);
            }
        }
    }

    public final void t() {
        if ((this.f1224b & 4) != 0) {
            boolean zIsEmpty = TextUtils.isEmpty(this.f1232j);
            Toolbar toolbar = this.f1223a;
            if (zIsEmpty) {
                toolbar.setNavigationContentDescription(this.n);
            } else {
                toolbar.setNavigationContentDescription(this.f1232j);
            }
        }
    }

    public final void u() {
        Drawable drawable;
        int i2 = this.f1224b;
        if ((i2 & 2) == 0) {
            drawable = null;
        } else if ((i2 & 1) == 0 || (drawable = this.f1227e) == null) {
            drawable = this.f1226d;
        }
        this.f1223a.setLogo(drawable);
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void setIcon(Drawable drawable) {
        this.f1226d = drawable;
        u();
    }

    @Override // androidx.appcompat.widget.DecorToolbar
    public final void o() {
    }
}
