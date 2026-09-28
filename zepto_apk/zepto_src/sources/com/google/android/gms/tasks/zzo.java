package com.google.android.gms.tasks;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f39794a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzp f39795b;

    public zzo(zzp zzpVar, Task task) {
        this.f39795b = zzpVar;
        this.f39794a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzp zzpVar = this.f39795b;
        try {
            Task taskThen = zzpVar.f39797b.then(this.f39794a.l());
            if (taskThen == null) {
                zzpVar.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f39752b;
            taskThen.f(executor, zzpVar);
            taskThen.d(executor, zzpVar);
            taskThen.a(executor, zzpVar);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zzpVar.onFailure((Exception) e2.getCause());
            } else {
                zzpVar.onFailure(e2);
            }
        } catch (CancellationException unused) {
            zzpVar.a();
        } catch (Exception e3) {
            zzpVar.onFailure(e3);
        }
    }
}
