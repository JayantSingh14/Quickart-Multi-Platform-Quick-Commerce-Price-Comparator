package com.facebook.react.runtime;

import android.content.res.AssetManager;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeArrayInterface;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashBridgeNotAllowedSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Deprecated
@DoNotStrip
@Metadata
/* loaded from: classes3.dex */
public final class BridgelessCatalystInstance implements CatalystInstance {

    /* renamed from: a, reason: collision with root package name */
    public final ReactHostImpl f19230a;

    public BridgelessCatalystInstance(ReactHostImpl reactHost) {
        Intrinsics.checkNotNullParameter(reactHost, "reactHost");
        this.f19230a = reactHost;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw new UnsupportedOperationException("Unimplemented method 'addBridgeIdleDebugListener'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void callFunction(String module, String method, NativeArray nativeArray) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(method, "method");
        throw new UnsupportedOperationException("Unimplemented method 'callFunction'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    /* renamed from: destroy */
    public final void lambda$onNativeException$6() {
        throw new UnsupportedOperationException("Unimplemented method 'destroy'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void extendNativeModules(NativeModuleRegistry modules) {
        Intrinsics.checkNotNullParameter(modules, "modules");
        throw new UnsupportedOperationException("Unimplemented method 'extendNativeModules'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final UIManager getFabricUIManager() {
        throw new UnsupportedOperationException("Unimplemented method 'getFabricUIManager'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final CallInvokerHolder getJSCallInvokerHolder() {
        CallInvokerHolderImpl jSCallInvokerHolder;
        ReactHostImpl reactHostImpl = this.f19230a;
        ReactInstance reactInstance = reactHostImpl.f19250l;
        if (reactInstance != null) {
            jSCallInvokerHolder = reactInstance.getJSCallInvokerHolder();
        } else {
            reactHostImpl.s("getJSCallInvokerHolder()", "Tried to get JSCallInvokerHolder while instance is not ready", null);
            jSCallInvokerHolder = null;
        }
        Intrinsics.c(jSCallInvokerHolder);
        return jSCallInvokerHolder;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final JavaScriptModule getJSModule(Class jsInterface) {
        Intrinsics.checkNotNullParameter(jsInterface, "jsInterface");
        ReactContext reactContextM = this.f19230a.m();
        if (reactContextM != null) {
            return reactContextM.getJSModule(jsInterface);
        }
        return null;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final JavaScriptContextHolder getJavaScriptContextHolder() {
        ReactInstance reactInstance = this.f19230a.f19250l;
        JavaScriptContextHolder javaScriptContextHolder = reactInstance != null ? reactInstance.f19268g : null;
        Intrinsics.c(javaScriptContextHolder);
        return javaScriptContextHolder;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final NativeMethodCallInvokerHolder getNativeMethodCallInvokerHolder() {
        throw new UnsupportedOperationException("Unimplemented method 'getNativeMethodCallInvokerHolder'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final NativeModule getNativeModule(Class nativeModuleInterface) {
        ReactModule reactModule;
        NativeModule module;
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        ReactHostImpl reactHostImpl = this.f19230a;
        if (nativeModuleInterface == UIManagerModule.class) {
            reactHostImpl.getClass();
            ReactSoftExceptionLogger.logSoftExceptionVerbose("ReactHost", new ReactNoCrashBridgeNotAllowedSoftException("getNativeModule(UIManagerModule.class) cannot be called when the bridge is disabled"));
        }
        ReactInstance reactInstance = reactHostImpl.f19250l;
        if (reactInstance == null || (reactModule = (ReactModule) nativeModuleInterface.getAnnotation(ReactModule.class)) == null) {
            return null;
        }
        String strName = reactModule.name();
        synchronized (reactInstance.f19264c) {
            module = reactInstance.f19264c.getModule(strName);
        }
        return module;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final Collection getNativeModules() {
        ReactInstance reactInstance = this.f19230a.f19250l;
        ArrayList arrayList = reactInstance != null ? new ArrayList(reactInstance.f19264c.getModules()) : new ArrayList();
        Intrinsics.checkNotNullExpressionValue(arrayList, "getNativeModules(...)");
        return arrayList;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final ReactQueueConfiguration getReactQueueConfiguration() {
        ReactInstance reactInstance = this.f19230a.f19250l;
        ReactQueueConfigurationImpl reactQueueConfigurationImpl = reactInstance != null ? reactInstance.f19263b : null;
        Intrinsics.c(reactQueueConfigurationImpl);
        return reactQueueConfigurationImpl;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final RuntimeExecutor getRuntimeExecutor() {
        ReactHostImpl reactHostImpl = this.f19230a;
        ReactInstance reactInstance = reactHostImpl.f19250l;
        if (reactInstance != null) {
            return reactInstance.getBufferedRuntimeExecutor();
        }
        reactHostImpl.s("getRuntimeExecutor()", "Tried to get runtime executor while instance is not ready", null);
        return null;
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final RuntimeScheduler getRuntimeScheduler() {
        throw new UnsupportedOperationException("Unimplemented method 'getRuntimeScheduler'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final String getSourceURL() {
        throw new UnsupportedOperationException("Unimplemented method 'getSourceURL'");
    }

    @Override // com.facebook.react.bridge.MemoryPressureListener
    public final void handleMemoryPressure(int i2) {
        throw new UnsupportedOperationException("Unimplemented method 'handleMemoryPressure'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final boolean hasNativeModule(Class nativeModuleInterface) {
        ReactModule reactModule;
        Intrinsics.checkNotNullParameter(nativeModuleInterface, "nativeModuleInterface");
        ReactInstance reactInstance = this.f19230a.f19250l;
        if (reactInstance == null || (reactModule = (ReactModule) nativeModuleInterface.getAnnotation(ReactModule.class)) == null) {
            return false;
        }
        return reactInstance.f19264c.hasModule(reactModule.name());
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final boolean hasRunJSBundle() {
        throw new UnsupportedOperationException("Unimplemented method 'hasRunJSBundle'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void initialize() {
        throw new UnsupportedOperationException("Unimplemented method 'initialize'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance, com.facebook.react.bridge.JSInstance
    @DoNotStrip
    public void invokeCallback(int i2, @NotNull NativeArrayInterface arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        throw new UnsupportedOperationException("Unimplemented method 'invokeCallback'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final boolean isDestroyed() {
        throw new UnsupportedOperationException("Unimplemented method 'isDestroyed'");
    }

    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
    public final void loadScriptFromAssets(AssetManager assetManager, String assetURL, boolean z) {
        Intrinsics.checkNotNullParameter(assetManager, "assetManager");
        Intrinsics.checkNotNullParameter(assetURL, "assetURL");
        throw new UnsupportedOperationException("Unimplemented method 'loadScriptFromAssets'");
    }

    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
    public final void loadScriptFromFile(String fileName, String sourceURL, boolean z) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(sourceURL, "sourceURL");
        throw new UnsupportedOperationException("Unimplemented method 'loadScriptFromFile'");
    }

    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
    public final void loadSplitBundleFromFile(String fileName, String sourceURL) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(sourceURL, "sourceURL");
        throw new UnsupportedOperationException("Unimplemented method 'loadSplitBundleFromFile'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void registerSegment(int i2, String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new UnsupportedOperationException("Unimplemented method 'registerSegment'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        throw new UnsupportedOperationException("Unimplemented method 'removeBridgeIdleDebugListener'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void runJSBundle() {
        throw new UnsupportedOperationException("Unimplemented method 'runJSBundle'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void setFabricUIManager(UIManager fabricUIManager) {
        Intrinsics.checkNotNullParameter(fabricUIManager, "fabricUIManager");
        throw new UnsupportedOperationException("Unimplemented method 'setFabricUIManager'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void setGlobalVariable(String propName, String jsonValue) {
        Intrinsics.checkNotNullParameter(propName, "propName");
        Intrinsics.checkNotNullParameter(jsonValue, "jsonValue");
        throw new UnsupportedOperationException("Unimplemented method 'setGlobalVariable'");
    }

    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
    public final void setSourceURLs(String deviceURL, String remoteURL) {
        Intrinsics.checkNotNullParameter(deviceURL, "deviceURL");
        Intrinsics.checkNotNullParameter(remoteURL, "remoteURL");
        throw new UnsupportedOperationException("Unimplemented method 'setSourceURLs'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final void setTurboModuleRegistry(TurboModuleRegistry turboModuleRegistry) {
        Intrinsics.checkNotNullParameter(turboModuleRegistry, "turboModuleRegistry");
        throw new UnsupportedOperationException("Unimplemented method 'setTurboModuleRegistry'");
    }

    @Override // com.facebook.react.bridge.CatalystInstance
    public final NativeModule getNativeModule(String moduleName) {
        NativeModule module;
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        ReactInstance reactInstance = this.f19230a.f19250l;
        if (reactInstance == null) {
            return null;
        }
        synchronized (reactInstance.f19264c) {
            module = reactInstance.f19264c.getModule(moduleName);
        }
        return module;
    }
}
