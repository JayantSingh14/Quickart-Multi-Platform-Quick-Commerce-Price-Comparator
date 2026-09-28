package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
public final class zzete implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzgyw f30270a;

    /* renamed from: b, reason: collision with root package name */
    public final zzcda f30271b;

    public zzete(zzgyw zzgywVar, zzcda zzcdaVar) {
        this.f30270a = zzgywVar;
        this.f30271b = zzcdaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        return ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.y3)).booleanValue() ? zzgym.a(new zzetf(null)) : zzgym.i(this.f30271b.h(), zzetd.f30269a, this.f30270a);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 10;
    }
}
