package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import java.util.List;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes4.dex */
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {
    }

    public static final class Present<V> {
    }

    @Override // com.google.common.util.concurrent.AggregateFuture
    public final void r() {
    }
}
