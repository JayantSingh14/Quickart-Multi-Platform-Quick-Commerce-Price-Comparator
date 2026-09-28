package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
class SingletonImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    public final /* bridge */ /* synthetic */ Set d() {
        d();
        throw null;
    }

    @Override // com.google.common.collect.ImmutableTable
    /* renamed from: h */
    public final ImmutableSet d() {
        Preconditions.j(null, "rowKey");
        throw null;
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.AbstractTable
    /* renamed from: i */
    public final ImmutableCollection e() {
        int i2 = ImmutableSet.f42719c;
        return new SingletonImmutableSet(null);
    }

    @Override // com.google.common.collect.ImmutableTable, com.google.common.collect.Table
    /* renamed from: k */
    public final ImmutableMap g() {
        return ImmutableMap.k(null, ImmutableMap.k(null, null));
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        return 1;
    }
}
