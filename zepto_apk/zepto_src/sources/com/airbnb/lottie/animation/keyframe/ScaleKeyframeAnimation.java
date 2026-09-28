package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.ScaleXY;
import java.util.List;

/* loaded from: classes3.dex */
public class ScaleKeyframeAnimation extends KeyframeAnimation<ScaleXY> {

    /* renamed from: i, reason: collision with root package name */
    public final ScaleXY f14366i;

    public ScaleKeyframeAnimation(List list) {
        super(list);
        this.f14366i = new ScaleXY();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        Object obj;
        float f3;
        Object obj2 = keyframe.f14816b;
        if (obj2 == null || (obj = keyframe.f14817c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        ScaleXY scaleXY = (ScaleXY) obj2;
        ScaleXY scaleXY2 = (ScaleXY) obj;
        LottieValueCallback lottieValueCallback = this.f14333e;
        if (lottieValueCallback != null) {
            f3 = f2;
            ScaleXY scaleXY3 = (ScaleXY) lottieValueCallback.b(keyframe.f14821g, keyframe.f14822h.floatValue(), scaleXY, scaleXY2, f3, e(), this.f14332d);
            if (scaleXY3 != null) {
                return scaleXY3;
            }
        } else {
            f3 = f2;
        }
        float fE = MiscUtils.e(scaleXY.f14838a, scaleXY2.f14838a, f3);
        float fE2 = MiscUtils.e(scaleXY.f14839b, scaleXY2.f14839b, f3);
        ScaleXY scaleXY4 = this.f14366i;
        scaleXY4.f14838a = fE;
        scaleXY4.f14839b = fE2;
        return scaleXY4;
    }
}
