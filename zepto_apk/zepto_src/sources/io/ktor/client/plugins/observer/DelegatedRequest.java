package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
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
public final class DelegatedRequest implements HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    public final DelegatedCall f49945a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ HttpRequest f49946b;

    public DelegatedRequest(DelegatedCall call, HttpRequest origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f49945a = call;
        this.f49946b = origin;
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Url N() {
        return this.f49946b.N();
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.f49946b.getHeaders();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final Attributes j1() {
        return this.f49946b.j1();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpMethod l() {
        return this.f49946b.l();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final OutgoingContent l1() {
        return this.f49946b.l1();
    }

    @Override // io.ktor.client.request.HttpRequest
    public final HttpClientCall o1() {
        return this.f49945a;
    }

    @Override // io.ktor.client.request.HttpRequest, kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49946b.r();
    }
}
