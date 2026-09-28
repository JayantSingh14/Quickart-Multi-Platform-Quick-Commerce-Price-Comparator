package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.media.b;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.MenuItemHoverListener;
import androidx.appcompat.widget.MenuPopupWindow;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
final class CascadingMenuPopup extends MenuPopup implements MenuPresenter, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int A = R.layout.abc_cascading_menu_item_layout;

    /* renamed from: b, reason: collision with root package name */
    public final Context f551b;

    /* renamed from: c, reason: collision with root package name */
    public final int f552c;

    /* renamed from: d, reason: collision with root package name */
    public final int f553d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f554e;

    /* renamed from: f, reason: collision with root package name */
    public final Handler f555f;
    public View n;
    public View o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public boolean v;
    public MenuPresenter.Callback w;
    public ViewTreeObserver x;
    public PopupWindow.OnDismissListener y;
    public boolean z;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f556g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList f557h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f558i = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.1
        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public final void onGlobalLayout() {
            CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
            if (cascadingMenuPopup.b()) {
                ArrayList arrayList = cascadingMenuPopup.f557h;
                if (arrayList.size() <= 0 || ((CascadingMenuInfo) arrayList.get(0)).f570a.y) {
                    return;
                }
                View view = cascadingMenuPopup.o;
                if (view == null || !view.isShown()) {
                    cascadingMenuPopup.dismiss();
                    return;
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((CascadingMenuInfo) it.next()).f570a.a();
                }
            }
        }
    };

    /* renamed from: j, reason: collision with root package name */
    public final View.OnAttachStateChangeListener f559j = new View.OnAttachStateChangeListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.2
        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View view) {
            CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
            ViewTreeObserver viewTreeObserver = cascadingMenuPopup.x;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    cascadingMenuPopup.x = view.getViewTreeObserver();
                }
                cascadingMenuPopup.x.removeGlobalOnLayoutListener(cascadingMenuPopup.f558i);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    public final MenuItemHoverListener f560k = new MenuItemHoverListener() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3
        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public final void d(final MenuBuilder menuBuilder, final MenuItemImpl menuItemImpl) {
            CascadingMenuPopup cascadingMenuPopup = CascadingMenuPopup.this;
            cascadingMenuPopup.f555f.removeCallbacksAndMessages(null);
            ArrayList arrayList = cascadingMenuPopup.f557h;
            int size = arrayList.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (menuBuilder == ((CascadingMenuInfo) arrayList.get(i2)).f571b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            final CascadingMenuInfo cascadingMenuInfo = i3 < arrayList.size() ? (CascadingMenuInfo) arrayList.get(i3) : null;
            cascadingMenuPopup.f555f.postAtTime(new Runnable() { // from class: androidx.appcompat.view.menu.CascadingMenuPopup.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    CascadingMenuInfo cascadingMenuInfo2 = cascadingMenuInfo;
                    if (cascadingMenuInfo2 != null) {
                        AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                        CascadingMenuPopup.this.z = true;
                        cascadingMenuInfo2.f571b.d(false);
                        CascadingMenuPopup.this.z = false;
                    }
                    MenuItemImpl menuItemImpl2 = menuItemImpl;
                    if (menuItemImpl2.isEnabled() && menuItemImpl2.hasSubMenu()) {
                        menuBuilder.r(menuItemImpl2, null, 4);
                    }
                }
            }, menuBuilder, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.MenuItemHoverListener
        public final void m(MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
            CascadingMenuPopup.this.f555f.removeCallbacksAndMessages(menuBuilder);
        }
    };

    /* renamed from: l, reason: collision with root package name */
    public int f561l = 0;

    /* renamed from: m, reason: collision with root package name */
    public int f562m = 0;
    public boolean u = false;

    public static class CascadingMenuInfo {

        /* renamed from: a, reason: collision with root package name */
        public final MenuPopupWindow f570a;

        /* renamed from: b, reason: collision with root package name */
        public final MenuBuilder f571b;

        /* renamed from: c, reason: collision with root package name */
        public final int f572c;

        public CascadingMenuInfo(MenuPopupWindow menuPopupWindow, MenuBuilder menuBuilder, int i2) {
            this.f570a = menuPopupWindow;
            this.f571b = menuBuilder;
            this.f572c = i2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface HorizPosition {
    }

    public CascadingMenuPopup(Context context, View view, int i2, boolean z) {
        this.f551b = context;
        this.n = view;
        this.f553d = i2;
        this.f554e = z;
        this.p = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.f552c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f555f = new Handler();
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (b()) {
            return;
        }
        ArrayList arrayList = this.f556g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            x((MenuBuilder) it.next());
        }
        arrayList.clear();
        View view = this.n;
        this.o = view;
        if (view != null) {
            boolean z = this.x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.x = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.f558i);
            }
            this.o.addOnAttachStateChangeListener(this.f559j);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final boolean b() {
        ArrayList arrayList = this.f557h;
        return arrayList.size() > 0 && ((CascadingMenuInfo) arrayList.get(0)).f570a.z.isShowing();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void c(MenuBuilder menuBuilder, boolean z) {
        ArrayList arrayList = this.f557h;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (menuBuilder == ((CascadingMenuInfo) arrayList.get(i2)).f571b) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 < 0) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 < arrayList.size()) {
            ((CascadingMenuInfo) arrayList.get(i3)).f571b.d(false);
        }
        CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) arrayList.remove(i2);
        cascadingMenuInfo.f571b.s(this);
        boolean z2 = this.z;
        MenuPopupWindow menuPopupWindow = cascadingMenuInfo.f570a;
        if (z2) {
            menuPopupWindow.t();
            menuPopupWindow.z.setAnimationStyle(0);
        }
        menuPopupWindow.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.p = ((CascadingMenuInfo) arrayList.get(size2 - 1)).f572c;
        } else {
            this.p = this.n.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((CascadingMenuInfo) arrayList.get(0)).f571b.d(false);
                return;
            }
            return;
        }
        dismiss();
        MenuPresenter.Callback callback = this.w;
        if (callback != null) {
            callback.c(menuBuilder, true);
        }
        ViewTreeObserver viewTreeObserver = this.x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.x.removeGlobalOnLayoutListener(this.f558i);
            }
            this.x = null;
        }
        this.o.removeOnAttachStateChangeListener(this.f559j);
        ((MenuPopupHelper.AnonymousClass1) this.y).onDismiss();
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void d(MenuPresenter.Callback callback) {
        this.w = callback;
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final void dismiss() {
        ArrayList arrayList = this.f557h;
        int size = arrayList.size();
        if (size > 0) {
            CascadingMenuInfo[] cascadingMenuInfoArr = (CascadingMenuInfo[]) arrayList.toArray(new CascadingMenuInfo[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                CascadingMenuInfo cascadingMenuInfo = cascadingMenuInfoArr[i2];
                if (cascadingMenuInfo.f570a.z.isShowing()) {
                    cascadingMenuInfo.f570a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void f(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean g(SubMenuBuilder subMenuBuilder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Iterator it = this.f557h.iterator();
        while (it.hasNext()) {
            CascadingMenuInfo cascadingMenuInfo = (CascadingMenuInfo) it.next();
            if (subMenuBuilder == cascadingMenuInfo.f571b) {
                cascadingMenuInfo.f570a.f1074c.requestFocus();
                return true;
            }
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        m(subMenuBuilder);
        MenuPresenter.Callback callback = this.w;
        if (callback != null) {
            callback.d(subMenuBuilder);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable h() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void j(boolean z) {
        Iterator it = this.f557h.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((CascadingMenuInfo) it.next()).f570a.f1074c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((MenuAdapter) adapter).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean k() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void m(MenuBuilder menuBuilder) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        menuBuilder.c(this, this.f551b);
        if (b()) {
            x(menuBuilder);
        } else {
            this.f556g.add(menuBuilder);
        }
    }

    @Override // androidx.appcompat.view.menu.ShowableListMenu
    public final ListView o() {
        ArrayList arrayList = this.f557h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((CascadingMenuInfo) b.c(1, arrayList)).f570a.f1074c;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        CascadingMenuInfo cascadingMenuInfo;
        ArrayList arrayList = this.f557h;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                cascadingMenuInfo = null;
                break;
            }
            cascadingMenuInfo = (CascadingMenuInfo) arrayList.get(i2);
            if (!cascadingMenuInfo.f570a.z.isShowing()) {
                break;
            } else {
                i2++;
            }
        }
        if (cascadingMenuInfo != null) {
            cascadingMenuInfo.f571b.d(false);
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
        if (this.n != view) {
            this.n = view;
            this.f562m = Gravity.getAbsoluteGravity(this.f561l, view.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void q(boolean z) {
        this.u = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void r(int i2) {
        if (this.f561l != i2) {
            this.f561l = i2;
            this.f562m = Gravity.getAbsoluteGravity(i2, this.n.getLayoutDirection());
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void s(int i2) {
        this.q = true;
        this.s = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void t(PopupWindow.OnDismissListener onDismissListener) {
        this.y = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void u(boolean z) {
        this.v = z;
    }

    @Override // androidx.appcompat.view.menu.MenuPopup
    public final void v(int i2) {
        this.r = true;
        this.t = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x019b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x(androidx.appcompat.view.menu.MenuBuilder r19) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.CascadingMenuPopup.x(androidx.appcompat.view.menu.MenuBuilder):void");
    }
}
