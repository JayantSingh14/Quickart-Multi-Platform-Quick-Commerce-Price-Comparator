package com.google.android.gms.internal.ads;

/* loaded from: classes4.dex */
public final class zzbbd extends zzbbh {
    public zzbbd(zzazt zzaztVar, zzavs zzavsVar, int i2) {
        super(zzaztVar, "f5uC0Q5BJBhs1YfPGy7Wx7MnBjWVUX5JNaW+Lz6dfUOfz0sIXH0KubqvIhiUByWt", "klWlopX/vpRWeyQx7GUjF52wT93EUJwbeMp05ev02yc=", zzavsVar, i2, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzbbh
    public final void a() {
        zzavs zzavsVar = this.f24672d;
        zzavsVar.n(3);
        boolean zBooleanValue = ((Boolean) this.f24673e.invoke(null, this.f24669a.f24558a)).booleanValue();
        synchronized (zzavsVar) {
            try {
                if (zBooleanValue) {
                    zzavsVar.n(2);
                } else {
                    zzavsVar.n(1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
