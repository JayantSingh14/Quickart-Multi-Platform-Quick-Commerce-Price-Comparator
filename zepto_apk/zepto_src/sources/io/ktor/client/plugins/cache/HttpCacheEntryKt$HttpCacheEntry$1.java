package io.ktor.client.plugins.cache;

import io.ktor.client.statement.HttpResponse;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCacheEntryKt", f = "HttpCacheEntry.kt", l = {18}, m = "HttpCacheEntry")
/* loaded from: classes3.dex */
final class HttpCacheEntryKt$HttpCacheEntry$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpResponse f49728a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49729b;

    /* renamed from: c, reason: collision with root package name */
    public int f49730c;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49729b = obj;
        this.f49730c |= Integer.MIN_VALUE;
        return HttpCacheEntryKt.a(null, this);
    }
}
