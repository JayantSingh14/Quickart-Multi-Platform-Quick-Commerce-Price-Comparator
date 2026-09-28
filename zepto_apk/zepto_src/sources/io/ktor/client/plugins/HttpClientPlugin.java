package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.util.AttributeKey;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata
/* loaded from: classes.dex */
public interface HttpClientPlugin<TConfig, TPlugin> {

    @Metadata
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    void a(Object obj, HttpClient httpClient);

    Object b(Function1 function1);

    AttributeKey getKey();
}
