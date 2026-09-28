package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzbh extends zzav {
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.e(str).ordinal();
        if (iOrdinal == 0) {
            zzh.a("ADD", arrayList, 2);
            zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzao zzaoVarB2 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
            if (!(zzaoVarB instanceof zzak) && !(zzaoVarB instanceof zzas) && !(zzaoVarB2 instanceof zzak) && !(zzaoVarB2 instanceof zzas)) {
                return new zzah(Double.valueOf(zzaoVarB2.zzd().doubleValue() + zzaoVarB.zzd().doubleValue()));
            }
            return new zzas(String.valueOf(zzaoVarB.zzc()).concat(String.valueOf(zzaoVarB2.zzc())));
        }
        if (iOrdinal == 21) {
            zzh.a("DIVIDE", arrayList, 2);
            return new zzah(Double.valueOf(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue() / zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()));
        }
        if (iOrdinal == 59) {
            zzh.a("SUBTRACT", arrayList, 2);
            zzao zzaoVarB3 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzah zzahVar = new zzah(Double.valueOf(-zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()));
            return new zzah(Double.valueOf(zzahVar.f36761a.doubleValue() + zzaoVarB3.zzd().doubleValue()));
        }
        if (iOrdinal == 52 || iOrdinal == 53) {
            zzh.a(str, arrayList, 2);
            zzao zzaoVarB4 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzgVar.a((zzao) arrayList.get(1));
            return zzaoVarB4;
        }
        if (iOrdinal == 55 || iOrdinal == 56) {
            zzh.a(str, arrayList, 1);
            return zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
        }
        switch (iOrdinal) {
            case 44:
                zzh.a("MODULUS", arrayList, 2);
                return new zzah(Double.valueOf(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue() % zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()));
            case 45:
                zzh.a("MULTIPLY", arrayList, 2);
                return new zzah(Double.valueOf(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue() * zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()));
            case 46:
                zzh.a("NEGATE", arrayList, 1);
                return new zzah(Double.valueOf(-zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()));
            default:
                b(str);
                throw null;
        }
    }
}
