package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineFactory;
import java.util.List;
import java.util.ServiceLoader;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class HttpClientJvmKt {

    /* renamed from: a, reason: collision with root package name */
    public static final List f49296a;

    /* renamed from: b, reason: collision with root package name */
    public static final HttpClientEngineFactory f49297b = null;

    static {
        ServiceLoader serviceLoaderLoad = ServiceLoader.load(HttpClientEngineContainer.class, HttpClientEngineContainer.class.getClassLoader());
        Intrinsics.checkNotNullExpressionValue(serviceLoaderLoad, "load(it, it.classLoader)");
        List listE0 = CollectionsKt.e0(serviceLoaderLoad);
        f49296a = listE0;
        HttpClientEngineContainer httpClientEngineContainer = (HttpClientEngineContainer) CollectionsKt.firstOrNull(listE0);
        if (httpClientEngineContainer == null || httpClientEngineContainer.a() == null) {
            throw new IllegalStateException("Failed to find HTTP client engine implementation in the classpath: consider adding client engine dependency. See https://ktor.io/docs/http-client-engines.html");
        }
    }
}
