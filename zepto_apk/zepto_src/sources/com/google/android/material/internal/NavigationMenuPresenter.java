package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;
import com.google.android.material.R;
import java.util.ArrayList;
import java.util.WeakHashMap;

@RestrictTo
/* loaded from: classes4.dex */
public class NavigationMenuPresenter implements MenuPresenter {
    public int A;

    /* renamed from: a, reason: collision with root package name */
    public NavigationMenuView f40584a;

    /* renamed from: b, reason: collision with root package name */
    public LinearLayout f40585b;

    /* renamed from: c, reason: collision with root package name */
    public MenuBuilder f40586c;

    /* renamed from: d, reason: collision with root package name */
    public int f40587d;

    /* renamed from: e, reason: collision with root package name */
    public NavigationMenuAdapter f40588e;

    /* renamed from: f, reason: collision with root package name */
    public LayoutInflater f40589f;

    /* renamed from: h, reason: collision with root package name */
    public ColorStateList f40591h;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f40594k;

    /* renamed from: l, reason: collision with root package name */
    public ColorStateList f40595l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f40596m;
    public RippleDrawable n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public int y;
    public int z;

    /* renamed from: g, reason: collision with root package name */
    public int f40590g = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f40592i = 0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f40593j = true;
    public boolean x = true;
    public int B = -1;
    public final View.OnClickListener C = new View.OnClickListener() { // from class: com.google.android.material.internal.NavigationMenuPresenter.1
        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            boolean z = true;
            navigationMenuPresenter.n(true);
            MenuItemImpl itemData = ((NavigationMenuItemView) view).getItemData();
            boolean zR = navigationMenuPresenter.f40586c.r(itemData, navigationMenuPresenter, 0);
            if (itemData != null && itemData.isCheckable() && zR) {
                navigationMenuPresenter.f40588e.z(itemData);
            } else {
                z = false;
            }
            navigationMenuPresenter.n(false);
            if (z) {
                navigationMenuPresenter.j(false);
            }
        }
    };

    public static class HeaderViewHolder extends ViewHolder {
    }

    public class NavigationMenuAdapter extends RecyclerView.Adapter<ViewHolder> {

        /* renamed from: d, reason: collision with root package name */
        public final ArrayList f40598d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        public MenuItemImpl f40599e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f40600f;

        public NavigationMenuAdapter() {
            y();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int d() {
            return this.f40598d.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final long e(int i2) {
            return i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final int f(int i2) {
            NavigationMenuItem navigationMenuItem = (NavigationMenuItem) this.f40598d.get(i2);
            if (navigationMenuItem instanceof NavigationMenuSeparatorItem) {
                return 2;
            }
            if (navigationMenuItem instanceof NavigationMenuHeaderItem) {
                return 3;
            }
            if (navigationMenuItem instanceof NavigationMenuTextItem) {
                return ((NavigationMenuTextItem) navigationMenuItem).f40607a.hasSubMenu() ? 1 : 0;
            }
            throw new RuntimeException("Unknown item type.");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void o(RecyclerView.ViewHolder viewHolder, final int i2) {
            int iF = f(i2);
            ArrayList arrayList = this.f40598d;
            View view = ((ViewHolder) viewHolder).f11653a;
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (iF != 0) {
                final boolean z = true;
                if (iF != 1) {
                    if (iF != 2) {
                        return;
                    }
                    NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuSeparatorItem) arrayList.get(i2);
                    view.setPadding(navigationMenuPresenter.s, navigationMenuSeparatorItem.f40605a, navigationMenuPresenter.t, navigationMenuSeparatorItem.f40606b);
                    return;
                }
                TextView textView = (TextView) view;
                textView.setText(((NavigationMenuTextItem) arrayList.get(i2)).f40607a.f623e);
                textView.setTextAppearance(navigationMenuPresenter.f40590g);
                textView.setPadding(navigationMenuPresenter.u, textView.getPaddingTop(), navigationMenuPresenter.v, textView.getPaddingBottom());
                ColorStateList colorStateList = navigationMenuPresenter.f40591h;
                if (colorStateList != null) {
                    textView.setTextColor(colorStateList);
                }
                ViewCompat.z(textView, new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter.1
                    @Override // androidx.core.view.AccessibilityDelegateCompat
                    public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                        super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                        int i3 = i2;
                        int i4 = 0;
                        int i5 = i3;
                        while (true) {
                            NavigationMenuAdapter navigationMenuAdapter = NavigationMenuAdapter.this;
                            if (i4 >= i3) {
                                navigationMenuAdapter.getClass();
                                accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(i5, 1, 1, 1, z, view2.isSelected()));
                                return;
                            } else {
                                NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                                if (navigationMenuPresenter2.f40588e.f(i4) == 2 || navigationMenuPresenter2.f40588e.f(i4) == 3) {
                                    i5--;
                                }
                                i4++;
                            }
                        }
                    }
                });
                return;
            }
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) view;
            navigationMenuItemView.setIconTintList(navigationMenuPresenter.f40595l);
            navigationMenuItemView.setTextAppearance(navigationMenuPresenter.f40592i);
            ColorStateList colorStateList2 = navigationMenuPresenter.f40594k;
            if (colorStateList2 != null) {
                navigationMenuItemView.setTextColor(colorStateList2);
            }
            Drawable drawable = navigationMenuPresenter.f40596m;
            Drawable drawableNewDrawable = drawable != null ? drawable.getConstantState().newDrawable() : null;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            navigationMenuItemView.setBackground(drawableNewDrawable);
            RippleDrawable rippleDrawable = navigationMenuPresenter.n;
            if (rippleDrawable != null) {
                navigationMenuItemView.setForeground(rippleDrawable.getConstantState().newDrawable());
            }
            NavigationMenuTextItem navigationMenuTextItem = (NavigationMenuTextItem) arrayList.get(i2);
            navigationMenuItemView.setNeedsEmptyIcon(navigationMenuTextItem.f40608b);
            int i3 = navigationMenuPresenter.o;
            int i4 = navigationMenuPresenter.p;
            navigationMenuItemView.setPadding(i3, i4, i3, i4);
            navigationMenuItemView.setIconPadding(navigationMenuPresenter.q);
            if (navigationMenuPresenter.w) {
                navigationMenuItemView.setIconSize(navigationMenuPresenter.r);
            }
            navigationMenuItemView.setMaxLines(navigationMenuPresenter.y);
            navigationMenuItemView.y = navigationMenuPresenter.f40593j;
            navigationMenuItemView.c(navigationMenuTextItem.f40607a);
            final boolean z2 = false;
            ViewCompat.z(navigationMenuItemView, new AccessibilityDelegateCompat() { // from class: com.google.android.material.internal.NavigationMenuPresenter.NavigationMenuAdapter.1
                @Override // androidx.core.view.AccessibilityDelegateCompat
                public final void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfoCompat);
                    int i32 = i2;
                    int i42 = 0;
                    int i5 = i32;
                    while (true) {
                        NavigationMenuAdapter navigationMenuAdapter = NavigationMenuAdapter.this;
                        if (i42 >= i32) {
                            navigationMenuAdapter.getClass();
                            accessibilityNodeInfoCompat.p(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.a(i5, 1, 1, 1, z2, view2.isSelected()));
                            return;
                        } else {
                            NavigationMenuPresenter navigationMenuPresenter2 = NavigationMenuPresenter.this;
                            if (navigationMenuPresenter2.f40588e.f(i42) == 2 || navigationMenuPresenter2.f40588e.f(i42) == 3) {
                                i5--;
                            }
                            i42++;
                        }
                    }
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final RecyclerView.ViewHolder p(ViewGroup viewGroup, int i2) {
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            if (i2 == 0) {
                LayoutInflater layoutInflater = navigationMenuPresenter.f40589f;
                View.OnClickListener onClickListener = navigationMenuPresenter.C;
                View viewInflate = layoutInflater.inflate(R.layout.design_navigation_item, viewGroup, false);
                NormalViewHolder normalViewHolder = new NormalViewHolder(viewInflate);
                viewInflate.setOnClickListener(onClickListener);
                return normalViewHolder;
            }
            if (i2 == 1) {
                return new SubheaderViewHolder(navigationMenuPresenter.f40589f.inflate(R.layout.design_navigation_item_subheader, viewGroup, false));
            }
            if (i2 == 2) {
                return new SeparatorViewHolder(navigationMenuPresenter.f40589f.inflate(R.layout.design_navigation_item_separator, viewGroup, false));
            }
            if (i2 != 3) {
                return null;
            }
            return new HeaderViewHolder(navigationMenuPresenter.f40585b);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public final void u(RecyclerView.ViewHolder viewHolder) {
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            if (viewHolder2 instanceof NormalViewHolder) {
                NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView) viewHolder2.f11653a;
                FrameLayout frameLayout = navigationMenuItemView.A;
                if (frameLayout != null) {
                    frameLayout.removeAllViews();
                }
                navigationMenuItemView.z.setCompoundDrawables(null, null, null, null);
            }
        }

        public final void y() {
            boolean z;
            if (this.f40600f) {
                return;
            }
            this.f40600f = true;
            ArrayList arrayList = this.f40598d;
            arrayList.clear();
            arrayList.add(new NavigationMenuHeaderItem());
            NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
            int size = navigationMenuPresenter.f40586c.m().size();
            boolean z2 = false;
            int i2 = -1;
            int i3 = 0;
            boolean z3 = false;
            int size2 = 0;
            while (i3 < size) {
                MenuItemImpl menuItemImpl = (MenuItemImpl) navigationMenuPresenter.f40586c.m().get(i3);
                if (menuItemImpl.isChecked()) {
                    z(menuItemImpl);
                }
                if (menuItemImpl.isCheckable()) {
                    menuItemImpl.f(z2);
                }
                if (menuItemImpl.hasSubMenu()) {
                    SubMenuBuilder subMenuBuilder = menuItemImpl.o;
                    if (subMenuBuilder.hasVisibleItems()) {
                        if (i3 != 0) {
                            arrayList.add(new NavigationMenuSeparatorItem(navigationMenuPresenter.A, z2 ? 1 : 0));
                        }
                        arrayList.add(new NavigationMenuTextItem(menuItemImpl));
                        int size3 = subMenuBuilder.size();
                        int i4 = z2 ? 1 : 0;
                        int i5 = i4;
                        while (i4 < size3) {
                            MenuItemImpl menuItemImpl2 = (MenuItemImpl) subMenuBuilder.getItem(i4);
                            if (menuItemImpl2.isVisible()) {
                                if (i5 == 0 && menuItemImpl2.getIcon() != null) {
                                    i5 = 1;
                                }
                                if (menuItemImpl2.isCheckable()) {
                                    menuItemImpl2.f(z2);
                                }
                                if (menuItemImpl.isChecked()) {
                                    z(menuItemImpl);
                                }
                                arrayList.add(new NavigationMenuTextItem(menuItemImpl2));
                            }
                            i4++;
                            z2 = false;
                        }
                        if (i5 != 0) {
                            int size4 = arrayList.size();
                            for (int size5 = arrayList.size(); size5 < size4; size5++) {
                                ((NavigationMenuTextItem) arrayList.get(size5)).f40608b = true;
                            }
                        }
                    }
                    z = true;
                } else {
                    int i6 = menuItemImpl.f620b;
                    if (i6 != i2) {
                        size2 = arrayList.size();
                        z3 = menuItemImpl.getIcon() != null;
                        if (i3 != 0) {
                            size2++;
                            int i7 = navigationMenuPresenter.A;
                            arrayList.add(new NavigationMenuSeparatorItem(i7, i7));
                        }
                    } else {
                        if (!z3 && menuItemImpl.getIcon() != null) {
                            int size6 = arrayList.size();
                            for (int i8 = size2; i8 < size6; i8++) {
                                ((NavigationMenuTextItem) arrayList.get(i8)).f40608b = true;
                            }
                            z = true;
                            z3 = true;
                        }
                        NavigationMenuTextItem navigationMenuTextItem = new NavigationMenuTextItem(menuItemImpl);
                        navigationMenuTextItem.f40608b = z3;
                        arrayList.add(navigationMenuTextItem);
                        i2 = i6;
                    }
                    z = true;
                    NavigationMenuTextItem navigationMenuTextItem2 = new NavigationMenuTextItem(menuItemImpl);
                    navigationMenuTextItem2.f40608b = z3;
                    arrayList.add(navigationMenuTextItem2);
                    i2 = i6;
                }
                i3++;
                z2 = false;
            }
            this.f40600f = z2 ? 1 : 0;
        }

        public final void z(MenuItemImpl menuItemImpl) {
            if (this.f40599e == menuItemImpl || !menuItemImpl.isCheckable()) {
                return;
            }
            MenuItemImpl menuItemImpl2 = this.f40599e;
            if (menuItemImpl2 != null) {
                menuItemImpl2.setChecked(false);
            }
            this.f40599e = menuItemImpl;
            menuItemImpl.setChecked(true);
        }
    }

    public static class NavigationMenuHeaderItem implements NavigationMenuItem {
    }

    public interface NavigationMenuItem {
    }

    public static class NavigationMenuSeparatorItem implements NavigationMenuItem {

        /* renamed from: a, reason: collision with root package name */
        public final int f40605a;

        /* renamed from: b, reason: collision with root package name */
        public final int f40606b;

        public NavigationMenuSeparatorItem(int i2, int i3) {
            this.f40605a = i2;
            this.f40606b = i3;
        }
    }

    public static class NavigationMenuTextItem implements NavigationMenuItem {

        /* renamed from: a, reason: collision with root package name */
        public final MenuItemImpl f40607a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f40608b;

        public NavigationMenuTextItem(MenuItemImpl menuItemImpl) {
            this.f40607a = menuItemImpl;
        }
    }

    public class NavigationMenuViewAccessibilityDelegate extends RecyclerViewAccessibilityDelegate {
        public NavigationMenuViewAccessibilityDelegate(RecyclerView recyclerView) {
            super(recyclerView);
        }

        @Override // androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate, androidx.core.view.AccessibilityDelegateCompat
        public final void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NavigationMenuAdapter navigationMenuAdapter = NavigationMenuPresenter.this.f40588e;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                NavigationMenuPresenter navigationMenuPresenter = NavigationMenuPresenter.this;
                if (i2 >= navigationMenuPresenter.f40588e.f40598d.size()) {
                    accessibilityNodeInfoCompat.o(AccessibilityNodeInfoCompat.CollectionInfoCompat.b(i3, 1, false));
                    return;
                }
                int iF = navigationMenuPresenter.f40588e.f(i2);
                if (iF == 0 || iF == 1) {
                    i3++;
                }
                i2++;
            }
        }
    }

    public static class NormalViewHolder extends ViewHolder {
    }

    public static class SeparatorViewHolder extends ViewHolder {
    }

    public static class SubheaderViewHolder extends ViewHolder {
    }

    public static abstract class ViewHolder extends RecyclerView.ViewHolder {
    }

    public final MenuItemImpl a() {
        return this.f40588e.f40599e;
    }

    public final MenuView b(ViewGroup viewGroup) {
        if (this.f40584a == null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) this.f40589f.inflate(R.layout.design_navigation_menu, viewGroup, false);
            this.f40584a = navigationMenuView;
            navigationMenuView.setAccessibilityDelegateCompat(new NavigationMenuViewAccessibilityDelegate(this.f40584a));
            if (this.f40588e == null) {
                NavigationMenuAdapter navigationMenuAdapter = new NavigationMenuAdapter();
                this.f40588e = navigationMenuAdapter;
                navigationMenuAdapter.w(true);
            }
            int i2 = this.B;
            if (i2 != -1) {
                this.f40584a.setOverScrollMode(i2);
            }
            LinearLayout linearLayout = (LinearLayout) this.f40589f.inflate(R.layout.design_navigation_item_header, (ViewGroup) this.f40584a, false);
            this.f40585b = linearLayout;
            WeakHashMap weakHashMap = ViewCompat.f3080a;
            linearLayout.setImportantForAccessibility(2);
            this.f40584a.setAdapter(this.f40588e);
        }
        return this.f40584a;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void c(MenuBuilder menuBuilder, boolean z) {
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean e(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void f(Parcelable parcelable) {
        MenuItemImpl menuItemImpl;
        View actionView;
        ParcelableSparseArray parcelableSparseArray;
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
            if (sparseParcelableArray != null) {
                this.f40584a.restoreHierarchyState(sparseParcelableArray);
            }
            Bundle bundle2 = bundle.getBundle("android:menu:adapter");
            if (bundle2 != null) {
                NavigationMenuAdapter navigationMenuAdapter = this.f40588e;
                navigationMenuAdapter.getClass();
                int i2 = bundle2.getInt("android:menu:checked", 0);
                ArrayList arrayList = navigationMenuAdapter.f40598d;
                if (i2 != 0) {
                    navigationMenuAdapter.f40600f = true;
                    int size = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            break;
                        }
                        NavigationMenuItem navigationMenuItem = (NavigationMenuItem) arrayList.get(i3);
                        if (navigationMenuItem instanceof NavigationMenuTextItem) {
                            MenuItemImpl menuItemImpl2 = ((NavigationMenuTextItem) navigationMenuItem).f40607a;
                            if (menuItemImpl2.f619a == i2) {
                                navigationMenuAdapter.z(menuItemImpl2);
                                break;
                            }
                        }
                        i3++;
                    }
                    navigationMenuAdapter.f40600f = false;
                    navigationMenuAdapter.y();
                }
                SparseArray sparseParcelableArray2 = bundle2.getSparseParcelableArray("android:menu:action_views");
                if (sparseParcelableArray2 != null) {
                    int size2 = arrayList.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        NavigationMenuItem navigationMenuItem2 = (NavigationMenuItem) arrayList.get(i4);
                        if ((navigationMenuItem2 instanceof NavigationMenuTextItem) && (actionView = (menuItemImpl = ((NavigationMenuTextItem) navigationMenuItem2).f40607a).getActionView()) != null && (parcelableSparseArray = (ParcelableSparseArray) sparseParcelableArray2.get(menuItemImpl.f619a)) != null) {
                            actionView.restoreHierarchyState(parcelableSparseArray);
                        }
                    }
                }
            }
            SparseArray<Parcelable> sparseParcelableArray3 = bundle.getSparseParcelableArray("android:menu:header");
            if (sparseParcelableArray3 != null) {
                this.f40585b.restoreHierarchyState(sparseParcelableArray3);
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean g(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return this.f40587d;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable h() {
        Bundle bundle = new Bundle();
        if (this.f40584a != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.f40584a.saveHierarchyState(sparseArray);
            bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        }
        NavigationMenuAdapter navigationMenuAdapter = this.f40588e;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.getClass();
            Bundle bundle2 = new Bundle();
            MenuItemImpl menuItemImpl = navigationMenuAdapter.f40599e;
            if (menuItemImpl != null) {
                bundle2.putInt("android:menu:checked", menuItemImpl.f619a);
            }
            SparseArray<? extends Parcelable> sparseArray2 = new SparseArray<>();
            ArrayList arrayList = navigationMenuAdapter.f40598d;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                NavigationMenuItem navigationMenuItem = (NavigationMenuItem) arrayList.get(i2);
                if (navigationMenuItem instanceof NavigationMenuTextItem) {
                    MenuItemImpl menuItemImpl2 = ((NavigationMenuTextItem) navigationMenuItem).f40607a;
                    View actionView = menuItemImpl2 != null ? menuItemImpl2.getActionView() : null;
                    if (actionView != null) {
                        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                        actionView.saveHierarchyState(parcelableSparseArray);
                        sparseArray2.put(menuItemImpl2.f619a, parcelableSparseArray);
                    }
                }
            }
            bundle2.putSparseParcelableArray("android:menu:action_views", sparseArray2);
            bundle.putBundle("android:menu:adapter", bundle2);
        }
        if (this.f40585b != null) {
            SparseArray<Parcelable> sparseArray3 = new SparseArray<>();
            this.f40585b.saveHierarchyState(sparseArray3);
            bundle.putSparseParcelableArray("android:menu:header", sparseArray3);
        }
        return bundle;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean i(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void j(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.f40588e;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.y();
            navigationMenuAdapter.g();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean k() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void l(Context context, MenuBuilder menuBuilder) {
        this.f40589f = LayoutInflater.from(context);
        this.f40586c = menuBuilder;
        this.A = context.getResources().getDimensionPixelOffset(R.dimen.design_navigation_separator_vertical_padding);
    }

    public final void m(MenuItemImpl menuItemImpl) {
        this.f40588e.z(menuItemImpl);
    }

    public final void n(boolean z) {
        NavigationMenuAdapter navigationMenuAdapter = this.f40588e;
        if (navigationMenuAdapter != null) {
            navigationMenuAdapter.f40600f = z;
        }
    }
}
