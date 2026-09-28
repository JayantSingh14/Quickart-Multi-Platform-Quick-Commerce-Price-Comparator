package com.airbnb.lottie.utils;

import android.animation.Animator;
import android.graphics.PointF;
import android.view.Choreographer;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.network.NetworkFetcher;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LottieValueAnimator extends BaseLottieAnimator implements Choreographer.FrameCallback {

    /* renamed from: l, reason: collision with root package name */
    public LottieComposition f14806l;

    /* renamed from: d, reason: collision with root package name */
    public float f14798d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14799e = false;

    /* renamed from: f, reason: collision with root package name */
    public long f14800f = 0;

    /* renamed from: g, reason: collision with root package name */
    public float f14801g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    public float f14802h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    public int f14803i = 0;

    /* renamed from: j, reason: collision with root package name */
    public float f14804j = -2.14748365E9f;

    /* renamed from: k, reason: collision with root package name */
    public float f14805k = 2.14748365E9f;

    /* renamed from: m, reason: collision with root package name */
    public boolean f14807m = false;
    public boolean n = false;

    public final float c() {
        LottieComposition lottieComposition = this.f14806l;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.f14802h;
        float f3 = lottieComposition.f14146l;
        return (f2 - f3) / (lottieComposition.f14147m - f3);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator it = this.f14790b.iterator();
        while (it.hasNext()) {
            ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
        }
        a(f());
        g(true);
    }

    public final float d() {
        LottieComposition lottieComposition = this.f14806l;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.f14805k;
        return f2 == 2.14748365E9f ? lottieComposition.f14147m : f2;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j2) {
        boolean z = false;
        if (this.f14807m) {
            g(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
        LottieComposition lottieComposition = this.f14806l;
        if (lottieComposition == null || !this.f14807m) {
            return;
        }
        NetworkFetcher networkFetcher = L.f14106a;
        float fAbs = (this.f14800f != 0 ? j2 - r2 : 0L) / ((1.0E9f / lottieComposition.n) / Math.abs(this.f14798d));
        float f2 = this.f14801g;
        if (f()) {
            fAbs = -fAbs;
        }
        float f3 = f2 + fAbs;
        float fE = e();
        float fD = d();
        PointF pointF = MiscUtils.f14809a;
        if (f3 >= fE && f3 <= fD) {
            z = true;
        }
        float f4 = this.f14801g;
        float fB = MiscUtils.b(f3, e(), d());
        this.f14801g = fB;
        if (this.n) {
            fB = (float) Math.floor(fB);
        }
        this.f14802h = fB;
        this.f14800f = j2;
        if (!this.n || this.f14801g != f4) {
            b();
        }
        if (!z) {
            if (getRepeatCount() == -1 || this.f14803i < getRepeatCount()) {
                Iterator it = this.f14790b.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationRepeat(this);
                }
                this.f14803i++;
                if (getRepeatMode() == 2) {
                    this.f14799e = !this.f14799e;
                    this.f14798d = -this.f14798d;
                } else {
                    float fD2 = f() ? d() : e();
                    this.f14801g = fD2;
                    this.f14802h = fD2;
                }
                this.f14800f = j2;
            } else {
                float fE2 = this.f14798d < 0.0f ? e() : d();
                this.f14801g = fE2;
                this.f14802h = fE2;
                g(true);
                a(f());
            }
        }
        if (this.f14806l != null) {
            float f5 = this.f14802h;
            if (f5 < this.f14804j || f5 > this.f14805k) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f14804j), Float.valueOf(this.f14805k), Float.valueOf(this.f14802h)));
            }
        }
        NetworkFetcher networkFetcher2 = L.f14106a;
    }

    public final float e() {
        LottieComposition lottieComposition = this.f14806l;
        if (lottieComposition == null) {
            return 0.0f;
        }
        float f2 = this.f14804j;
        return f2 == -2.14748365E9f ? lottieComposition.f14146l : f2;
    }

    public final boolean f() {
        return this.f14798d < 0.0f;
    }

    public final void g(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f14807m = false;
        }
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        float fE;
        float fD;
        float fE2;
        if (this.f14806l == null) {
            return 0.0f;
        }
        if (f()) {
            fE = d() - this.f14802h;
            fD = d();
            fE2 = e();
        } else {
            fE = this.f14802h - e();
            fD = d();
            fE2 = e();
        }
        return fE / (fD - fE2);
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(c());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        LottieComposition lottieComposition = this.f14806l;
        if (lottieComposition == null) {
            return 0L;
        }
        return (long) lottieComposition.b();
    }

    public final void h(float f2) {
        if (this.f14801g == f2) {
            return;
        }
        float fB = MiscUtils.b(f2, e(), d());
        this.f14801g = fB;
        if (this.n) {
            fB = (float) Math.floor(fB);
        }
        this.f14802h = fB;
        this.f14800f = 0L;
        b();
    }

    public final void i(float f2, float f3) {
        if (f2 > f3) {
            throw new IllegalArgumentException("minFrame (" + f2 + ") must be <= maxFrame (" + f3 + ")");
        }
        LottieComposition lottieComposition = this.f14806l;
        float f4 = lottieComposition == null ? -3.4028235E38f : lottieComposition.f14146l;
        float f5 = lottieComposition == null ? Float.MAX_VALUE : lottieComposition.f14147m;
        float fB = MiscUtils.b(f2, f4, f5);
        float fB2 = MiscUtils.b(f3, f4, f5);
        if (fB == this.f14804j && fB2 == this.f14805k) {
            return;
        }
        this.f14804j = fB;
        this.f14805k = fB2;
        h((int) MiscUtils.b(this.f14802h, fB, fB2));
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.f14807m;
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f14799e) {
            return;
        }
        this.f14799e = false;
        this.f14798d = -this.f14798d;
    }
}
