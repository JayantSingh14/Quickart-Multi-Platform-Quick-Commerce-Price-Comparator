package io.ktor.util.pipeline;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class PhaseContent<TSubject, Call> {

    /* renamed from: e, reason: collision with root package name */
    public static final ArrayList f50577e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    public final PipelinePhase f50578a;

    /* renamed from: b, reason: collision with root package name */
    public final PipelinePhaseRelation f50579b;

    /* renamed from: c, reason: collision with root package name */
    public List f50580c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f50581d;

    @Metadata
    public static final class Companion {
    }

    public PhaseContent(PipelinePhase phase, PipelinePhaseRelation relation) {
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        ArrayList interceptors = f50577e;
        Intrinsics.d(interceptors, "null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Function3<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent>, TSubject of io.ktor.util.pipeline.PhaseContent, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptorFunction<TSubject of io.ktor.util.pipeline.PhaseContent, Call of io.ktor.util.pipeline.PhaseContent> }>");
        if ((interceptors instanceof KMappedMarker) && !(interceptors instanceof KMutableList)) {
            TypeIntrinsics.d(interceptors, "kotlin.collections.MutableList");
            throw null;
        }
        Intrinsics.checkNotNullParameter(phase, "phase");
        Intrinsics.checkNotNullParameter(relation, "relation");
        Intrinsics.checkNotNullParameter(interceptors, "interceptors");
        this.f50578a = phase;
        this.f50579b = relation;
        this.f50580c = interceptors;
        this.f50581d = true;
        if (!interceptors.isEmpty()) {
            throw new IllegalStateException("The shared empty array list has been modified");
        }
    }

    public final void a(Function3 interceptor) {
        Intrinsics.checkNotNullParameter(interceptor, "interceptor");
        if (this.f50581d) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f50580c);
            this.f50580c = arrayList;
            this.f50581d = false;
        }
        this.f50580c.add(interceptor);
    }

    public final String toString() {
        return "Phase `" + this.f50578a.f50590a + "`, " + this.f50580c.size() + " handlers";
    }
}
