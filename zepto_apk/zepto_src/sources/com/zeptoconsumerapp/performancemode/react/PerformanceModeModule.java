package com.zeptoconsumerapp.performancemode.react;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.zeptoconsumerapp.performancemode.PerformanceModeEventManager;
import com.zeptoconsumerapp.performancemode.PerformanceModeResults;
import com.zeptoconsumerapp.performancemode.a;
import com.zeptoconsumerapp.performancemode.performanceClasses.NetworkBandwidthAggregator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata
/* loaded from: classes.dex */
public final class PerformanceModeModule extends ReactContextBaseJavaModule implements LifecycleEventListener {

    @NotNull
    public static final Companion Companion = new Companion();

    @NotNull
    public static final String NAME = "PerformanceModeModule";

    @Nullable
    private PerformanceModeEventManager eventManager;

    @NotNull
    private final ReactApplicationContext reactAppContext;

    @Metadata
    public static final class Companion {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PerformanceModeModule(@NotNull ReactApplicationContext reactAppContext) {
        super(reactAppContext);
        Intrinsics.checkNotNullParameter(reactAppContext, "reactAppContext");
        this.reactAppContext = reactAppContext;
        reactAppContext.addLifecycleEventListener(this);
        PerformanceModeEventManager performanceModeEventManager = new PerformanceModeEventManager(reactAppContext);
        this.eventManager = performanceModeEventManager;
        if (performanceModeEventManager.f47727c) {
            return;
        }
        performanceModeEventManager.f47727c = true;
        NetworkBandwidthAggregator.f47766j = new a(performanceModeEventManager);
    }

    @ReactMethod
    public final void addListener(@NotNull String eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
    }

    @Override // com.facebook.react.bridge.NativeModule
    @NotNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public final void getPerformanceResults(@NotNull Promise promise) {
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            Lazy lazy = PerformanceModeResults.f47736a;
            promise.resolve(PerformanceModeResults.Companion.a());
        } catch (Exception e2) {
            promise.reject("PERFORMANCE_RESULTS_ERROR", e2.getMessage(), e2);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        PerformanceModeEventManager performanceModeEventManager = this.eventManager;
        if (performanceModeEventManager != null && performanceModeEventManager.f47727c) {
            performanceModeEventManager.f47727c = false;
            NetworkBandwidthAggregator.f47766j = null;
            Job job = performanceModeEventManager.f47726b;
            if (job != null) {
                ((JobSupport) job).e(null);
            }
            performanceModeEventManager.f47726b = null;
            performanceModeEventManager.f47728d = 0L;
        }
        this.eventManager = null;
        this.reactAppContext.removeLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        PerformanceModeEventManager performanceModeEventManager = this.eventManager;
        if (performanceModeEventManager == null || performanceModeEventManager.f47727c) {
            return;
        }
        performanceModeEventManager.f47727c = true;
        NetworkBandwidthAggregator.f47766j = new a(performanceModeEventManager);
    }

    @ReactMethod
    public final void removeListeners(int i2) {
    }
}
