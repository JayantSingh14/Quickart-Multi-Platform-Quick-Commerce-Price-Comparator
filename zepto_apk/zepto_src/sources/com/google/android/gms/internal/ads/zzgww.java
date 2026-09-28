package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.Spliterator;
import java.util.Spliterators;

/* loaded from: classes4.dex */
final class zzgww extends AbstractList implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final int[] f33300a;

    /* renamed from: b, reason: collision with root package name */
    public final int f33301b;

    /* renamed from: c, reason: collision with root package name */
    public final int f33302c;

    public zzgww(int i2, int i3, int[] iArr) {
        this.f33300a = iArr;
        this.f33301b = i2;
        this.f33302c = i3;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        if (!(obj instanceof Integer)) {
            return false;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i2 = this.f33301b;
        while (true) {
            if (i2 >= this.f33302c) {
                i2 = -1;
                break;
            }
            if (this.f33300a[i2] == iIntValue) {
                break;
            }
            i2++;
        }
        return i2 != -1;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzgww)) {
            return super.equals(obj);
        }
        zzgww zzgwwVar = (zzgww) obj;
        int i2 = zzgwwVar.f33302c;
        int i3 = zzgwwVar.f33301b;
        int i4 = i2 - i3;
        int i5 = this.f33302c;
        int i6 = this.f33301b;
        int i7 = i5 - i6;
        if (i4 != i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (this.f33300a[i6 + i8] != zzgwwVar.f33300a[i3 + i8]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i2) {
        int i3 = this.f33302c;
        int i4 = this.f33301b;
        zzgqa.i(i2, i3 - i4);
        return Integer.valueOf(this.f33300a[i4 + i2]);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iHashCode = 1;
        for (int i2 = this.f33301b; i2 < this.f33302c; i2++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.f33300a[i2]);
        }
        return iHashCode;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i2 = this.f33301b;
            int i3 = i2;
            while (true) {
                if (i3 >= this.f33302c) {
                    i3 = -1;
                    break;
                }
                if (this.f33300a[i3] == iIntValue) {
                    break;
                }
                i3++;
            }
            if (i3 >= 0) {
                return i3 - i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return false;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int lastIndexOf(Object obj) {
        int i2;
        if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            int i3 = this.f33302c - 1;
            while (true) {
                i2 = this.f33301b;
                if (i3 < i2) {
                    i3 = -1;
                    break;
                }
                if (this.f33300a[i3] == iIntValue) {
                    break;
                }
                i3--;
            }
            if (i3 >= 0) {
                return i3 - i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i2, Object obj) {
        int i3 = this.f33302c;
        int i4 = this.f33301b;
        Integer num = (Integer) obj;
        zzgqa.i(i2, i3 - i4);
        int i5 = i4 + i2;
        int[] iArr = this.f33300a;
        int i6 = iArr[i5];
        num.getClass();
        iArr[i5] = num.intValue();
        return Integer.valueOf(i6);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f33302c - this.f33301b;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.List
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return Spliterators.spliterator(this.f33300a, this.f33301b, this.f33302c, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final List subList(int i2, int i3) {
        int i4 = this.f33302c;
        int i5 = this.f33301b;
        zzgqa.k(i2, i3, i4 - i5);
        return i2 == i3 ? Collections.EMPTY_LIST : new zzgww(i2 + i5, i5 + i3, this.f33300a);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        int i2 = this.f33302c;
        int i3 = this.f33301b;
        StringBuilder sb = new StringBuilder((i2 - i3) * 5);
        sb.append('[');
        int[] iArr = this.f33300a;
        sb.append(iArr[i3]);
        while (true) {
            i3++;
            if (i3 >= i2) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(iArr[i3]);
        }
    }
}
