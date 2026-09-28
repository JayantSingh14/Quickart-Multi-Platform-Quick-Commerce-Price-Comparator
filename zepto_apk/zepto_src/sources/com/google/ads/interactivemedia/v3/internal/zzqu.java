package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;

/* loaded from: classes3.dex */
final class zzqu extends zzqw implements Serializable {
    static final zzqu zza = new zzqu();

    private zzqu() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqw
    public final zzqw zza() {
        return zzrf.zza;
    }
}
