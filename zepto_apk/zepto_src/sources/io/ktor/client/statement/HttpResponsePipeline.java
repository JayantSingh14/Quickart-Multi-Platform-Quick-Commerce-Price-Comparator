package io.ktor.client.statement;

import io.ktor.client.call.HttpClientCall;
import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class HttpResponsePipeline extends Pipeline<HttpResponseContainer, HttpClientCall> {

    /* renamed from: g, reason: collision with root package name */
    public static final PipelinePhase f50069g = new PipelinePhase("Receive");

    /* renamed from: h, reason: collision with root package name */
    public static final PipelinePhase f50070h = new PipelinePhase("Parse");

    /* renamed from: i, reason: collision with root package name */
    public static final PipelinePhase f50071i = new PipelinePhase("Transform");

    /* renamed from: j, reason: collision with root package name */
    public static final PipelinePhase f50072j = new PipelinePhase("State");

    /* renamed from: k, reason: collision with root package name */
    public static final PipelinePhase f50073k = new PipelinePhase("After");

    /* renamed from: f, reason: collision with root package name */
    public final boolean f50074f;

    @Metadata
    public static final class Phases {
    }

    public HttpResponsePipeline() {
        this(false);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean d() {
        return this.f50074f;
    }

    public HttpResponsePipeline(boolean z) {
        super(f50069g, f50070h, f50071i, f50072j, f50073k);
        this.f50074f = z;
    }
}
