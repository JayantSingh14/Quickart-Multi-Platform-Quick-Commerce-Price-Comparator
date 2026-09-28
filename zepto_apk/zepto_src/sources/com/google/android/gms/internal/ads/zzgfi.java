package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
final class zzgfi extends zzgfz {
    @Override // com.google.android.gms.internal.ads.zzgfz
    public final void a(Method method, zzavs zzavsVar) {
        synchronized (zzavsVar) {
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).H0("E");
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).O(0L);
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).i0("D");
        }
        Object[] objArr = (Object[]) method.invoke("", null);
        objArr.getClass();
        synchronized (zzavsVar) {
            String str = (String) objArr[0];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).H0(str);
            long jLongValue = ((Long) objArr[1]).longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).O(jLongValue);
            String str2 = (String) objArr[2];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).i0(str2);
        }
    }
}
