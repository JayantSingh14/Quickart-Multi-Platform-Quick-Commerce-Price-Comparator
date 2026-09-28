package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class HttpSendPipeline extends Pipeline<Object, HttpRequestBuilder> {

    /* renamed from: g, reason: collision with root package name */
    public static final PipelinePhase f50030g = new PipelinePhase("Before");

    /* renamed from: h, reason: collision with root package name */
    public static final PipelinePhase f50031h = new PipelinePhase("State");

    /* renamed from: i, reason: collision with root package name */
    public static final PipelinePhase f50032i = new PipelinePhase("Monitoring");

    /* renamed from: j, reason: collision with root package name */
    public static final PipelinePhase f50033j = new PipelinePhase("Engine");

    /* renamed from: k, reason: collision with root package name */
    public static final PipelinePhase f50034k = new PipelinePhase("Receive");

    /* renamed from: f, reason: collision with root package name */
    public final boolean f50035f;

    @Metadata
    public static final class Phases {
    }

    public HttpSendPipeline() {
        this(false);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean d() {
        return this.f50035f;
    }

    public HttpSendPipeline(boolean z) {
        super(f50030g, f50031h, f50032i, f50033j, f50034k);
        this.f50035f = z;
    }
}
