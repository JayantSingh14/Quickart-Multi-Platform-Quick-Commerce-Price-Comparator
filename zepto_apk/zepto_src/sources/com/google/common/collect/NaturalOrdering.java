package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final NaturalOrdering f42971c = new NaturalOrdering();

    /* renamed from: a, reason: collision with root package name */
    public transient Ordering f42972a;

    /* renamed from: b, reason: collision with root package name */
    public transient Ordering f42973b;

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering d() {
        Ordering ordering = this.f42972a;
        if (ordering != null) {
            return ordering;
        }
        NullsFirstOrdering nullsFirstOrdering = new NullsFirstOrdering(this);
        this.f42972a = nullsFirstOrdering;
        return nullsFirstOrdering;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering e() {
        Ordering ordering = this.f42973b;
        if (ordering != null) {
            return ordering;
        }
        NullsLastOrdering nullsLastOrdering = new NullsLastOrdering(this);
        this.f42973b = nullsLastOrdering;
        return nullsLastOrdering;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering g() {
        return ReverseNaturalOrdering.f43049a;
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
