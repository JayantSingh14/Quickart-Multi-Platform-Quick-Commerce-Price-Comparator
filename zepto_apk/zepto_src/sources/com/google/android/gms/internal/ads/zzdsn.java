package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public final class zzdsn implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.zza f28434a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f28435b;

    /* renamed from: c, reason: collision with root package name */
    public final zzdxe f28436c;

    /* renamed from: d, reason: collision with root package name */
    public final zzehu f28437d;

    /* renamed from: e, reason: collision with root package name */
    public final Executor f28438e;

    /* renamed from: f, reason: collision with root package name */
    public final zzayq f28439f;

    /* renamed from: g, reason: collision with root package name */
    public final VersionInfoParcel f28440g;

    /* renamed from: h, reason: collision with root package name */
    public final zzfpi f28441h;

    /* renamed from: i, reason: collision with root package name */
    public final zzeif f28442i;

    /* renamed from: j, reason: collision with root package name */
    public final zzfio f28443j;

    public zzdsn(Context context, Executor executor, zzayq zzayqVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzehu zzehuVar, zzfpi zzfpiVar, zzdxe zzdxeVar, zzeif zzeifVar, zzfio zzfioVar) {
        this.f28435b = context;
        this.f28438e = executor;
        this.f28439f = zzayqVar;
        this.f28440g = versionInfoParcel;
        this.f28434a = zzaVar;
        this.f28437d = zzehuVar;
        this.f28441h = zzfpiVar;
        this.f28436c = zzdxeVar;
        this.f28442i = zzeifVar;
        this.f28443j = zzfioVar;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        final zzdsp zzdspVar = new zzdsp(this);
        synchronized (zzdspVar) {
            final String str = (String) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.t4);
            final zzayq zzayqVar = zzdspVar.f28453f;
            final com.google.android.gms.ads.internal.zza zzaVar = zzdspVar.f28449b;
            final zzeif zzeifVar = zzdspVar.f28458k;
            final Context context = zzdspVar.f28450c;
            final zzfio zzfioVar = zzdspVar.f28459l;
            final VersionInfoParcel versionInfoParcel = zzdspVar.f28454g;
            final zzdxe zzdxeVar = zzdspVar.f28451d;
            ListenableFuture listenableFutureI = zzgym.i(zzgym.d(new zzgxt() { // from class: com.google.android.gms.internal.ads.zzcjf
                @Override // com.google.android.gms.internal.ads.zzgxt
                public final ListenableFuture zza() throws zzcjg {
                    zzcjh zzcjhVar = com.google.android.gms.ads.internal.zzt.C.f21680d;
                    zzclb zzclbVar = new zzclb(0, 0, 0);
                    zzbfj zzbfjVar = new zzbfj();
                    Context context2 = context;
                    VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
                    com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                    zzfio zzfioVar2 = zzfioVar;
                    zzcir zzcirVarA = zzcjh.a(context2, versionInfoParcel2, zzaVar2, null, zzayqVar, zzbfjVar, null, zzclbVar, zzdxeVar, zzeifVar, null, null, zzfioVar2, "", false, false);
                    final zzcds zzcdsVar = new zzcds(zzcirVarA);
                    zzcirVarA.e0().f26375g = new zzckn() { // from class: com.google.android.gms.internal.ads.zzcje
                        @Override // com.google.android.gms.internal.ads.zzckn
                        public final /* synthetic */ void a(String str2, int i2, String str3, boolean z) {
                            zzcdsVar.d();
                        }
                    };
                    zzcirVarA.loadUrl(str);
                    return zzcdsVar;
                }
            }, zzcdo.f25987f), new zzgpr() { // from class: com.google.android.gms.internal.ads.zzdsm
                @Override // com.google.android.gms.internal.ads.zzgpr
                public final /* synthetic */ Object apply(Object obj) {
                    zzcir zzcirVar = (zzcir) obj;
                    zzdsp zzdspVar2 = zzdspVar;
                    zzcirVar.k0("/result", zzdspVar2.f28455h);
                    zzcjc zzcjcVarE0 = zzcirVar.e0();
                    com.google.android.gms.ads.internal.zzb zzbVar = new com.google.android.gms.ads.internal.zzb(zzdspVar2.f28450c, null);
                    zzdsd zzdsdVar = zzdspVar2.f28448a;
                    zzcjcVarE0.y(null, zzdsdVar, zzdsdVar, zzdsdVar, zzdsdVar, false, null, zzbVar, null, null, zzdspVar2.f28456i, zzdspVar2.f28457j, zzdspVar2.f28451d, null, null, null, null, null, null, null, null, null);
                    return zzcirVar;
                }
            }, zzdspVar.f28452e);
            zzdspVar.f28460m = listenableFutureI;
            zzcdr.a(listenableFutureI, "NativeJavascriptExecutor.initializeEngine");
        }
        return zzdspVar;
    }
}
