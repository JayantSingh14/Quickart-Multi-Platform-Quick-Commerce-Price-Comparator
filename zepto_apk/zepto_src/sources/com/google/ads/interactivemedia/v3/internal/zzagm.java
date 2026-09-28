package com.google.ads.interactivemedia.v3.internal;

/* loaded from: classes3.dex */
final class zzagm {
    private final Object zza;
    private final int zzb;

    public zzagm(Object obj) {
        this.zzb = System.identityHashCode(obj);
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzagm)) {
            return false;
        }
        zzagm zzagmVar = (zzagm) obj;
        return this.zzb == zzagmVar.zzb && this.zza == zzagmVar.zza;
    }

    public final int hashCode() {
        return this.zzb;
    }
}
