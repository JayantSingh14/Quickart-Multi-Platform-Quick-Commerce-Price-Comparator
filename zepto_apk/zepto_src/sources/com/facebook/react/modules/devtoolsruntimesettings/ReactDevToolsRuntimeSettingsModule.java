package com.facebook.react.modules.devtoolsruntimesettings;

import com.facebook.fbreact.specs.NativeReactDevToolsRuntimeSettingsModuleSpec;
import com.facebook.jni.annotations.DoNotStripAny;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStripAny
@ReactModule(name = "ReactDevToolsRuntimeSettingsModule")
@Metadata
/* loaded from: classes.dex */
public final class ReactDevToolsRuntimeSettingsModule extends NativeReactDevToolsRuntimeSettingsModuleSpec {

    @NotNull
    public static final String NAME = "ReactDevToolsRuntimeSettingsModule";

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final Settings settings = new Settings();

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    public ReactDevToolsRuntimeSettingsModule(@Nullable ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeReactDevToolsRuntimeSettingsModuleSpec
    @NotNull
    public WritableMap getReloadAndProfileConfig() {
        WritableMap writableMapCreateMap = Arguments.createMap();
        Settings settings2 = settings;
        writableMapCreateMap.putBoolean("shouldReloadAndProfile", settings2.b());
        writableMapCreateMap.putBoolean("recordChangeDescriptions", settings2.a());
        return writableMapCreateMap;
    }

    @Override // com.facebook.fbreact.specs.NativeReactDevToolsRuntimeSettingsModuleSpec
    public void setReloadAndProfileConfig(@NotNull ReadableMap map) {
        Intrinsics.checkNotNullParameter(map, "map");
        if (map.hasKey("shouldReloadAndProfile")) {
            settings.d(map.getBoolean("shouldReloadAndProfile"));
        }
        if (map.hasKey("recordChangeDescriptions")) {
            settings.c(map.getBoolean("recordChangeDescriptions"));
        }
    }
}
