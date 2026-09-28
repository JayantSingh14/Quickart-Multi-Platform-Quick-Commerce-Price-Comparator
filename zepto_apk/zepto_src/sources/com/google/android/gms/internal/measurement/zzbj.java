package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import androidx.fragment.app.e;
import coil3.network.internal.UtilsKt;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzbj extends zzav {
    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        String str2;
        zzbk zzbkVar = zzbk.ADD;
        int iOrdinal = zzh.e(str).ordinal();
        int i2 = 0;
        if (iOrdinal == 3) {
            zzh.a("ASSIGN", arrayList, 2);
            zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            if (!(zzaoVarB instanceof zzas)) {
                throw new IllegalArgumentException(b.C("Expected string for assign var. got ", zzaoVarB.getClass().getCanonicalName()));
            }
            zzas zzasVar = (zzas) zzaoVarB;
            boolean zD = zzgVar.d(zzasVar.f36775a);
            String str3 = zzasVar.f36775a;
            if (!zD) {
                throw new IllegalArgumentException(b.C("Attempting to assign undefined value ", str3));
            }
            zzao zzaoVarB2 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
            zzgVar.e(str3, zzaoVarB2);
            return zzaoVarB2;
        }
        if (iOrdinal == 14) {
            zzh.b("CONST", arrayList, 2);
            if (arrayList.size() % 2 != 0) {
                throw new IllegalArgumentException(b.f(arrayList.size(), "CONST requires an even number of arguments, found "));
            }
            while (i2 < arrayList.size() - 1) {
                zzao zzaoVarB3 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(i2));
                if (!(zzaoVarB3 instanceof zzas)) {
                    throw new IllegalArgumentException(b.C("Expected string for const name. got ", zzaoVarB3.getClass().getCanonicalName()));
                }
                String str4 = ((zzas) zzaoVarB3).f36775a;
                zzgVar.f(str4, zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(i2 + 1)));
                zzgVar.f36958d.put(str4, Boolean.TRUE);
                i2 += 2;
            }
            return zzao.o0;
        }
        if (iOrdinal == 24) {
            zzh.b("EXPRESSION_LIST", arrayList, 1);
            zzao zzaoVarB4 = zzao.o0;
            while (i2 < arrayList.size()) {
                zzaoVarB4 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(i2));
                if (zzaoVarB4 instanceof zzag) {
                    throw new IllegalStateException("ControlValue cannot be in an expression list");
                }
                i2++;
            }
            return zzaoVarB4;
        }
        if (iOrdinal == 33) {
            zzh.a(UtilsKt.HTTP_METHOD_GET, arrayList, 1);
            zzao zzaoVarB5 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            if (zzaoVarB5 instanceof zzas) {
                return zzgVar.g(((zzas) zzaoVarB5).f36775a);
            }
            throw new IllegalArgumentException(b.C("Expected string for get var. got ", zzaoVarB5.getClass().getCanonicalName()));
        }
        if (iOrdinal == 49) {
            zzh.a("NULL", arrayList, 0);
            return zzao.p0;
        }
        if (iOrdinal == 58) {
            zzh.a("SET_PROPERTY", arrayList, 3);
            zzao zzaoVarB6 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzao zzaoVar = (zzao) arrayList.get(1);
            zzaw zzawVar = zzgVar.f36956b;
            zzao zzaoVarB7 = zzawVar.b(zzgVar, zzaoVar);
            zzao zzaoVarB8 = zzawVar.b(zzgVar, (zzao) arrayList.get(2));
            if (zzaoVarB6 == zzao.o0 || zzaoVarB6 == zzao.p0) {
                throw new IllegalStateException(e.p("Can't set property ", zzaoVarB7.zzc(), " of ", zzaoVarB6.zzc()));
            }
            if ((zzaoVarB6 instanceof zzae) && (zzaoVarB7 instanceof zzah)) {
                ((zzae) zzaoVarB6).p(((zzah) zzaoVarB7).f36761a.intValue(), zzaoVarB8);
                return zzaoVarB8;
            }
            if (!(zzaoVarB6 instanceof zzak)) {
                return zzaoVarB8;
            }
            ((zzak) zzaoVarB6).d(zzaoVarB7.zzc(), zzaoVarB8);
            return zzaoVarB8;
        }
        if (iOrdinal == 17) {
            if (arrayList.isEmpty()) {
                return new zzae();
            }
            zzae zzaeVar = new zzae();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                zzao zzaoVarB9 = zzgVar.f36956b.b(zzgVar, (zzao) it.next());
                if (zzaoVarB9 instanceof zzag) {
                    throw new IllegalStateException("Failed to evaluate array element");
                }
                zzaeVar.p(i2, zzaoVarB9);
                i2++;
            }
            return zzaeVar;
        }
        if (iOrdinal == 18) {
            if (arrayList.isEmpty()) {
                return new zzal();
            }
            if (arrayList.size() % 2 != 0) {
                throw new IllegalArgumentException(b.f(arrayList.size(), "CREATE_OBJECT requires an even number of arguments, found "));
            }
            zzal zzalVar = new zzal();
            while (i2 < arrayList.size() - 1) {
                zzao zzaoVarB10 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(i2));
                zzao zzaoVarB11 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(i2 + 1));
                if ((zzaoVarB10 instanceof zzag) || (zzaoVarB11 instanceof zzag)) {
                    throw new IllegalStateException("Failed to evaluate map entry");
                }
                zzalVar.d(zzaoVarB10.zzc(), zzaoVarB11);
                i2 += 2;
            }
            return zzalVar;
        }
        if (iOrdinal == 35 || iOrdinal == 36) {
            zzh.a("GET_PROPERTY", arrayList, 2);
            zzao zzaoVarB12 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
            zzao zzaoVarB13 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
            if ((zzaoVarB12 instanceof zzae) && zzh.d(zzaoVarB13)) {
                return ((zzae) zzaoVarB12).o(zzaoVarB13.zzd().intValue());
            }
            if (zzaoVarB12 instanceof zzak) {
                return ((zzak) zzaoVarB12).b(zzaoVarB13.zzc());
            }
            if (zzaoVarB12 instanceof zzas) {
                if ("length".equals(zzaoVarB13.zzc())) {
                    return new zzah(Double.valueOf(((zzas) zzaoVarB12).f36775a.length()));
                }
                if (zzh.d(zzaoVarB13)) {
                    zzas zzasVar2 = (zzas) zzaoVarB12;
                    if (zzaoVarB13.zzd().doubleValue() < zzasVar2.f36775a.length()) {
                        return new zzas(String.valueOf(zzasVar2.f36775a.charAt(zzaoVarB13.zzd().intValue())));
                    }
                }
            }
            return zzao.o0;
        }
        switch (iOrdinal) {
            case 62:
                zzh.a("TYPEOF", arrayList, 1);
                zzao zzaoVarB14 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
                if (zzaoVarB14 instanceof zzat) {
                    str2 = "undefined";
                } else if (zzaoVarB14 instanceof zzaf) {
                    str2 = "boolean";
                } else if (zzaoVarB14 instanceof zzah) {
                    str2 = "number";
                } else if (zzaoVarB14 instanceof zzas) {
                    str2 = "string";
                } else if (zzaoVarB14 instanceof zzan) {
                    str2 = "function";
                } else {
                    if ((zzaoVarB14 instanceof zzap) || (zzaoVarB14 instanceof zzag)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzaoVarB14));
                    }
                    str2 = "object";
                }
                return new zzas(str2);
            case 63:
                zzh.a("UNDEFINED", arrayList, 0);
                return zzao.o0;
            case 64:
                zzh.b("VAR", arrayList, 1);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    zzao zzaoVarB15 = zzgVar.f36956b.b(zzgVar, (zzao) it2.next());
                    if (!(zzaoVarB15 instanceof zzas)) {
                        throw new IllegalArgumentException(b.C("Expected string for var name. got ", zzaoVarB15.getClass().getCanonicalName()));
                    }
                    zzgVar.f(((zzas) zzaoVarB15).f36775a, zzao.o0);
                }
                return zzao.o0;
            default:
                b(str);
                throw null;
        }
    }
}
