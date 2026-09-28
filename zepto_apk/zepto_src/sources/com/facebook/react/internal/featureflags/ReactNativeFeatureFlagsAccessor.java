package com.facebook.react.internal.featureflags;

import com.facebook.proguard.annotations.DoNotStrip;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public interface ReactNativeFeatureFlagsAccessor extends ReactNativeFeatureFlagsProvider {
    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean commonTestFlag();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean completeReactInstanceCreationOnBgThreadOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean disableEventLoopOnBridgeless();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean disableMountItemReorderingAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableAccumulatedUpdatesInRawPropsAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableBridgelessArchitecture();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableCppPropsIteratorSetter();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableDeletionOfUnmountedViews();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableEagerRootViewAttachment();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableEventEmitterRetentionDuringGesturesOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableFabricLogs();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableFabricRenderer();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableFixForViewCommandRace();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableGranularShadowTreeStateReconciliation();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableIOSViewClipToPaddingBox();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableImagePrefetchingAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableLayoutAnimationsOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableLayoutAnimationsOnIOS();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableLongTaskAPI();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableNewBackgroundAndBorderDrawables();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enablePreciseSchedulingForPremountItemsOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enablePropsUpdateReconciliationAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableReportEventPaintTime();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableSynchronousStateUpdates();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableUIConsistency();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean enableViewRecycling();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean excludeYogaFromRawProps();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean fuseboxEnabledRelease();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean initEagerTurboModulesOnNativeModulesQueueAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean lazyAnimationCallbacks();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean loadVectorDrawablesOnImages();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean traceTurboModulePromiseRejectionsOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useAlwaysAvailableJSErrorHandling();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useFabricInterop();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useImmediateExecutorInAndroidBridgeless();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useNativeViewConfigsInBridgelessMode();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useOptimisedViewPreallocationOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useOptimizedEventBatchingOnAndroid();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useRawPropsJsiValue();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useRuntimeShadowNodeReferenceUpdate();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useTurboModuleInterop();

    @Override // com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsProvider
    @DoNotStrip
    /* synthetic */ boolean useTurboModules();
}
