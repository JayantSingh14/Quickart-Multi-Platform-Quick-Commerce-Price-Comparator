package com.google.ads.mediation;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zzd extends FullScreenContentCallback {

    /* renamed from: a, reason: collision with root package name */
    public final MediationInterstitialListener f20504a;

    public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
        this.f20504a = mediationInterstitialListener;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void a() {
        this.f20504a.l();
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void b() {
        this.f20504a.i();
    }
}
