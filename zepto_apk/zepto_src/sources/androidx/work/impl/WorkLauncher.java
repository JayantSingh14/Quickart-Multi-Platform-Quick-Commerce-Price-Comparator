package androidx.work.impl;

import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public interface WorkLauncher {
    void a(StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras);

    default void b(StartStopToken workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        a(workSpecId, null);
    }

    void c(StartStopToken startStopToken, int i2);

    default void d(StartStopToken workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        c(workSpecId, -512);
    }
}
