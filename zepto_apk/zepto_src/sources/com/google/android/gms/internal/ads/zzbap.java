package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbap extends zzbbh {

    /* renamed from: h, reason: collision with root package name */
    public static volatile Long f24645h;

    /* renamed from: i, reason: collision with root package name */
    public static final Object f24646i = new Object();

    public zzbap(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "b8WdxwEW5LYMXGC6g6q07uNIFUV3fs77AEo1YVb/4q/M8KyV69so1cxJ+MsKyWwh", "kazSW9iygMpHEkKh5zVqXBXYRU+noi3Tzu4hpFfxZG4=", zzavsVar, i2, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        if (f24645h == null) {
            synchronized (f24646i) {
                try {
                    if (f24645h == null) {
                        f24645h = (Long) this.f24673e.invoke(null, null);
                    }
                } finally {
                }
            }
        }
        zzavs zzavsVar = this.f24672d;
        synchronized (zzavsVar) {
            long jLongValue = f24645h.longValue();
            zzavsVar.j();
            ((zzawp) zzavsVar.f34638b).T0(jLongValue);
        }
    }
}
