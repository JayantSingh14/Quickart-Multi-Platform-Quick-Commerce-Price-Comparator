package com.google.android.material.navigation;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MenuItem;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;

@RestrictTo
/* loaded from: classes4.dex */
public class NavigationBarPresenter implements MenuPresenter {

    /* renamed from: a, reason: collision with root package name */
    public NavigationBarMenuView f40732a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f40733b = false;

    /* renamed from: c, reason: collision with root package name */
    public int f40734c;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f40735a;

        /* renamed from: b, reason: collision with root package name */
        public ParcelableSparseArray f40736b;

        /* renamed from: com.google.android.material.navigation.NavigationBarPresenter$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState();
                savedState.f40735a = parcel.readInt();
                savedState.f40736b = (ParcelableSparseArray) parcel.readParcelable(SavedState.class.getClassLoader());
                return savedState;
            }

            @Override // android.os.Parcelable.Creator
            public final SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f40735a);
            parcel.writeParcelable(this.f40736b, 0);
        }
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
        SparseArray sparseArray;
        if (parcelable instanceof SavedState) {
            NavigationBarMenuView navigationBarMenuView = this.f40732a;
            SavedState savedState = (SavedState) parcelable;
            int i2 = savedState.f40735a;
            int size = navigationBarMenuView.E.f608f.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    break;
                }
                MenuItem item = navigationBarMenuView.E.getItem(i3);
                if (i2 == item.getItemId()) {
                    navigationBarMenuView.f40724g = i2;
                    navigationBarMenuView.f40725h = i3;
                    item.setChecked(true);
                    break;
                }
                i3++;
            }
            Context context = this.f40732a.getContext();
            ParcelableSparseArray parcelableSparseArray = savedState.f40736b;
            SparseArray sparseArray2 = new SparseArray(parcelableSparseArray.size());
            for (int i4 = 0; i4 < parcelableSparseArray.size(); i4++) {
                int iKeyAt = parcelableSparseArray.keyAt(i4);
                BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i4);
                sparseArray2.put(iKeyAt, state != null ? new BadgeDrawable(context, state) : null);
            }
            NavigationBarMenuView navigationBarMenuView2 = this.f40732a;
            navigationBarMenuView2.getClass();
            int i5 = 0;
            while (true) {
                int size2 = sparseArray2.size();
                sparseArray = navigationBarMenuView2.s;
                if (i5 >= size2) {
                    break;
                }
                int iKeyAt2 = sparseArray2.keyAt(i5);
                if (sparseArray.indexOfKey(iKeyAt2) < 0) {
                    sparseArray.append(iKeyAt2, (BadgeDrawable) sparseArray2.get(iKeyAt2));
                }
                i5++;
            }
            NavigationBarItemView[] navigationBarItemViewArr = navigationBarMenuView2.f40723f;
            if (navigationBarItemViewArr != null) {
                for (NavigationBarItemView navigationBarItemView : navigationBarItemViewArr) {
                    BadgeDrawable badgeDrawable = (BadgeDrawable) sparseArray.get(navigationBarItemView.getId());
                    if (badgeDrawable != null) {
                        navigationBarItemView.setBadge(badgeDrawable);
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean g(SubMenuBuilder subMenuBuilder) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final int getId() {
        return this.f40734c;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable h() {
        SavedState savedState = new SavedState();
        savedState.f40735a = this.f40732a.getSelectedItemId();
        SparseArray<BadgeDrawable> badgeDrawables = this.f40732a.getBadgeDrawables();
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i2 = 0; i2 < badgeDrawables.size(); i2++) {
            int iKeyAt = badgeDrawables.keyAt(i2);
            BadgeDrawable badgeDrawableValueAt = badgeDrawables.valueAt(i2);
            parcelableSparseArray.put(iKeyAt, badgeDrawableValueAt != null ? badgeDrawableValueAt.f39917e.f39926a : null);
        }
        savedState.f40736b = parcelableSparseArray;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean i(MenuItemImpl menuItemImpl) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void j(boolean z) {
        AutoTransition autoTransition;
        if (this.f40733b) {
            return;
        }
        if (z) {
            this.f40732a.b();
            return;
        }
        NavigationBarMenuView navigationBarMenuView = this.f40732a;
        MenuBuilder menuBuilder = navigationBarMenuView.E;
        if (menuBuilder == null || navigationBarMenuView.f40723f == null) {
            return;
        }
        int size = menuBuilder.f608f.size();
        if (size != navigationBarMenuView.f40723f.length) {
            navigationBarMenuView.b();
            return;
        }
        int i2 = navigationBarMenuView.f40724g;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = navigationBarMenuView.E.getItem(i3);
            if (item.isChecked()) {
                navigationBarMenuView.f40724g = item.getItemId();
                navigationBarMenuView.f40725h = i3;
            }
        }
        if (i2 != navigationBarMenuView.f40724g && (autoTransition = navigationBarMenuView.f40718a) != null) {
            TransitionManager.a(navigationBarMenuView, autoTransition);
        }
        boolean zF = NavigationBarMenuView.f(navigationBarMenuView.f40722e, navigationBarMenuView.E.m().size());
        for (int i4 = 0; i4 < size; i4++) {
            navigationBarMenuView.D.f40733b = true;
            navigationBarMenuView.f40723f[i4].setLabelVisibilityMode(navigationBarMenuView.f40722e);
            navigationBarMenuView.f40723f[i4].setShifting(zF);
            navigationBarMenuView.f40723f[i4].c((MenuItemImpl) navigationBarMenuView.E.getItem(i4));
            navigationBarMenuView.D.f40733b = false;
        }
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final boolean k() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void l(Context context, MenuBuilder menuBuilder) {
        this.f40732a.E = menuBuilder;
    }
}
