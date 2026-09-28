package io.ktor.client.engine.okhttp;

import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes.dex */
final /* synthetic */ class OkHttpEngine$clientCache$1 extends FunctionReferenceImpl implements Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, OkHttpClient> {
    @Override // kotlin.jvm.functions.Function1
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public final OkHttpClient invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        OkHttpConfig okHttpConfig = ((OkHttpEngine) this.receiver).f49373d;
        OkHttpClient okHttpClient = okHttpConfig.f49369b;
        if (okHttpClient == null) {
            okHttpClient = (OkHttpClient) OkHttpEngine.f49372i.getValue();
        }
        OkHttpClient.Builder builderC = okHttpClient.c();
        Dispatcher dispatcher = new Dispatcher();
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        builderC.f56310a = dispatcher;
        ((OkHttpConfig$config$1) okHttpConfig.f49368a).invoke(builderC);
        if (httpTimeoutCapabilityConfiguration != null) {
            Long l2 = httpTimeoutCapabilityConfiguration.f49648b;
            if (l2 != null) {
                builderC.b(HttpTimeoutKt.d(l2.longValue()), TimeUnit.MILLISECONDS);
            }
            Long l3 = httpTimeoutCapabilityConfiguration.f49649c;
            if (l3 != null) {
                long jLongValue = l3.longValue();
                long jD = HttpTimeoutKt.d(jLongValue);
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                builderC.c(jD, timeUnit);
                builderC.d(HttpTimeoutKt.d(jLongValue), timeUnit);
            }
        }
        return new OkHttpClient(builderC);
    }
}
