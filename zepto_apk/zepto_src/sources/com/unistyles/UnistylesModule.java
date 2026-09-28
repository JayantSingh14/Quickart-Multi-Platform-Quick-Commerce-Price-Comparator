package com.unistyles;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.media3.exoplayer.audio.i;
import com.appsflyer.internal.p;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class UnistylesModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    @NotNull
    public static final Companion Companion = new Companion(null);

    @NotNull
    public static final String NAME = "Unistyles";

    @NotNull
    private final UnistylesModule$configurationChangeReceiver$1 configurationChangeReceiver;
    private boolean isCxxReady;

    @NotNull
    private Platform platform;

    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnistylesModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.platform = new Platform(reactContext);
        UnistylesModule$configurationChangeReceiver$1 unistylesModule$configurationChangeReceiver$1 = new UnistylesModule$configurationChangeReceiver$1(this);
        this.configurationChangeReceiver = unistylesModule$configurationChangeReceiver$1;
        getReactApplicationContext().registerReceiver(unistylesModule$configurationChangeReceiver$1, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    public static final /* synthetic */ void access$onConfigChange(UnistylesModule unistylesModule) {
        unistylesModule.onConfigChange();
    }

    private final void enableEdgeToEdge() {
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.runOnUiThread(new com.amazon.android.amazonpay.api.b(currentActivity, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void enableEdgeToEdge$lambda$5$lambda$4(Activity activity) {
        WindowCompat.b(activity.getWindow(), false);
    }

    private final native void nativeDestroy();

    private final native void nativeInstall(long j2, CallInvokerHolder callInvokerHolder);

    private final native void nativeOnAppearanceChange(String str);

    private final native void nativeOnContentSizeCategoryChange(String str);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeOnOrientationChange(Screen screen, Insets insets, Dimensions dimensions, Dimensions dimensions2);

    /* JADX INFO: Access modifiers changed from: private */
    public final void onConfigChange() {
        getReactApplicationContext().runOnJSQueueThread(new p(this, this.platform.getColorScheme(), this.platform.getContentSizeCategory(), 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onConfigChange$lambda$0(UnistylesModule unistylesModule, String str, String str2) {
        unistylesModule.nativeOnAppearanceChange(str);
        unistylesModule.nativeOnContentSizeCategoryChange(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onHostResume$lambda$8$lambda$7$lambda$6(UnistylesModule unistylesModule, Activity activity, View view, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(view, "<unused var>");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Platform platform = unistylesModule.platform;
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
        platform.setInsetsCompat(insets, window, null);
        if (unistylesModule.isCxxReady) {
            unistylesModule.onLayoutConfigChange();
        }
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onLayoutConfigChange() {
        getReactApplicationContext().runOnJSQueueThread(new i(this, this.platform.getScreenDimensions(), this.platform.getInsets(), this.platform.getStatusBarDimensions(), this.platform.getNavigationBarDimensions(), 2));
    }

    @ReactMethod
    public final void addListener(@Nullable String str) {
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod(isBlockingSynchronousMethod = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED)
    public final boolean install() {
        CallInvokerHolder jSCallInvokerHolder;
        try {
            System.loadLibrary("unistyles");
            JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
            if (javaScriptContextHolder == null || (jSCallInvokerHolder = getReactApplicationContext().getCatalystInstance().getJSCallInvokerHolder()) == null) {
                return false;
            }
            nativeInstall(javaScriptContextHolder.get(), jSCallInvokerHolder);
            this.isCxxReady = true;
            Log.i(NAME, "Installed Unistyles 🦄!");
            return true;
        } catch (Exception unused) {
            this.isCxxReady = false;
            return false;
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getReactApplicationContext().unregisterReceiver(this.configurationChangeReceiver);
        getReactApplicationContext().removeLifecycleEventListener(this);
        if (this.isCxxReady) {
            nativeDestroy();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        Window window;
        View decorView;
        Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null || (window = currentActivity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        ViewCompat.H(decorView, null);
        ViewCompat.O(decorView, null);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        final View viewFindViewById;
        if (this.isCxxReady) {
            onConfigChange();
        }
        final Activity currentActivity = getReactApplicationContext().getCurrentActivity();
        if (currentActivity == null || (viewFindViewById = currentActivity.findViewById(android.R.id.content)) == null) {
            return;
        }
        ViewCompat.H(viewFindViewById, new OnApplyWindowInsetsListener() { // from class: com.unistyles.c
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat b(View view, WindowInsetsCompat windowInsetsCompat) {
                return UnistylesModule.onHostResume$lambda$8$lambda$7$lambda$6(this.f47299a, currentActivity, view, windowInsetsCompat);
            }
        });
        if (!this.platform.getHasAnimatedInsets() || Build.VERSION.SDK_INT < 30) {
            return;
        }
        ViewCompat.O(viewFindViewById, new WindowInsetsAnimationCompat.Callback() { // from class: com.unistyles.UnistylesModule$onHostResume$1$1$2
            private int initialBottomInsets;
            private boolean isGoingUp;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            public final int getInitialBottomInsets() {
                return this.initialBottomInsets;
            }

            public final boolean isGoingUp() {
                return this.isGoingUp;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public void onPrepare(WindowInsetsAnimationCompat animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                WindowInsetsCompat windowInsetsCompatM = ViewCompat.m(viewFindViewById);
                boolean zO = windowInsetsCompatM != null ? windowInsetsCompatM.o(8) : false;
                if (!zO) {
                    this.initialBottomInsets = MathKt.b(this.platform.getInsets().getBottom() * this.getReactApplicationContext().getResources().getDisplayMetrics().density);
                }
                this.isGoingUp = !zO;
            }

            @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
            public WindowInsetsCompat onProgress(WindowInsetsCompat insets, List<WindowInsetsAnimationCompat> runningAnimations) {
                int iB;
                Intrinsics.checkNotNullParameter(insets, "insets");
                Intrinsics.checkNotNullParameter(runningAnimations, "runningAnimations");
                WindowInsetsAnimationCompat windowInsetsAnimationCompat = (WindowInsetsAnimationCompat) CollectionsKt.firstOrNull(runningAnimations);
                if (windowInsetsAnimationCompat != null) {
                    UnistylesModule unistylesModule = this;
                    Activity activity = currentActivity;
                    float fB = windowInsetsAnimationCompat.b();
                    if (this.isGoingUp) {
                        int i2 = this.initialBottomInsets;
                        iB = i2 - MathKt.b(fB * i2);
                    } else {
                        iB = this.initialBottomInsets;
                    }
                    Platform platform = unistylesModule.platform;
                    Window window = activity.getWindow();
                    Intrinsics.checkNotNullExpressionValue(window, "getWindow(...)");
                    platform.setInsetsCompat(insets, window, Integer.valueOf(iB));
                    if (!this.isGoingUp) {
                        unistylesModule.onLayoutConfigChange();
                    }
                }
                return insets;
            }

            public final void setGoingUp(boolean z) {
                this.isGoingUp = z;
            }

            public final void setInitialBottomInsets(int i2) {
                this.initialBottomInsets = i2;
            }
        });
    }

    @ReactMethod
    public final void removeListeners(double d2) {
    }
}
