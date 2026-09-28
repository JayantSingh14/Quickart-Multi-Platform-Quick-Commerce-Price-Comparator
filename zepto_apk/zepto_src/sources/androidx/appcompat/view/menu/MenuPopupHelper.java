package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;

@RestrictTo
/* loaded from: classes3.dex */
public class MenuPopupHelper implements MenuHelper {

    /* renamed from: a, reason: collision with root package name */
    public final Context f644a;

    /* renamed from: b, reason: collision with root package name */
    public final MenuBuilder f645b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f646c;

    /* renamed from: d, reason: collision with root package name */
    public final int f647d;

    /* renamed from: e, reason: collision with root package name */
    public View f648e;

    /* renamed from: g, reason: collision with root package name */
    public boolean f650g;

    /* renamed from: h, reason: collision with root package name */
    public MenuPresenter.Callback f651h;

    /* renamed from: i, reason: collision with root package name */
    public MenuPopup f652i;

    /* renamed from: j, reason: collision with root package name */
    public PopupWindow.OnDismissListener f653j;

    /* renamed from: f, reason: collision with root package name */
    public int f649f = 8388611;

    /* renamed from: k, reason: collision with root package name */
    public final PopupWindow.OnDismissListener f654k = new AnonymousClass1();

    /* renamed from: androidx.appcompat.view.menu.MenuPopupHelper$1, reason: invalid class name */
    public class AnonymousClass1 implements PopupWindow.OnDismissListener {
        public AnonymousClass1() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public final void onDismiss() {
            MenuPopupHelper.this.c();
        }
    }

    public MenuPopupHelper(int i2, Context context, View view, MenuBuilder menuBuilder, boolean z) {
        this.f644a = context;
        this.f645b = menuBuilder;
        this.f648e = view;
        this.f646c = z;
        this.f647d = i2;
    }

    public final MenuPopup a() {
        MenuPopup standardMenuPopup;
        if (this.f652i == null) {
            Context context = this.f644a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                standardMenuPopup = new CascadingMenuPopup(context, this.f648e, this.f647d, this.f646c);
            } else {
                View view = this.f648e;
                Context context2 = this.f644a;
                boolean z = this.f646c;
                standardMenuPopup = new StandardMenuPopup(this.f647d, context2, view, this.f645b, z);
            }
            standardMenuPopup.m(this.f645b);
            standardMenuPopup.t(this.f654k);
            standardMenuPopup.p(this.f648e);
            standardMenuPopup.d(this.f651h);
            standardMenuPopup.q(this.f650g);
            standardMenuPopup.r(this.f649f);
            this.f652i = standardMenuPopup;
        }
        return this.f652i;
    }

    public final boolean b() {
        MenuPopup menuPopup = this.f652i;
        return menuPopup != null && menuPopup.b();
    }

    public void c() {
        this.f652i = null;
        PopupWindow.OnDismissListener onDismissListener = this.f653j;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public final void d(boolean z) {
        this.f650g = z;
        MenuPopup menuPopup = this.f652i;
        if (menuPopup != null) {
            menuPopup.q(z);
        }
    }

    public final void e(int i2, int i3, boolean z, boolean z2) {
        MenuPopup menuPopupA = a();
        menuPopupA.u(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f649f, this.f648e.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f648e.getWidth();
            }
            menuPopupA.s(i2);
            menuPopupA.v(i3);
            int i4 = (int) ((this.f644a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            menuPopupA.f643a = new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4);
        }
        menuPopupA.a();
    }
}
