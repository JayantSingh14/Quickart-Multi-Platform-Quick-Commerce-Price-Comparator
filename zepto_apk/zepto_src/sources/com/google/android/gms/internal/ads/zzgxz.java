package com.google.android.gms.internal.ads;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
abstract class zzgxz extends zzgyt {

    /* renamed from: c, reason: collision with root package name */
    public final Executor f33361c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgya f33362d;

    public zzgxz(zzgya zzgyaVar, Executor executor) {
        this.f33362d = zzgyaVar;
        executor.getClass();
        this.f33361c = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean d() {
        return this.f33362d.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void e(Object obj) {
        this.f33362d.p = null;
        h(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void f(Throwable th) {
        zzgya zzgyaVar = this.f33362d;
        zzgyaVar.p = null;
        if (th instanceof ExecutionException) {
            zzgyaVar.d(((ExecutionException) th).getCause());
        } else if (th instanceof CancellationException) {
            zzgyaVar.cancel(false);
        } else {
            zzgyaVar.d(th);
        }
    }

    public abstract void h(Object obj);
}
