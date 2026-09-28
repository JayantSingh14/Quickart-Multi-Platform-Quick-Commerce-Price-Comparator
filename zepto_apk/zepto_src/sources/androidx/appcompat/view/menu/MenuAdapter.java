package androidx.appcompat.view.menu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class MenuAdapter extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final MenuBuilder f597a;

    /* renamed from: b, reason: collision with root package name */
    public int f598b = -1;

    /* renamed from: c, reason: collision with root package name */
    public boolean f599c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f600d;

    /* renamed from: e, reason: collision with root package name */
    public final LayoutInflater f601e;

    /* renamed from: f, reason: collision with root package name */
    public final int f602f;

    public MenuAdapter(MenuBuilder menuBuilder, LayoutInflater layoutInflater, boolean z, int i2) {
        this.f600d = z;
        this.f601e = layoutInflater;
        this.f597a = menuBuilder;
        this.f602f = i2;
        a();
    }

    public final void a() {
        MenuBuilder menuBuilder = this.f597a;
        MenuItemImpl menuItemImpl = menuBuilder.v;
        if (menuItemImpl != null) {
            menuBuilder.j();
            ArrayList arrayList = menuBuilder.f612j;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (((MenuItemImpl) arrayList.get(i2)) == menuItemImpl) {
                    this.f598b = i2;
                    return;
                }
            }
        }
        this.f598b = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final MenuItemImpl getItem(int i2) {
        ArrayList arrayListM;
        MenuBuilder menuBuilder = this.f597a;
        if (this.f600d) {
            menuBuilder.j();
            arrayListM = menuBuilder.f612j;
        } else {
            arrayListM = menuBuilder.m();
        }
        int i3 = this.f598b;
        if (i3 >= 0 && i2 >= i3) {
            i2++;
        }
        return (MenuItemImpl) arrayListM.get(i2);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListM;
        MenuBuilder menuBuilder = this.f597a;
        if (this.f600d) {
            menuBuilder.j();
            arrayListM = menuBuilder.f612j;
        } else {
            arrayListM = menuBuilder.m();
        }
        return this.f598b < 0 ? arrayListM.size() : arrayListM.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i2) {
        return i2;
    }

    @Override // android.widget.Adapter
    public final View getView(int i2, View view, ViewGroup viewGroup) {
        boolean z = false;
        if (view == null) {
            view = this.f601e.inflate(this.f602f, viewGroup, false);
        }
        int i3 = getItem(i2).f620b;
        int i4 = i2 - 1;
        int i5 = i4 >= 0 ? getItem(i4).f620b : i3;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f597a.n() && i3 != i5) {
            z = true;
        }
        listMenuItemView.setGroupDividerEnabled(z);
        MenuView.ItemView itemView = (MenuView.ItemView) view;
        if (this.f599c) {
            listMenuItemView.setForceShowIcon(true);
        }
        itemView.c(getItem(i2));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
