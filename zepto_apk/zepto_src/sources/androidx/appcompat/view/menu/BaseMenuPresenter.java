package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public abstract class BaseMenuPresenter implements MenuPresenter {

    /* renamed from: a, reason: collision with root package name */
    public Context f539a;

    /* renamed from: b, reason: collision with root package name */
    public Context f540b;

    /* renamed from: c, reason: collision with root package name */
    public MenuBuilder f541c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f542d;

    /* renamed from: e, reason: collision with root package name */
    public MenuPresenter.Callback f543e;

    /* renamed from: f, reason: collision with root package name */
    public int f544f;

    /* renamed from: g, reason: collision with root package name */
    public int f545g;

    /* renamed from: h, reason: collision with root package name */
    public MenuView f546h;

    /* renamed from: i, reason: collision with root package name */
    public int f547i;

    public abstract void a(MenuItemImpl menuItemImpl, MenuView.ItemView itemView);

    public boolean b(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void c(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f543e;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean e(MenuItemImpl menuItemImpl) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.MenuBuilder] */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean g(SubMenuBuilder subMenuBuilder) {
        MenuPresenter.Callback callback = this.f543e;
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        if (callback == null) {
            return false;
        }
        if (subMenuBuilder == null) {
            subMenuBuilder2 = this.f541c;
        }
        return callback.d(subMenuBuilder2);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return this.f547i;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean i(MenuItemImpl menuItemImpl) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void j(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f546h;
        if (viewGroup == null) {
            return;
        }
        MenuBuilder menuBuilder = this.f541c;
        int i2 = 0;
        if (menuBuilder != null) {
            menuBuilder.j();
            ArrayList arrayListM = this.f541c.m();
            int size = arrayListM.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) arrayListM.get(i4);
                if (n(menuItemImpl)) {
                    View childAt = viewGroup.getChildAt(i3);
                    MenuItemImpl itemData = childAt instanceof MenuView.ItemView ? ((MenuView.ItemView) childAt).getItemData() : null;
                    View viewM = m(menuItemImpl, childAt, viewGroup);
                    if (menuItemImpl != itemData) {
                        viewM.setPressed(false);
                        viewM.jumpDrawablesToCurrentState();
                    }
                    if (viewM != childAt) {
                        ViewGroup viewGroup2 = (ViewGroup) viewM.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(viewM);
                        }
                        ((ViewGroup) this.f546h).addView(viewM, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!b(viewGroup, i2)) {
                i2++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public boolean k() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public void l(Context context, MenuBuilder menuBuilder) {
        this.f540b = context;
        LayoutInflater.from(context);
        this.f541c = menuBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View m(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        MenuView.ItemView itemView = view instanceof MenuView.ItemView ? (MenuView.ItemView) view : (MenuView.ItemView) this.f542d.inflate(this.f545g, viewGroup, false);
        a(menuItemImpl, itemView);
        return (View) itemView;
    }

    public boolean n(MenuItemImpl menuItemImpl) {
        return true;
    }
}
