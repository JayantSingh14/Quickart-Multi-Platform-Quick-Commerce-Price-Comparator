package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenStackManagerInterface;
import com.swmansion.rnscreens.NativeProxy;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@ReactModule(name = ScreenStackViewManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ScreenStackViewManager extends ViewGroupManager<ScreenStack> implements RNSScreenStackManagerInterface<ScreenStack> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNSScreenStack";

    @NotNull
    private final ViewManagerDelegate<ScreenStack> delegate = new RNSScreenStackManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    private final void prepareOutTransition(Screen screen) {
        if (screen == null || screen.f46946k) {
            return;
        }
        screen.f46946k = true;
        screen.d(screen);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ScreenStack> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.i(new Pair("topFinishTransitioning", MapsKt.i(new Pair("registrationName", "onFinishTransitioning"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public LayoutShadowNode createShadowNodeInstance(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreensShadowNode(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ScreenStack createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenStack(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull ScreenStack parent, @NotNull View child, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof Screen) {
            Screen screen = (Screen) child;
            screen.getId();
            NativeProxy.Companion.a(screen);
            parent.getClass();
            Intrinsics.checkNotNullParameter(screen, "screen");
            ScreenFragmentWrapper screenFragmentWrapperA = parent.a(screen);
            screen.setFragmentWrapper(screenFragmentWrapperA);
            parent.f46990a.add(i2, screenFragmentWrapperA);
            screen.setContainer(parent);
            parent.e();
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type Screen");
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    @NotNull
    public View getChildAt(@NotNull ScreenStack parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return ((ScreenFragmentWrapper) parent.f46990a.get(i2)).k();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull ScreenStack parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getScreenCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull ScreenStack parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Screen screenK = ((ScreenFragmentWrapper) parent.f46990a.get(i2)).k();
        prepareOutTransition(screenK);
        parent.i(i2);
        screenK.getId();
    }
}
