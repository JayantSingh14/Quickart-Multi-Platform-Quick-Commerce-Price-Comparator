package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;

@Metadata
/* loaded from: classes3.dex */
public interface CacheStorage {

    /* renamed from: a, reason: collision with root package name */
    public static final Companion f49750a = Companion.f49751a;

    @Metadata
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Companion f49751a = new Companion();

        /* renamed from: b, reason: collision with root package name */
        public static final Function0 f49752b = null;

        public static Function0 a() {
            return CacheStorage$Companion$Unlimited$1.f49753c;
        }
    }

    Object a(Url url, ContinuationImpl continuationImpl);

    Object b(Url url, CachedResponseData cachedResponseData, ContinuationImpl continuationImpl);

    Object c(Url url, Map map, Continuation continuation);
}
