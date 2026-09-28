package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.DoNotMock;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public final transient ImmutableMap f42686e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int f42687f;

    /* renamed from: com.google.common.collect.ImmutableMultimap$1, reason: invalid class name */
    class AnonymousClass1 extends UnmodifiableIterator<Map.Entry<Object, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public final UnmodifiableIterator f42688a;

        /* renamed from: b, reason: collision with root package name */
        public Object f42689b = null;

        /* renamed from: c, reason: collision with root package name */
        public UnmodifiableIterator f42690c = Iterators.ArrayItr.f42756d;

        public AnonymousClass1(ImmutableMultimap immutableMultimap) {
            this.f42688a = immutableMultimap.f42686e.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42690c.hasNext() || this.f42688a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.f42690c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f42688a.next();
                this.f42689b = entry.getKey();
                this.f42690c = ((ImmutableCollection) entry.getValue()).iterator();
            }
            Object obj = this.f42689b;
            Objects.requireNonNull(obj);
            return new ImmutableEntry(obj, this.f42690c.next());
        }
    }

    @DoNotMock
    public static class Builder<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f42693a = CompactHashMap.e();
    }

    public static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {

        /* renamed from: b, reason: collision with root package name */
        public final ImmutableMultimap f42694b;

        public EntryCollection(ImmutableMultimap immutableMultimap) {
            this.f42694b = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f42694b.s(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return this.f42694b.f42686e.g();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: k */
        public final UnmodifiableIterator iterator() {
            ImmutableMultimap immutableMultimap = this.f42694b;
            immutableMultimap.getClass();
            return new AnonymousClass1(immutableMultimap);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f42694b.f42687f;
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static class FieldSettersHolder {
        static {
            Serialization.a(ImmutableMultimap.class, "map");
            Serialization.a(ImmutableMultimap.class, "size");
        }
    }

    public class Keys extends ImmutableMultiset<K> {
        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        public final Set e() {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset
        /* renamed from: n */
        public final ImmutableSet e() {
            throw null;
        }

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMultiset
        public final Multiset.Entry p(int i2) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            throw null;
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static final class KeysSerializedForm implements Serializable {
    }

    public static final class Values<K, V> extends ImmutableCollection<V> {

        /* renamed from: b, reason: collision with root package name */
        public final transient ImmutableMultimap f42695b;

        public Values(ImmutableMultimap immutableMultimap) {
            this.f42695b = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return this.f42695b.containsValue(obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection
        public final int d(int i2, Object[] objArr) {
            UnmodifiableIterator it = this.f42695b.f42686e.values().iterator();
            while (it.hasNext()) {
                i2 = ((ImmutableCollection) it.next()).d(i2, objArr);
            }
            return i2;
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* renamed from: k */
        public final UnmodifiableIterator iterator() {
            ImmutableMultimap immutableMultimap = this.f42695b;
            immutableMultimap.getClass();
            return new UnmodifiableIterator<Object>(immutableMultimap) { // from class: com.google.common.collect.ImmutableMultimap.2

                /* renamed from: a, reason: collision with root package name */
                public final UnmodifiableIterator f42691a;

                /* renamed from: b, reason: collision with root package name */
                public UnmodifiableIterator f42692b = Iterators.ArrayItr.f42756d;

                {
                    this.f42691a = immutableMultimap.f42686e.values().iterator();
                }

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    return this.f42692b.hasNext() || this.f42691a.hasNext();
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Iterator
                public final Object next() {
                    if (!this.f42692b.hasNext()) {
                        this.f42692b = ((ImmutableCollection) this.f42691a.next()).iterator();
                    }
                    return this.f42692b.next();
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f42695b.f42687f;
        }
    }

    public ImmutableMultimap(ImmutableMap immutableMap, int i2) {
        this.f42686e = immutableMap;
        this.f42687f = i2;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Map a() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Collection b(Object obj) {
        m();
        throw null;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection c() {
        return new EntryCollection(this);
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public final boolean containsKey(Object obj) {
        return this.f42686e.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Set e() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection f() {
        return new Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Iterator g() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public ImmutableMap asMap() {
        return this.f42686e;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection d() {
        return (ImmutableCollection) super.d();
    }

    public final UnmodifiableIterator k() {
        return new AnonymousClass1(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Set keySet() {
        return this.f42686e.keySet();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public abstract ImmutableCollection l(Object obj);

    public ImmutableCollection m() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public final int size() {
        return this.f42687f;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final Collection values() {
        return (ImmutableCollection) super.values();
    }
}
