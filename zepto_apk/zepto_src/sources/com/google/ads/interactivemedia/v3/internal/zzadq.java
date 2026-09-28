package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzadq implements zzadx {
    private final zzadx[] zza;

    public zzadq(zzadx... zzadxVarArr) {
        this.zza = zzadxVarArr;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadx
    public final zzadw zzb(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            zzadx zzadxVar = this.zza[i2];
            if (zzadxVar.zzc(cls)) {
                return zzadxVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadx
    public final boolean zzc(Class cls) {
        for (int i2 = 0; i2 < 2; i2++) {
            if (this.zza[i2].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
