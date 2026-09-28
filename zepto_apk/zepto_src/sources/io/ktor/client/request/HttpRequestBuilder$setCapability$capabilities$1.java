package io.ktor.client.request;

import io.ktor.client.engine.HttpClientEngineCapability;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class HttpRequestBuilder$setCapability$capabilities$1 extends Lambda implements Function0<Map<HttpClientEngineCapability<?>, Object>> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpRequestBuilder$setCapability$capabilities$1 f50009c = new HttpRequestBuilder$setCapability$capabilities$1(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new LinkedHashMap();
    }
}
