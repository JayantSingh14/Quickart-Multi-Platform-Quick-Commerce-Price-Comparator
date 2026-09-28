package com.facebook.react;

import android.app.Application;
import android.os.Bundle;
import android.os.Trace;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.appsflyer.internal.o;
import com.appsflyer.internal.p;
import com.facebook.common.logging.FLog;
import com.facebook.debug.debugoverlay.model.DebugOverlayTag;
import com.facebook.debug.holder.NoopPrinter;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BridgeReactContext;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactCxxErrorHandler;
import com.facebook.react.bridge.ReactInstanceManagerInspectorTarget;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.InspectorFlags;
import com.facebook.react.devsupport.ReactInstanceDevHelper;
import com.facebook.react.devsupport.inspector.InspectorNetworkHelper;
import com.facebook.react.devsupport.inspector.InspectorNetworkRequestListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.internal.AndroidChoreographerProvider;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.ReactRoot;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.SystraceMessage;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

@ThreadSafe
/* loaded from: classes.dex */
public class ReactInstanceManager {

    /* renamed from: b, reason: collision with root package name */
    public volatile LifecycleState f18455b;

    /* renamed from: c, reason: collision with root package name */
    public ReactContextInitParams f18456c;

    /* renamed from: d, reason: collision with root package name */
    public volatile Thread f18457d;

    /* renamed from: e, reason: collision with root package name */
    public final JavaScriptExecutorFactory f18458e;

    /* renamed from: g, reason: collision with root package name */
    public final JSBundleLoader f18460g;

    /* renamed from: h, reason: collision with root package name */
    public final String f18461h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f18462i;

    /* renamed from: j, reason: collision with root package name */
    public final DevSupportManager f18463j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f18464k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f18465l;
    public volatile ReactApplicationContext n;
    public final Application o;
    public DefaultHardwareBackBtnHandler p;
    public FragmentActivity q;
    public ReactInstanceManagerInspectorTarget r;
    public final MemoryPressureRouter v;
    public final UIManagerProvider w;
    public final ReactPackageTurboModuleManagerDelegate.Builder x;
    public ArrayList y;

    /* renamed from: a, reason: collision with root package name */
    public final Set f18454a = Collections.synchronizedSet(new HashSet());

    /* renamed from: f, reason: collision with root package name */
    public HashSet f18459f = null;

    /* renamed from: m, reason: collision with root package name */
    public final Object f18466m = new Object();
    public final List s = Collections.synchronizedList(new ArrayList());
    public volatile boolean t = false;
    public volatile Boolean u = Boolean.FALSE;
    public final boolean z = true;

    /* renamed from: com.facebook.react.ReactInstanceManager$2, reason: invalid class name */
    class AnonymousClass2 implements ReactInstanceDevHelper {
    }

    /* renamed from: com.facebook.react.ReactInstanceManager$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    class AnonymousClass3 implements PackagerStatusCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DeveloperSettings f18468a;

        public AnonymousClass3(DeveloperSettings developerSettings) {
            this.f18468a = developerSettings;
        }

        @Override // com.facebook.react.devsupport.interfaces.PackagerStatusCallback
        public final void a(final boolean z) {
            final DeveloperSettings developerSettings = this.f18468a;
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.g
                @Override // java.lang.Runnable
                public final void run() {
                    ReactInstanceManager reactInstanceManager = ReactInstanceManager.this;
                    reactInstanceManager.getClass();
                    boolean z2 = z;
                    DevSupportManager devSupportManager = reactInstanceManager.f18463j;
                    if (z2) {
                        devSupportManager.w();
                        return;
                    }
                    boolean z3 = devSupportManager.z();
                    JavaScriptExecutorFactory javaScriptExecutorFactory = reactInstanceManager.f18458e;
                    DeveloperSettings developerSettings2 = developerSettings;
                    if (z3 && !developerSettings2.a() && !reactInstanceManager.z) {
                        FLog.a("ReactNative", "ReactInstanceManager.onJSBundleLoadedFromServer()");
                        reactInstanceManager.l(javaScriptExecutorFactory, JSBundleLoader.createCachedBundleFromNetworkLoader(devSupportManager.m(), devSupportManager.d()));
                    } else {
                        developerSettings2.c(false);
                        FLog.a("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
                        NoopPrinter.f17189a.a(ReactDebugOverlayTags.f17190a, "RNCore: load from BundleLoader");
                        reactInstanceManager.l(javaScriptExecutorFactory, reactInstanceManager.f18460g);
                    }
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static class InspectorTargetDelegateImpl implements ReactInstanceManagerInspectorTarget.TargetDelegate {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference f18472a;

        public InspectorTargetDelegateImpl(ReactInstanceManager reactInstanceManager) {
            this.f18472a = new WeakReference(reactInstanceManager);
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public final Map getMetadata() {
            ReactInstanceManager reactInstanceManager = (ReactInstanceManager) this.f18472a.get();
            return AndroidInfoHelpers.b(reactInstanceManager != null ? reactInstanceManager.o : null);
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public final void loadNetworkResource(String str, InspectorNetworkRequestListener inspectorNetworkRequestListener) {
            InspectorNetworkHelper.a(str, inspectorNetworkRequestListener);
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public final void onReload() {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.facebook.react.h
                @Override // java.lang.Runnable
                public final void run() {
                    ReactInstanceManager reactInstanceManager = (ReactInstanceManager) this.f18963a.f18472a.get();
                    if (reactInstanceManager != null) {
                        reactInstanceManager.f18463j.w();
                    }
                }
            });
        }

        @Override // com.facebook.react.bridge.ReactInstanceManagerInspectorTarget.TargetDelegate
        public final void onSetPausedInDebuggerMessage(String str) {
            final ReactInstanceManager reactInstanceManager = (ReactInstanceManager) this.f18472a.get();
            if (reactInstanceManager == null) {
                return;
            }
            DevSupportManager devSupportManager = reactInstanceManager.f18463j;
            if (str == null) {
                devSupportManager.b();
            } else {
                devSupportManager.a(str, new DevSupportManager.PausedInDebuggerOverlayCommandListener() { // from class: com.facebook.react.ReactInstanceManager.InspectorTargetDelegateImpl.1
                    @Override // com.facebook.react.devsupport.interfaces.DevSupportManager.PausedInDebuggerOverlayCommandListener
                    public final void onResume() {
                        UiThreadUtil.assertOnUiThread();
                        ReactInstanceManagerInspectorTarget reactInstanceManagerInspectorTarget = reactInstanceManager.r;
                        if (reactInstanceManagerInspectorTarget != null) {
                            reactInstanceManagerInspectorTarget.sendDebuggerResumeCommand();
                        }
                    }
                });
            }
        }
    }

    public class ReactContextInitParams {

        /* renamed from: a, reason: collision with root package name */
        public final JavaScriptExecutorFactory f18474a;

        /* renamed from: b, reason: collision with root package name */
        public final JSBundleLoader f18475b;

        public ReactContextInitParams(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            Assertions.c(javaScriptExecutorFactory);
            this.f18474a = javaScriptExecutorFactory;
            Assertions.c(jSBundleLoader);
            this.f18475b = jSBundleLoader;
        }
    }

    @Deprecated
    /* loaded from: classes3.dex */
    public interface ReactInstanceEventListener extends com.facebook.react.ReactInstanceEventListener {
    }

    public ReactInstanceManager(Application application, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, ArrayList arrayList, boolean z, DevSupportManagerFactory devSupportManagerFactory, boolean z2, LifecycleState lifecycleState, int i2, int i3, UIManagerProvider uIManagerProvider, ReactPackageTurboModuleManagerDelegate.Builder builder, SurfaceDelegateFactory surfaceDelegateFactory) throws NoSuchMethodException, SecurityException {
        Method method = null;
        FLog.a("ReactInstanceManager", "ReactInstanceManager.ctor()");
        try {
            SoLoader.f(0, application);
            DisplayMetricsHolder.f(application);
            this.o = application;
            this.q = null;
            this.p = null;
            this.f18458e = javaScriptExecutorFactory;
            this.f18460g = jSBundleLoader;
            this.f18461h = str;
            ArrayList arrayList2 = new ArrayList();
            this.f18462i = arrayList2;
            this.f18464k = z;
            this.f18465l = z2;
            Intrinsics.checkNotNullParameter("ReactInstanceManager.initDevSupportManager", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("ReactInstanceManager.initDevSupportManager"));
            DevSupportManager devSupportManagerA = devSupportManagerFactory.a(application, new AnonymousClass2(), str, z, i2, surfaceDelegateFactory);
            this.f18463j = devSupportManagerA;
            Trace.endSection();
            this.f18455b = lifecycleState;
            this.v = new MemoryPressureRouter(application);
            this.x = builder;
            synchronized (arrayList2) {
                try {
                    NoopPrinter.f17189a.a(ReactDebugOverlayTags.f17190a, "RNCore: Use Split Packages");
                    arrayList2.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler() { // from class: com.facebook.react.ReactInstanceManager.1
                        @Override // com.facebook.react.modules.core.DefaultHardwareBackBtnHandler
                        public final void j() {
                            ReactInstanceManager.this.i();
                        }
                    }, i3));
                    if (z) {
                        arrayList2.add(new DebugCorePackage());
                    }
                    arrayList2.addAll(arrayList);
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.w = uIManagerProvider;
            AndroidChoreographerProvider choreographerProvider = AndroidChoreographerProvider.f18966a;
            Intrinsics.checkNotNullParameter(choreographerProvider, "choreographerProvider");
            if (ReactChoreographer.f19063f == null) {
                ReactChoreographer.f19063f = new ReactChoreographer(choreographerProvider);
            }
            if (z) {
                devSupportManagerA.s();
            }
            try {
                method = ReactInstanceManager.class.getMethod("h", Exception.class);
            } catch (NoSuchMethodException e2) {
                FLog.h("ReactInstanceHolder", "Failed to set cxx error handler function", e2);
            }
            ReactCxxErrorHandler.setHandleErrorFunc(this, method);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    public static void e(ReactRoot reactRoot, ReactApplicationContext reactApplicationContext) {
        FLog.a("ReactNative", "ReactInstanceManager.detachRootViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (reactRoot.getState().compareAndSet(1, 0)) {
            int uIManagerType = reactRoot.getUIManagerType();
            if (uIManagerType != 2) {
                ((AppRegistry) reactApplicationContext.getCatalystInstance().getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(reactRoot.getRootViewTag());
                return;
            }
            int rootViewTag = reactRoot.getRootViewTag();
            if (rootViewTag != -1) {
                UIManager uIManagerF = UIManagerHelper.f(reactApplicationContext, uIManagerType, true);
                if (uIManagerF != null) {
                    uIManagerF.stopSurface(rootViewTag);
                } else {
                    FLog.q("ReactNative", "Failed to stop surface, UIManager has already gone away");
                }
            } else {
                ReactSoftExceptionLogger.logSoftException("ReactInstanceManager", new RuntimeException("detachRootViewFromInstance called with ReactRootView with invalid id"));
            }
            UiThreadUtil.assertOnUiThread();
            reactRoot.getState().compareAndSet(1, 0);
            ViewGroup rootViewGroup = reactRoot.getRootViewGroup();
            rootViewGroup.removeAllViews();
            rootViewGroup.setId(-1);
        }
    }

    public static void k(ReactPackage reactPackage, NativeModuleRegistryBuilder nativeModuleRegistryBuilder) {
        Iterable<ModuleHolder> reactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1;
        SystraceMessage.Builder builderA = SystraceMessage.a("processPackage");
        builderA.b(reactPackage.getClass().getSimpleName(), "className");
        builderA.c();
        boolean z = reactPackage instanceof ReactPackageLogger;
        if (z) {
            ((ReactPackageLogger) reactPackage).b();
        }
        Intrinsics.checkNotNullParameter(reactPackage, "reactPackage");
        boolean z2 = reactPackage instanceof LazyReactPackage;
        BridgeReactContext reactApplicationContext = nativeModuleRegistryBuilder.f18432a;
        if (z2) {
            final LazyReactPackage lazyReactPackage = (LazyReactPackage) reactPackage;
            final Map mapA = lazyReactPackage.b().a();
            final List listA = lazyReactPackage.a();
            reactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1 = new Iterable() { // from class: com.facebook.react.c
                @Override // java.lang.Iterable
                public final Iterator iterator() {
                    lazyReactPackage.getClass();
                    return new Iterator<ModuleHolder>() { // from class: com.facebook.react.LazyReactPackage.1

                        /* renamed from: a */
                        public int f18428a = 0;

                        /* renamed from: b */
                        public final /* synthetic */ List f18429b;

                        /* renamed from: c */
                        public final /* synthetic */ Map f18430c;

                        public AnonymousClass1(List list, Map map) {
                            list = list;
                            map = map;
                        }

                        @Override // java.util.Iterator
                        public final boolean hasNext() {
                            return this.f18428a < list.size();
                        }

                        @Override // java.util.Iterator
                        public final ModuleHolder next() {
                            int i2 = this.f18428a;
                            this.f18428a = i2 + 1;
                            ModuleSpec moduleSpec = (ModuleSpec) list.get(i2);
                            String name = moduleSpec.getName();
                            ReactModuleInfo reactModuleInfo = (ReactModuleInfo) map.get(name);
                            if (reactModuleInfo != null) {
                                return new ModuleHolder(reactModuleInfo, moduleSpec.getProvider());
                            }
                            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, name);
                            try {
                                NativeModule nativeModule = (NativeModule) moduleSpec.getProvider().get();
                                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                                return new ModuleHolder(nativeModule);
                            } catch (Throwable th) {
                                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                                throw th;
                            }
                        }

                        @Override // java.util.Iterator
                        public final void remove() {
                            throw new UnsupportedOperationException("Cannot remove native modules from the list");
                        }
                    };
                }
            };
        } else if (reactPackage instanceof BaseReactPackage) {
            reactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1 = ((BaseReactPackage) reactPackage).getNativeModuleIterator$ReactAndroid_release(reactApplicationContext);
        } else {
            Intrinsics.checkNotNullParameter(reactPackage, "reactPackage");
            Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
            FLog.a("ReactNative", reactPackage.getClass().getSimpleName().concat(" is not a LazyReactPackage, falling back to old version."));
            reactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1 = new ReactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1(reactPackage.createNativeModules(reactApplicationContext));
        }
        for (ModuleHolder moduleHolder : reactPackageHelper$getNativeModuleIterator$$inlined$Iterable$1) {
            String name = moduleHolder.getName();
            HashMap map = nativeModuleRegistryBuilder.f18433b;
            ModuleHolder moduleHolder2 = (ModuleHolder) map.get(name);
            if (moduleHolder2 != null && !moduleHolder.getCanOverrideExistingModule()) {
                throw new IllegalStateException(android.support.v4.media.b.m("\nNative module ", name, " tried to override ", moduleHolder2.getClassName(), ".\n\nCheck the getPackages() method in MainApplication.java, it might be that module is being created twice. \nIf this was your intention, set canOverrideExistingModule=true. This error may also be present if the \npackage is present only once in getPackages() but is also automatically added later during build time \nby autolinking. Try removing the existing entry and rebuild.\n").toString());
            }
            map.put(name, moduleHolder);
        }
        if (z) {
            ((ReactPackageLogger) reactPackage).a();
        }
        SystraceMessage.b().c();
    }

    public final void a(ReactRootView reactRootView) {
        UiThreadUtil.assertOnUiThread();
        synchronized (this.f18454a) {
            try {
                if (this.f18454a.add(reactRootView)) {
                    UiThreadUtil.assertOnUiThread();
                    reactRootView.getState().compareAndSet(1, 0);
                    ViewGroup rootViewGroup = reactRootView.getRootViewGroup();
                    rootViewGroup.removeAllViews();
                    rootViewGroup.setId(-1);
                } else {
                    FLog.g("ReactNative", "ReactRoot was attached multiple times");
                }
                ReactContext reactContextF = f();
                if (this.f18457d == null && reactContextF != null) {
                    b(reactRootView);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(ReactRoot reactRoot) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iAddRootView;
        FLog.a("ReactNative", "ReactInstanceManager.attachRootViewToInstance()");
        if (reactRoot.getState().compareAndSet(0, 1)) {
            Intrinsics.checkNotNullParameter("attachRootViewToInstance", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("attachRootViewToInstance"));
            UIManager uIManagerF = UIManagerHelper.f(this.n, reactRoot.getUIManagerType(), true);
            if (uIManagerF == null) {
                throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
            }
            Bundle appProperties = reactRoot.getAppProperties();
            if (reactRoot.getUIManagerType() == 2) {
                iAddRootView = uIManagerF.startSurface(reactRoot.getRootViewGroup(), reactRoot.getJSModuleName(), appProperties == null ? new WritableNativeMap() : Arguments.fromBundle(appProperties), reactRoot.getWidthMeasureSpec(), reactRoot.getHeightMeasureSpec());
                reactRoot.setShouldLogContentAppeared(true);
            } else {
                iAddRootView = uIManagerF.addRootView(reactRoot.getRootViewGroup(), appProperties == null ? new WritableNativeMap() : Arguments.fromBundle(appProperties));
                reactRoot.setRootViewTag(iAddRootView);
                reactRoot.b();
            }
            Intrinsics.checkNotNullParameter("pre_rootView.onAttachedToReactInstance", "sectionName");
            androidx.tracing.Trace.a(iAddRootView, "pre_rootView.onAttachedToReactInstance");
            UiThreadUtil.runOnUiThread(new androidx.core.content.res.a(iAddRootView, reactRoot));
            Trace.endSection();
        }
    }

    public final BridgeReactContext c(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        UIManager uIManagerCreateUIManager;
        ReactPackageTurboModuleManagerDelegate.Builder builder;
        FLog.a("ReactNative", "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        BridgeReactContext bridgeReactContext = new BridgeReactContext(this.o);
        DevSupportManager devSupportManager = this.f18463j;
        bridgeReactContext.setJSExceptionHandler(devSupportManager);
        ArrayList arrayList = this.f18462i;
        NativeModuleRegistryBuilder nativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(bridgeReactContext);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.f18462i) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ReactPackage reactPackage = (ReactPackage) it.next();
                    Intrinsics.checkNotNullParameter("createAndProcessCustomReactPackage", "sectionName");
                    Trace.beginSection(androidx.tracing.Trace.g("createAndProcessCustomReactPackage"));
                    try {
                        k(reactPackage, nativeModuleRegistryBuilder);
                        Trace.endSection();
                    } finally {
                        Trace.endSection();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        Intrinsics.checkNotNullParameter("buildNativeModuleRegistry", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("buildNativeModuleRegistry"));
        try {
            NativeModuleRegistry nativeModuleRegistry = new NativeModuleRegistry(nativeModuleRegistryBuilder.f18432a, nativeModuleRegistryBuilder.f18433b);
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
            CatalystInstanceImpl.Builder jSExceptionHandler = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(nativeModuleRegistry).setJSBundleLoader(jSBundleLoader).setJSExceptionHandler(devSupportManager);
            if (this.r == null && InspectorFlags.getFuseboxEnabled()) {
                this.r = new ReactInstanceManagerInspectorTarget(new InspectorTargetDelegateImpl(this));
            }
            CatalystInstanceImpl.Builder inspectorTarget = jSExceptionHandler.setInspectorTarget(this.r);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
            Intrinsics.checkNotNullParameter("createCatalystInstance", "sectionName");
            Trace.beginSection(androidx.tracing.Trace.g("createCatalystInstance"));
            try {
                CatalystInstanceImpl catalystInstanceImplBuild = inspectorTarget.build();
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
                bridgeReactContext.initializeWithInstance(catalystInstanceImplBuild);
                catalystInstanceImplBuild.getRuntimeScheduler();
                if (ReactNativeFeatureFlags.f18968a.useTurboModules() && (builder = this.x) != null) {
                    builder.c(this.f18462i);
                    builder.d(bridgeReactContext);
                    TurboModuleManager turboModuleManager = new TurboModuleManager(catalystInstanceImplBuild.getRuntimeExecutor(), builder.a(), catalystInstanceImplBuild.getJSCallInvokerHolder(), catalystInstanceImplBuild.getNativeMethodCallInvokerHolder());
                    catalystInstanceImplBuild.setTurboModuleRegistry(turboModuleManager);
                    Iterator<String> it2 = turboModuleManager.getEagerInitModuleNames().iterator();
                    while (it2.hasNext()) {
                        turboModuleManager.getModule(it2.next());
                    }
                }
                UIManagerProvider uIManagerProvider = this.w;
                if (uIManagerProvider != null && (uIManagerCreateUIManager = uIManagerProvider.createUIManager(bridgeReactContext)) != null) {
                    catalystInstanceImplBuild.setFabricUIManager(uIManagerCreateUIManager);
                    uIManagerCreateUIManager.initialize();
                    catalystInstanceImplBuild.setFabricUIManager(uIManagerCreateUIManager);
                }
                ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
                Intrinsics.checkNotNullParameter("runJSBundle", "sectionName");
                Trace.beginSection(androidx.tracing.Trace.g("runJSBundle"));
                catalystInstanceImplBuild.runJSBundle();
                return bridgeReactContext;
            } catch (Throwable th2) {
                Trace.endSection();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
                throw th2;
            }
        } catch (Throwable th3) {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
            throw th3;
        }
    }

    public final void d() {
        FLog.a("ReactInstanceManager", "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (this.t) {
            return;
        }
        this.t = true;
        FLog.a("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        NoopPrinter noopPrinter = NoopPrinter.f17189a;
        DebugOverlayTag debugOverlayTag = ReactDebugOverlayTags.f17190a;
        noopPrinter.a(debugOverlayTag, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (!this.f18464k || this.f18461h == null) {
            FLog.a("ReactInstanceManager", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
            noopPrinter.a(debugOverlayTag, "RNCore: load from BundleLoader");
            l(this.f18458e, this.f18460g);
        } else {
            DevSupportManager devSupportManager = this.f18463j;
            DeveloperSettings developerSettingsY = devSupportManager.y();
            if (this.f18460g == null) {
                devSupportManager.w();
            } else {
                devSupportManager.E(new AnonymousClass3(developerSettingsY));
            }
        }
    }

    public final ReactContext f() {
        ReactApplicationContext reactApplicationContext;
        synchronized (this.f18466m) {
            reactApplicationContext = this.n;
        }
        return reactApplicationContext;
    }

    public final List g(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        Intrinsics.checkNotNullParameter("createAllViewManagers", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("createAllViewManagers"));
        try {
            if (this.y == null) {
                synchronized (this.f18462i) {
                    try {
                        if (this.y == null) {
                            ArrayList arrayList = new ArrayList();
                            Iterator it = this.f18462i.iterator();
                            while (it.hasNext()) {
                                arrayList.addAll(((ReactPackage) it.next()).createViewManagers(reactApplicationContext));
                            }
                            this.y = arrayList;
                            Trace.endSection();
                            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
                            return arrayList;
                        }
                    } finally {
                    }
                }
            }
            ArrayList arrayList2 = this.y;
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            return arrayList2;
        } catch (Throwable th) {
            Trace.endSection();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
            throw th;
        }
    }

    public void h(Exception exc) {
        this.f18463j.handleException(exc);
    }

    public final void i() {
        UiThreadUtil.assertOnUiThread();
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.p;
        if (defaultHardwareBackBtnHandler != null) {
            defaultHardwareBackBtnHandler.j();
        }
    }

    public final synchronized void j(boolean z) {
        try {
            ReactContext reactContextF = f();
            if (reactContextF != null && (z || this.f18455b == LifecycleState.f18692b || this.f18455b == LifecycleState.f18691a)) {
                reactContextF.onHostResume(this.q);
            }
            this.f18455b = LifecycleState.f18693c;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        FLog.a("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        ReactContextInitParams reactContextInitParams = new ReactContextInitParams(javaScriptExecutorFactory, jSBundleLoader);
        if (this.f18457d == null) {
            m(reactContextInitParams);
        } else {
            this.f18456c = reactContextInitParams;
        }
    }

    public final void m(ReactContextInitParams reactContextInitParams) {
        FLog.a("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_START);
        synchronized (this.f18454a) {
            synchronized (this.f18466m) {
                try {
                    if (this.n != null) {
                        o(this.n);
                        this.n = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        this.f18457d = new Thread(null, new f(this, reactContextInitParams, 0), "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.f18457d.start();
    }

    public final void n(BridgeReactContext bridgeReactContext) {
        FLog.a("ReactNative", "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        Intrinsics.checkNotNullParameter("setupReactContext", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("setupReactContext"));
        synchronized (this.f18454a) {
            try {
                synchronized (this.f18466m) {
                    this.n = bridgeReactContext;
                }
                CatalystInstance catalystInstance = bridgeReactContext.getCatalystInstance();
                Assertions.c(catalystInstance);
                catalystInstance.initialize();
                this.f18463j.B(bridgeReactContext);
                CopyOnWriteArrayList copyOnWriteArrayList = this.v.f18431a;
                if (!copyOnWriteArrayList.contains(catalystInstance)) {
                    copyOnWriteArrayList.add(catalystInstance);
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
                Iterator it = this.f18454a.iterator();
                while (it.hasNext()) {
                    b((ReactRoot) it.next());
                }
                ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
            } catch (Throwable th) {
                throw th;
            }
        }
        UiThreadUtil.runOnUiThread(new p(this, (com.facebook.react.ReactInstanceEventListener[]) this.s.toArray(new com.facebook.react.ReactInstanceEventListener[this.s.size()]), bridgeReactContext, 1));
        bridgeReactContext.runOnJSQueueThread(new o(1));
        bridgeReactContext.runOnNativeModulesQueueThread(new o(2));
        Trace.endSection();
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.REACT_BRIDGE_LOADING_END);
    }

    public final void o(ReactApplicationContext reactApplicationContext) {
        FLog.a("ReactNative", "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.f18455b == LifecycleState.f18693c) {
            reactApplicationContext.onHostPause();
        }
        synchronized (this.f18454a) {
            try {
                Iterator it = this.f18454a.iterator();
                while (it.hasNext()) {
                    e((ReactRoot) it.next(), reactApplicationContext);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        MemoryPressureRouter memoryPressureRouter = this.v;
        memoryPressureRouter.f18431a.remove(reactApplicationContext.getCatalystInstance());
        reactApplicationContext.destroy();
        this.f18463j.C(reactApplicationContext);
    }
}
