package io.ktor.client.plugins.observer;

import io.ktor.client.call.HttpClientCall;
import io.ktor.client.statement.HttpResponse;
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
/* loaded from: classes3.dex */
public final class DelegatedResponse extends HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    public final DelegatedCall f49947a;

    /* renamed from: b, reason: collision with root package name */
    public final ByteReadChannel f49948b;

    /* renamed from: c, reason: collision with root package name */
    public final HttpResponse f49949c;

    /* renamed from: d, reason: collision with root package name */
    public final CoroutineContext f49950d;

    public DelegatedResponse(DelegatedCall call, ByteReadChannel content, HttpResponse origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f49947a = call;
        this.f49948b = content;
        this.f49949c = origin;
        this.f49950d = origin.r();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final ByteReadChannel a() {
        return this.f49948b;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate c() {
        return this.f49949c.c();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate d() {
        return this.f49949c.d();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpStatusCode e() {
        return this.f49949c.e();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpProtocolVersion f() {
        return this.f49949c.f();
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.f49949c.getHeaders();
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpClientCall o1() {
        return this.f49947a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49950d;
    }
}
