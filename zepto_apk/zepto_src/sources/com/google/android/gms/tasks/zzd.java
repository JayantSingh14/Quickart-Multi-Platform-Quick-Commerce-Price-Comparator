package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzd implements zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39767a;

    /* renamed from: b, reason: collision with root package name */
    public final Continuation f39768b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f39769c;

    public zzd(Executor executor, Continuation continuation, zzw zzwVar) {
        this.f39767a = executor;
        this.f39768b = continuation;
        this.f39769c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        this.f39767a.execute(new zzc(this, task));
    }
}
