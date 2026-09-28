package io.ktor.client.request;

import io.ktor.util.pipeline.Pipeline;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class HttpRequestPipeline extends Pipeline<Object, HttpRequestBuilder> {

    /* renamed from: g, reason: collision with root package name */
    public static final PipelinePhase f50017g = new PipelinePhase("Before");

    /* renamed from: h, reason: collision with root package name */
    public static final PipelinePhase f50018h = new PipelinePhase("State");

    /* renamed from: i, reason: collision with root package name */
    public static final PipelinePhase f50019i = new PipelinePhase("Transform");

    /* renamed from: j, reason: collision with root package name */
    public static final PipelinePhase f50020j = new PipelinePhase("Render");

    /* renamed from: k, reason: collision with root package name */
    public static final PipelinePhase f50021k = new PipelinePhase("Send");

    /* renamed from: f, reason: collision with root package name */
    public final boolean f50022f;

    @Metadata
    public static final class Phases {
    }

    public HttpRequestPipeline() {
        this(false);
    }

    @Override // io.ktor.util.pipeline.Pipeline
    public final boolean d() {
        return this.f50022f;
    }

    public HttpRequestPipeline(boolean z) {
        super(f50017g, f50018h, f50019i, f50020j, f50021k);
        this.f50022f = z;
    }
}
