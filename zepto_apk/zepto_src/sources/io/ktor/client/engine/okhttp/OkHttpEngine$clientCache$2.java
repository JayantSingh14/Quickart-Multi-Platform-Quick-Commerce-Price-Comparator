package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes.dex */
final class OkHttpEngine$clientCache$2 extends Lambda implements Function1<OkHttpClient, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final OkHttpEngine$clientCache$2 f49381c = new OkHttpEngine$clientCache$2(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        OkHttpClient it = (OkHttpClient) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f53572a;
    }
}
