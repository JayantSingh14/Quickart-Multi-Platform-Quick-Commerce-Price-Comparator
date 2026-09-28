package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;

/* loaded from: classes4.dex */
public final class zzbdy extends zzbef {

    /* renamed from: a, reason: collision with root package name */
    public final AppOpenAd.AppOpenAdLoadCallback f24818a;

    /* renamed from: b, reason: collision with root package name */
    public final String f24819b;

    public zzbdy(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback, String str) {
        this.f24818a = appOpenAdLoadCallback;
        this.f24819b = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void gb(zzbed zzbedVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.f24818a;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.b(new zzbdz(zzbedVar, this.f24819b));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void l(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbeg
    public final void t0(com.google.android.gms.ads.internal.client.zze zzeVar) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.f24818a;
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.a(zzeVar.r());
        }
    }
}
