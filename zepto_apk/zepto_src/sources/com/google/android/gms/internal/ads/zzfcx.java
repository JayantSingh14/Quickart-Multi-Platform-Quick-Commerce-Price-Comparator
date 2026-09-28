package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfcx implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzere f30861a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfno f30862b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfne f30863c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfcy f30864d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzfdb f30865e;

    public zzfcx(zzfdb zzfdbVar, zzere zzereVar, zzfno zzfnoVar, zzfne zzfneVar, zzfcy zzfcyVar) {
        this.f30861a = zzereVar;
        this.f30862b = zzfnoVar;
        this.f30863c = zzfneVar;
        this.f30864d = zzfcyVar;
        Objects.requireNonNull(zzfdbVar);
        this.f30865e = zzfdbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfno zzfnoVar;
        zzbgb zzbgbVar = zzbgk.w6;
        com.google.android.gms.ads.internal.client.zzbd zzbdVar = com.google.android.gms.ads.internal.client.zzbd.f21150e;
        if (((Boolean) zzbdVar.f21153c.a(zzbgbVar)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.l("App open ad failed to load", th);
        }
        zzfdb zzfdbVar = this.f30865e;
        zzcsm zzcsmVar = (zzcsm) zzfdbVar.f30874e.zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarB = zzcsmVar == null ? zzfjm.b(th, null) : zzfjm.b(th, zzcsmVar.zza().f27299l);
        synchronized (zzfdbVar) {
            try {
                zzfdbVar.f30879j = null;
                if (zzcsmVar != null) {
                    zzcsmVar.zze().m0(zzeVarB);
                    if (((Boolean) zzbdVar.f21153c.a(zzbgk.h9)).booleanValue()) {
                        zzfdbVar.f30871b.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfcw
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                this.f30859a.f30865e.f30873d.m0(zzeVarB);
                            }
                        });
                    }
                } else {
                    zzfdbVar.f30873d.m0(zzeVarB);
                    ((zzcsm) zzfdbVar.c(this.f30864d).zzh()).zza().f27293f.zzo();
                }
                zzfjh.a(zzeVarB.f21161a, "AppOpenAdLoader.onFailure", th);
                this.f30861a.zza();
                if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f30862b) == null) {
                    zzfnr zzfnrVar = zzfdbVar.f30877h;
                    zzfne zzfneVar = this.f30863c;
                    zzfneVar.d(zzeVarB);
                    zzfneVar.c(th);
                    zzfneVar.a(false);
                    zzfnrVar.b(zzfneVar.zzm());
                } else {
                    zzfnoVar.f(zzeVarB);
                    zzfne zzfneVar2 = this.f30863c;
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
        zzfdb zzfdbVar = this.f30865e;
        zzcvk zzcvkVar = (zzcvk) obj;
        synchronized (zzfdbVar) {
            if (zzcvkVar != null) {
                try {
                    zzcvkVar.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzfdbVar.f30879j = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.h9)).booleanValue()) {
                zzcvkVar.f27233g.f27693a.f27665a.f27696d = zzfdbVar.f30873d;
            }
            this.f30861a.a(zzcvkVar);
            if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f30862b) == null) {
                zzfnr zzfnrVar = zzfdbVar.f30877h;
                zzfne zzfneVar = this.f30863c;
                zzfneVar.i(zzcvkVar.f27227a.f31194b);
                zzfneVar.zzi(zzcvkVar.f27232f.f27543a);
                zzfneVar.a(true);
                zzfnrVar.b(zzfneVar.zzm());
            } else {
                zzfnoVar.e(zzcvkVar.f27227a.f31194b);
                zzfnoVar.g(zzcvkVar.f27232f.f27543a);
                zzfne zzfneVar2 = this.f30863c;
                zzfneVar2.a(true);
                zzfnoVar.a(zzfneVar2);
                zzfnoVar.h();
            }
        }
    }
}
