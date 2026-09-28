package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface BiMap<K, V> extends Map<K, V> {
    @Override // com.google.common.collect.BiMap
    Set values();
}
