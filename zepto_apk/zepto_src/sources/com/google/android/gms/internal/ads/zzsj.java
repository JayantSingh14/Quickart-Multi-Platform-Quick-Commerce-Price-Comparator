package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import java.util.Objects;

/* loaded from: classes4.dex */
final class zzsj implements zzpx {

    /* renamed from: a, reason: collision with root package name */
    public final zzqi f35511a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzss f35512b;

    public /* synthetic */ zzsj(zzss zzssVar, zzqi zzqiVar) {
        Objects.requireNonNull(zzssVar);
        this.f35512b = zzssVar;
        this.f35511a = zzqiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzpx
    public final void a(final long j2) {
        zzrc zzrcVar;
        final zzqx zzqxVar;
        Handler handler;
        zzss zzssVar = this.f35512b;
        if (!equals(zzssVar.f35547i) || (zzrcVar = zzssVar.f35551m) == null || (handler = (zzqxVar = ((zzsv) zzrcVar).f35552a.j1).f35417a) == null) {
            return;
        }
        handler.post(new Runnable(j2) { // from class: com.google.android.gms.internal.ads.zzqo
            @Override // java.lang.Runnable
            public final void run() {
                zzqx zzqxVar2 = this.f35406a;
                zzqxVar2.getClass();
                String str = zzfj.f31254a;
                zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                zzozVar.k(zzozVar.o(), 1010, new zzot());
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzpx
    public final void zzb() {
        zzrc zzrcVar;
        zzmh zzmhVar;
        zzss zzssVar = this.f35512b;
        if (equals(zzssVar.f35547i) && (zzrcVar = zzssVar.f35551m) != null && zzssVar.M && (zzmhVar = ((zzsv) zzrcVar).f35552a.H) != null) {
            zzmhVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpx
    public final void zzc() {
        zzss zzssVar = this.f35512b;
        if (equals(zzssVar.f35547i)) {
            zzssVar.L = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpx
    public final void zzd() {
        long jT;
        zzss zzssVar = this.f35512b;
        if (equals(zzssVar.f35547i) && zzssVar.f35551m != null) {
            zzsm zzsmVar = zzssVar.o;
            int i2 = zzsmVar.f35524d;
            if (i2 != -1) {
                long j2 = zzsmVar.f35525e.f35395d / i2;
                zzpz zzpzVar = zzssVar.r;
                zzpzVar.getClass();
                jT = zzfj.t(zzpzVar.zzi(), j2);
            } else {
                jT = -9223372036854775807L;
            }
            final long jElapsedRealtime = SystemClock.elapsedRealtime() - zzssVar.S;
            zzrc zzrcVar = zzssVar.f35551m;
            final int i3 = zzssVar.o.f35525e.f35395d;
            final zzqx zzqxVar = ((zzsv) zzrcVar).f35552a.j1;
            final long jR = zzfj.r(jT);
            Handler handler = zzqxVar.f35417a;
            if (handler != null) {
                handler.post(new Runnable(i3, jR, jElapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzqp
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqx zzqxVar2 = this.f35407a;
                        zzqxVar2.getClass();
                        String str = zzfj.f31254a;
                        zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                        zzozVar.k(zzozVar.o(), 1011, new zzou());
                    }
                });
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpx
    public final void zze() {
        zzss.X.getAndDecrement();
        zzrc zzrcVar = this.f35512b.f35551m;
        if (zzrcVar != null) {
            int i2 = this.f35511a.f35392a;
            final zzqz zzqzVar = new zzqz();
            final zzqx zzqxVar = ((zzsv) zzrcVar).f35552a.j1;
            Handler handler = zzqxVar.f35417a;
            if (handler != null) {
                handler.post(new Runnable(zzqzVar) { // from class: com.google.android.gms.internal.ads.zzql
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzqx zzqxVar2 = this.f35400a;
                        zzqxVar2.getClass();
                        String str = zzfj.f31254a;
                        zzoz zzozVar = ((zzjl) zzqxVar2.f35418b).f35004a.r;
                        zzozVar.k(zzozVar.o(), 1032, new zznc());
                    }
                });
            }
        }
    }
}
