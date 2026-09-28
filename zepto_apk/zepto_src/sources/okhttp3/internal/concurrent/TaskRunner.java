package okhttp3.internal.concurrent;

import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;
import okhttp3.internal.a;
import okhttp3.internal.concurrent.TaskRunner;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TaskRunner {

    /* renamed from: h, reason: collision with root package name */
    public static final TaskRunner f56473h;

    /* renamed from: i, reason: collision with root package name */
    public static final Logger f56474i;

    /* renamed from: a, reason: collision with root package name */
    public final RealBackend f56475a;

    /* renamed from: b, reason: collision with root package name */
    public int f56476b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56477c;

    /* renamed from: d, reason: collision with root package name */
    public long f56478d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f56479e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f56480f;

    /* renamed from: g, reason: collision with root package name */
    public final TaskRunner$runnable$1 f56481g;

    @Metadata
    public interface Backend {
    }

    @Metadata
    public static final class Companion {
    }

    @Metadata
    @SourceDebugExtension
    public static final class RealBackend implements Backend {

        /* renamed from: a, reason: collision with root package name */
        public final ThreadPoolExecutor f56482a;

        public RealBackend(a threadFactory) {
            Intrinsics.checkNotNullParameter(threadFactory, "threadFactory");
            this.f56482a = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        public final void a(TaskRunner$runnable$1 runnable) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.f56482a.execute(runnable);
        }
    }

    static {
        String name = Util.f56400g + " TaskRunner";
        Intrinsics.checkNotNullParameter(name, "name");
        f56473h = new TaskRunner(new RealBackend(new a(name, true)));
        Logger logger = Logger.getLogger(TaskRunner.class.getName());
        Intrinsics.checkNotNullExpressionValue(logger, "getLogger(TaskRunner::class.java.name)");
        f56474i = logger;
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [okhttp3.internal.concurrent.TaskRunner$runnable$1] */
    public TaskRunner(RealBackend backend) {
        Intrinsics.checkNotNullParameter(backend, "backend");
        this.f56475a = backend;
        this.f56476b = 10000;
        this.f56479e = new ArrayList();
        this.f56480f = new ArrayList();
        this.f56481g = new Runnable() { // from class: okhttp3.internal.concurrent.TaskRunner$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                Task taskC;
                long jNanoTime;
                while (true) {
                    TaskRunner taskRunner = this.f56483a;
                    synchronized (taskRunner) {
                        taskC = taskRunner.c();
                    }
                    if (taskC == null) {
                        return;
                    }
                    TaskQueue taskQueue = taskC.f56463c;
                    Intrinsics.c(taskQueue);
                    TaskRunner taskRunner2 = this.f56483a;
                    boolean zIsLoggable = TaskRunner.f56474i.isLoggable(Level.FINE);
                    if (zIsLoggable) {
                        TaskRunner.RealBackend realBackend = taskQueue.f56465a.f56475a;
                        jNanoTime = System.nanoTime();
                        TaskLoggerKt.a(taskC, taskQueue, "starting");
                    } else {
                        jNanoTime = -1;
                    }
                    try {
                        try {
                            TaskRunner.a(taskRunner2, taskC);
                            Unit unit = Unit.f53572a;
                            if (zIsLoggable) {
                                TaskRunner.RealBackend realBackend2 = taskQueue.f56465a.f56475a;
                                TaskLoggerKt.a(taskC, taskQueue, "finished run in ".concat(TaskLoggerKt.b(System.nanoTime() - jNanoTime)));
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        if (zIsLoggable) {
                            TaskRunner.RealBackend realBackend3 = taskQueue.f56465a.f56475a;
                            TaskLoggerKt.a(taskC, taskQueue, "failed a run in ".concat(TaskLoggerKt.b(System.nanoTime() - jNanoTime)));
                        }
                        throw th;
                    }
                }
            }
        };
    }

    public static final void a(TaskRunner taskRunner, Task task) {
        taskRunner.getClass();
        byte[] bArr = Util.f56394a;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(task.f56461a);
        try {
            long jA = task.a();
            synchronized (taskRunner) {
                taskRunner.b(task, jA);
                Unit unit = Unit.f53572a;
            }
            threadCurrentThread.setName(name);
        } catch (Throwable th) {
            synchronized (taskRunner) {
                taskRunner.b(task, -1L);
                Unit unit2 = Unit.f53572a;
                threadCurrentThread.setName(name);
                throw th;
            }
        }
    }

    public final void b(Task task, long j2) {
        byte[] bArr = Util.f56394a;
        TaskQueue taskQueue = task.f56463c;
        Intrinsics.c(taskQueue);
        if (taskQueue.f56468d != task) {
            throw new IllegalStateException("Check failed.");
        }
        boolean z = taskQueue.f56470f;
        taskQueue.f56470f = false;
        taskQueue.f56468d = null;
        this.f56479e.remove(taskQueue);
        if (j2 != -1 && !z && !taskQueue.f56467c) {
            taskQueue.e(task, j2, true);
        }
        if (taskQueue.f56469e.isEmpty()) {
            return;
        }
        this.f56480f.add(taskQueue);
    }

    public final Task c() {
        long j2;
        Task task;
        boolean z;
        byte[] bArr = Util.f56394a;
        while (true) {
            ArrayList arrayList = this.f56480f;
            if (arrayList.isEmpty()) {
                return null;
            }
            RealBackend realBackend = this.f56475a;
            long jNanoTime = System.nanoTime();
            Iterator it = arrayList.iterator();
            long jMin = Long.MAX_VALUE;
            Task task2 = null;
            while (true) {
                if (!it.hasNext()) {
                    j2 = jNanoTime;
                    task = null;
                    z = false;
                    break;
                }
                Task task3 = (Task) ((TaskQueue) it.next()).f56469e.get(0);
                j2 = jNanoTime;
                task = null;
                long jMax = Math.max(0L, task3.f56464d - j2);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (task2 != null) {
                        z = true;
                        break;
                    }
                    task2 = task3;
                }
                jNanoTime = j2;
            }
            ArrayList arrayList2 = this.f56479e;
            if (task2 != null) {
                byte[] bArr2 = Util.f56394a;
                task2.f56464d = -1L;
                TaskQueue taskQueue = task2.f56463c;
                Intrinsics.c(taskQueue);
                taskQueue.f56469e.remove(task2);
                arrayList.remove(taskQueue);
                taskQueue.f56468d = task2;
                arrayList2.add(taskQueue);
                if (z || (!this.f56477c && !arrayList.isEmpty())) {
                    realBackend.a(this.f56481g);
                }
                return task2;
            }
            if (this.f56477c) {
                if (jMin >= this.f56478d - j2) {
                    return task;
                }
                Intrinsics.checkNotNullParameter(this, "taskRunner");
                notify();
                return task;
            }
            this.f56477c = true;
            this.f56478d = j2 + jMin;
            try {
                try {
                    Intrinsics.checkNotNullParameter(this, "taskRunner");
                    long j3 = jMin / 1000000;
                    long j4 = jMin - (1000000 * j3);
                    if (j3 > 0 || jMin > 0) {
                        wait(j3, (int) j4);
                    }
                } catch (InterruptedException unused) {
                    for (int size = arrayList2.size() - 1; -1 < size; size--) {
                        ((TaskQueue) arrayList2.get(size)).b();
                    }
                    for (int size2 = arrayList.size() - 1; -1 < size2; size2--) {
                        TaskQueue taskQueue2 = (TaskQueue) arrayList.get(size2);
                        taskQueue2.b();
                        if (taskQueue2.f56469e.isEmpty()) {
                            arrayList.remove(size2);
                        }
                    }
                }
            } finally {
                this.f56477c = false;
            }
        }
    }

    public final void d(TaskQueue taskQueue) {
        Intrinsics.checkNotNullParameter(taskQueue, "taskQueue");
        byte[] bArr = Util.f56394a;
        if (taskQueue.f56468d == null) {
            boolean zIsEmpty = taskQueue.f56469e.isEmpty();
            ArrayList arrayList = this.f56480f;
            if (zIsEmpty) {
                arrayList.remove(taskQueue);
            } else {
                Intrinsics.checkNotNullParameter(arrayList, "<this>");
                if (!arrayList.contains(taskQueue)) {
                    arrayList.add(taskQueue);
                }
            }
        }
        boolean z = this.f56477c;
        RealBackend realBackend = this.f56475a;
        if (!z) {
            realBackend.a(this.f56481g);
        } else {
            Intrinsics.checkNotNullParameter(this, "taskRunner");
            notify();
        }
    }

    public final TaskQueue e() {
        int i2;
        synchronized (this) {
            i2 = this.f56476b;
            this.f56476b = i2 + 1;
        }
        return new TaskQueue(this, b.f(i2, "Q"));
    }
}
