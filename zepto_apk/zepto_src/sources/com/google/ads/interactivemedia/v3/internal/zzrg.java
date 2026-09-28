package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzrg extends zzqw implements Serializable {
    final zzqw zza;

    public zzrg(zzqw zzqwVar) {
        this.zza = zzqwVar;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzrg) {
            return this.zza.equals(((zzrg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return -this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString().concat(".reverse()");
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw
    public final zzqw zza() {
        return this.zza;
    }
}
