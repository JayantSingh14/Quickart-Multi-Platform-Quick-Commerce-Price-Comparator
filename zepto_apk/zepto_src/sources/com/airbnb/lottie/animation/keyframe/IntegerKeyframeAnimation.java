package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;

/* loaded from: classes3.dex */
public class IntegerKeyframeAnimation extends KeyframeAnimation<Integer> {
    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        return Integer.valueOf(l(keyframe, f2));
    }

    public final int l(Keyframe keyframe, float f2) {
        int i2;
        float f3;
        Object obj = keyframe.f14816b;
        if (obj == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        Object obj2 = keyframe.f14817c;
        if (obj2 == null) {
            if (keyframe.f14825k == 784923401) {
                keyframe.f14825k = ((Integer) obj).intValue();
            }
            i2 = keyframe.f14825k;
        } else {
            if (keyframe.f14826l == 784923401) {
                keyframe.f14826l = ((Integer) obj2).intValue();
            }
            i2 = keyframe.f14826l;
        }
        LottieValueCallback lottieValueCallback = this.f14333e;
        Object obj3 = keyframe.f14816b;
        if (lottieValueCallback != null) {
            f3 = f2;
            Integer num = (Integer) lottieValueCallback.b(keyframe.f14821g, keyframe.f14822h.floatValue(), (Integer) obj3, Integer.valueOf(i2), f3, e(), this.f14332d);
            if (num != null) {
                return num.intValue();
            }
        } else {
            f3 = f2;
        }
        if (keyframe.f14825k == 784923401) {
            keyframe.f14825k = ((Integer) obj3).intValue();
        }
        int i3 = keyframe.f14825k;
        PointF pointF = MiscUtils.f14809a;
        return (int) (((i2 - i3) * f3) + i3);
    }
}
