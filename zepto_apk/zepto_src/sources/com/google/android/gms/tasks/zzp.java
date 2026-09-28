package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzp<TResult, TContinuationResult> implements OnSuccessListener<TContinuationResult>, OnFailureListener, OnCanceledListener, zzq {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f39796a;

    /* renamed from: b, reason: collision with root package name */
    public final SuccessContinuation f39797b;

    /* renamed from: c, reason: collision with root package name */
    public final zzw f39798c;

    public zzp(Executor executor, SuccessContinuation successContinuation, zzw zzwVar) {
        this.f39796a = executor;
        this.f39797b = successContinuation;
        this.f39798c = zzwVar;
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void a() {
        this.f39798c.u();
    }

    @Override // com.google.android.gms.tasks.zzq
    public final void b(Task task) {
        this.f39796a.execute(new zzo(this, task));
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void onFailure(Exception exc) {
        this.f39798c.s(exc);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(Object obj) {
        this.f39798c.t(obj);
    }
}
