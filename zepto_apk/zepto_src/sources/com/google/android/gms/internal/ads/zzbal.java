package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbal extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public static volatile String f24637h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f24638i = new Object();

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        if (f24637h == null) {
            synchronized (f24638i) {
                try {
                    if (f24637h == null) {
                        f24637h = (String) this.f24673e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            String str = f24637h;
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).i0(str);
        }
    }
}
