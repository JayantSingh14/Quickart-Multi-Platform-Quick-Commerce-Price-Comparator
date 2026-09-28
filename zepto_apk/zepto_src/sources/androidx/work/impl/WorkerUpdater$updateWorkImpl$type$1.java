package androidx.work.impl;

import androidx.work.impl.model.WorkSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata
/* loaded from: classes3.dex */
final class WorkerUpdater$updateWorkImpl$type$1 extends Lambda implements Function1<WorkSpec, String> {
    static {
        new WorkerUpdater$updateWorkImpl$type$1(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WorkSpec spec = (WorkSpec) obj;
        Intrinsics.checkNotNullParameter(spec, "spec");
        return spec.c() ? "Periodic" : "OneTime";
    }
}
