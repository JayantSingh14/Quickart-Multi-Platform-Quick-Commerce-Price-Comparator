package io.ktor.client;

import io.ktor.client.engine.HttpClientEngineConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata
/* loaded from: classes.dex */
public final class HttpClientConfig$engineConfig$1<T> extends Lambda implements Function1<T, Unit> {

    /* renamed from: c, reason: collision with root package name */
    public static final HttpClientConfig$engineConfig$1 f49290c = new HttpClientConfig$engineConfig$1(1);

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        Intrinsics.checkNotNullParameter((HttpClientEngineConfig) obj, "$this$null");
        return Unit.f53572a;
    }
}
