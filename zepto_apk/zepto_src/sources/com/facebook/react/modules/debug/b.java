package com.facebook.react.modules.debug;

import android.view.Choreographer;

/* loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f19098a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FpsDebugFrameCallback f19099b;

    public /* synthetic */ b(FpsDebugFrameCallback fpsDebugFrameCallback, int i2) {
        this.f19098a = i2;
        this.f19099b = fpsDebugFrameCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f19098a) {
            case 0:
                Choreographer choreographer = Choreographer.getInstance();
                FpsDebugFrameCallback fpsDebugFrameCallback = this.f19099b;
                fpsDebugFrameCallback.f19086b = choreographer;
                if (choreographer != null) {
                    choreographer.postFrameCallback(fpsDebugFrameCallback);
                    break;
                }
                break;
            default:
                Choreographer choreographer2 = Choreographer.getInstance();
                FpsDebugFrameCallback fpsDebugFrameCallback2 = this.f19099b;
                fpsDebugFrameCallback2.f19086b = choreographer2;
                if (choreographer2 != null) {
                    choreographer2.removeFrameCallback(fpsDebugFrameCallback2);
                    break;
                }
                break;
        }
    }
}
