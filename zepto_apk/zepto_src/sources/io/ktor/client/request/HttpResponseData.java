package io.ktor.client.request;

import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpResponseData {

    /* renamed from: a, reason: collision with root package name */
    public final HttpStatusCode f50023a;

    /* renamed from: b, reason: collision with root package name */
    public final GMTDate f50024b;

    /* renamed from: c, reason: collision with root package name */
    public final Headers f50025c;

    /* renamed from: d, reason: collision with root package name */
    public final HttpProtocolVersion f50026d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f50027e;

    /* renamed from: f, reason: collision with root package name */
    public final CoroutineContext f50028f;

    /* renamed from: g, reason: collision with root package name */
    public final GMTDate f50029g;

    public HttpResponseData(HttpStatusCode statusCode, GMTDate requestTime, Headers headers, HttpProtocolVersion version, Object body, CoroutineContext callContext) {
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        this.f50023a = statusCode;
        this.f50024b = requestTime;
        this.f50025c = headers;
        this.f50026d = version;
        this.f50027e = body;
        this.f50028f = callContext;
        this.f50029g = DateJvmKt.b(null);
    }

    public final String toString() {
        return "HttpResponseData=(statusCode=" + this.f50023a + ')';
    }
}
