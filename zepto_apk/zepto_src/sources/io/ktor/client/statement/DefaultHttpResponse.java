package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@InternalAPI
@Metadata
/* loaded from: classes.dex */
public final class DefaultHttpResponse extends HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    public final HttpClientCall f50050a;

    /* renamed from: b, reason: collision with root package name */
    public final CoroutineContext f50051b;

    /* renamed from: c, reason: collision with root package name */
    public final HttpStatusCode f50052c;

    /* renamed from: d, reason: collision with root package name */
    public final HttpProtocolVersion f50053d;

    /* renamed from: e, reason: collision with root package name */
    public final GMTDate f50054e;

    /* renamed from: f, reason: collision with root package name */
    public final GMTDate f50055f;

    /* renamed from: g, reason: collision with root package name */
    public final ByteReadChannel f50056g;

    /* renamed from: h, reason: collision with root package name */
    public final Headers f50057h;

    public DefaultHttpResponse(HttpClientCall call, HttpResponseData responseData) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(responseData, "responseData");
        this.f50050a = call;
        this.f50051b = responseData.f50028f;
        this.f50052c = responseData.f50023a;
        this.f50053d = responseData.f50026d;
        this.f50054e = responseData.f50024b;
        this.f50055f = responseData.f50029g;
        Object obj = responseData.f50027e;
        ByteReadChannel byteReadChannelA = obj instanceof ByteReadChannel ? (ByteReadChannel) obj : null;
        if (byteReadChannelA == null) {
            ByteReadChannel.f51074a.getClass();
            byteReadChannelA = ByteReadChannel.Companion.a();
        }
        this.f50056g = byteReadChannelA;
        this.f50057h = responseData.f50025c;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final ByteReadChannel a() {
        return this.f50056g;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate c() {
        return this.f50054e;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate d() {
        return this.f50055f;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpStatusCode e() {
        return this.f50052c;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpProtocolVersion f() {
        return this.f50053d;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.f50057h;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpClientCall o1() {
        return this.f50050a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f50051b;
    }
}
