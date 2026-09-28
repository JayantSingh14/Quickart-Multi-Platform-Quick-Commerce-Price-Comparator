package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpResponsePipeline;
import io.ktor.util.logging.KtorSimpleLoggerJvmKt;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.slf4j.Logger;

@Metadata
/* loaded from: classes.dex */
public final class DefaultTransformKt {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f49470a = KtorSimpleLoggerJvmKt.a("io.ktor.client.plugins.defaultTransformers");

    public static final void a(HttpClient httpClient) {
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpClient.f49262e.g(HttpRequestPipeline.f50020j, new DefaultTransformKt$defaultTransformers$1(3, null));
        PipelinePhase pipelinePhase = HttpResponsePipeline.f50070h;
        DefaultTransformKt$defaultTransformers$2 defaultTransformKt$defaultTransformers$2 = new DefaultTransformKt$defaultTransformers$2(3, null);
        HttpResponsePipeline httpResponsePipeline = httpClient.f49263f;
        httpResponsePipeline.g(pipelinePhase, defaultTransformKt$defaultTransformers$2);
        Intrinsics.checkNotNullParameter(httpClient, "<this>");
        httpResponsePipeline.g(pipelinePhase, new DefaultTransformersJvmKt$platformResponseDefaultTransformers$1(3, null));
    }
}
