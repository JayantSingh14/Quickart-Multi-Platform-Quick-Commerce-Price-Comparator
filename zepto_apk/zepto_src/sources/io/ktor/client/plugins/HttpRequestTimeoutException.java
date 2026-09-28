package io.ktor.client.plugins;

import android.support.v4.media.b;
import com.google.ads.interactivemedia.v3.impl.data.zzck;
import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLBuilderKt;
import java.io.IOException;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HttpRequestTimeoutException extends IOException {
    public HttpRequestTimeoutException(HttpRequestBuilder request) {
        Intrinsics.checkNotNullParameter(request, "request");
        URLBuilder uRLBuilder = request.f50003a;
        uRLBuilder.a();
        StringBuilder sb = new StringBuilder(256);
        URLBuilderKt.a(uRLBuilder, sb);
        String url = sb.toString();
        Intrinsics.checkNotNullExpressionValue(url, "appendTo(StringBuilder(256)).toString()");
        HttpTimeout.Plugin key = HttpTimeout.f49642d;
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = (Map) request.f50008f.f(HttpClientEngineCapabilityKt.f49353a);
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) (map != null ? map.get(key) : null);
        Object obj = httpTimeoutCapabilityConfiguration != null ? httpTimeoutCapabilityConfiguration.f49647a : null;
        Intrinsics.checkNotNullParameter(url, "url");
        StringBuilder sb2 = new StringBuilder("Request timeout has expired [url=");
        sb2.append(url);
        sb2.append(", request_timeout=");
        super(b.q(sb2, obj == null ? zzck.UNKNOWN_CONTENT_TYPE : obj, " ms]"));
    }
}
