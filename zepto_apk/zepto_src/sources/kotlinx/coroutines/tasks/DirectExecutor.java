package kotlinx.coroutines.tasks;

import java.util.concurrent.Executor;
import kotlin.Metadata;

@Metadata
/* loaded from: classes3.dex */
final class DirectExecutor implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public static final DirectExecutor f55262a = new DirectExecutor();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
