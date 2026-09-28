package com.airbnb.lottie.value;

import android.graphics.PointF;
import com.airbnb.lottie.utils.MiscUtils;

/* loaded from: classes3.dex */
public class LottieRelativePointValueCallback extends LottieValueCallback<PointF> {

    /* renamed from: c, reason: collision with root package name */
    public final PointF f14835c = new PointF();

    @Override // com.airbnb.lottie.value.LottieValueCallback
    public final Object a(LottieFrameInfo lottieFrameInfo) {
        PointF pointF = this.f14835c;
        pointF.set(MiscUtils.e(((PointF) lottieFrameInfo.f14830c).x, ((PointF) lottieFrameInfo.f14831d).x, lottieFrameInfo.f14833f), MiscUtils.e(((PointF) lottieFrameInfo.f14830c).y, ((PointF) lottieFrameInfo.f14831d).y, lottieFrameInfo.f14833f));
        Object obj = this.f14837b;
        if (obj == null) {
            throw new IllegalArgumentException("You must provide a static value in the constructor , call setValue, or override getValue.");
        }
        PointF pointF2 = (PointF) obj;
        pointF.offset(pointF2.x, pointF2.y);
        return pointF;
    }
}
