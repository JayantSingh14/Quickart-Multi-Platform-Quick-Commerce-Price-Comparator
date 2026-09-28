package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class ImmutableMapValues<K, V> extends ImmutableCollection<V> {

    /* renamed from: b, reason: collision with root package name */
    public final ImmutableMap f42683b;

    /* renamed from: com.google.common.collect.ImmutableMapValues$1, reason: invalid class name */
    class AnonymousClass1 extends UnmodifiableIterator<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final UnmodifiableIterator f42684a;

        public AnonymousClass1(ImmutableMapValues immutableMapValues) {
            this.f42684a = immutableMapValues.f42683b.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42684a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            return ((Map.Entry) this.f42684a.next()).getValue();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static class SerializedForm<V> implements Serializable {
    }

    public ImmutableMapValues(ImmutableMap immutableMap) {
        this.f42683b = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList b() {
        final ImmutableList immutableListB = this.f42683b.entrySet().b();
        return new ImmutableList<Object>() { // from class: com.google.common.collect.ImmutableMapValues.2
            @Override // java.util.List
            public final Object get(int i2) {
                return ((Map.Entry) immutableListB.get(i2)).getValue();
            }

            @Override // com.google.common.collect.ImmutableCollection
            public final boolean j() {
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public final int size() {
                return immutableListB.size();
            }
        };
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return obj != null && Iterators.d(new AnonymousClass1(this), obj);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final Iterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        return new AnonymousClass1(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.f42683b.size();
    }
}
