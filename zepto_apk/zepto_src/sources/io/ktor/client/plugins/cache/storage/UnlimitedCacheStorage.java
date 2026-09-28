package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class UnlimitedCacheStorage extends HttpCacheStorage {

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f49839b = new ConcurrentMap(0);

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final HttpCacheEntry a(Url url, Map varyKeys) {
        Object next;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(varyKeys, "varyKeys");
        Iterator it = ((Set) this.f49839b.a(url, UnlimitedCacheStorage$find$data$1.f49840c)).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            HttpCacheEntry httpCacheEntry = (HttpCacheEntry) next;
            if (!varyKeys.isEmpty()) {
                for (Map.Entry entry : varyKeys.entrySet()) {
                    String str = (String) entry.getKey();
                    if (!Intrinsics.b(httpCacheEntry.f49725a.get(str), (String) entry.getValue())) {
                        break;
                    }
                }
                break loop0;
            }
            break;
        }
        return (HttpCacheEntry) next;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final Set b(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        Set set = (Set) this.f49839b.f50527a.get(url);
        return set == null ? EmptySet.f53611a : set;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final void c(Url url, HttpCacheEntry value) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(value, "value");
        Set set = (Set) this.f49839b.a(url, UnlimitedCacheStorage$store$data$1.f49841c);
        if (set.add(value)) {
            return;
        }
        set.remove(value);
        set.add(value);
    }
}
