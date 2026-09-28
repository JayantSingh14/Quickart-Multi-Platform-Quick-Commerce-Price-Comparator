package okhttp3.internal.concurrent;

import android.support.v4.media.b;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.Util;

@Metadata
@SourceDebugExtension
/* loaded from: classes.dex */
public final class TaskQueue {

    /* renamed from: a, reason: collision with root package name */
    public final TaskRunner f56465a;

    /* renamed from: b, reason: collision with root package name */
    public final String f56466b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f56467c;

    /* renamed from: d, reason: collision with root package name */
    public Task f56468d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f56469e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f56470f;

    @Metadata
    /* loaded from: classes3.dex */
    public static final class AwaitIdleTask extends Task {

        /* renamed from: e, reason: collision with root package name */
        public final CountDownLatch f56471e;

        public AwaitIdleTask() {
            super(b.r(new StringBuilder(), Util.f56400g, " awaitIdle"), false);
            this.f56471e = new CountDownLatch(1);
        }

        @Override // okhttp3.internal.concurrent.Task
        public final long a() {
            this.f56471e.countDown();
            return -1L;
        }
    }

    public TaskQueue(TaskRunner taskRunner, String name) {
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f56465a = taskRunner;
        this.f56466b = name;
        this.f56469e = new ArrayList();
    }

    public final void a() {
        byte[] bArr = Util.f56394a;
        synchronized (this.f56465a) {
            try {
                if (b()) {
                    this.f56465a.d(this);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b() {
        Task task = this.f56468d;
        if (task != null && task.f56462b) {
            this.f56470f = true;
        }
        ArrayList arrayList = this.f56469e;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((Task) arrayList.get(size)).f56462b) {
                Task task2 = (Task) arrayList.get(size);
                if (TaskRunner.f56474i.isLoggable(Level.FINE)) {
                    TaskLoggerKt.a(task2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void c(Task task, long j2) {
        Intrinsics.checkNotNullParameter(task, "task");
        synchronized (this.f56465a) {
            if (!this.f56467c) {
                if (e(task, j2, false)) {
                    this.f56465a.d(this);
                }
                Unit unit = Unit.f53572a;
            } else if (task.f56462b) {
                if (TaskRunner.f56474i.isLoggable(Level.FINE)) {
                    TaskLoggerKt.a(task, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (TaskRunner.f56474i.isLoggable(Level.FINE)) {
                    TaskLoggerKt.a(task, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e(okhttp3.internal.concurrent.Task r11, long r12, boolean r14) {
        /*
            r10 = this;
            java.lang.String r0 = "task"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r11.getClass()
            java.lang.String r0 = "queue"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            okhttp3.internal.concurrent.TaskQueue r0 = r11.f56463c
            if (r0 != r10) goto L12
            goto L16
        L12:
            if (r0 != 0) goto L96
            r11.f56463c = r10
        L16:
            okhttp3.internal.concurrent.TaskRunner r0 = r10.f56465a
            okhttp3.internal.concurrent.TaskRunner$RealBackend r0 = r0.f56475a
            long r0 = java.lang.System.nanoTime()
            long r2 = r0 + r12
            java.util.ArrayList r4 = r10.f56469e
            int r5 = r4.indexOf(r11)
            r6 = 0
            r7 = -1
            if (r5 == r7) goto L43
            long r8 = r11.f56464d
            int r8 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r8 > 0) goto L40
            java.util.logging.Logger r12 = okhttp3.internal.concurrent.TaskRunner.f56474i
            java.util.logging.Level r13 = java.util.logging.Level.FINE
            boolean r12 = r12.isLoggable(r13)
            if (r12 == 0) goto L95
            java.lang.String r12 = "already scheduled"
            okhttp3.internal.concurrent.TaskLoggerKt.a(r11, r10, r12)
            return r6
        L40:
            r4.remove(r5)
        L43:
            r11.f56464d = r2
            java.util.logging.Logger r5 = okhttp3.internal.concurrent.TaskRunner.f56474i
            java.util.logging.Level r8 = java.util.logging.Level.FINE
            boolean r5 = r5.isLoggable(r8)
            if (r5 == 0) goto L6b
            if (r14 == 0) goto L5d
            long r2 = r2 - r0
            java.lang.String r14 = okhttp3.internal.concurrent.TaskLoggerKt.b(r2)
            java.lang.String r2 = "run again after "
            java.lang.String r14 = r2.concat(r14)
            goto L68
        L5d:
            long r2 = r2 - r0
            java.lang.String r14 = okhttp3.internal.concurrent.TaskLoggerKt.b(r2)
            java.lang.String r2 = "scheduled after "
            java.lang.String r14 = r2.concat(r14)
        L68:
            okhttp3.internal.concurrent.TaskLoggerKt.a(r11, r10, r14)
        L6b:
            java.util.Iterator r14 = r4.iterator()
            r2 = r6
        L70:
            boolean r3 = r14.hasNext()
            if (r3 == 0) goto L87
            java.lang.Object r3 = r14.next()
            okhttp3.internal.concurrent.Task r3 = (okhttp3.internal.concurrent.Task) r3
            long r8 = r3.f56464d
            long r8 = r8 - r0
            int r3 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r3 <= 0) goto L84
            goto L88
        L84:
            int r2 = r2 + 1
            goto L70
        L87:
            r2 = r7
        L88:
            if (r2 != r7) goto L8e
            int r2 = r4.size()
        L8e:
            r4.add(r2, r11)
            if (r2 != 0) goto L95
            r11 = 1
            return r11
        L95:
            return r6
        L96:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "task is in multiple queues"
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.concurrent.TaskQueue.e(okhttp3.internal.concurrent.Task, long, boolean):boolean");
    }

    public final void f() {
        byte[] bArr = Util.f56394a;
        synchronized (this.f56465a) {
            try {
                this.f56467c = true;
                if (b()) {
                    this.f56465a.d(this);
                }
                Unit unit = Unit.f53572a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String toString() {
        return this.f56466b;
    }
}
