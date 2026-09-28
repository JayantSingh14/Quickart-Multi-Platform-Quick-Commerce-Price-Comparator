package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f42660a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f42661b;

    public ImmutableEntry(Object obj, Object obj2) {
        this.f42660a = obj;
        this.f42661b = obj2;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f42660a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f42661b;
    }

    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
