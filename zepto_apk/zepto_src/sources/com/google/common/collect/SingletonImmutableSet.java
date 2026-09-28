package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Iterators;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: d, reason: collision with root package name */
    public final transient Object f43068d;

    public SingletonImmutableSet(Object obj) {
        obj.getClass();
        this.f43068d = obj;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public final ImmutableList b() {
        return ImmutableList.t(this.f43068d);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f43068d.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        objArr[i2] = this.f43068d;
        return i2 + 1;
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f43068d.hashCode();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public final Iterator iterator() {
        Iterators.SingletonIterator singletonIterator = new Iterators.SingletonIterator();
        singletonIterator.f42768a = this.f43068d;
        return singletonIterator;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final boolean j() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        Iterators.SingletonIterator singletonIterator = new Iterators.SingletonIterator();
        singletonIterator.f42768a = this.f43068d;
        return singletonIterator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return "[" + this.f43068d.toString() + ']';
    }
}
