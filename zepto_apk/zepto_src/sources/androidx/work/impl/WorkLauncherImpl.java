package androidx.work.impl;

import androidx.work.WorkerParameters;
import androidx.work.impl.utils.StartWorkRunnable;
import androidx.work.impl.utils.StopWorkRunnable;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class WorkLauncherImpl implements WorkLauncher {

    /* renamed from: a, reason: collision with root package name */
    public final Processor f12648a;

    /* renamed from: b, reason: collision with root package name */
    public final TaskExecutor f12649b;

    public WorkLauncherImpl(Processor processor, TaskExecutor workTaskExecutor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        Intrinsics.checkNotNullParameter(workTaskExecutor, "workTaskExecutor");
        this.f12648a = processor;
        this.f12649b = workTaskExecutor;
    }

    @Override // androidx.work.impl.WorkLauncher
    public final void a(StartStopToken workSpecId, WorkerParameters.RuntimeExtras runtimeExtras) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f12649b.c(new StartWorkRunnable(this.f12648a, workSpecId, runtimeExtras));
    }

    @Override // androidx.work.impl.WorkLauncher
    public final void c(StartStopToken workSpecId, int i2) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        this.f12649b.c(new StopWorkRunnable(this.f12648a, workSpecId, false, i2));
    }
}
