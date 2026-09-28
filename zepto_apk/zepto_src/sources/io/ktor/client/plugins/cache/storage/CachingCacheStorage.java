package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class CachingCacheStorage implements CacheStorage {
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.http.Url r4, kotlin.coroutines.jvm.internal.ContinuationImpl r5) {
        /*
            r3 = this;
            boolean r4 = r5 instanceof io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1
            if (r4 == 0) goto L13
            r4 = r5
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1 r4 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1) r4
            int r0 = r4.f49768c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r4.f49768c = r0
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1 r4 = new io.ktor.client.plugins.cache.storage.CachingCacheStorage$findAll$1
            r4.<init>(r3, r5)
        L18:
            java.lang.Object r5 = r4.f49766a
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r4 = r4.f49768c
            r0 = 0
            if (r4 == 0) goto L30
            r1 = 1
            if (r4 == r1) goto L2c
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2c:
            kotlin.ResultKt.b(r5)
            throw r0
        L30:
            kotlin.ResultKt.b(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.CachingCacheStorage.a(io.ktor.http.Url, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(io.ktor.http.Url r4, io.ktor.client.plugins.cache.storage.CachedResponseData r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r3 = this;
            boolean r5 = r6 instanceof io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1
            if (r5 == 0) goto L13
            r5 = r6
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1 r5 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1) r5
            int r0 = r5.f49773e
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r0 & r1
            if (r2 == 0) goto L13
            int r0 = r0 - r1
            r5.f49773e = r0
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1 r5 = new io.ktor.client.plugins.cache.storage.CachingCacheStorage$store$1
            r5.<init>(r3, r6)
        L18:
            java.lang.Object r6 = r5.f49771c
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r0 = r5.f49773e
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L4f
            r4 = 2
            if (r0 == r1) goto L3e
            if (r0 != r4) goto L36
            io.ktor.http.Url r4 = r5.f49770b
            io.ktor.client.plugins.cache.storage.CachingCacheStorage r5 = r5.f49769a
            java.util.Map r5 = (java.util.Map) r5
            kotlin.ResultKt.b(r6)
            r5.put(r4, r6)
            kotlin.Unit r4 = kotlin.Unit.f53572a
            return r4
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            io.ktor.http.Url r0 = r5.f49770b
            io.ktor.client.plugins.cache.storage.CachingCacheStorage r1 = r5.f49769a
            kotlin.ResultKt.b(r6)
            r1.getClass()
            r5.f49769a = r2
            r5.f49770b = r0
            r5.f49773e = r4
            throw r2
        L4f:
            kotlin.ResultKt.b(r6)
            r5.f49769a = r3
            r5.f49770b = r4
            r5.f49773e = r1
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.CachingCacheStorage.b(io.ktor.http.Url, io.ktor.client.plugins.cache.storage.CachedResponseData, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(io.ktor.http.Url r3, java.util.Map r4, kotlin.coroutines.Continuation r5) {
        /*
            r2 = this;
            boolean r3 = r5 instanceof io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1
            if (r3 == 0) goto L13
            r3 = r5
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1 r3 = (io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1) r3
            int r4 = r3.f49765c
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r4 & r0
            if (r1 == 0) goto L13
            int r4 = r4 - r0
            r3.f49765c = r4
            goto L1a
        L13:
            io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1 r3 = new io.ktor.client.plugins.cache.storage.CachingCacheStorage$find$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r5 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r5
            r3.<init>(r2, r5)
        L1a:
            java.lang.Object r4 = r3.f49763a
            kotlin.coroutines.intrinsics.CoroutineSingletons r5 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r3.f49765c
            r5 = 0
            if (r3 == 0) goto L32
            r0 = 1
            if (r3 == r0) goto L2e
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            r3.<init>(r4)
            throw r3
        L2e:
            kotlin.ResultKt.b(r4)
            throw r5
        L32:
            kotlin.ResultKt.b(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.CachingCacheStorage.c(io.ktor.http.Url, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
