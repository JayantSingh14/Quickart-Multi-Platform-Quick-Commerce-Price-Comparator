package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Tables;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@IgnoreJRERequirement
/* loaded from: classes4.dex */
final class TableCollectors {

    public static final class ImmutableTableCollectorState<R, C, V> {
    }

    @IgnoreJRERequirement
    public static final class MutableCell<R, C, V> extends Tables.AbstractCell<R, C, V> {
        @Override // com.google.common.collect.Table.Cell
        public final Object a() {
            return null;
        }

        @Override // com.google.common.collect.Table.Cell
        public final Object b() {
            return null;
        }

        @Override // com.google.common.collect.Table.Cell
        public final Object getValue() {
            return null;
        }
    }
}
