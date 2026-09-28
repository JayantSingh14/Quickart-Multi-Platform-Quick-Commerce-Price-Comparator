package com.google.ads.mediation;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zzc extends InterstitialAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final AbstractAdViewAdapter f20502a;

    /* renamed from: b, reason: collision with root package name */
    public final MediationInterstitialListener f20503b;

    public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f20502a = abstractAdViewAdapter;
        this.f20503b = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void a(LoadAdError loadAdError) {
        this.f20503b.b(loadAdError);
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        InterstitialAd interstitialAd = (InterstitialAd) obj;
        AbstractAdViewAdapter abstractAdViewAdapter = this.f20502a;
        abstractAdViewAdapter.mInterstitialAd = interstitialAd;
        MediationInterstitialListener mediationInterstitialListener = this.f20503b;
        interstitialAd.c(new zzd(abstractAdViewAdapter, mediationInterstitialListener));
        mediationInterstitialListener.p();
    }
}
