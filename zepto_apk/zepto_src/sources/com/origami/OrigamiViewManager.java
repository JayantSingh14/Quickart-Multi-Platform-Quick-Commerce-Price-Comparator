package com.origami;

import android.graphics.Color;
import android.view.View;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata
/* loaded from: classes.dex */
public final class OrigamiViewManager extends SimpleViewManager<View> {
    @Override // com.facebook.react.uimanager.ViewManager
    @NotNull
    public View createViewInstance(@NotNull ThemedReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        return new View(reactContext);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return "OrigamiView";
    }

    @ReactProp(name = "color")
    public final void setColor(@NotNull View view, @NotNull String color) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(color, "color");
        view.setBackgroundColor(Color.parseColor(color));
    }
}
