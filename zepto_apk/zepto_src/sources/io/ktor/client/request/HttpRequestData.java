package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapabilityKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpMethod;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.Attributes;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptySet;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes.dex */
public final class HttpRequestData {

    /* renamed from: a, reason: collision with root package name */
    public final Url f50010a;

    /* renamed from: b, reason: collision with root package name */
    public final HttpMethod f50011b;

    /* renamed from: c, reason: collision with root package name */
    public final HeadersImpl f50012c;

    /* renamed from: d, reason: collision with root package name */
    public final OutgoingContent f50013d;

    /* renamed from: e, reason: collision with root package name */
    public final Job f50014e;

    /* renamed from: f, reason: collision with root package name */
    public final Attributes f50015f;

    /* renamed from: g, reason: collision with root package name */
    public final Set f50016g;

    public HttpRequestData(Url url, HttpMethod method, HeadersImpl headers, OutgoingContent body, Job executionContext, Attributes attributes) {
        Set setKeySet;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(executionContext, "executionContext");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.f50010a = url;
        this.f50011b = method;
        this.f50012c = headers;
        this.f50013d = body;
        this.f50014e = executionContext;
        this.f50015f = attributes;
        Map map = (Map) attributes.f(HttpClientEngineCapabilityKt.f49353a);
        this.f50016g = (map == null || (setKeySet = map.keySet()) == null) ? EmptySet.f53611a : setKeySet;
    }

    public final Object a() {
        HttpTimeout.Plugin key = HttpTimeout.f49642d;
        Intrinsics.checkNotNullParameter(key, "key");
        Map map = (Map) this.f50015f.f(HttpClientEngineCapabilityKt.f49353a);
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public final String toString() {
        return "HttpRequestData(url=" + this.f50010a + ", method=" + this.f50011b + ')';
    }
}
