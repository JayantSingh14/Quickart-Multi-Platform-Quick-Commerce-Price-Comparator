package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenContainerManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenContainerManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata
@ReactModule(name = ScreenContainerViewManager.REACT_CLASS)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> implements RNSScreenContainerManagerInterface<ScreenContainer> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNSScreenContainer";

    @NotNull
    private final ViewManagerDelegate<ScreenContainer> delegate = new RNSScreenContainerManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ScreenContainer> getDelegate() {
        return this.delegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewManagerWithChildren
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public LayoutShadowNode createShadowNodeInstance(@NotNull ReactApplicationContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreensShadowNode(context);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ScreenContainer createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ScreenContainer(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public void removeAllViews(@NotNull ScreenContainer parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.h();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(@NotNull ScreenContainer parent, @NotNull View child, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof Screen) {
            Screen screen = (Screen) child;
            parent.getClass();
            Intrinsics.checkNotNullParameter(screen, "screen");
            ScreenFragmentWrapper screenFragmentWrapperA = parent.a(screen);
            screen.setFragmentWrapper(screenFragmentWrapperA);
            parent.f46990a.add(i2, screenFragmentWrapperA);
            screen.setContainer(parent);
            parent.e();
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens");
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    @NotNull
    public View getChildAt(@NotNull ScreenContainer parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return ((ScreenFragmentWrapper) parent.f46990a.get(i2)).k();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public int getChildCount(@NotNull ScreenContainer parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return parent.getScreenCount();
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void removeViewAt(@NotNull ScreenContainer parent, int i2) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        parent.i(i2);
    }
}
