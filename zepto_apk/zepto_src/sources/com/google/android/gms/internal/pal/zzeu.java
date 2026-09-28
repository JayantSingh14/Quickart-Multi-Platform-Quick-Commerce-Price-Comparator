package com.google.android.gms.internal.pal;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzeu extends zzfg {
    public zzeu(zzdu zzduVar, zzr zzrVar, int i2) {
        super(zzduVar, "vkfQoQl1Rxr7/uvSSRcOrQI31A6S/KAPW33nf5P0hYbuVy6BLjHzjUB4OEnneXoS", "SfaCE2ReDSQ3+KDKcvA6SSrX7nuWYsM/FN3ZFmlH0dA=", zzrVar, i2, 3);
    }

    @Override // com.google.android.gms.internal.pal.zzfg
    public final void a() {
        Boolean bool = (Boolean) zzfv.f37741d.f37744c.a(zzgk.f37776m);
        bool.getClass();
        String str = (String) this.f37727e.invoke(null, this.f37723a.f37634a, bool);
        zzdc zzdcVar = new zzdc();
        zzdcVar.f37608a = -1L;
        zzdcVar.f37609b = -1L;
        HashMap mapA = zzbi.a(str);
        if (mapA != null) {
            zzdcVar.f37608a = ((Long) mapA.get(0)).longValue();
            zzdcVar.f37609b = ((Long) mapA.get(1)).longValue();
        }
        synchronized (this.f37726d) {
            zzr zzrVar = this.f37726d;
            long j2 = zzdcVar.f37608a;
            if (zzrVar.f37406c) {
                zzrVar.k();
                zzrVar.f37406c = false;
            }
            zzaf.m0((zzaf) zzrVar.f37405b, j2);
            zzr zzrVar2 = this.f37726d;
            long j3 = zzdcVar.f37609b;
            if (zzrVar2.f37406c) {
                zzrVar2.k();
                zzrVar2.f37406c = false;
            }
            zzaf.K((zzaf) zzrVar2.f37405b, j3);
        }
    }
}
