package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes3.dex */
final class OkHttpConfig$addNetworkInterceptor$1 extends Lambda implements Function1<OkHttpClient.Builder, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        OkHttpClient.Builder config = (OkHttpClient.Builder) obj;
        Intrinsics.checkNotNullParameter(config, "$this$config");
        config.getClass();
        Intrinsics.checkNotNullParameter(null, "interceptor");
        config.f56313d.add(null);
        throw null;
    }
}
