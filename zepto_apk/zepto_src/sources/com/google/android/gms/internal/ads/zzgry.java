package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzgry extends zzgux implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final zzgpr f33133a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgux f33134b;

    public zzgry() {
        zzcy zzcyVar = zzcy.f27393a;
        zzguv zzguvVar = zzguv.f33231a;
        this.f33133a = zzcyVar;
        this.f33134b = zzguvVar;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzgpr zzgprVar = this.f33133a;
        return this.f33134b.compare(zzgprVar.apply(obj), zzgprVar.apply(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzgry) {
            zzgry zzgryVar = (zzgry) obj;
            if (this.f33133a.equals(zzgryVar.f33133a) && this.f33134b.equals(zzgryVar.f33134b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(this.f33133a, this.f33134b);
    }

    public final String toString() {
        zzguv.f33231a.getClass();
        int length = "Ordering.natural()".length();
        String string = zzcy.f27393a.toString();
        return android.support.v4.media.a.n(new StringBuilder(length + 12 + string.length() + 1), "Ordering.natural()", ".onResultOf(", string, ")");
    }
}
