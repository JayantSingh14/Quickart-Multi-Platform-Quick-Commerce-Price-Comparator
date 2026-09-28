package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public class TaskCompletionSource<TResult> {

    /* renamed from: a, reason: collision with root package name */
    public final zzw f39750a = new zzw();

    public TaskCompletionSource() {
    }

    public final void a(Exception exc) {
        this.f39750a.s(exc);
    }

    public final void b(Object obj) {
        this.f39750a.t(obj);
    }

    public final boolean c(Exception exc) {
        zzw zzwVar = this.f39750a;
        zzwVar.getClass();
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (zzwVar.f39804a) {
            try {
                if (zzwVar.f39806c) {
                    return false;
                }
                zzwVar.f39806c = true;
                zzwVar.f39809f = exc;
                zzwVar.f39805b.b(zzwVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d(Object obj) {
        return this.f39750a.v(obj);
    }

    public TaskCompletionSource(CancellationToken cancellationToken) {
        zzs zzsVar = new zzs(this);
        zzb zzbVar = (zzb) cancellationToken;
        zzbVar.getClass();
        zza zzaVar = new zza(zzsVar);
        zzbVar.f39764a.f(TaskExecutors.f39751a, zzaVar);
    }
}
