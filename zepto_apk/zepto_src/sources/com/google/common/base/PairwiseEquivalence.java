package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    @Override // com.google.common.base.Equivalence
    public final boolean a(Object obj, Object obj2) {
        Iterator it = ((Iterable) obj).iterator();
        Iterator it2 = ((Iterable) obj2).iterator();
        if (!it.hasNext() || !it2.hasNext()) {
            return (it.hasNext() || it2.hasNext()) ? false : true;
        }
        it.next();
        it2.next();
        throw null;
    }

    @Override // com.google.common.base.Equivalence
    public final int b(Object obj) {
        Iterator it = ((Iterable) obj).iterator();
        if (!it.hasNext()) {
            return 78721;
        }
        it.next();
        throw null;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof PairwiseEquivalence)) {
            return false;
        }
        ((PairwiseEquivalence) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "null.pairwise()";
    }
}
