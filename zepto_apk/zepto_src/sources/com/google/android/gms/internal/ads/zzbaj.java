package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbaj extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public static volatile Long f24634h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f24635i = new Object();

    public zzbaj(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "N+SNt584k90MWn4aBLIhSutg85cYgcNyu+q+5WGRUo/oWkmPivq/1xlEIBG+GcFK", "VOVDFi9LxFQe2QWzKEnmStNUha/UwjqmQV12jeIMYds=", zzavsVar, i2, 44);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        if (f24634h == null) {
            synchronized (f24635i) {
                try {
                    if (f24634h == null) {
                        f24634h = (Long) this.f24673e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            long jLongValue = f24634h.longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).O(jLongValue);
        }
    }
}
