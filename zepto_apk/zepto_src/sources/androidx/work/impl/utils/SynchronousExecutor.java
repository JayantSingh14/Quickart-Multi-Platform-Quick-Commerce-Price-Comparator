package androidx.work.impl.utils;

import androidx.annotation.RestrictTo;
import java.util.concurrent.Executor;

@RestrictTo
/* loaded from: classes3.dex */
public class SynchronousExecutor implements Executor {
    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
