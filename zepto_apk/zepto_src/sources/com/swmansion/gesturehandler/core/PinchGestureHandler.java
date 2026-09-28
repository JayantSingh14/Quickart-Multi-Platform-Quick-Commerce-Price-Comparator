package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PinchGestureHandler extends GestureHandler<PinchGestureHandler> {
    public double M;
    public double N;
    public ScaleGestureDetector Q;
    public float R;
    public float S;
    public float O = Float.NaN;
    public float P = Float.NaN;
    public final PinchGestureHandler$gestureListener$1 T = new PinchGestureHandler$gestureListener$1(this);

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void a(boolean z) {
        if (this.f46719f != 4) {
            z();
        }
        super.a(z);
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void t(MotionEvent event, MotionEvent sourceEvent) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(sourceEvent, "sourceEvent");
        if (this.f46719f == 0) {
            View view = this.f46718e;
            Intrinsics.c(view);
            Context context = view.getContext();
            z();
            this.Q = new ScaleGestureDetector(context, this.T);
            this.S = ViewConfiguration.get(context).getScaledTouchSlop();
            this.O = event.getX();
            this.P = event.getY();
            d();
        }
        ScaleGestureDetector scaleGestureDetector = this.Q;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.d(sourceEvent);
        }
        ScaleGestureDetector scaleGestureDetector2 = this.Q;
        if (scaleGestureDetector2 != null) {
            PointF point = new PointF(scaleGestureDetector2.a(), scaleGestureDetector2.b());
            Intrinsics.checkNotNullParameter(point, "point");
            GestureHandlerOrchestrator gestureHandlerOrchestrator = this.A;
            if (gestureHandlerOrchestrator != null) {
                gestureHandlerOrchestrator.g(this.f46718e, point);
            } else {
                point.x = Float.NaN;
                point.y = Float.NaN;
            }
            this.O = point.x;
            this.P = point.y;
        }
        if (sourceEvent.getActionMasked() == 1) {
            if (this.f46719f == 4) {
                j();
            } else {
                l();
            }
        }
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void w() {
        this.Q = null;
        this.O = Float.NaN;
        this.P = Float.NaN;
        z();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void z() {
        this.N = 0.0d;
        this.M = 1.0d;
    }
}
