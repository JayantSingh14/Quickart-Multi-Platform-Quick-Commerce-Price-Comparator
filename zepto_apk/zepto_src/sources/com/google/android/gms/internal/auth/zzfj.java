package com.google.android.gms.internal.auth;

/* loaded from: classes4.dex */
final class zzfj extends zzfl {
    @Override // com.google.android.gms.internal.auth.zzfl
    public final void a(long j2, Object obj) {
        ((zzez) zzhj.d(obj, j2)).zzb();
    }

    @Override // com.google.android.gms.internal.auth.zzfl
    public final void b(Object obj, long j2, Object obj2) {
        zzez zzezVarZzd = (zzez) zzhj.d(obj, j2);
        zzez zzezVar = (zzez) zzhj.d(obj2, j2);
        int size = zzezVarZzd.size();
        int size2 = zzezVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzezVarZzd.zzc()) {
                zzezVarZzd = zzezVarZzd.zzd(size2 + size);
            }
            zzezVarZzd.addAll(zzezVar);
        }
        if (size > 0) {
            zzezVar = zzezVarZzd;
        }
        zzhj.j(obj, j2, zzezVar);
    }
}
