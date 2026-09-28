package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.CachingCacheStorage", f = "FileCacheStorage.kt", l = {37, Type.A6}, m = "store")
/* loaded from: classes3.dex */
final class CachingCacheStorage$store$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public CachingCacheStorage f49769a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49770b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49771c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CachingCacheStorage f49772d;

    /* renamed from: e, reason: collision with root package name */
    public int f49773e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachingCacheStorage$store$1(CachingCacheStorage cachingCacheStorage, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49772d = cachingCacheStorage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49771c = obj;
        this.f49773e |= Integer.MIN_VALUE;
        return this.f49772d.b(null, null, this);
    }
}
