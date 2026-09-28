package com.facebook.react.runtime;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.MemoryPressureRouter;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.defaults.DefaultReactHostDelegate;
import com.facebook.react.devsupport.DefaultDevSupportManagerFactory;
import com.facebook.react.devsupport.InspectorFlags;
import com.facebook.react.devsupport.inspector.InspectorNetworkHelper;
import com.facebook.react.devsupport.inspector.InspectorNetworkRequestListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.appearance.AppearanceModule;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.runtime.internal.bolts.Continuation;
import com.facebook.react.runtime.internal.bolts.Task;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.functions.Function0;

@DoNotStrip
@Nullsafe
@ThreadSafe
/* loaded from: classes3.dex */
public class ReactHostImpl implements ReactHost {
    public static final AtomicInteger A = new AtomicInteger(0);

    /* renamed from: a, reason: collision with root package name */
    public final Context f19239a;

    /* renamed from: b, reason: collision with root package name */
    public final DefaultReactHostDelegate f19240b;

    /* renamed from: c, reason: collision with root package name */
    public final ComponentFactory f19241c;

    /* renamed from: d, reason: collision with root package name */
    public final DevSupportManager f19242d;

    /* renamed from: e, reason: collision with root package name */
    public final ExecutorService f19243e;

    /* renamed from: f, reason: collision with root package name */
    public final Executor f19244f;

    /* renamed from: g, reason: collision with root package name */
    public final HashSet f19245g;

    /* renamed from: h, reason: collision with root package name */
    public final MemoryPressureRouter f19246h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f19247i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f19248j;

    /* renamed from: k, reason: collision with root package name */
    public final BridgelessAtomicRef f19249k;

    /* renamed from: l, reason: collision with root package name */
    public ReactInstance f19250l;

    /* renamed from: m, reason: collision with root package name */
    public final BridgelessAtomicRef f19251m;
    public final AtomicReference n;
    public final AtomicReference o;
    public final BridgelessReactStateTracker p;
    public final ReactLifecycleStateManager q;
    public final int r;
    public l s;
    public DefaultHardwareBackBtnHandler t;
    public final CopyOnWriteArrayList u;
    public final CopyOnWriteArrayList v;
    public ReactHostInspectorTarget w;
    public Task x;
    public Task y;
    public Task z;

    /* renamed from: com.facebook.react.runtime.ReactHostImpl$2, reason: invalid class name */
    class AnonymousClass2 implements Continuation<Void, Void> {
        @Override // com.facebook.react.runtime.internal.bolts.Continuation
        public final Object a(Task task) {
            if (task.i()) {
                task.j();
            }
            throw null;
        }
    }

    public static class CreationResult {

        /* renamed from: a, reason: collision with root package name */
        public final ReactInstance f19257a;

        /* renamed from: b, reason: collision with root package name */
        public final ReactContext f19258b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f19259c;

        public CreationResult(ReactInstance reactInstance, ReactContext reactContext, boolean z) {
            this.f19257a = reactInstance;
            this.f19258b = reactContext;
            this.f19259c = z;
        }
    }

    public interface ReactInstanceCalback {
        void a(ReactInstance reactInstance);
    }

    public interface ReactInstanceTaskUnwrapper {
    }

    public ReactHostImpl(Context context, DefaultReactHostDelegate defaultReactHostDelegate, ComponentFactory componentFactory, boolean z) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Executor executor = Task.f19312h;
        this.f19245g = new HashSet();
        this.f19249k = new BridgelessAtomicRef(Task.f19313i);
        this.f19251m = new BridgelessAtomicRef();
        this.n = new AtomicReference();
        this.o = new AtomicReference(new WeakReference(null));
        BridgelessReactStateTracker bridgelessReactStateTracker = new BridgelessReactStateTracker();
        this.p = bridgelessReactStateTracker;
        this.q = new ReactLifecycleStateManager(bridgelessReactStateTracker);
        this.r = A.getAndIncrement();
        this.u = new CopyOnWriteArrayList();
        this.v = new CopyOnWriteArrayList();
        this.x = null;
        this.y = null;
        this.z = null;
        this.f19239a = context;
        this.f19240b = defaultReactHostDelegate;
        this.f19241c = componentFactory;
        this.f19243e = executorServiceNewSingleThreadExecutor;
        this.f19244f = executor;
        this.f19246h = new MemoryPressureRouter(context);
        this.f19247i = true;
        this.f19248j = z;
        this.f19242d = new DefaultDevSupportManagerFactory().b(context.getApplicationContext(), new ReactHostImplDevHelper(this), defaultReactHostDelegate.f18750a, z);
    }

    @DoNotStrip
    private Map<String, String> getHostMetadata() {
        return AndroidInfoHelpers.b(this.f19239a);
    }

    @DoNotStrip
    private void loadNetworkResource(String str, InspectorNetworkRequestListener inspectorNetworkRequestListener) {
        InspectorNetworkHelper.a(str, inspectorNetworkRequestListener);
    }

    @DoNotStrip
    private void setPausedInDebuggerMessage(@Nullable String str) {
        DevSupportManager devSupportManager = this.f19242d;
        if (str == null) {
            devSupportManager.b();
        } else {
            devSupportManager.a(str, new DevSupportManager.PausedInDebuggerOverlayCommandListener() { // from class: com.facebook.react.runtime.ReactHostImpl.1
                @Override // com.facebook.react.devsupport.interfaces.DevSupportManager.PausedInDebuggerOverlayCommandListener
                public final void onResume() {
                    UiThreadUtil.assertOnUiThread();
                    ReactHostInspectorTarget reactHostInspectorTarget = ReactHostImpl.this.w;
                    if (reactHostInspectorTarget != null) {
                        reactHostInspectorTarget.sendDebuggerResumeCommand();
                    }
                }
            });
        }
    }

    @Override // com.facebook.react.ReactHost
    public final ReactSurfaceImpl a(FragmentActivity fragmentActivity, String str, Bundle bundle) {
        ReactSurfaceImpl reactSurfaceImpl = new ReactSurfaceImpl(fragmentActivity, str, bundle);
        ReactSurfaceView reactSurfaceView = new ReactSurfaceView(fragmentActivity, reactSurfaceImpl);
        reactSurfaceView.setShouldLogContentAppeared(true);
        AtomicReference atomicReference = reactSurfaceImpl.f19278a;
        while (!atomicReference.compareAndSet(null, reactSurfaceView)) {
            if (atomicReference.get() != null) {
                throw new IllegalStateException("Trying to call ReactSurface.attachView(), but the view is already attached.");
            }
        }
        reactSurfaceImpl.f19281d = reactSurfaceView.getContext();
        reactSurfaceImpl.a(this);
        return reactSurfaceImpl;
    }

    @Override // com.facebook.react.ReactHost
    public final DevSupportManager b() {
        DevSupportManager devSupportManager = this.f19242d;
        Assertions.c(devSupportManager);
        return devSupportManager;
    }

    @Override // com.facebook.react.ReactHost
    public final void c(FragmentActivity fragmentActivity) {
        q("onUserLeaveHint(activity)");
        ReactContext reactContextM = m();
        if (reactContextM != null) {
            reactContextM.onUserLeaveHint(fragmentActivity);
        }
    }

    @Override // com.facebook.react.ReactHost
    public final void d(FragmentActivity fragmentActivity) {
        q("onHostDestroy(activity)");
        if (l() == fragmentActivity) {
            if (this.f19248j) {
                this.f19242d.l(false);
            }
            this.q.a(m());
            t(null);
        }
    }

    @Override // com.facebook.react.ReactHost
    public final void e(ReactInstanceEventListener reactInstanceEventListener) {
        this.u.remove(reactInstanceEventListener);
    }

    @Override // com.facebook.react.ReactHost
    public final void f(FragmentActivity fragmentActivity, int i2, int i3, Intent intent) {
        String str = "onActivityResult(activity = \"" + fragmentActivity + "\", requestCode = \"" + i2 + "\", resultCode = \"" + i3 + "\", data = \"" + intent + "\")";
        ReactContext reactContextM = m();
        if (reactContextM != null) {
            reactContextM.onActivityResult(fragmentActivity, i2, i3, intent);
        } else {
            s(str, "Tried to access onActivityResult while context is not ready", null);
        }
    }

    @Override // com.facebook.react.ReactHost
    public final void g(FragmentActivity fragmentActivity) {
        q("onHostPause(activity)");
        ReactContext reactContextM = m();
        Activity activityL = l();
        if (activityL != null) {
            String simpleName = activityL.getClass().getSimpleName();
            String simpleName2 = fragmentActivity == null ? "null" : fragmentActivity.getClass().getSimpleName();
            Assertions.b(fragmentActivity == activityL, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + simpleName + " Paused activity: " + simpleName2);
        }
        if (this.f19248j) {
            this.f19242d.l(false);
        }
        this.t = null;
        ReactLifecycleStateManager reactLifecycleStateManager = this.q;
        if (reactContextM != null) {
            LifecycleState lifecycleState = reactLifecycleStateManager.f19276a;
            LifecycleState lifecycleState2 = LifecycleState.f18691a;
            BridgelessReactStateTracker bridgelessReactStateTracker = reactLifecycleStateManager.f19277b;
            if (lifecycleState == lifecycleState2) {
                bridgelessReactStateTracker.a("ReactContext.onHostResume()");
                reactContextM.onHostResume(activityL);
                bridgelessReactStateTracker.a("ReactContext.onHostPause()");
                reactContextM.onHostPause();
            } else if (lifecycleState == LifecycleState.f18693c) {
                bridgelessReactStateTracker.a("ReactContext.onHostPause()");
                reactContextM.onHostPause();
            }
        } else {
            reactLifecycleStateManager.getClass();
        }
        reactLifecycleStateManager.f19276a = LifecycleState.f18692b;
    }

    @Override // com.facebook.react.ReactHost
    public final void h(FragmentActivity fragmentActivity, DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        this.t = defaultHardwareBackBtnHandler;
        q("onHostResume(activity)");
        t(fragmentActivity);
        ReactContext reactContextM = m();
        if (this.f19248j) {
            this.f19242d.l(true);
        }
        Activity activityL = l();
        ReactLifecycleStateManager reactLifecycleStateManager = this.q;
        LifecycleState lifecycleState = reactLifecycleStateManager.f19276a;
        LifecycleState lifecycleState2 = LifecycleState.f18693c;
        if (lifecycleState == lifecycleState2) {
            return;
        }
        if (reactContextM != null) {
            reactLifecycleStateManager.f19277b.a("ReactContext.onHostResume()");
            reactContextM.onHostResume(activityL);
        }
        reactLifecycleStateManager.f19276a = lifecycleState2;
    }

    @Override // com.facebook.react.ReactHost
    public final void i(FragmentActivity fragmentActivity) {
        AppearanceModule appearanceModule;
        ReactContext reactContextM = m();
        if (reactContextM == null || (appearanceModule = (AppearanceModule) reactContextM.getNativeModule(AppearanceModule.class)) == null) {
            return;
        }
        appearanceModule.onConfigurationChanged(fragmentActivity);
    }

    public final void j(String str, String str2, WritableNativeArray writableNativeArray) {
        k(android.support.v4.media.b.m("callFunctionOnModule(\"", str, "\", \"", str2, "\")"), new g(str, str2, writableNativeArray), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.util.concurrent.Executor] */
    public final Task k(String str, ReactInstanceCalback reactInstanceCalback, ExecutorService executorService) {
        String strD = android.support.v4.media.b.D("callWithExistingReactInstance(", str, ")");
        ExecutorService executorService2 = executorService;
        if (executorService == null) {
            executorService2 = ReactNativeFeatureFlags.f18968a.useImmediateExecutorInAndroidBridgeless() ? Task.f19311g : this.f19243e;
        }
        return ((Task) this.f19249k.a()).l(new b(this, strD, reactInstanceCalback, 0), executorService2);
    }

    public final Activity l() {
        return (Activity) this.n.get();
    }

    public final ReactContext m() {
        return (ReactContext) this.f19251m.b();
    }

    public final Task n(final String str, Exception exc) {
        Task task;
        Object objA;
        q("getOrCreateDestroyTask()");
        s("getOrCreateDestroyTask()", str, exc);
        final f fVar = new f(this, "Destroy", str, "getOrCreateDestroyTask()");
        if (this.z == null) {
            boolean zCompleteReactInstanceCreationOnBgThreadOnAndroid = ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid();
            BridgelessAtomicRef bridgelessAtomicRef = this.f19249k;
            if (zCompleteReactInstanceCreationOnBgThreadOnAndroid) {
                synchronized (bridgelessAtomicRef) {
                    objA = bridgelessAtomicRef.a();
                    bridgelessAtomicRef.d();
                }
                task = (Task) objA;
            } else {
                task = (Task) bridgelessAtomicRef.a();
            }
            final int i2 = 0;
            Continuation continuation = new Continuation(this) { // from class: com.facebook.react.runtime.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ReactHostImpl f19294b;

                {
                    this.f19294b = this;
                }

                @Override // com.facebook.react.runtime.internal.bolts.Continuation
                public final Object a(Task task2) {
                    switch (i2) {
                        case 0:
                            f fVar2 = fVar;
                            AtomicInteger atomicInteger = ReactHostImpl.A;
                            ReactHostImpl reactHostImpl = this.f19294b;
                            reactHostImpl.r("getOrCreateDestroyTask()", "Starting React Native destruction");
                            ReactInstance reactInstanceA = fVar2.a(task2, "1: Starting destroy");
                            reactHostImpl.v(reactInstanceA);
                            if (reactHostImpl.f19248j) {
                                reactHostImpl.r("getOrCreateDestroyTask()", "DevSupportManager cleanup");
                                reactHostImpl.f19242d.f();
                            }
                            ReactContext reactContext = (ReactContext) reactHostImpl.f19251m.b();
                            if (reactContext == null) {
                                reactHostImpl.s("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str, null);
                            }
                            reactHostImpl.r("getOrCreateDestroyTask()", "Move ReactHost to onHostDestroy()");
                            reactHostImpl.q.a(reactContext);
                            return Task.e(reactInstanceA);
                        default:
                            ReactHostImpl reactHostImpl2 = this.f19294b;
                            f fVar3 = fVar;
                            String str2 = str;
                            AtomicInteger atomicInteger2 = ReactHostImpl.A;
                            reactHostImpl2.getClass();
                            fVar3.a(task2, "3: Destroying ReactContext");
                            Iterator it = reactHostImpl2.v.iterator();
                            while (it.hasNext()) {
                                ((Function0) it.next()).invoke();
                            }
                            ReactContext reactContext2 = (ReactContext) reactHostImpl2.f19251m.b();
                            if (reactContext2 == null) {
                                reactHostImpl2.s("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str2, null);
                            }
                            reactHostImpl2.r("getOrCreateDestroyTask()", "Destroying MemoryPressureRouter");
                            MemoryPressureRouter memoryPressureRouter = reactHostImpl2.f19246h;
                            Context context = reactHostImpl2.f19239a;
                            memoryPressureRouter.getClass();
                            context.getApplicationContext().unregisterComponentCallbacks(memoryPressureRouter);
                            if (reactContext2 != null) {
                                reactHostImpl2.r("getOrCreateDestroyTask()", "Resetting ReactContext ref");
                                reactHostImpl2.f19251m.d();
                                reactHostImpl2.r("getOrCreateDestroyTask()", "Destroying ReactContext");
                                reactContext2.destroy();
                            }
                            reactHostImpl2.t(null);
                            ResourceDrawableIdHelper resourceDrawableIdHelper = ResourceDrawableIdHelper.f19970b;
                            synchronized (resourceDrawableIdHelper) {
                                resourceDrawableIdHelper.f19971a.clear();
                            }
                            return task2;
                    }
                }
            };
            Executor executor = this.f19244f;
            Task taskC = task.c(continuation, executor);
            d dVar = new d(this, fVar, 6);
            ExecutorService executorService = this.f19243e;
            final int i3 = 1;
            this.z = taskC.c(dVar, executorService).c(new Continuation(this) { // from class: com.facebook.react.runtime.e

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ ReactHostImpl f19294b;

                {
                    this.f19294b = this;
                }

                @Override // com.facebook.react.runtime.internal.bolts.Continuation
                public final Object a(Task task2) {
                    switch (i3) {
                        case 0:
                            f fVar2 = fVar;
                            AtomicInteger atomicInteger = ReactHostImpl.A;
                            ReactHostImpl reactHostImpl = this.f19294b;
                            reactHostImpl.r("getOrCreateDestroyTask()", "Starting React Native destruction");
                            ReactInstance reactInstanceA = fVar2.a(task2, "1: Starting destroy");
                            reactHostImpl.v(reactInstanceA);
                            if (reactHostImpl.f19248j) {
                                reactHostImpl.r("getOrCreateDestroyTask()", "DevSupportManager cleanup");
                                reactHostImpl.f19242d.f();
                            }
                            ReactContext reactContext = (ReactContext) reactHostImpl.f19251m.b();
                            if (reactContext == null) {
                                reactHostImpl.s("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str, null);
                            }
                            reactHostImpl.r("getOrCreateDestroyTask()", "Move ReactHost to onHostDestroy()");
                            reactHostImpl.q.a(reactContext);
                            return Task.e(reactInstanceA);
                        default:
                            ReactHostImpl reactHostImpl2 = this.f19294b;
                            f fVar3 = fVar;
                            String str2 = str;
                            AtomicInteger atomicInteger2 = ReactHostImpl.A;
                            reactHostImpl2.getClass();
                            fVar3.a(task2, "3: Destroying ReactContext");
                            Iterator it = reactHostImpl2.v.iterator();
                            while (it.hasNext()) {
                                ((Function0) it.next()).invoke();
                            }
                            ReactContext reactContext2 = (ReactContext) reactHostImpl2.f19251m.b();
                            if (reactContext2 == null) {
                                reactHostImpl2.s("getOrCreateDestroyTask()", "ReactContext is null. Destroy reason: " + str2, null);
                            }
                            reactHostImpl2.r("getOrCreateDestroyTask()", "Destroying MemoryPressureRouter");
                            MemoryPressureRouter memoryPressureRouter = reactHostImpl2.f19246h;
                            Context context = reactHostImpl2.f19239a;
                            memoryPressureRouter.getClass();
                            context.getApplicationContext().unregisterComponentCallbacks(memoryPressureRouter);
                            if (reactContext2 != null) {
                                reactHostImpl2.r("getOrCreateDestroyTask()", "Resetting ReactContext ref");
                                reactHostImpl2.f19251m.d();
                                reactHostImpl2.r("getOrCreateDestroyTask()", "Destroying ReactContext");
                                reactContext2.destroy();
                            }
                            reactHostImpl2.t(null);
                            ResourceDrawableIdHelper resourceDrawableIdHelper = ResourceDrawableIdHelper.f19970b;
                            synchronized (resourceDrawableIdHelper) {
                                resourceDrawableIdHelper.f19971a.clear();
                            }
                            return task2;
                    }
                }
            }, executor).c(new d(this, fVar, 4), executorService).b(new d(this, str, 7));
        }
        return this.z;
    }

    public final Task o() {
        Task task;
        Object objA;
        q("getOrCreateReloadTask()");
        s("getOrCreateReloadTask()", "BridgelessDevSupportManager.handleReloadJS()", null);
        f fVar = new f(this, "Reload", "BridgelessDevSupportManager.handleReloadJS()", "getOrCreateReloadTask()");
        if (this.y == null) {
            boolean zCompleteReactInstanceCreationOnBgThreadOnAndroid = ReactNativeFeatureFlags.f18968a.completeReactInstanceCreationOnBgThreadOnAndroid();
            BridgelessAtomicRef bridgelessAtomicRef = this.f19249k;
            if (zCompleteReactInstanceCreationOnBgThreadOnAndroid) {
                synchronized (bridgelessAtomicRef) {
                    objA = bridgelessAtomicRef.a();
                    bridgelessAtomicRef.d();
                }
                task = (Task) objA;
            } else {
                task = (Task) bridgelessAtomicRef.a();
            }
            d dVar = new d(this, fVar, 0);
            Executor executor = this.f19244f;
            Task taskC = task.c(dVar, executor);
            d dVar2 = new d(this, fVar, 5);
            ExecutorService executorService = this.f19243e;
            this.y = taskC.c(dVar2, executorService).c(new d(this, fVar, 1), executor).c(new d(this, fVar, 2), executorService).c(new d(this, fVar, 3), executorService).c(new i(this, 6), executorService);
        }
        return this.y;
    }

    @Override // com.facebook.react.ReactHost
    public final boolean onBackPressed() {
        NativeModule module;
        UiThreadUtil.assertOnUiThread();
        ReactInstance reactInstance = this.f19250l;
        if (reactInstance == null) {
            return false;
        }
        ReactModule reactModule = (ReactModule) DeviceEventManagerModule.class.getAnnotation(ReactModule.class);
        if (reactModule != null) {
            String strName = reactModule.name();
            synchronized (reactInstance.f19264c) {
                module = reactInstance.f19264c.getModule(strName);
            }
        } else {
            module = null;
        }
        DeviceEventManagerModule deviceEventManagerModule = (DeviceEventManagerModule) module;
        if (deviceEventManagerModule == null) {
            return false;
        }
        deviceEventManagerModule.emitHardwareBackPressed();
        return true;
    }

    @Override // com.facebook.react.ReactHost
    public final void onNewIntent(Intent intent) {
        DeviceEventManagerModule deviceEventManagerModule;
        String str = "onNewIntent(intent = \"" + intent + "\")";
        ReactContext reactContextM = m();
        if (reactContextM == null) {
            s(str, "Tried to access onNewIntent while context is not ready", null);
            return;
        }
        String action = intent.getAction();
        Uri data = intent.getData();
        if (data != null && (("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action)) && (deviceEventManagerModule = (DeviceEventManagerModule) reactContextM.getNativeModule(DeviceEventManagerModule.class)) != null)) {
            deviceEventManagerModule.emitNewIntentReceived(data);
        }
        reactContextM.onNewIntent(l(), intent);
    }

    @Override // com.facebook.react.ReactHost
    public final void onWindowFocusChange(boolean z) {
        String str = "onWindowFocusChange(hasFocus = \"" + z + "\")";
        ReactContext reactContextM = m();
        if (reactContextM != null) {
            reactContextM.onWindowFocusChange(z);
        } else {
            s(str, "Tried to access onWindowFocusChange while context is not ready", null);
        }
    }

    public final void p(final Exception exc) {
        final String str = "handleHostException(message = \"" + exc.getMessage() + "\")";
        q(str);
        if (!this.f19248j) {
            this.f19240b.a(exc);
            throw null;
        }
        this.f19242d.handleException(exc);
        Task.a(new Callable() { // from class: com.facebook.react.runtime.p
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ReactHostImpl reactHostImpl = this.f19352a;
                Task task = reactHostImpl.y;
                String str2 = str;
                Exception exc2 = exc;
                if (task == null) {
                    return reactHostImpl.n(str2, exc2);
                }
                reactHostImpl.r("destroy()", "Reloading React Native. Waiting for reload to finish before destroying React Native.");
                return reactHostImpl.y.c(new b(reactHostImpl, str2, exc2, 2), reactHostImpl.f19243e);
            }
        }, this.f19243e).c(new j(1), Task.f19311g);
    }

    public final void q(String str) {
        this.p.a("ReactHost{" + this.r + "}." + str);
    }

    public final void r(String str, String str2) {
        this.p.a("ReactHost{" + this.r + "}." + str + ": " + str2);
    }

    public final void s(String str, String str2, Exception exc) {
        String str3 = "raiseSoftException(" + str + ")";
        r(str3, str2);
        ReactSoftExceptionLogger.logSoftException("ReactHost", new ReactNoCrashSoftException(android.support.v4.media.b.l(str3, ": ", str2), exc));
    }

    public final void t(FragmentActivity fragmentActivity) {
        this.n.set(fragmentActivity);
        if (fragmentActivity != null) {
            this.o.set(new WeakReference(fragmentActivity));
        }
    }

    public final void u(String str, ReactInstance reactInstance) {
        r(str, "Stopping all React Native surfaces");
        synchronized (this.f19245g) {
            try {
                Iterator it = this.f19245g.iterator();
                while (it.hasNext()) {
                    ReactSurfaceImpl reactSurfaceImpl = (ReactSurfaceImpl) it.next();
                    reactInstance.g(reactSurfaceImpl);
                    UiThreadUtil.runOnUiThread(new q(reactSurfaceImpl, 1));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void v(ReactInstance reactInstance) {
        if (reactInstance != null) {
            if (InspectorFlags.getFuseboxEnabled()) {
                ReactHostInspectorTarget reactHostInspectorTarget = this.w;
                Assertions.b(reactHostInspectorTarget != null && reactHostInspectorTarget.isValid(), "Host inspector target destroyed before instance was unregistered");
            }
            reactInstance.unregisterFromInspector();
        }
    }

    public final Task w(final int i2) {
        if (this.y != null) {
            r("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is reloading. Return reload task.");
            return this.y;
        }
        if (this.z != null) {
            if (i2 < 4) {
                r("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is tearing down.Wait for teardown to finish, before trying again (try count = " + i2 + ").");
                return this.z.m(new Continuation() { // from class: com.facebook.react.runtime.c
                    @Override // com.facebook.react.runtime.internal.bolts.Continuation
                    public final Object a(Task task) {
                        AtomicInteger atomicInteger = ReactHostImpl.A;
                        return this.f19288a.w(i2 + 1);
                    }
                }, this.f19243e);
            }
            s("waitThenCallGetOrCreateReactInstanceTaskWithRetries", "React Native is tearing down. Not wait for teardown to finish: reached max retries.", null);
        }
        q("getOrCreateReactInstanceTask()");
        return (Task) this.f19249k.c(new h(this, 0));
    }
}
