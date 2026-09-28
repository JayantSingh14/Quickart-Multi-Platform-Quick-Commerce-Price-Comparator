package com.facebook.react;

import androidx.media3.exoplayer.analytics.p;
import com.facebook.common.logging.FLog;
import com.facebook.hermes.reactexecutor.HermesExecutor;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DefaultDevSupportManagerFactory;
import com.facebook.react.jscexecutor.JSCExecutor;
import com.facebook.react.jscexecutor.JSCExecutorFactory;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.soloader.SoLoader;
import com.zeptoconsumerapp.MainApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class ReactNativeHost {

    /* renamed from: a, reason: collision with root package name */
    public final MainApplication f18489a;

    /* renamed from: b, reason: collision with root package name */
    public ReactInstanceManager f18490b;

    /* renamed from: com.facebook.react.ReactNativeHost$1, reason: invalid class name */
    class AnonymousClass1 implements SurfaceDelegateFactory {
    }

    public ReactNativeHost(MainApplication mainApplication) {
        this.f18489a = mainApplication;
    }

    public final ReactInstanceManager a() {
        ArrayList arrayList;
        JavaScriptExecutorFactory jSCExecutorFactory;
        JavaScriptExecutorFactory javaScriptExecutorFactory;
        JSBundleLoader jSBundleLoaderCreateAssetLoader;
        String str;
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        ReactInstanceManagerBuilder reactInstanceManagerBuilder = new ReactInstanceManagerBuilder();
        reactInstanceManagerBuilder.f18480e = this.f18489a;
        reactInstanceManagerBuilder.f18479d = d();
        reactInstanceManagerBuilder.f18481f = false;
        boolean z = true;
        reactInstanceManagerBuilder.f18482g = true;
        reactInstanceManagerBuilder.f18488m = new AnonymousClass1();
        reactInstanceManagerBuilder.f18486k = g();
        reactInstanceManagerBuilder.f18483h = LifecycleState.f18691a;
        JavaScriptExecutorFactory jSCExecutorFactory2 = null;
        reactInstanceManagerBuilder.f18487l = null;
        reactInstanceManagerBuilder.n = c();
        Iterator it = e().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            arrayList = reactInstanceManagerBuilder.f18476a;
            if (!zHasNext) {
                break;
            }
            arrayList.add((ReactPackage) it.next());
        }
        String strB = b();
        if (strB == null) {
            reactInstanceManagerBuilder.f18477b = "assets://".concat("index.android.bundle");
            reactInstanceManagerBuilder.f18478c = null;
        } else if (strB.startsWith("assets://")) {
            reactInstanceManagerBuilder.f18477b = strB;
            reactInstanceManagerBuilder.f18478c = null;
        } else {
            reactInstanceManagerBuilder.f18478c = JSBundleLoader.createFileLoader(strB);
            reactInstanceManagerBuilder.f18477b = null;
        }
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        Assertions.d(reactInstanceManagerBuilder.f18480e, "Application property has not been set with this builder");
        if (reactInstanceManagerBuilder.f18483h == LifecycleState.f18693c) {
            Assertions.d(null, "Activity needs to be set if initial lifecycle state is resumed");
        }
        Assertions.b((!reactInstanceManagerBuilder.f18481f && reactInstanceManagerBuilder.f18477b == null && reactInstanceManagerBuilder.f18478c == null) ? false : true, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
        if (reactInstanceManagerBuilder.f18479d == null && reactInstanceManagerBuilder.f18477b == null && reactInstanceManagerBuilder.f18478c == null) {
            z = false;
        }
        Assertions.b(z, "Either MainModulePath or JS Bundle File needs to be provided");
        String packageName = reactInstanceManagerBuilder.f18480e.getPackageName();
        String strA = AndroidInfoHelpers.a();
        MainApplication mainApplication = reactInstanceManagerBuilder.f18480e;
        try {
            SoLoader.f(0, mainApplication.getApplicationContext());
            JSEngineResolutionAlgorithm jSEngineResolutionAlgorithm = reactInstanceManagerBuilder.n;
            if (jSEngineResolutionAlgorithm == null) {
                try {
                    try {
                        HermesExecutor.a();
                        jSCExecutorFactory = new HermesExecutorFactory();
                    } catch (UnsatisfiedLinkError e2) {
                        FLog.g("ReactInstanceManagerBuilder", "Unable to load neither the Hermes nor the JSC native library. Your application is not built correctly and will fail to execute");
                        if (e2.getMessage().contains("__cxa_bad_typeid")) {
                            throw e2;
                        }
                    }
                } catch (UnsatisfiedLinkError unused) {
                    JSCExecutor.b();
                    jSCExecutorFactory = new JSCExecutorFactory(packageName, strA);
                }
                javaScriptExecutorFactory = jSCExecutorFactory;
                jSBundleLoaderCreateAssetLoader = reactInstanceManagerBuilder.f18478c;
                if (jSBundleLoaderCreateAssetLoader == null && (str = reactInstanceManagerBuilder.f18477b) != null) {
                    jSBundleLoaderCreateAssetLoader = JSBundleLoader.createAssetLoader(reactInstanceManagerBuilder.f18480e, str, false);
                }
                JSBundleLoader jSBundleLoader = jSBundleLoaderCreateAssetLoader;
                String str2 = reactInstanceManagerBuilder.f18479d;
                boolean z2 = reactInstanceManagerBuilder.f18481f;
                DefaultDevSupportManagerFactory defaultDevSupportManagerFactory = new DefaultDevSupportManagerFactory();
                boolean z3 = reactInstanceManagerBuilder.f18482g;
                LifecycleState lifecycleState = reactInstanceManagerBuilder.f18483h;
                Assertions.d(lifecycleState, "Initial lifecycle state was not set");
                return new ReactInstanceManager(mainApplication, javaScriptExecutorFactory, jSBundleLoader, str2, arrayList, z2, defaultDevSupportManagerFactory, z3, lifecycleState, reactInstanceManagerBuilder.f18484i, reactInstanceManagerBuilder.f18485j, reactInstanceManagerBuilder.f18486k, reactInstanceManagerBuilder.f18487l, reactInstanceManagerBuilder.f18488m);
            }
            if (jSEngineResolutionAlgorithm == JSEngineResolutionAlgorithm.f18425b) {
                HermesExecutor.a();
                jSCExecutorFactory2 = new HermesExecutorFactory();
            } else {
                JSCExecutor.b();
                jSCExecutorFactory2 = new JSCExecutorFactory(packageName, strA);
            }
            javaScriptExecutorFactory = jSCExecutorFactory2;
            jSBundleLoaderCreateAssetLoader = reactInstanceManagerBuilder.f18478c;
            if (jSBundleLoaderCreateAssetLoader == null) {
                jSBundleLoaderCreateAssetLoader = JSBundleLoader.createAssetLoader(reactInstanceManagerBuilder.f18480e, str, false);
            }
            JSBundleLoader jSBundleLoader2 = jSBundleLoaderCreateAssetLoader;
            String str22 = reactInstanceManagerBuilder.f18479d;
            boolean z22 = reactInstanceManagerBuilder.f18481f;
            DefaultDevSupportManagerFactory defaultDevSupportManagerFactory2 = new DefaultDevSupportManagerFactory();
            boolean z32 = reactInstanceManagerBuilder.f18482g;
            LifecycleState lifecycleState2 = reactInstanceManagerBuilder.f18483h;
            Assertions.d(lifecycleState2, "Initial lifecycle state was not set");
            return new ReactInstanceManager(mainApplication, javaScriptExecutorFactory, jSBundleLoader2, str22, arrayList, z22, defaultDevSupportManagerFactory2, z32, lifecycleState2, reactInstanceManagerBuilder.f18484i, reactInstanceManagerBuilder.f18485j, reactInstanceManagerBuilder.f18486k, reactInstanceManagerBuilder.f18487l, reactInstanceManagerBuilder.f18488m);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    public String b() {
        return null;
    }

    public JSEngineResolutionAlgorithm c() {
        return null;
    }

    public String d() {
        return "index.android";
    }

    public abstract ArrayList e();

    public final synchronized ReactInstanceManager f() {
        try {
            if (this.f18490b == null) {
                ReactMarker.logMarker(ReactMarkerConstants.INIT_REACT_RUNTIME_START);
                ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
                this.f18490b = a();
                ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f18490b;
    }

    public UIManagerProvider g() {
        return new p(25);
    }

    public final synchronized boolean h() {
        return this.f18490b != null;
    }
}
