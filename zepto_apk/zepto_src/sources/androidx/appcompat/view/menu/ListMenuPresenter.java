package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class ListMenuPresenter implements MenuPresenter, AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public Context f588a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f589b;

    /* renamed from: c, reason: collision with root package name */
    public MenuBuilder f590c;

    /* renamed from: d, reason: collision with root package name */
    public ExpandedMenuView f591d;

    /* renamed from: e, reason: collision with root package name */
    public final int f592e;

    /* renamed from: f, reason: collision with root package name */
    public MenuPresenter.Callback f593f;

    /* renamed from: g, reason: collision with root package name */
    public MenuAdapter f594g;

    public class MenuAdapter extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        public int f595a = -1;

        public MenuAdapter() {
            a();
        }

        public final void a() {
            MenuBuilder menuBuilder = ListMenuPresenter.this.f590c;
            MenuItemImpl menuItemImpl = menuBuilder.v;
            if (menuItemImpl != null) {
                menuBuilder.j();
                ArrayList arrayList = menuBuilder.f612j;
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (((MenuItemImpl) arrayList.get(i2)) == menuItemImpl) {
                        this.f595a = i2;
                        return;
                    }
                }
            }
            this.f595a = -1;
        }

        @Override // android.widget.Adapter
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final MenuItemImpl getItem(int i2) {
            ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
            MenuBuilder menuBuilder = listMenuPresenter.f590c;
            menuBuilder.j();
            ArrayList arrayList = menuBuilder.f612j;
            listMenuPresenter.getClass();
            int i3 = this.f595a;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return (MenuItemImpl) arrayList.get(i2);
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
            MenuBuilder menuBuilder = listMenuPresenter.f590c;
            menuBuilder.j();
            int size = menuBuilder.f612j.size();
            listMenuPresenter.getClass();
            return this.f595a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.Adapter
        public final View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                ListMenuPresenter listMenuPresenter = ListMenuPresenter.this;
                view = listMenuPresenter.f589b.inflate(listMenuPresenter.f592e, viewGroup, false);
            }
            ((MenuView.ItemView) view).c(getItem(i2));
            return view;
        }

        @Override // android.widget.BaseAdapter
        public final void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public ListMenuPresenter(Context context, int i2) {
        this.f592e = i2;
        this.f588a = context;
        this.f589b = LayoutInflater.from(context);
    }

    public final ListAdapter a() {
        if (this.f594g == null) {
            this.f594g = new MenuAdapter();
        }
        return this.f594g;
    }

    public final MenuView b(ViewGroup viewGroup) {
        if (this.f591d == null) {
            this.f591d = (ExpandedMenuView) this.f589b.inflate(R.layout.abc_expanded_menu_layout, viewGroup, false);
            if (this.f594g == null) {
                this.f594g = new MenuAdapter();
            }
            this.f591d.setAdapter((ListAdapter) this.f594g);
            this.f591d.setOnItemClickListener(this);
        }
        return this.f591d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void c(MenuBuilder menuBuilder, boolean z) {
        MenuPresenter.Callback callback = this.f593f;
        if (callback != null) {
            callback.c(menuBuilder, z);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void d(MenuPresenter.Callback callback) {
        this.f593f = callback;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean e(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void f(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f591d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean g(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return false;
        }
        MenuDialogHelper menuDialogHelper = new MenuDialogHelper();
        menuDialogHelper.f616a = subMenuBuilder;
        AlertDialog.Builder builder = new AlertDialog.Builder(subMenuBuilder.f603a);
        ListMenuPresenter listMenuPresenter = new ListMenuPresenter(builder.getContext(), R.layout.abc_list_menu_item_layout);
        menuDialogHelper.f618c = listMenuPresenter;
        listMenuPresenter.f593f = menuDialogHelper;
        subMenuBuilder.b(listMenuPresenter);
        ListAdapter listAdapterA = menuDialogHelper.f618c.a();
        AlertController.AlertParams alertParams = builder.f282a;
        alertParams.o = listAdapterA;
        alertParams.p = menuDialogHelper;
        View view = subMenuBuilder.o;
        if (view != null) {
            alertParams.f262e = view;
        } else {
            alertParams.f260c = subMenuBuilder.n;
            builder.setTitle(subMenuBuilder.f615m);
        }
        alertParams.f270m = menuDialogHelper;
        AlertDialog alertDialogCreate = builder.create();
        menuDialogHelper.f617b = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(menuDialogHelper);
        WindowManager.LayoutParams attributes = menuDialogHelper.f617b.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        menuDialogHelper.f617b.show();
        MenuPresenter.Callback callback = this.f593f;
        if (callback == null) {
            return true;
        }
        callback.d(subMenuBuilder);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable h() {
        if (this.f591d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f591d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean i(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void j(boolean z) {
        MenuAdapter menuAdapter = this.f594g;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean k() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void l(Context context, MenuBuilder menuBuilder) {
        if (this.f588a != null) {
            this.f588a = context;
            if (this.f589b == null) {
                this.f589b = LayoutInflater.from(context);
            }
        }
        this.f590c = menuBuilder;
        MenuAdapter menuAdapter = this.f594g;
        if (menuAdapter != null) {
            menuAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        this.f590c.r(this.f594g.getItem(i2), this, 0);
    }
}
