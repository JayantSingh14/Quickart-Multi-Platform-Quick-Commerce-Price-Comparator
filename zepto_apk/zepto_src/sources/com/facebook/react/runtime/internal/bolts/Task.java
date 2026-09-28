package com.facebook.react.runtime.internal.bolts;

import com.facebook.react.interfaces.TaskInterface;
import com.facebook.react.runtime.internal.bolts.Executors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public class Task<TResult> implements TaskInterface<TResult> {

    /* renamed from: g, reason: collision with root package name */
    public static final Executor f19311g = Executors.f19310b;

    /* renamed from: h, reason: collision with root package name */
    public static final Executor f19312h = Executors.f19309a;

    /* renamed from: i, reason: collision with root package name */
    public static final Task f19313i = new Task((Boolean) null);

    /* renamed from: j, reason: collision with root package name */
    public static final Task f19314j = new Task(Boolean.TRUE);

    /* renamed from: k, reason: collision with root package name */
    public static final Task f19315k = new Task(Boolean.FALSE);

    /* renamed from: l, reason: collision with root package name */
    public static final Task f19316l = new Task(0);

    /* renamed from: b, reason: collision with root package name */
    public boolean f19318b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f19319c;

    /* renamed from: d, reason: collision with root package name */
    public Object f19320d;

    /* renamed from: e, reason: collision with root package name */
    public Exception f19321e;

    /* renamed from: a, reason: collision with root package name */
    public final Object f19317a = new Object();

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f19322f = new ArrayList();

    /* renamed from: com.facebook.react.runtime.internal.bolts.Task$1, reason: invalid class name */
    class AnonymousClass1 implements Continuation<Object, Task<Void>> {
        @Override // com.facebook.react.runtime.internal.bolts.Continuation
        public final Object a(Task task) {
            return task.h() ? Task.f19316l : task.j() ? Task.d(task.f()) : Task.f19313i;
        }
    }

    /* renamed from: com.facebook.react.runtime.internal.bolts.Task$7, reason: invalid class name */
    class AnonymousClass7 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f19333a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Task f19334b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f19335c;

        public AnonymousClass7(Continuation continuation, Task task, TaskCompletionSource taskCompletionSource) {
            this.f19333a = continuation;
            this.f19334b = task;
            this.f19335c = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TaskCompletionSource taskCompletionSource = this.f19335c;
            try {
                taskCompletionSource.c(this.f19333a.a(this.f19334b));
            } catch (CancellationException unused) {
                taskCompletionSource.a();
            } catch (Exception e2) {
                taskCompletionSource.b(e2);
            }
        }
    }

    /* renamed from: com.facebook.react.runtime.internal.bolts.Task$8, reason: invalid class name */
    class AnonymousClass8 implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Continuation f19336a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Task f19337b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TaskCompletionSource f19338c;

        public AnonymousClass8(Continuation continuation, Task task, TaskCompletionSource taskCompletionSource) {
            this.f19336a = continuation;
            this.f19337b = task;
            this.f19338c = taskCompletionSource;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TaskCompletionSource taskCompletionSource = this.f19338c;
            try {
                Task task = (Task) this.f19336a.a(this.f19337b);
                if (task == null) {
                    taskCompletionSource.c(null);
                } else {
                    task.b(new Continuation<Object, Void>() { // from class: com.facebook.react.runtime.internal.bolts.Task.8.1
                        @Override // com.facebook.react.runtime.internal.bolts.Continuation
                        public final Object a(Task task2) {
                            boolean zH = task2.h();
                            TaskCompletionSource taskCompletionSource2 = AnonymousClass8.this.f19338c;
                            if (zH) {
                                taskCompletionSource2.a();
                                return null;
                            }
                            if (task2.j()) {
                                taskCompletionSource2.b(task2.f());
                                return null;
                            }
                            taskCompletionSource2.c(task2.g());
                            return null;
                        }
                    });
                }
            } catch (CancellationException unused) {
                taskCompletionSource.a();
            } catch (Exception e2) {
                taskCompletionSource.b(e2);
            }
        }
    }

    public interface UnobservedExceptionHandler {
    }

    public Task() {
    }

    public static Task a(final Callable callable, Executor executor) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        try {
            executor.execute(new Runnable() { // from class: com.facebook.react.runtime.internal.bolts.Task.2
                @Override // java.lang.Runnable
                public final void run() {
                    TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
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
        return taskCompletionSource.f19340a;
    }

    public static Task d(Exception exc) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.b(exc);
        return taskCompletionSource.f19340a;
    }

    public static Task e(Object obj) {
        if (obj == null) {
            return f19313i;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue() ? f19314j : f19315k;
        }
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        taskCompletionSource.c(obj);
        return taskCompletionSource.f19340a;
    }

    public final Task b(final Continuation continuation) {
        boolean zI;
        final Executor executor = f19311g;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f19317a) {
            try {
                zI = i();
                if (!zI) {
                    this.f19322f.add(new Continuation<Object, Void>() { // from class: com.facebook.react.runtime.internal.bolts.Task.3
                        @Override // com.facebook.react.runtime.internal.bolts.Continuation
                        public final Object a(Task task) {
                            Continuation continuation2 = continuation;
                            Executor executor2 = executor;
                            TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                            Executor executor3 = Task.f19311g;
                            try {
                                AnonymousClass7 command = new AnonymousClass7(continuation2, task, taskCompletionSource2);
                                ((Executors.ImmediateExecutor) executor2).getClass();
                                Intrinsics.checkNotNullParameter(command, "command");
                                command.run();
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
        if (zI) {
            try {
                AnonymousClass7 command = new AnonymousClass7(continuation, this, taskCompletionSource);
                ((Executors.ImmediateExecutor) executor).getClass();
                Intrinsics.checkNotNullParameter(command, "command");
                command.run();
            } catch (Exception e2) {
                taskCompletionSource.b(new ExecutorException(e2));
            }
        }
        return taskCompletionSource.f19340a;
    }

    public final Task c(final Continuation continuation, final Executor executor) {
        boolean zI;
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        synchronized (this.f19317a) {
            try {
                zI = i();
                if (!zI) {
                    this.f19322f.add(new Continuation<Object, Void>() { // from class: com.facebook.react.runtime.internal.bolts.Task.4
                        @Override // com.facebook.react.runtime.internal.bolts.Continuation
                        public final Object a(Task task) {
                            Continuation continuation2 = continuation;
                            Executor executor2 = executor;
                            TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                            Executor executor3 = Task.f19311g;
                            try {
                                executor2.execute(new AnonymousClass8(continuation2, task, taskCompletionSource2));
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
        if (zI) {
            try {
                executor.execute(new AnonymousClass8(continuation, this, taskCompletionSource));
            } catch (Exception e2) {
                taskCompletionSource.b(new ExecutorException(e2));
            }
        }
        return taskCompletionSource.f19340a;
    }

    public final Exception f() {
        Exception exc;
        synchronized (this.f19317a) {
            exc = this.f19321e;
        }
        return exc;
    }

    public final Object g() {
        Object obj;
        synchronized (this.f19317a) {
            obj = this.f19320d;
        }
        return obj;
    }

    public final boolean h() {
        boolean z;
        synchronized (this.f19317a) {
            z = this.f19319c;
        }
        return z;
    }

    public final boolean i() {
        boolean z;
        synchronized (this.f19317a) {
            z = this.f19318b;
        }
        return z;
    }

    public final boolean j() {
        boolean z;
        synchronized (this.f19317a) {
            z = f() != null;
        }
        return z;
    }

    public final Task k() {
        return c(new AnonymousClass1(), f19311g);
    }

    public final Task l(final Continuation continuation, Executor executor) {
        return c(new Continuation<Object, Task<Object>>() { // from class: com.facebook.react.runtime.internal.bolts.Task.5
            @Override // com.facebook.react.runtime.internal.bolts.Continuation
            public final Object a(Task task) {
                return task.j() ? Task.d(task.f()) : task.h() ? Task.f19316l : task.b(continuation);
            }
        }, executor);
    }

    public final Task m(final Continuation continuation, ExecutorService executorService) {
        return c(new Continuation<Object, Task<Object>>() { // from class: com.facebook.react.runtime.internal.bolts.Task.6
            @Override // com.facebook.react.runtime.internal.bolts.Continuation
            public final Object a(Task task) {
                if (task.j()) {
                    return Task.d(task.f());
                }
                if (task.h()) {
                    return Task.f19316l;
                }
                return task.c(continuation, Task.f19311g);
            }
        }, executorService);
    }

    public final void n() {
        synchronized (this.f19317a) {
            Iterator it = this.f19322f.iterator();
            while (it.hasNext()) {
                try {
                    ((Continuation) it.next()).a(this);
                } catch (RuntimeException e2) {
                    throw e2;
                } catch (Exception e3) {
                    throw new RuntimeException(e3);
                }
            }
            this.f19322f = null;
        }
    }

    public final boolean o() {
        synchronized (this.f19317a) {
            try {
                if (this.f19318b) {
                    return false;
                }
                this.f19318b = true;
                this.f19319c = true;
                this.f19317a.notifyAll();
                n();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean p(Object obj) {
        synchronized (this.f19317a) {
            try {
                if (this.f19318b) {
                    return false;
                }
                this.f19318b = true;
                this.f19320d = obj;
                this.f19317a.notifyAll();
                n();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Task(Boolean bool) {
        p(bool);
    }

    public Task(int i2) {
        o();
    }
}
