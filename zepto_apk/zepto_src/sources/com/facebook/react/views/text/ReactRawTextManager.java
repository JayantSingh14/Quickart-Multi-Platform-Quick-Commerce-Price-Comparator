package com.facebook.react.views.text;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = ReactRawTextManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ReactRawTextManager extends ViewManager<View, ReactRawTextShadowNode> {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RCTRawText";

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public Class<ReactRawTextShadowNode> getShadowNodeClass() {
        return ReactRawTextShadowNode.class;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @Nullable
    public View prepareToRecycleView(@NotNull ThemedReactContext reactContext, @NotNull View view) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        Intrinsics.checkNotNullParameter(view, "view");
        throw new IllegalStateException("Attempt to recycle a native view for RCTRawText");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void updateExtraData(@NotNull View view, @NotNull Object extraData) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(extraData, "extraData");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactRawTextShadowNode createShadowNodeInstance() {
        return new ReactRawTextShadowNode();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactTextView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        throw new IllegalStateException("Attempt to create a native view for RCTRawText");
    }
}
