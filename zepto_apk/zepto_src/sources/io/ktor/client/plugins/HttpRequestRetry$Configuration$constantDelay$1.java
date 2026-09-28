package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class HttpRequestRetry$Configuration$constantDelay$1 extends Lambda implements Function2<HttpRequestRetry.DelayContext, Integer, Long> {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        HttpRequestRetry.DelayContext delayMillis = (HttpRequestRetry.DelayContext) obj;
        ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        throw null;
    }
}
