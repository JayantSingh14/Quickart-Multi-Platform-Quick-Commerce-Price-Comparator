package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzj implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39781a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f39782b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final OnCompleteListener f39783c;

    public zzj(Executor executor, OnCompleteListener onCompleteListener) {
        this.f39781a = executor;
        this.f39783c = onCompleteListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        synchronized (this.f39782b) {
            try {
                if (this.f39783c == null) {
                    return;
                }
                this.f39781a.execute(new zzi(this, task));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
