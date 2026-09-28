package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.TreeMap;
import org.npci.upi.security.pinactivitycomponent.CLConstants;

/* loaded from: classes4.dex */
public final class zzv extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final zzz f37321c;

    public zzv(zzz zzzVar) {
        super("internal.registerCallback");
        this.f37321c = zzzVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        TreeMap treeMap;
        zzh.a(this.f36762a, list, 3);
        zzgVar.f36956b.b(zzgVar, (zzao) list.get(0)).zzc();
        zzao zzaoVar = (zzao) list.get(1);
        zzaw zzawVar = zzgVar.f36956b;
        zzao zzaoVarB = zzawVar.b(zzgVar, zzaoVar);
        if (!(zzaoVarB instanceof zzan)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        zzao zzaoVarB2 = zzawVar.b(zzgVar, (zzao) list.get(2));
        if (!(zzaoVarB2 instanceof zzal)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        zzal zzalVar = (zzal) zzaoVarB2;
        if (!zzalVar.f36765a.containsKey("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        String strZzc = zzalVar.b("type").zzc();
        int iG = zzalVar.f36765a.containsKey("priority") ? zzh.g(zzalVar.b("priority").zzd().doubleValue()) : 1000;
        zzan zzanVar = (zzan) zzaoVarB;
        zzz zzzVar = this.f37321c;
        zzzVar.getClass();
        if (CLConstants.CRED_SUB_TYPE_MANDATE_CREATE.equals(strZzc)) {
            treeMap = zzzVar.f37325b;
        } else {
            if (!"edit".equals(strZzc)) {
                throw new IllegalStateException("Unknown callback type: ".concat(String.valueOf(strZzc)));
            }
            treeMap = zzzVar.f37324a;
        }
        if (treeMap.containsKey(Integer.valueOf(iG))) {
            iG = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(iG), zzanVar);
        return zzao.o0;
    }
}
