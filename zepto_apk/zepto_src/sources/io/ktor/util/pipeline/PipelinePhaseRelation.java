package io.ktor.util.pipeline;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public abstract class PipelinePhaseRelation {

    @Metadata
    public static final class After extends PipelinePhaseRelation {

        /* renamed from: a, reason: collision with root package name */
        public final PipelinePhase f50591a;

        public After(PipelinePhase relativeTo) {
            Intrinsics.checkNotNullParameter(relativeTo, "relativeTo");
            this.f50591a = relativeTo;
        }
    }

    @Metadata
    public static final class Before extends PipelinePhaseRelation {
    }

    @Metadata
    public static final class Last extends PipelinePhaseRelation {

        /* renamed from: a, reason: collision with root package name */
        public static final Last f50592a = new Last();
    }
}
