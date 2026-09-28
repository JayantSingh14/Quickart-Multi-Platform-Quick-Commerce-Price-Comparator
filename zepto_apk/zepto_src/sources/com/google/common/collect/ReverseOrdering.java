package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Ordering f43050a;

    public ReverseOrdering(Ordering ordering) {
        ordering.getClass();
        this.f43050a = ordering;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f43050a.compare(obj2, obj);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.f43050a.equals(((ReverseOrdering) obj).f43050a);
        }
        return false;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering g() {
        return this.f43050a;
    }

    public final int hashCode() {
        return -this.f43050a.hashCode();
    }

    public final String toString() {
        return this.f43050a + ".reverse()";
    }
}
