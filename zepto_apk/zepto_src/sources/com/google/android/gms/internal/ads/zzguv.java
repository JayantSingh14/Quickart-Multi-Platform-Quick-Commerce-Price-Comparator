package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* loaded from: classes4.dex */
final class zzguv extends zzgux implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final zzguv f33231a = new zzguv();

    @Override // java.util.Comparator
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
}
