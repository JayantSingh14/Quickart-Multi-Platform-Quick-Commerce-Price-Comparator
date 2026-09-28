package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.http.Url;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Deprecated
@Metadata
/* loaded from: classes3.dex */
public abstract class HttpCacheStorage {

    /* renamed from: a, reason: collision with root package name */
    public static final Function0 f49821a = null;

    @Metadata
    public static final class Companion {
        public static Function0 a() {
            Function0 function0 = HttpCacheStorage.f49821a;
            return HttpCacheStorage$Companion$Unlimited$1.f49822c;
        }
    }

    static {
        int i2 = DisabledCacheStorage.f49774b;
    }

    public abstract HttpCacheEntry a(Url url, Map map);

    public abstract Set b(Url url);

    public abstract void c(Url url, HttpCacheEntry httpCacheEntry);
}
