package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfft implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzere f31026a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfno f31027b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfne f31028c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzdkz f31029d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzffv f31030e;

    public zzfft(zzffv zzffvVar, zzere zzereVar, zzfno zzfnoVar, zzfne zzfneVar, zzdkz zzdkzVar) {
        this.f31026a = zzereVar;
        this.f31027b = zzfnoVar;
        this.f31028c = zzfneVar;
        this.f31029d = zzdkzVar;
        Objects.requireNonNull(zzffvVar);
        this.f31030e = zzffvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfno zzfnoVar;
        zzbgb zzbgbVar = zzbgk.w6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.l("Interstitial ad failed to load", th);
        }
        zzdkz zzdkzVar = this.f31029d;
        final com.google.android.gms.ads.internal.client.zze zzeVarB = zzfjm.b(th, zzdkzVar.b().f27299l);
        zzffv zzffvVar = this.f31030e;
        synchronized (zzffvVar) {
            try {
                zzffvVar.f31040i = null;
                zzdkzVar.a().m0(zzeVarB);
                if (((Boolean) zzbdVar.f21153c.a(zzbgk.i9)).booleanValue()) {
                    zzffvVar.f31033b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffq
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f31021a.f31030e.f31035d.m0(zzeVarB);
                        }
                    });
                    zzffvVar.f31033b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffr
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.f31023a.f31030e.f31036e.m0(zzeVarB);
                        }
                    });
                }
                zzfjh.a(zzeVarB.f21161a, "InterstitialAdLoader.onFailure", th);
                this.f31026a.zza();
                if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f31027b) == null) {
                    zzfnr zzfnrVar = zzffvVar.f31038g;
                    zzfne zzfneVar = this.f31028c;
                    zzfneVar.d(zzeVarB);
                    zzfneVar.c(th);
                    zzfneVar.a(false);
                    zzfnrVar.b(zzfneVar.zzm());
                } else {
                    zzfnoVar.f(zzeVarB);
                    zzfne zzfneVar2 = this.f31028c;
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
        zzffv zzffvVar = this.f31030e;
        zzdjs zzdjsVar = (zzdjs) obj;
        synchronized (zzffvVar) {
            if (zzdjsVar != null) {
                try {
                    zzdjsVar.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzffvVar.f31040i = null;
            zzbgb zzbgbVar = zzbgk.i9;
            com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                zzdea zzdeaVar = zzdjsVar.f27233g.f27693a;
                zzeqp zzeqpVar = zzffvVar.f31035d;
                zzdfb zzdfbVar = zzdeaVar.f27665a;
                zzdfbVar.f27694b = zzeqpVar;
                zzdfbVar.f27697e = zzffvVar.f31036e;
            }
            this.f31026a.a(zzdjsVar);
            if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
                zzffvVar.f31033b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffs
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f31025a.f31030e.f31035d.zzg();
                    }
                });
                zzffvVar.f31033b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffp
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f31020a.f31030e.f31036e.zzg();
                    }
                });
            }
            if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f31027b) == null) {
                zzfnr zzfnrVar = zzffvVar.f31038g;
                zzfne zzfneVar = this.f31028c;
                zzfneVar.i(zzdjsVar.f27227a.f31194b);
                zzfneVar.zzi(zzdjsVar.f27232f.f27543a);
                zzfneVar.a(true);
                zzfnrVar.b(zzfneVar.zzm());
            } else {
                zzfnoVar.e(zzdjsVar.f27227a.f31194b);
                zzfnoVar.g(zzdjsVar.f27232f.f27543a);
                zzfne zzfneVar2 = this.f31028c;
                zzfneVar2.a(true);
                zzfnoVar.a(zzfneVar2);
                zzfnoVar.h();
            }
        }
    }
}
