package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public final class zzecy implements zzeee {

    /* renamed from: h, reason: collision with root package name */
    public static final Pattern f29083h = Pattern.compile("Received error HTTP response code: (.*)");

    /* renamed from: a, reason: collision with root package name */
    public final zzebz f29084a;

    /* renamed from: b, reason: collision with root package name */
    public final zzgyw f29085b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfik f29086c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f29087d;

    /* renamed from: e, reason: collision with root package name */
    public final zzegr f29088e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfno f29089f;

    /* renamed from: g, reason: collision with root package name */
    public final Context f29090g;

    public zzecy(Context context, zzfik zzfikVar, zzebz zzebzVar, zzgyw zzgywVar, ScheduledExecutorService scheduledExecutorService, zzegr zzegrVar, zzfno zzfnoVar) {
        this.f29090g = context;
        this.f29086c = zzfikVar;
        this.f29084a = zzebzVar;
        this.f29085b = zzgywVar;
        this.f29087d = scheduledExecutorService;
        this.f29088e = zzegrVar;
        this.f29089f = zzfnoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzeee
    public final ListenableFuture a(final zzbza zzbzaVar) {
        ListenableFuture listenableFutureF;
        final zzebz zzebzVar = this.f29084a;
        String str = zzbzaVar.f25723d;
        com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
        boolean zE = com.google.android.gms.ads.internal.util.zzs.e(str);
        zzgyw zzgywVar = zzebzVar.f29041b;
        if (zE) {
            listenableFutureF = zzgym.b(new zzeef(1));
        } else {
            listenableFutureF = zzgym.f(((zzgxi) zzebzVar.f29040a).submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzeby
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzcdt zzcdtVar;
                    zzebz zzebzVar2 = zzebzVar;
                    zzbza zzbzaVar2 = zzbzaVar;
                    final zzedj zzedjVar = zzebzVar2.f29042c;
                    synchronized (zzedjVar.f29149b) {
                        try {
                            if (zzedjVar.f29150c) {
                                zzcdtVar = zzedjVar.f29148a;
                            } else {
                                zzedjVar.f29150c = true;
                                zzedjVar.f29152e = zzbzaVar2;
                                zzedjVar.f29153f.checkAvailabilityAndConnect();
                                zzcdt zzcdtVar2 = zzedjVar.f29148a;
                                zzcdtVar2.f25992a.q(new Runnable() { // from class: com.google.android.gms.internal.ads.zzedi
                                    @Override // java.lang.Runnable
                                    public final /* synthetic */ void run() {
                                        zzedjVar.a();
                                    }
                                }, zzcdo.f25988g);
                                zzedq.b(zzedjVar.f29139g, zzcdtVar2, zzedjVar.f29140h);
                                zzcdtVar = zzcdtVar2;
                            }
                        } finally {
                        }
                    }
                    return (zzeeg) zzcdtVar.get(((Integer) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.o6)).intValue(), TimeUnit.SECONDS);
                }
            }), ExecutionException.class, zzebv.f29033a, zzgywVar);
        }
        final int callingUid = Binder.getCallingUid();
        ListenableFuture listenableFutureF2 = zzgym.f(listenableFutureF, zzeef.class, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzebw
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                Bundle bundle;
                zzebz zzebzVar2 = zzebzVar;
                final zzbza zzbzaVar2 = zzbzaVar;
                if (zzbzaVar2 != null && (bundle = zzbzaVar2.f25732m) != null) {
                    bundle.putBoolean("ls", true);
                }
                return zzgym.h(((zzefw) zzebzVar2.f29043d.zzb()).Xb(zzbzaVar2, callingUid), new zzgxu() { // from class: com.google.android.gms.internal.ads.zzebx
                    @Override // com.google.android.gms.internal.ads.zzgxu
                    public final /* synthetic */ ListenableFuture zza(Object obj2) {
                        return zzgym.a(new zzeeg((InputStream) obj2, zzbzaVar2));
                    }
                }, zzebzVar2.f29041b);
            }
        }, zzgywVar);
        zzfne zzfneVarF = zzfne.f(11, this.f29090g);
        zzfnn.a(listenableFutureF2, zzfneVarF);
        ListenableFuture listenableFutureH = zzgym.h(listenableFutureF2, new zzgxu() { // from class: com.google.android.gms.internal.ads.zzecx
            @Override // com.google.android.gms.internal.ads.zzgxu
            public final ListenableFuture zza(Object obj) {
                zzeeg zzeegVar = (zzeeg) obj;
                return zzgym.a(new zzfic(new zzfhz(this.f29082a.f29086c), zzfib.a(new InputStreamReader(zzeegVar.f29176a), zzeegVar.f29177b.f25732m)));
            }
        }, this.f29085b);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.n6)).booleanValue()) {
            listenableFutureH = zzgym.f(zzgym.g(listenableFutureH, ((Integer) r2.f21153c.a(zzbgk.o6)).intValue(), TimeUnit.SECONDS, this.f29087d), TimeoutException.class, zzecw.f29081a, zzcdo.f25988g);
        }
        zzfnn.c(listenableFutureH, this.f29089f, zzfneVarF, false);
        zzecv zzecvVar = new zzecv(this);
        ((zzgxf) listenableFutureH).q(new zzgyk(listenableFutureH, zzecvVar), zzcdo.f25988g);
        return listenableFutureH;
    }
}
