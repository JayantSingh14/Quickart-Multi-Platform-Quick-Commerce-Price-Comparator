package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.StandardTable;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public class TreeBasedTable<R, C, V> extends StandardRowSortedTable<R, C, V> {

    /* renamed from: com.google.common.collect.TreeBasedTable$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractIterator<Object> {

        /* renamed from: c, reason: collision with root package name */
        public Object f43134c;

        @Override // com.google.common.collect.AbstractIterator
        public final Object a() {
            throw null;
        }
    }

    public static class Factory<C, V> implements Supplier<TreeMap<C, V>>, Serializable {
        @Override // com.google.common.base.Supplier
        public final Object get() {
            return new TreeMap((Comparator) null);
        }
    }

    public class TreeRow extends StandardTable<R, C, V>.Row implements SortedMap<C, V> {

        /* renamed from: d, reason: collision with root package name */
        public final Object f43135d;

        /* renamed from: e, reason: collision with root package name */
        public final Object f43136e;

        /* renamed from: f, reason: collision with root package name */
        public transient SortedMap f43137f;

        public TreeRow(Object obj, Object obj2, Object obj3) {
            super(obj);
            this.f43135d = obj2;
            this.f43136e = obj3;
            if (obj2 == null || obj3 == null) {
                return;
            }
            comparator();
            throw null;
        }

        @Override // com.google.common.collect.StandardTable.Row
        public final Map b() {
            f();
            SortedMap sortedMapTailMap = this.f43137f;
            if (sortedMapTailMap == null) {
                return null;
            }
            Object obj = this.f43135d;
            if (obj != null) {
                sortedMapTailMap = sortedMapTailMap.tailMap(obj);
            }
            Object obj2 = this.f43136e;
            return obj2 != null ? sortedMapTailMap.headMap(obj2) : sortedMapTailMap;
        }

        @Override // com.google.common.collect.StandardTable.Row
        public final void c() {
            f();
            SortedMap sortedMap = this.f43137f;
            if (sortedMap == null || !sortedMap.isEmpty()) {
                return;
            }
            TreeBasedTable.this.getClass();
            throw null;
        }

        @Override // java.util.SortedMap
        public final Comparator comparator() {
            TreeBasedTable.this.getClass();
            return null;
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(Object obj) {
            return e(obj) && super.containsKey(obj);
        }

        public final boolean e(Object obj) {
            if (obj == null) {
                return false;
            }
            if (this.f43135d != null) {
                comparator();
                throw null;
            }
            if (this.f43136e == null) {
                return true;
            }
            comparator();
            throw null;
        }

        public final void f() {
            SortedMap sortedMap = this.f43137f;
            TreeBasedTable treeBasedTable = TreeBasedTable.this;
            if (sortedMap == null) {
                treeBasedTable.getClass();
                throw null;
            }
            if (sortedMap.isEmpty()) {
                treeBasedTable.getClass();
                throw null;
            }
        }

        @Override // java.util.SortedMap
        public final Object firstKey() {
            d();
            Map map = this.f43101b;
            if (map != null) {
                return ((SortedMap) map).firstKey();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.SortedMap
        public final SortedMap headMap(Object obj) {
            obj.getClass();
            Preconditions.f(e(obj));
            return new TreeRow(this.f43100a, this.f43135d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
        public final Set keySet() {
            return new Maps.SortedKeySet(this);
        }

        @Override // java.util.SortedMap
        public final Object lastKey() {
            d();
            Map map = this.f43101b;
            if (map != null) {
                return ((SortedMap) map).lastKey();
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.StandardTable.Row, java.util.AbstractMap, java.util.Map
        public final Object put(Object obj, Object obj2) {
            obj.getClass();
            Preconditions.f(e(obj));
            return super.put(obj, obj2);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // java.util.SortedMap
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.SortedMap subMap(java.lang.Object r4, java.lang.Object r5) {
            /*
                r3 = this;
                r4.getClass()
                boolean r0 = r3.e(r4)
                if (r0 == 0) goto L14
                r5.getClass()
                boolean r0 = r3.e(r5)
                if (r0 == 0) goto L14
                r0 = 1
                goto L15
            L14:
                r0 = 0
            L15:
                com.google.common.base.Preconditions.f(r0)
                com.google.common.collect.TreeBasedTable$TreeRow r0 = new com.google.common.collect.TreeBasedTable$TreeRow
                com.google.common.collect.TreeBasedTable r1 = com.google.common.collect.TreeBasedTable.this
                java.lang.Object r2 = r3.f43100a
                r0.<init>(r2, r4, r5)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeBasedTable.TreeRow.subMap(java.lang.Object, java.lang.Object):java.util.SortedMap");
        }

        @Override // java.util.SortedMap
        public final SortedMap tailMap(Object obj) {
            obj.getClass();
            Preconditions.f(e(obj));
            return new TreeRow(this.f43100a, obj, this.f43136e);
        }
    }

    @Override // com.google.common.collect.StandardRowSortedTable, com.google.common.collect.StandardTable, com.google.common.collect.Table
    public final Map g() {
        return super.g();
    }

    @Override // com.google.common.collect.StandardTable
    public final Map i(Object obj) {
        return new StandardTable.Column(obj);
    }

    @Override // com.google.common.collect.StandardTable
    public final Iterator o() {
        throw null;
    }

    @Override // com.google.common.collect.StandardTable
    public final Map t(Object obj) {
        return new TreeRow(obj, null, null);
    }
}
