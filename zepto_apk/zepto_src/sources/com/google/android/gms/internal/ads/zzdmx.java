package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzdmx implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzdnh f27987a;

    public zzdmx(zzdnh zzdnhVar) {
        Objects.requireNonNull(zzdnhVar);
        this.f27987a = zzdnhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.d6)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.C.f21684h.e("omid native display exp", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzcdt zzcdtVar;
        zzdnh zzdnhVar = this.f27987a;
        zzdnm zzdnmVar = zzdnhVar.f28007m;
        zzcir zzcirVar = (zzcir) obj;
        synchronized (zzdnmVar) {
            zzdnmVar.f28036k = zzcirVar;
        }
        zzdnm zzdnmVar2 = zzdnhVar.f28007m;
        synchronized (zzdnmVar2) {
            zzcdtVar = zzdnmVar2.n;
        }
        zzejb zzejbVarE = zzdnhVar.e("Google", true);
        if (zzejbVarE != null && zzcdtVar != null) {
            zzcdtVar.b(zzejbVarE);
        } else if (zzcdtVar != null) {
            zzcdtVar.cancel(false);
        }
    }
}
