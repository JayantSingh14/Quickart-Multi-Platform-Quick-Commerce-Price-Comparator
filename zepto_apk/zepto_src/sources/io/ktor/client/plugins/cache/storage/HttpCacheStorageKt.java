package io.ktor.client.plugins.cache.storage;

import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HttpCacheStorageKt {
    public static final HttpResponse a(final CachedResponseData cachedResponseData, HttpClient client, HttpRequest request, final CoroutineContext responseContext) {
        Intrinsics.checkNotNullParameter(cachedResponseData, "<this>");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(responseContext, "responseContext");
        return new SavedHttpCall(client, request, new HttpResponse(cachedResponseData, responseContext) { // from class: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$createResponse$response$1

            /* renamed from: a, reason: collision with root package name */
            public final HttpStatusCode f49823a;

            /* renamed from: b, reason: collision with root package name */
            public final HttpProtocolVersion f49824b;

            /* renamed from: c, reason: collision with root package name */
            public final GMTDate f49825c;

            /* renamed from: d, reason: collision with root package name */
            public final GMTDate f49826d;

            /* renamed from: e, reason: collision with root package name */
            public final Headers f49827e;

            /* renamed from: f, reason: collision with root package name */
            public final CoroutineContext f49828f;

            {
                this.f49823a = cachedResponseData.f49755b;
                this.f49824b = cachedResponseData.f49758e;
                this.f49825c = cachedResponseData.f49756c;
                this.f49826d = cachedResponseData.f49757d;
                this.f49827e = cachedResponseData.f49760g;
                this.f49828f = responseContext;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public final ByteReadChannel a() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.client.statement.HttpResponse
            public final GMTDate c() {
                return this.f49825c;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public final GMTDate d() {
                return this.f49826d;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public final HttpStatusCode e() {
                return this.f49823a;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public final HttpProtocolVersion f() {
                return this.f49824b;
            }

            @Override // io.ktor.http.HttpMessage
            public final Headers getHeaders() {
                return this.f49827e;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public final HttpClientCall o1() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // kotlinx.coroutines.CoroutineScope
            public final CoroutineContext r() {
                return this.f49828f;
            }
        }, cachedResponseData.f49762i).e();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(io.ktor.client.plugins.cache.storage.CacheStorage r18, io.ktor.client.statement.HttpResponse r19, java.util.Map r20, kotlin.coroutines.jvm.internal.ContinuationImpl r21) {
        /*
            r0 = r21
            boolean r1 = r0 instanceof io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4
            if (r1 == 0) goto L15
            r1 = r0
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4 r1 = (io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4) r1
            int r2 = r1.f49838f
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L15
            int r2 = r2 - r3
            r1.f49838f = r2
            goto L1a
        L15:
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4 r1 = new io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$4
            r1.<init>(r0)
        L1a:
            java.lang.Object r0 = r1.f49837e
            kotlin.coroutines.intrinsics.CoroutineSingletons r2 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r3 = r1.f49838f
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L4d
            if (r3 == r5) goto L38
            if (r3 != r4) goto L30
            java.lang.Object r1 = r1.f49833a
            io.ktor.client.plugins.cache.storage.CachedResponseData r1 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r1
            kotlin.ResultKt.b(r0)
            return r1
        L30:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L38:
            io.ktor.http.Url r3 = r1.f49836d
            java.util.Map r5 = r1.f49835c
            io.ktor.client.statement.HttpResponse r6 = r1.f49834b
            java.lang.Object r7 = r1.f49833a
            io.ktor.client.plugins.cache.storage.CacheStorage r7 = (io.ktor.client.plugins.cache.storage.CacheStorage) r7
            kotlin.ResultKt.b(r0)
            r16 = r7
            r7 = r6
            r6 = r16
            r16 = r5
            goto L7e
        L4d:
            kotlin.ResultKt.b(r0)
            io.ktor.client.call.HttpClientCall r0 = r19.o1()
            io.ktor.client.request.HttpRequest r0 = r0.d()
            io.ktor.http.Url r3 = r0.N()
            io.ktor.utils.io.ByteReadChannel r0 = r19.a()
            r6 = r18
            r1.f49833a = r6
            r7 = r19
            r1.f49834b = r7
            r8 = r20
            r1.f49835c = r8
            r1.f49836d = r3
            r1.f49838f = r5
            r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.lang.Object r0 = r0.n(r9, r1)
            if (r0 != r2) goto L7c
            goto Lc1
        L7c:
            r16 = r8
        L7e:
            io.ktor.utils.io.core.ByteReadPacket r0 = (io.ktor.utils.io.core.ByteReadPacket) r0
            byte[] r17 = io.ktor.utils.io.core.StringsKt.c(r0)
            io.ktor.client.statement.HttpResponseKt.c(r7)
            io.ktor.client.call.HttpClientCall r0 = r7.o1()
            io.ktor.client.request.HttpRequest r0 = r0.d()
            io.ktor.http.Url r9 = r0.N()
            io.ktor.http.HttpStatusCode r10 = r7.e()
            io.ktor.util.date.GMTDate r11 = r7.c()
            io.ktor.http.Headers r15 = r7.getHeaders()
            io.ktor.http.HttpProtocolVersion r13 = r7.f()
            io.ktor.util.date.GMTDate r12 = r7.d()
            io.ktor.util.date.GMTDate r14 = io.ktor.client.plugins.cache.HttpCacheEntryKt.b(r7)
            io.ktor.client.plugins.cache.storage.CachedResponseData r8 = new io.ktor.client.plugins.cache.storage.CachedResponseData
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            r1.f49833a = r8
            r0 = 0
            r1.f49834b = r0
            r1.f49835c = r0
            r1.f49836d = r0
            r1.f49838f = r4
            java.lang.Object r0 = r6.b(r3, r8, r1)
            if (r0 != r2) goto Lc2
        Lc1:
            return r2
        Lc2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.b(io.ktor.client.plugins.cache.storage.CacheStorage, io.ktor.client.statement.HttpResponse, java.util.Map, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.client.plugins.cache.storage.HttpCacheStorage r4, io.ktor.http.Url r5, io.ktor.client.statement.HttpResponse r6, kotlin.coroutines.jvm.internal.ContinuationImpl r7) {
        /*
            boolean r0 = r7 instanceof io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1
            if (r0 == 0) goto L13
            r0 = r7
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1 r0 = (io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1) r0
            int r1 = r0.f49832d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49832d = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1 r0 = new io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$store$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f49831c
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49832d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            io.ktor.http.Url r5 = r0.f49830b
            io.ktor.client.plugins.cache.storage.HttpCacheStorage r4 = r0.f49829a
            kotlin.ResultKt.b(r7)
            goto L43
        L2b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L33:
            kotlin.ResultKt.b(r7)
            r0.f49829a = r4
            r0.f49830b = r5
            r0.f49832d = r3
            java.lang.Object r7 = io.ktor.client.plugins.cache.HttpCacheEntryKt.a(r6, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            io.ktor.client.plugins.cache.HttpCacheEntry r7 = (io.ktor.client.plugins.cache.HttpCacheEntry) r7
            r4.c(r5, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.c(io.ktor.client.plugins.cache.storage.HttpCacheStorage, io.ktor.http.Url, io.ktor.client.statement.HttpResponse, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
