package io.ktor.client.plugins.cache;

import io.ktor.client.plugins.cache.storage.CacheStorage;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {298, 300}, m = "findAndRefresh")
/* loaded from: classes3.dex */
final class HttpCache$findAndRefresh$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49707a;

    /* renamed from: b, reason: collision with root package name */
    public Object f49708b;

    /* renamed from: c, reason: collision with root package name */
    public Object f49709c;

    /* renamed from: d, reason: collision with root package name */
    public CacheStorage f49710d;

    /* renamed from: e, reason: collision with root package name */
    public Object f49711e;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f49712f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ HttpCache f49713g;

    /* renamed from: h, reason: collision with root package name */
    public int f49714h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$findAndRefresh$1(HttpCache httpCache, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49713g = httpCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49712f = obj;
        this.f49714h |= Integer.MIN_VALUE;
        return HttpCache.a(this.f49713g, null, null, this);
    }
}
