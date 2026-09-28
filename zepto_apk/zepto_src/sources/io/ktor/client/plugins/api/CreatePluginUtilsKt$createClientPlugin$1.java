package io.ktor.client.plugins.api;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class CreatePluginUtilsKt$createClientPlugin$1 implements ClientPlugin<Object> {
    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final void a(Object obj, HttpClient scope) {
        ClientPluginInstance plugin = (ClientPluginInstance) obj;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(scope, "scope");
        plugin.getClass();
        Intrinsics.checkNotNullParameter(scope, "scope");
        throw null;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final Object b(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        throw null;
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final AttributeKey getKey() {
        return null;
    }
}
