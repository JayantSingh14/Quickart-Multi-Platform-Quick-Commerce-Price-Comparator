package com.google.ads.mediation;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.mediation.MediationBannerListener;

@VisibleForTesting
/* loaded from: classes3.dex */
final class zzb extends AdListener implements AppEventListener, com.google.android.gms.ads.internal.client.zza {

    /* renamed from: a, reason: collision with root package name */
    public final MediationBannerListener f20501a;

    public zzb(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
        this.f20501a = mediationBannerListener;
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void f() {
        this.f20501a.n();
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void g(LoadAdError loadAdError) {
        this.f20501a.f(loadAdError);
    }

    @Override // com.google.android.gms.ads.AdListener, com.google.android.gms.ads.internal.client.zza
    public final void h() {
        this.f20501a.h();
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void m() {
        this.f20501a.m();
    }

    @Override // com.google.android.gms.ads.AdListener
    public final void t() {
        this.f20501a.d();
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void y(String str, String str2) {
        this.f20501a.a(str, str2);
    }
}
