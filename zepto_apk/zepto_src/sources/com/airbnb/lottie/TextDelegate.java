package com.airbnb.lottie;

import java.util.HashMap;

/* loaded from: classes3.dex */
public class TextDelegate {

    /* renamed from: b, reason: collision with root package name */
    public final LottieAnimationView f14208b;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f14207a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final boolean f14209c = true;

    public TextDelegate(LottieAnimationView lottieAnimationView) {
        this.f14208b = lottieAnimationView;
    }

    public final void a(String str, String str2) {
        this.f14207a.put(str, str2);
        LottieAnimationView lottieAnimationView = this.f14208b;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
    }
}
