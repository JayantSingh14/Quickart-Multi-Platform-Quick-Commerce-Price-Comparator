package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.plugins.HttpRedirect;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLProtocol;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Ref;
import org.xbill.DNS.WKSRecord;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.HttpRedirect$Plugin", f = "HttpRedirect.kt", l = {WKSRecord.Service.AUTH}, m = "handleCall")
/* loaded from: classes3.dex */
final class HttpRedirect$Plugin$handleCall$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpRedirect.Plugin f49558a;

    /* renamed from: b, reason: collision with root package name */
    public Sender f49559b;

    /* renamed from: c, reason: collision with root package name */
    public HttpRequestBuilder f49560c;

    /* renamed from: d, reason: collision with root package name */
    public HttpClient f49561d;

    /* renamed from: e, reason: collision with root package name */
    public Ref.ObjectRef f49562e;

    /* renamed from: f, reason: collision with root package name */
    public Ref.ObjectRef f49563f;

    /* renamed from: g, reason: collision with root package name */
    public URLProtocol f49564g;

    /* renamed from: h, reason: collision with root package name */
    public String f49565h;

    /* renamed from: i, reason: collision with root package name */
    public Ref.ObjectRef f49566i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f49567j;

    /* renamed from: k, reason: collision with root package name */
    public int f49568k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpRedirect$Plugin$handleCall$1(ContinuationImpl continuationImpl) {
        super(continuationImpl);
        HttpRedirect.Plugin plugin = HttpRedirect.f49555a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49567j = obj;
        this.f49568k |= Integer.MIN_VALUE;
        HttpRedirect.Plugin plugin = HttpRedirect.f49555a;
        return HttpRedirect.Plugin.c(null, null, null, null, this);
    }
}
