package io.ktor.client.statement;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata
/* loaded from: classes.dex */
public final class HttpReceivePipeline extends Pipeline<HttpResponse, Unit> {

    /* renamed from: g, reason: collision with root package name */
    public static final PipelinePhase f50058g = new PipelinePhase("Before");

    /* renamed from: h, reason: collision with root package name */
    public static final PipelinePhase f50059h = new PipelinePhase("State");

    /* renamed from: i, reason: collision with root package name */
    public static final PipelinePhase f50060i = new PipelinePhase("After");

    /* renamed from: f, reason: collision with root package name */
    public final boolean f50061f;

    @Metadata
    public static final class Phases {
    }

    public HttpReceivePipeline() {
        this(false);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean d() {
        return this.f50061f;
    }

    public HttpReceivePipeline(boolean z) {
        super(f50058g, f50059h, f50060i);
        this.f50061f = z;
    }
}
