package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparator[] f42587a;

    public CompoundOrdering(Ordering ordering, Comparator comparator) {
        this.f42587a = new Comparator[]{ordering, comparator};
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i2 = 0;
        while (true) {
            Comparator[] comparatorArr = this.f42587a;
            if (i2 >= comparatorArr.length) {
                return 0;
            }
            int iCompare = comparatorArr[i2].compare(obj, obj2);
            if (iCompare != 0) {
                return iCompare;
            }
            i2++;
        }
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.f42587a, ((CompoundOrdering) obj).f42587a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f42587a);
    }

    public final String toString() {
        return android.support.v4.media.b.r(new StringBuilder("Ordering.compound("), Arrays.toString(this.f42587a), ")");
    }
}
