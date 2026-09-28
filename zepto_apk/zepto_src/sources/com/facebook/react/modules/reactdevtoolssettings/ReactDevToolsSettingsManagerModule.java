package com.facebook.react.modules.reactdevtoolssettings;

import android.content.SharedPreferences;
import com.facebook.fbreact.specs.NativeReactDevToolsSettingsManagerSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@ReactModule(name = "ReactDevToolsSettingsManager")
@Metadata
/* loaded from: classes.dex */
public final class ReactDevToolsSettingsManagerModule extends NativeReactDevToolsSettingsManagerSpec {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    private static final String KEY_HOOK_SETTINGS = "HookSettings";

    @NotNull
    public static final String NAME = "ReactDevToolsSettingsManager";

    @NotNull
    private static final String SHARED_PREFERENCES_PREFIX = "ReactNative__DevToolsSettings";

    @NotNull
    private final SharedPreferences sharedPreferences;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReactDevToolsSettingsManagerModule(@NotNull ReactApplicationContext reactContext) {
        super(reactContext);
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        SharedPreferences sharedPreferences = reactContext.getSharedPreferences(SHARED_PREFERENCES_PREFIX, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(...)");
        this.sharedPreferences = sharedPreferences;
    }

    @Override // com.facebook.fbreact.specs.NativeReactDevToolsSettingsManagerSpec
    @Nullable
    public String getGlobalHookSettings() {
        return this.sharedPreferences.getString(KEY_HOOK_SETTINGS, null);
    }

    @Override // com.facebook.fbreact.specs.NativeReactDevToolsSettingsManagerSpec
    public void setGlobalHookSettings(@NotNull String settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.sharedPreferences.edit().putString(KEY_HOOK_SETTINGS, settings).apply();
    }
}
