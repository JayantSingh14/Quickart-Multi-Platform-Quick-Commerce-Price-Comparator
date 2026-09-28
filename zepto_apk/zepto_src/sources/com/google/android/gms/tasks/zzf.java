package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzf<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39772a;

    /* renamed from: b, reason: collision with root package name */
    public final Continuation f39773b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f39774c;

    public zzf(Executor executor, Continuation continuation, zzw zzwVar) {
        this.f39772a = executor;
        this.f39773b = continuation;
        this.f39774c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void a() {
        this.f39774c.u();
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        this.f39772a.execute(new zze(this, task));
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f39774c.s(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.f39774c.t(obj);
    }
}
