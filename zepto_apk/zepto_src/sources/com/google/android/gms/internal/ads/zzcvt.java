package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
final class zzcvt implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzgyj f27243a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzcvz f27244b;

    public zzcvt(zzcvz zzcvzVar, zzgyj zzgyjVar) {
        this.f27243a = zzgyjVar;
        this.f27244b = zzcvzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        ((zzerj) this.f27243a).zza(th);
        zzcvz zzcvzVar = this.f27244b;
        zzcvzVar.getClass();
        ((zzcdn) zzcdo.f25987f).execute(new zzcvx(zzcvzVar));
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        List<ListenableFuture> list = ((zzcvs) obj).f27242a;
        final zzcvz zzcvzVar = this.f27244b;
        zzgyw zzgywVar = zzcvzVar.f27253a;
        final zzgyj zzgyjVar = this.f27243a;
        if (list == null || list.isEmpty()) {
            zzgywVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcvy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    ((zzerj) zzgyjVar).zza(new zzebr(3));
                }
            });
            return;
        }
        ListenableFuture listenableFutureH = zzgyq.f33377b;
        for (final ListenableFuture listenableFuture : list) {
            listenableFutureH = zzgym.h(zzgym.f(listenableFutureH, Throwable.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcvv
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final ListenableFuture zza(Object obj2) {
                    zzgyjVar.zza((Throwable) obj2);
                    return zzgyq.f33377b;
                }
            }, zzgywVar), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzcvw
                @Override // com.google.android.gms.internal.ads.zzgxu
                public final /* synthetic */ ListenableFuture zza(Object obj2) {
                    zzcvk zzcvkVar = (zzcvk) obj2;
                    zzcvz zzcvzVar2 = zzcvzVar;
                    zzcvzVar2.getClass();
                    if (zzcvkVar != null) {
                        ((zzerj) zzgyjVar).zzb(zzcvkVar);
                    }
                    return zzgym.g(listenableFuture, ((Long) zzbiy.f25223a.c()).longValue(), TimeUnit.MILLISECONDS, zzcvzVar2.f27254b);
                }
            }, zzgywVar);
        }
        listenableFutureH.q(new zzgyk(listenableFutureH, new zzcvu(zzcvzVar, zzgyjVar)), zzgywVar);
    }
}
