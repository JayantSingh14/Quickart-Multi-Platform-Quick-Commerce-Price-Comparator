package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.internal.view.SupportSubMenu;

/* loaded from: classes3.dex */
abstract class BaseMenuWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final Context f548a;

    /* renamed from: b, reason: collision with root package name */
    public SimpleArrayMap f549b;

    /* renamed from: c, reason: collision with root package name */
    public SimpleArrayMap f550c;

    public BaseMenuWrapper(Context context) {
        this.f548a = context;
    }

    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof SupportMenuItem)) {
            return menuItem;
        }
        SupportMenuItem supportMenuItem = (SupportMenuItem) menuItem;
        if (this.f549b == null) {
            this.f549b = new SimpleArrayMap();
        }
        MenuItem menuItem2 = (MenuItem) this.f549b.get(supportMenuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        MenuItemWrapperICS menuItemWrapperICS = new MenuItemWrapperICS(this.f548a, supportMenuItem);
        this.f549b.put(supportMenuItem, menuItemWrapperICS);
        return menuItemWrapperICS;
    }

    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof SupportSubMenu)) {
            return subMenu;
        }
        SupportSubMenu supportSubMenu = (SupportSubMenu) subMenu;
        if (this.f550c == null) {
            this.f550c = new SimpleArrayMap();
        }
        SubMenu subMenu2 = (SubMenu) this.f550c.get(supportSubMenu);
        if (subMenu2 != null) {
            return subMenu2;
        }
        SubMenuWrapperICS subMenuWrapperICS = new SubMenuWrapperICS(this.f548a, supportSubMenu);
        this.f550c.put(supportSubMenu, subMenuWrapperICS);
        return subMenuWrapperICS;
    }
}
