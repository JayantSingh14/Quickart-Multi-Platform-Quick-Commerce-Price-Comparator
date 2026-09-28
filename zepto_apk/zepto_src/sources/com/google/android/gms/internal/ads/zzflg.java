package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes4.dex */
public final class zzflg implements zzijg {
    @Override // com.google.android.gms.internal.ads.zzijv
    public final Object zzb() {
        zzgyw zzgzcVar;
        ExecutorService executorServiceA = ((zzfxj) zzfxk.f31990b).a(1, Executors.defaultThreadFactory());
        if (executorServiceA instanceof zzgyw) {
            zzgzcVar = (zzgyw) executorServiceA;
        } else {
            zzgzcVar = executorServiceA instanceof ScheduledExecutorService ? new zzgzc((ScheduledExecutorService) executorServiceA) : new zzgyy(executorServiceA);
        }
        zzijo.a(zzgzcVar);
        return zzgzcVar;
    }
}
