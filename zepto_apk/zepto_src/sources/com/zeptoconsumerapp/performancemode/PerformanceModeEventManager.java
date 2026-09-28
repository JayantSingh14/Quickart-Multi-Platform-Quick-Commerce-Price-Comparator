package com.zeptoconsumerapp.performancemode;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.zeptoconsumerapp.performancemode.PerformanceMode;
import com.zeptoconsumerapp.performancemode.PerformanceModeResults;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata
/* loaded from: classes.dex */
public final class PerformanceModeEventManager {

    /* renamed from: a, reason: collision with root package name */
    public final ReactApplicationContext f47725a;

    /* renamed from: b, reason: collision with root package name */
    public Job f47726b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f47727c;

    /* renamed from: d, reason: collision with root package name */
    public long f47728d;

    @Metadata
    public static final class Companion {
    }

    public PerformanceModeEventManager(ReactApplicationContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "reactContext");
        this.f47725a = reactContext;
    }

    public static final void a(PerformanceModeEventManager performanceModeEventManager) {
        ReactApplicationContext reactApplicationContext = performanceModeEventManager.f47725a;
        try {
            PerformanceMode.Companion.a(reactApplicationContext);
            DeviceEventManagerModule.RCTDeviceEventEmitter rCTDeviceEventEmitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
            Lazy lazy = PerformanceModeResults.f47736a;
            rCTDeviceEventEmitter.emit("PerformanceUpdated", PerformanceModeResults.Companion.a());
        } catch (Exception e2) {
            Timber.d("PSP").e(e2, "Error while emitting performance results", new Object[0]);
            e2.printStackTrace();
        }
    }
}
