package com.google.android.gms.internal.ads;

import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class zzban extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final zzazu f24641h;

    public zzban(zzazt zzaztVar, zzavs zzavsVar, int i2, zzazu zzazuVar) {
        super(zzaztVar, "OKoG374XK3cB1cjYFPuO/Bg6vy6AufzuCyu4QCURxkWhJwL4+NqQjs8XziSHB+CQ", "PjHrXBXcXoGkJe75zH8RZ0khapXmOV4o2gX+YgkGdus=", zzavsVar, i2, 85);
        this.f24641h = zzazuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        Method method = this.f24673e;
        zzazu zzazuVar = this.f24641h;
        long[] jArr = (long[]) method.invoke(null, Long.valueOf(zzazuVar.f24573c), Long.valueOf(zzazuVar.f24574d), Long.valueOf(zzazuVar.f24575e), Long.valueOf(zzazuVar.f24576f));
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            long j2 = jArr[0];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).l0(j2);
            long j3 = jArr[1];
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).m0(j3);
        }
    }
}
