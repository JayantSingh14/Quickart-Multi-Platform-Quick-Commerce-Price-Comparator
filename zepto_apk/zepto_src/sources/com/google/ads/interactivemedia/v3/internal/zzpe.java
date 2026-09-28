package com.google.ads.interactivemedia.v3.internal;

import android.support.v4.media.b;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpe extends zzoy {
    private final Object zza;

    public zzpe(Object obj) {
        this.zza = obj;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzpe) {
            return this.zza.equals(((zzpe) obj).zza);
        }
        return false;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        return b.D("Optional.of(", this.zza.toString(), ")");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final Object zza() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final Object zzb(Object obj) {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final Object zzc() {
        return this.zza;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzoy
    public final boolean zzd() {
        return true;
    }
}
