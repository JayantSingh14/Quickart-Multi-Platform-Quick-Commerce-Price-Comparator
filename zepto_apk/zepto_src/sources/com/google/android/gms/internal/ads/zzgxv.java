package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
final class zzgxv extends zzgxx {
    public zzgxv(zzgtd zzgtdVar, boolean z) {
        List arrayList;
        super(zzgtdVar, z, true);
        if (zzgtdVar.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            int size = zzgtdVar.size();
            zzgrz.b(size, "initialArraySize");
            arrayList = new ArrayList(size);
        }
        for (int i2 = 0; i2 < zzgtdVar.size(); i2++) {
            arrayList.add(null);
        }
        this.p = arrayList;
        w();
    }

    @Override // com.google.android.gms.internal.ads.zzgxx
    public final List z(List list) {
        int size = list.size();
        zzgrz.b(size, "initialArraySize");
        ArrayList arrayList = new ArrayList(size);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgxw zzgxwVar = (zzgxw) it.next();
            arrayList.add(zzgxwVar != null ? zzgxwVar.f33358a : null);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
