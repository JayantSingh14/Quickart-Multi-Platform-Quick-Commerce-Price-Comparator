package androidx.work.impl.utils.taskexecutor;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutorImpl;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.ExecutorsKt;

@RestrictTo
/* loaded from: classes.dex */
public class WorkManagerTaskExecutor implements TaskExecutor {

    /* renamed from: a, reason: collision with root package name */
    public final SerialExecutorImpl f13061a;

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorCoroutineDispatcherImpl f13062b;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f13063c = new Handler(Looper.getMainLooper());

    /* renamed from: d, reason: collision with root package name */
    public final Executor f13064d = new Executor() { // from class: androidx.work.impl.utils.taskexecutor.WorkManagerTaskExecutor.1
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            WorkManagerTaskExecutor.this.f13063c.post(runnable);
        }
    };

    public WorkManagerTaskExecutor(ExecutorService executorService) {
        SerialExecutorImpl serialExecutorImpl = new SerialExecutorImpl(executorService);
        this.f13061a = serialExecutorImpl;
        this.f13062b = ExecutorsKt.a(serialExecutorImpl);
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public final ExecutorCoroutineDispatcherImpl a() {
        return this.f13062b;
    }

    @Override // androidx.work.impl.utils.taskexecutor.TaskExecutor
    public final SerialExecutorImpl b() {
        return this.f13061a;
    }
}
