package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {

    /* renamed from: com.google.common.collect.TreeRangeMap$1, reason: invalid class name */
    public class AnonymousClass1 implements RangeMap<Comparable<?>, Object> {
        @Override // com.google.common.collect.RangeMap
        public final Map a() {
            return Collections.EMPTY_MAP;
        }
    }

    public final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public final Iterator a() {
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            get(obj);
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final Object get(Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            throw null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final int size() {
            throw null;
        }
    }

    public static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        @Override // java.util.Map.Entry
        public final Object getKey() {
            return null;
        }

        @Override // java.util.Map.Entry
        public final Object getValue() {
            return null;
        }
    }

    public class SubRangeMap implements RangeMap<K, V> {

        /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$1, reason: invalid class name */
        class AnonymousClass1 extends TreeRangeMap<Comparable, Object>.SubRangeMap.SubRangeMapAsMap {

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$1$1, reason: invalid class name and collision with other inner class name */
            class C00421 extends AbstractIterator<Map.Entry<Range<Comparable>, Object>> {
                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    throw null;
                }
            }

            @Override // com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap
            public final Iterator b() {
                throw null;
            }
        }

        public class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2, reason: invalid class name */
            class AnonymousClass2 extends Maps.EntrySet<Range<Comparable>, Object> {
                public AnonymousClass2() {
                }

                @Override // com.google.common.collect.Maps.EntrySet
                public final Map g() {
                    return SubRangeMapAsMap.this;
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final boolean isEmpty() {
                    SubRangeMapAsMap.this.b();
                    throw null;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public final Iterator iterator() {
                    SubRangeMapAsMap.this.b();
                    throw null;
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final boolean retainAll(Collection collection) {
                    SubRangeMapAsMap.a(SubRangeMapAsMap.this, Predicates.h(Predicates.f(collection)));
                    throw null;
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public final int size() {
                    SubRangeMapAsMap.this.b();
                    throw null;
                }
            }

            /* renamed from: com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap$3, reason: invalid class name */
            class AnonymousClass3 extends AbstractIterator<Map.Entry<Range<Comparable>, Object>> {
                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    throw null;
                }
            }

            public SubRangeMapAsMap() {
            }

            public static boolean a(SubRangeMapAsMap subRangeMapAsMap, Predicate predicate) {
                new ArrayList();
                subRangeMapAsMap.new AnonymousClass2();
                subRangeMapAsMap.b();
                throw null;
            }

            public Iterator b() {
                SubRangeMap.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final void clear() {
                SubRangeMap.this.getClass();
                throw null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final boolean containsKey(Object obj) {
                get(obj);
                return false;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final Set entrySet() {
                return new AnonymousClass2();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final Object get(Object obj) {
                try {
                    if (!(obj instanceof Range)) {
                        return null;
                    }
                    SubRangeMap.this.getClass();
                    throw null;
                } catch (ClassCastException unused) {
                    return null;
                }
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final Set keySet() {
                return new Maps.KeySet<Range<Comparable>, Object>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1
                    @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public final boolean remove(Object obj) {
                        SubRangeMapAsMap.this.get(obj);
                        return false;
                    }

                    @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public final boolean retainAll(Collection collection) {
                        SubRangeMapAsMap.a(SubRangeMapAsMap.this, Predicates.d(Predicates.h(Predicates.f(collection)), Maps.EntryFunction.f42905a));
                        throw null;
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final Object remove(Object obj) {
                get(obj);
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public final Collection values() {
                return new Maps.Values<Range<Comparable>, Object>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.4
                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public final boolean removeAll(Collection collection) {
                        SubRangeMapAsMap.a(SubRangeMapAsMap.this, Predicates.d(Predicates.f(collection), Maps.EntryFunction.f42906b));
                        throw null;
                    }

                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public final boolean retainAll(Collection collection) {
                        SubRangeMapAsMap.a(SubRangeMapAsMap.this, Predicates.d(Predicates.h(Predicates.f(collection)), Maps.EntryFunction.f42906b));
                        throw null;
                    }
                };
            }
        }

        @Override // com.google.common.collect.RangeMap
        public final Map a() {
            return new SubRangeMapAsMap();
        }

        public final boolean equals(Object obj) {
            if (obj instanceof RangeMap) {
                return new SubRangeMapAsMap().equals(((RangeMap) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return new SubRangeMapAsMap().hashCode();
        }

        public final String toString() {
            return new SubRangeMapAsMap().toString();
        }
    }

    @Override // com.google.common.collect.RangeMap
    public final Map a() {
        throw null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            throw null;
        }
        return false;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        throw null;
    }
}
