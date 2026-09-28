package com.swmansion.rnscreens;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.ReactTypefaceUtils;
import com.swmansion.rnscreens.ScreenStackHeaderSubview;
import com.swmansion.rnscreens.events.HeaderAttachedEvent;
import com.swmansion.rnscreens.events.HeaderDetachedEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ScreenStackHeaderConfig extends FabricEnabledHeaderConfigViewGroup implements ReactPointerEventsView {

    /* renamed from: d, reason: collision with root package name */
    public final PointerEventsBoxNoneImpl f47025d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f47026e;

    /* renamed from: f, reason: collision with root package name */
    public final CustomToolbar f47027f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f47028g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f47029h;

    /* renamed from: i, reason: collision with root package name */
    public String f47030i;

    /* renamed from: j, reason: collision with root package name */
    public int f47031j;

    /* renamed from: k, reason: collision with root package name */
    public String f47032k;

    /* renamed from: l, reason: collision with root package name */
    public String f47033l;

    /* renamed from: m, reason: collision with root package name */
    public float f47034m;
    public int n;
    public Integer o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public int u;
    public boolean v;
    public final int w;
    public final int x;
    public final com.google.android.material.datepicker.d y;
    public boolean z;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static TextView a(Toolbar toolbar) {
            Intrinsics.checkNotNullParameter(toolbar, "toolbar");
            int childCount = toolbar.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = toolbar.getChildAt(i2);
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    if (TextUtils.equals(textView.getText(), toolbar.getTitle())) {
                        return textView;
                    }
                }
            }
            return null;
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public static final class DebugMenuToolbar extends CustomToolbar {
        @Override // androidx.appcompat.widget.Toolbar
        public final boolean x() {
            Object applicationContext = getContext().getApplicationContext();
            Intrinsics.d(applicationContext, "null cannot be cast to non-null type com.facebook.react.ReactApplication");
            ReactInstanceManager reactInstanceManagerF = ((ReactApplication) applicationContext).a().f();
            reactInstanceManagerF.getClass();
            UiThreadUtil.assertOnUiThread();
            reactInstanceManagerF.f18463j.A();
            return true;
        }
    }

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[ScreenStackHeaderSubview.Type.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                ScreenStackHeaderSubview.Type type = ScreenStackHeaderSubview.Type.f47038a;
                iArr[2] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                ScreenStackHeaderSubview.Type type2 = ScreenStackHeaderSubview.Type.f47038a;
                iArr[1] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public ScreenStackHeaderConfig(ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PointerEventsBoxNoneImpl pointerEventsImpl = new PointerEventsBoxNoneImpl();
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(pointerEventsImpl, "pointerEventsImpl");
        Intrinsics.checkNotNullParameter(context, "context");
        super(context);
        this.f47025d = pointerEventsImpl;
        this.f47026e = new ArrayList(3);
        this.t = true;
        this.y = new com.google.android.material.datepicker.d(this, 2);
        setVisibility(8);
        CustomToolbar customToolbar = new CustomToolbar(context, this);
        this.f47027f = customToolbar;
        this.w = customToolbar.getContentInsetStart();
        this.x = customToolbar.getContentInsetStartWithNavigation();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(android.R.attr.colorPrimary, typedValue, true)) {
            customToolbar.setBackgroundColor(typedValue.data);
        }
        customToolbar.setClipChildren(false);
    }

    public static void a(ScreenStackHeaderConfig screenStackHeaderConfig) {
        ScreenStackFragment screenFragment = screenStackHeaderConfig.getScreenFragment();
        if (screenFragment != null) {
            ScreenStack screenStack = screenStackHeaderConfig.getScreenStack();
            if (screenStack == null || !Intrinsics.b(screenStack.getRootScreen(), screenFragment.k())) {
                if (screenFragment.k().getNativeBackButtonDismissalEnabled()) {
                    screenFragment.D();
                    return;
                } else {
                    screenFragment.y();
                    return;
                }
            }
            Fragment parentFragment = screenFragment.getParentFragment();
            if (parentFragment instanceof ScreenStackFragment) {
                ScreenStackFragment screenStackFragment = (ScreenStackFragment) parentFragment;
                if (screenStackFragment.k().getNativeBackButtonDismissalEnabled()) {
                    screenStackFragment.D();
                } else {
                    screenStackFragment.y();
                }
            }
        }
    }

    private final Screen getScreen() {
        ViewParent parent = getParent();
        if (parent instanceof Screen) {
            return (Screen) parent;
        }
        return null;
    }

    private final ScreenStack getScreenStack() {
        Screen screen = getScreen();
        ScreenContainer container = screen != null ? screen.getContainer() : null;
        if (container instanceof ScreenStack) {
            return (ScreenStack) container;
        }
        return null;
    }

    public final void b() {
        Screen screen;
        if (getParent() == null || this.r || (screen = getScreen()) == null || screen.f46946k) {
            return;
        }
        c();
    }

    public final void c() {
        Drawable navigationIcon;
        ScreenStackFragment screenFragment;
        ScreenStackFragment screenFragment2;
        ReactContext reactContextR;
        ScreenStack screenStack = getScreenStack();
        boolean z = screenStack == null || Intrinsics.b(screenStack.getTopScreen(), getParent());
        if (this.v && z && !this.r) {
            ScreenStackFragment screenFragment3 = getScreenFragment();
            AppCompatActivity appCompatActivity = (AppCompatActivity) (screenFragment3 != null ? screenFragment3.getActivity() : null);
            if (appCompatActivity == null) {
                return;
            }
            String str = this.f47033l;
            CustomToolbar customToolbar = this.f47027f;
            if (str != null) {
                if (str.equals("rtl")) {
                    customToolbar.setLayoutDirection(1);
                } else if (Intrinsics.b(this.f47033l, "ltr")) {
                    customToolbar.setLayoutDirection(0);
                }
            }
            Screen screen = getScreen();
            if (screen != null) {
                if (getContext() instanceof ReactContext) {
                    Context context = getContext();
                    Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
                    reactContextR = (ReactContext) context;
                } else {
                    ScreenFragmentWrapper fragmentWrapper = screen.getFragmentWrapper();
                    reactContextR = fragmentWrapper != null ? fragmentWrapper.r() : null;
                }
                ScreenWindowTraits.k(screen, appCompatActivity, reactContextR);
            }
            if (this.f47028g) {
                if (customToolbar.getParent() == null || (screenFragment2 = getScreenFragment()) == null) {
                    return;
                }
                screenFragment2.H();
                return;
            }
            if (customToolbar.getParent() == null && (screenFragment = getScreenFragment()) != null) {
                screenFragment.K(customToolbar);
            }
            appCompatActivity.setSupportActionBar(customToolbar);
            ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
            if (supportActionBar == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            ScreenStackFragment screenFragment4 = getScreenFragment();
            supportActionBar.r((screenFragment4 == null || !screenFragment4.C() || this.p) ? false : true);
            supportActionBar.u(this.f47030i);
            if (TextUtils.isEmpty(this.f47030i)) {
                this.z = true;
            }
            customToolbar.z();
            customToolbar.setNavigationOnClickListener(this.y);
            ScreenStackFragment screenFragment5 = getScreenFragment();
            if (screenFragment5 != null) {
                screenFragment5.L(this.q);
            }
            ScreenStackFragment screenFragment6 = getScreenFragment();
            if (screenFragment6 != null) {
                screenFragment6.M(this.f47029h);
            }
            TextView textViewA = Companion.a(customToolbar);
            int i2 = this.f47031j;
            if (i2 != 0) {
                customToolbar.setTitleTextColor(i2);
            }
            if (textViewA != null) {
                String str2 = this.f47032k;
                if (str2 != null || this.n > 0) {
                    int i3 = this.n;
                    AssetManager assets = getContext().getAssets();
                    Intrinsics.checkNotNullExpressionValue(assets, "getAssets(...)");
                    textViewA.setTypeface(ReactTypefaceUtils.a(null, 0, i3, str2, assets));
                }
                float f2 = this.f47034m;
                if (f2 > 0.0f) {
                    textViewA.setTextSize(f2);
                }
            }
            Integer num = this.o;
            if (num != null) {
                customToolbar.setBackgroundColor(num.intValue());
            }
            if (this.u != 0 && (navigationIcon = customToolbar.getNavigationIcon()) != null) {
                navigationIcon.setColorFilter(new PorterDuffColorFilter(this.u, PorterDuff.Mode.SRC_ATOP));
            }
            for (int childCount = customToolbar.getChildCount() - 1; -1 < childCount; childCount--) {
                if (customToolbar.getChildAt(childCount) instanceof ScreenStackHeaderSubview) {
                    customToolbar.removeViewAt(childCount);
                }
            }
            ArrayList arrayList = this.f47026e;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                Object obj = arrayList.get(i4);
                Intrinsics.checkNotNullExpressionValue(obj, "get(...)");
                ScreenStackHeaderSubview screenStackHeaderSubview = (ScreenStackHeaderSubview) obj;
                ScreenStackHeaderSubview.Type type = screenStackHeaderSubview.getType();
                if (type == ScreenStackHeaderSubview.Type.f47041d) {
                    View childAt = screenStackHeaderSubview.getChildAt(0);
                    ImageView imageView = childAt instanceof ImageView ? (ImageView) childAt : null;
                    if (imageView == null) {
                        throw new JSApplicationIllegalArgumentException("Back button header config view should have Image as first child");
                    }
                    supportActionBar.s(imageView.getDrawable());
                } else {
                    Toolbar.LayoutParams layoutParams = new Toolbar.LayoutParams(-1);
                    int iOrdinal = type.ordinal();
                    if (iOrdinal == 0) {
                        if (!this.s) {
                            customToolbar.setNavigationIcon((Drawable) null);
                        }
                        customToolbar.setTitle((CharSequence) null);
                        layoutParams.f243a = 8388611;
                    } else if (iOrdinal == 1) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -1;
                        layoutParams.f243a = 1;
                        customToolbar.setTitle((CharSequence) null);
                    } else if (iOrdinal == 2) {
                        layoutParams.f243a = 8388613;
                    }
                    screenStackHeaderSubview.setLayoutParams(layoutParams);
                    customToolbar.addView(screenStackHeaderSubview);
                }
            }
        }
    }

    public final int getConfigSubviewsCount() {
        return this.f47026e.size();
    }

    @Override // com.facebook.react.uimanager.ReactPointerEventsView
    @NotNull
    public PointerEvents getPointerEvents() {
        return this.f47025d.getPointerEvents();
    }

    public final int getPreferredContentInsetEnd() {
        return this.w;
    }

    public final int getPreferredContentInsetStart() {
        return this.w;
    }

    public final int getPreferredContentInsetStartWithNavigation() {
        if (this.z) {
            return 0;
        }
        return this.x;
    }

    @Nullable
    public final ScreenStackFragment getScreenFragment() {
        ViewParent parent = getParent();
        if (!(parent instanceof Screen)) {
            return null;
        }
        Fragment fragment = ((Screen) parent).getFragment();
        if (fragment instanceof ScreenStackFragment) {
            return (ScreenStackFragment) fragment;
        }
        return null;
    }

    @NotNull
    public final CustomToolbar getToolbar() {
        return this.f47027f;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.v = true;
        int iE = UIManagerHelper.e(this);
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new HeaderAttachedEvent(iE, getId()));
        }
        c();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.v = false;
        int iE = UIManagerHelper.e(this);
        Context context = getContext();
        Intrinsics.d(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        EventDispatcher eventDispatcherB = UIManagerHelper.b((ReactContext) context, getId());
        if (eventDispatcherB != null) {
            eventDispatcherB.g(new HeaderDetachedEvent(iE, getId()));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i2, int i3, int i4, int i5) {
    }

    public final void setBackButtonInCustomView(boolean z) {
        this.s = z;
    }

    public final void setBackgroundColor(@Nullable Integer num) {
        this.o = num;
    }

    public final void setDirection(@Nullable String str) {
        this.f47033l = str;
    }

    public final void setHeaderHidden(boolean z) {
        this.f47028g = z;
    }

    public final void setHeaderTranslucent(boolean z) {
        this.f47029h = z;
    }

    public final void setHidden(boolean z) {
        this.f47028g = z;
    }

    public final void setHideBackButton(boolean z) {
        this.p = z;
    }

    public final void setHideShadow(boolean z) {
        this.q = z;
    }

    public final void setTintColor(int i2) {
        this.u = i2;
    }

    public final void setTitle(@Nullable String str) {
        this.f47030i = str;
    }

    public final void setTitleColor(int i2) {
        this.f47031j = i2;
    }

    public final void setTitleEmpty(boolean z) {
        this.z = z;
    }

    public final void setTitleFontFamily(@Nullable String str) {
        this.f47032k = str;
    }

    public final void setTitleFontSize(float f2) {
        this.f47034m = f2;
    }

    public final void setTitleFontWeight(@Nullable String str) {
        this.n = ReactTypefaceUtils.d(str);
    }

    public final void setTopInsetEnabled(boolean z) {
        this.t = z;
    }

    public final void setTranslucent(boolean z) {
        this.f47029h = z;
    }
}
