package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes3.dex */
public abstract class zzqk<E> extends zzqb<E> implements Set<E> {

    @CheckForNull
    private transient zzqf zza;

    private static zzqk zzh(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzrd.zza;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzri(obj);
        }
        int iZzj = zzj(i2);
        Object[] objArr2 = new Object[iZzj];
        int i3 = iZzj - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            Object obj2 = objArr[i6];
            zzqv.zza(obj2, i6);
            int iHashCode = obj2.hashCode();
            int iZzb = zzpz.zzb(iHashCode);
            while (true) {
                int i7 = iZzb & i3;
                Object obj3 = objArr2[i7];
                if (obj3 == null) {
                    objArr[i5] = obj2;
                    objArr2[i7] = obj2;
                    i4 += iHashCode;
                    i5++;
                    break;
                }
                if (!obj3.equals(obj2)) {
                    iZzb++;
                }
            }
        }
        Arrays.fill(objArr, i5, i2, (Object) null);
        if (i5 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzri(obj4);
        }
        if (zzj(i5) < iZzj / 2) {
            return zzh(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new zzrd(objArr, i4, objArr2, i3, i5);
    }

    public static int zzj(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            zzpd.zzd(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (iHighestOneBit * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzqk zzl(Collection collection) {
        if ((collection instanceof zzqk) && !(collection instanceof SortedSet)) {
            zzqk zzqkVar = (zzqk) collection;
            if (!zzqkVar.zzf()) {
                return zzqkVar;
            }
        }
        Object[] array = collection.toArray();
        return zzh(array.length, array);
    }

    public static zzqk zzm(Object obj) {
        return new zzri(obj);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzqk) && zzi() && ((zzqk) obj).zzi() && hashCode() != obj.hashCode()) {
            return false;
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

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzrh.zza(this);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb
    public zzqf zzd() {
        zzqf zzqfVar = this.zza;
        if (zzqfVar != null) {
            return zzqfVar;
        }
        zzqf zzqfVarZzk = zzk();
        this.zza = zzqfVarZzk;
        return zzqfVarZzk;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.zzqb, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zze */
    public abstract zzrl iterator();

    public boolean zzi() {
        return false;
    }

    public zzqf zzk() {
        Object[] array = toArray();
        int i2 = zzqf.zzd;
        return zzqf.zzj(array, array.length);
    }
}
