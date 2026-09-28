package bolts;

import bolts.BoltsExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes3.dex */
public class Task<TResult> {

    /* renamed from: g, reason: collision with root package name */
    public static final ExecutorService f13188g;

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f13189h;

    /* renamed from: i, reason: collision with root package name */
    public static final Executor f13190i;

    /* renamed from: j, reason: collision with root package name */
    public static final Task f13191j;

    /* renamed from: k, reason: collision with root package name */
    public static final Task f13192k;

    /* renamed from: l, reason: collision with root package name */
    public static final Task f13193l;

    /* renamed from: m, reason: collision with root package name */
    public static final Task f13194m;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13196b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13197c;

    /* renamed from: d, reason: collision with root package name */
    public Object f13198d;

    /* renamed from: e, reason: collision with root package name */
    public Exception f13199e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f13195a = new Object();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f13200f = new ArrayList();

    /* renamed from: bolts.Task$1, reason: invalid class name */
    final class AnonymousClass1 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: bolts.Task$11, reason: invalid class name */
    class AnonymousClass11 implements Continuation<Object, Void> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // bolts.Continuation
        public final Object a(final Task task) {
            final bolts.TaskCompletionSource taskCompletionSource = null;
            Object[] objArr = 0;
            ExecutorService executorService = Task.f13188g;
            try {
                final Object[] objArr2 = objArr == true ? 1 : 0;
                new Runnable() { // from class: bolts.Task.15
                    @Override // java.lang.Runnable
                    public final void run() {
                        bolts.TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                        try {
                            Task task2 = (Task) ((AnonymousClass13) objArr2).a(task);
                            if (task2 == null) {
                                taskCompletionSource2.c(null);
                            } else {
                                task2.b(new Continuation<Object, Void>() { // from class: bolts.Task.15.1
                                    @Override // bolts.Continuation
                                    public final Object a(Task task3) {
                                        AnonymousClass15 anonymousClass15 = AnonymousClass15.this;
                                        boolean zG = task3.g();
                                        bolts.TaskCompletionSource taskCompletionSource3 = taskCompletionSource;
                                        if (zG) {
                                            taskCompletionSource3.a();
                                            return null;
                                        }
                                        if (task3.h()) {
                                            taskCompletionSource3.b(task3.e());
                                            return null;
                                        }
                                        taskCompletionSource3.c(task3.f());
                                        return null;
                                    }
                                });
                            }
                        } catch (CancellationException unused) {
                            taskCompletionSource2.a();
                        } catch (Exception e2) {
                            taskCompletionSource2.b(e2);
                        }
                    }
                };
                throw null;
            } catch (Exception e2) {
                new ExecutorException(e2);
                throw null;
            }
        }
    }

    /* renamed from: bolts.Task$12, reason: invalid class name */
    class AnonymousClass12 implements Continuation<Object, Task<Object>> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            return task.h() ? Task.c(task.e()) : task.g() ? Task.f13194m : task.b(null);
        }
    }

    /* renamed from: bolts.Task$13, reason: invalid class name */
    class AnonymousClass13 implements Continuation<Object, Task<Object>> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            if (task.h()) {
                return Task.c(task.e());
            }
            if (task.g()) {
                return Task.f13194m;
            }
            ExecutorService executorService = Task.f13188g;
            throw null;
        }
    }

    /* renamed from: bolts.Task$14, reason: invalid class name */
    final class AnonymousClass14 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bolts.TaskCompletionSource f13204a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Continuation f13205b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Task f13206c;

        public AnonymousClass14(bolts.TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
            this.f13204a = taskCompletionSource;
            this.f13205b = continuation;
            this.f13206c = task;
        }

        @Override // java.lang.Runnable
        public final void run() {
            bolts.TaskCompletionSource taskCompletionSource = this.f13204a;
            try {
                taskCompletionSource.c(this.f13205b.a(this.f13206c));
            } catch (CancellationException unused) {
                taskCompletionSource.a();
            } catch (Exception e2) {
                taskCompletionSource.b(e2);
            }
        }
    }

    /* renamed from: bolts.Task$2, reason: invalid class name */
    final class AnonymousClass2 implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            throw null;
        }
    }

    /* renamed from: bolts.Task$3, reason: invalid class name */
    class AnonymousClass3 implements Continuation<Object, Task<Void>> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            return task.g() ? Task.f13194m : task.h() ? Task.c(task.e()) : Task.f13191j;
        }
    }

    /* renamed from: bolts.Task$5, reason: invalid class name */
    final class AnonymousClass5 implements Continuation<Object, Void> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            throw null;
        }
    }

    /* renamed from: bolts.Task$6, reason: invalid class name */
    final class AnonymousClass6 implements Continuation<Object, Void> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            throw null;
        }
    }

    /* renamed from: bolts.Task$7, reason: invalid class name */
    final class AnonymousClass7 implements Continuation<Void, List<Object>> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            throw null;
        }
    }

    /* renamed from: bolts.Task$8, reason: invalid class name */
    final class AnonymousClass8 implements Continuation<Object, Void> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            if (task.h() || task.g()) {
                throw null;
            }
            throw null;
        }
    }

    /* renamed from: bolts.Task$9, reason: invalid class name */
    class AnonymousClass9 implements Continuation<Void, Task<Void>> {
        @Override // bolts.Continuation
        public final Object a(Task task) {
            throw null;
        }
    }

    public class TaskCompletionSource extends bolts.TaskCompletionSource<TResult> {
    }

    public interface UnobservedExceptionHandler {
    }

    static {
        BoltsExecutors boltsExecutors = BoltsExecutors.f13179d;
        f13188g = boltsExecutors.f13180a;
        f13189h = boltsExecutors.f13182c;
        f13190i = AndroidExecutors.f13175b.f13178a;
        f13191j = new Task((Boolean) null);
        f13192k = new Task(Boolean.TRUE);
        f13193l = new Task(Boolean.FALSE);
        f13194m = new Task(0);
    }

    public Task() {
    }

    public static Task a(final Callable callable, Executor executor) {
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        try {
            executor.execute(new Runnable() { // from class: bolts.Task.4
                @Override // java.lang.Runnable
                public final void run() {
                    bolts.TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                    try {
                        taskCompletionSource2.c(callable.call());
                    } catch (CancellationException unused) {
                        taskCompletionSource2.a();
                    } catch (Exception e2) {
                        taskCompletionSource2.b(e2);
                    }
                }
            });
        } catch (Exception e2) {
            taskCompletionSource.b(new ExecutorException(e2));
        }
        return taskCompletionSource.f13213a;
    }

    public static Task c(Exception exc) {
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.b(exc);
        return taskCompletionSource.f13213a;
    }

    public static Task d(Object obj) {
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? f13192k : f13193l;
        }
        bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        taskCompletionSource.c(obj);
        return taskCompletionSource.f13213a;
    }

    public final Task b(final Continuation continuation) {
        boolean z;
        final Executor executor = f13189h;
        final bolts.TaskCompletionSource taskCompletionSource = new bolts.TaskCompletionSource();
        synchronized (this.f13195a) {
            try {
                synchronized (this.f13195a) {
                    z = this.f13196b;
                }
                if (!z) {
                    this.f13200f.add(new Continuation<Object, Void>() { // from class: bolts.Task.10
                        @Override // bolts.Continuation
                        public final Object a(Task task) {
                            Executor executor2 = executor;
                            bolts.TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                            Continuation continuation2 = continuation;
                            ExecutorService executorService = Task.f13188g;
                            try {
                                ((BoltsExecutors.ImmediateExecutor) executor2).execute(new AnonymousClass14(taskCompletionSource2, continuation2, task));
                                return null;
                            } catch (Exception e2) {
                                taskCompletionSource2.b(new ExecutorException(e2));
                                return null;
                            }
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            try {
                ((BoltsExecutors.ImmediateExecutor) executor).execute(new AnonymousClass14(taskCompletionSource, continuation, this));
            } catch (Exception e2) {
                taskCompletionSource.b(new ExecutorException(e2));
            }
        }
        return taskCompletionSource.f13213a;
    }

    public final Exception e() {
        Exception exc;
        synchronized (this.f13195a) {
            exc = this.f13199e;
        }
        return exc;
    }

    public final Object f() {
        Object obj;
        synchronized (this.f13195a) {
            obj = this.f13198d;
        }
        return obj;
    }

    public final boolean g() {
        boolean z;
        synchronized (this.f13195a) {
            z = this.f13197c;
        }
        return z;
    }

    public final boolean h() {
        boolean z;
        synchronized (this.f13195a) {
            z = e() != null;
        }
        return z;
    }

    public final void i() {
        synchronized (this.f13195a) {
            Iterator it = this.f13200f.iterator();
            while (it.hasNext()) {
                try {
                    ((Continuation) it.next()).a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f13200f = null;
        }
    }

    public final boolean j() {
        synchronized (this.f13195a) {
            try {
                if (this.f13196b) {
                    return false;
                }
                this.f13196b = true;
                this.f13197c = true;
                this.f13195a.notifyAll();
                i();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean k(Object obj) {
        synchronized (this.f13195a) {
            try {
                if (this.f13196b) {
                    return false;
                }
                this.f13196b = true;
                this.f13198d = obj;
                this.f13195a.notifyAll();
                i();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Task(Boolean bool) {
        k(bool);
    }

    public Task(int i2) {
        j();
    }
}
