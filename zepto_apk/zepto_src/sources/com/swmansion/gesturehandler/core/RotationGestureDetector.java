package com.swmansion.gesturehandler.core;

import android.view.MotionEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes4.dex */
public final class RotationGestureDetector {

    /* renamed from: a, reason: collision with root package name */
    public final RotationGestureHandler$gestureListener$1 f46759a;

    /* renamed from: b, reason: collision with root package name */
    public long f46760b;

    /* renamed from: c, reason: collision with root package name */
    public long f46761c;

    /* renamed from: d, reason: collision with root package name */
    public double f46762d;

    /* renamed from: e, reason: collision with root package name */
    public double f46763e;

    /* renamed from: f, reason: collision with root package name */
    public float f46764f;

    /* renamed from: g, reason: collision with root package name */
    public float f46765g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f46766h;

    /* renamed from: i, reason: collision with root package name */
    public final int[] f46767i = new int[2];

    /* renamed from: j, reason: collision with root package name */
    public boolean f46768j;

    @Metadata
    public interface OnRotationGestureListener {
    }

    public RotationGestureDetector(RotationGestureHandler$gestureListener$1 rotationGestureHandler$gestureListener$1) {
        this.f46759a = rotationGestureHandler$gestureListener$1;
    }

    public final float a() {
        return this.f46764f;
    }

    public final float b() {
        return this.f46765g;
    }

    public final void c(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        int[] iArr = this.f46767i;
        if (actionMasked == 0) {
            this.f46766h = false;
            iArr[0] = event.getPointerId(event.getActionIndex());
            iArr[1] = -1;
            return;
        }
        RotationGestureHandler$gestureListener$1 rotationGestureHandler$gestureListener$1 = this.f46759a;
        if (actionMasked == 1) {
            if (this.f46766h) {
                this.f46768j = false;
                this.f46766h = false;
                if (rotationGestureHandler$gestureListener$1 != null) {
                    Intrinsics.checkNotNullParameter(this, "detector");
                    rotationGestureHandler$gestureListener$1.f46769a.j();
                    return;
                }
                return;
            }
            return;
        }
        if (actionMasked == 2) {
            if (this.f46766h) {
                d(event);
                if (this.f46768j || rotationGestureHandler$gestureListener$1 == null) {
                    return;
                }
                Intrinsics.checkNotNullParameter(this, "detector");
                RotationGestureHandler rotationGestureHandler = rotationGestureHandler$gestureListener$1.f46769a;
                double d2 = rotationGestureHandler.N;
                double d3 = this.f46763e + d2;
                rotationGestureHandler.N = d3;
                long j2 = this.f46760b - this.f46761c;
                if (j2 > 0) {
                    rotationGestureHandler.O = (d3 - d2) / j2;
                }
                if (Math.abs(d3) < 0.08726646259971647d || rotationGestureHandler.f46719f != 2) {
                    return;
                }
                rotationGestureHandler.a(false);
                return;
            }
            return;
        }
        if (actionMasked == 5) {
            if (!this.f46766h || this.f46768j) {
                iArr[1] = event.getPointerId(event.getActionIndex());
                d(event);
            }
            if (this.f46766h) {
                return;
            }
            this.f46766h = true;
            this.f46761c = event.getEventTime();
            this.f46762d = Double.NaN;
            if (rotationGestureHandler$gestureListener$1 != null) {
                Intrinsics.checkNotNullParameter(this, "detector");
                return;
            }
            return;
        }
        if (actionMasked == 6 && this.f46766h) {
            int pointerId = event.getPointerId(event.getActionIndex());
            if (pointerId == iArr[0]) {
                iArr[0] = iArr[1];
                iArr[1] = -1;
                if (this.f46768j) {
                    return;
                }
                this.f46768j = true;
                return;
            }
            if (pointerId == iArr[1]) {
                iArr[1] = -1;
                if (this.f46768j) {
                    return;
                }
                this.f46768j = true;
            }
        }
    }

    public final void d(MotionEvent motionEvent) {
        this.f46761c = this.f46760b;
        this.f46760b = motionEvent.getEventTime();
        int[] iArr = this.f46767i;
        int iFindPointerIndex = motionEvent.findPointerIndex(iArr[0]);
        int iFindPointerIndex2 = motionEvent.findPointerIndex(iArr[1]);
        if (iFindPointerIndex == -1 || iFindPointerIndex2 == -1) {
            return;
        }
        float x = motionEvent.getX(iFindPointerIndex);
        float y = motionEvent.getY(iFindPointerIndex);
        float x2 = motionEvent.getX(iFindPointerIndex2);
        float y2 = motionEvent.getY(iFindPointerIndex2);
        this.f46764f = (x + x2) * 0.5f;
        this.f46765g = (y + y2) * 0.5f;
        double d2 = -Math.atan2(y2 - y, x2 - x);
        if (this.f46768j) {
            this.f46762d = d2;
            this.f46768j = false;
        }
        double d3 = Double.isNaN(this.f46762d) ? 0.0d : this.f46762d - d2;
        this.f46763e = d3;
        this.f46762d = d2;
        if (d3 > 3.141592653589793d) {
            this.f46763e = d3 - 3.141592653589793d;
        } else if (d3 < -3.141592653589793d) {
            this.f46763e = d3 + 3.141592653589793d;
        }
        double d4 = this.f46763e;
        if (d4 > 1.5707963267948966d) {
            this.f46763e = d4 - 3.141592653589793d;
        } else if (d4 < -1.5707963267948966d) {
            this.f46763e = d4 + 3.141592653589793d;
        }
    }
}
