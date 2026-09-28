package com.google.android.gms.internal.measurement;

import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzau extends zzav {
    public zzau() {
        this.f36776a.add(zzbk.BITWISE_AND);
        this.f36776a.add(zzbk.BITWISE_LEFT_SHIFT);
        this.f36776a.add(zzbk.BITWISE_NOT);
        this.f36776a.add(zzbk.BITWISE_OR);
        this.f36776a.add(zzbk.BITWISE_RIGHT_SHIFT);
        this.f36776a.add(zzbk.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f36776a.add(zzbk.BITWISE_XOR);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        zzbk zzbkVar = zzbk.ADD;
        switch (zzh.e(str).ordinal()) {
            case 4:
                zzh.a("BITWISE_AND", arrayList, 2);
                return new zzah(Double.valueOf(zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) & zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue())));
            case 5:
                zzh.a("BITWISE_LEFT_SHIFT", arrayList, 2);
                return new zzah(Double.valueOf(zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) << ((int) (zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()) & 31))));
            case 6:
                zzh.a("BITWISE_NOT", arrayList, 1);
                return new zzah(Double.valueOf(~zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue())));
            case 7:
                zzh.a("BITWISE_OR", arrayList, 2);
                return new zzah(Double.valueOf(zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) | zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue())));
            case 8:
                zzh.a("BITWISE_RIGHT_SHIFT", arrayList, 2);
                return new zzah(Double.valueOf(zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) >> ((int) (zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()) & 31))));
            case 9:
                zzh.a("BITWISE_UNSIGNED_RIGHT_SHIFT", arrayList, 2);
                return new zzah(Double.valueOf((zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) & 4294967295L) >>> ((int) (zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue()) & 31))));
            case 10:
                zzh.a("BITWISE_XOR", arrayList, 2);
                return new zzah(Double.valueOf(zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzd().doubleValue()) ^ zzh.g(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzd().doubleValue())));
            default:
                b(str);
                throw null;
        }
    }
}
