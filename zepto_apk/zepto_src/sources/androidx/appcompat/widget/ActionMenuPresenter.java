package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPopup;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.ShowableListMenu;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

/* loaded from: classes3.dex */
class ActionMenuPresenter extends BaseMenuPresenter implements ActionProvider.SubUiVisibilityListener {

    /* renamed from: j, reason: collision with root package name */
    public OverflowMenuButton f716j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f717k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f718l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f719m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public final SparseBooleanArray s;
    public OverflowPopup t;
    public ActionButtonSubmenu u;
    public OpenOverflowRunnable v;
    public ActionMenuPopupCallback w;
    public final PopupPresenterCallback x;
    public int y;

    public class ActionButtonSubmenu extends MenuPopupHelper {
        public ActionButtonSubmenu(Context context, SubMenuBuilder subMenuBuilder, View view) {
            super(R.attr.actionOverflowMenuStyle, context, view, subMenuBuilder, false);
            if ((subMenuBuilder.A.x & 32) != 32) {
                View view2 = ActionMenuPresenter.this.f716j;
                this.f648e = view2 == null ? (View) ActionMenuPresenter.this.f546h : view2;
            }
            PopupPresenterCallback popupPresenterCallback = ActionMenuPresenter.this.x;
            this.f651h = popupPresenterCallback;
            MenuPopup menuPopup = this.f652i;
            if (menuPopup != null) {
                menuPopup.d(popupPresenterCallback);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.u = null;
            actionMenuPresenter.y = 0;
            super.c();
        }
    }

    public class ActionMenuPopupCallback extends ActionMenuItemView.PopupCallback {
        public ActionMenuPopupCallback() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.PopupCallback
        public final ShowableListMenu a() {
            ActionButtonSubmenu actionButtonSubmenu = ActionMenuPresenter.this.u;
            if (actionButtonSubmenu != null) {
                return actionButtonSubmenu.a();
            }
            return null;
        }
    }

    public class OpenOverflowRunnable implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final OverflowPopup f722a;

        public OpenOverflowRunnable(OverflowPopup overflowPopup) {
            this.f722a = overflowPopup;
        }

        @Override // java.lang.Runnable
        public final void run() {
            MenuBuilder.Callback callback;
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.f541c;
            if (menuBuilder != null && (callback = menuBuilder.f607e) != null) {
                callback.b(menuBuilder);
            }
            View view = (View) actionMenuPresenter.f546h;
            if (view != null && view.getWindowToken() != null) {
                OverflowPopup overflowPopup = this.f722a;
                if (overflowPopup.b()) {
                    actionMenuPresenter.t = overflowPopup;
                } else if (overflowPopup.f648e != null) {
                    overflowPopup.e(0, 0, false, false);
                    actionMenuPresenter.t = overflowPopup;
                }
            }
            actionMenuPresenter.v = null;
        }
    }

    public class OverflowMenuButton extends AppCompatImageView implements ActionMenuView.ActionMenuChildView {
        public OverflowMenuButton(Context context) {
            super(context, null, R.attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            TooltipCompat.a(this, getContentDescription());
            setOnTouchListener(new ForwardingListener(this) { // from class: androidx.appcompat.widget.ActionMenuPresenter.OverflowMenuButton.1
                @Override // androidx.appcompat.widget.ForwardingListener
                public final ShowableListMenu b() {
                    OverflowPopup overflowPopup = ActionMenuPresenter.this.t;
                    if (overflowPopup == null) {
                        return null;
                    }
                    return overflowPopup.a();
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public final boolean c() {
                    ActionMenuPresenter.this.r();
                    return true;
                }

                @Override // androidx.appcompat.widget.ForwardingListener
                public final boolean d() {
                    ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                    if (actionMenuPresenter.v != null) {
                        return false;
                    }
                    actionMenuPresenter.o();
                    return true;
                }
            });
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public final boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.ActionMenuChildView
        public final boolean b() {
            return false;
        }

        @Override // android.view.View
        public final boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.r();
            return true;
        }

        @Override // android.widget.ImageView
        public final boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int iMax = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - iMax, paddingTop - iMax, paddingLeft + iMax, paddingTop + iMax);
            }
            return frame;
        }
    }

    public class OverflowPopup extends MenuPopupHelper {
        public OverflowPopup(Context context, MenuBuilder menuBuilder, View view) {
            super(R.attr.actionOverflowMenuStyle, context, view, menuBuilder, true);
            this.f649f = 8388613;
            PopupPresenterCallback popupPresenterCallback = ActionMenuPresenter.this.x;
            this.f651h = popupPresenterCallback;
            MenuPopup menuPopup = this.f652i;
            if (menuPopup != null) {
                menuPopup.d(popupPresenterCallback);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPopupHelper
        public final void c() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            MenuBuilder menuBuilder = actionMenuPresenter.f541c;
            if (menuBuilder != null) {
                menuBuilder.d(true);
            }
            actionMenuPresenter.t = null;
            super.c();
        }
    }

    public class PopupPresenterCallback implements MenuPresenter.Callback {
        public PopupPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void c(MenuBuilder menuBuilder, boolean z) {
            if (menuBuilder instanceof SubMenuBuilder) {
                ((SubMenuBuilder) menuBuilder).z.l().d(false);
            }
            MenuPresenter.Callback callback = ActionMenuPresenter.this.f543e;
            if (callback != null) {
                callback.c(menuBuilder, z);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean d(MenuBuilder menuBuilder) {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            if (menuBuilder == actionMenuPresenter.f541c) {
                return false;
            }
            actionMenuPresenter.y = ((SubMenuBuilder) menuBuilder).A.f619a;
            MenuPresenter.Callback callback = actionMenuPresenter.f543e;
            if (callback != null) {
                return callback.d(menuBuilder);
            }
            return false;
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: a, reason: collision with root package name */
        public int f728a;

        /* renamed from: androidx.appcompat.widget.ActionMenuPresenter$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public final SavedState createFromParcel(Parcel parcel) {
                SavedState savedState = new SavedState();
                savedState.f728a = parcel.readInt();
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
            parcel.writeInt(this.f728a);
        }
    }

    public ActionMenuPresenter(Context context) {
        int i2 = R.layout.abc_action_menu_layout;
        int i3 = R.layout.abc_action_menu_item_layout;
        this.f539a = context;
        this.f542d = LayoutInflater.from(context);
        this.f544f = i2;
        this.f545g = i3;
        this.s = new SparseBooleanArray();
        this.x = new PopupPresenterCallback();
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final void a(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.c(menuItemImpl);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) itemView;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f546h);
        if (this.w == null) {
            this.w = new ActionMenuPopupCallback();
        }
        actionMenuItemView.setPopupCallback(this.w);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final boolean b(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.f716j) {
            return false;
        }
        viewGroup.removeViewAt(i2);
        return true;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final void c(MenuBuilder menuBuilder, boolean z) {
        o();
        ActionButtonSubmenu actionButtonSubmenu = this.u;
        if (actionButtonSubmenu != null && actionButtonSubmenu.b()) {
            actionButtonSubmenu.f652i.dismiss();
        }
        super.c(menuBuilder, z);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final void f(Parcelable parcelable) {
        int i2;
        MenuItem menuItemFindItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).f728a) > 0 && (menuItemFindItem = this.f541c.findItem(i2)) != null) {
            g((SubMenuBuilder) menuItemFindItem.getSubMenu());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final boolean g(SubMenuBuilder subMenuBuilder) {
        boolean z;
        if (subMenuBuilder.hasVisibleItems()) {
            SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
            while (true) {
                MenuBuilder menuBuilder = subMenuBuilder2.z;
                if (menuBuilder == this.f541c) {
                    break;
                }
                subMenuBuilder2 = (SubMenuBuilder) menuBuilder;
            }
            ViewGroup viewGroup = (ViewGroup) this.f546h;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (true) {
                    if (i2 >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i2);
                    if ((childAt instanceof MenuView.ItemView) && ((MenuView.ItemView) childAt).getItemData() == subMenuBuilder2.A) {
                        view = childAt;
                        break;
                    }
                    i2++;
                }
            }
            if (view != null) {
                this.y = subMenuBuilder.A.f619a;
                int size = subMenuBuilder.f608f.size();
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = subMenuBuilder.getItem(i3);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i3++;
                }
                ActionButtonSubmenu actionButtonSubmenu = new ActionButtonSubmenu(this.f540b, subMenuBuilder, view);
                this.u = actionButtonSubmenu;
                actionButtonSubmenu.d(z);
                ActionButtonSubmenu actionButtonSubmenu2 = this.u;
                if (!actionButtonSubmenu2.b()) {
                    if (actionButtonSubmenu2.f648e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    actionButtonSubmenu2.e(0, 0, false, false);
                }
                super.g(subMenuBuilder);
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter
    public final Parcelable h() {
        SavedState savedState = new SavedState();
        savedState.f728a = this.y;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final void j(boolean z) {
        ArrayList arrayList;
        super.j(z);
        ((View) this.f546h).requestLayout();
        MenuBuilder menuBuilder = this.f541c;
        boolean z2 = false;
        if (menuBuilder != null) {
            menuBuilder.j();
            ArrayList arrayList2 = menuBuilder.f611i;
            int size = arrayList2.size();
            for (int i2 = 0; i2 < size; i2++) {
                ActionProvider actionProvider = ((MenuItemImpl) arrayList2.get(i2)).A;
                if (actionProvider != null) {
                    actionProvider.f3016a = this;
                }
            }
        }
        MenuBuilder menuBuilder2 = this.f541c;
        if (menuBuilder2 != null) {
            menuBuilder2.j();
            arrayList = menuBuilder2.f612j;
        } else {
            arrayList = null;
        }
        if (this.f719m && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z2 = !((MenuItemImpl) arrayList.get(0)).C;
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.f716j == null) {
                this.f716j = new OverflowMenuButton(this.f539a);
            }
            ViewGroup viewGroup = (ViewGroup) this.f716j.getParent();
            if (viewGroup != this.f546h) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f716j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f546h;
                OverflowMenuButton overflowMenuButton = this.f716j;
                actionMenuView.getClass();
                ActionMenuView.LayoutParams layoutParamsL = ActionMenuView.l();
                layoutParamsL.f729a = true;
                actionMenuView.addView(overflowMenuButton, layoutParamsL);
            }
        } else {
            OverflowMenuButton overflowMenuButton2 = this.f716j;
            if (overflowMenuButton2 != null) {
                Object parent = overflowMenuButton2.getParent();
                Object obj = this.f546h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.f716j);
                }
            }
        }
        ((ActionMenuView) this.f546h).setOverflowReserved(this.f719m);
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final boolean k() {
        int size;
        ArrayList arrayListM;
        int i2;
        boolean z;
        ActionMenuPresenter actionMenuPresenter = this;
        MenuBuilder menuBuilder = actionMenuPresenter.f541c;
        if (menuBuilder != null) {
            arrayListM = menuBuilder.m();
            size = arrayListM.size();
        } else {
            size = 0;
            arrayListM = null;
        }
        int i3 = actionMenuPresenter.q;
        int i4 = actionMenuPresenter.p;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.f546h;
        int i5 = 0;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= size) {
                break;
            }
            MenuItemImpl menuItemImpl = (MenuItemImpl) arrayListM.get(i5);
            int i8 = menuItemImpl.y;
            if ((i8 & 2) == 2) {
                i6++;
            } else if ((i8 & 1) == 1) {
                i7++;
            } else {
                z2 = true;
            }
            if (actionMenuPresenter.r && menuItemImpl.C) {
                i3 = 0;
            }
            i5++;
        }
        if (actionMenuPresenter.f719m && (z2 || i7 + i6 > i3)) {
            i3--;
        }
        int i9 = i3 - i6;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.s;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            MenuItemImpl menuItemImpl2 = (MenuItemImpl) arrayListM.get(i10);
            int i12 = menuItemImpl2.y;
            boolean z3 = (i12 & 2) == i2 ? z : false;
            int i13 = menuItemImpl2.f620b;
            if (z3) {
                View viewM = actionMenuPresenter.m(menuItemImpl2, null, viewGroup);
                viewM.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredWidth = viewM.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                menuItemImpl2.g(z);
            } else if ((i12 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i13);
                boolean z5 = ((i9 > 0 || z4) && i4 > 0) ? z : false;
                if (z5) {
                    View viewM2 = actionMenuPresenter.m(menuItemImpl2, null, viewGroup);
                    viewM2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                    int measuredWidth2 = viewM2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z5 &= i4 + i11 > 0;
                }
                if (z5 && i13 != 0) {
                    sparseBooleanArray.put(i13, true);
                } else if (z4) {
                    sparseBooleanArray.put(i13, false);
                    for (int i14 = 0; i14 < i10; i14++) {
                        MenuItemImpl menuItemImpl3 = (MenuItemImpl) arrayListM.get(i14);
                        if (menuItemImpl3.f620b == i13) {
                            if ((menuItemImpl3.x & 32) == 32) {
                                i9++;
                            }
                            menuItemImpl3.g(false);
                        }
                    }
                }
                if (z5) {
                    i9--;
                }
                menuItemImpl2.g(z5);
            } else {
                menuItemImpl2.g(false);
                i10++;
                i2 = 2;
                actionMenuPresenter = this;
                z = true;
            }
            i10++;
            i2 = 2;
            actionMenuPresenter = this;
            z = true;
        }
        return z;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter, androidx.appcompat.view.menu.MenuPresenter
    public final void l(Context context, MenuBuilder menuBuilder) {
        super.l(context, menuBuilder);
        Resources resources = context.getResources();
        ActionBarPolicy actionBarPolicy = new ActionBarPolicy();
        actionBarPolicy.f466a = context;
        if (!this.n) {
            this.f719m = true;
        }
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        this.q = actionBarPolicy.a();
        int measuredWidth = this.o;
        if (this.f719m) {
            if (this.f716j == null) {
                OverflowMenuButton overflowMenuButton = new OverflowMenuButton(this.f539a);
                this.f716j = overflowMenuButton;
                if (this.f718l) {
                    overflowMenuButton.setImageDrawable(this.f717k);
                    this.f717k = null;
                    this.f718l = false;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f716j.measure(iMakeMeasureSpec, iMakeMeasureSpec);
            }
            measuredWidth -= this.f716j.getMeasuredWidth();
        } else {
            this.f716j = null;
        }
        this.p = measuredWidth;
        float f2 = resources.getDisplayMetrics().density;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final View m(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View actionView = menuItemImpl.getActionView();
        if (actionView == null || menuItemImpl.e()) {
            actionView = super.m(menuItemImpl, view, viewGroup);
        }
        actionView.setVisibility(menuItemImpl.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof ActionMenuView.LayoutParams)) {
            actionView.setLayoutParams(ActionMenuView.m(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.BaseMenuPresenter
    public final boolean n(MenuItemImpl menuItemImpl) {
        return (menuItemImpl.x & 32) == 32;
    }

    public final boolean o() {
        Object obj;
        OpenOverflowRunnable openOverflowRunnable = this.v;
        if (openOverflowRunnable != null && (obj = this.f546h) != null) {
            ((View) obj).removeCallbacks(openOverflowRunnable);
            this.v = null;
            return true;
        }
        OverflowPopup overflowPopup = this.t;
        if (overflowPopup == null) {
            return false;
        }
        if (overflowPopup.b()) {
            overflowPopup.f652i.dismiss();
        }
        return true;
    }

    public final boolean p() {
        OverflowPopup overflowPopup = this.t;
        return overflowPopup != null && overflowPopup.b();
    }

    public final void q(boolean z) {
        if (z) {
            super.g(null);
            return;
        }
        MenuBuilder menuBuilder = this.f541c;
        if (menuBuilder != null) {
            menuBuilder.d(false);
        }
    }

    public final boolean r() {
        MenuBuilder menuBuilder;
        if (!this.f719m || p() || (menuBuilder = this.f541c) == null || this.f546h == null || this.v != null) {
            return false;
        }
        menuBuilder.j();
        if (menuBuilder.f612j.isEmpty()) {
            return false;
        }
        OpenOverflowRunnable openOverflowRunnable = new OpenOverflowRunnable(new OverflowPopup(this.f540b, this.f541c, this.f716j));
        this.v = openOverflowRunnable;
        ((View) this.f546h).post(openOverflowRunnable);
        return true;
    }
}
