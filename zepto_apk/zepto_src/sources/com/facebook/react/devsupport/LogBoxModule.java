package com.facebook.react.devsupport;

import com.facebook.fbreact.specs.NativeLogBoxSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "LogBox")
@Metadata
/* loaded from: classes.dex */
public final class LogBoxModule extends NativeLogBoxSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "LogBox";

    @NotNull
    private final DevSupportManager devSupportManager;

    @NotNull
    private final SurfaceDelegate surfaceDelegate;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LogBoxModule(@Nullable ReactApplicationContext reactApplicationContext, @NotNull DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
        SurfaceDelegate surfaceDelegateI = devSupportManager.i("LogBox");
        this.surfaceDelegate = surfaceDelegateI == null ? new LogBoxDialogSurfaceDelegate(devSupportManager) : surfaceDelegateI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hide$lambda$1(LogBoxModule logBoxModule) {
        logBoxModule.surfaceDelegate.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invalidate$lambda$2(LogBoxModule logBoxModule) {
        logBoxModule.surfaceDelegate.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(LogBoxModule logBoxModule) {
        if (!logBoxModule.surfaceDelegate.d()) {
            logBoxModule.surfaceDelegate.e("LogBox");
        }
        logBoxModule.surfaceDelegate.a();
    }

    @Override // com.facebook.fbreact.specs.NativeLogBoxSpec
    public void hide() {
        UiThreadUtil.runOnUiThread(new k(this, 0));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        UiThreadUtil.runOnUiThread(new k(this, 1));
    }

    @Override // com.facebook.fbreact.specs.NativeLogBoxSpec
    public void show() {
        UiThreadUtil.runOnUiThread(new k(this, 2));
    }
}
