package com.google.common.collect;

import com.google.android.gms.common.api.Api;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class Maps {

    /* renamed from: com.google.common.collect.Maps$1, reason: invalid class name */
    class AnonymousClass1 extends TransformedIterator<Map.Entry<Object, Object>, Object> {
        @Override // com.google.common.collect.TransformedIterator
        public final Object a(Object obj) {
            return ((Map.Entry) obj).getKey();
        }
    }

    /* renamed from: com.google.common.collect.Maps$10, reason: invalid class name */
    class AnonymousClass10 implements Function<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f42883a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f42884b;

        public AnonymousClass10(EntryTransformer entryTransformer, Object obj) {
            this.f42883a = entryTransformer;
            this.f42884b = obj;
        }

        @Override // com.google.common.base.Function
        public final Object apply(Object obj) {
            return ((AnonymousClass9) this.f42883a).f42895a.apply(obj);
        }
    }

    /* renamed from: com.google.common.collect.Maps$12, reason: invalid class name */
    class AnonymousClass12 extends AbstractMapEntry<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f42886a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f42887b;

        public AnonymousClass12(Map.Entry entry, EntryTransformer entryTransformer) {
            this.f42886a = entry;
            this.f42887b = entryTransformer;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42886a.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            Map.Entry entry = this.f42886a;
            return this.f42887b.a(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: com.google.common.collect.Maps$13, reason: invalid class name */
    class AnonymousClass13 implements Function<Map.Entry<Object, Object>, Map.Entry<Object, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EntryTransformer f42888a;

        public AnonymousClass13(EntryTransformer entryTransformer) {
            this.f42888a = entryTransformer;
        }

        @Override // com.google.common.base.Function
        public final Map.Entry<Object, Object> apply(Map.Entry<Object, Object> entry) {
            Map.Entry<Object, Object> entry2 = entry;
            EntryTransformer entryTransformer = this.f42888a;
            entryTransformer.getClass();
            entry2.getClass();
            return new AnonymousClass12(entry2, entryTransformer);
        }
    }

    /* renamed from: com.google.common.collect.Maps$2, reason: invalid class name */
    class AnonymousClass2 extends TransformedIterator<Map.Entry<Object, Object>, Object> {
        @Override // com.google.common.collect.TransformedIterator
        public final Object a(Object obj) {
            return ((Map.Entry) obj).getValue();
        }
    }

    /* renamed from: com.google.common.collect.Maps$3, reason: invalid class name */
    class AnonymousClass3 extends TransformedIterator<Object, Map.Entry<Object, Object>> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function f42889b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Iterator it, Function function) {
            super(it);
            this.f42889b = function;
        }

        @Override // com.google.common.collect.TransformedIterator
        public final Object a(Object obj) {
            return new ImmutableEntry(obj, this.f42889b.apply(obj));
        }
    }

    /* renamed from: com.google.common.collect.Maps$5, reason: invalid class name */
    class AnonymousClass5 extends ForwardingSortedSet<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SortedSet f42891a;

        public AnonymousClass5(SortedSet sortedSet) {
            this.f42891a = sortedSet;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet
        /* renamed from: B */
        public final Set t() {
            return this.f42891a;
        }

        @Override // com.google.common.collect.ForwardingSortedSet
        /* renamed from: C */
        public final SortedSet t() {
            return this.f42891a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet headSet(Object obj) {
            return new AnonymousClass5(super.headSet(obj));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return new AnonymousClass5(super.subSet(obj, obj2));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            return this.f42891a;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet tailSet(Object obj) {
            return new AnonymousClass5(super.tailSet(obj));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return this.f42891a;
        }
    }

    /* renamed from: com.google.common.collect.Maps$7, reason: invalid class name */
    class AnonymousClass7 extends AbstractMapEntry<Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map.Entry f42893a;

        public AnonymousClass7(Map.Entry entry) {
            this.f42893a = entry;
        }

        @Override // java.util.Map.Entry
        public final Object getKey() {
            return this.f42893a.getKey();
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return this.f42893a.getValue();
        }
    }

    /* renamed from: com.google.common.collect.Maps$8, reason: invalid class name */
    class AnonymousClass8 extends UnmodifiableIterator<Map.Entry<Object, Object>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f42894a;

        public AnonymousClass8(Iterator it) {
            this.f42894a = it;
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f42894a.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            Map.Entry entry = (Map.Entry) this.f42894a.next();
            entry.getClass();
            return new AnonymousClass7(entry);
        }
    }

    /* renamed from: com.google.common.collect.Maps$9, reason: invalid class name */
    class AnonymousClass9 implements EntryTransformer<Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function f42895a;

        public AnonymousClass9(Function function) {
            this.f42895a = function;
        }

        @Override // com.google.common.collect.Maps.EntryTransformer
        public final Object a(Object obj, Object obj2) {
            return this.f42895a.apply(obj2);
        }
    }

    public static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {

        /* renamed from: d, reason: collision with root package name */
        public final SortedMap f42896d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f42897e;

        public AbstractFilteredMap(SortedMap sortedMap, Predicate predicate) {
            this.f42896d = sortedMap;
            this.f42897e = predicate;
        }

        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Collection c() {
            return new FilteredMapValues(this, this.f42896d, this.f42897e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            SortedMap sortedMap = this.f42896d;
            return sortedMap.containsKey(obj) && d(obj, sortedMap.get(obj));
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        public final boolean d(Object obj, Object obj2) {
            return this.f42897e.apply(new ImmutableEntry(obj, obj2));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Object obj2 = this.f42896d.get(obj);
            if (obj2 == null || !d(obj, obj2)) {
                return null;
            }
            return obj2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            Preconditions.f(d(obj, obj2));
            return this.f42896d.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void putAll(Map map) {
            for (Map.Entry<K, V> entry : map.entrySet()) {
                Preconditions.f(d(entry.getKey(), entry.getValue()));
            }
            this.f42896d.putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            if (containsKey(obj)) {
                return this.f42896d.remove(obj);
            }
            return null;
        }
    }

    public static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {

        /* renamed from: d, reason: collision with root package name */
        public final Set f42898d;

        /* renamed from: e, reason: collision with root package name */
        public final Function f42899e;

        public AsMapView(Set set, Function function) {
            set.getClass();
            this.f42898d = set;
            function.getClass();
            this.f42899e = function;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new EntrySet<Object, Object>() { // from class: com.google.common.collect.Maps.AsMapView.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                public final Map g() {
                    return AsMapView.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public final Iterator iterator() {
                    AsMapView asMapView = AsMapView.this;
                    return new AnonymousClass3(asMapView.d().iterator(), asMapView.f42899e);
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set b() {
            final Set setD = d();
            return new ForwardingSet<Object>() { // from class: com.google.common.collect.Maps.4
                @Override // com.google.common.collect.ForwardingSet
                /* renamed from: B */
                public final Set t() {
                    return setD;
                }

                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
                public final boolean add(Object obj) {
                    throw new UnsupportedOperationException();
                }

                @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
                public final boolean addAll(Collection collection) {
                    throw new UnsupportedOperationException();
                }

                @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
                public final Object t() {
                    return setD;
                }

                @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
                /* renamed from: u */
                public final Collection t() {
                    return setD;
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Collection c() {
            return new Collections2.TransformedCollection(this.f42898d, this.f42899e);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void clear() {
            d().clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return d().contains(obj);
        }

        public Set d() {
            return this.f42898d;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            if (Collections2.c(obj, d())) {
                return this.f42899e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            if (d().remove(obj)) {
                return this.f42899e.apply(obj);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return d().size();
        }
    }

    public static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        @Override // com.google.common.base.Converter
        public final Object b(Object obj) {
            throw null;
        }

        @Override // com.google.common.base.Function
        public final boolean equals(Object obj) {
            if (!(obj instanceof BiMapConverter)) {
                return false;
            }
            ((BiMapConverter) obj).getClass();
            throw null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Maps.asConverter(null)";
        }
    }

    @GwtIncompatible
    public static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public transient Ordering f42901a;

        /* renamed from: b, reason: collision with root package name */
        public transient Set f42902b;

        /* renamed from: c, reason: collision with root package name */
        public transient NavigableSet f42903c;

        public abstract NavigableMap B();

        @Override // java.util.NavigableMap
        public final Map.Entry ceilingEntry(Object obj) {
            return B().floorEntry(obj);
        }

        @Override // java.util.NavigableMap
        public final Object ceilingKey(Object obj) {
            return B().floorKey(obj);
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            Ordering ordering = this.f42901a;
            if (ordering != null) {
                return ordering;
            }
            Comparator<? super K> comparator = B().comparator();
            if (comparator == null) {
                comparator = NaturalOrdering.f42971c;
            }
            Ordering orderingG = Ordering.b(comparator).g();
            this.f42901a = orderingG;
            return orderingG;
        }

        @Override // java.util.NavigableMap
        public final NavigableSet descendingKeySet() {
            return B().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap descendingMap() {
            return B();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final Set entrySet() {
            Set set = this.f42902b;
            if (set != null) {
                return set;
            }
            EntrySet<Object, Object> entrySet = new EntrySet<Object, Object>() { // from class: com.google.common.collect.Maps.DescendingMap.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                public final Map g() {
                    return DescendingMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public final Iterator iterator() {
                    return DescendingMap.this.z();
                }
            };
            this.f42902b = entrySet;
            return entrySet;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry firstEntry() {
            return B().lastEntry();
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            return B().lastKey();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry floorEntry(Object obj) {
            return B().ceilingEntry(obj);
        }

        @Override // java.util.NavigableMap
        public final Object floorKey(Object obj) {
            return B().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return B().tailMap(obj, z).descendingMap();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry higherEntry(Object obj) {
            return B().lowerEntry(obj);
        }

        @Override // java.util.NavigableMap
        public final Object higherKey(Object obj) {
            return B().lowerKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lastEntry() {
            return B().firstEntry();
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            return B().firstKey();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lowerEntry(Object obj) {
            return B().higherEntry(obj);
        }

        @Override // java.util.NavigableMap
        public final Object lowerKey(Object obj) {
            return B().higherKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            NavigableSet navigableSet = this.f42903c;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableKeySet navigableKeySet = new NavigableKeySet(this);
            this.f42903c = navigableKeySet;
            return navigableKeySet;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            return B().pollLastEntry();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            return B().pollFirstEntry();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return B().subMap(obj2, z2, obj, z).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Object t() {
            return B();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return B().headMap(obj, z).descendingMap();
        }

        @Override // com.google.common.collect.ForwardingObject
        public final String toString() {
            return Maps.i(this);
        }

        @Override // com.google.common.collect.ForwardingMap
        /* renamed from: u */
        public final Map t() {
            return B();
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public final Collection values() {
            return new Values(this);
        }

        public abstract Iterator z();

        @Override // java.util.NavigableMap, java.util.SortedMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // java.util.NavigableMap, java.util.SortedMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static abstract class EntryFunction implements Function<Map.Entry<?, ?>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f42905a;

        /* renamed from: b, reason: collision with root package name */
        public static final AnonymousClass2 f42906b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ EntryFunction[] f42907c;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.Maps$EntryFunction$1] */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.collect.Maps$EntryFunction$2] */
        static {
            ?? r0 = new EntryFunction() { // from class: com.google.common.collect.Maps.EntryFunction.1
                @Override // com.google.common.base.Function
                public final Object apply(Map.Entry<?, ?> entry) {
                    return entry.getKey();
                }
            };
            f42905a = r0;
            ?? r1 = new EntryFunction() { // from class: com.google.common.collect.Maps.EntryFunction.2
                @Override // com.google.common.base.Function
                public final Object apply(Map.Entry<?, ?> entry) {
                    return entry.getValue();
                }
            };
            f42906b = r1;
            f42907c = new EntryFunction[]{r0, r1};
        }

        public static EntryFunction valueOf(String str) {
            return (EntryFunction) Enum.valueOf(EntryFunction.class, str);
        }

        public static EntryFunction[] values() {
            return (EntryFunction[]) f42907c.clone();
        }
    }

    public static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object objH = Maps.h(key, g());
            if (Objects.a(objH, entry.getValue())) {
                return objH != null || g().containsKey(key);
            }
            return false;
        }

        public abstract Map g();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (contains(obj) && (obj instanceof Map.Entry)) {
                return g().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            try {
                collection.getClass();
                return Sets.g(this, collection);
            } catch (UnsupportedOperationException unused) {
                return Sets.h(this, collection.iterator());
            }
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            try {
                collection.getClass();
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet(Maps.c(collection.size()));
                for (Object obj : collection) {
                    if (contains(obj) && (obj instanceof Map.Entry)) {
                        hashSet.add(((Map.Entry) obj).getKey());
                    }
                }
                return g().keySet().retainAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return g().size();
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        Object a(Object obj, Object obj2);
    }

    public static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {

        /* renamed from: com.google.common.collect.Maps$FilteredEntryBiMap$1, reason: invalid class name */
        class AnonymousClass1 implements Predicate<Map.Entry<Object, Object>> {
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                Map.Entry entry = (Map.Entry) obj;
                entry.getValue();
                entry.getKey();
                throw null;
            }
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public final Collection values() {
            throw null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public final Set values() {
            throw null;
        }
    }

    public static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {

        /* renamed from: f, reason: collision with root package name */
        public final Set f42908f;

        public class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            public EntrySet() {
            }

            @Override // com.google.common.collect.ForwardingSet
            /* renamed from: B */
            public final Set t() {
                return FilteredEntryMap.this.f42908f;
            }

            @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return new TransformedIterator<Map.Entry<Object, Object>, Map.Entry<Object, Object>>(FilteredEntryMap.this.f42908f.iterator()) { // from class: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1
                    @Override // com.google.common.collect.TransformedIterator
                    public final Object a(Object obj) {
                        final Map.Entry entry = (Map.Entry) obj;
                        return new ForwardingMapEntry<Object, Object>() { // from class: com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1.1
                            @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                            public final Object setValue(Object obj2) {
                                Preconditions.f(FilteredEntryMap.this.d(getKey(), obj2));
                                return super.setValue(obj2);
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

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
            public final Object t() {
                return FilteredEntryMap.this.f42908f;
            }

            @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
            /* renamed from: u */
            public final Collection t() {
                return FilteredEntryMap.this.f42908f;
            }
        }

        public class KeySet extends KeySet<K, V> {
            public KeySet() {
                super(FilteredEntryMap.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                if (!filteredEntryMap.containsKey(obj)) {
                    return false;
                }
                filteredEntryMap.f42896d.remove(obj);
                return true;
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.base.Predicate, java.lang.Object] */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection collection) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                return FilteredEntryMap.e(filteredEntryMap.f42896d, filteredEntryMap.f42897e, collection);
            }

            /* JADX WARN: Type inference failed for: r0v1, types: [com.google.common.base.Predicate, java.lang.Object] */
            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection collection) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                return FilteredEntryMap.f(filteredEntryMap.f42896d, filteredEntryMap.f42897e, collection);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final Object[] toArray() {
                return Lists.a(iterator()).toArray();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final Object[] toArray(Object[] objArr) {
                return Lists.a(iterator()).toArray(objArr);
            }
        }

        /* JADX WARN: Type inference failed for: r2v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        public FilteredEntryMap(SortedMap sortedMap, Predicate predicate) {
            super(sortedMap, predicate);
            this.f42908f = Sets.d(sortedMap.entrySet(), this.f42897e);
        }

        public static boolean e(Map map, Predicate predicate, Collection collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static boolean f(Map map, Predicate predicate, Collection collection) {
            Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new EntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set b() {
            return new KeySet();
        }
    }

    @GwtIncompatible
    public static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final NavigableMap f42914a;

        /* renamed from: b, reason: collision with root package name */
        public final Predicate f42915b;

        /* renamed from: c, reason: collision with root package name */
        public final Map f42916c;

        public FilteredEntryNavigableMap(NavigableMap navigableMap, Predicate predicate) {
            navigableMap.getClass();
            this.f42914a = navigableMap;
            this.f42915b = predicate;
            this.f42916c = new FilteredEntryMap(navigableMap, predicate);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            return Iterators.f(this.f42914a.entrySet().iterator(), this.f42915b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public final Iterator b() {
            return Iterators.f(this.f42914a.descendingMap().entrySet().iterator(), this.f42915b);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public final void clear() {
            ((AbstractMap) this.f42916c).clear();
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return this.f42914a.comparator();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return ((AbstractFilteredMap) this.f42916c).containsKey(obj);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public final NavigableMap descendingMap() {
            return Maps.e(this.f42914a.descendingMap(), this.f42915b);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public final Set entrySet() {
            return ((ViewCachingAbstractMap) this.f42916c).entrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            return ((AbstractFilteredMap) this.f42916c).get(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return Maps.e(this.f42914a.headMap(obj, z), this.f42915b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean isEmpty() {
            return !Iterables.a(this.f42914a.entrySet(), this.f42915b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            return new NavigableKeySet<Object, Object>(this) { // from class: com.google.common.collect.Maps.FilteredEntryNavigableMap.1
                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final boolean removeAll(Collection collection) {
                    FilteredEntryNavigableMap filteredEntryNavigableMap = FilteredEntryNavigableMap.this;
                    return FilteredEntryMap.e(filteredEntryNavigableMap.f42914a, filteredEntryNavigableMap.f42915b, collection);
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final boolean retainAll(Collection collection) {
                    FilteredEntryNavigableMap filteredEntryNavigableMap = FilteredEntryNavigableMap.this;
                    return FilteredEntryMap.f(filteredEntryNavigableMap.f42914a, filteredEntryNavigableMap.f42915b, collection);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            return (Map.Entry) Iterables.e(this.f42914a.entrySet(), this.f42915b);
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            return (Map.Entry) Iterables.e(this.f42914a.descendingMap().entrySet(), this.f42915b);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            return ((AbstractFilteredMap) this.f42916c).put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final void putAll(Map map) {
            ((AbstractFilteredMap) this.f42916c).putAll(map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            return ((AbstractFilteredMap) this.f42916c).remove(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return ((AbstractMap) this.f42916c).size();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return Maps.e(this.f42914a.subMap(obj, z, obj2, z2), this.f42915b);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return Maps.e(this.f42914a.tailMap(obj, z), this.f42915b);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public final Collection values() {
            return new FilteredMapValues(this, this.f42914a, this.f42915b);
        }
    }

    public static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

        public class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            public SortedKeySet() {
                super();
            }

            @Override // java.util.SortedSet
            public final Comparator comparator() {
                return FilteredEntrySortedMap.this.f42896d.comparator();
            }

            @Override // java.util.SortedSet
            public final Object first() {
                return FilteredEntrySortedMap.this.firstKey();
            }

            @Override // java.util.SortedSet
            public final SortedSet headSet(Object obj) {
                return (SortedSet) ((FilteredEntrySortedMap) FilteredEntrySortedMap.this.headMap(obj)).keySet();
            }

            @Override // java.util.SortedSet
            public final Object last() {
                return FilteredEntrySortedMap.this.lastKey();
            }

            @Override // java.util.SortedSet
            public final SortedSet subSet(Object obj, Object obj2) {
                return (SortedSet) ((FilteredEntrySortedMap) FilteredEntrySortedMap.this.subMap(obj, obj2)).keySet();
            }

            @Override // java.util.SortedSet
            public final SortedSet tailSet(Object obj) {
                return (SortedSet) ((FilteredEntrySortedMap) FilteredEntrySortedMap.this.tailMap(obj)).keySet();
            }
        }

        @Override // com.google.common.collect.Maps.FilteredEntryMap, com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set b() {
            return new SortedKeySet();
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return this.f42896d.comparator();
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            return ((SortedSet) super.keySet()).iterator().next();
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // java.util.SortedMap
        public final SortedMap headMap(Object obj) {
            return new FilteredEntrySortedMap(this.f42896d.headMap(obj), this.f42897e);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return (SortedSet) super.keySet();
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            SortedMap sortedMap = this.f42896d;
            SortedMap sortedMapHeadMap = sortedMap;
            while (true) {
                Object objLastKey = sortedMapHeadMap.lastKey();
                if (d(objLastKey, sortedMap.get(objLastKey))) {
                    return objLastKey;
                }
                sortedMapHeadMap = sortedMap.headMap(objLastKey);
            }
        }

        /* JADX WARN: Type inference failed for: r4v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // java.util.SortedMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return new FilteredEntrySortedMap(this.f42896d.subMap(obj, obj2), this.f42897e);
        }

        /* JADX WARN: Type inference failed for: r1v1, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // java.util.SortedMap
        public final SortedMap tailMap(Object obj) {
            return new FilteredEntrySortedMap(this.f42896d.tailMap(obj), this.f42897e);
        }
    }

    public static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return Sets.d(this.f42896d.entrySet(), this.f42897e);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set b() {
            return Sets.d(this.f42896d.keySet(), null);
        }

        @Override // com.google.common.collect.Maps.AbstractFilteredMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            if (this.f42896d.containsKey(obj)) {
                throw null;
            }
            return false;
        }
    }

    public static final class FilteredMapValues<K, V> extends Values<K, V> {

        /* renamed from: b, reason: collision with root package name */
        public final Map f42919b;

        /* renamed from: c, reason: collision with root package name */
        public final Object f42920c;

        public FilteredMapValues(AbstractMap abstractMap, Map map, Predicate predicate) {
            super(abstractMap);
            this.f42919b = map;
            this.f42920c = predicate;
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public final boolean remove(Object obj) {
            Iterator<Map.Entry<K, V>> it = this.f42919b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f42920c.apply(next) && Objects.a(next.getValue(), obj)) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public final boolean removeAll(Collection collection) {
            Iterator<Map.Entry<K, V>> it = this.f42919b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f42920c.apply(next) && collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        /* JADX WARN: Type inference failed for: r3v0, types: [com.google.common.base.Predicate, java.lang.Object] */
        @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
        public final boolean retainAll(Collection collection) {
            Iterator<Map.Entry<K, V>> it = this.f42919b.entrySet().iterator();
            boolean z = false;
            while (it.hasNext()) {
                Map.Entry<K, V> next = it.next();
                if (this.f42920c.apply(next) && !collection.contains(next.getValue())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray() {
            return Lists.a(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final Object[] toArray(Object[] objArr) {
            return Lists.a(iterator()).toArray(objArr);
        }
    }

    public static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        public abstract Iterator a();

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            Iterators.b(a());
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public Set entrySet() {
            return new EntrySet<Object, Object>() { // from class: com.google.common.collect.Maps.IteratorBasedAbstractMap.1
                @Override // com.google.common.collect.Maps.EntrySet
                public final Map g() {
                    return IteratorBasedAbstractMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public final Iterator iterator() {
                    return IteratorBasedAbstractMap.this.a();
                }
            };
        }
    }

    public static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f42922a;

        public KeySet(Map map) {
            map.getClass();
            this.f42922a = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            g().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return g().containsKey(obj);
        }

        public Map g() {
            return this.f42922a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            return g().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new AnonymousClass1(g().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            g().remove(obj);
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return g().size();
        }
    }

    public static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {
        @Override // com.google.common.collect.MapDifference
        public Map a() {
            return null;
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapDifference)) {
                return false;
            }
            ((MapDifference) obj).a();
            throw null;
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{null, null, null, null});
        }

        public final String toString() {
            throw null;
        }
    }

    @GwtIncompatible
    public static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public final NavigableSet f42923a;

        public NavigableAsMapView(NavigableSet navigableSet) {
            navigableSet.getClass();
            this.f42923a = navigableSet;
            throw null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            return new AnonymousClass3(this.f42923a.iterator(), null);
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        public final Iterator b() {
            descendingMap();
            throw null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f42923a.clear();
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return this.f42923a.comparator();
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public final NavigableMap descendingMap() {
            new NavigableAsMapView(this.f42923a.descendingSet());
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            if (Collections2.c(obj, this.f42923a)) {
                throw null;
            }
            return null;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            new NavigableAsMapView(this.f42923a.headSet(obj, z));
            throw null;
        }

        @Override // com.google.common.collect.AbstractNavigableMap, java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            return new AnonymousClass6(this.f42923a);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f42923a.size();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            new NavigableAsMapView(this.f42923a.subSet(obj, z, obj2, z2));
            throw null;
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            new NavigableAsMapView(this.f42923a.tailSet(obj, z));
            throw null;
        }
    }

    public static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return ((SortedSet) this.f42898d).comparator();
        }

        @Override // com.google.common.collect.Maps.AsMapView
        public final Set d() {
            return (SortedSet) this.f42898d;
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            return ((SortedSet) this.f42898d).first();
        }

        @Override // java.util.SortedMap
        public final SortedMap headMap(Object obj) {
            return new SortedAsMapView(((SortedSet) this.f42898d).headSet(obj), this.f42899e);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return new AnonymousClass5((SortedSet) this.f42898d);
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            return ((SortedSet) this.f42898d).last();
        }

        @Override // java.util.SortedMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return new SortedAsMapView(((SortedSet) this.f42898d).subSet(obj, obj2), this.f42899e);
        }

        @Override // java.util.SortedMap
        public final SortedMap tailMap(Object obj) {
            return new SortedAsMapView(((SortedSet) this.f42898d).tailSet(obj), this.f42899e);
        }
    }

    public static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        @Override // java.util.SortedSet
        public final Comparator comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        public final Object first() {
            return g().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return new SortedKeySet(g().headMap(obj));
        }

        @Override // com.google.common.collect.Maps.KeySet
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public SortedMap g() {
            return (SortedMap) this.f42922a;
        }

        @Override // java.util.SortedSet
        public final Object last() {
            return g().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return new SortedKeySet(g().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return new SortedKeySet(g().tailMap(obj));
        }
    }

    public static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        @Override // com.google.common.collect.Maps.MapDifferenceImpl, com.google.common.collect.MapDifference
        public final /* bridge */ /* synthetic */ Map a() {
            return null;
        }
    }

    public static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f42924a;

        /* renamed from: b, reason: collision with root package name */
        public final EntryTransformer f42925b;

        public TransformedEntriesMap(Map map, EntryTransformer entryTransformer) {
            map.getClass();
            this.f42924a = map;
            entryTransformer.getClass();
            this.f42925b = entryTransformer;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            Iterator it = this.f42924a.entrySet().iterator();
            EntryTransformer entryTransformer = this.f42925b;
            entryTransformer.getClass();
            return new Iterators.AnonymousClass6(it, new AnonymousClass13(entryTransformer));
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public final void clear() {
            this.f42924a.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return this.f42924a.containsKey(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Map map = this.f42924a;
            Object obj2 = map.get(obj);
            if (obj2 != null || map.containsKey(obj)) {
                return this.f42925b.a(obj, obj2);
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            return this.f42924a.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            Map map = this.f42924a;
            if (!map.containsKey(obj)) {
                return null;
            }
            return this.f42925b.a(obj, map.remove(obj));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            return this.f42924a.size();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Collection values() {
            return new Values(this);
        }
    }

    @GwtIncompatible
    public static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final NavigableMap b() {
            return (NavigableMap) ((SortedMap) this.f42924a);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry ceilingEntry(Object obj) {
            return d(b().ceilingEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object ceilingKey(Object obj) {
            return b().ceilingKey(obj);
        }

        public final Map.Entry d(Map.Entry entry) {
            if (entry == null) {
                return null;
            }
            EntryTransformer entryTransformer = this.f42925b;
            entryTransformer.getClass();
            return new AnonymousClass12(entry, entryTransformer);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet descendingKeySet() {
            return b().descendingKeySet();
        }

        @Override // java.util.NavigableMap
        public final NavigableMap descendingMap() {
            return new TransformedEntriesNavigableMap(b().descendingMap(), this.f42925b);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry firstEntry() {
            return d(b().firstEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry floorEntry(Object obj) {
            return d(b().floorEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object floorKey(Object obj) {
            return b().floorKey(obj);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry higherEntry(Object obj) {
            return d(b().higherEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object higherKey(Object obj) {
            return b().higherKey(obj);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lastEntry() {
            return d(b().lastEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lowerEntry(Object obj) {
            return d(b().lowerEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object lowerKey(Object obj) {
            return b().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            return b().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            return d(b().pollFirstEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            return d(b().pollLastEntry());
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            return new TransformedEntriesNavigableMap(b().subMap(obj, z, obj2, z2), this.f42925b);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            return new TransformedEntriesNavigableMap(b().headMap(obj, z), this.f42925b);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            return new TransformedEntriesNavigableMap(b().tailMap(obj, z), this.f42925b);
        }

        @Override // com.google.common.collect.Maps.TransformedEntriesSortedMap, java.util.SortedMap, java.util.NavigableMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }
    }

    public static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        public SortedMap b() {
            return (SortedMap) this.f42924a;
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            return b().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return new TransformedEntriesSortedMap(b().headMap(obj), this.f42925b);
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            return b().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return new TransformedEntriesSortedMap(b().subMap(obj, obj2), this.f42925b);
        }

        public SortedMap tailMap(Object obj) {
            return new TransformedEntriesSortedMap(b().tailMap(obj), this.f42925b);
        }
    }

    public static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public transient Set f42926a;

        @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Object t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingMap
        /* renamed from: u */
        public final Map t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
        public final Set values() {
            Set set = this.f42926a;
            set.getClass();
            return set;
        }
    }

    public static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            throw null;
        }

        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final Object[] toArray(Object[] objArr) {
            return ObjectArrays.c(this, objArr);
        }

        @Override // com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return null;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public final Object[] toArray() {
            return y();
        }
    }

    public static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        @Override // java.util.Collection, java.util.Set
        public final boolean equals(Object obj) {
            return Sets.b(this, obj);
        }

        @Override // java.util.Collection, java.util.Set
        public final int hashCode() {
            return Sets.e(this);
        }
    }

    @GwtIncompatible
    public static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {

        /* renamed from: a, reason: collision with root package name */
        public final NavigableMap f42927a;

        /* renamed from: b, reason: collision with root package name */
        public transient UnmodifiableNavigableMap f42928b;

        public UnmodifiableNavigableMap(NavigableMap navigableMap) {
            this.f42927a = navigableMap;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry ceilingEntry(Object obj) {
            return Maps.a(this.f42927a.ceilingEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object ceilingKey(Object obj) {
            return this.f42927a.ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet descendingKeySet() {
            return Sets.j(this.f42927a.descendingKeySet());
        }

        @Override // java.util.NavigableMap
        public final NavigableMap descendingMap() {
            UnmodifiableNavigableMap unmodifiableNavigableMap = this.f42928b;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap unmodifiableNavigableMap2 = new UnmodifiableNavigableMap(this.f42927a.descendingMap(), this);
            this.f42928b = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @Override // java.util.NavigableMap
        public final Map.Entry firstEntry() {
            return Maps.a(this.f42927a.firstEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry floorEntry(Object obj) {
            return Maps.a(this.f42927a.floorEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object floorKey(Object obj) {
            return this.f42927a.floorKey(obj);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public final SortedMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // java.util.NavigableMap
        public final Map.Entry higherEntry(Object obj) {
            return Maps.a(this.f42927a.higherEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object higherKey(Object obj) {
            return this.f42927a.higherKey(obj);
        }

        @Override // com.google.common.collect.ForwardingMap, java.util.Map
        public final Set keySet() {
            return navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lastEntry() {
            return Maps.a(this.f42927a.lastEntry());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry lowerEntry(Object obj) {
            return Maps.a(this.f42927a.lowerEntry(obj));
        }

        @Override // java.util.NavigableMap
        public final Object lowerKey(Object obj) {
            return this.f42927a.lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public final NavigableSet navigableKeySet() {
            return Sets.j(this.f42927a.navigableKeySet());
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.NavigableMap
        public final Map.Entry pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public final SortedMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
        public final Object t() {
            return Collections.unmodifiableSortedMap(this.f42927a);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, java.util.SortedMap
        public final SortedMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap
        /* renamed from: u */
        public final Map t() {
            return Collections.unmodifiableSortedMap(this.f42927a);
        }

        @Override // com.google.common.collect.ForwardingSortedMap
        /* renamed from: z */
        public final SortedMap t() {
            return Collections.unmodifiableSortedMap(this.f42927a);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap headMap(Object obj, boolean z) {
            NavigableMap<K, V> navigableMapHeadMap = this.f42927a.headMap(obj, z);
            navigableMapHeadMap.getClass();
            return navigableMapHeadMap instanceof UnmodifiableNavigableMap ? navigableMapHeadMap : new UnmodifiableNavigableMap(navigableMapHeadMap);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
            NavigableMap<K, V> navigableMapSubMap = this.f42927a.subMap(obj, z, obj2, z2);
            navigableMapSubMap.getClass();
            return navigableMapSubMap instanceof UnmodifiableNavigableMap ? navigableMapSubMap : new UnmodifiableNavigableMap(navigableMapSubMap);
        }

        @Override // java.util.NavigableMap
        public final NavigableMap tailMap(Object obj, boolean z) {
            NavigableMap<K, V> navigableMapTailMap = this.f42927a.tailMap(obj, z);
            navigableMapTailMap.getClass();
            return navigableMapTailMap instanceof UnmodifiableNavigableMap ? navigableMapTailMap : new UnmodifiableNavigableMap(navigableMapTailMap);
        }

        public UnmodifiableNavigableMap(NavigableMap navigableMap, UnmodifiableNavigableMap unmodifiableNavigableMap) {
            this.f42927a = navigableMap;
            this.f42928b = unmodifiableNavigableMap;
        }
    }

    public static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
        public final boolean equals(Object obj) {
            if (!(obj instanceof MapDifference.ValueDifference)) {
                return false;
            }
            ((MapDifference.ValueDifference) obj).getClass();
            return Objects.a(null, null) && Objects.a(null, null);
        }

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{null, null});
        }

        public final String toString() {
            return "(null, null)";
        }
    }

    public static class Values<K, V> extends AbstractCollection<V> {

        /* renamed from: a, reason: collision with root package name */
        public final Map f42929a;

        public Values(Map map) {
            map.getClass();
            this.f42929a = map;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            this.f42929a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return this.f42929a.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean isEmpty() {
            return this.f42929a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return new AnonymousClass2(this.f42929a.entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                Map map = this.f42929a;
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    if (Objects.a(obj, entry.getValue())) {
                        map.remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            try {
                collection.getClass();
                return super.removeAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                Map map = this.f42929a;
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return map.keySet().removeAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            try {
                collection.getClass();
                return super.retainAll(collection);
            } catch (UnsupportedOperationException unused) {
                HashSet hashSet = new HashSet();
                Map map = this.f42929a;
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        hashSet.add(entry.getKey());
                    }
                }
                return map.keySet().retainAll(hashSet);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return this.f42929a.size();
        }
    }

    @GwtCompatible
    public static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        public transient Set f42930a;

        /* renamed from: b, reason: collision with root package name */
        public transient Set f42931b;

        /* renamed from: c, reason: collision with root package name */
        public transient Collection f42932c;

        public abstract Set a();

        public Set b() {
            return new KeySet(this);
        }

        public Collection c() {
            return new Values(this);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Set entrySet() {
            Set set = this.f42930a;
            if (set != null) {
                return set;
            }
            Set setA = a();
            this.f42930a = setA;
            return setA;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            Set set = this.f42931b;
            if (set != null) {
                return set;
            }
            Set setB = b();
            this.f42931b = setB;
            return setB;
        }

        @Override // java.util.AbstractMap, java.util.Map, com.google.common.collect.BiMap
        public Collection values() {
            Collection collection = this.f42932c;
            if (collection != null) {
                return collection;
            }
            Collection collectionC = c();
            this.f42932c = collectionC;
            return collectionC;
        }
    }

    public static Map.Entry a(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return new AnonymousClass7(entry);
    }

    public static Map b(Set set, Function function) {
        return new AsMapView(set, function);
    }

    public static int c(int i2) {
        if (i2 >= 3) {
            return i2 < 1073741824 ? (int) Math.ceil(i2 / 0.75d) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        CollectPreconditions.b(i2, "expectedSize");
        return i2 + 1;
    }

    public static boolean d(Object obj, Map map) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public static NavigableMap e(NavigableMap navigableMap, Predicate predicate) {
        predicate.getClass();
        if (!(navigableMap instanceof FilteredEntryNavigableMap)) {
            navigableMap.getClass();
            return new FilteredEntryNavigableMap(navigableMap, predicate);
        }
        FilteredEntryNavigableMap filteredEntryNavigableMap = (FilteredEntryNavigableMap) navigableMap;
        return new FilteredEntryNavigableMap(filteredEntryNavigableMap.f42914a, Predicates.c(filteredEntryNavigableMap.f42915b, predicate));
    }

    public static Object f(Map.Entry entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    public static boolean g(Object obj, Map map) {
        map.getClass();
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static Object h(Object obj, Map map) {
        map.getClass();
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    public static String i(Map map) {
        int size = map.size();
        CollectPreconditions.b(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : map.entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public static Map j(Map map, com.google.common.net.a aVar) {
        aVar.getClass();
        return new TransformedEntriesMap(map, new AnonymousClass9(aVar));
    }

    /* renamed from: com.google.common.collect.Maps$6, reason: invalid class name */
    class AnonymousClass6 extends ForwardingNavigableSet<Object> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ NavigableSet f42892a;

        public AnonymousClass6(NavigableSet navigableSet) {
            this.f42892a = navigableSet;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet
        /* renamed from: B */
        public final Set t() {
            return this.f42892a;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet
        /* renamed from: C */
        public final SortedSet t() {
            return this.f42892a;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet
        /* renamed from: E */
        public final NavigableSet t() {
            return this.f42892a;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return new AnonymousClass6(super.descendingSet());
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet headSet(Object obj) {
            return new AnonymousClass5(super.headSet(obj));
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return new AnonymousClass5(super.subSet(obj, obj2));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public final Object t() {
            return this.f42892a;
        }

        @Override // com.google.common.collect.ForwardingSortedSet, java.util.SortedSet
        public final SortedSet tailSet(Object obj) {
            return new AnonymousClass5(super.tailSet(obj));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, com.google.common.collect.ForwardingSortedSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: u */
        public final Collection t() {
            return this.f42892a;
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return new AnonymousClass6(super.headSet(obj, z));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return new AnonymousClass6(super.subSet(obj, z, obj2, z2));
        }

        @Override // com.google.common.collect.ForwardingNavigableSet, java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return new AnonymousClass6(super.tailSet(obj, z));
        }
    }

    @GwtIncompatible
    public static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        @Override // java.util.NavigableSet
        public final Object ceiling(Object obj) {
            return ((NavigableMap) this.f42922a).ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet descendingSet() {
            return ((NavigableMap) this.f42922a).descendingKeySet();
        }

        @Override // java.util.NavigableSet
        public final Object floor(Object obj) {
            return ((NavigableMap) this.f42922a).floorKey(obj);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, com.google.common.collect.Maps.KeySet
        public final Map g() {
            return (NavigableMap) this.f42922a;
        }

        @Override // java.util.NavigableSet
        public final NavigableSet headSet(Object obj, boolean z) {
            return ((NavigableMap) this.f42922a).headMap(obj, z).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public final Object higher(Object obj) {
            return ((NavigableMap) this.f42922a).higherKey(obj);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet
        /* renamed from: i */
        public final SortedMap g() {
            return (NavigableMap) this.f42922a;
        }

        @Override // java.util.NavigableSet
        public final Object lower(Object obj) {
            return ((NavigableMap) this.f42922a).lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public final Object pollFirst() {
            return Maps.f(((NavigableMap) this.f42922a).pollFirstEntry());
        }

        @Override // java.util.NavigableSet
        public final Object pollLast() {
            return Maps.f(((NavigableMap) this.f42922a).pollLastEntry());
        }

        @Override // java.util.NavigableSet
        public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
            return ((NavigableMap) this.f42922a).subMap(obj, z, obj2, z2).navigableKeySet();
        }

        @Override // java.util.NavigableSet
        public final NavigableSet tailSet(Object obj, boolean z) {
            return ((NavigableMap) this.f42922a).tailMap(obj, z).navigableKeySet();
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet headSet(Object obj) {
            return headSet(obj, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.google.common.collect.Maps.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        public final SortedSet tailSet(Object obj) {
            return tailSet(obj, true);
        }
    }
}
