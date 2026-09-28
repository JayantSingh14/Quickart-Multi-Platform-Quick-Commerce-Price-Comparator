package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FileCacheStorage implements CacheStorage {
    public static String d(Url url) {
        byte[] bArrDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5).digest(StringsKt.q(url.f50268i));
        Intrinsics.checkNotNullExpressionValue(bArrDigest, "getInstance(\"MD5\").diges…ng().encodeToByteArray())");
        return CryptoKt.c(bArrDigest);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(io.ktor.http.Url r5, kotlin.coroutines.jvm.internal.ContinuationImpl r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1
            if (r0 == 0) goto L13
            r0 = r6
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1) r0
            int r1 = r0.f49781c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49781c = r1
            goto L18
        L13:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$findAll$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f49779a
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49781c
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.ResultKt.b(r6)
            goto L3e
        L27:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2f:
            kotlin.ResultKt.b(r6)
            d(r5)
            r0.f49781c = r3
            java.lang.Object r6 = r4.f(r0)
            if (r6 != r1) goto L3e
            return r1
        L3e:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            java.util.Set r5 = kotlin.collections.CollectionsKt.h0(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.a(io.ktor.http.Url, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public final Object b(Url url, CachedResponseData cachedResponseData, ContinuationImpl continuationImpl) throws Throwable {
        Object objE = BuildersKt.e(null, new FileCacheStorage$store$2(this, url, cachedResponseData, null), continuationImpl);
        return objE == CoroutineSingletons.f53689a ? objE : Unit.f53572a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(io.ktor.http.Url r6, java.util.Map r7, kotlin.coroutines.Continuation r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = (io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1) r0
            int r1 = r0.f49778d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f49778d = r1
            goto L1a
        L13:
            io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1 r0 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$find$1
            kotlin.coroutines.jvm.internal.ContinuationImpl r8 = (kotlin.coroutines.jvm.internal.ContinuationImpl) r8
            r0.<init>(r5, r8)
        L1a:
            java.lang.Object r8 = r0.f49776b
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r2 = r0.f49778d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            java.util.Map r7 = r0.f49775a
            kotlin.ResultKt.b(r8)
            goto L44
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            kotlin.ResultKt.b(r8)
            d(r6)
            r0.f49775a = r7
            r0.f49778d = r3
            java.lang.Object r8 = r5.f(r0)
            if (r8 != r1) goto L44
            return r1
        L44:
            java.util.Set r8 = (java.util.Set) r8
            java.util.Iterator r6 = r8.iterator()
        L4a:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L8c
            java.lang.Object r8 = r6.next()
            r0 = r8
            io.ktor.client.plugins.cache.storage.CachedResponseData r0 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r0
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L5e
            goto L8b
        L5e:
            java.util.Set r1 = r7.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L66:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8b
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            java.util.Map r4 = r0.f49761h
            java.lang.Object r3 = r4.get(r3)
            boolean r2 = kotlin.jvm.internal.Intrinsics.b(r3, r2)
            if (r2 != 0) goto L66
            goto L4a
        L8b:
            return r8
        L8c:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.c(io.ktor.http.Url, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0358, code lost:
    
        if (r1 != r4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x03f2, code lost:
    
        if (r1 != r4) goto L92;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x048f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x04ec  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0260 A[PHI: r0 r1 r5 r7
      0x0260: PHI (r0v7 int) = (r0v4 int), (r0v9 int) binds: [B:38:0x025c, B:27:0x01ff] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r1v10 java.lang.Object) = (r1v9 java.lang.Object), (r1v1 java.lang.Object) binds: [B:38:0x025c, B:27:0x01ff] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r5v7 java.lang.String) = (r5v3 java.lang.String), (r5v10 java.lang.String) binds: [B:38:0x025c, B:27:0x01ff] A[DONT_GENERATE, DONT_INLINE]
      0x0260: PHI (r7v4 io.ktor.utils.io.ByteReadChannel) = (r7v2 io.ktor.utils.io.ByteReadChannel), (r7v7 io.ktor.utils.io.ByteReadChannel) binds: [B:38:0x025c, B:27:0x01ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x03ac A[PHI: r0 r1 r5 r6 r7 r9 r10
      0x03ac: PHI (r0v42 io.ktor.util.date.GMTDate) = (r0v39 io.ktor.util.date.GMTDate), (r0v44 io.ktor.util.date.GMTDate) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x03ac: PHI (r1v38 java.lang.Object) = (r1v37 java.lang.Object), (r1v1 java.lang.Object) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x03ac: PHI (r5v29 io.ktor.http.HeadersBuilder) = (r5v25 io.ktor.http.HeadersBuilder), (r5v32 io.ktor.http.HeadersBuilder) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x03ac: PHI (r6v7 io.ktor.http.HttpProtocolVersion) = (r6v3 io.ktor.http.HttpProtocolVersion), (r6v10 io.ktor.http.HttpProtocolVersion) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x03ac: PHI (r7v28 io.ktor.http.HttpStatusCode) = (r7v24 io.ktor.http.HttpStatusCode), (r7v31 io.ktor.http.HttpStatusCode) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x03ac: PHI (r9v22 java.lang.String) = (r9v18 java.lang.String), (r9v25 java.lang.String) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]
      0x03ac: PHI (r10v16 io.ktor.utils.io.ByteReadChannel) = (r10v14 io.ktor.utils.io.ByteReadChannel), (r10v19 io.ktor.utils.io.ByteReadChannel) binds: [B:83:0x03a8, B:20:0x0152] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0404  */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r7v40, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r8v12, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r9v41, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x0466 -> B:16:0x00c7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0358 -> B:23:0x01ac). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(io.ktor.utils.io.ByteReadChannel r26, kotlin.coroutines.jvm.internal.ContinuationImpl r27) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1346
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.e(io.ktor.utils.io.ByteReadChannel, kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fa A[Catch: all -> 0x012c, TRY_LEAVE, TryCatch #10 {all -> 0x012c, blocks: (B:47:0x00fa, B:57:0x012f, B:45:0x00ed), top: B:100:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012f A[Catch: all -> 0x012c, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x012c, blocks: (B:47:0x00fa, B:57:0x012f, B:45:0x00ed), top: B:100:0x00ed }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Type inference failed for: r12v7, types: [java.util.Set] */
    /* JADX WARN: Type inference failed for: r4v0, types: [int] */
    /* JADX WARN: Type inference failed for: r4v1, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0115 -> B:93:0x011c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(kotlin.coroutines.jvm.internal.ContinuationImpl r18) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage.f(kotlin.coroutines.jvm.internal.ContinuationImpl):java.lang.Object");
    }
}
