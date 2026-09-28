package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return 0;
    }

    @Override // com.google.common.collect.Ordering
    public final Ordering g() {
        return this;
    }

    public final String toString() {
        return "Ordering.allEqual()";
    }
}
