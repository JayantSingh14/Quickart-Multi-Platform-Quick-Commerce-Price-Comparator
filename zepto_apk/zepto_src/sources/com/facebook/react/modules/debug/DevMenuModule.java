package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeDevMenuSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = NativeDevMenuSpec.NAME)
@Metadata
/* loaded from: classes.dex */
public final class DevMenuModule extends NativeDevMenuSpec {

    @NotNull
    private final DevSupportManager devSupportManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevMenuModule(@Nullable ReactApplicationContext reactApplicationContext, @NotNull DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$0(DevMenuModule devMenuModule) {
        devMenuModule.devSupportManager.w();
    }

    @Override // com.facebook.fbreact.specs.NativeDevMenuSpec
    public void debugRemotely(boolean z) {
        this.devSupportManager.c(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevMenuSpec
    public void reload() {
        if (this.devSupportManager.g()) {
            UiThreadUtil.runOnUiThread(new androidx.constraintlayout.helper.widget.a(this, 16));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDevMenuSpec
    public void setHotLoadingEnabled(boolean z) {
        this.devSupportManager.h(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevMenuSpec
    public void setProfilingEnabled(boolean z) {
    }

    @Override // com.facebook.fbreact.specs.NativeDevMenuSpec
    public void show() {
        if (this.devSupportManager.g()) {
            this.devSupportManager.A();
        }
    }
}
