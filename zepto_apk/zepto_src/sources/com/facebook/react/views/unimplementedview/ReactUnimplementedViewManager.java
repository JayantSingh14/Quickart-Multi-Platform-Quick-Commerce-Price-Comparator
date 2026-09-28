package com.facebook.react.views.unimplementedview;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerDelegate;
import com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@ReactModule(name = ReactUnimplementedViewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ReactUnimplementedViewManager extends ViewGroupManager<ReactUnimplementedView> implements UnimplementedNativeViewManagerInterface<ReactUnimplementedView> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "UnimplementedNativeView";

    @NotNull
    private final ViewManagerDelegate<ReactUnimplementedView> delegate = new UnimplementedNativeViewManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ReactUnimplementedView> getDelegate() {
        return this.delegate;
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
    public ReactUnimplementedView createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new ReactUnimplementedView(reactContext);
    }

    @Override // com.facebook.react.viewmanagers.UnimplementedNativeViewManagerInterface
    @ReactProp(name = CLConstants.FIELD_PAY_INFO_NAME)
    public void setName(@NotNull ReactUnimplementedView view, @Nullable String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (str == null) {
            str = "<null component name>";
        }
        view.setName$ReactAndroid_release(str);
    }
}
