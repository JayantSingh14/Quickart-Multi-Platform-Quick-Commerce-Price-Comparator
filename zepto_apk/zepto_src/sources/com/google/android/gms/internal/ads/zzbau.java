package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbau extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f24651h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f24652i = new Object();

    public zzbau(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "MMDDWI2IGLmF5pG/RRqJJZVb/JAirVaBalbjWCkub0DwWmFp7b+bfaTjmPK9uiWU", "m1dpreCDNlkoMOYdr+vmzaz+jSmUZiIrETih78jZTqg=", zzavsVar, i2, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        zzavsVar.j();
        ((zzawp) zzavsVar.f34638b).H0("E");
        if (f24651h == null) {
            synchronized (f24652i) {
                try {
                    if (f24651h == null) {
                        f24651h = (String) this.f24673e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        zzavs zzavsVar2 = this.f24672d;
        synchronized (zzavsVar2) {
            String str = f24651h;
            zzavsVar2.j();
            ((zzawp) zzavsVar2.f34638b).H0(str);
        }
    }
}
