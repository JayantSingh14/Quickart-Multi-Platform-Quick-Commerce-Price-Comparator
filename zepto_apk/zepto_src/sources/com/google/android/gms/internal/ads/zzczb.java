package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes4.dex */
public final class zzczb implements zzdak, zzdhw, zzdfm, zzdba, zzbck {

    /* renamed from: a, reason: collision with root package name */
    public final zzdbc f27443a;

    /* renamed from: b, reason: collision with root package name */
    public final zzddd f27444b;

    /* renamed from: c, reason: collision with root package name */
    public final zzfhr f27445c;

    /* renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f27446d;

    /* renamed from: e, reason: collision with root package name */
    public final zzgyw f27447e;

    /* renamed from: g, reason: collision with root package name */
    public ScheduledFuture f27449g;

    /* renamed from: i, reason: collision with root package name */
    public final String f27451i;

    /* renamed from: f, reason: collision with root package name */
    public final zzgzf f27448f = new zzgzf();

    /* renamed from: h, reason: collision with root package name */
    public final AtomicBoolean f27450h = new AtomicBoolean();

    public zzczb(zzdbc zzdbcVar, zzfhr zzfhrVar, ScheduledExecutorService scheduledExecutorService, zzgyw zzgywVar, String str, zzddd zzdddVar) {
        this.f27443a = zzdbcVar;
        this.f27445c = zzfhrVar;
        this.f27446d = scheduledExecutorService;
        this.f27447e = zzgywVar;
        this.f27451i = str;
        this.f27444b = zzdddVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void T() {
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final synchronized void a() {
        if (this.f27445c.f31153e == 4) {
            this.f27443a.g();
            return;
        }
        zzgzf zzgzfVar = this.f27448f;
        if (zzgzfVar.isDone()) {
            return;
        }
        ScheduledFuture scheduledFuture = this.f27449g;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
        zzgzfVar.c(Boolean.TRUE);
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void b() {
    }

    @Override // com.google.android.gms.internal.ads.zzdba
    public final synchronized void c(com.google.android.gms.ads.internal.client.zze zzeVar) {
        try {
            zzgzf zzgzfVar = this.f27448f;
            if (zzgzfVar.isDone()) {
                return;
            }
            ScheduledFuture scheduledFuture = this.f27449g;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            zzgzfVar.d(new Exception());
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void g() {
        zzfhr zzfhrVar = this.f27445c;
        if (zzfhrVar.f31153e == 3) {
            return;
        }
        int i2 = zzfhrVar.Y;
        if (i2 == 0 || i2 == 1) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Dc)).booleanValue() && this.f27451i.equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                return;
            }
            this.f27443a.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdfm
    public final void m() {
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void u0(zzbcj zzbcjVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.Dc)).booleanValue() && this.f27451i.equals("com.google.ads.mediation.admob.AdMobAdapter") && zzbcjVar.f24707j && this.f27450h.compareAndSet(false, true) && this.f27445c.f31153e != 3) {
            com.google.android.gms.ads.internal.util.zze.k("Full screen 1px impression occurred");
            this.f27443a.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final void zzg() {
        zzfhr zzfhrVar = this.f27445c;
        int i2 = zzfhrVar.f31153e;
        if (i2 == 3) {
            return;
        }
        if (i2 == 4) {
            this.f27444b.g();
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.f21150e.f21153c.a(zzbgk.R1)).booleanValue() && zzfhrVar.Y == 2) {
            int i3 = zzfhrVar.q;
            if (i3 == 0) {
                this.f27443a.g();
                return;
            }
            zzcyz zzcyzVar = new zzcyz(this);
            zzgzf zzgzfVar = this.f27448f;
            zzgzfVar.q(new zzgyk(zzgzfVar, zzcyzVar), this.f27447e);
            this.f27449g = this.f27446d.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcza
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    zzczb zzczbVar = this.f27442a;
                    synchronized (zzczbVar) {
                        try {
                            zzgzf zzgzfVar2 = zzczbVar.f27448f;
                            if (zzgzfVar2.isDone()) {
                                return;
                            }
                            zzgzfVar2.c(Boolean.TRUE);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            }, i3, TimeUnit.MILLISECONDS);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhw
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdak
    public final void Y(zzbzj zzbzjVar, String str, String str2) {
    }
}
