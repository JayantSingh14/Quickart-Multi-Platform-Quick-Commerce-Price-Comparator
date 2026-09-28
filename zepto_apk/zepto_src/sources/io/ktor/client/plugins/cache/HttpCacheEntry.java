package io.ktor.client.plugins.cache;

import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.statement.HttpResponse;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class HttpCacheEntry {

    /* renamed from: a, reason: collision with root package name */
    public final Map f49725a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpResponse f49726b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f49727c;

    public HttpCacheEntry(GMTDate expires, Map varyKeys, HttpResponse response, byte[] body) {
        Intrinsics.checkNotNullParameter(expires, "expires");
        Intrinsics.checkNotNullParameter(varyKeys, "varyKeys");
        Intrinsics.checkNotNullParameter(response, "response");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f49725a = varyKeys;
        this.f49726b = response;
        this.f49727c = body;
        Headers.Companion companion = Headers.f50200a;
        HeadersBuilder headersBuilder = new HeadersBuilder(true);
        headersBuilder.e(response.getHeaders());
        headersBuilder.l();
    }

    public final HttpResponse a() {
        HttpResponse httpResponse = this.f49726b;
        return new SavedHttpCall(httpResponse.o1().f49302a, httpResponse.o1().d(), httpResponse, this.f49727c).e();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof HttpCacheEntry)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return Intrinsics.b(this.f49725a, ((HttpCacheEntry) obj).f49725a);
    }

    public final int hashCode() {
        return this.f49725a.hashCode();
    }
}
