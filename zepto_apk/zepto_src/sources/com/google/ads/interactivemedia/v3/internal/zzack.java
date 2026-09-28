package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzack implements zzadx {
    private static final zzack zza = new zzack();

    private zzack() {
    }

    public static zzack zza() {
        return zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadx
    public final zzadw zzb(Class cls) {
        if (!zzacq.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzadw) zzacq.zzaz(cls.asSubclass(zzacq.class)).zzj(3, null, null);
        } catch (Exception e2) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e2);
        }
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzadx
    public final boolean zzc(Class cls) {
        return zzacq.class.isAssignableFrom(cls);
    }
}
