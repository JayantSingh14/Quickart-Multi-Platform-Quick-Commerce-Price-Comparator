package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingObject;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes4.dex */
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final /* bridge */ /* synthetic */ Object t() {
            return null;
        }

        @Override // com.google.common.cache.ForwardingCache
        /* renamed from: u */
        public final Cache t() {
            return null;
        }
    }

    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public abstract Cache t();
}
