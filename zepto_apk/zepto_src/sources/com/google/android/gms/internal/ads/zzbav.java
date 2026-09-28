package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes4.dex */
public final class zzbav extends zzbbh {
    public zzbav(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "8W5EiIZWvw8ca0gdEf2baMelwD0v1LgWFEv6AqIRDGIzRlZJKgzzVYcusXATxgKN", "ZXwHOojdfPkjtU4/T1kRX8Zucxdzz/LL+/XimOcPDrc=", zzavsVar, i2, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        Boolean bool = (Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.x3);
        bool.getClass();
        String str = (String) this.f24673e.invoke(null, this.f24669a.f24558a, bool);
        zzayz zzayzVar = new zzayz();
        zzayzVar.f24523a = -1L;
        zzayzVar.f24524b = -1L;
        HashMap mapB = zzaxi.b(str);
        if (mapB != null) {
            zzayzVar.f24523a = ((Long) mapB.get(0)).longValue();
            zzayzVar.f24524b = ((Long) mapB.get(1)).longValue();
        }
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            long j2 = zzayzVar.f24523a;
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).J0(j2);
            long j3 = zzayzVar.f24524b;
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).b0(j3);
        }
    }
}
