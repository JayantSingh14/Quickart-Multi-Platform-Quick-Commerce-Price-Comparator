package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.b;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;

@RestrictTo
/* loaded from: classes3.dex */
public class SubMenuBuilder extends MenuBuilder implements SubMenu {
    public final MenuItemImpl A;
    public final MenuBuilder z;

    public SubMenuBuilder(Context context, MenuBuilder menuBuilder, MenuItemImpl menuItemImpl) {
        super(context);
        this.z = menuBuilder;
        this.A = menuItemImpl;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final boolean e(MenuItemImpl menuItemImpl) {
        return this.z.e(menuItemImpl);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final boolean f(MenuBuilder menuBuilder, MenuItem menuItem) {
        return super.f(menuBuilder, menuItem) || this.z.f(menuBuilder, menuItem);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final boolean g(MenuItemImpl menuItemImpl) {
        return this.z.g(menuItemImpl);
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.A;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final String k() {
        MenuItemImpl menuItemImpl = this.A;
        int i2 = menuItemImpl != null ? menuItemImpl.f619a : 0;
        if (i2 == 0) {
            return null;
        }
        return b.f(i2, "android:menu:actionviewstates:");
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final MenuBuilder l() {
        return this.z.l();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final boolean n() {
        return this.z.n();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final boolean o() {
        return this.z.o();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final boolean p() {
        return this.z.p();
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, androidx.core.internal.view.SupportMenu, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.z.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        y(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        y(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        y(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.A.setIcon(drawable);
        return this;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.z.setQwertyMode(z);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final void x(MenuBuilder.Callback callback) {
        throw null;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i2) {
        y(0, null, i2, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i2) {
        y(i2, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i2) {
        this.A.setIcon(i2);
        return this;
    }
}
