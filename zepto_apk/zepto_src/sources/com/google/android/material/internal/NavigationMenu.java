package com.google.android.material.internal;

import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo
/* loaded from: classes4.dex */
public class NavigationMenu extends MenuBuilder {
    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        MenuItemImpl menuItemImplA = a(i2, i3, i4, charSequence);
        NavigationSubMenu navigationSubMenu = new NavigationSubMenu(this.f603a, this, menuItemImplA);
        menuItemImplA.o = navigationSubMenu;
        navigationSubMenu.setHeaderTitle(menuItemImplA.f623e);
        return navigationSubMenu;
    }
}
