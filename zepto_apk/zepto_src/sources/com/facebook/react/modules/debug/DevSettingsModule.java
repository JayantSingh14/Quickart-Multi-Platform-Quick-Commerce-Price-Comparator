package com.facebook.react.modules.debug;

import com.facebook.fbreact.specs.NativeDevSettingsSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = NativeDevSettingsSpec.NAME)
@Metadata
/* loaded from: classes.dex */
public final class DevSettingsModule extends NativeDevSettingsSpec {

    @NotNull
    private final DevSupportManager devSupportManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DevSettingsModule(@Nullable ReactApplicationContext reactApplicationContext, @NotNull DevSupportManager devSupportManager) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(devSupportManager, "devSupportManager");
        this.devSupportManager = devSupportManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addMenuItem$lambda$1(String str, DevSettingsModule devSettingsModule) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("title", str);
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = devSettingsModule.getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("didPressMenuItem", writableMapCreateMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reload$lambda$0(DevSettingsModule devSettingsModule) {
        devSettingsModule.devSupportManager.w();
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void addMenuItem(@NotNull final String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        this.devSupportManager.n(title, new DevOptionHandler() { // from class: com.facebook.react.modules.debug.a
            @Override // com.facebook.react.devsupport.interfaces.DevOptionHandler
            public final void a() {
                DevSettingsModule.addMenuItem$lambda$1(title, this);
            }
        });
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void onFastRefresh() {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void openDebugger() {
        this.devSupportManager.D();
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void reload() {
        if (this.devSupportManager.g()) {
            UiThreadUtil.runOnUiThread(new androidx.constraintlayout.helper.widget.a(this, 17));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void reloadWithReason(@NotNull String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        reload();
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setHotLoadingEnabled(boolean z) {
        this.devSupportManager.h(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setIsDebuggingRemotely(boolean z) {
        this.devSupportManager.c(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setIsShakeToShowDevMenuEnabled(boolean z) {
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void setProfilingEnabled(boolean z) {
        this.devSupportManager.x(z);
    }

    @Override // com.facebook.fbreact.specs.NativeDevSettingsSpec
    public void toggleElementInspector() {
        this.devSupportManager.q();
    }
}
