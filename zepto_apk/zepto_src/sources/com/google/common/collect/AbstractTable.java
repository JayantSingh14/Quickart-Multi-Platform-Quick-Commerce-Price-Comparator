package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class AbstractTable<R, C, V> implements Table<R, C, V> {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f42521a;

    /* renamed from: b, reason: collision with root package name */
    public transient Collection f42522b;

    /* renamed from: com.google.common.collect.AbstractTable$1, reason: invalid class name */
    class AnonymousClass1 extends TransformedIterator<Table.Cell<Object, Object, Object>, Object> {
        @Override // com.google.common.collect.TransformedIterator
        public final Object a(Object obj) {
            return ((Table.Cell) obj).getValue();
        }
    }

    public class CellSet extends AbstractSet<Table.Cell<R, C, V>> {
        public CellSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final void clear() {
            AbstractTable.this.b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Map map = (Map) Maps.h(cell.a(), AbstractTable.this.g());
            if (map != null) {
                return Collections2.c(new ImmutableEntry(cell.b(), cell.getValue()), map.entrySet());
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public final Iterator iterator() {
            return AbstractTable.this.a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(Object obj) {
            boolean zRemove;
            if (obj instanceof Table.Cell) {
                Table.Cell cell = (Table.Cell) obj;
                Map map = (Map) Maps.h(cell.a(), AbstractTable.this.g());
                if (map != null) {
                    Set setEntrySet = map.entrySet();
                    ImmutableEntry immutableEntry = new ImmutableEntry(cell.b(), cell.getValue());
                    setEntrySet.getClass();
                    try {
                        zRemove = setEntrySet.remove(immutableEntry);
                    } catch (ClassCastException | NullPointerException unused) {
                        zRemove = false;
                    }
                    if (zRemove) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return AbstractTable.this.size();
        }
    }

    public class Values extends AbstractCollection<V> {
        public Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final void clear() {
            AbstractTable.this.b();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final boolean contains(Object obj) {
            return AbstractTable.this.c(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public final Iterator iterator() {
            return AbstractTable.this.f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public final int size() {
            return AbstractTable.this.size();
        }
    }

    public abstract Iterator a();

    public void b() {
        Iterators.b(n().iterator());
    }

    public boolean c(Object obj) {
        Iterator<V> it = g().values().iterator();
        while (it.hasNext()) {
            if (((Map) it.next()).containsValue(obj)) {
                return true;
            }
        }
        return false;
    }

    public Set d() {
        return new CellSet();
    }

    public Collection e() {
        return new Values();
    }

    @Override // com.google.common.collect.Table
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Table) {
            return n().equals(((Table) obj).n());
        }
        return false;
    }

    public Iterator f() {
        return new AnonymousClass1(n().iterator());
    }

    @Override // com.google.common.collect.Table
    public int hashCode() {
        return n().hashCode();
    }

    @Override // com.google.common.collect.Table
    public Set n() {
        Set set = this.f42521a;
        if (set != null) {
            return set;
        }
        Set setD = d();
        this.f42521a = setD;
        return setD;
    }

    public String toString() {
        return g().toString();
    }
}
