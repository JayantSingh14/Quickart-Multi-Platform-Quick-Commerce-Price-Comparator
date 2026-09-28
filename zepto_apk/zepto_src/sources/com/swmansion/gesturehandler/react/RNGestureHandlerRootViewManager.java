package com.swmansion.gesturehandler.react;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerRootViewManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerRootViewManagerInterface;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = RNGestureHandlerRootViewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class RNGestureHandlerRootViewManager extends ViewGroupManager<RNGestureHandlerRootView> implements RNGestureHandlerRootViewManagerInterface<RNGestureHandlerRootView> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNGestureHandlerRootView";

    @NotNull
    private final ViewManagerDelegate<RNGestureHandlerRootView> mDelegate = new RNGestureHandlerRootViewManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<RNGestureHandlerRootView> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Map<String, String>> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.i(new Pair("onGestureHandlerEvent", MapsKt.i(new Pair("registrationName", "onGestureHandlerEvent"))), new Pair("onGestureHandlerStateChange", MapsKt.i(new Pair("registrationName", "onGestureHandlerStateChange"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public RNGestureHandlerRootView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new RNGestureHandlerRootView(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void onDropViewInstance(@NotNull RNGestureHandlerRootView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        RNGestureHandlerRootHelper rNGestureHandlerRootHelper = view.f46852b;
        if (rNGestureHandlerRootHelper != null) {
            rNGestureHandlerRootHelper.b();
        }
    }
}
