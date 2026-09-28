package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.lang.Enum;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ImmutableEnumMap<K extends Enum<K>, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {

    @J2ktIncompatible
    public static class EnumSerializedForm<K extends Enum<K>, V> implements Serializable {
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final boolean containsKey(Object obj) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumMap) {
            ((ImmutableEnumMap) obj).getClass();
        }
        throw null;
    }

    @Override // com.google.common.collect.ImmutableMap
    public final boolean g() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public final Object get(Object obj) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableMap
    public final UnmodifiableIterator h() {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
    public final UnmodifiableIterator o() {
        throw null;
    }

    @Override // java.util.Map
    public final int size() {
        throw null;
    }
}
