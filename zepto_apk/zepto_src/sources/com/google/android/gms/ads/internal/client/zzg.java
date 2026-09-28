package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;

/* loaded from: classes4.dex */
public final class zzg extends zzbj {

    /* renamed from: a, reason: collision with root package name */
    public final AdListener f21246a;

    public zzg(AdListener adListener) {
        this.f21246a = adListener;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void l(int i2) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void t0(zze zzeVar) {
        AdListener adListener = this.f21246a;
        if (adListener != null) {
            adListener.g(zzeVar.r());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzb() {
        AdListener adListener = this.f21246a;
        if (adListener != null) {
            adListener.f();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zze() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzf() {
        AdListener adListener = this.f21246a;
        if (adListener != null) {
            adListener.m();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzg() {
        AdListener adListener = this.f21246a;
        if (adListener != null) {
            adListener.t();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzh() {
        AdListener adListener = this.f21246a;
        if (adListener != null) {
            adListener.h();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzi() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbk
    public final void zzj() {
        AdListener adListener = this.f21246a;
        if (adListener != null) {
            adListener.j();
        }
    }
}
