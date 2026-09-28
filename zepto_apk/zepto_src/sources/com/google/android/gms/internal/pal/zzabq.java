package com.google.android.gms.internal.pal;

import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzabq implements Comparator {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzaby zzabyVar = (zzaby) obj;
        zzaby zzabyVar2 = (zzaby) obj2;
        zzabp zzabpVar = new zzabp(zzabyVar);
        zzabp zzabpVar2 = new zzabp(zzabyVar2);
        while (zzabpVar.hasNext() && zzabpVar2.hasNext()) {
            int iCompareTo = Integer.valueOf(zzabpVar.zza() & 255).compareTo(Integer.valueOf(zzabpVar2.zza() & 255));
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return Integer.valueOf(zzabyVar.f()).compareTo(Integer.valueOf(zzabyVar2.f()));
    }
}
