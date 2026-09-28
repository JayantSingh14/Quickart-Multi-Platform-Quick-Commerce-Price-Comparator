package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzdyy implements zzdyn {

    /* renamed from: a, reason: collision with root package name */
    public final long f28810a;

    /* renamed from: b, reason: collision with root package name */
    public final zzeqx f28811b;

    public zzdyy(long j2, Context context, zzdyr zzdyrVar, zzclg zzclgVar, String str) {
        this.f28810a = j2;
        zzcnp zzcnpVar = (zzcnp) zzclgVar.q();
        zzcnpVar.b(context);
        zzcnpVar.f26739d = new com.google.android.gms.ads.internal.client.zzr();
        zzcnpVar.o(str);
        zzeqx zzeqxVarZza = ((zzcnq) zzcnpVar.zza()).zza();
        this.f28811b = zzeqxVarZza;
        zzeqxVarZza.Q4(new zzdyx(this, zzdyrVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final void a(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        this.f28811b.U0(zzmVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final void zzb() {
        this.f28811b.k6(new ObjectWrapper(null));
    }

    @Override // com.google.android.gms.internal.ads.zzdyn
    public final void zzc() {
        this.f28811b.zzc();
    }
}
