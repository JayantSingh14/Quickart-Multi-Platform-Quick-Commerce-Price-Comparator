package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* loaded from: classes3.dex */
public final /* synthetic */ class i implements LottieDrawable.LazyCompositionTask {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14415a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LottieDrawable f14416b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f14417c;

    public /* synthetic */ i(LottieDrawable lottieDrawable, String str, int i2) {
        this.f14415a = i2;
        this.f14416b = lottieDrawable;
        this.f14417c = str;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run() {
        String str = this.f14417c;
        LottieDrawable lottieDrawable = this.f14416b;
        switch (this.f14415a) {
            case 0:
                boolean z = LottieDrawable.C0;
                lottieDrawable.b0(str);
                break;
            case 1:
                boolean z2 = LottieDrawable.C0;
                lottieDrawable.Y(str);
                break;
            default:
                boolean z3 = LottieDrawable.C0;
                lottieDrawable.e0(str);
                break;
        }
    }
}
