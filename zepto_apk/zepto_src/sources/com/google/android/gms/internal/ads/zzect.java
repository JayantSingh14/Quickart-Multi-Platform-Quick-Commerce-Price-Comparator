package com.google.android.gms.internal.ads;

import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class zzect {

    /* renamed from: a, reason: collision with root package name */
    public final ScheduledExecutorService f29072a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29073b;

    /* renamed from: c, reason: collision with root package name */
    public final zzgyw f29074c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeds f29075d;

    /* renamed from: e, reason: collision with root package name */
    public final zzija f29076e;

    public zzect(ScheduledExecutorService scheduledExecutorService, zzgyw zzgywVar, zzgyw zzgywVar2, zzeds zzedsVar, zzija zzijaVar) {
        this.f29072a = scheduledExecutorService;
        this.f29073b = zzgywVar;
        this.f29074c = zzgywVar2;
        this.f29075d = zzedsVar;
        this.f29076e = zzijaVar;
    }

    public final zzgye a(final zzbza zzbzaVar) {
        ListenableFuture listenableFutureSubmit;
        String str = zzbzaVar.f25723d;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        if (com.google.android.gms.ads.internal.util.zzs.e(str)) {
            listenableFutureSubmit = zzgym.b(new zzeef(1));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h8)).booleanValue() || ((Boolean) zzbiv.f25220a.c()).booleanValue()) {
                listenableFutureSubmit = ((zzgxi) this.f29074c).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzecq
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return (zzeeg) ((zzcdt) this.f29066a.f29075d.c(zzbzaVar)).f25992a.get(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.o6)).intValue(), TimeUnit.SECONDS);
                    }
                });
            } else {
                listenableFutureSubmit = this.f29075d.c(zzbzaVar);
            }
        }
        final int callingUid = Binder.getCallingUid();
        return (zzgye) zzgym.f((zzgye) zzgym.g(zzgye.s(listenableFutureSubmit), ((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.o6)).intValue(), TimeUnit.SECONDS, this.f29072a), Throwable.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzecs
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                zzect zzectVar = this.f29069a;
                final zzbza zzbzaVar2 = zzbzaVar;
                if (zzbzaVar2 != null) {
                    zzectVar.getClass();
                    Bundle bundle = zzbzaVar2.f25732m;
                    if (bundle != null) {
                        bundle.putBoolean("ls", true);
                    }
                }
                return zzgym.h(((zzefw) zzectVar.f29076e.zzb()).ac(zzbzaVar2, callingUid), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzecr
                    @Override // com.google.android.gms.internal.ads.zzgxu
                    public final /* synthetic */ ListenableFuture zza(Object obj2) {
                        return zzgym.a(new zzeeg((InputStream) obj2, zzbzaVar2));
                    }
                }, zzectVar.f29073b);
            }
        }, this.f29073b);
    }
}
