package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes4.dex */
final class zzgqc implements Serializable, zzgqb {

    /* renamed from: a, reason: collision with root package name */
    public final List f33068a;

    public final boolean equals(Object obj) {
        if (obj instanceof zzgqc) {
            return this.f33068a.equals(((zzgqc) obj).f33068a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f33068a.hashCode() + 306654252;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Predicates.and(");
        boolean z = true;
        for (Object obj : this.f33068a) {
            if (!z) {
                sb.append(',');
            }
            sb.append(obj);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgqb
    public final boolean zza(Object obj) {
        int i2 = 0;
        while (true) {
            List list = this.f33068a;
            if (i2 >= list.size()) {
                return true;
            }
            if (!((zzgqb) list.get(i2)).zza(obj)) {
                return false;
            }
            i2++;
        }
    }
}
