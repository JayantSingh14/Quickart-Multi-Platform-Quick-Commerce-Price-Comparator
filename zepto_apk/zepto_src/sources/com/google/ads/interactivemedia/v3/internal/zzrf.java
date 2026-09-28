package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class zzrf extends zzqw implements Serializable {
    static final zzrf zza = new zzrf();

    private zzrf() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw
    public final zzqw zza() {
        return zzqu.zza;
    }
}
