package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes4.dex */
public final class zzfkk implements zzfkj {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f31321a;

    public zzfkk(com.google.android.gms.ads.internal.client.zzm zzmVar, String str, int i2, String str2, com.google.android.gms.ads.internal.client.zzx zzxVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i2));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzmVar.f21255b));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(a(zzmVar.f21256c));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzmVar.f21256c.getString("npa"));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(zzmVar.f21257d));
        }
        if (hashSet.contains("keywords")) {
            List list = zzmVar.f21258e;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzmVar.f21259f));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzmVar.f21260g));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzmVar.f21261h));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzmVar.f21262i);
        }
        if (hashSet.contains("location")) {
            Location location = zzmVar.f21264k;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzmVar.f21265l);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(a(zzmVar.f21266m));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(a(zzmVar.n));
        }
        if (hashSet.contains("categoryExclusions")) {
            List list2 = zzmVar.o;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzmVar.p);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzmVar.q);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzmVar.r));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzmVar.t));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzmVar.u);
        }
        if (hashSet.contains("orientation")) {
            if (zzxVar != null) {
                arrayList.add(Integer.valueOf(zzxVar.f21306a));
            } else {
                arrayList.add(null);
            }
        }
        this.f31321a = arrayList.toArray();
    }

    public static String a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? a((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfkk) {
            return Arrays.equals(this.f31321a, ((zzfkk) obj).f31321a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f31321a);
    }

    public final String toString() {
        Object[] objArr = this.f31321a;
        int iHashCode = Arrays.hashCode(objArr);
        String string = Arrays.toString(objArr);
        StringBuilder sb = new StringBuilder(String.valueOf(iHashCode).length() + 10 + String.valueOf(string).length() + 1);
        sb.append("[PoolKey#");
        sb.append(iHashCode);
        sb.append(StringUtils.SPACE);
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
