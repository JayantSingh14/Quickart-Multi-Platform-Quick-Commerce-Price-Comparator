package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class zzgto extends zzgtj {
    public final void a(Object[] objArr, Object obj) {
        List listAsList = Arrays.asList(objArr);
        if (obj == null) {
            Iterator it = listAsList.iterator();
            StringBuilder sb = new StringBuilder("[");
            boolean z = true;
            while (it.hasNext()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(it.next());
                z = false;
            }
            sb.append(']');
            throw new NullPointerException("null key in entry: null=".concat(sb.toString()));
        }
        Iterator it2 = listAsList.iterator();
        if (it2.hasNext()) {
            Map zzgskVar = this.f33198a;
            if (zzgskVar == null) {
                zzgskVar = new zzgsk();
                this.f33198a = zzgskVar;
            }
            zzgsy zzgsyVarS = (zzgsy) ((zzgsk) zzgskVar).get(obj);
            if (zzgsyVarS == null) {
                zzgsyVarS = zzgtn.s(listAsList instanceof Set ? Math.max(4, ((Set) listAsList).size()) : 4);
                Map zzgskVar2 = this.f33198a;
                if (zzgskVar2 == null) {
                    zzgskVar2 = new zzgsk();
                    this.f33198a = zzgskVar2;
                }
                ((zzgsk) zzgskVar2).put(obj, zzgsyVarS);
            }
            while (it2.hasNext()) {
                Object next = it2.next();
                zzgrz.a(obj, next);
                zzgsyVarS.a(next);
            }
        }
    }
}
