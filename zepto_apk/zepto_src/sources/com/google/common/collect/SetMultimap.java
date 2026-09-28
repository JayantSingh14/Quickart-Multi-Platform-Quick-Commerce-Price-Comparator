package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface SetMultimap<K, V> extends Multimap<K, V> {
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    Set b(Object obj);

    @Override // com.google.common.collect.Multimap
    Set d();

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    Set get(Object obj);
}
