package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdsf implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f28412a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzbnn f28413b;

    public zzdsf(zzdsp zzdspVar, String str, zzbnn zzbnnVar) {
        this.f28412a = str;
        this.f28413b = zzbnnVar;
        Objects.requireNonNull(zzdspVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzcir) obj).k0(this.f28412a, this.f28413b);
    }
}
