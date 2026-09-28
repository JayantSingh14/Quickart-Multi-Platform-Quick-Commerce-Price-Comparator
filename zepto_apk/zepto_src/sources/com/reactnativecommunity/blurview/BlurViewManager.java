package com.reactnativecommunity.blurview;

import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import eightbitlab.com.blurview.BlurView;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
class BlurViewManager extends ViewGroupManager<BlurView> {
    ReactApplicationContext mCallerContext;

    public BlurViewManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "AndroidBlurView";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "autoUpdate")
    public void setAutoUpdate(BlurView blurView, boolean z) {
        BlurViewManagerImpl.b(blurView, z);
    }

    @ReactProp(defaultBoolean = com.zeptoconsumerapp.BuildConfig.IS_HERMES_ENABLED, name = "enabled")
    public void setBlurEnabled(BlurView blurView, boolean z) {
        BlurViewManagerImpl.c(blurView, z);
    }

    @ReactProp(customType = "Color", name = "overlayColor")
    public void setColor(BlurView blurView, int i2) {
        BlurViewManagerImpl.d(blurView, i2);
    }

    @ReactProp(defaultInt = 10, name = "downsampleFactor")
    public void setDownsampleFactor(BlurView blurView, int i2) {
    }

    @ReactProp(defaultInt = 10, name = "blurRadius")
    public void setRadius(BlurView blurView, int i2) {
        BlurViewManagerImpl.e(blurView, i2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public BlurView createViewInstance(ThemedReactContext themedReactContext) {
        return BlurViewManagerImpl.a(themedReactContext);
    }
}
