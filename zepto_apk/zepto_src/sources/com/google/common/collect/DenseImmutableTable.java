package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Table;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;

@Immutable
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {

    public final class Column extends ImmutableArrayMap<R, V> {
        @Override // com.google.common.collect.ImmutableMap
        public final boolean g() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final Object p(int i2) {
            throw null;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final ImmutableMap q() {
            throw null;
        }
    }

    public final class ColumnMap extends ImmutableArrayMap<C, ImmutableMap<R, V>> {
        @Override // com.google.common.collect.ImmutableMap
        public final boolean g() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final Object p(int i2) {
            throw null;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final ImmutableMap q() {
            throw null;
        }
    }

    public static abstract class ImmutableArrayMap<K, V> extends ImmutableMap.IteratorBasedImmutableMap<K, V> {
        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        public final ImmutableSet c() {
            q().size();
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public final Object get(Object obj) {
            Integer num = (Integer) q().get(obj);
            if (num == null) {
                return null;
            }
            p(num.intValue());
            throw null;
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        public final UnmodifiableIterator o() {
            return new AbstractIterator<Map.Entry<Object, Object>>() { // from class: com.google.common.collect.DenseImmutableTable.ImmutableArrayMap.1

                /* renamed from: c, reason: collision with root package name */
                public int f42595c = -1;

                /* renamed from: d, reason: collision with root package name */
                public final int f42596d;

                {
                    this.f42596d = ImmutableArrayMap.this.q().size();
                }

                @Override // com.google.common.collect.AbstractIterator
                public final Object a() {
                    int i2 = this.f42595c + 1;
                    this.f42595c = i2;
                    if (i2 >= this.f42596d) {
                        this.f42456a = AbstractIterator.State.f42461c;
                        return null;
                    }
                    ImmutableArrayMap.this.p(i2);
                    throw null;
                }
            };
        }

        public abstract Object p(int i2);

        public abstract ImmutableMap q();

        @Override // java.util.Map
        public final int size() {
            throw null;
        }
    }

    public final class Row extends ImmutableArrayMap<C, V> {
        @Override // com.google.common.collect.ImmutableMap
        public final boolean g() {
            return true;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final Object p(int i2) {
            throw null;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final ImmutableMap q() {
            throw null;
        }
    }

    public final class RowMap extends ImmutableArrayMap<R, ImmutableMap<C, V>> {
        @Override // com.google.common.collect.ImmutableMap
        public final boolean g() {
            return false;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final Object p(int i2) {
            throw null;
        }

        @Override // com.google.common.collect.DenseImmutableTable.ImmutableArrayMap
        public final ImmutableMap q() {
            throw null;
        }
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    public final Map g() {
        return ImmutableMap.a(null);
    }

    @Override // com.google.common.collect.ImmutableTable
    public final Object j(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: k */
    public final ImmutableMap g() {
        return ImmutableMap.a(null);
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public final Table.Cell l(int i2) {
        throw null;
    }

    @Override // com.google.common.collect.RegularImmutableTable
    public final Object m(int i2) {
        throw null;
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        throw null;
    }
}
