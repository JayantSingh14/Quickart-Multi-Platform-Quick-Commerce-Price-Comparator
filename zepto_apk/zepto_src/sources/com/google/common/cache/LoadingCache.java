package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    Object get(Object obj);
}
