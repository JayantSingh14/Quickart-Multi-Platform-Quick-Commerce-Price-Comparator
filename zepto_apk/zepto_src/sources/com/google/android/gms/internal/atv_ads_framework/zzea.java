package com.google.android.gms.internal.atv_ads_framework;

/* loaded from: classes4.dex */
final class zzea extends zzec {
    @Override // com.google.android.gms.internal.atv_ads_framework.zzec
    public final void a(long j2, Object obj) {
        ((zzdo) zzfz.g(obj, j2)).zzb();
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzec
    public final void b(Object obj, long j2, Object obj2) {
        zzdo zzdoVarZzg = (zzdo) zzfz.g(obj, j2);
        zzdo zzdoVar = (zzdo) zzfz.g(obj2, j2);
        int size = zzdoVarZzg.size();
        int size2 = zzdoVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzdoVarZzg.zzc()) {
                zzdoVarZzg = zzdoVarZzg.zzg(size2 + size);
            }
            zzdoVarZzg.addAll(zzdoVar);
        }
        if (size > 0) {
            zzdoVar = zzdoVarZzg;
        }
        zzfz.k(obj, j2, zzdoVar);
    }
}
