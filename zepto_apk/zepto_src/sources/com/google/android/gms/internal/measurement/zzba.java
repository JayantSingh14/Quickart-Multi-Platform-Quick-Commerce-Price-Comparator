package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class zzba {
    public static zzao a(zzae zzaeVar, zzg zzgVar, ArrayList arrayList, boolean z) {
        zzao zzaoVarA;
        zzh.b("reduce", arrayList, 1);
        zzh.c(2, "reduce", arrayList);
        zzao zzaoVarB = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0));
        if (!(zzaoVarB instanceof zzai)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (arrayList.size() == 2) {
            zzaoVarA = zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(1));
            if (zzaoVarA instanceof zzag) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (zzaeVar.n() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            zzaoVarA = null;
        }
        zzai zzaiVar = (zzai) zzaoVarB;
        int iN = zzaeVar.n();
        int i2 = z ? 0 : iN - 1;
        int i3 = z ? iN - 1 : 0;
        int i4 = true == z ? 1 : -1;
        if (zzaoVarA == null) {
            zzaoVarA = zzaeVar.o(i2);
            i2 += i4;
        }
        while ((i3 - i2) * i4 >= 0) {
            if (zzaeVar.q(i2)) {
                zzaoVarA = zzaiVar.a(zzgVar, Arrays.asList(zzaoVarA, zzaeVar.o(i2), new zzah(Double.valueOf(i2)), zzaeVar));
                if (zzaoVarA instanceof zzag) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i2 += i4;
            } else {
                i2 += i4;
            }
        }
        return zzaoVarA;
    }

    public static zzae b(zzae zzaeVar, zzg zzgVar, zzan zzanVar, Boolean bool, Boolean bool2) {
        zzae zzaeVar2 = new zzae();
        Iterator itM = zzaeVar.m();
        while (itM.hasNext()) {
            int iIntValue = ((Integer) itM.next()).intValue();
            if (zzaeVar.q(iIntValue)) {
                zzao zzaoVarA = zzanVar.a(zzgVar, Arrays.asList(zzaeVar.o(iIntValue), new zzah(Double.valueOf(iIntValue)), zzaeVar));
                if (zzaoVarA.zze().equals(bool)) {
                    break;
                }
                if (bool2 == null || zzaoVarA.zze().equals(bool2)) {
                    zzaeVar2.p(iIntValue, zzaoVarA);
                }
            }
        }
        return zzaeVar2;
    }
}
