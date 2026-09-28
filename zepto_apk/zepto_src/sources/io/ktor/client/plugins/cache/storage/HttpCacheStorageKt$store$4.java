package io.ktor.client.plugins.cache.storage;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Url;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.HttpCacheStorageKt", f = "HttpCacheStorage.kt", l = {WKSRecord.Service.LOCUS_MAP, WKSRecord.Service.NETBIOS_DGM}, m = "store")
/* loaded from: classes3.dex */
final class HttpCacheStorageKt$store$4 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public Object f49833a;

    /* renamed from: b, reason: collision with root package name */
    public HttpResponse f49834b;

    /* renamed from: c, reason: collision with root package name */
    public Map f49835c;

    /* renamed from: d, reason: collision with root package name */
    public Url f49836d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f49837e;

    /* renamed from: f, reason: collision with root package name */
    public int f49838f;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49837e = obj;
        this.f49838f |= Integer.MIN_VALUE;
        return HttpCacheStorageKt.b(null, null, null, this);
    }
}
