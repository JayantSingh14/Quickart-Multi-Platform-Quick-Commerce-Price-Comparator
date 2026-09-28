package io.ktor.client;

import io.ktor.client.engine.okhttp.OkHttp;
import io.ktor.client.engine.okhttp.OkHttpConfig;
import io.ktor.client.engine.okhttp.OkHttpEngine;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata
/* loaded from: classes.dex */
public final class HttpClientKt {
    /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object, kotlin.jvm.functions.Function1, kotlin.jvm.internal.Lambda] */
    public static final HttpClient a(Function1 block) {
        OkHttp engineFactory = OkHttp.f49365a;
        Intrinsics.checkNotNullParameter(engineFactory, "engineFactory");
        Intrinsics.checkNotNullParameter(block, "block");
        HttpClientConfig httpClientConfig = new HttpClientConfig();
        block.invoke(httpClientConfig);
        ?? block2 = httpClientConfig.f49284d;
        Intrinsics.checkNotNullParameter(block2, "block");
        OkHttpConfig okHttpConfig = new OkHttpConfig();
        block2.invoke(okHttpConfig);
        final OkHttpEngine okHttpEngine = new OkHttpEngine(okHttpConfig);
        HttpClient httpClient = new HttpClient(okHttpEngine, httpClientConfig);
        CoroutineContext.Element element = httpClient.f49261d.get(Job.Key.f54121a);
        Intrinsics.c(element);
        ((Job) element).j0(new Function1<Throwable, Unit>() { // from class: io.ktor.client.HttpClientKt$HttpClient$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) throws IOException {
                okHttpEngine.close();
                return Unit.f53572a;
            }
        });
        return httpClient;
    }
}
