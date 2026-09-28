package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeay extends InterstitialAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28982a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzebh f28983b;

    public zzeay(zzebh zzebhVar, String str) {
        this.f28982a = str;
        Objects.requireNonNull(zzebhVar);
        this.f28983b = zzebhVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void a(LoadAdError loadAdError) {
        this.f28983b.Yb(zzebh.bc(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        this.f28983b.Xb((InterstitialAd) obj, this.f28982a);
    }
}
