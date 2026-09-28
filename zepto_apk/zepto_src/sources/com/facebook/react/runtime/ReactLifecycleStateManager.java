package com.facebook.react.runtime;

import com.facebook.infer.annotation.Nullsafe;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.LifecycleState;

@Nullsafe
/* loaded from: classes3.dex */
class ReactLifecycleStateManager {

    /* renamed from: a, reason: collision with root package name */
    public LifecycleState f19276a = LifecycleState.f18691a;

    /* renamed from: b, reason: collision with root package name */
    public final BridgelessReactStateTracker f19277b;

    public ReactLifecycleStateManager(BridgelessReactStateTracker bridgelessReactStateTracker) {
        this.f19277b = bridgelessReactStateTracker;
    }

    public final void a(ReactContext reactContext) {
        if (reactContext != null) {
            LifecycleState lifecycleState = this.f19276a;
            LifecycleState lifecycleState2 = LifecycleState.f18692b;
            BridgelessReactStateTracker bridgelessReactStateTracker = this.f19277b;
            if (lifecycleState == lifecycleState2) {
                bridgelessReactStateTracker.a("ReactContext.onHostDestroy()");
                reactContext.onHostDestroy();
            } else if (lifecycleState == LifecycleState.f18693c) {
                bridgelessReactStateTracker.a("ReactContext.onHostPause()");
                reactContext.onHostPause();
                bridgelessReactStateTracker.a("ReactContext.onHostDestroy()");
                reactContext.onHostDestroy();
            }
        }
        this.f19276a = LifecycleState.f18691a;
    }
}
