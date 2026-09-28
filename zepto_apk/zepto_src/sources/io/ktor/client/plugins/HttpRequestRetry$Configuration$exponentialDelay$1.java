package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpRequestRetry;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.random.Random;
import org.apache.commons.lang3.time.DateUtils;

@Metadata
/* loaded from: classes3.dex */
final class HttpRequestRetry$Configuration$exponentialDelay$1 extends Lambda implements Function2<HttpRequestRetry.DelayContext, Integer, Long> {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        HttpRequestRetry.DelayContext delayMillis = (HttpRequestRetry.DelayContext) obj;
        int iIntValue = ((Number) obj2).intValue();
        Intrinsics.checkNotNullParameter(delayMillis, "$this$delayMillis");
        long jMin = Math.min(((long) Math.pow(2.0d, iIntValue)) * 1000, DateUtils.MILLIS_PER_MINUTE);
        Random.f53818a.getClass();
        return Long.valueOf(Random.f53819b.h(1000L) + jMin);
    }
}
