package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
final class zzbrp implements zzcdx {
    @Override // com.google.android.gms.internal.ads.zzcdx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzbqm zzbqmVar = (zzbqm) obj;
        ((zzcdn) zzcdo.f25987f).execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbro
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                com.google.android.gms.ads.internal.util.zze.k("maybeDestroy > Destroying engine.");
                zzboe zzboeVar = zzbnm.o;
                zzbqm zzbqmVar2 = zzbqmVar;
                zzbqmVar2.x0("/result", zzboeVar);
                zzbqmVar2.zzj();
            }
        });
    }
}
