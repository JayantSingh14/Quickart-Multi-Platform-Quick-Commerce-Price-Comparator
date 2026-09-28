package com.google.android.gms.internal.measurement;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public final class zzz {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f37324a = new TreeMap();

    /* renamed from: b, reason: collision with root package name */
    public final TreeMap f37325b = new TreeMap();

    public final void a(zzg zzgVar, zzab zzabVar) {
        zzl zzlVar = new zzl(zzabVar);
        TreeMap treeMap = this.f37324a;
        for (Integer num : treeMap.keySet()) {
            zzaa zzaaVarClone = zzabVar.f36750b.clone();
            zzao zzaoVarA = ((zzan) treeMap.get(num)).a(zzgVar, Collections.singletonList(zzlVar));
            int iG = zzaoVarA instanceof zzah ? zzh.g(((zzah) zzaoVarA).f36761a.doubleValue()) : -1;
            if (iG == 2 || iG == -1) {
                zzabVar.f36750b = zzaaVarClone;
            }
        }
        TreeMap treeMap2 = this.f37325b;
        Iterator it = treeMap2.keySet().iterator();
        while (it.hasNext()) {
            zzao zzaoVarA2 = ((zzan) treeMap2.get((Integer) it.next())).a(zzgVar, Collections.singletonList(zzlVar));
            if (zzaoVarA2 instanceof zzah) {
                zzh.g(((zzah) zzaoVarA2).f36761a.doubleValue());
            }
        }
    }
}
