package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class zzgvg extends zzgux implements Serializable {
    public zzgvg() {
        zzgux zzguxVar = zzzu.f35988k;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzgux zzguxVar = zzzu.f35988k;
        return zzza.f35946a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgvg)) {
            return false;
        }
        Object obj2 = zzzu.f35988k;
        ((zzgvg) obj).getClass();
        return obj2.equals(obj2);
    }

    public final int hashCode() {
        zzgux zzguxVar = zzzu.f35988k;
        return -zzza.f35946a.hashCode();
    }

    public final String toString() {
        zzgux zzguxVar = zzzu.f35988k;
        return zzza.f35946a.toString().concat(".reverse()");
    }
}
