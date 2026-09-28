package io.sentry.react.replay;

import android.view.View;
import androidx.annotation.NonNull;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = "RNSentryReplayUnmask")
/* loaded from: classes.dex */
public class RNSentryReplayUnmaskManager extends ViewGroupManager<RNSentryReplayUnmask> {
    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NonNull
    public String getName() {
        return "RNSentryReplayUnmask";
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    @NonNull
    public RNSentryReplayUnmask createViewInstance(@NonNull ThemedReactContext themedReactContext) {
        return new RNSentryReplayUnmask(themedReactContext);
    }
}
