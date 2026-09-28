package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzbg extends zzav {
    public static zzao c(zzbe zzbeVar, zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof Iterable) {
            return d(zzbeVar, ((Iterable) zzaoVar).iterator(), zzaoVar2);
        }
        throw new IllegalArgumentException("Non-iterable type in for...of loop.");
    }

    public static zzao d(zzbe zzbeVar, Iterator it, zzao zzaoVar) {
        if (it != null) {
            while (it.hasNext()) {
                zzao zzaoVarB = zzbeVar.a((zzao) it.next()).b((zzae) zzaoVar);
                if (zzaoVarB instanceof zzag) {
                    zzag zzagVar = (zzag) zzaoVarB;
                    if ("break".equals(zzagVar.f36760b)) {
                        return zzao.o0;
                    }
                    if ("return".equals(zzagVar.f36760b)) {
                        return zzagVar;
                    }
                }
            }
        }
        return zzao.o0;
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.e(str).ordinal();
        if (iOrdinal == 65) {
            zzh.a("WHILE", arrayList, 4);
            zzao zzaoVar = (zzao) arrayList.get(0);
            zzao zzaoVar2 = (zzao) arrayList.get(1);
            zzao zzaoVar3 = (zzao) arrayList.get(2);
            zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(3));
            zzaw zzawVar = zzgVar.f36956b;
            if (zzawVar.b(zzgVar, zzaoVar3).zze().booleanValue()) {
                zzao zzaoVarB2 = zzgVar.b((zzae) zzaoVarB);
                if (zzaoVarB2 instanceof zzag) {
                    zzag zzagVar = (zzag) zzaoVarB2;
                    if ("break".equals(zzagVar.f36760b)) {
                        return zzao.o0;
                    }
                    if ("return".equals(zzagVar.f36760b)) {
                        return zzagVar;
                    }
                }
            }
            while (zzawVar.b(zzgVar, zzaoVar).zze().booleanValue()) {
                zzao zzaoVarB3 = zzgVar.b((zzae) zzaoVarB);
                if (zzaoVarB3 instanceof zzag) {
                    zzag zzagVar2 = (zzag) zzaoVarB3;
                    if ("break".equals(zzagVar2.f36760b)) {
                        return zzao.o0;
                    }
                    if ("return".equals(zzagVar2.f36760b)) {
                        return zzagVar2;
                    }
                }
                zzgVar.a(zzaoVar2);
            }
            return zzao.o0;
        }
        switch (iOrdinal) {
            case 26:
                zzh.a("FOR_IN", arrayList, 3);
                if (!(arrayList.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN must be a string");
                }
                return d(new zzbf(zzgVar, ((zzao) arrayList.get(0)).zzc()), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzf(), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(2)));
            case 27:
                zzh.a("FOR_IN_CONST", arrayList, 3);
                if (!(arrayList.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_CONST must be a string");
                }
                return d(new zzbc(zzgVar, ((zzao) arrayList.get(0)).zzc()), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzf(), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(2)));
            case 28:
                zzh.a("FOR_IN_LET", arrayList, 3);
                if (!(arrayList.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_IN_LET must be a string");
                }
                return d(new zzbd(zzgVar, ((zzao) arrayList.get(0)).zzc()), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)).zzf(), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(2)));
            case 29:
                zzh.a("FOR_LET", arrayList, 4);
                zzao zzaoVarB4 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
                if (!(zzaoVarB4 instanceof zzae)) {
                    throw new IllegalArgumentException("Initializer variables in FOR_LET must be an ArrayList");
                }
                zzae zzaeVar = (zzae) zzaoVarB4;
                zzao zzaoVar4 = (zzao) arrayList.get(1);
                zzao zzaoVar5 = (zzao) arrayList.get(2);
                zzao zzaoVar6 = (zzao) arrayList.get(3);
                zzaw zzawVar2 = zzgVar.f36956b;
                zzao zzaoVarB5 = zzawVar2.b(zzgVar, zzaoVar6);
                zzg zzgVarC = zzgVar.c();
                for (int i2 = 0; i2 < zzaeVar.n(); i2++) {
                    String strZzc = zzaeVar.o(i2).zzc();
                    zzgVarC.e(strZzc, zzgVar.g(strZzc));
                }
                while (zzawVar2.b(zzgVar, zzaoVar4).zze().booleanValue()) {
                    zzao zzaoVarB6 = zzgVar.b((zzae) zzaoVarB5);
                    if (zzaoVarB6 instanceof zzag) {
                        zzag zzagVar3 = (zzag) zzaoVarB6;
                        if ("break".equals(zzagVar3.f36760b)) {
                            return zzao.o0;
                        }
                        if ("return".equals(zzagVar3.f36760b)) {
                            return zzagVar3;
                        }
                    }
                    zzg zzgVarC2 = zzgVar.c();
                    for (int i3 = 0; i3 < zzaeVar.n(); i3++) {
                        String strZzc2 = zzaeVar.o(i3).zzc();
                        zzgVarC2.e(strZzc2, zzgVarC.g(strZzc2));
                    }
                    zzgVarC2.a(zzaoVar5);
                    zzgVarC = zzgVarC2;
                }
                return zzao.o0;
            case 30:
                zzh.a("FOR_OF", arrayList, 3);
                if (!(arrayList.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF must be a string");
                }
                return c(new zzbf(zzgVar, ((zzao) arrayList.get(0)).zzc()), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(2)));
            case 31:
                zzh.a("FOR_OF_CONST", arrayList, 3);
                if (!(arrayList.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_CONST must be a string");
                }
                return c(new zzbc(zzgVar, ((zzao) arrayList.get(0)).zzc()), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(2)));
            case 32:
                zzh.a("FOR_OF_LET", arrayList, 3);
                if (!(arrayList.get(0) instanceof zzas)) {
                    throw new IllegalArgumentException("Variable name in FOR_OF_LET must be a string");
                }
                return c(new zzbd(zzgVar, ((zzao) arrayList.get(0)).zzc()), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1)), zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(2)));
            default:
                b(str);
                throw null;
        }
    }
}
