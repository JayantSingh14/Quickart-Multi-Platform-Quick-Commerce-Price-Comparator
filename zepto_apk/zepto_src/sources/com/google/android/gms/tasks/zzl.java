package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzl implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39786a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f39787b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final OnFailureListener f39788c;

    public zzl(Executor executor, OnFailureListener onFailureListener) {
        this.f39786a = executor;
        this.f39788c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        if (task.p() || task.n()) {
            return;
        }
        synchronized (this.f39787b) {
            try {
                if (this.f39788c == null) {
                    return;
                }
                this.f39786a.execute(new zzk(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
