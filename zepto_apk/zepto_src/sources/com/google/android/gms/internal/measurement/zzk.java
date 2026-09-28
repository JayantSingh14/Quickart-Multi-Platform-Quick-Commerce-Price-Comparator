package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzk extends zzai {

    /* renamed from: c, reason: collision with root package name */
    public final zzab f37023c;

    public zzk(zzab zzabVar) {
        super("internal.eventLogger");
        this.f37023c = zzabVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzai
    public final zzao a(zzg zzgVar, List list) {
        zzh.a(this.f36762a, list, 3);
        String strZzc = zzgVar.f36956b.b(zzgVar, (zzao) list.get(0)).zzc();
        zzao zzaoVar = (zzao) list.get(1);
        zzaw zzawVar = zzgVar.f36956b;
        long jH = (long) zzh.h(zzawVar.b(zzgVar, zzaoVar).zzd().doubleValue());
        zzao zzaoVarB = zzawVar.b(zzgVar, (zzao) list.get(2));
        HashMap mapJ = zzaoVarB instanceof zzal ? zzh.j((zzal) zzaoVarB) : new HashMap();
        zzab zzabVar = this.f37023c;
        zzabVar.getClass();
        HashMap map = new HashMap();
        for (String str : mapJ.keySet()) {
            HashMap map2 = zzabVar.f36749a.f36748c;
            map.put(str, zzaa.e(str, map2.containsKey(str) ? map2.get(str) : null, mapJ.get(str)));
        }
        zzabVar.f36751c.add(new zzaa(strZzc, jH, map));
        return zzao.o0;
    }
}
