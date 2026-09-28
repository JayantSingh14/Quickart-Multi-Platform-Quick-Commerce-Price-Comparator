package io.ktor.client.plugins.cache.storage;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", l = {53}, m = "findAll")
/* loaded from: classes3.dex */
final class CachingCacheStorage$findAll$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f49766a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CachingCacheStorage f49767b;

    /* renamed from: c, reason: collision with root package name */
    public int f49768c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachingCacheStorage$findAll$1(CachingCacheStorage cachingCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49767b = cachingCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49766a = obj;
        this.f49768c |= Integer.MIN_VALUE;
        this.f49767b.a(null, this);
        throw null;
    }
}
