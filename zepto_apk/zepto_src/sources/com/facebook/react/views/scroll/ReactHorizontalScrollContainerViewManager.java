package com.facebook.react.views.scroll;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.StateWrapper;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.views.view.ReactViewGroup;
import com.facebook.react.views.view.ReactViewManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = ReactHorizontalScrollContainerViewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ReactHorizontalScrollContainerViewManager extends ReactViewManager {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";

    @Nullable
    private static Integer uiManagerType;

    @Metadata
    public static final class Companion {
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactViewGroup createViewInstance(int i2, @NotNull ThemedReactContext context, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (uiManagerType == null) {
            uiManagerType = Integer.valueOf(ViewUtil.a(i2));
            View viewCreateViewInstance = super.createViewInstance(i2, context, reactStylesDiffMap, stateWrapper);
            Intrinsics.checkNotNullExpressionValue(viewCreateViewInstance, "createViewInstance(...)");
            ReactViewGroup reactViewGroup = (ReactViewGroup) viewCreateViewInstance;
            uiManagerType = null;
            return reactViewGroup;
        }
        throw new IllegalStateException("Check failed.");
    }

    @Override // com.facebook.react.views.view.ReactViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public ReactViewGroup createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Integer num = uiManagerType;
        if (num == null) {
            throw new IllegalStateException("Required value was null.");
        }
        if (num.intValue() == 2) {
            return new ReactViewGroup(context);
        }
        return new ReactHorizontalScrollContainerLegacyView(context);
    }
}
