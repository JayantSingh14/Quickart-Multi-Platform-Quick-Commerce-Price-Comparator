package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class FloatKeyframeAnimation extends KeyframeAnimation<Float> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        return Float.valueOf(m(keyframe, f2));
    }

    public final float l() {
        return m(b(), d());
    }

    public final float m(Keyframe keyframe, float f2) {
        float f3;
        if (keyframe.f14816b == null || keyframe.f14817c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        LottieValueCallback lottieValueCallback = this.f14333e;
        Object obj = keyframe.f14816b;
        if (lottieValueCallback != null) {
            Float f4 = (Float) keyframe.f14817c;
            float fE = e();
            float f5 = this.f14332d;
            f3 = f2;
            Float f6 = (Float) lottieValueCallback.b(keyframe.f14821g, keyframe.f14822h.floatValue(), (Float) obj, f4, f3, fE, f5);
            if (f6 != null) {
                return f6.floatValue();
            }
        } else {
            f3 = f2;
        }
        if (keyframe.f14823i == -3987645.8f) {
            keyframe.f14823i = ((Float) obj).floatValue();
        }
        float f7 = keyframe.f14823i;
        if (keyframe.f14824j == -3987645.8f) {
            keyframe.f14824j = ((Float) keyframe.f14817c).floatValue();
        }
        return MiscUtils.e(f7, keyframe.f14824j, f3);
    }
}
