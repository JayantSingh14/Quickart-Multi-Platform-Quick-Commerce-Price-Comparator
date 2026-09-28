package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.internal.ads.zzbqi;

/* loaded from: classes4.dex */
public final class zzh extends zzbm {

    /* renamed from: a, reason: collision with root package name */
    public final AdLoadCallback f21250a;

    /* renamed from: b, reason: collision with root package name */
    public final zzbqi f21251b;

    public zzh(AdLoadCallback adLoadCallback, zzbqi zzbqiVar) {
        this.f21250a = adLoadCallback;
        this.f21251b = zzbqiVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void k1(zze zzeVar) {
        AdLoadCallback adLoadCallback = this.f21250a;
        if (adLoadCallback != null) {
            adLoadCallback.a(zzeVar.r());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbn
    public final void zzb() {
        zzbqi zzbqiVar;
        AdLoadCallback adLoadCallback = this.f21250a;
        if (adLoadCallback == null || (zzbqiVar = this.f21251b) == null) {
            return;
        }
        adLoadCallback.b(zzbqiVar);
    }
}
