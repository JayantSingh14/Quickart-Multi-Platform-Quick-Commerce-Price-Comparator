package io.ktor.client.plugins.cookies;

import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.xbill.DNS.Type;

@Metadata
@DebugMetadata(c = "io.ktor.client.plugins.cookies.HttpCookies", f = "HttpCookies.kt", l = {Type.CDS}, m = "sendCookiesWith$ktor_client_core")
/* loaded from: classes3.dex */
final class HttpCookies$sendCookiesWith$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public HttpRequestBuilder f49935a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f49936b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ HttpCookies f49937c;

    /* renamed from: d, reason: collision with root package name */
    public int f49938d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpCookies$sendCookiesWith$1(HttpCookies httpCookies, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.f49937c = httpCookies;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f49936b = obj;
        this.f49938d |= Integer.MIN_VALUE;
        return this.f49937c.e(null, this);
    }
}
