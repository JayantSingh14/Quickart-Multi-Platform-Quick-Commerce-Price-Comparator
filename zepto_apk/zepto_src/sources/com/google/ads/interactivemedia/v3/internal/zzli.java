package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
public final class zzli {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    public zzli(String str, Object obj, int i2) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i2;
    }

    public static zzli zza(String str, boolean z) {
        return new zzli(str, Boolean.valueOf(z), 1);
    }

    public final Object zzb() {
        zzlm zzlmVarZza = zzlo.zza();
        if (zzlmVarZza != null) {
            return this.zzc + (-1) != 0 ? zzlmVarZza.zzb(this.zza, ((Long) this.zzb).longValue()) : zzlmVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (zzlo.zzb() != null) {
            zzlo.zzb().zza();
        }
        return this.zzb;
    }
}
