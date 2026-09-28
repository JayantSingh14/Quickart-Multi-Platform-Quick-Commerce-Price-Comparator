package io.ktor.client.request;

import io.ktor.client.call.HttpClientCall;
import io.ktor.http.Headers;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import io.ktor.util.InternalAPI;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@InternalAPI
@Metadata
/* loaded from: classes.dex */
public class DefaultHttpRequest implements HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    public final HttpClientCall f49997a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpMethod f49998b;

    /* renamed from: c, reason: collision with root package name */
    public final Url f49999c;

    /* renamed from: d, reason: collision with root package name */
    public final OutgoingContent f50000d;

    /* renamed from: e, reason: collision with root package name */
    public final HeadersImpl f50001e;

    /* renamed from: f, reason: collision with root package name */
    public final Attributes f50002f;

    public DefaultHttpRequest(HttpClientCall call, HttpRequestData data) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(data, "data");
        this.f49997a = call;
        this.f49998b = data.f50011b;
        this.f49999c = data.f50010a;
        this.f50000d = data.f50013d;
        this.f50001e = data.f50012c;
        this.f50002f = data.f50015f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Url N() {
        return this.f49999c;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.f50001e;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes j1() {
        return this.f50002f;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpMethod l() {
        return this.f49998b;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final OutgoingContent l1() {
        return this.f50000d;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpClientCall o1() {
        return this.f49997a;
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49997a.r();
    }
}
