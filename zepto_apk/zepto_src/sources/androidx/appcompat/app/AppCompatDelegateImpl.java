package androidx.appcompat.app;

import android.R;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.i;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.app.TwilightManager;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.SupportActionModeWrapper;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.WindowCallbackWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.FitWindowsViewGroup;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.app.AppLocalesStorageHelper;
import androidx.core.app.NavUtils;
import androidx.core.content.PermissionChecker;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.os.LocaleListCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import androidx.core.view.WindowInsetsCompat;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.WeakHashMap;
import org.apache.commons.lang3.time.DateUtils;
import org.xbill.DNS.KEYRecord;
import org.xbill.DNS.Type;

@RestrictTo
/* loaded from: classes.dex */
class AppCompatDelegateImpl extends AppCompatDelegate implements MenuBuilder.Callback, LayoutInflater.Factory2 {
    public static final SimpleArrayMap R0 = new SimpleArrayMap();
    public static final int[] S0 = {R.attr.windowBackground};
    public static final boolean T0 = !"robolectric".equals(Build.FINGERPRINT);
    public boolean A;
    public boolean A0;
    public ViewGroup B;
    public Configuration B0;
    public TextView C;
    public final int C0;
    public View D;
    public int D0;
    public boolean E;
    public int E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public AutoTimeNightModeManager G0;
    public boolean H;
    public AutoBatteryNightModeManager H0;
    public boolean I;
    public boolean I0;
    public boolean J;
    public int J0;
    public boolean K;
    public boolean L;
    public boolean L0;
    public PanelFeatureState[] M;
    public Rect M0;
    public Rect N0;
    public AppCompatViewInflater O0;
    public OnBackInvokedDispatcher P0;
    public PanelFeatureState Q;
    public OnBackInvokedCallback Q0;
    public boolean X;
    public boolean Y;
    public boolean Z;

    /* renamed from: j, reason: collision with root package name */
    public final Object f299j;

    /* renamed from: k, reason: collision with root package name */
    public final Context f300k;

    /* renamed from: l, reason: collision with root package name */
    public Window f301l;

    /* renamed from: m, reason: collision with root package name */
    public AppCompatWindowCallback f302m;
    public final Object n;
    public ActionBar o;
    public SupportMenuInflater p;
    public CharSequence q;
    public DecorContentParent r;
    public ActionMenuPresenterCallback s;
    public PanelMenuPresenterCallback t;
    public ActionMode u;
    public ActionBarContextView v;
    public PopupWindow w;
    public Runnable x;
    public ViewPropertyAnimatorCompat y = null;
    public final boolean z = true;
    public final Runnable K0 = new AnonymousClass2();

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass1 implements Thread.UncaughtExceptionHandler {
        @Override // java.lang.Thread.UncaughtExceptionHandler
        public final void uncaughtException(Thread thread, Throwable th) {
            boolean z = th instanceof Resources.NotFoundException;
            throw null;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$2, reason: invalid class name */
    public class AnonymousClass2 implements Runnable {
        public AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if ((appCompatDelegateImpl.J0 & 1) != 0) {
                appCompatDelegateImpl.N(0);
            }
            if ((appCompatDelegateImpl.J0 & 4096) != 0) {
                appCompatDelegateImpl.N(Type.EUI48);
            }
            appCompatDelegateImpl.I0 = false;
            appCompatDelegateImpl.J0 = 0;
        }
    }

    /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$4, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass4 implements FitWindowsViewGroup.OnFitSystemWindowsListener {
        @Override // androidx.appcompat.widget.FitWindowsViewGroup.OnFitSystemWindowsListener
        public final void a(Rect rect) {
            throw null;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
        public ActionBarDrawableToggleImpl(AppCompatDelegateImpl appCompatDelegateImpl) {
        }
    }

    /* loaded from: classes3.dex */
    public interface ActionBarMenuCallback {
    }

    /* loaded from: classes3.dex */
    public final class ActionMenuPresenterCallback implements MenuPresenter.Callback {
        public ActionMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void c(MenuBuilder menuBuilder, boolean z) {
            AppCompatDelegateImpl.this.J(menuBuilder);
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean d(MenuBuilder menuBuilder) {
            Window.Callback callback = AppCompatDelegateImpl.this.f301l.getCallback();
            if (callback == null) {
                return true;
            }
            callback.onMenuOpened(Type.EUI48, menuBuilder);
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class ActionModeCallbackWrapperV9 implements ActionMode.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final ActionMode.Callback f310a;

        public ActionModeCallbackWrapperV9(ActionMode.Callback callback) {
            this.f310a = callback;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [androidx.appcompat.app.AppCompatCallback, java.lang.Object] */
        @Override // androidx.appcompat.view.ActionMode.Callback
        public final void a(ActionMode actionMode) {
            this.f310a.a(actionMode);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (appCompatDelegateImpl.w != null) {
                appCompatDelegateImpl.f301l.getDecorView().removeCallbacks(appCompatDelegateImpl.x);
            }
            if (appCompatDelegateImpl.v != null) {
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.y;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.b();
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompatA = ViewCompat.a(appCompatDelegateImpl.v);
                viewPropertyAnimatorCompatA.a(0.0f);
                appCompatDelegateImpl.y = viewPropertyAnimatorCompatA;
                viewPropertyAnimatorCompatA.d(new ViewPropertyAnimatorListenerAdapter() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
                    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
                    public final void onAnimationEnd(View view) {
                        ActionModeCallbackWrapperV9 actionModeCallbackWrapperV9 = ActionModeCallbackWrapperV9.this;
                        AppCompatDelegateImpl.this.v.setVisibility(8);
                        AppCompatDelegateImpl appCompatDelegateImpl2 = AppCompatDelegateImpl.this;
                        PopupWindow popupWindow = appCompatDelegateImpl2.w;
                        if (popupWindow != null) {
                            popupWindow.dismiss();
                        } else if (appCompatDelegateImpl2.v.getParent() instanceof View) {
                            ViewCompat.x((View) appCompatDelegateImpl2.v.getParent());
                        }
                        appCompatDelegateImpl2.v.g();
                        appCompatDelegateImpl2.y.d(null);
                        appCompatDelegateImpl2.y = null;
                        ViewCompat.x(appCompatDelegateImpl2.B);
                    }
                });
            }
            appCompatDelegateImpl.n.onSupportActionModeFinished(appCompatDelegateImpl.u);
            appCompatDelegateImpl.u = null;
            ViewCompat.x(appCompatDelegateImpl.B);
            appCompatDelegateImpl.Z();
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean b(ActionMode actionMode, MenuBuilder menuBuilder) {
            return this.f310a.b(actionMode, menuBuilder);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean c(ActionMode actionMode, MenuItem menuItem) {
            return this.f310a.c(actionMode, menuItem);
        }

        @Override // androidx.appcompat.view.ActionMode.Callback
        public final boolean d(ActionMode actionMode, MenuBuilder menuBuilder) {
            ViewCompat.x(AppCompatDelegateImpl.this.B);
            return this.f310a.d(actionMode, menuBuilder);
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api21Impl {
        @DoNotInline
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        @DoNotInline
        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi
    public static class Api24Impl {
        @DoNotInline
        public static void a(@NonNull Configuration configuration, @NonNull Configuration configuration2, @NonNull Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        @DoNotInline
        public static LocaleListCompat b(Configuration configuration) {
            return LocaleListCompat.a(configuration.getLocales().toLanguageTags());
        }

        @DoNotInline
        public static void c(LocaleListCompat localeListCompat) {
            LocaleList.setDefault(LocaleList.forLanguageTags(localeListCompat.e()));
        }

        @DoNotInline
        public static void d(Configuration configuration, LocaleListCompat localeListCompat) {
            configuration.setLocales(LocaleList.forLanguageTags(localeListCompat.e()));
        }
    }

    @RequiresApi
    /* loaded from: classes3.dex */
    public static class Api26Impl {
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    @RequiresApi
    public static class Api33Impl {
        @DoNotInline
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [android.window.OnBackInvokedCallback, androidx.appcompat.app.e] */
        @DoNotInline
        public static OnBackInvokedCallback b(Object obj, final AppCompatDelegateImpl appCompatDelegateImpl) {
            Objects.requireNonNull(appCompatDelegateImpl);
            ?? r0 = new OnBackInvokedCallback() { // from class: androidx.appcompat.app.e
                public final void onBackInvoked() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                    appCompatDelegateImpl.U();
                }
            };
            i.j(obj).registerOnBackInvokedCallback(1000000, r0);
            return r0;
        }

        @DoNotInline
        public static void c(Object obj, Object obj2) {
            i.j(obj).unregisterOnBackInvokedCallback(i.g(obj2));
        }
    }

    public class AppCompatWindowCallback extends WindowCallbackWrapper {

        /* renamed from: b, reason: collision with root package name */
        public ToolbarActionBar.ToolbarMenuCallback f313b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f314c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f315d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f316e;

        public AppCompatWindowCallback(Window.Callback callback) {
            super(callback);
        }

        public final void a(Window.Callback callback) {
            try {
                this.f314c = true;
                callback.onContentChanged();
            } finally {
                this.f314c = false;
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            boolean z = this.f315d;
            Window.Callback callback = this.f518a;
            return z ? callback.dispatchKeyEvent(keyEvent) : AppCompatDelegateImpl.this.M(keyEvent) || callback.dispatchKeyEvent(keyEvent);
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (!this.f518a.dispatchKeyShortcutEvent(keyEvent)) {
                int keyCode = keyEvent.getKeyCode();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.R();
                ActionBar actionBar = appCompatDelegateImpl.o;
                if (actionBar == null || !actionBar.n(keyCode, keyEvent)) {
                    PanelFeatureState panelFeatureState = appCompatDelegateImpl.Q;
                    if (panelFeatureState == null || !appCompatDelegateImpl.W(panelFeatureState, keyEvent.getKeyCode(), keyEvent)) {
                        if (appCompatDelegateImpl.Q == null) {
                            PanelFeatureState panelFeatureStateQ = appCompatDelegateImpl.Q(0);
                            appCompatDelegateImpl.X(panelFeatureStateQ, keyEvent);
                            boolean zW = appCompatDelegateImpl.W(panelFeatureStateQ, keyEvent.getKeyCode(), keyEvent);
                            panelFeatureStateQ.f336k = false;
                            if (zW) {
                            }
                        }
                        return false;
                    }
                    PanelFeatureState panelFeatureState2 = appCompatDelegateImpl.Q;
                    if (panelFeatureState2 != null) {
                        panelFeatureState2.f337l = true;
                        return true;
                    }
                }
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final void onContentChanged() {
            if (this.f314c) {
                this.f518a.onContentChanged();
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof MenuBuilder)) {
                return this.f518a.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final View onCreatePanelView(int i2) {
            View viewA;
            ToolbarActionBar.ToolbarMenuCallback toolbarMenuCallback = this.f313b;
            return (toolbarMenuCallback == null || (viewA = toolbarMenuCallback.a(i2)) == null) ? this.f518a.onCreatePanelView(i2) : viewA;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean onMenuOpened(int i2, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i2 != 108) {
                appCompatDelegateImpl.getClass();
                return true;
            }
            appCompatDelegateImpl.R();
            ActionBar actionBar = appCompatDelegateImpl.o;
            if (actionBar != null) {
                actionBar.h(true);
            }
            return true;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final void onPanelClosed(int i2, Menu menu) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            if (this.f316e) {
                this.f518a.onPanelClosed(i2, menu);
                return;
            }
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (i2 == 108) {
                appCompatDelegateImpl.R();
                ActionBar actionBar = appCompatDelegateImpl.o;
                if (actionBar != null) {
                    actionBar.h(false);
                    return;
                }
                return;
            }
            if (i2 != 0) {
                appCompatDelegateImpl.getClass();
                return;
            }
            PanelFeatureState panelFeatureStateQ = appCompatDelegateImpl.Q(i2);
            if (panelFeatureStateQ.f338m) {
                appCompatDelegateImpl.K(panelFeatureStateQ, false);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final boolean onPreparePanel(int i2, View view, Menu menu) {
            MenuBuilder menuBuilder = menu instanceof MenuBuilder ? (MenuBuilder) menu : null;
            if (i2 == 0 && menuBuilder == null) {
                return false;
            }
            if (menuBuilder != null) {
                menuBuilder.z(true);
            }
            ToolbarActionBar.ToolbarMenuCallback toolbarMenuCallback = this.f313b;
            if (toolbarMenuCallback != null) {
                toolbarMenuCallback.b(i2);
            }
            boolean zOnPreparePanel = this.f518a.onPreparePanel(i2, view, menu);
            if (menuBuilder != null) {
                menuBuilder.z(false);
            }
            return zOnPreparePanel;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final void onProvideKeyboardShortcuts(List list, Menu menu, int i2) {
            MenuBuilder menuBuilder = AppCompatDelegateImpl.this.Q(0).f333h;
            if (menuBuilder != null) {
                super.onProvideKeyboardShortcuts(list, menuBuilder, i2);
            } else {
                super.onProvideKeyboardShortcuts(list, menu, i2);
            }
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        @Override // androidx.appcompat.view.WindowCallbackWrapper, android.view.Window.Callback
        public final android.view.ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.z || i2 != 0) {
                return super.onWindowStartingActionMode(callback, i2);
            }
            SupportActionModeWrapper.CallbackWrapper callbackWrapper = new SupportActionModeWrapper.CallbackWrapper(appCompatDelegateImpl.f300k, callback);
            androidx.appcompat.view.ActionMode actionModeE = appCompatDelegateImpl.E(callbackWrapper);
            if (actionModeE != null) {
                return callbackWrapper.e(actionModeE);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    public class AutoBatteryNightModeManager extends AutoNightModeManager {

        /* renamed from: c, reason: collision with root package name */
        public final PowerManager f318c;

        public AutoBatteryNightModeManager(Context context) {
            super();
            this.f318c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final void c() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
            AppCompatDelegateImpl.this.F(true, true);
        }

        public final int e() {
            return Api21Impl.a(this.f318c) ? 2 : 1;
        }
    }

    @RestrictTo
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public abstract class AutoNightModeManager {

        /* renamed from: a, reason: collision with root package name */
        public BroadcastReceiver f320a;

        public AutoNightModeManager() {
        }

        public final void a() {
            BroadcastReceiver broadcastReceiver = this.f320a;
            if (broadcastReceiver != null) {
                try {
                    AppCompatDelegateImpl.this.f300k.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.f320a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract void c();

        public final void d() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB.countActions() == 0) {
                return;
            }
            if (this.f320a == null) {
                this.f320a = new BroadcastReceiver() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager.1
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        AutoNightModeManager.this.c();
                    }
                };
            }
            AppCompatDelegateImpl.this.f300k.registerReceiver(this.f320a, intentFilterB);
        }
    }

    /* loaded from: classes3.dex */
    public class AutoTimeNightModeManager extends AutoNightModeManager {

        /* renamed from: c, reason: collision with root package name */
        public final TwilightManager f323c;

        public AutoTimeNightModeManager(TwilightManager twilightManager) {
            super();
            this.f323c = twilightManager;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.AutoNightModeManager
        public final void c() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
            AppCompatDelegateImpl.this.F(true, true);
        }

        public final int e() {
            Location location;
            boolean z;
            long j2;
            TwilightManager twilightManager = this.f323c;
            TwilightManager.TwilightState twilightState = twilightManager.f388c;
            if (twilightState.f390b > System.currentTimeMillis()) {
                z = twilightState.f389a;
            } else {
                Context context = twilightManager.f386a;
                int iA = PermissionChecker.a(context, "android.permission.ACCESS_COARSE_LOCATION");
                Location lastKnownLocation = null;
                LocationManager locationManager = twilightManager.f387b;
                if (iA == 0) {
                    try {
                    } catch (Exception e2) {
                        Log.d("TwilightManager", "Failed to get last known location", e2);
                    }
                    Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                    location = lastKnownLocation2;
                } else {
                    location = null;
                }
                if (PermissionChecker.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                    try {
                        if (locationManager.isProviderEnabled("gps")) {
                            lastKnownLocation = locationManager.getLastKnownLocation("gps");
                        }
                    } catch (Exception e3) {
                        Log.d("TwilightManager", "Failed to get last known location", e3);
                    }
                }
                if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                    location = lastKnownLocation;
                }
                if (location != null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TwilightCalculator.f381d == null) {
                        TwilightCalculator.f381d = new TwilightCalculator();
                    }
                    TwilightCalculator twilightCalculator = TwilightCalculator.f381d;
                    twilightCalculator.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis - DateUtils.MILLIS_PER_DAY);
                    twilightCalculator.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis);
                    z = twilightCalculator.f384c == 1;
                    long j3 = twilightCalculator.f383b;
                    long j4 = twilightCalculator.f382a;
                    twilightCalculator.a(location.getLatitude(), location.getLongitude(), jCurrentTimeMillis + DateUtils.MILLIS_PER_DAY);
                    long j5 = twilightCalculator.f383b;
                    if (j3 == -1 || j4 == -1) {
                        j2 = jCurrentTimeMillis + 43200000;
                    } else {
                        if (jCurrentTimeMillis <= j4) {
                            j5 = jCurrentTimeMillis > j3 ? j4 : j3;
                        }
                        j2 = j5 + DateUtils.MILLIS_PER_MINUTE;
                    }
                    twilightState.f389a = z;
                    twilightState.f390b = j2;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i2 = Calendar.getInstance().get(11);
                    if (i2 < 6 || i2 >= 22) {
                        z = true;
                    }
                }
            }
            return z ? 2 : 1;
        }
    }

    /* loaded from: classes3.dex */
    public class ListMenuDecorView extends ContentFrameLayout {
        public ListMenuDecorView(ContextThemeWrapper contextThemeWrapper) {
            super(contextThemeWrapper, null);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.M(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                    appCompatDelegateImpl.K(appCompatDelegateImpl.Q(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public final void setBackgroundResource(int i2) {
            setBackgroundDrawable(AppCompatResources.b(i2, getContext()));
        }
    }

    public static final class PanelFeatureState {

        /* renamed from: a, reason: collision with root package name */
        public int f326a;

        /* renamed from: b, reason: collision with root package name */
        public int f327b;

        /* renamed from: c, reason: collision with root package name */
        public int f328c;

        /* renamed from: d, reason: collision with root package name */
        public int f329d;

        /* renamed from: e, reason: collision with root package name */
        public ViewGroup f330e;

        /* renamed from: f, reason: collision with root package name */
        public View f331f;

        /* renamed from: g, reason: collision with root package name */
        public View f332g;

        /* renamed from: h, reason: collision with root package name */
        public MenuBuilder f333h;

        /* renamed from: i, reason: collision with root package name */
        public ListMenuPresenter f334i;

        /* renamed from: j, reason: collision with root package name */
        public ContextThemeWrapper f335j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f336k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f337l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f338m;
        public boolean n;
        public boolean o;
        public Bundle p;

        @SuppressLint({"BanParcelableUsage"})
        /* loaded from: classes3.dex */
        public static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();

            /* renamed from: a, reason: collision with root package name */
            public int f339a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f340b;

            /* renamed from: c, reason: collision with root package name */
            public Bundle f341c;

            /* renamed from: androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState$SavedState$1, reason: invalid class name */
            public class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
                @Override // android.os.Parcelable.ClassLoaderCreator
                public final SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public final Object[] newArray(int i2) {
                    return new SavedState[i2];
                }

                @Override // android.os.Parcelable.Creator
                public final Object createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, null);
                }
            }

            public static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f339a = parcel.readInt();
                boolean z = parcel.readInt() == 1;
                savedState.f340b = z;
                if (z) {
                    savedState.f341c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            @Override // android.os.Parcelable
            public final int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f339a);
                parcel.writeInt(this.f340b ? 1 : 0);
                if (this.f340b) {
                    parcel.writeBundle(this.f341c);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class PanelMenuPresenterCallback implements MenuPresenter.Callback {
        public PanelMenuPresenterCallback() {
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final void c(MenuBuilder menuBuilder, boolean z) {
            PanelFeatureState panelFeatureState;
            MenuBuilder menuBuilderL = menuBuilder.l();
            int i2 = 0;
            boolean z2 = menuBuilderL != menuBuilder;
            if (z2) {
                menuBuilder = menuBuilderL;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            PanelFeatureState[] panelFeatureStateArr = appCompatDelegateImpl.M;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            while (true) {
                if (i2 < length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                    if (panelFeatureState != null && panelFeatureState.f333h == menuBuilder) {
                        break;
                    } else {
                        i2++;
                    }
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                if (!z2) {
                    appCompatDelegateImpl.K(panelFeatureState, z);
                } else {
                    appCompatDelegateImpl.I(panelFeatureState.f326a, panelFeatureState, menuBuilderL);
                    appCompatDelegateImpl.K(panelFeatureState, true);
                }
            }
        }

        @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
        public final boolean d(MenuBuilder menuBuilder) {
            Window.Callback callback;
            if (menuBuilder != menuBuilder.l()) {
                return true;
            }
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (!appCompatDelegateImpl.G || (callback = appCompatDelegateImpl.f301l.getCallback()) == null || appCompatDelegateImpl.A0) {
                return true;
            }
            callback.onMenuOpened(Type.EUI48, menuBuilder);
            return true;
        }
    }

    public AppCompatDelegateImpl(Context context, Window window, AppCompatCallback appCompatCallback, Object obj) {
        AppCompatActivity appCompatActivity = null;
        this.C0 = -100;
        this.f300k = context;
        this.n = appCompatCallback;
        this.f299j = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof AppCompatActivity)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        appCompatActivity = (AppCompatActivity) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (appCompatActivity != null) {
                this.C0 = appCompatActivity.getDelegate().i();
            }
        }
        if (this.C0 == -100) {
            SimpleArrayMap simpleArrayMap = R0;
            Integer num = (Integer) simpleArrayMap.get(this.f299j.getClass().getName());
            if (num != null) {
                this.C0 = num.intValue();
                simpleArrayMap.remove(this.f299j.getClass().getName());
            }
        }
        if (window != null) {
            G(window);
        }
        AppCompatDrawableManager.d();
    }

    public static LocaleListCompat H(Context context) {
        LocaleListCompat localeListCompat;
        if (Build.VERSION.SDK_INT >= 33 || (localeListCompat = AppCompatDelegate.f288c) == null) {
            return null;
        }
        LocaleListCompat localeListCompatB = Api24Impl.b(context.getApplicationContext().getResources().getConfiguration());
        LocaleListCompat localeListCompatA = LocaleOverlayHelper.a(localeListCompat, localeListCompatB);
        return localeListCompatA.c() ? localeListCompatB : localeListCompatA;
    }

    public static Configuration L(Context context, int i2, LocaleListCompat localeListCompat, Configuration configuration, boolean z) {
        int i3 = i2 != 1 ? i2 != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (localeListCompat != null) {
            Api24Impl.d(configuration2, localeListCompat);
        }
        return configuration2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void B(Toolbar toolbar) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object obj = this.f299j;
        if (obj instanceof Activity) {
            R();
            ActionBar actionBar = this.o;
            if (actionBar instanceof WindowDecorActionBar) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.p = null;
            if (actionBar != null) {
                actionBar.m();
            }
            this.o = null;
            if (toolbar != null) {
                ToolbarActionBar toolbarActionBar = new ToolbarActionBar(toolbar, obj instanceof Activity ? ((Activity) obj).getTitle() : this.q, this.f302m);
                this.o = toolbarActionBar;
                this.f302m.f313b = toolbarActionBar.f368c;
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.f302m.f313b = null;
            }
            m();
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void C(int i2) {
        this.D0 = i2;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void D(CharSequence charSequence) {
        this.q = charSequence;
        DecorContentParent decorContentParent = this.r;
        if (decorContentParent != null) {
            decorContentParent.setWindowTitle(charSequence);
            return;
        }
        ActionBar actionBar = this.o;
        if (actionBar != null) {
            actionBar.v(charSequence);
            return;
        }
        TextView textView = this.C;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018a  */
    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.appcompat.app.AppCompatCallback, java.lang.Object] */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.appcompat.view.ActionMode E(androidx.appcompat.view.ActionMode.Callback r9) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.E(androidx.appcompat.view.ActionMode$Callback):androidx.appcompat.view.ActionMode");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean F(boolean r17, boolean r18) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, android.content.pm.PackageManager.NameNotFoundException, java.lang.SecurityException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.F(boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void G(android.view.Window r4) {
        /*
            r3 = this;
            android.view.Window r0 = r3.f301l
            java.lang.String r1 = "AppCompat has already installed itself into the Window"
            if (r0 != 0) goto L66
            android.view.Window$Callback r0 = r4.getCallback()
            boolean r2 = r0 instanceof androidx.appcompat.app.AppCompatDelegateImpl.AppCompatWindowCallback
            if (r2 != 0) goto L60
            androidx.appcompat.app.AppCompatDelegateImpl$AppCompatWindowCallback r1 = new androidx.appcompat.app.AppCompatDelegateImpl$AppCompatWindowCallback
            r1.<init>(r0)
            r3.f302m = r1
            r4.setCallback(r1)
            android.content.Context r0 = r3.f300k
            r1 = 0
            int[] r2 = androidx.appcompat.app.AppCompatDelegateImpl.S0
            androidx.appcompat.widget.TintTypedArray r0 = androidx.appcompat.widget.TintTypedArray.e(r0, r1, r2)
            r2 = 0
            android.graphics.drawable.Drawable r2 = r0.c(r2)
            if (r2 == 0) goto L2b
            r4.setBackgroundDrawable(r2)
        L2b:
            r0.g()
            r3.f301l = r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r0 = 33
            if (r4 < r0) goto L5f
            android.window.OnBackInvokedDispatcher r4 = r3.P0
            if (r4 != 0) goto L5f
            if (r4 == 0) goto L45
            android.window.OnBackInvokedCallback r0 = r3.Q0
            if (r0 == 0) goto L45
            androidx.appcompat.app.AppCompatDelegateImpl.Api33Impl.c(r4, r0)
            r3.Q0 = r1
        L45:
            java.lang.Object r4 = r3.f299j
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L5a
            android.app.Activity r4 = (android.app.Activity) r4
            android.view.Window r0 = r4.getWindow()
            if (r0 == 0) goto L5a
            android.window.OnBackInvokedDispatcher r4 = androidx.appcompat.app.AppCompatDelegateImpl.Api33Impl.a(r4)
            r3.P0 = r4
            goto L5c
        L5a:
            r3.P0 = r1
        L5c:
            r3.Z()
        L5f:
            return
        L60:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r1)
            throw r4
        L66:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            r4.<init>(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.G(android.view.Window):void");
    }

    public final void I(int i2, PanelFeatureState panelFeatureState, MenuBuilder menuBuilder) {
        if (menuBuilder == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.M;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menuBuilder = panelFeatureState.f333h;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f338m) && !this.A0) {
            AppCompatWindowCallback appCompatWindowCallback = this.f302m;
            Window.Callback callback = this.f301l.getCallback();
            appCompatWindowCallback.getClass();
            try {
                appCompatWindowCallback.f316e = true;
                callback.onPanelClosed(i2, menuBuilder);
            } finally {
                appCompatWindowCallback.f316e = false;
            }
        }
    }

    public final void J(MenuBuilder menuBuilder) {
        if (this.L) {
            return;
        }
        this.L = true;
        this.r.l();
        Window.Callback callback = this.f301l.getCallback();
        if (callback != null && !this.A0) {
            callback.onPanelClosed(Type.EUI48, menuBuilder);
        }
        this.L = false;
    }

    public final void K(PanelFeatureState panelFeatureState, boolean z) {
        ViewGroup viewGroup;
        DecorContentParent decorContentParent;
        if (z && panelFeatureState.f326a == 0 && (decorContentParent = this.r) != null && decorContentParent.e()) {
            J(panelFeatureState.f333h);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f300k.getSystemService("window");
        if (windowManager != null && panelFeatureState.f338m && (viewGroup = panelFeatureState.f330e) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                I(panelFeatureState.f326a, panelFeatureState, null);
            }
        }
        panelFeatureState.f336k = false;
        panelFeatureState.f337l = false;
        panelFeatureState.f338m = false;
        panelFeatureState.f331f = null;
        panelFeatureState.n = true;
        if (this.Q == panelFeatureState) {
            this.Q = null;
        }
        if (panelFeatureState.f326a == 0) {
            Z();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean M(android.view.KeyEvent r7) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.M(android.view.KeyEvent):boolean");
    }

    public final void N(int i2) {
        PanelFeatureState panelFeatureStateQ = Q(i2);
        if (panelFeatureStateQ.f333h != null) {
            Bundle bundle = new Bundle();
            panelFeatureStateQ.f333h.v(bundle);
            if (bundle.size() > 0) {
                panelFeatureStateQ.p = bundle;
            }
            panelFeatureStateQ.f333h.B();
            panelFeatureStateQ.f333h.clear();
        }
        panelFeatureStateQ.o = true;
        panelFeatureStateQ.n = true;
        if ((i2 == 108 || i2 == 0) && this.r != null) {
            PanelFeatureState panelFeatureStateQ2 = Q(0);
            panelFeatureStateQ2.f336k = false;
            X(panelFeatureStateQ2, null);
        }
    }

    public final void O() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        ViewGroup viewGroup;
        if (this.A) {
            return;
        }
        int[] iArr = androidx.appcompat.R.styleable.AppCompatTheme;
        Context context = this.f300k;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!typedArrayObtainStyledAttributes.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar)) {
            typedArrayObtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowNoTitle, false)) {
            w(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBar, false)) {
            w(Type.EUI48);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
            w(109);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
            w(10);
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(androidx.appcompat.R.styleable.AppCompatTheme_android_windowIsFloating, false);
        typedArrayObtainStyledAttributes.recycle();
        P();
        this.f301l.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        if (this.K) {
            viewGroup = this.I ? (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.J) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(androidx.appcompat.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.H = false;
            this.G = false;
        } else if (this.G) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(androidx.appcompat.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new ContextThemeWrapper(context, typedValue.resourceId) : context).inflate(androidx.appcompat.R.layout.abc_screen_toolbar, (ViewGroup) null);
            DecorContentParent decorContentParent = (DecorContentParent) viewGroup.findViewById(androidx.appcompat.R.id.decor_content_parent);
            this.r = decorContentParent;
            decorContentParent.setWindowCallback(this.f301l.getCallback());
            if (this.H) {
                this.r.h(109);
            }
            if (this.E) {
                this.r.h(2);
            }
            if (this.F) {
                this.r.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.G + ", windowActionBarOverlay: " + this.H + ", android:windowIsFloating: " + this.J + ", windowActionModeOverlay: " + this.I + ", windowNoTitle: " + this.K + " }");
        }
        ViewCompat.H(viewGroup, new OnApplyWindowInsetsListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.3
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
                boolean z;
                boolean z2;
                int iJ = windowInsetsCompat.j();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.getClass();
                int iJ2 = windowInsetsCompat.j();
                ActionBarContextView actionBarContextView = appCompatDelegateImpl.v;
                if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    z = false;
                } else {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) appCompatDelegateImpl.v.getLayoutParams();
                    if (appCompatDelegateImpl.v.isShown()) {
                        if (appCompatDelegateImpl.M0 == null) {
                            appCompatDelegateImpl.M0 = new Rect();
                            appCompatDelegateImpl.N0 = new Rect();
                        }
                        Rect rect = appCompatDelegateImpl.M0;
                        Rect rect2 = appCompatDelegateImpl.N0;
                        rect.set(windowInsetsCompat.h(), windowInsetsCompat.j(), windowInsetsCompat.i(), windowInsetsCompat.g());
                        ViewUtils.a(appCompatDelegateImpl.B, rect, rect2);
                        int i2 = rect.top;
                        int i3 = rect.left;
                        int i4 = rect.right;
                        WindowInsetsCompat windowInsetsCompatM = ViewCompat.m(appCompatDelegateImpl.B);
                        int iH = windowInsetsCompatM == null ? 0 : windowInsetsCompatM.h();
                        int i5 = windowInsetsCompatM == null ? 0 : windowInsetsCompatM.i();
                        if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                            z2 = false;
                        } else {
                            marginLayoutParams.topMargin = i2;
                            marginLayoutParams.leftMargin = i3;
                            marginLayoutParams.rightMargin = i4;
                            z2 = true;
                        }
                        Context context2 = appCompatDelegateImpl.f300k;
                        if (i2 <= 0 || appCompatDelegateImpl.D != null) {
                            View view2 = appCompatDelegateImpl.D;
                            if (view2 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                                int i6 = marginLayoutParams2.height;
                                int i7 = marginLayoutParams.topMargin;
                                if (i6 != i7 || marginLayoutParams2.leftMargin != iH || marginLayoutParams2.rightMargin != i5) {
                                    marginLayoutParams2.height = i7;
                                    marginLayoutParams2.leftMargin = iH;
                                    marginLayoutParams2.rightMargin = i5;
                                    appCompatDelegateImpl.D.setLayoutParams(marginLayoutParams2);
                                }
                            }
                        } else {
                            View view3 = new View(context2);
                            appCompatDelegateImpl.D = view3;
                            view3.setVisibility(8);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                            layoutParams.leftMargin = iH;
                            layoutParams.rightMargin = i5;
                            appCompatDelegateImpl.B.addView(appCompatDelegateImpl.D, -1, layoutParams);
                        }
                        View view4 = appCompatDelegateImpl.D;
                        z = view4 != null;
                        if (z && view4.getVisibility() != 0) {
                            View view5 = appCompatDelegateImpl.D;
                            view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & KEYRecord.Flags.FLAG2) != 0 ? context2.getColor(androidx.appcompat.R.color.abc_decor_view_status_guard_light) : context2.getColor(androidx.appcompat.R.color.abc_decor_view_status_guard));
                        }
                        if (!appCompatDelegateImpl.I && z) {
                            iJ2 = 0;
                        }
                        boolean z3 = z;
                        z = z2;
                        z = z3;
                    } else if (marginLayoutParams.topMargin != 0) {
                        marginLayoutParams.topMargin = 0;
                        z = false;
                    } else {
                        z = false;
                        z = false;
                    }
                    if (z) {
                        appCompatDelegateImpl.v.setLayoutParams(marginLayoutParams);
                    }
                }
                View view6 = appCompatDelegateImpl.D;
                if (view6 != null) {
                    view6.setVisibility(z ? 0 : 8);
                }
                return ViewCompat.t(view, iJ != iJ2 ? windowInsetsCompat.p(windowInsetsCompat.h(), iJ2, windowInsetsCompat.i(), windowInsetsCompat.g()) : windowInsetsCompat);
            }
        });
        if (this.r == null) {
            this.C = (TextView) viewGroup.findViewById(androidx.appcompat.R.id.title);
        }
        boolean z = ViewUtils.f1266a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", null);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, null);
        } catch (IllegalAccessException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e3) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e3);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(androidx.appcompat.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.f301l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.f301l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new ContentFrameLayout.OnAttachListener() { // from class: androidx.appcompat.app.AppCompatDelegateImpl.5
            @Override // androidx.appcompat.widget.ContentFrameLayout.OnAttachListener
            public final void onDetachedFromWindow() {
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                DecorContentParent decorContentParent2 = appCompatDelegateImpl.r;
                if (decorContentParent2 != null) {
                    decorContentParent2.l();
                }
                if (appCompatDelegateImpl.w != null) {
                    appCompatDelegateImpl.f301l.getDecorView().removeCallbacks(appCompatDelegateImpl.x);
                    if (appCompatDelegateImpl.w.isShowing()) {
                        try {
                            appCompatDelegateImpl.w.dismiss();
                        } catch (IllegalArgumentException unused2) {
                        }
                    }
                    appCompatDelegateImpl.w = null;
                }
                ViewPropertyAnimatorCompat viewPropertyAnimatorCompat = appCompatDelegateImpl.y;
                if (viewPropertyAnimatorCompat != null) {
                    viewPropertyAnimatorCompat.b();
                }
                MenuBuilder menuBuilder = appCompatDelegateImpl.Q(0).f333h;
                if (menuBuilder != null) {
                    menuBuilder.close();
                }
            }
        });
        this.B = viewGroup;
        Object obj = this.f299j;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
        if (!TextUtils.isEmpty(title)) {
            DecorContentParent decorContentParent2 = this.r;
            if (decorContentParent2 != null) {
                decorContentParent2.setWindowTitle(title);
            } else {
                ActionBar actionBar = this.o;
                if (actionBar != null) {
                    actionBar.v(title);
                } else {
                    TextView textView = this.C;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.B.findViewById(R.id.content);
        View decorView = this.f301l.getDecorView();
        contentFrameLayout2.f1006g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(androidx.appcompat.R.styleable.AppCompatTheme);
        typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
        typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes2.hasValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            typedArrayObtainStyledAttributes2.getValue(androidx.appcompat.R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.A = true;
        PanelFeatureState panelFeatureStateQ = Q(0);
        if (this.A0 || panelFeatureStateQ.f333h != null) {
            return;
        }
        S(Type.EUI48);
    }

    public final void P() {
        if (this.f301l == null) {
            Object obj = this.f299j;
            if (obj instanceof Activity) {
                G(((Activity) obj).getWindow());
            }
        }
        if (this.f301l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final PanelFeatureState Q(int i2) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[i2 + 1];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState();
        panelFeatureState2.f326a = i2;
        panelFeatureState2.n = false;
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    public final void R() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
        if (this.G && this.o == null) {
            Object obj = this.f299j;
            if (obj instanceof Activity) {
                this.o = new WindowDecorActionBar((Activity) obj, this.H);
            } else if (obj instanceof Dialog) {
                this.o = new WindowDecorActionBar((Dialog) obj);
            }
            ActionBar actionBar = this.o;
            if (actionBar != null) {
                actionBar.q(this.L0);
            }
        }
    }

    public final void S(int i2) {
        this.J0 = (1 << i2) | this.J0;
        if (this.I0) {
            return;
        }
        View decorView = this.f301l.getDecorView();
        Runnable runnable = this.K0;
        WeakHashMap weakHashMap = ViewCompat.f3080a;
        decorView.postOnAnimation(runnable);
        this.I0 = true;
    }

    public final int T(int i2, Context context) {
        if (i2 != -100) {
            if (i2 == -1) {
                return i2;
            }
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
                    return i2;
                }
                if (i2 != 3) {
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
                if (this.H0 == null) {
                    this.H0 = new AutoBatteryNightModeManager(context);
                }
                return this.H0.e();
            }
            if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                if (this.G0 == null) {
                    this.G0 = new AutoTimeNightModeManager(TwilightManager.a(context));
                }
                return this.G0.e();
            }
        }
        return -1;
    }

    public final boolean U() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        boolean z = this.X;
        this.X = false;
        PanelFeatureState panelFeatureStateQ = Q(0);
        if (!panelFeatureStateQ.f338m) {
            androidx.appcompat.view.ActionMode actionMode = this.u;
            if (actionMode != null) {
                actionMode.c();
                return true;
            }
            R();
            ActionBar actionBar = this.o;
            if (actionBar == null || !actionBar.g()) {
                return false;
            }
        } else if (!z) {
            K(panelFeatureStateQ, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void V(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r18, android.view.KeyEvent r19) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 429
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.V(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):void");
    }

    public final boolean W(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent) {
        MenuBuilder menuBuilder;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f336k || X(panelFeatureState, keyEvent)) && (menuBuilder = panelFeatureState.f333h) != null) {
            return menuBuilder.performShortcut(i2, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean X(androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState r12, android.view.KeyEvent r13) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.X(androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState, android.view.KeyEvent):boolean");
    }

    public final void Y() {
        if (this.A) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void Z() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.P0 != null && (Q(0).f338m || this.u != null)) {
                z = true;
            }
            if (z && this.Q0 == null) {
                this.Q0 = Api33Impl.b(this.P0, this);
            } else {
                if (z || (onBackInvokedCallback = this.Q0) == null) {
                    return;
                }
                Api33Impl.c(this.P0, onBackInvokedCallback);
                this.Q0 = null;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final boolean a(MenuBuilder menuBuilder, MenuItem menuItem) {
        PanelFeatureState panelFeatureState;
        Window.Callback callback = this.f301l.getCallback();
        if (callback != null && !this.A0) {
            MenuBuilder menuBuilderL = menuBuilder.l();
            PanelFeatureState[] panelFeatureStateArr = this.M;
            int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
            int i2 = 0;
            while (true) {
                if (i2 < length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                    if (panelFeatureState != null && panelFeatureState.f333h == menuBuilderL) {
                        break;
                    }
                    i2++;
                } else {
                    panelFeatureState = null;
                    break;
                }
            }
            if (panelFeatureState != null) {
                return callback.onMenuItemSelected(panelFeatureState.f326a, menuItem);
            }
        }
        return false;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public final void b(MenuBuilder menuBuilder) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        DecorContentParent decorContentParent = this.r;
        if (decorContentParent == null || !decorContentParent.a() || (ViewConfiguration.get(this.f300k).hasPermanentMenuKey() && !this.r.g())) {
            PanelFeatureState panelFeatureStateQ = Q(0);
            panelFeatureStateQ.n = true;
            K(panelFeatureStateQ, false);
            V(panelFeatureStateQ, null);
            return;
        }
        Window.Callback callback = this.f301l.getCallback();
        if (this.r.e()) {
            this.r.c();
            if (this.A0) {
                return;
            }
            callback.onPanelClosed(Type.EUI48, Q(0).f333h);
            return;
        }
        if (callback == null || this.A0) {
            return;
        }
        if (this.I0 && (1 & this.J0) != 0) {
            View decorView = this.f301l.getDecorView();
            Runnable runnable = this.K0;
            decorView.removeCallbacks(runnable);
            ((AnonymousClass2) runnable).run();
        }
        PanelFeatureState panelFeatureStateQ2 = Q(0);
        MenuBuilder menuBuilder2 = panelFeatureStateQ2.f333h;
        if (menuBuilder2 == null || panelFeatureStateQ2.o || !callback.onPreparePanel(0, panelFeatureStateQ2.f332g, menuBuilder2)) {
            return;
        }
        callback.onMenuOpened(Type.EUI48, panelFeatureStateQ2.f333h);
        this.r.d();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void c(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
        ((ViewGroup) this.B.findViewById(R.id.content)).addView(view, layoutParams);
        this.f302m.a(this.f301l.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean d() {
        return F(true, true);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final Context e(final Context context) {
        this.Y = true;
        int i2 = this.C0;
        if (i2 == -100) {
            i2 = AppCompatDelegate.f287b;
        }
        int iT = T(i2, context);
        if (AppCompatDelegate.n(context) && AppCompatDelegate.n(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (AppCompatDelegate.f294i) {
                    try {
                        LocaleListCompat localeListCompat = AppCompatDelegate.f288c;
                        if (localeListCompat == null) {
                            if (AppCompatDelegate.f289d == null) {
                                AppCompatDelegate.f289d = LocaleListCompat.a(AppLocalesStorageHelper.b(context));
                            }
                            if (!AppCompatDelegate.f289d.c()) {
                                AppCompatDelegate.f288c = AppCompatDelegate.f289d;
                            }
                        } else if (!localeListCompat.equals(AppCompatDelegate.f289d)) {
                            LocaleListCompat localeListCompat2 = AppCompatDelegate.f288c;
                            AppCompatDelegate.f289d = localeListCompat2;
                            AppLocalesStorageHelper.a(context, localeListCompat2.e());
                        }
                    } finally {
                    }
                }
            } else if (!AppCompatDelegate.f291f) {
                AppCompatDelegate.f286a.execute(new Runnable() { // from class: androidx.appcompat.app.a
                    /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final void run() {
                        /*
                            r7 = this;
                            int r0 = android.os.Build.VERSION.SDK_INT
                            r1 = 1
                            r2 = 33
                            if (r0 < r2) goto L79
                            androidx.appcompat.app.AppCompatDelegate$SerialExecutor r3 = androidx.appcompat.app.AppCompatDelegate.f286a
                            android.content.ComponentName r3 = new android.content.ComponentName
                            android.content.Context r4 = r1
                            java.lang.String r5 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
                            r3.<init>(r4, r5)
                            android.content.pm.PackageManager r5 = r4.getPackageManager()
                            int r5 = r5.getComponentEnabledSetting(r3)
                            if (r5 == r1) goto L79
                            java.lang.String r5 = "locale"
                            if (r0 < r2) goto L54
                            androidx.collection.ArraySet r0 = androidx.appcompat.app.AppCompatDelegate.f292g
                            java.util.Iterator r0 = r0.iterator()
                        L26:
                            r2 = r0
                            androidx.collection.IndexBasedArrayIterator r2 = (androidx.collection.IndexBasedArrayIterator) r2
                            boolean r6 = r2.hasNext()
                            if (r6 == 0) goto L48
                            java.lang.Object r2 = r2.next()
                            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2
                            java.lang.Object r2 = r2.get()
                            androidx.appcompat.app.AppCompatDelegate r2 = (androidx.appcompat.app.AppCompatDelegate) r2
                            if (r2 == 0) goto L26
                            android.content.Context r2 = r2.g()
                            if (r2 == 0) goto L26
                            java.lang.Object r0 = r2.getSystemService(r5)
                            goto L49
                        L48:
                            r0 = 0
                        L49:
                            if (r0 == 0) goto L59
                            android.os.LocaleList r0 = androidx.appcompat.app.AppCompatDelegate.Api33Impl.a(r0)
                            androidx.core.os.LocaleListCompat r0 = androidx.core.os.LocaleListCompat.f(r0)
                            goto L5b
                        L54:
                            androidx.core.os.LocaleListCompat r0 = androidx.appcompat.app.AppCompatDelegate.f288c
                            if (r0 == 0) goto L59
                            goto L5b
                        L59:
                            androidx.core.os.LocaleListCompat r0 = androidx.core.os.LocaleListCompat.f2881b
                        L5b:
                            boolean r0 = r0.c()
                            if (r0 == 0) goto L72
                            java.lang.String r0 = androidx.core.app.AppLocalesStorageHelper.b(r4)
                            java.lang.Object r2 = r4.getSystemService(r5)
                            if (r2 == 0) goto L72
                            android.os.LocaleList r0 = androidx.appcompat.app.AppCompatDelegate.Api24Impl.a(r0)
                            androidx.appcompat.app.AppCompatDelegate.Api33Impl.b(r2, r0)
                        L72:
                            android.content.pm.PackageManager r0 = r4.getPackageManager()
                            r0.setComponentEnabledSetting(r3, r1, r1)
                        L79:
                            androidx.appcompat.app.AppCompatDelegate.f291f = r1
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.a.run():void");
                    }
                });
            }
        }
        LocaleListCompat localeListCompatH = H(context);
        Configuration configuration = null;
        if (context instanceof android.view.ContextThemeWrapper) {
            try {
                ((android.view.ContextThemeWrapper) context).applyOverrideConfiguration(L(context, iT, localeListCompatH, null, false));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).a(L(context, iT, localeListCompatH, null, false));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!T0) {
            return context;
        }
        Configuration configuration2 = new Configuration();
        configuration2.uiMode = -1;
        configuration2.fontScale = 0.0f;
        Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
        Configuration configuration4 = context.getResources().getConfiguration();
        configuration3.uiMode = configuration4.uiMode;
        if (!configuration3.equals(configuration4)) {
            configuration = new Configuration();
            configuration.fontScale = 0.0f;
            if (configuration3.diff(configuration4) != 0) {
                float f2 = configuration3.fontScale;
                float f3 = configuration4.fontScale;
                if (f2 != f3) {
                    configuration.fontScale = f3;
                }
                int i3 = configuration3.mcc;
                int i4 = configuration4.mcc;
                if (i3 != i4) {
                    configuration.mcc = i4;
                }
                int i5 = configuration3.mnc;
                int i6 = configuration4.mnc;
                if (i5 != i6) {
                    configuration.mnc = i6;
                }
                int i7 = Build.VERSION.SDK_INT;
                Api24Impl.a(configuration3, configuration4, configuration);
                int i8 = configuration3.touchscreen;
                int i9 = configuration4.touchscreen;
                if (i8 != i9) {
                    configuration.touchscreen = i9;
                }
                int i10 = configuration3.keyboard;
                int i11 = configuration4.keyboard;
                if (i10 != i11) {
                    configuration.keyboard = i11;
                }
                int i12 = configuration3.keyboardHidden;
                int i13 = configuration4.keyboardHidden;
                if (i12 != i13) {
                    configuration.keyboardHidden = i13;
                }
                int i14 = configuration3.navigation;
                int i15 = configuration4.navigation;
                if (i14 != i15) {
                    configuration.navigation = i15;
                }
                int i16 = configuration3.navigationHidden;
                int i17 = configuration4.navigationHidden;
                if (i16 != i17) {
                    configuration.navigationHidden = i17;
                }
                int i18 = configuration3.orientation;
                int i19 = configuration4.orientation;
                if (i18 != i19) {
                    configuration.orientation = i19;
                }
                int i20 = configuration3.screenLayout & 15;
                int i21 = configuration4.screenLayout & 15;
                if (i20 != i21) {
                    configuration.screenLayout |= i21;
                }
                int i22 = configuration3.screenLayout & 192;
                int i23 = configuration4.screenLayout & 192;
                if (i22 != i23) {
                    configuration.screenLayout |= i23;
                }
                int i24 = configuration3.screenLayout & 48;
                int i25 = configuration4.screenLayout & 48;
                if (i24 != i25) {
                    configuration.screenLayout |= i25;
                }
                int i26 = configuration3.screenLayout & 768;
                int i27 = configuration4.screenLayout & 768;
                if (i26 != i27) {
                    configuration.screenLayout |= i27;
                }
                if (i7 >= 26) {
                    Api26Impl.a(configuration3, configuration4, configuration);
                }
                int i28 = configuration3.uiMode & 15;
                int i29 = configuration4.uiMode & 15;
                if (i28 != i29) {
                    configuration.uiMode |= i29;
                }
                int i30 = configuration3.uiMode & 48;
                int i31 = configuration4.uiMode & 48;
                if (i30 != i31) {
                    configuration.uiMode |= i31;
                }
                int i32 = configuration3.screenWidthDp;
                int i33 = configuration4.screenWidthDp;
                if (i32 != i33) {
                    configuration.screenWidthDp = i33;
                }
                int i34 = configuration3.screenHeightDp;
                int i35 = configuration4.screenHeightDp;
                if (i34 != i35) {
                    configuration.screenHeightDp = i35;
                }
                int i36 = configuration3.smallestScreenWidthDp;
                int i37 = configuration4.smallestScreenWidthDp;
                if (i36 != i37) {
                    configuration.smallestScreenWidthDp = i37;
                }
                int i38 = configuration3.densityDpi;
                int i39 = configuration4.densityDpi;
                if (i38 != i39) {
                    configuration.densityDpi = i39;
                }
            }
        }
        Configuration configurationL = L(context, iT, localeListCompatH, configuration, true);
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, androidx.appcompat.R.style.Theme_AppCompat_Empty);
        contextThemeWrapper.a(configurationL);
        try {
            if (context.getTheme() != null) {
                ResourcesCompat.ThemeCompat.a(contextThemeWrapper.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return contextThemeWrapper;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final View f(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
        return this.f301l.findViewById(i2);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final Context g() {
        return this.f300k;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBarDrawerToggle.Delegate h() {
        return new ActionBarDrawableToggleImpl(this);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final int i() {
        return this.C0;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final MenuInflater j() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.p == null) {
            R();
            ActionBar actionBar = this.o;
            this.p = new SupportMenuInflater(actionBar != null ? actionBar.j() : this.f300k);
        }
        return this.p;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final ActionBar k() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        R();
        return this.o;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void l() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f300k);
        if (layoutInflaterFrom.getFactory() == null) {
            layoutInflaterFrom.setFactory2(this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof AppCompatDelegateImpl) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void m() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.o != null) {
            R();
            if (this.o.k()) {
                return;
            }
            S(0);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void o(Configuration configuration) throws IllegalAccessException, NoSuchFieldException, NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (this.G && this.A) {
            R();
            ActionBar actionBar = this.o;
            if (actionBar != null) {
                actionBar.l();
            }
        }
        AppCompatDrawableManager appCompatDrawableManagerA = AppCompatDrawableManager.a();
        Context context = this.f300k;
        synchronized (appCompatDrawableManagerA) {
            ResourceManagerInternal resourceManagerInternal = appCompatDrawableManagerA.f836a;
            synchronized (resourceManagerInternal) {
                LongSparseArray longSparseArray = (LongSparseArray) resourceManagerInternal.f1096b.get(context);
                if (longSparseArray != null) {
                    longSparseArray.a();
                }
            }
        }
        this.B0 = new Configuration(this.f300k.getResources().getConfiguration());
        F(false, false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r10, java.lang.String r11, android.content.Context r12, android.util.AttributeSet r13) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void p() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        String strC;
        this.Y = true;
        F(false, true);
        P();
        Object obj = this.f299j;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    strC = NavUtils.c(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                ActionBar actionBar = this.o;
                if (actionBar == null) {
                    this.L0 = true;
                } else {
                    actionBar.q(true);
                }
            }
            synchronized (AppCompatDelegate.f293h) {
                AppCompatDelegate.v(this);
                AppCompatDelegate.f292g.add(new WeakReference(this));
            }
        }
        this.B0 = new Configuration(this.f300k.getResources().getConfiguration());
        this.Z = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // androidx.appcompat.app.AppCompatDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void q() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f299j
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L11
            java.lang.Object r0 = androidx.appcompat.app.AppCompatDelegate.f293h
            monitor-enter(r0)
            androidx.appcompat.app.AppCompatDelegate.v(r3)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            goto L11
        Le:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Le
            throw r1
        L11:
            boolean r0 = r3.I0
            if (r0 == 0) goto L20
            android.view.Window r0 = r3.f301l
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.K0
            r0.removeCallbacks(r1)
        L20:
            r0 = 1
            r3.A0 = r0
            int r0 = r3.C0
            r1 = -100
            if (r0 == r1) goto L4d
            java.lang.Object r0 = r3.f299j
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L4d
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L4d
            androidx.collection.SimpleArrayMap r0 = androidx.appcompat.app.AppCompatDelegateImpl.R0
            java.lang.Object r1 = r3.f299j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.C0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L5c
        L4d:
            androidx.collection.SimpleArrayMap r0 = androidx.appcompat.app.AppCompatDelegateImpl.R0
            java.lang.Object r1 = r3.f299j
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L5c:
            androidx.appcompat.app.ActionBar r0 = r3.o
            if (r0 == 0) goto L63
            r0.m()
        L63:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoTimeNightModeManager r0 = r3.G0
            if (r0 == 0) goto L6a
            r0.a()
        L6a:
            androidx.appcompat.app.AppCompatDelegateImpl$AutoBatteryNightModeManager r0 = r3.H0
            if (r0 == 0) goto L71
            r0.a()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.q():void");
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void r() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void s() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        R();
        ActionBar actionBar = this.o;
        if (actionBar != null) {
            actionBar.t(true);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void t() throws IllegalAccessException, NoSuchFieldException, PackageManager.NameNotFoundException, SecurityException, IllegalArgumentException {
        F(true, false);
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void u() throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        R();
        ActionBar actionBar = this.o;
        if (actionBar != null) {
            actionBar.t(false);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final boolean w(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        if (this.K && i2 == 108) {
            return false;
        }
        if (this.G && i2 == 1) {
            this.G = false;
        }
        if (i2 == 1) {
            Y();
            this.K = true;
            return true;
        }
        if (i2 == 2) {
            Y();
            this.E = true;
            return true;
        }
        if (i2 == 5) {
            Y();
            this.F = true;
            return true;
        }
        if (i2 == 10) {
            Y();
            this.I = true;
            return true;
        }
        if (i2 == 108) {
            Y();
            this.G = true;
            return true;
        }
        if (i2 != 109) {
            return this.f301l.requestFeature(i2);
        }
        Y();
        this.H = true;
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void x(int i2) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f300k).inflate(i2, viewGroup);
        this.f302m.a(this.f301l.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void y(View view) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.f302m.a(this.f301l.getCallback());
    }

    @Override // androidx.appcompat.app.AppCompatDelegate
    public final void z(View view, ViewGroup.LayoutParams layoutParams) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        O();
        ViewGroup viewGroup = (ViewGroup) this.B.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.f302m.a(this.f301l.getCallback());
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
