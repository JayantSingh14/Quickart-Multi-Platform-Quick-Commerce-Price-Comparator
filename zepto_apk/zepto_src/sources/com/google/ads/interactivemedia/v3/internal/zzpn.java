package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
final class zzpn extends zzqw implements Serializable {
    final Comparator zza;

    public zzpn(Comparator comparator) {
        comparator.getClass();
        this.zza = comparator;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.zza.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpn) {
            return this.zza.equals(((zzpn) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza.toString();
    }
}
