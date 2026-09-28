package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbas extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final zzayw f24648h;

    /* renamed from: i, reason: collision with root package name */
    public final long f24649i;

    /* renamed from: j, reason: collision with root package name */
    public final long f24650j;

    public zzbas(zzazt zzaztVar, zzavs zzavsVar, int i2, zzayw zzaywVar, long j2, long j3) {
        super(zzaztVar, "1MiCMWad12oLn5alnMxHwTvbBZm7RpaUcGFZ/LjrpVbPksWcBk53Qc+euKdOo/dG", "/cnUVQvNHFqi3ggOmiA4o/IdQSFHoegJ/H9a2xERT14=", zzavsVar, i2, 11);
        this.f24648h = zzaywVar;
        this.f24649i = j2;
        this.f24650j = j3;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzayw zzaywVar = this.f24648h;
        if (zzaywVar != null) {
            String str = (String) this.f24673e.invoke(null, zzaywVar.f24519a, Long.valueOf(this.f24649i), Long.valueOf(this.f24650j));
            zzayu zzayuVar = new zzayu();
            HashMap mapB = zzaxi.b(str);
            if (mapB != null) {
                zzayuVar.f24515a = (Long) mapB.get(0);
                zzayuVar.f24516b = (Long) mapB.get(1);
                zzayuVar.f24517c = (Long) mapB.get(2);
            }
            zzavs zzavsVar = this.f24672d;
            synchronized (zzavsVar) {
                try {
                    long jLongValue = zzayuVar.f24515a.longValue();
                    zzavsVar.j();
                    ((zzawp) zzavsVar.f34638b).M0(jLongValue);
                    if (zzayuVar.f24516b.longValue() >= 0) {
                        long jLongValue2 = zzayuVar.f24516b.longValue();
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).j0(jLongValue2);
                    }
                    if (zzayuVar.f24517c.longValue() >= 0) {
                        long jLongValue3 = zzayuVar.f24517c.longValue();
                        zzavsVar.j();
                        ((zzawp) zzavsVar.f34638b).k0(jLongValue3);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
