package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Ordering f42975a;

    public NullsLastOrdering(Ordering ordering) {
        this.f42975a = ordering;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return 1;
        }
        if (obj2 == null) {
            return -1;
        }
        return this.f42975a.compare(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering d() {
        return this.f42975a.d();
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering e() {
        return this;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsLastOrdering) {
            return this.f42975a.equals(((NullsLastOrdering) obj).f42975a);
        }
        return false;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering g() {
        return this.f42975a.g().d();
    }

    public final int hashCode() {
        return this.f42975a.hashCode() ^ (-921210296);
    }

    public final String toString() {
        return this.f42975a + ".nullsLast()";
    }
}
