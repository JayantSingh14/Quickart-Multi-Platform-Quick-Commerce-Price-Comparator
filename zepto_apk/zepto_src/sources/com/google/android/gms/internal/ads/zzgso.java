package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes4.dex */
final class zzgso extends zzgsq {
    public static final zzgsq f(int i2) {
        return i2 < 0 ? zzgsq.f33168b : i2 > 0 ? zzgsq.f33169c : zzgsq.f33167a;
    }

    @Override // com.google.android.gms.internal.ads.zzgsq
    public final zzgsq a(Object obj, Object obj2, Comparator comparator) {
        return f(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzgsq
    public final zzgsq b(int i2, int i3) {
        return f(Integer.compare(i2, i3));
    }

    @Override // com.google.android.gms.internal.ads.zzgsq
    public final zzgsq c(boolean z, boolean z2) {
        return f(Boolean.compare(z2, z));
    }

    @Override // com.google.android.gms.internal.ads.zzgsq
    public final zzgsq d(boolean z, boolean z2) {
        return f(Boolean.compare(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzgsq
    public final int e() {
        return 0;
    }
}
