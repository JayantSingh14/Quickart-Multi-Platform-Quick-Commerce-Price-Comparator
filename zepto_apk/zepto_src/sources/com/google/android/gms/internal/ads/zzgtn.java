package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes4.dex */
public abstract class zzgtn<E> extends zzgsz<E> implements Set<E> {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f33203c = 0;

    /* renamed from: b, reason: collision with root package name */
    public transient zzgtd f33204b;

    public static zzgtn m() {
        return new zzgvo("*");
    }

    public static zzgtn n(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        int length = objArr.length;
        int i2 = length + 6;
        Object[] objArr2 = new Object[i2];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, length);
        return t(i2, objArr2);
    }

    public static int o(int i2) {
        int iMax = Math.max(i2, 2);
        if (iMax >= 751619276) {
            zzgqa.b("collection too large", iMax < 1073741824);
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (iHighestOneBit * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzgtn p(Set set) {
        if ((set instanceof zzgtn) && !(set instanceof SortedSet)) {
            zzgtn zzgtnVar = (zzgtn) set;
            if (!zzgtnVar.j()) {
                return zzgtnVar;
            }
        }
        Object[] array = set.toArray();
        return t(array.length, array);
    }

    public static zzgtn q(Object[] objArr) {
        int length = objArr.length;
        return length != 0 ? length != 1 ? t(length, (Object[]) objArr.clone()) : new zzgvo(objArr[0]) : zzgve.f33249j;
    }

    public static zzgtm s(int i2) {
        zzgrz.b(i2, "expectedSize");
        zzgtm zzgtmVar = new zzgtm(i2);
        zzgtmVar.f33201d = new Object[o(i2)];
        return zzgtmVar;
    }

    public static zzgtn t(int i2, Object... objArr) {
        if (i2 == 0) {
            return zzgve.f33249j;
        }
        if (i2 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzgvo(obj);
        }
        int iO = o(i2);
        Object[] objArr2 = new Object[iO];
        int i3 = iO - 1;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            Object obj2 = objArr[i6];
            zzguw.b(i6, obj2);
            int iHashCode = obj2.hashCode();
            int iA = zzgsw.a(iHashCode);
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
            Objects.requireNonNull(obj4);
            return new zzgvo(obj4);
        }
        if (o(i5) < iO / 2) {
            return t(i5, objArr);
        }
        int length = objArr.length;
        if (i5 < (length >> 1) + (length >> 2)) {
            objArr = Arrays.copyOf(objArr, i5);
        }
        return new zzgve(objArr, i4, objArr2, i3, i5);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgtn) && (this instanceof zzgve)) {
            zzgtn zzgtnVar = (zzgtn) obj;
            zzgtnVar.getClass();
            if ((zzgtnVar instanceof zzgve) && hashCode() != obj.hashCode()) {
                return false;
            }
        }
        return zzgvn.d(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgvn.c(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgsz
    public zzgtd i() {
        zzgtd zzgtdVar = this.f33204b;
        if (zzgtdVar != null) {
            return zzgtdVar;
        }
        zzgtd zzgtdVarR = r();
        this.f33204b = zzgtdVarR;
        return zzgtdVarR;
    }

    @Override // com.google.android.gms.internal.ads.zzgsz, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public zzgtd r() {
        Object[] array = toArray(zzgsz.f33174a);
        zzgvs zzgvsVar = zzgtd.f33183b;
        return zzgtd.t(array.length, array);
    }
}
