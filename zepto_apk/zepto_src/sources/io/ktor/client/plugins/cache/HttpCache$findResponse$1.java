package io.ktor.client.plugins.cache;

import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache", f = "HttpCache.kt", l = {311, 316}, m = "findResponse")
/* loaded from: classes3.dex */
final class HttpCache$findResponse$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49715a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49716b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpCache f49717c;

    /* renamed from: d, reason: collision with root package name */
    public int f49718d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCache$findResponse$1(HttpCache httpCache, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49717c = httpCache;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49716b = obj;
        this.f49718d |= Integer.MIN_VALUE;
        AttributeKey attributeKey = HttpCache.f49687e;
        return this.f49717c.c(null, null, null, null, this);
    }
}
