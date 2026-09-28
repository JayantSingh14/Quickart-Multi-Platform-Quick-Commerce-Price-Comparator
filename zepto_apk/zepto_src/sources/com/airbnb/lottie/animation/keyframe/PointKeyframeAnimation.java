package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import android.support.v4.media.a;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.List;

/* loaded from: classes3.dex */
public class PointKeyframeAnimation extends KeyframeAnimation<PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f14365i;

    public PointKeyframeAnimation(List list) {
        super(list);
        this.f14365i = new PointF();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        return h(keyframe, f2, f2, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final PointF h(Keyframe keyframe, float f2, float f3, float f4) {
        Object obj;
        Object obj2 = keyframe.f14816b;
        if (obj2 == null || (obj = keyframe.f14817c) == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        PointF pointF = (PointF) obj2;
        PointF pointF2 = (PointF) obj;
        LottieValueCallback lottieValueCallback = this.f14333e;
        if (lottieValueCallback != null) {
            PointF pointF3 = (PointF) lottieValueCallback.b(keyframe.f14821g, keyframe.f14822h.floatValue(), pointF, pointF2, f2, e(), this.f14332d);
            if (pointF3 != null) {
                return pointF3;
            }
        }
        PointF pointF4 = this.f14365i;
        float f5 = pointF.x;
        float fA = a.a(pointF2.x, f5, f3, f5);
        float f6 = pointF.y;
        pointF4.set(fA, a.a(pointF2.y, f6, f4, f6));
        return pointF4;
    }
}
