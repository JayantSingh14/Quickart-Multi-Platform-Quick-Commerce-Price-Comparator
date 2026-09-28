package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache
        /* renamed from: u */
        public final /* bridge */ /* synthetic */ Cache t() {
            return null;
        }
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        throw null;
    }

    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    public /* bridge */ /* synthetic */ Object t() {
        return null;
    }

    @Override // com.google.common.cache.ForwardingCache
    /* renamed from: u */
    public /* bridge */ /* synthetic */ Cache t() {
        return null;
    }
}
