package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
interface FilteredMultimap<K, V> extends Multimap<K, V> {
    Multimap i();

    Predicate p();
}
