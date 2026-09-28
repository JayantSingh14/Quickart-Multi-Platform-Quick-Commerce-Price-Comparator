package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzh implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39776a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f39777b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public final OnCanceledListener f39778c;

    public zzh(Executor executor, OnCanceledListener onCanceledListener) {
        this.f39776a = executor;
        this.f39778c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        if (task.n()) {
            synchronized (this.f39777b) {
                try {
                    if (this.f39778c == null) {
                        return;
                    }
                    Executor executor = this.f39776a;
                    zzg zzgVar = new zzg(this);
                    ((zzt) executor).getClass();
                    zzgVar.run();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
