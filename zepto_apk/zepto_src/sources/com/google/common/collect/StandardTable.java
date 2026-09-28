package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import com.google.common.collect.Tables;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public transient Set f43082c;

    /* renamed from: d, reason: collision with root package name */
    public transient Map f43083d;

    public class CellIterator implements Iterator<Table.Cell<R, C, V>> {

        /* renamed from: a, reason: collision with root package name */
        public final Iterator f43084a;

        /* renamed from: b, reason: collision with root package name */
        public Map.Entry f43085b;

        /* renamed from: c, reason: collision with root package name */
        public Iterator f43086c;

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.f43084a.hasNext() || this.f43086c.hasNext();
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (!this.f43086c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f43084a.next();
                this.f43085b = entry;
                this.f43086c = ((Map) entry.getValue()).entrySet().iterator();
            }
            Objects.requireNonNull(this.f43085b);
            Map.Entry entry2 = (Map.Entry) this.f43086c.next();
            return new Tables.ImmutableCell(this.f43085b.getKey(), entry2.getKey(), entry2.getValue());
        }

        @Override // java.util.Iterator
        public final void remove() {
            this.f43086c.remove();
            Map.Entry entry = this.f43085b;
            Objects.requireNonNull(entry);
            if (((Map) entry.getValue()).isEmpty()) {
                this.f43084a.remove();
                this.f43085b = null;
            }
        }
    }

    public class Column extends Maps.ViewCachingAbstractMap<R, V> {

        /* renamed from: d, reason: collision with root package name */
        public final Object f43087d;

        public class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            public EntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final void clear() {
                Column.this.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Column column = Column.this;
                    StandardTable standardTable = StandardTable.this;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null && value.equals(standardTable.q(key, column.f43087d))) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean isEmpty() {
                Column column = Column.this;
                return !StandardTable.this.l(column.f43087d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                return Column.this.new EntrySetIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Column column = Column.this;
                    StandardTable standardTable = StandardTable.this;
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    if (value != null) {
                        Object obj2 = column.f43087d;
                        if (value.equals(standardTable.q(key, obj2))) {
                            standardTable.s(key, obj2);
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection collection) {
                return Column.this.d(Predicates.h(Predicates.f(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                StandardTable standardTable = StandardTable.this;
                throw null;
            }
        }

        public class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {

            /* renamed from: c, reason: collision with root package name */
            public final Iterator f43090c;

            public EntrySetIterator() {
                StandardTable standardTable = StandardTable.this;
                throw null;
            }

            @Override // com.google.common.collect.AbstractIterator
            public final Object a() {
                final Map.Entry entry;
                do {
                    Iterator it = this.f43090c;
                    if (!it.hasNext()) {
                        this.f42456a = AbstractIterator.State.f42461c;
                        return null;
                    }
                    entry = (Map.Entry) it.next();
                } while (!((Map) entry.getValue()).containsKey(Column.this.f43087d));
                return new AbstractMapEntry<Object, Object>() { // from class: com.google.common.collect.StandardTable.Column.EntrySetIterator.1EntryImpl
                    @Override // java.util.Map.Entry
                    public final Object getKey() {
                        return entry.getKey();
                    }

                    @Override // java.util.Map.Entry
                    public final Object getValue() {
                        return ((Map) entry.getValue()).get(Column.this.f43087d);
                    }

                    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                    public final Object setValue(Object obj) {
                        Map map = (Map) entry.getValue();
                        Object obj2 = Column.this.f43087d;
                        obj.getClass();
                        return map.put(obj2, obj);
                    }
                };
            }
        }

        public class KeySet extends Maps.KeySet<R, V> {
            public KeySet() {
                super(Column.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                Column column = Column.this;
                return StandardTable.this.k(obj, column.f43087d);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                Column column = Column.this;
                return StandardTable.this.s(obj, column.f43087d) != null;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection collection) {
                return Column.this.d(Predicates.d(Predicates.h(Predicates.f(collection)), Maps.EntryFunction.f42905a));
            }
        }

        public class Values extends Maps.Values<R, V> {
            public Values() {
                super(Column.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public final boolean remove(Object obj) {
                if (obj != null) {
                    return Column.this.d(Predicates.d(Predicates.e(obj), Maps.EntryFunction.f42906b));
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public final boolean removeAll(Collection collection) {
                return Column.this.d(Predicates.d(Predicates.f(collection), Maps.EntryFunction.f42906b));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public final boolean retainAll(Collection collection) {
                return Column.this.d(Predicates.d(Predicates.h(Predicates.f(collection)), Maps.EntryFunction.f42906b));
            }
        }

        public Column(Object obj) {
            obj.getClass();
            this.f43087d = obj;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new EntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set b() {
            return new KeySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Collection c() {
            return new Values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return StandardTable.this.k(obj, this.f43087d);
        }

        public final boolean d(Predicate predicate) {
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            return StandardTable.this.q(obj, this.f43087d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            return StandardTable.this.r(obj, this.f43087d, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            return StandardTable.this.s(obj, this.f43087d);
        }
    }

    public class ColumnKeyIterator extends AbstractIterator<C> {
        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            throw null;
        }
    }

    public class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        public ColumnKeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            return StandardTable.this.l(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return StandardTable.this.o();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            if (obj == null) {
                return false;
            }
            StandardTable.this.getClass();
            throw null;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean removeAll(Collection collection) {
            collection.getClass();
            StandardTable.this.getClass();
            throw null;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean retainAll(Collection collection) {
            collection.getClass();
            StandardTable.this.getClass();
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return Iterators.m(StandardTable.this.o());
        }
    }

    public class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {

        public final class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet$1, reason: invalid class name */
            class AnonymousClass1 implements Function<Object, Map<Object, Object>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                public final Map<Object, Object> apply(Object obj) {
                    ColumnMap.this.getClass();
                    throw null;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ColumnMapEntrySet() {
                super();
                ColumnMap.this.getClass();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                ColumnMap.this.getClass();
                ((Map.Entry) obj).getKey();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                ColumnMap.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                ColumnMap.this.getClass();
                StandardTable.h(null, ((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean removeAll(Collection collection) {
                collection.getClass();
                return Sets.h(this, collection.iterator());
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean retainAll(Collection collection) {
                collection.getClass();
                ColumnMap.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                ColumnMap.this.getClass();
                throw null;
            }
        }

        public class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            public ColumnMapValues() {
                super(ColumnMap.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public final boolean remove(Object obj) {
                for (Map.Entry entry : ColumnMap.this.entrySet()) {
                    if (((Map) entry.getValue()).equals(obj)) {
                        StandardTable.h(null, entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public final boolean removeAll(Collection collection) {
                collection.getClass();
                ColumnMap.this.getClass();
                throw null;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public final boolean retainAll(Collection collection) {
                collection.getClass();
                ColumnMap.this.getClass();
                throw null;
            }
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new ColumnMapEntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Collection c() {
            return new ColumnMapValues();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            throw null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public final Set keySet() {
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            throw null;
        }
    }

    public class Row extends Maps.IteratorBasedAbstractMap<C, V> {

        /* renamed from: a, reason: collision with root package name */
        public final Object f43100a;

        /* renamed from: b, reason: collision with root package name */
        public Map f43101b;

        public Row(Object obj) {
            obj.getClass();
            this.f43100a = obj;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            d();
            Map map = this.f43101b;
            if (map == null) {
                return Iterators.EmptyModifiableIterator.f42762a;
            }
            final Iterator it = map.entrySet().iterator();
            return new Iterator<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.StandardTable.Row.1
                @Override // java.util.Iterator
                public final boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public final Map.Entry<Object, Object> next() {
                    final Map.Entry entry = (Map.Entry) it.next();
                    Row.this.getClass();
                    return new ForwardingMapEntry<Object, Object>() { // from class: com.google.common.collect.StandardTable.Row.2
                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public final boolean equals(Object obj) {
                            if (!(obj instanceof Map.Entry)) {
                                return false;
                            }
                            Map.Entry entry2 = (Map.Entry) obj;
                            return com.google.common.base.Objects.a(getKey(), entry2.getKey()) && com.google.common.base.Objects.a(getValue(), entry2.getValue());
                        }

                        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                        public final Object setValue(Object obj) {
                            obj.getClass();
                            return super.setValue(obj);
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

                @Override // java.util.Iterator
                public final void remove() {
                    it.remove();
                    Row.this.c();
                }
            };
        }

        public Map b() {
            StandardTable.this.getClass();
            throw null;
        }

        public void c() {
            d();
            Map map = this.f43101b;
            if (map == null || !map.isEmpty()) {
                return;
            }
            StandardTable.this.getClass();
            throw null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public final void clear() {
            d();
            Map map = this.f43101b;
            if (map != null) {
                map.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map map;
            d();
            return (obj == null || (map = this.f43101b) == null || !Maps.g(obj, map)) ? false : true;
        }

        public final void d() {
            Map map = this.f43101b;
            if (map == null) {
                this.f43101b = b();
            } else if (map.isEmpty()) {
                StandardTable.this.getClass();
                throw null;
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            Map map;
            d();
            if (obj == null || (map = this.f43101b) == null) {
                return null;
            }
            return Maps.h(obj, map);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            obj.getClass();
            obj2.getClass();
            Map map = this.f43101b;
            return (map == null || map.isEmpty()) ? StandardTable.this.r(this.f43100a, obj, obj2) : this.f43101b.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            d();
            Map map = this.f43101b;
            Object objRemove = null;
            if (map == null) {
                return null;
            }
            try {
                objRemove = map.remove(obj);
            } catch (ClassCastException | NullPointerException unused) {
            }
            c();
            return objRemove;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            d();
            Map map = this.f43101b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    public class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {

        public final class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {

            /* renamed from: com.google.common.collect.StandardTable$RowMap$EntrySet$1, reason: invalid class name */
            class AnonymousClass1 implements Function<Object, Map<Object, Object>> {
                public AnonymousClass1() {
                }

                @Override // com.google.common.base.Function
                public final Map<Object, Object> apply(Object obj) {
                    return StandardTable.this.t(obj);
                }
            }

            public EntrySet() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map)) {
                    return false;
                }
                StandardTable.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public final Iterator iterator() {
                StandardTable.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getKey() == null || !(entry.getValue() instanceof Map)) {
                    return false;
                }
                StandardTable.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public final int size() {
                StandardTable.this.getClass();
                throw null;
            }
        }

        public RowMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public final Set a() {
            return new EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return StandardTable.this.m(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            StandardTable standardTable = StandardTable.this;
            if (!standardTable.m(obj)) {
                return null;
            }
            Objects.requireNonNull(obj);
            return standardTable.t(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object remove(Object obj) {
            if (obj == null) {
                return null;
            }
            StandardTable.this.getClass();
            throw null;
        }
    }

    public abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        public TableSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            StandardTable.this.getClass();
            throw null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean isEmpty() {
            StandardTable.this.getClass();
            throw null;
        }
    }

    public static LinkedHashMap h(StandardTable standardTable, Object obj) {
        standardTable.getClass();
        new LinkedHashMap();
        throw null;
    }

    @Override // com.google.common.collect.AbstractTable
    public final Iterator a() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractTable
    public void b() {
        throw null;
    }

    @Override // com.google.common.collect.AbstractTable
    public boolean c(Object obj) {
        return obj != null && super.c(obj);
    }

    @Override // com.google.common.collect.Table
    public Map g() {
        Map map = this.f43083d;
        if (map != null) {
            return map;
        }
        Map mapP = p();
        this.f43083d = mapP;
        return mapP;
    }

    public Map i(Object obj) {
        return new Column(obj);
    }

    public Set j() {
        Set set = this.f43082c;
        if (set != null) {
            return set;
        }
        ColumnKeySet columnKeySet = new ColumnKeySet();
        this.f43082c = columnKeySet;
        return columnKeySet;
    }

    public boolean k(Object obj, Object obj2) {
        Map map;
        return (obj == null || obj2 == null || (map = (Map) Maps.h(obj, g())) == null || !Maps.g(obj2, map)) ? false : true;
    }

    public boolean l(Object obj) {
        if (obj == null) {
            return false;
        }
        throw null;
    }

    public boolean m(Object obj) {
        return obj != null && Maps.g(obj, null);
    }

    public Iterator o() {
        throw null;
    }

    public Map p() {
        return new RowMap();
    }

    public Object q(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.h(obj, g())) == null) {
            return null;
        }
        return Maps.h(obj2, map);
    }

    public Object r(Object obj, Object obj2, Object obj3) {
        obj.getClass();
        obj2.getClass();
        obj3.getClass();
        throw null;
    }

    public Object s(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.h(obj, null)) == null) {
            return null;
        }
        Object objRemove = map.remove(obj2);
        if (map.isEmpty()) {
            throw null;
        }
        return objRemove;
    }

    @Override // com.google.common.collect.Table
    public int size() {
        throw null;
    }

    public Map t(Object obj) {
        return new Row(obj);
    }
}
