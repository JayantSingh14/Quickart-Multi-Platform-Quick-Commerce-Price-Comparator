package io.ktor.client.plugins.cache;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestData;
import io.ktor.http.Headers;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
final class RequestForCache implements HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    public final HttpMethod f49741a;

    /* renamed from: b, reason: collision with root package name */
    public final Url f49742b;

    /* renamed from: c, reason: collision with root package name */
    public final Attributes f49743c;

    /* renamed from: d, reason: collision with root package name */
    public final OutgoingContent f49744d;

    /* renamed from: e, reason: collision with root package name */
    public final Headers f49745e;

    public RequestForCache(HttpRequestData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.f49741a = data.f50011b;
        this.f49742b = data.f50010a;
        this.f49743c = data.f50015f;
        this.f49744d = data.f50013d;
        this.f49745e = data.f50012c;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Url N() {
        return this.f49742b;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.f49745e;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes j1() {
        return this.f49743c;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpMethod l() {
        return this.f49741a;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final OutgoingContent l1() {
        return this.f49744d;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpClientCall o1() {
        throw new IllegalStateException("This request has no call");
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        o1();
        throw null;
    }
}
