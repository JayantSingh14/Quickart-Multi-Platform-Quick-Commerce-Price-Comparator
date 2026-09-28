package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import io.ktor.client.request.HttpRequestBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
public final class HttpRequestRetry$Configuration$modifyRequest$1 extends Lambda implements Function2<HttpRequestRetry.ModifyRequestContext, HttpRequestBuilder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpRequestRetry$Configuration$modifyRequest$1 f49601c = new HttpRequestRetry$Configuration$modifyRequest$1(2);

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        HttpRequestBuilder it = (HttpRequestBuilder) obj2;
        Intrinsics.checkNotNullParameter((HttpRequestRetry.ModifyRequestContext) obj, "$this$null");
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f53572a;
    }
}
