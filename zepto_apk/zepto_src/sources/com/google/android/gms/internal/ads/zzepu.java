package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* loaded from: classes4.dex */
public final class zzepu extends com.google.android.gms.ads.internal.client.zzbw implements zzddg {

    /* renamed from: a, reason: collision with root package name */
    public final Context f30069a;

    /* renamed from: b, reason: collision with root package name */
    public final zzfef f30070b;

    /* renamed from: c, reason: collision with root package name */
    public final String f30071c;

    /* renamed from: d, reason: collision with root package name */
    public final zzeqp f30072d;

    /* renamed from: e, reason: collision with root package name */
    public com.google.android.gms.ads.internal.client.zzr f30073e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfij f30074f;

    /* renamed from: g, reason: collision with root package name */
    public final VersionInfoParcel f30075g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdxe f30076h;

    /* renamed from: i, reason: collision with root package name */
    public zzctc f30077i;

    public zzepu(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzfef zzfefVar, zzeqp zzeqpVar, VersionInfoParcel versionInfoParcel, zzdxe zzdxeVar) {
        this.f30069a = context;
        this.f30070b = zzfefVar;
        this.f30073e = zzrVar;
        this.f30071c = str;
        this.f30072d = zzeqpVar;
        this.f30074f = zzfefVar.f30951k;
        this.f30075g = versionInfoParcel;
        this.f30076h = zzdxeVar;
        zzfefVar.f30948h.t0(this, zzfefVar.f30942b);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void B7(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void C0(boolean z) {
        try {
            if (Yb()) {
                Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
            }
            this.f30074f.f31204e = z;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Ga(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean H() {
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar != null) {
            if (zzctcVar.f27228b.q0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void J6(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        if (Yb()) {
            Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        }
        this.f30072d.m(zzcoVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized long L() {
        zzcze zzczeVar;
        zzctc zzctcVar = this.f30077i;
        return (zzctcVar == null || (zzczeVar = zzctcVar.f27236j) == null) ? this.f30074f.u.get() : zzczeVar.f27458a.get();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Q4(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        if (Yb()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.f30072d.f30103a.set(zzbkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean U0(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        com.google.android.gms.ads.internal.client.zzr zzrVar = this.f30073e;
        synchronized (this) {
            zzfij zzfijVar = this.f30074f;
            zzfijVar.f31201b = zzrVar;
            zzfijVar.q = this.f30073e.n;
        }
        return Xb(zzmVar);
        return Xb(zzmVar);
    }

    public final synchronized boolean Xb(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        try {
            if (Yb()) {
                Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
            }
            com.google.android.gms.ads.internal.util.zzs zzsVar = com.google.android.gms.ads.internal.zzt.C.f21679c;
            Context context = this.f30069a;
            if (!com.google.android.gms.ads.internal.util.zzs.h(context) || zzmVar.s != null) {
                zzfjh.b(context, zzmVar.f21259f);
                return this.f30070b.a(zzmVar, this.f30071c, null, new zzept(this));
            }
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.c("Failed to load the ad because app ID is missing.");
            zzeqp zzeqpVar = this.f30072d;
            if (zzeqpVar != null) {
                zzeqpVar.m0(zzfjm.d(4, null, null));
            }
            return false;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean Yb() {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbii.f25160f
            java.lang.Object r0 = r0.c()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L24
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.oc
            com.google.android.gms.ads.internal.client.zzbd r3 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r3 = r3.f21153c
            java.lang.Object r0 = r3.a(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L24
            r0 = r1
            goto L25
        L24:
            r0 = r2
        L25:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r6.f30075g
            int r3 = r3.f21402c
            com.google.android.gms.internal.ads.zzbgb r4 = com.google.android.gms.internal.ads.zzbgk.pc
            com.google.android.gms.ads.internal.client.zzbd r5 = com.google.android.gms.ads.internal.client.zzbd.f21150e
            com.google.android.gms.internal.ads.zzbgi r5 = r5.f21153c
            java.lang.Object r4 = r5.a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r3 < r4) goto L3f
            if (r0 != 0) goto L3e
            goto L3f
        L3e:
            return r2
        L3f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepu.Yb():boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void b2(zzbhf zzbhfVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.f30070b.f30947g = zzbhfVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String c() {
        return this.f30071c;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void c3() {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzddg
    public final synchronized void d4() {
        int i2;
        zzfef zzfefVar = this.f30070b;
        if (zzfefVar.d()) {
            zzfefVar.c();
            return;
        }
        zzdfq zzdfqVar = zzfefVar.f30950j;
        zzddl zzddlVar = zzfefVar.f30948h;
        synchronized (zzdfqVar) {
            i2 = zzdfqVar.f27708b;
        }
        zzddlVar.x0(i2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void d8(com.google.android.gms.ads.internal.client.zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void eb(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
        try {
            if (Yb()) {
                Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
            }
            this.f30074f.f31203d = zzgaVar;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea f() {
        zzctc zzctcVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.s7)).booleanValue() && (zzctcVar = this.f30077i) != null) {
            return zzctcVar.f27232f;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzddg
    public final synchronized void g() {
        int i2;
        try {
            if (!this.f30070b.d()) {
                zzfef zzfefVar = this.f30070b;
                zzddl zzddlVar = zzfefVar.f30948h;
                zzdfq zzdfqVar = zzfefVar.f30950j;
                synchronized (zzdfqVar) {
                    i2 = zzdfqVar.f27707a;
                }
                zzddlVar.w0(i2);
                return;
            }
            zzfij zzfijVar = this.f30074f;
            com.google.android.gms.ads.internal.client.zzr zzrVarA = zzfijVar.f31201b;
            zzctc zzctcVar = this.f30077i;
            if (zzctcVar != null && zzfijVar.q) {
                zzrVarA = zzfiq.a(this.f30069a, Collections.singletonList(zzctcVar.g()));
            }
            synchronized (this) {
                zzfij zzfijVar2 = this.f30074f;
                zzfijVar2.f31201b = zzrVarA;
                zzfijVar2.q = this.f30073e.n;
                zzfijVar.p = true;
                try {
                    Xb(zzfijVar.f31200a);
                } catch (RemoteException unused) {
                    int i3 = com.google.android.gms.ads.internal.util.zze.f21576b;
                    com.google.android.gms.ads.internal.util.client.zzo.f("Failed to refresh the banner ad.");
                }
                this.f30074f.p = false;
            }
            return;
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco h() {
        com.google.android.gms.ads.internal.client.zzco zzcoVar;
        zzeqp zzeqpVar = this.f30072d;
        synchronized (zzeqpVar) {
            zzcoVar = (com.google.android.gms.ads.internal.client.zzco) zzeqpVar.f30104b.get();
        }
        return zzcoVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk j() {
        return this.f30072d.j();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void j2(long j2) {
        zzcze zzczeVar;
        this.f30074f.u.set(j2);
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar == null || (zzczeVar = zzctcVar.f27236j) == null) {
            return;
        }
        zzczeVar.a(j2);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void k6(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void o8(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        if (Yb()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        zzeqt zzeqtVar = this.f30070b.f30945e;
        synchronized (zzeqtVar) {
            zzeqtVar.f30116a = zzbhVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void qa(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean t() {
        return this.f30070b.b();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void t5(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzed w() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar == null) {
            return null;
        }
        return zzctcVar.e();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void w4(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.f30074f.f31201b = zzrVar;
        this.f30073e = zzrVar;
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar != null) {
            zzctcVar.d(this.f30070b.f30946f, zzrVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void xa(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        if (Yb()) {
            Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        }
        try {
            if (!zzdtVar.zzf()) {
                this.f30076h.b();
            }
        } catch (RemoteException e2) {
            int i2 = com.google.android.gms.ads.internal.util.zze.f21576b;
            com.google.android.gms.ads.internal.util.client.zzo.b("Error in making CSI ping for reporting paid event callback", e2);
        }
        this.f30072d.f30105c.set(zzdtVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z2(zzbeg zzbegVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void z3(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.f30074f.w = zzcsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z8(zzbzs zzbzsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        if (Yb()) {
            Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        }
        return new ObjectWrapper(this.f30070b.f30946f);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0021, B:13:0x003d, B:15:0x0041, B:12:0x0038), top: B:22:0x0001 }] */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzc() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbii.f25159e     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.lc     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgi r2 = r1.f21153c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r3.f30075g     // Catch: java.lang.Throwable -> L36
            int r0 = r0.f21402c     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.qc     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L36
            if (r0 >= r1) goto L3d
            goto L38
        L36:
            r0 = move-exception
            goto L53
        L38:
            java.lang.String r0 = "destroy must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            com.google.android.gms.internal.ads.zzctc r0 = r3.f30077i     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L51
            com.google.android.gms.internal.ads.zzdbj r0 = r0.f27229c     // Catch: java.lang.Throwable -> L36
            r0.getClass()     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzdbh r1 = new com.google.android.gms.internal.ads.zzdbh     // Catch: java.lang.Throwable -> L36
            r2 = 0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L36
            r0.v0(r1)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            return
        L51:
            monitor-exit(r3)
            return
        L53:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepu.zzc():void");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzd() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0021, B:13:0x003d, B:15:0x0041, B:12:0x0038), top: B:22:0x0001 }] */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzf() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbii.f25161g     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.mc     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgi r2 = r1.f21153c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r3.f30075g     // Catch: java.lang.Throwable -> L36
            int r0 = r0.f21402c     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.qc     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L36
            if (r0 >= r1) goto L3d
            goto L38
        L36:
            r0 = move-exception
            goto L53
        L38:
            java.lang.String r0 = "pause must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            com.google.android.gms.internal.ads.zzctc r0 = r3.f30077i     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L51
            com.google.android.gms.internal.ads.zzdbj r0 = r0.f27229c     // Catch: java.lang.Throwable -> L36
            r0.getClass()     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzdbi r1 = new com.google.android.gms.internal.ads.zzdbi     // Catch: java.lang.Throwable -> L36
            r2 = 0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L36
            r0.v0(r1)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            return
        L51:
            monitor-exit(r3)
            return
        L53:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepu.zzf():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:3:0x0001, B:5:0x000f, B:7:0x0021, B:13:0x003d, B:15:0x0041, B:12:0x0038), top: B:22:0x0001 }] */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized void zzg() {
        /*
            r3 = this;
            monitor-enter(r3)
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbii.f25162h     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r0.c()     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.internal.ads.zzbgb r0 = com.google.android.gms.internal.ads.zzbgk.kc     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.ads.internal.client.zzbd r1 = com.google.android.gms.ads.internal.client.zzbd.f21150e     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgi r2 = r1.f21153c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r0 = r2.a(r0)     // Catch: java.lang.Throwable -> L36
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.Throwable -> L36
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L38
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r3.f30075g     // Catch: java.lang.Throwable -> L36
            int r0 = r0.f21402c     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgb r2 = com.google.android.gms.internal.ads.zzbgk.qc     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzbgi r1 = r1.f21153c     // Catch: java.lang.Throwable -> L36
            java.lang.Object r1 = r1.a(r2)     // Catch: java.lang.Throwable -> L36
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch: java.lang.Throwable -> L36
            int r1 = r1.intValue()     // Catch: java.lang.Throwable -> L36
            if (r0 >= r1) goto L3d
            goto L38
        L36:
            r0 = move-exception
            goto L53
        L38:
            java.lang.String r0 = "resume must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r0)     // Catch: java.lang.Throwable -> L36
        L3d:
            com.google.android.gms.internal.ads.zzctc r0 = r3.f30077i     // Catch: java.lang.Throwable -> L36
            if (r0 == 0) goto L51
            com.google.android.gms.internal.ads.zzdbj r0 = r0.f27229c     // Catch: java.lang.Throwable -> L36
            r0.getClass()     // Catch: java.lang.Throwable -> L36
            com.google.android.gms.internal.ads.zzdbg r1 = new com.google.android.gms.internal.ads.zzdbg     // Catch: java.lang.Throwable -> L36
            r2 = 0
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L36
            r0.v0(r1)     // Catch: java.lang.Throwable -> L36
            monitor-exit(r3)
            return
        L51:
            monitor-exit(r3)
            return
        L53:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L36
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepu.zzg():void");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zzk() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzl() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzm() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar != null) {
            zzctcVar.j();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzr zzn() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar != null) {
            return zzfiq.a(this.f30069a, Collections.singletonList(zzctcVar.f()));
        }
        return this.f30074f.f31201b;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzr() {
        zzdad zzdadVar;
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar == null || (zzdadVar = zzctcVar.f27232f) == null) {
            return null;
        }
        return zzdadVar.f27543a;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        zzdad zzdadVar;
        zzctc zzctcVar = this.f30077i;
        if (zzctcVar == null || (zzdadVar = zzctcVar.f27232f) == null) {
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
