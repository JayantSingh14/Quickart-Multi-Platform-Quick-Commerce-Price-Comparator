package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zze implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f39770a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzf f39771b;

    public zze(zzf zzfVar, Task task) {
        this.f39771b = zzfVar;
        this.f39770a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzf zzfVar = this.f39771b;
        try {
            Task task = (Task) zzfVar.f39773b.then(this.f39770a);
            if (task == null) {
                zzfVar.onFailure(new NullPointerException("Continuation returned null"));
                return;
            }
            Executor executor = TaskExecutors.f39752b;
            task.f(executor, zzfVar);
            task.d(executor, zzfVar);
            task.a(executor, zzfVar);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zzfVar.f39774c.s((Exception) e2.getCause());
            } else {
                zzfVar.f39774c.s(e2);
            }
        } catch (Exception e3) {
            zzfVar.f39774c.s(e3);
        }
    }
}
