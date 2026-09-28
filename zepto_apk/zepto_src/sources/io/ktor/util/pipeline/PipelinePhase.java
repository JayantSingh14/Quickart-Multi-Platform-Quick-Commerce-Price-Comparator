package io.ktor.util.pipeline;

import android.support.v4.media.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class PipelinePhase {

    /* renamed from: a, reason: collision with root package name */
    public final String f50590a;

    public PipelinePhase(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f50590a = name;
    }

    public final String toString() {
        return b.r(new StringBuilder("Phase('"), this.f50590a, "')");
    }
}
