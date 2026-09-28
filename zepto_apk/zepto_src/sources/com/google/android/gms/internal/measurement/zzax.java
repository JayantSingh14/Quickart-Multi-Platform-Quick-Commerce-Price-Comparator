package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import org.xbill.DNS.Type;

/* loaded from: classes4.dex */
public final class zzax extends zzav {
    public zzax() {
        this.f36776a.add(zzbk.EQUALS);
        this.f36776a.add(zzbk.GREATER_THAN);
        this.f36776a.add(zzbk.GREATER_THAN_EQUALS);
        this.f36776a.add(zzbk.IDENTITY_EQUALS);
        this.f36776a.add(zzbk.IDENTITY_NOT_EQUALS);
        this.f36776a.add(zzbk.LESS_THAN);
        this.f36776a.add(zzbk.LESS_THAN_EQUALS);
        this.f36776a.add(zzbk.NOT_EQUALS);
    }

    public static boolean c(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof zzak) {
            zzaoVar = new zzas(zzaoVar.zzc());
        }
        if (zzaoVar2 instanceof zzak) {
            zzaoVar2 = new zzas(zzaoVar2.zzc());
        }
        if ((zzaoVar instanceof zzas) && (zzaoVar2 instanceof zzas)) {
            return ((zzas) zzaoVar).f36775a.compareTo(((zzas) zzaoVar2).f36775a) < 0;
        }
        double dDoubleValue = zzaoVar.zzd().doubleValue();
        double dDoubleValue2 = zzaoVar2.zzd().doubleValue();
        return (Double.isNaN(dDoubleValue) || Double.isNaN(dDoubleValue2) || (dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || ((dDoubleValue == 0.0d && dDoubleValue2 == 0.0d) || Double.compare(dDoubleValue, dDoubleValue2) >= 0)) ? false : true;
    }

    public static boolean d(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar.getClass().equals(zzaoVar2.getClass())) {
            if ((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) {
                return true;
            }
            return zzaoVar instanceof zzah ? (Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue()) || zzaoVar.zzd().doubleValue() != zzaoVar2.zzd().doubleValue()) ? false : true : zzaoVar instanceof zzas ? zzaoVar.zzc().equals(zzaoVar2.zzc()) : zzaoVar instanceof zzaf ? zzaoVar.zze().equals(zzaoVar2.zze()) : zzaoVar == zzaoVar2;
        }
        if (((zzaoVar instanceof zzat) || (zzaoVar instanceof zzam)) && ((zzaoVar2 instanceof zzat) || (zzaoVar2 instanceof zzam))) {
            return true;
        }
        boolean z = zzaoVar instanceof zzah;
        if (z && (zzaoVar2 instanceof zzas)) {
            return d(zzaoVar, new zzah(zzaoVar2.zzd()));
        }
        boolean z2 = zzaoVar instanceof zzas;
        if (z2 && (zzaoVar2 instanceof zzah)) {
            return d(new zzah(zzaoVar.zzd()), zzaoVar2);
        }
        if (zzaoVar instanceof zzaf) {
            return d(new zzah(zzaoVar.zzd()), zzaoVar2);
        }
        if (zzaoVar2 instanceof zzaf) {
            return d(zzaoVar, new zzah(zzaoVar2.zzd()));
        }
        if ((z2 || z) && (zzaoVar2 instanceof zzak)) {
            return d(zzaoVar, new zzas(zzaoVar2.zzc()));
        }
        if ((zzaoVar instanceof zzak) && ((zzaoVar2 instanceof zzas) || (zzaoVar2 instanceof zzah))) {
            return d(new zzas(zzaoVar.zzc()), zzaoVar2);
        }
        return false;
    }

    public static boolean e(zzao zzaoVar, zzao zzaoVar2) {
        if (zzaoVar instanceof zzak) {
            zzaoVar = new zzas(zzaoVar.zzc());
        }
        if (zzaoVar2 instanceof zzak) {
            zzaoVar2 = new zzas(zzaoVar2.zzc());
        }
        return (((zzaoVar instanceof zzas) && (zzaoVar2 instanceof zzas)) || !(Double.isNaN(zzaoVar.zzd().doubleValue()) || Double.isNaN(zzaoVar2.zzd().doubleValue()))) && !c(zzaoVar2, zzaoVar);
    }

    @Override // com.google.android.gms.internal.measurement.zzav
    public final zzao a(String str, zzg zzgVar, ArrayList arrayList) {
        boolean zD;
        boolean zD2;
        zzh.a(zzh.e(str).name(), arrayList, 2);
        zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
        zzao zzaoVarB2 = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
        int iOrdinal = zzh.e(str).ordinal();
        if (iOrdinal != 23) {
            if (iOrdinal == 48) {
                zD2 = d(zzaoVarB, zzaoVarB2);
            } else if (iOrdinal == 42) {
                zD = c(zzaoVarB, zzaoVarB2);
            } else if (iOrdinal != 43) {
                switch (iOrdinal) {
                    case 37:
                        zD = c(zzaoVarB2, zzaoVarB);
                        break;
                    case Type.A6 /* 38 */:
                        zD = e(zzaoVarB2, zzaoVarB);
                        break;
                    case 39:
                        zD = zzh.f(zzaoVarB, zzaoVarB2);
                        break;
                    case 40:
                        zD2 = zzh.f(zzaoVarB, zzaoVarB2);
                        break;
                    default:
                        b(str);
                        throw null;
                }
            } else {
                zD = e(zzaoVarB, zzaoVarB2);
            }
            zD = !zD2;
        } else {
            zD = d(zzaoVarB, zzaoVarB2);
        }
        return zD ? zzao.t0 : zzao.u0;
    }
}
