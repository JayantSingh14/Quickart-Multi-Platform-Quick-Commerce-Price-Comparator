package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.GammaEvaluator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class ColorKeyframeAnimation extends KeyframeAnimation<Integer> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        return Integer.valueOf(l(keyframe, f2));
    }

    public final int l(Keyframe keyframe, float f2) {
        float f3;
        Float f4;
        if (keyframe.f14816b == null || keyframe.f14817c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback lottieValueCallback = this.f14333e;
        Object obj = keyframe.f14816b;
        if (lottieValueCallback == null || (f4 = keyframe.f14822h) == null) {
            f3 = f2;
        } else {
            f3 = f2;
            Integer num = (Integer) lottieValueCallback.b(keyframe.f14821g, f4.floatValue(), (Integer) obj, (Integer) keyframe.f14817c, f3, e(), this.f14332d);
            if (num != null) {
                return num.intValue();
            }
        }
        return GammaEvaluator.c(MiscUtils.b(f3, 0.0f, 1.0f), ((Integer) obj).intValue(), ((Integer) keyframe.f14817c).intValue());
    }
}
