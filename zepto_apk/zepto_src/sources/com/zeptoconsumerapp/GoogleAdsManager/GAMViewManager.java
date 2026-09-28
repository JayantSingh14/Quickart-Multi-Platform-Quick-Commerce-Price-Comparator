package com.zeptoconsumerapp.GoogleAdsManager;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class GAMViewManager extends ViewGroupManager<GAMView> {
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    @NotNull
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapsKt.h(new Pair("onAdImpressionFunc", MapsKt.g(new Pair("registrationName", "onAdImpressionFunc"))), new Pair("onAdClickedFunc", MapsKt.g(new Pair("registrationName", "onAdClickedFunc"))), new Pair("onAdFailedToLoadFunc", MapsKt.g(new Pair("registrationName", "onAdFailedToLoadFunc"))), new Pair("onAdLoadedFunc", MapsKt.g(new Pair("registrationName", "onAdLoadedFunc"))));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "GAMView";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "adConfig")
    public final void setAdConfig(@NotNull GAMView view, @Nullable ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setAdConfig(readableMap);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public GAMView createViewInstance(@NotNull ThemedReactContext context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new GAMView(context);
    }
}
