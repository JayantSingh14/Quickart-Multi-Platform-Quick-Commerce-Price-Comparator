package com.facebook.react.internal.featureflags;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.soloader.SoLoader;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@DoNotStrip
@Metadata
/* loaded from: classes.dex */
public final class ReactNativeFeatureFlagsCxxInterop {
    static {
        new ReactNativeFeatureFlagsCxxInterop();
        SoLoader.m("react_featureflagsjni");
    }

    private ReactNativeFeatureFlagsCxxInterop() {
    }

    @JvmStatic
    @DoNotStrip
    public static final native boolean commonTestFlag();

    @JvmStatic
    @DoNotStrip
    public static final native boolean completeReactInstanceCreationOnBgThreadOnAndroid();

    @JvmStatic
    @DoNotStrip
    @Nullable
    public static final native String dangerouslyForceOverride(@NotNull Object obj);

    @JvmStatic
    @DoNotStrip
    public static final native void dangerouslyReset();

    @JvmStatic
    @DoNotStrip
    public static final native boolean disableEventLoopOnBridgeless();

    @JvmStatic
    @DoNotStrip
    public static final native boolean disableMountItemReorderingAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableAccumulatedUpdatesInRawPropsAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableBridgelessArchitecture();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableCppPropsIteratorSetter();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableDeletionOfUnmountedViews();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableEagerRootViewAttachment();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableEventEmitterRetentionDuringGesturesOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableFabricLogs();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableFabricRenderer();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableFixForViewCommandRace();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableGranularShadowTreeStateReconciliation();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableIOSViewClipToPaddingBox();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableImagePrefetchingAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableLayoutAnimationsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableLayoutAnimationsOnIOS();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableLongTaskAPI();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableNewBackgroundAndBorderDrawables();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enablePreciseSchedulingForPremountItemsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enablePropsUpdateReconciliationAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableReportEventPaintTime();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableSynchronousStateUpdates();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableUIConsistency();

    @JvmStatic
    @DoNotStrip
    public static final native boolean enableViewRecycling();

    @JvmStatic
    @DoNotStrip
    public static final native boolean excludeYogaFromRawProps();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fixDifferentiatorEmittingUpdatesWithWrongParentTag();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fixMappingOfEventPrioritiesBetweenFabricAndReact();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fixMountingCoordinatorReportedPendingTransactionsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean fuseboxEnabledRelease();

    @JvmStatic
    @DoNotStrip
    public static final native boolean initEagerTurboModulesOnNativeModulesQueueAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean lazyAnimationCallbacks();

    @JvmStatic
    @DoNotStrip
    public static final native boolean loadVectorDrawablesOnImages();

    @JvmStatic
    @DoNotStrip
    public static final native void override(@NotNull Object obj);

    @JvmStatic
    @DoNotStrip
    public static final native boolean traceTurboModulePromiseRejectionsOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useAlwaysAvailableJSErrorHandling();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useFabricInterop();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useImmediateExecutorInAndroidBridgeless();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useNativeViewConfigsInBridgelessMode();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useOptimisedViewPreallocationOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useOptimizedEventBatchingOnAndroid();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useRawPropsJsiValue();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useRuntimeShadowNodeReferenceUpdate();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useTurboModuleInterop();

    @JvmStatic
    @DoNotStrip
    public static final native boolean useTurboModules();
}
