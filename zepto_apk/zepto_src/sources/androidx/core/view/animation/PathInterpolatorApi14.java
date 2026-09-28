package androidx.core.view.animation;

import android.view.animation.Interpolator;

/* loaded from: classes3.dex */
class PathInterpolatorApi14 implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        if (f2 <= 0.0f) {
            return 0.0f;
        }
        if (f2 >= 1.0f) {
            return 1.0f;
        }
        throw null;
    }
}
