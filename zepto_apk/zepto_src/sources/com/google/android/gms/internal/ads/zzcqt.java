package com.google.android.gms.internal.ads;

import java.util.Objects;

/* loaded from: classes4.dex */
final class zzcqt implements zzgyj {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zzfpi f26911a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f26912b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.ads.internal.util.client.zzv f26913c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zzcra f26914d;

    public zzcqt(zzcra zzcraVar, zzfpi zzfpiVar, String str, com.google.android.gms.ads.internal.util.client.zzv zzvVar) {
        this.f26911a = zzfpiVar;
        this.f26912b = str;
        this.f26913c = zzvVar;
        Objects.requireNonNull(zzcraVar);
        this.f26914d = zzcraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final void zza(final Throwable th) {
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.f26913c;
        final zzfpi zzfpiVar = this.f26911a;
        final String str = this.f26912b;
        ((zzgxi) this.f26914d.f26932e).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqs
            @Override // java.lang.Runnable
            public final void run() {
                boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.vb)).booleanValue();
                Throwable th2 = th;
                zzcqt zzcqtVar = this.f26906a;
                if (zBooleanValue) {
                    zzcra zzcraVar = zzcqtVar.f26914d;
                    zzbxx zzbxxVarE = zzbxv.e(zzcraVar.f26928a);
                    zzcraVar.f26936i = zzbxxVarE;
                    zzbxxVarE.a("AttributionReporting.registerSourceAndPingClickUrl", th2);
                } else {
                    zzcra zzcraVar2 = zzcqtVar.f26914d;
                    zzbxx zzbxxVarC = zzbxv.c(zzcraVar2.f26928a);
                    zzcraVar2.f26935h = zzbxxVarC;
                    zzbxxVarC.a("AttributionReportingSampled.registerSourceAndPingClickUrl", th2);
                }
                zzfpiVar.b(str, zzvVar, null, null);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzgyj
    public final /* synthetic */ void zzb(Object obj) {
        final String str = (String) obj;
        final com.google.android.gms.ads.internal.util.client.zzv zzvVar = this.f26913c;
        final zzfpi zzfpiVar = this.f26911a;
        ((zzgxi) this.f26914d.f26932e).submit(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcqr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                zzfpiVar.b(str, zzvVar, null, null);
            }
        });
    }
}
