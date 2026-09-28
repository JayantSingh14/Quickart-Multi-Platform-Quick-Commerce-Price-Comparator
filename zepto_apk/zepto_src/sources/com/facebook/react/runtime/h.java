package com.facebook.react.runtime;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.runtime.BridgelessAtomicRef;
import com.facebook.react.runtime.internal.bolts.Task;
import com.facebook.react.runtime.internal.bolts.TaskCompletionSource;
import com.facebook.react.uimanager.ComponentNameResolver;
import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final /* synthetic */ class h implements BridgelessAtomicRef.Provider, QueueThreadExceptionHandler, ComponentNameResolver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19305a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19306b;

    public /* synthetic */ h(Object obj, int i2) {
        this.f19305a = i2;
        this.f19306b = obj;
    }

    @Override // com.facebook.react.runtime.BridgelessAtomicRef.Provider
    public Object get() {
        Task taskA;
        int i2 = 0;
        int i3 = 2;
        int i4 = 1;
        Object obj = this.f19306b;
        switch (this.f19305a) {
            case 0:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                ReactHostImpl reactHostImpl = (ReactHostImpl) obj;
                reactHostImpl.r("getOrCreateReactInstanceTask()", "Start");
                ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGELESS_LOADING_START, 1);
                reactHostImpl.q("getJSBundleLoader()");
                boolean z = reactHostImpl.f19248j;
                ExecutorService executorService = reactHostImpl.f19243e;
                if (z && reactHostImpl.f19247i) {
                    reactHostImpl.q("isMetroRunning()");
                    TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                    DevSupportManager devSupportManager = reactHostImpl.f19242d;
                    Assertions.c(devSupportManager);
                    devSupportManager.E(new s(reactHostImpl, taskCompletionSource));
                    taskA = taskCompletionSource.f19340a.m(new i(reactHostImpl, i3), executorService);
                } else {
                    taskA = Task.a(new a(reactHostImpl, i3), Task.f19311g);
                }
                Task taskL = taskA.l(new i(reactHostImpl, i2), executorService);
                i iVar = new i(reactHostImpl, i4);
                boolean zCompleteReactInstanceCreationOnBgThreadOnAndroid = ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid();
                Executor executor = reactHostImpl.f19244f;
                if (!zCompleteReactInstanceCreationOnBgThreadOnAndroid) {
                    return taskL.l(iVar, executor);
                }
                taskL.l(iVar, executor);
                return taskL.l(new j(i2), Task.f19311g);
            default:
                AtomicInteger atomicInteger2 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl2 = (ReactHostImpl) obj;
                reactHostImpl2.r("getOrCreateReactContext()", "Creating BridgelessReactContext");
                return new BridgelessReactContext(reactHostImpl2.f19239a, reactHostImpl2);
        }
    }

    @Override // com.facebook.react.uimanager.ComponentNameResolver
    public String[] getComponentNames() {
        HashSet hashSet = (HashSet) ((ReactInstance) this.f19306b).f19267f.a();
        if (hashSet.size() >= 1) {
            return (String[]) hashSet.toArray(new String[0]);
        }
        FLog.g("ReactInstance", "No ViewManager names found");
        return new String[0];
    }

    @Override // com.facebook.react.bridge.queue.QueueThreadExceptionHandler
    public void handleException(Exception exc) {
        ((ReactHostImpl) this.f19306b).p(exc);
    }
}
