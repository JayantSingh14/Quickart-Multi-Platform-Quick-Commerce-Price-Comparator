package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2", f = "FileCacheStorage.kt", l = {WKSRecord.Service.NETRJS_2, WKSRecord.Service.NETRJS_3}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes3.dex */
final class FileCacheStorage$store$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public String f49807a;

    /* renamed from: b, reason: collision with root package name */
    public int f49808b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ FileCacheStorage f49809c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Url f49810d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CachedResponseData f49811e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileCacheStorage$store$2(FileCacheStorage fileCacheStorage, Url url, CachedResponseData cachedResponseData, Continuation continuation) {
        super(2, continuation);
        this.f49809c = fileCacheStorage;
        this.f49810d = url;
        this.f49811e = cachedResponseData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new FileCacheStorage$store$2(this.f49809c, this.f49810d, this.f49811e, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((FileCacheStorage$store$2) create((CoroutineScope) obj, (Continuation) obj2)).invokeSuspend(Unit.f53572a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0074, code lost:
    
        if (kotlinx.coroutines.CoroutineScopeKt.c(new io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2(r4, r1, r9, null), r8) == r0) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f53689a
            int r1 = r8.f49808b
            r2 = 2
            r3 = 1
            io.ktor.client.plugins.cache.storage.FileCacheStorage r4 = r8.f49809c
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r9)
            goto L77
        L12:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1a:
            java.lang.String r1 = r8.f49807a
            kotlin.ResultKt.b(r9)
            goto L37
        L20:
            kotlin.ResultKt.b(r9)
            r4.getClass()
            io.ktor.http.Url r9 = r8.f49810d
            java.lang.String r1 = io.ktor.client.plugins.cache.storage.FileCacheStorage.d(r9)
            r8.f49807a = r1
            r8.f49808b = r3
            java.lang.Object r9 = r4.f(r8)
            if (r9 != r0) goto L37
            goto L76
        L37:
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r9 = r9.iterator()
        L42:
            boolean r5 = r9.hasNext()
            io.ktor.client.plugins.cache.storage.CachedResponseData r6 = r8.f49811e
            if (r5 == 0) goto L5f
            java.lang.Object r5 = r9.next()
            r7 = r5
            io.ktor.client.plugins.cache.storage.CachedResponseData r7 = (io.ktor.client.plugins.cache.storage.CachedResponseData) r7
            java.util.Map r7 = r7.f49761h
            java.util.Map r6 = r6.f49761h
            boolean r6 = kotlin.jvm.internal.Intrinsics.b(r7, r6)
            if (r6 != 0) goto L42
            r3.add(r5)
            goto L42
        L5f:
            java.util.ArrayList r9 = kotlin.collections.CollectionsKt.K(r6, r3)
            r3 = 0
            r8.f49807a = r3
            r8.f49808b = r2
            r4.getClass()
            io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2 r2 = new io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2
            r2.<init>(r4, r1, r9, r3)
            java.lang.Object r9 = kotlinx.coroutines.CoroutineScopeKt.c(r2, r8)
            if (r9 != r0) goto L77
        L76:
            return r0
        L77:
            kotlin.Unit r9 = kotlin.Unit.f53572a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.cache.storage.FileCacheStorage$store$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
