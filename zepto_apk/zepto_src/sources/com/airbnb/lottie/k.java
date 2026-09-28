package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes3.dex */
public final /* synthetic */ class k implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14421a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14422b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14423c;

    public /* synthetic */ k(LottieDrawable lottieDrawable, int i2, int i3) {
        this.f14421a = i3;
        this.f14422b = lottieDrawable;
        this.f14423c = i2;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run() {
        int i2 = this.f14423c;
        LottieDrawable lottieDrawable = this.f14422b;
        switch (this.f14421a) {
            case 0:
                boolean z = LottieDrawable.C0;
                lottieDrawable.X(i2);
                break;
            case 1:
                boolean z2 = LottieDrawable.C0;
                lottieDrawable.d0(i2);
                break;
            default:
                boolean z3 = LottieDrawable.C0;
                lottieDrawable.S(i2);
                break;
        }
    }
}
