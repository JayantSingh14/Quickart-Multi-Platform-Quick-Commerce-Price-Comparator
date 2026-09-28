package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbb extends zzav {
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.e(str).ordinal();
        if (iOrdinal == 1) {
            zzh.a("AND", arrayList, 2);
            zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            if (!zzaoVarB.zze().booleanValue()) {
                return zzaoVarB;
            }
            return zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
        }
        if (iOrdinal == 47) {
            zzh.a("NOT", arrayList, 1);
            return new zzaf(Boolean.valueOf(!zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zze().booleanValue()));
        }
        if (iOrdinal != 50) {
            b(str);
            throw null;
        }
        zzh.a("OR", arrayList, 2);
        zzao zzaoVarB2 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
        if (zzaoVarB2.zze().booleanValue()) {
            return zzaoVarB2;
        }
        return zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
    }
}
