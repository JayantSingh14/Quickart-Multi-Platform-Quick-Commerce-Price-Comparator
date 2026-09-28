package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdsg implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28414a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbnn f28415b;

    public zzdsg(zzdsp zzdspVar, String str, zzbnn zzbnnVar) {
        this.f28414a = str;
        this.f28415b = zzbnnVar;
        Objects.requireNonNull(zzdspVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcir) obj).h0(this.f28414a, this.f28415b);
    }
}
