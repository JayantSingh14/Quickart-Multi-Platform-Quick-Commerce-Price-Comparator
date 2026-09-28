package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzerj implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzere f30159a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ zzfno f30160b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ zzfne f30161c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzdlv f30162d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ zzerm f30163e;

    public zzerj(zzerm zzermVar, zzere zzereVar, zzfno zzfnoVar, zzfne zzfneVar, zzdlv zzdlvVar) {
        this.f30159a = zzereVar;
        this.f30160b = zzfnoVar;
        this.f30161c = zzfneVar;
        this.f30162d = zzdlvVar;
        Objects.requireNonNull(zzermVar);
        this.f30163e = zzermVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(Throwable th) {
        zzfno zzfnoVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.w6)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.l("Native ad failed to load", th);
        }
        zzdlv zzdlvVar = this.f30162d;
        final com.google.android.gms.ads.internal.client.zze zzeVarB = zzfjm.b(th, zzdlvVar.a().f27299l);
        zzdlvVar.b().m0(zzeVarB);
        zzerm zzermVar = this.f30163e;
        zzermVar.f30167b.g().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzerh
            @Override // java.lang.Runnable
            public final void run() {
                ((zzerb) this.f30156a.f30163e.f30169d.f30154c).m0(zzeVarB);
            }
        });
        zzfjh.a(zzeVarB.f21161a, "NativeAdLoader.onFailure", th);
        ((zzeqz) this.f30159a).zza();
        boolean zBooleanValue = ((Boolean) zzbid.f25133c.c()).booleanValue();
        zzfne zzfneVar = this.f30161c;
        if (!zBooleanValue || (zzfnoVar = this.f30160b) == null) {
            zzfneVar.d(zzeVarB);
            zzfneVar.c(th);
            zzfneVar.a(false);
            zzermVar.f30170e.b(zzfneVar.zzm());
            return;
        }
        zzfnoVar.f(zzeVarB);
        zzfneVar.c(th);
        zzfneVar.a(false);
        zzfnoVar.a(zzfneVar);
        zzfnoVar.h();
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zzb(Object obj) {
        zzfno zzfnoVar;
        zzerm zzermVar = this.f30163e;
        zzcvk zzcvkVar = (zzcvk) obj;
        synchronized (zzermVar) {
            if (zzcvkVar != null) {
                try {
                    zzcvkVar.b();
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzcvkVar.f27233g.f27693a.f27665a.f27694b = zzermVar.f30169d.f30153b;
            ((zzeqz) this.f30159a).a(zzcvkVar);
            zzermVar.f30167b.g().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeri
                @Override // java.lang.Runnable
                public final void run() {
                    this.f30158a.f30163e.f30169d.f30153b.zzg();
                }
            });
            if (!((Boolean) zzbid.f25133c.c()).booleanValue() || (zzfnoVar = this.f30160b) == null) {
                zzfnr zzfnrVar = zzermVar.f30170e;
                zzfne zzfneVar = this.f30161c;
                zzfneVar.i(zzcvkVar.f27227a.f31194b);
                zzfneVar.zzi(zzcvkVar.f27232f.f27543a);
                zzfneVar.a(true);
                zzfnrVar.b(zzfneVar.zzm());
            } else {
                zzfnoVar.e(zzcvkVar.f27227a.f31194b);
                zzfnoVar.g(zzcvkVar.f27232f.f27543a);
                zzfne zzfneVar2 = this.f30161c;
                zzfneVar2.a(true);
                zzfnoVar.a(zzfneVar2);
                zzfnoVar.h();
            }
        }
    }
}
