package com.appsflyer.internal;

import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.BridgeReactContext;
import com.facebook.react.common.LifecycleState;
import com.unistyles.UnistylesModule;
import in.juspay.hypersdk.analytics.LogConstants;
import io.sentry.PropagationContext;
import io.sentry.Scope;
import io.sentry.SpanContext;
import io.sentry.cache.PersistingScopeObserver;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15336a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15337b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15338c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f15339d;

    public /* synthetic */ p(Object obj, Object obj2, Object obj3, int i2) {
        this.f15336a = i2;
        this.f15337b = obj;
        this.f15338c = obj2;
        this.f15339d = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f15336a) {
            case 0:
                ((AFj1sSDK) this.f15337b).getMonetizationNetwork((AFi1aSDK) this.f15338c, (Runnable) this.f15339d);
                return;
            case 1:
                ReactInstanceManager reactInstanceManager = (ReactInstanceManager) this.f15337b;
                ReactInstanceEventListener[] reactInstanceEventListenerArr = (ReactInstanceEventListener[]) this.f15338c;
                BridgeReactContext bridgeReactContext = (BridgeReactContext) this.f15339d;
                synchronized (reactInstanceManager) {
                    if (reactInstanceManager.f18455b == LifecycleState.f18693c) {
                        reactInstanceManager.j(true);
                    }
                }
                for (ReactInstanceEventListener reactInstanceEventListener : reactInstanceEventListenerArr) {
                    if (reactInstanceEventListener != null) {
                        reactInstanceEventListener.a(bridgeReactContext);
                    }
                }
                return;
            case 2:
                UnistylesModule.onConfigChange$lambda$0((UnistylesModule) this.f15337b, (String) this.f15338c, (String) this.f15339d);
                return;
            default:
                Charset charset = PersistingScopeObserver.f52680c;
                PersistingScopeObserver persistingScopeObserver = (PersistingScopeObserver) this.f15337b;
                SpanContext spanContext = (SpanContext) this.f15338c;
                if (spanContext != null) {
                    persistingScopeObserver.p(spanContext, "trace.json");
                    return;
                }
                persistingScopeObserver.getClass();
                PropagationContext propagationContext = ((Scope) this.f15339d).q;
                SpanContext spanContext2 = new SpanContext(propagationContext.f51748a, propagationContext.f51749b, LogConstants.DEFAULT_CHANNEL, null, null);
                spanContext2.f51929i = "auto";
                persistingScopeObserver.p(spanContext2, "trace.json");
                return;
        }
    }
}
