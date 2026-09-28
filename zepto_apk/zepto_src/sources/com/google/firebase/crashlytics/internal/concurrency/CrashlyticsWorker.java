package com.google.firebase.crashlytics.internal.concurrency;

import androidx.work.impl.c;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class CrashlyticsWorker implements Executor {

    /* renamed from: a, reason: collision with root package name */
    public final ExecutorService f43870a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f43871b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public Task f43872c = Tasks.e(null);

    public CrashlyticsWorker(ExecutorService executorService) {
        this.f43870a = executorService;
    }

    public final Task a(Runnable runnable) {
        Task taskJ;
        synchronized (this.f43871b) {
            taskJ = this.f43872c.j(this.f43870a, new c(runnable, 3));
            this.f43872c = taskJ;
        }
        return taskJ;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f43870a.execute(runnable);
    }
}
