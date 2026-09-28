package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes4.dex */
final class zzgzj extends zzgyt {

    /* renamed from: c, reason: collision with root package name */
    public final zzgxt f33399c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzgzl f33400d;

    public zzgzj(zzgzl zzgzlVar, zzgxt zzgxtVar) {
        this.f33400d = zzgzlVar;
        this.f33399c = zzgxtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final Object a() {
        zzgxt zzgxtVar = this.f33399c;
        ListenableFuture listenableFutureZza = zzgxtVar.zza();
        if (listenableFutureZza != null) {
            return listenableFutureZza;
        }
        throw new NullPointerException(zzgqr.b("AsyncCallable.call returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", zzgxtVar));
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final String c() {
        return this.f33399c.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final boolean d() {
        return this.f33400d.isDone();
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final /* synthetic */ void e(Object obj) {
        this.f33400d.m((ListenableFuture) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgyt
    public final void f(Throwable th) {
        this.f33400d.d(th);
    }
}
