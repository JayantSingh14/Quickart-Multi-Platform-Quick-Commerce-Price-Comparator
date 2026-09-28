package com.facebook.react.modules.statusbar;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.common.util.c;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.views.view.WindowUtilKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xbill.DNS.KEYRecord;
import org.xbill.DNS.WKSRecord;

@ReactModule(name = "StatusBarManager")
@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class StatusBarModule extends NativeStatusBarManagerAndroidSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String DEFAULT_BACKGROUND_COLOR_KEY = "DEFAULT_BACKGROUND_COLOR";

    @NotNull
    private static final String HEIGHT_KEY = "HEIGHT";

    @NotNull
    public static final String NAME = "StatusBarManager";

    @Metadata
    public static final class Companion {
    }

    public StatusBarModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private final float getStatusBarHeightPx() {
        Window window;
        View decorView;
        WindowInsetsCompat windowInsetsCompatM;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null || (windowInsetsCompatM = ViewCompat.m(decorView)) == null) {
            return 0.0f;
        }
        return windowInsetsCompatM.d(WKSRecord.Service.CISCO_TNA).f2809b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHidden$lambda$1(Activity activity, boolean z) {
        Window window = activity.getWindow();
        if (window != null) {
            Intrinsics.checkNotNullParameter(window, "<this>");
            if (z) {
                if (Build.VERSION.SDK_INT >= 30) {
                    window.getAttributes().layoutInDisplayCutoutMode = 1;
                    window.setDecorFitsSystemWindows(false);
                }
                window.addFlags(1024);
                window.clearFlags(2048);
                return;
            }
            if (Build.VERSION.SDK_INT >= 30) {
                window.getAttributes().layoutInDisplayCutoutMode = 0;
                window.setDecorFitsSystemWindows(true);
            }
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setStyle$lambda$2(Activity activity, String str) {
        Window window = activity.getWindow();
        if (window == null) {
            return;
        }
        if (Build.VERSION.SDK_INT <= 30) {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility("dark-content".equals(str) ? systemUiVisibility | KEYRecord.Flags.FLAG2 : systemUiVisibility & (-8193));
            return;
        }
        WindowInsetsController insetsController = window.getInsetsController();
        if (insetsController == null) {
            return;
        }
        if ("dark-content".equals(str)) {
            insetsController.setSystemBarsAppearance(8, 8);
        } else {
            insetsController.setSystemBarsAppearance(0, 8);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    @NotNull
    public Map<String, Object> getTypedExportedConstants() {
        String str;
        Window window;
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null) {
            str = "black";
        } else {
            str = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(window.getStatusBarColor() & 16777215)}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        }
        return MapsKt.h(new Pair(HEIGHT_KEY, Float.valueOf(PixelUtil.a(getStatusBarHeightPx()))), new Pair(DEFAULT_BACKGROUND_COLOR_KEY, str));
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setColor(double d2, final boolean z) {
        final int i2 = (int) d2;
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.q("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) { // from class: com.facebook.react.modules.statusbar.StatusBarModule.setColor.1
                @Override // com.facebook.react.bridge.GuardedRunnable
                public final void runGuarded() {
                    final Activity activity = currentActivity;
                    Window window = activity.getWindow();
                    if (window == null) {
                        return;
                    }
                    window.addFlags(Integer.MIN_VALUE);
                    boolean z2 = z;
                    int i3 = i2;
                    if (!z2) {
                        window.setStatusBarColor(i3);
                        return;
                    }
                    ValueAnimator valueAnimatorOfObject = ValueAnimator.ofObject(new ArgbEvaluator(), Integer.valueOf(window.getStatusBarColor()), Integer.valueOf(i3));
                    valueAnimatorOfObject.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.facebook.react.modules.statusbar.b
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public final void onAnimationUpdate(ValueAnimator animator) {
                            Intrinsics.checkNotNullParameter(animator, "animator");
                            Window window2 = activity.getWindow();
                            if (window2 != null) {
                                Object animatedValue = animator.getAnimatedValue();
                                Intrinsics.d(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                                window2.setStatusBarColor(((Integer) animatedValue).intValue());
                            }
                        }
                    });
                    valueAnimatorOfObject.setDuration(300L).setStartDelay(0L);
                    valueAnimatorOfObject.start();
                }
            });
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setHidden(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.q("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.modules.statusbar.a
                @Override // java.lang.Runnable
                public final void run() {
                    StatusBarModule.setHidden$lambda$1(currentActivity, z);
                }
            });
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setStyle(@Nullable String str) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.q("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new c(2, currentActivity, str));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeStatusBarManagerAndroidSpec
    public void setTranslucent(final boolean z) {
        final Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            FLog.q("ReactNative", "StatusBarModule: Ignored status bar change, current activity is null.");
        } else {
            UiThreadUtil.runOnUiThread(new GuardedRunnable(getReactApplicationContext()) { // from class: com.facebook.react.modules.statusbar.StatusBarModule.setTranslucent.1
                @Override // com.facebook.react.bridge.GuardedRunnable
                public final void runGuarded() {
                    Window window = currentActivity.getWindow();
                    if (window != null) {
                        WindowUtilKt.a(window, z);
                    }
                }
            });
        }
    }
}
