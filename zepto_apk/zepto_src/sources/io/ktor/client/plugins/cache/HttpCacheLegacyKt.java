package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpCacheLegacyKt {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(io.ktor.client.plugins.cache.HttpCache r7, io.ktor.client.statement.HttpResponse r8, kotlin.coroutines.jvm.internal.ContinuationImpl r9) {
        /*
            boolean r0 = r9 instanceof io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1 r0 = (io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1) r0
            int r1 = r0.f49737b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49737b = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1 r0 = new io.ktor.client.plugins.cache.HttpCacheLegacyKt$cacheResponse$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f49736a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49737b
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r9)
            goto L6e
        L27:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L2f:
            kotlin.ResultKt.b(r9)
            io.ktor.client.call.HttpClientCall r9 = r8.o1()
            io.ktor.client.request.HttpRequest r9 = r9.d()
            java.util.List r2 = io.ktor.http.HttpMessagePropertiesKt.a(r8)
            java.util.List r4 = io.ktor.http.HttpMessagePropertiesKt.a(r9)
            io.ktor.http.HeaderValue r5 = io.ktor.client.plugins.cache.CacheControl.f49684c
            boolean r5 = r2.contains(r5)
            if (r5 == 0) goto L4d
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r5 = r7.f49690b
            goto L4f
        L4d:
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r5 = r7.f49689a
        L4f:
            io.ktor.http.HeaderValue r6 = io.ktor.client.plugins.cache.CacheControl.f49682a
            boolean r2 = r2.contains(r6)
            if (r2 != 0) goto L75
            boolean r2 = r4.contains(r6)
            if (r2 == 0) goto L5e
            goto L75
        L5e:
            io.ktor.http.Url r9 = r9.N()
            r7.getClass()
            r0.f49737b = r3
            java.lang.Object r9 = io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.c(r5, r9, r8, r0)
            if (r9 != r1) goto L6e
            return r1
        L6e:
            io.ktor.client.plugins.cache.HttpCacheEntry r9 = (io.ktor.client.plugins.cache.HttpCacheEntry) r9
            io.ktor.client.statement.HttpResponse r7 = r9.a()
            return r7
        L75:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.HttpCacheLegacyKt.a(io.ktor.client.plugins.cache.HttpCache, io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
