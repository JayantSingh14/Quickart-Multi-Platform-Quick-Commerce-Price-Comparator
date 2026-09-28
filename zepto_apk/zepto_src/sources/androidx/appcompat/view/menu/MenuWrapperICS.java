package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.internal.view.SupportMenu;
import androidx.core.internal.view.SupportMenuItem;

@RestrictTo
/* loaded from: classes3.dex */
public class MenuWrapperICS extends BaseMenuWrapper implements Menu {

    /* renamed from: d, reason: collision with root package name */
    public final SupportMenu f656d;

    public MenuWrapperICS(Context context, SupportMenu supportMenu) {
        super(context);
        if (supportMenu == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f656d = supportMenu;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return c(this.f656d.add(charSequence));
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i2, int i3, int i4, ComponentName componentName, Intent[] intentArr, Intent intent, int i5, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int iAddIntentOptions = this.f656d.addIntentOptions(i2, i3, i4, componentName, intentArr, intent, i5, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i6 = 0; i6 < length; i6++) {
                menuItemArr[i6] = c(menuItemArr2[i6]);
            }
        }
        return iAddIntentOptions;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return d(this.f656d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public final void clear() {
        SimpleArrayMap simpleArrayMap = this.f549b;
        if (simpleArrayMap != null) {
            simpleArrayMap.clear();
        }
        SimpleArrayMap simpleArrayMap2 = this.f550c;
        if (simpleArrayMap2 != null) {
            simpleArrayMap2.clear();
        }
        this.f656d.clear();
    }

    @Override // android.view.Menu
    public final void close() {
        this.f656d.close();
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i2) {
        return c(this.f656d.findItem(i2));
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i2) {
        return c(this.f656d.getItem(i2));
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        return this.f656d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i2, KeyEvent keyEvent) {
        return this.f656d.isShortcutKey(i2, keyEvent);
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i2, int i3) {
        return this.f656d.performIdentifierAction(i2, i3);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i2, KeyEvent keyEvent, int i3) {
        return this.f656d.performShortcut(i2, keyEvent, i3);
    }

    @Override // android.view.Menu
    public final void removeGroup(int i2) {
        if (this.f549b != null) {
            int i3 = 0;
            while (true) {
                SimpleArrayMap simpleArrayMap = this.f549b;
                if (i3 >= simpleArrayMap.f1605c) {
                    break;
                }
                if (((SupportMenuItem) simpleArrayMap.f(i3)).getGroupId() == i2) {
                    this.f549b.h(i3);
                    i3--;
                }
                i3++;
            }
        }
        this.f656d.removeGroup(i2);
    }

    @Override // android.view.Menu
    public final void removeItem(int i2) {
        if (this.f549b != null) {
            int i3 = 0;
            while (true) {
                SimpleArrayMap simpleArrayMap = this.f549b;
                if (i3 >= simpleArrayMap.f1605c) {
                    break;
                }
                if (((SupportMenuItem) simpleArrayMap.f(i3)).getItemId() == i2) {
                    this.f549b.h(i3);
                    break;
                }
                i3++;
            }
        }
        this.f656d.removeItem(i2);
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i2, boolean z, boolean z2) {
        this.f656d.setGroupCheckable(i2, z, z2);
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i2, boolean z) {
        this.f656d.setGroupEnabled(i2, z);
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i2, boolean z) {
        this.f656d.setGroupVisible(i2, z);
    }

    @Override // android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f656d.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f656d.size();
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2) {
        return c(this.f656d.add(i2));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2) {
        return d(this.f656d.addSubMenu(i2));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, CharSequence charSequence) {
        return c(this.f656d.add(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, CharSequence charSequence) {
        return d(this.f656d.addSubMenu(i2, i3, i4, charSequence));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i2, int i3, int i4, int i5) {
        return c(this.f656d.add(i2, i3, i4, i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i2, int i3, int i4, int i5) {
        return d(this.f656d.addSubMenu(i2, i3, i4, i5));
    }
}
