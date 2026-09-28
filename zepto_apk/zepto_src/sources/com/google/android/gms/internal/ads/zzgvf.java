package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class zzgvf extends zzgux implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final zzgvf f33255a = new zzgvf();

    @Override // java.util.Comparator
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
}
