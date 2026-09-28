package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes3.dex */
public final /* synthetic */ class q implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14786a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14787b;

    public /* synthetic */ q(LottieDrawable lottieDrawable, int i2) {
        this.f14786a = i2;
        this.f14787b = lottieDrawable;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run() {
        LottieDrawable lottieDrawable = this.f14787b;
        switch (this.f14786a) {
            case 0:
                boolean z = LottieDrawable.C0;
                lottieDrawable.I();
                break;
            default:
                boolean z2 = LottieDrawable.C0;
                lottieDrawable.G();
                break;
        }
    }
}
