package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {

    /* renamed from: b, reason: collision with root package name */
    public transient ImmutableList f42696b;

    /* renamed from: c, reason: collision with root package name */
    public transient ImmutableSet f42697c;

    public final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        public EntrySet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && ImmutableMultiset.this.o1(entry.a()) == entry.getCount();
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public final Object get(int i2) {
            return ImmutableMultiset.this.p(i2);
        }

        @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return ImmutableMultiset.this.j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return ImmutableMultiset.this.e().size();
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static class EntrySetSerializedForm<E> implements Serializable {
    }

    public static ImmutableMultiset m(Collection collection) {
        ObjectCountHashMap objectCountHashMap;
        if (collection instanceof ImmutableMultiset) {
            ImmutableMultiset immutableMultiset = (ImmutableMultiset) collection;
            if (!immutableMultiset.j()) {
                return immutableMultiset;
            }
        }
        Collection collection2 = collection;
        Builder builder = new Builder(collection2 instanceof Multiset ? ((Multiset) collection2).e().size() : 11);
        Objects.requireNonNull(builder.f42701a);
        if (collection instanceof Multiset) {
            Multiset multiset = (Multiset) collection;
            if (multiset instanceof RegularImmutableMultiset) {
                objectCountHashMap = ((RegularImmutableMultiset) multiset).f43028d;
            } else if (multiset instanceof AbstractMapBasedMultiset) {
                ((AbstractMapBasedMultiset) multiset).getClass();
                objectCountHashMap = null;
            } else {
                objectCountHashMap = null;
            }
            if (objectCountHashMap != null) {
                ObjectCountHashMap objectCountHashMap2 = builder.f42701a;
                objectCountHashMap2.b(Math.max(objectCountHashMap2.f42978c, objectCountHashMap.f42978c));
                for (int iC = objectCountHashMap.c(); iC >= 0; iC = objectCountHashMap.k(iC)) {
                    builder.d(objectCountHashMap.f(iC), objectCountHashMap.e(iC));
                }
            } else {
                Set setEntrySet = multiset.entrySet();
                ObjectCountHashMap objectCountHashMap3 = builder.f42701a;
                objectCountHashMap3.b(Math.max(objectCountHashMap3.f42978c, setEntrySet.size()));
                for (Multiset.Entry entry : multiset.entrySet()) {
                    builder.d(entry.getCount(), entry.a());
                }
            }
        } else {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                builder.b(it.next());
            }
        }
        Objects.requireNonNull(builder.f42701a);
        if (builder.f42701a.f42978c == 0) {
            return RegularImmutableMultiset.f43027g;
        }
        builder.f42702b = true;
        return new RegularImmutableMultiset(builder.f42701a);
    }

    @Override // com.google.common.collect.Multiset
    public final int O1(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public final int T(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multiset
    public final int add(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList b() {
        ImmutableList immutableList = this.f42696b;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList immutableListB = super.b();
        this.f42696b = immutableListB;
        return immutableListB;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return o1(obj) > 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final int d(int i2, Object[] objArr) {
        UnmodifiableIterator it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            Arrays.fill(objArr, i2, entry.getCount() + i2, entry.a());
            i2 += entry.getCount();
        }
        return i2;
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final boolean equals(Object obj) {
        return Multisets.a(this, obj);
    }

    @Override // java.util.Collection, com.google.common.collect.Multiset
    public final int hashCode() {
        return Sets.e(entrySet());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    /* renamed from: k */
    public final UnmodifiableIterator iterator() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<Object>() { // from class: com.google.common.collect.ImmutableMultiset.1

            /* renamed from: a, reason: collision with root package name */
            public int f42698a;

            /* renamed from: b, reason: collision with root package name */
            public Object f42699b;

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f42698a > 0 || it.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                if (this.f42698a <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) it.next();
                    this.f42699b = entry.a();
                    this.f42698a = entry.getCount();
                }
                this.f42698a--;
                Object obj = this.f42699b;
                Objects.requireNonNull(obj);
                return obj;
            }
        };
    }

    @Override // com.google.common.collect.Multiset
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableSet e();

    @Override // com.google.common.collect.Multiset
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public final ImmutableSet entrySet() {
        ImmutableSet entrySet = this.f42697c;
        if (entrySet == null) {
            entrySet = isEmpty() ? RegularImmutableSet.f43033j : new EntrySet();
            this.f42697c = entrySet;
        }
        return entrySet;
    }

    public abstract Multiset.Entry p(int i2);

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    @Override // com.google.common.collect.Multiset
    public final boolean u0(int i2, Object obj) {
        throw new UnsupportedOperationException();
    }

    public static class Builder<E> extends ImmutableCollection.Builder<E> {

        /* renamed from: a, reason: collision with root package name */
        public ObjectCountHashMap f42701a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f42702b;

        public Builder(int i2) {
            this.f42702b = false;
            ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
            objectCountHashMap.h(i2);
            this.f42701a = objectCountHashMap;
        }

        @Override // 
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder b(Object obj) {
            return d(1, obj);
        }

        public Builder d(int i2, Object obj) {
            Objects.requireNonNull(this.f42701a);
            if (i2 == 0) {
                return this;
            }
            if (this.f42702b) {
                ObjectCountHashMap objectCountHashMap = this.f42701a;
                ObjectCountHashMap objectCountHashMap2 = new ObjectCountHashMap();
                objectCountHashMap2.h(objectCountHashMap.f42978c);
                for (int iC = objectCountHashMap.c(); iC != -1; iC = objectCountHashMap.k(iC)) {
                    objectCountHashMap2.m(objectCountHashMap.f(iC), objectCountHashMap.e(iC));
                }
                this.f42701a = objectCountHashMap2;
            }
            this.f42702b = false;
            obj.getClass();
            ObjectCountHashMap objectCountHashMap3 = this.f42701a;
            objectCountHashMap3.m(i2 + objectCountHashMap3.d(obj), obj);
            return this;
        }

        public Builder() {
            this(4);
        }
    }
}
