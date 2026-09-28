package com.facebook.react.modules.devloading;

import androidx.constraintlayout.helper.widget.a;
import com.facebook.fbreact.specs.NativeDevLoadingViewSpec;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "DevLoadingView")
@Metadata
/* loaded from: classes.dex */
public final class DevLoadingModule extends NativeDevLoadingViewSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "DevLoadingView";

    @Nullable
    private DevLoadingViewManager devLoadingViewManager;

    @Nullable
    private final JSExceptionHandler jsExceptionHandler;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevLoadingModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        JSExceptionHandler jSExceptionHandler = reactContext.getJSExceptionHandler();
        this.jsExceptionHandler = jSExceptionHandler;
        if (jSExceptionHandler == null || !(jSExceptionHandler instanceof DevSupportManagerBase)) {
            return;
        }
        this.devLoadingViewManager = ((DevSupportManagerBase) jSExceptionHandler).F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$1(DevLoadingModule devLoadingModule) {
        DevLoadingViewManager devLoadingViewManager = devLoadingModule.devLoadingViewManager;
        if (devLoadingViewManager != null) {
            devLoadingViewManager.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showMessage$lambda$0(DevLoadingModule devLoadingModule, String str) {
        DevLoadingViewManager devLoadingViewManager = devLoadingModule.devLoadingViewManager;
        if (devLoadingViewManager != null) {
            devLoadingViewManager.a(str);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDevLoadingViewSpec
    public void hide() {
        UiThreadUtil.runOnUiThread(new a(this, 18));
    }

    @Override // com.facebook.fbreact.specs.NativeDevLoadingViewSpec
    public void showMessage(@NotNull String message, @Nullable Double d2, @Nullable Double d3) {
        Intrinsics.checkNotNullParameter(message, "message");
        UiThreadUtil.runOnUiThread(new androidx.constraintlayout.motion.widget.a(23, this, message));
    }
}
