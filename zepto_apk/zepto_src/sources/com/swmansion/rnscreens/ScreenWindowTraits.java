package com.swmansion.rnscreens;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.media3.exoplayer.audio.h;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.rnscreens.Screen;
import com.swmansion.rnscreens.utils.EdgeToEdgePackageDetector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ScreenWindowTraits {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f47045a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f47046b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f47047c;

    /* renamed from: d, reason: collision with root package name */
    public static Integer f47048d;

    /* renamed from: e, reason: collision with root package name */
    public static final ScreenWindowTraits$windowInsetsListener$1 f47049e = new ScreenWindowTraits$windowInsetsListener$1();

    @Metadata
    /* loaded from: classes4.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[Screen.WindowTraits.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Screen.WindowTraits windowTraits = Screen.WindowTraits.f46975a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                Screen.WindowTraits windowTraits2 = Screen.WindowTraits.f46975a;
                iArr[2] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                Screen.WindowTraits windowTraits3 = Screen.WindowTraits.f46975a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                Screen.WindowTraits windowTraits4 = Screen.WindowTraits.f46975a;
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                Screen.WindowTraits windowTraits5 = Screen.WindowTraits.f46975a;
                iArr[5] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                Screen.WindowTraits windowTraits6 = Screen.WindowTraits.f46975a;
                iArr[6] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                Screen.WindowTraits windowTraits7 = Screen.WindowTraits.f46975a;
                iArr[7] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                Screen.WindowTraits windowTraits8 = Screen.WindowTraits.f46975a;
                iArr[8] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public static boolean a(Screen screen, Screen.WindowTraits windowTraits) {
        switch (windowTraits.ordinal()) {
            case 0:
                return screen.getScreenOrientation() != null;
            case 1:
                return screen.getStatusBarColor() != null;
            case 2:
                return screen.getStatusBarStyle() != null;
            case 3:
                return screen.x != null;
            case 4:
                return screen.w != null;
            case 5:
                return screen.f46945j != null;
            case 6:
                return screen.getNavigationBarColor() != null;
            case 7:
                return screen.A != null;
            case 8:
                return screen.B != null;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static Screen b(Screen screen, Screen.WindowTraits windowTraits) {
        ScreenFragmentWrapper fragmentWrapper;
        if (screen == null || (fragmentWrapper = screen.getFragmentWrapper()) == null) {
            return null;
        }
        Iterator it = fragmentWrapper.n().iterator();
        while (it.hasNext()) {
            Screen topScreen = ((ScreenContainer) it.next()).getTopScreen();
            Screen screenB = b(topScreen, windowTraits);
            if (screenB != null) {
                return screenB;
            }
            if (topScreen != null && a(topScreen, windowTraits)) {
                return topScreen;
            }
        }
        return null;
    }

    public static Screen c(Screen screen, Screen.WindowTraits windowTraits) {
        Screen screenB = b(screen, windowTraits);
        if (screenB != null) {
            return screenB;
        }
        if (a(screen, windowTraits)) {
            return screen;
        }
        for (ViewParent container = screen.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen2 = (Screen) container;
                if (a(screen2, windowTraits)) {
                    return screen2;
                }
            }
        }
        return null;
    }

    public static void d(Screen screen, final Activity activity, ReactContext reactContext) {
        final Integer statusBarColor;
        Boolean bool;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || reactContext == null) {
            return;
        }
        if (f47048d == null) {
            f47048d = Integer.valueOf(activity.getWindow().getStatusBarColor());
        }
        Screen screenC = c(screen, Screen.WindowTraits.f46976b);
        Screen screenC2 = c(screen, Screen.WindowTraits.f46980f);
        if (screenC == null || (statusBarColor = screenC.getStatusBarColor()) == null) {
            statusBarColor = f47048d;
        }
        final boolean zBooleanValue = (screenC2 == null || (bool = screenC2.f46945j) == null) ? false : bool.booleanValue();
        final JSExceptionHandler exceptionHandler = reactContext.getExceptionHandler();
        UiThreadUtil.runOnUiThread(new GuardedRunnable(exceptionHandler) { // from class: com.swmansion.rnscreens.ScreenWindowTraits$setColor$1
            @Override // com.facebook.react.bridge.GuardedRunnable
            public final void runGuarded() {
                Window window = activity.getWindow();
                ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(window.getStatusBarColor()), statusBarColor);
                valueAnimatorOfObject.addUpdateListener(new com.google.android.material.motion.b(window, 2));
                if (zBooleanValue) {
                    valueAnimatorOfObject.setDuration(300L).setStartDelay(0L);
                } else {
                    valueAnimatorOfObject.setDuration(0L).setStartDelay(300L);
                }
                valueAnimatorOfObject.start();
            }
        });
    }

    public static void e(Screen screen, Activity activity) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Screen screenC = c(screen, Screen.WindowTraits.f46979e);
        boolean zBooleanValue = (screenC == null || (bool = screenC.w) == null) ? false : bool.booleanValue();
        Window window = activity.getWindow();
        UiThreadUtil.runOnUiThread(new h(zBooleanValue, new WindowInsetsControllerCompat(window, window.getDecorView()), 3));
    }

    public static void f(Screen screen, Activity activity) {
        Integer navigationBarColor;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenC = c(screen, Screen.WindowTraits.f46981g);
        int navigationBarColor2 = (screenC == null || (navigationBarColor = screenC.getNavigationBarColor()) == null) ? window.getNavigationBarColor() : navigationBarColor.intValue();
        UiThreadUtil.runOnUiThread(new com.facebook.react.uimanager.b(navigationBarColor2, 3, window));
        window.setNavigationBarColor(navigationBarColor2);
    }

    public static void g(Screen screen, Activity activity) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenC = c(screen, Screen.WindowTraits.f46983i);
        if (!((screenC == null || (bool = screenC.B) == null) ? false : bool.booleanValue())) {
            new WindowInsetsControllerCompat(window, window.getDecorView()).g(2);
            return;
        }
        WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
        windowInsetsControllerCompat.b(2);
        windowInsetsControllerCompat.f(2);
    }

    public static void h(Screen screen, Activity activity) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || EdgeToEdgePackageDetector.a()) {
            return;
        }
        Window window = activity.getWindow();
        Screen screenC = c(screen, Screen.WindowTraits.f46982h);
        if (screenC == null || (bool = screenC.A) == null) {
            return;
        }
        WindowCompat.b(window, !bool.booleanValue());
    }

    public static void i(Screen screen, Activity activity, ReactContext reactContext) {
        String statusBarStyle;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || reactContext == null) {
            return;
        }
        Screen screenC = c(screen, Screen.WindowTraits.f46977c);
        if (screenC == null || (statusBarStyle = screenC.getStatusBarStyle()) == null) {
            statusBarStyle = "light";
        }
        UiThreadUtil.runOnUiThread(new androidx.constraintlayout.motion.widget.a(28, activity, statusBarStyle));
    }

    public static void j(Screen screen, final Activity activity, ReactContext reactContext) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity == null || reactContext == null || EdgeToEdgePackageDetector.a()) {
            return;
        }
        Screen screenC = c(screen, Screen.WindowTraits.f46978d);
        final boolean zBooleanValue = (screenC == null || (bool = screenC.x) == null) ? false : bool.booleanValue();
        final JSExceptionHandler exceptionHandler = reactContext.getExceptionHandler();
        UiThreadUtil.runOnUiThread(new GuardedRunnable(exceptionHandler) { // from class: com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1
            @Override // com.facebook.react.bridge.GuardedRunnable
            public final void runGuarded() {
                View decorView = activity.getWindow().getDecorView();
                Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
                ScreenWindowTraits$windowInsetsListener$1 listener = ScreenWindowTraits.f47049e;
                if (zBooleanValue) {
                    InsetsObserverProxy.f46927a.a(decorView);
                    Intrinsics.checkNotNullParameter(listener, "listener");
                    InsetsObserverProxy.f46928b.add(listener);
                } else {
                    InsetsObserverProxy insetsObserverProxy = InsetsObserverProxy.f46927a;
                    Intrinsics.checkNotNullParameter(listener, "listener");
                    InsetsObserverProxy.f46928b.remove(listener);
                }
                ViewCompat.x(decorView);
            }
        });
    }

    public static void k(Screen screen, Activity activity, ReactContext reactContext) {
        Integer screenOrientation;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (f47045a) {
            Intrinsics.checkNotNullParameter(screen, "screen");
            if (activity != null) {
                Screen screenC = c(screen, Screen.WindowTraits.f46975a);
                activity.setRequestedOrientation((screenC == null || (screenOrientation = screenC.getScreenOrientation()) == null) ? -1 : screenOrientation.intValue());
            }
        }
        if (f47046b) {
            d(screen, activity, reactContext);
            i(screen, activity, reactContext);
            j(screen, activity, reactContext);
            e(screen, activity);
        }
        if (f47047c) {
            f(screen, activity);
            h(screen, activity);
            g(screen, activity);
        }
    }
}
