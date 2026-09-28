package com.facebook.react.jscexecutor;

import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.WritableNativeMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class JSCExecutorFactory implements JavaScriptExecutorFactory {

    /* renamed from: a, reason: collision with root package name */
    public final String f19002a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19003b;

    public JSCExecutorFactory(String appName, String deviceName) {
        Intrinsics.checkNotNullParameter(appName, "appName");
        Intrinsics.checkNotNullParameter(deviceName, "deviceName");
        this.f19002a = appName;
        this.f19003b = deviceName;
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public final JavaScriptExecutor create() {
        WritableNativeMap jscConfig = new WritableNativeMap();
        jscConfig.putString("OwnerIdentity", "ReactNative");
        jscConfig.putString("AppIdentity", this.f19002a);
        jscConfig.putString("DeviceIdentity", this.f19003b);
        Intrinsics.checkNotNullParameter(jscConfig, "jscConfig");
        return new JSCExecutor(JSCExecutor.initHybrid(jscConfig));
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public final void startSamplingProfiler() {
        throw new UnsupportedOperationException("Starting sampling profiler not supported on " + this);
    }

    @Override // com.facebook.react.bridge.JavaScriptExecutorFactory
    public final void stopSamplingProfiler(String filename) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        throw new UnsupportedOperationException("Stopping sampling profiler not supported on " + this);
    }

    public final String toString() {
        return "JSIExecutor+JSCRuntime";
    }
}
