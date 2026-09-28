package com.swmansion.gesturehandler.core;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class ScaleGestureDetector {

    /* renamed from: a, reason: collision with root package name */
    public final PinchGestureHandler$gestureListener$1 f46770a;

    /* renamed from: b, reason: collision with root package name */
    public float f46771b;

    /* renamed from: c, reason: collision with root package name */
    public float f46772c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f46773d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f46774e;

    /* renamed from: f, reason: collision with root package name */
    public float f46775f;

    /* renamed from: g, reason: collision with root package name */
    public float f46776g;

    /* renamed from: h, reason: collision with root package name */
    public float f46777h;

    /* renamed from: i, reason: collision with root package name */
    public long f46778i;

    /* renamed from: j, reason: collision with root package name */
    public long f46779j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f46780k;

    /* renamed from: l, reason: collision with root package name */
    public final int f46781l;

    /* renamed from: m, reason: collision with root package name */
    public float f46782m;
    public float n;
    public int o = 0;
    public final GestureDetector p;
    public boolean q;

    public interface OnScaleGestureListener {
    }

    public static class SimpleOnScaleGestureListener implements OnScaleGestureListener {
    }

    public ScaleGestureDetector(Context context, PinchGestureHandler$gestureListener$1 pinchGestureHandler$gestureListener$1) {
        this.f46770a = pinchGestureHandler$gestureListener$1;
        this.f46781l = ViewConfiguration.get(context).getScaledTouchSlop() * 2;
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (i2 > 18) {
            this.f46773d = true;
            if (this.p == null) {
                this.p = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.swmansion.gesturehandler.core.ScaleGestureDetector.1
                    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                    public final boolean onDoubleTap(MotionEvent motionEvent) {
                        float x = motionEvent.getX();
                        ScaleGestureDetector scaleGestureDetector = ScaleGestureDetector.this;
                        scaleGestureDetector.f46782m = x;
                        scaleGestureDetector.n = motionEvent.getY();
                        scaleGestureDetector.o = 1;
                        return true;
                    }
                }, null);
            }
        }
        if (i2 > 22) {
            this.f46774e = true;
        }
    }

    public final float a() {
        return this.f46771b;
    }

    public final float b() {
        return this.f46772c;
    }

    public final boolean c() {
        return this.o != 0;
    }

    public final void d(MotionEvent motionEvent) {
        float f2;
        float f3;
        this.f46778i = motionEvent.getEventTime();
        int actionMasked = motionEvent.getActionMasked();
        if (this.f46773d) {
            this.p.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        boolean z = true;
        boolean z2 = (motionEvent.getButtonState() & 32) != 0;
        boolean z3 = this.o == 2 && !z2;
        boolean z4 = actionMasked == 1 || actionMasked == 3 || z3;
        PinchGestureHandler$gestureListener$1 pinchGestureHandler$gestureListener$1 = this.f46770a;
        if (actionMasked == 0 || z4) {
            if (this.f46780k) {
                pinchGestureHandler$gestureListener$1.getClass();
                Intrinsics.checkNotNullParameter(this, "detector");
                this.f46780k = false;
                this.f46777h = 0.0f;
                this.o = 0;
            } else if (c() && z4) {
                this.f46780k = false;
                this.f46777h = 0.0f;
                this.o = 0;
            }
            if (z4) {
                return;
            }
        }
        if (!this.f46780k && this.f46774e && !c() && !z4 && z2) {
            this.f46782m = motionEvent.getX();
            this.n = motionEvent.getY();
            this.o = 2;
            this.f46777h = 0.0f;
        }
        boolean z5 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z3;
        boolean z6 = actionMasked == 6;
        int actionIndex = z6 ? motionEvent.getActionIndex() : -1;
        int i2 = z6 ? pointerCount - 1 : pointerCount;
        if (c()) {
            f3 = this.f46782m;
            f2 = this.n;
            if (motionEvent.getY() < f2) {
                this.q = true;
            } else {
                this.q = false;
            }
        } else {
            float x = 0.0f;
            float y = 0.0f;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (actionIndex != i3) {
                    x = motionEvent.getX(i3) + x;
                    y = motionEvent.getY(i3) + y;
                }
            }
            float f4 = i2;
            float f5 = x / f4;
            f2 = y / f4;
            f3 = f5;
        }
        float fAbs = 0.0f;
        float fAbs2 = 0.0f;
        for (int i4 = 0; i4 < pointerCount; i4++) {
            if (actionIndex != i4) {
                fAbs = Math.abs(motionEvent.getX(i4) - f3) + fAbs;
                fAbs2 = Math.abs(motionEvent.getY(i4) - f2) + fAbs2;
            }
        }
        float f6 = i2;
        float f7 = (fAbs / f6) * 2.0f;
        float fHypot = 2.0f * (fAbs2 / f6);
        if (!c()) {
            fHypot = (float) Math.hypot(f7, fHypot);
        }
        boolean z7 = this.f46780k;
        this.f46771b = f3;
        this.f46772c = f2;
        if (!c() && this.f46780k && (fHypot < 0 || z5)) {
            pinchGestureHandler$gestureListener$1.getClass();
            Intrinsics.checkNotNullParameter(this, "detector");
            this.f46780k = false;
            this.f46777h = fHypot;
        }
        if (z5) {
            this.f46775f = fHypot;
            this.f46776g = fHypot;
            this.f46777h = fHypot;
        }
        boolean zC = c();
        int i5 = this.f46781l;
        int i6 = zC ? i5 : 0;
        if (!this.f46780k && fHypot >= i6 && (z7 || Math.abs(fHypot - this.f46777h) > i5)) {
            this.f46775f = fHypot;
            this.f46776g = fHypot;
            this.f46779j = this.f46778i;
            pinchGestureHandler$gestureListener$1.getClass();
            Intrinsics.checkNotNullParameter(this, "detector");
            pinchGestureHandler$gestureListener$1.f46752a.R = this.f46775f;
            this.f46780k = true;
        }
        if (actionMasked == 2) {
            this.f46775f = fHypot;
            if (this.f46780k) {
                pinchGestureHandler$gestureListener$1.getClass();
                Intrinsics.checkNotNullParameter(this, "detector");
                PinchGestureHandler pinchGestureHandler = pinchGestureHandler$gestureListener$1.f46752a;
                double d2 = pinchGestureHandler.M;
                float f8 = 1.0f;
                if (c()) {
                    boolean z8 = this.q;
                    if ((!z8 || this.f46775f >= this.f46776g) && (z8 || this.f46775f <= this.f46776g)) {
                        z = false;
                    }
                    float fAbs3 = Math.abs(1.0f - (this.f46775f / this.f46776g)) * 0.5f;
                    if (this.f46776g > this.f46781l) {
                        f8 = z ? 1.0f + fAbs3 : 1.0f - fAbs3;
                    }
                } else {
                    float f9 = this.f46776g;
                    if (f9 > 0.0f) {
                        f8 = this.f46775f / f9;
                    }
                }
                double d3 = f8 * d2;
                pinchGestureHandler.M = d3;
                double d4 = (this.f46778i - this.f46779j) / 1000.0d;
                if (d4 > 0.0d) {
                    pinchGestureHandler.N = (d3 - d2) / d4;
                }
                if (Math.abs(pinchGestureHandler.R - this.f46775f) >= pinchGestureHandler.S && pinchGestureHandler.f46719f == 2) {
                    pinchGestureHandler.a(false);
                }
            }
            this.f46776g = this.f46775f;
            this.f46779j = this.f46778i;
        }
    }
}
