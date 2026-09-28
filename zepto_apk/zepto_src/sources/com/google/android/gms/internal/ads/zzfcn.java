package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzfcn implements zzezx {

    /* renamed from: a, reason: collision with root package name */
    public final zzcda f30843a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f30844b;

    /* renamed from: c, reason: collision with root package name */
    public final ScheduledExecutorService f30845c;

    /* renamed from: d, reason: collision with root package name */
    public final zzgyw f30846d;

    /* renamed from: e, reason: collision with root package name */
    public final int f30847e;

    /* renamed from: f, reason: collision with root package name */
    public final int f30848f;

    public zzfcn(zzcda zzcdaVar, boolean z, zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, int i2, int i3) {
        this.f30843a = zzcdaVar;
        this.f30844b = z;
        this.f30846d = zzgywVar;
        this.f30845c = scheduledExecutorService;
        this.f30847e = i2;
        this.f30848f = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final ListenableFuture zza() {
        zzbgb zzbgbVar = zzbgk.H7;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue() && this.f30844b) {
            return zzgym.a(new zzfco(null));
        }
        if (this.f30848f == 2) {
            return zzgym.a(new zzfco(null));
        }
        if (!Arrays.asList(((String) zzbdVar.f21153c.a(zzbgk.J7)).split(",")).contains(String.valueOf(this.f30847e))) {
            return zzgym.a(new zzfco(null));
        }
        ListenableFuture listenableFuture = zzgyq.f33377b;
        zzfcm zzfcmVar = zzfcm.f30842a;
        zzgyw zzgywVar = this.f30846d;
        return zzgym.e(zzgym.g(zzgym.i(listenableFuture, zzfcmVar, zzgywVar), ((Long) zzbiz.f25225b.c()).longValue(), TimeUnit.MILLISECONDS, this.f30845c), Exception.class, new zzgpr() { // from class: com.google.android.gms.internal.ads.zzfcl
            @Override // com.google.android.gms.internal.ads.zzgpr
            public final /* synthetic */ Object apply(Object obj) {
                this.f30841a.f30843a.d("TrustlessTokenSignal", (Exception) obj);
                return new zzfco(null);
            }
        }, zzgywVar);
    }

    @Override // com.google.android.gms.internal.ads.zzezx
    public final int zzb() {
        return 50;
    }
}
