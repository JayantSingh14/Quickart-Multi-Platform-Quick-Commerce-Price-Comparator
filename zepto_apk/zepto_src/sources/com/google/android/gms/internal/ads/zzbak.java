package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbak extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final long f24636h;

    public zzbak(zzazt zzaztVar, zzavs zzavsVar, long j2, int i2) {
        super(zzaztVar, "6Tbgi6IQESKZikJOpZcClcVJxza1rhAf3nfasZu/vDcTd3loITpTNbH23xjyLA5L", "g107GCb4k6+PXON8scRHoxvRnyAK9ZOpFHjKTWKkbXc=", zzavsVar, i2, 25);
        this.f24636h = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        long jLongValue = ((Long) this.f24673e.invoke(null, null)).longValue();
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).q0(jLongValue);
            long j2 = this.f24636h;
            if (j2 != 0) {
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).R0(jLongValue - j2);
                zzavsVar.j();
                ((zzawp) zzavsVar.f34638b).U0(j2);
            }
        }
    }
}
