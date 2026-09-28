package kotlinx.coroutines.scheduling;

import android.support.v4.media.a;
import android.support.v4.media.b;
import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.internal.ResizableAtomicArray;
import kotlinx.coroutines.internal.Symbol;
import org.jetbrains.annotations.Nullable;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class CoroutineScheduler implements Executor, Closeable, AutoCloseable {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f55123h = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "parkedWorkersStack$volatile");

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f55124i = AtomicLongFieldUpdater.newUpdater(CoroutineScheduler.class, "controlState$volatile");

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f55125j = AtomicIntegerFieldUpdater.newUpdater(CoroutineScheduler.class, "_isTerminated$volatile");

    /* renamed from: k, reason: collision with root package name */
    public static final Symbol f55126k = new Symbol("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* renamed from: a, reason: collision with root package name */
    public final int f55127a;

    /* renamed from: b, reason: collision with root package name */
    public final int f55128b;

    /* renamed from: c, reason: collision with root package name */
    public final long f55129c;
    private volatile /* synthetic */ long controlState$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final String f55130d;

    /* renamed from: e, reason: collision with root package name */
    public final GlobalQueue f55131e;

    /* renamed from: f, reason: collision with root package name */
    public final GlobalQueue f55132f;

    /* renamed from: g, reason: collision with root package name */
    public final ResizableAtomicArray f55133g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    @Metadata
    public static final class Companion {
    }

    @Metadata
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        static {
            int[] iArr = new int[WorkerState.values().length];
            try {
                iArr[2] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                WorkerState workerState = WorkerState.f55143a;
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                WorkerState workerState2 = WorkerState.f55143a;
                iArr[0] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                WorkerState workerState3 = WorkerState.f55143a;
                iArr[3] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                WorkerState workerState4 = WorkerState.f55143a;
                iArr[4] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @Metadata
    @SourceDebugExtension
    public final class Worker extends Thread {

        /* renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f55134i = AtomicIntegerFieldUpdater.newUpdater(Worker.class, "workerCtl$volatile");

        /* renamed from: a, reason: collision with root package name */
        public final WorkQueue f55135a;

        /* renamed from: b, reason: collision with root package name */
        public final Ref.ObjectRef f55136b;

        /* renamed from: c, reason: collision with root package name */
        public WorkerState f55137c;

        /* renamed from: d, reason: collision with root package name */
        public long f55138d;

        /* renamed from: e, reason: collision with root package name */
        public long f55139e;

        /* renamed from: f, reason: collision with root package name */
        public int f55140f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f55141g;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        public Worker(int i2) {
            setDaemon(true);
            setContextClassLoader(CoroutineScheduler.this.getClass().getClassLoader());
            this.f55135a = new WorkQueue();
            this.f55136b = new Ref.ObjectRef();
            this.f55137c = WorkerState.f55146d;
            this.nextParkedWorker = CoroutineScheduler.f55126k;
            int iNanoTime = (int) System.nanoTime();
            this.f55140f = iNanoTime == 0 ? 42 : iNanoTime;
            f(i2);
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
        
            r13 = kotlinx.coroutines.scheduling.WorkQueue.f55167d.get(r3);
            r0 = kotlinx.coroutines.scheduling.WorkQueue.f55166c.get(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        
            if (r13 == r0) goto L68;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0057, code lost:
        
            if (kotlinx.coroutines.scheduling.WorkQueue.f55168e.get(r3) != 0) goto L25;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
        
            r0 = r0 - 1;
            r1 = r3.c(r0, true);
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
        
            if (r1 == null) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        
            r2 = r1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final kotlinx.coroutines.scheduling.Task a(boolean r13) {
            /*
                r12 = this;
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = r12.f55137c
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r1 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.f55143a
                r2 = 0
                kotlinx.coroutines.scheduling.WorkQueue r3 = r12.f55135a
                r4 = 1
                kotlinx.coroutines.scheduling.CoroutineScheduler r5 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                if (r0 != r1) goto Le
                goto L88
            Le:
                java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.f55124i
            L10:
                kotlinx.coroutines.scheduling.CoroutineScheduler r7 = kotlinx.coroutines.scheduling.CoroutineScheduler.this
                long r8 = r0.get(r7)
                r10 = 9223367638808264704(0x7ffffc0000000000, double:NaN)
                long r10 = r10 & r8
                r1 = 42
                long r10 = r10 >> r1
                int r1 = (int) r10
                if (r1 != 0) goto L75
                r3.getClass()
            L25:
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = kotlinx.coroutines.scheduling.WorkQueue.f55165b
                java.lang.Object r0 = r13.get(r3)
                kotlinx.coroutines.scheduling.Task r0 = (kotlinx.coroutines.scheduling.Task) r0
                if (r0 != 0) goto L30
                goto L43
            L30:
                boolean r1 = r0.f55156b
                if (r1 != r4) goto L43
            L34:
                boolean r1 = r13.compareAndSet(r3, r0, r2)
                if (r1 == 0) goto L3c
                r2 = r0
                goto L63
            L3c:
                java.lang.Object r1 = r13.get(r3)
                if (r1 == r0) goto L34
                goto L25
            L43:
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r13 = kotlinx.coroutines.scheduling.WorkQueue.f55167d
                int r13 = r13.get(r3)
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = kotlinx.coroutines.scheduling.WorkQueue.f55166c
                int r0 = r0.get(r3)
            L4f:
                if (r13 == r0) goto L63
                java.util.concurrent.atomic.AtomicIntegerFieldUpdater r1 = kotlinx.coroutines.scheduling.WorkQueue.f55168e
                int r1 = r1.get(r3)
                if (r1 != 0) goto L5a
                goto L63
            L5a:
                int r0 = r0 + (-1)
                kotlinx.coroutines.scheduling.Task r1 = r3.c(r0, r4)
                if (r1 == 0) goto L4f
                r2 = r1
            L63:
                if (r2 != 0) goto L74
                kotlinx.coroutines.scheduling.GlobalQueue r13 = r5.f55132f
                java.lang.Object r13 = r13.c()
                kotlinx.coroutines.scheduling.Task r13 = (kotlinx.coroutines.scheduling.Task) r13
                if (r13 != 0) goto L73
                kotlinx.coroutines.scheduling.Task r13 = r12.i(r4)
            L73:
                return r13
            L74:
                return r2
            L75:
                r10 = 4398046511104(0x40000000000, double:2.1729236899484E-311)
                long r10 = r8 - r10
                java.util.concurrent.atomic.AtomicLongFieldUpdater r6 = kotlinx.coroutines.scheduling.CoroutineScheduler.f55124i
                boolean r1 = r6.compareAndSet(r7, r8, r10)
                if (r1 == 0) goto L10
                kotlinx.coroutines.scheduling.CoroutineScheduler$WorkerState r0 = kotlinx.coroutines.scheduling.CoroutineScheduler.WorkerState.f55143a
                r12.f55137c = r0
            L88:
                if (r13 == 0) goto Lbc
                int r13 = r5.f55127a
                int r13 = r13 * 2
                int r13 = r12.d(r13)
                if (r13 != 0) goto L95
                goto L96
            L95:
                r4 = 0
            L96:
                if (r4 == 0) goto L9f
                kotlinx.coroutines.scheduling.Task r13 = r12.e()
                if (r13 == 0) goto L9f
                return r13
            L9f:
                r3.getClass()
                java.util.concurrent.atomic.AtomicReferenceFieldUpdater r13 = kotlinx.coroutines.scheduling.WorkQueue.f55165b
                java.lang.Object r13 = r13.getAndSet(r3, r2)
                kotlinx.coroutines.scheduling.Task r13 = (kotlinx.coroutines.scheduling.Task) r13
                if (r13 != 0) goto Lb0
                kotlinx.coroutines.scheduling.Task r13 = r3.b()
            Lb0:
                if (r13 == 0) goto Lb3
                return r13
            Lb3:
                if (r4 != 0) goto Lc3
                kotlinx.coroutines.scheduling.Task r13 = r12.e()
                if (r13 == 0) goto Lc3
                return r13
            Lbc:
                kotlinx.coroutines.scheduling.Task r13 = r12.e()
                if (r13 == 0) goto Lc3
                return r13
            Lc3:
                r13 = 3
                kotlinx.coroutines.scheduling.Task r13 = r12.i(r13)
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.a(boolean):kotlinx.coroutines.scheduling.Task");
        }

        public final int b() {
            return this.indexInArray;
        }

        public final Object c() {
            return this.nextParkedWorker;
        }

        public final int d(int i2) {
            int i3 = this.f55140f;
            int i4 = i3 ^ (i3 << 13);
            int i5 = i4 ^ (i4 >> 17);
            int i6 = i5 ^ (i5 << 5);
            this.f55140f = i6;
            int i7 = i2 - 1;
            return (i7 & i2) == 0 ? i6 & i7 : (i6 & Api.BaseClientBuilder.API_PRIORITY_OTHER) % i2;
        }

        public final Task e() {
            int iD = d(2);
            CoroutineScheduler coroutineScheduler = CoroutineScheduler.this;
            if (iD == 0) {
                Task task = (Task) coroutineScheduler.f55131e.c();
                return task != null ? task : (Task) coroutineScheduler.f55132f.c();
            }
            Task task2 = (Task) coroutineScheduler.f55132f.c();
            return task2 != null ? task2 : (Task) coroutineScheduler.f55131e.c();
        }

        public final void f(int i2) {
            StringBuilder sb = new StringBuilder();
            sb.append(CoroutineScheduler.this.f55130d);
            sb.append("-worker-");
            sb.append(i2 == 0 ? "TERMINATED" : String.valueOf(i2));
            setName(sb.toString());
            this.indexInArray = i2;
        }

        public final void g(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean h(WorkerState workerState) {
            WorkerState workerState2 = this.f55137c;
            boolean z = workerState2 == WorkerState.f55143a;
            if (z) {
                CoroutineScheduler.f55124i.addAndGet(CoroutineScheduler.this, 4398046511104L);
            }
            if (workerState2 != workerState) {
                this.f55137c = workerState;
            }
            return z;
        }

        /* JADX WARN: Code restructure failed: missing block: B:25:0x006b, code lost:
        
            r7 = r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00a0, code lost:
        
            r7 = -2;
            r23 = r6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final kotlinx.coroutines.scheduling.Task i(int r26) {
            /*
                Method dump skipped, instructions count: 264
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.i(int):kotlinx.coroutines.scheduling.Task");
        }

        /* JADX WARN: Code restructure failed: missing block: B:128:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x0004, code lost:
        
            continue;
         */
        /* JADX WARN: Code restructure failed: missing block: B:130:0x0004, code lost:
        
            continue;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void run() {
            /*
                Method dump skipped, instructions count: 429
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.Worker.run():void");
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata
    public static final class WorkerState {

        /* renamed from: a, reason: collision with root package name */
        public static final WorkerState f55143a;

        /* renamed from: b, reason: collision with root package name */
        public static final WorkerState f55144b;

        /* renamed from: c, reason: collision with root package name */
        public static final WorkerState f55145c;

        /* renamed from: d, reason: collision with root package name */
        public static final WorkerState f55146d;

        /* renamed from: e, reason: collision with root package name */
        public static final WorkerState f55147e;

        /* renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ WorkerState[] f55148f;

        /* renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f55149g;

        static {
            WorkerState workerState = new WorkerState("CPU_ACQUIRED", 0);
            f55143a = workerState;
            WorkerState workerState2 = new WorkerState("BLOCKING", 1);
            f55144b = workerState2;
            WorkerState workerState3 = new WorkerState("PARKING", 2);
            f55145c = workerState3;
            WorkerState workerState4 = new WorkerState("DORMANT", 3);
            f55146d = workerState4;
            WorkerState workerState5 = new WorkerState("TERMINATED", 4);
            f55147e = workerState5;
            WorkerState[] workerStateArr = {workerState, workerState2, workerState3, workerState4, workerState5};
            f55148f = workerStateArr;
            f55149g = EnumEntriesKt.a(workerStateArr);
        }

        public static WorkerState valueOf(String str) {
            return (WorkerState) Enum.valueOf(WorkerState.class, str);
        }

        public static WorkerState[] values() {
            return (WorkerState[]) f55148f.clone();
        }
    }

    public CoroutineScheduler(long j2, String str, int i2, int i3) {
        this.f55127a = i2;
        this.f55128b = i3;
        this.f55129c = j2;
        this.f55130d = str;
        if (i2 < 1) {
            throw new IllegalArgumentException(b.g(i2, "Core pool size ", " should be at least 1").toString());
        }
        if (i3 < i2) {
            throw new IllegalArgumentException(b.d(i3, i2, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i3 > 2097150) {
            throw new IllegalArgumentException(b.g(i3, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j2 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j2 + " must be positive").toString());
        }
        this.f55131e = new GlobalQueue();
        this.f55132f = new GlobalQueue();
        this.f55133g = new ResizableAtomicArray((i2 + 1) * 2);
        this.controlState$volatile = i2 << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void c(CoroutineScheduler coroutineScheduler, Runnable runnable, int i2) {
        coroutineScheduler.b(runnable, false, (i2 & 4) == 0);
    }

    public final int a() {
        synchronized (this.f55133g) {
            try {
                if (f55125j.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f55124i;
                long j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 & 2097151);
                int i3 = i2 - ((int) ((j2 & 4398044413952L) >> 21));
                if (i3 < 0) {
                    i3 = 0;
                }
                if (i3 >= this.f55127a) {
                    return 0;
                }
                if (i2 >= this.f55128b) {
                    return 0;
                }
                int i4 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i4 <= 0 || this.f55133g.b(i4) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                Worker worker = new Worker(i4);
                this.f55133g.c(i4, worker);
                if (i4 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i5 = i3 + 1;
                worker.start();
                return i5;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, boolean z, boolean z2) {
        Task taskImpl;
        WorkerState workerState;
        TasksKt.f55163f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof Task) {
            taskImpl = (Task) runnable;
            taskImpl.f55155a = jNanoTime;
            taskImpl.f55156b = z;
        } else {
            taskImpl = new TaskImpl(runnable, jNanoTime, z);
        }
        boolean z3 = taskImpl.f55156b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f55124i;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        Worker worker = threadCurrentThread instanceof Worker ? (Worker) threadCurrentThread : null;
        if (worker == null || !Intrinsics.b(CoroutineScheduler.this, this)) {
            worker = null;
        }
        if (worker != null && (workerState = worker.f55137c) != WorkerState.f55147e && (taskImpl.f55156b || workerState != WorkerState.f55144b)) {
            worker.f55141g = true;
            WorkQueue workQueue = worker.f55135a;
            if (z2) {
                taskImpl = workQueue.a(taskImpl);
            } else {
                workQueue.getClass();
                Task task = (Task) WorkQueue.f55165b.getAndSet(workQueue, taskImpl);
                taskImpl = task == null ? null : workQueue.a(task);
            }
        }
        if (taskImpl != null) {
            if (!(taskImpl.f55156b ? this.f55132f.a(taskImpl) : this.f55131e.a(taskImpl))) {
                throw new RejectedExecutionException(b.r(new StringBuilder(), this.f55130d, " was terminated"));
            }
        }
        boolean z4 = z2 && worker != null;
        if (z3) {
            if (z4 || s() || l(jAddAndGet)) {
                return;
            }
            s();
            return;
        }
        if (z4 || s() || l(atomicLongFieldUpdater.get(this))) {
            return;
        }
        s();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a6  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.CoroutineScheduler.close():void");
    }

    public final void e(Worker worker, int i2, int i3) {
        while (true) {
            long j2 = f55123h.get(this);
            int i4 = (int) (2097151 & j2);
            long j3 = (2097152 + j2) & (-2097152);
            if (i4 == i2) {
                if (i3 == 0) {
                    Object objC = worker.c();
                    while (true) {
                        if (objC == f55126k) {
                            i4 = -1;
                            break;
                        }
                        if (objC == null) {
                            i4 = 0;
                            break;
                        }
                        Worker worker2 = (Worker) objC;
                        int iB = worker2.b();
                        if (iB != 0) {
                            i4 = iB;
                            break;
                        }
                        objC = worker2.c();
                    }
                } else {
                    i4 = i3;
                }
            }
            if (i4 >= 0) {
                if (f55123h.compareAndSet(this, j2, i4 | j3)) {
                    return;
                }
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        c(this, runnable, 6);
    }

    public final boolean l(long j2) {
        int i2 = ((int) (2097151 & j2)) - ((int) ((j2 & 4398044413952L) >> 21));
        if (i2 < 0) {
            i2 = 0;
        }
        int i3 = this.f55127a;
        if (i2 < i3) {
            int iA = a();
            if (iA == 1 && i3 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean s() {
        Symbol symbol;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f55123h;
            long j2 = atomicLongFieldUpdater.get(this);
            Worker worker = (Worker) this.f55133g.b((int) (2097151 & j2));
            if (worker == null) {
                worker = null;
            } else {
                long j3 = (2097152 + j2) & (-2097152);
                Object objC = worker.c();
                while (true) {
                    symbol = f55126k;
                    if (objC == symbol) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    Worker worker2 = (Worker) objC;
                    iB = worker2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = worker2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j2, j3 | iB)) {
                    worker.g(symbol);
                }
            }
            if (worker == null) {
                return false;
            }
            if (Worker.f55134i.compareAndSet(worker, -1, 0)) {
                LockSupport.unpark(worker);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        ResizableAtomicArray resizableAtomicArray = this.f55133g;
        int iA = resizableAtomicArray.a();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 1; i7 < iA; i7++) {
            Worker worker = (Worker) resizableAtomicArray.b(i7);
            if (worker != null) {
                WorkQueue workQueue = worker.f55135a;
                workQueue.getClass();
                int i8 = WorkQueue.f55165b.get(workQueue) != null ? (WorkQueue.f55166c.get(workQueue) - WorkQueue.f55167d.get(workQueue)) + 1 : WorkQueue.f55166c.get(workQueue) - WorkQueue.f55167d.get(workQueue);
                int iOrdinal = worker.f55137c.ordinal();
                if (iOrdinal == 0) {
                    i2++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i8);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i3++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i8);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i4++;
                } else if (iOrdinal == 3) {
                    i5++;
                    if (i8 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i8);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i6++;
                }
            }
        }
        long j2 = f55124i.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f55130d);
        sb4.append('@');
        sb4.append(DebugStringsKt.a(this));
        sb4.append("[Pool Size {core = ");
        int i9 = this.f55127a;
        sb4.append(i9);
        sb4.append(", max = ");
        a.q(this.f55128b, i2, "}, Worker States {CPU = ", ", blocking = ", sb4);
        a.q(i3, i4, ", parked = ", ", dormant = ", sb4);
        a.q(i5, i6, ", terminated = ", "}, running workers queues = ", sb4);
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.f55131e.b());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f55132f.b());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j2));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j2) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i9 - ((int) ((j2 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
