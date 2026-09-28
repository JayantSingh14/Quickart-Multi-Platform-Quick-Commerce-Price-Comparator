package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.EmptySet;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UnlimitedStorage implements CacheStorage {

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f49842b = new ConcurrentMap(0);

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object a(Url url, ContinuationImpl continuationImpl) {
        Set set = (Set) this.f49842b.f50527a.get(url);
        return set == null ? EmptySet.f53611a : set;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object b(Url url, CachedResponseData cachedResponseData, ContinuationImpl continuationImpl) {
        Set set = (Set) this.f49842b.a(url, UnlimitedStorage$store$cache$1.f49844c);
        if (!set.add(cachedResponseData)) {
            set.remove(cachedResponseData);
            set.add(cachedResponseData);
        }
        return Unit.f53572a;
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object c(Url url, Map map, Continuation continuation) {
        for (Object obj : (Set) this.f49842b.a(url, UnlimitedStorage$find$data$1.f49843c)) {
            CachedResponseData cachedResponseData = (CachedResponseData) obj;
            if (!map.isEmpty()) {
                for (Map.Entry entry : map.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!Intrinsics.b(cachedResponseData.f49761h.get(str), (String) entry.getValue())) {
                        break;
                    }
                }
            }
            return obj;
        }
        return null;
    }
}
