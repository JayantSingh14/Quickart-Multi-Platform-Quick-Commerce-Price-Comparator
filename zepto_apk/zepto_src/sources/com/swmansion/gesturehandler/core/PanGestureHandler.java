package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.facebook.react.bridge.ReactApplicationContext;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    public float M;
    public float N;
    public final float O;
    public float P;
    public float d0;
    public float e0;
    public float f0;
    public float g0;
    public float h0;
    public float i0;
    public VelocityTracker j0;
    public boolean k0;
    public long l0;
    public Handler n0;
    public float Q = Float.MAX_VALUE;
    public float R = Float.MIN_VALUE;
    public float S = Float.MIN_VALUE;
    public float T = Float.MAX_VALUE;
    public float U = Float.MAX_VALUE;
    public float V = Float.MIN_VALUE;
    public float W = Float.MIN_VALUE;
    public float X = Float.MAX_VALUE;
    public float Y = Float.MAX_VALUE;
    public float Z = Float.MAX_VALUE;
    public float a0 = Float.MAX_VALUE;
    public int b0 = 1;
    public int c0 = 10;
    public final androidx.lifecycle.a m0 = new androidx.lifecycle.a(this, 7);
    public StylusData o0 = new StylusData(0);

    @Metadata
    public static final class Companion {
        public static final void a(VelocityTracker velocityTracker, MotionEvent motionEvent) {
            float rawX = motionEvent.getRawX() - motionEvent.getX();
            float rawY = motionEvent.getRawY() - motionEvent.getY();
            motionEvent.offsetLocation(rawX, rawY);
            Intrinsics.c(velocityTracker);
            velocityTracker.addMovement(motionEvent);
            motionEvent.offsetLocation(-rawX, -rawY);
        }
    }

    public PanGestureHandler(ReactApplicationContext reactApplicationContext) {
        this.P = Float.MIN_VALUE;
        Intrinsics.c(reactApplicationContext);
        int scaledTouchSlop = ViewConfiguration.get(reactApplicationContext).getScaledTouchSlop();
        float f2 = scaledTouchSlop * scaledTouchSlop;
        this.O = f2;
        this.P = f2;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void a(boolean z) {
        if (this.f46719f != 4) {
            z();
        }
        super.a(z);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void s() {
        Handler handler = this.n0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x012e  */
    @Override // com.swmansion.gesturehandler.core.GestureHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.MotionEvent r13, android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.core.PanGestureHandler.t(android.view.MotionEvent, android.view.MotionEvent):void");
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        Handler handler = this.n0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        VelocityTracker velocityTracker = this.j0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.j0 = null;
        }
        this.o0 = new StylusData(0);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void y() {
        super.y();
        this.Q = Float.MAX_VALUE;
        this.R = Float.MIN_VALUE;
        this.S = Float.MIN_VALUE;
        this.T = Float.MAX_VALUE;
        this.U = Float.MAX_VALUE;
        this.V = Float.MIN_VALUE;
        this.W = Float.MIN_VALUE;
        this.X = Float.MAX_VALUE;
        this.Y = Float.MAX_VALUE;
        this.Z = Float.MAX_VALUE;
        this.a0 = Float.MAX_VALUE;
        this.P = this.O;
        this.b0 = 1;
        this.c0 = 10;
        this.l0 = 0L;
        this.k0 = false;
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void z() {
        this.d0 = this.h0;
        this.e0 = this.i0;
    }
}
