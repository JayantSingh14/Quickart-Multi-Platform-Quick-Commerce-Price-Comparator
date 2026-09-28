package com.google.android.material.navigation;

import android.content.Context;
import android.support.v4.media.b;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

@RestrictTo
/* loaded from: classes4.dex */
public final class NavigationBarMenu extends MenuBuilder {
    public final int A;
    public final Class z;

    public NavigationBarMenu(Context context, Class cls, int i2) {
        super(context);
        this.z = cls;
        this.A = i2;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    public final MenuItemImpl a(int i2, int i3, int i4, CharSequence charSequence) {
        int size = this.f608f.size() + 1;
        int i5 = this.A;
        if (size <= i5) {
            B();
            MenuItemImpl menuItemImplA = super.a(i2, i3, i4, charSequence);
            menuItemImplA.f(true);
            A();
            return menuItemImplA;
        }
        String simpleName = this.z.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i5);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(b.r(sb, simpleName, "#getMaxItemCount()"));
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.z.getSimpleName().concat(" does not support submenus"));
    }
}
