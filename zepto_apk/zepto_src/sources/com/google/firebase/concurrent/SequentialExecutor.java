package com.google.firebase.concurrent;

import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

/* loaded from: classes.dex */
final class SequentialExecutor implements Executor {

    /* renamed from: f, reason: collision with root package name */
    public static final Logger f43639f = Logger.getLogger(SequentialExecutor.class.getName());

    /* renamed from: a, reason: collision with root package name */
    public final Executor f43640a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayDeque f43641b = new ArrayDeque();

    /* renamed from: c, reason: collision with root package name */
    public WorkerRunningState f43642c = WorkerRunningState.f43648a;

    /* renamed from: d, reason: collision with root package name */
    public long f43643d = 0;

    /* renamed from: e, reason: collision with root package name */
    public final QueueWorker f43644e = new QueueWorker();

    public final class QueueWorker implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public Runnable f43646a;

        public QueueWorker() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x003d, code lost:
        
            if (r1 == false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
        
            r1 = r1 | java.lang.Thread.interrupted();
            r2 = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
        
            r9.f43646a.run();
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0052, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
        
            r3 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
        
            com.google.firebase.concurrent.SequentialExecutor.f43639f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + r9.f43646a, (java.lang.Throwable) r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
        
            r9.f43646a = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
        
            return;
         */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0036 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a() {
            /*
                r9 = this;
                r0 = 0
                r1 = r0
            L2:
                com.google.firebase.concurrent.SequentialExecutor r2 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L50
                java.util.ArrayDeque r2 = r2.f43641b     // Catch: java.lang.Throwable -> L50
                monitor-enter(r2)     // Catch: java.lang.Throwable -> L50
                if (r0 != 0) goto L28
                com.google.firebase.concurrent.SequentialExecutor r0 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L1c
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = r0.f43642c     // Catch: java.lang.Throwable -> L1c
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r4 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43651d     // Catch: java.lang.Throwable -> L1c
                if (r3 != r4) goto L1e
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L40
            L14:
                java.lang.Thread r0 = java.lang.Thread.currentThread()
                r0.interrupt()
                goto L40
            L1c:
                r0 = move-exception
                goto L73
            L1e:
                long r5 = r0.f43643d     // Catch: java.lang.Throwable -> L1c
                r7 = 1
                long r5 = r5 + r7
                r0.f43643d = r5     // Catch: java.lang.Throwable -> L1c
                r0.f43642c = r4     // Catch: java.lang.Throwable -> L1c
                r0 = 1
            L28:
                com.google.firebase.concurrent.SequentialExecutor r3 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L1c
                java.util.ArrayDeque r3 = r3.f43641b     // Catch: java.lang.Throwable -> L1c
                java.lang.Object r3 = r3.poll()     // Catch: java.lang.Throwable -> L1c
                java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L1c
                r9.f43646a = r3     // Catch: java.lang.Throwable -> L1c
                if (r3 != 0) goto L41
                com.google.firebase.concurrent.SequentialExecutor r0 = com.google.firebase.concurrent.SequentialExecutor.this     // Catch: java.lang.Throwable -> L1c
                com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43648a     // Catch: java.lang.Throwable -> L1c
                r0.f43642c = r3     // Catch: java.lang.Throwable -> L1c
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                if (r1 == 0) goto L40
                goto L14
            L40:
                return
            L41:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L50
                r1 = r1 | r2
                r2 = 0
                java.lang.Runnable r3 = r9.f43646a     // Catch: java.lang.Throwable -> L52 java.lang.RuntimeException -> L54
                r3.run()     // Catch: java.lang.Throwable -> L52 java.lang.RuntimeException -> L54
            L4d:
                r9.f43646a = r2     // Catch: java.lang.Throwable -> L50
                goto L2
            L50:
                r0 = move-exception
                goto L75
            L52:
                r0 = move-exception
                goto L70
            L54:
                r3 = move-exception
                java.util.logging.Logger r4 = com.google.firebase.concurrent.SequentialExecutor.f43639f     // Catch: java.lang.Throwable -> L52
                java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L52
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L52
                r6.<init>()     // Catch: java.lang.Throwable -> L52
                java.lang.String r7 = "Exception while executing runnable "
                r6.append(r7)     // Catch: java.lang.Throwable -> L52
                java.lang.Runnable r7 = r9.f43646a     // Catch: java.lang.Throwable -> L52
                r6.append(r7)     // Catch: java.lang.Throwable -> L52
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L52
                r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L52
                goto L4d
            L70:
                r9.f43646a = r2     // Catch: java.lang.Throwable -> L50
                throw r0     // Catch: java.lang.Throwable -> L50
            L73:
                monitor-exit(r2)     // Catch: java.lang.Throwable -> L1c
                throw r0     // Catch: java.lang.Throwable -> L50
            L75:
                if (r1 == 0) goto L7e
                java.lang.Thread r1 = java.lang.Thread.currentThread()
                r1.interrupt()
            L7e:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.SequentialExecutor.QueueWorker.a():void");
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a();
            } catch (Error e2) {
                synchronized (SequentialExecutor.this.f43641b) {
                    SequentialExecutor.this.f43642c = WorkerRunningState.f43648a;
                    throw e2;
                }
            }
        }

        public final String toString() {
            Runnable runnable = this.f43646a;
            if (runnable != null) {
                return "SequentialExecutorWorker{running=" + runnable + "}";
            }
            return "SequentialExecutorWorker{state=" + SequentialExecutor.this.f43642c + "}";
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class WorkerRunningState {

        /* renamed from: a, reason: collision with root package name */
        public static final WorkerRunningState f43648a;

        /* renamed from: b, reason: collision with root package name */
        public static final WorkerRunningState f43649b;

        /* renamed from: c, reason: collision with root package name */
        public static final WorkerRunningState f43650c;

        /* renamed from: d, reason: collision with root package name */
        public static final WorkerRunningState f43651d;

        /* renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ WorkerRunningState[] f43652e;

        static {
            WorkerRunningState workerRunningState = new WorkerRunningState("IDLE", 0);
            f43648a = workerRunningState;
            WorkerRunningState workerRunningState2 = new WorkerRunningState("QUEUING", 1);
            f43649b = workerRunningState2;
            WorkerRunningState workerRunningState3 = new WorkerRunningState("QUEUED", 2);
            f43650c = workerRunningState3;
            WorkerRunningState workerRunningState4 = new WorkerRunningState("RUNNING", 3);
            f43651d = workerRunningState4;
            f43652e = new WorkerRunningState[]{workerRunningState, workerRunningState2, workerRunningState3, workerRunningState4};
        }

        public static WorkerRunningState valueOf(String str) {
            return (WorkerRunningState) Enum.valueOf(WorkerRunningState.class, str);
        }

        public static WorkerRunningState[] values() {
            return (WorkerRunningState[]) f43652e.clone();
        }
    }

    public SequentialExecutor(Executor executor) {
        this.f43640a = (Executor) Preconditions.checkNotNull(executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0061  */
    @Override // java.util.concurrent.Executor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void execute(final java.lang.Runnable r8) {
        /*
            r7 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            java.util.ArrayDeque r0 = r7.f43641b
            monitor-enter(r0)
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r1 = r7.f43642c     // Catch: java.lang.Throwable -> L6d
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43651d     // Catch: java.lang.Throwable -> L6d
            if (r1 == r2) goto L6f
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r2 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43650c     // Catch: java.lang.Throwable -> L6d
            if (r1 != r2) goto L11
            goto L6f
        L11:
            long r3 = r7.f43643d     // Catch: java.lang.Throwable -> L6d
            com.google.firebase.concurrent.SequentialExecutor$1 r1 = new com.google.firebase.concurrent.SequentialExecutor$1     // Catch: java.lang.Throwable -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6d
            java.util.ArrayDeque r8 = r7.f43641b     // Catch: java.lang.Throwable -> L6d
            r8.add(r1)     // Catch: java.lang.Throwable -> L6d
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r8 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43649b     // Catch: java.lang.Throwable -> L6d
            r7.f43642c = r8     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            java.util.concurrent.Executor r0 = r7.f43640a     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            com.google.firebase.concurrent.SequentialExecutor$QueueWorker r5 = r7.f43644e     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            r0.execute(r5)     // Catch: java.lang.Error -> L44 java.lang.RuntimeException -> L46
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r0 = r7.f43642c
            if (r0 == r8) goto L2e
            goto L69
        L2e:
            java.util.ArrayDeque r0 = r7.f43641b
            monitor-enter(r0)
            long r5 = r7.f43643d     // Catch: java.lang.Throwable -> L3e
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 != 0) goto L40
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r1 = r7.f43642c     // Catch: java.lang.Throwable -> L3e
            if (r1 != r8) goto L40
            r7.f43642c = r2     // Catch: java.lang.Throwable -> L3e
            goto L40
        L3e:
            r8 = move-exception
            goto L42
        L40:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            return
        L42:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3e
            throw r8
        L44:
            r8 = move-exception
            goto L47
        L46:
            r8 = move-exception
        L47:
            java.util.ArrayDeque r2 = r7.f43641b
            monitor-enter(r2)
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r0 = r7.f43642c     // Catch: java.lang.Throwable -> L55
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43648a     // Catch: java.lang.Throwable -> L55
            if (r0 == r3) goto L57
            com.google.firebase.concurrent.SequentialExecutor$WorkerRunningState r3 = com.google.firebase.concurrent.SequentialExecutor.WorkerRunningState.f43649b     // Catch: java.lang.Throwable -> L55
            if (r0 != r3) goto L61
            goto L57
        L55:
            r8 = move-exception
            goto L6b
        L57:
            java.util.ArrayDeque r0 = r7.f43641b     // Catch: java.lang.Throwable -> L55
            boolean r0 = r0.removeLastOccurrence(r1)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L61
            r0 = 1
            goto L62
        L61:
            r0 = 0
        L62:
            boolean r1 = r8 instanceof java.util.concurrent.RejectedExecutionException     // Catch: java.lang.Throwable -> L55
            if (r1 == 0) goto L6a
            if (r0 != 0) goto L6a
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
        L69:
            return
        L6a:
            throw r8     // Catch: java.lang.Throwable -> L55
        L6b:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L55
            throw r8
        L6d:
            r8 = move-exception
            goto L76
        L6f:
            java.util.ArrayDeque r1 = r7.f43641b     // Catch: java.lang.Throwable -> L6d
            r1.add(r8)     // Catch: java.lang.Throwable -> L6d
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            return
        L76:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6d
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.SequentialExecutor.execute(java.lang.Runnable):void");
    }

    public final String toString() {
        return "SequentialExecutor@" + System.identityHashCode(this) + "{" + this.f43640a + "}";
    }
}
