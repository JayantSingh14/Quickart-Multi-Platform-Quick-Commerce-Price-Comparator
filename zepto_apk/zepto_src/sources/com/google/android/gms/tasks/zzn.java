package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzn implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39791a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f39792b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final OnSuccessListener f39793c;

    public zzn(Executor executor, OnSuccessListener onSuccessListener) {
        this.f39791a = executor;
        this.f39793c = onSuccessListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        if (task.p()) {
            synchronized (this.f39792b) {
                try {
                    if (this.f39793c == null) {
                        return;
                    }
                    this.f39791a.execute(new zzm(this, task));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
