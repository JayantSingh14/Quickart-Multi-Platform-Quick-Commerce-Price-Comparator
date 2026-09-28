package com.facebook.react.internal.featureflags;

import java.util.LinkedHashSet;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
public final class ReactNativeFeatureFlagsLocalAccessor implements ReactNativeFeatureFlagsAccessor {
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
    public Boolean T;
    public Boolean U;

    /* renamed from: a, reason: collision with root package name */
    public final ReactNativeFeatureFlagsDefaults f18982a = new ReactNativeFeatureFlagsDefaults();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f18983b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    public Boolean f18984c;

    /* renamed from: d, reason: collision with root package name */
    public Boolean f18985d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f18986e;

    /* renamed from: f, reason: collision with root package name */
    public Boolean f18987f;

    /* renamed from: g, reason: collision with root package name */
    public Boolean f18988g;

    /* renamed from: h, reason: collision with root package name */
    public Boolean f18989h;

    /* renamed from: i, reason: collision with root package name */
    public Boolean f18990i;

    /* renamed from: j, reason: collision with root package name */
    public Boolean f18991j;

    /* renamed from: k, reason: collision with root package name */
    public Boolean f18992k;

    /* renamed from: l, reason: collision with root package name */
    public Boolean f18993l;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f18994m;
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
        Boolean bool = this.f18984c;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("commonTestFlag");
            this.f18984c = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean completeReactInstanceCreationOnBgThreadOnAndroid() {
        Boolean bool = this.f18985d;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("completeReactInstanceCreationOnBgThreadOnAndroid");
            this.f18985d = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean disableEventLoopOnBridgeless() {
        Boolean bool = this.f18986e;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("disableEventLoopOnBridgeless");
            this.f18986e = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean disableMountItemReorderingAndroid() {
        Boolean bool = this.f18987f;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("disableMountItemReorderingAndroid");
            this.f18987f = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableAccumulatedUpdatesInRawPropsAndroid() {
        Boolean bool = this.f18988g;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableAccumulatedUpdatesInRawPropsAndroid");
            this.f18988g = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableBridgelessArchitecture() {
        Boolean bool = this.f18989h;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableBridgelessArchitecture");
            this.f18989h = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableCppPropsIteratorSetter() {
        Boolean bool = this.f18990i;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableCppPropsIteratorSetter");
            this.f18990i = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableDeletionOfUnmountedViews() {
        Boolean bool = this.f18991j;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableDeletionOfUnmountedViews");
            this.f18991j = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableEagerRootViewAttachment() {
        Boolean bool = this.f18992k;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableEagerRootViewAttachment");
            this.f18992k = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableEventEmitterRetentionDuringGesturesOnAndroid() {
        Boolean bool = this.f18993l;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableEventEmitterRetentionDuringGesturesOnAndroid");
            this.f18993l = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFabricLogs() {
        Boolean bool = this.f18994m;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableFabricLogs");
            this.f18994m = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFabricRenderer() {
        Boolean bool = this.n;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableFabricRenderer");
            this.n = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableFixForViewCommandRace() {
        Boolean bool = this.o;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableFixForViewCommandRace");
            this.o = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableGranularShadowTreeStateReconciliation() {
        Boolean bool = this.p;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableGranularShadowTreeStateReconciliation");
            this.p = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableIOSViewClipToPaddingBox() {
        Boolean bool = this.q;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableIOSViewClipToPaddingBox");
            this.q = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableImagePrefetchingAndroid() {
        Boolean bool = this.r;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableImagePrefetchingAndroid");
            this.r = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableLayoutAnimationsOnAndroid() {
        Boolean bool = this.s;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableLayoutAnimationsOnAndroid");
            this.s = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableLayoutAnimationsOnIOS() {
        Boolean bool = this.t;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("enableLayoutAnimationsOnIOS");
            this.t = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableLongTaskAPI() {
        Boolean bool = this.u;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableLongTaskAPI");
            this.u = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableNewBackgroundAndBorderDrawables() {
        Boolean bool = this.v;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableNewBackgroundAndBorderDrawables");
            this.v = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enablePreciseSchedulingForPremountItemsOnAndroid() {
        Boolean bool = this.w;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enablePreciseSchedulingForPremountItemsOnAndroid");
            this.w = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enablePropsUpdateReconciliationAndroid() {
        Boolean bool = this.x;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enablePropsUpdateReconciliationAndroid");
            this.x = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableReportEventPaintTime() {
        Boolean bool = this.y;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableReportEventPaintTime");
            this.y = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableSynchronousStateUpdates() {
        Boolean bool = this.z;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableSynchronousStateUpdates");
            this.z = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableUIConsistency() {
        Boolean bool = this.A;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableUIConsistency");
            this.A = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean enableViewRecycling() {
        Boolean bool = this.B;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("enableViewRecycling");
            this.B = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean excludeYogaFromRawProps() {
        Boolean bool = this.C;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("excludeYogaFromRawProps");
            this.C = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag() {
        Boolean bool = this.D;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("fixDifferentiatorEmittingUpdatesWithWrongParentTag");
            this.D = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fixMappingOfEventPrioritiesBetweenFabricAndReact() {
        Boolean bool = this.E;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("fixMappingOfEventPrioritiesBetweenFabricAndReact");
            this.E = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid() {
        Boolean bool = this.F;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("fixMountingCoordinatorReportedPendingTransactionsOnAndroid");
            this.F = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean fuseboxEnabledRelease() {
        Boolean bool = this.G;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("fuseboxEnabledRelease");
            this.G = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean initEagerTurboModulesOnNativeModulesQueueAndroid() {
        Boolean bool = this.H;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("initEagerTurboModulesOnNativeModulesQueueAndroid");
            this.H = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean lazyAnimationCallbacks() {
        Boolean bool = this.I;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("lazyAnimationCallbacks");
            this.I = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean loadVectorDrawablesOnImages() {
        Boolean bool = this.J;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("loadVectorDrawablesOnImages");
            this.J = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean traceTurboModulePromiseRejectionsOnAndroid() {
        Boolean bool = this.K;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("traceTurboModulePromiseRejectionsOnAndroid");
            this.K = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useAlwaysAvailableJSErrorHandling() {
        Boolean bool = this.L;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useAlwaysAvailableJSErrorHandling");
            this.L = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useFabricInterop() {
        Boolean bool = this.M;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useFabricInterop");
            this.M = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useImmediateExecutorInAndroidBridgeless() {
        Boolean bool = this.N;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("useImmediateExecutorInAndroidBridgeless");
            this.N = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useNativeViewConfigsInBridgelessMode() {
        Boolean bool = this.O;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useNativeViewConfigsInBridgelessMode");
            this.O = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useOptimisedViewPreallocationOnAndroid() {
        Boolean bool = this.P;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useOptimisedViewPreallocationOnAndroid");
            this.P = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useOptimizedEventBatchingOnAndroid() {
        Boolean bool = this.Q;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useOptimizedEventBatchingOnAndroid");
            this.Q = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useRawPropsJsiValue() {
        Boolean bool = this.R;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useRawPropsJsiValue");
            this.R = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useRuntimeShadowNodeReferenceUpdate() {
        Boolean bool = this.S;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.TRUE;
            this.f18983b.add("useRuntimeShadowNodeReferenceUpdate");
            this.S = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useTurboModuleInterop() {
        Boolean bool = this.T;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useTurboModuleInterop");
            this.T = bool;
        }
        return bool.booleanValue();
    }

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor, com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    public final boolean useTurboModules() {
        Boolean bool = this.U;
        if (bool == null) {
            this.f18982a.getClass();
            bool = Boolean.FALSE;
            this.f18983b.add("useTurboModules");
            this.U = bool;
        }
        return bool.booleanValue();
    }
}
