package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenFooterManagerDelegate;
import com.facebook.react.viewmanagers.RNSScreenFooterManagerInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = ScreenFooterManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ScreenFooterManager extends ViewGroupManager<ScreenFooter> implements RNSScreenFooterManagerInterface<ScreenFooter> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNSScreenFooter";

    @NotNull
    private final ViewManagerDelegate<ScreenFooter> delegate = new RNSScreenFooterManagerDelegate(this);

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ViewManagerDelegate<ScreenFooter> getDelegate() {
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
    public ScreenFooter createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new ScreenFooter(context);
    }
}
