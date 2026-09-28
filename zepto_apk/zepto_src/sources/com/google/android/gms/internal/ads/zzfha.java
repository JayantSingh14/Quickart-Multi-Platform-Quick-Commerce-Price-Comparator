package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
final class zzfha implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzere f31089a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfno f31090b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfne f31091c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfhd f31092d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzfhe f31093e;

    public zzfha(zzfhe zzfheVar, zzere zzereVar, zzfno zzfnoVar, zzfne zzfneVar, zzfhd zzfhdVar) {
        this.f31089a = zzereVar;
        this.f31090b = zzfnoVar;
        this.f31091c = zzfneVar;
        this.f31092d = zzfhdVar;
        Objects.requireNonNull(zzfheVar);
        this.f31093e = zzfheVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfno zzfnoVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w6)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.l("Rewarded ad failed to load", th);
        }
        zzfhe zzfheVar = this.f31093e;
        zzdtj zzdtjVar = (zzdtj) zzfheVar.f31101e.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarB = zzdtjVar == null ? zzfjm.b(th, null) : zzfjm.b(th, ((zzcnz) zzdtjVar).zza().f27299l);
        synchronized (zzfheVar) {
            try {
                if (zzdtjVar != null) {
                    zzdtjVar.zze().m0(zzeVarB);
                    zzfheVar.f31098b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f31087a.f31093e.f31100d.m0(zzeVarB);
                        }
                    });
                } else {
                    zzfheVar.f31100d.m0(zzeVarB);
                    ((zzcnz) ((zzcny) zzfheVar.b(this.f31092d)).zzh()).zza().f27293f.zzo();
                }
                zzfjh.a(zzeVarB.f21161a, "RewardedAdLoader.onFailure", th);
                this.f31089a.zza();
                if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f31090b) == null) {
                    zzfnr zzfnrVar = zzfheVar.f31103g;
                    zzfne zzfneVar = this.f31091c;
                    zzfneVar.d(zzeVarB);
                    zzfneVar.c(th);
                    zzfneVar.a(false);
                    zzfnrVar.b(zzfneVar.zzm());
                } else {
                    zzfnoVar.f(zzeVarB);
                    zzfne zzfneVar2 = this.f31091c;
                    zzfneVar2.c(th);
                    zzfneVar2.a(false);
                    zzfnoVar.a(zzfneVar2);
                    zzfnoVar.h();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfno zzfnoVar;
        zzfhe zzfheVar = this.f31093e;
        zzdte zzdteVar = (zzdte) obj;
        synchronized (zzfheVar) {
            if (zzdteVar != null) {
                try {
                    zzdteVar.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzdteVar.f27233g.f27693a.f27665a.f27697e = zzfheVar.f31100d;
            this.f31089a.a(zzdteVar);
            Executor executor = zzfheVar.f31098b;
            final zzfgv zzfgvVar = zzfheVar.f31100d;
            Objects.requireNonNull(zzfgvVar);
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfgy
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzfgvVar.zzg();
                }
            });
            zzfheVar.f31100d.j();
            if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f31090b) == null) {
                zzfnr zzfnrVar = zzfheVar.f31103g;
                zzfne zzfneVar = this.f31091c;
                zzfneVar.i(zzdteVar.f27227a.f31194b);
                zzfneVar.zzi(zzdteVar.f27232f.f27543a);
                zzfneVar.a(true);
                zzfnrVar.b(zzfneVar.zzm());
            } else {
                zzfnoVar.e(zzdteVar.f27227a.f31194b);
                zzfnoVar.g(zzdteVar.f27232f.f27543a);
                zzfne zzfneVar2 = this.f31091c;
                zzfneVar2.a(true);
                zzfnoVar.a(zzfneVar2);
                zzfnoVar.h();
            }
        }
    }
}
