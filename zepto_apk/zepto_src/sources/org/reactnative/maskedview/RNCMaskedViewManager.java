package org.reactnative.maskedview;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public class RNCMaskedViewManager extends ViewGroupManager<RNCMaskedView> {
    private static final String REACT_CLASS = "RNCMaskedView";

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @ReactProp(name = "androidRenderingMode")
    public void setAndroidRenderingMode(RNCMaskedView rNCMaskedView, @Nullable String str) {
        if (str != null) {
            rNCMaskedView.setRenderingMode(str);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public RNCMaskedView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNCMaskedView(themedReactContext);
    }
}
