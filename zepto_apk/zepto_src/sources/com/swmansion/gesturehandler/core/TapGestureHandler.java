package com.swmansion.gesturehandler.core;

import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class TapGestureHandler extends GestureHandler<TapGestureHandler> {
    public float U;
    public float V;
    public float W;
    public float X;
    public float Y;
    public float Z;
    public Handler a0;
    public int b0;
    public float M = Float.MIN_VALUE;
    public float N = Float.MIN_VALUE;
    public float O = Float.MIN_VALUE;
    public long P = 500;
    public long Q = 200;
    public int R = 1;
    public int S = 1;
    public int T = 1;
    public final androidx.constraintlayout.helper.widget.a c0 = new androidx.constraintlayout.helper.widget.a(this, 28);

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    public TapGestureHandler() {
        this.y = true;
    }

    public final void H() {
        Handler handler = this.a0;
        if (handler == null) {
            this.a0 = new Handler(Looper.getMainLooper());
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        Handler handler2 = this.a0;
        Intrinsics.c(handler2);
        handler2.postDelayed(this.c0, this.P);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void a(boolean z) {
        super.a(z);
        j();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void s() {
        Handler handler = this.a0;
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
            int actionMasked = sourceEvent.getActionMasked();
            if (i2 == 0) {
                this.W = 0.0f;
                this.X = 0.0f;
                this.U = GestureUtils.b(sourceEvent, true);
                this.V = GestureUtils.c(sourceEvent, true);
            }
            if (actionMasked == 5 || actionMasked == 6) {
                this.W = (this.Y - this.U) + this.W;
                this.X = (this.Z - this.V) + this.X;
                this.Y = GestureUtils.b(sourceEvent, true);
                float fC = GestureUtils.c(sourceEvent, true);
                this.Z = fC;
                this.U = this.Y;
                this.V = fC;
            } else {
                this.Y = GestureUtils.b(sourceEvent, true);
                this.Z = GestureUtils.c(sourceEvent, true);
            }
            if (this.T < sourceEvent.getPointerCount()) {
                this.T = sourceEvent.getPointerCount();
            }
            float f2 = (this.Y - this.U) + this.W;
            if (this.M == Float.MIN_VALUE || Math.abs(f2) <= this.M) {
                float f3 = (this.Z - this.V) + this.X;
                if (this.N == Float.MIN_VALUE || Math.abs(f3) <= this.N) {
                    float f4 = (f2 * f2) + (f3 * f3);
                    float f5 = this.O;
                    if (f5 == Float.MIN_VALUE || f4 <= f5) {
                        if (i2 == 0) {
                            if (actionMasked == 0 || actionMasked == 11) {
                                d();
                            }
                            H();
                            return;
                        }
                        if (i2 == 2) {
                            if (actionMasked != 0) {
                                if (actionMasked != 1) {
                                    if (actionMasked != 11) {
                                        if (actionMasked != 12) {
                                            return;
                                        }
                                    }
                                }
                                Handler handler = this.a0;
                                if (handler == null) {
                                    this.a0 = new Handler(Looper.getMainLooper());
                                } else {
                                    handler.removeCallbacksAndMessages(null);
                                }
                                int i3 = this.b0 + 1;
                                this.b0 = i3;
                                if (i3 == this.R && this.T >= this.S) {
                                    a(false);
                                    return;
                                }
                                Handler handler2 = this.a0;
                                Intrinsics.c(handler2);
                                handler2.postDelayed(this.c0, this.Q);
                                return;
                            }
                            H();
                            return;
                        }
                        return;
                    }
                }
            }
            l();
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        this.b0 = 0;
        this.T = 0;
        Handler handler = this.a0;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void y() {
        super.y();
        this.M = Float.MIN_VALUE;
        this.N = Float.MIN_VALUE;
        this.O = Float.MIN_VALUE;
        this.P = 500L;
        this.Q = 200L;
        this.R = 1;
        this.S = 1;
    }
}
