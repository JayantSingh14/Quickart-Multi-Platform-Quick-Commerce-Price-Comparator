package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import io.ktor.util.converters.DataConversion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes3.dex */
public final class DataConversion implements HttpClientPlugin<DataConversion.Configuration, io.ktor.util.converters.DataConversion> {

    /* renamed from: a, reason: collision with root package name */
    public static final AttributeKey f49454a = new AttributeKey("DataConversion");

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final void a(Object obj, HttpClient scope) {
        io.ktor.util.converters.DataConversion plugin = (io.ktor.util.converters.DataConversion) obj;
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        Intrinsics.checkNotNullParameter(scope, "scope");
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final Object b(Function1 block) {
        Intrinsics.checkNotNullParameter(block, "block");
        DataConversion.Configuration configuration = new DataConversion.Configuration();
        block.invoke(configuration);
        return new io.ktor.util.converters.DataConversion(configuration);
    }

    @Override // io.ktor.client.plugins.HttpClientPlugin
    public final AttributeKey getKey() {
        return f49454a;
    }
}
