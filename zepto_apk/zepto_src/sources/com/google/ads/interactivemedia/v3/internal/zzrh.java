package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public final class zzrh {
    public static int zza(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }
}
