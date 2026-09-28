package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbay extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public final boolean f24655h;

    public zzbay(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "i1MP+hbN0GtKV+UrtunReVDE3xh08srd5laBoZPswSp8P1i6BkpyGoiKZr6P+aBQ", "NQ1lo07HyX6R6o9xhF+JysjB/gJoli3QRzxLpFE7RH8=", zzavsVar, i2, 61);
        this.f24655h = zzaztVar.o.f24541a;
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        long jLongValue = ((Long) this.f24673e.invoke(null, this.f24669a.f24558a, Boolean.valueOf(this.f24655h))).longValue();
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).d0(jLongValue);
        }
    }
}
