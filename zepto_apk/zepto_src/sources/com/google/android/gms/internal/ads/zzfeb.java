package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzfeb implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfno f30933a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfne f30934b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzcuh f30935c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzfef f30936d;

    public zzfeb(zzfef zzfefVar, zzfno zzfnoVar, zzfne zzfneVar, zzcuh zzcuhVar) {
        this.f30933a = zzfnoVar;
        this.f30934b = zzfneVar;
        this.f30935c = zzcuhVar;
        Objects.requireNonNull(zzfefVar);
        this.f30936d = zzfefVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfno zzfnoVar;
        int i2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w6)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.l("Banner ad failed to load", th);
        }
        zzfef zzfefVar = this.f30936d;
        synchronized (zzfefVar) {
            zzcuh zzcuhVar = this.f30935c;
            com.google.android.gms.ads.internal.client.zze zzeVarB = zzfjm.b(th, zzcuhVar.b().f27299l);
            zzfefVar.n = zzeVarB;
            zzcuhVar.a().m0(zzeVarB);
            zzfjh.a(zzeVarB.f21161a, "BannerAdLoader.onFailure", th);
            if (zzfefVar.f30953m) {
                zzfefVar.e();
                zzddl zzddlVar = zzfefVar.f30948h;
                zzdfq zzdfqVar = zzfefVar.f30950j;
                synchronized (zzdfqVar) {
                    i2 = zzdfqVar.f27707a;
                }
                zzddlVar.w0(i2);
            }
            if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f30933a) == null) {
                zzfnr zzfnrVar = zzfefVar.f30949i;
                zzfne zzfneVar = this.f30934b;
                zzfneVar.d(zzeVarB);
                zzfneVar.c(th);
                zzfneVar.a(false);
                zzfnrVar.b(zzfneVar.zzm());
            } else {
                zzfnoVar.f(zzeVarB);
                zzfne zzfneVar2 = this.f30934b;
                zzfneVar2.c(th);
                zzfneVar2.a(false);
                zzfnoVar.a(zzfneVar2);
                zzfnoVar.h();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfno zzfnoVar;
        zzfef zzfefVar = this.f30936d;
        zzctc zzctcVar = (zzctc) obj;
        synchronized (zzfefVar) {
            if (zzctcVar != null) {
                try {
                    zzctcVar.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (zzfefVar.f30953m) {
                zzfefVar.c();
            }
            if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f30933a) == null) {
                zzfnr zzfnrVar = zzfefVar.f30949i;
                zzfne zzfneVar = this.f30934b;
                zzfneVar.i(zzctcVar.f27227a.f31194b);
                zzfneVar.zzi(zzctcVar.f27232f.f27543a);
                zzfneVar.a(true);
                zzfnrVar.b(zzfneVar.zzm());
            } else {
                zzfnoVar.e(zzctcVar.f27227a.f31194b);
                zzfnoVar.g(zzctcVar.f27232f.f27543a);
                zzfne zzfneVar2 = this.f30934b;
                zzfneVar2.a(true);
                zzfnoVar.a(zzfneVar2);
                zzfnoVar.h();
            }
        }
    }
}
