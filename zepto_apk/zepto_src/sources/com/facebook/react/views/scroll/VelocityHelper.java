package com.facebook.react.views.scroll;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class VelocityHelper {

    /* renamed from: a, reason: collision with root package name */
    public VelocityTracker f20091a;

    /* renamed from: b, reason: collision with root package name */
    public float f20092b;

    /* renamed from: c, reason: collision with root package name */
    public float f20093c;

    public final void a(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (this.f20091a == null) {
            this.f20091a = VelocityTracker.obtain();
        }
        VelocityTracker velocityTracker = this.f20091a;
        if (velocityTracker != null) {
            velocityTracker.addMovement(ev);
            int action = ev.getAction() & 255;
            if (action == 1 || action == 3) {
                velocityTracker.computeCurrentVelocity(1);
                this.f20092b = velocityTracker.getXVelocity();
                this.f20093c = velocityTracker.getYVelocity();
                velocityTracker.recycle();
                this.f20091a = null;
            }
        }
    }
}
