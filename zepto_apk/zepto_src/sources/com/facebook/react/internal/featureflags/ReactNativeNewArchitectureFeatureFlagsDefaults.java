package com.facebook.react.internal.featureflags;

import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public class ReactNativeNewArchitectureFeatureFlagsDefaults extends ReactNativeFeatureFlagsDefaults {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f18995a = true;

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableBridgelessArchitecture() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableDeletionOfUnmountedViews() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableEventEmitterRetentionDuringGesturesOnAndroid() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean enableFabricRenderer() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useFabricInterop() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useNativeViewConfigsInBridgelessMode() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useTurboModuleInterop() {
        return this.f18995a;
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsDefaults, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public boolean useTurboModules() {
        return this.f18995a;
    }
}
