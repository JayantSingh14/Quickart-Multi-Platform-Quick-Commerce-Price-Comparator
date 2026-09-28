package com.facebook.react.internal.featureflags;

import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ReactNativeFeatureFlagsCxxAccessor implements ReactNativeFeatureFlagsAccessor {
    public Boolean A;
    public Boolean B;
    public Boolean C;
    public Boolean D;
    public Boolean E;
    public Boolean F;
    public Boolean G;
    public Boolean H;
    public Boolean I;
    public Boolean J;
    public Boolean K;
    public Boolean L;
    public Boolean M;
    public Boolean N;
    public Boolean O;
    public Boolean P;
    public Boolean Q;
    public Boolean R;
    public Boolean S;

    /* renamed from: a, reason: collision with root package name */
    public Boolean f18969a;

    /* renamed from: b, reason: collision with root package name */
    public Boolean f18970b;

    /* renamed from: c, reason: collision with root package name */
    public Boolean f18971c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f18972d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f18973e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f18974f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f18975g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f18976h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f18977i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f18978j;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f18979k;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f18980l;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f18981m;
    public Boolean n;
    public Boolean o;
    public Boolean p;
    public Boolean q;
    public Boolean r;
    public Boolean s;
    public Boolean t;
    public Boolean u;
    public Boolean v;
    public Boolean w;
    public Boolean x;
    public Boolean y;
    public Boolean z;

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean commonTestFlag() {
        Boolean boolValueOf = this.f18969a;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.commonTestFlag());
            this.f18969a = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean completeReactInstanceCreationOnBgThreadOnAndroid() {
        Boolean boolValueOf = this.f18970b;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.completeReactInstanceCreationOnBgThreadOnAndroid());
            this.f18970b = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean disableEventLoopOnBridgeless() {
        Boolean boolValueOf = this.f18971c;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableEventLoopOnBridgeless());
            this.f18971c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean disableMountItemReorderingAndroid() {
        Boolean boolValueOf = this.f18972d;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.disableMountItemReorderingAndroid());
            this.f18972d = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableAccumulatedUpdatesInRawPropsAndroid() {
        Boolean boolValueOf = this.f18973e;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableAccumulatedUpdatesInRawPropsAndroid());
            this.f18973e = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableBridgelessArchitecture() {
        Boolean boolValueOf = this.f18974f;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableBridgelessArchitecture());
            this.f18974f = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableCppPropsIteratorSetter() {
        Boolean boolValueOf = this.f18975g;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableCppPropsIteratorSetter());
            this.f18975g = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableDeletionOfUnmountedViews() {
        Boolean boolValueOf = this.f18976h;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableDeletionOfUnmountedViews());
            this.f18976h = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableEagerRootViewAttachment() {
        Boolean boolValueOf = this.f18977i;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableEagerRootViewAttachment());
            this.f18977i = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableEventEmitterRetentionDuringGesturesOnAndroid() {
        Boolean boolValueOf = this.f18978j;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableEventEmitterRetentionDuringGesturesOnAndroid());
            this.f18978j = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFabricLogs() {
        Boolean boolValueOf = this.f18979k;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableFabricLogs());
            this.f18979k = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFabricRenderer() {
        Boolean boolValueOf = this.f18980l;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableFabricRenderer());
            this.f18980l = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFixForViewCommandRace() {
        Boolean boolValueOf = this.f18981m;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableFixForViewCommandRace());
            this.f18981m = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableGranularShadowTreeStateReconciliation() {
        Boolean boolValueOf = this.n;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableGranularShadowTreeStateReconciliation());
            this.n = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableIOSViewClipToPaddingBox() {
        Boolean boolValueOf = this.o;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableIOSViewClipToPaddingBox());
            this.o = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableImagePrefetchingAndroid() {
        Boolean boolValueOf = this.p;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableImagePrefetchingAndroid());
            this.p = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableLayoutAnimationsOnAndroid() {
        Boolean boolValueOf = this.q;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableLayoutAnimationsOnAndroid());
            this.q = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableLayoutAnimationsOnIOS() {
        Boolean boolValueOf = this.r;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableLayoutAnimationsOnIOS());
            this.r = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableLongTaskAPI() {
        Boolean boolValueOf = this.s;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableLongTaskAPI());
            this.s = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableNewBackgroundAndBorderDrawables() {
        Boolean boolValueOf = this.t;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableNewBackgroundAndBorderDrawables());
            this.t = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enablePreciseSchedulingForPremountItemsOnAndroid() {
        Boolean boolValueOf = this.u;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enablePreciseSchedulingForPremountItemsOnAndroid());
            this.u = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enablePropsUpdateReconciliationAndroid() {
        Boolean boolValueOf = this.v;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enablePropsUpdateReconciliationAndroid());
            this.v = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableReportEventPaintTime() {
        Boolean boolValueOf = this.w;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableReportEventPaintTime());
            this.w = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableSynchronousStateUpdates() {
        Boolean boolValueOf = this.x;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableSynchronousStateUpdates());
            this.x = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableUIConsistency() {
        Boolean boolValueOf = this.y;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableUIConsistency());
            this.y = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableViewRecycling() {
        Boolean boolValueOf = this.z;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.enableViewRecycling());
            this.z = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean excludeYogaFromRawProps() {
        Boolean boolValueOf = this.A;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.excludeYogaFromRawProps());
            this.A = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag() {
        Boolean boolValueOf = this.B;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fixDifferentiatorEmittingUpdatesWithWrongParentTag());
            this.B = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fixMappingOfEventPrioritiesBetweenFabricAndReact() {
        Boolean boolValueOf = this.C;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fixMappingOfEventPrioritiesBetweenFabricAndReact());
            this.C = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid() {
        Boolean boolValueOf = this.D;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fixMountingCoordinatorReportedPendingTransactionsOnAndroid());
            this.D = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fuseboxEnabledRelease() {
        Boolean boolValueOf = this.E;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.fuseboxEnabledRelease());
            this.E = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean initEagerTurboModulesOnNativeModulesQueueAndroid() {
        Boolean boolValueOf = this.F;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.initEagerTurboModulesOnNativeModulesQueueAndroid());
            this.F = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean lazyAnimationCallbacks() {
        Boolean boolValueOf = this.G;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.lazyAnimationCallbacks());
            this.G = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean loadVectorDrawablesOnImages() {
        Boolean boolValueOf = this.H;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.loadVectorDrawablesOnImages());
            this.H = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean traceTurboModulePromiseRejectionsOnAndroid() {
        Boolean boolValueOf = this.I;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.traceTurboModulePromiseRejectionsOnAndroid());
            this.I = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useAlwaysAvailableJSErrorHandling() {
        Boolean boolValueOf = this.J;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useAlwaysAvailableJSErrorHandling());
            this.J = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useFabricInterop() {
        Boolean boolValueOf = this.K;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useFabricInterop());
            this.K = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useImmediateExecutorInAndroidBridgeless() {
        Boolean boolValueOf = this.L;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useImmediateExecutorInAndroidBridgeless());
            this.L = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useNativeViewConfigsInBridgelessMode() {
        Boolean boolValueOf = this.M;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useNativeViewConfigsInBridgelessMode());
            this.M = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useOptimisedViewPreallocationOnAndroid() {
        Boolean boolValueOf = this.N;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useOptimisedViewPreallocationOnAndroid());
            this.N = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useOptimizedEventBatchingOnAndroid() {
        Boolean boolValueOf = this.O;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useOptimizedEventBatchingOnAndroid());
            this.O = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useRawPropsJsiValue() {
        Boolean boolValueOf = this.P;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useRawPropsJsiValue());
            this.P = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useRuntimeShadowNodeReferenceUpdate() {
        Boolean boolValueOf = this.Q;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useRuntimeShadowNodeReferenceUpdate());
            this.Q = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useTurboModuleInterop() {
        Boolean boolValueOf = this.R;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useTurboModuleInterop());
            this.R = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useTurboModules() {
        Boolean boolValueOf = this.S;
        if (boolValueOf == null) {
            boolValueOf = Boolean.valueOf(ReactNativeFeatureFlagsCxxInterop.useTurboModules());
            this.S = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
