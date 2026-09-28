package com.airbnb.lottie.animation.keyframe;

import android.graphics.PointF;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes3.dex */
public class SplitDimensionPathKeyframeAnimation extends BaseKeyframeAnimation<PointF, PointF> {

    /* renamed from: i, reason: collision with root package name */
    public final PointF f14372i;

    /* renamed from: j, reason: collision with root package name */
    public final PointF f14373j;

    /* renamed from: k, reason: collision with root package name */
    public final FloatKeyframeAnimation f14374k;

    /* renamed from: l, reason: collision with root package name */
    public final FloatKeyframeAnimation f14375l;

    /* renamed from: m, reason: collision with root package name */
    public LottieValueCallback f14376m;
    public LottieValueCallback n;

    public SplitDimensionPathKeyframeAnimation(FloatKeyframeAnimation floatKeyframeAnimation, FloatKeyframeAnimation floatKeyframeAnimation2) {
        super(Collections.EMPTY_LIST);
        this.f14372i = new PointF();
        this.f14373j = new PointF();
        this.f14374k = floatKeyframeAnimation;
        this.f14375l = floatKeyframeAnimation2;
        j(this.f14332d);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object f() {
        return l();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final /* bridge */ /* synthetic */ Object g(Keyframe keyframe, float f2) {
        return l();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void j(float f2) {
        FloatKeyframeAnimation floatKeyframeAnimation = this.f14374k;
        floatKeyframeAnimation.j(f2);
        FloatKeyframeAnimation floatKeyframeAnimation2 = this.f14375l;
        floatKeyframeAnimation2.j(f2);
        this.f14372i.set(((Float) floatKeyframeAnimation.f()).floatValue(), ((Float) floatKeyframeAnimation2.f()).floatValue());
        int i2 = 0;
        while (true) {
            ArrayList arrayList = this.f14329a;
            if (i2 >= arrayList.size()) {
                return;
            }
            ((BaseKeyframeAnimation.AnimationListener) arrayList.get(i2)).a();
            i2++;
        }
    }

    public final PointF l() {
        Float f2;
        FloatKeyframeAnimation floatKeyframeAnimation;
        Keyframe keyframeB;
        FloatKeyframeAnimation floatKeyframeAnimation2;
        Keyframe keyframeB2;
        Float f3 = null;
        if (this.f14376m == null || (keyframeB2 = (floatKeyframeAnimation2 = this.f14374k).b()) == null) {
            f2 = null;
        } else {
            Float f4 = keyframeB2.f14822h;
            LottieValueCallback lottieValueCallback = this.f14376m;
            float f5 = keyframeB2.f14821g;
            f2 = (Float) lottieValueCallback.b(f5, f4 == null ? f5 : f4.floatValue(), (Float) keyframeB2.f14816b, (Float) keyframeB2.f14817c, floatKeyframeAnimation2.d(), floatKeyframeAnimation2.e(), floatKeyframeAnimation2.f14332d);
        }
        if (this.n != null && (keyframeB = (floatKeyframeAnimation = this.f14375l).b()) != null) {
            Float f6 = keyframeB.f14822h;
            LottieValueCallback lottieValueCallback2 = this.n;
            float f7 = keyframeB.f14821g;
            f3 = (Float) lottieValueCallback2.b(f7, f6 == null ? f7 : f6.floatValue(), (Float) keyframeB.f14816b, (Float) keyframeB.f14817c, floatKeyframeAnimation.d(), floatKeyframeAnimation.e(), floatKeyframeAnimation.f14332d);
        }
        PointF pointF = this.f14372i;
        PointF pointF2 = this.f14373j;
        if (f2 == null) {
            pointF2.set(pointF.x, 0.0f);
        } else {
            pointF2.set(f2.floatValue(), 0.0f);
        }
        if (f3 == null) {
            pointF2.set(pointF2.x, pointF.y);
            return pointF2;
        }
        pointF2.set(pointF2.x, f3.floatValue());
        return pointF2;
    }
}
