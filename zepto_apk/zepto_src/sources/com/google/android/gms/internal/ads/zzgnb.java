package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgnb implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgna f32967a;

    public zzgnb(zzgnc zzgncVar, zzgna zzgnaVar) {
        this.f32967a = zzgnaVar;
        Objects.requireNonNull(zzgncVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzgna zzgnaVar = this.f32967a;
        zzgnaVar.b(th);
        zzgnaVar.c();
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        this.f32967a.c();
    }
}
