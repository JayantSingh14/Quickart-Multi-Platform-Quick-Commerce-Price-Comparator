package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Url;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", l = {Type.RKEY}, m = "store")
/* loaded from: classes3.dex */
final class HttpCacheStorageKt$store$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpCacheStorage f49829a;

    /* renamed from: b, reason: collision with root package name */
    public Url f49830b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f49831c;

    /* renamed from: d, reason: collision with root package name */
    public int f49832d;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49831c = obj;
        this.f49832d |= Integer.MIN_VALUE;
        return HttpCacheStorageKt.c(null, null, null, this);
    }
}
