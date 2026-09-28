package com.google.common.collect;

import androidx.media3.exoplayer.analytics.p;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Multimaps {

    public static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* renamed from: d, reason: collision with root package name */
        public final Multimap f42948d;

        public class EntrySet extends Maps.EntrySet<K, Collection<V>> {
            public EntrySet() {
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public final Map g() {
                return AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                Set setKeySet = AsMap.this.f42948d.keySet();
                return new Maps.AnonymousClass3(setKeySet.iterator(), new f(this));
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AsMap.this.f42948d.keySet().remove(entry.getKey());
                return true;
            }
        }

        public AsMap(Multimap multimap) {
            this.f42948d = multimap;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f42948d.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return this.f42948d.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Multimap multimap = this.f42948d;
            if (multimap.containsKey(obj)) {
                return multimap.l(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            return this.f42948d.isEmpty();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return this.f42948d.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            Multimap multimap = this.f42948d;
            if (multimap.containsKey(obj)) {
                return multimap.b(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f42948d.keySet().size();
        }
    }

    public static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {

        /* renamed from: g, reason: collision with root package name */
        public transient Supplier f42950g;

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Map a() {
            return k();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Set e() {
            return l();
        }

        @Override // com.google.common.collect.AbstractListMultimap, com.google.common.collect.AbstractMapBasedMultimap
        /* renamed from: r */
        public final List h() {
            return (List) this.f42950g.get();
        }
    }

    public static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Map a() {
            return k();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Set e() {
            return l();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public final Collection h() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public final Collection n(Collection collection) {
            return collection instanceof NavigableSet ? Sets.j((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : collection instanceof Set ? Collections.unmodifiableSet((Set) collection) : collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap
        public final Collection q(Object obj, Collection collection) {
            if (!(collection instanceof List)) {
                return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(obj, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.WrappedSortedSet(obj, (SortedSet) collection, null) : collection instanceof Set ? new AbstractMapBasedMultimap.WrappedSet(obj, (Set) collection) : new AbstractMapBasedMultimap.WrappedCollection(obj, collection, null);
            }
            List list = (List) collection;
            return list instanceof RandomAccess ? new AbstractMapBasedMultimap.RandomAccessWrappedList(obj, list, null) : new AbstractMapBasedMultimap.WrappedList(obj, list, null);
        }
    }

    public static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Map a() {
            return k();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Set e() {
            return l();
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public final Collection h() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public final Collection n(Collection collection) {
            return collection instanceof NavigableSet ? Sets.j((NavigableSet) collection) : collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public final Collection q(Object obj, Collection collection) {
            return collection instanceof NavigableSet ? new AbstractMapBasedMultimap.WrappedNavigableSet(obj, (NavigableSet) collection, null) : collection instanceof SortedSet ? new AbstractMapBasedMultimap.WrappedSortedSet(obj, (SortedSet) collection, null) : new AbstractMapBasedMultimap.WrappedSet(obj, (Set) collection);
        }

        @Override // com.google.common.collect.AbstractSetMultimap
        /* renamed from: r */
        public final Set h() {
            throw null;
        }
    }

    public static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Map a() {
            return k();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
        public final Set e() {
            return l();
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
        public final Collection h() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap, com.google.common.collect.AbstractSetMultimap
        /* renamed from: r */
        public final Set h() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractSortedSetMultimap
        /* renamed from: u */
        public final SortedSet h() {
            throw null;
        }
    }

    public static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        public abstract Multimap b();

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            b().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().s(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().remove(entry.getKey(), entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return b().size();
        }
    }

    public static class Keys<K, V> extends AbstractMultiset<K> {

        /* renamed from: com.google.common.collect.Multimaps$Keys$1, reason: invalid class name */
        class AnonymousClass1 extends TransformedIterator<Map.Entry<Object, Collection<Object>>, Multiset.Entry<Object>> {
            @Override // com.google.common.collect.TransformedIterator
            public final Object a(Object obj) {
                final Map.Entry entry = (Map.Entry) obj;
                return new Multisets.AbstractEntry<Object>() { // from class: com.google.common.collect.Multimaps.Keys.1.1
                    @Override // com.google.common.collect.Multiset.Entry
                    public final Object a() {
                        return entry.getKey();
                    }

                    @Override // com.google.common.collect.Multiset.Entry
                    public final int getCount() {
                        return ((Collection) entry.getValue()).size();
                    }
                };
            }
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int T(int i2, Object obj) {
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0) {
                throw null;
            }
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public final Set e() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final int f() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Iterator g() {
            throw new AssertionError("should never be called");
        }

        @Override // com.google.common.collect.AbstractMultiset
        public final Iterator i() {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            throw null;
        }
    }

    public static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {

        /* renamed from: com.google.common.collect.Multimaps$MapMultimap$1, reason: invalid class name */
        class AnonymousClass1 extends Sets.ImprovedAbstractSet<Object> {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Object f42952a;

            public AnonymousClass1(Object obj) {
                this.f42952a = obj;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return new Iterator<Object>() { // from class: com.google.common.collect.Multimaps.MapMultimap.1.1

                    /* renamed from: a, reason: collision with root package name */
                    public int f42954a;

                    @Override // java.util.Iterator
                    public final boolean hasNext() {
                        if (this.f42954a != 0) {
                            return false;
                        }
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        MapMultimap.this.getClass();
                        Object obj = anonymousClass1.f42952a;
                        throw null;
                    }

                    @Override // java.util.Iterator
                    public final Object next() {
                        hasNext();
                        throw new NoSuchElementException();
                    }

                    @Override // java.util.Iterator
                    public final void remove() {
                        CollectPreconditions.d(this.f42954a == 1);
                        this.f42954a = -1;
                        MapMultimap.this.getClass();
                        throw null;
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                MapMultimap.this.getClass();
                throw null;
            }
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Map a() {
            return new AsMap(this);
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final /* bridge */ /* synthetic */ Collection b(Object obj) {
            b(obj);
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Collection c() {
            throw new AssertionError("unreachable");
        }

        @Override // com.google.common.collect.Multimap
        public final void clear() {
            throw null;
        }

        @Override // com.google.common.collect.Multimap
        public final boolean containsKey(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean containsValue(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final Collection d() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Set e() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Collection f() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Iterator g() {
            throw null;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final Collection l(Object obj) {
            return new AnonymousClass1(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final int hashCode() {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean remove(Object obj, Object obj2) {
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean s(Object obj, Object obj2) {
            throw null;
        }

        @Override // com.google.common.collect.Multimap
        public final int size() {
            throw null;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final Set b(Object obj) {
            new HashSet(2);
            throw null;
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final Set d() {
            throw null;
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final Set l(Object obj) {
            return new AnonymousClass1(obj);
        }
    }

    public static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap
        public final Collection h(Object obj, Collection collection) {
            return Lists.d(new Maps.AnonymousClass10(this.f42957f, obj), (List) collection);
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final List b(Object obj) {
            return Lists.d(new Maps.AnonymousClass10(this.f42957f, obj), (List) this.f42956e.b(obj));
        }

        @Override // com.google.common.collect.Multimaps.TransformedEntriesMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final List l(Object obj) {
            return Lists.d(new Maps.AnonymousClass10(this.f42957f, obj), (List) this.f42956e.l(obj));
        }
    }

    public static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {

        /* renamed from: e, reason: collision with root package name */
        public final ListMultimap f42956e;

        /* renamed from: f, reason: collision with root package name */
        public final Maps.EntryTransformer f42957f;

        public TransformedEntriesMultimap(ListMultimap listMultimap, Maps.EntryTransformer entryTransformer) {
            listMultimap.getClass();
            this.f42956e = listMultimap;
            this.f42957f = entryTransformer;
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Map a() {
            return new Maps.TransformedEntriesMap(this.f42956e.asMap(), new f(this));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection b(Object obj) {
            return h(obj, this.f42956e.b(obj));
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Collection c() {
            return new AbstractMultimap.Entries();
        }

        @Override // com.google.common.collect.Multimap
        public final void clear() {
            this.f42956e.clear();
        }

        @Override // com.google.common.collect.Multimap
        public final boolean containsKey(Object obj) {
            return this.f42956e.containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Set e() {
            return this.f42956e.keySet();
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Collection f() {
            Collection collectionD = this.f42956e.d();
            final Maps.EntryTransformer entryTransformer = this.f42957f;
            return new Collections2.TransformedCollection(collectionD, new Function<Map.Entry<Object, Object>, Object>() { // from class: com.google.common.collect.Maps.11
                public AnonymousClass11() {
                }

                @Override // com.google.common.base.Function
                public final Object apply(Map.Entry<Object, Object> entry) {
                    Map.Entry<Object, Object> entry2 = entry;
                    entry2.getKey();
                    return ((AnonymousClass9) entryTransformer).f42895a.apply(entry2.getValue());
                }
            });
        }

        @Override // com.google.common.collect.AbstractMultimap
        public final Iterator g() {
            return new Iterators.AnonymousClass6(this.f42956e.d().iterator(), new Maps.AnonymousClass13(this.f42957f));
        }

        @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection l(Object obj) {
            return h(obj, this.f42956e.l(obj));
        }

        public Collection h(Object obj, Collection collection) {
            Maps.AnonymousClass10 anonymousClass10 = new Maps.AnonymousClass10(this.f42957f, obj);
            return collection instanceof List ? Lists.d(anonymousClass10, (List) collection) : new Collections2.TransformedCollection(collection, anonymousClass10);
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean isEmpty() {
            return this.f42956e.isEmpty();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
        public final boolean remove(Object obj, Object obj2) {
            return l(obj).remove(obj2);
        }

        @Override // com.google.common.collect.Multimap
        public final int size() {
            return this.f42956e.size();
        }
    }

    public static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final Collection b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final Collection l(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap
        /* renamed from: u */
        public final /* bridge */ /* synthetic */ Multimap t() {
            return null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final List b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final List l(Object obj) {
            throw null;
        }
    }

    public static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final Map asMap() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Collection b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public Collection d() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Collection l(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final Set keySet() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final boolean put(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final boolean remove(Object obj, Object obj2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        /* renamed from: u */
        public Multimap t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final Collection values() {
            throw null;
        }
    }

    public static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public /* bridge */ /* synthetic */ Collection b(Object obj) {
            b(obj);
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final Collection d() {
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap
        /* renamed from: u */
        public /* bridge */ /* synthetic */ Multimap t() {
            return null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap
        public final Set d() {
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Set l(Object obj) {
            throw null;
        }
    }

    public static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final Collection b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final Collection l(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap
        /* renamed from: u */
        public final /* bridge */ /* synthetic */ Multimap t() {
            return null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final Set b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final Set l(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final SortedSet b(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.Multimaps.UnmodifiableSetMultimap, com.google.common.collect.Multimaps.UnmodifiableMultimap, com.google.common.collect.ForwardingMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final SortedSet l(Object obj) {
            throw null;
        }
    }

    public static ListMultimap a(ImmutableListMultimap immutableListMultimap, p pVar) {
        return new TransformedEntriesListMultimap(immutableListMultimap, new Maps.AnonymousClass9(pVar));
    }
}
