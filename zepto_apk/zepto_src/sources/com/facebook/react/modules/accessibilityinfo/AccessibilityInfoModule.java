package com.facebook.react.modules.accessibilityinfo;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.facebook.fbreact.specs.NativeAccessibilityInfoSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "AccessibilityInfo")
@Metadata
/* loaded from: classes.dex */
public final class AccessibilityInfoModule extends NativeAccessibilityInfoSpec implements LifecycleEventListener {

    @NotNull
    private static final String ACCESSIBILITY_HIGH_TEXT_CONTRAST_ENABLED_CONSTANT = "high_text_contrast_enabled";

    @NotNull
    private static final String ACCESSIBILITY_SERVICE_EVENT_NAME = "accessibilityServiceDidChange";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String GRAYSCALE_MODE_EVENT_NAME = "grayscaleModeDidChange";

    @NotNull
    private static final String HIGH_TEXT_CONTRAST_EVENT_NAME = "highTextContrastDidChange";

    @NotNull
    private static final String INVERT_COLOR_EVENT_NAME = "invertColorDidChange";

    @NotNull
    public static final String NAME = "AccessibilityInfo";

    @NotNull
    private static final String REDUCE_MOTION_EVENT_NAME = "reduceMotionDidChange";

    @NotNull
    private static final String TOUCH_EXPLORATION_EVENT_NAME = "touchExplorationDidChange";

    @Nullable
    private final AccessibilityManager accessibilityManager;

    @NotNull
    private final ReactAccessibilityServiceChangeListener accessibilityServiceChangeListener;
    private boolean accessibilityServiceEnabled;

    @NotNull
    private final ContentObserver animationScaleObserver;

    @NotNull
    private final ContentResolver contentResolver;
    private boolean grayscaleModeEnabled;
    private boolean highTextContrastEnabled;

    @NotNull
    private final ContentObserver highTextContrastObserver;
    private boolean invertColorsEnabled;
    private int recommendedTimeout;
    private boolean reduceMotionEnabled;
    private boolean touchExplorationEnabled;

    @NotNull
    private final ReactTouchExplorationStateChangeListener touchExplorationStateChangeListener;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @TargetApi(21)
    public final class ReactAccessibilityServiceChangeListener implements AccessibilityManager.AccessibilityStateChangeListener {
        public ReactAccessibilityServiceChangeListener() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean z) {
            AccessibilityInfoModule.this.updateAndSendAccessibilityServiceChangeEvent(z);
        }
    }

    @Metadata
    @TargetApi(21)
    public final class ReactTouchExplorationStateChangeListener implements AccessibilityManager.TouchExplorationStateChangeListener {
        public ReactTouchExplorationStateChangeListener() {
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public final void onTouchExplorationStateChanged(boolean z) {
            AccessibilityInfoModule.this.updateAndSendTouchExplorationChangeEvent(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccessibilityInfoModule(@NotNull ReactApplicationContext context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        final Handler uiThreadHandler = UiThreadUtil.getUiThreadHandler();
        this.animationScaleObserver = new ContentObserver(uiThreadHandler) { // from class: com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule$animationScaleObserver$1
            @Override // android.database.ContentObserver
            public final void onChange(boolean z) {
                onChange(z, null);
            }

            @Override // android.database.ContentObserver
            public final void onChange(boolean z, Uri uri) {
                AccessibilityInfoModule accessibilityInfoModule = this.f19028a;
                if (accessibilityInfoModule.getReactApplicationContext().hasActiveReactInstance()) {
                    accessibilityInfoModule.updateAndSendReduceMotionChangeEvent();
                }
            }
        };
        final Handler uiThreadHandler2 = UiThreadUtil.getUiThreadHandler();
        this.highTextContrastObserver = new ContentObserver(uiThreadHandler2) { // from class: com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule$highTextContrastObserver$1
            @Override // android.database.ContentObserver
            public final void onChange(boolean z) {
                onChange(z, null);
            }

            @Override // android.database.ContentObserver
            public final void onChange(boolean z, Uri uri) {
                AccessibilityInfoModule accessibilityInfoModule = this.f19029a;
                if (accessibilityInfoModule.getReactApplicationContext().hasActiveReactInstance()) {
                    accessibilityInfoModule.updateAndSendHighTextContrastChangeEvent();
                }
            }
        };
        this.touchExplorationStateChangeListener = new ReactTouchExplorationStateChangeListener();
        this.accessibilityServiceChangeListener = new ReactAccessibilityServiceChangeListener();
        Object systemService = context.getApplicationContext().getSystemService("accessibility");
        Intrinsics.d(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        AccessibilityManager accessibilityManager = (AccessibilityManager) systemService;
        this.accessibilityManager = accessibilityManager;
        this.contentResolver = getReactApplicationContext().getContentResolver();
        this.touchExplorationEnabled = accessibilityManager.isTouchExplorationEnabled();
        this.accessibilityServiceEnabled = accessibilityManager.isEnabled();
        this.reduceMotionEnabled = isReduceMotionEnabledValue();
        this.highTextContrastEnabled = isHighTextContrastEnabledValue();
        this.grayscaleModeEnabled = isGrayscaleEnabledValue();
    }

    @TargetApi(21)
    private final boolean isGrayscaleEnabledValue() {
        try {
            if (Settings.Secure.getInt(this.contentResolver, "accessibility_display_daltonizer_enabled") == 1) {
                if (Settings.Secure.getInt(this.contentResolver, "accessibility_display_daltonizer") == 0) {
                    return true;
                }
            }
        } catch (Settings.SettingNotFoundException unused) {
        }
        return false;
    }

    @TargetApi(21)
    private final boolean isHighTextContrastEnabledValue() {
        return Settings.Secure.getInt(this.contentResolver, ACCESSIBILITY_HIGH_TEXT_CONTRAST_ENABLED_CONSTANT, 0) != 0;
    }

    @TargetApi(21)
    private final boolean isInvertColorsEnabledValue() {
        return Settings.Secure.getInt(this.contentResolver, "accessibility_display_inversion_enabled") == 1;
    }

    @TargetApi(21)
    private final boolean isReduceMotionEnabledValue() {
        String string = Settings.Global.getString(this.contentResolver, "transition_animation_scale");
        return (string != null ? Float.parseFloat(string) : 1.0f) == 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAndSendAccessibilityServiceChangeEvent(boolean z) {
        if (this.accessibilityServiceEnabled != z) {
            this.accessibilityServiceEnabled = z;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                getReactApplicationContext().emitDeviceEvent(ACCESSIBILITY_SERVICE_EVENT_NAME, Boolean.valueOf(this.accessibilityServiceEnabled));
            }
        }
    }

    private final void updateAndSendGrayscaleModeChangeEvent() {
        boolean zIsGrayscaleEnabledValue = isGrayscaleEnabledValue();
        if (this.grayscaleModeEnabled != zIsGrayscaleEnabledValue) {
            this.grayscaleModeEnabled = zIsGrayscaleEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                reactApplicationContextIfActiveOrWarn.emitDeviceEvent(GRAYSCALE_MODE_EVENT_NAME, Boolean.valueOf(this.grayscaleModeEnabled));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAndSendHighTextContrastChangeEvent() {
        boolean zIsHighTextContrastEnabledValue = isHighTextContrastEnabledValue();
        if (this.highTextContrastEnabled != zIsHighTextContrastEnabledValue) {
            this.highTextContrastEnabled = zIsHighTextContrastEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                reactApplicationContextIfActiveOrWarn.emitDeviceEvent(HIGH_TEXT_CONTRAST_EVENT_NAME, Boolean.valueOf(this.highTextContrastEnabled));
            }
        }
    }

    private final void updateAndSendInvertColorsChangeEvent() {
        boolean zIsInvertColorsEnabledValue = isInvertColorsEnabledValue();
        if (this.invertColorsEnabled != zIsInvertColorsEnabledValue) {
            this.invertColorsEnabled = zIsInvertColorsEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                reactApplicationContextIfActiveOrWarn.emitDeviceEvent(INVERT_COLOR_EVENT_NAME, Boolean.valueOf(this.invertColorsEnabled));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAndSendReduceMotionChangeEvent() {
        boolean zIsReduceMotionEnabledValue = isReduceMotionEnabledValue();
        if (this.reduceMotionEnabled != zIsReduceMotionEnabledValue) {
            this.reduceMotionEnabled = zIsReduceMotionEnabledValue;
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                reactApplicationContextIfActiveOrWarn.emitDeviceEvent(REDUCE_MOTION_EVENT_NAME, Boolean.valueOf(this.reduceMotionEnabled));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAndSendTouchExplorationChangeEvent(boolean z) {
        if (this.touchExplorationEnabled != z) {
            this.touchExplorationEnabled = z;
            if (getReactApplicationContextIfActiveOrWarn() != null) {
                getReactApplicationContext().emitDeviceEvent(TOUCH_EXPLORATION_EVENT_NAME, Boolean.valueOf(this.touchExplorationEnabled));
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void announceForAccessibility(@Nullable String str) {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(16384);
        accessibilityEventObtain.getText().add(str);
        accessibilityEventObtain.setClassName("com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule");
        accessibilityEventObtain.setPackageName(getReactApplicationContext().getPackageName());
        this.accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain);
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void getRecommendedTimeoutMillis(double d2, @NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        if (Build.VERSION.SDK_INT < 29) {
            successCallback.invoke(Integer.valueOf((int) d2));
            return;
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        int recommendedTimeoutMillis = accessibilityManager != null ? accessibilityManager.getRecommendedTimeoutMillis((int) d2, 4) : 0;
        this.recommendedTimeout = recommendedTimeoutMillis;
        successCallback.invoke(Integer.valueOf(recommendedTimeoutMillis));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        boolean z = false;
        updateAndSendTouchExplorationChangeEvent(accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled());
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null && accessibilityManager2.isEnabled()) {
            z = true;
        }
        updateAndSendAccessibilityServiceChangeEvent(z);
        updateAndSendReduceMotionChangeEvent();
        updateAndSendHighTextContrastChangeEvent();
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        getReactApplicationContext().removeLifecycleEventListener(this);
        super.invalidate();
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isAccessibilityServiceEnabled(@NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        successCallback.invoke(Boolean.valueOf(this.accessibilityServiceEnabled));
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isGrayscaleEnabled(@NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        successCallback.invoke(Boolean.valueOf(this.grayscaleModeEnabled));
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isHighTextContrastEnabled(@NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        successCallback.invoke(Boolean.valueOf(this.highTextContrastEnabled));
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isInvertColorsEnabled(@NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        successCallback.invoke(Boolean.valueOf(this.invertColorsEnabled));
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isReduceMotionEnabled(@NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        successCallback.invoke(Boolean.valueOf(this.reduceMotionEnabled));
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void isTouchExplorationEnabled(@NotNull Callback successCallback) {
        Intrinsics.checkNotNullParameter(successCallback, "successCallback");
        successCallback.invoke(Boolean.valueOf(this.touchExplorationEnabled));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    @TargetApi(21)
    public void onHostPause() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            accessibilityManager2.removeAccessibilityStateChangeListener(this.accessibilityServiceChangeListener);
        }
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.contentResolver.unregisterContentObserver(this.highTextContrastObserver);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    @TargetApi(21)
    public void onHostResume() {
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager != null) {
            accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        }
        AccessibilityManager accessibilityManager2 = this.accessibilityManager;
        if (accessibilityManager2 != null) {
            accessibilityManager2.addAccessibilityStateChangeListener(this.accessibilityServiceChangeListener);
        }
        boolean z = false;
        this.contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, this.animationScaleObserver);
        this.contentResolver.registerContentObserver(Settings.Global.getUriFor(ACCESSIBILITY_HIGH_TEXT_CONTRAST_ENABLED_CONSTANT), false, this.highTextContrastObserver);
        AccessibilityManager accessibilityManager3 = this.accessibilityManager;
        updateAndSendTouchExplorationChangeEvent(accessibilityManager3 != null && accessibilityManager3.isTouchExplorationEnabled());
        AccessibilityManager accessibilityManager4 = this.accessibilityManager;
        if (accessibilityManager4 != null && accessibilityManager4.isEnabled()) {
            z = true;
        }
        updateAndSendAccessibilityServiceChangeEvent(z);
        updateAndSendReduceMotionChangeEvent();
        updateAndSendHighTextContrastChangeEvent();
        updateAndSendInvertColorsChangeEvent();
        updateAndSendGrayscaleModeChangeEvent();
    }

    @Override // com.facebook.fbreact.specs.NativeAccessibilityInfoSpec
    public void setAccessibilityFocus(double d2) {
    }
}
