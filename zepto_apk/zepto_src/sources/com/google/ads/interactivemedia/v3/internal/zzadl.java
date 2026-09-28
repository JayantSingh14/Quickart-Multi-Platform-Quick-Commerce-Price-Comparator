package com.google.ads.interactivemedia.v3.internal;

import java.util.List;

/* loaded from: classes3.dex */
final class zzadl extends zzadn {
    private zzadl() {
        super(null);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadn
    public final List zza(Object obj, long j2) {
        zzacw zzacwVar = (zzacw) zzafu.zzf(obj, j2);
        if (zzacwVar.zzc()) {
            return zzacwVar;
        }
        int size = zzacwVar.size();
        zzacw zzacwVarZzd = zzacwVar.zzd(size == 0 ? 10 : size + size);
        zzafu.zzs(obj, j2, zzacwVarZzd);
        return zzacwVarZzd;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadn
    public final void zzb(Object obj, long j2) {
        ((zzacw) zzafu.zzf(obj, j2)).zzb();
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadn
    public final void zzc(Object obj, Object obj2, long j2) {
        zzacw zzacwVarZzd = (zzacw) zzafu.zzf(obj, j2);
        zzacw zzacwVar = (zzacw) zzafu.zzf(obj2, j2);
        int size = zzacwVarZzd.size();
        int size2 = zzacwVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzacwVarZzd.zzc()) {
                zzacwVarZzd = zzacwVarZzd.zzd(size2 + size);
            }
            zzacwVarZzd.addAll(zzacwVar);
        }
        if (size > 0) {
            zzacwVar = zzacwVarZzd;
        }
        zzafu.zzs(obj, j2, zzacwVar);
    }

    public /* synthetic */ zzadl(zzadk zzadkVar) {
        super(null);
    }
}
