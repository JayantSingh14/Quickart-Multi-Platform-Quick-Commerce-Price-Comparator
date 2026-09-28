package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@ReactModule(name = ModalScreenViewManager.REACT_CLASS)
@Metadata
/* loaded from: classes.dex */
public final class ModalScreenViewManager extends ScreenViewManager {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String REACT_CLASS = "RNSModalScreen";

    @Metadata
    public static final class Companion {
    }

    @Override // com.swmansion.rnscreens.ScreenViewManager, com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.swmansion.rnscreens.ScreenViewManager, com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.IViewGroupManager
    public /* bridge */ /* synthetic */ void removeAllViews(@NotNull View view) {
        super.removeAllViews(view);
    }
}
