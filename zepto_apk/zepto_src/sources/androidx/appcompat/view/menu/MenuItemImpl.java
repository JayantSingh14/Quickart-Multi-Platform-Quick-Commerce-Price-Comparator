package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public final class MenuItemImpl implements SupportMenuItem {
    public ActionProvider A;
    public MenuItem.OnActionExpandListener B;

    /* renamed from: a, reason: collision with root package name */
    public final int f619a;

    /* renamed from: b, reason: collision with root package name */
    public final int f620b;

    /* renamed from: c, reason: collision with root package name */
    public final int f621c;

    /* renamed from: d, reason: collision with root package name */
    public final int f622d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f623e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f624f;

    /* renamed from: g, reason: collision with root package name */
    public Intent f625g;

    /* renamed from: h, reason: collision with root package name */
    public char f626h;

    /* renamed from: j, reason: collision with root package name */
    public char f628j;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f630l;
    public final MenuBuilder n;
    public SubMenuBuilder o;
    public MenuItem.OnMenuItemClickListener p;
    public CharSequence q;
    public CharSequence r;
    public int y;
    public View z;

    /* renamed from: i, reason: collision with root package name */
    public int f627i = 4096;

    /* renamed from: k, reason: collision with root package name */
    public int f629k = 4096;

    /* renamed from: m, reason: collision with root package name */
    public int f631m = 0;
    public ColorStateList s = null;
    public PorterDuff.Mode t = null;
    public boolean u = false;
    public boolean v = false;
    public boolean w = false;
    public int x = 16;
    public boolean C = false;

    /* renamed from: androidx.appcompat.view.menu.MenuItemImpl$1, reason: invalid class name */
    class AnonymousClass1 implements ActionProvider.VisibilityListener {
        public AnonymousClass1() {
        }
    }

    public MenuItemImpl(MenuBuilder menuBuilder, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6) {
        this.n = menuBuilder;
        this.f619a = i3;
        this.f620b = i2;
        this.f621c = i4;
        this.f622d = i5;
        this.f623e = charSequence;
        this.y = i6;
    }

    public static void c(int i2, int i3, String str, StringBuilder sb) {
        if ((i2 & i3) == i3) {
            sb.append(str);
        }
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final ActionProvider a() {
        return this.A;
    }

    @Override // androidx.core.internal.view.SupportMenuItem
    public final SupportMenuItem b(ActionProvider actionProvider) {
        ActionProvider actionProvider2 = this.A;
        if (actionProvider2 != null) {
            actionProvider2.f3017b = null;
            actionProvider2.f3016a = null;
        }
        this.z = null;
        this.A = actionProvider;
        this.n.q(true);
        ActionProvider actionProvider3 = this.A;
        if (actionProvider3 != null) {
            actionProvider3.h(new AnonymousClass1());
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.e(this);
        }
        return false;
    }

    public final Drawable d(Drawable drawable) {
        if (drawable != null && this.w && (this.u || this.v)) {
            drawable = drawable.mutate();
            if (this.u) {
                drawable.setTintList(this.s);
            }
            if (this.v) {
                drawable.setTintMode(this.t);
            }
            this.w = false;
        }
        return drawable;
    }

    public final boolean e() {
        ActionProvider actionProvider;
        if ((this.y & 8) == 0) {
            return false;
        }
        if (this.z == null && (actionProvider = this.A) != null) {
            this.z = actionProvider.d(this);
        }
        return this.z != null;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        if (!e()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.B;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
            return this.n.g(this);
        }
        return false;
    }

    public final void f(boolean z) {
        this.x = (z ? 4 : 0) | (this.x & (-5));
    }

    public final void g(boolean z) {
        if (z) {
            this.x |= 32;
        } else {
            this.x &= -33;
        }
    }

    @Override // android.view.MenuItem
    public final android.view.ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View view = this.z;
        if (view != null) {
            return view;
        }
        ActionProvider actionProvider = this.A;
        if (actionProvider == null) {
            return null;
        }
        View viewD = actionProvider.d(this);
        this.z = viewD;
        return viewD;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f629k;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f628j;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.q;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f620b;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        Drawable drawable = this.f630l;
        if (drawable != null) {
            return d(drawable);
        }
        int i2 = this.f631m;
        if (i2 == 0) {
            return null;
        }
        Drawable drawableB = AppCompatResources.b(i2, this.n.f603a);
        this.f631m = 0;
        this.f630l = drawableB;
        return d(drawableB);
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.s;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.t;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f625g;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f619a;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f627i;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f626h;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f621c;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f623e;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f624f;
        return charSequence != null ? charSequence : this.f623e;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.o != null;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.C;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.x & 1) == 1;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.x & 2) == 2;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.x & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        ActionProvider actionProvider = this.A;
        return (actionProvider == null || !actionProvider.g()) ? (this.x & 8) == 0 : (this.x & 8) == 0 && this.A.b();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(android.view.ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        int i2;
        this.z = view;
        this.A = null;
        if (view != null && view.getId() == -1 && (i2 = this.f619a) > 0) {
            view.setId(i2);
        }
        MenuBuilder menuBuilder = this.n;
        menuBuilder.f613k = true;
        menuBuilder.q(true);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2) {
        if (this.f628j == c2) {
            return this;
        }
        this.f628j = Character.toLowerCase(c2);
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        int i2 = this.x;
        int i3 = (z ? 1 : 0) | (i2 & (-2));
        this.x = i3;
        if (i2 != i3) {
            this.n.q(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        int i2 = this.x;
        if ((i2 & 4) == 0) {
            int i3 = (i2 & (-3)) | (z ? 2 : 0);
            this.x = i3;
            if (i2 != i3) {
                this.n.q(false);
            }
            return this;
        }
        MenuBuilder menuBuilder = this.n;
        menuBuilder.getClass();
        ArrayList arrayList = menuBuilder.f608f;
        int size = arrayList.size();
        menuBuilder.B();
        for (int i4 = 0; i4 < size; i4++) {
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayList.get(i4);
            if (menuItemImpl.f620b == this.f620b && (menuItemImpl.x & 4) != 0 && menuItemImpl.isCheckable()) {
                boolean z2 = menuItemImpl == this;
                int i5 = menuItemImpl.x;
                int i6 = (z2 ? 2 : 0) | (i5 & (-3));
                menuItemImpl.x = i6;
                if (i5 != i6) {
                    menuItemImpl.n.q(false);
                }
            }
        }
        menuBuilder.A();
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setContentDescription(CharSequence charSequence) {
        setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        if (z) {
            this.x |= 16;
        } else {
            this.x &= -17;
        }
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f631m = 0;
        this.f630l = drawable;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.s = colorStateList;
        this.u = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.t = mode;
        this.v = true;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f625g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2) {
        if (this.f626h == c2) {
            return this;
        }
        this.f626h = c2;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.B = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.p = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3) {
        this.f626h = c2;
        this.f628j = Character.toLowerCase(c3);
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i2) {
        int i3 = i2 & 3;
        if (i3 != 0 && i3 != 1 && i3 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.y = i2;
        MenuBuilder menuBuilder = this.n;
        menuBuilder.f613k = true;
        menuBuilder.q(true);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i2) {
        setShowAsAction(i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f623e = charSequence;
        this.n.q(false);
        SubMenuBuilder subMenuBuilder = this.o;
        if (subMenuBuilder != null) {
            subMenuBuilder.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f624f = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final /* bridge */ /* synthetic */ MenuItem setTooltipText(CharSequence charSequence) {
        setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        int i2 = this.x;
        int i3 = (z ? 0 : 8) | (i2 & (-9));
        this.x = i3;
        if (i2 != i3) {
            MenuBuilder menuBuilder = this.n;
            menuBuilder.f610h = true;
            menuBuilder.q(true);
        }
        return this;
    }

    public final String toString() {
        CharSequence charSequence = this.f623e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.q = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.r = charSequence;
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c2, int i2) {
        if (this.f628j == c2 && this.f629k == i2) {
            return this;
        }
        this.f628j = Character.toLowerCase(c2);
        this.f629k = KeyEvent.normalizeMetaState(i2);
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c2, int i2) {
        if (this.f626h == c2 && this.f627i == i2) {
            return this;
        }
        this.f626h = c2;
        this.f627i = KeyEvent.normalizeMetaState(i2);
        this.n.q(false);
        return this;
    }

    @Override // androidx.core.internal.view.SupportMenuItem, android.view.MenuItem
    public final MenuItem setShortcut(char c2, char c3, int i2, int i3) {
        this.f626h = c2;
        this.f627i = KeyEvent.normalizeMetaState(i2);
        this.f628j = Character.toLowerCase(c3);
        this.f629k = KeyEvent.normalizeMetaState(i3);
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i2) {
        this.f630l = null;
        this.f631m = i2;
        this.w = true;
        this.n.q(false);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i2) {
        setTitle(this.n.f603a.getString(i2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i2) {
        int i3;
        Context context = this.n.f603a;
        View viewInflate = LayoutInflater.from(context).inflate(i2, (ViewGroup) new LinearLayout(context), false);
        this.z = viewInflate;
        this.A = null;
        if (viewInflate != null && viewInflate.getId() == -1 && (i3 = this.f619a) > 0) {
            viewInflate.setId(i3);
        }
        MenuBuilder menuBuilder = this.n;
        menuBuilder.f613k = true;
        menuBuilder.q(true);
        return this;
    }
}
