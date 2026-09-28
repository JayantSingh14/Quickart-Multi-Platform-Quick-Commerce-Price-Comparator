package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes3.dex */
public final /* synthetic */ class n implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14662a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14663b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ float f14664c;

    public /* synthetic */ n(LottieDrawable lottieDrawable, float f2, int i2) {
        this.f14662a = i2;
        this.f14663b = lottieDrawable;
        this.f14664c = f2;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run() {
        float f2 = this.f14664c;
        LottieDrawable lottieDrawable = this.f14663b;
        switch (this.f14662a) {
            case 0:
                boolean z = LottieDrawable.C0;
                lottieDrawable.Z(f2);
                break;
            case 1:
                boolean z2 = LottieDrawable.C0;
                lottieDrawable.f0(f2);
                break;
            default:
                boolean z3 = LottieDrawable.C0;
                lottieDrawable.i0(f2);
                break;
        }
    }
}
