package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {

    /* renamed from: e, reason: collision with root package name */
    public final transient Map f42464e;

    /* renamed from: f, reason: collision with root package name */
    public transient int f42465f;

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractMapBasedMultimap<Object, Object>.Itr<Object> {
        @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
        public final Object a(Object obj, Object obj2) {
            return obj2;
        }
    }

    /* renamed from: com.google.common.collect.AbstractMapBasedMultimap$2, reason: invalid class name */
    class AnonymousClass2 extends AbstractMapBasedMultimap<Object, Object>.Itr<Map.Entry<Object, Object>> {
        @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
        public final Object a(Object obj, Object obj2) {
            return new ImmutableEntry(obj, obj2);
        }
    }

    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* renamed from: d, reason: collision with root package name */
        public final transient Map f42466d;

        public class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            public AsMapEntries() {
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                return Collections2.c(obj, AsMap.this.f42466d.entrySet());
            }

            @Override // com.google.common.collect.Maps.EntrySet
            public final Map g() {
                return AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return AsMap.this.new AsMapIterator();
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                Object objRemove;
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                Object key = entry.getKey();
                Map map = abstractMapBasedMultimap.f42464e;
                map.getClass();
                try {
                    objRemove = map.remove(key);
                } catch (ClassCastException | NullPointerException unused) {
                    objRemove = null;
                }
                Collection collection = (Collection) objRemove;
                if (collection == null) {
                    return true;
                }
                int size = collection.size();
                collection.clear();
                abstractMapBasedMultimap.f42465f -= size;
                return true;
            }
        }

        public class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a, reason: collision with root package name */
            public final Iterator f42469a;

            /* renamed from: b, reason: collision with root package name */
            public Collection f42470b;

            public AsMapIterator() {
                this.f42469a = AsMap.this.f42466d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                return this.f42469a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                Map.Entry entry = (Map.Entry) this.f42469a.next();
                this.f42470b = (Collection) entry.getValue();
                return AsMap.this.d(entry);
            }

            @Override // java.util.Iterator
            public final void remove() {
                Preconditions.m("no calls to next() since the last call to remove()", this.f42470b != null);
                this.f42469a.remove();
                AbstractMapBasedMultimap.this.f42465f -= this.f42470b.size();
                this.f42470b.clear();
                this.f42470b = null;
            }
        }

        public AsMap(Map map) {
            this.f42466d = map;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new AsMapEntries();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            if (this.f42466d == abstractMapBasedMultimap.f42464e) {
                abstractMapBasedMultimap.clear();
            } else {
                Iterators.b(new AsMapIterator());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return Maps.g(obj, this.f42466d);
        }

        public final Map.Entry d(Map.Entry entry) {
            Object key = entry.getKey();
            return new ImmutableEntry(key, AbstractMapBasedMultimap.this.q(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean equals(Object obj) {
            return this == obj || this.f42466d.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Collection collection = (Collection) Maps.h(obj, this.f42466d);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.q(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int hashCode() {
            return this.f42466d.hashCode();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            Collection collection = (Collection) this.f42466d.remove(obj);
            if (collection == null) {
                return null;
            }
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Collection collectionH = abstractMapBasedMultimap.h();
            collectionH.addAll(collection);
            abstractMapBasedMultimap.f42465f -= collection.size();
            collection.clear();
            return collectionH;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f42466d.size();
        }

        @Override // java.util.AbstractMap
        public final String toString() {
            return this.f42466d.toString();
        }
    }

    public abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f42472a;

        /* renamed from: b, reason: collision with root package name */
        public Object f42473b = null;

        /* renamed from: c, reason: collision with root package name */
        public Collection f42474c = null;

        /* renamed from: d, reason: collision with root package name */
        public Iterator f42475d = Iterators.EmptyModifiableIterator.f42762a;

        public Itr() {
            this.f42472a = AbstractMapBasedMultimap.this.f42464e.entrySet().iterator();
        }

        public abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42472a.hasNext() || this.f42475d.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.f42475d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f42472a.next();
                this.f42473b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.f42474c = collection;
                this.f42475d = collection.iterator();
            }
            return a(this.f42473b, this.f42475d.next());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f42475d.remove();
            Collection collection = this.f42474c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f42472a.remove();
            }
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            abstractMapBasedMultimap.f42465f--;
        }
    }

    public class KeySet extends Maps.KeySet<K, Collection<V>> {
        public KeySet(Map map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            Iterators.b(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection collection) {
            return this.f42922a.keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return this == obj || this.f42922a.keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public final int hashCode() {
            return this.f42922a.keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            final Iterator<Map.Entry<K, V>> it = this.f42922a.entrySet().iterator();
            return new Iterator<Object>() { // from class: com.google.common.collect.AbstractMapBasedMultimap.KeySet.1

                /* renamed from: a, reason: collision with root package name */
                public Map.Entry f42478a;

                @Override // java.util.Iterator
                public final boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public final Object next() {
                    Map.Entry entry = (Map.Entry) it.next();
                    this.f42478a = entry;
                    return entry.getKey();
                }

                @Override // java.util.Iterator
                public final void remove() {
                    Preconditions.m("no calls to next() since the last call to remove()", this.f42478a != null);
                    Collection collection = (Collection) this.f42478a.getValue();
                    it.remove();
                    KeySet keySet = KeySet.this;
                    AbstractMapBasedMultimap.this.f42465f -= collection.size();
                    collection.clear();
                    this.f42478a = null;
                }
            };
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            int size;
            Collection collection = (Collection) this.f42922a.remove(obj);
            if (collection != null) {
                size = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.this.f42465f -= size;
            } else {
                size = 0;
            }
            return size > 0;
        }
    }

    public final class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        public NavigableAsMap(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set b() {
            return new NavigableKeySet(g());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry ceilingEntry(Object obj) {
            Map.Entry<K, V> entryCeilingEntry = g().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return d(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public final Object ceilingKey(Object obj) {
            return g().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet descendingKeySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap descendingMap() {
            return new NavigableAsMap(g().descendingMap());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: e */
        public final SortedSet b() {
            return new NavigableKeySet(g());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: f */
        public final SortedSet keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry firstEntry() {
            Map.Entry<K, V> entryFirstEntry = g().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return d(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry floorEntry(Object obj) {
            Map.Entry<K, V> entryFloorEntry = g().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return d(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public final Object floorKey(Object obj) {
            return g().floorKey(obj);
        }

        public final Map.Entry h(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Collection collectionH = abstractMapBasedMultimap.h();
            collectionH.addAll((Collection) entry.getValue());
            it.remove();
            return new ImmutableEntry(entry.getKey(), abstractMapBasedMultimap.n(collectionH));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry higherEntry(Object obj) {
            Map.Entry<K, V> entryHigherEntry = g().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return d(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public final Object higherKey(Object obj) {
            return g().higherKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final NavigableMap g() {
            return (NavigableMap) ((SortedMap) this.f42466d);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lastEntry() {
            Map.Entry<K, V> entryLastEntry = g().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return d(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lowerEntry(Object obj) {
            Map.Entry<K, V> entryLowerEntry = g().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return d(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public final Object lowerKey(Object obj) {
            return g().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            return h(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            return h(((Maps.ViewCachingAbstractMap) descendingMap()).entrySet().iterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return new NavigableAsMap(g().headMap(obj, z));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return new NavigableAsMap(g().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return new NavigableAsMap(g().tailMap(obj, z));
        }
    }

    public final class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        public NavigableKeySet(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return i().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return ((KeySet) descendingSet()).iterator();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return new NavigableKeySet(i().descendingMap());
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return i().floorKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return i().higherKey(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public final NavigableMap i() {
            return (NavigableMap) ((SortedMap) this.f42922a);
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return i().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            return Iterators.k(iterator());
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            return Iterators.k(descendingIterator());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return new NavigableKeySet(i().headMap(obj, z));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return new NavigableKeySet(i().subMap(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return new NavigableKeySet(i().tailMap(obj, z));
        }
    }

    public class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
    }

    public class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {

        /* renamed from: f, reason: collision with root package name */
        public SortedSet f42483f;

        public SortedAsMap(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return g().comparator();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public SortedSet b() {
            return new SortedKeySet(g());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public SortedSet keySet() {
            SortedSet sortedSet = this.f42483f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetB = b();
            this.f42483f = sortedSetB;
            return sortedSetB;
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            return g().firstKey();
        }

        public SortedMap g() {
            return (SortedMap) this.f42466d;
        }

        public SortedMap headMap(Object obj) {
            return new SortedAsMap(g().headMap(obj));
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            return g().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return new SortedAsMap(g().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return new SortedAsMap(g().tailMap(obj));
        }
    }

    public class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        public SortedKeySet(SortedMap sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        public final Comparator comparator() {
            return i().comparator();
        }

        @Override // java.util.SortedSet
        public final Object first() {
            return i().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return new SortedKeySet(i().headMap(obj));
        }

        public SortedMap i() {
            return (SortedMap) this.f42922a;
        }

        @Override // java.util.SortedSet
        public final Object last() {
            return i().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return new SortedKeySet(i().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return new SortedKeySet(i().tailMap(obj));
        }
    }

    public class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        public WrappedNavigableSet(Object obj, NavigableSet navigableSet, WrappedCollection wrappedCollection) {
            super(obj, navigableSet, wrappedCollection);
        }

        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return g().ceiling(obj);
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return new WrappedCollection.WrappedIterator(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return j(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return g().floor(obj);
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return j(g().headSet(obj, z));
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return g().higher(obj);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final NavigableSet g() {
            return (NavigableSet) ((SortedSet) this.f42487b);
        }

        public final NavigableSet j(NavigableSet navigableSet) {
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection == null) {
                wrappedCollection = this;
            }
            return new WrappedNavigableSet(this.f42486a, navigableSet, wrappedCollection);
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return g().lower(obj);
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            return Iterators.k(iterator());
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            return Iterators.k(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return j(g().subSet(obj, z, obj2, z2));
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return j(g().tailSet(obj, z));
        }
    }

    public class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        public WrappedSet(Object obj, Set set) {
            super(obj, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zG = Sets.g((Set) this.f42487b, collection);
            if (zG) {
                int size2 = this.f42487b.size();
                AbstractMapBasedMultimap.this.f42465f += size2 - size;
                f();
            }
            return zG;
        }
    }

    public class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        public WrappedSortedSet(Object obj, SortedSet sortedSet, WrappedCollection wrappedCollection) {
            super(obj, sortedSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        public final Comparator comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public final Object first() {
            d();
            return g().first();
        }

        public SortedSet g() {
            return (SortedSet) this.f42487b;
        }

        @Override // java.util.SortedSet
        public final SortedSet headSet(Object obj) {
            d();
            SortedSet sortedSetHeadSet = g().headSet(obj);
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection == null) {
                wrappedCollection = this;
            }
            return new WrappedSortedSet(this.f42486a, sortedSetHeadSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        public final Object last() {
            d();
            return g().last();
        }

        @Override // java.util.SortedSet
        public final SortedSet subSet(Object obj, Object obj2) {
            d();
            SortedSet sortedSetSubSet = g().subSet(obj, obj2);
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection == null) {
                wrappedCollection = this;
            }
            return new WrappedSortedSet(this.f42486a, sortedSetSubSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        public final SortedSet tailSet(Object obj) {
            d();
            SortedSet sortedSetTailSet = g().tailSet(obj);
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection == null) {
                wrappedCollection = this;
            }
            return new WrappedSortedSet(this.f42486a, sortedSetTailSet, wrappedCollection);
        }
    }

    public AbstractMapBasedMultimap(Map map) {
        Preconditions.f(map.isEmpty());
        this.f42464e = map;
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Map a() {
        return new AsMap(this.f42464e);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection b(Object obj) {
        Collection collection = (Collection) this.f42464e.remove(obj);
        if (collection == null) {
            return m();
        }
        Collection collectionH = h();
        collectionH.addAll(collection);
        this.f42465f -= collection.size();
        collection.clear();
        return n(collectionH);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection c() {
        return this instanceof SetMultimap ? new AbstractMultimap.EntrySet() : new AbstractMultimap.Entries();
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        Map map = this.f42464e;
        Iterator<V> it = map.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        map.clear();
        this.f42465f = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.f42464e.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Set e() {
        return new KeySet(this.f42464e);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public final Collection f() {
        return new AbstractMultimap.Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public Iterator g() {
        return new AnonymousClass2();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* renamed from: get */
    public Collection l(Object obj) {
        Collection collectionJ = (Collection) this.f42464e.get(obj);
        if (collectionJ == null) {
            collectionJ = j(obj);
        }
        return q(obj, collectionJ);
    }

    public abstract Collection h();

    public Collection j(Object obj) {
        return h();
    }

    public final Map k() {
        Map map = this.f42464e;
        return map instanceof NavigableMap ? new NavigableAsMap((NavigableMap) map) : map instanceof SortedMap ? new SortedAsMap((SortedMap) map) : new AsMap(map);
    }

    public final Set l() {
        Map map = this.f42464e;
        return map instanceof NavigableMap ? new NavigableKeySet((NavigableMap) map) : map instanceof SortedMap ? new SortedKeySet((SortedMap) map) : new KeySet(map);
    }

    public Collection m() {
        return n(h());
    }

    public Collection n(Collection collection) {
        return Collections.unmodifiableCollection(collection);
    }

    public Iterator o() {
        return new AnonymousClass1();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(Object obj, Object obj2) {
        Map map = this.f42464e;
        Collection collection = (Collection) map.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f42465f++;
            return true;
        }
        Collection collectionJ = j(obj);
        if (!collectionJ.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f42465f++;
        map.put(obj, collectionJ);
        return true;
    }

    public Collection q(Object obj, Collection collection) {
        return new WrappedCollection(obj, collection, null);
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f42465f;
    }

    public class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {

        public class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
            public WrappedListIterator() {
                super();
            }

            @Override // java.util.ListIterator
            public final void add(Object obj) {
                WrappedList wrappedList = WrappedList.this;
                boolean zIsEmpty = wrappedList.isEmpty();
                b().add(obj);
                AbstractMapBasedMultimap.this.f42465f++;
                if (zIsEmpty) {
                    wrappedList.b();
                }
            }

            public final ListIterator b() {
                a();
                return (ListIterator) this.f42491a;
            }

            @Override // java.util.ListIterator
            public final boolean hasPrevious() {
                return b().hasPrevious();
            }

            @Override // java.util.ListIterator
            public final int nextIndex() {
                return b().nextIndex();
            }

            @Override // java.util.ListIterator
            public final Object previous() {
                return b().previous();
            }

            @Override // java.util.ListIterator
            public final int previousIndex() {
                return b().previousIndex();
            }

            @Override // java.util.ListIterator
            public final void set(Object obj) {
                b().set(obj);
            }

            public WrappedListIterator(int i2) {
                super(((List) WrappedList.this.f42487b).listIterator(i2));
            }
        }

        public WrappedList(Object obj, List list, WrappedCollection wrappedCollection) {
            super(obj, list, wrappedCollection);
        }

        @Override // java.util.List
        public final void add(int i2, Object obj) {
            d();
            boolean zIsEmpty = this.f42487b.isEmpty();
            ((List) this.f42487b).add(i2, obj);
            AbstractMapBasedMultimap.this.f42465f++;
            if (zIsEmpty) {
                b();
            }
        }

        @Override // java.util.List
        public final boolean addAll(int i2, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = ((List) this.f42487b).addAll(i2, collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.this.f42465f += this.f42487b.size() - size;
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            d();
            return ((List) this.f42487b).get(i2);
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            d();
            return ((List) this.f42487b).indexOf(obj);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            d();
            return ((List) this.f42487b).lastIndexOf(obj);
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            d();
            return new WrappedListIterator();
        }

        @Override // java.util.List
        public final Object remove(int i2) {
            d();
            Object objRemove = ((List) this.f42487b).remove(i2);
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            abstractMapBasedMultimap.f42465f--;
            f();
            return objRemove;
        }

        @Override // java.util.List
        public final Object set(int i2, Object obj) {
            d();
            return ((List) this.f42487b).set(i2, obj);
        }

        @Override // java.util.List
        public final List subList(int i2, int i3) {
            d();
            List listSubList = ((List) this.f42487b).subList(i2, i3);
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection == null) {
                wrappedCollection = this;
            }
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            abstractMapBasedMultimap.getClass();
            boolean z = listSubList instanceof RandomAccess;
            Object obj = this.f42486a;
            return z ? new RandomAccessWrappedList(obj, listSubList, wrappedCollection) : new WrappedList(obj, listSubList, wrappedCollection);
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i2) {
            d();
            return new WrappedListIterator(i2);
        }
    }

    public class WrappedCollection extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f42486a;

        /* renamed from: b, reason: collision with root package name */
        public Collection f42487b;

        /* renamed from: c, reason: collision with root package name */
        public final WrappedCollection f42488c;

        /* renamed from: d, reason: collision with root package name */
        public final Collection f42489d;

        public WrappedCollection(Object obj, Collection collection, WrappedCollection wrappedCollection) {
            this.f42486a = obj;
            this.f42487b = collection;
            this.f42488c = wrappedCollection;
            this.f42489d = wrappedCollection == null ? null : wrappedCollection.f42487b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean add(Object obj) {
            d();
            boolean zIsEmpty = this.f42487b.isEmpty();
            boolean zAdd = this.f42487b.add(obj);
            if (zAdd) {
                AbstractMapBasedMultimap.this.f42465f++;
                if (zIsEmpty) {
                    b();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f42487b.addAll(collection);
            if (zAddAll) {
                AbstractMapBasedMultimap.this.f42465f += this.f42487b.size() - size;
                if (size == 0) {
                    b();
                }
            }
            return zAddAll;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void b() {
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection != null) {
                wrappedCollection.b();
            } else {
                AbstractMapBasedMultimap.this.f42464e.put(this.f42486a, this.f42487b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f42487b.clear();
            AbstractMapBasedMultimap.this.f42465f -= size;
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            d();
            return this.f42487b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean containsAll(Collection collection) {
            d();
            return this.f42487b.containsAll(collection);
        }

        public final void d() {
            Collection collection;
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection != null) {
                wrappedCollection.d();
                if (wrappedCollection.f42487b != this.f42489d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f42487b.isEmpty() || (collection = (Collection) AbstractMapBasedMultimap.this.f42464e.get(this.f42486a)) == null) {
                    return;
                }
                this.f42487b = collection;
            }
        }

        @Override // java.util.Collection
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            d();
            return this.f42487b.equals(obj);
        }

        public final void f() {
            WrappedCollection wrappedCollection = this.f42488c;
            if (wrappedCollection != null) {
                wrappedCollection.f();
            } else if (this.f42487b.isEmpty()) {
                AbstractMapBasedMultimap.this.f42464e.remove(this.f42486a);
            }
        }

        @Override // java.util.Collection
        public final int hashCode() {
            d();
            return this.f42487b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            d();
            return new WrappedIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            d();
            boolean zRemove = this.f42487b.remove(obj);
            if (zRemove) {
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                abstractMapBasedMultimap.f42465f--;
                f();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f42487b.removeAll(collection);
            if (zRemoveAll) {
                AbstractMapBasedMultimap.this.f42465f += this.f42487b.size() - size;
                f();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection collection) {
            collection.getClass();
            int size = size();
            boolean zRetainAll = this.f42487b.retainAll(collection);
            if (zRetainAll) {
                AbstractMapBasedMultimap.this.f42465f += this.f42487b.size() - size;
                f();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            d();
            return this.f42487b.size();
        }

        @Override // java.util.AbstractCollection
        public final String toString() {
            d();
            return this.f42487b.toString();
        }

        public class WrappedIterator implements Iterator<V> {

            /* renamed from: a, reason: collision with root package name */
            public final Iterator f42491a;

            /* renamed from: b, reason: collision with root package name */
            public final Collection f42492b;

            public WrappedIterator() {
                Collection collection = WrappedCollection.this.f42487b;
                this.f42492b = collection;
                this.f42491a = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
            }

            public final void a() {
                WrappedCollection wrappedCollection = WrappedCollection.this;
                wrappedCollection.d();
                if (wrappedCollection.f42487b != this.f42492b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                a();
                return this.f42491a.hasNext();
            }

            @Override // java.util.Iterator
            public final Object next() {
                a();
                return this.f42491a.next();
            }

            @Override // java.util.Iterator
            public final void remove() {
                this.f42491a.remove();
                WrappedCollection wrappedCollection = WrappedCollection.this;
                AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
                abstractMapBasedMultimap.f42465f--;
                wrappedCollection.f();
            }

            public WrappedIterator(Iterator it) {
                this.f42492b = WrappedCollection.this.f42487b;
                this.f42491a = it;
            }
        }
    }
}
