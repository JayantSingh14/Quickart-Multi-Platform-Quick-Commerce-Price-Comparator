package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", l = {43}, m = "find")
/* loaded from: classes3.dex */
final class CachingCacheStorage$find$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49763a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CachingCacheStorage f49764b;

    /* renamed from: c, reason: collision with root package name */
    public int f49765c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachingCacheStorage$find$1(CachingCacheStorage cachingCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49764b = cachingCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49763a = obj;
        this.f49765c |= Integer.MIN_VALUE;
        this.f49764b.c(null, null, this);
        throw null;
    }
}
