package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzay extends zzav {
    public static zzan c(zzg zzgVar, ArrayList arrayList) {
        zzbk zzbkVar = zzbk.ADD;
        zzh.b("FN", arrayList, 2);
        zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
        zzao zzaoVarB2 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
        if (!(zzaoVarB2 instanceof zzae)) {
            throw new IllegalArgumentException(b.C("FN requires an ArrayValue of parameter names found ", zzaoVarB2.getClass().getCanonicalName()));
        }
        List listK = ((zzae) zzaoVarB2).k();
        List arrayList2 = new ArrayList();
        if (arrayList.size() > 2) {
            arrayList2 = arrayList.subList(2, arrayList.size());
        }
        return new zzan(zzaoVarB.zzc(), (ArrayList) listK, arrayList2, zzgVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.e(str).ordinal();
        if (iOrdinal == 2) {
            zzh.a("APPLY", arrayList, 3);
            zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzao zzaoVar = (zzao) arrayList.get(1);
            zzaw zzawVar = zzgVar.f36956b;
            String strZzc = zzawVar.b(zzgVar, zzaoVar).zzc();
            zzao zzaoVarB2 = zzawVar.b(zzgVar, (zzao) arrayList.get(2));
            if (!(zzaoVarB2 instanceof zzae)) {
                throw new IllegalArgumentException(b.C("Function arguments for Apply are not a list found ", zzaoVarB2.getClass().getCanonicalName()));
            }
            if (strZzc.isEmpty()) {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
            return zzaoVarB.i(strZzc, zzgVar, (ArrayList) ((zzae) zzaoVarB2).k());
        }
        if (iOrdinal == 15) {
            zzh.a("BREAK", arrayList, 0);
            return zzao.q0;
        }
        if (iOrdinal == 25) {
            return c(zzgVar, arrayList);
        }
        if (iOrdinal == 41) {
            zzh.b("IF", arrayList, 2);
            zzao zzaoVarB3 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzao zzaoVar2 = (zzao) arrayList.get(1);
            zzaw zzawVar2 = zzgVar.f36956b;
            zzao zzaoVarB4 = zzawVar2.b(zzgVar, zzaoVar2);
            zzao zzaoVarB5 = arrayList.size() > 2 ? zzawVar2.b(zzgVar, (zzao) arrayList.get(2)) : null;
            zzao zzaoVar3 = zzao.o0;
            zzao zzaoVarB6 = zzaoVarB3.zze().booleanValue() ? zzgVar.b((zzae) zzaoVarB4) : zzaoVarB5 != null ? zzgVar.b((zzae) zzaoVarB5) : zzaoVar3;
            return true != (zzaoVarB6 instanceof zzag) ? zzaoVar3 : zzaoVarB6;
        }
        if (iOrdinal == 54) {
            return new zzae(arrayList);
        }
        if (iOrdinal == 57) {
            if (arrayList.isEmpty()) {
                return zzao.s0;
            }
            zzh.a("RETURN", arrayList, 1);
            return new zzag("return", zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)));
        }
        if (iOrdinal != 19) {
            if (iOrdinal == 20) {
                zzh.b("DEFINE_FUNCTION", arrayList, 2);
                zzan zzanVarC = c(zzgVar, arrayList);
                String str2 = zzanVarC.f36762a;
                if (str2 == null) {
                    zzgVar.e("", zzanVarC);
                    return zzanVarC;
                }
                zzgVar.e(str2, zzanVarC);
                return zzanVarC;
            }
            if (iOrdinal == 60) {
                zzh.a("SWITCH", arrayList, 3);
                zzao zzaoVarB7 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
                zzao zzaoVar4 = (zzao) arrayList.get(1);
                zzaw zzawVar3 = zzgVar.f36956b;
                zzao zzaoVarB8 = zzawVar3.b(zzgVar, zzaoVar4);
                zzao zzaoVarB9 = zzawVar3.b(zzgVar, (zzao) arrayList.get(2));
                if (!(zzaoVarB8 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if (!(zzaoVarB9 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                zzae zzaeVar = (zzae) zzaoVarB8;
                zzae zzaeVar2 = (zzae) zzaoVarB9;
                boolean z = false;
                for (int i2 = 0; i2 < zzaeVar.n(); i2++) {
                    if (z || zzaoVarB7.equals(zzawVar3.b(zzgVar, zzaeVar.o(i2)))) {
                        zzao zzaoVarB10 = zzawVar3.b(zzgVar, zzaeVar2.o(i2));
                        if (zzaoVarB10 instanceof zzag) {
                            return ((zzag) zzaoVarB10).f36760b.equals("break") ? zzao.o0 : zzaoVarB10;
                        }
                        z = true;
                    } else {
                        z = false;
                    }
                }
                if (zzaeVar.n() + 1 == zzaeVar2.n()) {
                    zzao zzaoVarB11 = zzawVar3.b(zzgVar, zzaeVar2.o(zzaeVar.n()));
                    if (zzaoVarB11 instanceof zzag) {
                        String str3 = ((zzag) zzaoVarB11).f36760b;
                        if (str3.equals("return") || str3.equals("continue")) {
                            return zzaoVarB11;
                        }
                    }
                }
                return zzao.o0;
            }
            if (iOrdinal == 61) {
                zzh.a("TERNARY", arrayList, 3);
                boolean zBooleanValue = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zze().booleanValue();
                zzaw zzawVar4 = zzgVar.f36956b;
                return zBooleanValue ? zzawVar4.b(zzgVar, (zzao) arrayList.get(1)) : zzawVar4.b(zzgVar, (zzao) arrayList.get(2));
            }
            switch (iOrdinal) {
                case 11:
                    return zzgVar.c().b(new zzae(arrayList));
                case 12:
                    zzh.a("BREAK", arrayList, 0);
                    return zzao.r0;
                case 13:
                    break;
                default:
                    b(str);
                    throw null;
            }
        }
        if (arrayList.isEmpty()) {
            return zzao.o0;
        }
        zzao zzaoVarB12 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
        return zzaoVarB12 instanceof zzae ? zzgVar.b((zzae) zzaoVarB12) : zzao.o0;
    }
}
