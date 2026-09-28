package com.facebook.react;

import android.content.Intent;
import android.os.Bundle;
import android.os.Trace;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class ReactDelegate {

    /* renamed from: a, reason: collision with root package name */
    public final FragmentActivity f18445a;

    /* renamed from: b, reason: collision with root package name */
    public ReactRootView f18446b;

    /* renamed from: c, reason: collision with root package name */
    public final String f18447c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f18448d;

    /* renamed from: e, reason: collision with root package name */
    public final DoubleTapReloadRecognizer f18449e;

    /* renamed from: f, reason: collision with root package name */
    public final ReactNativeHost f18450f;

    /* renamed from: g, reason: collision with root package name */
    public final ReactHost f18451g;

    /* renamed from: h, reason: collision with root package name */
    public ReactSurface f18452h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f18453i;

    public ReactDelegate(FragmentActivity fragmentActivity, ReactHost reactHost, String str, Bundle bundle) {
        this.f18453i = ReactNativeFeatureFlags.f18968a.enableFabricRenderer();
        this.f18445a = fragmentActivity;
        this.f18447c = str;
        this.f18448d = bundle;
        this.f18449e = new DoubleTapReloadRecognizer();
        this.f18451g = reactHost;
    }

    public ReactRootView a() {
        ReactRootView reactRootView = new ReactRootView(this.f18445a);
        reactRootView.setIsFabric(this.f18453i);
        return reactRootView;
    }

    public final void b(String str) {
        boolean zEnableBridgelessArchitecture = ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture();
        Bundle bundle = this.f18448d;
        if (zEnableBridgelessArchitecture) {
            if (this.f18452h == null) {
                this.f18452h = this.f18451g.a(this.f18445a, str, bundle);
            }
            this.f18452h.start();
            return;
        }
        if (this.f18446b != null) {
            throw new IllegalStateException("Cannot loadApp while app is already running.");
        }
        ReactRootView reactRootViewA = a();
        this.f18446b = reactRootViewA;
        ReactInstanceManager reactInstanceManagerF = this.f18450f.f();
        reactRootViewA.getClass();
        Intrinsics.checkNotNullParameter("startReactApplication", "sectionName");
        Trace.beginSection(androidx.tracing.Trace.g("startReactApplication"));
        try {
            UiThreadUtil.assertOnUiThread();
            Assertions.b(reactRootViewA.f18497a == null, "This root view has already been attached to a catalyst instance manager");
            reactRootViewA.f18497a = reactInstanceManagerF;
            reactRootViewA.f18498b = str;
            reactRootViewA.f18499c = bundle;
            reactInstanceManagerF.d();
            if (ReactNativeFeatureFlags.f18968a.enableEagerRootViewAttachment()) {
                if (!reactRootViewA.f18508l) {
                    DisplayMetrics displayMetrics = reactRootViewA.getContext().getResources().getDisplayMetrics();
                    reactRootViewA.f18509m = View.MeasureSpec.makeMeasureSpec(displayMetrics.widthPixels, Integer.MIN_VALUE);
                    reactRootViewA.n = View.MeasureSpec.makeMeasureSpec(displayMetrics.heightPixels, Integer.MIN_VALUE);
                }
                reactRootViewA.e();
            }
        } finally {
            Trace.endSection();
        }
    }

    public final void c(int i2, int i3, Intent intent, boolean z) {
        ReactContext reactContextF;
        boolean zEnableBridgelessArchitecture = ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture();
        FragmentActivity fragmentActivity = this.f18445a;
        if (zEnableBridgelessArchitecture) {
            this.f18451g.f(fragmentActivity, i2, i3, intent);
            return;
        }
        ReactNativeHost reactNativeHost = this.f18450f;
        if (reactNativeHost.h() && z && (reactContextF = reactNativeHost.f().f()) != null) {
            reactContextF.onActivityResult(fragmentActivity, i2, i3, intent);
        }
    }

    public final void d() {
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            ReactSurface reactSurface = this.f18452h;
            if (reactSurface != null) {
                reactSurface.stop();
                this.f18452h = null;
            }
        } else {
            ReactRootView reactRootView = this.f18446b;
            if (reactRootView != null) {
                reactRootView.n();
                this.f18446b = null;
            }
        }
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            this.f18451g.d(this.f18445a);
            return;
        }
        if (this.f18450f.h()) {
            ReactInstanceManager reactInstanceManagerF = this.f18450f.f();
            if (this.f18445a == reactInstanceManagerF.q) {
                UiThreadUtil.assertOnUiThread();
                if (reactInstanceManagerF.f18464k) {
                    reactInstanceManagerF.f18463j.l(false);
                }
                synchronized (reactInstanceManagerF) {
                    try {
                        ReactContext reactContextF = reactInstanceManagerF.f();
                        if (reactContextF != null) {
                            if (reactInstanceManagerF.f18455b == LifecycleState.f18693c) {
                                reactContextF.onHostPause();
                                reactInstanceManagerF.f18455b = LifecycleState.f18692b;
                            }
                            if (reactInstanceManagerF.f18455b == LifecycleState.f18692b) {
                                reactContextF.onHostDestroy(false);
                            }
                        }
                        reactInstanceManagerF.f18455b = LifecycleState.f18691a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                reactInstanceManagerF.q = null;
            }
        }
    }

    public final void e() {
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            this.f18451g.g(this.f18445a);
            return;
        }
        if (this.f18450f.h()) {
            ReactInstanceManager reactInstanceManagerF = this.f18450f.f();
            FragmentActivity fragmentActivity = this.f18445a;
            if (reactInstanceManagerF.f18465l) {
                FragmentActivity fragmentActivity2 = reactInstanceManagerF.q;
                if (fragmentActivity2 == null) {
                    FLog.g("ReactInstanceManager", "ReactInstanceManager.onHostPause called with null activity, expected:".concat(fragmentActivity2.getClass().getSimpleName()));
                    for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                        FLog.g("ReactInstanceManager", stackTraceElement.toString());
                    }
                }
                Assertions.a(reactInstanceManagerF.q != null);
            }
            FragmentActivity fragmentActivity3 = reactInstanceManagerF.q;
            if (fragmentActivity3 != null) {
                Assertions.b(fragmentActivity == fragmentActivity3, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + reactInstanceManagerF.q.getClass().getSimpleName() + " Paused activity: " + fragmentActivity.getClass().getSimpleName());
            }
            UiThreadUtil.assertOnUiThread();
            reactInstanceManagerF.p = null;
            if (reactInstanceManagerF.f18464k) {
                reactInstanceManagerF.f18463j.l(false);
            }
            synchronized (reactInstanceManagerF) {
                try {
                    ReactContext reactContextF = reactInstanceManagerF.f();
                    if (reactContextF != null) {
                        if (reactInstanceManagerF.f18455b == LifecycleState.f18691a) {
                            reactContextF.onHostResume(reactInstanceManagerF.q);
                            reactContextF.onHostPause();
                        } else if (reactInstanceManagerF.f18455b == LifecycleState.f18693c) {
                            reactContextF.onHostPause();
                        }
                    }
                    reactInstanceManagerF.f18455b = LifecycleState.f18692b;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f() {
        FragmentActivity fragmentActivity = this.f18445a;
        if (!(fragmentActivity instanceof DefaultHardwareBackBtnHandler)) {
            throw new ClassCastException("Host Activity does not implement DefaultHardwareBackBtnHandler");
        }
        if (ReactNativeFeatureFlags.f18968a.enableBridgelessArchitecture()) {
            this.f18451g.h(fragmentActivity, (DefaultHardwareBackBtnHandler) fragmentActivity);
            return;
        }
        ReactNativeHost reactNativeHost = this.f18450f;
        if (reactNativeHost.h()) {
            final ReactInstanceManager reactInstanceManagerF = reactNativeHost.f();
            reactInstanceManagerF.getClass();
            UiThreadUtil.assertOnUiThread();
            reactInstanceManagerF.p = (DefaultHardwareBackBtnHandler) fragmentActivity;
            UiThreadUtil.assertOnUiThread();
            reactInstanceManagerF.q = fragmentActivity;
            if (reactInstanceManagerF.f18464k) {
                DevSupportManager devSupportManager = reactInstanceManagerF.f18463j;
                if (fragmentActivity != 0) {
                    final View decorView = fragmentActivity.getWindow().getDecorView();
                    WeakHashMap weakHashMap = ViewCompat.f3080a;
                    if (decorView.isAttachedToWindow()) {
                        devSupportManager.l(true);
                    } else {
                        decorView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.facebook.react.ReactInstanceManager.4

                            /* renamed from: a */
                            public final /* synthetic */ View f18470a;

                            public AnonymousClass4(final View decorView2) {
                                view = decorView2;
                            }

                            @Override // android.view.View.OnAttachStateChangeListener
                            public final void onViewAttachedToWindow(View view) {
                                view.removeOnAttachStateChangeListener(this);
                                ReactInstanceManager.this.f18463j.l(true);
                            }

                            @Override // android.view.View.OnAttachStateChangeListener
                            public final void onViewDetachedFromWindow(View view) {
                            }
                        });
                    }
                } else if (!reactInstanceManagerF.f18465l) {
                    devSupportManager.l(true);
                }
            }
            reactInstanceManagerF.j(false);
        }
    }

    public ReactDelegate(FragmentActivity fragmentActivity, ReactNativeHost reactNativeHost, String str, Bundle bundle, boolean z) {
        ReactNativeFeatureFlags.f18968a.enableFabricRenderer();
        this.f18453i = z;
        this.f18445a = fragmentActivity;
        this.f18447c = str;
        this.f18448d = bundle;
        this.f18449e = new DoubleTapReloadRecognizer();
        this.f18450f = reactNativeHost;
    }
}
