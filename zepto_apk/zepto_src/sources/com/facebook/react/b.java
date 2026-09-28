package com.facebook.react;

import com.facebook.react.views.debuggingoverlay.DebuggingOverlayManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager;
import com.swmansion.gesturehandler.react.RNGestureHandlerRootViewManager;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Provider {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18676a;

    public /* synthetic */ b(int i2) {
        this.f18676a = i2;
    }

    @Override // javax.inject.Provider
    public final Object get() {
        switch (this.f18676a) {
            case 0:
                return new DebuggingOverlayManager();
            case 1:
                return new RNGestureHandlerRootViewManager();
            default:
                return new RNGestureHandlerButtonViewManager();
        }
    }
}
