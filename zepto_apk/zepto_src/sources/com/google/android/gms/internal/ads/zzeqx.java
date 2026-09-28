package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes4.dex */
public final class zzeqx extends com.google.android.gms.ads.internal.client.zzbw {

    /* renamed from: a, reason: collision with root package name */
    public final com.google.android.gms.ads.internal.client.zzr f30119a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30120b;

    /* renamed from: c, reason: collision with root package name */
    public final zzffv f30121c;

    /* renamed from: d, reason: collision with root package name */
    public final String f30122d;

    /* renamed from: e, reason: collision with root package name */
    public final VersionInfoParcel f30123e;

    /* renamed from: f, reason: collision with root package name */
    public final zzeqp f30124f;

    /* renamed from: g, reason: collision with root package name */
    public final zzfgv f30125g;

    /* renamed from: h, reason: collision with root package name */
    public final zzayq f30126h;

    /* renamed from: i, reason: collision with root package name */
    public final zzdxe f30127i;

    /* renamed from: j, reason: collision with root package name */
    public zzdjs f30128j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f30129k = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Z0)).booleanValue();

    public zzeqx(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzffv zzffvVar, zzeqp zzeqpVar, zzfgv zzfgvVar, VersionInfoParcel versionInfoParcel, zzayq zzayqVar, zzdxe zzdxeVar) {
        this.f30119a = zzrVar;
        this.f30122d = str;
        this.f30120b = context;
        this.f30121c = zzffvVar;
        this.f30124f = zzeqpVar;
        this.f30125g = zzfgvVar;
        this.f30123e = versionInfoParcel;
        this.f30126h = zzayqVar;
        this.f30127i = zzdxeVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void B7(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.f30129k = z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void C0(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Ga(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
        this.f30124f.f30106d.set(zzbnVar);
        U0(zzmVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean H() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void J6(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.f30124f.m(zzcoVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized long L() {
        zzcze zzczeVar;
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar == null || (zzczeVar = zzdjsVar.f27236j) == null) {
            return 0L;
        }
        return zzczeVar.f27458a.get();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Q4(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.f30124f.f30103a.set(zzbkVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002b  */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean U0(com.google.android.gms.ads.internal.client.zzm r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            boolean r0 = r6.r()     // Catch: java.lang.Throwable -> L2d
            r1 = 0
            if (r0 == 0) goto L9
            goto L4c
        L9:
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbii.f25163i     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.oc     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.ads.internal.client.zzbd r2 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbgi r2 = r2.f21153c     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L2d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L2d
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L2b
            r0 = 1
            goto L2f
        L2b:
            r0 = r1
            goto L2f
        L2d:
            r6 = move-exception
            goto L96
        L2f:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.f30123e     // Catch: java.lang.Throwable -> L2d
            int r2 = r2.f21402c     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbgb r3 = com.google.android.gms.internal.ads.zzbgk.pc     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.ads.internal.client.zzbd r4 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzbgi r4 = r4.f21153c     // Catch: java.lang.Throwable -> L2d
            java.lang.Object r3 = r4.a(r3)     // Catch: java.lang.Throwable -> L2d
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Throwable -> L2d
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L2d
            if (r2 < r3) goto L47
            if (r0 != 0) goto L4c
        L47:
            java.lang.String r0 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L2d
        L4c:
            com.google.android.gms.ads.internal.zzt r0 = com.google.android.gms.ads.internal.zzt.C     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.ads.internal.util.zzs r0 = r0.f21679c     // Catch: java.lang.Throwable -> L2d
            android.content.Context r0 = r5.f30120b     // Catch: java.lang.Throwable -> L2d
            boolean r2 = com.google.android.gms.ads.internal.util.zzs.h(r0)     // Catch: java.lang.Throwable -> L2d
            r3 = 0
            if (r2 == 0) goto L71
            com.google.android.gms.ads.internal.client.zzc r2 = r6.s     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L71
            int r6 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzo.c(r6)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzeqp r6 = r5.f30124f     // Catch: java.lang.Throwable -> L2d
            if (r6 == 0) goto L94
            r0 = 4
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfjm.d(r0, r3, r3)     // Catch: java.lang.Throwable -> L2d
            r6.m0(r0)     // Catch: java.lang.Throwable -> L2d
            goto L94
        L71:
            boolean r2 = r5.Xb()     // Catch: java.lang.Throwable -> L2d
            if (r2 != 0) goto L94
            boolean r1 = r6.f21259f     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfjh.b(r0, r1)     // Catch: java.lang.Throwable -> L2d
            r5.f30128j = r3     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzffv r0 = r5.f30121c     // Catch: java.lang.Throwable -> L2d
            java.lang.String r1 = r5.f30122d     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.ads.internal.client.zzr r2 = r5.f30119a     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzffo r3 = new com.google.android.gms.internal.ads.zzffo     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzeqw r2 = new com.google.android.gms.internal.ads.zzeqw     // Catch: java.lang.Throwable -> L2d
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2d
            boolean r6 = r0.a(r6, r1, r3, r2)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r5)
            return r6
        L94:
            monitor-exit(r5)
            return r1
        L96:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2d
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqx.U0(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    public final synchronized boolean Xb() {
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar != null) {
            if (!zzdjsVar.p.f27277b.get()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void b2(zzbhf zzbhfVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f30121c.f31037f = zzbhfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String c() {
        return this.f30122d;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void c3() {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void d8(com.google.android.gms.ads.internal.client.zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void eb(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea f() {
        zzdjs zzdjsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s7)).booleanValue() && (zzdjsVar = this.f30128j) != null) {
            return zzdjsVar.f27232f;
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco h() {
        com.google.android.gms.ads.internal.client.zzco zzcoVar;
        zzeqp zzeqpVar = this.f30124f;
        synchronized (zzeqpVar) {
            zzcoVar = (com.google.android.gms.ads.internal.client.zzco) zzeqpVar.f30104b.get();
        }
        return zzcoVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk j() {
        return this.f30124f.j();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void j2(long j2) {
        zzcze zzczeVar;
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar == null || (zzczeVar = zzdjsVar.f27236j) == null) {
            return;
        }
        zzczeVar.a(j2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void k6(IObjectWrapper iObjectWrapper) {
        if (this.f30128j == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Interstitial can not be shown before loaded.");
            this.f30124f.c(zzfjm.d(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue()) {
                this.f30126h.f24512b.h(new Throwable().getStackTrace());
            }
            this.f30128j.c((Activity) ObjectWrapper.z0(iObjectWrapper), this.f30129k);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void o8(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void qa(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean t() {
        return this.f30121c.b();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void t5(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
        this.f30124f.f30107e.set(zzcvVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzed w() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void w4(com.google.android.gms.ads.internal.client.zzr zzrVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void xa(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdtVar.zzf()) {
                this.f30127i.b();
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.f30124f.f30105c.set(zzdtVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z2(zzbeg zzbegVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z3(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z8(zzbzs zzbzsVar) {
        this.f30125g.f31080e.set(zzbzsVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar != null) {
            zzdbj zzdbjVar = zzdjsVar.f27229c;
            zzdbjVar.getClass();
            zzdbjVar.v0(new zzdbh(null));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzd() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return Xb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar != null) {
            zzdbj zzdbjVar = zzdjsVar.f27229c;
            zzdbjVar.getClass();
            zzdbjVar.v0(new zzdbi(null));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar != null) {
            zzdbj zzdbjVar = zzdjsVar.f27229c;
            zzdbjVar.getClass();
            zzdbjVar.v0(new zzdbg(null));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zzk() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzl() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.f30128j == null) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.f("Interstitial can not be shown before loaded.");
            this.f30124f.c(zzfjm.d(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.q3)).booleanValue()) {
                this.f30126h.f24512b.h(new Throwable().getStackTrace());
            }
            this.f30128j.c(null, this.f30129k);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzm() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzn() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzr() {
        zzdad zzdadVar;
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar == null || (zzdadVar = zzdjsVar.f27232f) == null) {
            return null;
        }
        return zzdadVar.f27543a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        zzdad zzdadVar;
        zzdjs zzdjsVar = this.f30128j;
        if (zzdjsVar == null || (zzdadVar = zzdjsVar.f27232f) == null) {
            return null;
        }
        return zzdadVar.f27543a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void m() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void x() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzp() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzq() {
    }
}
