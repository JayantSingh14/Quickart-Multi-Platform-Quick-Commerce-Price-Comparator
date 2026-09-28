package io.ktor.client.engine.okhttp;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;

@Metadata
/* loaded from: classes.dex */
public final class OkHttpEngine$Companion$okHttpClientPrototype$2 extends Lambda implements Function0<OkHttpClient> {

    /* renamed from: c, reason: collision with root package name */
    public static final OkHttpEngine$Companion$okHttpClientPrototype$2 f49380c = new OkHttpEngine$Companion$okHttpClientPrototype$2(0);

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return new OkHttpClient(new OkHttpClient.Builder());
    }
}
