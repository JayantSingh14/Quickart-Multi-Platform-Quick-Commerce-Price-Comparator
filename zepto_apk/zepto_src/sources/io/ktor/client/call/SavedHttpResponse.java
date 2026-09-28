package io.ktor.client.call;

import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteBufferChannel;
import io.ktor.utils.io.ByteChannelCtorKt;
import io.ktor.utils.io.ByteReadChannel;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobKt;

@Metadata
/* loaded from: classes.dex */
public final class SavedHttpResponse extends HttpResponse {

    /* renamed from: a, reason: collision with root package name */
    public final SavedHttpCall f49320a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpStatusCode f49321b;

    /* renamed from: c, reason: collision with root package name */
    public final HttpProtocolVersion f49322c;

    /* renamed from: d, reason: collision with root package name */
    public final GMTDate f49323d;

    /* renamed from: e, reason: collision with root package name */
    public final GMTDate f49324e;

    /* renamed from: f, reason: collision with root package name */
    public final Headers f49325f;

    /* renamed from: g, reason: collision with root package name */
    public final CoroutineContext f49326g;

    /* renamed from: h, reason: collision with root package name */
    public final ByteBufferChannel f49327h;

    public SavedHttpResponse(SavedHttpCall call, byte[] body, HttpResponse origin) {
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(origin, "origin");
        this.f49320a = call;
        JobImpl jobImplA = JobKt.a();
        this.f49321b = origin.e();
        this.f49322c = origin.f();
        this.f49323d = origin.c();
        this.f49324e = origin.d();
        this.f49325f = origin.getHeaders();
        this.f49326g = origin.r().plus(jobImplA);
        this.f49327h = ByteChannelCtorKt.a(body);
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final ByteReadChannel a() {
        return this.f49327h;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate c() {
        return this.f49323d;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final GMTDate d() {
        return this.f49324e;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpStatusCode e() {
        return this.f49321b;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpProtocolVersion f() {
        return this.f49322c;
    }

    @Override // io.ktor.http.HttpMessage
    public final Headers getHeaders() {
        return this.f49325f;
    }

    @Override // io.ktor.client.statement.HttpResponse
    public final HttpClientCall o1() {
        return this.f49320a;
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public final CoroutineContext r() {
        return this.f49326g;
    }
}
