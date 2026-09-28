package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzgud {
    public static ArrayList a(zzgvr zzgvrVar) {
        ArrayList arrayList = new ArrayList();
        zzgvrVar.getClass();
        while (zzgvrVar.hasNext()) {
            arrayList.add(zzgvrVar.next());
        }
        return arrayList;
    }

    public static AbstractList b(List list, zzgpr zzgprVar) {
        return list != null ? new zzgua(list, zzgprVar) : new zzguc(list, zzgprVar);
    }
}
