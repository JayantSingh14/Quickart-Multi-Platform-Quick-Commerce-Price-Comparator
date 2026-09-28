package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Table;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {

    public final class CellSet extends IndexedImmutableSet<Table.Cell<R, C, V>> {
        public CellSet() {
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(Object obj) {
            if (!(obj instanceof Table.Cell)) {
                return false;
            }
            Table.Cell cell = (Table.Cell) obj;
            Object objJ = RegularImmutableTable.this.j(cell.a(), cell.b());
            return objJ != null && objJ.equals(cell.getValue());
        }

        @Override // com.google.common.collect.IndexedImmutableSet
        public final Object get(int i2) {
            return RegularImmutableTable.this.l(i2);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final int size() {
            return RegularImmutableTable.this.size();
        }
    }

    public final class Values extends ImmutableList<V> {
        public Values() {
        }

        @Override // java.util.List
        public final Object get(int i2) {
            return RegularImmutableTable.this.m(i2);
        }

        @Override // com.google.common.collect.ImmutableCollection
        public final boolean j() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public final int size() {
            return RegularImmutableTable.this.size();
        }
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* renamed from: h */
    public final ImmutableSet d() {
        if (size() != 0) {
            return new CellSet();
        }
        int i2 = ImmutableSet.f42719c;
        return RegularImmutableSet.f43033j;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* renamed from: i */
    public final ImmutableCollection e() {
        if (size() != 0) {
            return new Values();
        }
        UnmodifiableListIterator unmodifiableListIterator = ImmutableList.f42665b;
        return RegularImmutableList.f43010e;
    }

    public abstract Table.Cell l(int i2);

    public abstract Object m(int i2);
}
