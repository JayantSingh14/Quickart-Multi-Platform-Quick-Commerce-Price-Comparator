package com.google.firebase.crashlytics.internal.concurrency;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class CrashlyticsTasks {

    /* renamed from: a, reason: collision with root package name */
    public static final androidx.arch.core.executor.a f43869a = new androidx.arch.core.executor.a(1);

    public static Task a(Task task, Task task2) {
        final CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.f39749a);
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Continuation continuation = new Continuation() { // from class: com.google.firebase.crashlytics.internal.concurrency.a
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                boolean zP = task3.p();
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (zP) {
                    taskCompletionSource2.d(task3.l());
                } else if (task3.k() != null) {
                    taskCompletionSource2.c(task3.k());
                } else if (atomicBoolean.getAndSet(true)) {
                    cancellationTokenSource.a();
                }
                return Tasks.e(null);
            }
        };
        androidx.arch.core.executor.a aVar = f43869a;
        task.j(aVar, continuation);
        task2.j(aVar, continuation);
        return taskCompletionSource.f39750a;
    }
}
