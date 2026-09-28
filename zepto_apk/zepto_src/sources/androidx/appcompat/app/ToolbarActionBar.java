package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.WeakHashMap;
import org.xbill.DNS.Type;

/* loaded from: classes3.dex */
class ToolbarActionBar extends ActionBar {

    /* renamed from: a, reason: collision with root package name */
    public final ToolbarWidgetWrapper f366a;

    /* renamed from: b, reason: collision with root package name */
    public final Window.Callback f367b;

    /* renamed from: c, reason: collision with root package name */
    public final ToolbarMenuCallback f368c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f369d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f370e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f371f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f372g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public final Runnable f373h = new Runnable() { // from class: androidx.appcompat.app.ToolbarActionBar.1
        @Override // java.lang.Runnable
        public final void run() {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            Window.Callback callback = toolbarActionBar.f367b;
            Menu menuX = toolbarActionBar.x();
            MenuBuilder menuBuilder = menuX instanceof MenuBuilder ? (MenuBuilder) menuX : null;
            if (menuBuilder != null) {
                menuBuilder.B();
            }
            try {
                menuX.clear();
                if (!callback.onCreatePanelMenu(0, menuX) || !callback.onPreparePanel(0, null, menuX)) {
                    menuX.clear();
                }
                if (menuBuilder != null) {
                    menuBuilder.A();
                }
            } catch (Throwable th) {
                if (menuBuilder != null) {
                    menuBuilder.A();
                }
                throw th;
            }
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public final Toolbar.OnMenuItemClickListener f374i;

    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {

        /* renamed from: a, reason: collision with root package name */
        public boolean f377a;

        public ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void c(MenuBuilder menuBuilder, boolean z) {
            if (this.f377a) {
                return;
            }
            this.f377a = true;
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            toolbarActionBar.f366a.n();
            toolbarActionBar.f367b.onPanelClosed(Type.EUI48, menuBuilder);
            this.f377a = false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean d(MenuBuilder menuBuilder) {
            ToolbarActionBar.this.f367b.onMenuOpened(Type.EUI48, menuBuilder);
            return true;
        }
    }

    public final class MenuBuilderCallback implements MenuBuilder.Callback {
        public MenuBuilderCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void b(MenuBuilder menuBuilder) {
            ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
            boolean zQ = toolbarActionBar.f366a.f1223a.q();
            Window.Callback callback = toolbarActionBar.f367b;
            if (zQ) {
                callback.onPanelClosed(Type.EUI48, menuBuilder);
            } else if (callback.onPreparePanel(0, null, menuBuilder)) {
                callback.onMenuOpened(Type.EUI48, menuBuilder);
            }
        }
    }

    public class ToolbarMenuCallback implements AppCompatDelegateImpl.ActionBarMenuCallback {
        public ToolbarMenuCallback() {
        }

        public final View a(int i2) {
            if (i2 == 0) {
                return new View(ToolbarActionBar.this.f366a.f1223a.getContext());
            }
            return null;
        }

        public final void b(int i2) {
            if (i2 == 0) {
                ToolbarActionBar toolbarActionBar = ToolbarActionBar.this;
                if (toolbarActionBar.f369d) {
                    return;
                }
                toolbarActionBar.f366a.f1234l = true;
                toolbarActionBar.f369d = true;
            }
        }
    }

    public ToolbarActionBar(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        Toolbar.OnMenuItemClickListener onMenuItemClickListener = new Toolbar.OnMenuItemClickListener() { // from class: androidx.appcompat.app.ToolbarActionBar.2
            @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return ToolbarActionBar.this.f367b.onMenuItemSelected(0, menuItem);
            }
        };
        this.f374i = onMenuItemClickListener;
        toolbar.getClass();
        ToolbarWidgetWrapper toolbarWidgetWrapper = new ToolbarWidgetWrapper(toolbar, false);
        this.f366a = toolbarWidgetWrapper;
        callback.getClass();
        this.f367b = callback;
        toolbarWidgetWrapper.f1233k = callback;
        toolbar.setOnMenuItemClickListener(onMenuItemClickListener);
        toolbarWidgetWrapper.setWindowTitle(charSequence);
        this.f368c = new ToolbarMenuCallback();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean f() {
        return this.f366a.c();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean g() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f366a;
        if (!toolbarWidgetWrapper.f1223a.m()) {
            return false;
        }
        toolbarWidgetWrapper.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void h(boolean z) {
        if (z == this.f371f) {
            return;
        }
        this.f371f = z;
        ArrayList arrayList = this.f372g;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ActionBar.OnMenuVisibilityListener) arrayList.get(i2)).a();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int i() {
        return this.f366a.f1224b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context j() {
        return this.f366a.f1223a.getContext();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean k() {
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f366a;
        Toolbar toolbar = toolbarWidgetWrapper.f1223a;
        Runnable runnable = this.f373h;
        toolbar.removeCallbacks(runnable);
        Toolbar toolbar2 = toolbarWidgetWrapper.f1223a;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        toolbar2.postOnAnimation(runnable);
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void m() {
        this.f366a.f1223a.removeCallbacks(this.f373h);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean n(int i2, KeyEvent keyEvent) {
        Menu menuX = x();
        if (menuX == null) {
            return false;
        }
        menuX.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menuX.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean o(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            p();
        }
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean p() {
        return this.f366a.f1223a.x();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void q(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void r(boolean z) {
        int i2 = z ? 4 : 0;
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f366a;
        toolbarWidgetWrapper.i((i2 & 4) | (toolbarWidgetWrapper.f1224b & (-5)));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void s(Drawable drawable) {
        this.f366a.s(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void t(boolean z) {
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void u(CharSequence charSequence) {
        this.f366a.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void v(CharSequence charSequence) {
        this.f366a.setWindowTitle(charSequence);
    }

    public final Menu x() {
        boolean z = this.f370e;
        ToolbarWidgetWrapper toolbarWidgetWrapper = this.f366a;
        if (!z) {
            ActionMenuPresenterCallback actionMenuPresenterCallback = new ActionMenuPresenterCallback();
            MenuBuilderCallback menuBuilderCallback = new MenuBuilderCallback();
            Toolbar toolbar = toolbarWidgetWrapper.f1223a;
            toolbar.Q = actionMenuPresenterCallback;
            toolbar.A0 = menuBuilderCallback;
            ActionMenuView actionMenuView = toolbar.f1187a;
            if (actionMenuView != null) {
                actionMenuView.u = actionMenuPresenterCallback;
                actionMenuView.v = menuBuilderCallback;
            }
            this.f370e = true;
        }
        return toolbarWidgetWrapper.f1223a.getMenu();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void l() {
    }
}
