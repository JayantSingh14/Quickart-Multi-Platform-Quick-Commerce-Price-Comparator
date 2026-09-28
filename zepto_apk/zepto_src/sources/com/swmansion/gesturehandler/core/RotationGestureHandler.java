package com.swmansion.gesturehandler.core;

import android.graphics.PointF;
import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class RotationGestureHandler extends GestureHandler<RotationGestureHandler> {
    public RotationGestureDetector M;
    public double N;
    public double O;
    public float P = Float.NaN;
    public float Q = Float.NaN;
    public final RotationGestureHandler$gestureListener$1 R;

    @Metadata
    /* loaded from: classes4.dex */
    public static final class Companion {
    }

    public RotationGestureHandler() {
        this.y = false;
        this.R = new RotationGestureHandler$gestureListener$1(this);
    }

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
            z();
            this.M = new RotationGestureDetector(this.R);
            this.P = event.getX();
            this.Q = event.getY();
            d();
        }
        RotationGestureDetector rotationGestureDetector = this.M;
        if (rotationGestureDetector != null) {
            rotationGestureDetector.c(sourceEvent);
        }
        RotationGestureDetector rotationGestureDetector2 = this.M;
        if (rotationGestureDetector2 != null) {
            PointF point = new PointF(rotationGestureDetector2.a(), rotationGestureDetector2.b());
            Intrinsics.checkNotNullParameter(point, "point");
            GestureHandlerOrchestrator gestureHandlerOrchestrator = this.A;
            if (gestureHandlerOrchestrator != null) {
                gestureHandlerOrchestrator.g(this.f46718e, point);
            } else {
                point.x = Float.NaN;
                point.y = Float.NaN;
            }
            this.P = point.x;
            this.Q = point.y;
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
        this.M = null;
        this.P = Float.NaN;
        this.Q = Float.NaN;
        z();
    }

    @Override // com.swmansion.gesturehandler.core.GestureHandler
    public final void z() {
        this.O = 0.0d;
        this.N = 0.0d;
    }
}
