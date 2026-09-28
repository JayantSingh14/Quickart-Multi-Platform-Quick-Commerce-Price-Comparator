package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzfzt implements zzijg {

    /* renamed from: a, reason: collision with root package name */
    public final zzijh f32110a;

    public zzfzt(zzijh zzijhVar) {
        this.f32110a = zzijhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgzcVar;
        ExecutorService executorService = (ExecutorService) this.f32110a.f34899a;
        if (executorService instanceof zzgyw) {
            zzgzcVar = (zzgyw) executorService;
        } else {
            zzgzcVar = executorService instanceof ScheduledExecutorService ? new zzgzc((ScheduledExecutorService) executorService) : new zzgyy(executorService);
        }
        zzijo.a(zzgzcVar);
        return zzgzcVar;
    }
}
