package com.google.android.gms.internal.atv_ads_framework;

import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzcf implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzcn zzcnVar = (zzcn) obj;
        zzcn zzcnVar2 = (zzcn) obj2;
        zzce zzceVar = new zzce(zzcnVar);
        zzce zzceVar2 = new zzce(zzcnVar2);
        while (zzceVar.hasNext() && zzceVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzceVar.zza() & 255).compareTo(Integer.valueOf(zzceVar2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzcnVar.f()).compareTo(Integer.valueOf(zzcnVar2.f()));
    }
}
