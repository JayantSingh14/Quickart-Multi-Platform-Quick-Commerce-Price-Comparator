package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f42582a;

    public ComparatorOrdering(Comparator comparator) {
        comparator.getClass();
        this.f42582a = comparator;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f42582a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComparatorOrdering) {
            return this.f42582a.equals(((ComparatorOrdering) obj).f42582a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f42582a.hashCode();
    }

    public final String toString() {
        return this.f42582a.toString();
    }
}
