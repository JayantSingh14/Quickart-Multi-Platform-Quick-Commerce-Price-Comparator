package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzeyj implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzezx f30576a;

    /* renamed from: b, reason: collision with root package name */
    public final long f30577b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f30578c;

    public zzeyj(zzezx zzezxVar, long j2, ScheduledExecutorService scheduledExecutorService) {
        this.f30576a = zzezxVar;
        this.f30577b = j2;
        this.f30578c = scheduledExecutorService;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        ListenableFuture listenableFutureZza = this.f30576a.zza();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.K2)).booleanValue()) {
            timeUnit = TimeUnit.MICROSECONDS;
        }
        long j2 = this.f30577b;
        if (j2 > 0) {
            listenableFutureZza = zzgym.g(listenableFutureZza, j2, timeUnit, this.f30578c);
        }
        return zzgym.f(listenableFutureZza, Throwable.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzeyi
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                Throwable th = (Throwable) obj;
                zzeyj zzeyjVar = this.f30575a;
                zzeyjVar.getClass();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.I2)).booleanValue()) {
                    zzcda zzcdaVar = com.google.android.gms.ads.internal.zzt.C.f21684h;
                    int iZzb = zzeyjVar.f30576a.zzb();
                    StringBuilder sb = new StringBuilder(String.valueOf(iZzb).length() + 22);
                    sb.append("OptionalSignalTimeout:");
                    sb.append(iZzb);
                    zzcdaVar.d(sb.toString(), th);
                }
                return zzgyq.f33377b;
            }
        }, zzcdo.f25988g);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return this.f30576a.zzb();
    }
}
