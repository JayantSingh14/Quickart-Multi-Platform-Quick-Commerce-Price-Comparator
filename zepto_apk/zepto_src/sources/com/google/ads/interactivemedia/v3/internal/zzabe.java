package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;

/* loaded from: classes3.dex */
final class zzabe implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzabn zzabnVar = (zzabn) obj;
        zzabn zzabnVar2 = (zzabn) obj2;
        zzabh it = zzabnVar.iterator();
        zzabh it2 = zzabnVar2.iterator();
        while (it.hasNext() && it2.hasNext()) {
            int iCompareTo = Integer.valueOf(it.zza() & 255).compareTo(Integer.valueOf(it2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzabnVar.zzd()).compareTo(Integer.valueOf(zzabnVar2.zzd()));
    }
}
