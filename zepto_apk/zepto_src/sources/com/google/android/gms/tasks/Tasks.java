package com.google.android.gms.tasks;

import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class Tasks {
    public static Object a(Task task) {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.o()) {
            return j(task);
        }
        zzad zzadVar = new zzad();
        Executor executor = TaskExecutors.f39752b;
        task.f(executor, zzadVar);
        task.d(executor, zzadVar);
        task.a(executor, zzadVar);
        zzadVar.f39755a.await();
        return j(task);
    }

    public static Object b(Task task, long j2, TimeUnit timeUnit) throws TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotGoogleApiHandlerThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.o()) {
            return j(task);
        }
        zzad zzadVar = new zzad();
        Executor executor = TaskExecutors.f39752b;
        task.f(executor, zzadVar);
        task.d(executor, zzadVar);
        task.a(executor, zzadVar);
        if (zzadVar.f39755a.await(j2, timeUnit)) {
            return j(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static Task c(Callable callable, Executor executor) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzw zzwVar = new zzw();
        executor.execute(new zzz(zzwVar, callable));
        return zzwVar;
    }

    public static Task d(Exception exc) {
        zzw zzwVar = new zzw();
        zzwVar.s(exc);
        return zzwVar;
    }

    public static Task e(Object obj) {
        zzw zzwVar = new zzw();
        zzwVar.t(obj);
        return zzwVar;
    }

    public static Task f(List list) {
        if (list == null || list.isEmpty()) {
            return e(null);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((Task) it.next()) == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzw zzwVar = new zzw();
        zzaf zzafVar = new zzaf(list.size(), zzwVar);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            Task task = (Task) it2.next();
            Executor executor = TaskExecutors.f39752b;
            task.f(executor, zzafVar);
            task.d(executor, zzafVar);
            task.a(executor, zzafVar);
        }
        return zzwVar;
    }

    public static Task g(List list) {
        Executor executor = TaskExecutors.f39751a;
        if (list == null || list.isEmpty()) {
            return e(Collections.EMPTY_LIST);
        }
        List list2 = list;
        return f(list2).j(executor, new zzab(list2));
    }

    public static Task h(Task... taskArr) {
        return taskArr.length == 0 ? e(Collections.EMPTY_LIST) : g(Arrays.asList(taskArr));
    }

    public static Task i(Task task, long j2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkArgument(j2 > 0, "Timeout must be positive");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        final zzb zzbVar = new zzb();
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource(zzbVar);
        final com.google.android.gms.internal.tasks.zza zzaVar = new com.google.android.gms.internal.tasks.zza(Looper.getMainLooper());
        zzaVar.postDelayed(new Runnable() { // from class: com.google.android.gms.tasks.zzx
            @Override // java.lang.Runnable
            public final void run() {
                taskCompletionSource.c(new TimeoutException());
            }
        }, timeUnit.toMillis(j2));
        task.addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.gms.tasks.zzy
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task2) {
                zzaVar.removeCallbacksAndMessages(null);
                boolean zP = task2.p();
                TaskCompletionSource taskCompletionSource2 = taskCompletionSource;
                if (zP) {
                    taskCompletionSource2.d(task2.l());
                } else {
                    if (task2.n()) {
                        zzbVar.f39764a.v(null);
                        return;
                    }
                    Exception excK = task2.k();
                    excK.getClass();
                    taskCompletionSource2.c(excK);
                }
            }
        });
        return taskCompletionSource.f39750a;
    }

    public static Object j(Task task) throws ExecutionException {
        if (task.p()) {
            return task.l();
        }
        if (task.n()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.k());
    }
}
