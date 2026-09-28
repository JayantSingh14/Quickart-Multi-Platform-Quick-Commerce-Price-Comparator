package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DisabledCacheStorage extends HttpCacheStorage {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f49774b = 0;

    static {
        new DisabledCacheStorage();
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final HttpCacheEntry a(Url url, Map varyKeys) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(varyKeys, "varyKeys");
        return null;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final Set b(Url url) {
        Intrinsics.checkNotNullParameter(url, "url");
        return EmptySet.f53611a;
    }

    @Override // io.ktor.client.plugins.cache.storage.HttpCacheStorage
    public final void c(Url url, HttpCacheEntry value) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(value, "value");
    }
}
