package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeba extends RewardedInterstitialAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28989a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzebh f28990b;

    public zzeba(zzebh zzebhVar, String str) {
        this.f28989a = str;
        Objects.requireNonNull(zzebhVar);
        this.f28990b = zzebhVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void a(LoadAdError loadAdError) {
        this.f28990b.Yb(zzebh.bc(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        String str = this.f28989a;
        this.f28990b.Xb((RewardedInterstitialAd) obj, str);
    }
}
