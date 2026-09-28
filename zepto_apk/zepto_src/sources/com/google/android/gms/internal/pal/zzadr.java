package com.google.android.gms.internal.pal;

import java.util.List;

/* loaded from: classes4.dex */
final class zzadr extends zzadt {
    @Override // com.google.android.gms.internal.pal.zzadt
    public final List a(Object obj, long j2) {
        zzadf zzadfVar = (zzadf) zzafs.f37500c.m(j2, obj);
        if (zzadfVar.zzc()) {
            return zzadfVar;
        }
        int size = zzadfVar.size();
        zzadf zzadfVarZzd = zzadfVar.zzd(size == 0 ? 10 : size + size);
        zzafs.h(obj, j2, zzadfVarZzd);
        return zzadfVarZzd;
    }

    @Override // com.google.android.gms.internal.pal.zzadt
    public final void b(Object obj, long j2) {
        ((zzadf) zzafs.f37500c.m(j2, obj)).zzb();
    }

    @Override // com.google.android.gms.internal.pal.zzadt
    public final void c(zzacz zzaczVar, zzacz zzaczVar2, long j2) {
        zzafr zzafrVar = zzafs.f37500c;
        zzadf zzadfVarZzd = (zzadf) zzafrVar.m(j2, zzaczVar);
        zzadf zzadfVar = (zzadf) zzafrVar.m(j2, zzaczVar2);
        int size = zzadfVarZzd.size();
        int size2 = zzadfVar.size();
        if (size > 0 && size2 > 0) {
            if (!zzadfVarZzd.zzc()) {
                zzadfVarZzd = zzadfVarZzd.zzd(size2 + size);
            }
            zzadfVarZzd.addAll(zzadfVar);
        }
        if (size > 0) {
            zzadfVar = zzadfVarZzd;
        }
        zzafs.h(zzaczVar, j2, zzadfVar);
    }
}
