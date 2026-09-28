package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzfdz extends com.google.android.gms.ads.internal.client.zzbw implements com.google.android.gms.ads.internal.overlay.zzr, zzbdx {

    /* renamed from: a, reason: collision with root package name */
    public final zzclg f30913a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f30914b;

    /* renamed from: d, reason: collision with root package name */
    public final String f30916d;

    /* renamed from: e, reason: collision with root package name */
    public final zzfdt f30917e;

    /* renamed from: f, reason: collision with root package name */
    public final zzfdr f30918f;

    /* renamed from: g, reason: collision with root package name */
    public final VersionInfoParcel f30919g;

    /* renamed from: h, reason: collision with root package name */
    public final zzdxe f30920h;

    /* renamed from: j, reason: collision with root package name */
    public zzcsj f30922j;

    /* renamed from: k, reason: collision with root package name */
    public zzcsw f30923k;

    /* renamed from: c, reason: collision with root package name */
    public AtomicBoolean f30915c = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    public long f30921i = -1;

    public zzfdz(zzclg zzclgVar, Context context, String str, zzfdt zzfdtVar, zzfdr zzfdrVar, VersionInfoParcel versionInfoParcel, zzdxe zzdxeVar) {
        this.f30913a = zzclgVar;
        this.f30914b = context;
        this.f30916d = str;
        this.f30917e = zzfdtVar;
        this.f30918f = zzfdrVar;
        this.f30919g = versionInfoParcel;
        this.f30920h = zzdxeVar;
        zzfdrVar.f30900f.set(this);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void A4() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void B7(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void C0(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Ga(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean H() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void J6(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long L() {
        return 0L;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void Q4(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void R6(int i2) {
        if (i2 == 0) {
            throw null;
        }
        int i3 = i2 - 1;
        if (i3 == 0) {
            Xb(2);
            return;
        }
        if (i3 == 1) {
            Xb(4);
        } else if (i3 != 2) {
            Xb(6);
        } else {
            Xb(3);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void T7() {
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
            com.google.android.gms.internal.ads.zzbhu r0 = com.google.android.gms.internal.ads.zzbii.f25158d     // Catch: java.lang.Throwable -> L2d
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
            goto L94
        L2f:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r5.f30919g     // Catch: java.lang.Throwable -> L2d
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
            android.content.Context r0 = r5.f30914b     // Catch: java.lang.Throwable -> L2d
            boolean r0 = com.google.android.gms.ads.internal.util.zzs.h(r0)     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L71
            com.google.android.gms.ads.internal.client.zzc r0 = r6.s     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L5d
            goto L71
        L5d:
            int r6 = com.google.android.gms.ads.internal.util.zze.f21576b     // Catch: java.lang.Throwable -> L2d
            java.lang.String r6 = "Failed to load the ad because app ID is missing."
            com.google.android.gms.ads.internal.util.client.zzo.c(r6)     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfdr r6 = r5.f30918f     // Catch: java.lang.Throwable -> L2d
            r0 = 4
            r2 = 0
            com.google.android.gms.ads.internal.client.zze r0 = com.google.android.gms.internal.ads.zzfjm.d(r0, r2, r2)     // Catch: java.lang.Throwable -> L2d
            r6.m0(r0)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r5)
            return r1
        L71:
            boolean r0 = r5.t()     // Catch: java.lang.Throwable -> L2d
            if (r0 == 0) goto L79
            monitor-exit(r5)
            return r1
        L79:
            java.util.concurrent.atomic.AtomicBoolean r0 = new java.util.concurrent.atomic.AtomicBoolean     // Catch: java.lang.Throwable -> L2d
            r0.<init>()     // Catch: java.lang.Throwable -> L2d
            r5.f30915c = r0     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfdv r0 = new com.google.android.gms.internal.ads.zzfdv     // Catch: java.lang.Throwable -> L2d
            r0.<init>()     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfdt r1 = r5.f30917e     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = r5.f30916d     // Catch: java.lang.Throwable -> L2d
            com.google.android.gms.internal.ads.zzfdw r3 = new com.google.android.gms.internal.ads.zzfdw     // Catch: java.lang.Throwable -> L2d
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L2d
            boolean r6 = r1.a(r6, r2, r0, r3)     // Catch: java.lang.Throwable -> L2d
            monitor-exit(r5)
            return r6
        L94:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L2d
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdz.U0(com.google.android.gms.ads.internal.client.zzm):boolean");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void V2() {
    }

    public final synchronized void Xb(int i2) {
        try {
            if (this.f30915c.compareAndSet(false, true)) {
                this.f30918f.f();
                zzcsj zzcsjVar = this.f30922j;
                if (zzcsjVar != null) {
                    com.google.android.gms.ads.internal.zzt.C.f21683g.c(zzcsjVar);
                }
                if (this.f30923k != null) {
                    long jElapsedRealtime = -1;
                    if (this.f30921i != -1) {
                        jElapsedRealtime = com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - this.f30921i;
                    }
                    this.f30923k.e(i2, jElapsedRealtime);
                }
                zzc();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void b2(zzbhf zzbhfVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String c() {
        return this.f30916d;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void d8(com.google.android.gms.ads.internal.client.zzx zzxVar) {
        this.f30917e.f30878i.f31208i = zzxVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void d9() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void eb(com.google.android.gms.ads.internal.client.zzga zzgaVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea f() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbdx
    public final void g() {
        Xb(3);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco h() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void i5() {
        zzcsw zzcswVar = this.f30923k;
        if (zzcswVar != null) {
            zzcswVar.e(1, com.google.android.gms.ads.internal.zzt.C.f21687k.elapsedRealtime() - this.f30921i);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk j() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void j2(long j2) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void j7() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void k6(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void o8(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void qa(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000f  */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized boolean t() {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzfdt r0 = r1.f30917e     // Catch: java.lang.Throwable -> L12
            com.google.common.util.concurrent.ListenableFuture r0 = r0.f30879j     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto Lf
            boolean r0 = r0.isDone()     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto Lf
            r0 = 1
            goto L10
        Lf:
            r0 = 0
        L10:
            monitor-exit(r1)
            return r0
        L12:
            r0 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L12
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdz.t():boolean");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void t5(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzed w() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w1() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void w4(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void w8() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void xa(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final void y3() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z2(zzbeg zzbegVar) {
        this.f30918f.f30896b.set(zzbegVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void z3(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void z8(zzbzs zzbzsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzb() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzc() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcsw zzcswVar = this.f30923k;
        if (zzcswVar != null) {
            zzcswVar.d();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzd() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzf() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzg() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzr
    public final synchronized void zzh() {
        if (this.f30923k != null) {
            com.google.android.gms.ads.internal.zzt zztVar = com.google.android.gms.ads.internal.zzt.C;
            this.f30921i = zztVar.f21687k.elapsedRealtime();
            int i2 = this.f30923k.f27075m;
            if (i2 > 0) {
                ScheduledExecutorService scheduledExecutorServiceH = this.f30913a.h();
                Clock clock = zztVar.f21687k;
                zzcsj zzcsjVar = new zzcsj(scheduledExecutorServiceH, clock);
                this.f30922j = zzcsjVar;
                Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdx
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        final zzfdz zzfdzVar = this.f30911a;
                        zzfdzVar.f30913a.g().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdy
                            @Override // java.lang.Runnable
                            public final /* synthetic */ void run() {
                                zzfdzVar.Xb(5);
                            }
                        });
                    }
                };
                synchronized (zzcsjVar) {
                    zzcsjVar.f27063f = runnable;
                    long jElapsedRealtime = clock.elapsedRealtime();
                    long j2 = i2;
                    zzcsjVar.f27061d = jElapsedRealtime + j2;
                    zzcsjVar.f27060c = scheduledExecutorServiceH.schedule(runnable, j2, TimeUnit.MILLISECONDS);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zzk() {
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzl() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzm() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzr zzn() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzr() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void c3() {
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
