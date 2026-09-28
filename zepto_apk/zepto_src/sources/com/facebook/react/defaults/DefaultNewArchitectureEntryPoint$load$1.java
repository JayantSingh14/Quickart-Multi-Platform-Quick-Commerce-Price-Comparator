package com.facebook.react.defaults;

import com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class DefaultNewArchitectureEntryPoint$load$1 extends ReactNativeNewArchitectureFeatureFlagsDefaults {
    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableEventEmitterRetentionDuringGesturesOnAndroid() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFabricRenderer() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useFabricInterop() {
        return false;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeNewArchitectureFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useTurboModules() {
        return false;
    }
}
