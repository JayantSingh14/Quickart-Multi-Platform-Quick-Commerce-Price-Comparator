package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzesd implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final ListenableFuture f30208a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f30209b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f30210c;

    public zzesd(ListenableFuture listenableFuture, zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService) {
        this.f30208a = listenableFuture;
        this.f30209b = zzgywVar;
        this.f30210c = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzesc zzescVar = zzesc.f30207a;
        ListenableFuture listenableFuture = this.f30208a;
        zzgyw zzgywVar = this.f30209b;
        ListenableFuture listenableFutureH = zzgym.h(listenableFuture, zzescVar, zzgywVar);
        if (((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Ed)).intValue() > 0) {
            listenableFutureH = zzgym.g(listenableFutureH, ((Integer) r3.f21153c.a(r1)).intValue(), TimeUnit.MILLISECONDS, this.f30210c);
        }
        return zzgym.f(listenableFutureH, Throwable.class, zzesb.f30206a, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 6;
    }
}
