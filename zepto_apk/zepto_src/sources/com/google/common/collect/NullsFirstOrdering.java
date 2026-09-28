package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Ordering f42974a;

    public NullsFirstOrdering(Ordering ordering) {
        this.f42974a = ordering;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return this.f42974a.compare(obj, obj2);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering d() {
        return this;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering e() {
        return this.f42974a.e();
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.f42974a.equals(((NullsFirstOrdering) obj).f42974a);
        }
        return false;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering g() {
        return this.f42974a.g().e();
    }

    public final int hashCode() {
        return this.f42974a.hashCode() ^ 957692532;
    }

    public final String toString() {
        return this.f42974a + ".nullsFirst()";
    }
}
