package com.facebook.react.bridge.interop;

import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class InteropModuleRegistry {

    @NotNull
    private final Map<Class<?>, Object> supportedModules = new LinkedHashMap();

    private final boolean checkReactFeatureFlagsConditions() {
        ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessor = ReactNativeFeatureFlags.f18968a;
        return reactNativeFeatureFlagsAccessor.enableFabricRenderer() && reactNativeFeatureFlagsAccessor.useFabricInterop();
    }

    @Nullable
    public final <T extends JavaScriptModule> T getInteropModule(@NotNull Class<T> requestedModule) {
        Intrinsics.checkNotNullParameter(requestedModule, "requestedModule");
        if (checkReactFeatureFlagsConditions()) {
            Object obj = this.supportedModules.get(requestedModule);
            if (obj instanceof JavaScriptModule) {
                return (T) obj;
            }
        }
        return null;
    }

    public final <T extends JavaScriptModule> void registerInteropModule(@NotNull Class<T> interopModuleInterface, @NotNull Object interopModule) {
        Intrinsics.checkNotNullParameter(interopModuleInterface, "interopModuleInterface");
        Intrinsics.checkNotNullParameter(interopModule, "interopModule");
        if (checkReactFeatureFlagsConditions()) {
            this.supportedModules.put(interopModuleInterface, interopModule);
        }
    }

    public final <T extends JavaScriptModule> boolean shouldReturnInteropModule(@NotNull Class<T> requestedModule) {
        Intrinsics.checkNotNullParameter(requestedModule, "requestedModule");
        return checkReactFeatureFlagsConditions() && this.supportedModules.containsKey(requestedModule);
    }
}
