package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.SortedSet;

/* loaded from: classes3.dex */
final class zzrk {
    public static boolean zza(Comparator comparator, Iterable iterable) {
        Comparator comparator2;
        comparator.getClass();
        iterable.getClass();
        if (iterable instanceof SortedSet) {
            comparator2 = ((SortedSet) iterable).comparator();
            if (comparator2 == null) {
                comparator2 = zzqu.zza;
            }
        } else {
            if (!(iterable instanceof zzrj)) {
                return false;
            }
            comparator2 = ((zzrj) iterable).comparator();
        }
        return comparator.equals(comparator2);
    }
}
