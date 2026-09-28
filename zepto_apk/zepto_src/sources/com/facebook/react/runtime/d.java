package com.facebook.react.runtime;

import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function0;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements Continuation {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19290a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactHostImpl f19291b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f19292c;

    public /* synthetic */ d(ReactHostImpl reactHostImpl, Object obj, int i2) {
        this.f19290a = i2;
        this.f19291b = reactHostImpl;
        this.f19292c = obj;
    }

    @Override // com.facebook.react.runtime.internal.bolts.Continuation
    public final Object a(Task task) {
        switch (this.f19290a) {
            case 0:
                AtomicInteger atomicInteger = ReactHostImpl.A;
                ReactHostImpl reactHostImpl = this.f19291b;
                reactHostImpl.r("getOrCreateReloadTask()", "Starting React Native reload");
                ReactInstance reactInstanceA = ((f) this.f19292c).a(task, "1: Starting reload");
                reactHostImpl.v(reactInstanceA);
                ReactContext reactContext = (ReactContext) reactHostImpl.f19251m.b();
                if (reactContext == null) {
                    reactHostImpl.s("getOrCreateReloadTask()", "ReactContext is null. Reload reason: BridgelessDevSupportManager.handleReloadJS()", null);
                }
                if (reactContext != null && reactHostImpl.q.f19276a == LifecycleState.f18693c) {
                    reactHostImpl.r("getOrCreateReloadTask()", "Calling ReactContext.onHostPause()");
                    reactContext.onHostPause();
                }
                return Task.e(reactInstanceA);
            case 1:
                AtomicInteger atomicInteger2 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl2 = this.f19291b;
                reactHostImpl2.getClass();
                ((f) this.f19292c).a(task, "3: Destroying ReactContext");
                Iterator it = reactHostImpl2.v.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                if (reactHostImpl2.s != null) {
                    reactHostImpl2.r("getOrCreateReloadTask()", "Removing memory pressure listener");
                    reactHostImpl2.f19246h.f18431a.remove(reactHostImpl2.s);
                }
                BridgelessAtomicRef bridgelessAtomicRef = reactHostImpl2.f19251m;
                ReactContext reactContext2 = (ReactContext) bridgelessAtomicRef.b();
                if (reactContext2 != null) {
                    reactHostImpl2.r("getOrCreateReloadTask()", "Resetting ReactContext ref");
                    bridgelessAtomicRef.d();
                    reactHostImpl2.r("getOrCreateReloadTask()", "Destroying ReactContext");
                    reactContext2.destroy();
                }
                if (reactHostImpl2.f19248j && reactContext2 != null) {
                    reactHostImpl2.r("getOrCreateReloadTask()", "Calling DevSupportManager.onReactInstanceDestroyed(reactContext)");
                    reactHostImpl2.f19242d.C(reactContext2);
                }
                return task;
            case 2:
                AtomicInteger atomicInteger3 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl3 = this.f19291b;
                reactHostImpl3.getClass();
                ReactInstance reactInstanceA2 = ((f) this.f19292c).a(task, "4: Destroying ReactInstance");
                if (reactInstanceA2 == null) {
                    reactHostImpl3.s("getOrCreateReloadTask()", "Skipping ReactInstance.destroy(): ReactInstance null", null);
                } else {
                    reactHostImpl3.r("getOrCreateReloadTask()", "Resetting ReactInstance ptr");
                    reactHostImpl3.f19250l = null;
                    reactHostImpl3.r("getOrCreateReloadTask()", "Destroying ReactInstance");
                    reactInstanceA2.c();
                }
                boolean zCompleteReactInstanceCreationOnBgThreadOnAndroid = ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid();
                BridgelessAtomicRef bridgelessAtomicRef2 = reactHostImpl3.f19249k;
                if (!zCompleteReactInstanceCreationOnBgThreadOnAndroid) {
                    reactHostImpl3.r("getOrCreateReloadTask()", "Resetting createReactInstance task ref");
                    bridgelessAtomicRef2.d();
                }
                reactHostImpl3.r("getOrCreateReloadTask()", "Resetting start task ref");
                reactHostImpl3.x = null;
                reactHostImpl3.q("getOrCreateReactInstanceTask()");
                return (Task) bridgelessAtomicRef2.c(new h(reactHostImpl3, 0));
            case 3:
                ReactHostImpl reactHostImpl4 = this.f19291b;
                f fVar = (f) this.f19292c;
                AtomicInteger atomicInteger4 = ReactHostImpl.A;
                reactHostImpl4.getClass();
                ReactInstance reactInstanceA3 = fVar.a(task, "5: Restarting surfaces");
                if (reactInstanceA3 == null) {
                    reactHostImpl4.s("getOrCreateReloadTask()", "Skipping surface restart: ReactInstance null", null);
                } else {
                    reactHostImpl4.r("getOrCreateReloadTask()", "Restarting previously running React Native Surfaces");
                    synchronized (reactHostImpl4.f19245g) {
                        try {
                            Iterator it2 = reactHostImpl4.f19245g.iterator();
                            while (it2.hasNext()) {
                                reactInstanceA3.f((ReactSurfaceImpl) it2.next());
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                return task;
            case 4:
                AtomicInteger atomicInteger5 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl5 = this.f19291b;
                reactHostImpl5.getClass();
                ReactInstance reactInstanceA4 = ((f) this.f19292c).a(task, "4: Destroying ReactInstance");
                if (reactInstanceA4 == null) {
                    reactHostImpl5.s("getOrCreateDestroyTask()", "Skipping ReactInstance.destroy(): ReactInstance null", null);
                } else {
                    reactHostImpl5.r("getOrCreateDestroyTask()", "Resetting ReactInstance ptr");
                    reactHostImpl5.f19250l = null;
                    reactHostImpl5.r("getOrCreateDestroyTask()", "Destroying ReactInstance");
                    reactInstanceA4.c();
                }
                if (!ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid()) {
                    reactHostImpl5.r("getOrCreateDestroyTask()", "Resetting createReactInstance task ref");
                    reactHostImpl5.f19249k.d();
                }
                reactHostImpl5.r("getOrCreateDestroyTask()", "Resetting start task ref");
                reactHostImpl5.x = null;
                reactHostImpl5.r("getOrCreateDestroyTask()", "Resetting destroy task ref");
                reactHostImpl5.z = null;
                return task;
            case 5:
                AtomicInteger atomicInteger6 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl6 = this.f19291b;
                reactHostImpl6.getClass();
                ReactInstance reactInstanceA5 = ((f) this.f19292c).a(task, "2: Surface shutdown");
                if (reactInstanceA5 == null) {
                    reactHostImpl6.s("getOrCreateReloadTask()", "Skipping surface shutdown: ReactInstance null", null);
                } else {
                    reactHostImpl6.u("getOrCreateReloadTask()", reactInstanceA5);
                }
                return task;
            case 6:
                ReactHostImpl reactHostImpl7 = this.f19291b;
                f fVar2 = (f) this.f19292c;
                AtomicInteger atomicInteger7 = ReactHostImpl.A;
                reactHostImpl7.getClass();
                ReactInstance reactInstanceA6 = fVar2.a(task, "2: Stopping surfaces");
                if (reactInstanceA6 == null) {
                    reactHostImpl7.s("getOrCreateDestroyTask()", "Skipping surface shutdown: ReactInstance null", null);
                } else {
                    reactHostImpl7.u("getOrCreateDestroyTask()", reactInstanceA6);
                    synchronized (reactHostImpl7.f19245g) {
                        reactHostImpl7.f19245g.clear();
                    }
                }
                return task;
            default:
                AtomicInteger atomicInteger8 = ReactHostImpl.A;
                ReactHostImpl reactHostImpl8 = this.f19291b;
                reactHostImpl8.getClass();
                boolean zJ = task.j();
                String str = (String) this.f19292c;
                if (zJ) {
                    reactHostImpl8.s("getOrCreateDestroyTask()", "React destruction failed. ReactInstance task faulted. Fault reason: " + task.f().getMessage() + ". Destroy reason: " + str, task.f());
                }
                if (task.h()) {
                    reactHostImpl8.s("getOrCreateDestroyTask()", "React destruction failed. ReactInstance task cancelled. Destroy reason: " + str, null);
                }
                return null;
        }
    }
}
