package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.AnimationHandler;
import androidx.dynamicanimation.animation.DynamicAnimation;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class SpringAnimation extends DynamicAnimation<SpringAnimation> {
    public SpringForce s;
    public float t;
    public boolean u;

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public final boolean c(long j2) {
        if (this.u) {
            float f2 = this.t;
            if (f2 != Float.MAX_VALUE) {
                this.s.f4288i = f2;
                this.t = Float.MAX_VALUE;
            }
            this.f4265b = (float) this.s.f4288i;
            this.f4264a = 0.0f;
            this.u = false;
            return true;
        }
        if (this.t != Float.MAX_VALUE) {
            SpringForce springForce = this.s;
            double d2 = springForce.f4288i;
            long j3 = j2 / 2;
            DynamicAnimation.MassState massStateB = springForce.b(this.f4265b, this.f4264a, j3);
            SpringForce springForce2 = this.s;
            springForce2.f4288i = this.t;
            this.t = Float.MAX_VALUE;
            DynamicAnimation.MassState massStateB2 = springForce2.b(massStateB.f4277a, massStateB.f4278b, j3);
            this.f4265b = massStateB2.f4277a;
            this.f4264a = massStateB2.f4278b;
        } else {
            DynamicAnimation.MassState massStateB3 = this.s.b(this.f4265b, this.f4264a, j2);
            this.f4265b = massStateB3.f4277a;
            this.f4264a = massStateB3.f4278b;
        }
        float fMax = Math.max(this.f4265b, this.f4271h);
        this.f4265b = fMax;
        this.f4265b = Math.min(fMax, this.f4270g);
        float f3 = this.f4264a;
        SpringForce springForce3 = this.s;
        springForce3.getClass();
        if (Math.abs(f3) >= springForce3.f4284e || Math.abs(r1 - ((float) springForce3.f4288i)) >= springForce3.f4283d) {
            return false;
        }
        this.f4265b = (float) this.s.f4288i;
        this.f4264a = 0.0f;
        return true;
    }

    public final void d(float f2) {
        if (this.f4269f) {
            this.t = f2;
            return;
        }
        if (this.s == null) {
            this.s = new SpringForce(f2);
        }
        SpringForce springForce = this.s;
        double d2 = f2;
        springForce.f4288i = d2;
        double d3 = (float) d2;
        if (d3 > this.f4270g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (d3 < this.f4271h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
        double dAbs = Math.abs(this.f4273j * 0.75f);
        springForce.f4283d = dAbs;
        springForce.f4284e = dAbs * 62.5d;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        boolean z = this.f4269f;
        if (z || z) {
            return;
        }
        this.f4269f = true;
        if (!this.f4266c) {
            this.f4265b = this.f4268e.a(this.f4267d);
        }
        float f3 = this.f4265b;
        if (f3 > this.f4270g || f3 < this.f4271h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        ThreadLocal threadLocal = AnimationHandler.f4252f;
        if (threadLocal.get() == null) {
            threadLocal.set(new AnimationHandler());
        }
        AnimationHandler animationHandler = (AnimationHandler) threadLocal.get();
        ArrayList arrayList = animationHandler.f4254b;
        if (arrayList.size() == 0) {
            if (animationHandler.f4256d == null) {
                animationHandler.f4256d = new AnimationHandler.FrameCallbackProvider16(animationHandler.f4255c);
            }
            animationHandler.f4256d.a();
        }
        if (arrayList.contains(this)) {
            return;
        }
        arrayList.add(this);
    }

    public final void e() {
        if (this.s.f4281b <= 0.0d) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f4269f) {
            this.u = true;
        }
    }
}
