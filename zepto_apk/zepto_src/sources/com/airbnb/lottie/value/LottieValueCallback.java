package com.airbnb.lottie.value;

import com.airbnb.lottie.SimpleColorFilter;

/* loaded from: classes3.dex */
public class LottieValueCallback<T> {

    /* renamed from: a, reason: collision with root package name */
    public final LottieFrameInfo f14836a;

    /* renamed from: b, reason: collision with root package name */
    public final SimpleColorFilter f14837b;

    public LottieValueCallback() {
        this.f14836a = new LottieFrameInfo();
        this.f14837b = null;
    }

    public Object a(LottieFrameInfo lottieFrameInfo) {
        return this.f14837b;
    }

    public final Object b(float f2, float f3, Object obj, Object obj2, float f4, float f5, float f6) {
        LottieFrameInfo lottieFrameInfo = this.f14836a;
        lottieFrameInfo.f14828a = f2;
        lottieFrameInfo.f14829b = f3;
        lottieFrameInfo.f14830c = obj;
        lottieFrameInfo.f14831d = obj2;
        lottieFrameInfo.f14832e = f4;
        lottieFrameInfo.f14833f = f5;
        lottieFrameInfo.f14834g = f6;
        return a(lottieFrameInfo);
    }

    public LottieValueCallback(SimpleColorFilter simpleColorFilter) {
        this.f14836a = new LottieFrameInfo();
        this.f14837b = simpleColorFilter;
    }
}
