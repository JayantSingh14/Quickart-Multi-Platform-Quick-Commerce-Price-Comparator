package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzeaz extends RewardedAdLoadCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28984a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzebh f28985b;

    public zzeaz(zzebh zzebhVar, String str) {
        this.f28984a = str;
        Objects.requireNonNull(zzebhVar);
        this.f28985b = zzebhVar;
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final void a(LoadAdError loadAdError) {
        this.f28985b.Yb(zzebh.bc(loadAdError));
    }

    @Override // com.google.android.gms.ads.AdLoadCallback
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        String str = this.f28984a;
        this.f28985b.Xb((RewardedAd) obj, str);
    }
}
