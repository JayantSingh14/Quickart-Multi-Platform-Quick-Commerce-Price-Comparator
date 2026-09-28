package com.facebook.react;

import android.os.Process;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.bridge.BridgeReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18957a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ReactInstanceManager f18958b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f18959c;

    public /* synthetic */ f(ReactInstanceManager reactInstanceManager, Object obj, int i2) {
        this.f18957a = i2;
        this.f18958b = reactInstanceManager;
        this.f18959c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() throws SecurityException, IllegalArgumentException {
        switch (this.f18957a) {
            case 0:
                ReactInstanceManager reactInstanceManager = this.f18958b;
                ReactInstanceManager.ReactContextInitParams reactContextInitParams = (ReactInstanceManager.ReactContextInitParams) this.f18959c;
                reactInstanceManager.getClass();
                ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
                synchronized (reactInstanceManager.u) {
                    while (reactInstanceManager.u.booleanValue()) {
                        try {
                            reactInstanceManager.u.wait();
                        } catch (InterruptedException unused) {
                        }
                    }
                }
                reactInstanceManager.t = true;
                try {
                    Process.setThreadPriority(-4);
                    ReactMarker.logMarker(ReactMarkerConstants.VM_INIT);
                    BridgeReactContext bridgeReactContextC = reactInstanceManager.c(reactContextInitParams.f18474a.create(), reactContextInitParams.f18475b);
                    try {
                        reactInstanceManager.f18457d = null;
                        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
                        d dVar = new d(reactInstanceManager, 1);
                        bridgeReactContextC.runOnNativeModulesQueueThread(new f(reactInstanceManager, bridgeReactContextC, 1));
                        UiThreadUtil.runOnUiThread(dVar);
                        return;
                    } catch (Exception e2) {
                        reactInstanceManager.f18463j.handleException(e2);
                        return;
                    }
                } catch (Exception e3) {
                    reactInstanceManager.t = false;
                    reactInstanceManager.f18457d = null;
                    reactInstanceManager.f18463j.handleException(e3);
                    return;
                }
            default:
                BridgeReactContext bridgeReactContext = (BridgeReactContext) this.f18959c;
                ReactInstanceManager reactInstanceManager2 = this.f18958b;
                reactInstanceManager2.getClass();
                try {
                    reactInstanceManager2.n(bridgeReactContext);
                    return;
                } catch (Exception e4) {
                    reactInstanceManager2.f18463j.handleException(e4);
                    return;
                }
        }
    }
}
