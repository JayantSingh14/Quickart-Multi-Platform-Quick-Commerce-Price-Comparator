package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.DropDownListView;
import androidx.appcompat.widget.MenuPopupWindow;

/* loaded from: classes3.dex */
final class StandardMenuPopup extends MenuPopup implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, MenuPresenter, View.OnKeyListener {
    public static final int u = R.layout.abc_popup_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f657b;

    /* renamed from: c, reason: collision with root package name */
    public final MenuBuilder f658c;

    /* renamed from: d, reason: collision with root package name */
    public final MenuAdapter f659d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f660e;

    /* renamed from: f, reason: collision with root package name */
    public final int f661f;

    /* renamed from: g, reason: collision with root package name */
    public final int f662g;

    /* renamed from: h, reason: collision with root package name */
    public final MenuPopupWindow f663h;

    /* renamed from: k, reason: collision with root package name */
    public PopupWindow.OnDismissListener f666k;

    /* renamed from: l, reason: collision with root package name */
    public View f667l;

    /* renamed from: m, reason: collision with root package name */
    public View f668m;
    public MenuPresenter.Callback n;
    public ViewTreeObserver o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean t;

    /* renamed from: i, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f664i = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
            if (standardMenuPopup.b()) {
                MenuPopupWindow menuPopupWindow = standardMenuPopup.f663h;
                if (menuPopupWindow.y) {
                    return;
                }
                View view = standardMenuPopup.f668m;
                if (view == null || !view.isShown()) {
                    standardMenuPopup.dismiss();
                } else {
                    menuPopupWindow.a();
                }
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f665j = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.StandardMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            StandardMenuPopup standardMenuPopup = StandardMenuPopup.this;
            ViewTreeObserver viewTreeObserver = standardMenuPopup.o;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    standardMenuPopup.o = view.getViewTreeObserver();
                }
                standardMenuPopup.o.removeGlobalOnLayoutListener(standardMenuPopup.f664i);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };
    public int s = 0;

    public StandardMenuPopup(int i2, Context context, View view, MenuBuilder menuBuilder, boolean z) {
        this.f657b = context;
        this.f658c = menuBuilder;
        this.f660e = z;
        this.f659d = new MenuAdapter(menuBuilder, LayoutInflater.from(context), z, u);
        this.f662g = i2;
        Resources resources = context.getResources();
        this.f661f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f667l = view;
        this.f663h = new MenuPopupWindow(context, null, i2, 0);
        menuBuilder.c(this, context);
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void a() {
        View view;
        if (b()) {
            return;
        }
        if (this.p || (view = this.f667l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.f668m = view;
        MenuPopupWindow menuPopupWindow = this.f663h;
        menuPopupWindow.z.setOnDismissListener(this);
        menuPopupWindow.p = this;
        menuPopupWindow.y = true;
        menuPopupWindow.z.setFocusable(true);
        View view2 = this.f668m;
        boolean z = this.o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.o = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.f664i);
        }
        view2.addOnAttachStateChangeListener(this.f665j);
        menuPopupWindow.o = view2;
        menuPopupWindow.f1083l = this.s;
        boolean z2 = this.q;
        Context context = this.f657b;
        MenuAdapter menuAdapter = this.f659d;
        if (!z2) {
            this.r = MenuPopup.n(menuAdapter, context, this.f661f);
            this.q = true;
        }
        menuPopupWindow.r(this.r);
        menuPopupWindow.z.setInputMethodMode(2);
        Rect rect = this.f643a;
        menuPopupWindow.x = rect != null ? new Rect(rect) : null;
        menuPopupWindow.a();
        DropDownListView dropDownListView = menuPopupWindow.f1074c;
        dropDownListView.setOnKeyListener(this);
        if (this.t) {
            MenuBuilder menuBuilder = this.f658c;
            if (menuBuilder.f615m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) dropDownListView, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(menuBuilder.f615m);
                }
                frameLayout.setEnabled(false);
                dropDownListView.addHeaderView(frameLayout, null, false);
            }
        }
        menuPopupWindow.n(menuAdapter);
        menuPopupWindow.a();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean b() {
        return !this.p && this.f663h.z.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void c(MenuBuilder menuBuilder, boolean z) {
        if (menuBuilder != this.f658c) {
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.n;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void d(MenuPresenter.Callback callback) {
        this.n = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        if (b()) {
            this.f663h.dismiss();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void f(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean g(SubMenuBuilder subMenuBuilder) {
        if (subMenuBuilder.hasVisibleItems()) {
            View view = this.f668m;
            MenuPopupHelper menuPopupHelper = new MenuPopupHelper(this.f662g, this.f657b, view, subMenuBuilder, this.f660e);
            MenuPresenter.Callback callback = this.n;
            menuPopupHelper.f651h = callback;
            MenuPopup menuPopup = menuPopupHelper.f652i;
            if (menuPopup != null) {
                menuPopup.d(callback);
            }
            menuPopupHelper.d(MenuPopup.w(subMenuBuilder));
            menuPopupHelper.f653j = this.f666k;
            this.f666k = null;
            this.f658c.d(false);
            MenuPopupWindow menuPopupWindow = this.f663h;
            int width = menuPopupWindow.f1077f;
            int iL = menuPopupWindow.l();
            if ((Gravity.getAbsoluteGravity(this.s, this.f667l.getLayoutDirection()) & 7) == 5) {
                width += this.f667l.getWidth();
            }
            if (!menuPopupHelper.b()) {
                if (menuPopupHelper.f648e != null) {
                    menuPopupHelper.e(width, iL, true, true);
                }
            }
            MenuPresenter.Callback callback2 = this.n;
            if (callback2 != null) {
                callback2.d(subMenuBuilder);
            }
            return true;
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable h() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void j(boolean z) {
        this.q = false;
        MenuAdapter menuAdapter = this.f659d;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean k() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void m(MenuBuilder menuBuilder) {
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView o() {
        return this.f663h.f1074c;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.p = true;
        this.f658c.d(true);
        ViewTreeObserver viewTreeObserver = this.o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.o = this.f668m.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.f664i);
            this.o = null;
        }
        this.f668m.removeOnAttachStateChangeListener(this.f665j);
        PopupWindow.OnDismissListener onDismissListener = this.f666k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void p(View view) {
        this.f667l = view;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void q(boolean z) {
        this.f659d.f599c = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void r(int i2) {
        this.s = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void s(int i2) {
        this.f663h.f1077f = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.f666k = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void u(boolean z) {
        this.t = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void v(int i2) {
        this.f663h.i(i2);
    }
}
