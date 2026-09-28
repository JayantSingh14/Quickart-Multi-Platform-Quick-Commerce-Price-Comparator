package com.unistyles;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.ReactApplicationContext;
import com.google.firebase.crashlytics.internal.common.k;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class Platform {
    private int defaultNavigationBarColor;
    private int defaultStatusBarColor;
    private boolean hasAnimatedInsets;

    @NotNull
    private Insets insets;
    private int orientation;

    @NotNull
    private final ReactApplicationContext reactApplicationContext;

    public Platform(@NotNull ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        this.reactApplicationContext = reactApplicationContext;
        this.hasAnimatedInsets = true;
        this.insets = new Insets(0, 0, 0, 0);
        this.defaultNavigationBarColor = -1;
        this.defaultStatusBarColor = -1;
        this.orientation = reactApplicationContext.getResources().getConfiguration().orientation;
    }

    private final int getNavigationBarHeight() {
        return MathKt.b(this.insets.getBottom() / this.reactApplicationContext.getResources().getDisplayMetrics().density);
    }

    private final int getStatusBarHeight() {
        return MathKt.b(this.insets.getTop() / this.reactApplicationContext.getResources().getDisplayMetrics().density);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetNavigationBarColor$lambda$3$lambda$2(Activity activity, Platform platform, String str, float f2) {
        activity.getWindow().setNavigationBarColor(platform.parseColor(str, f2, platform.defaultNavigationBarColor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetNavigationBarHidden$lambda$7$lambda$6$lambda$5$lambda$4(boolean z, View view, WindowInsetsControllerCompat windowInsetsControllerCompat, Activity activity) {
        if (!z) {
            windowInsetsControllerCompat.g(2);
            return;
        }
        if (Build.VERSION.SDK_INT <= 29) {
            view.setSystemUiVisibility(4610);
        } else {
            windowInsetsControllerCompat.b(2);
            windowInsetsControllerCompat.f(2);
        }
        WindowInsetsCompat.Builder builder = new WindowInsetsCompat.Builder();
        builder.b(2, androidx.core.graphics.Insets.c(0, 0, 0, 0));
        WindowInsetsCompat windowInsetsCompatA = builder.a();
        Intrinsics.checkNotNullExpressionValue(windowInsetsCompatA, "build(...)");
        ViewCompat.c(activity.findViewById(android.R.id.content), windowInsetsCompatA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetRootViewBackgroundColor$lambda$16$lambda$15$lambda$14(View view, Platform platform, String str, float f2) {
        view.getRootView().setBackgroundColor(platform.parseColor(str, f2, -1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetStatusBarColor$lambda$13$lambda$12(Activity activity, Platform platform, String str, float f2) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().setStatusBarColor(platform.parseColor(str, f2, platform.defaultStatusBarColor));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onSetStatusBarHidden$lambda$11$lambda$10$lambda$9$lambda$8(boolean z, Window window, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        if (!z) {
            windowInsetsControllerCompat.g(1);
        } else if (Build.VERSION.SDK_INT > 29) {
            windowInsetsControllerCompat.b(1);
        } else {
            window.addFlags(1024);
            window.clearFlags(2048);
        }
    }

    private final int parseColor(String str, float f2, int i2) {
        if (Intrinsics.b(str, "")) {
            return i2;
        }
        if (Intrinsics.b(str, "transparent")) {
            return 0;
        }
        return f2 == 1.0f ? Color.parseColor(str) : ColorUtils.k(Color.parseColor(str), (int) (255 * f2));
    }

    public final void disableAnimatedInsets() {
        this.hasAnimatedInsets = false;
    }

    @NotNull
    public final String getColorScheme() {
        int i2 = this.reactApplicationContext.getResources().getConfiguration().uiMode & 48;
        return i2 != 16 ? i2 != 32 ? "unspecified" : "dark" : "light";
    }

    @NotNull
    public final String getContentSizeCategory() {
        float f2 = this.reactApplicationContext.getResources().getConfiguration().fontScale;
        return f2 <= 0.85f ? "Small" : f2 <= 1.0f ? "Default" : f2 <= 1.15f ? "Large" : f2 <= 1.3f ? "ExtraLarge" : f2 <= 1.5f ? "Huge" : ((double) f2) <= 1.8d ? "ExtraHuge" : "ExtraExtraHuge";
    }

    public final boolean getHasAnimatedInsets() {
        return this.hasAnimatedInsets;
    }

    @NotNull
    public final Insets getInsets() {
        float f2 = this.reactApplicationContext.getResources().getDisplayMetrics().density;
        return new Insets(MathKt.b(this.insets.getTop() / f2), MathKt.b(this.insets.getBottom() / f2), MathKt.b(this.insets.getLeft() / f2), MathKt.b(this.insets.getRight() / f2));
    }

    public final boolean getIsRTL() {
        return this.reactApplicationContext.getSharedPreferences("com.facebook.react.modules.i18nmanager.I18nUtil", 0).getBoolean("RCTI18nUtil_forceRTL", false) || (TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1);
    }

    @NotNull
    public final Dimensions getNavigationBarDimensions() {
        return new Dimensions(MathKt.b(r0.widthPixels / this.reactApplicationContext.getResources().getDisplayMetrics().density), getNavigationBarHeight());
    }

    public final int getOrientation() {
        return this.orientation;
    }

    @NotNull
    public final Screen getScreenDimensions() {
        WindowManager windowManager;
        WindowMetrics currentWindowMetrics;
        Rect bounds;
        DisplayMetrics displayMetrics = this.reactApplicationContext.getResources().getDisplayMetrics();
        float f2 = this.reactApplicationContext.getResources().getConfiguration().fontScale;
        if (Build.VERSION.SDK_INT >= 30) {
            Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
            return (currentActivity == null || (windowManager = currentActivity.getWindowManager()) == null || (currentWindowMetrics = windowManager.getCurrentWindowMetrics()) == null || (bounds = currentWindowMetrics.getBounds()) == null) ? new Screen(MathKt.b(displayMetrics.widthPixels / displayMetrics.density), MathKt.b(displayMetrics.heightPixels / displayMetrics.density), displayMetrics.density, f2) : new Screen(MathKt.b(bounds.width() / displayMetrics.density), MathKt.b(bounds.height() / displayMetrics.density), displayMetrics.density, f2);
        }
        Object systemService = this.reactApplicationContext.getSystemService("window");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics2);
        return new Screen(MathKt.b(displayMetrics2.widthPixels / displayMetrics2.density), MathKt.b(displayMetrics2.heightPixels / displayMetrics2.density), displayMetrics2.density, f2);
    }

    @NotNull
    public final Dimensions getStatusBarDimensions() {
        return new Dimensions(MathKt.b(r0.widthPixels / this.reactApplicationContext.getResources().getDisplayMetrics().density), getStatusBarHeight());
    }

    public final void onSetImmersiveMode(boolean z) {
        onSetStatusBarHidden(z);
        onSetNavigationBarHidden(z);
    }

    public final void onSetNavigationBarColor(@NotNull String color, float f2) {
        String str;
        Intrinsics.checkNotNullParameter(color, "color");
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (this.defaultNavigationBarColor == -1) {
            this.defaultNavigationBarColor = currentActivity.getWindow().getNavigationBarColor();
        }
        try {
            str = color;
            try {
                currentActivity.runOnUiThread(new b(currentActivity, this, str, f2, 0));
                Unit unit = Unit.f53572a;
            } catch (Exception unused) {
                android.support.v4.media.a.t("Failed to set navigation bar color: ", str, UnistylesModule.NAME);
            }
        } catch (Exception unused2) {
            str = color;
        }
    }

    public final void onSetNavigationBarHidden(boolean z) {
        View decorView;
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        if (currentActivity != null) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(currentActivity.getWindow(), currentActivity.getWindow().getDecorView());
            Window window = currentActivity.getWindow();
            if (window == null || (decorView = window.getDecorView()) == null) {
                return;
            }
            currentActivity.runOnUiThread(new k(z, decorView, windowInsetsControllerCompat, currentActivity));
        }
    }

    public final void onSetRootViewBackgroundColor(@NotNull String color, float f2) {
        Window window;
        View decorView;
        String str;
        Intrinsics.checkNotNullParameter(color, "color");
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        try {
            str = color;
            try {
                currentActivity.runOnUiThread(new b(decorView, this, str, f2, 2));
                Unit unit = Unit.f53572a;
            } catch (Exception unused) {
                android.support.v4.media.a.t("Failed to set root view background color: ", str, UnistylesModule.NAME);
            }
        } catch (Exception unused2) {
            str = color;
        }
    }

    public final void onSetStatusBarColor(@NotNull String color, float f2) {
        String str;
        Intrinsics.checkNotNullParameter(color, "color");
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        if (currentActivity == null) {
            return;
        }
        if (this.defaultStatusBarColor == -1) {
            this.defaultStatusBarColor = currentActivity.getWindow().getStatusBarColor();
        }
        try {
            str = color;
            try {
                currentActivity.runOnUiThread(new b(currentActivity, this, str, f2, 1));
                Unit unit = Unit.f53572a;
            } catch (Exception unused) {
                android.support.v4.media.a.t("Failed to set status bar color: ", str, UnistylesModule.NAME);
            }
        } catch (Exception unused2) {
            str = color;
        }
    }

    public final void onSetStatusBarHidden(boolean z) {
        Activity currentActivity = this.reactApplicationContext.getCurrentActivity();
        if (currentActivity != null) {
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(currentActivity.getWindow(), currentActivity.getWindow().getDecorView());
            Window window = currentActivity.getWindow();
            if (window != null) {
                currentActivity.runOnUiThread(new a(z, window, windowInsetsControllerCompat));
            }
        }
    }

    public final void setHasAnimatedInsets(boolean z) {
        this.hasAnimatedInsets = z;
    }

    public final void setInsetsCompat(@NotNull WindowInsetsCompat insetsCompat, @NotNull Window window, @Nullable Integer num) {
        int i2;
        Intrinsics.checkNotNullParameter(insetsCompat, "insetsCompat");
        Intrinsics.checkNotNullParameter(window, "window");
        int i3 = Build.VERSION.SDK_INT;
        int iIntValue = 0;
        boolean zO = 30 <= i3 ? insetsCompat.o(1) : (window.getAttributes().flags & 1024) != 1024;
        if (zO) {
            Rect rect = new Rect();
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            i2 = rect.top;
        } else {
            if (zO) {
                throw new NoWhenBranchMatchedException();
            }
            i2 = 0;
        }
        androidx.core.graphics.Insets insetsD = insetsCompat.d(647);
        Intrinsics.checkNotNullExpressionValue(insetsD, "getInsets(...)");
        int i4 = insetsCompat.d(8).f2811d;
        boolean z = this.hasAnimatedInsets;
        if (z || i4 == 0) {
            if (!z) {
                this.insets = new Insets(i2, insetsD.f2811d, insetsD.f2808a, insetsD.f2810c);
                return;
            }
            androidx.core.graphics.Insets insetsD2 = insetsCompat.d(8);
            Intrinsics.checkNotNullExpressionValue(insetsD2, "getInsets(...)");
            if (insetsD2.f2811d <= 0) {
                iIntValue = insetsD.f2811d;
            } else if (i3 >= 30 && num != null) {
                iIntValue = num.intValue();
            }
            this.insets = new Insets(i2, iIntValue, insetsD.f2808a, insetsD.f2810c);
        }
    }

    public final void setOrientation(int i2) {
        this.orientation = i2;
    }
}
