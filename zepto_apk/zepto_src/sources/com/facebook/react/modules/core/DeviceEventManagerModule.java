package com.facebook.react.modules.core;

import android.net.Uri;
import com.facebook.fbreact.specs.NativeDeviceEventManagerSpec;
import com.facebook.proguard.annotations.DoNotStripAny;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "DeviceEventManager")
@Metadata
/* loaded from: classes.dex */
public class DeviceEventManagerModule extends NativeDeviceEventManagerSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "DeviceEventManager";

    @NotNull
    private final Runnable invokeDefaultBackPressRunnable;

    @Metadata
    public static final class Companion {
    }

    @DoNotStripAny
    @Metadata
    public interface RCTDeviceEventEmitter extends JavaScriptModule {
        void emit(@NotNull String str, @Nullable Object obj);
    }

    public DeviceEventManagerModule(@Nullable ReactApplicationContext reactApplicationContext, @Nullable DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        super(reactApplicationContext);
        this.invokeDefaultBackPressRunnable = new androidx.lifecycle.a(defaultHardwareBackBtnHandler, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invokeDefaultBackPressRunnable$lambda$0(DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        UiThreadUtil.assertOnUiThread();
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.j();
        }
    }

    public void emitHardwareBackPressed() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("hardwareBackPress", null);
        }
    }

    public void emitNewIntentReceived(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("url", uri.toString());
        if (reactApplicationContextIfActiveOrWarn != null) {
            reactApplicationContextIfActiveOrWarn.emitDeviceEvent("url", writableMapCreateMap);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDeviceEventManagerSpec
    public void invokeDefaultBackPressHandler() {
        getReactApplicationContext().runOnUiQueueThread(this.invokeDefaultBackPressRunnable);
    }
}
