package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.k;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.R;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.CollapsibleActionView;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuHostHelper;
import androidx.core.view.MenuProvider;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes3.dex */
public class Toolbar extends ViewGroup implements MenuHost {
    public ColorStateList A;
    public MenuBuilder.Callback A0;
    public boolean B;
    public boolean B0;
    public boolean C;
    public OnBackInvokedCallback C0;
    public final ArrayList D;
    public OnBackInvokedDispatcher D0;
    public final ArrayList E;
    public boolean E0;
    public final int[] F;
    public final Runnable F0;
    public final MenuHostHelper G;
    public ArrayList H;
    public OnMenuItemClickListener I;
    public final ActionMenuView.OnMenuItemClickListener J;
    public ToolbarWidgetWrapper K;
    public ActionMenuPresenter L;
    public ExpandedActionViewMenuPresenter M;
    public MenuPresenter.Callback Q;

    /* renamed from: a, reason: collision with root package name */
    public ActionMenuView f1187a;

    /* renamed from: b, reason: collision with root package name */
    public AppCompatTextView f1188b;

    /* renamed from: c, reason: collision with root package name */
    public AppCompatTextView f1189c;

    /* renamed from: d, reason: collision with root package name */
    public AppCompatImageButton f1190d;

    /* renamed from: e, reason: collision with root package name */
    public AppCompatImageView f1191e;

    /* renamed from: f, reason: collision with root package name */
    public final Drawable f1192f;

    /* renamed from: g, reason: collision with root package name */
    public final CharSequence f1193g;

    /* renamed from: h, reason: collision with root package name */
    public AppCompatImageButton f1194h;

    /* renamed from: i, reason: collision with root package name */
    public View f1195i;

    /* renamed from: j, reason: collision with root package name */
    public Context f1196j;

    /* renamed from: k, reason: collision with root package name */
    public int f1197k;

    /* renamed from: l, reason: collision with root package name */
    public int f1198l;

    /* renamed from: m, reason: collision with root package name */
    public int f1199m;
    public final int n;
    public final int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public RtlSpacingHelper t;
    public int u;
    public int v;
    public final int w;
    public CharSequence x;
    public CharSequence y;
    public ColorStateList z;

    @RequiresApi
    public static class Api33Impl {
        @Nullable
        @DoNotInline
        public static OnBackInvokedDispatcher a(@NonNull View view) {
            return view.findOnBackInvokedDispatcher();
        }

        @NonNull
        @DoNotInline
        public static OnBackInvokedCallback b(@NonNull final Runnable runnable) {
            Objects.requireNonNull(runnable);
            return new OnBackInvokedCallback() { // from class: androidx.appcompat.widget.d
                public final void onBackInvoked() {
                    runnable.run();
                }
            };
        }

        @DoNotInline
        public static void c(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(1000000, (OnBackInvokedCallback) obj2);
        }

        @DoNotInline
        public static void d(@NonNull Object obj, @NonNull Object obj2) {
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    public class ExpandedActionViewMenuPresenter implements MenuPresenter {

        /* renamed from: a, reason: collision with root package name */
        public MenuBuilder f1204a;

        /* renamed from: b, reason: collision with root package name */
        public MenuItemImpl f1205b;

        public ExpandedActionViewMenuPresenter() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void c(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean e(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = Toolbar.this;
            KeyEvent.Callback callback = toolbar.f1195i;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).e();
            }
            toolbar.removeView(toolbar.f1195i);
            toolbar.removeView(toolbar.f1194h);
            toolbar.f1195i = null;
            ArrayList arrayList = toolbar.E;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                toolbar.addView((View) arrayList.get(size));
            }
            arrayList.clear();
            this.f1205b = null;
            toolbar.requestLayout();
            menuItemImpl.C = false;
            menuItemImpl.n.q(false);
            toolbar.y();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void f(Parcelable parcelable) {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean g(SubMenuBuilder subMenuBuilder) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final int getId() {
            return 0;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final Parcelable h() {
            return null;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean i(MenuItemImpl menuItemImpl) {
            Toolbar toolbar = Toolbar.this;
            toolbar.c();
            ViewParent parent = toolbar.f1194h.getParent();
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f1194h);
                }
                toolbar.addView(toolbar.f1194h);
            }
            View actionView = menuItemImpl.getActionView();
            toolbar.f1195i = actionView;
            this.f1205b = menuItemImpl;
            ViewParent parent2 = actionView.getParent();
            if (parent2 != toolbar) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar.f1195i);
                }
                LayoutParams layoutParamsH = Toolbar.h();
                layoutParamsH.f243a = (toolbar.n & 112) | 8388611;
                layoutParamsH.f1220b = 2;
                toolbar.f1195i.setLayoutParams(layoutParamsH);
                toolbar.addView(toolbar.f1195i);
            }
            for (int childCount = toolbar.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = toolbar.getChildAt(childCount);
                if (((LayoutParams) childAt.getLayoutParams()).f1220b != 2 && childAt != toolbar.f1187a) {
                    toolbar.removeViewAt(childCount);
                    toolbar.E.add(childAt);
                }
            }
            toolbar.requestLayout();
            menuItemImpl.C = true;
            menuItemImpl.n.q(false);
            KeyEvent.Callback callback = toolbar.f1195i;
            if (callback instanceof CollapsibleActionView) {
                ((CollapsibleActionView) callback).b();
            }
            toolbar.y();
            return true;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void j(boolean z) {
            if (this.f1205b != null) {
                MenuBuilder menuBuilder = this.f1204a;
                if (menuBuilder != null) {
                    int size = menuBuilder.f608f.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        if (this.f1204a.getItem(i2) == this.f1205b) {
                            return;
                        }
                    }
                }
                e(this.f1205b);
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final boolean k() {
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter
        public final void l(Context context, MenuBuilder menuBuilder) {
            MenuItemImpl menuItemImpl;
            MenuBuilder menuBuilder2 = this.f1204a;
            if (menuBuilder2 != null && (menuItemImpl = this.f1205b) != null) {
                menuBuilder2.e(menuItemImpl);
            }
            this.f1204a = menuBuilder;
        }
    }

    @RequiresApi
    @RestrictTo
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1207a = false;

        /* renamed from: b, reason: collision with root package name */
        public int f1208b;

        /* renamed from: c, reason: collision with root package name */
        public int f1209c;

        /* renamed from: d, reason: collision with root package name */
        public int f1210d;

        /* renamed from: e, reason: collision with root package name */
        public int f1211e;

        /* renamed from: f, reason: collision with root package name */
        public int f1212f;

        /* renamed from: g, reason: collision with root package name */
        public int f1213g;

        /* renamed from: h, reason: collision with root package name */
        public int f1214h;

        /* renamed from: i, reason: collision with root package name */
        public int f1215i;

        /* renamed from: j, reason: collision with root package name */
        public int f1216j;

        /* renamed from: k, reason: collision with root package name */
        public int f1217k;

        /* renamed from: l, reason: collision with root package name */
        public int f1218l;

        /* renamed from: m, reason: collision with root package name */
        public int f1219m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;

        public final void mapProperties(PropertyMapper propertyMapper) {
            this.f1208b = propertyMapper.mapObject("collapseContentDescription", R.attr.collapseContentDescription);
            this.f1209c = propertyMapper.mapObject("collapseIcon", R.attr.collapseIcon);
            this.f1210d = propertyMapper.mapInt("contentInsetEnd", R.attr.contentInsetEnd);
            this.f1211e = propertyMapper.mapInt("contentInsetEndWithActions", R.attr.contentInsetEndWithActions);
            this.f1212f = propertyMapper.mapInt("contentInsetLeft", R.attr.contentInsetLeft);
            this.f1213g = propertyMapper.mapInt("contentInsetRight", R.attr.contentInsetRight);
            this.f1214h = propertyMapper.mapInt("contentInsetStart", R.attr.contentInsetStart);
            this.f1215i = propertyMapper.mapInt("contentInsetStartWithNavigation", R.attr.contentInsetStartWithNavigation);
            this.f1216j = propertyMapper.mapObject("logo", R.attr.logo);
            this.f1217k = propertyMapper.mapObject("logoDescription", R.attr.logoDescription);
            this.f1218l = propertyMapper.mapObject("menu", R.attr.menu);
            this.f1219m = propertyMapper.mapObject("navigationContentDescription", R.attr.navigationContentDescription);
            this.n = propertyMapper.mapObject("navigationIcon", R.attr.navigationIcon);
            this.o = propertyMapper.mapResourceId("popupTheme", R.attr.popupTheme);
            this.p = propertyMapper.mapObject("subtitle", R.attr.subtitle);
            this.q = propertyMapper.mapObject("title", R.attr.title);
            this.r = propertyMapper.mapInt("titleMarginBottom", R.attr.titleMarginBottom);
            this.s = propertyMapper.mapInt("titleMarginEnd", R.attr.titleMarginEnd);
            this.t = propertyMapper.mapInt("titleMarginStart", R.attr.titleMarginStart);
            this.u = propertyMapper.mapInt("titleMarginTop", R.attr.titleMarginTop);
            this.f1207a = true;
        }

        public final void readProperties(Object obj, PropertyReader propertyReader) {
            Toolbar toolbar = (Toolbar) obj;
            if (!this.f1207a) {
                throw k.e();
            }
            propertyReader.readObject(this.f1208b, toolbar.getCollapseContentDescription());
            propertyReader.readObject(this.f1209c, toolbar.getCollapseIcon());
            propertyReader.readInt(this.f1210d, toolbar.getContentInsetEnd());
            propertyReader.readInt(this.f1211e, toolbar.getContentInsetEndWithActions());
            propertyReader.readInt(this.f1212f, toolbar.getContentInsetLeft());
            propertyReader.readInt(this.f1213g, toolbar.getContentInsetRight());
            propertyReader.readInt(this.f1214h, toolbar.getContentInsetStart());
            propertyReader.readInt(this.f1215i, toolbar.getContentInsetStartWithNavigation());
            propertyReader.readObject(this.f1216j, toolbar.getLogo());
            propertyReader.readObject(this.f1217k, toolbar.getLogoDescription());
            propertyReader.readObject(this.f1218l, toolbar.getMenu());
            propertyReader.readObject(this.f1219m, toolbar.getNavigationContentDescription());
            propertyReader.readObject(this.n, toolbar.getNavigationIcon());
            propertyReader.readResourceId(this.o, toolbar.getPopupTheme());
            propertyReader.readObject(this.p, toolbar.getSubtitle());
            propertyReader.readObject(this.q, toolbar.getTitle());
            propertyReader.readInt(this.r, toolbar.getTitleMarginBottom());
            propertyReader.readInt(this.s, toolbar.getTitleMarginEnd());
            propertyReader.readInt(this.t, toolbar.getTitleMarginStart());
            propertyReader.readInt(this.u, toolbar.getTitleMarginTop());
        }
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

        /* renamed from: c, reason: collision with root package name */
        public int f1221c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1222d;

        /* renamed from: androidx.appcompat.widget.Toolbar$SavedState$1, reason: invalid class name */
        public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public final Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1221c = parcel.readInt();
            this.f1222d = parcel.readInt() != 0;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.f1221c);
            parcel.writeInt(this.f1222d ? 1 : 0);
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.toolbarStyle);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i2 = 0; i2 < menu.size(); i2++) {
            arrayList.add(menu.getItem(i2));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new SupportMenuInflater(getContext());
    }

    public static LayoutParams h() {
        return new LayoutParams(-2);
    }

    public static LayoutParams i(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            LayoutParams layoutParams3 = new LayoutParams(layoutParams2);
            layoutParams3.f1220b = 0;
            layoutParams3.f1220b = layoutParams2.f1220b;
            return layoutParams3;
        }
        if (layoutParams instanceof ActionBar.LayoutParams) {
            LayoutParams layoutParams4 = new LayoutParams((ActionBar.LayoutParams) layoutParams);
            layoutParams4.f1220b = 0;
            return layoutParams4;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            LayoutParams layoutParams5 = new LayoutParams(layoutParams);
            layoutParams5.f1220b = 0;
            return layoutParams5;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        LayoutParams layoutParams6 = new LayoutParams(marginLayoutParams);
        layoutParams6.f1220b = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams6).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) layoutParams6).bottomMargin = marginLayoutParams.bottomMargin;
        return layoutParams6;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i2, ArrayList arrayList) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f1220b == 0 && w(childAt)) {
                    int i4 = layoutParams.f243a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i4, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i5 = childCount - 1; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
            if (layoutParams2.f1220b == 0 && w(childAt2)) {
                int i6 = layoutParams2.f243a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i6, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // androidx.core.view.MenuHost
    public final void addMenuProvider(MenuProvider menuProvider) {
        MenuHostHelper menuHostHelper = this.G;
        menuHostHelper.f3047b.add(menuProvider);
        menuHostHelper.f3046a.run();
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        LayoutParams layoutParamsH = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (LayoutParams) layoutParams;
        layoutParamsH.f1220b = 1;
        if (!z || this.f1195i == null) {
            addView(view, layoutParamsH);
        } else {
            view.setLayoutParams(layoutParamsH);
            this.E.add(view);
        }
    }

    public final void c() {
        if (this.f1194h == null) {
            AppCompatImageButton appCompatImageButton = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.f1194h = appCompatImageButton;
            appCompatImageButton.setImageDrawable(this.f1192f);
            this.f1194h.setContentDescription(this.f1193g);
            LayoutParams layoutParamsH = h();
            layoutParamsH.f243a = (this.n & 112) | 8388611;
            layoutParamsH.f1220b = 2;
            this.f1194h.setLayoutParams(layoutParamsH);
            this.f1194h.setOnClickListener(new View.OnClickListener() { // from class: androidx.appcompat.widget.Toolbar.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = Toolbar.this.M;
                    MenuItemImpl menuItemImpl = expandedActionViewMenuPresenter == null ? null : expandedActionViewMenuPresenter.f1205b;
                    if (menuItemImpl != null) {
                        menuItemImpl.collapseActionView();
                    }
                }
            });
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    public final void d() {
        if (this.t == null) {
            RtlSpacingHelper rtlSpacingHelper = new RtlSpacingHelper();
            rtlSpacingHelper.f1100a = 0;
            rtlSpacingHelper.f1101b = 0;
            rtlSpacingHelper.f1102c = Integer.MIN_VALUE;
            rtlSpacingHelper.f1103d = Integer.MIN_VALUE;
            rtlSpacingHelper.f1104e = 0;
            rtlSpacingHelper.f1105f = 0;
            rtlSpacingHelper.f1106g = false;
            rtlSpacingHelper.f1107h = false;
            this.t = rtlSpacingHelper;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f1187a;
        if (actionMenuView.p == null) {
            MenuBuilder menuBuilder = (MenuBuilder) actionMenuView.getMenu();
            if (this.M == null) {
                this.M = new ExpandedActionViewMenuPresenter();
            }
            this.f1187a.setExpandedActionViewsExclusive(true);
            menuBuilder.c(this.M, this.f1196j);
            y();
        }
    }

    public final void f() {
        if (this.f1187a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f1187a = actionMenuView;
            actionMenuView.setPopupTheme(this.f1197k);
            this.f1187a.setOnMenuItemClickListener(this.J);
            ActionMenuView actionMenuView2 = this.f1187a;
            MenuPresenter.Callback callback = this.Q;
            MenuBuilder.Callback callback2 = new MenuBuilder.Callback() { // from class: androidx.appcompat.widget.Toolbar.3
                @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
                public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
                    MenuBuilder.Callback callback3 = Toolbar.this.A0;
                    return false;
                }

                @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
                public final void b(MenuBuilder menuBuilder) {
                    Toolbar toolbar = Toolbar.this;
                    ActionMenuPresenter actionMenuPresenter = toolbar.f1187a.t;
                    if (actionMenuPresenter == null || !actionMenuPresenter.p()) {
                        Iterator it = toolbar.G.f3047b.iterator();
                        while (it.hasNext()) {
                            ((MenuProvider) it.next()).b(menuBuilder);
                        }
                    }
                    MenuBuilder.Callback callback3 = toolbar.A0;
                    if (callback3 != null) {
                        callback3.b(menuBuilder);
                    }
                }
            };
            actionMenuView2.u = callback;
            actionMenuView2.v = callback2;
            LayoutParams layoutParamsH = h();
            layoutParamsH.f243a = (this.n & 112) | 8388613;
            this.f1187a.setLayoutParams(layoutParamsH);
            b(this.f1187a, false);
        }
    }

    public final void g() {
        if (this.f1190d == null) {
            this.f1190d = new AppCompatImageButton(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            LayoutParams layoutParamsH = h();
            layoutParamsH.f243a = (this.n & 112) | 8388611;
            this.f1190d.setLayoutParams(layoutParamsH);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    @Nullable
    public CharSequence getCollapseContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f1194h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getCollapseIcon() {
        AppCompatImageButton appCompatImageButton = this.f1194h;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        RtlSpacingHelper rtlSpacingHelper = this.t;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.f1106g ? rtlSpacingHelper.f1100a : rtlSpacingHelper.f1101b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        RtlSpacingHelper rtlSpacingHelper = this.t;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.f1100a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        RtlSpacingHelper rtlSpacingHelper = this.t;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.f1101b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        RtlSpacingHelper rtlSpacingHelper = this.t;
        if (rtlSpacingHelper != null) {
            return rtlSpacingHelper.f1106g ? rtlSpacingHelper.f1101b : rtlSpacingHelper.f1100a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.u;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuBuilder menuBuilder;
        ActionMenuView actionMenuView = this.f1187a;
        return (actionMenuView == null || (menuBuilder = actionMenuView.p) == null || !menuBuilder.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        AppCompatImageView appCompatImageView = this.f1191e;
        if (appCompatImageView != null) {
            return appCompatImageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        AppCompatImageView appCompatImageView = this.f1191e;
        if (appCompatImageView != null) {
            return appCompatImageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f1187a.getMenu();
    }

    @Nullable
    @VisibleForTesting
    public View getNavButtonView() {
        return this.f1190d;
    }

    @Nullable
    public CharSequence getNavigationContentDescription() {
        AppCompatImageButton appCompatImageButton = this.f1190d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getContentDescription();
        }
        return null;
    }

    @Nullable
    public Drawable getNavigationIcon() {
        AppCompatImageButton appCompatImageButton = this.f1190d;
        if (appCompatImageButton != null) {
            return appCompatImageButton.getDrawable();
        }
        return null;
    }

    public ActionMenuPresenter getOuterActionMenuPresenter() {
        return this.L;
    }

    @Nullable
    public Drawable getOverflowIcon() {
        e();
        return this.f1187a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f1196j;
    }

    @StyleRes
    public int getPopupTheme() {
        return this.f1197k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    @Nullable
    @VisibleForTesting
    public final TextView getSubtitleTextView() {
        return this.f1189c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    @Nullable
    @VisibleForTesting
    public final TextView getTitleTextView() {
        return this.f1188b;
    }

    @RestrictTo
    public DecorToolbar getWrapper() {
        if (this.K == null) {
            this.K = new ToolbarWidgetWrapper(this, true);
        }
        return this.K;
    }

    public final int j(int i2, View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int i4 = layoutParams.f243a & 112;
        if (i4 != 16 && i4 != 48 && i4 != 80) {
            i4 = this.w & 112;
        }
        if (i4 == 48) {
            return getPaddingTop() - i3;
        }
        if (i4 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int iMax = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
        if (iMax < i5) {
            iMax = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - iMax) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            if (i6 < i7) {
                iMax = Math.max(0, iMax - (i7 - i6));
            }
        }
        return paddingTop + iMax;
    }

    public final boolean m() {
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.M;
        return (expandedActionViewMenuPresenter == null || expandedActionViewMenuPresenter.f1205b == null) ? false : true;
    }

    public void n(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public final void o() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it2 = this.G.f3047b.iterator();
        while (it2.hasNext()) {
            ((MenuProvider) it2.next()).d(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        y();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.F0);
        y();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.C = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x028f A[LOOP:0: B:102:0x028d->B:103:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02a7 A[LOOP:1: B:105:0x02a5->B:106:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02c8 A[LOOP:2: B:108:0x02c6->B:109:0x02c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0318 A[LOOP:3: B:117:0x0316->B:118:0x0318, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r19, int r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 809
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.Toolbar.onLayout(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        char c2;
        Object[] objArr;
        int iK;
        int iMax;
        int iCombineMeasuredStates;
        int iK2;
        int iL;
        int iCombineMeasuredStates2;
        int iMax2;
        boolean z = ViewUtils.f1266a;
        int i4 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c2 = 0;
        } else {
            c2 = 1;
            objArr = false;
        }
        if (w(this.f1190d)) {
            u(this.f1190d, i2, 0, i3, this.o);
            iK = k(this.f1190d) + this.f1190d.getMeasuredWidth();
            iMax = Math.max(0, l(this.f1190d) + this.f1190d.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(0, this.f1190d.getMeasuredState());
        } else {
            iK = 0;
            iMax = 0;
            iCombineMeasuredStates = 0;
        }
        if (w(this.f1194h)) {
            u(this.f1194h, i2, 0, i3, this.o);
            iK = k(this.f1194h) + this.f1194h.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f1194h) + this.f1194h.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1194h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int iMax3 = Math.max(currentContentInsetStart, iK);
        int iMax4 = Math.max(0, currentContentInsetStart - iK);
        Object[] objArr2 = objArr;
        int[] iArr = this.F;
        iArr[objArr2 == true ? 1 : 0] = iMax4;
        if (w(this.f1187a)) {
            u(this.f1187a, i2, iMax3, i3, this.o);
            iK2 = k(this.f1187a) + this.f1187a.getMeasuredWidth();
            iMax = Math.max(iMax, l(this.f1187a) + this.f1187a.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1187a.getMeasuredState());
        } else {
            iK2 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int iMax5 = iMax3 + Math.max(currentContentInsetEnd, iK2);
        iArr[c2] = Math.max(0, currentContentInsetEnd - iK2);
        if (w(this.f1195i)) {
            iMax5 += t(this.f1195i, i2, iMax5, i3, 0, iArr);
            iMax = Math.max(iMax, l(this.f1195i) + this.f1195i.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1195i.getMeasuredState());
        }
        if (w(this.f1191e)) {
            iMax5 += t(this.f1191e, i2, iMax5, i3, 0, iArr);
            iMax = Math.max(iMax, l(this.f1191e) + this.f1191e.getMeasuredHeight());
            iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, this.f1191e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (((LayoutParams) childAt.getLayoutParams()).f1220b == 0 && w(childAt)) {
                iMax5 += t(childAt, i2, iMax5, i3, 0, iArr);
                int iMax6 = Math.max(iMax, l(childAt) + childAt.getMeasuredHeight());
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, childAt.getMeasuredState());
                iMax = iMax6;
            } else {
                iMax5 = iMax5;
            }
        }
        int i6 = iMax5;
        int i7 = this.r + this.s;
        int i8 = this.p + this.q;
        if (w(this.f1188b)) {
            t(this.f1188b, i2, i6 + i8, i3, i7, iArr);
            int iK3 = k(this.f1188b) + this.f1188b.getMeasuredWidth();
            iL = l(this.f1188b) + this.f1188b.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates, this.f1188b.getMeasuredState());
            iMax2 = iK3;
        } else {
            iL = 0;
            iCombineMeasuredStates2 = iCombineMeasuredStates;
            iMax2 = 0;
        }
        if (w(this.f1189c)) {
            iMax2 = Math.max(iMax2, t(this.f1189c, i2, i6 + i8, i3, i7 + iL, iArr));
            iL += l(this.f1189c) + this.f1189c.getMeasuredHeight();
            iCombineMeasuredStates2 = View.combineMeasuredStates(iCombineMeasuredStates2, this.f1189c.getMeasuredState());
        }
        int iMax7 = Math.max(iMax, iL);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i6 + iMax2;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + iMax7;
        int iResolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i2, (-16777216) & iCombineMeasuredStates2);
        int iResolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, iCombineMeasuredStates2 << 16);
        if (!this.B0) {
            i4 = iResolveSizeAndState2;
            break;
        }
        int childCount2 = getChildCount();
        for (int i9 = 0; i9 < childCount2; i9++) {
            View childAt2 = getChildAt(i9);
            if (w(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                i4 = iResolveSizeAndState2;
                break;
            }
        }
        setMeasuredDimension(iResolveSizeAndState, i4);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem menuItemFindItem;
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.f3321a);
        ActionMenuView actionMenuView = this.f1187a;
        MenuBuilder menuBuilder = actionMenuView != null ? actionMenuView.p : null;
        int i2 = savedState.f1221c;
        if (i2 != 0 && this.M != null && menuBuilder != null && (menuItemFindItem = menuBuilder.findItem(i2)) != null) {
            menuItemFindItem.expandActionView();
        }
        if (savedState.f1222d) {
            Runnable runnable = this.F0;
            removeCallbacks(runnable);
            post(runnable);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i2) {
        super.onRtlPropertiesChanged(i2);
        d();
        RtlSpacingHelper rtlSpacingHelper = this.t;
        boolean z = i2 == 1;
        if (z == rtlSpacingHelper.f1106g) {
            return;
        }
        rtlSpacingHelper.f1106g = z;
        if (!rtlSpacingHelper.f1107h) {
            rtlSpacingHelper.f1100a = rtlSpacingHelper.f1104e;
            rtlSpacingHelper.f1101b = rtlSpacingHelper.f1105f;
            return;
        }
        if (z) {
            int i3 = rtlSpacingHelper.f1103d;
            if (i3 == Integer.MIN_VALUE) {
                i3 = rtlSpacingHelper.f1104e;
            }
            rtlSpacingHelper.f1100a = i3;
            int i4 = rtlSpacingHelper.f1102c;
            if (i4 == Integer.MIN_VALUE) {
                i4 = rtlSpacingHelper.f1105f;
            }
            rtlSpacingHelper.f1101b = i4;
            return;
        }
        int i5 = rtlSpacingHelper.f1102c;
        if (i5 == Integer.MIN_VALUE) {
            i5 = rtlSpacingHelper.f1104e;
        }
        rtlSpacingHelper.f1100a = i5;
        int i6 = rtlSpacingHelper.f1103d;
        if (i6 == Integer.MIN_VALUE) {
            i6 = rtlSpacingHelper.f1105f;
        }
        rtlSpacingHelper.f1101b = i6;
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        ActionMenuPresenter actionMenuPresenter;
        MenuItemImpl menuItemImpl;
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        ExpandedActionViewMenuPresenter expandedActionViewMenuPresenter = this.M;
        if (expandedActionViewMenuPresenter != null && (menuItemImpl = expandedActionViewMenuPresenter.f1205b) != null) {
            savedState.f1221c = menuItemImpl.f619a;
        }
        ActionMenuView actionMenuView = this.f1187a;
        savedState.f1222d = (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null || !actionMenuPresenter.p()) ? false : true;
        return savedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.B = false;
        return true;
    }

    public final boolean p(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public final boolean q() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f1187a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null || !actionMenuPresenter.p()) ? false : true;
    }

    public final int r(View view, int i2, int i3, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin - iArr[0];
        int iMax = Math.max(0, i4) + i2;
        iArr[0] = Math.max(0, -i4);
        int iJ = j(i3, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax, iJ, iMax + measuredWidth, view.getMeasuredHeight() + iJ);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + iMax;
    }

    @Override // androidx.core.view.MenuHost
    public final void removeMenuProvider(MenuProvider menuProvider) {
        this.G.c(menuProvider);
    }

    public final int s(View view, int i2, int i3, int[] iArr) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin - iArr[1];
        int iMax = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int iJ = j(i3, view);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(iMax - measuredWidth, iJ, iMax, view.getMeasuredHeight() + iJ);
        return iMax - (measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin);
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.E0 != z) {
            this.E0 = z;
            y();
        }
    }

    public void setCollapseContentDescription(@StringRes int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseIcon(@DrawableRes int i2) {
        setCollapseIcon(AppCompatResources.b(i2, getContext()));
    }

    @RestrictTo
    public void setCollapsible(boolean z) {
        this.B0 = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.u) {
            this.u = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(@DrawableRes int i2) {
        setLogo(AppCompatResources.b(i2, getContext()));
    }

    public void setLogoDescription(@StringRes int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setNavigationContentDescription(@StringRes int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationIcon(@DrawableRes int i2) {
        setNavigationIcon(AppCompatResources.b(i2, getContext()));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f1190d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.I = onMenuItemClickListener;
    }

    public void setOverflowIcon(@Nullable Drawable drawable) {
        e();
        this.f1187a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(@StyleRes int i2) {
        if (this.f1197k != i2) {
            this.f1197k = i2;
            if (i2 == 0) {
                this.f1196j = getContext();
            } else {
                this.f1196j = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(@StringRes int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitleTextColor(@ColorInt int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitle(@StringRes int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitleMarginBottom(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.p = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleTextColor(@ColorInt int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public final int t(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int iMax = Math.max(0, i7) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + iMax + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + iMax;
    }

    public final void u(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i5 >= 0) {
            if (mode != 0) {
                i5 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i5);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public final void v(int i2, int i3) {
        d();
        this.t.a(i2, i3);
    }

    public final boolean w(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean x() {
        ActionMenuPresenter actionMenuPresenter;
        ActionMenuView actionMenuView = this.f1187a;
        return (actionMenuView == null || (actionMenuPresenter = actionMenuView.t) == null || !actionMenuPresenter.r()) ? false : true;
    }

    public final void y() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcherA = Api33Impl.a(this);
            boolean z = m() && onBackInvokedDispatcherA != null && isAttachedToWindow() && this.E0;
            if (z && this.D0 == null) {
                if (this.C0 == null) {
                    this.C0 = Api33Impl.b(new c(this, 0));
                }
                Api33Impl.c(onBackInvokedDispatcherA, this.C0);
                this.D0 = onBackInvokedDispatcherA;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.D0) == null) {
                return;
            }
            Api33Impl.d(onBackInvokedDispatcher, this.C0);
            this.D0 = null;
        }
    }

    public Toolbar(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new MenuHostHelper(new c(this, 1));
        this.H = new ArrayList();
        this.J = new ActionMenuView.OnMenuItemClickListener() { // from class: androidx.appcompat.widget.Toolbar.1
            @Override // androidx.appcompat.widget.ActionMenuView.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Toolbar toolbar = Toolbar.this;
                Iterator it = toolbar.G.f3047b.iterator();
                while (it.hasNext()) {
                    if (((MenuProvider) it.next()).c(menuItem)) {
                        return true;
                    }
                }
                OnMenuItemClickListener onMenuItemClickListener = toolbar.I;
                if (onMenuItemClickListener != null) {
                    return onMenuItemClickListener.onMenuItemClick(menuItem);
                }
                return false;
            }
        };
        this.F0 = new Runnable() { // from class: androidx.appcompat.widget.Toolbar.2
            @Override // java.lang.Runnable
            public final void run() {
                Toolbar.this.x();
            }
        };
        TintTypedArray tintTypedArrayF = TintTypedArray.f(getContext(), attributeSet, R.styleable.Toolbar, i2);
        ViewCompat.y(this, context, R.styleable.Toolbar, attributeSet, tintTypedArrayF.f1185b, i2, 0);
        int i3 = R.styleable.Toolbar_titleTextAppearance;
        TypedArray typedArray = tintTypedArrayF.f1185b;
        this.f1198l = typedArray.getResourceId(i3, 0);
        this.f1199m = typedArray.getResourceId(R.styleable.Toolbar_subtitleTextAppearance, 0);
        this.w = typedArray.getInteger(R.styleable.Toolbar_android_gravity, 8388627);
        this.n = typedArray.getInteger(R.styleable.Toolbar_buttonGravity, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargin, 0);
        dimensionPixelOffset = typedArray.hasValue(R.styleable.Toolbar_titleMargins) ? typedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMargins, dimensionPixelOffset) : dimensionPixelOffset;
        this.s = dimensionPixelOffset;
        this.r = dimensionPixelOffset;
        this.q = dimensionPixelOffset;
        this.p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginStart, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginEnd, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginTop, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_titleMarginBottom, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.s = dimensionPixelOffset5;
        }
        this.o = typedArray.getDimensionPixelSize(R.styleable.Toolbar_maxButtonHeight, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetLeft, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(R.styleable.Toolbar_contentInsetRight, 0);
        d();
        RtlSpacingHelper rtlSpacingHelper = this.t;
        rtlSpacingHelper.f1107h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            rtlSpacingHelper.f1104e = dimensionPixelSize;
            rtlSpacingHelper.f1100a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            rtlSpacingHelper.f1105f = dimensionPixelSize2;
            rtlSpacingHelper.f1101b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            rtlSpacingHelper.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.u = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.v = typedArray.getDimensionPixelOffset(R.styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f1192f = tintTypedArrayF.b(R.styleable.Toolbar_collapseIcon);
        this.f1193g = typedArray.getText(R.styleable.Toolbar_collapseContentDescription);
        CharSequence text = typedArray.getText(R.styleable.Toolbar_title);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(R.styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.f1196j = getContext();
        setPopupTheme(typedArray.getResourceId(R.styleable.Toolbar_popupTheme, 0));
        Drawable drawableB = tintTypedArrayF.b(R.styleable.Toolbar_navigationIcon);
        if (drawableB != null) {
            setNavigationIcon(drawableB);
        }
        CharSequence text3 = typedArray.getText(R.styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable drawableB2 = tintTypedArrayF.b(R.styleable.Toolbar_logo);
        if (drawableB2 != null) {
            setLogo(drawableB2);
        }
        CharSequence text4 = typedArray.getText(R.styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(R.styleable.Toolbar_titleTextColor)) {
            setTitleTextColor(tintTypedArrayF.a(R.styleable.Toolbar_titleTextColor));
        }
        if (typedArray.hasValue(R.styleable.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(tintTypedArrayF.a(R.styleable.Toolbar_subtitleTextColor));
        }
        if (typedArray.hasValue(R.styleable.Toolbar_menu)) {
            n(typedArray.getResourceId(R.styleable.Toolbar_menu, 0));
        }
        tintTypedArrayF.g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setCollapseContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        AppCompatImageButton appCompatImageButton = this.f1194h;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            c();
            this.f1194h.setImageDrawable(drawable);
        } else {
            AppCompatImageButton appCompatImageButton = this.f1194h;
            if (appCompatImageButton != null) {
                appCompatImageButton.setImageDrawable(this.f1192f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f1191e == null) {
                this.f1191e = new AppCompatImageView(getContext(), null);
            }
            if (!p(this.f1191e)) {
                b(this.f1191e, true);
            }
        } else {
            AppCompatImageView appCompatImageView = this.f1191e;
            if (appCompatImageView != null && p(appCompatImageView)) {
                removeView(this.f1191e);
                this.E.remove(this.f1191e);
            }
        }
        AppCompatImageView appCompatImageView2 = this.f1191e;
        if (appCompatImageView2 != null) {
            appCompatImageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f1191e == null) {
            this.f1191e = new AppCompatImageView(getContext(), null);
        }
        AppCompatImageView appCompatImageView = this.f1191e;
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(@Nullable CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        AppCompatImageButton appCompatImageButton = this.f1190d;
        if (appCompatImageButton != null) {
            appCompatImageButton.setContentDescription(charSequence);
            TooltipCompat.a(this.f1190d, charSequence);
        }
    }

    public void setNavigationIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            g();
            if (!p(this.f1190d)) {
                b(this.f1190d, true);
            }
        } else {
            AppCompatImageButton appCompatImageButton = this.f1190d;
            if (appCompatImageButton != null && p(appCompatImageButton)) {
                removeView(this.f1190d);
                this.E.remove(this.f1190d);
            }
        }
        AppCompatImageButton appCompatImageButton2 = this.f1190d;
        if (appCompatImageButton2 != null) {
            appCompatImageButton2.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f1189c;
            if (appCompatTextView != null && p(appCompatTextView)) {
                removeView(this.f1189c);
                this.E.remove(this.f1189c);
            }
        } else {
            if (this.f1189c == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f1189c = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f1189c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1199m;
                if (i2 != 0) {
                    this.f1189c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f1189c.setTextColor(colorStateList);
                }
            }
            if (!p(this.f1189c)) {
                b(this.f1189c, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f1189c;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextColor(@NonNull ColorStateList colorStateList) {
        this.A = colorStateList;
        AppCompatTextView appCompatTextView = this.f1189c;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            AppCompatTextView appCompatTextView = this.f1188b;
            if (appCompatTextView != null && p(appCompatTextView)) {
                removeView(this.f1188b);
                this.E.remove(this.f1188b);
            }
        } else {
            if (this.f1188b == null) {
                Context context = getContext();
                AppCompatTextView appCompatTextView2 = new AppCompatTextView(context, null);
                this.f1188b = appCompatTextView2;
                appCompatTextView2.setSingleLine();
                this.f1188b.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.f1198l;
                if (i2 != 0) {
                    this.f1188b.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    this.f1188b.setTextColor(colorStateList);
                }
            }
            if (!p(this.f1188b)) {
                b(this.f1188b, true);
            }
        }
        AppCompatTextView appCompatTextView3 = this.f1188b;
        if (appCompatTextView3 != null) {
            appCompatTextView3.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleTextColor(@NonNull ColorStateList colorStateList) {
        this.z = colorStateList;
        AppCompatTextView appCompatTextView = this.f1188b;
        if (appCompatTextView != null) {
            appCompatTextView.setTextColor(colorStateList);
        }
    }

    public static class LayoutParams extends ActionBar.LayoutParams {

        /* renamed from: b, reason: collision with root package name */
        public int f1220b;

        public LayoutParams(int i2) {
            super(-2, i2);
            this.f1220b = 0;
            this.f243a = 8388627;
        }

        public LayoutParams(@NonNull Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1220b = 0;
        }
    }
}
