package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        throw null;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (!(obj instanceof ExplicitOrdering)) {
            return false;
        }
        ((ExplicitOrdering) obj).getClass();
        throw null;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
