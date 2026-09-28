package androidx.work.impl.utils.taskexecutor;

import androidx.annotation.RestrictTo;
import androidx.work.impl.utils.SerialExecutorImpl;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.ExecutorsKt;

@RestrictTo
/* loaded from: classes.dex */
public interface TaskExecutor {
    default ExecutorCoroutineDispatcherImpl a() {
        return ExecutorsKt.a(b());
    }

    SerialExecutorImpl b();

    default void c(Runnable runnable) {
        b().execute(runnable);
    }
}
