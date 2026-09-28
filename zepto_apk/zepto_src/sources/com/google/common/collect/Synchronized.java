package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class Synchronized {

    public static final class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {

        /* renamed from: f, reason: collision with root package name */
        public transient Set f43110f;

        /* renamed from: g, reason: collision with root package name */
        public transient Collection f43111g;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public final boolean containsValue(Object obj) {
            return values().contains(obj);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public final Set entrySet() {
            Set set;
            synchronized (this.f43126b) {
                try {
                    if (this.f43110f == null) {
                        this.f43110f = new SynchronizedAsMapEntries(((Map) this.f43125a).entrySet(), this.f43126b);
                    }
                    set = this.f43110f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public final Object get(Object obj) {
            Collection collectionA;
            synchronized (this.f43126b) {
                Collection collection = (Collection) super.get(obj);
                collectionA = collection == null ? null : Synchronized.a(this.f43126b, collection);
            }
            return collectionA;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public final Collection values() {
            Collection collection;
            synchronized (this.f43126b) {
                try {
                    if (this.f43111g == null) {
                        this.f43111g = new SynchronizedAsMapValues(((Map) this.f43125a).values(), this.f43126b);
                    }
                    collection = this.f43111g;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    public static final class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new TransformedIterator<Collection<Object>, Collection<Object>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapValues.1
                @Override // com.google.common.collect.TransformedIterator
                public final Object a(Object obj) {
                    return Synchronized.a(SynchronizedAsMapValues.this.f43126b, (Collection) obj);
                }
            };
        }
    }

    public static final class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {

        /* renamed from: f, reason: collision with root package name */
        public transient Set f43116f;

        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        public final Map f() {
            return (BiMap) ((Map) this.f43125a);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public final Set values() {
            Set set;
            synchronized (this.f43126b) {
                try {
                    if (this.f43116f == null) {
                        this.f43116f = new SynchronizedSet(((BiMap) ((Map) this.f43125a)).values(), this.f43126b);
                    }
                    set = this.f43116f;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    public static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        @Override // java.util.Deque
        public final void addFirst(Object obj) {
            synchronized (this.f43126b) {
                ((Deque) super.f()).addFirst(obj);
            }
        }

        @Override // java.util.Deque
        public final void addLast(Object obj) {
            synchronized (this.f43126b) {
                ((Deque) super.f()).addLast(obj);
            }
        }

        @Override // java.util.Deque
        public final Iterator descendingIterator() {
            Iterator<E> itDescendingIterator;
            synchronized (this.f43126b) {
                itDescendingIterator = ((Deque) super.f()).descendingIterator();
            }
            return itDescendingIterator;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue, com.google.common.collect.Synchronized.SynchronizedCollection
        public final Collection f() {
            return (Deque) super.f();
        }

        @Override // java.util.Deque
        public final Object getFirst() {
            Object first;
            synchronized (this.f43126b) {
                first = ((Deque) super.f()).getFirst();
            }
            return first;
        }

        @Override // java.util.Deque
        public final Object getLast() {
            Object last;
            synchronized (this.f43126b) {
                last = ((Deque) super.f()).getLast();
            }
            return last;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedQueue
        /* renamed from: j */
        public final Queue f() {
            return (Deque) super.f();
        }

        @Override // java.util.Deque
        public final boolean offerFirst(Object obj) {
            boolean zOfferFirst;
            synchronized (this.f43126b) {
                zOfferFirst = ((Deque) super.f()).offerFirst(obj);
            }
            return zOfferFirst;
        }

        @Override // java.util.Deque
        public final boolean offerLast(Object obj) {
            boolean zOfferLast;
            synchronized (this.f43126b) {
                zOfferLast = ((Deque) super.f()).offerLast(obj);
            }
            return zOfferLast;
        }

        @Override // java.util.Deque
        public final Object peekFirst() {
            Object objPeekFirst;
            synchronized (this.f43126b) {
                objPeekFirst = ((Deque) super.f()).peekFirst();
            }
            return objPeekFirst;
        }

        @Override // java.util.Deque
        public final Object peekLast() {
            Object objPeekLast;
            synchronized (this.f43126b) {
                objPeekLast = ((Deque) super.f()).peekLast();
            }
            return objPeekLast;
        }

        @Override // java.util.Deque
        public final Object pollFirst() {
            Object objPollFirst;
            synchronized (this.f43126b) {
                objPollFirst = ((Deque) super.f()).pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.Deque
        public final Object pollLast() {
            Object objPollLast;
            synchronized (this.f43126b) {
                objPollLast = ((Deque) super.f()).pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.Deque
        public final Object pop() {
            Object objPop;
            synchronized (this.f43126b) {
                objPop = ((Deque) super.f()).pop();
            }
            return objPop;
        }

        @Override // java.util.Deque
        public final void push(Object obj) {
            synchronized (this.f43126b) {
                ((Deque) super.f()).push(obj);
            }
        }

        @Override // java.util.Deque
        public final Object removeFirst() {
            Object objRemoveFirst;
            synchronized (this.f43126b) {
                objRemoveFirst = ((Deque) super.f()).removeFirst();
            }
            return objRemoveFirst;
        }

        @Override // java.util.Deque
        public final boolean removeFirstOccurrence(Object obj) {
            boolean zRemoveFirstOccurrence;
            synchronized (this.f43126b) {
                zRemoveFirstOccurrence = ((Deque) super.f()).removeFirstOccurrence(obj);
            }
            return zRemoveFirstOccurrence;
        }

        @Override // java.util.Deque
        public final Object removeLast() {
            Object objRemoveLast;
            synchronized (this.f43126b) {
                objRemoveLast = ((Deque) super.f()).removeLast();
            }
            return objRemoveLast;
        }

        @Override // java.util.Deque
        public final boolean removeLastOccurrence(Object obj) {
            boolean zRemoveLastOccurrence;
            synchronized (this.f43126b) {
                zRemoveLastOccurrence = ((Deque) super.f()).removeLastOccurrence(obj);
            }
            return zRemoveLastOccurrence;
        }
    }

    @GwtIncompatible
    public static final class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            boolean zEquals;
            synchronized (this.f43126b) {
                zEquals = ((Map.Entry) this.f43125a).equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            Object key;
            synchronized (this.f43126b) {
                key = ((Map.Entry) this.f43125a).getKey();
            }
            return key;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            Object value;
            synchronized (this.f43126b) {
                value = ((Map.Entry) this.f43125a).getValue();
            }
            return value;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = ((Map.Entry) this.f43125a).hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map.Entry
        public final Object setValue(Object obj) {
            Object value;
            synchronized (this.f43126b) {
                value = ((Map.Entry) this.f43125a).setValue(obj);
            }
            return value;
        }
    }

    public static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        @Override // java.util.List
        public final void add(int i2, Object obj) {
            synchronized (this.f43126b) {
                f().add(i2, obj);
            }
        }

        @Override // java.util.List
        public final boolean addAll(int i2, Collection collection) {
            boolean zAddAll;
            synchronized (this.f43126b) {
                zAddAll = f().addAll(i2, collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection, java.util.List
        public final boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f43126b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.List
        public final Object get(int i2) {
            Object obj;
            synchronized (this.f43126b) {
                obj = f().get(i2);
            }
            return obj;
        }

        @Override // java.util.Collection, java.util.List
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.List
        public final int indexOf(Object obj) {
            int iIndexOf;
            synchronized (this.f43126b) {
                iIndexOf = f().indexOf(obj);
            }
            return iIndexOf;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public final List f() {
            return (List) ((Collection) this.f43125a);
        }

        @Override // java.util.List
        public final int lastIndexOf(Object obj) {
            int iLastIndexOf;
            synchronized (this.f43126b) {
                iLastIndexOf = f().lastIndexOf(obj);
            }
            return iLastIndexOf;
        }

        @Override // java.util.List
        public final ListIterator listIterator() {
            return f().listIterator();
        }

        @Override // java.util.List
        public final Object remove(int i2) {
            Object objRemove;
            synchronized (this.f43126b) {
                objRemove = f().remove(i2);
            }
            return objRemove;
        }

        @Override // java.util.List
        public final Object set(int i2, Object obj) {
            Object obj2;
            synchronized (this.f43126b) {
                obj2 = f().set(i2, obj);
            }
            return obj2;
        }

        @Override // java.util.List
        public final List subList(int i2, int i3) {
            List listC;
            synchronized (this.f43126b) {
                listC = Synchronized.c(f().subList(i2, i3), this.f43126b);
            }
            return listC;
        }

        @Override // java.util.List
        public final ListIterator listIterator(int i2) {
            return f().listIterator(i2);
        }
    }

    public static final class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap
        public final Multimap f() {
            return (ListMultimap) ((Multimap) this.f43125a);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final List b(Object obj) {
            List listB;
            synchronized (this.f43126b) {
                listB = ((ListMultimap) ((Multimap) this.f43125a)).b(obj);
            }
            return listB;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final List l(Object obj) {
            List listC;
            synchronized (this.f43126b) {
                listC = Synchronized.c(((ListMultimap) ((Multimap) this.f43125a)).l(obj), this.f43126b);
            }
            return listC;
        }
    }

    public static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {

        /* renamed from: c, reason: collision with root package name */
        public transient Set f43117c;

        /* renamed from: d, reason: collision with root package name */
        public transient Collection f43118d;

        /* renamed from: e, reason: collision with root package name */
        public transient Set f43119e;

        @Override // java.util.Map
        public final void clear() {
            synchronized (this.f43126b) {
                f().clear();
            }
        }

        @Override // java.util.Map
        public final boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f43126b) {
                zContainsKey = f().containsKey(obj);
            }
            return zContainsKey;
        }

        public boolean containsValue(Object obj) {
            boolean zContainsValue;
            synchronized (this.f43126b) {
                zContainsValue = f().containsValue(obj);
            }
            return zContainsValue;
        }

        public Set entrySet() {
            Set set;
            synchronized (this.f43126b) {
                try {
                    if (this.f43119e == null) {
                        this.f43119e = new SynchronizedSet(f().entrySet(), this.f43126b);
                    }
                    set = this.f43119e;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public final boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f43126b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        public Map f() {
            return (Map) this.f43125a;
        }

        public Object get(Object obj) {
            Object obj2;
            synchronized (this.f43126b) {
                obj2 = f().get(obj);
            }
            return obj2;
        }

        @Override // java.util.Map
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Map
        public final boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f43126b) {
                zIsEmpty = f().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // java.util.Map
        public Set keySet() {
            Set set;
            synchronized (this.f43126b) {
                try {
                    if (this.f43117c == null) {
                        this.f43117c = new SynchronizedSet(f().keySet(), this.f43126b);
                    }
                    set = this.f43117c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        @Override // java.util.Map
        public final Object put(Object obj, Object obj2) {
            Object objPut;
            synchronized (this.f43126b) {
                objPut = f().put(obj, obj2);
            }
            return objPut;
        }

        @Override // java.util.Map
        public final void putAll(Map map) {
            synchronized (this.f43126b) {
                f().putAll(map);
            }
        }

        @Override // java.util.Map
        public final Object remove(Object obj) {
            Object objRemove;
            synchronized (this.f43126b) {
                objRemove = f().remove(obj);
            }
            return objRemove;
        }

        @Override // java.util.Map
        public final int size() {
            int size;
            synchronized (this.f43126b) {
                size = f().size();
            }
            return size;
        }

        public Collection values() {
            Collection collection;
            synchronized (this.f43126b) {
                try {
                    if (this.f43118d == null) {
                        this.f43118d = new SynchronizedCollection(f().values(), this.f43126b);
                    }
                    collection = this.f43118d;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    public static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {

        /* renamed from: c, reason: collision with root package name */
        public transient Collection f43120c;

        @Override // com.google.common.collect.Multimap
        public final Map asMap() {
            synchronized (this.f43126b) {
            }
            return null;
        }

        public Collection b(Object obj) {
            Collection collectionB;
            synchronized (this.f43126b) {
                collectionB = f().b(obj);
            }
            return collectionB;
        }

        @Override // com.google.common.collect.Multimap
        public final void clear() {
            synchronized (this.f43126b) {
                f().clear();
            }
        }

        @Override // com.google.common.collect.Multimap
        public final boolean containsKey(Object obj) {
            boolean zContainsKey;
            synchronized (this.f43126b) {
                zContainsKey = f().containsKey(obj);
            }
            return zContainsKey;
        }

        @Override // com.google.common.collect.Multimap
        public Collection d() {
            synchronized (this.f43126b) {
            }
            return null;
        }

        @Override // com.google.common.collect.Multimap
        public final boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f43126b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        public Multimap f() {
            return (Multimap) this.f43125a;
        }

        /* renamed from: get */
        public Collection l(Object obj) {
            Collection collectionA;
            synchronized (this.f43126b) {
                collectionA = Synchronized.a(this.f43126b, f().l(obj));
            }
            return collectionA;
        }

        @Override // com.google.common.collect.Multimap
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Multimap
        public final boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f43126b) {
                zIsEmpty = f().isEmpty();
            }
            return zIsEmpty;
        }

        @Override // com.google.common.collect.Multimap
        public final Set keySet() {
            synchronized (this.f43126b) {
            }
            return null;
        }

        @Override // com.google.common.collect.Multimap
        public final boolean put(Object obj, Object obj2) {
            boolean zPut;
            synchronized (this.f43126b) {
                zPut = f().put(obj, obj2);
            }
            return zPut;
        }

        @Override // com.google.common.collect.Multimap
        public final boolean remove(Object obj, Object obj2) {
            boolean zRemove;
            synchronized (this.f43126b) {
                zRemove = f().remove(obj, obj2);
            }
            return zRemove;
        }

        @Override // com.google.common.collect.Multimap
        public final boolean s(Object obj, Object obj2) {
            boolean zS;
            synchronized (this.f43126b) {
                zS = f().s(obj, obj2);
            }
            return zS;
        }

        @Override // com.google.common.collect.Multimap
        public final int size() {
            int size;
            synchronized (this.f43126b) {
                size = f().size();
            }
            return size;
        }

        @Override // com.google.common.collect.Multimap
        public final Collection values() {
            Collection collection;
            synchronized (this.f43126b) {
                try {
                    if (this.f43120c == null) {
                        this.f43120c = new SynchronizedCollection(f().values(), this.f43126b);
                    }
                    collection = this.f43120c;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    public static final class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        @Override // com.google.common.collect.Multiset
        public final int O1(Object obj) {
            int iO1;
            synchronized (this.f43126b) {
                iO1 = f().O1(obj);
            }
            return iO1;
        }

        @Override // com.google.common.collect.Multiset
        public final int T(int i2, Object obj) {
            int iT;
            synchronized (this.f43126b) {
                iT = f().T(i2, obj);
            }
            return iT;
        }

        @Override // com.google.common.collect.Multiset
        public final int add(int i2, Object obj) {
            int iAdd;
            synchronized (this.f43126b) {
                iAdd = f().add(i2, obj);
            }
            return iAdd;
        }

        @Override // com.google.common.collect.Multiset
        public final Set e() {
            synchronized (this.f43126b) {
            }
            return null;
        }

        @Override // com.google.common.collect.Multiset
        public final Set entrySet() {
            synchronized (this.f43126b) {
            }
            return null;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public final boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f43126b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Collection, com.google.common.collect.Multiset
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public final Multiset f() {
            return (Multiset) ((Collection) this.f43125a);
        }

        @Override // com.google.common.collect.Multiset
        public final int o1(Object obj) {
            int iO1;
            synchronized (this.f43126b) {
                iO1 = f().o1(obj);
            }
            return iO1;
        }

        @Override // com.google.common.collect.Multiset
        public final boolean u0(int i2, Object obj) {
            boolean zU0;
            synchronized (this.f43126b) {
                zU0 = f().u0(i2, obj);
            }
            return zU0;
        }
    }

    public static class SynchronizedObject implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final Object f43125a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f43126b;

        public SynchronizedObject(Object obj, Object obj2) {
            obj.getClass();
            this.f43125a = obj;
            this.f43126b = obj2 == null ? this : obj2;
        }

        public final String toString() {
            String string;
            synchronized (this.f43126b) {
                string = this.f43125a.toString();
            }
            return string;
        }
    }

    public static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        @Override // java.util.Queue
        public final Object element() {
            Object objElement;
            synchronized (this.f43126b) {
                objElement = f().element();
            }
            return objElement;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Queue f() {
            return (Queue) ((Collection) this.f43125a);
        }

        @Override // java.util.Queue
        public final boolean offer(Object obj) {
            boolean zOffer;
            synchronized (this.f43126b) {
                zOffer = f().offer(obj);
            }
            return zOffer;
        }

        @Override // java.util.Queue
        public final Object peek() {
            Object objPeek;
            synchronized (this.f43126b) {
                objPeek = f().peek();
            }
            return objPeek;
        }

        @Override // java.util.Queue
        public final Object poll() {
            Object objPoll;
            synchronized (this.f43126b) {
                objPoll = f().poll();
            }
            return objPoll;
        }

        @Override // java.util.Queue
        public final Object remove() {
            Object objRemove;
            synchronized (this.f43126b) {
                objRemove = f().remove();
            }
            return objRemove;
        }
    }

    public static final class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
    }

    public static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        public boolean equals(Object obj) {
            boolean zEquals;
            if (obj == this) {
                return true;
            }
            synchronized (this.f43126b) {
                zEquals = f().equals(obj);
            }
            return zEquals;
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = f().hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public Set f() {
            return (Set) ((Collection) this.f43125a);
        }
    }

    public static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public SetMultimap f() {
            return (SetMultimap) ((Multimap) this.f43125a);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public Set b(Object obj) {
            Set setB;
            synchronized (this.f43126b) {
                setB = f().b(obj);
            }
            return setB;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap
        public final Set d() {
            synchronized (this.f43126b) {
            }
            return null;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public Set l(Object obj) {
            SynchronizedSet synchronizedSet;
            synchronized (this.f43126b) {
                synchronizedSet = new SynchronizedSet(f().l(obj), this.f43126b);
            }
            return synchronizedSet;
        }
    }

    public static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        @Override // java.util.SortedMap
        public final Comparator comparator() {
            Comparator<? super K> comparator;
            synchronized (this.f43126b) {
                comparator = f().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            Object objFirstKey;
            synchronized (this.f43126b) {
                objFirstKey = f().firstKey();
            }
            return objFirstKey;
        }

        public SortedMap headMap(Object obj) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.f43126b) {
                synchronizedSortedMap = new SynchronizedSortedMap(f().headMap(obj), this.f43126b);
            }
            return synchronizedSortedMap;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public SortedMap f() {
            return (SortedMap) ((Map) this.f43125a);
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            Object objLastKey;
            synchronized (this.f43126b) {
                objLastKey = f().lastKey();
            }
            return objLastKey;
        }

        public SortedMap subMap(Object obj, Object obj2) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.f43126b) {
                synchronizedSortedMap = new SynchronizedSortedMap(f().subMap(obj, obj2), this.f43126b);
            }
            return synchronizedSortedMap;
        }

        public SortedMap tailMap(Object obj) {
            SynchronizedSortedMap synchronizedSortedMap;
            synchronized (this.f43126b) {
                synchronizedSortedMap = new SynchronizedSortedMap(f().tailMap(obj), this.f43126b);
            }
            return synchronizedSortedMap;
        }
    }

    public static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        @Override // java.util.SortedSet
        public final Comparator comparator() {
            Comparator<? super E> comparator;
            synchronized (this.f43126b) {
                comparator = f().comparator();
            }
            return comparator;
        }

        @Override // java.util.SortedSet
        public final Object first() {
            Object objFirst;
            synchronized (this.f43126b) {
                objFirst = f().first();
            }
            return objFirst;
        }

        public SortedSet headSet(Object obj) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.f43126b) {
                synchronizedSortedSet = new SynchronizedSortedSet(f().headSet(obj), this.f43126b);
            }
            return synchronizedSortedSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet
        /* renamed from: k, reason: merged with bridge method [inline-methods] */
        public SortedSet f() {
            return (SortedSet) super.f();
        }

        @Override // java.util.SortedSet
        public final Object last() {
            Object objLast;
            synchronized (this.f43126b) {
                objLast = f().last();
            }
            return objLast;
        }

        public SortedSet subSet(Object obj, Object obj2) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.f43126b) {
                synchronizedSortedSet = new SynchronizedSortedSet(f().subSet(obj, obj2), this.f43126b);
            }
            return synchronizedSortedSet;
        }

        public SortedSet tailSet(Object obj) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.f43126b) {
                synchronizedSortedSet = new SynchronizedSortedSet(f().tailSet(obj), this.f43126b);
            }
            return synchronizedSortedSet;
        }
    }

    public static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {

        /* renamed from: com.google.common.collect.Synchronized$SynchronizedTable$2, reason: invalid class name */
        class AnonymousClass2 implements Function<Map<Object, Object>, Map<Object, Object>> {
            @Override // com.google.common.base.Function
            public final Map<Object, Object> apply(Map<Object, Object> map) {
                throw null;
            }
        }

        @Override // com.google.common.collect.Table
        public final boolean equals(Object obj) {
            boolean zEquals;
            if (this == obj) {
                return true;
            }
            synchronized (this.f43126b) {
                zEquals = ((Table) this.f43125a).equals(obj);
            }
            return zEquals;
        }

        @Override // com.google.common.collect.Table
        public final Map g() {
            SynchronizedMap synchronizedMap;
            synchronized (this.f43126b) {
                synchronizedMap = new SynchronizedMap(new Maps.TransformedEntriesMap(((Table) this.f43125a).g(), new Maps.AnonymousClass9(new Function<Map<Object, Object>, Map<Object, Object>>() { // from class: com.google.common.collect.Synchronized.SynchronizedTable.1
                    @Override // com.google.common.base.Function
                    public final Map<Object, Object> apply(Map<Object, Object> map) {
                        return new SynchronizedMap(map, SynchronizedTable.this.f43126b);
                    }
                })), this.f43126b);
            }
            return synchronizedMap;
        }

        @Override // com.google.common.collect.Table
        public final int hashCode() {
            int iHashCode;
            synchronized (this.f43126b) {
                iHashCode = ((Table) this.f43125a).hashCode();
            }
            return iHashCode;
        }

        @Override // com.google.common.collect.Table
        public final Set n() {
            SynchronizedSet synchronizedSet;
            synchronized (this.f43126b) {
                synchronizedSet = new SynchronizedSet(((Table) this.f43125a).n(), this.f43126b);
            }
            return synchronizedSet;
        }

        @Override // com.google.common.collect.Table
        public final int size() {
            int size;
            synchronized (this.f43126b) {
                size = ((Table) this.f43125a).size();
            }
            return size;
        }
    }

    public static Collection a(Object obj, Collection collection) {
        return collection instanceof SortedSet ? new SynchronizedSortedSet((SortedSet) collection, obj) : collection instanceof Set ? new SynchronizedSet((Set) collection, obj) : collection instanceof List ? c((List) collection, obj) : new SynchronizedCollection(collection, obj);
    }

    public static Map.Entry b(Map.Entry entry, Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    public static List c(List list, Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    public static final class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap
        public final Multimap f() {
            return (SortedSetMultimap) super.f();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap
        /* renamed from: j */
        public final SetMultimap f() {
            return (SortedSetMultimap) super.f();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        public final SortedSet b(Object obj) {
            SortedSet sortedSetB;
            synchronized (this.f43126b) {
                sortedSetB = ((SortedSetMultimap) super.f()).b(obj);
            }
            return sortedSetB;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSetMultimap, com.google.common.collect.Synchronized.SynchronizedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
        /* renamed from: get */
        public final SortedSet l(Object obj) {
            SynchronizedSortedSet synchronizedSortedSet;
            synchronized (this.f43126b) {
                synchronizedSortedSet = new SynchronizedSortedSet(((SortedSetMultimap) super.f()).l(obj), this.f43126b);
            }
            return synchronizedSortedSet;
        }
    }

    @VisibleForTesting
    public static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        @Override // java.util.Collection
        public final boolean add(Object obj) {
            boolean zAdd;
            synchronized (this.f43126b) {
                zAdd = f().add(obj);
            }
            return zAdd;
        }

        @Override // java.util.Collection
        public final boolean addAll(Collection collection) {
            boolean zAddAll;
            synchronized (this.f43126b) {
                zAddAll = f().addAll(collection);
            }
            return zAddAll;
        }

        @Override // java.util.Collection
        public final void clear() {
            synchronized (this.f43126b) {
                f().clear();
            }
        }

        public boolean contains(Object obj) {
            boolean zContains;
            synchronized (this.f43126b) {
                zContains = f().contains(obj);
            }
            return zContains;
        }

        public boolean containsAll(Collection collection) {
            boolean zContainsAll;
            synchronized (this.f43126b) {
                zContainsAll = f().containsAll(collection);
            }
            return zContainsAll;
        }

        public Collection f() {
            return (Collection) this.f43125a;
        }

        @Override // java.util.Collection
        public final boolean isEmpty() {
            boolean zIsEmpty;
            synchronized (this.f43126b) {
                zIsEmpty = f().isEmpty();
            }
            return zIsEmpty;
        }

        public Iterator iterator() {
            return f().iterator();
        }

        public boolean remove(Object obj) {
            boolean zRemove;
            synchronized (this.f43126b) {
                zRemove = f().remove(obj);
            }
            return zRemove;
        }

        public boolean removeAll(Collection collection) {
            boolean zRemoveAll;
            synchronized (this.f43126b) {
                zRemoveAll = f().removeAll(collection);
            }
            return zRemoveAll;
        }

        public boolean retainAll(Collection collection) {
            boolean zRetainAll;
            synchronized (this.f43126b) {
                zRetainAll = f().retainAll(collection);
            }
            return zRetainAll;
        }

        @Override // java.util.Collection
        public final int size() {
            int size;
            synchronized (this.f43126b) {
                size = f().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.f43126b) {
                array = f().toArray();
            }
            return array;
        }

        public Object[] toArray(Object[] objArr) {
            Object[] array;
            synchronized (this.f43126b) {
                array = f().toArray(objArr);
            }
            return array;
        }
    }

    public static final class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            boolean zContains;
            synchronized (this.f43126b) {
                Set setF = f();
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    entry.getClass();
                    zContains = setF.contains(new Maps.AnonymousClass7(entry));
                } else {
                    zContains = false;
                }
            }
            return zContains;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final boolean containsAll(Collection collection) {
            boolean zA;
            synchronized (this.f43126b) {
                zA = Collections2.a(f(), collection);
            }
            return zA;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSet, java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            boolean zB;
            if (obj == this) {
                return true;
            }
            synchronized (this.f43126b) {
                zB = Sets.b(f(), obj);
            }
            return zB;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return new TransformedIterator<Map.Entry<Object, Collection<Object>>, Map.Entry<Object, Collection<Object>>>(super.iterator()) { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1
                @Override // com.google.common.collect.TransformedIterator
                public final Object a(Object obj) {
                    final Map.Entry entry = (Map.Entry) obj;
                    return new ForwardingMapEntry<Object, Collection<Object>>() { // from class: com.google.common.collect.Synchronized.SynchronizedAsMapEntries.1.1
                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public final Object getValue() {
                            return Synchronized.a(SynchronizedAsMapEntries.this.f43126b, (Collection) entry.getValue());
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                        public final Object t() {
                            return entry;
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry
                        /* renamed from: u */
                        public final Map.Entry t() {
                            return entry;
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            boolean zRemove;
            synchronized (this.f43126b) {
                Set setF = f();
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    entry.getClass();
                    zRemove = setF.remove(new Maps.AnonymousClass7(entry));
                } else {
                    zRemove = false;
                }
            }
            return zRemove;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            boolean zL;
            synchronized (this.f43126b) {
                zL = Iterators.l(collection, f().iterator());
            }
            return zL;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            boolean z;
            synchronized (this.f43126b) {
                Iterator it = f().iterator();
                collection.getClass();
                z = false;
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                        z = true;
                    }
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            Object[] objArr;
            synchronized (this.f43126b) {
                Set setF = f();
                objArr = new Object[setF.size()];
                ObjectArrays.b(setF, objArr);
            }
            return objArr;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedCollection, java.util.Collection, java.util.Set
        public final Object[] toArray(Object[] objArr) {
            Object[] objArrC;
            synchronized (this.f43126b) {
                objArrC = ObjectArrays.c(f(), objArr);
            }
            return objArrC;
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    public static final class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {

        /* renamed from: f, reason: collision with root package name */
        public transient NavigableSet f43121f;

        /* renamed from: g, reason: collision with root package name */
        public transient NavigableMap f43122g;

        /* renamed from: h, reason: collision with root package name */
        public transient NavigableSet f43123h;

        @Override // java.util.NavigableMap
        public final Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).ceilingEntry(obj), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Object ceilingKey(Object obj) {
            Object objCeilingKey;
            synchronized (this.f43126b) {
                objCeilingKey = ((NavigableMap) super.f()).ceilingKey(obj);
            }
            return objCeilingKey;
        }

        @Override // java.util.NavigableMap
        public final NavigableSet descendingKeySet() {
            synchronized (this.f43126b) {
                try {
                    NavigableSet navigableSet = this.f43121f;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    SynchronizedNavigableSet synchronizedNavigableSet = new SynchronizedNavigableSet(((NavigableMap) super.f()).descendingKeySet(), this.f43126b);
                    this.f43121f = synchronizedNavigableSet;
                    return synchronizedNavigableSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public final NavigableMap descendingMap() {
            synchronized (this.f43126b) {
                try {
                    NavigableMap navigableMap = this.f43122g;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    SynchronizedNavigableMap synchronizedNavigableMap = new SynchronizedNavigableMap(((NavigableMap) super.f()).descendingMap(), this.f43126b);
                    this.f43122g = synchronizedNavigableMap;
                    return synchronizedNavigableMap;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, com.google.common.collect.Synchronized.SynchronizedMap
        public final Map f() {
            return (NavigableMap) super.f();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry firstEntry() {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).firstEntry(), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry floorEntry(Object obj) {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).floorEntry(obj), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Object floorKey(Object obj) {
            Object objFloorKey;
            synchronized (this.f43126b) {
                objFloorKey = ((NavigableMap) super.f()).floorKey(obj);
            }
            return objFloorKey;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.f43126b) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(((NavigableMap) super.f()).headMap(obj, z), this.f43126b);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry higherEntry(Object obj) {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).higherEntry(obj), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Object higherKey(Object obj) {
            Object objHigherKey;
            synchronized (this.f43126b) {
                objHigherKey = ((NavigableMap) super.f()).higherKey(obj);
            }
            return objHigherKey;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap
        /* renamed from: j */
        public final SortedMap f() {
            return (NavigableMap) super.f();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedMap, java.util.Map
        public final Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lastEntry() {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).lastEntry(), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lowerEntry(Object obj) {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).lowerEntry(obj), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Object lowerKey(Object obj) {
            Object objLowerKey;
            synchronized (this.f43126b) {
                objLowerKey = ((NavigableMap) super.f()).lowerKey(obj);
            }
            return objLowerKey;
        }

        @Override // java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            synchronized (this.f43126b) {
                try {
                    NavigableSet navigableSet = this.f43123h;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    SynchronizedNavigableSet synchronizedNavigableSet = new SynchronizedNavigableSet(((NavigableMap) super.f()).navigableKeySet(), this.f43126b);
                    this.f43123h = synchronizedNavigableSet;
                    return synchronizedNavigableSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).pollFirstEntry(), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            Map.Entry entryB;
            synchronized (this.f43126b) {
                entryB = Synchronized.b(((NavigableMap) super.f()).pollLastEntry(), this.f43126b);
            }
            return entryB;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.f43126b) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(((NavigableMap) super.f()).subMap(obj, z, obj2, z2), this.f43126b);
            }
            return synchronizedNavigableMap;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            SynchronizedNavigableMap synchronizedNavigableMap;
            synchronized (this.f43126b) {
                synchronizedNavigableMap = new SynchronizedNavigableMap(((NavigableMap) super.f()).tailMap(obj, z), this.f43126b);
            }
            return synchronizedNavigableMap;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    public static final class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {

        /* renamed from: c, reason: collision with root package name */
        public transient NavigableSet f43124c;

        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            Object objCeiling;
            synchronized (this.f43126b) {
                objCeiling = ((NavigableSet) super.f()).ceiling(obj);
            }
            return objCeiling;
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return ((NavigableSet) super.f()).descendingIterator();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            synchronized (this.f43126b) {
                try {
                    NavigableSet navigableSet = this.f43124c;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    SynchronizedNavigableSet synchronizedNavigableSet = new SynchronizedNavigableSet(((NavigableSet) super.f()).descendingSet(), this.f43126b);
                    this.f43124c = synchronizedNavigableSet;
                    return synchronizedNavigableSet;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet, com.google.common.collect.Synchronized.SynchronizedCollection
        public final Collection f() {
            return (NavigableSet) super.f();
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            Object objFloor;
            synchronized (this.f43126b) {
                objFloor = ((NavigableSet) super.f()).floor(obj);
            }
            return objFloor;
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.f43126b) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(((NavigableSet) super.f()).headSet(obj, z), this.f43126b);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            Object objHigher;
            synchronized (this.f43126b) {
                objHigher = ((NavigableSet) super.f()).higher(obj);
            }
            return objHigher;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, com.google.common.collect.Synchronized.SynchronizedSet
        /* renamed from: j */
        public final Set f() {
            return (NavigableSet) super.f();
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet
        /* renamed from: k */
        public final SortedSet f() {
            return (NavigableSet) super.f();
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            Object objLower;
            synchronized (this.f43126b) {
                objLower = ((NavigableSet) super.f()).lower(obj);
            }
            return objLower;
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            Object objPollFirst;
            synchronized (this.f43126b) {
                objPollFirst = ((NavigableSet) super.f()).pollFirst();
            }
            return objPollFirst;
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            Object objPollLast;
            synchronized (this.f43126b) {
                objPollLast = ((NavigableSet) super.f()).pollLast();
            }
            return objPollLast;
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.f43126b) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(((NavigableSet) super.f()).subSet(obj, z, obj2, z2), this.f43126b);
            }
            return synchronizedNavigableSet;
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            SynchronizedNavigableSet synchronizedNavigableSet;
            synchronized (this.f43126b) {
                synchronizedNavigableSet = new SynchronizedNavigableSet(((NavigableSet) super.f()).tailSet(obj, z), this.f43126b);
            }
            return synchronizedNavigableSet;
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Synchronized.SynchronizedSortedSet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }
}
