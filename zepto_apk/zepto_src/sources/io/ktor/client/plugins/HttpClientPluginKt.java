package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.Attributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class HttpClientPluginKt {

    /* renamed from: a, reason: collision with root package name */
    public static final AttributeKey f49537a = new AttributeKey("ApplicationPluginRegistry");

    public static final Object a(HttpClient httpClient, HttpClientPlugin plugin) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Object objB = b(httpClient, plugin);
        if (objB != null) {
            return objB;
        }
        throw new IllegalStateException("Plugin " + plugin + " is not installed. Consider using `install(" + plugin.getKey() + ")` in client config first.");
    }

    public static final Object b(HttpClient httpClient, HttpClientPlugin plugin) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Attributes attributes = (Attributes) httpClient.f49266i.f(f49537a);
        if (attributes != null) {
            return attributes.f(plugin.getKey());
        }
        return null;
    }
}
