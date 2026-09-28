package androidx.work.impl.utils;

import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import java.util.ArrayDeque;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class SerialExecutorImpl implements SerialExecutor {

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f12981b;

    /* renamed from: c, reason: collision with root package name */
    public Runnable f12982c;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayDeque f12980a = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    public final Object f12983d = new Object();

    public static class Task implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final SerialExecutorImpl f12984a;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f12985b;

        public Task(SerialExecutorImpl serialExecutorImpl, Runnable runnable) {
            this.f12984a = serialExecutorImpl;
            this.f12985b = runnable;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                this.f12985b.run();
                synchronized (this.f12984a.f12983d) {
                    this.f12984a.a();
                }
            } catch (Throwable th) {
                synchronized (this.f12984a.f12983d) {
                    this.f12984a.a();
                    throw th;
                }
            }
        }
    }

    public SerialExecutorImpl(ExecutorService executorService) {
        this.f12981b = executorService;
    }

    public final void a() {
        Runnable runnable = (Runnable) this.f12980a.poll();
        this.f12982c = runnable;
        if (runnable != null) {
            this.f12981b.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.f12983d) {
            try {
                this.f12980a.add(new Task(this, runnable));
                if (this.f12982c == null) {
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
