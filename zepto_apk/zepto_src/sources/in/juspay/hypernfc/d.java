package in.juspay.hypernfc;

import android.view.animation.Interpolator;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements Interpolator {
    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f2) {
        return Wave.createRingAnimator$lambda$1(f2);
    }
}
