package com.airbnb.lottie.value;

import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes3.dex */
public class LottieRelativeFloatValueCallback extends LottieValueCallback<Float> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final Object a(LottieFrameInfo lottieFrameInfo) {
        float fE = MiscUtils.e(((Float) lottieFrameInfo.f14830c).floatValue(), ((Float) lottieFrameInfo.f14831d).floatValue(), lottieFrameInfo.f14833f);
        Object obj = this.f14837b;
        if (obj != null) {
            return Float.valueOf(((Float) obj).floatValue() + fE);
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
