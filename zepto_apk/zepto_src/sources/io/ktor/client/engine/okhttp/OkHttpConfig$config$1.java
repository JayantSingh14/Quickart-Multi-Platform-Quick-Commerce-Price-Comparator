package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes.dex */
public final class OkHttpConfig$config$1 extends Lambda implements Function1<OkHttpClient.Builder, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final OkHttpConfig$config$1 f49371c = new OkHttpConfig$config$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        OkHttpClient.Builder builder = (OkHttpClient.Builder) obj;
        Intrinsics.checkNotNullParameter(builder, "$this$null");
        builder.f56317h = false;
        builder.f56318i = false;
        builder.f56315f = true;
        return Unit.f53572a;
    }
}
