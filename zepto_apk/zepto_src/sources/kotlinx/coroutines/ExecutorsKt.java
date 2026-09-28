package kotlinx.coroutines;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata
/* loaded from: classes.dex */
public final class ExecutorsKt {
    public static final ExecutorCoroutineDispatcherImpl a(Executor executor) {
        boolean z = executor instanceof DispatcherExecutor;
        return new ExecutorCoroutineDispatcherImpl(executor);
    }
}
