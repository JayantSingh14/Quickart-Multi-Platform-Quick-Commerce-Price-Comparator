package com.facebook.react.runtime;

import android.content.res.AssetManager;
import android.os.Trace;
import android.view.ViewGroup;
import coil3.util.UtilsKt;
import com.amazon.apay.hardened.external.model.APayConstants;
import com.facebook.common.logging.FLog;
import com.facebook.fbreact.specs.NativeExceptionsManagerSpec;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.Nullsafe;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.DebugCorePackage;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.defaults.DefaultReactHostDelegate;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.devsupport.StackTraceHelper;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.FabricUIManagerBinding;
import com.facebook.react.fabric.SurfaceHandlerBinding;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import com.facebook.react.internal.AndroidChoreographerProvider;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import com.facebook.react.jstasks.HeadlessJsTaskContext;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.JavaTimerManager;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.uimanager.ComponentNameResolverBinding;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIConstantsProviderBinding;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.ViewManagerResolver;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;
import kotlin.jvm.internal.Intrinsics;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

@Nullsafe
@ThreadSafe
/* loaded from: classes3.dex */
final class ReactInstance {

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f19261h;

    /* renamed from: a, reason: collision with root package name */
    public final BridgelessReactContext f19262a;

    /* renamed from: b, reason: collision with root package name */
    public final ReactQueueConfigurationImpl f19263b;

    /* renamed from: c, reason: collision with root package name */
    public final TurboModuleManager f19264c;

    /* renamed from: d, reason: collision with root package name */
    public final FabricUIManager f19265d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaTimerManager f19266e;

    /* renamed from: f, reason: collision with root package name */
    public final BridgelessViewManagerResolver f19267f;

    /* renamed from: g, reason: collision with root package name */
    public final JavaScriptContextHolder f19268g;

    @DoNotStrip
    private final HybridData mHybridData;

    public static class BridgelessViewManagerResolver implements ViewManagerResolver {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f19270a;

        /* renamed from: b, reason: collision with root package name */
        public final BridgelessReactContext f19271b;

        /* renamed from: c, reason: collision with root package name */
        public final HashMap f19272c = new HashMap();

        /* renamed from: d, reason: collision with root package name */
        public HashMap f19273d = null;

        public BridgelessViewManagerResolver(ArrayList arrayList, BridgelessReactContext bridgelessReactContext) {
            this.f19270a = arrayList;
            this.f19271b = bridgelessReactContext;
        }

        @Override // com.facebook.react.uimanager.ViewManagerResolver
        public final synchronized Collection a() {
            HashSet hashSet;
            hashSet = new HashSet();
            hashSet.addAll(d());
            hashSet.addAll(((HashMap) c()).keySet());
            return hashSet;
        }

        @Override // com.facebook.react.uimanager.ViewManagerResolver
        public final synchronized ViewManager b(String str) {
            ViewManager viewManager;
            ViewManager viewManagerCreateViewManager;
            HashMap map = this.f19272c;
            if (!map.containsKey(str)) {
                Iterator it = this.f19270a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        viewManager = null;
                        break;
                    }
                    ReactPackage reactPackage = (ReactPackage) it.next();
                    if ((reactPackage instanceof ViewManagerOnDemandReactPackage) && (viewManagerCreateViewManager = ((ViewManagerOnDemandReactPackage) reactPackage).createViewManager(this.f19271b, str)) != null) {
                        map.put(str, viewManagerCreateViewManager);
                        viewManager = viewManagerCreateViewManager;
                        break;
                    }
                }
            } else {
                viewManager = (ViewManager) map.get(str);
            }
            return viewManager != null ? viewManager : (ViewManager) ((HashMap) c()).get(str);
        }

        public final synchronized Map c() {
            try {
                HashMap map = this.f19273d;
                if (map != null) {
                    return map;
                }
                HashMap map2 = new HashMap();
                Iterator it = this.f19270a.iterator();
                while (it.hasNext()) {
                    ReactPackage reactPackage = (ReactPackage) it.next();
                    if (!(reactPackage instanceof ViewManagerOnDemandReactPackage)) {
                        for (ViewManager viewManager : reactPackage.createViewManagers(this.f19271b)) {
                            map2.put(viewManager.getName(), viewManager);
                        }
                    }
                }
                this.f19273d = map2;
                return map2;
            } catch (Throwable th) {
                throw th;
            }
        }

        public final synchronized HashSet d() {
            HashSet hashSet;
            Collection viewManagerNames;
            hashSet = new HashSet();
            Iterator it = this.f19270a.iterator();
            while (it.hasNext()) {
                ReactPackage reactPackage = (ReactPackage) it.next();
                if ((reactPackage instanceof ViewManagerOnDemandReactPackage) && (viewManagerNames = ((ViewManagerOnDemandReactPackage) reactPackage).getViewManagerNames(this.f19271b)) != null) {
                    hashSet.addAll(viewManagerNames);
                }
            }
            return hashSet;
        }
    }

    public class ReactJsExceptionHandlerImpl implements ReactJsExceptionHandler {

        /* renamed from: a, reason: collision with root package name */
        public final h f19274a;

        public ReactJsExceptionHandlerImpl(h hVar) {
            this.f19274a = hVar;
        }

        @Override // com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler
        public final void reportJsException(ReactJsExceptionHandler.ProcessedError processedError) {
            int i2 = StackTraceHelper.f18896a;
            List<ReactJsExceptionHandler.ProcessedError.StackFrame> stack = processedError.getStack();
            ArrayList arrayList = new ArrayList();
            for (ReactJsExceptionHandler.ProcessedError.StackFrame stackFrame : stack) {
                JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
                if (stackFrame.getColumn() != null) {
                    javaOnlyMap.putDouble("column", stackFrame.getColumn().intValue());
                }
                if (stackFrame.getLineNumber() != null) {
                    javaOnlyMap.putDouble("lineNumber", stackFrame.getLineNumber().intValue());
                }
                javaOnlyMap.putString(UtilsKt.SCHEME_FILE, stackFrame.getFile());
                javaOnlyMap.putString("methodName", stackFrame.getMethodName());
                arrayList.add(javaOnlyMap);
            }
            JavaOnlyMap javaOnlyMap2 = new JavaOnlyMap();
            javaOnlyMap2.putString(APayConstants.Error.MESSAGE, processedError.getMessage());
            if (processedError.getOriginalMessage() != null) {
                javaOnlyMap2.putString("originalMessage", processedError.getOriginalMessage());
            }
            if (processedError.getName() != null) {
                javaOnlyMap2.putString(CLConstants.FIELD_PAY_INFO_NAME, processedError.getName());
            }
            if (processedError.getComponentStack() != null) {
                javaOnlyMap2.putString("componentStack", processedError.getComponentStack());
            }
            javaOnlyMap2.putArray("stack", JavaOnlyArray.from(arrayList));
            javaOnlyMap2.putInt(CLConstants.SHARED_PREFERENCE_ITEM_ID, processedError.getId());
            javaOnlyMap2.putBoolean("isFatal", processedError.isFatal());
            javaOnlyMap2.putMap("extraData", processedError.getExtraData());
            try {
                NativeModule module = ReactInstance.this.f19264c.getModule(NativeExceptionsManagerSpec.NAME);
                Assertions.c(module);
                ((NativeExceptionsManagerSpec) module).reportException(javaOnlyMap2);
            } catch (Exception e2) {
                ((ReactHostImpl) this.f19274a.f19306b).p(e2);
            }
        }
    }

    static {
        synchronized (ReactInstance.class) {
            if (!f19261h) {
                SoLoader.m("rninstance");
                f19261h = true;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [com.facebook.react.runtime.m] */
    public ReactInstance(BridgelessReactContext bridgelessReactContext, DefaultReactHostDelegate defaultReactHostDelegate, ComponentFactory componentFactory, DevSupportManager devSupportManager, h hVar, boolean z, ReactHostInspectorTarget reactHostInspectorTarget) {
        this.f19262a = bridgelessReactContext;
        Intrinsics.checkNotNullParameter("ReactInstance.initialize", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactInstance.initialize"));
        ReactQueueConfigurationImpl reactQueueConfigurationImplCreate = ReactQueueConfigurationImpl.create(new ReactQueueConfigurationSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("v_native"), MessageQueueThreadSpec.newBackgroundThreadSpec("v_js")), hVar);
        this.f19263b = reactQueueConfigurationImplCreate;
        FLog.a("ReactInstance", "Calling initializeMessageQueueThreads()");
        bridgelessReactContext.initializeMessageQueueThreads(reactQueueConfigurationImplCreate);
        MessageQueueThread jSQueueThread = reactQueueConfigurationImplCreate.getJSQueueThread();
        MessageQueueThread nativeModulesQueueThread = reactQueueConfigurationImplCreate.getNativeModulesQueueThread();
        AndroidChoreographerProvider choreographerProvider = AndroidChoreographerProvider.f18966a;
        Intrinsics.checkNotNullParameter(choreographerProvider, "choreographerProvider");
        if (ReactChoreographer.f19063f == null) {
            ReactChoreographer.f19063f = new ReactChoreographer(choreographerProvider);
        }
        devSupportManager.s();
        JSTimerExecutor jSTimerExecutorCreateJSTimerExecutor = createJSTimerExecutor();
        JavaTimerManager javaTimerManager = new JavaTimerManager(bridgelessReactContext, jSTimerExecutorCreateJSTimerExecutor, ReactChoreographer.Companion.a(), devSupportManager);
        this.f19266e = javaTimerManager;
        this.mHybridData = initHybrid(defaultReactHostDelegate.f18753d, jSQueueThread, nativeModulesQueueThread, javaTimerManager, jSTimerExecutorCreateJSTimerExecutor, new ReactJsExceptionHandlerImpl(hVar), null, false, reactHostInspectorTarget);
        this.f19268g = new JavaScriptContextHolder(getJavaScriptContext());
        Intrinsics.checkNotNullParameter("ReactInstance.initialize#initTurboModules", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactInstance.initialize#initTurboModules"));
        ArrayList arrayList = new ArrayList();
        final ReactHostImpl reactHostImpl = bridgelessReactContext.f19231a;
        DevSupportManager devSupportManager2 = reactHostImpl.f19242d;
        Assertions.c(devSupportManager2);
        reactHostImpl.getClass();
        arrayList.add(new CoreReactPackage(devSupportManager2, new DefaultHardwareBackBtnHandler() { // from class: com.facebook.react.runtime.m
            @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
            public final void j() {
                AtomicInteger atomicInteger = ReactHostImpl.A;
                ReactHostImpl reactHostImpl2 = reactHostImpl;
                reactHostImpl2.getClass();
                UiThreadUtil.assertOnUiThread();
                DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = reactHostImpl2.t;
                if (defaultHardwareBackBtnHandler != null) {
                    defaultHardwareBackBtnHandler.j();
                }
            }
        }));
        if (z) {
            arrayList.add(new DebugCorePackage());
        }
        arrayList.addAll(defaultReactHostDelegate.f18752c);
        DefaultTurboModuleManagerDelegate.Builder builder = defaultReactHostDelegate.f18755f;
        builder.c(arrayList);
        builder.f18496b = bridgelessReactContext;
        ReactPackageTurboModuleManagerDelegate reactPackageTurboModuleManagerDelegateA = builder.a();
        RuntimeExecutor unbufferedRuntimeExecutor = getUnbufferedRuntimeExecutor();
        this.f19264c = new TurboModuleManager(unbufferedRuntimeExecutor, reactPackageTurboModuleManagerDelegateA, getJSCallInvokerHolder(), getNativeMethodCallInvokerHolder());
        Trace.endSection();
        Intrinsics.checkNotNullParameter("ReactInstance.initialize#initFabric", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactInstance.initialize#initFabric"));
        BridgelessViewManagerResolver bridgelessViewManagerResolver = new BridgelessViewManagerResolver(arrayList, bridgelessReactContext);
        this.f19267f = bridgelessViewManagerResolver;
        ComponentNameResolverBinding.install(unbufferedRuntimeExecutor, new h(this, 3));
        if (ReactNativeFeatureFlags.f18968a.useNativeViewConfigsInBridgelessMode()) {
            HashMap map = new HashMap();
            UIConstantsProviderBinding.install(unbufferedRuntimeExecutor, new r(), new s(this, map), new s(this, map));
        }
        EventBeatManager eventBeatManager = new EventBeatManager();
        FabricUIManager fabricUIManager = new FabricUIManager(bridgelessReactContext, new ViewManagerRegistry(bridgelessViewManagerResolver), eventBeatManager);
        this.f19265d = fabricUIManager;
        DisplayMetricsHolder.f(bridgelessReactContext);
        new FabricUIManagerBinding().register(getBufferedRuntimeExecutor(), getRuntimeScheduler(), fabricUIManager, eventBeatManager, componentFactory);
        fabricUIManager.initialize();
        Trace.endSection();
        Trace.endSection();
    }

    @DoNotStrip
    private static native JSTimerExecutor createJSTimerExecutor();

    private native long getJavaScriptContext();

    private native NativeMethodCallInvokerHolderImpl getNativeMethodCallInvokerHolder();

    private native RuntimeScheduler getRuntimeScheduler();

    private native RuntimeExecutor getUnbufferedRuntimeExecutor();

    private native void handleMemoryPressureJs(int i2);

    @DoNotStrip
    private native HybridData initHybrid(JSRuntimeFactory jSRuntimeFactory, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, JavaTimerManager javaTimerManager, JSTimerExecutor jSTimerExecutor, ReactJsExceptionHandler reactJsExceptionHandler, @Nullable BindingsInstaller bindingsInstaller, boolean z, @Nullable ReactHostInspectorTarget reactHostInspectorTarget);

    @DoNotStrip
    private native void installGlobals(boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    public native void loadJSBundleFromAssets(AssetManager assetManager, String str);

    /* JADX INFO: Access modifiers changed from: private */
    public native void loadJSBundleFromFile(String str, String str2);

    private native void registerSegmentNative(int i2, String str);

    public final void c() {
        FLog.a("ReactInstance", "ReactInstance.destroy() is called.");
        this.f19263b.destroy();
        this.f19264c.invalidate();
        this.f19265d.invalidate();
        JavaTimerManager listener = this.f19266e;
        listener.getClass();
        WeakHashMap weakHashMap = HeadlessJsTaskContext.f19009g;
        ReactApplicationContext reactApplicationContext = listener.f19040a;
        HeadlessJsTaskContext headlessJsTaskContextA = HeadlessJsTaskContext.Companion.a(reactApplicationContext);
        Intrinsics.checkNotNullParameter(listener, "listener");
        headlessJsTaskContextA.f19011b.remove(listener);
        reactApplicationContext.removeLifecycleEventListener(listener);
        listener.c();
        if (listener.n) {
            listener.f19042c.c(ReactChoreographer.CallbackType.f19072e, listener.f19050k);
            listener.n = false;
        }
        this.mHybridData.resetNative();
        this.f19268g.clear();
    }

    public native void callFunctionOnModule(String str, String str2, NativeArray nativeArray);

    public final void d(int i2) {
        try {
            handleMemoryPressureJs(i2);
        } catch (NullPointerException unused) {
            ReactSoftExceptionLogger.logSoftException("ReactInstance", new ReactNoCrashSoftException("Native method handleMemoryPressureJs is called earlier than librninstance.so got ready."));
        }
    }

    public final void e(int i2, String str) {
        registerSegmentNative(i2, str);
    }

    public final void f(ReactSurfaceImpl reactSurfaceImpl) {
        FLog.a("ReactInstance", "startSurface() is called with surface: " + reactSurfaceImpl.f19280c.getSurfaceId());
        Intrinsics.checkNotNullParameter("ReactInstance.startSurface", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("ReactInstance.startSurface"));
        ViewGroup view = reactSurfaceImpl.getView();
        if (view == null) {
            throw new IllegalStateException("Starting surface without a view is not supported, use prerenderSurface instead.");
        }
        if (view.getId() != -1) {
            Intrinsics.checkNotNullParameter("surfaceView's is NOT equal to View.NO_ID before calling startSurface.", "msg");
            ReactSoftExceptionLogger.logSoftException("ReactInstance", new IllegalViewOperationException("surfaceView's is NOT equal to View.NO_ID before calling startSurface."));
            view.setId(-1);
        }
        SurfaceHandlerBinding surfaceHandlerBinding = reactSurfaceImpl.f19280c;
        boolean zIsRunning = surfaceHandlerBinding.isRunning();
        FabricUIManager fabricUIManager = this.f19265d;
        if (zIsRunning) {
            fabricUIManager.attachRootView(surfaceHandlerBinding, view);
        } else {
            fabricUIManager.startSurface(surfaceHandlerBinding, reactSurfaceImpl.f19281d, view);
        }
        Trace.endSection();
    }

    public final void g(ReactSurfaceImpl reactSurfaceImpl) {
        FLog.a("ReactInstance", "stopSurface() is called with surface: " + reactSurfaceImpl.f19280c.getSurfaceId());
        this.f19265d.stopSurface(reactSurfaceImpl.f19280c);
    }

    public native RuntimeExecutor getBufferedRuntimeExecutor();

    public native CallInvokerHolderImpl getJSCallInvokerHolder();

    @ThreadConfined
    public native void unregisterFromInspector();
}
