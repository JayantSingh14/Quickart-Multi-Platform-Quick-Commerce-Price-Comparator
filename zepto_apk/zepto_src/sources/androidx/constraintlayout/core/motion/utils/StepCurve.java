package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes3.dex */
public class StepCurve extends Easing {

    /* renamed from: d, reason: collision with root package name */
    public MonotonicCurveFit f1868d;

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double a(double d2) {
        return this.f1868d.b(d2);
    }

    @Override // androidx.constraintlayout.core.motion.utils.Easing
    public final double b(double d2) {
        return this.f1868d.e(d2);
    }
}
