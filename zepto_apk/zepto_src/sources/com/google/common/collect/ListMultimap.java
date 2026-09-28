package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.List;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    @Override // 
    List b(Object obj);

    @Override // 
    List get(Object obj);
}
