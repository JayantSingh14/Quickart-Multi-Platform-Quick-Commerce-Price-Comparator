package com.facebook.react.runtime;

import android.content.Context;
import android.util.Log;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashBridgeNotAllowedSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.interop.InteropModuleRegistry;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.BlackHoleEventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@Nullsafe
/* loaded from: classes3.dex */
class BridgelessReactContext extends ReactApplicationContext implements EventDispatcherProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ReactHostImpl f19231a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicReference f19232b;

    /* renamed from: c, reason: collision with root package name */
    public final String f19233c;

    public static class BridgelessJSModuleInvocationHandler implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        public final ReactHostImpl f19234a;

        /* renamed from: b, reason: collision with root package name */
        public final Class f19235b;

        public BridgelessJSModuleInvocationHandler(ReactHostImpl reactHostImpl, Class cls) {
            this.f19234a = reactHostImpl;
            this.f19235b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            this.f19234a.j(JavaScriptModuleRegistry.getJSModuleName(this.f19235b), method.getName(), objArr != null ? Arguments.fromJavaArgs(objArr) : new WritableNativeArray());
            return null;
        }
    }

    public BridgelessReactContext(Context context, ReactHostImpl reactHostImpl) {
        super(context);
        this.f19232b = new AtomicReference();
        this.f19233c = getClass().getSimpleName();
        this.f19231a = reactHostImpl;
        if (ReactNativeFeatureFlags.f18968a.useFabricInterop()) {
            initializeInteropModules();
        }
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void destroy() {
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void emitDeviceEvent(String str, Object obj) {
        this.f19231a.j("RCTDeviceEventEmitter", "emit", Arguments.fromJavaArgs(new Object[]{str, obj}));
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final CatalystInstance getCatalystInstance() {
        Log.w(this.f19233c, "[WARNING] Bridgeless doesn't support CatalystInstance. Accessing an API that's not part of the new architecture is not encouraged usage.");
        return new BridgelessCatalystInstance(this.f19231a);
    }

    @Override // com.facebook.react.uimanager.events.EventDispatcherProvider
    public final EventDispatcher getEventDispatcher() {
        ReactInstance reactInstance = this.f19231a.f19250l;
        return reactInstance == null ? BlackHoleEventDispatcher.f19706a : reactInstance.f19265d.getEventDispatcher();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final UIManager getFabricUIManager() {
        ReactInstance reactInstance = this.f19231a.f19250l;
        if (reactInstance == null) {
            return null;
        }
        return reactInstance.f19265d;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final CallInvokerHolder getJSCallInvokerHolder() {
        ReactHostImpl reactHostImpl = this.f19231a;
        ReactInstance reactInstance = reactHostImpl.f19250l;
        if (reactInstance != null) {
            return reactInstance.getJSCallInvokerHolder();
        }
        reactHostImpl.s("getJSCallInvokerHolder()", "Tried to get JSCallInvokerHolder while instance is not ready", null);
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final JavaScriptModule getJSModule(Class cls) {
        InteropModuleRegistry interopModuleRegistry = this.mInteropModuleRegistry;
        return (interopModuleRegistry == null || !interopModuleRegistry.shouldReturnInteropModule(cls)) ? (JavaScriptModule) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BridgelessJSModuleInvocationHandler(this.f19231a, cls)) : this.mInteropModuleRegistry.getInteropModule(cls);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final JavaScriptContextHolder getJavaScriptContextHolder() {
        ReactInstance reactInstance = this.f19231a.f19250l;
        if (reactInstance != null) {
            return reactInstance.f19268g;
        }
        return null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final NativeModule getNativeModule(Class cls) {
        ReactModule reactModule;
        NativeModule module;
        ReactHostImpl reactHostImpl = this.f19231a;
        if (cls == UIManagerModule.class) {
            reactHostImpl.getClass();
            ReactSoftExceptionLogger.logSoftExceptionVerbose("ReactHost", new ReactNoCrashBridgeNotAllowedSoftException("getNativeModule(UIManagerModule.class) cannot be called when the bridge is disabled"));
        }
        ReactInstance reactInstance = reactHostImpl.f19250l;
        if (reactInstance == null || (reactModule = (ReactModule) cls.getAnnotation(ReactModule.class)) == null) {
            return null;
        }
        String strName = reactModule.name();
        synchronized (reactInstance.f19264c) {
            module = reactInstance.f19264c.getModule(strName);
        }
        return module;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final Collection getNativeModules() {
        ReactInstance reactInstance = this.f19231a.f19250l;
        return reactInstance != null ? new ArrayList(reactInstance.f19264c.getModules()) : new ArrayList();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final String getSourceURL() {
        return (String) this.f19232b.get();
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void handleException(Exception exc) {
        this.f19231a.p(exc);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasActiveCatalystInstance() {
        return this.f19231a.f19250l != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasActiveReactInstance() {
        return this.f19231a.f19250l != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasCatalystInstance() {
        return false;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasNativeModule(Class cls) {
        ReactModule reactModule;
        ReactInstance reactInstance = this.f19231a.f19250l;
        if (reactInstance == null || (reactModule = (ReactModule) cls.getAnnotation(ReactModule.class)) == null) {
            return false;
        }
        return reactInstance.f19264c.hasModule(reactModule.name());
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean hasReactInstance() {
        return this.f19231a.f19250l != null;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final boolean isBridgeless() {
        return true;
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final void registerSegment(final int i2, final String str, final Callback callback) {
        final ReactHostImpl reactHostImpl = this.f19231a;
        reactHostImpl.getClass();
        final String str2 = "registerSegment(segmentId = \"" + i2 + "\", path = \"" + str + "\")";
        reactHostImpl.r(str2, "Schedule");
        reactHostImpl.k(str2, new ReactHostImpl.ReactInstanceCalback() { // from class: com.facebook.react.runtime.o
            @Override // com.facebook.react.runtime.ReactHostImpl.ReactInstanceCalback
            public final void a(ReactInstance reactInstance) {
                AtomicInteger atomicInteger = ReactHostImpl.A;
                reactHostImpl.r(str2, "Execute");
                reactInstance.e(i2, str);
                Callback callback2 = callback;
                Assertions.c(callback2);
                callback2.invoke(new Object[0]);
            }
        }, null);
    }

    @Override // com.facebook.react.bridge.ReactContext
    public final NativeModule getNativeModule(String str) {
        NativeModule module;
        ReactInstance reactInstance = this.f19231a.f19250l;
        if (reactInstance == null) {
            return null;
        }
        synchronized (reactInstance.f19264c) {
            module = reactInstance.f19264c.getModule(str);
        }
        return module;
    }
}
