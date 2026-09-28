package io.ktor.client.plugins.cache;

import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {328, 328}, m = "findResponse")
/* loaded from: classes3.dex */
final class HttpCache$findResponse$4 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49719a;

    /* renamed from: b, reason: collision with root package name */
    public Object f49720b;

    /* renamed from: c, reason: collision with root package name */
    public Object f49721c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ Object f49722d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ HttpCache f49723e;

    /* renamed from: f, reason: collision with root package name */
    public int f49724f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$findResponse$4(HttpCache httpCache, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49723e = httpCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49722d = obj;
        this.f49724f |= Integer.MIN_VALUE;
        return HttpCache.b(this.f49723e, null, null, this);
    }
}
