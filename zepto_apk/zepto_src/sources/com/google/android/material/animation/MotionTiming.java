package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.v4.media.b;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public class MotionTiming {

    /* renamed from: a, reason: collision with root package name */
    public long f39830a;

    /* renamed from: c, reason: collision with root package name */
    public TimeInterpolator f39832c = null;

    /* renamed from: d, reason: collision with root package name */
    public int f39833d = 0;

    /* renamed from: e, reason: collision with root package name */
    public int f39834e = 1;

    /* renamed from: b, reason: collision with root package name */
    public long f39831b = 150;

    public MotionTiming(long j2) {
        this.f39830a = j2;
    }

    public final void a(Animator animator) {
        animator.setStartDelay(this.f39830a);
        animator.setDuration(this.f39831b);
        animator.setInterpolator(b());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(this.f39833d);
            valueAnimator.setRepeatMode(this.f39834e);
        }
    }

    public final TimeInterpolator b() {
        TimeInterpolator timeInterpolator = this.f39832c;
        return timeInterpolator != null ? timeInterpolator : AnimationUtils.f39817b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MotionTiming)) {
            return false;
        }
        MotionTiming motionTiming = (MotionTiming) obj;
        if (this.f39830a == motionTiming.f39830a && this.f39831b == motionTiming.f39831b && this.f39833d == motionTiming.f39833d && this.f39834e == motionTiming.f39834e) {
            return b().getClass().equals(motionTiming.b().getClass());
        }
        return false;
    }

    public final int hashCode() {
        long j2 = this.f39830a;
        long j3 = this.f39831b;
        return ((((b().getClass().hashCode() + (((((int) (j2 ^ (j2 >>> 32))) * 31) + ((int) ((j3 >>> 32) ^ j3))) * 31)) * 31) + this.f39833d) * 31) + this.f39834e;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(StringUtils.LF);
        sb.append(getClass().getName());
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" delay: ");
        sb.append(this.f39830a);
        sb.append(" duration: ");
        sb.append(this.f39831b);
        sb.append(" interpolator: ");
        sb.append(b().getClass());
        sb.append(" repeatCount: ");
        sb.append(this.f39833d);
        sb.append(" repeatMode: ");
        return b.o(sb, this.f39834e, "}\n");
    }
}
