package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.core.motion.utils.SpringStopEngine;
import androidx.constraintlayout.core.motion.utils.StopEngine;
import androidx.constraintlayout.core.motion.utils.StopLogicEngine;
import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* loaded from: classes3.dex */
public class StopLogic extends MotionInterpolator {

    /* renamed from: a, reason: collision with root package name */
    public final StopLogicEngine f2072a;

    /* renamed from: b, reason: collision with root package name */
    public SpringStopEngine f2073b;

    /* renamed from: c, reason: collision with root package name */
    public StopEngine f2074c;

    public StopLogic() {
        StopLogicEngine stopLogicEngine = new StopLogicEngine();
        this.f2072a = stopLogicEngine;
        this.f2074c = stopLogicEngine;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public final float a() {
        return this.f2074c.a();
    }

    public final void b(float f2, float f3, float f4, float f5, float f6, float f7) {
        StopLogicEngine stopLogicEngine = this.f2072a;
        this.f2074c = stopLogicEngine;
        stopLogicEngine.f1880l = f2;
        boolean z = f2 > f3;
        stopLogicEngine.f1879k = z;
        if (z) {
            stopLogicEngine.d(-f4, f2 - f3, f6, f7, f5);
        } else {
            stopLogicEngine.d(f4, f3 - f2, f6, f7, f5);
        }
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        return this.f2074c.getInterpolation(f2);
    }
}
