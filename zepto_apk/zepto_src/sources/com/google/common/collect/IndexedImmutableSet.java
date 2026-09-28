package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    @Override // com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        return b().d(i2, objArr);
    }

    public abstract Object get(int i2);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: k */
    public UnmodifiableIterator iterator() {
        return b().listIterator(0);
    }

    @Override // com.google.common.collect.ImmutableSet
    public final ImmutableList q() {
        return new ImmutableList<Object>() { // from class: com.google.common.collect.IndexedImmutableSet.1
            @Override // java.util.List
            public final Object get(int i2) {
                return IndexedImmutableSet.this.get(i2);
            }

            @Override // com.google.common.collect.ImmutableCollection
            public final boolean j() {
                return IndexedImmutableSet.this.j();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }
}
