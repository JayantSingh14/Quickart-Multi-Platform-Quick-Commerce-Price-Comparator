package com.google.android.gms.tasks;

/* loaded from: classes.dex */
final class zzc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Task f39765a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzd f39766b;

    public zzc(zzd zzdVar, Task task) {
        this.f39766b = zzdVar;
        this.f39765a = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Task task = this.f39765a;
        boolean zN = task.n();
        zzd zzdVar = this.f39766b;
        if (zN) {
            zzdVar.f39769c.u();
            return;
        }
        try {
            zzdVar.f39769c.t(zzdVar.f39768b.then(task));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                zzdVar.f39769c.s((Exception) e2.getCause());
            } else {
                zzdVar.f39769c.s(e2);
            }
        } catch (Exception e3) {
            zzdVar.f39769c.s(e3);
        }
    }
}
