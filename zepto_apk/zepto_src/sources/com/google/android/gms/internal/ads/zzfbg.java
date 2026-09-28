package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfbg implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzcda f30803a;

    /* renamed from: b, reason: collision with root package name */
    public final ScheduledExecutorService f30804b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f30805c;

    public zzfbg(zzcda zzcdaVar, ScheduledExecutorService scheduledExecutorService, zzgyw zzgywVar) {
        this.f30803a = zzcdaVar;
        this.f30804b = scheduledExecutorService;
        this.f30805c = zzgywVar;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzbgb zzbgbVar = zzbgk.z3;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            if (((Boolean) zzbdVar.f21153c.a(zzbgk.E3)).booleanValue()) {
                ListenableFuture listenableFutureA = zzfzr.a(Tasks.e(null));
                zzfbf zzfbfVar = zzfbf.f30802a;
                zzgyw zzgywVar = this.f30805c;
                ListenableFuture listenableFutureH = zzgym.h(listenableFutureA, zzfbfVar, zzgywVar);
                if (((Boolean) zzbhx.f25104a.c()).booleanValue()) {
                    listenableFutureH = zzgym.g(listenableFutureH, ((Long) zzbhx.f25105b.c()).longValue(), TimeUnit.MILLISECONDS, this.f30804b);
                }
                return zzgym.e(listenableFutureH, Exception.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzfbe
                    @Override // com.google.android.gms.internal.ads.zzgpr
                    public final /* synthetic */ Object apply(Object obj) {
                        this.f30801a.f30803a.d("AppSetIdInfoGmscoreSignal", (Exception) obj);
                        return new zzfbh(null, -1);
                    }
                }, zzgywVar);
            }
        }
        return zzgym.a(new zzfbh(null, -1));
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 43;
    }
}
