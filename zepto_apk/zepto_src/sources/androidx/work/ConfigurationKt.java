package androidx.work;

import android.support.v4.media.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: classes.dex */
public final class ConfigurationKt {
    public static final ExecutorService a(final boolean z) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactory() { // from class: androidx.work.ConfigurationKt$createDefaultExecutor$factory$1

            /* renamed from: a, reason: collision with root package name */
            public final AtomicInteger f12484a = new AtomicInteger(0);

            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Intrinsics.checkNotNullParameter(runnable, "runnable");
                StringBuilder sbW = b.w(z ? "WM.task-" : "androidx.work-");
                sbW.append(this.f12484a.incrementAndGet());
                return new Thread(runnable, sbW.toString());
            }
        });
        Intrinsics.checkNotNullExpressionValue(executorServiceNewFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return executorServiceNewFixedThreadPool;
    }
}
