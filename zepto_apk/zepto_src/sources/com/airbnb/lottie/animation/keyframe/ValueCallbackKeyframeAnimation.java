package com.airbnb.lottie.animation.keyframe;

import com.airbnb.lottie.value.Keyframe;
import com.airbnb.lottie.value.LottieValueCallback;
import java.util.Collections;

/* loaded from: classes3.dex */
public class ValueCallbackKeyframeAnimation<K, A> extends BaseKeyframeAnimation<K, A> {

    /* renamed from: i, reason: collision with root package name */
    public final Object f14393i;

    public ValueCallbackKeyframeAnimation(LottieValueCallback lottieValueCallback, Object obj) {
        super(Collections.EMPTY_LIST);
        k(lottieValueCallback);
        this.f14393i = obj;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final float c() {
        return 1.0f;
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object f() {
        LottieValueCallback lottieValueCallback = this.f14333e;
        float f2 = this.f14332d;
        Object obj = this.f14393i;
        return lottieValueCallback.b(0.0f, 0.0f, obj, obj, f2, f2, f2);
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final Object g(Keyframe keyframe, float f2) {
        return f();
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void i() {
        if (this.f14333e != null) {
            super.i();
        }
    }

    @Override // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation
    public final void j(float f2) {
        this.f14332d = f2;
    }
}
