package com.airbnb.lottie;

import java.util.Arrays;

/* loaded from: classes3.dex */
public final class LottieResult<V> {

    /* renamed from: a, reason: collision with root package name */
    public final LottieComposition f14191a;

    /* renamed from: b, reason: collision with root package name */
    public final Throwable f14192b;

    public LottieResult(LottieComposition lottieComposition) {
        this.f14191a = lottieComposition;
        this.f14192b = null;
    }

    public final Object a() {
        return this.f14191a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LottieResult)) {
            return false;
        }
        LottieResult lottieResult = (LottieResult) obj;
        LottieComposition lottieComposition = this.f14191a;
        if (lottieComposition != null && lottieComposition.equals(lottieResult.f14191a)) {
            return true;
        }
        Throwable th = this.f14192b;
        if (th == null || lottieResult.f14192b == null) {
            return false;
        }
        return th.toString().equals(th.toString());
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f14191a, this.f14192b});
    }

    public LottieResult(Throwable th) {
        this.f14192b = th;
        this.f14191a = null;
    }
}
