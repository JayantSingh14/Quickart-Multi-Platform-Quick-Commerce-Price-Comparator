package com.google.android.gms.internal.measurement;

import android.support.v4.media.b;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public interface zzak {
    static zzao g(zzak zzakVar, zzas zzasVar, zzg zzgVar, ArrayList arrayList) {
        String str = zzasVar.f36775a;
        if (zzakVar.j(str)) {
            zzao zzaoVarB = zzakVar.b(str);
            if (zzaoVarB instanceof zzai) {
                return ((zzai) zzaoVarB).a(zzgVar, arrayList);
            }
            throw new IllegalArgumentException(b.k(str, " is not a function"));
        }
        if (!"hasOwnProperty".equals(str)) {
            throw new IllegalArgumentException(b.C("Object has no function ", str));
        }
        zzh.a("hasOwnProperty", arrayList, 1);
        return zzakVar.j(zzgVar.f36956b.b(zzgVar, (zzao) arrayList.get(0)).zzc()) ? zzao.t0 : zzao.u0;
    }

    zzao b(String str);

    void d(String str, zzao zzaoVar);

    boolean j(String str);
}
