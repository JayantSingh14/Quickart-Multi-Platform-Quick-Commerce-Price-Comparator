package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.RestrictTo;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListener;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;
import androidx.core.view.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

@RestrictTo
/* loaded from: classes3.dex */
public class WindowDecorActionBar extends ActionBar implements ActionBarOverlayLayout.ActionBarVisibilityCallback {

    /* renamed from: a, reason: collision with root package name */
    public Context f391a;

    /* renamed from: b, reason: collision with root package name */
    public Context f392b;

    /* renamed from: c, reason: collision with root package name */
    public ActionBarOverlayLayout f393c;

    /* renamed from: d, reason: collision with root package name */
    public ActionBarContainer f394d;

    /* renamed from: e, reason: collision with root package name */
    public DecorToolbar f395e;

    /* renamed from: f, reason: collision with root package name */
    public ActionBarContextView f396f;

    /* renamed from: g, reason: collision with root package name */
    public final View f397g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f398h;

    /* renamed from: i, reason: collision with root package name */
    public ActionModeImpl f399i;

    /* renamed from: j, reason: collision with root package name */
    public ActionModeImpl f400j;

    /* renamed from: k, reason: collision with root package name */
    public ActionMode.Callback f401k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f402l;

    /* renamed from: m, reason: collision with root package name */
    public final ArrayList f403m;
    public boolean n;
    public int o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public ViewPropertyAnimatorCompatSet t;
    public boolean u;
    public boolean v;
    public final ViewPropertyAnimatorListener w;
    public final ViewPropertyAnimatorListener x;
    public final ViewPropertyAnimatorUpdateListener y;
    public static final AccelerateInterpolator z = new AccelerateInterpolator();
    public static final DecelerateInterpolator A = new DecelerateInterpolator();

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$1, reason: invalid class name */
    public class AnonymousClass1 extends ViewPropertyAnimatorListenerAdapter {
        public AnonymousClass1() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd(View view) {
            View view2;
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.p && (view2 = windowDecorActionBar.f397g) != null) {
                view2.setTranslationY(0.0f);
                windowDecorActionBar.f394d.setTranslationY(0.0f);
            }
            windowDecorActionBar.f394d.setVisibility(8);
            windowDecorActionBar.f394d.setTransitioning(false);
            windowDecorActionBar.t = null;
            ActionMode.Callback callback = windowDecorActionBar.f401k;
            if (callback != null) {
                ((AppCompatDelegateImpl.ActionModeCallbackWrapperV9) callback).a(windowDecorActionBar.f400j);
                windowDecorActionBar.f400j = null;
                windowDecorActionBar.f401k = null;
            }
            ActionBarOverlayLayout actionBarOverlayLayout = windowDecorActionBar.f393c;
            if (actionBarOverlayLayout != null) {
                ViewCompat.x(actionBarOverlayLayout);
            }
        }
    }

    /* renamed from: androidx.appcompat.app.WindowDecorActionBar$2, reason: invalid class name */
    public class AnonymousClass2 extends ViewPropertyAnimatorListenerAdapter {
        public AnonymousClass2() {
        }

        @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
        public final void onAnimationEnd(View view) {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            windowDecorActionBar.t = null;
            windowDecorActionBar.f394d.requestLayout();
        }
    }

    @RestrictTo
    public class ActionModeImpl extends ActionMode implements MenuBuilder.Callback {

        /* renamed from: c, reason: collision with root package name */
        public final Context f407c;

        /* renamed from: d, reason: collision with root package name */
        public final MenuBuilder f408d;

        /* renamed from: e, reason: collision with root package name */
        public ActionMode.Callback f409e;

        /* renamed from: f, reason: collision with root package name */
        public WeakReference f410f;

        public ActionModeImpl(Context context, ActionMode.Callback callback) {
            this.f407c = context;
            this.f409e = callback;
            MenuBuilder menuBuilder = new MenuBuilder(context);
            menuBuilder.f614l = 1;
            this.f408d = menuBuilder;
            menuBuilder.f607e = this;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
            ActionMode.Callback callback = this.f409e;
            if (callback != null) {
                return ((AppCompatDelegateImpl.ActionModeCallbackWrapperV9) callback).f310a.c(this, menuItem);
            }
            return false;
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public final void b(MenuBuilder menuBuilder) {
            if (this.f409e == null) {
                return;
            }
            i();
            WindowDecorActionBar.this.f396f.i();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void c() {
            WindowDecorActionBar windowDecorActionBar = WindowDecorActionBar.this;
            if (windowDecorActionBar.f399i != this) {
                return;
            }
            if (windowDecorActionBar.q) {
                windowDecorActionBar.f400j = this;
                windowDecorActionBar.f401k = this.f409e;
            } else {
                ((AppCompatDelegateImpl.ActionModeCallbackWrapperV9) this.f409e).a(this);
            }
            this.f409e = null;
            windowDecorActionBar.x(false);
            ActionBarContextView actionBarContextView = windowDecorActionBar.f396f;
            if (actionBarContextView.f696k == null) {
                actionBarContextView.g();
            }
            windowDecorActionBar.f393c.setHideOnContentScrollEnabled(windowDecorActionBar.v);
            windowDecorActionBar.f399i = null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final View d() {
            WeakReference weakReference = this.f410f;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
            return null;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuBuilder e() {
            return this.f408d;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final MenuInflater f() {
            return new SupportMenuInflater(this.f407c);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence g() {
            return WindowDecorActionBar.this.f396f.getSubtitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final CharSequence h() {
            return WindowDecorActionBar.this.f396f.getTitle();
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void i() {
            if (WindowDecorActionBar.this.f399i != this) {
                return;
            }
            MenuBuilder menuBuilder = this.f408d;
            menuBuilder.B();
            try {
                ((AppCompatDelegateImpl.ActionModeCallbackWrapperV9) this.f409e).d(this, menuBuilder);
            } finally {
                menuBuilder.A();
            }
        }

        @Override // androidx.appcompat.view.ActionMode
        public final boolean j() {
            return WindowDecorActionBar.this.f396f.s;
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void k(View view) {
            WindowDecorActionBar.this.f396f.setCustomView(view);
            this.f410f = new WeakReference(view);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void l(int i2) {
            m(WindowDecorActionBar.this.f391a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void m(CharSequence charSequence) {
            WindowDecorActionBar.this.f396f.setSubtitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void n(int i2) {
            o(WindowDecorActionBar.this.f391a.getResources().getString(i2));
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void o(CharSequence charSequence) {
            WindowDecorActionBar.this.f396f.setTitle(charSequence);
        }

        @Override // androidx.appcompat.view.ActionMode
        public final void p(boolean z) {
            this.f468b = z;
            WindowDecorActionBar.this.f396f.setTitleOptional(z);
        }
    }

    @RestrictTo
    public class TabImpl extends ActionBar.Tab {
    }

    public WindowDecorActionBar(Activity activity, boolean z2) {
        new ArrayList();
        this.f403m = new ArrayList();
        this.o = 0;
        this.p = true;
        this.s = true;
        this.w = new AnonymousClass1();
        this.x = new AnonymousClass2();
        this.y = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public final void a() {
                ((View) WindowDecorActionBar.this.f394d.getParent()).invalidate();
            }
        };
        View decorView = activity.getWindow().getDecorView();
        y(decorView);
        if (z2) {
            return;
        }
        this.f397g = decorView.findViewById(R.id.content);
    }

    public final void A(boolean z2) {
        boolean z3 = this.r || !this.q;
        ViewPropertyAnimatorUpdateListener viewPropertyAnimatorUpdateListener = this.y;
        View view = this.f397g;
        if (!z3) {
            if (this.s) {
                this.s = false;
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.t;
                if (viewPropertyAnimatorCompatSet != null) {
                    viewPropertyAnimatorCompatSet.a();
                }
                int i2 = this.o;
                ViewPropertyAnimatorListener viewPropertyAnimatorListener = this.w;
                if (i2 != 0 || (!this.u && !z2)) {
                    ((AnonymousClass1) viewPropertyAnimatorListener).onAnimationEnd(null);
                    return;
                }
                this.f394d.setAlpha(1.0f);
                this.f394d.setTransitioning(true);
                ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet2 = new ViewPropertyAnimatorCompatSet();
                float f2 = -this.f394d.getHeight();
                if (z2) {
                    this.f394d.getLocationInWindow(new int[]{0, 0});
                    f2 -= r12[1];
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA = ViewCompat.a(this.f394d);
                viewPropertyAnimatorCompatA.e(f2);
                View view2 = (View) viewPropertyAnimatorCompatA.f3117a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new h(0, viewPropertyAnimatorUpdateListener, view2) : null);
                }
                boolean z4 = viewPropertyAnimatorCompatSet2.f513e;
                ArrayList arrayList = viewPropertyAnimatorCompatSet2.f509a;
                if (!z4) {
                    arrayList.add(viewPropertyAnimatorCompatA);
                }
                if (this.p && view != null) {
                    ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA2 = ViewCompat.a(view);
                    viewPropertyAnimatorCompatA2.e(f2);
                    if (!viewPropertyAnimatorCompatSet2.f513e) {
                        arrayList.add(viewPropertyAnimatorCompatA2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = z;
                boolean z5 = viewPropertyAnimatorCompatSet2.f513e;
                if (!z5) {
                    viewPropertyAnimatorCompatSet2.f511c = accelerateInterpolator;
                }
                if (!z5) {
                    viewPropertyAnimatorCompatSet2.f510b = 250L;
                }
                ViewPropertyAnimatorListenerAdapter viewPropertyAnimatorListenerAdapter = (ViewPropertyAnimatorListenerAdapter) viewPropertyAnimatorListener;
                if (!z5) {
                    viewPropertyAnimatorCompatSet2.f512d = viewPropertyAnimatorListenerAdapter;
                }
                this.t = viewPropertyAnimatorCompatSet2;
                viewPropertyAnimatorCompatSet2.b();
                return;
            }
            return;
        }
        if (this.s) {
            return;
        }
        this.s = true;
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet3 = this.t;
        if (viewPropertyAnimatorCompatSet3 != null) {
            viewPropertyAnimatorCompatSet3.a();
        }
        this.f394d.setVisibility(0);
        int i3 = this.o;
        ViewPropertyAnimatorListener viewPropertyAnimatorListener2 = this.x;
        if (i3 == 0 && (this.u || z2)) {
            this.f394d.setTranslationY(0.0f);
            float f3 = -this.f394d.getHeight();
            if (z2) {
                this.f394d.getLocationInWindow(new int[]{0, 0});
                f3 -= r12[1];
            }
            this.f394d.setTranslationY(f3);
            ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet4 = new ViewPropertyAnimatorCompatSet();
            ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA3 = ViewCompat.a(this.f394d);
            viewPropertyAnimatorCompatA3.e(0.0f);
            View view3 = (View) viewPropertyAnimatorCompatA3.f3117a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(viewPropertyAnimatorUpdateListener != null ? new h(0, viewPropertyAnimatorUpdateListener, view3) : null);
            }
            boolean z6 = viewPropertyAnimatorCompatSet4.f513e;
            ArrayList arrayList2 = viewPropertyAnimatorCompatSet4.f509a;
            if (!z6) {
                arrayList2.add(viewPropertyAnimatorCompatA3);
            }
            if (this.p && view != null) {
                view.setTranslationY(f3);
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA4 = ViewCompat.a(view);
                viewPropertyAnimatorCompatA4.e(0.0f);
                if (!viewPropertyAnimatorCompatSet4.f513e) {
                    arrayList2.add(viewPropertyAnimatorCompatA4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = A;
            boolean z7 = viewPropertyAnimatorCompatSet4.f513e;
            if (!z7) {
                viewPropertyAnimatorCompatSet4.f511c = decelerateInterpolator;
            }
            if (!z7) {
                viewPropertyAnimatorCompatSet4.f510b = 250L;
            }
            ViewPropertyAnimatorListenerAdapter viewPropertyAnimatorListenerAdapter2 = (ViewPropertyAnimatorListenerAdapter) viewPropertyAnimatorListener2;
            if (!z7) {
                viewPropertyAnimatorCompatSet4.f512d = viewPropertyAnimatorListenerAdapter2;
            }
            this.t = viewPropertyAnimatorCompatSet4;
            viewPropertyAnimatorCompatSet4.b();
        } else {
            this.f394d.setAlpha(1.0f);
            this.f394d.setTranslationY(0.0f);
            if (this.p && view != null) {
                view.setTranslationY(0.0f);
            }
            ((AnonymousClass2) viewPropertyAnimatorListener2).onAnimationEnd(null);
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.f393c;
        if (actionBarOverlayLayout != null) {
            ViewCompat.x(actionBarOverlayLayout);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void a() {
        if (this.q) {
            this.q = false;
            A(true);
        }
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void b(int i2) {
        this.o = i2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void c(boolean z2) {
        this.p = z2;
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void d() {
        if (this.q) {
            return;
        }
        this.q = true;
        A(true);
    }

    @Override // androidx.appcompat.widget.ActionBarOverlayLayout.ActionBarVisibilityCallback
    public final void e() {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = this.t;
        if (viewPropertyAnimatorCompatSet != null) {
            viewPropertyAnimatorCompatSet.a();
            this.t = null;
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean g() {
        DecorToolbar decorToolbar = this.f395e;
        if (decorToolbar == null || !decorToolbar.h()) {
            return false;
        }
        this.f395e.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void h(boolean z2) {
        if (z2 == this.f402l) {
            return;
        }
        this.f402l = z2;
        ArrayList arrayList = this.f403m;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ActionBar.OnMenuVisibilityListener) arrayList.get(i2)).a();
        }
    }

    @Override // androidx.appcompat.app.ActionBar
    public final int i() {
        return this.f395e.q();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final Context j() {
        if (this.f392b == null) {
            TypedValue typedValue = new TypedValue();
            this.f391a.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarWidgetTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                this.f392b = new ContextThemeWrapper(this.f391a, i2);
            } else {
                this.f392b = this.f391a;
            }
        }
        return this.f392b;
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void l() {
        z(this.f391a.getResources().getBoolean(androidx.appcompat.R.bool.abc_action_bar_embed_tabs));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final boolean n(int i2, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        ActionModeImpl actionModeImpl = this.f399i;
        if (actionModeImpl == null || (menuBuilder = actionModeImpl.f408d) == null) {
            return false;
        }
        menuBuilder.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
        return menuBuilder.performShortcut(i2, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void q(boolean z2) {
        if (this.f398h) {
            return;
        }
        r(z2);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void r(boolean z2) {
        int i2 = z2 ? 4 : 0;
        int iQ = this.f395e.q();
        this.f398h = true;
        this.f395e.i((i2 & 4) | (iQ & (-5)));
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void s(Drawable drawable) {
        this.f395e.s(drawable);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void t(boolean z2) {
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet;
        this.u = z2;
        if (z2 || (viewPropertyAnimatorCompatSet = this.t) == null) {
            return;
        }
        viewPropertyAnimatorCompatSet.a();
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void u(CharSequence charSequence) {
        this.f395e.setTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final void v(CharSequence charSequence) {
        this.f395e.setWindowTitle(charSequence);
    }

    @Override // androidx.appcompat.app.ActionBar
    public final ActionMode w(ActionMode.Callback callback) {
        ActionModeImpl actionModeImpl = this.f399i;
        if (actionModeImpl != null) {
            actionModeImpl.c();
        }
        this.f393c.setHideOnContentScrollEnabled(false);
        this.f396f.g();
        ActionModeImpl actionModeImpl2 = new ActionModeImpl(this.f396f.getContext(), callback);
        MenuBuilder menuBuilder = actionModeImpl2.f408d;
        menuBuilder.B();
        try {
            if (!((AppCompatDelegateImpl.ActionModeCallbackWrapperV9) actionModeImpl2.f409e).f310a.b(actionModeImpl2, menuBuilder)) {
                return null;
            }
            this.f399i = actionModeImpl2;
            actionModeImpl2.i();
            this.f396f.e(actionModeImpl2);
            x(true);
            return actionModeImpl2;
        } finally {
            menuBuilder.A();
        }
    }

    public final void x(boolean z2) {
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatK;
        ViewPropertyAnimatorCompat viewPropertyAnimatorCompatH;
        if (z2) {
            if (!this.r) {
                this.r = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.f393c;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                A(false);
            }
        } else if (this.r) {
            this.r = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f393c;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            A(false);
        }
        if (!this.f394d.isLaidOut()) {
            if (z2) {
                this.f395e.setVisibility(4);
                this.f396f.setVisibility(0);
                return;
            } else {
                this.f395e.setVisibility(0);
                this.f396f.setVisibility(8);
                return;
            }
        }
        if (z2) {
            viewPropertyAnimatorCompatH = this.f395e.k(4, 100L);
            viewPropertyAnimatorCompatK = this.f396f.h(0, 200L);
        } else {
            viewPropertyAnimatorCompatK = this.f395e.k(0, 200L);
            viewPropertyAnimatorCompatH = this.f396f.h(8, 100L);
        }
        ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet = new ViewPropertyAnimatorCompatSet();
        ArrayList arrayList = viewPropertyAnimatorCompatSet.f509a;
        arrayList.add(viewPropertyAnimatorCompatH);
        View view = (View) viewPropertyAnimatorCompatH.f3117a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) viewPropertyAnimatorCompatK.f3117a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(viewPropertyAnimatorCompatK);
        viewPropertyAnimatorCompatSet.b();
    }

    public final void y(View view) {
        DecorToolbar wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(androidx.appcompat.R.id.decor_content_parent);
        this.f393c = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback callbackFindViewById = view.findViewById(androidx.appcompat.R.id.action_bar);
        if (callbackFindViewById instanceof DecorToolbar) {
            wrapper = (DecorToolbar) callbackFindViewById;
        } else {
            if (!(callbackFindViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(callbackFindViewById != null ? callbackFindViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) callbackFindViewById).getWrapper();
        }
        this.f395e = wrapper;
        this.f396f = (ActionBarContextView) view.findViewById(androidx.appcompat.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(androidx.appcompat.R.id.action_bar_container);
        this.f394d = actionBarContainer;
        DecorToolbar decorToolbar = this.f395e;
        if (decorToolbar == null || this.f396f == null || actionBarContainer == null) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        this.f391a = decorToolbar.getContext();
        if ((this.f395e.q() & 4) != 0) {
            this.f398h = true;
        }
        Context context = this.f391a;
        ActionBarPolicy actionBarPolicy = new ActionBarPolicy();
        actionBarPolicy.f466a = context;
        int i2 = context.getApplicationInfo().targetSdkVersion;
        this.f395e.getClass();
        z(actionBarPolicy.f466a.getResources().getBoolean(androidx.appcompat.R.bool.abc_action_bar_embed_tabs));
        TypedArray typedArrayObtainStyledAttributes = this.f391a.obtainStyledAttributes(null, androidx.appcompat.R.styleable.ActionBar, androidx.appcompat.R.attr.actionBarStyle, 0);
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.ActionBar_hideOnContentScroll, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.f393c;
            if (!actionBarOverlayLayout2.f706g) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.v = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(androidx.appcompat.R.styleable.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            ViewCompat.E(this.f394d, dimensionPixelSize);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void z(boolean z2) {
        this.n = z2;
        if (z2) {
            this.f394d.setTabContainer(null);
            this.f395e.o();
        } else {
            this.f395e.o();
            this.f394d.setTabContainer(null);
        }
        boolean z3 = false;
        boolean z4 = this.f395e.j() == 2;
        this.f395e.m(!this.n && z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f393c;
        if (!this.n && z4) {
            z3 = true;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z3);
    }

    public WindowDecorActionBar(Dialog dialog) {
        new ArrayList();
        this.f403m = new ArrayList();
        this.o = 0;
        this.p = true;
        this.s = true;
        this.w = new AnonymousClass1();
        this.x = new AnonymousClass2();
        this.y = new ViewPropertyAnimatorUpdateListener() { // from class: androidx.appcompat.app.WindowDecorActionBar.3
            @Override // androidx.core.view.ViewPropertyAnimatorUpdateListener
            public final void a() {
                ((View) WindowDecorActionBar.this.f394d.getParent()).invalidate();
            }
        };
        y(dialog.getWindow().getDecorView());
    }
}
