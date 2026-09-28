package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public abstract class ForwardingTable<R, C, V> extends ForwardingObject implements Table<R, C, V> {
    @Override // com.google.common.collect.Table
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        throw null;
    }

    @Override // com.google.common.collect.Table
    public Map g() {
        throw null;
    }

    @Override // com.google.common.collect.Table
    public final int hashCode() {
        throw null;
    }

    @Override // com.google.common.collect.Table
    public Set n() {
        throw null;
    }

    @Override // com.google.common.collect.Table
    public final int size() {
        throw null;
    }

    @Override // com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object t() {
        return null;
    }
}
