package io.ktor.client.plugins.cache.storage;

import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.date.GMTDate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class CachedResponseData {

    /* renamed from: a, reason: collision with root package name */
    public final Url f49754a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpStatusCode f49755b;

    /* renamed from: c, reason: collision with root package name */
    public final GMTDate f49756c;

    /* renamed from: d, reason: collision with root package name */
    public final GMTDate f49757d;

    /* renamed from: e, reason: collision with root package name */
    public final HttpProtocolVersion f49758e;

    /* renamed from: f, reason: collision with root package name */
    public final GMTDate f49759f;

    /* renamed from: g, reason: collision with root package name */
    public final Headers f49760g;

    /* renamed from: h, reason: collision with root package name */
    public final Map f49761h;

    /* renamed from: i, reason: collision with root package name */
    public final byte[] f49762i;

    public CachedResponseData(Url url, HttpStatusCode statusCode, GMTDate requestTime, GMTDate responseTime, HttpProtocolVersion version, GMTDate expires, Headers headers, Map varyKeys, byte[] body) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(statusCode, "statusCode");
        Intrinsics.checkNotNullParameter(requestTime, "requestTime");
        Intrinsics.checkNotNullParameter(responseTime, "responseTime");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(expires, "expires");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(varyKeys, "varyKeys");
        Intrinsics.checkNotNullParameter(body, "body");
        this.f49754a = url;
        this.f49755b = statusCode;
        this.f49756c = requestTime;
        this.f49757d = responseTime;
        this.f49758e = version;
        this.f49759f = expires;
        this.f49760g = headers;
        this.f49761h = varyKeys;
        this.f49762i = body;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CachedResponseData)) {
            return false;
        }
        CachedResponseData cachedResponseData = (CachedResponseData) obj;
        return Intrinsics.b(this.f49754a, cachedResponseData.f49754a) && Intrinsics.b(this.f49761h, cachedResponseData.f49761h);
    }

    public final int hashCode() {
        return this.f49761h.hashCode() + (this.f49754a.f50268i.hashCode() * 31);
    }
}
