package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@DoNotMock
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public interface Multimap<K, V> {
    Map asMap();

    Collection b(Object obj);

    void clear();

    boolean containsKey(Object obj);

    boolean containsValue(Object obj);

    Collection d();

    boolean equals(Object obj);

    Collection get(Object obj);

    int hashCode();

    boolean isEmpty();

    Set keySet();

    boolean put(Object obj, Object obj2);

    boolean remove(Object obj, Object obj2);

    boolean s(Object obj, Object obj2);

    int size();

    Collection values();
}
