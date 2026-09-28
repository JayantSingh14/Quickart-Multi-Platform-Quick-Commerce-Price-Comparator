package io.ktor.client.plugins;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.util.AttributeKey;
import io.ktor.util.pipeline.InvalidPhaseException;
import io.ktor.util.pipeline.PipelinePhase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class BodyProgress {

    /* renamed from: a, reason: collision with root package name */
    public static final Plugin f49443a = new Plugin();

    /* renamed from: b, reason: collision with root package name */
    public static final AttributeKey f49444b = new AttributeKey("BodyProgress");

    @Metadata
    public static final class Plugin implements HttpClientPlugin<Unit, BodyProgress> {
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final void a(Object obj, HttpClient scope) throws InvalidPhaseException {
            BodyProgress plugin = (BodyProgress) obj;
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            Plugin plugin2 = BodyProgress.f49443a;
            plugin.getClass();
            PipelinePhase pipelinePhase = new PipelinePhase("ObservableContent");
            scope.f49262e.f(HttpRequestPipeline.f50020j, pipelinePhase);
            scope.f49262e.g(pipelinePhase, new BodyProgress$handle$1(3, null));
            scope.f49265h.g(HttpReceivePipeline.f50060i, new BodyProgress$handle$2(3, null));
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final Object b(Function1 block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new BodyProgress();
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public final AttributeKey getKey() {
            return BodyProgress.f49444b;
        }
    }
}
