package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingMapEntry<K, V> extends ForwardingObject implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        return t().equals(obj);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return t().getKey();
    }

    @Override // java.util.Map.Entry
    public Object getValue() {
        return t().getValue();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return t().hashCode();
    }

    public Object setValue(Object obj) {
        return t().setValue(obj);
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract Map.Entry t();
}
