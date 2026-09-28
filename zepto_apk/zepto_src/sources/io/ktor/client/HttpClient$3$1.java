package io.ktor.client;

import io.ktor.client.plugins.DefaultTransformKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes.dex */
final class HttpClient$3$1 extends Lambda implements Function1<HttpClient, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpClient$3$1 f49274c = new HttpClient$3$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        HttpClient install = (HttpClient) obj;
        Intrinsics.checkNotNullParameter(install, "$this$install");
        DefaultTransformKt.a(install);
        return Unit.f53572a;
    }
}
