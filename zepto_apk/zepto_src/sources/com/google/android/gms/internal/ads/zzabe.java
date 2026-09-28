package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;

/* loaded from: classes4.dex */
final class zzabe implements zzabf {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ExecutorService f22640a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzdr f22641b;

    public zzabe(ExecutorService executorService) {
        zzaas zzaasVar = zzaas.f22610a;
        this.f22640a = executorService;
        this.f22641b = zzaasVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f22640a.execute(runnable);
    }
}
