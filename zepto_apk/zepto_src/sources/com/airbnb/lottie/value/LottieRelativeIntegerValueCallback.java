package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes3.dex */
public class LottieRelativeIntegerValueCallback extends LottieValueCallback<Integer> {
    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final Object a(LottieFrameInfo lottieFrameInfo) {
        int iIntValue = ((Integer) lottieFrameInfo.f14830c).intValue();
        int iIntValue2 = ((Integer) lottieFrameInfo.f14831d).intValue();
        float f2 = lottieFrameInfo.f14833f;
        PointF pointF = MiscUtils.f14809a;
        int i2 = (int) ((f2 * (iIntValue2 - iIntValue)) + iIntValue);
        Object obj = this.f14837b;
        if (obj != null) {
            return Integer.valueOf(((Integer) obj).intValue() + i2);
        }
        throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
    }
}
