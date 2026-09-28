package com.facebook.react.runtime;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Trace;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSBundleLoaderDelegate;
import com.facebook.react.bridge.MemoryPressureListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.InspectorFlags;
import com.facebook.react.devsupport.interfaces.BundleLoadCallback;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import com.facebook.react.runtime.internal.bolts.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19307a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f19308b;

    public /* synthetic */ i(Object obj, int i2) {
        this.f19307a = i2;
        this.f19308b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.facebook.react.runtime.l, java.lang.Object] */
    @Override // com.facebook.react.runtime.internal.bolts.Continuation
    public final Object a(Task task) {
        int i2 = 1;
        Object obj = this.f19308b;
        switch (this.f19307a) {
            case 0:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                final ReactHostImpl reactHostImpl = (ReactHostImpl) obj;
                reactHostImpl.getClass();
                JSBundleLoader jSBundleLoader = (JSBundleLoader) task.g();
                BridgelessReactContext bridgelessReactContext = (BridgelessReactContext) reactHostImpl.f19251m.c(new h(reactHostImpl, i2));
                DevSupportManager devSupportManager = reactHostImpl.f19242d;
                Assertions.c(devSupportManager);
                bridgelessReactContext.setJSExceptionHandler(devSupportManager);
                reactHostImpl.r("getOrCreateReactInstanceTask()", "Creating ReactInstance");
                h hVar = new h(reactHostImpl, 2);
                if (reactHostImpl.w == null && InspectorFlags.getFuseboxEnabled()) {
                    reactHostImpl.w = new ReactHostInspectorTarget(reactHostImpl);
                }
                final ReactInstance reactInstance = new ReactInstance(bridgelessReactContext, reactHostImpl.f19240b, reactHostImpl.f19241c, devSupportManager, hVar, reactHostImpl.f19248j, reactHostImpl.w);
                reactHostImpl.f19250l = reactInstance;
                final WeakReference weakReference = new WeakReference(reactInstance);
                ?? r7 = new MemoryPressureListener() { // from class: com.facebook.react.runtime.l
                    @Override // com.facebook.react.bridge.MemoryPressureListener
                    public final void handleMemoryPressure(final int i3) {
                        AtomicInteger atomicInteger2 = ReactHostImpl.A;
                        ReactHostImpl reactHostImpl2 = reactHostImpl;
                        reactHostImpl2.getClass();
                        final WeakReference weakReference2 = weakReference;
                        reactHostImpl2.f19243e.execute(new Runnable() { // from class: com.facebook.react.runtime.n
                            @Override // java.lang.Runnable
                            public final void run() {
                                AtomicInteger atomicInteger3 = ReactHostImpl.A;
                                ReactInstance reactInstance2 = (ReactInstance) weakReference2.get();
                                if (reactInstance2 != null) {
                                    reactInstance2.d(i3);
                                }
                            }
                        });
                    }
                };
                reactHostImpl.s = r7;
                CopyOnWriteArrayList copyOnWriteArrayList = reactHostImpl.f19246h.f18431a;
                if (!copyOnWriteArrayList.contains(r7)) {
                    copyOnWriteArrayList.add(r7);
                }
                q qVar = new q(reactInstance, z ? 1 : 0);
                if (ReactNativeFeatureFlags.f18968a.initEagerTurboModulesOnNativeModulesQueueAndroid()) {
                    reactInstance.f19263b.getNativeModulesQueueThread().runOnQueue(qVar);
                } else {
                    qVar.run();
                }
                reactHostImpl.r("getOrCreateReactInstanceTask()", "Loading JS Bundle");
                Intrinsics.checkNotNullParameter("ReactInstance.loadJSBundle", "sectionName");
                Trace.beginSection(androidx.tracing.Trace.g("ReactInstance.loadJSBundle"));
                jSBundleLoader.loadScript(new JSBundleLoaderDelegate() { // from class: com.facebook.react.runtime.ReactInstance.1
                    public AnonymousClass1() {
                    }

                    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
                    public final void loadScriptFromAssets(AssetManager assetManager, String str, boolean z) {
                        ReactInstance reactInstance2 = ReactInstance.this;
                        reactInstance2.f19262a.f19232b.set(str);
                        reactInstance2.loadJSBundleFromAssets(assetManager, str);
                    }

                    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
                    public final void loadScriptFromFile(String str, String str2, boolean z) {
                        ReactInstance reactInstance2 = ReactInstance.this;
                        reactInstance2.f19262a.f19232b.set(str2);
                        reactInstance2.loadJSBundleFromFile(str, str2);
                    }

                    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
                    public final void loadSplitBundleFromFile(String str, String str2) {
                        ReactInstance.this.loadJSBundleFromFile(str, str2);
                    }

                    @Override // com.facebook.react.bridge.JSBundleLoaderDelegate
                    public final void setSourceURLs(String str, String str2) {
                        ReactInstance.this.f19262a.f19232b.set(str);
                    }
                });
                Trace.endSection();
                reactHostImpl.r("getOrCreateReactInstanceTask()", "Calling DevSupportManagerBase.onNewReactContextCreated(reactContext)");
                devSupportManager.B(bridgelessReactContext);
                bridgelessReactContext.runOnJSQueueThread(new k());
                return new ReactHostImpl.CreationResult(reactInstance, bridgelessReactContext, reactHostImpl.y != null);
            case 1:
                AtomicInteger atomicInteger2 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl2 = (ReactHostImpl) obj;
                reactHostImpl2.getClass();
                ReactInstance reactInstance2 = ((ReactHostImpl.CreationResult) task.g()).f19257a;
                ReactContext reactContext = ((ReactHostImpl.CreationResult) task.g()).f19258b;
                boolean z = ((ReactHostImpl.CreationResult) task.g()).f19259c;
                ReactLifecycleStateManager reactLifecycleStateManager = reactHostImpl2.q;
                LifecycleState lifecycleState = reactLifecycleStateManager.f19276a;
                LifecycleState lifecycleState2 = LifecycleState.f18693c;
                Object[] objArr = lifecycleState == lifecycleState2 ? 1 : null;
                BridgelessReactStateTracker bridgelessReactStateTracker = reactLifecycleStateManager.f19277b;
                if (z && objArr == null) {
                    Activity activityL = reactHostImpl2.l();
                    if (reactLifecycleStateManager.f19276a != lifecycleState2) {
                        bridgelessReactStateTracker.a("ReactContext.onHostResume()");
                        reactContext.onHostResume(activityL);
                        reactLifecycleStateManager.f19276a = lifecycleState2;
                    }
                } else {
                    Activity activityL2 = reactHostImpl2.l();
                    if (reactLifecycleStateManager.f19276a == lifecycleState2) {
                        bridgelessReactStateTracker.a("ReactContext.onHostResume()");
                        reactContext.onHostResume(activityL2);
                    }
                }
                reactHostImpl2.r("getOrCreateReactInstanceTask()", "Executing ReactInstanceEventListeners");
                Iterator it = reactHostImpl2.u.iterator();
                while (it.hasNext()) {
                    ReactInstanceEventListener reactInstanceEventListener = (ReactInstanceEventListener) it.next();
                    if (reactInstanceEventListener != null) {
                        reactInstanceEventListener.a((ReactApplicationContext) reactContext);
                    }
                }
                return reactInstance2;
            case 2:
                AtomicInteger atomicInteger3 = ReactHostImpl.A;
                final ReactHostImpl reactHostImpl3 = (ReactHostImpl) obj;
                reactHostImpl3.getClass();
                if (!((Boolean) task.g()).booleanValue()) {
                    return Task.e(reactHostImpl3.f19240b.f18751b);
                }
                reactHostImpl3.q("loadJSBundleFromMetro()");
                final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                DevSupportManager devSupportManager2 = reactHostImpl3.f19242d;
                Assertions.c(devSupportManager2);
                final DevSupportManagerBase devSupportManagerBase = (DevSupportManagerBase) devSupportManager2;
                String str = devSupportManagerBase.f18824g;
                Assertions.c(str);
                final String strB = devSupportManagerBase.f18821d.b(str);
                devSupportManagerBase.I(strB, new BundleLoadCallback() { // from class: com.facebook.react.runtime.ReactHostImpl.3

                    /* renamed from: a */
                    public final /* synthetic */ String f19253a;

                    /* renamed from: b */
                    public final /* synthetic */ DevSupportManagerBase f19254b;

                    /* renamed from: c */
                    public final /* synthetic */ TaskCompletionSource f19255c;

                    public AnonymousClass3(final String strB2, final DevSupportManagerBase devSupportManagerBase2, final TaskCompletionSource taskCompletionSource2) {
                        str = strB2;
                        devSupportManagerBase = devSupportManagerBase2;
                        taskCompletionSource = taskCompletionSource2;
                    }

                    @Override // com.facebook.react.devsupport.interfaces.BundleLoadCallback
                    public final void b(DebugServerException debugServerException) {
                        taskCompletionSource.b(debugServerException);
                    }

                    @Override // com.facebook.react.devsupport.interfaces.BundleLoadCallback
                    public final void onSuccess() {
                        AtomicInteger atomicInteger4 = ReactHostImpl.A;
                        ReactHostImpl.this.r("loadJSBundleFromMetro()", "Creating BundleLoader");
                        taskCompletionSource.c(JSBundleLoader.createCachedBundleFromNetworkLoader(str, devSupportManagerBase.f18825h.getAbsolutePath()));
                    }
                });
                return taskCompletionSource2.f19340a;
            case 3:
                AtomicInteger atomicInteger4 = ReactHostImpl.A;
                return ((ReactHostImpl) obj).o();
            case 4:
                AtomicInteger atomicInteger5 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl4 = (ReactHostImpl) obj;
                reactHostImpl4.getClass();
                if (!task.j()) {
                    return task;
                }
                Exception excF = task.f();
                if (reactHostImpl4.f19248j) {
                    reactHostImpl4.f19242d.handleException(excF);
                    return reactHostImpl4.n("Reload failed", excF);
                }
                reactHostImpl4.f19240b.a(excF);
                throw null;
            case 5:
                AtomicInteger atomicInteger6 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl5 = (ReactHostImpl) obj;
                reactHostImpl5.getClass();
                if (!task.j()) {
                    return task.k();
                }
                Exception excF2 = task.f();
                if (!reactHostImpl5.f19248j) {
                    reactHostImpl5.f19240b.a(excF2);
                    throw null;
                }
                reactHostImpl5.f19242d.handleException(excF2);
                return reactHostImpl5.n("getOrCreateStartTask() failure: " + task.f().getMessage(), task.f()).c(new i(task, 8), Task.f19311g).k();
            case 6:
                AtomicInteger atomicInteger7 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl6 = (ReactHostImpl) obj;
                reactHostImpl6.getClass();
                if (task.j()) {
                    reactHostImpl6.s("getOrCreateReloadTask()", "Error during reload. ReactInstance task faulted. Fault reason: " + task.f().getMessage() + ". Reload reason: BridgelessDevSupportManager.handleReloadJS()", task.f());
                }
                if (task.h()) {
                    reactHostImpl6.s("getOrCreateReloadTask()", "Error during reload. ReactInstance task cancelled. Reload reason: BridgelessDevSupportManager.handleReloadJS()", null);
                }
                reactHostImpl6.r("getOrCreateReloadTask()", "Resetting reload task ref");
                reactHostImpl6.y = null;
                return task;
            case 7:
                AtomicInteger atomicInteger8 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl7 = (ReactHostImpl) obj;
                reactHostImpl7.getClass();
                if (task.j()) {
                    reactHostImpl7.p(task.f());
                }
                return null;
            default:
                AtomicInteger atomicInteger9 = ReactHostImpl.A;
                return Task.d(((Task) obj).f());
        }
    }
}
