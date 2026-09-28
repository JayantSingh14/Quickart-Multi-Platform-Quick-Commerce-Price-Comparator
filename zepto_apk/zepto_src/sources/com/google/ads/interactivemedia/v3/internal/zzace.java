package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzace {
    private static final zzacc zza = new zzacd();
    private static final zzacc zzb;

    static {
        zzacc zzaccVar = null;
        try {
            zzaccVar = (zzacc) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
        }
        zzb = zzaccVar;
    }

    public static zzacc zza() {
        zzacc zzaccVar = zzb;
        if (zzaccVar != null) {
            return zzaccVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzacc zzb() {
        return zza;
    }
}
