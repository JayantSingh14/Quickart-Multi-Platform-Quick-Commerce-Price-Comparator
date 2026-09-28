package coil3;

import android.app.ActivityManager;
import coil3.disk.UtilsKt;
import coil3.network.CacheStrategy;
import coil3.network.okhttp.OkHttpNetworkFetcher;
import coil3.util.ServiceLoaderComponentRegistry;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsAccessor;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlagsCxxAccessor;
import com.facebook.react.uimanager.ReactYogaConfigProvider;
import com.facebook.react.uimanager.YogaNodePool;
import com.facebook.yoga.YogaConfigJNIFinalizer;
import com.facebook.yoga.YogaNative;
import com.google.android.gms.common.api.Api;
import com.phoenix.Phoenix;
import com.phoenix.PhoenixUtils;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootViewManager;
import com.zeptoconsumerapp.Utils;
import com.zeptoconsumerapp.modules.base.ContextProvider;
import com.zeptoconsumerapp.performancemode.PerformanceModeResults;
import com.zeptoconsumerapp.performancemode.performanceClasses.InitialPerformanceModeEvaluator;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13861a;

    public /* synthetic */ d(int i2) {
        this.f13861a = i2;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        switch (this.f13861a) {
            case 0:
                return UtilsKt.singletonDiskCache();
            case 1:
                return RealImageLoaderKt.addServiceLoaderComponents$lambda$3();
            case 2:
                return RealImageLoaderKt.addServiceLoaderComponents$lambda$6();
            case 3:
                return CacheStrategy.DEFAULT;
            case 4:
                return OkHttpNetworkFetcher.OkHttpNetworkFetcherFactory$lambda$0();
            case 5:
                return ServiceLoaderComponentRegistry.fetchers_delegate$lambda$0();
            case 6:
                return ServiceLoaderComponentRegistry.decoders_delegate$lambda$1();
            case 7:
                ReactNativeFeatureFlagsAccessor reactNativeFeatureFlagsAccessor = ReactNativeFeatureFlags.f18968a;
                return new ReactNativeFeatureFlagsCxxAccessor();
            case 8:
                Object obj = ReactYogaConfigProvider.f19470a;
                YogaConfigJNIFinalizer yogaConfigJNIFinalizer = new YogaConfigJNIFinalizer();
                YogaNative.jni_YGConfigSetPointScaleFactorJNI(yogaConfigJNIFinalizer.f20341a, 0.0f);
                YogaNative.jni_YGConfigSetErrataJNI(yogaConfigJNIFinalizer.f20341a, Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return yogaConfigJNIFinalizer;
            case 9:
                Object obj2 = YogaNodePool.f19623a;
                return new ClearableSynchronizedPool();
            case 10:
                return MapsKt.h(new Pair(RNGestureHandlerRootViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new com.facebook.react.b(i))), new Pair(RNGestureHandlerButtonViewManager.REACT_CLASS, ModuleSpec.viewManagerSpec(new com.facebook.react.b(2))));
            case 11:
                return Utils.c();
            case 12:
                return "26.1.3";
            case 13:
                Intrinsics.checkNotNullParameter(0, "jsVersion");
                Intrinsics.checkNotNullParameter(0, "bundleVersion");
                int iH = PhoenixUtils.Companion.h(0, 0);
                return Integer.valueOf(iH > 0 ? iH : 1);
            case 14:
                return Boolean.valueOf(Phoenix.Companion.g());
            case 15:
                return Boolean.valueOf(Phoenix.Companion.d());
            case 16:
                Lazy lazy = PerformanceModeResults.f47736a;
                return InitialPerformanceModeEvaluator.a();
            default:
                Lazy lazy2 = PerformanceModeResults.f47736a;
                Object systemService = ContextProvider.f47615b.a().a().getSystemService("activity");
                Intrinsics.d(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                return (ActivityManager) systemService;
        }
    }
}
