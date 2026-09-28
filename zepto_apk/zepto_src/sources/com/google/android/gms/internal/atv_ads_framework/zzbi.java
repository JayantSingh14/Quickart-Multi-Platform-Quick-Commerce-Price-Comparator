package com.google.android.gms.internal.atv_ads_framework;

import android.support.v4.media.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public abstract class zzbi extends zzbb implements Set {

    /* renamed from: b, reason: collision with root package name */
    public transient zzbe f36055b;

    public static int m(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            if (iMax < 1073741824) {
                return 1073741824;
            }
            throw new IllegalArgumentException("collection too large");
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (iHighestOneBit * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzbi o(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzbr.f36075i;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            obj.getClass();
            return new zzbt(obj);
        }
        int iM = m(i2);
        Object[] objArr2 = new Object[iM];
        int i3 = iM - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            Object obj2 = objArr[i6];
            if (obj2 == null) {
                throw new NullPointerException(b.f(i6, "at index "));
            }
            int iHashCode = obj2.hashCode();
            int iA = zzba.a(iHashCode);
            while (true) {
                int i7 = iA & i3;
                Object obj3 = objArr2[i7];
                if (obj3 == null) {
                    objArr[i5] = obj2;
                    objArr2[i7] = obj2;
                    i4 += iHashCode;
                    i5++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iA++;
                }
            }
        }
        Arrays.fill(objArr, i5, i2, (Object) null);
        if (i5 == 1) {
            Object obj4 = objArr[0];
            obj4.getClass();
            return new zzbt(obj4);
        }
        if (m(i5) < iM / 2) {
            return o(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new zzbr(objArr, i4, objArr2, i3, i5);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzbi) && (this instanceof zzbr)) {
            zzbi zzbiVar = (zzbi) obj;
            zzbiVar.getClass();
            if ((zzbiVar instanceof zzbr) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb
    public zzbe g() {
        zzbe zzbeVar = this.f36055b;
        if (zzbeVar != null) {
            return zzbeVar;
        }
        zzbe zzbeVarN = n();
        this.f36055b = zzbeVarN;
        return zzbeVarN;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // com.google.android.gms.internal.atv_ads_framework.zzbb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzbe n() {
        Object[] array = toArray(zzbb.f36040a);
        zzbv zzbvVar = zzbe.f36045b;
        return zzbe.n(array.length, array);
    }
}
