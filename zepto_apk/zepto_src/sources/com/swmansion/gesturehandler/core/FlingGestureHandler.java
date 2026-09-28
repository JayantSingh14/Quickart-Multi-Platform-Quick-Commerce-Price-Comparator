package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FlingGestureHandler extends GestureHandler<FlingGestureHandler> {
    public static final double U = GestureUtils.a(30.0d);
    public static final double V = GestureUtils.a(60.0d);
    public static final /* synthetic */ int W = 0;
    public Handler Q;
    public int R;
    public VelocityTracker T;
    public int M = 1;
    public int N = 1;
    public final long O = 800;
    public final long P = 2000;
    public final androidx.constraintlayout.helper.widget.a S = new androidx.constraintlayout.helper.widget.a(this, 25);

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean H(android.view.MotionEvent r11) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.FlingGestureHandler.H(android.view.MotionEvent):boolean");
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void a(boolean z) {
        super.a(z);
        j();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void s() {
        Handler handler = this.Q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (B(sourceEvent)) {
            int i2 = this.f46719f;
            if (i2 == 0) {
                this.T = VelocityTracker.obtain();
                d();
                this.R = 1;
                Handler handler = this.Q;
                if (handler == null) {
                    this.Q = new Handler(Looper.getMainLooper());
                } else {
                    handler.removeCallbacksAndMessages(null);
                }
                Handler handler2 = this.Q;
                Intrinsics.c(handler2);
                handler2.postDelayed(this.S, this.O);
            }
            if (i2 == 2) {
                H(sourceEvent);
                if (sourceEvent.getPointerCount() > this.R) {
                    this.R = sourceEvent.getPointerCount();
                }
                if (sourceEvent.getActionMasked() != 1 || H(sourceEvent)) {
                    return;
                }
                l();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        VelocityTracker velocityTracker = this.T;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.T = null;
        Handler handler = this.Q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void y() {
        super.y();
        this.M = 1;
        this.N = 1;
    }
}
