package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SortedIterables {
    public static boolean a(Comparator comparator, Collection collection) {
        Comparator comparator2;
        comparator.getClass();
        collection.getClass();
        if (collection instanceof SortedSet) {
            comparator2 = ((SortedSet) collection).comparator();
            if (comparator2 == null) {
                comparator2 = NaturalOrdering.f42971c;
            }
        } else {
            if (!(collection instanceof SortedIterable)) {
                return false;
            }
            comparator2 = ((SortedIterable) collection).comparator();
        }
        return comparator.equals(comparator2);
    }
}
