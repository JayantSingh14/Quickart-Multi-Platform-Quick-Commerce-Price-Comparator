package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbba extends zzbbh {
    public zzbba(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "cOth2BAAthu6X8KDmzC58653OwqftcurhEiV9l+3uxMh7KBnOgbdhGM0zSnSPufi", "2EDSTVCwfkpT+1duJ+umEyNIZ3jEP0NWyK78oeLPLhI=", zzavsVar, i2, 51);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            String str = (String) this.f24673e.invoke(null, null);
            zzazo zzazoVar = new zzazo();
            HashMap mapB = zzaxi.b(str);
            if (mapB != null) {
                zzazoVar.f24550a = (Long) mapB.get(0);
                zzazoVar.f24551b = (Long) mapB.get(1);
            }
            long jLongValue = zzazoVar.f24550a.longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).S(jLongValue);
            long jLongValue2 = zzazoVar.f24551b.longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).T(jLongValue2);
        }
    }
}
