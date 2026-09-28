package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@Metadata
/* loaded from: classes3.dex */
public final class DisabledStorage implements CacheStorage {
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object a(Url url, ContinuationImpl continuationImpl) {
        return EmptySet.f53611a;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object b(Url url, CachedResponseData cachedResponseData, ContinuationImpl continuationImpl) {
        return Unit.f53572a;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object c(Url url, Map map, Continuation continuation) {
        return null;
    }
}
